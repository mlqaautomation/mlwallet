package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.mlwallet.pages.*;
import com.utility.ExtentReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.utility.Utilities.*;

public class BillsPayClass extends BaseClass{
    public BillsPayClass(String Application, String deviceName, String portno) throws InterruptedException {
        super(Application, deviceName, portno);
    }

    public void payBillsPageValidation_PB_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Page Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        if (verifyElementPresent(MLWalletPayBillsPage.objSelectBiller, getTextVal(MLWalletPayBillsPage.objSelectBiller, "Page"))) {
            verifyElementPresent(MLWalletPayBillsPage.objRecentTransactions, getTextVal(MLWalletPayBillsPage.objRecentTransactions, "Button"));
            verifyElementPresent(MLWalletPayBillsPage.objBillers, getTextVal(MLWalletPayBillsPage.objBillers, "Text"));
            logger.info("PB_TC_01, Pay Bills Page validated");
            ExtentReporter.extentLoggerPass("PB_TC_01", "PB_TC_01, Pay Bills Page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void billerCategories_PB_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("Biller Categories");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        click(MLWalletPayBillsPage.objCategories, getTextVal(MLWalletPayBillsPage.objCategories, "Button"));
        if (verifyElementPresent(MLWalletPayBillsPage.objBankingAndFinance, getTextVal(MLWalletPayBillsPage.objBankingAndFinance, "Button"))) {
            click(MLWalletPayBillsPage.objBankingAndFinance, getTextVal(MLWalletPayBillsPage.objBankingAndFinance, "Biller Category"));
        }
        if (verifyElementPresent(MLWalletPayBillsPage.objCharityAndReligious, getTextVal(MLWalletPayBillsPage.objCharityAndReligious, "Biller Category"))) {
            click(MLWalletPayBillsPage.objCharityAndReligious, getTextVal(MLWalletPayBillsPage.objCharityAndReligious, "Biller Category"));
            getBillers(MLWalletPayBillsPage.objCharityAndReligiousBillers);
            click(MLWalletPayBillsPage.objCharityAndReligious, getTextVal(MLWalletPayBillsPage.objCharityAndReligious, "Biller Category"));
        }
        Swipe("UP", 1);
        if (verifyElementPresent(MLWalletPayBillsPage.objUtilities, getTextVal(MLWalletPayBillsPage.objUtilities, "Biller Category"))) {
            click(MLWalletPayBillsPage.objUtilities, getTextVal(MLWalletPayBillsPage.objUtilities, "Biller Category"));
            Swipe("UP", 1);
            getBillers(MLWalletPayBillsPage.objUtilitiesBillers);
            click(MLWalletPayBillsPage.objUtilities, getTextVal(MLWalletPayBillsPage.objUtilities, "Biller Category"));
        }
        if (verifyElementPresent(MLWalletPayBillsPage.objOthers, getTextVal(MLWalletPayBillsPage.objOthers, "Biller Category"))) {
            click(MLWalletPayBillsPage.objOthers, getTextVal(MLWalletPayBillsPage.objOthers, "Biller Category"));
            Swipe("UP", 1);
            getBillers(MLWalletPayBillsPage.objOthersBillers);
            click(MLWalletPayBillsPage.objOthers, getTextVal(MLWalletPayBillsPage.objOthers, "Biller Category"));
        }
        logger.info("PB_TC_02, Biller Categories validated");
        ExtentReporter.extentLoggerPass("PB_TC_02", "PB_TC_02, Biller Categories validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void billersInAlphabeticalOrder_PB_TC_03() throws Exception {
        ExtentReporter.HeaderChildNode("Billers In Alphabetical Order");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        click(MLWalletPayBillsPage.objAlphabetical, getTextVal(MLWalletPayBillsPage.objAlphabetical, "Button"));
        swipeDownUntilElementVisible("SAGIP KAPAMILYA");
        swipeDownUntilElementVisible("ZYBITECH");
        logger.info("PB_TC_03, Billers swiped until Z Alphabet, and all the Billers are displayed in alphabetical order");
        ExtentReporter.extentLoggerPass("PB_TC_03", "PB_TC_03, Billers swiped until Z Alphabet, and all the Billers are displayed in alphabetical order");
        System.out.println("-----------------------------------------------------------");
    }

    public void selectBiller_PB_TC_04() throws Exception {
        ExtentReporter.HeaderChildNode("Select Biller");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        click(MLWalletPayBillsPage.objAlphabetical, getTextVal(MLWalletPayBillsPage.objAlphabetical, "Button"));
        swipeDownUntilElementVisible("AIR ASIA BILLSPAYMENT");
        if (verifyElementPresent(MLWalletPayBillsPage.objAirAsia, getTextVal(MLWalletPayBillsPage.objAirAsia, "Biller"))) {
            String sAirAsiaBillsPayment = getText(MLWalletPayBillsPage.objAirAsia);
            click(MLWalletPayBillsPage.objAirAsia, getTextVal(MLWalletPayBillsPage.objAirAsia, "Biller"));
            verifyElementPresent(MLWalletPayBillsPage.objBillsPayInformation, getTextVal(MLWalletPayBillsPage.objBillsPayInformation, "Page"));
            if (verifyElementPresent(MLWalletPayBillsPage.objBillerNameInBillsPayInformation, getTextVal(MLWalletPayBillsPage.objBillerNameInBillsPayInformation, "Biller Name"))) {
                String sBillerInBillsPayInformation = getText(MLWalletPayBillsPage.objBillerNameInBillsPayInformation);
                assertionValidation(sAirAsiaBillsPayment, sBillerInBillsPayInformation);
                logger.info("PB_TC_04, Bills Pay Information page is displayed and Biller name is matched");
                ExtentReporter.extentLoggerPass("PB_TC_04", "PB_TC_04, Bills Pay Information page is displayed and Biller name is matched");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void searchBiller_PB_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("Search Biller");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        Thread.sleep(5000);
        type(MLWalletPayBillsPage.objSearchBiller, prop.getproperty("Biller_Name"), "Search Biller");
        if (verifyElementPresent(MLWalletPayBillsPage.objMisBillsPayBiller, getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller, "Biller"))) {
            String sMisBillsPayBiller = getText(MLWalletPayBillsPage.objMisBillsPayBiller);
            click(MLWalletPayBillsPage.objMisBillsPayBiller, getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller, "Biller"));
            verifyElementPresent(MLWalletPayBillsPage.objBillsPayInformation, getTextVal(MLWalletPayBillsPage.objBillsPayInformation, "Page"));
            if (verifyElementPresent(MLWalletPayBillsPage.objBillerNameInBillsPayInformation, getTextVal(MLWalletPayBillsPage.objBillerNameInBillsPayInformation, "Biller Name"))) {
                String sBillerInBillsPayInformation = getText(MLWalletPayBillsPage.objBillerNameInBillsPayInformation);
                assertionValidation(sMisBillsPayBiller, sBillerInBillsPayInformation);
                logger.info("PB_TC_05, Bills Pay Information page is displayed and Biller name is MIS BILLSPAY123456");
                ExtentReporter.extentLoggerPass("PB_TC_05", "PB_TC_05, Bills Pay Information page is displayed and Biller name is MIS BILLSPAY123456");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void billingInformationInput_PB_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("Biller Information Input");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        if (verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"))) {
            verifyElementPresent(MLWalletPayBillsPage.objBillerName, getTextVal(MLWalletPayBillsPage.objBillerName, "Biller Name"));
            verifyElementPresent(MLWalletPayBillsPage.objAccountName, getTextVal(MLWalletPayBillsPage.objAccountName, "Account holder Name"));
            verifyElementPresent(MLWalletPayBillsPage.objAccountNumber, getTextVal(MLWalletPayBillsPage.objAccountNumber, "Account Number"));
            verifyElementPresent(MLWalletPayBillsPage.objPaymentMethod, getTextVal(MLWalletPayBillsPage.objPaymentMethod, "Payment Method"));
            logger.info("PB_TC_06, Confirm Details page displayed with transaction details is validated");
            ExtentReporter.extentLoggerPass("PB_TC_06", "PB_TC_06, Confirm Details page displayed with transaction details is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsWithValidInputs_PB_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills With Valid Inputs");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletPayBillsPage.objSuccessPillPaymentMsg, getTextVal(MLWalletPayBillsPage.objSuccessPillPaymentMsg, "Message"))) {
            verifyElementPresent(MLWalletPayBillsPage.objAmountPaid, getTextVal(MLWalletPayBillsPage.objAmountPaid, "Amount"));
            verifyElementPresent(MLWalletPayBillsPage.objPaidDate, getTextVal(MLWalletPayBillsPage.objPaidDate, "Date"));
            verifyElementPresent(MLWalletPayBillsPage.objTransactionDetails, getTextVal(MLWalletPayBillsPage.objTransactionDetails, "Header"));
            verifyElementPresent(MLWalletPayBillsPage.objTransactionNumber, getTextVal(MLWalletPayBillsPage.objTransactionNumber, "Transaction Number"));
            String sTransactionNumber = getText(MLWalletPayBillsPage.objTransactionNumber);
            verifyElementPresent(MLWalletPayBillsPage.objBillerName, getTextVal(MLWalletPayBillsPage.objBillerName, "Biller Name"));
            verifyElementPresent(MLWalletPayBillsPage.objAccountName, getTextVal(MLWalletPayBillsPage.objAccountName, "Account Name"));
            verifyElementPresent(MLWalletPayBillsPage.objPaymentMethod, getTextVal(MLWalletPayBillsPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletPayBillsPage.objAmountToPay, getTextVal(MLWalletPayBillsPage.objAmountToPay, "Amount"));
            verifyElementPresent(MLWalletPayBillsPage.objServiceFee, getTextVal(MLWalletPayBillsPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletPayBillsPage.objTotalAmount, getTextVal(MLWalletPayBillsPage.objTotalAmount, "Total Amount"));
            verifyElementPresentAndClick(MLWalletPayBillsPage.objBackToHomeBtn, getTextVal(MLWalletPayBillsPage.objBackToHomeBtn, "Button"));
            waitTime(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objPayBills, getTextVal(MLWalletHomePage.objPayBills, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sTransactionNumber);
                logger.info("PB_TC_07, Bills Payment Successful and validated with Recent Transaction");
                ExtentReporter.extentLoggerPass("PB_TC_07", "PB_TC_07, Bills Payment Successful and validated with Recent Transaction");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void payBillsInRecentTransactions_PB_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills In Recent Transactions");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        click(MLWalletHomePage.objPayBills, getTextVal(MLWalletHomePage.objPayBills, "Text"));
        if (verifyElementPresent(MLWalletPayBillsPage.objTransactionDetails, getTextVal(MLWalletPayBillsPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletPayBillsPage.objReferenceNumber, getTextVal(MLWalletPayBillsPage.objReferenceNumber, "Reference Number"));
            verifyElementPresent(MLWalletPayBillsPage.objReceiverName, getTextVal(MLWalletPayBillsPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletPayBillsPage.objBillerName, getTextVal(MLWalletPayBillsPage.objBillerName, "Biller Name"));
            verifyElementPresent(MLWalletPayBillsPage.objReceiverMobNo, getTextVal(MLWalletPayBillsPage.objReceiverMobNo, "Receiver Mobile Number"));
            verifyElementPresent(MLWalletPayBillsPage.objPaymentMethod, getTextVal(MLWalletPayBillsPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletPayBillsPage.objAmountToSend, getTextVal(MLWalletPayBillsPage.objAmountToSend, "Amount"));
            verifyElementPresent(MLWalletPayBillsPage.objServiceFee, getTextVal(MLWalletPayBillsPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletPayBillsPage.objTotalAmount, getTextVal(MLWalletPayBillsPage.objTotalAmount, "Total Amount"));
            logger.info("PB_TC_08, Pay Bills In Recent Transactions Validated");
            ExtentReporter.extentLoggerPass("PB_TC_08", "PB_TC_08, Pay Bills In Recent Transactions Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsInsufficientBalance_PB_TC_09() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Insufficient Balance");
        mlWalletLogin("9999999997");
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "24000");
        confirmDetailsAndPay();
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objInsufficientAmountMsg, getTextVal(SendTransferPage.objInsufficientAmountMsg, "Error Message"))) {
            String sInsufficientBalanceErrorMsg = getText(SendTransferPage.objInsufficientAmountMsg);
            String sExpectedErrorMsg = "There is insufficient balance to proceed with this transaction. Please try again.";
            assertionValidation(sInsufficientBalanceErrorMsg, sExpectedErrorMsg);
            logger.info("PB_TC_09, Insufficient Balance - Error Message is validated");
            ExtentReporter.extentLoggerPass("PB_TC_09", "PB_TC_09, Insufficient Balance - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void billingInformationInvalidInput_PB_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("Biller Information Invalid Input");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        searchBiller();
        click(MLWalletPayBillsPage.objConfirmBtn, getTextVal(MLWalletPayBillsPage.objConfirmBtn, "Button"));
        if (verifyElementPresent(MLWalletPayBillsPage.objAccountNumberRequiredMsg, getTextVal(MLWalletPayBillsPage.objAccountNumberRequiredMsg, "Error Message"))) {
            String sAccountNumberRequiredErrorMsg = getText(MLWalletPayBillsPage.objAccountNumberRequiredMsg);
            String sExceptedAccountNumberRequiredErrorMsg = "Account Number is required";
            assertionValidation(sAccountNumberRequiredErrorMsg, sExceptedAccountNumberRequiredErrorMsg);
        }
        if (verifyElementPresent(MLWalletPayBillsPage.objFirstNameRequiredMsg, getTextVal(MLWalletPayBillsPage.objFirstNameRequiredMsg, "Error Message"))) {
            String sFirstNameRequiredErrorMsg = getText(MLWalletPayBillsPage.objFirstNameRequiredMsg);
            String sExceptedFirstNameRequiredErrorMsg = "First name is required";
            assertionValidation(sFirstNameRequiredErrorMsg, sExceptedFirstNameRequiredErrorMsg);
        }

        if (verifyElementPresent(MLWalletPayBillsPage.objLastNameRequiredMsg, getTextVal(MLWalletPayBillsPage.objLastNameRequiredMsg, "Error Message"))) {
            String sLastNameRequiredErrorMsg = getText(MLWalletPayBillsPage.objLastNameRequiredMsg);
            String sExceptedLastNameRequiredErrorMsg = "Last name is required";
            assertionValidation(sLastNameRequiredErrorMsg, sExceptedLastNameRequiredErrorMsg);
        }

        billerDetails(prop.getproperty("Invalid_First_Name"), prop.getproperty("Invalid_Middle_Name"), prop.getproperty("Invalid_Last_Name"), "0.99");
        if (verifyElementPresent(MLWalletPayBillsPage.objInvalidFirstNameMsg, getTextVal(MLWalletPayBillsPage.objInvalidFirstNameMsg, "Error Message"))) {
            String sInvalidFirstNameErrorMsg = getText(MLWalletPayBillsPage.objInvalidFirstNameMsg);
            String sExceptedFirstNameErrorMsg = "First name must only contain letters and spaces";
            assertionValidation(sInvalidFirstNameErrorMsg, sExceptedFirstNameErrorMsg);
        }
        if (verifyElementPresent(MLWalletPayBillsPage.objInvalidSecondNameMsg, getTextVal(MLWalletPayBillsPage.objInvalidSecondNameMsg, "Error Message"))) {
            String sInvalidSecondNameErrorMsg = getText(MLWalletPayBillsPage.objInvalidSecondNameMsg);
            String sExceptedSecondNameErrorMsg = "Middle name must only contain letters and spaces";
            assertionValidation(sInvalidSecondNameErrorMsg, sExceptedSecondNameErrorMsg);
        }
        if (verifyElementPresent(MLWalletPayBillsPage.objInvalidLastName, getTextVal(MLWalletPayBillsPage.objInvalidLastName, "Error Message"))) {
            String sInvalidThirdNameErrorMsg = getText(MLWalletPayBillsPage.objInvalidLastName);
            String sExceptedThirdNameErrorMsg = "Last name must only contain letters and spaces";
            assertionValidation(sInvalidThirdNameErrorMsg, sExceptedThirdNameErrorMsg);
        }
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "0.99");
        Swipe("UP", 1);

        if (verifyElementPresent(MLWalletPayBillsPage.objInvalidAmount, getTextVal(MLWalletPayBillsPage.objInvalidAmount, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(MLWalletPayBillsPage.objInvalidAmount);
            String sExceptedAmountErrorMsg = "The amount should not be less than 1";
            assertionValidation(sInvalidAmountErrorMsg, sExceptedAmountErrorMsg);
        }

        logger.info("PB_TC_10, Invalid biller Information Error messages validated");
        ExtentReporter.extentLoggerPass("PB_TC_10", "PB_TC_10, Invalid biller Information Error messages validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void addBillerToPayBills_PB_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Add Biller To Pay Bills");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        addBiller();
        click(MLWalletPayBillsPage.objOKBtn, getTextVal(MLWalletPayBillsPage.objOKBtn, "Button"));
        type(MLWalletPayBillsPage.objSearchSavedBiller, prop.getproperty("Last_Name"), "Search Biller Text Field");
        if (verifyElementPresent(MLWalletPayBillsPage.objSelectBillerInnSavedBiller(prop.getproperty("Last_Name")), getTextVal(MLWalletPayBillsPage.objSelectBillerInnSavedBiller(prop.getproperty("Last_Name")), "Recipient"))) {
            logger.info("PB_TC_12, The Added Biller is displayed in Saved Biller Page");
            ExtentReporter.extentLoggerPass("PB_TC_12", "PB_TC_12, The Added Biller is displayed in Saved Biller Page");
            System.out.println("-----------------------------------------------------------");
        }
    }
//
//	public void addBillerInvalidInputs_PB_TC_13() throws Exception {
//		ExtentReporter.HeaderChildNode("Add Biller Invalid Inputs");
//		mlWalletLogin(prop.getproperty("Branch_Verified"));
//		verifyElementPresent(MLWalletPayBillsPage.objPayBills,getTextVal(MLWalletPayBillsPage.objPayBills,"Icon"));
//		click(MLWalletPayBillsPage.objPayBills,getTextVal(MLWalletPayBillsPage.objPayBills,"Icon"));
//		click(MLWalletPayBillsPage.objSavedBiller, getTextVal(MLWalletPayBillsPage.objSavedBiller, "Button"));
//		waitTime(5000);
//		click(MLWalletPayBillsPage.objAddBiller, getTextVal(MLWalletPayBillsPage.objAddBiller, "Button"));
//		addSelectedBiller();
//
//		type(MLWalletPayBillsPage.objAddAccountNumber,"ABC","Account Number Input Field");
//		click(MLWalletPayBillsPage.objProceedBtn,getTextVal(MLWalletPayBillsPage.objProceedBtn,"Button"));
//		if(verifyElementPresent(MLWalletPayBillsPage.objAddAccountNumber,getTextVal(MLWalletPayBillsPage.objAddAccountNumber,"Error Message"))){
//			String sAccountNumberRequiredErrorMsg = getText(MLWalletPayBillsPage.objAccountNumberRequiredMsg);
//			String sExceptedAccountNumberRequiredErrorMsg = "Account Number is required";
//			assertionValidation(sAccountNumberRequiredErrorMsg,sExceptedAccountNumberRequiredErrorMsg);
//		}
//
//		click(MLWalletPayBillsPage.objProceedBtn,getTextVal(MLWalletPayBillsPage.objProceedBtn,"Button"));
//		type(MLWalletPayBillsPage.objAddAccountNumber,prop.getproperty("AccountNumber"),"Account Number Input Field");
//		if(verifyElementPresent(MLWalletPayBillsPage.objFirstNameRequiredMsg,getTextVal(MLWalletPayBillsPage.objFirstNameRequiredMsg,"Error Message"))){
//			String sFirstNameRequiredErrorMsg = getText(MLWalletPayBillsPage.objFirstNameRequiredMsg);
//			String sExceptedFirstNameRequiredErrorMsg = "First name is required";
//			assertionValidation(sFirstNameRequiredErrorMsg,sExceptedFirstNameRequiredErrorMsg);
//		}
//
//		click(MLWalletPayBillsPage.objProceedBtn,getTextVal(MLWalletPayBillsPage.objProceedBtn,"Button"));
//		type(MLWalletPayBillsPage.objAddFirstName,prop.getproperty("Invalid_First_Name"),"First Name Input Field");
//		if(verifyElementPresent(MLWalletPayBillsPage.objLastNameRequiredMsg,getTextVal(MLWalletPayBillsPage.objLastNameRequiredMsg,"Error Message"))){
//			String sLastNameRequiredErrorMsg = getText(MLWalletPayBillsPage.objLastNameRequiredMsg);
//			String sExceptedLastNameRequiredErrorMsg = "Last name is required";
//			assertionValidation(sLastNameRequiredErrorMsg,sExceptedLastNameRequiredErrorMsg);
//		}
//
//		click(MLWalletPayBillsPage.objProceedBtn,getTextVal(MLWalletPayBillsPage.objProceedBtn,"Button"));
//		type(MLWalletPayBillsPage.objAddLastName,prop.getproperty("Invalid_Last_Name"),"Last Name Input Field");
////		billerDetails(prop.getproperty("Invalid_First_Name"),prop.getproperty("Invalid_Middle_Name"),prop.getproperty("Invalid_Last_Name"),"0.99");
//
//
//		if(verifyElementPresent(MLWalletPayBillsPage.objInvalidFirstNameMsg,getTextVal(MLWalletPayBillsPage.objInvalidFirstNameMsg,"Error Message"))){
//			String sInvalidFirstNameErrorMsg = getText(MLWalletPayBillsPage.objInvalidFirstNameMsg);
//			String sExceptedFirstNameErrorMsg = "First name must only contain letters and spaces";
//			assertionValidation(sInvalidFirstNameErrorMsg,sExceptedFirstNameErrorMsg);
//		}
//		if(verifyElementPresent(MLWalletPayBillsPage.objInvalidSecondNameMsg,getTextVal(MLWalletPayBillsPage.objInvalidSecondNameMsg,"Error Message"))){
//			String sInvalidSecondNameErrorMsg = getText(MLWalletPayBillsPage.objInvalidSecondNameMsg);
//			String sExceptedSecondNameErrorMsg = "Middle name must only contain letters and spaces";
//			assertionValidation(sInvalidSecondNameErrorMsg,sExceptedSecondNameErrorMsg);
//		}
//		if(verifyElementPresent(MLWalletPayBillsPage.objInvalidLastName,getTextVal(MLWalletPayBillsPage.objInvalidLastName,"Error Message"))){
//			String sInvalidThirdNameErrorMsg = getText(MLWalletPayBillsPage.objInvalidLastName);
//			String sExceptedThirdNameErrorMsg = "Last name must only contain letters and spaces";
//			assertionValidation(sInvalidThirdNameErrorMsg,sExceptedThirdNameErrorMsg);
//		}

    public void editAddedBillerToPayBills_PB_TC_14() throws Exception {
        ExtentReporter.HeaderChildNode("Edit Added Biller to Pay bIlls");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        selectAddedBiler();
        click(MLWalletPayBillsPage.objEditBtn, getTextVal(MLWalletPayBillsPage.objEditBtn, "Button"));

        clearField(MLWalletPayBillsPage.objEditRecipientLastName, "Last Name Input Field");
        type(MLWalletPayBillsPage.objEditRecipientLastName, prop.getproperty("Edited_Last_name"), "Last Name Text Field");
        click(MLWalletPayBillsPage.ObjSaveBtn, getTextVal(MLWalletPayBillsPage.ObjSaveBtn, "Button"));
        click(MLWalletPayBillsPage.objOKBtn, getTextVal(MLWalletPayBillsPage.objOKBtn, "Button"));
        type(MLWalletPayBillsPage.objSearchSavedBiller, prop.getproperty("Edited_Last_name"), "Search Recipient Text Field");
        if (verifyElementPresent(MLWalletPayBillsPage.objSelectLastName(prop.getproperty("Edited_Last_name"), prop.getproperty("First_Name")), getTextVal(SendTransferPage.objSelectLastName(prop.getproperty("Edited_Last_name"), prop.getproperty("First_Name")), "Recipient"))) {
            logger.info("PB_TC_14, Successfully edited the Added Biller");
            ExtentReporter.extentLoggerPass("PB_TC_14", "PB_TC_14, Successfully edited the Added Biller");
            System.out.println("-----------------------------------------------------------");
        }

    }

    public void deleteAddedBillerPayBills_PB_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Delete Added Biller Pay Bills");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        selectAddedBiler();
        click(MLWalletPayBillsPage.objRemoveBtn, getTextVal(MLWalletPayBillsPage.objRemoveBtn, "Button"));
        if (verifyElementPresent(MLWalletPayBillsPage.objConfirmPopup, getTextVal(MLWalletPayBillsPage.objConfirmPopup, "Pop up"))) {
            verifyElementPresentAndClick(MLWalletPayBillsPage.objConfirmBtn, getTextVal(MLWalletPayBillsPage.objConfirmBtn, "Button"));
        }
        if (verifyElementPresent(MLWalletPayBillsPage.objSavedBillers, getTextVal(MLWalletPayBillsPage.objSavedBillers, "Page"))) {
            type(MLWalletPayBillsPage.objSearchBillerInSavedBillers, prop.getproperty("Edited_Last_name"), "Search saved biller input field");
            if (verifyElementNotPresent(MLWalletPayBillsPage.objSelectLastName(prop.getproperty("Edited_Last_name"), prop.getproperty("First_Name")), "Saved Recipient", 5)) {
                logger.info("PB_TC_15, Successfully deleted the Added Biller");
                ExtentReporter.extentLoggerPass("PB_TC_15", "PB_TC_15, Successfully deleted the Added Biller");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

//================================ Phase 2=============================================================//

    public void payBillsUIValidation_PB_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        if (verifyElementPresent(MLWalletPayBillsPage.objSelectBiller, getTextVal(MLWalletPayBillsPage.objSelectBiller, "Page"))) {
            verifyElementPresent(MLWalletPayBillsPage.objRecentTransactions, getTextVal(MLWalletPayBillsPage.objRecentTransactions, "Header"));
            verifyElementPresent(MLWalletPayBillsPage.objSavedBiller, getTextVal(MLWalletPayBillsPage.objSavedBiller, "Button"));
            verifyElementPresent(MLWalletPayBillsPage.objBillers, getTextVal(MLWalletPayBillsPage.objBillers, "Header"));
            verifyElementPresent(MLWalletPayBillsPage.objCategories, getTextVal(MLWalletPayBillsPage.objCategories, "Button"));
            verifyElementPresent(MLWalletPayBillsPage.objAlphabetical, getTextVal(MLWalletPayBillsPage.objAlphabetical, "Button"));
            verifyElementPresent(MLWalletPayBillsPage.objSearchBiller, "Search Biller Input Field");
            logger.info("PB_TC_16, Pay Bills UI Page Validated");
            ExtentReporter.extentLoggerPass("PB_TC_16", "PB_TC_16, Pay Bills UI Page Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsAddBillerPageUIValidation_PB_TC_18() throws Exception {
        ExtentReporter.HeaderChildNode("PayBills Add Biller Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        verifyElementPresentAndClick(MLWalletPayBillsPage.objSavedBiller, getTextVal(MLWalletPayBillsPage.objSavedBiller, "Button"));
        verifyElementPresentAndClick(MLWalletPayBillsPage.objAddBiller, getTextVal(MLWalletPayBillsPage.objAddBiller, "Button"));
        if (verifyElementPresent(MLWalletPayBillsPage.objAddBillers, getTextVal(MLWalletPayBillsPage.objAddBillers, "Page"))) {
            verifyElementPresent(MLWalletPayBillsPage.objBillerInformation, getTextVal(MLWalletPayBillsPage.objBillerInformation, "Header"));
            verifyElementPresent(MLWalletPayBillsPage.objBiller, getTextVal(MLWalletPayBillsPage.objBiller, "Edit Field"));
            verifyElementPresent(MLWalletPayBillsPage.objAddAccountNumber, "Account Number Input Field");
            verifyElementPresent(MLWalletPayBillsPage.objAddFirstName, "Account Holder First Name Input Field");
            verifyElementPresent(MLWalletPayBillsPage.objAddMiddleName, "Account Holder Middle Name Input Field");
            verifyElementPresent(MLWalletPayBillsPage.objAddLastName, "Account Holder Last Name Input Field");
            verifyElementPresent(MLWalletPayBillsPage.objAddNickName, "Nick Name Input Field");
            verifyElementPresent(MLWalletPayBillsPage.objProceedBtn, getTextVal(MLWalletPayBillsPage.objProceedBtn, "Button"));
            logger.info("PB_TC_18, PayBills Add Biller Page UI Validated");
            ExtentReporter.extentLoggerPass("PB_TC_18", "PB_TC_16, PayBills Add Biller Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void paybillsRecentTransaction_PB_TC_19() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Recent Transaction validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletPayBillsPage.objTransactionDetails, getTextVal(MLWalletPayBillsPage.objTransactionDetails, "Page"));
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletPayBillsPage.objNewTransactionBtn, getTextVal(MLWalletPayBillsPage.objNewTransactionBtn, "Button"));
        verifyElementPresentAndClick(MLWalletPayBillsPage.objRecentTransactionOne, "Recent Transaction");
        if (verifyElementPresent(MLWalletPayBillsPage.objBillsPayInformation, getTextVal(MLWalletPayBillsPage.objBillsPayInformation, "Page"))) {
            verifyElementPresent(MLWalletPayBillsPage.objMisBillsPayBiller, getTextVal(MLWalletPayBillsPage.objMisBillsPayBiller, "Biller"));
            logger.info("PB_TC_19, Pay Bills Recent Transaction Validated");
            ExtentReporter.extentLoggerPass("PB_TC_19", "PB_TC_19, Pay Bills Recent Transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsSavedBilerUIValidation_PB_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Saved Biler UI Validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        selectAddedBiler();
        if (verifyElementPresent(MLWalletPayBillsPage.objAccountInfo, getTextVal(MLWalletPayBillsPage.objAccountInfo, "Page"))) {
            verifyElementPresent(MLWalletPayBillsPage.objAddAccountNumber, getTextVal(MLWalletPayBillsPage.objAddAccountNumber, "Account Number"));
            verifyElementPresent(MLWalletPayBillsPage.objAddFirstName, getTextVal(MLWalletPayBillsPage.objAddFirstName, "First Name"));
            verifyElementPresent(MLWalletPayBillsPage.objAddMiddleName, getTextVal(MLWalletPayBillsPage.objAddMiddleName, "Middle Name"));
            verifyElementPresent(MLWalletPayBillsPage.objAddLastName, getTextVal(MLWalletPayBillsPage.objAddLastName, "Last Name"));
            verifyElementPresent(MLWalletPayBillsPage.objAddNickName, getTextVal(MLWalletPayBillsPage.objAddNickName, "Nick Name"));
            verifyElementPresent(MLWalletPayBillsPage.objEditBtn, getTextVal(MLWalletPayBillsPage.objEditBtn, "Button"));
            verifyElementPresent(MLWalletPayBillsPage.objRemoveBtn, getTextVal(MLWalletPayBillsPage.objRemoveBtn, "Button"));
            verifyElementPresent(MLWalletPayBillsPage.objSelectBiller, getTextVal(MLWalletPayBillsPage.objSelectBiller, "Button"));
            logger.info("PB_TC_20, Pay Bills Saved Biler UI Validated");
            ExtentReporter.extentLoggerPass("PB_TC_20", "PB_TC_20, Pay Bills Saved Biler UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsMaxBillsPaymentPerTransactionBuyTierUser_PB_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Maximum Bills Payment Per Transaction for Buyer Tier Account");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "20000");
        confirmDetailsAndPay();
        if (verifyElementPresent(MLWalletPayBillsPage.objMaxLimitErrorMessageUpgrade, getTextVal(MLWalletPayBillsPage.objMaxLimitErrorMessageUpgrade, "Error Message"))) {
            String sMaxLimitErrorMessage = getText(MLWalletPayBillsPage.objMaxLimitErrorMessageUpgrade);
            String sExpectedErrorMessage = "The maximum Bills Pay per transaction set for your verification level is P10,000.00. Please try again.";
            assertionValidation(sMaxLimitErrorMessage, sExpectedErrorMessage);
            verifyElementPresent(MLWalletPayBillsPage.objUpgradeNowBtn, getTextVal(MLWalletPayBillsPage.objUpgradeNowBtn, "Button"));
            logger.info("PB_TC_22, Pay Bills Maximum Bills Payment Per Transaction for Buyer Tier Account Validated");
            ExtentReporter.extentLoggerPass("PB_TC_22", "PB_TC_22, Pay Bills Maximum Bills Payment Per Transaction for Buyer Tier Account validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsMaxBillsPaymentPerTransactionSemiVerifiedTier_PB_TC_25() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Maximum Bills Payment Per Transaction for Semi Verified Tier Account");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "60000");
        confirmDetailsAndPay();
        if (verifyElementPresent(MLWalletPayBillsPage.objMaxLimitErrorMessageUpgrade, getTextVal(MLWalletPayBillsPage.objMaxLimitErrorMessageUpgrade, "Error Message"))) {
            String sMaxLimitErrorMessage = getText(MLWalletPayBillsPage.objMaxLimitErrorMessageUpgrade);
            String sExpectedErrorMessage = "The maximum Bills Pay per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaxLimitErrorMessage, sExpectedErrorMessage);
            verifyElementPresent(MLWalletPayBillsPage.objUpgradeNowBtn, getTextVal(MLWalletPayBillsPage.objUpgradeNowBtn, "Button"));
            logger.info("PB_TC_25, Pay Bills Maximum Bills Payment Per Transaction for Semi Verified Tier Account Validated");
            ExtentReporter.extentLoggerPass("PB_TC_25", "PB_TC_25, Pay Bills Maximum Bills Payment Per Transaction for Semi Verified Tier Account validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsMaxBillsPaymentPerTransactionBranchVerifiedTier_PB_TC_28() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Maximum Bills Payment Per Transaction for Branch Verified Tier Account");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "60000");
        confirmDetailsAndPay();
        if (verifyElementPresent(MLWalletPayBillsPage.objMaxLimitErrorMessage, getTextVal(MLWalletPayBillsPage.objMaxLimitErrorMessage, "Error Message"))) {
            String sMaxLimitErrorMessage = getText(MLWalletPayBillsPage.objMaxLimitErrorMessage);
            String sExpectedErrorMessage = "The maximum Bills Pay per transaction set for your verification level is P25,000.00. Please try again.";
            assertionValidation(sMaxLimitErrorMessage, sExpectedErrorMessage);
            verifyElementPresent(MLWalletPayBillsPage.objOKBtn, getTextVal(MLWalletPayBillsPage.objOKBtn, "Button"));
            logger.info("PB_TC_26, Pay Bills Maximum Bills Payment Per Transaction for Branch Verified Tier Account Validated");
            ExtentReporter.extentLoggerPass("PB_TC_26", "PB_TC_26, Pay Bills Maximum Bills Payment Per Transaction for Branch Verified Tier Account validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsMaxBillsPaymentPerTransactionFullyVerifiedTier_PB_TC_31() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Maximum Bills Payment Per Transaction for Fully Verified Tier Account");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "60000");
        confirmDetailsAndPay();
        if (verifyElementPresent(MLWalletPayBillsPage.objMaxLimitErrorMessage, getTextVal(MLWalletPayBillsPage.objMaxLimitErrorMessage, "Error Message"))) {
            String sMaxLimitErrorMessage = getText(MLWalletPayBillsPage.objMaxLimitErrorMessage);
            String sExpectedErrorMessage = "The maximum Bills Pay per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaxLimitErrorMessage, sExpectedErrorMessage);
            verifyElementPresent(MLWalletPayBillsPage.objOKBtn, getTextVal(MLWalletPayBillsPage.objOKBtn, "Button"));
            logger.info("PB_TC_31, Pay Bills Maximum Bills Payment Per Transaction for Fully Verified Tier Account Validated");
            ExtentReporter.extentLoggerPass("PB_TC_31", "PB_TC_31, Pay Bills Maximum Bills Payment Per Transaction for Fully Verified Tier Account validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsRecentTransaction_PB_TC_21() throws Exception {
        ExtentReporter.HeaderChildNode("PayBills Recent Transactions");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        payBillsNavigation();
        waitTime(5000);
        verifyElementPresent(MLWalletPayBillsPage.objRecentTransactions, getTextVal(MLWalletPayBillsPage.objRecentTransactions, "Header"));
        horizontalSwipeByPercentages(0.8, 0.2, 0.25);
        horizontalSwipeByPercentages(0.8, 0.2, 0.25);
        logger.info("PB_TC_21, PayBills Recent Transactions Swiped until Last Transaction");
        ExtentReporter.extentLoggerPass("PB_TC_21", "PB_TC_21, PayBills Recent Transactions Swiped until Last Transaction");
        System.out.println("-----------------------------------------------------------");
    }


    public void payBillsLocationPopupValidation_PB_TC_34() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Location popup Validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpValidation();
            logger.info("PB_TC_34, Pay Bills Location popup Validated");
            ExtentReporter.extentLoggerPass("PB_TC_34", "PB_TC_34, Pay Bills Location popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsLocationDenyFunctionality_PB_TC_35() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Location Deny Functionality Validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyPopUp();
            logger.info("PB_TC_35, Pay Bills Location Deny Functionality Validated");
            ExtentReporter.extentLoggerPass("PB_TC_35", "PB_TC_35, Pay Bills Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsLocationPermissionDenyCloseBtnFunctionality_PB_TC_36() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Location Permission Deny Close Button Functionality Validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyCloseBtnFunctionality();
            if (verifyElementPresent(MLWalletPayBillsPage.objBillsPayInformation, getTextVal(MLWalletPayBillsPage.objBillsPayInformation, "Page"))) {
                logger.info("PB_TC_36, Pay Bills Location Permission Deny Close Button Functionality Validated");
                ExtentReporter.extentLoggerPass("PB_TC_36", "PB_TC_36, Pay Bills Location Permission Deny Close Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void payBillsLocationPermissionDenyOpenSettingsBtnFunctionality_PB_TC_37() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Location Permission Deny open Settings Button Functionality Validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyOpenSettingsBtnFunctionality();
            if (verifyElementPresent(SendTransferPage.objAppInfo, getTextVal(SendTransferPage.objAppInfo, "Page"))) {
                logger.info("PB_TC_37, Pay Bills Location Permission Deny Open Settings Button Functionality Validated");
                ExtentReporter.extentLoggerPass("PB_TC_37", "PB_TC_37, Pay Bills Location Permission Deny Open Settings Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void payBillsLocationPopUpAllowFunctionality_PB_TC_38() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Location popup Allow Button Functionality Validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpAllowFunctionality();
            if (verifyElementDisplayed(MLWalletLoginPage.objOneTimePin)) {
                verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
            } else if (verifyElementDisplayed(MLWalletLoginPage.objMLPin)) {
                verifyElementPresent(MLWalletLoginPage.objMLPin, getTextVal(MLWalletLoginPage.objMLPin, "Page"));
            }
            logger.info("PB_TC_38, Pay Bills Location popup Allow Button Functionality Validated");
            ExtentReporter.extentLoggerPass("PB_TC_38", "PB_TC_38, Pay Bills Location popup Allow Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsInternetInterruptionWhileEnteringOTP_PB_TC_39() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Internet Interruption While Entering OTP Validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        enableLocation_PopUp();
        waitTime(15000);
        setWifiConnectionToONOFF("OFF");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"))) {
            internetConnectionError();
            logger.info("PB_TC_39, Pay Bills Internet Interruption While Entering OTP Validated");
            ExtentReporter.extentLoggerPass("PB_TC_39", "PB_TC_39, Pay Bills Internet Interruption While Entering OTP Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsTransactionValidationAfterMinimizingApp_PB_TC_42() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Transaction Validation After Minimizing App");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        if (verifyElementPresent(MLWalletPayBillsPage.objSuccessPillPaymentMsg, getTextVal(MLWalletPayBillsPage.objSuccessPillPaymentMsg, "Message"))) {
            logger.info("PB_TC_40, Pay Bills Transaction Validation After Minimizing App Validated");
            ExtentReporter.extentLoggerPass("PB_TC_40", "PB_TC_40, Pay Bills Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void payBillsTransactionWithValidMLPin_PB_TC_48() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Transaction With Valid ML Pin");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        enableLocation_PopUp();
        handleMpin("1111");
        if (verifyElementPresent(MLWalletPayBillsPage.objSuccessPillPaymentMsg, getTextVal(MLWalletPayBillsPage.objSuccessPillPaymentMsg, "Message"))) {
            verifyElementPresent(MLWalletPayBillsPage.objAmountPaid, getTextVal(MLWalletPayBillsPage.objAmountPaid, "Amount"));
            verifyElementPresent(MLWalletPayBillsPage.objPaidDate, getTextVal(MLWalletPayBillsPage.objPaidDate, "Date"));
            verifyElementPresent(MLWalletPayBillsPage.objTransactionDetails, getTextVal(MLWalletPayBillsPage.objTransactionDetails, "Header"));
            verifyElementPresent(MLWalletPayBillsPage.objTransactionNumber, getTextVal(MLWalletPayBillsPage.objTransactionNumber, "Transaction Number"));
            String sTransactionNumber = getText(MLWalletPayBillsPage.objTransactionNumber);
            verifyElementPresent(MLWalletPayBillsPage.objBillerName, getTextVal(MLWalletPayBillsPage.objBillerName, "Biller Name"));
            verifyElementPresent(MLWalletPayBillsPage.objAccountName, getTextVal(MLWalletPayBillsPage.objAccountName, "Account Name"));
            verifyElementPresent(MLWalletPayBillsPage.objPaymentMethod, getTextVal(MLWalletPayBillsPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletPayBillsPage.objAmountToPay, getTextVal(MLWalletPayBillsPage.objAmountToPay, "Amount"));
            verifyElementPresent(MLWalletPayBillsPage.objServiceFee, getTextVal(MLWalletPayBillsPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletPayBillsPage.objTotalAmount, getTextVal(MLWalletPayBillsPage.objTotalAmount, "Total Amount"));
            verifyElementPresentAndClick(MLWalletPayBillsPage.objBackToHomeBtn, getTextVal(MLWalletPayBillsPage.objBackToHomeBtn, "Button"));
            waitTime(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            click(MLWalletHomePage.objPayBills, getTextVal(MLWalletHomePage.objPayBills, "Text"));
            if (verifyElementPresent(MLWalletCashOutPage.objTransactionDetails, getTextVal(MLWalletCashOutPage.objTransactionDetails, "Page"))) {
                String sReferenceNumberInCashOut = getText(MLWalletCashOutPage.objReferenceNumberInCashOut);
                System.out.println(sReferenceNumberInCashOut);
                assertionValidation(sReferenceNumberInCashOut, sTransactionNumber);
                logger.info("PB_TC_48, Pay Bills Transaction With Valid ML Pin is validated");
                ExtentReporter.extentLoggerPass("PB_TC_48", "PB_TC_48, Pay Bills Transaction With Valid ML Pin is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void payBillsTransactionWithInValidMLPin_PB_TC_49() throws Exception {
        ExtentReporter.HeaderChildNode("Pay Bills Transaction With Invalid ML Pin");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        enableLocation_PopUp();
        handleMpin("1234");
        if (verifyElementPresent(MLWalletPayBillsPage.objInvalidPINMsg, getTextVal(MLWalletPayBillsPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletPayBillsPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("PB_TC_49, Buy ELoad Transaction With Invalid ML Pin validated");
            ExtentReporter.extentLoggerPass("PB_TC_49", "PB_TC_49, Buy ELoad Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsInOTPPopupValidation_PB_TC_55() throws Exception {
        ExtentReporter.HeaderChildNode("PayBills InApp OTP popup Validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            logger.info("PB_TC_55, PayBills, InApp OTP popup validated");
            ExtentReporter.extentLoggerPass("PB_TC_55", "PB_TC_55, PayBills, InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsTransactionInAppOTPPopupUIValidation_PB_TC_56() throws Exception {
        ExtentReporter.HeaderChildNode("PayBills Transaction InApp OTP popup UI Validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds, getTextVal(MLWalletLoginPage.objSeconds, "Seconds"));
            verifyElementPresent(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
            logger.info("PB_TC_56, PayBills Transaction InApp OTP popup UI validated");
            ExtentReporter.extentLoggerPass("PB_TC_56", "PB_TC_56, PayBills Transaction InApp OTP popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsTransactionNewOTPAfterSixtySecondsValidation_PB_TC_57() throws Exception {
        ExtentReporter.HeaderChildNode("PayBills New OTP got generated After Sixty Seconds validation");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if (verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"))) {
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP, sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("PB_TC_57, PayBills Transaction New OTP got generated After Sixty Seconds is validated");
            ExtentReporter.extentLoggerPass("PB_TC_57", "PB_TC_57, PayBills Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsTransactionOTPCancelBtnFunctionality_PB_TC_58() throws Exception {
        ExtentReporter.HeaderChildNode("PayBills Transaction OTP Cancel Button Functionality");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletPayBillsPage.objConfirmDetails, getTextVal(MLWalletPayBillsPage.objConfirmDetails, "Page"))) {
            logger.info("PB_TC_58, PayBills Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            ExtentReporter.extentLoggerPass("PB_TC_58", "PB_TC_58, PayBills Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void payBillsTransactionOTPContinueBtnFunctionality_PB_TC_59() throws Exception {
        ExtentReporter.HeaderChildNode("PayBills Transaction OTP Continue Button Functionality");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        payBillsNavigation();
        searchBiller();
        billerDetails(prop.getproperty("First_Name"), prop.getproperty("Middle_Name"), prop.getproperty("Last_Name"), "10");
        confirmDetailsAndPay();
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        if (verifyElementPresent(MLWalletPayBillsPage.objSuccessPillPaymentMsg, getTextVal(MLWalletPayBillsPage.objSuccessPillPaymentMsg, "Message"))) {
            logger.info("PB_TC_59, PayBills Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            ExtentReporter.extentLoggerPass("PB_TC_59", "PB_TC_59, PayBills Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
