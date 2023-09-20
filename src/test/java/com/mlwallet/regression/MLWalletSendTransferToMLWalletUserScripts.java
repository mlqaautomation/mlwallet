package com.mlwallet.regression;

import com.business.mlwallet.MLWalletBusinessLogic;
import com.driverInstance.AppiumServer;
import org.testng.annotations.*;
import com.business.mlwallet.SendMoneyVia_WalletClass;

public class MLWalletSendTransferToMLWalletUserScripts {

    public static String deviceName;
    public static String portno;
    public  static com.business.mlwallet.MLWalletBusinessLogic MLWalletBusinessLogic;
    public static com.business.mlwallet.SendMoneyVia_WalletClass sendMoneyVia_walletClass;



    //@BeforeSuite(groups = { "All" })
    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletSendTransferToMLWalletUserScripts.deviceName=deviceName;
        MLWalletSendTransferToMLWalletUserScripts.portno= portno;
//        MLWalletBusinessLogic = new MLWalletBusinessLogic("MLWallet",deviceName,portno);
        sendMoneyVia_walletClass = new SendMoneyVia_WalletClass("MLWallet",deviceName,portno);
    }


//===========================================================================================================//

    @Test(priority = 1)
    public void sendToMLWalletUser_STW_TC_01() throws Exception
    {
        sendMoneyVia_walletClass.sendToMLWalletUser_STW_TC_01();
    }

    @Test(priority = 2)
    public void sendMoneyAddToFavorites_STW_TC_12() throws Exception {
        sendMoneyVia_walletClass.sendMoneyAddToFavorites_STW_TC_12();
    }

    @Test(priority = 3)
    public void sendMoneyMLWalletToExistingReceiver_STW_TC_02() throws Exception
    {
        sendMoneyVia_walletClass.sendMoneyMLWalletToExistingReceiver_STW_TC_02();

    }

    @Test(priority = 4)
    public void sendToMLWalletInvalidMobNumber_STW_TC_03() throws Exception
    {
        MLWalletBusinessLogic.sendToMLWalletInvalidMobNumber_STW_TC_03();
    }

    @Test(priority = 5)
    public void sendToMLWalletUnRegisteredNumber_STW_TC_04() throws Exception
    {
        sendMoneyVia_walletClass.sendToMLWalletUnRegisteredNumber_STW_TC_04();
    }

    @Test(priority = 6)
    public void sendToMLWalletInvalidAmount_STW_TC_05() throws Exception
    {
        sendMoneyVia_walletClass.sendToMLWalletInvalidAmount_STW_TC_05("0");
    }

    @Test(priority = 7)
    public void sendToMLWalletInsufficientAmount_STW_TC_06() throws Exception
    {
        sendMoneyVia_walletClass.sendToMLWalletInsufficientAmount_STW_TC_06();
    }

    @Test(priority = 8)
    public void sendMoneyMLWalletMaximumAmount_STW_TC_07() throws Exception
    {
        sendMoneyVia_walletClass.sendMoneyMLWalletMaximumAmount_STW_TC_07();
    }


