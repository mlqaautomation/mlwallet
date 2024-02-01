package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.mlwallet.pages.*;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static com.utility.Utilities.*;
import static com.utility.Utilities.verifyElementPresent;

public class BuyEloadClass extends BaseClass{

    public BuyEloadClass(){
        super();
    }
    public void buyELoadTransactionDetails_BE_TC_01(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Transaction Details Validation after Buying eLoad");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objRegularLoadTab, "Regular Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.obj5SmartRegularLoad, getTextVal(MLWalletEloadPage.obj5SmartRegularLoad, "Regular Load"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(30000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            verifyElementPresent(MLWalletEloadPage.objMobileNumberInTransactionDetails, getTextVal(MLWalletEloadPage.objMobileNumberInTransactionDetails, "Mobile Number"));
            verifyElementPresent(MLWalletEloadPage.objBuyELoadTime, getTextVal(MLWalletEloadPage.objBuyELoadTime, "Date and Time"));
            verifyElementPresent(MLWalletEloadPage.objTypeOfPromoUsed, getTextVal(MLWalletEloadPage.objTypeOfPromoUsed, "Promo"));
            verifyElementPresent(MLWalletEloadPage.objAmountToSend, getTextVal(MLWalletEloadPage.objAmountToSend, "Amount to Send"));
            verifyElementPresent(MLWalletEloadPage.objServiceFee, getTextVal(MLWalletEloadPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletEloadPage.objTotalAmount, getTextVal(MLWalletEloadPage.objTotalAmount, "Total Amount"));
            logger.info("BE_TC_01, Transaction Details Validated after Buying eLoad");
            ExtentReporter.extentLoggerPass("BE_TC_01", "BE_TC_01, Transaction Details Validated after Buying eLoad");
            System.out.println("-----------------------------------------------------------");
        }

    }

    public void buyELoadInvalidMobileNumber_BE_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("Buying eLoad using invalid mobile number");
        eLoad_generic(prop.getproperty("Fully_Verified"), prop.getproperty("inValidMobNumber"), "true", 3);
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletEloadPage.objErrorMsg, getTextVal(MLWalletEloadPage.objErrorMsg, "Pop Up Message"))) {
            String sActualErrorMsg = getText(MLWalletEloadPage.objErrorMsg);
            String sExceptedErrorMsg = "Network and Mobile number does not match";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("BE_TC_02, Buy ELoad Using Invalid Mobile Number, Network and Mobile number does not match Error Message Validated");
            ExtentReporter.extentLoggerPass("BE_TC_02", "BE_TC_02, Buy ELoad Using Invalid Mobile Number, Network and Mobile number does not match Error Message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadWithoutInputMobNumber_BE_TC_03() throws Exception {
        ExtentReporter.HeaderChildNode("Buying eLoad without mobile number input");
        eLoad_generic(prop.getproperty("Fully_Verified"), "", "true", 3);
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletEloadPage.objErrorMsg, getTextVal(MLWalletEloadPage.objErrorMsg, "Pop Up Message"))) {
            String sActualErrorMsg = getText(MLWalletEloadPage.objErrorMsg);
            String sExceptedErrorMsg = "Mobile number is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("BE_TC_03, Buy ELoad without mobile number input, Mobile number is required Error Message is validated");
            ExtentReporter.extentLoggerPass("BE_TC_03", "BE_TC_03, Buy ELoad without mobile number input, Mobile number is required Error Message is validated");
        }
    }

    public void buyELoadWithoutTelecommunicationSelected_BE_TC_04() throws Exception {
        ExtentReporter.HeaderChildNode("Buying eLoad without telecommunication selected");
        eLoad_generic(prop.getproperty("Fully_Verified"), prop.getproperty("Smart"), "false", 4);
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletEloadPage.objErrorMsg, getTextVal(MLWalletEloadPage.objErrorMsg, "Pop Up Message"))) {
            String sActualErrorMsg = getText(MLWalletEloadPage.objErrorMsg);
            String sExceptedErrorMsg = "Network and Mobile number does not match";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("BE_TC_04, Buying eLoad without selecting telecommunication, Network and Mobile number does not match Error Msg Validated");
            ExtentReporter.extentLoggerPass("BE_TC_04", "BE_TC_04, Buying eLoad without selecting telecommunication, Network and Mobile number does not match Error Msg Validated");
        }
    }

    public void buyELoadInsufficientBalance_BE_TC_05(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buying eLoad with insufficient balance");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        swipeDownUntilElementVisible("Smart Regular Load 3000");
        verifyElementPresentAndClick(MLWalletEloadPage.obj2000PromoLoad, getTextVal(MLWalletEloadPage.obj2000PromoLoad, "Load"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletEloadPage.objInsufficientBalPopup, getTextVal(MLWalletEloadPage.objInsufficientBalPopup, "Pop up"))) {
            String sActualInsufficientBalMsg = getText(MLWalletEloadPage.objInsufficientBalPopup);
            String sExceptedMsg = "There is insufficient balance to proceed with this transaction. Please try again.";
            assertionValidation(sActualInsufficientBalMsg, sExceptedMsg);
            verifyElementPresent(MLWalletEloadPage.objOkBtn, getTextVal(MLWalletEloadPage.objOkBtn, "Button"));
            logger.info("BE_TC_05, Insufficient Balance Error Message Validated");
            ExtentReporter.extentLoggerPass("BE_TC_05", "BE_TC_05, Insufficient Balance Error Message Validated");
            System.out.println("-----------------------------------------------------------");
        }

    }


    public void buyELoadMaxLimitPerTransaction_BE_TC_09(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Maximum Limit per Transaction");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        swipeDownUntilElementVisible("Smart Regular Load 3000");
        verifyElementPresentAndClick(MLWalletEloadPage.obj3000RegularLoad, getTextVal(MLWalletEloadPage.obj3000RegularLoad, "Load"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletEloadPage.objMaxLimitPopupMsg, getTextVal(MLWalletEloadPage.objMaxLimitPopupMsg, "Error Popup Msg"))) {
            String sActualPopupMsg = getText(MLWalletEloadPage.objMaxLimitPopupMsg);
            String sExceptedPopupMsg = "The maximum E-load per transaction set for your verification level is P2,000.00. Please try again.";
            assertionValidation(sActualPopupMsg, sExceptedPopupMsg);
            logger.info("BE_TC_09, Buy ELoad Maximum Limit per Transaction Validated");
            ExtentReporter.extentLoggerPass("BE_TC_09", "BE_TC_09, Buy ELoad Maximum Limit per Transaction Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadTransactionPageUIValidation_BE_TC_10(String sTier) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Transaction Page UI Validation");
        mlWalletLogin(sTier);
        verifyElementPresentAndClick(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        if (verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage, getTextVal(MLWalletEloadPage.objEloadtransactionPage, "Page"))) {
            verifyElementPresent(MLWalletEloadPage.objSelectTelco, getTextVal(MLWalletEloadPage.objSelectTelco, "Header"));
            verifyElementPresent(MLWalletEloadPage.objPhoneToLoad, getTextVal(MLWalletEloadPage.objPhoneToLoad, "Header"));
            verifyElementPresent(MLWalletEloadPage.objMobileNoField, "Mobile Number Input Field");
            verifyElementPresent(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
            verifyElementPresent(MLWalletEloadPage.objNextBtn, getTextVal(MLWalletEloadPage.objNextBtn, "Button"));
            logger.info("BE_TC_10, Buy ELoad Transaction Page UI Validated");
            ExtentReporter.extentLoggerPass("BE_TC_10", "BE_TC_10, Buy ELoad Transaction Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadNextButtonFunctionalityOnELoadTransactionPage_BE_TC_11(String sTier, String mobileNo, int telcoOption) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Next Button Functionality On ELoad Transaction Page");
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage, "eLoad Transaction Page");
        click(MLWalletEloadPage.objMobileNoField, "Mobile Number Field");
        type(MLWalletEloadPage.objMobileNoField, mobileNo, "Mobile Number Field");
        hideKeyboard();
        click(MLWalletEloadPage.telcoOptions(telcoOption), "Telco");
        click(MLWalletEloadPage.telcoOptions(telcoOption), "Telco");
        click(MLWalletEloadPage.objNextBtn, "Next Button");
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page")) {
            logger.info("BE_TC_11, Buy ELoad Next Button Functionality On ELoad Transaction Page Validated");
            ExtentReporter.extentLoggerPass("BE_TC_11", "BE_TC_11, Buy ELoad Next Button Functionality On ELoad Transaction Page Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadLoadSelectionPageBackBtnValidation_BE_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Load Selection Back Arrow Button Validation");
        buyELoadNextButtonFunctionalityOnELoadTransactionPage_BE_TC_11(prop.getproperty("Fully_Verified"), prop.getproperty("Smart"), 2);
        verifyElementPresentAndClick(MLWalletEloadPage.objLoadSelectionBackArrowBtn, "Load Selection Back Arrow Button");
        if (verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage, getTextVal(MLWalletEloadPage.objEloadtransactionPage, "Page"))) {
            logger.info("BE_TC_12, After clicking on Back Arrow Btn on Load Selection Page, Application Navigates to eLoad Transaction Page is Validated");
            ExtentReporter.extentLoggerPass("BE_TC_12", "BE_TC_12,  After clicking on Back Arrow Btn on Load Selection Page, Application Navigates to eLoad Transaction Page is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadLoadSelectionPageUIValidation_BE_TC_13(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Load Selection Page UI Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, getTextVal(MLWalletEloadPage.objLoadSelectionPage, "Page"))) {
            verifyElementPresent(MLWalletEloadPage.objMobileNumberInLoadSelection, getTextVal(MLWalletEloadPage.objMobileNumberInLoadSelection, "Number"));
            verifyElementPresent(MLWalletEloadPage.objChange, getTextVal(MLWalletEloadPage.objChange, "button"));
            verifyElementPresent(MLWalletEloadPage.objWalletBalanceInLoadSeletion, getTextVal(MLWalletEloadPage.objWalletBalanceInLoadSeletion, "Balance"));
            verifyElementPresent(MLWalletEloadPage.objPromoLoadTab, getTextVal(MLWalletEloadPage.objPromoLoadTab, "Tab"));
            verifyElementPresent(MLWalletEloadPage.objRegularLoadTab, getTextVal(MLWalletEloadPage.objRegularLoadTab, "Tab"));
            List<WebElement> values = findElements(MLWalletEloadPage.objPromoLoads);
            for (int i = 0; i < values.size(); i++) {
                String sPromoLoads = values.get(i).getText();
                logger.info("Promo Load : " + sPromoLoads + " is displayed");
                ExtentReporter.extentLogger(" ", "Promo Load : " + sPromoLoads + " is displayed");
            }
            logger.info("BE_TC_13, Buy ELoad Load Selection Page UI Validated");
            ExtentReporter.extentLoggerPass("BE_TC_13", "BE_TC_13,  Buy ELoad Load Selection Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadLoadSelectionChangeBtnFunctionality_BE_TC_14(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Load Selection Change Button Functionality Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresentAndClick(MLWalletEloadPage.objChange, getTextVal(MLWalletEloadPage.objChange, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage, getTextVal(MLWalletEloadPage.objEloadtransactionPage, "Page"))) {
            logger.info("BE_TC_14, After clicking on Change Btn in Load Selection Page, Application navigates to eLoad Transaction page is Validated");
            ExtentReporter.extentLoggerPass("BE_TC_14", "BE_TC_14, After clicking on Change Btn in Load Selection Page, Application navigates to eLoad Transaction page is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadTransactionDetailsPageUIValidation_BE_TC_15(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Transaction Details Page UI Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        if (verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"))) {
            verifyElementPresent(MLWalletEloadPage.objLoadWithAmount, getTextVal(MLWalletEloadPage.objLoadWithAmount, "Load With Amount"));
            verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Header"));
            verifyElementPresent(MLWalletEloadPage.objMobileNumber, getTextVal(MLWalletEloadPage.objMobileNumber, "Mobile Number"));
            verifyElementPresent(MLWalletEloadPage.objTypeOfPromoUsed, getTextVal(MLWalletEloadPage.objTypeOfPromoUsed, "Promo"));
            verifyElementPresent(MLWalletEloadPage.objAmountToSend, getTextVal(MLWalletEloadPage.objAmountToSend, "Amount to Send"));
            verifyElementPresent(MLWalletEloadPage.objServiceFee, getTextVal(MLWalletEloadPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletEloadPage.objTotalAmount, getTextVal(MLWalletEloadPage.objTotalAmount, "Total Amount"));
            verifyElementPresent(MLWalletEloadPage.objConfirmBtn, getTextVal(MLWalletEloadPage.objConfirmBtn, "Button"));
            logger.info("BE_TC_15, Buy ELoad Transaction Details Page UI Validated");
            ExtentReporter.extentLoggerPass("BE_TC_15", "BE_TC_15, Buy ELoad Transaction Details Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadSelectFromContactsBtnFunctionality_BE_TC_16(String sTier) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Select From Contacts Functionality");
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
        verifyElementPresentAndClick(MLWalletEloadPage.objAllowBtn, getTextVal(MLWalletEloadPage.objAllowBtn, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objContacts, getTextVal(MLWalletEloadPage.objContacts, "Page"))) {
            logger.info("BE_TC_16, Buy ELoad, After clicking on Select From Contacts Application Navigates to Contacts Page");
            ExtentReporter.extentLoggerPass("BE_TC_16", "BE_TC_16, Buy ELoad, After clicking on Select From Contacts Application Navigates to Contacts Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadContactsPageUIValidation_BE_TC_17(String sTier) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Contacts Page UI Validation");
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
        verifyElementPresentAndClick(MLWalletEloadPage.objAllowBtn, getTextVal(MLWalletEloadPage.objAllowBtn, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objContacts, getTextVal(MLWalletEloadPage.objContacts, "Page"))) {
            for (int i = 1; i <= 7; i++) {
                for (int j = 1; j <= 2; j++) {
                    if (j == 1) {
                        String sContactName = getText(MLWalletEloadPage.objContactsAndNumber(i, j));
                        logger.info("Contact Name : " + sContactName + " is displayed");
                        ExtentReporter.extentLogger(" ", "Contact Name : " + sContactName + " is displayed");
                    }
                    if (j == 2) {
                        String sContactNumber = getText(MLWalletEloadPage.objContactsAndNumber(i, j));
                        logger.info("Contact Number : " + sContactNumber + " is displayed");
                        ExtentReporter.extentLogger(" ", "Contact Number : " + sContactNumber + " is displayed");
                    }
                }
            }
            logger.info("BE_TC_17, Buy ELoad Contacts Page UI Validated");
            ExtentReporter.extentLoggerPass("BE_TC_17", "BE_TC_17, Buy ELoad Contacts Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadContactsPageBackBtnValidation_BE_TC_18(String sTier) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Contacts Page Back Arrow Button Validation");
        buyELoadSelectFromContactsBtnFunctionality_BE_TC_16(sTier);
        verifyElementPresentAndClick(MLWalletEloadPage.objContactsPageBackBtn, "Contacts Page back arrow Button");
        if (verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage, getTextVal(MLWalletEloadPage.objEloadtransactionPage, "Page"))) {
            logger.info("BE_TC_18, Buy ELoad Contacts Page Back Arrow Button Validated");
            ExtentReporter.extentLoggerPass("BE_TC_18", "BE_TC_18, Buy ELoad Contacts Page Back Arrow Button Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadSearchFieldValidation_BE_TC_19(String sTier) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Search Field Validation");
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
        verifyElementPresentAndClick(MLWalletEloadPage.objAllowBtn, getTextVal(MLWalletEloadPage.objAllowBtn, "Button"));
        verifyElementPresent(MLWalletEloadPage.objContacts, getTextVal(MLWalletEloadPage.objContacts, "Page"));
        if (verifyElementPresent(MLWalletEloadPage.objSearch, "Contact Search")) {
            type(MLWalletEloadPage.objSearch, prop.getproperty("contactName"), "Contact Search");
            verifyElementPresent(MLWalletEloadPage.objSearchedContactName, getTextVal(MLWalletEloadPage.objSearchedContactName, "Contact name"));
            verifyElementPresent(MLWalletEloadPage.objSearchedContactNumber, getTextVal(MLWalletEloadPage.objSearchedContactNumber, "Contact Number"));
            logger.info("BE_TC_19, Buy ELoad Search Field Validated");
            ExtentReporter.extentLoggerPass("BE_TC_19", "BE_TC_19, Buy ELoad Search Field Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadAddContactToFavorites_BE_TC_20(String sTier) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Add Contact To Favorites");
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
        verifyElementPresentAndClick(MLWalletEloadPage.objAllowBtn, getTextVal(MLWalletEloadPage.objAllowBtn, "Button"));
        verifyElementPresent(MLWalletEloadPage.objContacts, getTextVal(MLWalletEloadPage.objContacts, "Page"));
        type(MLWalletEloadPage.objSearch, prop.getproperty("contactName"), "Contact Search");
        verifyElementPresent(MLWalletEloadPage.objSearchedContactName, getTextVal(MLWalletEloadPage.objSearchedContactName, "Contact name"));
        String sContactName = getText(MLWalletEloadPage.objSearchedContactName);
        verifyElementPresent(MLWalletEloadPage.objSearchedContactNumber, getTextVal(MLWalletEloadPage.objSearchedContactNumber, "Contact Number"));
        String sContactNumber = getText(MLWalletEloadPage.objSearchedContactNumber);
        hideKeyboard();
        verifyElementPresentAndClick(MLWalletEloadPage.objAddToFavoriteIcon, "Add To Favorite Icon");
        verticalSwipeByPercentages(0.5, 0.9, 0.5);
        verifyElementPresentAndClick(MLWalletEloadPage.objFavorites, getTextVal(MLWalletEloadPage.objFavorites, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objSearchedContactName, getTextVal(MLWalletEloadPage.objSearchedContactName, "Contact name"))) {
            String sContactNameInFavorites = getText(MLWalletEloadPage.objSearchedContactName);
            assertionValidation(sContactName, sContactNameInFavorites);
            String sContactNumberInFavorites = getText(MLWalletEloadPage.objSearchedContactNumber);
            assertionValidation(sContactNumber, sContactNumberInFavorites);
            logger.info("BE_TC_20, Buy ELoad Add Contact To Favorites Validated");
            ExtentReporter.extentLoggerPass("BE_TC_20", "BE_TC_20, Buy ELoad Add Contact To Favorites Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadAddedContactToFavoritesValidation_BE_TC_21(String sTier) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Added Contacts To Favorites validation");
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
        verifyElementPresentAndClick(MLWalletEloadPage.objAllowBtn, getTextVal(MLWalletEloadPage.objAllowBtn, "Button"));
        verifyElementPresent(MLWalletEloadPage.objContacts, getTextVal(MLWalletEloadPage.objContacts, "Page"));
        type(MLWalletEloadPage.objSearch, prop.getproperty("contactNumber"), "Contact Search");
        verifyElementPresent(MLWalletEloadPage.objSearchedContactName, getTextVal(MLWalletEloadPage.objSearchedContactName, "Contact name"));
        verifyElementPresent(MLWalletEloadPage.objSearchedContactNumber, getTextVal(MLWalletEloadPage.objSearchedContactNumber, "Contact Number"));
        hideKeyboard();
        verifyElementPresentAndClick(MLWalletEloadPage.objAddToFavoriteIcon, "Add To Favorite Icon");
        verticalSwipeByPercentages(0.5, 0.9, 0.5);
        clearField(MLWalletEloadPage.objSearch, "Search field");
        if (verifyElementPresentAndClick(MLWalletEloadPage.objFavorites, getTextVal(MLWalletEloadPage.objFavorites, "Button"))) {
            waitTime(3000);
            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= 2; j++) {
                    if (j == 1) {
                        String sContactName = getText(MLWalletEloadPage.objContactsAndNumber(i, j));
                        logger.info("Contact Name : " + sContactName + " is displayed");
                        ExtentReporter.extentLogger(" ", "Contact Name : " + sContactName + " is displayed");
                    }
                    if (j == 2) {
                        String sContactNumber = getText(MLWalletEloadPage.objContactsAndNumber(i, j));
                        logger.info("Contact Number : " + sContactNumber + " is displayed");
                        ExtentReporter.extentLogger(" ", "Contact Number : " + sContactNumber + " is displayed");
                    }
                }
            }
            logger.info("BE_TC_21, Buy ELoad Added Contacts To Favorites Validated");
            ExtentReporter.extentLoggerPass("BE_TC_21", "BE_TC_21, Buy ELoad Added Contacts To Favorites Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadSearchAddedFavoriteContact_BE_TC_22(String sTier) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Search Added Favorite Contact");
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
        verifyElementPresentAndClick(MLWalletEloadPage.objAllowBtn, getTextVal(MLWalletEloadPage.objAllowBtn, "Button"));
        verifyElementPresent(MLWalletEloadPage.objContacts, getTextVal(MLWalletEloadPage.objContacts, "Page"));
        type(MLWalletEloadPage.objSearch, prop.getproperty("favoriteContact"), "Contact Search");
        verifyElementPresent(MLWalletEloadPage.objSearchedContactName, getTextVal(MLWalletEloadPage.objSearchedContactName, "Contact name"));
        verifyElementPresent(MLWalletEloadPage.objSearchedContactNumber, getTextVal(MLWalletEloadPage.objSearchedContactNumber, "Contact Number"));
        hideKeyboard();
        verifyElementPresentAndClick(MLWalletEloadPage.objAddToFavoriteIcon, "Add To Favorite Icon");
        verticalSwipeByPercentages(0.5, 0.9, 0.5);
        clearField(MLWalletEloadPage.objSearch, "Search field");
        verifyElementPresentAndClick(MLWalletEloadPage.objFavorites, getTextVal(MLWalletEloadPage.objFavorites, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objSearch, "Contact Search")) {
            type(MLWalletEloadPage.objSearch, prop.getproperty("favoriteContactNumber"), "Contact Search");
            verifyElementPresent(MLWalletEloadPage.objSearchedContactName, getTextVal(MLWalletEloadPage.objSearchedContactName, "Contact name"));
            verifyElementPresent(MLWalletEloadPage.objSearchedContactNumber, getTextVal(MLWalletEloadPage.objSearchedContactNumber, "Contact Number"));
            logger.info("BE_TC_22, Buy ELoad Search Added Favorite Contact Validated");
            ExtentReporter.extentLoggerPass("BE_TC_22", "BE_TC_22, Buy ELoad Search Added Favorite Contact Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadSearchUnFavoriteContact_BE_TC_23(String sTier) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Search UnFavorite Contact");
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
        verifyElementPresentAndClick(MLWalletEloadPage.objAllowBtn, getTextVal(MLWalletEloadPage.objAllowBtn, "Button"));
        verifyElementPresent(MLWalletEloadPage.objContacts, getTextVal(MLWalletEloadPage.objContacts, "Page"));
        verifyElementPresentAndClick(MLWalletEloadPage.objFavorites, getTextVal(MLWalletEloadPage.objFavorites, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objSearch, "Contact Search")) {
            type(MLWalletEloadPage.objSearch, prop.getproperty("unFavoriteNumber"), "Contact Search");
            verifyElementPresent(MLWalletEloadPage.objNoFavoritesFoundMsg, getTextVal(MLWalletEloadPage.objNoFavoritesFoundMsg, "Message"));
            logger.info("BE_TC_23, Buy ELoad Search UnFavorite Contact Validated");
            ExtentReporter.extentLoggerPass("BE_TC_23", "BE_TC_23, Buy ELoad Search UnFavorite Contact Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadPromoConfirmationPopupValidation_BE_TC_24(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Promo Confirmation Popup Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, "Promo");
        waitTime(5000);
        if (verifyElementPresent(MLWalletEloadPage.objPromoConfirmationPopup, getTextVal(MLWalletEloadPage.objPromoConfirmationPopup, "Popup Msg"))) {
            verifyElementPresent(MLWalletEloadPage.objConfirmBtn, getTextVal(MLWalletEloadPage.objConfirmBtn, "Button"));
            verifyElementPresent(MLWalletEloadPage.objCancelBtn, getTextVal(MLWalletEloadPage.objCancelBtn, "Button"));
            logger.info("BE_TC_24, Buy ELoad Promo Confirmation Popup Validated");
            ExtentReporter.extentLoggerPass("BE_TC_24", "BE_TC_24, Buy ELoad Promo Confirmation Popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadOTPPageUIValidation_BE_TC_25(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad OTP page UI Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        waitTime(5000);
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, "Promo");
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
//			verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
//			verifyElementPresent(MLWalletCashOutPage.objResendCode, getTextVal(MLWalletCashOutPage.objResendCode, "Seconds"));
            logger.info("BE_TC_25, Buy ELoad One Time Pin page UI Validated");
            ExtentReporter.extentLoggerPass("BE_TC_25", "BE_TC_25, Buy ELoad One Time Pin page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadSuccessfulTransactionUIValidation_BE_TC_26(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Successful Transaction UI Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        waitTime(5000);
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, "Promo");
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(30000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            verifyElementPresent(MLWalletEloadPage.objMobileNumberInTransactionDetails, getTextVal(MLWalletEloadPage.objMobileNumberInTransactionDetails, "Mobile Number"));
            verifyElementPresent(MLWalletEloadPage.objBuyELoadTime, getTextVal(MLWalletEloadPage.objBuyELoadTime, "Date and Time"));
            verifyElementPresent(MLWalletEloadPage.objTypeOfPromoUsed, getTextVal(MLWalletEloadPage.objTypeOfPromoUsed, "Promo"));
            verifyElementPresent(MLWalletEloadPage.objAmountToSend, getTextVal(MLWalletEloadPage.objAmountToSend, "Amount to Send"));
            verifyElementPresent(MLWalletEloadPage.objServiceFee, getTextVal(MLWalletEloadPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletEloadPage.objTotalAmount, getTextVal(MLWalletEloadPage.objTotalAmount, "Total Amount"));
            logger.info("BE_TC_26, Buy ELoad Successful Transaction UI validated");
            ExtentReporter.extentLoggerPass("BE_TC_26", "BE_TC_26, Buy ELoad Successful Transaction UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadRecentTransactionUIValidation_BE_TC_27() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Recent Transaction UI Validation");
        buyELoadSuccessfulTransactionUIValidation_BE_TC_26(prop.getproperty("Fully_Verified"), 2);
        verifyElementPresentAndClick(MLWalletEloadPage.objBackToHomeBtn, getTextVal(MLWalletEloadPage.objBackToHomeBtn, "Button"));
        Swipe("DOWN", 2);
        if (verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Header"))) {
            verifyElementPresent(MLWalletHomePage.objBuyELoadTransaction, getTextVal(MLWalletHomePage.objBuyELoadTransaction, "Transaction"));
            verifyElementPresent(MLWalletHomePage.objPosted, getTextVal(MLWalletHomePage.objPosted, "Status"));
            logger.info("BE_TC_27, Buy ELoad Recent Transaction UI validated");
            ExtentReporter.extentLoggerPass("BE_TC_27", "BE_TC_27, Buy ELoad Recent Transaction UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadTransactionDetailsUIValidation_BE_TC_28() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Transaction Details UI Validation");
        buyELoadRecentTransactionUIValidation_BE_TC_27();
        click(MLWalletHomePage.objBuyELoadTransaction, getTextVal(MLWalletHomePage.objBuyELoadTransaction, "Transaction"));
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objLoadType, getTextVal(MLWalletTransactionHistoryPage.objLoadType, "Load Type"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalAmount, getTextVal(MLWalletTransactionHistoryPage.objTotalAmount, "Total Amount"));
            logger.info("BE_TC_28, Buy ELoad Transaction Details UI validated");
            ExtentReporter.extentLoggerPass("BE_TC_28", "BE_TC_28, Buy ELoad Transaction Details UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadLocationPopupValidation_BE_TC_51(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Location Popup Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpValidation();
            logger.info("BE_TC_51, Buy ELoad Location Popup Validated");
            ExtentReporter.extentLoggerPass("BE_TC_51", "BE_TC_51, Buy ELoad Location Popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadLocationDenyFunctionality_BE_TC_52(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Location Deny Functionality");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyPopUp();
            logger.info("BE_TC_52, Buy ELoad Location Deny Functionality Validated");
            ExtentReporter.extentLoggerPass("BE_TC_52", "BE_TC_52, Buy ELoad Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadLocationPermissionDenyCloseBtnFunctionality_BE_TC_53(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Location Permission Deny Close Button Functionality");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyCloseBtnFunctionality();
            if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Page"))) {
                logger.info("BE_TC_53, Buy ELoad Location Permission Deny Close Button Functionality Validated");
                ExtentReporter.extentLoggerPass("BE_TC_53", "BE_TC_53, Buy ELoad Location Permission Deny Close Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void buyELoadLocationPermissionDenyOpenSettingsBtnFunctionality_BE_TC_54(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Location Permission Deny open Settings Button Functionality Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyOpenSettingsBtnFunctionality();
            if (verifyElementPresent(MLWalletEloadPage.objAppInfo, getTextVal(MLWalletEloadPage.objAppInfo, "Page"))) {
                logger.info("BE_TC_54, Buy ELoad Location Permission Deny Open Settings Button Functionality Validated");
                ExtentReporter.extentLoggerPass("BE_TC_54", "BE_TC_54, Buy ELoad Location Permission Deny Open Settings Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void buyELoadLocationPopUpAllowFunctionality_BE_TC_55(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Location popup Allow Button Functionality Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpAllowFunctionality();
            verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, getTextVal(MLWalletEloadPage.objLoadSelectionPage, "Page"));
            logger.info("BE_TC_55, Buy ELoad Location popup Allow Button Functionality Validated");
            ExtentReporter.extentLoggerPass("BE_TC_55", "BE_TC_55, Buy ELoad Location popup Allow Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");

        }
    }

    public void buyELoadContactsPermissionPopup_BE_TC_56(String sTier) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Contacts Permission Popup");
        mlWalletLogin(sTier);
        click(MLWalletEloadPage.objEloadTab, "Buy eLoad");
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            verifyElementPresent(MLWalletHomePage.objContactPopUpAllowBtn, getTextVal(MLWalletHomePage.objContactPopUpAllowBtn, "Button"));
            verifyElementPresent(MLWalletHomePage.objPopUpDenyBtn, getTextVal(MLWalletHomePage.objPopUpDenyBtn, "Button"));
            logger.info("BE_TC_56, Buy ELoad Contacts Permission Popup Validated");
            ExtentReporter.extentLoggerPass("BE_TC_56", "BE_TC_56, Buy ELoad Location popup Allow Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadContactPermissionPopupAllowBtnFunctionality_BE_TC_57() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Contacts Permission Popup Allow Button Functionality");
        buyELoadContactsPermissionPopup_BE_TC_56(prop.getproperty("Fully_Verified"));
        click(MLWalletHomePage.objContactPopUpAllowBtn, getTextVal(MLWalletHomePage.objContactPopUpAllowBtn, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objContacts, getTextVal(MLWalletEloadPage.objContacts, "Page"))) {
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 2; j++) {
                    if (j == 1) {
                        String sContactName = getText(MLWalletEloadPage.objContactsAndNumber(i, j));
                        logger.info("Contact Name : " + sContactName + " is displayed");
                        ExtentReporter.extentLogger(" ", "Contact Name : " + sContactName + " is displayed");
                    }
                    if (j == 2) {
                        String sContactNumber = getText(MLWalletEloadPage.objContactsAndNumber(i, j));
                        logger.info("Contact Number : " + sContactNumber + " is displayed");
                        ExtentReporter.extentLogger(" ", "Contact Number : " + sContactNumber + " is displayed");
                    }
                }
            }
            logger.info("BE_TC_57, Buy ELoad Contacts Permission Popup Allow Button Functionality Validated");
            ExtentReporter.extentLoggerPass("BE_TC_57", "BE_TC_57, Buy ELoad Contacts Permission Popup Allow Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_58() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Contacts Permission Popup Deny Button Functionality");
        buyELoadContactsPermissionPopup_BE_TC_56(prop.getproperty("Fully_Verified"));
        click(MLWalletHomePage.objPopUpDenyBtn, getTextVal(MLWalletHomePage.objPopUpDenyBtn, "Button"));
        verifyElementPresentAndClick(MLWalletEloadPage.objContactsPageBackBtn, "Contact Page Back Arrow Button");
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objContactPopupMsg, getTextVal(MLWalletEloadPage.objContactPopupMsg, "Popup"))) {
            verifyElementPresent(MLWalletEloadPage.objAllowAccess, getTextVal(MLWalletEloadPage.objAllowAccess, "Button"));
            verifyElementPresent(MLWalletEloadPage.objAskMeLater, getTextVal(MLWalletEloadPage.objAskMeLater, "Button"));
            logger.info("BE_TC_58, Buy ELoad Contacts Permission Popup Deny Button Functionality Validated");
            ExtentReporter.extentLoggerPass("BE_TC_58", "BE_TC_58, Buy ELoad Contacts Permission Popup Deny Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadContactPermissionTwoDenyBtnFunctionality_BE_TC_59() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Contact PermissionTwo Deny Button Functionality");
        buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_58();
        click(MLWalletEloadPage.objAllowAccess, getTextVal(MLWalletEloadPage.objAllowAccess, "Button"));
        verifyElementPresentAndClick(MLWalletHomePage.objContactPopupDenyBtn, getTextVal(MLWalletHomePage.objContactPopupDenyBtn, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objNoContactsFoundMsg, getTextVal(MLWalletEloadPage.objNoContactsFoundMsg, "Message"))) {
            logger.info("BE_TC_59, Buy ELoad Contact PermissionTwo Deny Button Functionality validated");
            ExtentReporter.extentLoggerPass("BE_TC_59", "BE_TC_59, Buy ELoad Contact PermissionTwo Deny Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadContactPermissionTwoAllowBtnFunctionality_BE_TC_60() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Contact PermissionTwo Allow Button Functionality");
        buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_58();
        click(MLWalletEloadPage.objAllowAccess, getTextVal(MLWalletEloadPage.objAllowAccess, "Button"));
        verifyElementPresentAndClick(MLWalletHomePage.objContactPopUpAllowBtn, getTextVal(MLWalletHomePage.objContactPopUpAllowBtn, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objContacts, getTextVal(MLWalletEloadPage.objContacts, "Page"))) {
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 2; j++) {
                    if (j == 1) {
                        String sContactName = getText(MLWalletEloadPage.objContactsAndNumber(i, j));
                        logger.info("Contact Name : " + sContactName + " is displayed");
                        ExtentReporter.extentLogger(" ", "Contact Name : " + sContactName + " is displayed");
                    }
                    if (j == 2) {
                        String sContactNumber = getText(MLWalletEloadPage.objContactsAndNumber(i, j));
                        logger.info("Contact Number : " + sContactNumber + " is displayed");
                        ExtentReporter.extentLogger(" ", "Contact Number : " + sContactNumber + " is displayed");
                    }
                }
            }
            logger.info("BE_TC_60, Buy ELoad Contact PermissionTwo Allow Button Functionality Validated");
            ExtentReporter.extentLoggerPass("BE_TC_60", "BE_TC_60, Buy ELoad Contact PermissionTwo Allow Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadInternetInterruptionWhileEnteringOTP_BE_TC_61(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Internet Interruption While Entering OTP Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(20000);
        setWifiConnectionToONOFF("OFF");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"))) {
            internetConnectionError();
            logger.info("BE_TC_61, Buy ELoad Internet Interruption While Entering OTP Validated");
            ExtentReporter.extentLoggerPass("BE_TC_61", "BE_TC_61, Buy ELoad Internet Interruption While Entering OTP Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadLocationPermissionAskMeLaterButtonFunctionality_BE_TC_62() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Location Permission Ask Me Later Button Functionality");
        buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_58();
        verifyElementPresentAndClick(MLWalletEloadPage.objAskMeLater, getTextVal(MLWalletEloadPage.objAskMeLater, "Button"));
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            verifyElementPresent(MLWalletHomePage.objContactPopUpAllowBtn, getTextVal(MLWalletHomePage.objContactPopUpAllowBtn, "Button"));
            verifyElementPresent(MLWalletHomePage.objContactPopupDenyBtn, getTextVal(MLWalletHomePage.objContactPopupDenyBtn, "Button"));
            logger.info("BE_TC_62, Buy ELoad Location Permission Ask Me Later Button Functionality Validated");
            ExtentReporter.extentLoggerPass("BE_TC_62", "BE_TC_62, Buy ELoad Location Permission Ask Me Later Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadLocationPermissionTwoDenyBtnFunctionality_BE_TC_63() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Location PermissionTwo Deny Button Functionality");
        buyELoadLocationPermissionAskMeLaterButtonFunctionality_BE_TC_62();
        click(MLWalletHomePage.objContactPopupDenyBtn, getTextVal(MLWalletHomePage.objContactPopupDenyBtn, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objNoContactsFoundMsg, getTextVal(MLWalletEloadPage.objNoContactsFoundMsg, "Message"))) {
            logger.info("BE_TC_63, Buy ELoad Location PermissionTwo Deny Button Functionality validated");
            ExtentReporter.extentLoggerPass("BE_TC_63", "BE_TC_63, Buy ELoad Location PermissionTwo Deny Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadLocationPermissionTwoAllowBtnFunctionality_BE_TC_64() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Location PermissionTwo Allow Button Functionality");
        buyELoadLocationPermissionAskMeLaterButtonFunctionality_BE_TC_62();
        click(MLWalletHomePage.objContactPopUpAllowBtn, getTextVal(MLWalletHomePage.objContactPopUpAllowBtn, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objContacts, getTextVal(MLWalletEloadPage.objContacts, "Page"))) {
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 2; j++) {
                    if (j == 1) {
                        String sContactName = getText(MLWalletEloadPage.objContactsAndNumber(i, j));
                        logger.info("Contact Name : " + sContactName + " is displayed");
                        ExtentReporter.extentLogger(" ", "Contact Name : " + sContactName + " is displayed");
                    }
                    if (j == 2) {
                        String sContactNumber = getText(MLWalletEloadPage.objContactsAndNumber(i, j));
                        logger.info("Contact Number : " + sContactNumber + " is displayed");
                        ExtentReporter.extentLogger(" ", "Contact Number : " + sContactNumber + " is displayed");
                    }
                }
            }
            logger.info("BE_TC_64, Buy ELoad Location PermissionTwo Allow Button Functionality Validated");
            ExtentReporter.extentLoggerPass("BE_TC_64", "BE_TC_64, Buy ELoad Location PermissionTwo Allow Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadContactPopupNotDisplayedAfterClickingODenyButtonValidation_BE_TC_65() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Contact Popup Not displayed After Clicking On Deny Button Validation");
        buyELoadLocationPermissionAskMeLaterButtonFunctionality_BE_TC_62();
        click(MLWalletHomePage.objContactPopupDenyBtn, getTextVal(MLWalletHomePage.objContactPopupDenyBtn, "Button"));
        verifyElementPresentAndClick(MLWalletEloadPage.objContactsPageBackBtn, "Contacts Page Back Btn");
        verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage, getTextVal(MLWalletEloadPage.objEloadtransactionPage, "Page"));
        verifyElementPresentAndClick(MLWalletEloadPage.objSelectFromContacts, getTextVal(MLWalletEloadPage.objSelectFromContacts, "Button"));
        if (verifyElementNotPresent(MLWalletEloadPage.objContactPopupMsg, "Contacts Popup", 5)) {
            logger.info("BE_TC_65, Buy ELoad Contact Popup Not displayed After Clicking On Deny Button is Validated");
            ExtentReporter.extentLoggerPass("BE_TC_65", "BE_TC_65, Buy ELoad Contact Popup Not displayed After Clicking On Deny Button is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadNewTransactionBtnFunctionality_BE_TC_66() throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad New Transaction Button Functionality");
        buyELoadTransactionDetails_BE_TC_01(prop.getproperty("Fully_Verified"), 3);
        verifyElementPresentAndClick(MLWalletCashOutPage.objNewTransaction, getTextVal(MLWalletCashOutPage.objNewTransaction, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objEloadtransactionPage, getTextVal(MLWalletEloadPage.objEloadtransactionPage, "Page"))) {
            logger.info("BE_TC_66, Buy ELoad New Transaction Button Functionality Validated");
            ExtentReporter.extentLoggerPass("BE_TC_66", "BE_TC_66, Buy ELoad New Transaction Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadTransactionValidationAfterMinimizingApp_BE_TC_069(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Transaction Validation After Minimizing App");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        enterOTP(prop.getproperty("Valid_OTP"));
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        waitTime(20000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_069, Buy ELoad Transaction Validation After Minimizing App Validated");
            ExtentReporter.extentLoggerPass("BE_TC_069", "BE_TC_069, Buy ELoad Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadTransactionWithValidMLPin_BE_TC_78(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Transaction With Valid MLPin");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        handleMpin("1111");
        waitTime(30000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            verifyElementPresent(MLWalletEloadPage.objMobileNumberInTransactionDetails, getTextVal(MLWalletEloadPage.objMobileNumberInTransactionDetails, "Mobile Number"));
            verifyElementPresent(MLWalletEloadPage.objBuyELoadTime, getTextVal(MLWalletEloadPage.objBuyELoadTime, "Date and Time"));
            verifyElementPresent(MLWalletEloadPage.objTypeOfPromoUsed, getTextVal(MLWalletEloadPage.objTypeOfPromoUsed, "Promo"));
            verifyElementPresent(MLWalletEloadPage.objAmountToSend, getTextVal(MLWalletEloadPage.objAmountToSend, "Amount to Send"));
            verifyElementPresent(MLWalletEloadPage.objServiceFee, getTextVal(MLWalletEloadPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletEloadPage.objTotalAmount, getTextVal(MLWalletEloadPage.objTotalAmount, "Total Amount"));
            logger.info("BE_TC_78, Buy ELoad Transaction With Valid MLPin is Validated");
            ExtentReporter.extentLoggerPass("BE_TC_78", "BE_TC_78, Buy ELoad Transaction With Valid MLPin is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadTransactionWithInValidMLPin_BE_TC_79(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Transaction With InValid MLPin");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        handleMpin("1234");
        if (verifyElementPresent(MLWalletEloadPage.objInvalidPINMsg, getTextVal(MLWalletEloadPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletEloadPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("BE_TC_79, Buy ELoad Transaction With Invalid ML Pin validated");
            ExtentReporter.extentLoggerPass("BE_TC_79", "BE_TC_79, Buy ELoad Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadInOTPPopupValidation_BE_TC_089(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Transaction IN App OTP Popup Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            logger.info("BE_TC_089, Buy ELoad, InApp OTP popup validated");
            ExtentReporter.extentLoggerPass("BE_TC_089", "BE_TC_089, Buy ELoad, InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadTransactionInAppOTPPopupUIValidation_BE_TC_090(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Transaction InApp OTP popup UI Validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds, getTextVal(MLWalletLoginPage.objSeconds, "Seconds"));
            verifyElementPresent(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
            logger.info("BE_TC_090, Buy ELoad Transaction InApp OTP popup UI validated");
            ExtentReporter.extentLoggerPass("BE_TC_090", "BE_TC_090, Buy ELoad Transaction InApp OTP popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadTransactionNewOTPAfterSixtySecondsValidation_BE_TC_091(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad New OTP got generated After Sixty Seconds validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if (verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"))) {
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP, sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("BE_TC_091, Buy ELoad Transaction New OTP got generated After Sixty Seconds is validated");
            ExtentReporter.extentLoggerPass("BE_TC_091", "BE_TC_091, Buy ELoad Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadTransactionOTPCancelBtnFunctionality_BE_TC_092(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Transaction OTP Cancel Button Functionality");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"))) {
            logger.info("BE_TC_092, Buy ELoad Transaction, After clicking on Cancel in One time pin popup App navigates back to Buy ELoad Page is validated");
            ExtentReporter.extentLoggerPass("BE_TC_092", "BE_TC_092, Buy ELoad Transaction, After clicking on Cancel in One time pin popup App navigates back to Buy ELoad Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadTransactionOTPContinueBtnFunctionality_BE_TC_093(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Transaction OTP Continue Button Functionality");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.objTransaction, getTextVal(MLWalletEloadPage.objTransaction, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        waitTime(30000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_093, Buy ELoad Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            ExtentReporter.extentLoggerPass("BE_TC_093", "BE_TC_093, Buy ELoad Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumTransactionForBranchVerifiedTier_BE_TC_42(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad maximum transaction for Branch verified Tier");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.obj2000PromoLoad, getTextVal(MLWalletEloadPage.obj2000PromoLoad, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        waitTime(30000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_42, Buy ELoad maximum transaction for Branch verified Tier validated");
            ExtentReporter.extentLoggerPass("BE_TC_42", "BE_TC_42, Buy ELoad maximum transaction for Branch verified Tier validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumTransactionForSemiVerifiedTier_BE_TC_30(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad maximum transaction for Semi verified Tier");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.obj2000PromoLoad, getTextVal(MLWalletEloadPage.obj2000PromoLoad, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_30, Buy ELoad maximum transaction for Semi verified Tier validated");
            ExtentReporter.extentLoggerPass("BE_TC_30", "BE_TC_42, Buy ELoad maximum transaction for Semi verified Tier validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumLimitForSemiVerifiedTier_BE_TC_33(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad maximum Limit reached Error msg validation for Semi verified Tier");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        Swipe("UP", 1);
        click(MLWalletEloadPage.obj3000PromoLoad, getTextVal(MLWalletEloadPage.obj3000PromoLoad, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(2000);
        if (verifyElementPresent(MLWalletEloadPage.objMaxLimitErrorMsg, getTextVal(MLWalletEloadPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sErrorMsg = getText(MLWalletEloadPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum E-load per transaction set for your verification level is P2,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("BE_TC_33, Buy ELoad maximum Limit reached Error msg validated for Semi verified Tier");
            ExtentReporter.extentLoggerPass("BE_TC_33", "BE_TC_33, Buy ELoad maximum Limit reached Error msg validated for Semi verified Tier");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumLimitForFullyVerifiedTier_BE_TC_39(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad maximum Limit reached Error msg validation for Fully verified Tier");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        Swipe("UP", 1);
        click(MLWalletEloadPage.obj3000PromoLoad, getTextVal(MLWalletEloadPage.obj3000PromoLoad, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(2000);
        if (verifyElementPresent(MLWalletEloadPage.objMaxLimitErrorMsg, getTextVal(MLWalletEloadPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sErrorMsg = getText(MLWalletEloadPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum E-load per transaction set for your verification level is P2,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("BE_TC_39, Buy ELoad maximum Limit reached Error msg validated for Fully verified Tier");
            ExtentReporter.extentLoggerPass("BE_TC_39", "BE_TC_39, Buy ELoad maximum Limit reached Error msg validated for Fully verified Tier");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumTransactionForFullyVerifiedTier_BE_TC_36(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad maximum transaction for Fully verified Tier");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.obj2000PromoLoad, getTextVal(MLWalletEloadPage.obj2000PromoLoad, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_36, Buy ELoad maximum transaction for Fully verified Tier validated");
            ExtentReporter.extentLoggerPass("BE_TC_36", "BE_TC_36, Buy ELoad maximum transaction for Fully verified Tier validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void buyELoadMaximumLimitForBuyerTierVerifiedTier_BE_TC_45(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad maximum Limit reached Error msg validation for Buyer Tier verified Tier");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        Swipe("UP", 2);
        click(MLWalletEloadPage.obj3000PromoLoad, getTextVal(MLWalletEloadPage.obj3000PromoLoad, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(2000);
        if (verifyElementPresent(MLWalletEloadPage.objMaxLimitErrorMsg, getTextVal(MLWalletEloadPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sErrorMsg = getText(MLWalletEloadPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum E-load per transaction set for your verification level is P2,000.00. Please try again.";
            assertionValidation(sErrorMsg, sExpectedErrorMsg);
            logger.info("BE_TC_45, Buy ELoad maximum Limit reached Error msg validated for Buyer Tier verified Tier");
            ExtentReporter.extentLoggerPass("BE_TC_45", "BE_TC_45, Buy ELoad maximum Limit reached Error msg validated for Buyer Tier verified Tier");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_48(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad maximum transaction for Buyer Tier verified Tier");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.obj2000PromoLoad, getTextVal(MLWalletEloadPage.obj2000PromoLoad, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletEloadPage.objTransactionDetailsPage, getTextVal(MLWalletEloadPage.objTransactionDetailsPage, "Page"))) {
            logger.info("BE_TC_48, Buy ELoad maximum transaction for Buyer Tier verified Tier validated");
            ExtentReporter.extentLoggerPass("BE_TC_48", "BE_TC_48, Buy ELoad maximum transaction for Buyer Tier verified Tier validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadSecondTimeLoadSelectionPopupValidation_BE_TC_29(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad Second time Load selection popup validation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.obj2000PromoLoad, getTextVal(MLWalletEloadPage.obj2000PromoLoad, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresentAndClick(MLWalletEloadPage.objBuyLoadBackArrowBtn, "Buy Load Back Arrow Button");
        click(MLWalletEloadPage.obj2000PromoLoad, getTextVal(MLWalletEloadPage.obj2000PromoLoad, "Promo"));
        if (verifyElementPresent(MLWalletEloadPage.objSecondTimeConfirmationPopup, getTextVal(MLWalletEloadPage.objSecondTimeConfirmationPopup, "Popup"))) {
            verifyElementPresent(MLWalletEloadPage.obj2000PromoLoad, getTextVal(MLWalletEloadPage.obj2000PromoLoad, "Promo Load"));
            logger.info("BE_TC_29, Buy ELoad Second time Load selection popup validated");
            ExtentReporter.extentLoggerPass("BE_TC_29", "BE_TC_29, Buy ELoad Second time Load selection popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void buyELoadMLPinPageNavigation_BE_TC_87(String sTier, int promotab) throws Exception {
        ExtentReporter.HeaderChildNode("Buy ELoad ML pin page navigation");
        eLoad_generic(sTier, prop.getproperty("Smart"), "true", promotab);
        enableLocation_PopUp();
        verifyElementPresent(MLWalletEloadPage.objLoadSelectionPage, "Load Selection Page");
        click(MLWalletEloadPage.objPromoLoadTab, "Promo Load Tab");
        waitTime(5000);
        click(MLWalletEloadPage.obj2000PromoLoad, getTextVal(MLWalletEloadPage.obj2000PromoLoad, "Promo"));
        verifyElementPresent(MLWalletEloadPage.objContinuePromoPopUp, getTextVal(MLWalletEloadPage.objContinuePromoPopUp, "Pop Up"));
        waitTime(5000);
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        verifyElementPresent(MLWalletEloadPage.objBuyLoad, getTextVal(MLWalletEloadPage.objBuyLoad, "Page"));
        click(MLWalletEloadPage.objConfirmBtn, "Confirm Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletEloadPage.objMLPinEditField, "ML Pin Page")) {
            logger.info("BE_TC_87, Buy ELoad ML pin page navigation validated");
            ExtentReporter.extentLoggerPass("BE_TC_87", "BE_TC_87, Buy ELoad ML pin page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
