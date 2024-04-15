package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

public class MLWalletSendTransferToAnyMLBranchScripts extends BaseTest{
    
    @Test(priority = 1)
    public void sendMoneyToMLBranch_STB_TC_01() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranch_STB_TC_01();
    }

    @Test(priority = 2)
    public void sendMoneyAddRecipient_STB_TC_03() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyAddRecipient_STB_TC_03();
    }

    @Test(priority = 3)
    public void sendMoneyContactDuplicate_STB_TC_04() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyContactDuplicate_STB_TC_04();
    }

    @Test(priority = 4)
    public void kwartaPadalaViaBranchSuccessfulTransaction_STB_TC_02() throws Exception {
        mlWalletSendMoneyViaBranch.kwartaPadalaViaBranchSuccessfulTransaction_STB_TC_02();
    }

    @Test(priority = 5)
    public void sendMoneyEditRecipient_STB_TC_06() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyEditRecipient_STB_TC_06();
    }

    @Test(priority = 6)
    public void sendMoneyDeleteRecipient_STB_TC_05() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyDeleteRecipient_STB_TC_05();
    }

    @Test(priority = 7)
    public void sendMoneyInvalidAmount_STB_TC_09() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyInvalidAmount_STB_TC_09("0");
    }

    @Test(priority = 8)
    public void sendMoneyInsufficientAmount_STB_TC_10() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyInsufficientAmount_STB_TC_10();
    }

    @Test(priority = 9)
    public void sendMoneyMaximumAmount_STB_TC_12() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyMaximumAmount_STB_TC_12();
    }

    @Test(priority = 10)
    public void sendMoneyRequiredDetails_STB_TC_08() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyRequiredDetails_STB_TC_08();
    }

    @Test(priority = 11)
    public void sendMoneyInvalidDetails_STB_TC_07() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyInvalidDetails_STB_TC_07();
    }


    //========================================================================================================//
    @Test(priority = 12)
    public void sendTransferUIValidation_STB_TC_13() throws Exception {
        mlWalletSendMoneyViaBranch.sendTransferUIValidation_STB_TC_13();
    }


    @Test(priority = 13)
    public void sendMoneyToBranchUIValidation_STB_TC_14() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToBranchUIValidation_STB_TC_14();
    }

    @Test(priority = 14)
    public void sendMoneyToBranchSaveRecipientPageUIValidation_STB_TC_15() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToBranchSaveRecipientPageUIValidation_STB_TC_15();
    }

    @Test(priority = 15)
    public void sendMoneyToBranchSuccessUIValidation_STB_TC_16() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToBranchSuccessUIValidation_STB_TC_16();
    }

    @Test(priority = 16)
    public void sendMoneyToBranchConfirmDetailsPageUIValidation_STB_TC_17() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToBranchConfirmDetailsPageUIValidation_STB_TC_17("100");
    }

    @Test(priority = 17)
    public void sendMoneyToBranchSelectPaymentMethodPageUIValidation_STB_TC_18() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToBranchSelectPaymentMethodPageUIValidation_STB_TC_18("100");
    }

    @Test(priority = 18)
    public void sendMoneyToBranchEnterAmountPageUIValidation_STB_TC_19() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToBranchEnterAmountPageUIValidation_STB_TC_19();
    }

    @Test(priority = 19)
    public void kwartaPadalaTransactionDetailsUIValidation_STB_TC_20() throws Exception {
        mlWalletSendMoneyViaBranch.kwartaPadalaTransactionDetailsUIValidation_STB_TC_20();
    }

    @Test(priority = 20)
    public void sendMoneyToBranchAddRecipientPageUIValidation_STB_TC_21() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToBranchAddRecipientPageUIValidation_STB_TC_21();
    }
