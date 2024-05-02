package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletTopUpGames extends BaseTest{

    //-----------------Positive Testing
    @Test(priority = 1)
    public void topUpGamesHomePageValidation_TUG_TC_01() throws Exception {
        mlWalletTopUp.topUpGamesHomePageValidation_TUG_TC_01();
    }
    @Test(priority = 2)
    public void topUPGamesLoadSelectionScreenNavigation_TUG_TC_05() throws Exception {
        mlWalletTopUp.topUPGamesLoadSelectionScreenNavigation_TUG_TC_05();
    }
    @Test(priority = 3)
    public void topUpGamesSuccessfulTransaction_TUG_TC_06() throws Exception {
        mlWalletTopUp.topUpGamesSuccessfulTransaction_TUG_TC_06();
    }
    @Test(priority = 4)
    public void topUPGamesLoadSelectionPageLoadTypesValidation_TUG_TC_08() throws Exception {
        mlWalletTopUp.topUPGamesLoadSelectionPageLoadTypesValidation_TUG_TC_08();
    }
    @Test(priority = 5)
    public void topUPGamesTransactionDetailsPageNavigation_TUG_TC_09() throws Exception {
        mlWalletTopUp.topUPGamesTransactionDetailsPageNavigation_TUG_TC_09();
    }
    @Test(priority = 6)
    public void topUpGamesLandingPageNavigation_TUG_TC_14() throws Exception {
        mlWalletTopUp.topUpGamesLandingPageNavigation_TUG_TC_14();
    }
    @Test(priority = 7)
    public void topUpGamesTransactionDetailsPageUIValidation_TUG_TC_15() throws Exception {
        mlWalletTopUp.topUpGamesTransactionDetailsPageUIValidation_TUG_TC_15();
    }
    @Test(priority = 8)
    public void topUpGamesSaveToFavorites_TUG_TC_16() throws Exception {
        mlWalletTopUp.topUpGamesSaveToFavorites_TUG_TC_16();
    }
    @Test(priority = 9)
    public void topUpGamesSelectRecipientWithSavedFavorites_TUG_TC_29() throws Exception {
        mlWalletTopUp.topUpGamesSelectRecipientWithSavedFavorites_TUG_TC_29();
    }
    @Test(priority = 10)
    public void topUpGamesSRecipientAlreadySavedMsgValidation_TUG_TC_17() throws Exception {
        mlWalletTopUp.topUpGamesSRecipientAlreadySavedMsgValidation_TUG_TC_17();
    }
    @Test(priority = 11)
    public void topUpGamesTransactionValidationInTransactionHistory_TUG_TC_19() throws Exception {
        mlWalletTopUp.topUpGamesTransactionValidationInTransactionHistory_TUG_TC_19();
    }
    @Test(priority = 12)
    public void topUpGamesTopUpAgainFunctionalityAfterFirstSuccessfulTransaction_TUG_TC_27() throws Exception {
        mlWalletTopUp.topUpGamesTopUpAgainFunctionalityAfterFirstSuccessfulTransaction_TUG_TC_27();
    }
    @Test(priority = 13)
    public void topUpGamesRecentTransactionValidation_TUG_TC_28() throws Exception {
        mlWalletTopUp.topUpGamesRecentTransactionValidation_TUG_TC_28();
    }
    @Test(priority = 14)
    public void topUpGamesTransactionWithValidMLPin_TUG_TC_31() throws Exception {
        mlWalletTopUp.topUpGamesTransactionWithValidMLPin_TUG_TC_31();
    }
    @Test(priority = 15)
    public void topUpGamesMLPinPageNavigation_TUG_TC_23() throws Exception {
        mlWalletTopUp.topUpGamesMLPinPageNavigation_TUG_TC_23();
    }
    @Test(priority = 16)
    public void topUpGamesInAppOTPPopupNavigation_TUG_TC_20() throws Exception {
        mlWalletTopUp.topUpGamesInAppOTPPopupNavigation_TUG_TC_20();
    }

    //============================================================================================

    //-----------------Negative Testing
    @Test(priority = 17)
    public void topUpGamesGameIDRequiredErrorMsgValidation_TUG_TC_10() throws Exception {
        mlWalletTopUp.topUpGamesGameIDRequiredErrorMsgValidation_TUG_TC_10();
    }
    @Test(priority = 18)
    public void topUpGamesEmailAddressRequiredErrorMsgValidation_TUG_TC_11() throws Exception {
        mlWalletTopUp.topUpGamesEmailAddressRequiredErrorMsgValidation_TUG_TC_11();
    }
    @Test(priority = 19)
    public void topUpGamesEmailAddressInvalidErrorMsgValidation_TUG_TC_12() throws Exception {
        mlWalletTopUp.topUpGamesEmailAddressInvalidErrorMsgValidation_TUG_TC_12();
    }
    @Test(priority = 20)
    public void topUpGamesMobileNumberInvalidErrorMsgValidation_TUG_TC_13() throws Exception {
        mlWalletTopUp.topUpGamesMobileNumberInvalidErrorMsgValidation_TUG_TC_13();
    }
    @Test(priority = 21)
    public void topUpGamesRemoveFromFavorites_TUG_TC_18() throws Exception {
        mlWalletTopUp.topUpGamesRemoveFromFavorites_TUG_TC_18();
    }
    @Test(priority = 22)
    public void topUpGamesTransactionWithInValidMLPin_TUG_TC_26() throws Exception {
        mlWalletTopUp.topUpGamesTransactionWithInValidMLPin_TUG_TC_26();
    }


    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }
}

