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
public class GCashClass extends BaseClass{
    public GCashClass(){
        super();
    }

    //method for navigating gcash
    public void goToGcash()throws Exception{
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashText, "Gcash Icon Text");
        if(verifyElementPresent(MLWalletGcashPage.objGcashOptionsText, "Gcash Options Text")){
            logger.info("Navigated to Gcash Services Page");
        }
        else{
            logger.info("Not Navigated to Gcash Services Page");
        }
    }
    //method to scroll recent transactions and verify gcash transaction
    public void verifyGcashTransaction(String type)throws Exception{
        waitTime(5000);
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
    public void sendMoneyToGcash(String tier)throws Exception{
        waitTime(5000);
        mlWalletLogin(tier);
        logger.info("Sending Money To Gcash Scenario");
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money To Gcash");
        verifyElementPresent(MLWalletGcashPage.objGcashMobileNumber, "Mobile Number Field Text");
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(5000);
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        verifyTransactionDetails();
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        click(MLWalletGcashPage.objBack_to_Home_Page , "Back to Home Page Button");
        logger.info("Send Money To Gcash, Success");
    }
    public void verifyTransactionDetails()throws Exception{
        waitTime(5000);
        verifyElementPresent(MLWalletGcashPage.objTransactionDetailsText, "Transaction Details");
        verifyElementPresent(MLWalletGcashPage.objReceiverNumber_Transaction, "Receiver Number");
        verifyElementPresent(MLWalletGcashPage.objSenderName_Transaction, "Sender Name");
        verifyElementPresent(MLWalletGcashPage.objSenderNumber_Transaction, "Sender Number");
        verifyElementPresent(MLWalletGcashPage.objGcashAmount, "Gcash Amount");
        verifyElementPresent(MLWalletGcashPage.objGcashServiceFee, "Gcash Service Fee");
        verifyElementPresent(MLWalletGcashPage.objGcashTotal, "Total Amount");
        verifyElementPresent(MLWalletGcashPage.objGcashReminder, "Reminder");
    }

    //GC_Land_TC_02
    public void GC_Land_TC_02()throws Exception{
        ExtentReporter.HeaderChildNode("To verify user is able to navigate to \"Gcash services\" page on tapping Gcash icon from the Dashboard");
        mlWalletLogin("Branch_Verified");
        goToGcash();
        verifyElementPresent(MLWalletGcashPage.objGcashServicesText, "Gcash Services Page Text");
        verifyElementPresent(MLWalletGcashPage.objGcashSendMoneyText, "Send Money to Gcash Text");
        logger.info("Gcash Page Navigation Success");
        ExtentReporter.extentLoggerPass("GC_Land_TC_02","To verify user is able to navigate to \"Gcash services\" page on tapping Gcash icon from the Dashboard");
    }
    //GC_Land_TC_04


    //GC_RM_TC_43
    public void GC_SM_TC_43()throws Exception{
        ExtentReporter.HeaderChildNode("To verify user is able to navigate to \"Gcash services\" page on tapping Gcash icon from the Dashboard");
        mlWalletLogin("Branch_Verified");
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money To Gcash");
        if(verifyElementPresent(MLWalletGcashPage.objSendMoneyPageHeader, "Send Money Page Header Text")){
            verifyElementPresent(MLWalletGcashPage.objSendMoneyReceiverText, "Receiver Text");
            verifyElementPresent(MLWalletGcashPage.objGcashMobileNumber, "Mobile Number Field Text");
            verifyElementPresent(MLWalletGcashPage.objSelectContactText, "Select From Contacts Text");
            verifyElementPresent(MLWalletGcashPage.objNextBtn, "Next Button");
            logger.info("Send Money to Gcash Page UI Validated");
            ExtentReporter.extentLoggerPass("GC_RM_TC_43", "");
        }
    }


    //GC_RM_TC_132 To Validate Successful Send Money to Gcash per Transaction while in Semi Verified Tier
    public void GC_SM_TC_132_SendMoney_as_SemiVerified()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate Successful Send Money to Gcash per Transaction while in Semi Verified Tier ");
        sendMoneyToGcash(prop.getproperty("Semi_Verified"));
        logger.info("Send Money to Gcash as Semi Verified Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_132", "To Validate Successful Send Money to Gcash per Transaction while in Semi Verified Tier");
    }
    //GC_RM_TC_135 To Validate Successful Send Money to Gcash per Transaction while in Branch Verified Tier
    public void GC_RM_TC_135_SendMoney_as_BranchVerified()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate Successful Send Money to Gcash per Transaction while in Branch Verified Tier ");
        sendMoneyToGcash(prop.getproperty("Branch_Verified"));
        logger.info("Send Money to Gcash as Branch Verified Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_135", "To Validate Successful Send Money to Gcash as Branch Verified Tier ");
    }
    //GC_RM_TC_49
    public void GC_SM_TC_49_EmptyReceiverNumber_ErrorMsg_Validation()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate Error Message When Receiver Number Field is Empty ");
        mlWalletLogin("Branch_Verified");
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Option");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        assertionValidation(getText(MLWalletGcashPage.objGetErrMsg(gcashProp.getproperty("EmptyMobileNum"))), gcashProp.getproperty("EmptyMobileNum"));
        logger.info("Error Message When Empty Receiver Number Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_49", "To Validate Error Message When Receiver Number Field is Empty ");
    }
    //GC_RM_TC_50
    public void GC_SM_TC_50_InvalidReceiverNumber_ErrorMsg_Validation()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate Error Message When Receiver Number Field is Invalid");
        mlWalletLogin("Branch_Verified");
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Option");
        type(MLWalletGcashPage.objReceiverNumber, gcashProp.getproperty("SpecialChar"), "Receiver Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        assertionValidation(getText(MLWalletGcashPage.objGetErrMsg(gcashProp.getproperty("InvalidMobileNum"))), gcashProp.getproperty("InvalidMobileNum"));
        logger.info("Error Message When Invalid Receiver Number Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_50", "To Validate Error Message When Receiver Number Field is Invalid");
    }

    //GC_RM_TC_54
    public void GC_SM_TC_54_MoreThanTwoDecimal_ErrorMsg_Validation()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate Error Message When Amount is More than 2 Decimal Places ");
        mlWalletLogin("Branch_Verified");
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Option");
        type(MLWalletGcashPage.objReceiverNumber, gcashProp.getproperty("3DecimalPlaces"), "Receiver Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        assertionValidation(getText(MLWalletGcashPage.objGetErrMsg(gcashProp.getproperty("DecimalErr"))), gcashProp.getproperty("DecimalErr"));
        logger.info("Error Message More than two decimal places Validated");
        ExtentReporter.extentLoggerPass("GC_RM_TC_54", "To Validate Error Message When Amount is More than 2 Decimal Places");
    }
    //GC_RM_TC_56
    public void GC_SM_TC_56_RedirectBack_ToGcashServices_From_SendMoney_Validation()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate Redirection to Gcash Services from Send Money Page using Back Button");
        mlWalletLogin("Branch_Verified");
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Option");
        verifyElementPresent(MLWalletGcashPage.objSendMoneyPageHeader, "Send Money to GCash Page");
        click(MLWalletGcashPage.objGcashPage_BackBtn, "Back Button");
        if(verifyElementPresent(MLWalletGcashPage.objGcashServicesText, "Gcash Services Page")){
            verifyElementPresent(MLWalletGcashPage.objGcashOptionsText, "Gcash Options");
            logger.info("Redirect to Gcash Services from Send Money Page using Back Button, Validated");
            ExtentReporter.extentLoggerPass("GC_RM_TC_54", "To Validate Redirection to Gcash Services from Send Money Page using Back Button");
        }
    }

    //GC_RM_TC_59
    public void GC_SM_TC_59_RedirectBack_SendMoneytoGcash_From_ConfirmDetails_Validation()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate Redirection to Send Money to Gcash Page from Confirm Details Page using Back Button");
        mlWalletLogin("Branch_Verified");
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money Option");
        verifyElementPresent(MLWalletGcashPage.objSendMoneyPageHeader, "Send Money to GCash Page");
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(5000);
        type(MLWalletGcashPage.objGcashAmount, gcashProp.getproperty("ValidAmount"), "Valid Amount");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(5000);
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        click(MLWalletGcashPage.objGcashPage_BackBtn, "Back Button");
        if(verifyElementPresent(MLWalletGcashPage.objSendMoneyPageHeader, getText(MLWalletGcashPage.objSendMoneyPageHeader))){
            verifyElementPresent(MLWalletGcashPage.objGcashMobileNumText, getText(MLWalletGcashPage.objGcashMobileNumText));
            logger.info("Redirect to Send Money to Gcash Page from Confirm Details Page using Back Button, Validated");
            ExtentReporter.extentLoggerPass("GC_RM_TC_59", "To Validate Redirection to Send Money to Gcash Page from Confirm Details Page using Back Button");
        }
    }
    //GC_RM_TC_60
    public void GC_SM_TC_60_InAppOtp_Page_Redirection_Validation()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        mlWalletLogin("Branch_Verified");
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money To Gcash");
        verifyElementPresent(MLWalletGcashPage.objGcashMobileNumber, "Mobile Number Field Text");
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(5000);
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        verifyTransactionDetails();
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        enableLocation_PopUp();
        if(verifyElementPresent(MLWalletLoginPage.objContinueBtn, "OTP Continue Button")
         || verifyElementPresent(MLWalletLoginPage.objOneTimePin, "One Time Pin")
         || verifyElementPresent(MLWalletLoginPage.objMLPin, "MLPin")
        ){
            logger.info("OTP Page is Displayed");
            ExtentReporter.extentLoggerPass("GC_RM_TC_60", "To Validate InAppOtp Page Redirection");
        }
    }
    //GC_RM_TC_61

    //GC_RM_TC_64
    public void GC_SM_TC_64_CancelOTP_Redirect_SendMoney_to_Gcash_Mobile_Entry()throws Exception{
        ExtentReporter.HeaderChildNode("To Validate InAppOtp Page Redirection");
        mlWalletLogin("Branch_Verified");
        goToGcash();
        verifyElementPresentAndClick(MLWalletGcashPage.objGcashSendMoneyText, "Send Money To Gcash");
        verifyElementPresent(MLWalletGcashPage.objGcashMobileNumber, "Mobile Number Field Text");
        type(MLWalletGcashPage.objGcashMobileNumber, gcashProp.getproperty("ValidGcashNumber"), "Number Field");
        click(MLWalletGcashPage.objNextBtn, "Next Button");
        waitTime(5000);
        verifyElementPresent(MLWalletGcashPage.objConfirmDetailsPage, "Confirm Details Page");
        verifyTransactionDetails();
        click(MLWalletGcashPage.objConfirmBtn, "Confirm Button");
        enableLocation_PopUp();
        if(verifyElementPresent(MLWalletLoginPage.objContinueBtn, "OTP Continue Button")
        ){
            logger.info("OTP Page is Displayed");

            ExtentReporter.extentLoggerPass("GC_RM_TC_60", "To Validate InAppOtp Page Redirection");
        }
    }
    //GC_RM_TC_69

    //GC_RM_TC_70

    //GC_RM_TC_71

    //GC_RM_TC_72

    //GC_RM_TC_73

    //GC_RM_TC_76

    //GC_RM_TC_83

    //GC_RM_TC_84

    //GC_RM_TC_102

    //GC_RM_TC_103

    //GC_RM_TC_104

    //GC_RM_TC_105
}