//================================================================================================//

    @Test(priority = 14)
      public void sendMoneyDeleteFromFavorites_STW_TC_09() throws Exception
    {
        sendMoneyVia_walletClass.sendMoneyDeleteFromFavorites_STW_TC_09();
    }

    @Test(priority = 10)
    public void sendMoneyMLWalletUIValidation_STW_TC_10() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletUIValidation_STW_TC_10();
    }

    @Test(priority = 11)
    public void sendMoneyFavoritesUIValidation_STW_TC_11() throws Exception {
        sendMoneyVia_walletClass.sendMoneyFavoritesUIValidation_STW_TC_11();
    }

    @Test(priority = 12)
    public void sendMoneyMLWalletCancelTransaction_STW_TC_13() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletCancelTransaction_STW_TC_13("100");
    }

    @Test(priority = 13)
    public void sendMoneyMLWalletSearchUnFavoriteUser_STW_TC_14() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletSearchUnFavoriteUser_STW_TC_14();
    }

    @Test(priority = 9)
    public void sendMoneyMLWalletSearchFavoriteUser_STW_TC_15() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletSearchFavoriteUser_STW_TC_15();
    }

    @Test(priority = 15)
    public void SendMoneyMLWalletSuccessPageUIValidation_STW_TC_16() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletSuccessPageUIValidation_STW_TC_16();
    }

    @Test(priority = 16)
    public void sendMoneyMLWalletOTPPageUIValidation_STW_TC_17() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletOTPPageUIValidation_STW_TC_17();
    }

    @Test(priority = 17)
    public void sendMoneyMLWalletConfirmDetailsPageUIValidation_STW_TC_18() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletConfirmDetailsPageUIValidation_STW_TC_18("100");
    }

    @Test(priority = 18)
    public void sendMoneyToMlWalletEnterAmountPageUIValidation_STW_TC_19() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMlWalletEnterAmountPageUIValidation_STW_TC_19();
    }

    @Test(priority = 19)
    public void sendMoneyToMLWalletPageUIValidation_STW_TC_20() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletPageUIValidation_STW_TC_20();
    }

    @Test(priority = 20)
    public void sendMoneyMlWalletTransactionDetailsUIValidation_STW_TC_21() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMlWalletTransactionDetailsUIValidation_STW_TC_21();
    }


    @Test(priority = 21)
    public void sendMoneyMLWalletBuyerTierAccountUser_STW_TC_22() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletBuyerTierAccountUser_STW_TC_22();
    }

    @Test(priority = 22)
    public void sendMoneyMLWalletSemiVerifiedAccountUser_STW_TC_23() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletSemiVerifiedAccountUser_STW_TC_23();
    }

    @Test(priority = 23)
    public void sendMoneyMLWalletBranchVerifiedAccountUser_STW_TC_24() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletBranchVerifiedAccountUser_STW_TC_24();
    }

    @Test(priority = 24)
    public void sendMoneyMLWalletFullyVerifiedAccountUser_STW_TC_25() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletFullyVerifiedAccountUser_STW_TC_25();
    }

    @Test(priority = 25)
    public void sendMoneyMlWalletSemiVerifiedAccountMaxLimit_STW_TC_26() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletSemiVerifiedAccountMaxLimit_STW_TC_26();
    }

    @Test(priority = 26)
    public void sendMoneyMlWalletBranchVerifiedAccountMaxLimit_STW_TC_29() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletBranchVerifiedAccountMaxLimit_STW_TC_29();
    }

    @Test(priority = 27)
    public void sendMoneyMLWalletFullyVerifiedAccountMaxLimit_STW_TC_32() throws Exception {
        sendMoneyVia_walletClass.sendMoneyMLWalletFullyVerifiedAccountMaxLimit_STW_TC_32();
    }

    @Test(priority = 28)
    public void sendMoneyToMLWalletSuccessMsgValidation_STW_TC_35() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletSuccessMsgValidation_STW_TC_35();
    }

    @Test(priority = 29)
    public void sendMoneyToMLWalletMaxTransactionReceivingLimitSemiVerifiedTier_STW_TC_36() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletMaxTransactionReceivingLimitSemiVerifiedTier_STW_TC_36("50000");
    }

    @Test(priority = 30)
    public void sendMoneyToMLWalletMaxTransactionReceivingLimitBranchVerifiedTier_STW_TC_38() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletMaxTransactionReceivingLimitBranchVerifiedTier_STW_TC_38("50000");
    }

    @Test(priority = 31)
    public void sendMoneyToMLWalletMaxTransactionReceivingLimitFullyVerifiedTier_STW_TC_40() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletMaxTransactionReceivingLimitFullyVerifiedTier_STW_TC_40("50000");
    }
    @Test(priority = 35)
    public void sendMoneyToMLWalletLocationPopupValidation_STW_TC_42() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletLocationPopupValidation_STW_TC_42();
    }

    @Test(priority = 36)
    public void sendMoneyToMLWalletLocationDenyFunctionality_STW_TC_43() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletLocationDenyFunctionality_STW_TC_43();
    }

    @Test(priority = 37)
    public void sendMoneyToMLWalletLocationPermissionDenyCloseBtnFunctionality_STW_TC_44() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletLocationPermissionDenyCloseBtnFunctionality_STW_TC_44();
    }

    @Test(priority = 38)
    public void sendMoneyToMLWalletLocationPermissionDenyOpenSettingsBtnFunctionality_STW_TC_45() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletLocationPermissionDenyOpenSettingsBtnFunctionality_STW_TC_45();
    }

    @Test(priority = 39)
    public void sendMoneyToMLWalletLocationPopUpAllowFunctionality_STW_TC_46() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletLocationPopUpAllowFunctionality_STW_TC_46();
    }

    @Test(priority = 40)
    public void sendMoneyToMLWalletInternetInterruptionWhileEnteringOTP_STW_TC_47() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletInternetInterruptionWhileEnteringOTP_STW_TC_47();
    }

    @Test(priority = 41)
    public void sendMoneyToMLWalletTransactionValidationAfterMinimizingApp_STW_TC_50() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletTransactionValidationAfterMinimizingApp_STW_TC_50();
    }


    @Test(priority = 42)
    public void sendMoneyToMLWalletTransactionWithValidMLPin_STW_TC_56() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletTransactionWithValidMLPin_STW_TC_56();
    }

    @Test(priority = 43)
    public void sendMoneyToMLWalletTransactionWithInValidMLPin_STW_TC_57() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletTransactionWithInValidMLPin_STW_TC_57();
    }

    @Test(priority = 44)
    public void sendMoneyToMLWalletInOTPPopupValidation_STW_TC_63() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletInOTPPopupValidation_STW_TC_63();
    }

    @Test(priority = 45)
    public void sendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_STW_TC_64() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletTransactionInAppOTPPopupUIValidation_STW_TC_64();
    }

    @Test(priority = 46)
    public void sendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_STW_TC_65() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletTransactionNewOTPAfterSixtySecondsValidation_STW_TC_65();
    }

    @Test(priority = 47)
    public void sendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_STW_TC_66() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletTransactionOTPCancelBtnFunctionality_STW_TC_66();
    }


    @Test(priority = 48)
    public void sendMoneyToMLWalletOTPContinueBtnFunctionality_STW_TC_67() throws Exception {
        sendMoneyVia_walletClass.sendMoneyToMLWalletOTPContinueBtnFunctionality_STW_TC_67();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }








}
