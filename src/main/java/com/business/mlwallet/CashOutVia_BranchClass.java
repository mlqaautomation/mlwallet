package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.mlwallet.pages.MLWalletCashOutPage;
import com.mlwallet.pages.MLWalletHomePage;
import com.mlwallet.pages.MLWalletLoginPage;
import com.mlwallet.pages.MLWalletTransactionHistoryPage;
import com.utility.ExtentReporter;

import java.time.Duration;

import static com.utility.Utilities.*;
import static com.utility.Utilities.assertionValidation;

public class CashOutVia_BranchClass extends BaseClass {

    public CashOutVia_BranchClass(String Application, String deviceName, String portno) throws InterruptedException{
        super(Application, deviceName, portno);
    }
    public void cashOutWithdrawBranch_WM_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Withdraw Branch");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objCreatedDate, getTextVal(MLWalletCashOutPage.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashOutPage.objReferenceNumber, getTextVal(MLWalletCashOutPage.objReferenceNumber, "Reference Number"));
            String nReference = getText(MLWalletCashOutPage.objReferenceNumber);
            System.out.println(nReference);
            String sReferenceNumber = nReference.substring(5, 16);
            System.out.println(sReferenceNumber);
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sReferenceNumber);
                logger.info("Reference Number is matching with recent Transaction");
                logger.info("WM_TC_05, Successfully Withdraw Money to ML Branch");
                ExtentReporter.extentLoggerPass("WM_TC_05", "WM_TC_05, Successfully Withdraw Money to ML Branch");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutMaxLimit_WM_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Withdraw Branch");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("100000");
        if (verifyElementPresent(MLWalletCashOutPage.objMaxLimitTxt, getTextVal(MLWalletCashOutPage.objMaxLimitTxt, "Text Message"))) {
            String sMaxLimitTxt = getText(MLWalletCashOutPage.objMaxLimitTxt);
            String ExpectedTxt = "The maximum Branch Cash-out per transaction set for your verification level is P40,000.00. Please try again.";
            assertionValidation(sMaxLimitTxt, ExpectedTxt);
            logger.info("WM_TC_06, The supplied amount us less than the required minimum transaction limit. Error Message is Validated");
            ExtentReporter.extentLoggerPass("WM_TC_06", "WM_TC_06, The supplied amount us less than the required minimum transaction limit. Error Message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutInsufficientBalance_WM_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Insufficient Balance");
        mlWalletLogin("9999999997");
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("35000");
        if (verifyElementPresent(MLWalletCashOutPage.objInsufficientBalance, getTextVal(MLWalletCashOutPage.objInsufficientBalance, "Text Message"))) {
            String sInsufficientBalancePopupTxt = getText(MLWalletCashOutPage.objInsufficientBalance);
            String ExpectedTxt = "There is insufficient balance to proceed with this transaction. Please try again.";
            assertionValidation(sInsufficientBalancePopupTxt, ExpectedTxt);
            logger.info("WM_TC_07, Insufficient Balance pop up validated");
            ExtentReporter.extentLoggerPass("WM_TC_07", "WM_TC_07, Insufficient Balance pop up validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBranchMaximumTransactionBranchVerifiedTier_WM_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Branch Maximum Transaction Branch Verified Tier");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("50001");
        if (verifyElementPresent(MLWalletCashOutPage.objMaxLimitTxt, getTextVal(MLWalletCashOutPage.objMaxLimitTxt, "Text Message"))) {
            String sInsufficientBalancePopupTxt = getText(MLWalletCashOutPage.objMaxLimitTxt);
            String ExpectedTxt = "The maximum Branch Cash-out per transaction set for your verification level is P40,000.00. Please try again.";
            assertionValidation(sInsufficientBalancePopupTxt, ExpectedTxt);
            logger.info("WM_TC_08, The Maximum Branch Cash-out per transaction Msg for Branch-verified tier Account is Validated");
            ExtentReporter.extentLoggerPass("WM_TC_08", "WM_TC_08, The Maximum Branch Cash-out per transaction Msg for Branch-verified tier Account is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBuyerTierLevelAcc_WM_TC_09() throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Withdraw Branch");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("100");
        if (verifyElementPresent(MLWalletCashOutPage.objMaxLimitUpgrade, getTextVal(MLWalletCashOutPage.objMaxLimitUpgrade, "Text Message"))) {
            String sErrorMessage = getText(MLWalletCashOutPage.objMaxLimitUpgrade);
            String ExpectedTxt = "Branch Cash-out is not allowed for customers at this verification level. Please upgrade your account to use this service.";
            assertionValidation(sErrorMessage, ExpectedTxt);
            logger.info("WM_TC_09, Branch Cash-out is not allowed for customers at this verification level. Error Message is Validated");
            ExtentReporter.extentLoggerPass("WM_TC_09", "WM_TC_08, Branch Cash-out is not allowed for customers at this verification level. Error Message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
//=================================== Cash Out Phase2==================================================//
public void cashOutUIValidation_WM_TC_16() throws Exception {
    ExtentReporter.HeaderChildNode("Cash Out Page UI Validation");
    mlWalletLogin(prop.getproperty("Branch_Verified"));
    verifyElementPresentAndClick(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
    if (verifyElementPresent(MLWalletCashOutPage.objCashOutWithdraw, getTextVal(MLWalletCashOutPage.objCashOutWithdraw, "Page"))) {
        verifyElementPresent(MLWalletCashOutPage.objCashOutOptions, getTextVal(MLWalletCashOutPage.objCashOutOptions, "Header"));
        verifyElementPresent(MLWalletCashOutPage.objToAnyBank, getTextVal(MLWalletCashOutPage.objToAnyBank, "Option"));
        verifyElementPresent(MLWalletCashOutPage.objToAnyMLBranch, getTextVal(MLWalletCashOutPage.objToAnyMLBranch, "Option"));
        verifyElementPresent(MLWalletCashOutPage.objCashOutOngoingTransaction, getTextVal(MLWalletCashOutPage.objCashOutOngoingTransaction, "Header"));
        logger.info("WM_TC_16, Cash Out Page UI Validation");
        ExtentReporter.extentLoggerPass("WM_TC_16", "WM_TC_16, Cash Out Page UI Validation");
        System.out.println("-----------------------------------------------------------");
    }
}

    public void cashOutWithdrawBackBtnValidation_WM_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Page back arrow Button Validation");
        cashOutUIValidation_WM_TC_16();
        click(MLWalletCashOutPage.cashOutBackArrowBtn, "Cash Out Page Back Arrow Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("WM_TC_17, Cash Out Page back arrow Button Validation");
            ExtentReporter.extentLoggerPass("WM_TC_17", "WM_TC_17, Cash Out Page back arrow Button Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutToBranchUIValidation_WM_TC_18() throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out To Branch UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        verifyElementPresentAndClick(MLWalletCashOutPage.objToAnyMLBranch, getTextVal(MLWalletCashOutPage.objToAnyMLBranch, "Button"));
        waitTime(6000);
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutPage, getTextVal(MLWalletCashOutPage.objCashOutPage, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.ObjCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Header"));
            verifyElementPresent(MLWalletCashOutPage.objUserName, getTextVal(MLWalletCashOutPage.objUserName, "User Name"));
            verifyElementPresent(MLWalletCashOutPage.objUserMobileNumber, getTextVal(MLWalletCashOutPage.objUserMobileNumber, "User Mobile Number"));
            verifyElementPresent(MLWalletCashOutPage.objMLWalletBalance, getTextVal(MLWalletCashOutPage.objMLWalletBalance, "Balance"));
            verifyElementPresent(MLWalletCashOutPage.objCashOutInstructions, "Instructions Icon");
            logger.info("WM_TC_18, Cash Out to Branch Page Validation");
            ExtentReporter.extentLoggerPass("WM_TC_18", "WM_TC_18, Cash Out to Branch Page Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutToBranchBackBtnValidation_WM_TC_19() throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out To Branch Page back arrow Button Validation");
        cashOutToBranchUIValidation_WM_TC_18();
        click(MLWalletCashOutPage.objCashOutToBranchBackBtn, "Cash Out Page Back Arrow Button");
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutWithdraw, getTextVal(MLWalletCashOutPage.objCashOutWithdraw, "Page"))) {
            logger.info("WM_TC_19, Cash Out To Branch Page back arrow Button Validation");
            ExtentReporter.extentLoggerPass("WM_TC_19", "WM_TC_19, Cash Out To Branch Page back arrow Button Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutMlBranchQRPageUIValidation_WM_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut ML Branch QR Code Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objCreatedDate, getTextVal(MLWalletCashOutPage.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashOutPage.objReferenceNumber, getTextVal(MLWalletCashOutPage.objReferenceNumber, "Reference Number"));
            verifyElementPresent(MLWalletCashOutPage.objPHP, getTextVal(MLWalletCashOutPage.objPHP, "Amount"));
            verifyElementPresent(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            verifyElementPresent(MLWalletCashOutPage.objNewTransaction, getTextVal(MLWalletCashOutPage.objNewTransaction, "Button"));
            logger.info("WM_TC_22, CashOut ML Branch QR Code Page UI Validation");
            ExtentReporter.extentLoggerPass("WM_TC_22", "WM_TC_22, CashOut ML Branch QR Code Page UI Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutCancelIconValidation_WM_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Cash Out Cancel Icon Validation");
        cashOutMlBranchQRPageUIValidation_WM_TC_22();
        verifyElementPresentAndClick(MLWalletCashOutPage.objCancelIcon, "Cancel Icon");
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("WM_TC_23, Cash Out Cancel Icon Validated");
            ExtentReporter.extentLoggerPass("WM_TC_23", "WM_TC_23, Cash Out Cancel Icon Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutMLBranchSemiVerifiedTier_WM_TC_31() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Branch Semi-Verified Tier");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objCreatedDate, getTextVal(MLWalletCashOutPage.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashOutPage.objReferenceNumber, getTextVal(MLWalletCashOutPage.objReferenceNumber, "Reference Number"));
            String nReference = getText(MLWalletCashOutPage.objReferenceNumber);
            System.out.println(nReference);
            String sReferenceNumber = nReference.substring(5, 16);
            System.out.println(sReferenceNumber);
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sReferenceNumber);
                logger.info("Reference Number is matching with recent Transaction");
                logger.info("WM_TC_31, Successfully Withdraw Money to ML Branch for Semi-verified Tier Account");
                ExtentReporter.extentLoggerPass("WM_TC_31", "WM_TC_31, Successfully Withdraw Money to ML Branch for Semi-verified Tier Account");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void cashOutMLBranchFullyVerifiedTier_WM_TC_32() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Branch Fully-Verified Tier");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objCreatedDate, getTextVal(MLWalletCashOutPage.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashOutPage.objReferenceNumber, getTextVal(MLWalletCashOutPage.objReferenceNumber, "Reference Number"));
            String nReference = getText(MLWalletCashOutPage.objReferenceNumber);
            System.out.println(nReference);
            String sReferenceNumber = nReference.substring(5, 16);
            System.out.println(sReferenceNumber);
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sReferenceNumber);
                logger.info("Reference Number is matching with recent Transaction");
                logger.info("WM_TC_32, Successfully Withdraw Money to ML Branch for Fully-Verified Tier Account");
                ExtentReporter.extentLoggerPass("WM_TC_32", "WM_TC_32, Successfully Withdraw Money to ML Branch for Fully-Verified Tier Account");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }
    public void cashOutMLBranchMaxLimitSemiVerifiedTier_WM_TC_39() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut ML Branch Maximum Limit For Semi-verified Tier");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("20000");
        if (verifyElementPresent(MLWalletCashOutPage.objMaxLimitUpgrade, getTextVal(MLWalletCashOutPage.objMaxLimitUpgrade, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashOutPage.objMaxLimitUpgrade);
            String sExpectedErrorMsg = "The maximum Branch Cash-out per transaction set for your verification level is P5,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(MLWalletCashOutPage.objUpgradeNowBtn, getTextVal(MLWalletCashOutPage.objUpgradeNowBtn, "Button"));
            logger.info("WM_TC_39, The Maximum Branch Cash-out per transaction Msg for Semi-verified tier Account is Validated");
            ExtentReporter.extentLoggerPass("WM_TC_39", "WM_TC_39, The Maximum Bank Cash-out per transaction Msg for Semi-verified tier Account is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashOutMLBranchMaxLimitFullyVerifiedTier_WM_TC_42() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut ML Branch Maximum Limit For Fully-verified Tier");
        mlWalletLogin(prop.getproperty("Fully_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("60000");
        if (verifyElementPresent(MLWalletCashOutPage.objBankMaxLimitTxt, getTextVal(MLWalletCashOutPage.objBankMaxLimitTxt, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashOutPage.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Branch Cash-out per transaction set for your verification level is P40,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(MLWalletCashOutPage.objOkBtn, getTextVal(MLWalletCashOutPage.objOkBtn, "Button"));
            logger.info("WM_TC_42, The Maximum Branch Cash-out per transaction Msg for Fully-verified tier Account is Validated");
            ExtentReporter.extentLoggerPass("WM_TC_42", "WM_TC_42, The Maximum Bank Cash-out per transaction Msg for Fully-verified tier Account is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutMLBranchBackToHomeBtnValidation_WM_TC_54() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut ML Branch Back To Home Button Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"));
        verifyElementPresent(MLWalletCashOutPage.objCreatedDate, getTextVal(MLWalletCashOutPage.objCreatedDate, "Date"));
        verifyElementPresent(MLWalletCashOutPage.objReferenceNumber, getTextVal(MLWalletCashOutPage.objReferenceNumber, "Reference Number"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("WM_TC_54, CashOut ML Branch, After Clicking On Back To Home Button Application Navigated to Home page Validated");
            ExtentReporter.extentLoggerPass("WM_TC_54", "WM_TC_54, CashOut ML Branch, After Clicking On Back To Home Button Application Navigated to Home page Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutMLBranchNewTransactionBtnValidation_WM_TC_55() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut ML Branch New Transaction Button Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"));
        verifyElementPresent(MLWalletCashOutPage.objCreatedDate, getTextVal(MLWalletCashOutPage.objCreatedDate, "Date"));
        verifyElementPresent(MLWalletCashOutPage.objReferenceNumber, getTextVal(MLWalletCashOutPage.objReferenceNumber, "Reference Number"));
        verifyElementPresentAndClick(MLWalletCashOutPage.objNewTransaction, getTextVal(MLWalletCashOutPage.objNewTransaction, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutWithdraw, getTextVal(MLWalletCashOutPage.objCashOutWithdraw, "Page"))) {
            logger.info("WM_TC_55, CashOut ML Branch, After Clicking On New Transaction Button Application Navigated to CashOut/WithDraw Page Validated");
            ExtentReporter.extentLoggerPass("WM_TC_55", "WM_TC_55, CashOut ML Branch, After Clicking On New Transaction Button Application Navigated to CashOut/WithDraw Page Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutMLBranchOTPPageUiValidation_WM_TC_60() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/WithDraw ML Branch OTP Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
//			verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
            verifyElementPresent(MLWalletCashOutPage.objResendCode, getTextVal(MLWalletCashOutPage.objResendCode, "Seconds"));
            logger.info("WM_TC_60, CashOut/WithDraw ML Branch OTP Page UI Validated");
            ExtentReporter.extentLoggerPass("WM_TC_60", "WM_TC_20, CashOut/WithDraw ML Branch OTP Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutMLBranchTransactionDetailsUIValidation_WM_TC_61() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/WithDraw ML Branch Transaction Details UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objCreatedDate, getTextVal(MLWalletCashOutPage.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashOutPage.objReferenceNumber, getTextVal(MLWalletCashOutPage.objReferenceNumber, "Reference Number"));
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
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
                verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objTotalCashOut, getTextVal(MLWalletTransactionHistoryPage.objTotalCashOut, "Total Cash Out"));
                logger.info("WM_TC_61, CashOut/WithDraw ML Branch Transaction Details UI Validated");
                ExtentReporter.extentLoggerPass("WM_TC_61", "WM_TC_61, CashOut/WithDraw ML Branch Transaction Details UI Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }
    public void cashOutBranchLocationPopupValidation_WM_TC_74(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Branch Location Popup Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch(sAmount);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpValidation();
            logger.info("WM_TC_74, CashOut/Withdraw Branch Location popup Validated");
            ExtentReporter.extentLoggerPass("WM_TC_74", "WM_TC_74, CashOut/Withdraw Branch Location popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashOutBranchLocationDenyFunctionality_WM_TC_75(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Branch Location Deny Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch(sAmount);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyPopUp();
            logger.info("WM_TC_75, CashOut/Withdraw Branch Location Deny Functionality Validated");
            ExtentReporter.extentLoggerPass("WM_TC_75", "WM_TC_75, CashOut/Withdraw Branch Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashOutBranchLocationPermissionDenyCloseBtnFunctionality_WM_TC_76(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Branch Location Permission Deny Close Button Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch(sAmount);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyCloseBtnFunctionality();
            if (verifyElementPresent(MLWalletCashOutPage.objCashOutWithdraw, getTextVal(MLWalletCashOutPage.objCashOutWithdraw, "Page"))) {
                logger.info("WM_TC_76, CashOut/Withdraw Branch Location Permission Deny Close Button Functionality Validated");
                ExtentReporter.extentLoggerPass("WM_TC_76", "WM_TC_76, CashOut/Withdraw Branch Location Permission Deny Close Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutBranchLocationPermissionDenyOpenSettingsBtnFunctionality_WM_TC_77(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Branch Location Permission Deny open Settings Button Functionality Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch(sAmount);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyOpenSettingsBtnFunctionality();
            if (verifyElementPresent(MLWalletCashOutPage.objAppInfo, getTextVal(MLWalletCashOutPage.objAppInfo, "Page"))) {
                logger.info("WM_TC_77, CashOut/Withdraw Branch Location Permission Deny Open Settings Button Functionality Validated");
                ExtentReporter.extentLoggerPass("WM_TC_77", "WM_TC_77, CashOut/Withdraw Branch Location Permission Deny Open Settings Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void cashOutBranchLocationPopUpAllowFunctionality_WM_TC_78(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Branch Location popup Allow Button Functionality Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch(sAmount);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpAllowFunctionality();
            waitTime(4000);
            if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
                logger.info("WM_TC_78, CashOut/Withdraw Branch Location popup Allow Button Functionality Validated");
                ExtentReporter.extentLoggerPass("WM_TC_78", "WM_TC_78, CashOut/Withdraw Branch Location popup Allow Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }
    public void cashOutBranchInternetInterruptionWhileEnteringOTP_WM_TC_80(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Branch Internet Interruption While Entering OTP Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch(sAmount);
        enableLocation_PopUp();
        waitTime(6000);
        setWifiConnectionToONOFF("OFF");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"))) {
            internetConnectionError();
            logger.info("WM_TC_80,CashOut/Withdraw Branch Internet Interruption While Entering OTP Validated");
            ExtentReporter.extentLoggerPass("WM_TC_80", "WM_TC_80, CashOut/Withdraw Branch Internet Interruption While Entering OTP Validated");
            System.out.println("-----------------------------------------------------------");
        }
        setWifiConnectionToONOFF("ON");
    }
    public void cashOutBranchTransactionValidationAfterMinimizingApp_WM_TC_91() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut/Withdraw Branch Transaction Validation After Minimizing App");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"))) {
            logger.info("WM_TC_91, CashOut/Withdraw Branch Transaction Validation After Minimizing App Validated");
            ExtentReporter.extentLoggerPass("WM_TC_91", "WM_TC_91, CashOut/Withdraw Branch Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutBranchAmountFieldValidation_WM_TC_98(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Branch, Amount Field with more than 2 decimals Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        verifyElementPresent(MLWalletCashOutPage.objToAnyMLBranch, getTextVal(MLWalletCashOutPage.objToAnyMLBranch, "Button"));
        click(MLWalletCashOutPage.objToAnyMLBranch, getTextVal(MLWalletCashOutPage.objToAnyMLBranch, "Button"));
        verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"));
        type(MLWalletCashOutPage.objAmountField, sAmount, "Amount to Send");
        click(MLWalletCashOutPage.objNextBtn, getTextVal(MLWalletCashOutPage.objNextBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objInvalidAmountMsg, getTextVal(MLWalletCashOutPage.objInvalidAmountMsg, "Pop Message"))) {
            String sMinimumTransactionPopupMsg = getText(MLWalletCashOutPage.objInvalidAmountMsg);
            String sExpectedPopupMsg = "The amount must be limited to 2 decimal places";
            assertionValidation(sMinimumTransactionPopupMsg, sExpectedPopupMsg);
            logger.info("WM_TC_98, CashOut Branch, Amount Field with more than 2 decimals Error Msg validated");
            ExtentReporter.extentLoggerPass("WM_TC_98", "WM_TC_98, CashOut Branch, Amount Field with more than 2 decimals Error Msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void cashOutBranchTransactionWithInValidMLPin_WM_TC_100(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Bank Transaction With Invalid ML Pin");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        cashOutSelectBank(prop.getproperty("Valid_BankName"));
        enterBankDetails(prop.getproperty("AccountNumber"));
        Thread.sleep(3000);
        enterAmountBank(sAmount);
        enableLocation_PopUp();
        handleMpin("1234");
        if (verifyElementPresent(MLWalletCashOutPage.objInvalidPINMsg, getTextVal(MLWalletCashOutPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletCashOutPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("WM_TC_100, CashOut Bank Transaction With Invalid ML Pin validated");
            ExtentReporter.extentLoggerPass("WM_TC_100", "WM_TC_100, CashOut Bank Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBranchTransactionWithValidMLPin_WM_TC_106() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Branch Transaction With Invalid ML Pin");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        handleMpin("1111");
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"))) {
            verifyElementPresent(MLWalletCashOutPage.objCreatedDate, getTextVal(MLWalletCashOutPage.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashOutPage.objReferenceNumber, getTextVal(MLWalletCashOutPage.objReferenceNumber, "Reference Number"));
            String nReference = getText(MLWalletCashOutPage.objReferenceNumber);
            System.out.println(nReference);
            String sReferenceNumber = nReference.substring(5, 16);
            System.out.println(sReferenceNumber);
            click(MLWalletCashOutPage.objBackToHomeBtn, getTextVal(MLWalletCashOutPage.objBackToHomeBtn, "Button"));
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objCashOutButton, getTextVal(MLWalletHomePage.objCashOutButton, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sReferenceNumber);
                logger.info("Reference Number is matching with recent Transaction");
                logger.info("WM_TC_106, CashOut Branch Transaction With valid ML Pin validated");
                ExtentReporter.extentLoggerPass("WM_TC_106", "WM_TC_106, CashOut Branch Transaction With valid ML Pin validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashOutBranchTransactionWithInValidMLPin_WM_TC_107() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Branch Transaction With Invalid ML Pin");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        handleMpin("1234");
        if (verifyElementPresent(MLWalletCashOutPage.objInvalidPINMsg, getTextVal(MLWalletCashOutPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletCashOutPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("WM_TC_107, CashOut Bank Transaction With Invalid ML Pin validated");
            ExtentReporter.extentLoggerPass("WM_TC_107", "WM_TC_107, CashOut Bank Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBranchInAppOTPPopupValidation_WM_TC_113() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Branch InApp OTP Popup validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            logger.info("WM_TC_113, CashOut Branch InApp OTP Popup validated");
            ExtentReporter.extentLoggerPass("WM_TC_113", "WM_TC_113, CashOut Branch InApp OTP Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBranchTransactionInAppOTPPopupUIValidation_WM_TC_114() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Branch Transaction InApp OTP Popup UI validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds, getTextVal(MLWalletLoginPage.objSeconds, "Seconds"));
            verifyElementPresent(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
            logger.info("WM_TC_114, CashOut Branch Transaction InApp OTP Popup UI validated");
            ExtentReporter.extentLoggerPass("WM_TC_114", "WM_TC_114, CashOut Branch Transaction InApp OTP Popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBranchTransactionNewOTPAfterSixtySecondsValidation_WM_TC_115() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Branch Transaction New OTP got generated After Sixty Seconds validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if (verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"))) {
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP, sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("WM_TC_115, CashOut Branch Transaction New OTP got generated After Sixty Seconds is validated");
            ExtentReporter.extentLoggerPass("WM_TC_115", "WM_TC_115, CashOut Branch Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBranchTransactionOTPCancelBtnFunctionality_WM_TC_116() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Branch Transaction OTP Cancel Button Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"))) {
            logger.info("WM_TC_116, CashOut Branch Transaction, After clicking on Cancel in One time pin popup App navigates back to Cash Out To Branch Page is validated");
            ExtentReporter.extentLoggerPass("WM_TC_116", "WM_TC_116, CashOut Branch Transaction, After clicking on Cancel in One time pin popup App navigates back to Cash Out To Branch Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashOutBranchTransactionOTPContinueBtnFunctionality_WM_TC_117() throws Exception {
        ExtentReporter.HeaderChildNode("CashOut Branch Transaction OTP Continue Button Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(MLWalletCashOutPage.objCashOut, "CashOut / Withdraw Button");
        enterAmountMLBranch("10");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        if (verifyElementPresent(MLWalletCashOutPage.objCashOutToBranch, getTextVal(MLWalletCashOutPage.objCashOutToBranch, "Page"))) {
            logger.info("WM_TC_117, CashOut Branch Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            ExtentReporter.extentLoggerPass("WM_TC_117", "WM_TC_117, CashOut Branch Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


}
