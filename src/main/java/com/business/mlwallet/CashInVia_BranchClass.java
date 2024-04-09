package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.mlwallet.pages.*;
import com.utility.ExtentReporter;

import java.time.Duration;

import static com.utility.Utilities.*;

public class CashInVia_BranchClass extends BaseClass{

    public CashInVia_BranchClass() throws InterruptedException{
        super();
    }

    public void cashInviaBranch_ValidAmount_Scenario_CIBR_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("ML_Wallet_Cash_In_Via_Barnch_ValidAmount_Scenario");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"))) {
            verifyElementPresent(MLWalletCashInViaBranch.objPHP, getTextVal(MLWalletCashInViaBranch.objPHP, "PHP"));
            verifyElementPresent(MLWalletCashInViaBranch.objCreatedDate, getTextVal(MLWalletCashInViaBranch.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashInViaBranch.objStatus, getTextVal(MLWalletCashInViaBranch.objStatus, "Status"));
            verifyElementPresent(MLWalletCashInViaBranch.objTransactionNo, getTextVal(MLWalletCashInViaBranch.objTransactionNo, "Transaction Number"));
            verifyElementPresentAndClick(MLWalletCashInViaBranch.objCrossBtn, "Cash In Branch Cross Button");
            Swipe("DOWN", 1);
            Swipe("UP", 1);
            if (verifyElementPresent(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"))) {
                logger.info("'CIBR_TC_01', To validate valid Amount in Cash In ML Branch ");
                ExtentReporter.extentLoggerPass("'CIBR_TC_01", "'CIBR_TC_01', To validate valid Amount in Cash In ML Branch ");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBranchCancelTransactionScenario_CIBR_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("ML Wallet Cash In Via Branch Cancel Transaction Scenario");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        waitTime(2000);
        cashInViaBranchEnterAmount("100");
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCancelTransactionBtn, getTextVal(MLWalletCashInViaBranch.objCancelTransactionBtn, "Button"));
        verifyElementPresent(MLWalletCashInViaBranch.objCancelTransactionPopup, getTextVal(MLWalletCashInViaBranch.objCancelTransactionPopup, "PopUp"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCancelTransactionBtn, getTextVal(MLWalletCashInViaBranch.objCancelTransactionBtn, "Button"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objBackToHomeBtn, getTextVal(MLWalletCashInViaBranch.objBackToHomeBtn, "Button"));
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        if (verifyElementPresent(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"))) {
            verifyElementPresent(MLWalletCashInBank.objCancelled, getTextVal(MLWalletCashInBank.objCancelled, "Status"));
            logger.info("'CIBR_TC_02', To validate Cancel Transaction in Cash In ML Branch");
            ExtentReporter.extentLoggerPass("'CIBR_TC_02", "'CIBR_TC_02', To validate Cancel Transaction in Cash In ML Branch");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInviaBranch_Invalid_Amount_CIBR_TC_03() throws Exception {
        ExtentReporter.HeaderChildNode("ML Wallet Cash In via Branch Invalid Amount");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("0");
        if (verifyElementPresent(MLWalletCashInViaBranch.objInvalidAmountMsg, getTextVal(MLWalletCashInViaBranch.objInvalidAmountMsg, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(MLWalletCashInViaBranch.objInvalidAmountMsg);
            String sExpectedErrorMsg = "The amount should not be less than 1";
            assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
            logger.info("'CIBR_TC_03', 'CIBR_TC_03' To validate Invalid Amount");
            ExtentReporter.extentLoggerPass("CIBR_TC_03", "'CIBR_TC_03', To validate Invalid Amount");
        }
    }


    public void cashInViaBranch_Maximum_Limit_Amount_CIBR_TC_04() throws Exception {
        ExtentReporter.HeaderChildNode("ML Wallet Cash In via Branch Maximum Limit Amount");
        maxTransactionLimitValidation(prop.getproperty("Branch_Verified"));
        if (verifyElementPresent(MLWalletCashInViaBranch.objBankMaxLimitTxt, getTextVal(MLWalletCashInViaBranch.objBankMaxLimitTxt, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInViaBranch.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Branch Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("'CIBR_TC_04', ML Wallet Cash In via Branch Maximum Limit Amount Validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_04", "'CIBR_TC_04', ML Wallet Cash In via Branch Maximum Limit Amount Validated");
        }
    }


    public void cashInViaBRanchInvalidAmount_CIBR_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("ML Wallet Cash In via Branch Empty Amount Field Validation ");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("");
        if (verifyElementPresent(MLWalletCashInViaBranch.objInvalidAmountMsg, getTextVal(MLWalletCashInViaBranch.objInvalidAmountMsg, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(MLWalletCashInViaBranch.objInvalidAmountMsg);
            String sExpectedErrorMsg = "Amount is required";
            assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
            logger.info("CIBR_TC_05, Amount is required - Error Message is validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_05", "CIBR_TC_05, Amount is required - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchUIValidation_CIBR_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch UI Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        waitTime(5000);
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInMenu, getTextVal(MLWalletCashInViaBranch.objCashInMenu, "Page"))) {
            verifyElementPresent(MLWalletCashInViaBranch.objBranchCashIn, getTextVal(MLWalletCashInViaBranch.objBranchCashIn, "Header"));
            verifyElementPresent(MLWalletCashInViaBranch.objUserName, getTextVal(MLWalletCashInViaBranch.objUserName, "User Name"));
            verifyElementPresent(MLWalletCashInViaBranch.objUserNumber, getTextVal(MLWalletCashInViaBranch.objUserNumber, "User Number"));
            verifyElementPresent(MLWalletCashInViaBranch.objAmountTextField, "Amount Input Field");
            verifyElementPresent(MLWalletCashInViaBranch.objNextButton, "Next Button");
            logger.info("CIBR_TC_06, Cash In Via Branch UI validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_06", "CIBR_TC_06, Cash In Via Branch UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchBackBtnValidation_CIBR_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Back Btn Validation");
        cashInViaBranchUIValidation_CIBR_TC_06();
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCashInBranchBackBtn, "Cash In Branch Back Button");
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInMenu, getTextVal(MLWalletCashInViaBranch.objCashInMenu, "Page"))) {
            logger.info("CIBR_TC_07, Cash In Via Branch Back Btn validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_07", "CIBR_TC_07, Cash In Via Branch Back Btn validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchNavigationToHomePageFromQRPage_CIBR_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch, Navigation to Home Page After clicking on cross button on QR Code Page");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCrossBtn, "Cash In Branch Cross Button");
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Header"))) {
            logger.info("CIBR_TC_08, Cash In Via Branch, Navigation to Home Page After clicking on cross button on QR Code Page validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_08", "CIBR_TC_08, Cash In Via Branch, Navigation to Home Page After clicking on cross button on QR Code Page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchQRCodePageUIValidation_CIBR_TC_09() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch QR Code UI Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        waitTime(4000);
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"))) {
            verifyElementPresent(MLWalletCashInViaBranch.objQRCode, "QR Code");
            verifyElementPresent(MLWalletCashInViaBranch.objPHP, getTextVal(MLWalletCashInViaBranch.objPHP, "PHP"));
            verifyElementPresent(MLWalletCashInViaBranch.objCreatedDate, getTextVal(MLWalletCashInViaBranch.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashInViaBranch.objStatus, getTextVal(MLWalletCashInViaBranch.objStatus, "Status"));
            verifyElementPresent(MLWalletCashInViaBranch.objTransactionNo, getTextVal(MLWalletCashInViaBranch.objTransactionNo, "Transaction Number"));
            verifyElementPresent(MLWalletCashInViaBranch.objCrossBtn, "Cash In Branch Cross Button");
            logger.info("CIBR_TC_09, Cash In Via Branch QR Code UI validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_09", "CIBR_TC_09, Cash In Via Branch QR Code UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchPendingTransaction_CIBR_TC_11() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch, If pending transaction Exists, Application directly navigates to previous transaction QR Code");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        Swipe("UP", 1);
        if (verifyElementPresent(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"))) {
            verifyElementPresent(MLWalletCashInBank.objPending, getTextVal(MLWalletCashInBank.objPending, "Status"));
            click(MLWalletCashInViaBranch.objCashInMenu, "Cash In");
            verifyElementPresent(MLWalletCashInViaBranch.objBranchName, "Cash In Options Page");
            click(MLWalletCashInViaBranch.objBranchName, "ML Branch");
            if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"))) {
                verifyElementPresent(MLWalletCashInViaBranch.objPHP, getTextVal(MLWalletCashInViaBranch.objPHP, "PHP"));
                verifyElementPresent(MLWalletCashInViaBranch.objCreatedDate, getTextVal(MLWalletCashInViaBranch.objCreatedDate, "Date"));
                verifyElementPresent(MLWalletCashInViaBranch.objStatus, getTextVal(MLWalletCashInViaBranch.objStatus, "Status"));
                verifyElementPresent(MLWalletCashInViaBranch.objTransactionNo, getTextVal(MLWalletCashInViaBranch.objTransactionNo, "Transaction Number"));
                verifyElementPresent(MLWalletCashInViaBranch.objCrossBtn, "Cash In Branch Cross Button");
                logger.info("CIBR_TC_11, Cash In Via Branch, If pending transaction Exists, Application directly navigates to previous transaction QR Code validated");
                ExtentReporter.extentLoggerPass("CIBR_TC_11", "CIBR_TC_11, Cash In Via Branch, If pending transaction Exists, Application directly navigates to previous transaction QR Code validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBranchCancelBtnValidationOnCashInConfirmPopUp_CIBR_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Cancel Button validation on CashIn Confirm Popup");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCancelTransactionBtn, getTextVal(MLWalletCashInViaBranch.objCancelTransactionBtn, "Button"));
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCancelTransactionBtn, getTextVal(MLWalletCashInViaBranch.objCancelTransactionBtn, "Button"));
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"))) {
            logger.info("CIBR_TC_12, Cash In Via Branch, On clicking Cancel Button on CashIn Confirm Popup Application Navigates to CashIn Page with Cancelled Status");
            ExtentReporter.extentLoggerPass("CIBR_TC_12", "CIBR_TC_12, Cash In Via Branch, On clicking Cancel Button on CashIn Confirm Popup Application Navigates to CashIn Page with Cancelled Status");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchTappingOutsideTheCashInConfirmationPopUp_CIBR_TC_13(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch, On tapping Outside the CashIn Confirmation Popup");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount(sAmount);
        verifyElementPresent(MLWalletCashInViaBranch.objCashInConfirmationPopup, getTextVal(MLWalletCashInViaBranch.objCashInConfirmationPopup, "Popup"));
        tapUsingCoordinates(500, 1000);
        logger.info("Clicked OutSide the Dragon Pay Popup");
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInConfirmationPopup, getTextVal(MLWalletCashInViaBranch.objCashInConfirmationPopup, "Popup"))) {
            logger.info("CIBR_TC_13, Cash In Via Branch, On tapping Outside the CashIn Confirmation Popup, Popup doesn't closed");
            ExtentReporter.extentLoggerPass("CIBR_TC_13", "CIBR_TC_13, Cash In Via Branch, On tapping Outside the CashIn Confirmation Popup, Popup doesn't closed");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchGoBackBtnValidationOnCashInConfirmPopUp_CIBR_TC_14() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Go Back Button validation on CashIn Confirm Popup");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objContinueButton, getTextVal(MLWalletCashInViaBranch.objContinueButton, "button"));
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCancelTransactionBtn, getTextVal(MLWalletCashInViaBranch.objCancelTransactionBtn, "Button"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objGoBackBtn, getTextVal(MLWalletCashInViaBranch.objGoBackBtn, "Button"));
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"))) {
            logger.info("CIBR_TC_14, Cash In Via Branch, On clicking Go Back Button on CashIn Confirm Popup Application Navigates to CashIn Page with pending Status");
            ExtentReporter.extentLoggerPass("CIBR_TC_14", "CIBR_TC_14, Cash In Via Branch, On clicking Go Back Button on CashIn Confirm Popup Application Navigates to CashIn Page with pending Status");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBankTappingOutsideTheCancelTransactionConfirmationPopup_CIBR_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch, On tapping Outside the Cancel Transaction Confirmation Popup");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCancelTransactionBtn, getTextVal(MLWalletCashInViaBranch.objCancelTransactionBtn, "Button"));
        verifyElementPresent(MLWalletCashInViaBranch.objCancelTransactionPopup, getTextVal(MLWalletCashInViaBranch.objCancelTransactionPopup, "PopUp"));
        tapUsingCoordinates(500, 1000);
        logger.info("Clicked OutSide the Dragon Pay Popup");
        if (verifyElementPresent(MLWalletCashInViaBranch.objCancelTransactionPopup, getTextVal(MLWalletCashInViaBranch.objCancelTransactionPopup, "PopUp"))) {
            logger.info("CIBR_TC_15, Cash In Via Branch, On tapping Outside the Cancel Transaction Confirmation Popup, Popup doesn't closed");
            ExtentReporter.extentLoggerPass("CIBR_TC_15", "CIBR_TC_15, Cash In Via Branch, On tapping Outside the Cancel Transaction Confirmation Popup, Popup doesn't closed");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchBuyerTierUser_CIBR_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Buyer Tier User");
        cashInViaBranchNavigation(prop.getproperty("Fully_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup, getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        waitTime(4000);
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"))) {
            verifyElementPresent(MLWalletCashInViaBranch.objPHP, getTextVal(MLWalletCashInViaBranch.objPHP, "PHP"));
            verifyElementPresent(MLWalletCashInViaBranch.objCreatedDate, getTextVal(MLWalletCashInViaBranch.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashInViaBranch.objStatus, getTextVal(MLWalletCashInViaBranch.objStatus, "Status"));
            verifyElementPresent(MLWalletCashInViaBranch.objTransactionNo, getTextVal(MLWalletCashInViaBranch.objTransactionNo, "Transaction Number"));
            verifyElementPresentAndClick(MLWalletCashInViaBranch.objCrossBtn, "Cash In Branch Cross Button");
            Swipe("DOWN", 1);
            Swipe("UP", 1);
            if (verifyElementPresent(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"))) {
                logger.info("CIBR_TC_16, Cash In Via Branch Transaction successful for Buyer Tier User is Validated");
                ExtentReporter.extentLoggerPass("CIBR_TC_16", "CIBR_TC_16, Cash In Via Branch Transaction successful for Buyer Tier User is Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBranchSemiVerifiedTierUser_CIBR_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Semi verified Tier User");
        cashInViaBranchNavigation(prop.getproperty("Semi_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"))) {
            verifyElementPresent(MLWalletCashInViaBranch.objPHP, getTextVal(MLWalletCashInViaBranch.objPHP, "PHP"));
            verifyElementPresent(MLWalletCashInViaBranch.objCreatedDate, getTextVal(MLWalletCashInViaBranch.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashInViaBranch.objStatus, getTextVal(MLWalletCashInViaBranch.objStatus, "Status"));
            verifyElementPresent(MLWalletCashInViaBranch.objTransactionNo, getTextVal(MLWalletCashInViaBranch.objTransactionNo, "Transaction Number"));
            verifyElementPresentAndClick(MLWalletCashInViaBranch.objCrossBtn, "Cash In Branch Cross Button");
            Swipe("DOWN", 1);
            Swipe("UP", 1);
            if (verifyElementPresent(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"))) {
                verifyElementPresent(MLWalletCashInBank.objPending, getTextVal(MLWalletCashInBank.objPending, "Status"));
                logger.info("CIBR_TC_17, Cash In Via Branch Semi verified Tier User Validated");
                ExtentReporter.extentLoggerPass("CIBR_TC_17", "CIBR_TC_17, Cash In Via Branch Semi verified Tier User Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBranchFullyVerifiedTierUser_CIBR_TC_18() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Fully verified Tier User");
        cashInViaBranchNavigation(prop.getproperty("Fully_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"))) {
            verifyElementPresent(MLWalletCashInViaBranch.objPHP, getTextVal(MLWalletCashInViaBranch.objPHP, "PHP"));
            verifyElementPresent(MLWalletCashInViaBranch.objCreatedDate, getTextVal(MLWalletCashInViaBranch.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashInViaBranch.objStatus, getTextVal(MLWalletCashInViaBranch.objStatus, "Status"));
            verifyElementPresent(MLWalletCashInViaBranch.objTransactionNo, getTextVal(MLWalletCashInViaBranch.objTransactionNo, "Transaction Number"));
            verifyElementPresentAndClick(MLWalletCashInViaBranch.objCrossBtn, "Cash In Branch Cross Button");
            Swipe("DOWN", 1);
            Swipe("UP", 1);
            if (verifyElementPresent(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"))) {
                verifyElementPresent(MLWalletCashInBank.objPending, getTextVal(MLWalletCashInBank.objPending, "Status"));
                logger.info("CIBR_TC_18, Cash In Via Branch Fully verified Tier User Validated");
                ExtentReporter.extentLoggerPass("CIBR_TC_18", "CIBR_TC_18, Cash In Via Branch Fully verified Tier User Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void cashInViaBranchMaxTransactionBuyerTierUser_CIBR_TC_19() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Max Transaction Buyer Tier User");
        maxTransactionLimitValidation(prop.getproperty("Buyer_Tier"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletCashInViaBranch.objBankMaxLimitToUpgrade, getTextVal(MLWalletCashInViaBranch.objBankMaxLimitToUpgrade, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInViaBranch.objBankMaxLimitToUpgrade);
            String sExpectedErrorMsg = "The maximum Branch Cash-in per transaction set for your verification level is P20,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("CIBR_TC_19, Cash In Via Branch Max Transaction Buyer Tier User,Branch CashIn Not Allowed-Error message Validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_19", "CIBR_TC_19, Cash In Via Branch Max Transaction Buyer Tier User,Branch CashIn Not Allowed-Error message Validated");
        }
    }

    public void cashInViaBranchMaxTransactionSemiVerifiedTierUser_CIBR_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Max Transaction Limit Semi-verified Tier User");
        maxTransactionLimitValidation(prop.getproperty("Semi_Verified"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletCashInViaBranch.objBankMaxLimitToUpgrade, getTextVal(MLWalletCashInViaBranch.objBankMaxLimitToUpgrade, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInViaBranch.objBankMaxLimitToUpgrade);
            String sExpectedErrorMsg = "The maximum Branch Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("CIBR_TC_20, Cash In Via Branch Max Transaction Limit Semi-verified Tier User Validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_20", "CIBR_TC_20, Cash In Via Branch Max Transaction Limit Semi-verified Tier User Validated");
        }
    }


    public void cashInViaBranchMaxTransactionFullyVerifiedTierUser_CIBR_TC_21() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Max Transaction Limit Fully-verified Tier User");
        maxTransactionLimitValidation(prop.getproperty("Fully_verified"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletCashInViaBranch.objBankMaxLimitTxt, getTextVal(MLWalletCashInViaBranch.objBankMaxLimitTxt, "Error Message"))) {
            String sErrorMsg = getText(MLWalletCashInViaBranch.objBankMaxLimitTxt);
            String sExpectedErrorMsg = "The maximum Branch Cash-in per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("CIBR_TC_21, Cash In Via Branch Max Transaction Limit Fully-verified Tier User Validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_21", "CIBR_TC_21, Cash In Via Branch Max Transaction Limit Fully-verified Tier User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchTransactionDetailsUIValidation_CIBR_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Transaction Details UI Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"));
        verifyElementPresent(MLWalletCashInViaBranch.objPHP, getTextVal(MLWalletCashInViaBranch.objPHP, "PHP"));
        verifyElementPresent(MLWalletCashInViaBranch.objCreatedDate, getTextVal(MLWalletCashInViaBranch.objCreatedDate, "Date"));
        verifyElementPresent(MLWalletCashInViaBranch.objStatus, getTextVal(MLWalletCashInViaBranch.objStatus, "Status"));
        verifyElementPresent(MLWalletCashInViaBranch.objTransactionNo, getTextVal(MLWalletCashInViaBranch.objTransactionNo, "Transaction Number"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCrossBtn, "Cash In Branch Cross Button");
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"));
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionType, getTextVal(MLWalletTransactionHistoryPage.objTransactionType, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalCashIn, getTextVal(MLWalletTransactionHistoryPage.objTotalCashIn, "Total Cash In"));
            logger.info("CIBR_TC_22,Cash In Via Branch Transaction Details UI Validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_22", "'CIBR_TC_22',Cash In Via Branch Transaction Details UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchTransactionPendingStatusValidation_CIBR_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Transaction Pending status Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        enableLocation_PopUp();
        verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"));
        verifyElementPresent(MLWalletCashInViaBranch.objPHP, getTextVal(MLWalletCashInViaBranch.objPHP, "PHP"));
        verifyElementPresent(MLWalletCashInViaBranch.objCreatedDate, getTextVal(MLWalletCashInViaBranch.objCreatedDate, "Date"));
        verifyElementPresent(MLWalletCashInViaBranch.objStatus, getTextVal(MLWalletCashInViaBranch.objStatus, "Status"));
        verifyElementPresent(MLWalletCashInViaBranch.objTransactionNo, getTextVal(MLWalletCashInViaBranch.objTransactionNo, "Transaction Number"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCrossBtn, "Cash In Branch Cross Button");
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        if (verifyElementPresent(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"))) {
            verifyElementPresent(MLWalletCashInBank.objPending, getTextVal(MLWalletCashInBank.objPending, "Status"));
            logger.info("CIBR_TC_23,Cash In Via Branch Transaction Pending status Validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_23", "'CIBR_TC_23',Cash In Via Branch Transaction Pending status Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchTransactionCancelledStatusValidation_CIBR_TC_26() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Transaction Cancelled Status Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCancelTransactionBtn, getTextVal(MLWalletCashInViaBranch.objCancelTransactionBtn, "Button"));
        verifyElementPresent(MLWalletCashInViaBranch.objCancelTransactionPopup, getTextVal(MLWalletCashInViaBranch.objCancelTransactionPopup, "PopUp"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objCancelTransactionBtn, getTextVal(MLWalletCashInViaBranch.objCancelTransactionBtn, "Button"));
        verifyElementPresentAndClick(MLWalletCashInViaBranch.objBackToHomeBtn, getTextVal(MLWalletCashInViaBranch.objBackToHomeBtn, "Button"));
        Swipe("DOWN", 2);
        if (verifyElementPresent(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"))) {
            verifyElementPresent(MLWalletCashInBank.objCancelled, getTextVal(MLWalletCashInBank.objCancelled, "Status"));
            logger.info("'CIBR_TC_26',Cash In Via Branch Transaction Cancelled Status Validated");
            ExtentReporter.extentLoggerPass("'CIBR_TC_26", "'CIBR_TC_26', Cash In Via Branch Transaction Cancelled Status Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchLocationPopupValidation_CIBR_TC_28() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Location Pop up Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpValidation();
            logger.info("CIBR_TC_28, Cash In Via Branch Location Pop up Validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_28", "CIBR_TC_28, Cash In Via Branch Location Pop up Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchLocationDenyFunctionality_CIBR_TC_29() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Location Deny Functionality");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyPopUp();
            logger.info("CIBR_TC_29, Cash In Via Branch Location Deny Functionality Validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_29", "CIBR_TC_29, Cash In Via Branch Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchLocationPermissionDenyCloseBtnFunctionality_CIBR_TC_30() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Location Permission Deny Close Button Functionality");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyCloseBtnFunctionality();
            if (verifyElementPresent(MLWalletCashInViaBranch.objBranchCashIn, getTextVal(MLWalletCashInViaBranch.objBranchCashIn, "Page"))) {
                logger.info("CIBR_TC_30, Cash In Via Branch Location Permission Deny Close Button Functionality Validated");
                ExtentReporter.extentLoggerPass("CIBR_TC_30", "CIBR_TC_30, Cash In Via Branch Location Permission Deny Close Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void cashInViaBranchLocationPermissionDenyOpenSettingsBtnFunctionality_CIBR_TC_31() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Location Permission Deny Open Settings Button Functionality");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyOpenSettingsBtnFunctionality();
            if (verifyElementPresent(MLWalletCashInViaBranch.objAppInfo, getTextVal(MLWalletCashInViaBranch.objAppInfo, "Page"))) {
                logger.info("CIBR_TC_31, Cash In Via Branch Location Permission Deny Open Settings Button Functionality Validated");
                ExtentReporter.extentLoggerPass("CIBR_TC_31", "CIBR_TC_31, Cash In Via Branch Location Permission Deny Open Settings Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void cashInViaBranchInternetInterruptionWhileEnteringOTP_CIBR_TC_33() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Internet Interruption While Entering OTP Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        waitTime(5000);
        setWifiConnectionToONOFF("OFF");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"))) {
            waitTime(3000);
            internetConnectionError();
            logger.info("CIBR_TC_33, Cash In Via Branch Internet Interruption While Entering OTP Validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_33", "CIBR_TC_33, Cash In Via Branch Internet Interruption While Entering OTP Validated");
            System.out.println("-----------------------------------------------------------");
        }
        setWifiConnectionToONOFF("ON");
    }


    public void cashInViaBranchLocationPopUpAllowFunctionality_CIBR_TC_32() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Location popup Allow Button Functionality Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpAllowFunctionality();
            if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Bank Page"))) {
                logger.info("CIBR_TC_32, Cash In Via Branch Location popup Allow Button Functionality Validated");
                ExtentReporter.extentLoggerPass("CIBR_TC_32", "CIBR_TC_32, Cash In Via Branch Location popup Allow Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void cashInViaBranchTransactionValidationAfterMinimizingApp_CIBR_TC_36() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Transaction Validation After Minimizing App");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(3000);
        enableLocation_PopUp();
        waitTime(5000);
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        waitTime(5000);
        logger.info("Application relaunched after 5 Seconds");
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Bank Page"))) {
            logger.info("CIBR_TC_36, Cash In Via Branch Transaction Validation After Minimizing App Validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_36", "CIBR_TC_36, Cash In Via Branch Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchAmountFieldValidation_CIBR_TC_42() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch, Amount Field with more than 2 decimals Validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100.123");
        waitTime(2000);
        if (verifyElementPresent(MLWalletCashInViaBranch.objInvalidAmountMsg, getTextVal(MLWalletCashInViaBranch.objInvalidAmountMsg, "Pop Message"))) {
            String sMinimumTransactionPopupMsg = getText(MLWalletCashInViaBranch.objInvalidAmountMsg);
            String sExpectedPopupMsg = "The amount must be limited to 2 decimal places";
            assertionValidation(sMinimumTransactionPopupMsg, sExpectedPopupMsg);
            logger.info("CIBR_TC_42, Cash In Via Branch, Amount Field with more than 2 decimals Error Msg validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_42", "CIBR_TC_42, Cash In Via Branch, Amount Field with more than 2 decimals Error Msg validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchTransactionWithValidMLPin_CIBR_TC_43() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Transaction With Valid ML Pin");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        handleMpin("1111");
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Header"))) {
            verifyElementPresent(MLWalletCashInViaBranch.objPHP, getTextVal(MLWalletCashInViaBranch.objPHP, "PHP"));
            verifyElementPresent(MLWalletCashInViaBranch.objCreatedDate, getTextVal(MLWalletCashInViaBranch.objCreatedDate, "Date"));
            verifyElementPresent(MLWalletCashInViaBranch.objStatus, getTextVal(MLWalletCashInViaBranch.objStatus, "Status"));
            verifyElementPresent(MLWalletCashInViaBranch.objTransactionNo, getTextVal(MLWalletCashInViaBranch.objTransactionNo, "Transaction Number"));
            verifyElementPresentAndClick(MLWalletCashInViaBranch.objCrossBtn, "Cash In Branch Cross Button");
            Swipe("DOWN", 1);
            Swipe("UP", 1);
            if (verifyElementPresent(MLWalletCashInBank.objCashInTransaction, getTextVal(MLWalletCashInBank.objCashInTransaction, "Transaction"))) {
                verifyElementPresent(MLWalletCashInBank.objPending, getTextVal(MLWalletCashInBank.objPending, "Status"));
                logger.info("'CIBR_TC_43', Cash In Via Branch Transaction With Valid ML Pin validated");
                ExtentReporter.extentLoggerPass("'CIBR_TC_43", "'CIBR_TC_43', Cash In Via Branch Transaction With Valid ML Pin validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void cashInViaBranchTransactionWithInValidMLPin_CIBR_TC_44() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Transaction With InValid ML Pin");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        handleMpin("1234");
        if (verifyElementPresent(MLWalletCashInViaBranch.objInvalidPINMsg, getTextVal(MLWalletCashInViaBranch.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletCashInViaBranch.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("CIBR_TC_44, Cash In Via Branch Transaction With Invalid ML Pin validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_44", "CIBR_TC_44, Cash In Via Branch Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchOTPPopupValidation_CIBR_TC_50() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch OTP Popup validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            logger.info("CIBR_TC_50, Cash In Via Branch, InApp OTP popup validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_50", "CIBR_TC_50, Cash In Via Branch, InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchTransactionInAppOTPPopupUIValidation_CIBR_TC_51() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Transaction InApp OTP Popup validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds, getTextVal(MLWalletLoginPage.objSeconds, "Seconds"));
            verifyElementPresent(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
            logger.info("CIBR_TC_51, Cash In Via Branch Transaction InApp OTP Popup validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_51", "CIBR_TC_51, Cash In Via Branch Transaction InApp OTP Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchTransactionNewOTPAfterSixtySecondsValidation_CIBR_TC_52() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Transaction New OTP got generated After Sixty Seconds validation");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if (verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"))) {
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP, sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("CIBR_TC_52, Cash In Via Branch Transaction New OTP got generated After Sixty Seconds is validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_52", "CIBR_TC_52, Cash In Via Branch Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void cashInViaBranchTransactionOTPCancelBtnFunctionality_CIBR_TC_53() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Transaction OTP Cancel Button Functionality");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletCashInViaBranch.objBranchCashIn, getTextVal(MLWalletCashInViaBranch.objBranchCashIn, "Page"))) {
            logger.info("CIBR_TC_53, Cash In Via Branch Transaction, After clicking on Cancel in One time pin popup App navigates back to Branch cash In Page is validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_53", "CIBR_TC_53, Cash In Via Branch Transaction, After clicking on Cancel in One time pin popup App navigates back to Branch cash In Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void cashInViaBranchOTPContinueBtnFunctionality_CIBR_TC_54() throws Exception {
        ExtentReporter.HeaderChildNode("Cash In Via Branch Transaction OTP Continue Button Functionality");
        cashInViaBranchNavigation(prop.getproperty("Branch_Verified"));
        cancelPreviousTransactionAndContinue();
        cashInViaBranchEnterAmount("100");
        waitTime(2000);
        verifyElementPresent(MLWalletCashInViaBranch.objWarningPopup,
                getTextVal(MLWalletCashInViaBranch.objWarningPopup, "Pop Up"));
        click(MLWalletCashInViaBranch.objContinueButton, "Continue Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletCashInViaBranch.objCashInToBranch, getTextVal(MLWalletCashInViaBranch.objCashInToBranch, "Page"))) {
            logger.info("CIBR_TC_54, Cash In Via Branch Transaction, After clicking on Continue in One time pin popup App navigates to Cash In To Branch Page is validated");
            ExtentReporter.extentLoggerPass("CIBR_TC_54", "CIBR_TC_54, Cash In Via Branch Transaction, After clicking on Continue in One time pin popup App navigates to Cash In To Branch page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


}
