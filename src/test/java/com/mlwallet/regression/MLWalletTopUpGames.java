package com.mlwallet.regression;

import com.business.mlwallet.TopUpGameClass;
import com.driverInstance.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MLWalletTopUpGames {

    public static String deviceName;
    public static String portno;
    public  static TopUpGameClass TopUpGameClass;


    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletTopUpGames.deviceName=deviceName;
        MLWalletTopUpGames.portno= portno;
        TopUpGameClass = new TopUpGameClass("MLWallet",deviceName,portno);
    }

    @Test(priority = 1)
    public void topUpGamesHomePageValidation_TUG_TC_01() throws Exception {
        TopUpGameClass.topUpGamesHomePageValidation_TUG_TC_01();
    }

    @Test(priority = 2)
    public void topUPGamesLoadSelectionScreenNavigation_TUG_TC_05() throws Exception {
        TopUpGameClass.topUPGamesLoadSelectionScreenNavigation_TUG_TC_05();
    }

    @Test(priority = 3)
    public void topUpGamesSuccessfulLoadTransaction_TUG_TC_06() throws Exception {
        TopUpGameClass.topUpGamesSuccessfulLoadTransaction_TUG_TC_06();
    }

    @Test(priority = 4)
    public void topUPGamesLoadSelectionPageLoadTypesValidation_TUG_TC_08() throws Exception {
        TopUpGameClass.topUPGamesLoadSelectionPageLoadTypesValidation_TUG_TC_08();
    }


    @Test(priority = 5)
    public void topUPGamesTransactionDetailsPageNavigation_TUG_TC_09() throws Exception {
        TopUpGameClass.topUPGamesTransactionDetailsPageNavigation_TUG_TC_09();
    }

    @Test(priority = 6)
    public void topUpGamesGameIDRequiredErrorMsgValidation_TUG_TC_10() throws Exception {
        TopUpGameClass.topUpGamesGameIDRequiredErrorMsgValidation_TUG_TC_10();
    }

    @Test(priority = 7)
    public void topUpGamesEmailAddressRequiredErrorMsgValidation_TUG_TC_11() throws Exception {
        TopUpGameClass.topUpGamesEmailAddressRequiredErrorMsgValidation_TUG_TC_11();
    }

    @Test(priority = 8)
    public void topUpGamesEmailAddressInvalidErrorMsgValidation_TUG_TC_12() throws Exception {
        TopUpGameClass.topUpGamesEmailAddressInvalidErrorMsgValidation_TUG_TC_12();
    }

    @Test(priority = 9)
    public void topUpGamesMobileNumberInvalidErrorMsgValidation_TUG_TC_13() throws Exception {
        TopUpGameClass.topUpGamesMobileNumberInvalidErrorMsgValidation_TUG_TC_13();
    }

    @Test(priority = 10)
    public void topUpGamesLandingPageNavigation_TUG_TC_14() throws Exception {
        TopUpGameClass.topUpGamesLandingPageNavigation_TUG_TC_14();
    }

    @Test(priority = 11)
    public void topUpGamesTransactionDetailsPageUIValidation_TUG_TC_15() throws Exception {
        TopUpGameClass.topUpGamesTransactionDetailsPageUIValidation_TUG_TC_15();
    }

    @Test(priority = 12)
    public void topUpGamesSaveToFavorites_TUG_TC_16() throws Exception {
        TopUpGameClass.topUpGamesSaveToFavorites_TUG_TC_16();
    }

    @Test(priority = 13)
    public void topUpGamesSelectRecipientWithSavedFavorites_TUG_TC_29() throws Exception {
        TopUpGameClass.topUpGamesSelectRecipientWithSavedFavorites_TUG_TC_29();
    }

    @Test(priority = 14)
    public void topUpGamesSRecipientAlreadySavedMsgValidation_TUG_TC_17() throws Exception {
        TopUpGameClass.topUpGamesSRecipientAlreadySavedMsgValidation_TUG_TC_17();
    }

    @Test(priority = 15)
    public void topUpGamesRemoveFromFavorites_TUG_TC_18() throws Exception {
        TopUpGameClass.topUpGamesRemoveFromFavorites_TUG_TC_18();
    }

    @Test(priority = 16)
    public void topUpGamesTransactionValidationInTransactionHistory_TUG_TC_19() throws Exception {
        TopUpGameClass.topUpGamesTransactionValidationInTransactionHistory_TUG_TC_19();
    }

    @Test(priority = 17)
    public void topUpGamesTransactionWithInValidMLPin_TUG_TC_26() throws Exception {
        TopUpGameClass.topUpGamesTransactionWithInValidMLPin_TUG_TC_26();
    }

    @Test(priority = 18)
    public void topUpGamesTopUpAgainFunctionalityAfterFirstSuccessfulTransaction_TUG_TC_27() throws Exception {
        TopUpGameClass.topUpGamesTopUpAgainFunctionalityAfterFirstSuccessfulTransaction_TUG_TC_27();
    }

    @Test(priority = 19)
    public void topUpGamesRecentTransactionValidation_TUG_TC_28() throws Exception {
        TopUpGameClass.topUpGamesRecentTransactionValidation_TUG_TC_28();
    }

    @Test(priority = 20)
    public void topUpGamesTransactionWithValidMLPin_TUG_TC_31() throws Exception {
        TopUpGameClass.topUpGamesTransactionWithValidMLPin_TUG_TC_31();
    }

    @Test(priority = 21)
    public void topUpGamesMLPinPageNavigation_TUG_TC_23() throws Exception {
        TopUpGameClass.topUpGamesMLPinPageNavigation_TUG_TC_23();
    }

    @Test(priority = 22)
    public void topUpGamesInAppOTPPopupNavigation_TUG_TC_20() throws Exception {
        TopUpGameClass.topUpGamesInAppOTPPopupNavigation_TUG_TC_20();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }
}

