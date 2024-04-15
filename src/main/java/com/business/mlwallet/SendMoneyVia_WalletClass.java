package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.mlwallet.pages.*;
import com.utility.ExtentReporter;

import java.time.Duration;

import static com.utility.Utilities.*;

public class SendMoneyVia_WalletClass extends BaseClass{
    public SendMoneyVia_WalletClass() {
        super();
    }

    public void sendToMLWalletUser_STW_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Wallet");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objSendMoneyMLWallet, getTextVal(SendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletPHP, getTextVal(SendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletDate, getTextVal(SendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            String sReferenceNumber = getText(SendTransferPage.objMLWalletReferenceNumber);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            click(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            if (verifyElementPresent(SendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(SendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInWalletToWallet = getText(SendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInWalletToWallet);
                assertionValidation(sReferenceNumberInWalletToWallet, sReferenceNumber);
                logger.info("STW_TC_01, Successfully Amount sent from Wallet to Wallet and Transaction Details is validated");
                ExtentReporter.extentLoggerPass("STW_TC_01", "STW_TC_01, Successfully Amount sent from Wallet to Wallet and Transaction Details is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyAddToFavorites_STW_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money Add To Favorites");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objSendMoneyMLWallet, getTextVal(SendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletPHP, getTextVal(SendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletDate, getTextVal(SendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            String sReferenceNumber = getText(SendTransferPage.objMLWalletReferenceNumber);
            System.out.println(sReferenceNumber);
            Swipe("UP", 1);
            click(SendTransferPage.objSaveToMyFavorite, getTextVal(SendTransferPage.objSaveToMyFavorite, "Button"));
            if (verifyElementPresent(SendTransferPage.objAddedToFavoritesMsg, getTextVal(SendTransferPage.objAddedToFavoritesMsg, "Message"))) {
                click(SendTransferPage.objOkBtn, getTextVal(SendTransferPage.objOkBtn, "Button"));
            }
            if (verifyElementPresent(SendTransferPage.objSendMoney, getTextVal(SendTransferPage.objSendMoney, "Page"))) {
                verifyElementPresent(SendTransferPage.objFavoriteReceiver, "Added Favorites");
                logger.info("STW_TC_12, Added to favorites and displayed in Recent Favorites");
                ExtentReporter.extentLoggerPass("STW_TC_12", "STW_TC_12, Added to favorites and displayed in Recent Favorites");
                System.out.println("-----------------------------------------------------------");
            }

        }
    }


    public void kwartaPadalaViaMLWalletSuccessfulTransaction_STW_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet To Existing Receiver");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        verifyElementPresent(SendTransferPage.objSelectFavorite, getTextVal(SendTransferPage.objSelectFavorite, "Text"));
        click(SendTransferPage.objSelectFavorite, getTextVal(SendTransferPage.objSelectFavorite, "Text"));
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objSendMoneyMLWallet, getTextVal(SendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletPHP, getTextVal(SendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletDate, getTextVal(SendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            String sReferenceNumber = getText(SendTransferPage.objMLWalletReferenceNumber);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            click(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            if (verifyElementPresent(SendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(SendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInWalletToWallet = getText(SendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInWalletToWallet);
                assertionValidation(sReferenceNumberInWalletToWallet, sReferenceNumber);
                logger.info("STW_TC_02, Successfully Amount sent from Wallet to Wallet to Recently added favorite and Transaction Details is validated");
                ExtentReporter.extentLoggerPass("STW_TC_02", "STW_TC_02, Successfully Amount sent from Wallet to Wallet to Recently added favorite and Transaction Details is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }

    }


    public void sendToMLWalletInvalidMobNumber_STW_TC_03() throws Exception {
        ExtentReporter.HeaderChildNode("Send To ML Wallet to Invalid Mobile Number");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Invalid_MobileNumber"));
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objMobileNumberErrorMsg, getTextVal(SendTransferPage.objMobileNumberErrorMsg, "Error Message"))) {
            String sFirstNameErrorMsg = getText(SendTransferPage.objMobileNumberErrorMsg);
            String sExpectedMsg = "Mobile number is invalid";
            assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
            logger.info("STW_TC_03, Mobile number is invalid - Error Message is validated");
            ExtentReporter.extentLoggerPass("STW_TC_03", "STW_TC_03, Mobile number is invalid - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendToMLWalletUnRegisteredNumber_STW_TC_04() throws Exception {
        ExtentReporter.HeaderChildNode("Send To ML Wallet to Invalid Mobile Number");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Unregistered_MobileNumber"));
        waitTime(10000);
        if (verifyElementPresent(SendTransferPage.objUnRegisteredMobNumber, getTextVal(SendTransferPage.objUnRegisteredMobNumber, "Error Message"))) {
            String sFirstNameErrorMsg = getText(SendTransferPage.objUnRegisteredMobNumber);
            String sExpectedMsg = "Receiver not Found!";
            assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
            logger.info("STW_TC_04, Receiver not Found - Error Message is validated");
            ExtentReporter.extentLoggerPass("STW_TC_04", "STW_TC_04, Receiver not Found - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendToMLWalletInvalidAmount_STW_TC_05(String Amount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        type(SendTransferPage.objAmountTxtField, Amount, "Amount Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objInvalidAmountMsg, getTextVal(SendTransferPage.objInvalidAmountMsg, "Error Message"))) {
            String sInvalidAmountErrorMsg = getText(SendTransferPage.objInvalidAmountMsg);
            String sExpectedErrorMsg = "The amount should not be less than 1";
            assertionValidation(sInvalidAmountErrorMsg, sExpectedErrorMsg);
            logger.info("STW_TC_05, The amount should not be less than 1 - Error Message is validated");
            ExtentReporter.extentLoggerPass("STW_TC_05", "STW_TC_05, The amount should not be less than 1 - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendToMLWalletInsufficientAmount_STW_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Branch");
        sendMoneyMLWallet("9999999997");
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("35000");
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objInsufficientAmountMsg, getTextVal(SendTransferPage.objInsufficientAmountMsg, "Error Message"))) {
            String sInsufficientBalanceErrorMsg = getText(SendTransferPage.objInsufficientAmountMsg);
            String sExpectedErrorMsg = "There is insufficient balance to proceed with this transaction. Please try again.";
            assertionValidation(sInsufficientBalanceErrorMsg, sExpectedErrorMsg);
            logger.info("STW_TC_06, Insufficient Balance - Error Message is validated");
            ExtentReporter.extentLoggerPass("STW_TC_06", "STW_TC_06, Insufficient Balance - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyMLWalletMaximumAmount_STW_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet Maximum Amount");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("100000");
        if (verifyElementPresent(SendTransferPage.objMaxLimitErrorMsg, getTextVal(SendTransferPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(SendTransferPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            logger.info("STW_TC_07, The maximum send money per transaction - Error Message is validated");
            ExtentReporter.extentLoggerPass("STW_TC_07", "STW_TC_07, The maximum send money per transaction - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyDeleteFromFavorites_STW_TC_09() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money Delete From Favorites");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objSendMoney, getTextVal(SendTransferPage.objSendMoney, "Page"));
        click(SendTransferPage.objViewAllBtn, getTextVal(SendTransferPage.objViewAllBtn, "Text"));
        click(SendTransferPage.objEllipsisBtn, "Ellipsis Button");
        click(SendTransferPage.objDeleteBtn, getTextVal(SendTransferPage.objDeleteBtn, "Button"));
        click(SendTransferPage.objConfirmBtn, getTextVal(SendTransferPage.objConfirmBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objFavRemovedMsg, getTextVal(SendTransferPage.objFavRemovedMsg, "Pop up Message"))) {
            String sRemovedSuccessfulMsg = getText(SendTransferPage.objFavRemovedMsg);
            String sExpectedMsg = "Successfully Removed";
            assertionValidation(sRemovedSuccessfulMsg, sExpectedMsg);
            logger.info("STW_TC_09, Successfully removed Favorite Contact from favorites list is validated");
            ExtentReporter.extentLoggerPass("STW_TC_09", "STW_TC_09, Successfully removed Favorite Contact from favorites list is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyMLWalletUIValidation_STW_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet Page UI Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objSendMoney, getTextVal(SendTransferPage.objSendMoney, "Page"))) {
            verifyElementPresent(SendTransferPage.objViewAllBtn, getTextVal(SendTransferPage.objViewAllBtn, "Button"));
            verifyElementPresent(SendTransferPage.objRecentFavorites, getTextVal(SendTransferPage.objRecentFavorites, "Header"));
            verifyElementPresent(SendTransferPage.objReceiver, getTextVal(SendTransferPage.objReceiver, "Header"));
            verifyElementPresent(SendTransferPage.objMobileNumberField, "Mobile number input text field");
            verifyElementPresent(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
            logger.info("STW_TC_10, Send Money ML Wallet Page UI validated");
            ExtentReporter.extentLoggerPass("STW_TC_10", "STW_TC_10, Send Money ML Wallet Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyFavoritesUIValidation_STW_TC_11() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money Saved Favorites UI Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        waitTime(5000);
        verifyElementPresentAndClick(SendTransferPage.objViewAllBtn, getTextVal(SendTransferPage.objViewAllBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.ObjFavorites, getTextVal(SendTransferPage.ObjFavorites, "Page"))) {
            verifyElementPresent(SendTransferPage.objSearchFavoriteField, "Search Favorites Field");
            logger.info("STW_TC_11, Send Money ML Wallet Page UI validated");
            ExtentReporter.extentLoggerPass("STW_TC_11", "STW_TC_11, Send Money ML Wallet Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletCancelTransaction_STW_TC_13(String nAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet Cancel Transaction");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objToMLWalletUser, getTextVal(SendTransferPage.objToMLWalletUser, "Page"))) {
            type(SendTransferPage.objAmountTxtField, nAmount, "Amount Text Field");
            click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
            click(SendTransferPage.objMLWalletBalance, getTextVal(SendTransferPage.objMLWalletBalance, "Button"));
            verifyElementPresent(SendTransferPage.objConfirmDetails, getTextVal(SendTransferPage.objConfirmDetails, "Page"));
            Swipe("UP", 1);
            verifyElementPresentAndClick(SendTransferPage.objCancelTransaction, getTextVal(SendTransferPage.objCancelTransaction, "Button"));
            waitTime(5000);
            if (verifyElementPresent(SendTransferPage.objSendMoney, getTextVal(SendTransferPage.objSendMoney, "Page"))) {
                logger.info("STW_TC_13, Cancelled the current Transaction");
                ExtentReporter.extentLoggerPass("STW_TC_13", "STW_TC_13, Cancelled the current Transaction");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyMLWalletSearchUnFavoriteUser_STW_TC_14() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet Search UnFavorite User");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        waitTime(5000);
        verifyElementPresentAndClick(SendTransferPage.objViewAllBtn, getTextVal(SendTransferPage.objViewAllBtn, "Button"));
        verifyElementPresent(SendTransferPage.ObjFavorites, getTextVal(SendTransferPage.ObjFavorites, "Page"));
        type(SendTransferPage.objSearchFavoriteField, "ABCD", "Search Favorite Field");
        if (verifyElementPresent(SendTransferPage.objNoRecentTransactionTxt, getTextVal(SendTransferPage.objNoRecentTransactionTxt, "Added Favorite"))) {
            logger.info("STW_TC_14, Send Money ML Wallet Search UnFavorite User Validated");
            ExtentReporter.extentLoggerPass("STW_TC_14", "STW_TC_14, Send Money ML Wallet Search UnFavorite User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletSearchFavoriteUser_STW_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet Search Favorite User");
        sendMoneyAddToFavorites_STW_TC_12();
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        waitTime(5000);
        verifyElementPresentAndClick(SendTransferPage.objViewAllBtn, getTextVal(SendTransferPage.objViewAllBtn, "Button"));
        verifyElementPresent(SendTransferPage.ObjFavorites, getTextVal(SendTransferPage.ObjFavorites, "Page"));
        type(SendTransferPage.objSearchFavoriteField, prop.getproperty("Last_Name"), "Search Favorite Field");
        if (verifyElementPresent(SendTransferPage.objAddedFavorite, getTextVal(SendTransferPage.objAddedFavorite, "Added Favorite"))) {
            logger.info("STW_TC_15, Send Money ML Wallet Search Favorite User Validated");
            ExtentReporter.extentLoggerPass("STW_TC_15", "STW_TC_15, Send Money ML Wallet Search Favorite User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletSuccessPageUIValidation_STW_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet Success Page UI Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objSendMoneyMLWallet, getTextVal(SendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletPHP, getTextVal(SendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletDate, getTextVal(SendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            verifyElementPresent(SendTransferPage.objReceiverName, getTextVal(SendTransferPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(SendTransferPage.objReceiverMobileNo, getTextVal(SendTransferPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(SendTransferPage.objPaymentMethod, getTextVal(SendTransferPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(SendTransferPage.objAmount, getTextVal(SendTransferPage.objAmount, "Amount"));
            verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"));
            verifyElementPresent(SendTransferPage.objTotalAmount, getTextVal(SendTransferPage.objTotalAmount, "Total Amount"));
            Swipe("UP", 2);
            verifyElementPresent(SendTransferPage.objSaveToMyFavorite, getTextVal(SendTransferPage.objSaveToMyFavorite, "Button"));
            verifyElementPresent(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
            verifyElementPresent(SendTransferPage.objNewTransaction, getTextVal(SendTransferPage.objNewTransaction, "Button"));
            logger.info("STW_TC_16,Send Money ML Wallet Success Page UI Validated");
            ExtentReporter.extentLoggerPass("STW_TC_16", "STW_TC_16, Send Money ML Wallet Success Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletOTPPageUIValidation_STW_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet OTP PageUI Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
//			verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
//			verifyElementPresent(MLWalletCashOutPage.objResendCode, getTextVal(MLWalletCashOutPage.objResendCode, "Seconds"));
            logger.info("STW_TC_17, One Time Pin page UI Validated");
            ExtentReporter.extentLoggerPass("STW_TC_17", "STW_TC_16, One Time Pin page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletConfirmDetailsPageUIValidation_STW_TC_18(String nAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet Confirm Details Page UI Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        verifyElementPresent(SendTransferPage.objToMLWalletUser, getTextVal(SendTransferPage.objToMLWalletUser, "Page"));
        type(SendTransferPage.objAmountTxtField, nAmount, "Amount Text Field");
        click(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
        click(SendTransferPage.objMLWalletBalance, getTextVal(SendTransferPage.objMLWalletBalance, "Button"));
        if (verifyElementPresent(SendTransferPage.objConfirmDetails, getTextVal(SendTransferPage.objConfirmDetails, "Page"))) {
            verifyElementPresent(SendTransferPage.objReceiverName, getTextVal(SendTransferPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(SendTransferPage.objReceiverMobileNo, getTextVal(SendTransferPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(SendTransferPage.objPaymentMethod, getTextVal(SendTransferPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(SendTransferPage.objAmount, getTextVal(SendTransferPage.objAmount, "Amount"));
            verifyElementPresent(SendTransferPage.objServiceFee, getTextVal(SendTransferPage.objServiceFee, "Service Fee"));
            verifyElementPresent(SendTransferPage.objTotalAmount, getTextVal(SendTransferPage.objTotalAmount, "Total Amount"));
            verifyElementPresent(SendTransferPage.objCancelTransaction, getTextVal(SendTransferPage.objCancelTransaction, "Button"));
            Swipe("UP", 1);
            verifyElementPresent(SendTransferPage.objSendPHPBtn, getTextVal(SendTransferPage.objSendPHPBtn, "Button"));
            logger.info("STW_TC_18, Send Money ML Wallet Confirm Details Page UI Validated");
            ExtentReporter.extentLoggerPass("STW_TC_18", "STW_TC_18, Send Money ML Wallet Confirm Details Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMlWalletEnterAmountPageUIValidation_STW_TC_19() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To Ml Wallet Enter Amount Page UI Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objToMLWalletUser, getTextVal(SendTransferPage.objToMLWalletUser, "Page"))) {
            verifyElementPresent(SendTransferPage.objAmountToSend, getTextVal(SendTransferPage.objAmountToSend, "Header"));
            verifyElementPresent(SendTransferPage.objAmountTxtField, "Amount Text Field");
            verifyElementPresent(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
            logger.info("STW_TC_19, Send Money To Ml Wallet Enter Amount Page UI Validated");
            ExtentReporter.extentLoggerPass("STW_TC_19", "STW_TC_19, Send Money To Ml Wallet Enter Amount Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLWalletPageUIValidation_STW_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Page UI Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        waitTime(5000);
        if (verifyElementPresent(SendTransferPage.objSendMoney, getTextVal(SendTransferPage.objSendMoney, "Page"))) {
            verifyElementPresent(SendTransferPage.objRecentFavorites, getTextVal(SendTransferPage.objRecentFavorites, "Header"));
            verifyElementPresent(SendTransferPage.objViewAllBtn, getTextVal(SendTransferPage.objViewAllBtn, "Button"));
            verifyElementPresent(SendTransferPage.objReceiver, getTextVal(SendTransferPage.objReceiver, "Header"));
            verifyElementPresent(SendTransferPage.objMobileNumberField, "Mobile Number Text Field");
            verifyElementPresent(SendTransferPage.objNextBtn, getTextVal(SendTransferPage.objNextBtn, "Button"));
            logger.info("STW_TC_20, Send Money To ML Wallet Page UI Validated");
            ExtentReporter.extentLoggerPass("STW_TC_20", "STW_TC_20, Send Money To ML Wallet Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMlWalletTransactionDetailsUIValidation_STW_TC_21() throws Exception {
        ExtentReporter.HeaderChildNode("Transaction Details of Wallet To Wallet Page UI Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objSendMoneyMLWallet, getTextVal(SendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletPHP, getTextVal(SendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletDate, getTextVal(SendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            Swipe("UP", 2);
            click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            click(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
                verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objDate, getTextVal(MLWalletTransactionHistoryPage.objDate, "Date"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objSenderName, getTextVal(MLWalletTransactionHistoryPage.objSenderName, "Sender Name"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
                verifyElementPresent(MLWalletTransactionHistoryPage.objTotalAmount, getTextVal(MLWalletTransactionHistoryPage.objTotalAmount, "Total Amount"));
                logger.info("STW_TC_21, Transaction Details of Wallet To Wallet Page UI Validation Validated");
                ExtentReporter.extentLoggerPass("STW_TC_21", "STW_TC_21, Transaction Details of Wallet To Wallet Page UI Validation Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyMLWalletBuyerTierAccountUser_STW_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet Buyer Tier Account User Transaction");
        sendMoneyMLWallet(prop.getproperty("Buyer_Tier"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        if (verifyElementPresent(SendTransferPage.objErrorMsg, getTextVal(SendTransferPage.objErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(SendTransferPage.objErrorMsg);
            String sExpectedErrorMsg = "Send Money is not allowed for customers at this verification level. Please upgrade your account to use this service.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(SendTransferPage.objUpgradeNowBtn, getTextVal(SendTransferPage.objUpgradeNowBtn, "Button"));
            logger.info("STW_TC_22, Send Money is not allowed for customers at this Buyer tier - Error Message is validated");
            ExtentReporter.extentLoggerPass("STW_TC_22", "STW_TC_22, Send Money is not allowed for customers at this Buyer tier  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletSemiVerifiedAccountUser_STW_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet Semi-Verified Account User Transaction");
        sendMoneyMLWallet(prop.getproperty("Semi_Verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
            logger.info("STW_TC_23, Send Money ML Wallet Semi-Verified Account User Transaction validated");
            ExtentReporter.extentLoggerPass("STW_TC_23", "STW_TC_23, Send Money ML Wallet Semi-Verified Account User Transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletBranchVerifiedAccountUser_STW_TC_24() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet Branch-Verified Account User Transaction");
        sendMoneyMLWallet(prop.getproperty("Branch_Verified"));
        enterMobileNumberMLWallet(prop.getproperty("Fully_verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
            logger.info("STW_TC_24, Send Money ML Wallet Branch-Verified Account User Transaction validated");
            ExtentReporter.extentLoggerPass("STW_TC_24", "STW_TC_24, Send Money ML Wallet Branch-Verified Account User Transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyMLWalletFullyVerifiedAccountUser_STW_TC_25() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money ML Wallet Fully-Verified Account User Transaction");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
            logger.info("STW_TC_25, Send Money ML Wallet Fully-Verified Account User Transaction validated");
            ExtentReporter.extentLoggerPass("STW_TC_25", "STW_TC_25, Send Money ML Wallet Fully-Verified Account User Transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyMLWalletSemiVerifiedAccountMaxLimit_STW_TC_26() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Semi-Verified Account Maximum Limit Validation");
        sendMoneyMLWallet(prop.getproperty("Semi_Verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("60000");
        if (verifyElementPresent(SendTransferPage.objErrorMsg, getTextVal(SendTransferPage.objErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(SendTransferPage.objErrorMsg);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(SendTransferPage.objUpgradeNowBtn, getTextVal(SendTransferPage.objUpgradeNowBtn, "Button"));
            logger.info("STB_TC_26, Send Money To ML Wallet Semi-Verified Account Maximum Limit - Error Message is validated");
            ExtentReporter.extentLoggerPass("STB_TC_26", "STB_TC_26, Send Money To ML Wallet Semi-Verified Account Maximum Limit  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyMLWalletBranchVerifiedAccountMaxLimit_STW_TC_29() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Branch-Verified Account Maximum Limit Validation");
        sendMoneyMLWallet(prop.getproperty("Branch_Verified"));
        enterMobileNumberMLWallet(prop.getproperty("Fully_verified"));
        enterAmountAndSendToMLWallet("60000");
        if (verifyElementPresent(SendTransferPage.objMaxLimitErrorMsg, getTextVal(SendTransferPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(SendTransferPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(SendTransferPage.objOkBtn, getTextVal(SendTransferPage.objOkBtn, "Button"));
            logger.info("STW_TC_29, Send Money To ML Wallet Branch-Verified Account Maximum Limit - Error Message is validated");
            ExtentReporter.extentLoggerPass("STW_TC_29", "STW_TC_29, Send Money To ML Wallet Branch-Verified Account Maximum Limit  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyMLWalletFullyVerifiedAccountMaxLimit_STW_TC_32() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Fully-Verified Account Maximum Limit Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("60000");
        if (verifyElementPresent(SendTransferPage.objMaxLimitErrorMsg, getTextVal(SendTransferPage.objMaxLimitErrorMsg, "Error Message"))) {
            String sMaximumLimitErrorMsg = getText(SendTransferPage.objMaxLimitErrorMsg);
            String sExpectedErrorMsg = "The maximum Send Money per transaction set for your verification level is P50,000.00. Please try again.";
            assertionValidation(sMaximumLimitErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(SendTransferPage.objOkBtn, getTextVal(SendTransferPage.objOkBtn, "Button"));
            logger.info("STW_TC_32, Send Money To ML Wallet Fully-Verified Account Maximum Limit - Error Message is validated");
            ExtentReporter.extentLoggerPass("STW_TC_32", "STW_TC_32, Send Money To ML Wallet Fully-Verified Account Maximum Limit  - Error Message is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLWalletSuccessMsgValidation_STW_TC_35() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Success Message Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Page"));
        verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
        Swipe("UP", 2);
        click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
        Thread.sleep(3000);
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
        if (verifyElementPresent(SendTransferPage.objWalletToWalletStatus, getTextVal(SendTransferPage.objWalletToWalletStatus, "Status"))) {
            String sSuccessStatus = getText(SendTransferPage.objWalletToWalletStatus);
            String sExpectedStatus = "Success";
            assertionValidation(sSuccessStatus, sExpectedStatus);
            logger.info("STW_TC_35, Send Money To ML Wallet Success Message validated");
            ExtentReporter.extentLoggerPass("STW_TC_35", "STW_TC_35, Send Money To ML Wallet Success Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletMaxTransactionReceivingLimitSemiVerifiedTier_STW_TC_36(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Maximum Transaction Receiving Limit for Semi-Verified Tier User");
        sendMoneyMLWallet(prop.getproperty("SemiVerified_MaxTransactionSender"));
        enterMobileNumberMLWallet(prop.getproperty("SemiVerified_MaxTransactionReceiver"));

        enterAmountAndSendToMLWallet(sAmount);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Page"));
        verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
        String sReferenceNumberSender = getText(SendTransferPage.objMLWalletReferenceNumber);
        Swipe("UP", 2);
        click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
        Thread.sleep(3000);
        mlWalletLogout();
        verifyElementPresentAndClick(MLWalletLogOutPage.objChangeNumber, "Changer Number");
        mlWalletLogin(prop.getproperty("SemiVerified_MaxTransactionReceiver"));
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objReceiveMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objReceiveMoneyTab, "Tab"));
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            String sReferenceNumberReceiver = getText(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails);
            assertionValidation(sReferenceNumberSender, sReferenceNumberReceiver);
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objSenderName, getTextVal(MLWalletTransactionHistoryPage.objSenderName, "Sender Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmountReceived, getTextVal(MLWalletTransactionHistoryPage.objAmountReceived, "Total Amount"));
            String sReceivedAmount = getText(MLWalletTransactionHistoryPage.objAmountReceived);
            String sActualReceivedAmount = sReceivedAmount.substring(4);
            assertionValidation(sActualReceivedAmount, "50,000.00");
            logger.info("STW_TC_36, Send Money To ML Wallet Maximum Transaction Receiving Limit for Semi-Verified Tier User Validated");
            ExtentReporter.extentLoggerPass("STW_TC_36", "STW_TC_36, Send Money To ML Wallet Maximum Transaction Receiving Limit for Semi-Verified Tier User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletMaxTransactionReceivingLimitBranchVerifiedTier_STW_TC_38(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Maximum Transaction Receiving Limit for Branch-Verified Tier User");
        sendMoneyMLWallet(prop.getproperty("BranchVerified_MaxTransactionSender"));
        enterMobileNumberMLWallet(prop.getproperty("BranchVerified_MaxTransactionReceiver"));

        enterAmountAndSendToMLWallet(sAmount);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Page"));
        verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
        String sReferenceNumberSender = getText(SendTransferPage.objMLWalletReferenceNumber);
        Swipe("UP", 2);
        click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
        Thread.sleep(3000);
        mlWalletLogout();
        verifyElementPresentAndClick(MLWalletLogOutPage.objChangeNumber, "Changer Number");
        mlWalletLogin(prop.getproperty("BranchVerified_MaxTransactionReceiver"));
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objReceiveMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objReceiveMoneyTab, "Tab"));
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            String sReferenceNumberReceiver = getText(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails);
            assertionValidation(sReferenceNumberSender, sReferenceNumberReceiver);
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objSenderName, getTextVal(MLWalletTransactionHistoryPage.objSenderName, "Sender Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmountReceived, getTextVal(MLWalletTransactionHistoryPage.objAmountReceived, "Total Amount"));
            String sReceivedAmount = getText(MLWalletTransactionHistoryPage.objAmountReceived);
            String sActualReceivedAmount = sReceivedAmount.substring(4);
            assertionValidation(sActualReceivedAmount, "50,000.00");
            logger.info("STW_TC_38, Send Money To ML Wallet Maximum Transaction Receiving Limit for Branch-Verified Tier User Validated");
            ExtentReporter.extentLoggerPass("STW_TC_38", "STW_TC_38, Send Money To ML Wallet Maximum Transaction Receiving Limit for Branch-Verified Tier User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletMaxTransactionReceivingLimitFullyVerifiedTier_STW_TC_40(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Maximum Transaction Receiving Limit for Fully-Verified Tier User");
        sendMoneyMLWallet(prop.getproperty("FullyVerified_MaxTransactionSender"));
        enterMobileNumberMLWallet(prop.getproperty("FullyVerified_MaxTransactionReceiver"));

        enterAmountAndSendToMLWallet(sAmount);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(SendTransferPage.objTransactionDetails, getTextVal(SendTransferPage.objTransactionDetails, "Page"));
        verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Transaction Number"));
        String sReferenceNumberSender = getText(SendTransferPage.objMLWalletReferenceNumber);
        Swipe("UP", 2);
        click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
        Thread.sleep(3000);
        mlWalletLogout();
        verifyElementPresentAndClick(MLWalletLogOutPage.objChangeNumber, "Changer Number");
        mlWalletLogin(prop.getproperty("FullyVerified_MaxTransactionReceiver"));
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objReceiveMoneyTab, getTextVal(MLWalletTransactionHistoryPage.objReceiveMoneyTab, "Tab"));
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            String sReferenceNumberReceiver = getText(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails);
            assertionValidation(sReferenceNumberSender, sReferenceNumberReceiver);
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverName, getTextVal(MLWalletTransactionHistoryPage.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objSenderName, getTextVal(MLWalletTransactionHistoryPage.objSenderName, "Sender Name"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmountReceived, getTextVal(MLWalletTransactionHistoryPage.objAmountReceived, "Total Amount"));
            String sReceivedAmount = getText(MLWalletTransactionHistoryPage.objAmountReceived);
            String sActualReceivedAmount = sReceivedAmount.substring(4);
            assertionValidation(sActualReceivedAmount, "50,000.00");
            logger.info("STW_TC_40, Send Money To ML Wallet Maximum Transaction Receiving Limit for Fully-Verified Tier User Validated");
            ExtentReporter.extentLoggerPass("STW_TC_40", "STW_TC_40, Send Money To ML Wallet Maximum Transaction Receiving Limit for Fully-Verified Tier User Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletLocationPopupValidation_STW_TC_42() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Location popup Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpValidation();
            logger.info("STW_TC_42, Send Money To ML Wallet Location popup Validated");
            ExtentReporter.extentLoggerPass("STW_TC_42", "STW_TC_42, Send Money To ML Wallet Location popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletLocationDenyFunctionality_STW_TC_43() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Location Deny Functionality Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyPopUp();
            logger.info("STW_TC_43, Send Money To ML Wallet Location Deny Functionality Validated");
            ExtentReporter.extentLoggerPass("STW_TC_43", "STW_TC_43, Send Money To ML Wallet Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletLocationPermissionDenyCloseBtnFunctionality_STW_TC_44() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Location Permission Deny Close Button Functionality Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyCloseBtnFunctionality();
            if (verifyElementPresent(SendTransferPage.objMLWalletBalance, getTextVal(SendTransferPage.objMLWalletBalance, "Page"))) {
                logger.info("STW_TC_44, Send Money To ML Wallet Location Permission Deny Close Button Functionality Validated");
                ExtentReporter.extentLoggerPass("STW_TC_44", "STW_TC_44, Send Money To ML Wallet Location Permission Deny Close Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyToMLWalletLocationPermissionDenyOpenSettingsBtnFunctionality_STW_TC_45() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Location Permission Deny open Settings Button Functionality Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyOpenSettingsBtnFunctionality();
            if (verifyElementPresent(SendTransferPage.objAppInfo, getTextVal(SendTransferPage.objAppInfo, "Page"))) {
                logger.info("STW_TC_45, Send Money To ML Wallet Location Permission Deny Open Settings Button Functionality Validated");
                ExtentReporter.extentLoggerPass("STW_TC_45", "STW_TC_45, Send Money To ML Wallet Location Permission Deny Open Settings Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void sendMoneyToMLWalletLocationPopUpAllowFunctionality_STW_TC_46() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Location popup Allow Button Functionality Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpAllowFunctionality();
            if (verifyElementDisplayed(MLWalletLoginPage.objOneTimePin)) {
                verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
            } else if (verifyElementDisplayed(MLWalletLoginPage.objMLPin)) {
                verifyElementPresent(MLWalletLoginPage.objMLPin, getTextVal(MLWalletLoginPage.objMLPin, "Page"));
            }
            logger.info("STW_TC_46, Send Money To ML Wallet Location popup Allow Button Functionality Validated");
            ExtentReporter.extentLoggerPass("STW_TC_46", "STW_TC_46, Send Money To ML Wallet Location popup Allow Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletInternetInterruptionWhileEnteringOTP_STW_TC_47() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Internet Interruption While Entering OTP Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(15000);
        setWifiConnectionToONOFF("OFF");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"))) {
            internetConnectionError();
            logger.info("STW_TC_47, Send Money To ML Wallet Internet Interruption While Entering OTP Validated");
            ExtentReporter.extentLoggerPass("STW_TC_47", "STW_TC_47, Send Money To ML Wallet Internet Interruption While Entering OTP Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletTransactionValidationAfterMinimizingApp_STW_TC_50() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Transaction Validation After Minimizing App");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        if (verifyElementPresent(SendTransferPage.objSendMoneyMLWallet, getTextVal(SendTransferPage.objSendMoneyMLWallet, "Message"))) {
            logger.info("STW_TC_50, Send Money To ML Wallet Transaction Validation After Minimizing App Validated");
            ExtentReporter.extentLoggerPass("STW_TC_50", "STW_TC_50, Send Money To ML Wallet Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletTransactionWithValidMLPin_STW_TC_56() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Wallet Transaction With Valid ML Pin");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        handleMpin("1111");
        if (verifyElementPresent(SendTransferPage.objSendMoneyMLWallet, getTextVal(SendTransferPage.objSendMoneyMLWallet, "Message"))) {
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletPHP, getTextVal(SendTransferPage.objSendMoneyMLWalletPHP, "Amount"));
            verifyElementPresent(SendTransferPage.objSendMoneyMLWalletDate, getTextVal(SendTransferPage.objSendMoneyMLWalletDate, "Date"));
            verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
            String sReferenceNumber = getText(SendTransferPage.objMLWalletReferenceNumber);
            System.out.println(sReferenceNumber);
            Swipe("UP", 2);
            click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
            Thread.sleep(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            click(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            if (verifyElementPresent(SendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(SendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInWalletToWallet = getText(SendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInWalletToWallet);
                assertionValidation(sReferenceNumberInWalletToWallet, sReferenceNumber);
                logger.info("STW_TC_56, Send Money to any ML Wallet Transaction With Valid ML Pin validated");
                ExtentReporter.extentLoggerPass("STW_TC_56", "STW_TC_56, Send Money to any ML Wallet Transaction With Valid ML Pin validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void sendMoneyToMLWalletTransactionWithInValidMLPin_STW_TC_57() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money to any ML Wallet Transaction With Invalid ML Pin");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        handleMpin("1234");
        if (verifyElementPresent(SendTransferPage.objInvalidPINMsg, getTextVal(SendTransferPage.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(SendTransferPage.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("STW_TC_57, Send Money to any ML Wallet Transaction With Invalid ML Pin validated");
            ExtentReporter.extentLoggerPass("STW_TC_57", "STW_TC_57, Send Money to any ML Wallet Transaction With Invalid ML Pin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletInOTPPopupValidation_STW_TC_63() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet InApp OTP popup Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            logger.info("STW_TC_63, Send Money To ML Wallet, InApp OTP popup validated");
            ExtentReporter.extentLoggerPass("STW_TC_63", "STW_TC_63, Send Money To ML Wallet, InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_STW_TC_64() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Transaction InApp OTP popup UI Validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds, getTextVal(MLWalletLoginPage.objSeconds, "Seconds"));
            verifyElementPresent(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
            logger.info("STW_TC_64, Send Money To ML Wallet Transaction InApp OTP popup UI validated");
            ExtentReporter.extentLoggerPass("STW_TC_64", "STW_TC_64, Send Money To ML Wallet Transaction InApp OTP popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_STW_TC_65() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet New OTP got generated After Sixty Seconds validation");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if (verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"))) {
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP, sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("STW_TC_65, Send Money To ML Wallet Transaction New OTP got generated After Sixty Seconds is validated");
            ExtentReporter.extentLoggerPass("STW_TC_65", "STW_TC_65, Send Money To ML Wallet Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void sendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_STW_TC_66() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Transaction OTP Cancel Button Functionality");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objConfirmDetails, getTextVal(SendTransferPage.objConfirmDetails, "Page"))) {
            logger.info("STW_TC_66, Send Money To ML Wallet Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            ExtentReporter.extentLoggerPass("STW_TC_66", "STW_TC_66, Send Money To ML Wallet Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void sendMoneyToMLWalletOTPContinueBtnFunctionality_STW_TC_67() throws Exception {
        ExtentReporter.HeaderChildNode("Send Money To ML Wallet Transaction OTP Continue Button Functionality");
        sendMoneyMLWallet(prop.getproperty("Fully_verified"));
        enterMobileNumberMLWallet(prop.getproperty("Branch_Verified"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objSendMoneyMLWallet, getTextVal(SendTransferPage.objSendMoneyMLWallet, "Message"))) {
            logger.info("STW_TC_67, Send Money To ML Wallet Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            ExtentReporter.extentLoggerPass("STW_TC_67", "STW_TC_67, Send Money To ML Wallet Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
