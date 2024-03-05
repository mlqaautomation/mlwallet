package com.business.mlwallet;
import com.driverInstance.DriverManager;
import com.mlwallet.pages.*;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static com.utility.Utilities.*;
import static com.utility.Utilities.verifyElementPresent;
public class GCashClass extends BaseClass {
    public GCashClass() {
        super();
    }

    //method for navigating gcash
    public void goToGcash() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Text");
        if (verifyElementPresent(MLWalletGcashPage.objGcashOptionsText, "Gcash Options Text")) {
            logger.info("Navigated to Gcash Services Page");
        } else {
            logger.info("Not Navigated to Gcash Services Page");
        }
    }

    //method to scroll recent transactions and verify gcash transaction
    public void verifyGcashTransaction(String type) throws Exception {
        waitTime(1000);
        Swipe("UP", 3);
        switch (type) {
            case "Pending":
                click(MLWalletGcashPage.objRecentFailedText, "Failed Transaction");
                break;
            case "Completed":
                // Perform action for Completed type
                break;
            case "Failed":
                // Perform action for Failed type
                break;
            default:
                // Handle unknown transaction types
                break;
        }
    }

    //method for successful transaction gcash
    public void sendMoneyToGcash(String tier) throws Exception {
        waitTime(1000);
        mlWalletLogin(tier);
        logger.info("Sending Money To Gcash Scenario");
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money To Gcash");
        verifyElementPresent(MLWalletGcashPage.objGcashMobileNumber, "Mobile Number Field Text");
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(1000);
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        verifyTransactionDetails();
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        click(MLWalletGcashPage.objBack_to_Home_Page, "Back to Home Page Button");
        logger.info("Send Money To Gcash, Success");
    }

    public void verifyTransactionDetails() throws Exception {
        waitTime(1000);
        verifyElementPresent(MLWalletGcashPage.objTransactionDetailsText, "Transaction Details");
        verifyElementPresent(MLWalletGcashPage.objReceiverNumber_Transaction, "Receiver Number");
        verifyElementPresent(MLWalletGcashPage.objSenderName_Transaction, "Sender Name");
        verifyElementPresent(MLWalletGcashPage.objSenderNumber_Transaction, "Sender Number");
        verifyElementPresent(MLWalletGcashPage.objGcashAmount, "Gcash Amount");
        verifyElementPresent(MLWalletGcashPage.objGcashServiceFee, "Gcash Service Fee");
        verifyElementPresent(MLWalletGcashPage.objGcashTotal, "Total Amount");
        verifyElementPresent(MLWalletGcashPage.objGcashReminder, "Reminder");
    }

    public void GC_SM_TC_01_Verify_user_able_see_Gcash_icon_Dashborad() throws Exception {
        ExtentReporter.HeaderChildNode("To verify user is able to see Gcash icon in Dashborad on sucessfull login to the application");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresent(MLWalletGcashPage.objGcashText, "Gcash Services Page Text");
        logger.info("Gcash Page Navigation Success");
        ExtentReporter.extentLoggerPass("GC_Land_TC_01", "To verify user is able to see Gcash icon in Dashborad on sucessfull login to the application");
    }

    //GC_Land_TC_02
    public void GC_SM_TC_02_Verify_user_able_navigate_Gcash_services_page_tapping_Gcash_icon() throws Exception {
        ExtentReporter.HeaderChildNode("To verify user is able to navigate to \"Gcash services\" page on tapping Gcash icon from the Dashboard");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        goToGcash();
        verifyElementPresent(MLWalletGcashPage.objGcashServicesText, "Gcash Services Page Text");
        verifyElementPresent(MLWalletGcashPage.objGcashSendMoneyText, "Send Money to Gcash Text");
        logger.info("Gcash Page Navigation Success");
        ExtentReporter.extentLoggerPass("GC_Land_TC_02", "To verify user is able to navigate to \"Gcash services\" page on tapping Gcash icon from the Dashboard");
    }
    //GC_Land_TC_04

    public void GC_SM_TC_03_Verify_UI_Gcash_Services_page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify the UI of Gcash Services page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Text");
        verifyElementPresent(MLWalletGcashPage.objGcashServicesText, "Gcash Services Page Text");
        verifyElementPresent(MLWalletGcashPage.objGcashSendMoneyText, "Send Money to Gcash Text");
        logger.info("Gcash Page Navigation Success");
        ExtentReporter.extentLoggerPass("GC_Land_TC_03", "To verify the UI of Gcash Services page");
    }

    public void GC_SM_TC_04_Verify_user_redirected_back_Dashboard_tapping_back_arrow_btn() throws Exception {
        ExtentReporter.HeaderChildNode("To verify user is redirected  back to Dashboard on tapping <(back arrow) from the Gcash Services page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Text");
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashPage_BackBtn, "Gcash Icon Text");
        logger.info("Back Gcash Page Navigation Success");
        ExtentReporter.extentLoggerPass("GC_Land_TC_04", "To verify user is redirected  back to Dashboard on tapping <(back arrow) from the Gcash Services page");
    }
    //GC_RM_TC_43

    public void goToSendMoneyToGcash() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Button");
        if (verifyElementPresent(MLWalletGcashPage.objSendMoneyPageHeader, "Send Money to GCash Page")) {
            logger.info("Navigated to Send Money to GCash Page");
        } else {
            logger.info("Not Navigated to Send Money to GCash Page");
        }
    }

    public void GC_SM_TC_43_Verify_user_redirected_back_Dashboard_tapping_back_arrow_btn() throws Exception {
        ExtentReporter.HeaderChildNode("To verify user is able to navigate to \"Gcash services\" page on tapping Gcash icon from the Dashboard");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        goToSendMoneyToGcash();
        verifyElementPresent(MLWalletGcashPage.objSendMoneyPageHeader, "Send Money to GCash Page");
        verifyElementPresent(MLWalletGcashPage.objGcashMobileNumber, "GCash No Text");
        logger.info("Send Money to Gcash Page Navigation Success");
        ExtentReporter.extentLoggerPass("GC_Land_TC_43", "To verify user is redirected to Receive Money from Gcash page on tapping Recive Money from Gcash Services page");
    }

    //GC_RM_TC_49
    public void GC_SM_TC_49_EmptyReceiverNumber_ErrorMsg_Validation() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate Error Message When Receiver Number Field is Empty ");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Option");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        assertionValidation(getText(MLWalletGcashPage.objGetErrMsg(gcashProp.getproperty("EmptyMobileNum"))), gcashProp.getproperty("EmptyMobileNum"));
        logger.info("Error Message When Empty Receiver Number Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_49", "To Validate Error Message When Receiver Number Field is Empty ");
    }

    //GC_RM_TC_50
    public void GC_SM_TC_50_InvalidReceiverNumber_ErrorMsg_Validation() throws Exception {
        ExtentReporter.HeaderChildNode("To verify user gets an appropriate error on entering Symbols and special characters in  Receiver Mobile number field in Send Money to Gcash page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Button");
        waitTime(1000);
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("SpecialChar"), "Type Characters");
        verifyElementPresentAndClick(MLWalletGcashPage.objNextBtn, "GCash Next Button");
        assertionValidation(getText(MLWalletGcashPage.objGetErrMsg(gcashProp.getproperty("InvalidMobileNum"))), gcashProp.getproperty("InvalidMobileNum"));
        logger.info("Prompt mobile no is Invalid Special Characters");
        ExtentReporter.extentLoggerPass("GC_Land_TC_50", "To verify user gets an appropriate error on entering Symbols and special characters in  Receiver Mobile number field in Send Money to Gcash page");

    }
   //GC_RM_TC_54
    public void GC_SM_TC_54_MoreThanTwoDecimal_ErrorMsg_Validation() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate Error Message When Amount is More than 2 Decimal Places ");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Option");
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("3DecimalPlaces"), "Receiver Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        assertionValidation(getText(MLWalletGcashPage.objGetErrMsg(gcashProp.getproperty("InvalidMobileNum"))), gcashProp.getproperty("InvalidMobileNum"));
        logger.info("Error Message More than two decimal places Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_54", "To Validate Error Message When Amount is More than 2 Decimal Places");
    }

    public void GC_SM_TC_57_SendMoneytoGcash_LessThan_One_Validation() throws Exception {
        ExtentReporter.HeaderChildNode("To Send Money to Gcash Less Than One Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Option");
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("ValidGcashNumber"), "Number Field");
        verifyElementPresentAndClick(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGcashPage.objAmountTextBox, gcashProp.getproperty("InvalidLessAmount"), "InvalidLessAmount");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        assertionValidation(getText(MLWalletGcashPage.objGetErrMsg(gcashProp.getproperty("InvalidLessAmount"))), gcashProp.getproperty("InvalidLessAmount"));
        waitTime(1000);
        logger.info("GC_RM_TC_57, To Send Money to Gcash Less Than One Validation, Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_57", "To Send Money to Gcash Less Than One Validation, Validated");
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void confirmGcashAmountTransaction() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Button");
        waitTime(1000);
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("ValidGcashNumber"), "Valid Number");
        click(MLWalletGcashPage.objNextBtn, "GCash Next Button");
        waitTime(1000);
        type(MLWalletGcashPage.objAmountTextBox, gcashProp.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGcashPage.objNextBtn, "Next Amount");
        if(verifyElementDisplayed(MLWalletGcashPage.objProceedBtn)){
            click(MLWalletGcashPage.objProceedBtn,"Click Proceed");
        }
        waitTime(1000);
    }

    public void GC_SM_TC_58_Validate_user_able_see_NextBtn_Send_money_Gcash_page() throws Exception {
        ExtentReporter.HeaderChildNode("To validate user is able to see Next button Send money to Gcash page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Button");
        waitTime(1000);
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("ValidGcashNumber"), "Valid Number");
        click(MLWalletGcashPage.objNextBtn, "GCash Next Button");
        waitTime(1000);
        type(MLWalletGcashPage.objAmountTextBox, gcashProp.getproperty("ValidAmount"), "Valid Amount");
        if (verifyElementPresent(MLWalletGcashPage.objNextBtn, "Next Amount")) {
            logger.info("Observe the Next Button");
        }
        logger.info("GC_RM_TC_58, To validate user is able to see Next button Send money to Gcash page, Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_58", "To validate user is able to see Next button Send money to Gcash page, Validated");
    }

    //GC_RM_TC_59
    public void GC_SM_TC_59_RedirectBack_SendMoneytoGcash_From_ConfirmDetails_Validation() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate Redirection to Send Money to Gcash Page from Confirm Details Page using Back Button");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashAmountTransaction();
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        click(MLWalletGcashPage.objGcashPage_BackBtn, "Back Button");
        if (verifyElementPresent(MLWalletGcashPage.objGcashMobileNumText, getText(MLWalletGcashPage.objGcashMobileNumText))) {
            verifyElementPresent(MLWalletGcashPage.objReceiverNumber, getText(MLWalletGcashPage.objReceiverNumber));
            logger.info("Redirect to Send Money to Gcash Page from Confirm Details Page using Back Button, Validated");
            ExtentReporter.extentLoggerPass("GC_RM_TC_59", "To Validate Redirection to Send Money to Gcash Page from Confirm Details Page using Back Button");
        }
    }

    public void confirmGcashTransaction() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money To Gcash");
        waitTime(1000);
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGcashPage.objAmountTextBox, gcashProp.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        if(verifyElementDisplayed(MLWalletGcashPage.objProceedBtn)){
            click(MLWalletGcashPage.objProceedBtn,"Click Proceed");
        }
        waitTime(1000);
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGcashPage.objAllowOnceBtn)) {
            click(MLWalletGcashPage.objAllowOnceBtn, "Allow Once Notif");
        }
