package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.*;
public class MLWalletCashInViaBankScripts extends BaseTest{

    @Test(priority = 1)
    public void cashInViaBank() throws Exception {
        mlWalletCashInViaBank.cashInViaBank_CIBA_TC_01();
    }

    @Test(priority = 2)
    public void cashInViaBankMinimumTransactionLimit() throws Exception {
        mlWalletCashInViaBank.cashInViaBankMinimumTransactionLimit_CIBA_TC_05();
    }

    @Test(priority = 3)
    public void cashInViaBankMaximumTransaction() throws Exception {
        mlWalletCashInViaBank.cashInViaBankMaximumTransaction_CIBA_TC_04();
    }


//=========================================================================================================//

    @Test(priority = 4)
    public void cashInViaBankInvalidAmount() throws Exception {
        mlWalletCashInViaBank.cashInViaBankInvalidAmount_STW_TC_03();
    }

    @Test(priority = 5)
    public void cashInViaBankNavigation_STW_TC_06() throws Exception {
        mlWalletCashInViaBank.cashInViaBankNavigation_STW_TC_06();
    }

    @Test(priority = 6)
    public void cashInUIValidation_STW_TC_07() throws Exception {
        mlWalletCashInViaBank.cashInUIValidation_STW_TC_07();
    }

    @Test(priority = 7)
    public void cashInPageBackArrowBtnValidation_STW_TC_08() throws Exception {
        mlWalletCashInViaBank.cashInPageBackArrowBtnValidation_STW_TC_08();
    }

    @Test(priority = 8)
    public void cashInSelectBankPageUIValidation_STW_TC_09() throws Exception {
        mlWalletCashInViaBank.cashInSelectBankPageUIValidation_STW_TC_09();
    }

    @Test(priority = 9)
    public void cashInViaBankSearchInvalidBank_STW_TC_10() throws Exception {
        mlWalletCashInViaBank.cashInViaBankSearchInvalidBank_STW_TC_10();
    }

    @Test(priority = 10)
    public void cashInViaBankSelectBankPageBackBtnValidation_STW_TC_11() throws Exception {
        mlWalletCashInViaBank.cashInViaBankSelectBankPageBackBtnValidation_STW_TC_11();
    }

    @Test(priority = 11)
    public void cashInViaBankDragonPayPageUIValidation_STW_TC_12() throws Exception {
        mlWalletCashInViaBank.cashInViaBankDragonPayPageUIValidation_STW_TC_12();
    }

    @Test(priority = 12)
    public void cashInViaBankDragonPayBackBtnValidation_STW_TC_13() throws Exception {
        mlWalletCashInViaBank.cashInViaBankDragonPayBackBtnValidation_STW_TC_13();
    }

    @Test(priority = 13)
    public void cashInViaBankReviewTransactionPageUIValidation_STW_TC_14() throws Exception {
        mlWalletCashInViaBank.cashInViaBankReviewTransactionPageUIValidation_STW_TC_14();
    }

    @Test(priority = 14)
    public void cashInViaBankReviewTransactionBackBtnValidation_STW_TC_15() throws Exception {
        mlWalletCashInViaBank.cashInViaBankReviewTransactionBackBtnValidation_STW_TC_15();
    }

    @Test(priority = 15)
    public void cashInViaBankStatusTransaction_CIBA_TC_16() throws Exception {
        mlWalletCashInViaBank.cashInViaBankStatusTransaction_CIBA_TC_16();
    }

    @Test(priority = 16)
    public void cashInViaBankPendingTransaction_CIBA_TC_17() throws Exception {
        mlWalletCashInViaBank.cashInViaBankPendingTransaction_CIBA_TC_17();
    }

    @Test(priority = 17)
    public void cashInViaBankWithExistingPendingTransaction_CIBA_TC_20() throws Exception {
        mlWalletCashInViaBank.cashInViaBankWithExistingPendingTransaction_CIBA_TC_20();
    }

    @Test(priority = 18)
    public void cancelButtonValidationInDragonPayPopUp_CIBA_TC_21() throws Exception {
        mlWalletCashInViaBank.cancelButtonValidationInDragonPayPopUp_CIBA_TC_21();
    }


    @Test(priority = 19)
    public void cashInViaBankTappingOutsideTheDragonPayPopupValidation_CIBA_TC_22() throws Exception {
        mlWalletCashInViaBank.cashInViaBankTappingOutsideTheDragonPayPopupValidation_CIBA_TC_22();
    }


    @Test(priority = 20)
    public void cashInViaBankInvalidAmountFieldValidation_CIBA_TC_23() throws Exception {
        mlWalletCashInViaBank.cashInViaBankInvalidAmountFieldValidation_CIBA_TC_23();
    }

    @Test(priority = 21)
    public void cashInViaBankBuyerTierLevel_CIBA_TC_24() throws Exception {
        mlWalletCashInViaBank.cashInViaBankBuyerTierLevel_CIBA_TC_24();
    }

    @Test(priority = 22)
    public void cashInViaBankSemiVerifiedTierStatusTransaction_STW_TC_25() throws Exception {
        mlWalletCashInViaBank.cashInViaBankSemiVerifiedTierStatusTransaction_CIBA_TC_25();
    }

