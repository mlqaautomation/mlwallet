package com.mlwallet.regression;


import com.driverInstance.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletCashOutViaBranch extends BaseTest{

    @Test(priority = 1)
    public void cashOutWithdrawBranch_WM_TC_05() throws Exception
    {
        mlWalletCashOutViaBranch.cashOutWithdrawBranch_WM_TC_05();
    }

    @Test(priority = 2)
    public void cashOutMaxLimit_WM_TC_06() throws Exception
    {
        mlWalletCashOutViaBranch.cashOutMaxLimit_WM_TC_06();
    }

    @Test(priority = 3)
    public void cashOutInsufficientBalance_WM_TC_07() throws Exception {
        mlWalletCashOutViaBranch.cashOutInsufficientBalance_WM_TC_07();
    }

    @Test(priority = 4)
    public void cashOutBuyerTierLevelAcc_WM_TC_09() throws Exception
    {
        mlWalletCashOutViaBranch.cashOutBuyerTierLevelAcc_WM_TC_09();
    }

    @Test(priority = 5)
    public void cashOutUIValidation_WM_TC_16() throws Exception {
        mlWalletCashOutViaBranch.cashOutUIValidation_WM_TC_16();
    }

    @Test(priority = 6)
    public void cashOutWithdrawBackBtnValidation_WM_TC_17() throws Exception {
        mlWalletCashOutViaBranch.cashOutWithdrawBackBtnValidation_WM_TC_17();
    }

    @Test(priority = 7)
    public void cashOutToBranchUIValidation_WM_TC_18() throws Exception {
        mlWalletCashOutViaBranch.cashOutToBranchUIValidation_WM_TC_18();
    }

    @Test(priority = 8)
    public void cashOutToBranchBackBtnValidation_WM_TC_19 () throws Exception {
        mlWalletCashOutViaBranch.cashOutToBranchBackBtnValidation_WM_TC_19();
    }
    @Test(priority = 9)
    public void cashOutMlBranchQRPageUIValidation_WM_TC_22() throws Exception {
        mlWalletCashOutViaBranch.cashOutMlBranchQRPageUIValidation_WM_TC_22();
    }

    @Test(priority = 10)
    public void cashOutCancelIconValidation_WM_TC_23() throws Exception {
        mlWalletCashOutViaBranch.cashOutCancelIconValidation_WM_TC_23();
    }
    @Test(priority = 11)
    public void cashOutMLBranchSemiVerifiedTier_WM_TC_31() throws Exception {
            mlWalletCashOutViaBranch.cashOutMLBranchSemiVerifiedTier_WM_TC_31();
    }

    @Test(priority = 12)
    public void cashOutMLBranchFullyVerifiedTier_WM_TC_32() throws Exception {
        mlWalletCashOutViaBranch.cashOutMLBranchFullyVerifiedTier_WM_TC_32();
    }
    @Test(priority = 13)
    public void cashOutMLBranchMaxLimitSemiVerifiedTier_WM_TC_39() throws Exception {
        mlWalletCashOutViaBranch.cashOutMLBranchMaxLimitSemiVerifiedTier_WM_TC_39();
    }

    @Test(priority = 14)
    public void cashOutMLBranchMaxLimitFullyVerifiedTier_WM_TC_42() throws Exception {
        mlWalletCashOutViaBranch.cashOutMLBranchMaxLimitFullyVerifiedTier_WM_TC_42();
    }
    @Test(priority = 15)
    public void cashOutMLBranchBackToHomeBtnValidation_WM_TC_54() throws Exception {
        mlWalletCashOutViaBranch.cashOutMLBranchBackToHomeBtnValidation_WM_TC_54();
    }

    @Test(priority = 16)
    public void cashOutMLBranchNewTransactionBtnValidation_WM_TC_55() throws Exception {
        mlWalletCashOutViaBranch.cashOutMLBranchNewTransactionBtnValidation_WM_TC_55();
    }
    @Test(priority = 17)
    public void cashOutMLBranchOTPPageUiValidation_WM_TC_60() throws Exception {
        mlWalletCashOutViaBranch.cashOutMLBranchOTPPageUiValidation_WM_TC_60();
    }

    @Test(priority = 18)
    public void cashOutMLBranchTransactionDetailsUIValidation_WM_TC_61() throws Exception {
        mlWalletCashOutViaBranch.cashOutMLBranchTransactionDetailsUIValidation_WM_TC_61();
    }
    @Test(priority = 19)
    public void cashOutBranchLocationPopupValidation_WM_TC_74() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchLocationPopupValidation_WM_TC_74("10");
    }

    @Test(priority = 20)
    public void cashOutBranchLocationDenyFunctionality_WM_TC_75() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchLocationDenyFunctionality_WM_TC_75("10");
    }

    @Test(priority = 21)
    public void cashOutBranchLocationPermissionDenyCloseBtnFunctionality_WM_TC_76() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchLocationPermissionDenyCloseBtnFunctionality_WM_TC_76("10");
    }

    @Test(priority = 22)
    public void cashOutBranchLocationPermissionDenyOpenSettingsBtnFunctionality_WM_TC_77() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchLocationPermissionDenyOpenSettingsBtnFunctionality_WM_TC_77("10");
    }

    @Test(priority = 23)
    public void cashOutBranchLocationPopUpAllowFunctionality_WM_TC_78() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchLocationPopUpAllowFunctionality_WM_TC_78("10");
    }