//        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        waitTime(1000);
        click(MLWalletLoginPage.objContinueBtn, "Continue Button");
        waitTime(1000);
    }

    //GC_RM_TC_60
    public void GC_SM_TC_60_InAppOtp_Page_Redirection_Validation() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashAmountTransaction();
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGcashPage.objAllowOnceBtn)) {
            click(MLWalletGcashPage.objAllowOnceBtn, "Allow Once Notif");
        }
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, "One Time Pin")
                || verifyElementPresent(MLWalletLoginPage.objContinueBtn, "Continue")
                || verifyElementPresent(MLWalletLoginPage.objCancelBtn, "MLPin")
        ) {
            logger.info("OTP Page is Displayed");
            ExtentReporter.extentLoggerPass("GC_RM_TC_60", "To Validate InAppOtp Page Redirection");
        }
    }


    //GC_RM_TC_64
    public void GC_SM_TC_64_CancelOTP_Redirect_SendMoney_to_Gcash_Mobile_Entry() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashAmountTransaction();
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGcashPage.objAllowOnceBtn)) {
            click(MLWalletGcashPage.objAllowOnceBtn, "Allow Once Notif");
        }
        if (verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, "OTP Cancel Button")) {
            logger.info("Successfully Cancel InappOTP");
            ExtentReporter.extentLoggerPass("GC_RM_TC_60", "To Validate InAppOtp Page Redirection");
        }
    }

    //GC_RM_TC_72
    public void GC_SM_TC_72_ValidateSMSOTP_InApp_GCash_Send_Money() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate to SMS OTP screen Mpin GCash Send Money");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashAmountTransaction();
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGcashPage.objAllowOnceBtn)) {
            click(MLWalletGcashPage.objAllowOnceBtn, "Allow Once Notif");
        }
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getText(MLWalletLoginPage.objOneTimePin))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getText(MLWalletLoginPage.objOTP));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, "Obeserve Cancel Button");
            verifyElementPresent(MLWalletLoginPage.objContinueBtn, "Obeserve Continue Button");
            logger.info("GC_SM_TC_72, GCash In App OTP Navigation validated");
            ExtentReporter.extentLoggerPass("GC_SM_TC_70", "To Validate to SMS OTP Mpin GCash Send Money");
            System.out.println("-----------------------------------------------------------");
        }
    }

    //GC_RM_TC_73
    public void GC_SM_TC_73_Validate_Back_Btn_In_GCash_Transaction_Details_Page() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate Back Button In GCash Transaction Details Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashTransaction();
        waitTime(1000);
        verifyElementPresent(MLWalletGcashPage.objTransactionDetailsText, "Transaction Detail");
        verifyElementPresent(MLWalletGcashPage.objSendtoGCash_Transaction, "Send Money GCash");
        Swipe("UP", 1);
