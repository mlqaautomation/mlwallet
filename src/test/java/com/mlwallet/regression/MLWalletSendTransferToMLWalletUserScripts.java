package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

public class MLWalletSendTransferToMLWalletUserScripts extends BaseTest{
    
    @Test(priority = 1)
    public void sendToMLWalletUser_STW_TC_01() throws Exception
    {
        mlWalletSendMoneyViaWallet.sendToMLWalletUser_STW_TC_01();
    }

    @Test(priority = 2)
    public void sendMoneyAddToFavorites_STW_TC_12() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyAddToFavorites_STW_TC_12();
    }

    @Test(priority = 3)
    public void kwartaPadalaViaMLWalletSuccessfulTransaction_STW_TC_02() throws Exception
    {
        mlWalletSendMoneyViaWallet.kwartaPadalaViaMLWalletSuccessfulTransaction_STW_TC_02();

    }

    @Test(priority = 4)
    public void sendToMLWalletInvalidMobNumber_STW_TC_03() throws Exception
    {
        mlWalletSendMoneyViaWallet.sendToMLWalletInvalidMobNumber_STW_TC_03();
    }

    @Test(priority = 5)
    public void sendToMLWalletUnRegisteredNumber_STW_TC_04() throws Exception
    {
        mlWalletSendMoneyViaWallet.sendToMLWalletUnRegisteredNumber_STW_TC_04();
    }

    @Test(priority = 6)
    public void sendToMLWalletInvalidAmount_STW_TC_05() throws Exception
    {
        mlWalletSendMoneyViaWallet.sendToMLWalletInvalidAmount_STW_TC_05("0");
    }

    @Test(priority = 7)
    public void sendToMLWalletInsufficientAmount_STW_TC_06() throws Exception
    {
        mlWalletSendMoneyViaWallet.sendToMLWalletInsufficientAmount_STW_TC_06();
    }

    @Test(priority = 8)
    public void sendMoneyMLWalletMaximumAmount_STW_TC_07() throws Exception
    {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletMaximumAmount_STW_TC_07();
    }

    @Test(priority = 14)
      public void sendMoneyDeleteFromFavorites_STW_TC_09() throws Exception
    {
        mlWalletSendMoneyViaWallet.sendMoneyDeleteFromFavorites_STW_TC_09();
    }

    @Test(priority = 10)
    public void sendMoneyMLWalletUIValidation_STW_TC_10() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletUIValidation_STW_TC_10();
    }

    @Test(priority = 11)
    public void sendMoneyFavoritesUIValidation_STW_TC_11() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyFavoritesUIValidation_STW_TC_11();
    }

    @Test(priority = 12)
    public void sendMoneyMLWalletCancelTransaction_STW_TC_13() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletCancelTransaction_STW_TC_13("100");
    }

    @Test(priority = 13)
    public void sendMoneyMLWalletSearchUnFavoriteUser_STW_TC_14() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletSearchUnFavoriteUser_STW_TC_14();
    }

    @Test(priority = 9)
    public void sendMoneyMLWalletSearchFavoriteUser_STW_TC_15() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletSearchFavoriteUser_STW_TC_15();
    }

    @Test(priority = 15)
    public void SendMoneyMLWalletSuccessPageUIValidation_STW_TC_16() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletSuccessPageUIValidation_STW_TC_16();
    }

    @Test(priority = 16)
    public void sendMoneyMLWalletOTPPageUIValidation_STW_TC_17() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletOTPPageUIValidation_STW_TC_17();
    }

    @Test(priority = 17)
    public void sendMoneyMLWalletConfirmDetailsPageUIValidation_STW_TC_18() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletConfirmDetailsPageUIValidation_STW_TC_18("100");
    }

    @Test(priority = 18)
    public void sendMoneyToMlWalletEnterAmountPageUIValidation_STW_TC_19() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMlWalletEnterAmountPageUIValidation_STW_TC_19();
    }

    @Test(priority = 19)
    public void sendMoneyToMLWalletPageUIValidation_STW_TC_20() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletPageUIValidation_STW_TC_20();
    }

    @Test(priority = 20)
    public void sendMoneyMlWalletTransactionDetailsUIValidation_STW_TC_21() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMlWalletTransactionDetailsUIValidation_STW_TC_21();
    }


    @Test(priority = 21)
    public void sendMoneyMLWalletBuyerTierAccountUser_STW_TC_22() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletBuyerTierAccountUser_STW_TC_22();
    }

    @Test(priority = 22)
    public void sendMoneyMLWalletSemiVerifiedAccountUser_STW_TC_23() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletSemiVerifiedAccountUser_STW_TC_23();
    }

    @Test(priority = 23)
    public void sendMoneyMLWalletBranchVerifiedAccountUser_STW_TC_24() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletBranchVerifiedAccountUser_STW_TC_24();
    }

    @Test(priority = 24)
    public void sendMoneyMLWalletFullyVerifiedAccountUser_STW_TC_25() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletFullyVerifiedAccountUser_STW_TC_25();
    }

    @Test(priority = 25)
    public void sendMoneyMlWalletSemiVerifiedAccountMaxLimit_STW_TC_26() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletSemiVerifiedAccountMaxLimit_STW_TC_26();
    }

    @Test(priority = 26)
    public void sendMoneyMlWalletBranchVerifiedAccountMaxLimit_STW_TC_29() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletBranchVerifiedAccountMaxLimit_STW_TC_29();
    }

    @Test(priority = 27)
    public void sendMoneyMLWalletFullyVerifiedAccountMaxLimit_STW_TC_32() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyMLWalletFullyVerifiedAccountMaxLimit_STW_TC_32();
    }

    @Test(priority = 28)
    public void sendMoneyToMLWalletSuccessMsgValidation_STW_TC_35() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletSuccessMsgValidation_STW_TC_35();
    }

    @Test(priority = 29)
    public void sendMoneyToMLWalletMaxTransactionReceivingLimitSemiVerifiedTier_STW_TC_36() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletMaxTransactionReceivingLimitSemiVerifiedTier_STW_TC_36("50000");
    }

    @Test(priority = 30)
    public void sendMoneyToMLWalletMaxTransactionReceivingLimitBranchVerifiedTier_STW_TC_38() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletMaxTransactionReceivingLimitBranchVerifiedTier_STW_TC_38("50000");
    }

    @Test(priority = 31)
    public void sendMoneyToMLWalletMaxTransactionReceivingLimitFullyVerifiedTier_STW_TC_40() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletMaxTransactionReceivingLimitFullyVerifiedTier_STW_TC_40("50000");
    }
    @Test(priority = 35)
    public void sendMoneyToMLWalletLocationPopupValidation_STW_TC_42() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletLocationPopupValidation_STW_TC_42();
    }

    @Test(priority = 36)
    public void sendMoneyToMLWalletLocationDenyFunctionality_STW_TC_43() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletLocationDenyFunctionality_STW_TC_43();
    }

    @Test(priority = 37)
    public void sendMoneyToMLWalletLocationPermissionDenyCloseBtnFunctionality_STW_TC_44() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletLocationPermissionDenyCloseBtnFunctionality_STW_TC_44();
    }

    @Test(priority = 38)
    public void sendMoneyToMLWalletLocationPermissionDenyOpenSettingsBtnFunctionality_STW_TC_45() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletLocationPermissionDenyOpenSettingsBtnFunctionality_STW_TC_45();
    }

    @Test(priority = 39)
    public void sendMoneyToMLWalletLocationPopUpAllowFunctionality_STW_TC_46() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletLocationPopUpAllowFunctionality_STW_TC_46();
    }

