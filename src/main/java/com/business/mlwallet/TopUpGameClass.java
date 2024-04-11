package com.business.mlwallet;

import com.mlwallet.pages.*;
import com.utility.ExtentReporter;

import static com.utility.Utilities.*;

public class TopUpGameClass extends BaseClass {
    public TopUpGameClass() {
        super();
    }

    public void topUpGamesHomePageValidation_TUG_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Home Page Validation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        waitTime(5000);
        for (int i = 2; i < 8; i++) {
            verifyElementPresent(MLWalletTopUpGames.objGames(i), getTextVal(MLWalletTopUpGames.objGames(i), "Games"));
        }
//		for(int j=1;j<4;j++){
//			verifyElementPresent(MLWalletTopUpGames.objGames1(j),getTextVal(MLWalletTopUpGames.objGames1(j),"Games"));
//		}
        logger.info("TUG_TC_01, TopUp Games Home Page validated");
        ExtentReporter.extentLoggerPass("TUG_TC_01", "TUG_TC_01, TopUp Games Home Page validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void topUPGamesLoadSelectionScreenNavigation_TUG_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Load Selection Screen Navigation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletTopUpGames.objValorant, getTextVal(MLWalletTopUpGames.objValorant, "Game"));
        waitTime(4000);
        for (int i = 1; i <= 6; i++) {
            if (i % 2 != 0) {
                verifyElementPresent(MLWalletTopUpGames.objLoadTypeAndPoints(i), getTextVal(MLWalletTopUpGames.objLoadTypeAndPoints(i), "Load Type"));
            } else if (i % 2 == 0) {
                verifyElementPresent(MLWalletTopUpGames.objLoadTypeAndPoints(i), getTextVal(MLWalletTopUpGames.objLoadTypeAndPoints(i), "Points"));

            }
        }
        logger.info("TUG_TC_05, TopUp Games Load Selection Screen navigation validated");
        ExtentReporter.extentLoggerPass("TUG_TC_05", "TUG_TC_05, TopUp Games Load Selection Screen navigation validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void topUpGamesSuccessfulLoadTransaction_TUG_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games successful Load Transaction");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon, "Eye Icon");
        String sAvailableBalance = getText(MLWalletTopUpGames.objAvailableBalance);
        verifyElementPresentAndClick(MLWalletTopUpGames.objTopUpGames, getTextVal(MLWalletTopUpGames.objTopUpGames, "Icon"));
        verifyElementPresent(MLWalletTopUpGames.objTopGamesPage, "TopUp Games Page");
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGames.objConfirm, getTextVal(MLWalletTopUpGames.objConfirm, "button"));
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletTopUpGames.objTransactionDetails, getTextVal(MLWalletTopUpGames.objTransactionDetails, "Page"));
        verifyElementPresent(MLWalletTopUpGames.objTransactionCode, getTextVal(MLWalletTopUpGames.objTransactionCode, "Transaction Code"));
        verifyElementPresent(MLWalletTopUpGames.objGameUserIDInTransactionDetails, getTextVal(MLWalletTopUpGames.objGameUserIDInTransactionDetails, "Game User ID"));
        verifyElementPresent(MLWalletTopUpGames.objRedeemCode, getTextVal(MLWalletTopUpGames.objRedeemCode, "Redeem code"));
        swipeDownUntilElementVisible("Back To Home");
        verifyElementPresentAndClick(MLWalletTopUpGames.objBackToHome, getTextVal(MLWalletTopUpGames.objBackToHome, "Button"));
        Swipe("DOWN", 2);
        verifyElementPresentAndClick(MLWalletHomePage.objEyeIcon, "Eye Icon");
        String sAvailableBalanceAfterTopUp = getText(MLWalletTopUpGames.objAvailableBalance);
        assertNotEquals(sAvailableBalance, sAvailableBalanceAfterTopUp);
        logger.info("TUG_TC_06, TopUp Games successful Load Transaction validated");
        ExtentReporter.extentLoggerPass("TUG_TC_06", "TUG_TC_06, TopUp Games successful Load Transaction validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void topUPGamesLoadSelectionPageLoadTypesValidation_TUG_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Load Selection Page Load Types Validation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletTopUpGames.objValorant, getTextVal(MLWalletTopUpGames.objValorant, "Game"));
        waitTime(4000);
        for (int i = 1; i <= 6; i++) {
            if (i % 2 != 0) {
                verifyElementPresent(MLWalletTopUpGames.objLoadTypeAndPoints(i), getTextVal(MLWalletTopUpGames.objLoadTypeAndPoints(i), "Load Type"));
            } else if (i % 2 == 0) {
                verifyElementPresent(MLWalletTopUpGames.objLoadTypeAndPoints(i), getTextVal(MLWalletTopUpGames.objLoadTypeAndPoints(i), "Points"));
            }
            Swipe("UP", 1);
        }
        logger.info("TUG_TC_08, TopUp Games Load Selection Page Load Types Validation validated");
        ExtentReporter.extentLoggerPass("TUG_TC_08", "TUG_TC_08, TopUp Games Load Selection Page Load Types validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void topUPGamesTransactionDetailsPageNavigation_TUG_TC_09() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Transaction Details Page Navigation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        if (verifyElementPresent(MLWalletTopUpGames.objTransactionDetails, getTextVal(MLWalletTopUpGames.objTransactionDetails, "Page"))) {
            logger.info("TUG_TC_09, TopUp Games Transaction Details Page navigation validated");
            ExtentReporter.extentLoggerPass("TUG_TC_09", "TUG_TC_09, TopUp Games Transaction Details Page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesGameIDRequiredErrorMsgValidation_TUG_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Game ID Required Error Message validation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        swipeDownUntilElementVisible("Continue");
        verifyElementPresentAndClick(MLWalletTopUpGames.objContinue, getTextVal(MLWalletTopUpGames.objContinue, "Button"));
        if (verifyElementPresent(MLWalletTopUpGames.objGameIDRequiredMsg, getTextVal(MLWalletTopUpGames.objGameIDRequiredMsg, "Error Message"))) {
            String sActualErrorMsg = getText(MLWalletTopUpGames.objGameIDRequiredMsg);
            String sExceptedErrorMsg = "Game ID is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TUG_TC_10, TopUp Games Game ID Required Error Message validated");
            ExtentReporter.extentLoggerPass("TUG_TC_10", "TUG_TC_10, TopUp Games Game ID Required Error Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesEmailAddressRequiredErrorMsgValidation_TUG_TC_11() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Email Address Required Error Message validation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        type(MLWalletTopUpGames.objGameUserID, prop.getproperty("GameUserID"), "Game User ID Input Field");
        swipeDownUntilElementVisible("Continue");
        verifyElementPresentAndClick(MLWalletTopUpGames.objContinue, getTextVal(MLWalletTopUpGames.objContinue, "Button"));
        if (verifyElementPresent(MLWalletTopUpGames.objEmailRequiredMsg, getTextVal(MLWalletTopUpGames.objEmailRequiredMsg, "Error Message"))) {
            String sActualErrorMsg = getText(MLWalletTopUpGames.objEmailRequiredMsg);
            String sExceptedErrorMsg = "Email address is required";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TUG_TC_11, TopUp Games Email Address Required Error Message validated");
            ExtentReporter.extentLoggerPass("TUG_TC_11", "TUG_TC_11, TopUp Games Email Address Required Error Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesEmailAddressInvalidErrorMsgValidation_TUG_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Email Address invalid Error Message validation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        type(MLWalletTopUpGames.objGameUserID, prop.getproperty("GameUserID"), "Game User ID Input Field");
        type(MLWalletTopUpGames.objEmailAddress, prop.getproperty("Invalid_Email_Address"), "Email ID Input Field");
        swipeDownUntilElementVisible("Continue");
        verifyElementPresentAndClick(MLWalletTopUpGames.objContinue, getTextVal(MLWalletTopUpGames.objContinue, "Button"));
        if (verifyElementPresent(MLWalletTopUpGames.objEmailAddressInvalidMsg, getTextVal(MLWalletTopUpGames.objEmailAddressInvalidMsg, "Error Message"))) {
            String sActualErrorMsg = getText(MLWalletTopUpGames.objEmailAddressInvalidMsg);
            String sExceptedErrorMsg = "Email address is invalid";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TUG_TC_12, TopUp Games Email Address invalid Error Message validated");
            ExtentReporter.extentLoggerPass("TUG_TC_12", "TUG_TC_12, TopUp Games Email Address invalid Error Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesMobileNumberInvalidErrorMsgValidation_TUG_TC_13() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Mobile Number invalid Error Message validation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        type(MLWalletTopUpGames.objGameUserID, prop.getproperty("GameUserID"), "Game User ID Input Field");
        type(MLWalletTopUpGames.objEmailAddress, prop.getproperty("Email"), "Email ID Input Field");
        type(MLWalletTopUpGames.objMobileNumber, prop.getproperty("Invalid_MobileNumber"), "Mobile Number");
        swipeDownUntilElementVisible("Continue");
        verifyElementPresentAndClick(MLWalletTopUpGames.objContinue, getTextVal(MLWalletTopUpGames.objContinue, "Button"));
        if (verifyElementPresent(MLWalletTopUpGames.objMobileNumberInvalidMsg, getTextVal(MLWalletTopUpGames.objMobileNumberInvalidMsg, "Error Message"))) {
            String sActualErrorMsg = getText(MLWalletTopUpGames.objMobileNumberInvalidMsg);
            String sExceptedErrorMsg = "Mobile number is invalid";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TUG_TC_13, TopUp Games Mobile Number invalid Error Message validated");
            ExtentReporter.extentLoggerPass("TUG_TC_13", "TUG_TC_13, TopUp Games Mobile Number invalid Error Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesLandingPageNavigation_TUG_TC_14() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Landing Page navigation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletTopUpGames.objTopUpGames, getTextVal(MLWalletTopUpGames.objTopUpGames, "Icon"));
        if (verifyElementPresent(MLWalletTopUpGames.objTopGamesPage, "TopUp Games Page")) {
            logger.info("TUG_TC_14, TopUp Games Landing Page navigation validated");
            ExtentReporter.extentLoggerPass("TUG_TC_14", "TUG_TC_14, TopUp Games Landing Page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesTransactionDetailsPageUIValidation_TUG_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Transaction Details page UI navigation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        if (verifyElementPresent(MLWalletTopUpGames.objTransactionDetails, getTextVal(MLWalletTopUpGames.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTopUpGames.objGameUserIDInTransactionDetails, getTextVal(MLWalletTopUpGames.objGameUserIDInTransactionDetails, "Game User ID"));
            verifyElementPresent(MLWalletTopUpGames.objMobileNumberInTransactionDetails, getTextVal(MLWalletTopUpGames.objMobileNumberInTransactionDetails, "Mobile Number"));
            verifyElementPresent(MLWalletTopUpGames.objEmailInTransactionDetails, getTextVal(MLWalletTopUpGames.objEmailInTransactionDetails, "Email Address"));
            verifyElementPresent(MLWalletTopUpGames.objAmountInTransactionDetails, getTextVal(MLWalletTopUpGames.objAmountInTransactionDetails, "Amount"));
            verifyElementPresent(MLWalletTopUpGames.objConfirm, getTextVal(MLWalletTopUpGames.objConfirm, "Button"));
            logger.info("TUG_TC_15, TopUp Games Transaction Details page UI navigation validated");
            ExtentReporter.extentLoggerPass("TUG_TC_15", "TUG_TC_15, TopUp Games Transaction Details page UI navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesSaveToFavorites_TUG_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Save To Favorites");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGames.objConfirm, getTextVal(MLWalletTopUpGames.objConfirm, "button"));
        waitTime(5000);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletTopUpGames.objTransactionDetails, getTextVal(MLWalletTopUpGames.objTransactionDetails, "Page"));
        swipeDownUntilElementVisible("Save to my favorite");
        verifyElementPresentAndClick(MLWalletTopUpGames.objSaveToMyFavorite, getTextVal(MLWalletTopUpGames.objSaveToMyFavorite, "Button"));
        if (verifyElementPresent(MLWalletTopUpGames.objAddToFavoritesMsg, getTextVal(MLWalletTopUpGames.objAddToFavoritesMsg, "PopUp"))) {
            verifyElementPresent(MLWalletTopUpGames.objOkButton, getTextVal(MLWalletTopUpGames.objOkButton, "Button"));
            logger.info("TUG_TC_16, TopUp Games Save To Favorites validated");
            ExtentReporter.extentLoggerPass("TUG_TC_16", "TUG_TC_16, TopUp Games Save To Favorites validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void topUpGamesSRecipientAlreadySavedMsgValidation_TUG_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Recipient Already Saved Message validation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGames.objConfirm, getTextVal(MLWalletTopUpGames.objConfirm, "button"));
        waitTime(5000);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        verifyElementPresent(MLWalletTopUpGames.objTransactionDetails, getTextVal(MLWalletTopUpGames.objTransactionDetails, "Page"));
        swipeDownUntilElementVisible("Save to my favorite");
        verifyElementPresentAndClick(MLWalletTopUpGames.objSaveToMyFavorite, getTextVal(MLWalletTopUpGames.objSaveToMyFavorite, "Button"));
        if (verifyElementPresent(MLWalletTopUpGames.objDuplicateFavorites, getTextVal(MLWalletTopUpGames.objDuplicateFavorites, "PopUp"))) {
            verifyElementPresent(MLWalletTopUpGames.objOkButton, getTextVal(MLWalletTopUpGames.objOkButton, "Button"));
            logger.info("TUG_TC_17, TopUp Games Recipient Already Saved Message validated");
            ExtentReporter.extentLoggerPass("TUG_TC_17", "TUG_TC_17, TopUp Games Recipient Already Saved Message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesRemoveFromFavorites_TUG_TC_18() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games remove from favorites");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletTopUpGames.objMyFavorites, getTextVal(MLWalletTopUpGames.objMyFavorites, "Button"));
        type(MLWalletTopUpGames.objSearchFavField, prop.getproperty("GameMobileNumber"), "Game User ID Input Field");
        click(MLWalletTopUpGames.objHamburgerMenu, "Hamburger menu");
        verifyElementPresentAndClick(MLWalletTopUpGames.objRemoveBtn, getTextVal(MLWalletTopUpGames.objRemoveBtn, "Button"));
        if (verifyElementNotPresent(MLWalletTopUpGames.objFavoriteRecipient, "Saved Recipient", 5)) {
            logger.info("TUG_TC_18, TopUp Games Recipient successfully removed from favorites validated");
            ExtentReporter.extentLoggerPass("TUG_TC_18", "TUG_TC_18, TopUp Games Recipient successfully removed from favorites validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesTransactionValidationInTransactionHistory_TUG_TC_19() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Transaction Validation in Transaction History");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        Swipe("UP", 3);
        verifyElementPresentAndClick(MLWalletHomePage.objSeeMore, getTextVal(MLWalletHomePage.objSeeMore, "Button"));
        scrollToFirstHorizontalScrollableElement("Top Up Games");
        click(MLWalletTopUpGames.objTopUpGamesTransaction, getTextVal(MLWalletTopUpGames.objTopUpGamesTransaction, "Option"));
        verifyElementPresentAndClick(MLWalletTransactionHistoryPage.objFirstTransaction, "First Transaction");
        if (verifyElementPresent(MLWalletTransactionHistoryPage.objTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, getTextVal(MLWalletTransactionHistoryPage.objReferenceNumberInTransactionDetails, "Reference Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objReceiverMobileNo, getTextVal(MLWalletTransactionHistoryPage.objReceiverMobileNo, "Receiver Mobile Number"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objPaymentMethod, getTextVal(MLWalletTransactionHistoryPage.objPaymentMethod, "Payment Method"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objLoadType, getTextVal(MLWalletTransactionHistoryPage.objLoadType, "Load Type"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objRedeemCode, getTextVal(MLWalletTransactionHistoryPage.objRedeemCode, "Redeem Code"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objAmount, getTextVal(MLWalletTransactionHistoryPage.objAmount, "Amount To Send"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objServiceFee, getTextVal(MLWalletTransactionHistoryPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletTransactionHistoryPage.objTotalAmount, getTextVal(MLWalletTransactionHistoryPage.objTotalAmount, "Total Amount"));
            logger.info("TUG_TC_19, TopUp Games Transaction Validated in Transaction History");
            ExtentReporter.extentLoggerPass("TUG_TC_19", "TUG_TC_19, TopUp Games Transaction Validated in Transaction History");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void topUpGamesTopUpAgainFunctionalityAfterFirstSuccessfulTransaction_TUG_TC_27() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games TopUp Again Functionality After First Successful Transaction");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGames.objConfirm, getTextVal(MLWalletTopUpGames.objConfirm, "button"));
        waitTime(5000);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        swipeDownUntilElementVisible("Top Up Again");
        verifyElementPresentAndClick(MLWalletTopUpGames.objTopUpAgainBtn, getTextVal(MLWalletTopUpGames.objTopUpAgainBtn, "Button"));
        waitTime(6000);
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGames.objConfirm, getTextVal(MLWalletTopUpGames.objConfirm, "button"));
        waitTime(5000);
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletTopUpGames.objTransactionDetails, getTextVal(MLWalletTopUpGames.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTopUpGames.objTransactionCode, getTextVal(MLWalletTopUpGames.objTransactionCode, "Transaction Code"));
            verifyElementPresent(MLWalletTopUpGames.objGameUserIDInTransactionDetails, getTextVal(MLWalletTopUpGames.objGameUserIDInTransactionDetails, "Game User ID"));
            verifyElementPresent(MLWalletTopUpGames.objRedeemCode, getTextVal(MLWalletTopUpGames.objRedeemCode, "Redeem code"));
            logger.info("TUG_TC_27, TopUp Games TopUp Again Functionality After First Successful Transaction validated");
            ExtentReporter.extentLoggerPass("TUG_TC_27", "TUG_TC_27, TopUp Games TopUp Again Functionality After First Successful Transaction validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesRecentTransactionValidation_TUG_TC_28() throws Exception {
        ExtentReporter.HeaderChildNode("Top Up Games Recent Transaction Validation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGames.objConfirm, getTextVal(MLWalletTopUpGames.objConfirm, "button"));
        waitTime(5000);
        enableLocation_PopUp();
        enterOTP(prop.getproperty("Valid_OTP"));
        swipeDownUntilElementVisible("Back To Home");
        verifyElementPresentAndClick(MLWalletTopUpGames.objBackToHome, getTextVal(MLWalletTopUpGames.objBackToHome, "Button"));
        verifyElementPresent(MLWalletHomePage.objRecentTransactions, getTextVal(MLWalletHomePage.objRecentTransactions, "Header"));
        Swipe("UP", 1);
        if (verifyElementPresent(MLWalletTopUpGames.objTopUpGamesTransaction, getTextVal(MLWalletTopUpGames.objTopUpGamesTransaction, "Transaction"))) {
            verifyElementPresent(MLWalletTopUpGames.objCompleteStatus, getTextVal(MLWalletTopUpGames.objCompleteStatus, "Status"));
            logger.info("TUG_TC_28, Top Up Games Recent Transaction Validation");
            ExtentReporter.extentLoggerPass("TUG_TC_28", "TUG_TC_28, Top Up Games Recent Transaction Validation");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesSelectRecipientWithSavedFavorites_TUG_TC_29() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Select recipient with saved favorites");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletTopUpGames.objMyFavorites, getTextVal(MLWalletTopUpGames.objMyFavorites, "Button"));
        type(MLWalletTopUpGames.objSearchFavField, prop.getproperty("GameMobileNumber"), "Game User ID Input Field");
        click(MLWalletTopUpGames.objFavoriteRecipient, getTextVal(MLWalletTopUpGames.objFavoriteRecipient, "Favorite Recipient"));
        if (verifyElementPresent(MLWalletTopUpGames.objBuyPHP149, "Load Selection Page")) {
            logger.info("TUG_TC_29, TopUp Games Select recipient with saved favorites validated");
            ExtentReporter.extentLoggerPass("TUG_TC_29", "TUG_TC_29, Top Up Games Recent Transaction Validation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesTransactionWithValidMLPin_TUG_TC_31() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Transaction with Valid MLPin");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGames.objConfirm, getTextVal(MLWalletTopUpGames.objConfirm, "button"));
        waitTime(5000);
        enableLocation_PopUp();
        handleMpin(prop.getproperty("MLPin"));
        if (verifyElementPresent(MLWalletTopUpGames.objTransactionDetails, getTextVal(MLWalletTopUpGames.objTransactionDetails, "Page"))) {
            verifyElementPresent(MLWalletTopUpGames.objTransactionCode, getTextVal(MLWalletTopUpGames.objTransactionCode, "Transaction Code"));
            verifyElementPresent(MLWalletTopUpGames.objGameUserIDInTransactionDetails, getTextVal(MLWalletTopUpGames.objGameUserIDInTransactionDetails, "Game User ID"));
            verifyElementPresent(MLWalletTopUpGames.objRedeemCode, getTextVal(MLWalletTopUpGames.objRedeemCode, "Redeem code"));
        }
        logger.info("TUG_TC_31, TopUp Games Transaction with Valid MLPin validated");
        ExtentReporter.extentLoggerPass("TUG_TC_31", "TUG_TC_31, TopUp Games Transaction with Valid MLPin validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void topUpGamesTransactionWithInValidMLPin_TUG_TC_26() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games Transaction with InValid MLPin");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGames.objConfirm, getTextVal(MLWalletTopUpGames.objConfirm, "button"));
        waitTime(5000);
        enableLocation_PopUp();
        handleMpin(prop.getproperty("wrongMpin"));
        if (verifyElementPresent(MLWalletCashInViaBranch.objInvalidPINMsg, getTextVal(MLWalletCashInViaBranch.objInvalidPINMsg, "Message"))) {
            String sActualErrorMsg = getText(MLWalletCashInViaBranch.objInvalidPINMsg);
            String sExceptedErrorMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TUG_TC_26, TopUp Games Transaction with InValid MLPin validated");
            ExtentReporter.extentLoggerPass("TUG_TC_26", "TUG_TC_26, TopUp Games Transaction with Valid MLPin validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesMLPinPageNavigation_TUG_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games ML Pin Page Navigation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGames.objConfirm, getTextVal(MLWalletTopUpGames.objConfirm, "button"));
        waitTime(5000);
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletTopUpGames.objMLPinEditField, "ML Pin Edit Field")) {
            logger.info("TUG_TC_23, TopUp Games ML Pin Page navigation validated");
            ExtentReporter.extentLoggerPass("TUG_TC_23", "TUG_TC_23, TopUp Games ML Pin Page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void topUpGamesInAppOTPPopupNavigation_TUG_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("TopUp Games InApp popup navigation");
        topUpGamesHomePageNavigation(prop.getproperty("Branch_Verified"));
        selectGameAndLoadType();
        inputRequiredDataAndContinue();
        verifyElementPresentAndClick(MLWalletTopUpGames.objConfirm, getTextVal(MLWalletTopUpGames.objConfirm, "button"));
        waitTime(5000);
        enableLocation_PopUp();
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Popup"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "OTP Generated"));
            logger.info("TUG_TC_20, TopUp Games InApp popup navigation validated");
            ExtentReporter.extentLoggerPass("TUG_TC_20", "TUG_TC_20, TopUp Games InApp popup navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