//            verifyElementPresent(MLWalletGcashPage.objAmountSendTransactText, getTextVal(MLWalletGcashPage.objAmountSendTransactText, "Amount Send"));
            if (verifyElementPresent(MLWalletGcashPage.objReceiverNumber_Transaction, getTextVal(MLWalletGcashPage.objReceiverNumber_Transaction, "Receiver GCash No."))) {
                verifyElementPresent(MLWalletGcashPage.objSenderName_Transaction, getTextVal(MLWalletGcashPage.objSenderName_Transaction, "Sender Name"));
                verifyElementPresent(MLWalletGcashPage.objSenderNumber_Transaction, getTextVal(MLWalletGcashPage.objSenderNumber_Transaction, "Sender No."));
                verifyElementPresent(MLWalletGcashPage.objGcashAmount, getTextVal(MLWalletGcashPage.objGcashAmount, "Amount"));
                verifyElementPresent(MLWalletGcashPage.objGcashServiceFee, getTextVal(MLWalletGcashPage.objGcashServiceFee, "Service Fee"));
                verifyElementPresent(MLWalletGcashPage.objGcashTotal, getTextVal(MLWalletGcashPage.objGcashTotal, "Total"));
                verifyElementPresent(MLWalletGcashPage.objBack_to_Home_Page, "Back Home Button");
                verifyElementPresent(MLWalletGcashPage.objNew_Transaction, "New Transaction Button");
            }
        logger.info("GC_SM_TC_73, Back Button In GCash Transaction Details Page Validated");
        ExtentReporter.extentLoggerPass("GC_SM_TC_73", "To Validate Back Button In GCash Transaction Details Page");
        System.out.println("-----------------------------------------------------------");
    }

    //GC_RM_TC_76
    public void GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page() throws Exception {
//        String amount , amountHistory;
        ExtentReporter.HeaderChildNode("To Validate Back Home Button In GCash View Recent Transaction Dashboard Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon,"Eye Icon");
//        String currentBalance = getText(MLWalletHomePage.objAvailableBalance);
        confirmGcashTransaction();
        waitTime(1000);
        verifyElementPresent(MLWalletGcashPage.objTransactionDetailsText, "Transaction Details");
        Swipe("UP", 1);
//        amount = getText(MLWalletGcashPage.objGcashTotal);
        verifyElementPresentAndClick(MLWalletGcashPage.objBack_to_Home_Page, "Back to Home Page");
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            Swipe("DOWN", 1);
            verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon,"Eye Icon");
//            String NewBalance = getText(MLWalletHomePage.objAvailableBalance);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Header"));
            Swipe("UP", 2);
            click(MLWalletTransactionHistoryPage.objSeeMoreBtn, "See More Button");
            waitTime(5000);
            verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionHistory, getTextVal(MLWalletTransactionHistoryPage.objTransactionHistory, "Page"));
            verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objSendMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objSendMoneyTab, "Tab"));
            verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransaction, getTextVal(MLWalletTransactionHistoryPage.objFirstTransaction,"First Transaction"));
