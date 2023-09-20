package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.mlwallet.pages.*;
import com.utility.ExtentReporter;

import java.time.Duration;

import static com.utility.Utilities.*;

public class UseQrClass extends BaseClass{
    public UseQrClass(String Application, String deviceName, String portno) throws InterruptedException {
        super(Application, deviceName, portno);
    }
    public void useQRGenerateQRCode_QR_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Generate QR Code");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objGenerateQRCodeToReceiveMoney, getTextVal(MLWalletUseQR.objGenerateQRCodeToReceiveMoney, "Option"));
        if (verifyElementPresent(MLWalletUseQR.objGenerateQR, getTextVal(MLWalletUseQR.objGenerateQR, "Page"))) {
            verifyElementPresent(MLWalletUseQR.objQR, "Generated QR");
            verifyElementPresent(MLWalletUseQR.objReceiverName, getTextVal(MLWalletUseQR.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletUseQR.objReceiverMobileNumber, getTextVal(MLWalletUseQR.objReceiverMobileNumber, "Receiver Mobile Number"));
            logger.info("QR_TC_01, Use QR, Generate QR Code Validated");
            ExtentReporter.extentLoggerPass("QR_TC_01", "QR_TC_01, Use QR, Generate QR Code Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQRSendMoneyToAnyMLWalletUser_QR_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To Any ML Wallet User");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
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
                logger.info("QR_TC_02, Successfully Amount sent from Wallet to Wallet using QR code and Transaction Details is validated");
                ExtentReporter.extentLoggerPass("QR_TC_02", "QR_TC_02, Successfully Amount sent from Wallet to Wallet using QR code and Transaction Details is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void useQRInvalidQRCodeValidation_QR_TC_03() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Invalid QR Code Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Invalid_QR"));
        if (verifyElementPresent(MLWalletUseQR.objInvalidQRCodeMsg, getTextVal(MLWalletUseQR.objInvalidQRCodeMsg, "Error Msg"))) {
            String sActualErrorMsg = getText(MLWalletUseQR.objInvalidQRCodeMsg);
            String sExpectedErrorMsg = "Invalid QR code";
            assertionValidation(sActualErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(MLWalletUseQR.objOKBtn, getTextVal(MLWalletUseQR.objOKBtn, "Button"));
            logger.info("QR_TC_03, Use QR, Invalid QR Code validated");
            ExtentReporter.extentLoggerPass("QR_TC_03", "QR_TC_03, Use QR, Invalid QR Code validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_WalletToWalletReceivedMoneyValidation_QR_TC_04(String Amount) throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Wallet to Wallet Receive Money Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet(Amount);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(SendTransferPage.objMLWalletReferenceNumber, getTextVal(SendTransferPage.objMLWalletReferenceNumber, "Reference Number"));
        String sReferenceNumberInSender = getText(SendTransferPage.objMLWalletReferenceNumber);
        String sAmountToSend = getText(SendTransferPage.objAmount);
        swipeDownUntilElementVisible("Back To Home");
        click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
        Thread.sleep(3000);
        mlWalletLogout();
        click(MLWalletLogOutPage.objChangeNumber, getTextVal(MLWalletLogOutPage.objChangeNumber, "Link"));
        mlWalletLogin(prop.getproperty("Fully_verified"));
        verifyElementPresent(MLWalletTransactionHistoryPage.objRecentTransaction, getTextVal(MLWalletTransactionHistoryPage.objRecentTransaction, "Header"));
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        verifyElementPresent(MLWalletTransactionHistoryPage.objWalletToWallet, getTextVal(MLWalletTransactionHistoryPage.objWalletToWallet, "Transaction"));

        verifyElementPresent(MLWalletUseQR.objSuccess, getTextVal(MLWalletUseQR.objSuccess, "Status"));
        click(MLWalletTransactionHistoryPage.objWalletToWallet, getTextVal(MLWalletTransactionHistoryPage.objWalletToWallet, "Transaction"));
        String sReferenceNumberInReceiver = getText(SendTransferPage.objReferenceNumberInTransactionDetails);
        assertionValidation(sReferenceNumberInReceiver, sReferenceNumberInSender);
        logger.info("QR_TC_04, Use QR, Wallet to Wallet Receive Money validated");
        ExtentReporter.extentLoggerPass("QR_TC_04", "QR_TC_04, Use QR, Wallet to Wallet Receive Money validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void useQRScanningReceiverQRCOde_QR_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Scanning Receiver QR Code");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        if (verifyElementPresent(SendTransferPage.objToMLWalletUser, getTextVal(SendTransferPage.objToMLWalletUser, "Page"))) {
            logger.info("QR_TC_05, Use QR, Scanning Receiver QR Code validated");
            ExtentReporter.extentLoggerPass("QR_TC_05", "QR_TC_05, Use QR, Scanning Receiver QR Code validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQRPageUIValidation_QR_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR Page UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        if (verifyElementPresent(MLWalletUseQR.objUseQR, getTextVal(MLWalletUseQR.objUseQR, "Page"))) {
            verifyElementPresent(MLWalletUseQR.objUseQROptions, getTextVal(MLWalletUseQR.objUseQROptions, "Header"));
            verifyElementPresent(MLWalletUseQR.objGenerateQRCodeToReceiveMoney, getTextVal(MLWalletUseQR.objGenerateQRCodeToReceiveMoney, "Option"));
            verifyElementPresent(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
            verifyElementPresent(MLWalletUseQR.objReadQRCodeToSignInToWeb, getTextVal(MLWalletUseQR.objReadQRCodeToSignInToWeb, "Option"));
            logger.info("QR_TC_06, Use QR Page UI validated");
            ExtentReporter.extentLoggerPass("QR_TC_06", "QR_TC_06, Use QR Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQRPageBackBtnValidation_QR_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR Page Back Btn Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objUseQRBackBtn, "Use QR page Back Arrow Button");
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Header"))) {
            logger.info("QR_TC_07, Use QR, After clicking On  Use QR Page Back Btn, App navigates to Home page is validated");
            ExtentReporter.extentLoggerPass("QR_TC_07", "QR_TC_07, Use QR, After clicking On  Use QR Page Back Btn, App navigates to Home page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_GenerateQRPageBackBtnValidation_QR_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Generate QR page Back Arrow Btn Validation");
        useQRGenerateQRCode_QR_TC_01();
        verifyElementPresentAndClick(MLWalletUseQR.objGenerateQRBackBtn, "Generate QR Page Back Arrow button");
        if (verifyElementPresent(MLWalletUseQR.objUseQR, getTextVal(MLWalletUseQR.objUseQR, "Page"))) {
            logger.info("QR_TC_08, Use QR, After clicking On  Generate QR Page Back Btn, App navigates to Use QR page is validated");
            ExtentReporter.extentLoggerPass("QR_TC_08", "QR_TC_08, Use QR, After clicking On  Generate QR Page Back Btn, App navigates to Use QR page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_GenerateQRPageUIValidation_QR_TC_11() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Generate QR Page UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objGenerateQRCodeToReceiveMoney, getTextVal(MLWalletUseQR.objGenerateQRCodeToReceiveMoney, "Option"));
        if (verifyElementPresent(MLWalletUseQR.objGenerateQR, getTextVal(MLWalletUseQR.objGenerateQR, "Page"))) {
            verifyElementPresent(MLWalletUseQR.objQR, "Generated QR");
            verifyElementPresent(MLWalletUseQR.objReceiverName, getTextVal(MLWalletUseQR.objReceiverName, "Receiver Name"));
            verifyElementPresent(MLWalletUseQR.objReceiverMobileNumber, getTextVal(MLWalletUseQR.objReceiverMobileNumber, "Receiver Mobile Number"));
            verifyElementPresent(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
            logger.info("QR_TC_11, Use QR, Generate QR Page UI Validated");
            ExtentReporter.extentLoggerPass("QR_TC_11", "QR_TC_11, Use QR, Generate QR Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_ToMLWalletScreenUIValidation_QR_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, To ML Wallet Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        if (verifyElementPresent(SendTransferPage.objToMLWalletUser, getTextVal(SendTransferPage.objToMLWalletUser, "Page"))) {
            verifyElementPresent(MLWalletUseQR.objReceiverNameInEnterAmount, getTextVal(MLWalletUseQR.objReceiverNameInEnterAmount, "Receiver Name"));
            verifyElementPresent(MLWalletUseQR.objReceiverMobileNumberInEnterAmount, getTextVal(MLWalletUseQR.objReceiverMobileNumberInEnterAmount, "Receiver Mobile Number"));
            verifyElementPresent(MLWalletUseQR.objAmountInputField, "Amount Entering Field");
            verifyElementPresent(MLWalletUseQR.objNextBtn, getTextVal(MLWalletUseQR.objNextBtn, "Button"));
            logger.info("QR_TC_12, Use QR, To ML Wallet Screen UI Validated");
            ExtentReporter.extentLoggerPass("QR_TC_12", "QR_TC_12, Use QR, To ML Wallet Screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_EmptyAmountFieldValidation_QR_TC_13() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Empty Amount Input Field Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        verifyElementPresent(SendTransferPage.objToMLWalletUser, getTextVal(SendTransferPage.objToMLWalletUser, "Page"));
        click(MLWalletUseQR.objNextBtn, getTextVal(MLWalletUseQR.objNextBtn, "Button"));
        if (verifyElementPresent(MLWalletUseQR.objAmountRequiredErrorMsg, getTextVal(MLWalletUseQR.objAmountRequiredErrorMsg, "Error Message"))) {
            String sAmountRequiredErrorMsg = getText(MLWalletUseQR.objAmountRequiredErrorMsg);
            String sExceptedErrorMsg = "Amount is required";
            assertionValidation(sAmountRequiredErrorMsg, sExceptedErrorMsg);
            logger.info("QR_TC_13, Amount is required - Error message is Validated");
            ExtentReporter.extentLoggerPass("QR_TC_13", "QR_TC_13, Amount is required - Error message is Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_ConfirmDetailsScreenUIValidation_QR_TC_14(String sAmount) throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Confirm Details Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        waitTime(3000);
        type(MLWalletUseQR.objAmountInputField, sAmount, "Amount Input Field");
        click(MLWalletUseQR.objNextBtn, getTextVal(MLWalletUseQR.objNextBtn, "Button"));
        click(MLWalletUseQR.objMLWalletBalance, getTextVal(MLWalletUseQR.objMLWalletBalance, "Button"));
        if (verifyElementPresent(MLWalletUseQR.objConfirmDetails, getTextVal(MLWalletUseQR.objConfirmDetails, "Page"))) {
            verifyElementPresent(MLWalletUseQR.objReceiverNameInConfirmDetails, getTextVal(MLWalletUseQR.objReceiverNameInConfirmDetails, "Receiver Name"));
            verifyElementPresent(MLWalletUseQR.objReceiverMobileNo, getTextVal(MLWalletUseQR.objReceiverMobileNo, "Receiver's Mobile Number"));
            verifyElementPresent(MLWalletUseQR.objPaymentMethod, getTextVal(MLWalletUseQR.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletUseQR.objAmount, getTextVal(MLWalletUseQR.objAmount, "Amount"));
            verifyElementPresent(MLWalletUseQR.objServiceFee, getTextVal(MLWalletUseQR.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletUseQR.objTotalAmount, getTextVal(MLWalletUseQR.objTotalAmount, "Total Amount"));
            verifyElementPresent(MLWalletUseQR.objCancelTransaction, getTextVal(MLWalletUseQR.objCancelTransaction, "Button"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletUseQR.objSendPHPBtn, getTextVal(MLWalletUseQR.objSendPHPBtn, "Button"));
            logger.info("QR_TC_14, Use QR, Confirm Details Screen UI Validated");
            ExtentReporter.extentLoggerPass("QR_TC_14", "QR_TC_14, Use QR, Confirm Details Screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_OneTimePinScreenUIValidation_QR_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, one Time Pin Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
//			verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
//			verifyElementPresent(MLWalletCashOutPage.objResendCode, getTextVal(MLWalletCashOutPage.objResendCode, "Seconds"));
            logger.info("QR_TC_15,Use QR, One Time Pin screen UI Validated");
            ExtentReporter.extentLoggerPass("QR_TC_15", "QR_TC_15,Use QR, One Time Pin screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_SendMoneyToMlWalletSuccessScreenUIValidation_QR_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet Success Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
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
            logger.info("QR_TC_16,Use QR, Send Money To ML Wallet Success Screen UI Validated");
            ExtentReporter.extentLoggerPass("QR_TC_16", "QR_TC_16, Use QR, Send Money To ML Wallet Success Screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_RecentTransactionInHomeScreenUIValidation_QR_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Recent Transaction In Home Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        swipeDownUntilElementVisible("Back To Home");
        click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
        Thread.sleep(3000);
        Swipe("DOWN", 2);
        if (verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"))) {
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            verifyElementPresent(MLWalletUseQR.objSuccess, getTextVal(MLWalletUseQR.objSuccess, "Status"));
            logger.info("QR_TC_17, Use QR, Recent Transaction In Home Screen UI Validated");
            ExtentReporter.extentLoggerPass("QR_TC_17", "QR_TC_17, Use QR, Recent Transaction In Home Screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_TransactionDetailsScreenUIValidation_QR_TC_18() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Transaction Details Screen UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        swipeDownUntilElementVisible("Back To Home");
        click(SendTransferPage.objBackToHomeBtn, getTextVal(SendTransferPage.objBackToHomeBtn, "Button"));
        Thread.sleep(3000);
        Swipe("DOWN", 2);
        Swipe("UP", 1);
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
        verifyElementPresentAndClick(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
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
            logger.info("QR_TC_18, Use QR, Transaction Details Screen UI Validated");
            ExtentReporter.extentLoggerPass("QR_TC_18", "QR_TC_18, Use QR, Transaction Details Screen UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_CameraPermissionPopupValidation_QR_TC_19() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Camera Permission Popup Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        if (verifyElementPresent(MLWalletUseQR.objCameraPopup, getTextVal(MLWalletUseQR.objCameraPopup, "Popup"))) {
            verifyElementPresent(MLWalletUseQR.objWhileUsingApp, getTextVal(MLWalletUseQR.objWhileUsingApp, "Button"));
            verifyElementPresent(MLWalletUseQR.objOnlyThisTime, getTextVal(MLWalletUseQR.objOnlyThisTime, "Button"));
            verifyElementPresent(MLWalletUseQR.objDenyButton, getTextVal(MLWalletUseQR.objDenyButton, "Button"));
            logger.info("QR_TC_19, Use QR, Camera Permission Popup Validated");
            ExtentReporter.extentLoggerPass("QR_TC_19", "QR_TC_19, Use QR, Camera Permission Popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_CameraPermissionPopupDenyButtonFunctionality_QR_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Camera Permission Popup Deny Button Functionality");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        verifyElementPresent(MLWalletUseQR.objCameraPopup, getTextVal(MLWalletUseQR.objCameraPopup, "Popup"));
        verifyElementPresentAndClick(MLWalletUseQR.objDenyButton, getTextVal(MLWalletUseQR.objDenyButton, "Button"));
        if (verifyElementPresent(MLWalletUseQR.objCameraNotAuthorized, getTextVal(MLWalletUseQR.objCameraNotAuthorized, "Message"))) {
            String sActualMsg = getText(MLWalletUseQR.objCameraNotAuthorized);
            String sExceptedMsg = "Camera not authorized";
            assertionValidation(sActualMsg, sExceptedMsg);
            logger.info("QR_TC_20, Use QR, Camera Permission Popup Deny Button Functionality Validated");
            ExtentReporter.extentLoggerPass("QR_TC_20", "QR_TC_20, Use QR, Camera Permission Popup Deny Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_CameraPermissionPopupOnlyThisTimeButtonFunctionality_QR_TC_21() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Camera Permission Popup Only This Time Button Functionality");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        verifyElementPresent(MLWalletUseQR.objCameraPopup, getTextVal(MLWalletUseQR.objCameraPopup, "Popup"));
        verifyElementPresentAndClick(MLWalletUseQR.objOnlyThisTime, getTextVal(MLWalletUseQR.objOnlyThisTime, "Button"));
        if (verifyElementPresent(MLWalletUseQR.objScanQR, getTextVal(MLWalletUseQR.objScanQR, "Page"))) {
            verifyElementPresent(MLWalletUseQR.objScanQRSuggestion, getTextVal(MLWalletUseQR.objScanQRSuggestion, "Message"));
            String sActualMsg = getText(MLWalletUseQR.objScanQRSuggestion);
            String sExpectedMsg = "Make sure that the QR code is within the frame";
            assertionValidation(sActualMsg, sExpectedMsg);
            logger.info("QR_TC_21, Use QR, Camera Permission Popup Only This Time Button Functionality Validated");
            ExtentReporter.extentLoggerPass("QR_TC_21", "QR_TC_21, Use QR, Camera Permission Popup Only This Time Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_CameraPermissionPopupWhileUsingTheAppButtonFunctionality_QR_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Camera Permission Popup While Using The App Button Functionality");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        verifyElementPresent(MLWalletUseQR.objCameraPopup, getTextVal(MLWalletUseQR.objCameraPopup, "Popup"));
        verifyElementPresentAndClick(MLWalletUseQR.objWhileUsingApp, getTextVal(MLWalletUseQR.objWhileUsingApp, "Button"));
        if (verifyElementPresent(MLWalletUseQR.objScanQR, getTextVal(MLWalletUseQR.objScanQR, "Page"))) {
            verifyElementPresent(MLWalletUseQR.objScanQRSuggestion, getTextVal(MLWalletUseQR.objScanQRSuggestion, "Message"));
            String sActualMsg = getText(MLWalletUseQR.objScanQRSuggestion);
            String sExpectedMsg = "Make sure that the QR code is within the frame";
            assertionValidation(sActualMsg, sExpectedMsg);
            logger.info("QR_TC_22, Use QR, Camera Permission Popup While Using The App Button Functionality Validated");
            ExtentReporter.extentLoggerPass("QR_TC_22", "QR_TC_22, Use QR, Camera Permission Popup While Using The App Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_SendMoneyToMLWalletInternetInterruptionWhileEnteringOTP_QR_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet Internet Interruption While Entering OTP Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(15000);
        setWifiConnectionToONOFF("OFF");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"))) {
            internetConnectionError();
            logger.info("QR_TC_23, Use QR, Send Money To ML Wallet Internet Interruption While Entering OTP Validated");
            ExtentReporter.extentLoggerPass("QR_TC_23", "QR_TC_23, Use QR, Send Money To ML Wallet Internet Interruption While Entering OTP Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_ScanQRCodeAfterClickingOnDenyButton_QR_TC_24() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Scan QR Code After Clicking On Deny Button");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        verifyElementPresent(MLWalletUseQR.objCameraPopup, getTextVal(MLWalletUseQR.objCameraPopup, "Popup"));
        verifyElementPresentAndClick(MLWalletUseQR.objDenyButton, getTextVal(MLWalletUseQR.objDenyButton, "Button"));
        verifyElementPresentAndClick(MLWalletUseQR.objScanQRBackBtn, "Scan QR Page Back Arrow Button");
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        if (verifyElementPresent(MLWalletUseQR.objCameraPermissionRequiredPopup, getTextVal(MLWalletUseQR.objCameraPermissionRequiredPopup, "Popup"))) {
            verifyElementPresent(MLWalletUseQR.objCameraPermissionRequiredMsg, getTextVal(MLWalletUseQR.objCameraPermissionRequiredMsg, "Message"));
            verifyElementPresent(MLWalletUseQR.objOKBtn, getTextVal(MLWalletUseQR.objOKBtn, "Button"));
            logger.info("QR_TC_24, Use QR, Scan QR Code After Clicking On Deny Button Validated");
            ExtentReporter.extentLoggerPass("QR_TC_24", "QR_TC_24, Use QR, Scan QR Code After Clicking On Deny Button Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void UseQR_SendMoneyToMLWalletLocationPopupValidation_QR_TC_026() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet Location popup Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpValidation();
            logger.info("QR_TC_026, Use QR, Send Money To ML Wallet Location popup Validated");
            ExtentReporter.extentLoggerPass("QR_TC_026", "QR_TC_026, Use QR, Send Money To ML Wallet Location popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_SendMoneyToMLWalletLocationDenyFunctionality_QR_TC_027() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet Location Deny Functionality Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyPopUp();
            logger.info("QR_TC_027, Use QR, Send Money To ML Wallet Location Deny Functionality Validated");
            ExtentReporter.extentLoggerPass("QR_TC_027", "QR_TC_027, Use QR, Send Money To ML Wallet Location Deny Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_SendMoneyToMLWalletLocationPermissionDenyCloseBtnFunctionality_QR_TC_028() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet Location Permission Deny Close Button Functionality Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyCloseBtnFunctionality();
            if (verifyElementPresent(SendTransferPage.objMLWalletBalance, getTextVal(SendTransferPage.objMLWalletBalance, "Page"))) {
                logger.info("QR_TC_028, Use QR, Send Money To ML Wallet Location Permission Deny Close Button Functionality Validated");
                ExtentReporter.extentLoggerPass("QR_TC_028", "QR_TC_028, Use QR, Send Money To ML Wallet Location Permission Deny Close Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void useQR_SendMoneyToMLWalletLocationPermissionDenyOpenSettingsBtnFunctionality_QR_TC_029() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet Location Permission Deny open Settings Button Functionality Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            permissionDenyOpenSettingsBtnFunctionality();
            if (verifyElementPresent(SendTransferPage.objAppInfo, getTextVal(SendTransferPage.objAppInfo, "Page"))) {
                logger.info("QR_TC_029, Use QR, Send Money To ML Wallet Location Permission Deny Open Settings Button Functionality Validated");
                ExtentReporter.extentLoggerPass("QR_TC_029", "QR_TC_029, Use QR, Send Money To ML Wallet Location Permission Deny Open Settings Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void useQR_SendMoneyToMLWalletLocationPopUpAllowFunctionality_QR_TC_030() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet Location popup Allow Button Functionality Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        if (verifyElementPresent(MLWalletHomePage.objPopUpMsg, getTextVal(MLWalletHomePage.objPopUpMsg, "Popup Msg"))) {
            locationPopUpAllowFunctionality();
            if (verifyElementDisplayed(MLWalletLoginPage.objOneTimePin)) {
                verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
                logger.info("QR_TC_030, Use QR, Send Money To ML Wallet Location popup Allow Button Functionality Validated");
                ExtentReporter.extentLoggerPass("QR_TC_030", "QR_TC_030, Use QR, Send Money To ML Wallet Location popup Allow Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            } else if (verifyElementDisplayed(MLWalletUseQR.objMLPinEditField)) {
                verifyElementPresent(MLWalletUseQR.objMLPinEditField, "ML Pin Page");
                logger.info("QR_TC_030, Use QR, Send Money To ML Wallet Location popup Allow Button Functionality Validated");
                ExtentReporter.extentLoggerPass("QR_TC_030", "QR_TC_030, Use QR, Send Money To ML Wallet Location popup Allow Button Functionality Validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void useQR_CameraPermissionRequiredPopupValidation_QR_TC_31() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Camera Permission Required Popup Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        verifyElementPresent(MLWalletUseQR.objCameraPopup, getTextVal(MLWalletUseQR.objCameraPopup, "Popup"));
        verifyElementPresentAndClick(MLWalletUseQR.objDenyButton, getTextVal(MLWalletUseQR.objDenyButton, "Button"));
        verifyElementPresent(MLWalletUseQR.objCameraNotAuthorized, getTextVal(MLWalletUseQR.objCameraNotAuthorized, "Message"));
        verifyElementPresentAndClick(MLWalletUseQR.objScanQRBackBtn, "Scan QR Page Back Arrow Button");
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        verifyElementPresent(MLWalletUseQR.objCameraPermissionRequiredPopup, getTextVal(MLWalletUseQR.objCameraPermissionRequiredPopup, "Popup"));
        verifyElementPresent(MLWalletUseQR.objCameraPermissionRequiredMsg, getTextVal(MLWalletUseQR.objCameraPermissionRequiredMsg, "Message"));
        verifyElementPresentAndClick(MLWalletUseQR.objOKBtn, getTextVal(MLWalletUseQR.objOKBtn, "Button"));
        if (verifyElementPresent(MLWalletUseQR.objCameraPopup, getTextVal(MLWalletUseQR.objCameraPopup, "Popup"))) {
            verifyElementPresent(MLWalletUseQR.objWhileUsingApp, getTextVal(MLWalletUseQR.objWhileUsingApp, "Button"));
            verifyElementPresent(MLWalletUseQR.objOnlyThisTime, getTextVal(MLWalletUseQR.objOnlyThisTime, "Button"));
            verifyElementPresent(MLWalletUseQR.objDenyButton, getTextVal(MLWalletUseQR.objDenyButton, "Button"));
            logger.info("QR_TC_31, Use QR, Camera Permission Required Popup Validated");
            ExtentReporter.extentLoggerPass("QR_TC_31", "QR_TC_31, Use QR, Camera Permission Required Popup Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_TransactionValidationAfterMinimizingTheApp_QR_TC_34() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Transaction Validation After Minimizing The app");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Application relaunched after 5 Seconds");
        if (verifyElementPresent(SendTransferPage.objSendMoneyMLWallet, getTextVal(SendTransferPage.objSendMoneyMLWallet, "Message"))) {
            logger.info("QR_TC_34, Use QR, Transaction Validation After Minimizing App Validated");
            ExtentReporter.extentLoggerPass("QR_TC_34", "QR_TC_34, Use QR, Transaction Validation After Minimizing App Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void useQR_SendMoneyToMLWalletWhenReceiverQRCodeCapturedByCamera_QR_TC_40() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To Any ML Wallet When Receiver QR Code Captured By Camera");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
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
            waitTime(3000);
            Swipe("DOWN", 2);
            Swipe("UP", 1);
            verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Text"));
            verifyElementPresent(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            click(MLWalletHomePage.objWalletToWallet, getTextVal(MLWalletHomePage.objWalletToWallet, "Text"));
            if (verifyElementPresent(SendTransferPage.objReferenceNumberInTransactionDetails, getTextVal(SendTransferPage.objReferenceNumberInTransactionDetails, "Page"))) {
                String sReferenceNumberInWalletToWallet = getText(SendTransferPage.objReferenceNumberInTransactionDetails);
                System.out.println(sReferenceNumberInWalletToWallet);
                assertionValidation(sReferenceNumberInWalletToWallet, sReferenceNumber);
                logger.info("QR_TC_40, Successfully Amount sent from Wallet to Wallet using QR Code Captured By Camera and Transaction Details is validated");
                ExtentReporter.extentLoggerPass("QR_TC_40", "QR_TC_40, Successfully Amount sent from Wallet to Wallet using QR Code Captured By Camera and Transaction Details is validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }

    public void useQR_SendMoneyToMLWalletInOTPPopupValidation_QR_TC_41() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet InApp OTP popup Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            logger.info("QR_TC_41, Use QR, Send Money To ML Wallet InApp OTP popup validated");
            ExtentReporter.extentLoggerPass("QR_TC_41", "QR_TC_41, Use QR, Send Money To ML Wallet InApp OTP popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_SendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_QR_TC_42() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet Transaction InApp OTP popup UI Validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds, getTextVal(MLWalletLoginPage.objSeconds, "Seconds"));
            verifyElementPresent(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
            logger.info("QR_TC_42, Use QR, Send Money To ML Wallet Transaction InApp OTP popup UI validated");
            ExtentReporter.extentLoggerPass("QR_TC_42", "QR_TC_42, Use QR, Send Money To ML Wallet Transaction InApp OTP popup UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_SendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_QR_TC_43() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet New OTP got generated After Sixty Seconds validation");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if (verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"))) {
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP, sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("QR_TC_43, Use QR, Send Money To ML Wallet Transaction New OTP got generated After Sixty Seconds is validated");
            ExtentReporter.extentLoggerPass("QR_TC_43", "QR_TC_43, Use QR, Send Money To ML Wallet Transaction New OTP got generated After Sixty Seconds is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_SendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_QR_TC_44() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet Transaction OTP Cancel Button Functionality");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletUseQR.objConfirmDetails, getTextVal(MLWalletUseQR.objConfirmDetails, "Page"))) {
            logger.info("QR_TC_44, Use QR, Send Money To ML Wallet Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            ExtentReporter.extentLoggerPass("QR_TC_44", "QR_TC_44, Use QR, Send Money To ML Wallet Transaction, After clicking on Cancel in One time pin popup App navigates back to Confirm details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void useQR_SendMoneyToMLWalletOTPContinueBtnFunctionality_QR_TC_45() throws Exception {
        ExtentReporter.HeaderChildNode("Use QR, Send Money To ML Wallet Transaction OTP Continue Button Functionality");
        useQRCodeNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletUseQR.objReadQRCodeToSendMoney, getTextVal(MLWalletUseQR.objReadQRCodeToSendMoney, "Option"));
        enableCameraPopup();
        scanQR(prop.getproperty("Valid_QR"));
        enterAmountAndSendToMLWallet("10");
        enableLocation_PopUp();
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        if (verifyElementPresent(SendTransferPage.objSendMoneyMLWallet, getTextVal(SendTransferPage.objSendMoneyMLWallet, "Message"))) {
            logger.info("QR_TC_45, Use QR, Send Money To ML Wallet Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success Page is validated");
            ExtentReporter.extentLoggerPass("QR_TC_45", "QR_TC_45, Use QR, Send Money To ML Wallet Transaction, After clicking on Continue in One time pin popup App navigates to Transaction Success page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
