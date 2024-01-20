package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

public class MLWalletCashOutViaBank extends BaseTest{
    @Test(priority = 1)
    public void cashOutWithdrawBank_WM_TC_01() throws Exception
    {
        mlWalletCashOutViaBank.cashOutWithdrawBank_WM_TC_01("100");
    }

    @Test(priority = 2)
    public void cashOutWithInvalidAccNumber_WM_TC_02() throws Exception
    {
        mlWalletCashOutViaBank.cashOutWithInvalidAccNumber_WM_TC_02();
    }

    @Test(priority = 3)
    public void cashOutWithdrawBankMaxAmount_WM_TC_03() throws Exception
    {
        mlWalletCashOutViaBank.cashOutWithdrawBankMaxAmount_WM_TC_03("60000");
    }

    @Test(priority = 4)
    public void cashOutWithdrawMinTransactionLimit_WM_TC_04() throws Exception
    {
        mlWalletCashOutViaBank.cashOutWithdrawMinTransactionLimit_WM_TC_04("10");
    }

    @Test(priority = 9)
    public void cashOutInvalidBank_WM_TC_10() throws Exception {
        mlWalletCashOutViaBank.cashOutInvalidBank_WM_TC_10();
    }

    @Test(priority = 10)
    public void searchAndSelectBank_WM_TC_11() throws Exception {
        mlWalletCashOutViaBank.searchAndSelectBank_WM_TC_11();
    }

    @Test(priority = 11)
    public void cashOutInvalidAmount_WM_TC_12() throws Exception {
        mlWalletCashOutViaBank.cashOutInvalidAmount_WM_TC_12();
    }

    @Test(priority = 12)
    public void cashOutSaveRecipient_WM_TC_13() throws Exception {
        mlWalletCashOutViaBank.cashOutSaveRecipient_WM_TC_13("100");
    }

    @Test(priority = 13)
    public void cashOutRecipientDuplicate_WM_TC_14() throws Exception {
        mlWalletCashOutViaBank.cashOutRecipientDuplicate_WM_TC_14("100");
    }


    @Test(priority = 18)
    public void cashOutOTPPageUIValidation_WM_TC_20() throws Exception {
        mlWalletCashOutViaBank.cashOutOTPPageUIValidation_WM_TC_20("100");
    }

    @Test(priority = 19)
    public void cashOutOTPPageBackBtnValidation() throws Exception {
        mlWalletCashOutViaBank.cashOutOTPPageBackBtnValidation_WM_TC_21("100");
    }


    @Test(priority = 22)
    public void cashOutPendingTransactionValidation_WM_TC_24() throws Exception {
        mlWalletCashOutViaBank.cashOutPendingTransactionValidation_WM_TC_24("100");
    }


    @Test(priority = 23)
    public void cashOutMLBranchBuyerTier_WM_TC_27() throws Exception {
        mlWalletCashOutViaBank.cashOutMLBankBuyerTier_WM_TC_27("100");
    }


    @Test(priority = 24)
    public void cashOutSemiVerifiedTier_WM_TC_28() throws Exception {
        mlWalletCashOutViaBank.cashOutSemiVerifiedTier_WM_TC_28("100");
    }

    @Test(priority = 25)
    public void cashOutFullyVerifiedTier_WM_TC_29() throws Exception {
        mlWalletCashOutViaBank.cashOutFullyVerifiedTier_WM_TC_29("100");
    }


    @Test(priority = 28)
    public void cashOutMaxLimitSemiVerifiedTier_WM_TC_33() throws Exception {
        mlWalletCashOutViaBank.cashOutMaxLimitSemiVerifiedTier_WM_TC_33();
    }

    @Test(priority = 29)
    public void cashOutMaxLimitFullyVerifiedTier_WM_TC_36() throws Exception {
        mlWalletCashOutViaBank.cashOutMaxLimitFullyVerifiedTier_WM_TC_36();
    }

    @Test(priority = 32)
    public void cashOutWithDrawBankRequiredDetails_WM_TC_47() throws Exception {
        mlWalletCashOutViaBank.cashOutWithDrawBankRequiredDetails_WM_TC_47();
    }

    @Test(priority = 33)
    public void cashOutMiddleNameCheckBoxValidation_WM_TC_48() throws Exception {
        mlWalletCashOutViaBank.cashOutMiddleNameCheckBoxValidation_WM_TC_48();
    }

    @Test(priority = 34)
    public void cashOutBankPageUIValidation_WM_TC_49() throws Exception {
        mlWalletCashOutViaBank.cashOutBankPageUIValidation_WM_TC_49();
    }

    @Test(priority = 35)
    public void cashOutDragonPayPageUIValidation_WM_TC_50() throws Exception {
        mlWalletCashOutViaBank.cashOutDragonPayPageUIValidation_WM_TC_50();
    }

    @Test(priority = 36)
    public void cashOutBankReviewTransactionUIValidation_WM_TC_51() throws Exception {
        mlWalletCashOutViaBank.cashOutBankReviewTransactionUIValidation_WM_TC_51("100");
    }

    @Test(priority = 37)
    public void cashOutBankTransactionReceiptUIValidation_WM_TC_52() throws Exception {
        mlWalletCashOutViaBank.cashOutBankTransactionReceiptUIValidation_WM_TC_52();
    }