//====================================================================================
    @Test(priority = 21)
    public void sendMoneyToMLBranchBuyerTierAccount_STB_TC_22() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchBuyerTierAccount_STB_TC_22();
    }

    @Test(priority = 22)
    public void sendMoneyToMLBranchSemiVerifiedTierAccount_STB_TC_23() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchSemiVerifiedTierAccount_STB_TC_23();
    }

    @Test(priority = 23)
    public void sendMoneyToMLBranchBranchVerifiedAccount_STB_TC_24() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchBranchVerifiedAccount_STB_TC_24();
    }

    @Test(priority = 24)
    public void sendMoneyToMLBranchFullyVerifiedAccount_STB_TC_25() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchFullyVerifiedAccount_STB_TC_25();
    }

    @Test(priority = 25)
    public void sendMoneyToMLBranchSemiVerifiedTierAccountMaxAmount_STB_TC_26() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchSemiVerifiedTierAccountMaxAmount_STB_TC_26();
    }

    @Test(priority = 26)
    public void sendMoneyToMLBranchBranchVerifiedTierAccountMaxAmount_STB_TC_29() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchBranchVerifiedTierAccountMaxAmount_STB_TC_29();
    }

    @Test(priority = 27)
    public void sendMoneyToMLBranchFullyVerifiedTierAccountMaxAmount_STB_TC_32() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchFullyVerifiedTierAccountMaxAmount_STB_TC_32();
    }

    @Test(priority = 28)
    public void kwartaPadalaRates_STB_TC_35() throws Exception {
        mlWalletSendMoneyViaBranch.kwartaPadalaRates_STB_TC_35();
    }

    @Test(priority = 29)
    public void sendMoneyToMLBranchRatesValidationScenarioOne_STB_TC_36() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioOne_STB_TC_36("10");
    }

    @Test(priority = 30)
    public void sendMoneyToMLBranchRatesValidationScenarioTwo_STB_TC_37() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioTwo_STB_TC_37("70");
    }

    @Test(priority = 31)
    public void sendMoneyToMLBranchRatesValidationScenarioThree_STB_TC_38() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioThree_STB_TC_38("200");
    }

    @Test(priority = 32)
    public void sendMoneyToMLBranchRatesValidationScenarioFour_STB_TC_39() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioFour_STB_TC_39("350");
    }

    @Test(priority = 33)
    public void sendMoneyToMLBranchRatesValidationScenarioFive_STB_TC_40() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioFive_STB_TC_40("450");
    }

    @Test(priority = 34)
    public void sendMoneyToMLBranchRatesValidationScenarioSix_STB_TC_41() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioSix_STB_TC_41("550");
    }


    @Test(priority = 35)
    public void sendMoneyToMLBranchRatesValidationScenarioSeven_STB_TC_42() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioSeven_STB_TC_42("650");
    }

    @Test(priority = 36)
    public void sendMoneyToMLBranchRatesValidationScenarioEight_STB_TC_43() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioEight_STB_TC_43("800");
    }

    @Test(priority = 37)
    public void sendMoneyToMLBranchRatesValidationScenarioNine_STB_TC_44() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioNine_STB_TC_44("950");
    }

    @Test(priority = 38)
    public void sendMoneyToMLBranchRatesValidationScenarioTen_STB_TC_45() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioTen_STB_TC_45("1300");
    }

    @Test(priority = 39)
    public void sendMoneyToMLBranchRatesValidationScenarioEleven_STB_TC_46() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioEleven_STB_TC_46("1800");
    }

    @Test(priority = 40)
    public void sendMoneyToMLBranchRatesValidationScenarioTwelve_STB_TC_47() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioTwelve_STB_TC_47("2300");
    }

    @Test(priority = 41)
    public void sendMoneyToMLBranchRatesValidationScenarioThirteen_STB_TC_48() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchRatesValidationScenarioThirteen_STB_TC_48("25000");
    }

    @Test(priority = 42)
    public void sendMoneyToMLBranchLocationPopupValidation_STB_TC_50() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchLocationPopupValidation_STB_TC_50();
    }

    @Test(priority = 43)
    public void sendMoneyToMLBranchLocationDenyFunctionality_STB_TC_51() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchLocationDenyFunctionality_STB_TC_51();
    }

    @Test(priority = 44)
    public void sendMoneyToMLBranchLocationPermissionDenyCloseBtnFunctionality_STB_TC_52() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchLocationPermissionDenyCloseBtnFunctionality_STB_TC_52();
    }

    @Test(priority = 45)
    public void sendMoneyToMLBranchLocationPermissionDenyOpenSettingsBtnFunctionality_STB_TC_53() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchLocationPermissionDenyOpenSettingsBtnFunctionality_STB_TC_53();
    }

    @Test(priority = 46)
    public void sendMoneyToMLBranchLocationPopUpAllowFunctionality_STB_TC_54() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchLocationPopUpAllowFunctionality_STB_TC_54();
    }

//    @Test(priority = 47)
//    public void sendMoneyToMLBranchInternetInterruptionWhileEnteringOTP_STB_TC_55() throws Exception {
//        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchInternetInterruptionWhileEnteringOTP_STB_TC_55();
//    }

    @Test(priority = 48)
    public void sendMoneyToMLBranchTransactionValidationAfterMinimizingApp_STB_TC_58() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchTransactionValidationAfterMinimizingApp_STB_TC_58();
    }

    @Test(priority = 49)
    public void sendMoneyToMLBranchTransactionWithValidMLPin_STB_TC_64() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchTransactionWithValidMLPin_STB_TC_64();
    }

    @Test(priority = 50)
    public void sendMoneyToMLBranchTransactionWithInValidMLPin_STB_TC_65() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchTransactionWithInValidMLPin_STB_TC_65();
    }

    @Test(priority = 51)
    public void sendMoneyToMLBranchInOTPPopupValidation_STB_TC_71() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchInOTPPopupValidation_STB_TC_71();
    }

    @Test(priority = 52)
    public void sendMoneyToMLBranchTransactionInAppOTPPopupUIValidation_STB_TC_72() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchTransactionInAppOTPPopupUIValidation_STB_TC_72();
    }

    @Test(priority = 53)
    public void sendMoneyToMLBranchTransactionNewOTPAfterSixtySecondsValidation_STB_TC_73() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchTransactionNewOTPAfterSixtySecondsValidation_STB_TC_73();
    }

    @Test(priority = 54)
    public void sendMoneyToMLBranchTransactionOTPCancelBtnFunctionality_STB_TC_74() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchTransactionOTPCancelBtnFunctionality_STB_TC_74();
    }

    @Test(priority = 55)
    public void sendMoneyToMLBranchOTPContinueBtnFunctionality_STB_TC_75() throws Exception {
        mlWalletSendMoneyViaBranch.sendMoneyToMLBranchTransactionOTPContinueBtnFunctionality_STB_TC_75();
    }



    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }




}