//            amountHistory = getText(MLWalletTransactionHistoryPage.objTotalAmount);
//            if(amount.contains(amountHistory)){
                logger.info("GC_SM_TC_76, Same amount in transaction history Validated");
//            }
//            else
//            {
//                logger.info("GC_SM_TC_76, Not same amount in transaction history Failed");
//            }
            //-----------Formula----------------------
//            int cBalance = Integer.parseInt(currentBalance);
//            int cAmount = Integer.parseInt(amount);
//            int deduction = cBalance- cAmount;
//            String Sdeduction = String.valueOf(deduction);
            //----------------------------------------

        }
        logger.info("GC_SM_TC_76, Back Home Button In GCash View Recent Transaction Dashboard Page Validated");
        ExtentReporter.extentLoggerPass("GC_SM_TC_76", "To Validate Back Home Button In GCash View Recent Transaction Dashboard Page");
        System.out.println("-----------------------------------------------------------");
    }

    //GC_RM_TC_83
    public void GC_SM_TC_83_Validate_Transaction_Details_Match_User_Entered_Details() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate transaction details are matching with user entered details");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcashAmountTransaction();
        if (verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page")) {
            waitTime(1000);
            verifyElementPresent(MLWalletGcashPage.objSendtoGCash_Confirm, "Send Money to GCash");
            verifyElementPresent(MLWalletGcashPage.objReceiverNumber_Confirm, getTextVal(MLWalletGcashPage.objReceiverNumber_Confirm, "Receiver Number"));
            verifyElementPresent(MLWalletGcashPage.objSenderName_Confirm, getTextVal(MLWalletGcashPage.objSenderName_Confirm, "Sender Name"));
            verifyElementPresent(MLWalletGcashPage.objSenderNumber_Confirm, getTextVal(MLWalletGcashPage.objSenderNumber_Confirm, "Sender Number"));
            verifyElementPresent(MLWalletGcashPage.objAmount_Confirm, getTextVal(MLWalletGcashPage.objAmount_Confirm, "Gcash Amount"));
            verifyElementPresent(MLWalletGcashPage.objServiceFee_Confirm, getTextVal(MLWalletGcashPage.objServiceFee_Confirm, "Gcash Service Fee"));
            verifyElementPresent(MLWalletGcashPage.objTotal_Confirm, getTextVal(MLWalletGcashPage.objTotal_Confirm, "Total Amount"));
            logger.info("GC_SM_TC_83, Validate transaction details are matching with user entered details");
        }
        ExtentReporter.extentLoggerPass("GC_SM_TC_83", "To Validate transaction details are matching with user entered details");
        System.out.println("-----------------------------------------------------------");
    }

    //GC_RM_TC_102
    public void GC_SM_TC_102_Validate_SendMoneyGCash_BuyerTier() throws Exception {
        ExtentReporter.HeaderChildNode("To validate if user gets popup message when sending money to Gcash when logged in with buyer tier");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        confirmGcashAmountTransaction();
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        assertionValidation(getText(MLWalletGcashPage.objGetErrMsg(gcashProp.getproperty("InvalidTierBuyerVer"))), gcashProp.getproperty("InvalidTierBuyerVer"));
        if(verifyElementPresent(MLWalletGcashPage.objUpgradeNowLabel, "Prompt Mobile No is Invalid")) {
            verifyElementPresentAndClick(MLWalletGcashPage.objUpgradeBtn, "Upgrade Now Visible");
            waitTime(1000);
            verifyElementPresent(MLWalletTierUpgrade.objVerificationTierPerksLabel, "Tier Upgrade Page");
            logger.info("Prompt Invalid BuyerTier, Validated");
        }
        logger.info("GC_SM_TC_83, validate if user gets popup message when sending money to Gcash when logged in with buyer tier");
        ExtentReporter.extentLoggerPass("GC_SM_TC_83", "To validate if user gets popup message when sending money to Gcash when logged in with buyer tier");
        System.out.println("-----------------------------------------------------------");
    }

    public void confirmGcash50kTransaction() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money To Gcash");
        waitTime(1000);
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGcashPage.objAmountTextBox, gcashProp.getproperty("Invalid50kAmount"), "Invalid50kAmount");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        if(verifyElementDisplayed(MLWalletGcashPage.objProceedBtn)){
            click(MLWalletGcashPage.objProceedBtn,"Click Proceed");
        }
        waitTime(1000);
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGcashPage.objAllowOnceBtn)) {
            click(MLWalletGcashPage.objAllowOnceBtn, "Allow Once Notif");
        }