    @Test(priority = 23)
    public void cashInViaBankFullyVerifiedTierStatusTransaction_CIBA_TC_26() throws Exception {
        mlWalletCashInViaBank.cashInViaBankFullyVerifiedTierStatusTransaction_CIBA_TC_26();
    }


    @Test(priority = 24)
    public void cashInViaBankSemiVerifiedUserMaxLimit_CIBA_TC_27() throws Exception {
        mlWalletCashInViaBank.cashInViaBankSemiVerifiedUserMaxLimit_CIBA_TC_27();
    }

    @Test(priority = 25)
    public void cashInViaBankFullyVerifiedUserMaxLimit_CIBA_TC_28() throws Exception {
        mlWalletCashInViaBank.cashInViaBankFullyVerifiedUserMaxLimit_CIBA_TC_28();
    }

    @Test(priority = 26)
    public void cashInViaBankTransactionDetailsPageUIValidation_CIBA_TC_29() throws Exception {
        mlWalletCashInViaBank.cashInViaBankTransactionDetailsPageUIValidation_CIBA_TC_29();
    }


    @Test(priority = 27)
    public void cashInViaBankDragonPayChagresPopUpValidation_CIBA_TC_32() throws Exception {
        mlWalletCashInViaBank.cashInViaBankDragonPayChagresPopUpValidation_CIBA_TC_32();
    }

    @Test(priority = 28)
    public void cashInViaBankLocationPopupValidation_CIBA_TC_35() throws Exception {
        mlWalletCashInViaBank.cashInViaBankLocationPopupValidation_CIBA_TC_35();
    }

    @Test(priority = 29)
    public void cashInViaBankLocationDenyFunctionality_CIBA_TC_36() throws Exception {
        mlWalletCashInViaBank.cashInViaBankLocationDenyFunctionality_CIBA_TC_36();
    }

    @Test(priority = 30)
    public void cashInViaBankLocationPermissionDenyCloseBtnFunctionality_CIBA_TC_37() throws Exception {
        mlWalletCashInViaBank.cashInViaBankLocationPermissionDenyCloseBtnFunctionality_CIBA_TC_37();
    }

    @Test(priority = 31)
    public void cashInViaBankLocationPermissionDenyOpenSettingsBtnFunctionality_CIBA_TC_38() throws Exception {
        mlWalletCashInViaBank.cashInViaBankLocationPermissionDenyOpenSettingsBtnFunctionality_CIBA_TC_38();
    }

    @Test(priority = 32)
    public void cashInViaBankLocationPopUpAllowFunctionality_CIBA_TC_39() throws Exception {
        mlWalletCashInViaBank.cashInViaBankLocationPopUpAllowFunctionality_CIBA_TC_39();
    }

//    @Test(priority = 33)
//    public void cashInViaBankInternetInterruptionWhileEnteringOTP_CIBA_TC_40() throws Exception {
//        mlWalletCashInViaBank.cashInViaBankInternetInterruptionWhileEnteringOTP_CIBA_TC_40();
//    }

    @Test(priority = 34)
    public void cashInViaBankTransactionValidationAfterMinimizingApp_CIBA_TC_43() throws Exception {
        mlWalletCashInViaBank.cashInViaBankTransactionValidationAfterMinimizingApp_CIBA_TC_43();
    }

    @Test(priority = 35)
    public void cashInViaBankAmountFieldValidation_CIBA_TC_49() throws Exception {
        mlWalletCashInViaBank.cashInViaBankAmountFieldValidation_CIBA_TC_49();
    }

    @Test(priority = 36)
    public void cashInViaBankTransactionWithValidMLPin_CIBA_TC_50() throws Exception {
        mlWalletCashInViaBank.cashInViaBankTransactionWithValidMLPin_CIBA_TC_50();
    }

    @Test(priority = 37)
    public void cashInViaBankTransactionWithInValidMLPin_CIBA_TC_51() throws Exception {
        mlWalletCashInViaBank.cashInViaBankTransactionWithInValidMLPin_CIBA_TC_51();
    }

    @Test(priority = 38)
    public void cashInViaBankOTPPopupValidation_CIBA_TC_57() throws Exception {
        mlWalletCashInViaBank.cashInViaBankOTPPopupValidation_CIBA_TC_57();
    }

    @Test(priority = 39)
    public void cashInViaBankTransactionInAppOTPPopupUIValidation_CIBA_TC_58() throws Exception {
        mlWalletCashInViaBank.cashInViaBankTransactionInAppOTPPopupUIValidation_CIBA_TC_58();
    }

    @Test(priority = 40)
    public void cashInViaBankTransactionNewOTPAfterSixtySecondsValidation_CIBA_TC_59() throws Exception {
        mlWalletCashInViaBank.cashInViaBankTransactionNewOTPAfterSixtySecondsValidation_CIBA_TC_59();
    }

    @Test(priority = 41)
    public void cashInViaBankTransactionOTPCancelBtnFunctionality_CIBA_TC_60() throws Exception {
        mlWalletCashInViaBank.cashInViaBankTransactionOTPCancelBtnFunctionality_CIBA_TC_60();
    }

    @Test(priority = 42)
    public void cashInViaBankOTPContinueBtnFunctionality_CIBA_TC_61() throws Exception {
        mlWalletCashInViaBank.cashInViaBankOTPContinueBtnFunctionality_CIBA_TC_61();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
