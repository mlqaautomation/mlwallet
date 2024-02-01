package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.mlwallet.pages.MLWalletHomePage;
import com.mlwallet.pages.MLWalletLogOutPage;
import com.mlwallet.pages.MLWalletLoginPage;
import com.mlwallet.pages.SendTransferPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.utility.Utilities.*;
import static com.utility.Utilities.getTextVal;

public class SendMoneyVia_BranchClass extends BaseClass{
public SendMoneyVia_BranchClass(){
    super();
}
    public void sendMoneyToMLBranch_STB_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objSendMoneySuccessful, getTextVal(SendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(SendTransferPage.objPHPAmount, getTextVal(SendTransferPage.objPHPAmount, "Amount"));
            verifyElementPresent(SendTransferPage.objDate, getTextVal(SendTransferPage.objDate, "Date"));
            verifyElementPresent(SendTransferPage.objReferenceNumber, getTextVal(SendTransferPage.objReferenceNumber, "Reference Number"));
            String sReference = getText(SendTransferPage.objReferenceNumber);
            System.out.println(sReference);
            String sReferenceNumber = sReference.substring(9, 20);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objKwartaPadala, getTextVal(MLWalletHomePage.objKwartaPadala, "Text"));
            if (verifyElementPresent(SendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(SendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(SendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sReferenceNumber);
                logger.info("STB_TC_01, Successfully sent Amount to ML Branch and Transaction Details is validated");
                ExtentReporter.extentLoggerPass("STB_TC_01", "STB_TC_01, Successfully sent Amount to ML Branch and Transaction Details is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyRequiredDetails_STB_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money Invalid Bank Details");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"));
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objFirstNameRequiredMsg, getTextVal(SendTransferPage.objFirstNameRequiredMsg, "Error Message"))) {
            String sFirstNameErrorMsg = getText(SendTransferPage.objFirstNameRequiredMsg);
            String sExpectedMsg = "First name is required";
            assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
        }
        hideKeyboard();
        type(SendTransferPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");
        type(SendTransferPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objMiddleNameRequiredMsg, getTextVal(SendTransferPage.objMiddleNameRequiredMsg, "Error Message"))) {
            String sMiddleNameRequiredMsg = getText(SendTransferPage.objMiddleNameRequiredMsg);
            String sExpectedMsg = "Middle name is required";
            assertionValidation(sMiddleNameRequiredMsg, sExpectedMsg);
        }
        waitTime(3000);
        type(SendTransferPage.objMiddleName, prop.getproperty("Middle_Name"), "Middle Name Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objLastNameRequiredMsg, getTextVal(SendTransferPage.objLastNameRequiredMsg, "Error Message"))) {
            String sLastNameRequiredMsg = getText(SendTransferPage.objLastNameRequiredMsg);
            String sExpectedMsg = "Last name is required";
            assertionValidation(sLastNameRequiredMsg, sExpectedMsg);
        }
        waitTime(3000);
        type(SendTransferPage.objLastName, prop.getproperty("Last_Name"), "Last Name Text Field");
        type(SendTransferPage.objLastName, prop.getproperty("Last_Name"), "Last Name Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objMobileNumberRequiredMsg, getTextVal(SendTransferPage.objMobileNumberRequiredMsg, "Error Message"))) {
            String sMobileNumberRequiredMsg = getText(SendTransferPage.objMobileNumberRequiredMsg);
            String sExpectedMsg = "Mobile number is required";
            assertionValidation(sMobileNumberRequiredMsg, sExpectedMsg);
        }
        type(SendTransferPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Last Name Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "page"))) {
            logger.info("STB_TC_08, Prompt msg for Receiver's Details required is validated");
            ExtentReporter.extentLoggerPass("STB_TC_08", "STB_TC_08, Prompt msg for Receiver's Details required is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyInvalidDetails_STB_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money Invalid Bank Details");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"));
        type(SendTransferPage.objFirstname, prop.getproperty("Invalid_First_Name"), "First Name Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objFirstNameErrorMsg, getTextVal(SendTransferPage.objFirstNameErrorMsg, "Error Message"))) {
            String sFirstNameErrorMsg = getText(SendTransferPage.objFirstNameErrorMsg);
            String sExpectedMsg = "First name must only contain letters and spaces";
            assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
        }
        type(SendTransferPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");
        type(SendTransferPage.objFirstname, prop.getproperty("First_Name"), "First Name Text Field");

        type(SendTransferPage.objMiddleName, prop.getproperty("Invalid_Middle_Name"), "Middle Name Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objMiddleNameErrorMsg, getTextVal(SendTransferPage.objMiddleNameErrorMsg, "Error Message"))) {
            String sFirstNameErrorMsg = getText(SendTransferPage.objMiddleNameErrorMsg);
            String sExpectedMsg = "Middle name must only contain letters and spaces";
            assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
        }
        click(SendTransferPage.objCheckBox, "Check Box");
        Swipe("UP", 1);
        type(SendTransferPage.objLastName, prop.getproperty("Invalid_Last_Name"), "Last Name Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objLastNameErrorMsg, getTextVal(SendTransferPage.objLastNameErrorMsg, "Error Message"))) {
            String sFirstNameErrorMsg = getText(SendTransferPage.objLastNameErrorMsg);
            String sExpectedMsg = "Last name must only contain letters and spaces";
            assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
        }
        type(SendTransferPage.objLastName, prop.getproperty("Last_Name"), "Last Name Text Field");
        type(SendTransferPage.objLastName, prop.getproperty("Last_Name"), "Last Name Text Field");


        type(SendTransferPage.objMobileNumber, prop.getproperty("Invalid_MobileNumber"), "Mobile Number Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objMobileNumberErrorMsg, getTextVal(SendTransferPage.objMobileNumberErrorMsg, "Error Message"))) {
            String sFirstNameErrorMsg = getText(SendTransferPage.objMobileNumberErrorMsg);
            String sExpectedMsg = "Mobile number is invalid";
            assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
        }
        clearField(SendTransferPage.objMobileNumber, "Mobile Number Text Field");
        type(SendTransferPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "page"))) {
            logger.info("STB_TC_07, Prompt msg for Receiver's Details Invalid is validated");
            ExtentReporter.extentLoggerPass("STB_TC_07", "STB_TC_07, Prompt msg for Receiver's Details Invalid is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyAddRecipient_STB_TC_03() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"));
        addRecipient();
        waitTime(4000);
        type(SendTransferPage.objSearchRecipient, prop.getproperty("Last_Name"), "Search Recipient Text Field");
        if (verifyElementPresent(SendTransferPage.objSelectLastName(prop.getproperty("Last_Name"), prop.getproperty("First_Name")), getTextVal(SendTransferPage.objSelectLastName(prop.getproperty("Last_Name"), prop.getproperty("First_Name")), "Recipient"))) {
            logger.info("STB_TC_03, The Added Recipient is displayed in Saved Recipient Page");
            ExtentReporter.extentLoggerPass("STB_TC_03", "STB_TC_03, The Added Recipient is displayed in Saved Recipient Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToSavedRecipient_STB_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        selectSavedRecipient();
        waitTime(3000);
        click(SendTransferPage.objSelectRecipient, getTextVal(SendTransferPage.objSelectRecipient, "Button"));
        click(SendTransferPage.objCheckBox, "Check Box");
        Swipe("UP", 1);
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        waitTime(5000);
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objSendMoneySuccessful, getTextVal(SendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(SendTransferPage.objPHPAmount, getTextVal(SendTransferPage.objPHPAmount, "Amount"));
            verifyElementPresent(SendTransferPage.objDate, getTextVal(SendTransferPage.objDate, "Date"));
            verifyElementPresent(SendTransferPage.objReferenceNumber, getTextVal(SendTransferPage.objReferenceNumber, "Reference Number"));
            String sReference = getText(SendTransferPage.objReferenceNumber);
            System.out.println(sReference);
            String sReferenceNumber = sReference.substring(9, 20);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
            waitTime(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objKwartaPadala, getTextVal(MLWalletHomePage.objKwartaPadala, "Text"));
            if (verifyElementPresent(SendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(SendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(SendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sReferenceNumber);
                logger.info("STB_TC_02, Successfully sent Amount to saved Recipient and Transaction Details is validated");
                ExtentReporter.extentLoggerPass("STB_TC_02", "STB_TC_02, Successfully sent Amount to saved Recipient and Transaction Details is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyContactDuplicate_STB_TC_04() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money Contact Duplicate");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"));
        addRecipient();
        if (verifyElementPresent(SendTransferPage.objContactAlreadyExistMsg, getTextVal(SendTransferPage.objContactAlreadyExistMsg, "Error Message"))) {
            String sContactDuplicatePopupMsg = getText(SendTransferPage.objContactAlreadyExistMsg);
            String sExpectedPopupMsg = "Contact already exists.";
            assertionValidation(sContactDuplicatePopupMsg, sExpectedPopupMsg);
            logger.info("STB_TC_04, Contact already exists popup message Validated");
            ExtentReporter.extentLoggerPass("STB_TC_04", "STB_TC_04, Contact already exists popup message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyEditRecipient_STB_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch");
        sendMoneyAddRecipient_STB_TC_03();
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        selectSavedRecipient();
        click(SendTransferPage.objEditRecipient, getTextVal(SendTransferPage.objEditRecipient, "Button"));
        waitTime(4000);
        type(SendTransferPage.objEditRecipientLastName, prop.getproperty("Edited_Last_name"), "Last Name Text Field");
        click(SendTransferPage.ObjSaveRecipient, getTextVal(SendTransferPage.ObjSaveRecipient, "Button"));
        type(SendTransferPage.objSearchRecipient, prop.getproperty("Edited_Last_name"), "Search Recipient Text Field");
        if (verifyElementPresent(SendTransferPage.objSelectLastName(prop.getproperty("Edited_Last_name"), prop.getproperty("First_Name")), getTextVal(SendTransferPage.objSelectLastName(prop.getproperty("Edited_Last_name"), prop.getproperty("First_Name")), "Recipient"))) {
            logger.info("STB_TC_06, Successfully edited the Saved Recipient");
            ExtentReporter.extentLoggerPass("STB_TC_06", "STB_TC_06, Successfully edited the Saved Recipient");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyDeleteRecipient_STB_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        selectSavedRecipient();
        click(SendTransferPage.objDeleteRecipient, getTextVal(SendTransferPage.objDeleteRecipient, "Button"));
        verifyElementPresent(SendTransferPage.objPopupMsg, getTextVal(SendTransferPage.objPopupMsg, "Pop Up message"));
        String sDeleteConfirmationPopup = getText(SendTransferPage.objPopupMsg);
        String sExceptedMsg = "Are you sure you want to remove this saved recipient?";
        assertionValidation(sDeleteConfirmationPopup, sExceptedMsg);
        click(SendTransferPage.objRemoveBtn, getTextVal(SendTransferPage.objRemoveBtn, "Button"));
        clearField(SendTransferPage.objSearchRecipient, "Search Field");
        Thread.sleep(3000);
        if (verifyElementNotPresent(SendTransferPage.objSelectLastName(prop.getproperty("Edited_Last_name"), prop.getproperty("First_Name")), "Saved Recipient", 5)) {
            logger.info("STB_TC_05, Saved Recipient from Saved Recipients page not got deleted Successfully");
        } else {
            logger.info("STB_TC_05, Saved Recipient from Saved Recipients page deleted Successfully");
            ExtentReporter.extentLoggerPass("STB_TC_05", "STB_TC_05, Saved Recipient from Saved Recipients page deleted Successfully");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyInvalidAmount_STB_TC_09(String Amount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"));
        type(SendTransferPage.objAmountTxtField, Amount, "Amount text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objInvalidAmountMsg, getTextVal(SendTransferPage.objInvalidAmountMsg, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(SendTransferPage.objInvalidAmountMsg);
            String sExpectedErrorMsg = "The amount should not be less than 1";
            assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
            logger.info("STB_TC_09, The amount should not be less than 1 - Error Message is validated");
            ExtentReporter.extentLoggerPass("STB_TC_09", "STB_TC_09, The amount should not be less than 1 - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyInsufficientAmount_STB_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch");
        sendMoneyToAnyMLBranch(prop.getproperty("Semi_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("39000");
        if (verifyElementPresent(SendTransferPage.objInsufficientAmountMsg, getTextVal(SendTransferPage.objInsufficientAmountMsg, "Error Message"))) {
            String sInsufficientBalanceErrorMsg = getText(SendTransferPage.objInsufficientAmountMsg);
            String sExpectedErrorMsg = "There is insufficient balance to proceed with this transaction. Please try again.";
            assertionValidation(sInsufficientBalanceErrorMsg, sExpectedErrorMsg);
            logger.info("STB_TC_10, Insufficient Balance - Error Message is validated");
            ExtentReporter.extentLoggerPass("STB_TC_10", "STB_TC_10, Insufficient Balance - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyMaximumAmount_STB_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100000");
        if (verifyElementPresent(SendTransferPage.objMaxLimitErrorMsg, getTextVal(SendTransferPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(SendTransferPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            logger.info("STB_TC_12, The maximum send money per transaction - Error Message is validated");
            ExtentReporter.extentLoggerPass("STB_TC_12", "STB_TC_12, The maximum send money per transaction - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

//================================= Phase 2 ==================================================================//


    public void sendTransferUIValidation_STB_TC_13() throws Exception {
        ExtentReporter.HeaderChildNode("Send/Transfer page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        click(SendTransferPage.objSendTransferBtn, getTextVal(SendTransferPage.objSendTransferBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objSendMoney, getTextVal(SendTransferPage.objSendMoney, "Page"))) {
            verifyElementPresent(SendTransferPage.objSendWalletOptions, getTextVal(SendTransferPage.objSendWalletOptions, "Header"));
            verifyElementPresent(SendTransferPage.objToAnyMLBranch, getTextVal(SendTransferPage.objToAnyMLBranch, "option"));
            verifyElementPresent(SendTransferPage.objToAMLWalletUser, getTextVal(SendTransferPage.objToAMLWalletUser, "option"));
            logger.info("STB_TC_13, Send/Transfer page UI Validated");
            ExtentReporter.extentLoggerPass("STB_TC_13", "STB_TC_13, Send/Transfer page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToBranchUIValidation_STB_TC_14() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to ML Branch page UI Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"))) {
            verifyElementPresent(SendTransferPage.objSavedRecipients, getTextVal(SendTransferPage.objSavedRecipients, "Button"));
            verifyElementPresent(SendTransferPage.objFirstname, "First Name Input Field");
            verifyElementPresent(SendTransferPage.objMiddleName, "Middle Name Input Field");
            verifyElementPresent(SendTransferPage.objCheckBox, "Check box to Receiver legally does not have middle Name");
            verifyElementPresent(SendTransferPage.objLastName, "Last Name Input Field");
            verifyElementPresent(SendTransferPage.objMobileNumber, "Mobile Number Input Field");
            verifyElementPresent(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
            logger.info("STB_TC_14, Send Money to ML Branch page UI Validation");
            ExtentReporter.extentLoggerPass("STB_TC_14", "STB_TC_14, Send Money to ML Branch page UI Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToBranchSaveRecipientPageUIValidation_STB_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To Branch Save Recipient Page UI Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        verifyElementPresentAndClick(SendTransferPage.objSavedRecipients, getTextVal(SendTransferPage.objSavedRecipients, "Button"));
        waitTime(3000);
        if (verifyElementPresent(SendTransferPage.objSavedRecipients, getTextVal(SendTransferPage.objSavedRecipients, "Page"))) {
            verifyElementPresent(SendTransferPage.objAddRecipient, getTextVal(SendTransferPage.objAddRecipient, "Button"));
            verifyElementPresent(SendTransferPage.objSelectRecipient, getTextVal(SendTransferPage.objSelectRecipient, "Header"));
            verifyElementPresent(SendTransferPage.objSearchRecipient, "Search Recipient Input Field");
            if (verifyElementDisplayed(SendTransferPage.objSavedRecipientsList)) {
                List<WebElement> values = findElements(SendTransferPage.objSavedRecipientsList);
                for (int i = 0; i < values.size(); i++) {
                    String savedRecipientName = values.get(i).getText();
                    logger.info("Saved Recipient : " + savedRecipientName + " is displayed");
                    ExtentReporter.extentLogger(" ", "Saved Recipient : " + savedRecipientName + " is displayed");
                }
            } else if (verifyElementPresent(SendTransferPage.objNoRecentTransactionTxt, getTextVal(SendTransferPage.objNoRecentTransactionTxt, "Text"))) {
                logger.info("No Saved Recipients are present");
            }
            logger.info("STB_TC_15, Send Money To Branch Save Recipient Page UI Validated");
            ExtentReporter.extentLoggerPass("STB_TC_15", "STB_TC_15, Send Money To Branch Save Recipient Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToBranchSuccessUIValidation_STB_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To Branch Success UI Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objSendMoneySuccessful, getTextVal(SendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(SendTransferPage.objPHPAmount, getTextVal(SendTransferPage.objPHPAmount, "Amount"));
            verifyElementPresent(SendTransferPage.objDate, getTextVal(SendTransferPage.objDate, "Date"));
            verifyElementPresent(SendTransferPage.objReferenceNumber, getTextVal(SendTransferPage.objReferenceNumber, "Reference Number"));
            verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Header"));
            verifyElementPresent(SendTransferPage.objReceiverName, getTextVal(SendTransferPage.objReceiverName, "Receiver's Name"));
            verifyElementPresent(SendTransferPage.objReceiverMobileNo, getTextVal(SendTransferPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(SendTransferPage.objPaymentMethod, getTextVal(SendTransferPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(SendTransferPage.objAmount, getTextVal(SendTransferPage.objAmount, "Amount"));
            verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"));
            verifyElementPresent(SendTransferPage.objTotalAmount, getTextVal(SendTransferPage.objTotalAmount, "Total Amount"));
            Swipe("UP", 1);
            verifyElementPresent(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
            verifyElementPresent(SendTransferPage.objNewTransaction, getTextVal(SendTransferPage.objNewTransaction, "Button"));
            logger.info("STB_TC_16, Send Money To Branch Success page UI Validated");
            ExtentReporter.extentLoggerPass("STB_TC_16", "STB_TC_16, Send Money To Branch Success page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToBranchConfirmDetailsPageUIValidation_STB_TC_17(String nAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To Branch Confirm Details Page UI Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"));
        type(SendTransferPage.objAmountTxtField, nAmount, "Amount text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        verifyElementPresent(SendTransferPage.objSelectPaymentMethod, getTextVal(SendTransferPage.objSelectPaymentMethod, "Page"));
        Thread.sleep(3000);
        click(SendTransferPage.objMLWalletBalance, getTextVal(SendTransferPage.objMLWalletBalance, "Button"));
        if (verifyElementPresent(SendTransferPage.objConfirmDetails, getTextVal(SendTransferPage.objConfirmDetails, "Page"))) {
            verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Header"));
            verifyElementPresent(SendTransferPage.objReceiverName, getTextVal(SendTransferPage.objReceiverName, "Receiver's Name"));
            verifyElementPresent(SendTransferPage.objReceiverMobileNo, getTextVal(SendTransferPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(SendTransferPage.objPaymentMethod, getTextVal(SendTransferPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(SendTransferPage.objAmount, getTextVal(SendTransferPage.objAmount, "Amount"));
            verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"));
            verifyElementPresent(SendTransferPage.objTotalAmount, getTextVal(SendTransferPage.objTotalAmount, "Total Amount"));
            verifyElementPresent(SendTransferPage.objConfirmBtn, getTextVal(SendTransferPage.objConfirmBtn, "Button"));
            logger.info("STB_TC_17, Send Money To Branch Confirm Details Page UI Validated");
            ExtentReporter.extentLoggerPass("STB_TC_17", "STB_TC_17, Send Money To Branch Confirm Details Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToBranchSelectPaymentMethodPageUIValidation_STB_TC_18(String nAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To Branch Select Payment Method Page UI Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"));
        type(SendTransferPage.objAmountTxtField, nAmount, "Amount text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        waitTime(3000);
        if (verifyElementPresent(SendTransferPage.objSelectPaymentMethod, getTextVal(SendTransferPage.objSelectPaymentMethod, "Page"))) {
            verifyElementPresent(SendTransferPage.objMLWalletBalance, getTextVal(SendTransferPage.objMLWalletBalance, "Button"));
            verifyElementPresent(SendTransferPage.objAvailableBalance, getTextVal(SendTransferPage.objAvailableBalance, "Available PHP"));
            logger.info("STB_TC_18, Send Money To Branch Select Payment Method Page UI Validated");
            ExtentReporter.extentLoggerPass("STB_TC_18", "STB_TC_18, Send Money To Branch Select Payment Method Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToBranchEnterAmountPageUIValidation_STB_TC_19() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To Branch Enter Amount Page UI Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"))) {
            verifyElementPresent(SendTransferPage.objAmountToSend, getTextVal(SendTransferPage.objAmountToSend, "Header"));
            verifyElementPresent(SendTransferPage.objAmountTxtField, "Amount Input Field");
            verifyElementPresent(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
            logger.info("STB_TC_19, Send Money To Branch Enter Amount Page UI Validated");
            ExtentReporter.extentLoggerPass("STB_TC_19", "STB_TC_19, Send Money To Branch Enter Amount Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void kwartaPadalaTransactionDetailsUIValidation_STB_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Kwarta Padala Transaction Details UI Validation");
        sendMoneyToMLBranch_STB_TC_01();
        if (verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Header"))) {
            verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Text"));
            verifyElementPresent(SendTransferPage.objKwartaPadalaDate, getTextVal(SendTransferPage.objKwartaPadalaDate, "Kwarta Padala Date"));
            verifyElementPresent(SendTransferPage.objReceiverName, getTextVal(SendTransferPage.objReceiverName, "Receiver's Name"));
            verifyElementPresent(SendTransferPage.objReceiverMobileNo, getTextVal(SendTransferPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(SendTransferPage.objPaymentMethod, getTextVal(SendTransferPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(SendTransferPage.objAmount, getTextVal(SendTransferPage.objAmount, "Amount"));
            verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"));
            verifyElementPresent(SendTransferPage.objTotalAmount, getTextVal(SendTransferPage.objTotalAmount, "Total Amount"));
            logger.info("STB_TC_20, Kwarta Padala Transaction Details page UI Validated");
            ExtentReporter.extentLoggerPass("STB_TC_20", "STB_TC_20, Kwarta Padala Transaction Details page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToBranchAddRecipientPageUIValidation_STB_TC_21() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To Branch Add Recipient Page UI Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        if (verifyElementPresent(SendTransferPage.objSavedRecipients, getTextVal(SendTransferPage.objSavedRecipients, "Button"))) {
            click(SendTransferPage.objSavedRecipients, getTextVal(SendTransferPage.objSavedRecipients, "Button"));
            click(SendTransferPage.objAddRecipient, getTextVal(SendTransferPage.objAddRecipient, "Button"));
            waitTime(5000);
            if (verifyElementPresent(SendTransferPage.objAddRecipient, getTextVal(SendTransferPage.objAddRecipient, "Page"))) {
                verifyElementPresent(SendTransferPage.objFirstname, "First Name Text Field");
                verifyElementPresent(SendTransferPage.objMiddleName, "Middle Name Text Field");
                verifyElementPresent(SendTransferPage.objCheckBox, "Check Box");
                verifyElementPresent(SendTransferPage.objLastName, "Last Name Text Field");
                verifyElementPresent(SendTransferPage.objMobileNumber, "Last Name Text Field");
                verifyElementPresent(SendTransferPage.objNickName, "Nick Name Text Field");
                verifyElementPresent(SendTransferPage.ObjSaveRecipient, getTextVal(SendTransferPage.ObjSaveRecipient, "Button"));
                logger.info("STB_TC_21, Send Money To Branch Add Recipient Page UI Validated");
                ExtentReporter.extentLoggerPass("STB_TC_21", "STB_TC_21, Send Money To Branch Add Recipient Page UI Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void sendMoneyToMLBranchBuyerTierAccount_STB_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch, Buyer Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Buyer_Tier"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        if (verifyElementPresent(SendTransferPage.objErrorMsg, getTextVal(SendTransferPage.objErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(SendTransferPage.objErrorMsg);
            String sExpectedErrorMsg = "Send Money is not allowed for customers at this verification level. Please upgrade your account to use this service.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(SendTransferPage.objUpgradeNowBtn, getTextVal(SendTransferPage.objUpgradeNowBtn, "Button"));
            logger.info("STB_TC_22, Send Money is not allowed for customers at this Buyer tier - Error Message is validated");
            ExtentReporter.extentLoggerPass("STB_TC_22", "STB_TC_22, Send Money is not allowed for customers at this Buyer tier  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchSemiVerifiedTierAccount_STB_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch, Semi verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Semi_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objSendMoneySuccessful, getTextVal(SendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Header"));
            verifyElementPresent(SendTransferPage.objReferenceNumber, getTextVal(SendTransferPage.objReferenceNumber, "Reference Number"));
            logger.info("STB_TC_23, Send Money To ML Branch, Semi verified Tier Account transaction validated");
            ExtentReporter.extentLoggerPass("STB_TC_23", "STB_TC_23, Send Money To ML Branch, Semi verified Tier Account transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchBranchVerifiedAccount_STB_TC_24() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch, Branch verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objSendMoneySuccessful, getTextVal(SendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Header"));
            verifyElementPresent(SendTransferPage.objReferenceNumber, getTextVal(SendTransferPage.objReferenceNumber, "Reference Number"));
            logger.info("STB_TC_24, Send Money To ML Branch, Branch verified Tier Account transaction validated");
            ExtentReporter.extentLoggerPass("STB_TC_24", "STB_TC_24, Send Money To ML Branch, Branch verified Tier Account transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchFullyVerifiedAccount_STB_TC_25() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch, Branch verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Fully_verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objSendMoneySuccessful, getTextVal(SendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Header"));
            verifyElementPresent(SendTransferPage.objReferenceNumber, getTextVal(SendTransferPage.objReferenceNumber, "Reference Number"));
            logger.info("STB_TC_25, Send Money To ML Branch, Branch verified Tier Account transaction validated");
            ExtentReporter.extentLoggerPass("STB_TC_25", "STB_TC_25, Send Money To ML Branch, Branch verified Tier Account transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchSemiVerifiedTierAccountMaxAmount_STB_TC_26() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch, Semi verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Semi_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("20000");
        if (verifyElementPresent(SendTransferPage.objErrorMsg, getTextVal(SendTransferPage.objErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(SendTransferPage.objErrorMsg);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P10,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(SendTransferPage.objUpgradeNowBtn, getTextVal(SendTransferPage.objUpgradeNowBtn, "Button"));
            logger.info("STB_TC_26, Send Money To ML Branch, Semi verified Tier Account Maximum Transaction - Error Message is validated");
            ExtentReporter.extentLoggerPass("STB_TC_26", "STB_TC_26, Send Money To ML Branch, Semi verified Tier Account Maximum Transaction  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchBranchVerifiedTierAccountMaxAmount_STB_TC_29() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch, Branch verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("60000");
        if (verifyElementPresent(SendTransferPage.objMaxLimitErrorMsg, getTextVal(SendTransferPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(SendTransferPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(SendTransferPage.objOkBtn, getTextVal(SendTransferPage.objOkBtn, "Button"));
            logger.info("STB_TC_29, Send Money To ML Branch, Branch verified Tier Account Maximum Transaction - Error Message is validated");
            ExtentReporter.extentLoggerPass("STB_TC_29", "STB_TC_29, Send Money To ML Branch, Branch verified Tier Account Maximum Transaction  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchFullyVerifiedTierAccountMaxAmount_STB_TC_32() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch, Fully verified Tier Account");
        sendMoneyToAnyMLBranch(prop.getproperty("Fully_verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("60000");
        if (verifyElementPresent(SendTransferPage.objMaxLimitErrorMsg, getTextVal(SendTransferPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(SendTransferPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(SendTransferPage.objOkBtn, getTextVal(SendTransferPage.objOkBtn, "Button"));
            logger.info("STB_TC_32, Send Money To ML Branch, Fully verified Tier Account Maximum Transaction - Error Message is validated");
            ExtentReporter.extentLoggerPass("STB_TC_32", "STB_TC_32, Send Money To ML Branch, Fully verified Tier Account Maximum Transaction  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void kwartaPadalaRates_STB_TC_35() throws Exception {
        ExtentReporter.HeaderChildNode("Kwarta Padala Rates");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu");
        verifyElementPresentAndClick(SendTransferPage.objKwartaPadalaRatesBtn, "Kwarta Padala Rates");
        if (verifyElementPresent(SendTransferPage.objKwartaPadalaRates, "Kwarta Padala Rates")) {
            List<WebElement> values = findElements(SendTransferPage.objKwartaPadalaRates);
            for (int i = 0; i < values.size(); i++) {
                if (i % 2 != 0) {
                    String sRates = values.get(i).getText();
                    logger.info("Rates : " + sRates + " is displayed");
                    ExtentReporter.extentLogger(" ", "Rates : " + sRates + " is displayed");
                }
                if (i % 2 == 0) {
                    String sAmountRange = values.get(i).getText();
                    logger.info("Amount Range : " + sAmountRange + " is displayed");
                    ExtentReporter.extentLogger(" ", "Amount Range : " + sAmountRange + " is displayed");
                }
            }
            logger.info("STB_TC_35, Kwarta Padala Rates validated");
            ExtentReporter.extentLoggerPass("STB_TC_35", "STB_TC_35, Kwarta Padala Rates validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioOne_STB_TC_36(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP0.50 for PHP0.01 to PHP50.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 0.50";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_36, Send Money To ML Branch charged PHP0.50 for 0.01 to PHP50.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_36", "STB_TC_36, Send Money To ML Branch charged PHP0.50 for PHP0.01 to PHP50.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioTwo_STB_TC_37(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP1.00 for PHP50.01 to PHP100.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 1.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_36, Send Money To ML Branch charged PHP1.00 for PHP50.01 to PHP100.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_36", "STB_TC_36, Send Money To ML Branch charged PHP1.00 for PHP50.01 to PHP100.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioThree_STB_TC_38(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP2.00 for PHP100.01 to PHP300.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 2.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_38, Send Money To ML Branch charged PHP2.00 for PHP100.01 to PHP300.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_38", "STB_TC_38, Send Money To ML Branch charged PHP2.00 for PHP100.01 to PHP300.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioFour_STB_TC_39(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP3.00 for PHP300.01 to PHP400.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 3.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_39, Send Money To ML Branch charged PHP3.00 for PHP300.01 to PHP400.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_39", "STB_TC_39, Send Money To ML Branch charged PHP3.00 for PHP300.01 to PHP400.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioFive_STB_TC_40(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP5.00 for PHP400.01 to PHP500.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 5.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_40, Send Money To ML Branch charged PHP5.00 for PHP400.01 to PHP500.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_40", "STB_TC_40, Send Money To ML Branch charged PHP5.00 for PHP400.01 to PHP500.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioSix_STB_TC_41(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP8.00 for PHP500.01 to PHP600.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 8.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_41, Send Money To ML Branch charged PHP5.00 for PHP8.00 to PHP600.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_41", "STB_TC_41, Send Money To ML Branch charged PHP8.00 for PHP500.01 to PHP600.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioSeven_STB_TC_42(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP10.00 for PHP600.01 to PHP700.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 10.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_42, Send Money To ML Branch charged PHP10.00 for PHP600.01 to PHP700.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_42", "STB_TC_42, Send Money To ML Branch charged PHP10.00 for PHP600.01 to PHP700.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioEight_STB_TC_43(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP12.00 for PHP700.01 to PHP900.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 12.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_43, Send Money To ML Branch charged PHP12.00 for PHP700.01 to PHP900.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_43", "STB_TC_43 , Send Money To ML Branch charged PHP12.00 for PHP700.01 to PHP900.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioNine_STB_TC_44(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP15.00 for PHP900.01 to PHP1000.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 15.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_44, Send Money To ML Branch charged PHP15.00 for PHP900.01 to PHP1000.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_44", "STB_TC_44 , Send Money To ML Branch charged PHP15.00 for PHP900.01 to PHP1000.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioTen_STB_TC_45(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP20.00 for PHP1000.01 to PHP1500.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 20.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_45, Send Money To ML Branch charged PHP20.00 for PHP1000.01 to PHP1500.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_45", "STB_TC_45 , Send Money To ML Branch charged PHP20.00 for PHP1000.01 to PHP1500.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioEleven_STB_TC_46(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP30.00 for PHP1500.01 to PHP2000.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 30.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_46, Send Money To ML Branch charged PHP30.00 for PHP1500.01 to PHP2000.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_46", "STB_TC_46 , Send Money To ML Branch charged PHP30.00 for PHP1500.01 to PHP2000.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchRatesValidationScenarioTwelve_STB_TC_47(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP40.00 for PHP2000.01 to PHP2500.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 40.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_47, Send Money To ML Branch charged PHP40.00 for PHP2000.01 to PHP2500.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_47", "STB_TC_47 , Send Money To ML Branch charged PHP40.00 for PHP2000.01 to PHP2500.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchRatesValidationScenarioThirteen_STB_TC_48(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch charged PHP500.00 for PHP2500.01 to PHP50000.00");
        sendMoneyToMLBranchRatesValidation(sAmount);
        if (verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"))) {
            String sServiceFee = getText(SendTransferPage.objServiceFee);
            String sExceptedServiceFee = "Php 500.00";
            assertionValidation(sServiceFee, sExceptedServiceFee);
            logger.info("STB_TC_48, Send Money To ML Branch charged PHP500.00 for PHP2500.01 to PHP50000.00 validated");
            ExtentReporter.extentLoggerPass("STB_TC_48", "STB_TC_48 , Send Money To ML Branch charged PHP500.00 for PHP2500.01 to PHP50000.00 validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchLocationPopupValidation_STB_TC_50() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch Location popup Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpValidation();
            logger.info("STB_TC_50, Send Money To ML Branch Location popup Validated");
            ExtentReporter.extentLoggerPass("STB_TC_50", "STB_TC_50, Send Money To ML Branch Location popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchLocationDenyFunctionality_STB_TC_51() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch Location Deny Functionality Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyPopUp();
            logger.info("STB_TC_51, Send Money To ML Branch Location Deny Functionality Validated");
            ExtentReporter.extentLoggerPass("STB_TC_51", "STB_TC_51, Send Money To ML Branch Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchLocationPermissionDenyCloseBtnFunctionality_STB_TC_52() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch Location Permission Deny Close Button Functionality Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyCloseBtnFunctionality();
            if (verifyElementPresent(SendTransferPage.objKwartaPadala, getTextVal(SendTransferPage.objKwartaPadala, "Page"))) {
                logger.info("STB_TC_52, Send Money To ML Branch Location Permission Deny Close Button Functionality Validated");
                ExtentReporter.extentLoggerPass("STB_TC_52", "STB_TC_52, Send Money To ML Branch Location Permission Deny Close Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void sendMoneyToMLBranchLocationPermissionDenyOpenSettingsBtnFunctionality_STB_TC_53() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch Location Permission Deny open Settings Button Functionality Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyOpenSettingsBtnFunctionality();
            if (verifyElementPresent(SendTransferPage.objAppInfo, getTextVal(SendTransferPage.objAppInfo, "Page"))) {
                logger.info("STB_TC_53, Send Money To ML Branch Location Permission Deny Open Settings Button Functionality Validated");
                ExtentReporter.extentLoggerPass("STB_TC_53", "STB_TC_53, Send Money To ML Branch Location Permission Deny Open Settings Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyToMLBranchLocationPopUpAllowFunctionality_STB_TC_54() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch Location popup Allow Button Functionality Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpAllowFunctionality();
            if (verifyElementDisplayed(MLWalletLoginPage.objOneTimePin)) {
                verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
            } else if (verifyElementDisplayed(MLWalletLoginPage.objMLPin)) {
                verifyElementPresent(MLWalletLoginPage.objMLPin, getTextVal(MLWalletLoginPage.objMLPin, "Page"));
            }
            logger.info("STB_TC_54, Send Money To ML Branch Location popup Allow Button Functionality Validated");
            ExtentReporter.extentLoggerPass("STB_TC_54", "STB_TC_54, Send Money To ML Branch Location popup Allow Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchInternetInterruptionWhileEnteringOTP_STB_TC_55() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch Internet Interruption While Entering OTP Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        waitTime(15000);
        setWifiConnectionToONOFF("OFF");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"))) {
            internetConnectionError();
            logger.info("STB_TC_55, Send Money To ML Branch Internet Interruption While Entering OTP Validated");
            ExtentReporter.extentLoggerPass("STB_TC_55", "STB_TC_55, Send Money To ML Branch Internet Interruption While Entering OTP Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchTransactionValidationAfterMinimizingApp_STB_TC_58() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch Transaction Validation After Minimizing App");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        if (verifyElementPresent(SendTransferPage.objSendMoneySuccessful, getTextVal(SendTransferPage.objSendMoneySuccessful, "Message"))) {
            logger.info("STB_TC_58, Send Money To ML Branch Transaction Validation After Minimizing App Validated");
            ExtentReporter.extentLoggerPass("STB_TC_58", "STB_TC_58, Send Money To ML Branch Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchTransactionWithValidMLPin_STB_TC_64() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch Transaction With Valid ML Pin");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        handleMpin("1111");
        if (verifyElementPresent(SendTransferPage.objSendMoneySuccessful, getTextVal(SendTransferPage.objSendMoneySuccessful, "Message"))) {
            verifyElementPresent(SendTransferPage.objPHPAmount, getTextVal(SendTransferPage.objPHPAmount, "Amount"));
            verifyElementPresent(SendTransferPage.objDate, getTextVal(SendTransferPage.objDate, "Date"));
            verifyElementPresent(SendTransferPage.objReferenceNumber, getTextVal(SendTransferPage.objReferenceNumber, "Reference Number"));
            String sReference = getText(SendTransferPage.objReferenceNumber);
            System.out.println(sReference);
            String sReferenceNumber = sReference.substring(9, 20);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objKwartaPadala, getTextVal(MLWalletHomePage.objKwartaPadala, "Text"));
            if (verifyElementPresent(SendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(SendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(SendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sReferenceNumber);
                logger.info("STB_TC_64, Send Money to any ML Branch Transaction With Valid ML Pin validated");
                ExtentReporter.extentLoggerPass("STB_TC_64", "STB_TC_64, Send Money to any ML Branch Transaction With Valid ML Pin validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void sendMoneyToMLBranchTransactionWithInValidMLPin_STB_TC_65() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch Transaction With Invalid ML Pin");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        waitTime(3000);
        enableLocation_PopUp();
        handleMpin("1234");
        if (verifyElementPresent(SendTransferPage.objInvalidPINMsg, getTextVal(SendTransferPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(SendTransferPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("STB_TC_65, Send Money to any ML Branch Transaction With Invalid ML Pin validated");
            ExtentReporter.extentLoggerPass("STB_TC_65", "STB_TC_65, Send Money to any ML Branch Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchInOTPPopupValidation_STB_TC_71() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch InApp OTP popup Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            logger.info("STB_TC_71, Send Money To ML Branch, InApp OTP popup validated");
            ExtentReporter.extentLoggerPass("STB_TC_71", "STB_TC_71, Send Money To ML Branch, InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchTransactionInAppOTPPopupUIValidation_STB_TC_72() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch Transaction InApp OTP popup UI Validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds, getTextVal(MLWalletLoginPage.objSeconds, "Seconds"));
            verifyElementPresent(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
            logger.info("STB_TC_72, Send Money To ML Branch Transaction InApp OTP popup UI validated");
            ExtentReporter.extentLoggerPass("STB_TC_72", "STB_TC_72, Send Money To ML Branch Transaction InApp OTP popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchTransactionNewOTPAfterSixtySecondsValidation_STB_TC_73() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch New OTP got generated After Sixty Seconds validation");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if (verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"))) {
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP, sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("STB_TC_73, Send Money To ML Branch Transaction New OTP got generated After Sixty Seconds is validated");
            ExtentReporter.extentLoggerPass("STB_TC_73", "STB_TC_73, Send Money To ML Branch Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLBranchTransactionOTPCancelBtnFunctionality_STB_TC_74() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch Transaction OTP Cancel Button Functionality");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objConfirmDetails, getTextVal(SendTransferPage.objConfirmDetails, "Page"))) {
            logger.info("STB_TC_74, Send Money To ML Branch Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            ExtentReporter.extentLoggerPass("STB_TC_74", "STB_TC_74, Send Money To ML Branch Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLBranchTransactionOTPContinueBtnFunctionality_STB_TC_75() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Branch Transaction OTP Continue Button Functionality");
        sendMoneyToAnyMLBranch(prop.getproperty("Branch_Verified"));
        enterMLBranchDetails();
        enterAmountToKwartaPadala("100");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objSendMoneySuccessful, getTextVal(SendTransferPage.objSendMoneySuccessful, "Message"))) {
            logger.info("STB_TC_75, Send Money To ML Branch Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            ExtentReporter.extentLoggerPass("STB_TC_75", "STB_TC_75, Send Money To ML Branch Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
