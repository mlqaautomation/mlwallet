package com.business.mlwallet;

import com.driverInstance.CommandBase;
import com.driverInstance.DriverManager;
import com.mlwallet.pages.*;
import com.propertyfilereader.PropertyFileReader;
import com.utility.ExtentReporter;
import com.utility.LoggingUtils;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.utility.Utilities.*;

public class BaseClass {
    public static LoggingUtils logger = new LoggingUtils();
    public static String osName=System.getProperty("os.name").toLowerCase();
    private int timeout;
    private int retryCount;

    public static SoftAssert softAssert = new SoftAssert();
    public static PropertyFileReader prop;
    public static PropertyFileReader tierProp;
    public static PropertyFileReader shopProp;
    public static PropertyFileReader gcashProp;
    public void propertyFileReader(){
        if(osName.contains("linux")){
             prop = new PropertyFileReader("./properties/testdata.properties");
             tierProp = new PropertyFileReader("./properties/tierUpgrade.properties");
             shopProp = new PropertyFileReader("./properties/mlshop.properties");
             gcashProp = new PropertyFileReader("./properties/gcash.properties");
        }else{
             prop = new PropertyFileReader(".\\properties\\testdata.properties");
             tierProp = new PropertyFileReader(".\\properties\\tierUpgrade.properties");
             shopProp = new PropertyFileReader(".\\properties\\mlshop.properties");
            gcashProp = new PropertyFileReader(".\\properties\\gcash.properties");
        }
    }
    public BaseClass(){

    }
    public BaseClass(String Application, String deviceName, String portno) throws InterruptedException{
        new CommandBase(Application, deviceName, portno);
        init();
        propertyFileReader();
    }
    public void init(){
        PropertyFileReader handler;
        handler = new PropertyFileReader("properties/Execution.properties");
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
        waitTime(5000);
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
        waitTime(5000);
//		click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, sTier, "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        LoginClass.clickAnnouncement_Exit();
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

// <<------------------------------------CASH IN VIA BRANCH GENERAL METHOD------------------------------------>>
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
            click(MLWalletEloadPage.objSelectSmartTelco, "Telco");
        }
        click(MLWalletEloadPage.objMobileNoField, "Mobile Number Field");
        type(MLWalletEloadPage.objMobileNoField, mobileNo, "Mobile Number Field");
        hideKeyboard();
        waitTime(5000);
        click(MLWalletEloadPage.objNextBtn, "Next Button");
//		click(MLWalletEloadPage.objNextBtn, "Next Button");
//		enableLocation_PopUp();
    }

    // <<------------------------------------SEND MONEY GENERAL METHOD------------------------------------>>
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
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletSettingsPage.objProfileIcon, "Profile Icon");
        if (verifyElementPresent(MLWalletSettingsPage.objAccountDetails, "Account Details Page")) {
            logger.info("Navigated to settings");
        }
    }

    public void getBillers(By sWebElement) {
        List<WebElement> list = findElements(sWebElement);

        for (int i = 0; i < list.size(); i++) {
            String billers = list.get(i).getText();
            logger.info(billers + " Biller is displayed");
        }
    }

    public void payBillsNavigation() throws Exception {
        verifyElementPresent(MLWalletPayBillsPage.objPayBills, getTextVal(MLWalletPayBillsPage.objPayBills, "Icon"));
        click(MLWalletPayBillsPage.objPayBills, getTextVal(MLWalletPayBillsPage.objPayBills, "Icon"));
        waitTime(5000);
    }


    public void searchBiller() throws Exception {
        type(MLWalletPayBillsPage.objSearchBiller, prop.getproperty("Biller_Name"), "Search Biller");
        verifyElementPresent(MLWalletPayBillsPage.objMisBillsPayBiller, getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller, "Biller"));
        click(MLWalletPayBillsPage.objMisBillsPayBiller, getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller, "Biller"));
    }

    public void billerDetails(String sFirstName, String sLastName, String sMiddleName, String sAmount) throws Exception {
        if (verifyElementPresent(MLWalletPayBillsPage.objBillsPayInformation, getTextVal(MLWalletPayBillsPage.objBillsPayInformation, "Page"))) {
            type(MLWalletPayBillsPage.objAccountNumberField, prop.getproperty("AccountNumber"), "Account Number Text Field");
            type(MLWalletPayBillsPage.objFirstNameField, sFirstName, "First Name Text Field");
            type(MLWalletPayBillsPage.objMiddleNameField, sMiddleName, "Middle Name Text Field");
            type(MLWalletPayBillsPage.objLastnameField, sLastName, "Last Name Text Field");
            Swipe("UP", 1);
            type(MLWalletPayBillsPage.objAmountField, sAmount, "Amount to Send Text Field");
            click(MLWalletPayBillsPage.objConfirmBtn, getTextVal(MLWalletPayBillsPage.objConfirmBtn, "Button"));
        }
    }

    public void confirmDetailsAndPay() throws Exception {
        if (verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"))) {
            Swipe("UP", 1);
            click(MLWalletPayBillsPage.objPayBtn, getTextVal(MLWalletPayBillsPage.objPayBtn, "Button"));
        }
    }

    public void addBiller() throws Exception {
        if (verifyElementPresent(MLWalletPayBillsPage.objSavedBiller, getTextVal(MLWalletPayBillsPage.objSavedBiller, "Button"))) {
            click(MLWalletPayBillsPage.objSavedBiller, getTextVal(MLWalletPayBillsPage.objSavedBiller, "Button"));
            waitTime(5000);
            click(MLWalletPayBillsPage.objAddBiller, getTextVal(MLWalletPayBillsPage.objAddBiller, "Button"));
            addSelectedBiller();
            if (verifyElementPresent(MLWalletPayBillsPage.objAddBillers, getTextVal(MLWalletPayBillsPage.objAddBillers, "Page"))) {
                type(MLWalletPayBillsPage.objAddAccountNumber, prop.getproperty("AccountNumber"), "Account Number in Add Biller");
                type(MLWalletPayBillsPage.objAddFirstName, prop.getproperty("First_Name"), "First Name in Add Biller");
                type(MLWalletPayBillsPage.objAddMiddleName, prop.getproperty("Middle_Name"), "Middle Name in Add Biller");
                type(MLWalletPayBillsPage.objAddLastName, prop.getproperty("Last_Name"), "Last Name in Add Biller");
                type(MLWalletPayBillsPage.objAddNickName, prop.getproperty("Nick_Name"), "Nick Name in Add Biller");
                click(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "button"));
            }
        }
    }

    public void addSelectedBiller() throws Exception {
        waitTime(3000);
        if (verifyElementPresent(MLWalletPayBillsPage.objAddSeectedBiller, "Edit Biller")) {
            click(MLWalletPayBillsPage.objAddSeectedBiller, "Edit Biller");
            waitTime(5000);
            click(MLWalletPayBillsPage.objBillerListSearchBiller, "Biller List Search Biller");
            type(MLWalletPayBillsPage.objBillerListSearchBiller, prop.getproperty("Biller_Name"), "Biller List Search Biller");
            waitTime(4000);
            click(MLWalletPayBillsPage.objMisBillsPayBiller, getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller, "Biller"));
            click(MLWalletPayBillsPage.objMisBillsPayBiller, getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller, "Biller"));
        }
    }

    public void selectAddedBiler() throws Exception {
        verifyElementPresentAndClick(MLWalletPayBillsPage.objSavedBiller, getTextVal(MLWalletPayBillsPage.objSavedBiller, "Button"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletPayBillsPage.objSavedBillers, getTextVal(MLWalletPayBillsPage.objSavedBillers, "Page"))) {
            type(MLWalletPayBillsPage.objSearchBillerInSavedBillers, prop.getproperty("Last_Name"), "Search Recipient Text Field");
            verifyElementPresent(MLWalletPayBillsPage.objSelectLastName(prop.getproperty("Last_Name"), prop.getproperty("First_Name")), getTextVal(SendTransferPage.objSelectLastName(prop.getproperty("Last_Name"), prop.getproperty("First_Name")), "Recipient"));
            click(MLWalletPayBillsPage.objSelectLastName(prop.getproperty("Last_Name"), prop.getproperty("First_Name")), getTextVal(SendTransferPage.objSelectLastName(prop.getproperty("Last_Name"), prop.getproperty("First_Name")), "Recipient"));
        }
    }

    public void registrationPageNavigation() throws Exception {
        verifyElementPresentAndClick(MLWalletRegistration.objCreateOne, getTextVal(MLWalletRegistration.objCreateOne, "Button"));
        waitTime(6000);
        type(MLWalletRegistration.objMobileNumberField, prop.getproperty("Registration_MobileNumber"), "Mobile Number Text Field");
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        enterOTP(prop.getproperty("Valid_OTP"));
    }

    public void registrationInputName() throws Exception {
        verifyElementPresent(MLWalletRegistration.objRegistrationPersonalInfo, getTextVal(MLWalletRegistration.objRegistrationPersonalInfo, "Page"));
        verifyElementPresent(MLWalletRegistration.objPersonalInfo, getTextVal(MLWalletRegistration.objPersonalInfo, "Header"));
        type(MLWalletRegistration.objFirstName, prop.getproperty("First_Name"), "First Name Input Field");
        type(MLWalletRegistration.objMiddleName, prop.getproperty("Middle_Name"), "Middle Name Input Field");
        type(MLWalletRegistration.objLastName, prop.getproperty("Last_Name"), "Last Name Input Field");
    }

    public void selectDate() throws Exception {
        verifyElementPresentAndClick(MLWalletRegistration.objBirthDate, "Birth Date Input Field");
        verifyElementPresentAndClick(MLWalletRegistration.objDatePickerYear, getTextVal(MLWalletRegistration.objDatePickerYear, "Year Section"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String year = dateFormat.format(date);
        int selectYear = Integer.parseInt(year) - 18;
        verticalSwipeByPercentages(0.4, 0.8, 0.5);
        verticalSwipeByPercentages(0.4, 0.8, 0.5);
        verifyElementPresentAndClick(MLWalletRegistration.objYearSelector(Integer.toString(selectYear)), "Selected Year");
        verifyElementPresentAndClick(MLWalletRegistration.objOkBtn, getTextVal(MLWalletRegistration.objOkBtn, "Button"));
    }

    public void emailAndPlaceOfBirth() throws Exception {
        type(MLWalletRegistration.objEmailAddress, prop.getproperty("Email"), "Email Address Field");
        type(MLWalletRegistration.objReEnterEmailAddress, prop.getproperty("Email"), "Re-Enter Email Address Field");
        type(MLWalletRegistration.objPlaceOfBirth, prop.getproperty("Valid_PlaceOfBirth"), "Place of Birth Field");
    }

    public void swipeAndConfirm() throws Exception {
        swipeDownUntilElementVisible("Confirm");
        verifyElementPresentAndClick(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
    }

    public void selectNationality() throws Exception {
        verifyElementPresentAndClick(MLWalletRegistration.objNationality, "Nationality Field");
        waitTime(5000);
        type(MLWalletRegistration.objNationalitySearchField, "filipino", "Nationality search field");
        verifyElementPresentAndClick(MLWalletRegistration.objFilipino, getTextVal(MLWalletRegistration.objFilipino, "Nationality"));
    }

    public void civilAndGenderSelection() throws Exception {
        verifyElementPresentAndClick(MLWalletRegistration.objCivilStatus, "Civil Status");
        verifyElementPresentAndClick(MLWalletRegistration.objSingleCivilStatus, getTextVal(MLWalletRegistration.objSingleCivilStatus, "Civil Status"));
        verifyElementPresentAndClick(MLWalletRegistration.objGender, "Gender Field");
        verifyElementPresentAndClick(MLWalletRegistration.objMaleGender, getTextVal(MLWalletRegistration.objMaleGender, "Gender"));
    }

    public void registrationAddressPageNavigation() throws Exception {
        registrationPageNavigation();
        waitTime(5000);
        registrationInputName();
        selectDate();
        emailAndPlaceOfBirth();
        selectNationality();
        swipeDownUntilElementVisible("Confirm");
        civilAndGenderSelection();
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
    }

    public void accountDetailsPageNavigation(String sTier) throws Exception {
        mlWalletLogin(sTier);
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        waitTime(5000);
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objFullyVerifiedTab,getTextVal(MLWalletTierUpgrade.objFullyVerifiedTab,"Tab"));
        waitTime(3000);
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objUpgradeTierLevel,getTextVal(MLWalletTierUpgrade.objUpgradeTierLevel, "Button"));
        waitTime(5000);
        verifyElementPresent(MLWalletTierUpgrade.objAccountDetails,getTextVal(MLWalletTierUpgrade.objAccountDetails, "Page"));
    }

    public void openKPXInChrome(String url) {
        switchPlatformToWeb(url);
        waitTime(5000);
    }

    public void selectProductServiceOffered(String service)throws Exception{
        try{
            verifyElementPresentAndClick(MLWalletTierUpgrade.objProductServiceOffered, getTextVal(MLWalletTierUpgrade.objSourceOfIncome , "DropDown"));
            waitTime(3000);
            verifyElementPresent(MLWalletTierUpgrade.objProductServicePage, getTextVal(MLWalletTierUpgrade.objProductServicePage, "Header"));
            type(MLWalletTierUpgrade.objSearchField, service, "Search Field");
            verifyElementPresentAndClick(MLWalletTierUpgrade.getObjProductServiceOffered(service),
                    getTextVal(MLWalletTierUpgrade.getObjProductServiceOffered(service), "Value"));
        }catch (Exception e){
            logger.info("error : " + e);
        }
    }

    public void selectSourceOfIncome(String source)throws Exception{
        try{
            verifyElementPresentAndClick(MLWalletTierUpgrade.objSourceOfIncome, getTextVal(MLWalletTierUpgrade.objSourceOfIncome , "DropDown"));
            waitTime(3000);
            verifyElementPresent(MLWalletTierUpgrade.objSourceOfIncomePage, getTextVal(MLWalletTierUpgrade.objSourceOfIncomePage, "Header"));
            type(MLWalletTierUpgrade.objSearchField, source, "Search Field");
            verifyElementPresentAndClick(MLWalletTierUpgrade.getObjSourceOfIncome(source),
                    getTextVal(MLWalletTierUpgrade.getObjSourceOfIncome(source), "Value"));
        }catch (Exception e){
            logger.info("error : " + e);
        }
    }

    public void selectPositionAtWork(String position)throws Exception{
        try{
            verifyElementPresentAndClick(MLWalletTierUpgrade.objPositionAtWork, getTextVal(MLWalletTierUpgrade.objPositionAtWork , "DropDown"));
            waitTime(3000);
            verifyElementPresent(MLWalletTierUpgrade.objPositionAtWorkPage, getTextVal(MLWalletTierUpgrade.objPositionAtWorkPage, "Header"));
            type(MLWalletTierUpgrade.objSearchField, position, "Search Field");
            verifyElementPresentAndClick(MLWalletTierUpgrade.getObjPositionAtWork(position),
                    getTextVal(MLWalletTierUpgrade.getObjPositionAtWork(position), "Value"));
        }catch (Exception e){
            logger.info("error : " + e);
        }
    }

    public void selectNatureOfWork(String nature)throws Exception{
        try{
            verifyElementPresentAndClick(MLWalletTierUpgrade.ObjNatureOfWork, getTextVal(MLWalletTierUpgrade.ObjNatureOfWork , "DropDown"));
            waitTime(5000);
            verifyElementPresent(MLWalletTierUpgrade.ObjNatureOfWorkPage, getTextVal(MLWalletTierUpgrade.ObjNatureOfWorkPage, "Header"));
            type(MLWalletTierUpgrade.objSearchField, nature, "Search Field");
            verifyElementPresentAndClick(MLWalletTierUpgrade.getObjNatureOfWork(nature),
                    getTextVal(MLWalletTierUpgrade.getObjNatureOfWork(nature), "Value"));
        }catch (Exception e){
            logger.info("error : " + e);
        }
    }

    public void topUpGamesHomePageNavigation(String sTier) throws Exception {
        mlWalletLogin(sTier);
        verifyElementPresentAndClick(MLWalletTopUpGames.objTopUpGames, getTextVal(MLWalletTopUpGames.objTopUpGames, "Icon"));
        verifyElementPresent(MLWalletTopUpGames.objTopGamesPage, "TopUp Games Page");
    }

    public void selectGameAndLoadType() throws Exception {
        verifyElementPresentAndClick(MLWalletTopUpGames.objValorant, getTextVal(MLWalletTopUpGames.objValorant, "Game"));
        waitTime(4000);
        verifyElementPresentAndClick(MLWalletTopUpGames.objBuyPHP149, getTextVal(MLWalletTopUpGames.objBuyPHP149, "Load Type"));
    }

    public void inputRequiredDataAndContinue() throws Exception {
        type(MLWalletTopUpGames.objGameUserID, prop.getproperty("GameUserID"), "Game User ID Input Field");
        type(MLWalletTopUpGames.objEmailAddress, prop.getproperty("Email"), "Email ID Input Field");
        type(MLWalletTopUpGames.objMobileNumber, prop.getproperty("GameMobileNumber"), "Mobile Number");
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletTopUpGames.objContinue, getTextVal(MLWalletTopUpGames.objContinue, "Button"));
    }

    public void mlWallet_TransactionHistory_Generic_Steps(String billModule, String transaction) throws Exception {
        String PayBillsHistory = getText(MLWalletTransactionHistoryPage.objBillHistory(billModule, transaction));
        if (PayBillsHistory.equals(billModule))// "Pay Bills"
        {
            List<WebElement> values = findElements(MLWalletTransactionHistoryPage.objPayBillsTransctionList1(billModule));
            for (int i = 0; i < values.size(); i++) {
                String billPayTransaction = values.get(i).getText();
                logger.info(billModule + " Transaction : " + billPayTransaction);
                ExtentReporter.extentLogger(" ", billModule + " All Transactions : " + billPayTransaction);
            }
        } else if (PayBillsHistory.equals(transaction))// "No Recent Transaction"
        {
            logger.info("No Recent Transactions Are Available for " + billModule + " Module");
            ExtentReporter.extentLogger("", "No Recent Transactions Are Available for " + billModule + " Module");
        }
    }
    //------------SHOP ITEMS--------------------
    public String getWallentBalance(String balance) throws Exception{
        if(verifyElementPresent(MLWalletHomePage.objHiddenAvailableBalance, "Hidden Balance")){
            click(MLWalletHomePage.objEyeIcon, "Eye Icon");
            waitTime(5000);
            balance = getText(MLWalletHomePage.objAvailableBalance);
            logger.info("balance is = " + getText(MLWalletHomePage.objAvailableBalance));
            return balance;
        }else{
            balance = getText(MLWalletHomePage.objAvailableBalance);
            logger.info("balance is = " + getText(MLWalletHomePage.objAvailableBalance));
            return balance;
        }
    }

    //Cash Back
    public void exit_cashBack_popUp()throws Exception{
        //if cashback pop up visible tap Refer and Earn button. Then tap back button again to go to dashboard
            
        //
    }
}
