package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.mlwallet.pages.*;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.utility.Utilities.*;

public class CashInVia_BankClass extends BaseClass{

    public CashInVia_BankClass (String Application, String deviceName, String portno ) throws InterruptedException{
        super(Application, deviceName, portno);
    }
    public void cashInViaBank_CIBA_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(3000);
        enableLocation_PopUp();
        bankUserLogin(prop.getproperty("Valid_LoginId"), prop.getproperty("Valid_Password"));
        click(MLWalletCashInBank.objWebContinueBtn, "Continue Button");
        click(MLWalletCashInBank.objPayBtn, getTextVal(MLWalletCashInBank.objPayBtn, "Button"));
        verifyElementPresent(MLWalletCashInBank.objBankReferenceNumber, getTextVal(MLWalletCashInBank.objBankReferenceNumber, "Reference Number"));
        verifyElementPresent(MLWalletCashInBank.objStatus, getTextVal(MLWalletCashInBank.objStatus, "Status"));
        verifyElementPresent(MLWalletCashInBank.objMessage, getTextVal(MLWalletCashInBank.objMessage, "Message"));
        if (verifyElementPresent(MLWalletCashInBank.objSuccessMsg, getTextVal(MLWalletCashInBank.objSuccessMsg, "Message"))) {
            logger.info("CIBA_TC_01, Cash In Via Bank validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_01", "CIBA_TC_01, Cash In Via Bank validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankMinimumTransactionLimit_CIBA_TC_03() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Minimum Transaction Limit");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("20");
        if (verifyElementPresent(MLWalletCashInBank.objMinimumTransactionPopupMsg, getTextVal(MLWalletCashInBank.objMinimumTransactionPopupMsg, "Pop Message"))) {
            String sMinimumTransactionPopupMsg = getText(MLWalletCashInBank.objMinimumTransactionPopupMsg);
            String sExpectedPopupMsg = "The supplied amount is less than the required minimum transaction limit";
            assertionValidation(sMinimumTransactionPopupMsg, sExpectedPopupMsg);
            logger.info("CIBA_TC_03, Minimum transaction limit pop up message is validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_03", "CIBA_TC_03, Minimum transaction limit pop up message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankMaximumTransaction_CIBA_TC_04() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Maximum Transaction");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("60000");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        if (verifyElementPresent(MLWalletCashInBank.objMaxLimitErrorMsg, getTextVal(MLWalletCashInBank.objMaxLimitErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(MLWalletCashInBank.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum Bank Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            logger.info("CIBA_TC_04, The maximum send money per transaction - Error Message is validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_04", "CIBA_TC_04, The maximum send money per transaction - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankInvalidAmount_STW_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Invalid Amount");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("0");
        if (verifyElementPresent(MLWalletCashInBank.objInvalidAmountMsg, getTextVal(MLWalletCashInBank.objInvalidAmountMsg, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(MLWalletCashInBank.objInvalidAmountMsg);
            String sExpectedErrorMsg = "The amount should not be less than 1";
            assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
            logger.info("STW_TC_05, The amount should not be less than 1 - Error Message is validated");
            ExtentReporter.extentLoggerPass("STW_TC_05", "STW_TC_05, The amount should not be less than 1 - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankNavigation_STW_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Navigation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"));
        waitTime(4000);
        if (verifyElementPresent(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Page"))) {
            logger.info("STW_TC_06, Navigated to Cash In Page Validated");
            ExtentReporter.extentLoggerPass("STW_TC_06", "STW_TC_06, Navigated to Cash In Page Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInUIValidation_STW_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"));
        waitTime(4000);
        if (verifyElementPresent(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Page"))) {
            verifyElementPresent(MLWalletCashInBank.objCashInOption, getTextVal(MLWalletCashInBank.objCashInOption, "Header"));
            verifyElementPresent(MLWalletCashInBank.objMyBankAccount, getTextVal(MLWalletCashInBank.objMyBankAccount, "Option"));
            verifyElementPresent(MLWalletCashInBank.objBranchName, getTextVal(MLWalletCashInBank.objBranchName, "Option"));
            logger.info("STW_TC_07, Cash In Page UI validated");
            ExtentReporter.extentLoggerPass("STW_TC_07", "STW_TC_07, Cash In Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInPageBackArrowBtnValidation_STW_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Page Back Button Validation");
        cashInUIValidation_STW_TC_07();
        verifyElementPresentAndClick(MLWalletCashInBank.objCashInBackArrowBtn, "Cash In Back Button");
        waitTime(10000);
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("STW_TC_08, Cash In Page Back Button validated");
            ExtentReporter.extentLoggerPass("STW_TC_08", "STW_TC_08, Cash In Page Back Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInSelectBankPageUIValidation_STW_TC_09() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Select Bank Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"));
        verifyElementPresentAndClick(MLWalletCashInBank.objMyBankAccount, getTextVal(MLWalletCashInBank.objMyBankAccount, "Option"));
        if (verifyElementPresent(MLWalletCashInBank.objSelectABank, getTextVal(MLWalletCashInBank.objSelectABank, "Header"))) {
            verifyElementPresent(MLWalletCashInBank.objSearchBank, "Search Bank Input Field");
            if (verifyElementDisplayed(MLWalletCashInBank.objBanks)) {
                List<WebElement> values = findElements(MLWalletCashInBank.objBanks);
                for (int i = 0; i < values.size(); i++) {
                    String savedRecipientName = values.get(i).getText();
                    logger.info("Bank : " + savedRecipientName + " is displayed");
                    ExtentReporter.extentLogger(" ", "Bank : " + savedRecipientName + " is displayed");
                }
            }
            logger.info("STW_TC_09, Cash In Select Bank Page UI validated");
            ExtentReporter.extentLoggerPass("STW_TC_09", "STW_TC_09, Cash In Select Bank Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankSearchInvalidBank_STW_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Invalid Bank");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"));
        verifyElementPresentAndClick(MLWalletCashInBank.objMyBankAccount, getTextVal(MLWalletCashInBank.objMyBankAccount, "Option"));
        if (verifyElementPresent(MLWalletCashInBank.objSelectABank, getTextVal(MLWalletCashInBank.objSelectABank, "Header"))) {
            type(MLWalletCashInBank.objSearchBank, prop.getproperty("Invalid_BankName"), "Search Bank Input Field");
            if (verifyElementPresent(MLWalletCashInBank.objNoRecentTransactionTxt, getTextVal(MLWalletCashInBank.objNoRecentTransactionTxt, "Text"))) {
                logger.info("STW_TC_10, Cash In Select Bank Page UI validated");
                ExtentReporter.extentLoggerPass("STW_TC_10", "STW_TC_10, Cash In Select Bank Page UI validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBankSelectBankPageBackBtnValidation_STW_TC_11() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Select Bank Page BackArrow Button Validation");
        cashInViaBankSearchInvalidBank_STW_TC_10();
        verifyElementPresentAndClick(MLWalletCashInBank.objSelectBankBackBtn, "Select A Bank Page Back Button");
        if (verifyElementPresent(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Page"))) {
            logger.info("STW_TC_11, Select Bank Page Back Button validated");
            ExtentReporter.extentLoggerPass("STW_TC_11", "STW_TC_11, Select Bank Page Back Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankDragonPayPageUIValidation_STW_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Dragon Pay Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresent(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"));
        click(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Icon"));
        click(MLWalletCashInBank.objMyBankAccount, getTextVal(MLWalletCashInBank.objMyBankAccount, "Button"));
        verifyElementPresent(MLWalletCashInBank.objSelectABank, getTextVal(MLWalletCashInBank.objSelectABank, "Page"));
        click(MLWalletCashInBank.objTestBankOnline, getTextVal(MLWalletCashInBank.objTestBankOnline, "Bank"));
        if (verifyElementPresent(MLWalletCashInBank.objDragonPay, getTextVal(MLWalletCashInBank.objDragonPay, "Page"))) {
            verifyElementPresent(MLWalletCashInBank.objBankCashIn, getTextVal(MLWalletCashInBank.objBankCashIn, "Text"));
            verifyElementPresent(MLWalletCashInBank.objAmountEditField, "Amount Text Field");
            verifyElementPresent(MLWalletCashInBank.objNextBtn, getTextVal(MLWalletCashInBank.objNextBtn, "Button"));
            logger.info("STW_TC_12, Cash In Via Bank Dragon Pay Page UI validated");
            ExtentReporter.extentLoggerPass("STW_TC_12", "STW_TC_12, Cash In Via Bank Dragon Pay Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankDragonPayBackBtnValidation_STW_TC_13() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Dragon Pay Back Button Validation");
        cashInViaBankDragonPayPageUIValidation_STW_TC_12();
        verifyElementPresentAndClick(MLWalletCashInBank.objDragonPayBackBtn, "Dragon Pay Back Button");
        if (verifyElementPresent(MLWalletCashInBank.objSelectABank, getTextVal(MLWalletCashInBank.objSelectABank, "Page"))) {
            logger.info("STW_TC_13, Cash In Via Bank Dragon Pay Back Button validated");
            ExtentReporter.extentLoggerPass("STW_TC_13", "STW_TC_13, Cash In Via Bank Dragon Pay Back Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankReviewTransactionPageUIValidation_STW_TC_14() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Review Transaction Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        if (verifyElementPresent(MLWalletCashInBank.objReviewTransaction, getTextVal(MLWalletCashInBank.objReviewTransaction, "Page"))) {
            verifyElementPresent(MLWalletCashInBank.objReceiverName, getTextVal(MLWalletCashInBank.objReceiverName, "Receiver's Name"));
            verifyElementPresent(MLWalletCashInBank.objBankName, getTextVal(MLWalletCashInBank.objBankName, "Bank Name"));
            verifyElementPresent(MLWalletCashInBank.objPrincipalAmount, getTextVal(MLWalletCashInBank.objPrincipalAmount, "Principal Amount"));
            verifyElementPresent(MLWalletCashInBank.objServiceFee, getTextVal(MLWalletCashInBank.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletCashInBank.objEmail, getTextVal(MLWalletCashInBank.objEmail, "Email"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletCashInBank.objBankTransferCutOffTime, getTextVal(MLWalletCashInBank.objBankTransferCutOffTime, "Message"));
            verifyElementPresent(MLWalletCashInBank.objNextBtn, getTextVal(MLWalletCashInBank.objNextBtn, "Button"));
            logger.info("STW_TC_14, Cash In Via Bank Review Transaction Page UI validated");
            ExtentReporter.extentLoggerPass("STW_TC_14", "STW_TC_14, Cash In Via Bank Review Transaction Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankReviewTransactionBackBtnValidation_STW_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Review Transaction Back Button Validation");
        cashInViaBankReviewTransactionPageUIValidation_STW_TC_14();
        verifyElementPresentAndClick(MLWalletCashInBank.objReviewTransactionBackBtn, "Review Transaction Back Button");
        if (verifyElementPresent(MLWalletCashInBank.objDragonPay, getTextVal(MLWalletCashInBank.objDragonPay, "Page"))) {
            logger.info("STW_TC_15, Cash In Via Bank Review Transaction Back Button validated");
            ExtentReporter.extentLoggerPass("STW_TC_15", "STW_TC_15, Cash In Via Bank Review Transaction Back Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankStatusTransaction_CIBA_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Success transaction validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon, "Eye Icon");
        String sBalance = getText(MLWalletHomePage.objAvailableBalance);
        selectBankAndInputAmount("1000");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        bankUserLogin(prop.getproperty("Valid_LoginId"), prop.getproperty("Valid_Password"));
        click(MLWalletCashInBank.objWebContinueBtn, "Continue Button");
        click(MLWalletCashInBank.objPayBtn, getTextVal(MLWalletCashInBank.objPayBtn, "Button"));
        verifyElementPresent(MLWalletCashInBank.objBankReferenceNumber, getTextVal(MLWalletCashInBank.objBankReferenceNumber, "Reference Number"));
        verifyElementPresent(MLWalletCashInBank.objStatus, getTextVal(MLWalletCashInBank.objStatus, "Status"));
        verifyElementPresent(MLWalletCashInBank.objMessage, getTextVal(MLWalletCashInBank.objMessage, "Message"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCompleteTransactionBtn, getTextVal(MLWalletCashInBank.objCompleteTransactionBtn, "Button"));
        Swipe("DOWN", 3);
        String sBalanceAfterTransaction = getText(MLWalletHomePage.objAvailableBalance);
        Swipe("UP", 1);
        if (verifyElementPresent(MLWalletHomePage.objSuccess, getTextVal(MLWalletHomePage.objSuccess, "Status"))) {
            assertNotEquals(sBalance, sBalanceAfterTransaction);
            logger.info("STW_TC_16, Cash In Via Bank success transaction validated and cash in Amount is reflected in Balance");
            ExtentReporter.extentLoggerPass("STW_TC_16", "STW_TC_16, Cash In Via Bank success transaction validated and cash in Amount is reflected in Balance");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankPendingTransaction_CIBA_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Pending Transaction");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        bankUserLogin(prop.getproperty("Valid_LoginId"), prop.getproperty("Valid_Password"));
        click(MLWalletCashInBank.objWebContinueBtn, "Continue Button");
        click(MLWalletCashInBank.objPayBtn, getTextVal(MLWalletCashInBank.objPayBtn, "Button"));
        verifyElementPresent(MLWalletCashInBank.objBankReferenceNumber, getTextVal(MLWalletCashInBank.objBankReferenceNumber, "Reference Number"));
        verifyElementPresent(MLWalletCashInBank.objStatus, getTextVal(MLWalletCashInBank.objStatus, "Status"));
        verifyElementPresent(MLWalletCashInBank.objMessage, getTextVal(MLWalletCashInBank.objMessage, "Message"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCompleteTransactionBtn, getTextVal(MLWalletCashInBank.objCompleteTransactionBtn, "Button"));
        Swipe("DOWN", 2);
        if (verifyElementPresent(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Transaction"))) {
            verifyElementPresent(MLWalletCashInBank.objPendingStatus, getTextVal(MLWalletCashInBank.objPendingStatus, "Status"));
            String sStatus = getText(MLWalletCashInBank.objPendingStatus);
            String sExpectedStatus = "Pending";
            assertionValidation(sStatus, sExpectedStatus);
            logger.info("CIBA_TC_17, An entry in recent transaction for current Cash In should be present with status pending validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_17", "CIBA_TC_17, An entry in recent transaction for current Cash In should be present with status pending validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankWithExistingPendingTransaction_CIBA_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank With Existing Pending Transaction");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletTransactionHistoryPage.objHistoryText, "History Icon/Text");
        scrollToFirstHorizontalScrollableElement("Cash In");
        click(MLWalletTransactionHistoryPage.objCashInTab, "Cash In");
        Thread.sleep(3000);
        scrollToVertical("Pending");
        if (verifyElementPresent(MLWalletCashInBank.objPending, getTextVal(MLWalletCashInBank.objPending, "Status"))) {
            click(MLWalletCashInBank.objTransactionHistoryBackBtn, "Transaction History Back Button");
            Swipe("DOWN", 1);
            selectBankAndInputAmount("100");
            dragonPayChargesMsgValidation();
            reviewTransactionValidation();
            enterOTP(prop.getproperty("Valid_OTP"));
            enableLocation_PopUp();
            bankUserLogin(prop.getproperty("Valid_LoginId"), prop.getproperty("Valid_Password"));
            click(MLWalletCashInBank.objWebContinueBtn, "Continue Button");
            click(MLWalletCashInBank.objPayBtn, getTextVal(MLWalletCashInBank.objPayBtn, "Button"));
            verifyElementPresent(MLWalletCashInBank.objBankReferenceNumber, getTextVal(MLWalletCashInBank.objBankReferenceNumber, "Reference Number"));
            verifyElementPresent(MLWalletCashInBank.objStatus, getTextVal(MLWalletCashInBank.objStatus, "Status"));
            verifyElementPresent(MLWalletCashInBank.objMessage, getTextVal(MLWalletCashInBank.objMessage, "Message"));
            verifyElementPresentAndClick(MLWalletCashInBank.objCompleteTransactionBtn, getTextVal(MLWalletCashInBank.objCompleteTransactionBtn, "Button"));
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            if (verifyElementPresent(MLWalletCashInBank.objCashIn, getTextVal(MLWalletCashInBank.objCashIn, "Transaction"))) {
                verifyElementPresent(MLWalletCashInBank.objPending, getTextVal(MLWalletCashInBank.objPending, "Status"));
                logger.info("CIBA_TC_20, Cash In Via Bank With Existing Pending Transaction Validated");
                ExtentReporter.extentLoggerPass("CIBA_TC_20", "CIBA_TC_20, Cash In Via Bank With Existing Pending Transaction validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cancelButtonValidationInDragonPayPopUp_CIBA_TC_21() throws Exception {
        ExtentReporter.HeaderChildNode("Cancel Button Validation In Dragon Pay PopUp");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        verifyElementPresent(MLWalletCashInBank.objDragonPayChargesMsg, getTextVal(MLWalletCashInBank.objDragonPayChargesMsg, "Message"));
        String sDragonPayChargesMsg = getText(MLWalletCashInBank.objDragonPayChargesMsg);
        String sExpectedDragonPayChargesMsg = "Dragon Pay charges a fee of 30 pesos for this transaction. Do you wish to continue with your transaction?";
        assertionValidation(sDragonPayChargesMsg, sExpectedDragonPayChargesMsg);
        click(MLWalletCashInBank.objCancelBtn, getTextVal(MLWalletCashInBank.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletCashInBank.objDragonPay, getTextVal(MLWalletCashInBank.objDragonPay, "Page"))) {
            logger.info("CIBA_TC_21, Cancel Button Validated In Dragon Pay PopUp");
            ExtentReporter.extentLoggerPass("CIBA_TC_21", "CIBA_TC_21, Cancel Button Validated In Dragon Pay PopUp");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankTappingOutsideTheDragonPayPopupValidation_CIBA_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Tapping Outside the Dragon Pay Popup Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        verifyElementPresent(MLWalletCashInBank.objDragonPayChargesMsg, getTextVal(MLWalletCashInBank.objDragonPayChargesMsg, "Message"));
        String sDragonPayChargesMsg = getText(MLWalletCashInBank.objDragonPayChargesMsg);
        String sExpectedDragonPayChargesMsg = "Dragon Pay charges a fee of 30 pesos for this transaction. Do you wish to continue with your transaction?";
        assertionValidation(sDragonPayChargesMsg, sExpectedDragonPayChargesMsg);
        tapUsingCoordinates(500, 1000);
        logger.info("Clicked OutSide the Dragon Pay Popup");
        if (verifyElementPresent(MLWalletCashInBank.objDragonPayChargesMsg, getTextVal(MLWalletCashInBank.objDragonPayChargesMsg, "Popup Message"))) {
            logger.info("CIBA_TC_22, Cash In Via Bank, After Tapping Outside the Dragon Pay Popup, Popup doesn't closed");
            ExtentReporter.extentLoggerPass("CIBA_TC_22", "CIBA_TC_22, Cash In Via Bank, After Tapping Outside the Dragon Pay Popup, Popup doesn't closed");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankInvalidAmountFieldValidation_CIBA_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Invalid Amount Field Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("");
        if (verifyElementPresent(MLWalletCashInBank.objInvalidAmountMsg, getTextVal(MLWalletCashInBank.objInvalidAmountMsg, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(MLWalletCashInBank.objInvalidAmountMsg);
            String sExpectedErrorMsg = "Amount is required";
            assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
            logger.info("CIBA_TC_23, Amount is required - Error Message is validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_23", "CIBA_TC_23, Amount is required - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankBuyerTierLevel_CIBA_TC_24() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Buyer Tier Level");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        if (verifyElementPresent(MLWalletCashInBank.objMaxLimitTxt, getTextVal(MLWalletCashInBank.objMaxLimitTxt, "Text Message"))) {
            String sErrorMessage = getText(MLWalletCashInBank.objMaxLimitTxt);
            String ExpectedTxt = "Bank Cash-in is not allowed for customers at this verification level. Please upgrade your account to use this service.";
            assertionValidation(sErrorMessage, ExpectedTxt);
            verifyElementPresent(MLWalletCashInBank.objUpgradeNowBtn, getTextVal(MLWalletCashInBank.objUpgradeNowBtn, "Button"));
            logger.info("CIBA_TC_24, Branch Cash-In is not allowed for customers at this verification level. Error Message is Validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_24", "CIBA_TC_24, Branch Cash-In is not allowed for customers at this verification level. Error Message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankSemiVerifiedTierStatusTransaction_CIBA_TC_25() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Semi Verified Tier Success transaction validation");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon, "Eye Icon");
        String sBalance = getText(MLWalletHomePage.objHiddenAvailableBalance);
        selectBankAndInputAmount("1000");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        bankUserLogin(prop.getproperty("Valid_LoginId"), prop.getproperty("Valid_Password"));
        click(MLWalletCashInBank.objWebContinueBtn, "Continue Button");
        click(MLWalletCashInBank.objPayBtn, getTextVal(MLWalletCashInBank.objPayBtn, "Button"));
        verifyElementPresent(MLWalletCashInBank.objBankReferenceNumber, getTextVal(MLWalletCashInBank.objBankReferenceNumber, "Reference Number"));
        verifyElementPresent(MLWalletCashInBank.objStatus, getTextVal(MLWalletCashInBank.objStatus, "Status"));
        verifyElementPresent(MLWalletCashInBank.objMessage, getTextVal(MLWalletCashInBank.objMessage, "Message"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCompleteTransactionBtn, getTextVal(MLWalletCashInBank.objCompleteTransactionBtn, "Button"));
        Swipe("DOWN", 3);
        String sBalanceAfterTransaction = getText(MLWalletHomePage.objHiddenAvailableBalance);
        Swipe("UP", 1);
        if (verifyElementPresent(MLWalletHomePage.objSuccess, getTextVal(MLWalletHomePage.objSuccess, "Status"))) {
            assertNotEquals(sBalance, sBalanceAfterTransaction);
            logger.info("CIBA_TC_25, Cash In Via Bank Semi Verified Tier success transaction validated and cash in Amount is reflected in Balance");
            ExtentReporter.extentLoggerPass("CIBA_TC_25", "CIBA_TC_25, Cash In Via Bank Semi Verified Tier success transaction validated and cash in Amount is reflected in Balance");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankFullyVerifiedTierStatusTransaction_CIBA_TC_26() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Fully Verified Tier Success transaction validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon, "Eye Icon");
        String sBalance = getText(MLWalletHomePage.objHiddenAvailableBalance);
        selectBankAndInputAmount("1000");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        bankUserLogin(prop.getproperty("Valid_LoginId"), prop.getproperty("Valid_Password"));
        click(MLWalletCashInBank.objWebContinueBtn, "Continue Button");
        click(MLWalletCashInBank.objPayBtn, getTextVal(MLWalletCashInBank.objPayBtn, "Button"));
        verifyElementPresent(MLWalletCashInBank.objBankReferenceNumber, getTextVal(MLWalletCashInBank.objBankReferenceNumber, "Reference Number"));
        verifyElementPresent(MLWalletCashInBank.objStatus, getTextVal(MLWalletCashInBank.objStatus, "Status"));
        verifyElementPresent(MLWalletCashInBank.objMessage, getTextVal(MLWalletCashInBank.objMessage, "Message"));
        verifyElementPresentAndClick(MLWalletCashInBank.objCompleteTransactionBtn, getTextVal(MLWalletCashInBank.objCompleteTransactionBtn, "Button"));
        Swipe("DOWN", 3);
        String sBalanceAfterTransaction = getText(MLWalletHomePage.objHiddenAvailableBalance);
        Swipe("UP", 1);
        if (verifyElementPresent(MLWalletHomePage.objSuccess, getTextVal(MLWalletHomePage.objSuccess, "Status"))) {
            assertNotEquals(sBalance, sBalanceAfterTransaction);
            logger.info("CIBA_TC_26, Cash In Via Bank Fully Verified Tier success transaction validated and cash in Amount is reflected in Balance");
            ExtentReporter.extentLoggerPass("CIBA_TC_26", "CIBA_TC_26, Cash In Via Bank Fully Verified Tier success transaction validated and cash in Amount is reflected in Balance");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankSemiVerifiedUserMaxLimit_CIBA_TC_27() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Maximum Limit");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        selectBankAndInputAmount("60000");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        if (verifyElementPresent(MLWalletCashInBank.objBankMaxLimitTxt, getTextVal(MLWalletCashInBank.objBankMaxLimitTxt, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInBank.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Bank Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("CIBA_TC_27, To validate Maximum Limit of transaction");
            ExtentReporter.extentLoggerPass("CIBA_TC_27", "CIBA_TC_27, To validate Maximum Limit of transaction");
        }
    }

    public void cashInViaBankFullyVerifiedUserMaxLimit_CIBA_TC_28() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Maximum Limit");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        selectBankAndInputAmount("60000");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        if (verifyElementPresent(MLWalletCashInBank.objBankMaxLimitTxtFullyVerified, getTextVal(MLWalletCashInBank.objBankMaxLimitTxtFullyVerified, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInBank.objBankMaxLimitTxtFullyVerified);
            String sExpectedErrorMsg = "The maximum Bank Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("CIBA_TC_28, To validate Maximum Limit of transaction");
            ExtentReporter.extentLoggerPass("CIBA_TC_28", "CIBA_TC_28, To validate Maximum Limit of transaction");
        }
    }

    public void cashInViaBankTransactionDetailsPageUIValidation_CIBA_TC_29() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Transaction Details Page UI Validation");
        cashInViaBank_CIBA_TC_01();
        verifyElementPresentAndClick(MLWalletCashInBank.objCompleteTransactionBtn, getTextVal(MLWalletCashInBank.objCompleteTransactionBtn, "Button"));
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        click(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionType, getTextVal(MLWalletTransactionHistoryPage.objTransactionType, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objBank, getTextVal(MLWalletTransactionHistoryPage.objBank, "Bank"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalCashIn, getTextVal(MLWalletTransactionHistoryPage.objTotalCashIn, "Total Cash In"));
            logger.info("CIBA_TC_29, Cash In Via Bank Transaction Details Page UI Validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_29", "CIBA_TC_29, Cash In Via Bank Transaction Details Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankDragonPayChagresPopUpValidation_CIBA_TC_32() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Dragon Pay charges popup Validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        selectBankAndInputAmount("100");
        if (verifyElementPresent(MLWalletCashInBank.objDragonPayChargesMsg, getTextVal(MLWalletCashInBank.objDragonPayChargesMsg, "Message"))) {
            String sDragonPayChargesMsg = getText(MLWalletCashInBank.objDragonPayChargesMsg);
            String sExpectedDragonPayChargesMsg = "Dragon Pay charges a fee of 30 pesos for this transaction. Do you wish to continue with your transaction?";
            assertionValidation(sDragonPayChargesMsg, sExpectedDragonPayChargesMsg);
            logger.info("CIBA_TC_32, Cash In Via Bank Dragon Pay charges popup Validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_32", "CIBA_TC_32, Cash In Via Bank Dragon Pay charges popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankLocationPopupValidation_CIBA_TC_35() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Location popup Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpValidation();
            logger.info("CIBA_TC_35, Cash In Via Bank Location popup Validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_35", "CIBA_TC_35, Cash In Via Bank Location popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankLocationDenyFunctionality_CIBA_TC_36() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Location Deny Functionality Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyPopUp();
            logger.info("CIBA_TC_36, Cash In Via Bank Location Deny Functionality Validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_36", "CIBA_TC_36, Cash In Via Bank Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankLocationPermissionDenyCloseBtnFunctionality_CIBA_TC_37() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Location Permission Deny Close Button Functionality Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyCloseBtnFunctionality();
            if (verifyElementPresent(MLWalletCashInBank.objReviewTransaction, getTextVal(MLWalletCashInBank.objReviewTransaction, "Page"))) {
                logger.info("CIBA_TC_37, Cash In Via Bank Location Permission Deny Close Button Functionality Validated");
                ExtentReporter.extentLoggerPass("CIBA_TC_37", "CIBA_TC_37, Cash In Via Bank Location Permission Deny Close Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBankLocationPermissionDenyOpenSettingsBtnFunctionality_CIBA_TC_38() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Location Permission Deny open Settings Button Functionality Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyOpenSettingsBtnFunctionality();
            if (verifyElementPresent(MLWalletCashInBank.objAppInfo, getTextVal(MLWalletCashInBank.objAppInfo, "Page"))) {
                logger.info("CIBA_TC_38, Cash In Via Bank Location Permission Deny Open Settings Button Functionality Validated");
                ExtentReporter.extentLoggerPass("CIBA_TC_38", "CIBA_TC_38, Cash In Via Bank Location Permission Deny Open Settings Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBankLocationPopUpAllowFunctionality_CIBA_TC_39() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Location popup Allow Button Functionality Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpAllowFunctionality();
            if (verifyElementPresent(MLWalletCashInBank.objLoginIdTxtField, "Bank Page")) {
                logger.info("CIBA_TC_39, Cash In Via Bank Location popup Allow Button Functionality Validated");
                ExtentReporter.extentLoggerPass("CIBA_TC_39", "CIBA_TC_39, Cash In Via Bank Location popup Allow Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBankInternetInterruptionWhileEnteringOTP_CIBA_TC_40() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Internet Interruption While Entering OTP Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(15000);
        setWifiConnectionToONOFF("OFF");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"))) {
            internetConnectionError();
            logger.info("CIBA_TC_40, Cash In Via Bank Internet Interruption While Entering OTP Validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_40", "CIBA_TC_40, Cash In Via Bank Internet Interruption While Entering OTP Validated");
            System.out.println("-----------------------------------------------------------");
        }
        setWifiConnectionToONOFF("ON");
    }


    public void cashInViaBankTransactionValidationAfterMinimizingApp_CIBA_TC_43() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Transaction Validation After Minimizing App");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        waitTime(3000);
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        if (verifyElementPresent(MLWalletCashInBank.objLoginIdTxtField, "Bank Page")) {
            logger.info("CIBA_TC_43, Cash In Via Bank Transaction Validation After Minimizing App Validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_43", "CIBA_TC_43, Cash In Via Bank Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankAmountFieldValidation_CIBA_TC_49() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank, Amount Field with more than 2 decimals Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("1000.123");
        if (verifyElementPresent(MLWalletCashInBank.objInvalidAmountMsg, getTextVal(MLWalletCashInBank.objInvalidAmountMsg, "Pop Message"))) {
            String sMinimumTransactionPopupMsg = getText(MLWalletCashInBank.objInvalidAmountMsg);
            String sExpectedPopupMsg = "The amount must be limited to 2 decimal places";
            assertionValidation(sMinimumTransactionPopupMsg, sExpectedPopupMsg);
            logger.info("CIBA_TC_49, Cash In Via Bank, Amount Field with more than 2 decimals Error Msg validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_49", "CIBA_TC_49, Cash In Via Bank, Amount Field with more than 2 decimals Error Msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankTransactionWithValidMLPin_CIBA_TC_50() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Transaction With Valid ML Pin");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        handleMpin("1111");
        enableLocation_PopUp();
        bankUserLogin(prop.getproperty("Valid_LoginId"), prop.getproperty("Valid_Password"));
        click(MLWalletCashInBank.objWebContinueBtn, "Continue Button");
        click(MLWalletCashInBank.objPayBtn, getTextVal(MLWalletCashInBank.objPayBtn, "Button"));
        verifyElementPresent(MLWalletCashInBank.objBankReferenceNumber, getTextVal(MLWalletCashInBank.objBankReferenceNumber, "Reference Number"));
        verifyElementPresent(MLWalletCashInBank.objStatus, getTextVal(MLWalletCashInBank.objStatus, "Status"));
        verifyElementPresent(MLWalletCashInBank.objMessage, getTextVal(MLWalletCashInBank.objMessage, "Message"));
        if (verifyElementPresent(MLWalletCashInBank.objSuccessMsg, getTextVal(MLWalletCashInBank.objSuccessMsg, "Message"))) {
            logger.info("CIBA_TC_50, Cash In Via Bank Transaction With Valid ML Pin validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_50", "CIBA_TC_50, Cash In Via Bank Transaction With Valid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankTransactionWithInValidMLPin_CIBA_TC_51() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Transaction With Invalid ML Pin");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        handleMpin("1234");
        if (verifyElementPresent(MLWalletCashInBank.objInvalidPINMsg, getTextVal(MLWalletCashInBank.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletCashInBank.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("CIBA_TC_51, Cash In Via Bank Transaction With Invalid ML Pin validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_51", "CIBA_TC_51, Cash In Via Bank Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankOTPPopupValidation_CIBA_TC_57() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank OTP Popup validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            logger.info("CIBA_TC_57, Cash In Via Bank, OTP popup validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_57", "CIBA_TC_57, Cash In Via Bank, OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankTransactionInAppOTPPopupUIValidation_CIBA_TC_58() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Transaction InApp OTP Popup UI validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds, getTextVal(MLWalletLoginPage.objSeconds, "Seconds"));
            verifyElementPresent(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
            logger.info("CIBA_TC_58, Cash In Via Bank Transaction InApp OTP Popup validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_58", "CIBA_TC_58, Cash In Via Bank Transaction InApp OTP Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBankTransactionNewOTPAfterSixtySecondsValidation_CIBA_TC_59() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Transaction New OTP got generated After Sixty Seconds validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if (verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"))) {
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP, sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("CIBA_TC_59, Cash In Via Bank Transaction New OTP got generated After Sixty Seconds is validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_59", "CIBA_TC_59, Cash In Via Bank Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankTransactionOTPCancelBtnFunctionality_CIBA_TC_60() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Transaction OTP Cancel Button Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletCashInBank.objReviewTransaction, getTextVal(MLWalletCashInBank.objReviewTransaction, "Page"))) {
            logger.info("CIBA_TC_60, Cash In Via Bank Transaction, After clicking on Cancel in One time pin popup App navigates back to review transaction Page is validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_60", "CIBA_TC_60, Cash In Via Bank Transaction, After clicking on Cancel in One time pin popup App navigates back to review transaction Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankOTPContinueBtnFunctionality_CIBA_TC_61() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Bank Transaction OTP Continue Button Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        selectBankAndInputAmount("100");
        dragonPayChargesMsgValidation();
        reviewTransactionValidation();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletCashInBank.objReferenceNumberMsg, "Dragon Pay bank Page")) {
            logger.info("CIBA_TC_61, Cash In Via Bank Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            ExtentReporter.extentLoggerPass("CIBA_TC_61", "CIBA_TC_61, Cash In Via Bank Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