//    @Test(priority = 40)
//    public void sendMoneyToMLWalletInternetInterruptionWhileEnteringOTP_STW_TC_47() throws Exception {
//        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletInternetInterruptionWhileEnteringOTP_STW_TC_47();
//    }

    @Test(priority = 41)
    public void sendMoneyToMLWalletTransactionValidationAfterMinimizingApp_STW_TC_50() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletTransactionValidationAfterMinimizingApp_STW_TC_50();
    }


    @Test(priority = 42)
    public void sendMoneyToMLWalletTransactionWithValidMLPin_STW_TC_56() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletTransactionWithValidMLPin_STW_TC_56();
    }

    @Test(priority = 43)
    public void sendMoneyToMLWalletTransactionWithInValidMLPin_STW_TC_57() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletTransactionWithInValidMLPin_STW_TC_57();
    }

    @Test(priority = 44)
    public void sendMoneyToMLWalletInOTPPopupValidation_STW_TC_63() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletInOTPPopupValidation_STW_TC_63();
    }

    @Test(priority = 45)
    public void sendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_STW_TC_64() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_STW_TC_64();
    }

    @Test(priority = 46)
    public void sendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_STW_TC_65() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_STW_TC_65();
    }

    @Test(priority = 47)
    public void sendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_STW_TC_66() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_STW_TC_66();
    }


    @Test(priority = 48)
    public void sendMoneyToMLWalletOTPContinueBtnFunctionality_STW_TC_67() throws Exception {
        mlWalletSendMoneyViaWallet.sendMoneyToMLWalletOTPContinueBtnFunctionality_STW_TC_67();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }








}
