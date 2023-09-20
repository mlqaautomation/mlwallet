package com.business.mlwallet;

import com.driverInstance.CommandBase;
import com.driverInstance.DriverManager;
import com.mlwallet.pages.*;
import com.propertyfilereader.PropertyFileReader;
import com.utility.ExtentReporter;
import com.utility.LoggingUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.utility.Utilities.*;

public abstract class BaseClass {
    static LoggingUtils logger = new LoggingUtils();
    private int timeout;
    private int retryCount;

    public static SoftAssert softAssert = new SoftAssert();
    public static PropertyFileReader prop = new PropertyFileReader(".\\properties\\testdata.properties");
    public static PropertyFileReader tierProp = new PropertyFileReader(".\\properties\\tierUpgrade.properties");

    public BaseClass(String Application, String deviceName, String portno) throws InterruptedException{
        new CommandBase(Application, deviceName, portno);
        init();
    }
    public void init(){
        PropertyFileReader handler = new PropertyFileReader("properties/Execution.properties");
        setTimeout(Integer.parseInt(handler.getproperty("TIMEOUT")));
        setRetryCount(Integer.parseInt(handler.getproperty("RETRY_COUNT")));
        logger.info("Loaded the following properties" + " TimeOut :" + getTimeout() + " RetryCount :" + getRetryCount());
    }
    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public void tearDown() {
        softAssert.assertAll();
        logger.info("Session ID: " + ((RemoteWebDriver) DriverManager.getAppiumDriver()).getSessionId());
        ExtentReporter.extentLogger("", "Session ID: " + ((RemoteWebDriver) DriverManager.getAppiumDriver()).getSessionId());
        logger.info("Session is quit");
        ExtentReporter.extentLogger("", "Session is quit");
        setScreenshotSource();
        DriverManager.getAppiumDriver().quit();
    }
    public void enableNotif() throws Exception{
        waitTime(2000);
        if(verifyElementDisplayed(MLWalletLoginPage.objAllowNotif)){
            click(MLWalletLoginPage.objAllowNotif, getTextVal(MLWalletLoginPage.objAllowNotif, "Button"));
            logger.info("Notification is allowed");
        }else{
            logger.info("Notification pop up is not visible");
        }
    }
    public void enterOTP(String OTP) throws Exception {
//		explicitWaitVisible(MLWalletLoginPage.objOneTimePin, 5);
//		verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
//		verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
//		Thread.sleep(3000);
//		for(int i=1;i<=6;i++) {
//			type(MLWalletLoginPage.objOtpTextField(i), OTP, "OTP Text Field");
//		}

        waitTime(5000);
        if (verifyElementDisplayed(MLWalletLoginPage.objContinueBtn)) {
            click(MLWalletLoginPage.objContinueBtn, "OTP Continue Button");
        } else if (verifyElementDisplayed(MLWalletLoginPage.objOneTimePin)) {
            waitTime(10000);
            verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
            for (int i = 1; i <= 6; i++) {
                type(MLWalletLoginPage.objOtpTextField(i), OTP, "OTP Text Field");
            }
            waitTime(3000);
        } else {
            handleMpin(prop.getproperty("mPin"));
        }
    }
    public static void handleMpin(String mPin) throws Exception {
        for (int i = 0; i < mPin.length(); i++) {
            char ch = mPin.charAt(i);
            String ch1 = String.valueOf(ch);
            click(MLWalletSettingsPage.objEnterMpinVal(ch1),
                    getTextVal(MLWalletSettingsPage.objEnterMpinVal(ch1), "MPIN"));
        }
        logger.info("Entered MLPin " + mPin + " Successfully");
        ExtentReporter.extentLogger("Enter MLPin", "Entered MLPin " + mPin + " Successfully");
    }

    public void enterMLPin() throws Exception {
        click(MLWalletLoginPage.objOneBtn, getTextVal(MLWalletLoginPage.objOneBtn, "Button"));
        click(MLWalletLoginPage.objOneBtn, getTextVal(MLWalletLoginPage.objOneBtn, "Button"));
        click(MLWalletLoginPage.objOneBtn, getTextVal(MLWalletLoginPage.objOneBtn, "Button"));
        click(MLWalletLoginPage.objOneBtn, getTextVal(MLWalletLoginPage.objOneBtn, "Button"));
    }