    @Test(priority = 38)
    public void cashOutRecentTransactionDetailsUIValidation_WM_TC_53() throws Exception {
        mlWalletCashOutViaBank.cashOutRecentTransactionDetailsUIValidation_WM_TC_53();
    }

    @Test(priority = 41)
    public void cahOutBankViewAllPageBackBtnValidation_WM_TC_56() throws Exception {
        mlWalletCashOutViaBank.cahOutBankViewAllPageBackBtnValidation_WM_TC_56();
    }

    @Test(priority = 42)
    public void cashOutBankSavedRecipientEditBackButton_WM_TC_57() throws Exception {
        mlWalletCashOutViaBank.cashOutBankSavedRecipientEditBackButton_WM_TC_57();
    }

    @Test(priority = 43)
    public void cashOutBankEditRecipient_WM_TC_58() throws Exception {
        mlWalletCashOutViaBank.cashOutBankEditRecipient_WM_TC_58();
    }

    @Test(priority = 44)
    public void cashOutBankDeleteRecipient_WM_TC_59() throws Exception {
        mlWalletCashOutViaBank.cashOutBankDeleteRecipient_WM_TC_59();
    }

    @Test(priority = 47)
    public void cashOutBankBackHomeBtnValidation_WM_TC_62() throws Exception {
        mlWalletCashOutViaBank.cashOutBankBackHomeBtnValidation_WM_TC_62();
    }

    @Test(priority = 48)
    public void cashOutBankNewTransactionBtnValidation_WM_TC_63() throws Exception {
        mlWalletCashOutViaBank.cashOutBankNewTransactionBtnValidation_WM_TC_63();
    }

    @Test(priority = 49)
    public void cashOutBankDragonPayMessageValidation_WM_TC_64() throws Exception {
        mlWalletCashOutViaBank.cashOutBankDragonPayMessageValidation_WM_TC_64("100");
    }

    @Test(priority = 50)
    public void cashOutBankReviewTransactionTotalAmountValidation_WM_TC_65() throws Exception {
        mlWalletCashOutViaBank.cashOutBankReviewTransactionTotalAmountValidation_WM_TC_65("100",35);
    }

    @Test(priority = 51)
    public void cashOutBankLocationPopupValidation_WM_TC_69() throws Exception {
        mlWalletCashOutViaBank.cashOutBankLocationPopupValidation_WM_TC_69("100");
    }

    @Test(priority = 52)
    public void cashOutBankLocationDenyFunctionality_WM_TC_70() throws Exception {
        mlWalletCashOutViaBank.cashOutBankLocationDenyFunctionality_WM_TC_70("100");
    }
    @Test(priority = 53)
    public void cashOutBankLocationPermissionDenyCloseBtnFunctionality_WM_TC_71() throws Exception {
        mlWalletCashOutViaBank.cashOutBankLocationPermissionDenyCloseBtnFunctionality_WM_TC_71("100");
    }

    @Test(priority = 54)
    public void cashOutBankLocationPermissionDenyOpenSettingsBtnFunctionality_WM_TC_72() throws Exception {
        mlWalletCashOutViaBank.cashOutBankLocationPermissionDenyOpenSettingsBtnFunctionality_WM_TC_72("100");
    }

    @Test(priority = 55)
    public void cashOutBankLocationPopUpAllowFunctionality_WM_TC_73() throws Exception {
        mlWalletCashOutViaBank.cashOutBankLocationPopUpAllowFunctionality_WM_TC_73("100");
    }


    @Test(priority = 63)
    public void cashOutBankTransactionValidationAfterMinimizingApp_WM_TC_83() throws Exception {
        mlWalletCashOutViaBank.cashOutBankTransactionValidationAfterMinimizingApp_WM_TC_83("100");
    }


    @Test(priority = 66)
    public void cashOutBankAmountFieldValidation_WM_TC_97() throws Exception {
        mlWalletCashOutViaBank.cashOutBankAmountFieldValidation_WM_TC_97("100.123");
    }

    @Test(priority = 68)
    public void cashOutBankTransactionWithValidMLPin_WM_TC_99() throws Exception {
        mlWalletCashOutViaBank.cashOutBankTransactionWithValidMLPin_WM_TC_99("100");
    }

    @Test(priority = 77)
    public void cashOutBankInAppOTPPopupValidation_WM_TC_119() throws Exception {
        mlWalletCashOutViaBank.cashOutBankInAppOTPPopupValidation_WM_TC_119("100");
    }

    @Test(priority = 78)
    public void cashOutBankTransactionInAppOTPPopupUIValidation_WM_TC_120() throws Exception {
        mlWalletCashOutViaBank.cashOutBankTransactionInAppOTPPopupUIValidation_WM_TC_120("100");
    }

    @Test(priority = 79)
    public void cashOutBankTransactionNewOTPAfterSixtySecondsValidation_WM_TC_121() throws Exception {
        mlWalletCashOutViaBank.cashOutBankTransactionNewOTPAfterSixtySecondsValidation_WM_TC_121("100");
    }

    @Test(priority = 80)
    public void cashOutBankTransactionOTPCancelBtnFunctionality_WM_TC_122() throws Exception {
        mlWalletCashOutViaBank.cashOutBankTransactionOTPCancelBtnFunctionality_WM_TC_122("100");
    }
    @Test(priority = 81)
    public void cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123() throws Exception {
        mlWalletCashOutViaBank.cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123("100");
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }


}