//        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
    }

    //GC_RM_TC_103
    public void GC_SM_TC_103_Validate_SendMoneyGCash50k_SemiVerified() throws Exception {
        ExtentReporter.HeaderChildNode("To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Semi-Verified Tier");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        confirmGcash50kTransaction();
        verifyElementPresent(MLWalletGcashPage.objUpgrade50kNowLabel, "Prompt Mobile No is Invalid");
        logger.info("Prompt Invalid 50k SemiTier, Validated");
        logger.info("GC_SM_TC_103, Validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Semi-Verified Tier");
        ExtentReporter.extentLoggerPass("GC_SM_TC_103","To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Semi-Verified Tier");
        System.out.println("-----------------------------------------------------------");
    }
    //GC_RM_TC_104
    public void GC_SM_TC_104_Validate_SendMoneyGCash50k_BranchVerified() throws Exception {
        ExtentReporter.HeaderChildNode("To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmGcash50kTransaction();
        verifyElementPresent(MLWalletGcashPage.objUpgrade50kNowLabel, "Prompt Mobile No is Invalid");
        logger.info("Prompt Invalid 50k BranchTier, Validated");
        logger.info("GC_SM_TC_104, Validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        ExtentReporter.extentLoggerPass("GC_SM_TC_104", "To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        System.out.println("-----------------------------------------------------------");
    }
    //GC_RM_TC_105
    public void GC_SM_TC_105_Validate_SendMoneyGCash50k_FullyVerified() throws Exception {
        ExtentReporter.HeaderChildNode("To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        confirmGcash50kTransaction();
        verifyElementPresent(MLWalletGcashPage.objUpgrade50kNowLabel, "Prompt Mobile No is Invalid");
        logger.info("Prompt Invalid 50k FullyTier, Validated");
        logger.info("GC_SM_TC_105, Validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        ExtentReporter.extentLoggerPass("GC_SM_TC_105", "To validate Sending Money to Gcash in a Single Transaction Amount Exceeding Maximum Limit as a Branch-Verified Tier");
        System.out.println("-----------------------------------------------------------");
    }

    public void sendMoneyToGcash() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money To Gcash");
        waitTime(1000);
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGcashPage.objAmountTextBox, gcashProp.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        if(verifyElementDisplayed(MLWalletGcashPage.objProceedBtn)){
            click(MLWalletGcashPage.objProceedBtn,"Click Proceed");
        }
        waitTime(1000);
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGcashPage.objAllowOnceBtn)) {
            click(MLWalletGcashPage.objAllowOnceBtn, "Allow Once Notif");
        }
//        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        waitTime(1000);
        click(MLWalletLoginPage.objContinueBtn, "Continue Button");
        waitTime(1000);
        click(MLWalletGcashPage.objBack_to_Home_Page, "Back to Home Page Button");
        logger.info("Send Money To Gcash, Success");
    }

    //GC_RM_TC_132 To Validate Successful Send Money to Gcash per Transaction while in Semi Verified Tier
    public void GC_SM_TC_132_SendMoney_as_SemiVerified() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate Successful Send Money to Gcash per Transaction while in Semi Verified Tier ");
        waitTime(1000);
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        sendMoneyToGcash();
        logger.info("Send Money to Gcash as Semi Verified Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_132", "To Validate Successful Send Money to Gcash per Transaction while in Semi Verified Tier");
    }

    //GC_RM_TC_135 To Validate Successful Send Money to Gcash per Transaction while in Branch Verified Tier
    public void GC_RM_TC_135_SendMoney_as_BranchVerified() throws Exception {
        ExtentReporter.HeaderChildNode("To Validate Successful Send Money to Gcash per Transaction while in Branch Verified Tier ");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        sendMoneyToGcash();
        logger.info("Send Money to Gcash as Branch Verified Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_135", "To Validate Successful Send Money to Gcash as Branch Verified Tier ");
    }
    public void confirmNoGcashgotoKwartaPadalaTransaction() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money To Gcash");
        waitTime(1000);
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("NoGcashKwartaPadalaNo"), "Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGcashPage.objAmountTextBox, gcashProp.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        if(verifyElementDisplayed(MLWalletGcashPage.objProceedBtn)){
            click(MLWalletGcashPage.objProceedBtn,"Click Proceed");
        }
        waitTime(1000);
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGcashPage.objAllowOnceBtn)) {
            click(MLWalletGcashPage.objAllowOnceBtn, "Allow Once Notif");
        }