    public void mlWalletLogin(String sTier) throws Exception {
        enableNotif();
        waitTime(10000);
//		click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, sTier, "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        handleMpin("1111");
        waitTime(10000);
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("Application Logged In Successfully");
        } else {
            logger.info("Application not get Logged In Successfully");
        }
    }

    public void mlWalletLogout() throws Exception {
        if (verifyElementPresent(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu")) {
            click(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu");
            click(MLWalletLogOutPage.objLogoutBtn, getTextVal(MLWalletLogOutPage.objLogoutBtn, "Button"));
            Thread.sleep(2000);
            click(MLWalletLogOutPage.objLogoutBtn, getTextVal(MLWalletLogOutPage.objLogoutBtn, "Button"));
        }
        if (verifyElementPresent(MLWalletLogOutPage.objChangeNumber, getTextVal(MLWalletLogOutPage.objChangeNumber, "Link"))) {
            logger.info("Application Logged Out Successfully");
        } else {
            logger.info("Application not get Logged Out Successfully");
        }
    }
    public void enableLocation_PopUp() throws Exception {
        String loc = getText(MLWalletLoginPage.objLocationPopup);
        if (loc.contains("Allow")) {
            logger.info(loc + " Pop Up is Displayed");
            ExtentReporter.extentLoggerPass("pop up", loc + " Pop Up is Displayed");
            click(MLWalletCashOutPage.objLocationPermission, "Allow Button");
        } else {
            logger.info(" Location Pop Up is not Displayed");
            ExtentReporter.extentLoggerPass("pop up", "Location Pop Up is not Displayed");
        }
    }

    public void enableCameraPopup() throws Exception {
        String loc = getText(MLWalletLoginPage.objCameraPopup);
        if (loc.contains("Allow")) {
            logger.info(loc + " Pop Up is Displayed");
            ExtentReporter.extentLoggerPass("pop up", loc + " Pop Up is Displayed");
            click(MLWalletUseQR.objWhileUsingApp, "Allow Button");
        } else {
            logger.info(" Location Pop Up is not Displayed");
            ExtentReporter.extentLoggerPass("pop up", "Location Pop Up is not Displayed");
        }
    }
    public void internetConnectionError() throws Exception {
        verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"));
        verifyElementPresent(MLWalletHomePage.objInternetConnectionMsg, getTextVal(MLWalletHomePage.objInternetConnectionMsg, "Error message"));
        verifyElementPresent(MLWalletHomePage.objOkBtn, getTextVal(MLWalletHomePage.objOkBtn, "Button"));
        setWifiConnectionToONOFF("ON");
    }

    public void cashInViaBranchNavigation(String sTier) throws Exception {
        mlWalletLogin(sTier);
        click(MLWalletCashInViaBranch.objCashInMenu, "Cash In");
        verifyElementPresent(MLWalletCashInViaBranch.objBranchName, "Cash In Options Page");
        click(MLWalletCashInViaBranch.objBranchName, "ML Branch");
    }

    public void cashInViaBranchEnterAmount(String sAmount) throws Exception {
        type(MLWalletCashInViaBranch.objAmountTextField, sAmount, "Amount Text Field");
        hideKeyboard();
        Swipe("up", 1);
        click(MLWalletCashInViaBranch.objNextButton, "Next Button");
    }

    public void maxTransactionLimitValidation(String sTier) throws Exception {
        cashInViaBranchNavigation(sTier);
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("50001");
        click(MLWalletCashInViaBranch.objContinueButton, getTextVal(MLWalletCashInViaBranch.objContinueButton, "Button"));
    }

    public void cancelPreviousTransactionAndContinue() throws Exception {
        if (verifyElementDisplayed(MLWalletCashInViaBranch.objCancelTransactionBtn)) {
            click(MLWalletCashInViaBranch.objCancelTransactionBtn, getTextVal(MLWalletCashInViaBranch.objCancelTransactionBtn, "button"));
            waitTime(3000);
            click(MLWalletCashInViaBranch.objCancelBtn1, getTextVal(MLWalletCashInViaBranch.objCancelBtn1, "Button"));
            verifyElementPresentAndClick(MLWalletCashInViaBranch.objBackToHomeBtn, getTextVal(MLWalletCashInViaBranch.objBackToHomeBtn, "Button"));
            click(MLWalletCashInViaBranch.objCashInMenu, "Cash In");
            verifyElementPresent(MLWalletCashInViaBranch.objBranchName, "Cash In Options Page");
            click(MLWalletCashInViaBranch.objBranchName, "ML Branch");
        }
    }
    public void locationPopUpValidation() throws Exception {
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "PopUp Msg"))) {
            verifyElementPresent(MLWalletHomePage.obPopupAllowBtn, getTextVal(MLWalletHomePage.obPopupAllowBtn, "Button"));
            verifyElementPresent(MLWalletHomePage.objLocationPopUpAllowOnceBtn, getTextVal(MLWalletHomePage.objLocationPopUpAllowOnceBtn, "Button"));
            verifyElementPresent(MLWalletHomePage.objPopUpDenyBtn, getTextVal(MLWalletHomePage.objPopUpDenyBtn, "Button"));
        }
    }

    public void permissionDenyPopUp() throws Exception {
        locationPopUpValidation();
        click(MLWalletHomePage.objPopUpDenyBtn, getTextVal(MLWalletHomePage.objPopUpDenyBtn, "Button"));
        if (verifyElementPresent(MLWalletHomePage.objPermissionDeniedPopUp, getTextVal(MLWalletHomePage.objPermissionDeniedPopUp, "PopUp"))) {
            verifyElementPresent(MLWalletHomePage.objOpenSettingBtn, getTextVal(MLWalletHomePage.objOpenSettingBtn, "Button"));
            verifyElementPresent(MLWalletHomePage.objCloseBtn, getTextVal(MLWalletHomePage.objCloseBtn, "Button"));
        }
    }

    public void permissionDenyCloseBtnFunctionality() throws Exception {
        permissionDenyPopUp();
        click(MLWalletHomePage.objCloseBtn, getTextVal(MLWalletHomePage.objCloseBtn, "Button"));
    }

    public void permissionDenyOpenSettingsBtnFunctionality() throws Exception {
        permissionDenyPopUp();
        click(MLWalletHomePage.objOpenSettingBtn, getTextVal(MLWalletHomePage.objOpenSettingBtn, "Button"));
    }

    public void locationPopUpAllowFunctionality() throws Exception {
        locationPopUpValidation();
        click(MLWalletHomePage.obPopupAllowBtn, getTextVal(MLWalletHomePage.obPopupAllowBtn, "Button"));
    }

    public void selectBankAndInputAmount(String sAmount) throws Exception {
        if (verifyElementPresent(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"))) {
            click(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"));
            click(MLWalletCashInBank.objMyBankAccount, getTextVal(MLWalletCashInBank.objMyBankAccount, "Button"));
            verifyElementPresent(MLWalletCashInBank.objSelectABank, getTextVal(MLWalletCashInBank.objSelectABank, "Page"));
            click(MLWalletCashInBank.objTestBankOnline, getTextVal(MLWalletCashInBank.objTestBankOnline, "Bank"));
            verifyElementPresent(MLWalletCashInBank.objDragonPay, getTextVal(MLWalletCashInBank.objDragonPay, "Page"));
            verifyElementPresent(MLWalletCashInBank.objBankCashIn, getTextVal(MLWalletCashInBank.objBankCashIn, "Text"));
            type(MLWalletCashInBank.objAmountEditField, sAmount, "Amount Text Field");
            click(MLWalletCashInBank.objNextBtn, getTextVal(MLWalletCashInBank.objNextBtn, "Button"));
            Thread.sleep(3000);
        }
    }

    public void dragonPayChargesMsgValidation() throws Exception {
        if (verifyElementPresent(MLWalletCashInBank.objDragonPayChargesMsg, getTextVal(MLWalletCashInBank.objDragonPayChargesMsg, "Message"))) {
            String sDragonPayChargesMsg = getText(MLWalletCashInBank.objDragonPayChargesMsg);
            String sExpectedDragonPayChargesMsg = "Dragon Pay charges a fee of 30 pesos for this transaction. Do you wish to continue with your transaction?";
            assertionValidation(sDragonPayChargesMsg, sExpectedDragonPayChargesMsg);
            click(MLWalletCashInBank.objContinueBtn, getTextVal(MLWalletCashInBank.objContinueBtn, "Button"));
        }
    }

    public void reviewTransactionValidation() throws Exception {
        verifyElementPresent(MLWalletCashInBank.objReviewTransaction, getTextVal(MLWalletCashInBank.objReviewTransaction, "Page"));
        Swipe("UP", 1);
        if (verifyElementPresent(MLWalletCashInBank.objBankTransferCutOffTime, getTextVal(MLWalletCashInBank.objBankTransferCutOffTime, "Message"))) {
            String sBankTransferTime = getText(MLWalletCashInBank.objBankTransferCutOffTime);
            String sExpectedBankTransferTime = "Bank transfers after 1:00PM are posted on the next banking day.";
            assertionValidation(sBankTransferTime, sExpectedBankTransferTime);
        }
        click(MLWalletCashInBank.objNextBtn, getTextVal(MLWalletCashInBank.objNextBtn, "Button"));
    }


    public void bankUserLogin(String sLoginId, String sPassword) throws Exception {
        waitTime(5000);
        if (verifyElementPresent(MLWalletCashInBank.objReferenceNumberMsg, getTextVal(MLWalletCashInBank.objReferenceNumberMsg, "Reference Information"))) {
            type(MLWalletCashInBank.objLoginIdTxtField, sLoginId, "Login Id Text Field");
            type(MLWalletCashInBank.objPasswordTxtField, sPassword, "Password Text Field");
        }
    }
    public void cashOutSelectBank(String sBank) throws Exception {
        if (verifyElementPresent(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button")) {
            click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
            if (verifyElementPresent(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Button"))) {
                click(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Button"));
                type(MLWalletCashOutPage.objSearchBank, sBank, "Search Bank Text Field");
                click(MLWalletCashOutPage.BogusBank, getTextVal(MLWalletCashOutPage.BogusBank, "Bank"));
            }
        }
    }

    public void enterBankDetails(String sAccountNumber) throws Exception {
        if (verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Page"))) {
            type(MLWalletCashOutPage.objAccountNumberField, sAccountNumber, "Account Number Field");
            type(MLWalletCashOutPage.objFirstname, prop.getproperty("First_Name"), "Account Holder First Name");
            type(MLWalletCashOutPage.objMiddleName, prop.getproperty("Middle_Name"), "Account Holder Middle Name");
            click(MLWalletCashOutPage.objCheckBox, "Check Box");
            type(MLWalletCashOutPage.objLastName, prop.getproperty("Last_Name"), "Account Holder Last Name");
            Swipe("UP", 1);
            type(MLWalletCashOutPage.objEmailAddress, prop.getproperty("Email"), "Account Holder Email Address");
            click(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
        }

    }

    public void enterAmountMLBranch(String nAmount) throws Exception {
        if (verifyElementPresent(MLWalletCashOutPage.objToAnyMLBranch, getTextVal(MLWalletCashOutPage.objToAnyMLBranch, "Button"))) {
            click(MLWalletCashOutPage.objToAnyMLBranch, getTextVal(MLWalletCashOutPage.objToAnyMLBranch, "Button"));
            verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"));
            type(MLWalletCashOutPage.objAmountField, nAmount, "Amount to Send");
            click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
            click(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button"));
            Thread.sleep(3000);
        }
    }

    public void enterAmountBank(String sAmount) throws Exception {
        if (verifyElementPresent(MLWalletCashOutPage.objAmountField, "Bank Cash Out Amount Field")) {
            type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
            click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
            waitTime(10000);
            String sDragonPopUpMsg = getText(MLWalletCashOutPage.objDragonPayPopUpMsg);
            String sExpectedMsg = "Dragon Pay charges a fee of 35.00 pesos for this transaction. Do you wish to continue with your transaction?";
            assertionValidation(sDragonPopUpMsg, sExpectedMsg);
            click(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button"));
            swipeDownUntilElementVisible("Next");
            click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
            Thread.sleep(5000);
        }
    }
    //=================================== Buy e - load ======================================================//
//==================================== Generalized methods ============================================//


    public void eLoad_generic(String sTier, String mobileNo, String status, int telcoOption) throws Exception {
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        waitTime(5000);
        if (status.equals("true")) {
            verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage, "eLoad Transaction Page");
            click(MLWalletEloadPage.telcoOptions(telcoOption), "Telco");
        }
        click(MLWalletEloadPage.objMobileNoField, "Mobile Number Field");
        type(MLWalletEloadPage.objMobileNoField, mobileNo, "Mobile Number Field");
        hideKeyboard();
        waitTime(5000);
        click(MLWalletEloadPage.objNextBtn, "Next Button");
//		click(MLWalletEloadPage.objNextBtn, "Next Button");
//		enableLocation_PopUp();
    }
    //================================ Send/Transfer To any ML Branch ============================================//
//=============================== General methods For send transfer ============================================//

    public void sendMoneyToAnyMLBranch(String sTier) throws Exception {
        mlWalletLogin(sTier);
        click(SendTransferPage.objSendTransferBtn, getTextVal(SendTransferPage.objSendTransferBtn, "Button"));
        verifyElementPresent(SendTransferPage.objSendMoney, getTextVal(SendTransferPage.objSendMoney, "Page"));
        if (verifyElementPresent(SendTransferPage.objToAnyMLBranch, getTextVal(SendTransferPage.objToAnyMLBranch, "Button"))) {
            click(SendTransferPage.objToAnyMLBranch, getTextVal(SendTransferPage.objToAnyMLBranch, "Button"));
        }
    }

    public void enterMLBranchDetails() throws Exception {
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"))) {
            verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"));
            type(SendTransferPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");
            type(SendTransferPage.objMiddleName, prop.getproperty("Middle_Name"), "Middle Name Text Field");
            click(SendTransferPage.objCheckBox, "Check Box");
            waitTime(3000);
            type(SendTransferPage.objLastName, prop.getproperty("Last_Name"), "Last Name Text Field");
            type(SendTransferPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
            click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        }
    }

    public void enterAmountToKwartaPadala(String nAmount) throws Exception {
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"));
        type(SendTransferPage.objAmountTxtField, nAmount, "Amount text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        verifyElementPresent(SendTransferPage.objSelectPaymentMethod, getTextVal(SendTransferPage.objSelectPaymentMethod, "Page"));
        Thread.sleep(3000);
        click(SendTransferPage.objMLWalletBalance, getTextVal(SendTransferPage.objMLWalletBalance, "Button"));
        verifyElementPresent(SendTransferPage.objConfirmDetails, getTextVal(SendTransferPage.objConfirmDetails, "Page"));
        click(SendTransferPage.objConfirmBtn, getTextVal(SendTransferPage.objConfirmBtn, "Button"));
    }

    public void selectSavedRecipient() throws Exception {
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"))) {
            click(SendTransferPage.objSavedRecipients, getTextVal(SendTransferPage.objSavedRecipients, "Button"));
            waitTime(5000);
            click(SendTransferPage.objSavedRecipients, getTextVal(SendTransferPage.objSavedRecipients, "Page"));
            type(SendTransferPage.objSearchRecipient, prop.getproperty("Last_Name"), "Search Recipient Text Field");
            verifyElementPresent(SendTransferPage.objSelectLastName(prop.getproperty("Last_Name"), prop.getproperty("First_Name")), getTextVal(SendTransferPage.objSelectLastName(prop.getproperty("Last_Name"), prop.getproperty("First_Name")), "Recipient"));
            click(SendTransferPage.objSelectLastName(prop.getproperty("Last_Name"), prop.getproperty("First_Name")), getTextVal(SendTransferPage.objSelectLastName(prop.getproperty("Last_Name"), prop.getproperty("First_Name")), "Recipient"));
            Thread.sleep(3000);
        }
    }

    public void addRecipient() throws Exception {
        if (verifyElementPresent(SendTransferPage.objSavedRecipients, getTextVal(SendTransferPage.objSavedRecipients, "Button"))) {
            click(SendTransferPage.objSavedRecipients, getTextVal(SendTransferPage.objSavedRecipients, "Button"));
            click(SendTransferPage.objAddRecipient, getTextVal(SendTransferPage.objAddRecipient, "Button"));
            waitTime(5000);
            type(SendTransferPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");
            type(SendTransferPage.objMiddleName, prop.getproperty("Middle_Name"), "Middle Name Text Field");
            click(SendTransferPage.objCheckBox, "Check Box");
            type(SendTransferPage.objLastName, prop.getproperty("Last_Name"), "Last Name Text Field");
            type(SendTransferPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Last Name Text Field");
            type(SendTransferPage.objNickName, prop.getproperty("Nick_Name"), "Nick Name Text Field");
            click(SendTransferPage.ObjSaveRecipient, getTextVal(SendTransferPage.ObjSaveRecipient, "Button"));
        }
    }

    public void verificationTierPerksPageValidation() throws Exception {
        verifyElementPresent(MLWalletHomePage.objMaxBalanceText, getTextVal(MLWalletHomePage.objMaxBalanceText, "Header"));
        verifyElementPresent(MLWalletHomePage.objMaxBalanceAmount, getTextVal(MLWalletHomePage.objMaxBalanceAmount, "Max Balance"));
        verifyElementPresent(MLWalletHomePage.objSendingLimitsCashOut, getTextVal(MLWalletHomePage.objSendingLimitsCashOut, "Header"));
        List<WebElement> values = findElements(MLWalletHomePage.objSendingLimitTransactionTypeAndAmount);
        for (int i = 0; i < values.size(); i++) {
            if (i % 2 == 0) {
                String sTransactionType = values.get(i).getText();
                logger.info("Transaction Type : " + sTransactionType + " is displayed");
                ExtentReporter.extentLogger(" ", "Transaction Type : " + sTransactionType + " is displayed");
            }
            if (i % 2 != 0) {
                String sAmountRange = values.get(i).getText();
                logger.info("Amount Range : " + sAmountRange + " is displayed");
                ExtentReporter.extentLogger(" ", "Amount Range : " + sAmountRange + " is displayed");
            }
        }
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objReceivingLimitsCashIn, getTextVal(MLWalletHomePage.objReceivingLimitsCashIn, "Header"));
        List<WebElement> values1 = findElements(MLWalletHomePage.objReceivingLimitsTransactionTypeAndAmount);
        for (int i = 0; i < values1.size(); i++) {
            if (i % 2 == 0) {
                String sTransactionType = values1.get(i).getText();
                logger.info("Transaction Type : " + sTransactionType + " is displayed");
                ExtentReporter.extentLogger(" ", "Transaction Type : " + sTransactionType + " is displayed");
            }
            if (i % 2 != 0) {
                String sAmountRange = values1.get(i).getText();
                logger.info("Amount Range : " + sAmountRange + " is displayed");
                ExtentReporter.extentLogger(" ", "Amount Range : " + sAmountRange + " is displayed");
            }
        }
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objPurchaseLimits, getTextVal(MLWalletHomePage.objPurchaseLimits, "Header"));
        List<WebElement> values2 = findElements(MLWalletHomePage.objPurchaseLimitsTransactionTypeAndAmount);
        for (int i = 0; i < values2.size(); i++) {
            if (i % 2 == 0) {
                String sTransactionType = values2.get(i).getText();
                logger.info("Transaction Type : " + sTransactionType + " is displayed");
                ExtentReporter.extentLogger(" ", "Transaction Type : " + sTransactionType + " is displayed");
            }
            if (i % 2 != 0) {
                String sAmountRange = values2.get(i).getText();
                logger.info("Amount Range : " + sAmountRange + " is displayed");
                ExtentReporter.extentLogger(" ", "Amount Range : " + sAmountRange + " is displayed");
            }
        }
    }

    public void sendMoneyMLWallet(String sTier) throws Exception {
        mlWalletLogin(sTier);
        click(SendTransferPage.objSendTransferBtn, getTextVal(SendTransferPage.objSendTransferBtn, "Button"));
        verifyElementPresent(SendTransferPage.objSendMoney, getTextVal(SendTransferPage.objSendMoney, "Page"));
        verifyElementPresentAndClick(SendTransferPage.objToAMLWalletUser, getTextVal(SendTransferPage.objToAMLWalletUser, "Button"));
    }


    public void enterMobileNumberMLWallet(String nMobileNumber) throws Exception {
        waitTime(10000);
        verifyElementPresent(SendTransferPage.objSendMoney, getTextVal(SendTransferPage.objSendMoney, "Page"));
        type(SendTransferPage.objMobileNumberField, nMobileNumber, "Mobile Number Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));

    }

    public void enterAmountAndSendToMLWallet(String nAmount) throws Exception {
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objToMLWalletUser, getTextVal(SendTransferPage.objToMLWalletUser, "Page"))) {
            type(SendTransferPage.objAmountTxtField, nAmount, "Amount Text Field");
            click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
            waitTime(5000);
            click(SendTransferPage.objMLWalletBalance, getTextVal(SendTransferPage.objMLWalletBalance, "Button"));
            verifyElementPresent(SendTransferPage.objConfirmDetails, getTextVal(SendTransferPage.objConfirmDetails, "Page"));
            Swipe("UP", 2);
            click(SendTransferPage.objSendPHPBtn, getTextVal(SendTransferPage.objSendPHPBtn, "Button"));
        }
    }

    public void branchLocatorNavigation() throws Exception {
        if (verifyElementPresentAndClick(MLWalletLoginPage.objBranchLocator, getTextVal(MLWalletLoginPage.objBranchLocator, "Button"))) {
            enableLocation_PopUp();
            verifyElementPresent(MLWalletLoginPage.objBranchLocator, getTextVal(MLWalletLoginPage.objBranchLocator, "Page"));
            logger.info("Navigated to Branch Locator page");
        } else {
            logger.info("Not Navigated to Branch Locator Page");
        }
    }


    public void branchLocatorPageValidation() throws Exception {
        if (verifyElementPresent(MLWalletBranchLocator.objSearchBranch, getTextVal(MLWalletBranchLocator.objSearchBranch, "Header"))) {
            verifyElementPresent(MLWalletBranchLocator.obj24HoursOnly, getTextVal(MLWalletBranchLocator.obj24HoursOnly, "Option"));
            verifyElementPresent(MLWalletBranchLocator.objSearchBranchField, "Search Branch Input Field");
            verifyElementPresent(MLWalletBranchLocator.objLuzon, getTextVal(MLWalletBranchLocator.objLuzon, "Button"));
            click(MLWalletBranchLocator.objLuzon, getTextVal(MLWalletBranchLocator.objLuzon, "Button"));
            verifyElementPresent(MLWalletBranchLocator.objVisayas, getTextVal(MLWalletBranchLocator.objVisayas, "Button"));
            verifyElementPresent(MLWalletBranchLocator.objMindanao, getTextVal(MLWalletBranchLocator.objMindanao, "Button"));
            verifyElementPresent(MLWalletBranchLocator.objMLUS, getTextVal(MLWalletBranchLocator.objMLUS, "Button"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletBranchLocator.objBranchesNearYou, getTextVal(MLWalletBranchLocator.objBranchesNearYou, "Map Header"));
        }
    }

    public void homePageNavigation() throws Exception {
        verifyElementPresentAndClick(MLWalletBranchLocator.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocator.objHome, getTextVal(MLWalletBranchLocator.objHome, "Option"));
        waitTime(8000);
    }














    public void sendMoneyToMLBranchRatesValidation(String sAmount) throws Exception {
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"));
        type(SendTransferPage.objAmountTxtField, sAmount, "Amount text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        verifyElementPresent(SendTransferPage.objSelectPaymentMethod, getTextVal(SendTransferPage.objSelectPaymentMethod, "Page"));
        Thread.sleep(3000);
        click(SendTransferPage.objMLWalletBalance, getTextVal(SendTransferPage.objMLWalletBalance, "Button"));
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objConfirmDetails, getTextVal(SendTransferPage.objConfirmDetails, "Page"));
    }
//===============================================Send/Transfer To a ML Wallet User=============================//
//========================== Generalized methods for Send/Transfer To a ML Wallet User========================//











    public void useQRCodeNavigation(String sTier) throws Exception {
        mlWalletLogin(sTier);
        verifyElementPresentAndClick(MLWalletUseQR.objUseQR, getTextVal(MLWalletUseQR.objUseQR, "Icon"));
        waitTime(3000);
        verifyElementPresent(MLWalletUseQR.objUseQR, getTextVal(MLWalletUseQR.objUseQR, "Page"));
    }

    public void scanQR(String url) {
        switchPlatformToWeb(url);
        waitTime(5000);
        closeWebBrowser();
        switchPlatformToAndroid();
    }

    public void navigateToProfile() throws Exception {
        click(MLWalletSettingsPage.objProfileIcon, "Profile Icon");
        waitTime(5000);
        if (verifyElementPresent(MLWalletSettingsPage.objAccountDetails, "Account Details Page")) {
            logger.info("Navigated to settings");
        }
    }

}
