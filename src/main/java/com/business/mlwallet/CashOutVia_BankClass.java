package com.business.mlwallet;

import com.driverInstance.CommandBase;
import com.driverInstance.DriverManager;
import com.mlwallet.pages.*;
import com.utility.ExtentReporter;

import java.time.Duration;

import static com.utility.Utilities.*;
import static com.utility.Utilities.assertionValidation;

public class CashOutVia_BankClass extends BaseClass{
    public CashOutVia_BankClass(String Application, String deviceName, String portno) throws InterruptedException{
        super(Application, deviceName, portno);
    }
    public void cashOutWithdrawBank_WM_TC_01(String Amount) throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Withdraw Branch");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(Amount);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            String sTransactionSuccess = getText(MLWalletCashOutPage.objTransactionSuccessMessage);
            assertionValidation(sTransactionSuccess, "Transaction Successful");
            verifyElementPresent(MLWalletCashOutPage.objTransactionNo, getTextVal(MLWalletCashOutPage.objTransactionNo, "Transaction Number"));
            String sTransactionNumber = getText(MLWalletCashOutPage.objTransactionNo);
            System.out.println(sTransactionNumber);
            scrollToVertical("Back To Home");
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sTransactionNumber);
                logger.info("WM_TC_01, Successfully Withdraw Money to Bank");
                ExtentReporter.extentLoggerPass("WM_TC_01", "WM_TC_01, Successfully Withdraw Money to Bank");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutWithInvalidAccNumber_WM_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("cashOut With Invalid Account Number");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("Invalid_AccountNumber"));
        Thread.sleep(3000);
        if (verifyElementPresent(MLWalletCashOutPage.objAccInvalidErrorMsg, getTextVal(MLWalletCashOutPage.objAccInvalidErrorMsg, "Text Message"))) {
            String sInvalidAccTxt = getText(MLWalletCashOutPage.objAccInvalidErrorMsg);
            String ExpectedTxt = "Bank Account provided not valid. Please check the account details and try again.";
            assertionValidation(sInvalidAccTxt, ExpectedTxt);
            logger.info("WM_TC_02, Bank Account provided not valid. Error Message is Validated");
            ExtentReporter.extentLoggerPass("WM_TC_02", "WM_TC_02, Bank Account provided not valid. Error Message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashOutWithdrawBankMaxAmount_WM_TC_03(String Amount) throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Withdraw Branch Max Amount");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(Amount);
        if (verifyElementPresent(MLWalletCashOutPage.objBankMaxLimitTxt, getTextVal(MLWalletCashOutPage.objBankMaxLimitTxt, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashOutPage.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Bank Cash-out per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("WM_TC_03, The Maximum Bank Cash-out per transaction Msg is Validated");
            ExtentReporter.extentLoggerPass("WM_TC_03", "WM_TC_03, The Maximum Bank Cash-out per transaction Msg is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutWithdrawMinTransactionLimit_WM_TC_04(String Amount) throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Withdraw Branch Max Amount");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        waitTime(5000);
        type(MLWalletCashOutPage.objAmountField, Amount, "Amount to Send");
        click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
        Thread.sleep(5000);
        if (verifyElementPresent(MLWalletCashOutPage.objMinimumTransactionErrorMsg, getTextVal(MLWalletCashOutPage.objMinimumTransactionErrorMsg, "Error message"))) {
            String sMinimumTransactionErrorMsg = getText(MLWalletCashOutPage.objMinimumTransactionErrorMsg);
            String sExpectedMsg = "The supplied amount is less than the required minimum transaction limit";
            assertionValidation(sMinimumTransactionErrorMsg, sExpectedMsg);
            logger.info("WM_TC_04, The supplied amount is less than the required minimum transaction limit Error Msg is validated");
            ExtentReporter.extentLoggerPass("WM_TC_04", "WM_TC_04, The supplied amount is less than the required minimum transaction limit Error Msg is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
//=================================== Cash Out Phase2==================================================//

    public void cashOutInvalidBank_WM_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Invalid Bank Details");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        if (verifyElementPresent(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button")) {
            click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
            if (verifyElementPresent(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Button"))) {
                click(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Button"));
                type(MLWalletCashOutPage.objSearchBank, prop.getproperty("Invalid_BankName"), "Search Bank Text Field");
                if (verifyElementPresent(MLWalletCashOutPage.objNoRecentTransactionTxt, getTextVal(MLWalletCashOutPage.objNoRecentTransactionTxt, "Text"))) {
                    logger.info("WM_TC_10, No Recent Transaction message Validated after entering invalid Bank Name");
                    ExtentReporter.extentLoggerPass("WM_TC_10", "WM_TC_10, No Recent Transaction message Validated after entering invalid Bank Name");
                    System.out.println("-----------------------------------------------------------");
                }
            }
        }
    }

    public void searchAndSelectBank_WM_TC_11() throws Exception {
        ExtentReporter.HeaderChildNode("Search And Select Bank");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        if (verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.BogusBank, getTextVal(MLWalletCashOutPage.BogusBank, "Bank Name"));
            logger.info("WM_TC_11, Bank Name auto-displayed after searching and selecting the particular Bank");
            ExtentReporter.extentLoggerPass("WM_TC_11", "WM_TC_11, Bank Name auto-displayed after searching and selecting the particular Bank");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutInvalidAmount_WM_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Search And Select Bank");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        type(MLWalletCashOutPage.objAmountField, "", "Amount to Send");
        click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objAmountRequiredErrorMsg, getTextVal(MLWalletCashOutPage.objAmountRequiredErrorMsg, "Error Message"))) {
            String sAmountRequiredErrorMsg = getText(MLWalletCashOutPage.objAmountRequiredErrorMsg);
            String sExceptedErrorMsg = "Amount is required";
            assertionValidation(sAmountRequiredErrorMsg, sExceptedErrorMsg);
            logger.info("WM_TC_12, Amount is required - Error message is Validated");
            ExtentReporter.extentLoggerPass("WM_TC_12", "WM_TC_12, Amount is required - Error message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutSaveRecipient_WM_TC_13(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Cash out Save Recipient");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        scrollToVertical("Back To Home");
        type(MLWalletCashOutPage.objNickName, prop.getproperty("Nick_Name"), "Nick Name Input Text Field");
        click(MLWalletCashOutPage.objSaveRecipientBtn, getTextVal(MLWalletCashOutPage.objSaveRecipientBtn, "Button"));
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Button"));
        click(MLWalletCashOutPage.BogusBank, getTextVal(MLWalletCashOutPage.BogusBank, "Bank"));
        verifyElementPresent(MLWalletCashOutPage.objSavedBankAccount, getTextVal(MLWalletCashOutPage.objSavedBankAccount, "Page"));
        if (verifyElementPresent(MLWalletCashOutPage.objNickNameInSavedBankAcc(prop.getproperty("Nick_Name")), getTextVal(MLWalletCashOutPage.objNickNameInSavedBankAcc(prop.getproperty("Nick_Name")), "Nick Name for Saved Bank Account"))) {
            logger.info("WM_TC_13, Saved Recipient is displayed under Saved Bank Account");
            ExtentReporter.extentLoggerPass("WM_TC_13", "WM_TC_13, Saved Recipient is displayed under Saved Bank Account");
            System.out.println("-----------------------------------------------------------");

        }
    }

    public void cashOutRecipientDuplicate_WM_TC_14(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Cash out Recipient Duplicate");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        scrollToVertical("Back To Home");
        type(MLWalletCashOutPage.objNickName, prop.getproperty("Nick_Name"), "Nick Name Input Text Field");
        click(MLWalletCashOutPage.objSaveRecipientBtn, getTextVal(MLWalletCashOutPage.objSaveRecipientBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objRecipientExistMsg, getTextVal(MLWalletCashOutPage.objRecipientExistMsg, "Popup Message"))) {
            String sRecipientExistMsg = getText(MLWalletCashOutPage.objRecipientExistMsg);
            String sExpectedMsg = "Recipient already exists.";
            assertionValidation(sRecipientExistMsg, sExpectedMsg);
            logger.info("WM_TC_14, Recipient already exists pop up message Validated");
            ExtentReporter.extentLoggerPass("WM_TC_14", "WM_TC_14, Recipient already exists pop up message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutOTPPageUIValidation_WM_TC_20(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out OTP Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        waitTime(6000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
//			verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
//			verifyElementPresent(MLWalletCashOutPage.objResendCode, getTextVal(MLWalletCashOutPage.objResendCode, "Seconds"));
            logger.info("WM_TC_20, One Time Pin page UI Validation");
            ExtentReporter.extentLoggerPass("WM_TC_20", "WM_TC_20, One Time Pin page UI Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutOTPPageBackBtnValidation_WM_TC_21(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out OTP Page Back Button Validation");
        cashOutOTPPageUIValidation_WM_TC_20(sAmount);
        click(MLWalletCashOutPage.objOneTimePinBackBtn, "OTP Back Arrow Button");
        if (verifyElementPresent(MLWalletCashOutPage.objReviewTransaction, getTextVal(MLWalletCashOutPage.objReviewTransaction, "Page"))) {
            logger.info("WM_TC_21, OTP page back arrow Button Validation");
            ExtentReporter.extentLoggerPass("WM_TC_21", "WM_TC_21, OTP page back arrow Button Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutPendingTransactionValidation_WM_TC_24(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Pending Transaction Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            scrollToVertical("Back To Home");
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletHomePage.objPendingStatusForCashOut, getTextVal(MLWalletHomePage.objPendingStatusForCashOut, "Status"))) {
                String sActualStatus = getText(MLWalletHomePage.objPendingStatusForCashOut);
                String sExceptedStatus = "Pending";
                assertionValidation(sActualStatus, sExceptedStatus);
                logger.info("WM_TC_24, Cash Out Pending Transaction Validated");
                ExtentReporter.extentLoggerPass("WM_TC_24", "WM_TC_24, Cash Out Pending Transaction Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutMLBankBuyerTier_WM_TC_27(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut ML Bank Buyer Tier");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        if (verifyElementPresent(MLWalletCashOutPage.objMaxLimitUpgrade, getTextVal(MLWalletCashOutPage.objMaxLimitUpgrade, "Text Message"))) {
            String sErrorMessage = getText(MLWalletCashOutPage.objMaxLimitUpgrade);
            String ExpectedTxt = "Bank Cash-out is not allowed for customers at this verification level. Please upgrade your account to use this service.";
            assertionValidation(sErrorMessage, ExpectedTxt);
            verifyElementPresent(MLWalletCashOutPage.objUpgradeNowBtn, getTextVal(MLWalletCashOutPage.objUpgradeNowBtn, "Button"));
            logger.info("WM_TC_27, CashOut ML Bank Buyer Tier Validated");
            ExtentReporter.extentLoggerPass("WM_TC_27", "WM_TC_27, CashOut ML Bank Buyer Tier Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashOutSemiVerifiedTier_WM_TC_28(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Withdraw Semi-Verified Tier Account");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            verifyElementPresent(MLWalletCashOutPage.objReferenceNumberCashOutBranch, getTextVal(MLWalletCashOutPage.objReferenceNumberCashOutBranch, "Reference NUmber"));
            verifyElementPresent(MLWalletCashOutPage.objTransactionNo, getTextVal(MLWalletCashOutPage.objTransactionNo, "Transaction Number"));
            logger.info("WM_TC_28, CashOut Withdraw Semi-Verified Tier Account Validated");
            ExtentReporter.extentLoggerPass("WM_TC_28", "WM_TC_28, CashOut Withdraw Semi-Verified Tier Account Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutFullyVerifiedTier_WM_TC_29(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Withdraw Semi-Verified Tier Account");
        mlWalletLogin(prop.getproperty("Fully_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            verifyElementPresent(MLWalletCashOutPage.objReferenceNumberCashOutBranch, getTextVal(MLWalletCashOutPage.objReferenceNumberCashOutBranch, "Reference NUmber"));
            verifyElementPresent(MLWalletCashOutPage.objTransactionNo, getTextVal(MLWalletCashOutPage.objTransactionNo, "Transaction Number"));
            logger.info("WM_TC_29, CashOut Withdraw Fully_Verified Tier Account Validated");
            ExtentReporter.extentLoggerPass("WM_TC_29", "WM_TC_29, CashOut Withdraw Fully_Verified Tier Account Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutMaxLimitSemiVerifiedTier_WM_TC_33() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Maximum Limit For Semi-verified Tier");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank("30000");
        if (verifyElementPresent(MLWalletCashOutPage.objMaxLimitUpgrade, getTextVal(MLWalletCashOutPage.objMaxLimitUpgrade, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashOutPage.objMaxLimitUpgrade);
            String sExpectedErrorMsg = "The maximum Bank Cash-out per transaction set for your verification level is P5,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(MLWalletCashOutPage.objUpgradeNowBtn, getTextVal(MLWalletCashOutPage.objUpgradeNowBtn, "Button"));
            logger.info("WM_TC_33, The Maximum Bank Cash-out per transaction Msg for Semi-verified tier Account is Validated");
            ExtentReporter.extentLoggerPass("WM_TC_33", "WM_TC_33, The Maximum Bank Cash-out per transaction Msg for Semi-verified tier Account is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutMaxLimitFullyVerifiedTier_WM_TC_36() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Maximum Limit For Fully-verified Tier");
        mlWalletLogin(prop.getproperty("Fully_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank("60000");
        if (verifyElementPresent(MLWalletCashOutPage.objBankMaxLimitTxt, getTextVal(MLWalletCashOutPage.objBankMaxLimitTxt, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashOutPage.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Bank Cash-out per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(MLWalletCashOutPage.objOkBtn, getTextVal(MLWalletCashOutPage.objOkBtn, "Button"));
            logger.info("WM_TC_36, The Maximum Bank Cash-out per transaction Msg for Fully-verified tier Account is Validated");
            ExtentReporter.extentLoggerPass("WM_TC_36", "WM_TC_36, The Maximum Bank Cash-out per transaction Msg for Fully-verified tier Account is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutWithDrawBankRequiredDetails_WM_TC_47() throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Bank Required Details Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Page"));
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objAccountNumberRequiredMsg, getTextVal(MLWalletCashOutPage.objAccountNumberRequiredMsg, "Error Message"))) {
            String sAccountNumberErrorMsg = getText(MLWalletCashOutPage.objAccountNumberRequiredMsg);
            String sExpectedMsg = "Account Number is required";
            assertionValidation(sAccountNumberErrorMsg, sExpectedMsg);
        }
        type(MLWalletCashOutPage.objAccountNumberField, prop.getproperty("AccountNumber"), "Account Number Text Field");
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objFirstNameRequiredMsg, getTextVal(MLWalletCashOutPage.objFirstNameRequiredMsg, "Error Message"))) {
            String sFirstNameErrorMsg = getText(MLWalletCashOutPage.objFirstNameRequiredMsg);
            String sExpectedMsg = "First name is required";
            assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
        }
        type(MLWalletCashOutPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objMiddleNameRequiredMsg, getTextVal(MLWalletCashOutPage.objMiddleNameRequiredMsg, "Error Message"))) {
            String sMiddleNameRequiredMsg = getText(MLWalletCashOutPage.objMiddleNameRequiredMsg);
            String sExpectedMsg = "Middle name is required";
            assertionValidation(sMiddleNameRequiredMsg, sExpectedMsg);
        }
        type(MLWalletCashOutPage.objMiddleName, prop.getproperty("Middle_Name"), "Account Holder Middle Name");
        verifyElementPresentAndClick(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objLastNameRequiredMsg, getTextVal(MLWalletCashOutPage.objLastNameRequiredMsg, "Error Message"))) {
            String sLastNameRequiredMsg = getText(MLWalletCashOutPage.objLastNameRequiredMsg);
            String sExpectedMsg = "Last name is required";
            assertionValidation(sLastNameRequiredMsg, sExpectedMsg);
        }
        type(MLWalletCashOutPage.objLastName, prop.getproperty("Last_Name"), "Account Holder Last Name");
        click(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objEmailAddressRequiredMsg, getTextVal(MLWalletCashOutPage.objEmailAddressRequiredMsg, "Error Message"))) {
            String sLastNameRequiredMsg = getText(MLWalletCashOutPage.objEmailAddressRequiredMsg);
            String sExpectedMsg = "Email address is required";
            assertionValidation(sLastNameRequiredMsg, sExpectedMsg);
        }
        type(MLWalletCashOutPage.objEmailAddress, prop.getproperty("Email"), "Account Holder Email Address");
        click(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objDragonPage, getTextVal(MLWalletCashOutPage.objDragonPage, "Page"))) {
            logger.info("WM_TC_47, Prompt msg for Bank Details data required is validated");
            ExtentReporter.extentLoggerPass("WM_TC_47", "WM_TC_47, Prompt msg for Bank Details data required is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutMiddleNameCheckBoxValidation_WM_TC_48() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank details Middle Name Check Box Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Page"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objCheckBox, "I legally do not have a middle name Check Box");
        if (verifyElementPresent(MLWalletCashOutPage.objMiddleName, "Middle Name input Field")) {
            String sMiddleNameFieldDisabled = getAttributValue("enabled", MLWalletCashOutPage.objMiddleName);
            assertionValidation("false", sMiddleNameFieldDisabled);
            logger.info("WM_TC_48, CashOut Bank Middle Name field is disabled After clicking on Check Box Validated");
            ExtentReporter.extentLoggerPass("WM_TC_48", "WM_TC_48, CashOut Bank Middle Name field is disabled After clicking on Check Box Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankPageUIValidation_WM_TC_49() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        if (verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objSavedBankAccount, getTextVal(MLWalletCashOutPage.objSavedBankAccount, "Header"));
            verifyElementPresent(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "Button"));
            verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Header"));
            verifyElementPresent(MLWalletCashOutPage.objBank, getTextVal(MLWalletCashOutPage.objBank, "Bank"));
            verifyElementPresent(MLWalletCashOutPage.objAccountNumberField, "Account Number Input Field");
            verifyElementPresent(MLWalletCashOutPage.objFirstname, "First Name Input Field");
            verifyElementPresent(MLWalletCashOutPage.objMiddleName, "Middle Name Input Field");
            verifyElementPresent(MLWalletCashOutPage.objCheckBox, "I legally do not have a middle name check Box");
            verifyElementPresent(MLWalletCashOutPage.objLastName, "Last Name Input field");
            verifyElementPresent(MLWalletCashOutPage.objEmailAddress, "Email Address Input field");
            Swipe("UP", 1);
            verifyElementPresent(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
            logger.info("WM_TC_49, CashOut Bank Page UI Validated");
            ExtentReporter.extentLoggerPass("WM_TC_49", "WM_TC_49, CashOut Bank Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutDragonPayPageUIValidation_WM_TC_50() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Dragon Pay Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        if (verifyElementPresent(MLWalletCashOutPage.objDragonPage, getTextVal(MLWalletCashOutPage.objDragonPage, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objBankCashOut, getTextVal(MLWalletCashOutPage.objBankCashOut, "Header"));
            verifyElementPresent(MLWalletCashOutPage.objAmountField, "Amount Input Field");
            verifyElementPresent(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
            logger.info("WM_TC_50, CashOut Dragon Pay Page UI Validated");
            ExtentReporter.extentLoggerPass("WM_TC_50", "WM_TC_50, CashOut Dragon Pay Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankReviewTransactionUIValidation_WM_TC_51(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Review Transaction UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
        Thread.sleep(3000);
        String sDragonPopUpMsg = getText(MLWalletCashOutPage.objDragonPayPopUpMsg);
        String sExpectedMsg = "Dragon Pay charges a fee of 35.00 pesos for this transaction. Do you wish to continue with your transaction?";
        assertionValidation(sDragonPopUpMsg, sExpectedMsg);
        click(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objReviewTransaction, getTextVal(MLWalletCashOutPage.objReviewTransaction, "page"))) {
            verifyElementPresent(MLWalletCashOutPage.objReceiverName, getTextVal(MLWalletCashOutPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletCashOutPage.objBankName, getTextVal(MLWalletCashOutPage.objBankName, "Bank Name"));
            verifyElementPresent(MLWalletCashOutPage.objAccountNumber, getTextVal(MLWalletCashOutPage.objAccountNumber, "Account Number"));
            verifyElementPresent(MLWalletCashOutPage.objAmount, getTextVal(MLWalletCashOutPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletCashOutPage.objServiceFee, getTextVal(MLWalletCashOutPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletCashOutPage.objTotalAmountDeduct, getTextVal(MLWalletCashOutPage.objTotalAmountDeduct, "Total Amount Deduct"));
            verifyElementPresent(MLWalletCashOutPage.objEmailAddressUpdated, getTextVal(MLWalletCashOutPage.objEmailAddressUpdated, "Email Address"));
            Swipe("UP", 2);
            verifyElementPresent(MLWalletCashInBank.objBankTransferCutOffTime, getTextVal(MLWalletCashInBank.objBankTransferCutOffTime, "Message"));
            String sBankTransferTime = getText(MLWalletCashInBank.objBankTransferCutOffTime);
            String sExpectedBankTransferTime = "Bank transfers after 1:00PM are posted on the next banking day.";
            assertionValidation(sBankTransferTime, sExpectedBankTransferTime);
            verifyElementPresent(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "button"));
            logger.info("WM_TC_51, CashOut Bank Review Transaction UI Validated");
            ExtentReporter.extentLoggerPass("WM_TC_51", "WM_TC_51, CashOut Bank Review Transaction UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionReceiptUIValidation_WM_TC_52() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Transaction Receipt UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank("100");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            verifyElementPresent(MLWalletCashOutPage.objReceiverNameInTransactionReceipt, getTextVal(MLWalletCashOutPage.objReceiverNameInTransactionReceipt, "Receiver's Name"));
            verifyElementPresent(MLWalletCashOutPage.objBankNamInTransactionReceipt, getTextVal(MLWalletCashOutPage.objBankNamInTransactionReceipt, "Bank Name"));
            verifyElementPresent(MLWalletCashOutPage.objAccountNumberInTransactionReceipt, getTextVal(MLWalletCashOutPage.objAccountNumberInTransactionReceipt, "Account Number"));
            verifyElementPresent(MLWalletCashOutPage.objPrincipalAmount, getTextVal(MLWalletCashOutPage.objPrincipalAmount, "Principal Amount"));
            verifyElementPresent(MLWalletCashOutPage.objServiceFeeInTransactionReceipt, getTextVal(MLWalletCashOutPage.objServiceFeeInTransactionReceipt, "Service Fee"));
            verifyElementPresent(MLWalletCashOutPage.objNetAmount, getTextVal(MLWalletCashOutPage.objNetAmount, "Net Amount"));
            verifyElementPresent(MLWalletCashOutPage.objEmailInTransactionReceipt, getTextVal(MLWalletCashOutPage.objEmailInTransactionReceipt, "Email"));
            Swipe("UP", 2);
            verifyElementPresent(MLWalletCashOutPage.objDate, getTextVal(MLWalletCashOutPage.objDate, "Date"));
            verifyElementPresent(MLWalletCashOutPage.objType, getTextVal(MLWalletCashOutPage.objType, "Type"));
            verifyElementPresent(MLWalletCashOutPage.objAddToSavedRecipients, getTextVal(MLWalletCashOutPage.objAddToSavedRecipients, "Header"));
            verifyElementPresent(MLWalletCashOutPage.objNickName, "Nick Name Input Field");
            verifyElementPresent(MLWalletCashOutPage.objSaveRecipientBtn, getTextVal(MLWalletCashOutPage.objSaveRecipientBtn, "Button"));
            verifyElementPresent(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            verifyElementPresent(MLWalletCashOutPage.objNewTransaction, getTextVal(MLWalletCashOutPage.objNewTransaction, "Button"));
            logger.info("WM_TC_52, CashOut Bank Transaction Receipt UI Validated");
            ExtentReporter.extentLoggerPass("WM_TC_52", "WM_TC_52, CashOut Bank Transaction Receipt UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutRecentTransactionDetailsUIValidation_WM_TC_53() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Recent Transaction Details UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank("100");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            scrollToVertical("Back To Home");
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionType, getTextVal(MLWalletTransactionHistoryPage.objTransactionType, "Payment Method"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objBank, getTextVal(MLWalletTransactionHistoryPage.objBank, "Bank"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objTotalCashOut, getTextVal(MLWalletTransactionHistoryPage.objTotalCashOut, "Total Cash Out"));
                logger.info("WM_TC_53, CashOut Recent Transaction Details UI Validated");
                ExtentReporter.extentLoggerPass("WM_TC_53", "WM_TC_53, CashOut Recent Transaction Details UI Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }
    public void cahOutBankViewAllPageBackBtnValidation_WM_TC_56() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank, View All Page Back Button Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "button"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBackBtn, "Back Button in ViewAll page");
        if (verifyElementPresent(MLWalletCashOutPage.objBankInformation, getTextVal(MLWalletCashOutPage.objBankInformation, "Page"))) {
            logger.info("WM_TC_56, CashOut Bank, View All Page Back Button Validated");
            ExtentReporter.extentLoggerPass("WM_TC_56", "WM_TC_56, CashOut Bank, View All Page Back Button Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankSavedRecipientEditBackButton_WM_TC_57() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Saved Recipient Edited changes are unsaved upon back navigation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "button"));
        waitTime(3000);
        verifyElementPresent(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, getTextVal(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, "Account Number in Saved Bank Account"));
        String sAccountNumberInSavedBankAccount = getText(MLWalletCashOutPage.objAccountNumberInSavedBankAccount);
        verifyElementPresentAndClick(MLWalletCashOutPage.objThreeDotMenuButton, "Three Dot menu Button");
        verifyElementPresentAndClick(MLWalletCashOutPage.objEditBtn, getTextVal(MLWalletCashOutPage.objEditBtn, "Button"));
        type(MLWalletCashOutPage.objAccountNumberInEditRecipient, prop.getproperty("EditedAccountNumber"), "Account Number In Edit Recipient");
        click(MLWalletCashOutPage.objEditRecipientBackBtn, "Edit Recipient Back Button");
        verifyElementPresent(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, getTextVal(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, "Account Number in Saved Bank Account"));
        String sAccountNumberAfterNavigatingBack = getText(MLWalletCashOutPage.objAccountNumberInSavedBankAccount);
        assertionValidation(sAccountNumberInSavedBankAccount, sAccountNumberAfterNavigatingBack);
        if (sAccountNumberInSavedBankAccount.equals(sAccountNumberAfterNavigatingBack)) {
            logger.info("WM_TC_57, CashOut Bank Saved Recipient Edited changes are unsaved upon back navigation validated");
            ExtentReporter.extentLoggerPass("WM_TC_57", "WM_TC_57, CashOut Bank Saved Recipient Edited changes are unsaved upon back navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankEditRecipient_WM_TC_58() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Edit Recipient");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "button"));
        waitTime(3000);
        verifyElementPresent(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, getTextVal(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, "Account Number in Saved Bank Account"));
        String sAccountNumberInSavedBankAccount = getText(MLWalletCashOutPage.objAccountNumberInSavedBankAccount);
        verifyElementPresentAndClick(MLWalletCashOutPage.objThreeDotMenuButton, "Three Dot menu Button");
        verifyElementPresentAndClick(MLWalletCashOutPage.objEditBtn, getTextVal(MLWalletCashOutPage.objEditBtn, "Button"));
        type(MLWalletCashOutPage.objAccountNumberInEditRecipient, prop.getproperty("EditedAccountNumber"), "Account Number In Edit Recipient");
        click(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objCheckBox, "Middle Name Check Box");
        click(MLWalletCashOutPage.objConfirmBtn, getTextVal(MLWalletCashOutPage.objConfirmBtn, "Button"));
        verifyElementPresentAndClick(MLWalletCashOutPage.BogusBank, getTextVal(MLWalletCashOutPage.BogusBank, "Bank"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "button"));
        waitTime(3000);
        verifyElementPresent(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, getTextVal(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, "Account Number in Saved Bank Account"));
        String sEditedAccountNumberInSavedBankAccount = getText(MLWalletCashOutPage.objAccountNumberInSavedBankAccount);
        assertNotEquals(sAccountNumberInSavedBankAccount, sEditedAccountNumberInSavedBankAccount);
        if (sAccountNumberInSavedBankAccount != sEditedAccountNumberInSavedBankAccount) {
            logger.info("WM_TC_58, CashOut/Withdraw Edit Recipient validated");
            ExtentReporter.extentLoggerPass("WM_TC_58", "WM_TC_58, CashOut/Withdraw Edit Recipient validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankDeleteRecipient_WM_TC_59() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Delete Recipient");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objViewAllBtn, getTextVal(MLWalletCashOutPage.objViewAllBtn, "button"));
        waitTime(3000);
        verifyElementPresent(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, getTextVal(MLWalletCashOutPage.objAccountNumberInSavedBankAccount, "Account Number in Saved Bank Account"));
        String sAccountNumberInSavedBankAccount = getText(MLWalletCashOutPage.objAccountNumberInSavedBankAccount);
        verifyElementPresentAndClick(MLWalletCashOutPage.objThreeDotMenuButton, "Three Dot menu Button");
        verifyElementPresentAndClick(MLWalletCashOutPage.objDeleteBtn, getTextVal(MLWalletCashOutPage.objDeleteBtn, "Button"));
        verifyElementNotPresent(MLWalletCashOutPage.objAccountNumber(sAccountNumberInSavedBankAccount), "Account Number", 5);
        logger.info("WM_TC_59, CashOut/Withdraw Delete Recipient validated");
        ExtentReporter.extentLoggerPass("WM_TC_59", "WM_TC_59, CashOut/Withdraw Delete Recipient validated");
        System.out.println("-----------------------------------------------------------");
    }
    public void cashOutBankBackHomeBtnValidation_WM_TC_62() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Bank, Back to Home Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank("100");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            scrollToVertical("Back To Home");
            verifyElementPresentAndClick(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
                logger.info("WM_TC_62, CashOut/Withdraw Bank, After Clicking on Back To Home Button, Application should navigate to Home Page is Validated");
                ExtentReporter.extentLoggerPass("WM_TC_62", "WM_TC_62, CashOut/Withdraw Bank, After Clicking on Back To Home Button, Application should navigate to Home Page is Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutBankNewTransactionBtnValidation_WM_TC_63() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Bank, New Transaction Button Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank("100");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            scrollToVertical("New Transaction");
            verifyElementPresentAndClick(MLWalletCashOutPage.objNewTransaction, getTextVal(MLWalletCashOutPage.objNewTransaction, "Button"));
            if (verifyElementPresent(MLWalletCashOutPage.objCashOutWithdraw, getTextVal(MLWalletCashOutPage.objCashOutWithdraw, "Page"))) {
                logger.info("WM_TC_63, CashOut/Withdraw Bank, After Clicking on New Transaction Button, Application should navigate to CashOut/WithDraw Page is Validated");
                ExtentReporter.extentLoggerPass("WM_TC_63", "WM_TC_63, CashOut/Withdraw Bank, After Clicking on New Transaction Button, Application should navigate to CashOut/WithDraw Page is Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutBankDragonPayMessageValidation_WM_TC_64(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/WithDraw Bank Dragon Pay Message Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        verifyElementPresent(MLWalletCashOutPage.objAmountField, "Bank Cash Out Amount Field");
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
        Thread.sleep(3000);
        if (verifyElementPresent(MLWalletCashOutPage.objDragonPayPopUpMsg, getTextVal(MLWalletCashOutPage.objDragonPayPopUpMsg, "Dragon Pay Message"))) {
            String sDragonPopUpMsg = getText(MLWalletCashOutPage.objDragonPayPopUpMsg);
            String sExpectedMsg = "Dragon Pay charges a fee of 35.00 pesos for this transaction. Do you wish to continue with your transaction?";
            assertionValidation(sDragonPopUpMsg, sExpectedMsg);
            logger.info("WM_TC_64, CashOut/WithDraw Bank Dragon Pay Message Validated");
            ExtentReporter.extentLoggerPass("WM_TC_64", "WM_TC_64, CashOut/WithDraw Bank Dragon Pay Message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankReviewTransactionTotalAmountValidation_WM_TC_65(String sAmount, int serviceFee) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Bank, Review Transaction Total Amount Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        verifyElementPresent(MLWalletCashOutPage.objAmountField, "Bank Cash Out Amount Field");
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
        Thread.sleep(3000);
        String sDragonPopUpMsg = getText(MLWalletCashOutPage.objDragonPayPopUpMsg);
        String sExpectedMsg = "Dragon Pay charges a fee of 35.00 pesos for this transaction. Do you wish to continue with your transaction?";
        assertionValidation(sDragonPopUpMsg, sExpectedMsg);
        click(MLWalletCashOutPage.objContinueBtn, getTextVal(MLWalletCashOutPage.objContinueBtn, "Button"));
        verifyElementPresent(MLWalletCashOutPage.objReviewTransaction, getTextVal(MLWalletCashOutPage.objReviewTransaction, "page"));
        verifyElementPresent(MLWalletCashOutPage.objTotalAmountDeduct, getTextVal(MLWalletCashOutPage.objTotalAmountDeduct, "Total Amount Deduct"));
        String sTotalAmountDeductWithPHP = getText(MLWalletCashOutPage.objTotalAmountDeduct);
        System.out.println(sTotalAmountDeductWithPHP);
        String sActualTotalAmountDeduct = sTotalAmountDeductWithPHP.substring(4, 7);
        logger.info("Actual Total Amount Deduct displayed : " + sActualTotalAmountDeduct);
        int nAmount = Integer.parseInt(sAmount);
        int nExceptedTotalAmountDeduct = nAmount + serviceFee;
        String sExceptedTotalAmount = Integer.toString(nExceptedTotalAmountDeduct);
        logger.info("Expected Total Amount Deduct : " + sExceptedTotalAmount);
        assertionValidation(sActualTotalAmountDeduct, sExceptedTotalAmount);
        if (sActualTotalAmountDeduct.equals(sExceptedTotalAmount)) {
            logger.info("WM_TC_65, CashOut/Withdraw Bank, Review Transaction Total Amount Validated");
            ExtentReporter.extentLoggerPass("WM_TC_65", "WM_TC_65, CashOut/Withdraw Bank, Review Transaction Total Amount Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankLocationPopupValidation_WM_TC_69(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Bank Location Popup Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpValidation();
            logger.info("WM_TC_69, CashOut/Withdraw Bank Location popup Validated");
            ExtentReporter.extentLoggerPass("WM_TC_69", "WM_TC_69, CashOut/Withdraw Bank Location popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankLocationDenyFunctionality_WM_TC_70(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Bank Location Deny Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        waitTime(3000);
        enterAmountBank(sAmount);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyPopUp();
            logger.info("WM_TC_70, CashOut/Withdraw Bank Location Deny Functionality Validated");
            ExtentReporter.extentLoggerPass("WM_TC_70", "WM_TC_70, CashOut/Withdraw Bank Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankLocationPermissionDenyCloseBtnFunctionality_WM_TC_71(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Bank Location Permission Deny Close Button Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        waitTime(3000);
        enterAmountBank(sAmount);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyCloseBtnFunctionality();
            if (verifyElementPresent(MLWalletCashOutPage.objDragonPage, getTextVal(MLWalletCashOutPage.objDragonPage, "Page"))) {
                logger.info("WM_TC_71, CashOut/Withdraw Bank Location Permission Deny Close Button Functionality Validated");
                ExtentReporter.extentLoggerPass("WM_TC_71", "WM_TC_71, CashOut/Withdraw Bank Location Permission Deny Close Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutBankLocationPermissionDenyOpenSettingsBtnFunctionality_WM_TC_72(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Bank Location Permission Deny open Settings Button Functionality Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        waitTime(3000);
        enterAmountBank(sAmount);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyOpenSettingsBtnFunctionality();
            if (verifyElementPresent(MLWalletCashOutPage.objAppInfo, getTextVal(MLWalletCashOutPage.objAppInfo, "Page"))) {
                logger.info("WM_TC_72, CashOut/Withdraw Bank Location Permission Deny Open Settings Button Functionality Validated");
                ExtentReporter.extentLoggerPass("WM_TC_72", "WM_TC_72, CashOut/Withdraw Bank Location Permission Deny Open Settings Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void cashOutBankLocationPopUpAllowFunctionality_WM_TC_73(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Location Bank popup Allow Button Functionality Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        waitTime(3000);
        enterAmountBank(sAmount);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpAllowFunctionality();
            waitTime(4000);
            if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
                logger.info("WM_TC_73, CashOut/Withdraw Bank Location popup Allow Button Functionality Validated");
                ExtentReporter.extentLoggerPass("WM_TC_73", "WM_TC_73, CashOut/Withdraw Bank Location popup Allow Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }
    public void cashOutBankInternetInterruptionWhileEnteringOTP_WM_TC_79(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Bank Internet Interruption While Entering OTP Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        waitTime(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        waitTime(6000);
        setWifiConnectionToONOFF("OFF");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"))) {
            internetConnectionError();
            logger.info("WM_TC_79,CashOut/Withdraw Bank Internet Interruption While Entering OTP Validated");
            ExtentReporter.extentLoggerPass("WM_TC_78", "WM_TC_78, CashOut/Withdraw Bank Internet Interruption While Entering OTP Validated");
            System.out.println("-----------------------------------------------------------");
        }
        setWifiConnectionToONOFF("ON");
    }
    public void cashOutBankTransactionValidationAfterMinimizingApp_WM_TC_83(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Bank Transaction Validation After Minimizing App");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"))) {
            logger.info("WM_TC_83, CashOut/Withdraw Bank Transaction Validation After Minimizing App Validated");
            ExtentReporter.extentLoggerPass("WM_TC_83", "WM_TC_83, CashOut/Withdraw Bank Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutBankAmountFieldValidation_WM_TC_97(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank, Amount Field with more than 2 decimals Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        verifyElementPresent(MLWalletCashOutPage.objAmountField, "Bank Cash Out Amount Field");
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objInvalidAmountMsg, getTextVal(MLWalletCashOutPage.objInvalidAmountMsg, "Pop Message"))) {
            String sMinimumTransactionPopupMsg = getText(MLWalletCashOutPage.objInvalidAmountMsg);
            String sExpectedPopupMsg = "The amount must be limited to 2 decimal places";
            assertionValidation(sMinimumTransactionPopupMsg, sExpectedPopupMsg);
            logger.info("WM_TC_97, CashOut Bank, Amount Field with more than 2 decimals Error Msg validated");
            ExtentReporter.extentLoggerPass("WM_TC_97", "WM_TC_97, CashOut Bank, Amount Field with more than 2 decimals Error Msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutBankTransactionWithValidMLPin_WM_TC_99(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Transaction With Valid ML Pin");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        handleMpin("1111");
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionReceipt, getTextVal(MLWalletCashOutPage.objTransactionReceipt, "Text"))) {
            verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"));
            String sTransactionSuccess = getText(MLWalletCashOutPage.objTransactionSuccessMessage);
            assertionValidation(sTransactionSuccess, "Transaction Successful");
            verifyElementPresent(MLWalletCashOutPage.objTransactionNo, getTextVal(MLWalletCashOutPage.objTransactionNo, "Transaction Number"));
            String sTransactionNumber = getText(MLWalletCashOutPage.objTransactionNo);
            System.out.println(sTransactionNumber);
            scrollToVertical("Back To Home");
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sTransactionNumber);
                logger.info("WM_TC_99, CashOut Bank Transaction With Valid ML Pin validated");
                ExtentReporter.extentLoggerPass("WM_TC_99", "WM_TC_99, CashOut Bank Transaction With Valid ML Pin validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }
    public void cashOutBankInAppOTPPopupValidation_WM_TC_119(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank InApp OTP Popup validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            logger.info("WM_TC_119, CashOut Bank InApp OTP Popup validated");
            ExtentReporter.extentLoggerPass("WM_TC_119", "WM_TC_119, CashOut Bank InApp OTP Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionInAppOTPPopupUIValidation_WM_TC_120(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Transaction InApp OTP Popup UI validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds, getTextVal(MLWalletLoginPage.objSeconds, "Seconds"));
            verifyElementPresent(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
            logger.info("WM_TC_120, CashOut Bank Transaction InApp OTP Popup UI validated");
            ExtentReporter.extentLoggerPass("WM_TC_120", "WM_TC_120, CashOut Bank Transaction InApp OTP Popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionNewOTPAfterSixtySecondsValidation_WM_TC_121(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Transaction New OTP got generated After Sixty Seconds validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if (verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"))) {
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP, sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("WM_TC_121, CashOut Bank Transaction New OTP got generated After Sixty Seconds is validated");
            ExtentReporter.extentLoggerPass("WM_TC_121", "WM_TC_121, CashOut Bank Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionOTPCancelBtnFunctionality_WM_TC_122(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Transaction OTP Cancel Button Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objReviewTransaction, getTextVal(MLWalletCashOutPage.objReviewTransaction, "Page"))) {
            logger.info("WM_TC_122, CashOut Bank Transaction, After clicking on Cancel in One time pin popup App navigates back to Review Transaction Page is validated");
            ExtentReporter.extentLoggerPass("WM_TC_122", "WM_TC_122, CashOut Bank Transaction, After clicking on Cancel in One time pin popup App navigates back to Review Transaction is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Transaction OTP Continue Button Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objTransactionSuccessMessage, getTextVal(MLWalletCashOutPage.objTransactionSuccessMessage, "Message"))) {
            logger.info("WM_TC_123, CashOut Bank Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            ExtentReporter.extentLoggerPass("WM_TC_123", "WM_TC_123, CashOut Bank Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


}