//        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        waitTime(1000);
        click(MLWalletLoginPage.objContinueBtn, "Continue Button");
        waitTime(1000);
    }

    public void confirmNoGcashggotoMLWalletTransaction() throws Exception {
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Button");
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money To Gcash");
        waitTime(1000);
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("NoGcashMlwalletNo"), "Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(1000);
        type(MLWalletGcashPage.objAmountTextBox, gcashProp.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        if(verifyElementDisplayed(MLWalletGcashPage.objProceedBtn)){
            click(MLWalletGcashPage.objProceedBtn,"Click Proceed");
        }
        waitTime(1000);
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        if (verifyElementDisplayed(MLWalletGcashPage.objAllowOnceBtn)) {
            click(MLWalletGcashPage.objAllowOnceBtn, "Allow Once Notif");
        }
//        click(MLWalletGCashPage.objGcashConfirmBtn, "Confirm Button");
        waitTime(1000);
        click(MLWalletLoginPage.objContinueBtn, "Continue Button");
        waitTime(1000);
    }
    public void GC_RM_TC_180_SendMoney_NoGCash_thru_MLWallet()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmNoGcashggotoMLWalletTransaction();
        if(verifyElementPresent(MLWalletGcashPage.objNoGCashOtherOptionLabel, "Prompt Mobile No is Invalid")){
            verifyElementPresent(MLWalletGcashPage.objSendViaMLWalletlabel, "Send Via ML Wallet");
            verifyElementPresent(MLWalletGcashPage.objSendViaMLWalletBtn, "Send Via ML Wallet Button");
            verifyElementPresent(MLWalletGcashPage.objCloseBtn, "Close Button");
            if(verifyElementDisplayed(MLWalletGcashPage.objSendViaMLWalletBtn)){
                click(MLWalletGcashPage.objSendViaMLWalletBtn, "Send Via Kwarta Padala Button");
                verifyElementPresent(MLWalletTransactionHistoryPage.objSendMoneyTab,"Kwarta Padala Label");
            }
        }
    }
    public void GC_RM_TC_181_SendMoney_NoGCash_thru_KwartaPadala()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        confirmNoGcashgotoKwartaPadalaTransaction();
        if(verifyElementPresent(MLWalletGcashPage.objNoGCashOtherOptionLabel, "Prompt Mobile No is Invalid")){
            verifyElementPresent(MLWalletGcashPage.objSendViaMLKwartaWallelabel, "Send Via Kwarta Padala");
            verifyElementPresent(MLWalletGcashPage.objSendViaMLKwartaPadalaBtn, "Send Via Kwarta Padala Button");
            verifyElementPresent(MLWalletGcashPage.objCloseBtn, "Close Button");
            if(verifyElementDisplayed(MLWalletGcashPage.objSendViaMLKwartaPadalaBtn)){
                click(MLWalletGcashPage.objSendViaMLKwartaPadalaBtn, "Send Via Kwarta Padala Button");
                verifyElementPresent(MLWalletTransactionHistoryPage.objKwartaPadala,"Kwarta Padala Label");
            }
        }
    }

    public void GC_RM_TC_182_Contacts()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Button");
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money To Gcash");
        waitTime(1000);
        verifyElementPresentAndClick(MLWalletGcashPage.objSelectContactText, "Contact Buttons");
        if(verifyElementDisplayed(MLWalletGcashPage.objOkAllowContacts)){
            verifyElementPresentAndClick(MLWalletGcashPage.objOkAllowContacts,"Allow Notif Button");
            verifyElementPresent(MLWalletGcashPage.objContactPageHeader,"Contacts");
            verifyElementPresent(MLWalletGcashPage.objFavoritesBtn, "Favorites Buttons");
            verifyElementPresent(MLWalletGcashPage.objSearchBox, "Select Box");
            verifyElementPresent(MLWalletGcashPage.objContactButton, "Select Contacts");
        }

    }
//demo1
    //demo2
}