//    @Test(priority = 24)
//    public void cashOutBranchInternetInterruptionWhileEnteringOTP_WM_TC_80() throws Exception {
//        mlWalletCashOutViaBranch.cashOutBranchInternetInterruptionWhileEnteringOTP_WM_TC_80("10");
//    }
    @Test(priority = 25)
    public void cashOutBranchTransactionValidationAfterMinimizingApp_WM_TC_91() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchTransactionValidationAfterMinimizingApp_WM_TC_91();
    }

    @Test(priority = 26)
    public void cashOutBranchMaximumTransactionBranchVerifiedTier_WM_TC_08() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchMaximumTransactionBranchVerifiedTier_WM_TC_08();
    }  @Test(priority = 27)
    public void cashOutBranchAmountFieldValidation_WM_TC_98() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchAmountFieldValidation_WM_TC_98("100.123");
    }@Test(priority = 28)
    public void cashOutBranchTransactionWithValidMLPin_WM_TC_100() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchTransactionWithInValidMLPin_WM_TC_100("100");
    }

    @Test(priority = 29)
    public void cashOutBranchTransactionWithValidMLPin_WM_TC_106() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchTransactionWithValidMLPin_WM_TC_106();
    }

    @Test(priority = 30)
    public void cashOutBranchTransactionWithInValidMLPin_WM_TC_107() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchTransactionWithInValidMLPin_WM_TC_107();
    }

    @Test(priority = 31)
    public void cashOutBranchInAppOTPPopupValidation_WM_TC_113() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchInAppOTPPopupValidation_WM_TC_113();
    }

    @Test(priority = 32)
    public void cashOutBranchTransactionInAppOTPPopupUIValidation_WM_TC_114() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchTransactionInAppOTPPopupUIValidation_WM_TC_114();
    }

    @Test(priority = 33)
    public void cashOutBranchTransactionNewOTPAfterSixtySecondsValidation_WM_TC_115() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchTransactionNewOTPAfterSixtySecondsValidation_WM_TC_115();
    }

    @Test(priority = 34)
    public void cashOutBranchTransactionOTPCancelBtnFunctionality_WM_TC_116() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchTransactionOTPCancelBtnFunctionality_WM_TC_116();
    }

    @Test(priority = 35)
    public void cashOutBranchTransactionOTPContinueBtnFunctionality_WM_TC_117() throws Exception {
        mlWalletCashOutViaBranch.cashOutBranchTransactionOTPContinueBtnFunctionality_WM_TC_117();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
