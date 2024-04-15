package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

public class MLWalletCashInViaBranch extends BaseTest{

    @Test(priority = 1)
    public void cashInviaBranch_ValidAmount_Scenario_CIBR_TC_01() throws Exception
    {
        mlWalletCashInViaBranch.cashInviaBranch_ValidAmount_Scenario_CIBR_TC_01();
    }

    @Test(priority = 2)
    public void cashInViaBranchCancelTransactionScenario_CIBR_TC_02() throws Exception
    {
        mlWalletCashInViaBranch.cashInViaBranchCancelTransactionScenario_CIBR_TC_02();
    }

    @Test(priority = 3)
    public void cashInviaBranch_Invalid_Amount_CIBR_TC_03() throws Exception
    {
        mlWalletCashInViaBranch.cashInviaBranch_Invalid_Amount_CIBR_TC_03();
    }

    @Test(priority = 4)
    public void cashInViaBranch_Maximum_Limit_Amount_CIBR_TC_04() throws Exception
    {
        mlWalletCashInViaBranch.cashInViaBranch_Maximum_Limit_Amount_CIBR_TC_04();
    }


//============================================================================================================//


    @Test(priority = 5)
    public void cashInViaBRanchInvalidAmount_CIBR_TC_05() throws Exception {
        mlWalletCashInViaBranch.cashInViaBRanchInvalidAmount_CIBR_TC_05();
    }

    @Test(priority = 6)
    public void cashInViaBranchUIValidation_CIBR_TC_06() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchUIValidation_CIBR_TC_06();
    }

    @Test(priority = 7)
    public void cashInViaBranchBackBtnValidation_CIBR_TC_07() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchBackBtnValidation_CIBR_TC_07();
    }

    @Test(priority = 8)
    public void cashInViaBranchNavigationToHomePageFromQRPage_CIBR_TC_08() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchNavigationToHomePageFromQRPage_CIBR_TC_08();
    }

    @Test(priority = 9)
    public void cashInViaBranchQRCodePageUIValidation_CIBR_TC_09() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchQRCodePageUIValidation_CIBR_TC_09();
    }

    @Test(priority = 10)
    public void cashInViaBranchPendingTransaction_CIBR_TC_11() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchPendingTransaction_CIBR_TC_11();
    }

    @Test(priority = 11)
    public void cashInViaBranchCancelBtnValidationOnCashInConfirmPopUp_CIBR_TC_12() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchCancelBtnValidationOnCashInConfirmPopUp_CIBR_TC_12();
    }

    @Test(priority = 12)
    public void cashInViaBranchTappingOutsideTheCashInConfirmationPopUp_CIBR_TC_13() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchTappingOutsideTheCashInConfirmationPopUp_CIBR_TC_13("100");
    }

    @Test(priority = 13)
    public void cashInViaBranchGoBackBtnValidationOnCashInConfirmPopUp_CIBR_TC_14() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchGoBackBtnValidationOnCashInConfirmPopUp_CIBR_TC_14();
    }

    @Test(priority = 14)
    public void cashInViaBankTappingOutsideTheCancelTransactionConfirmationPopup_CIBR_TC_15() throws Exception {
        mlWalletCashInViaBranch.cashInViaBankTappingOutsideTheCancelTransactionConfirmationPopup_CIBR_TC_15();
    }

    @Test(priority = 15)
    public void cashInViaBranchMaxTransactionBuyerTierUser_CIBR_TC_19() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchMaxTransactionBuyerTierUser_CIBR_TC_19();
    }

    @Test(priority = 16)
     public void cashInViaBranchSuccessfulTransaction_CIBR_TC_16() throws Exception {
     mlWalletCashInViaBranch.cashInViaBranchSuccessfulTransaction_CIBR_TC_16();
}


    @Test(priority = 17)
    public void cashInViaBranchMaxTransactionSemiVerifiedTierUser_CIBR_TC_20() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchMaxTransactionSemiVerifiedTierUser_CIBR_TC_20();
    }

    @Test(priority = 18)
    public void cashInViaBranchSemiVerifiedTierUser_CIBR_TC_17() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchSemiVerifiedTierUser_CIBR_TC_17();
    }

    @Test(priority = 19)
    public void cashInViaBranchMaxTransactionFullyVerifiedTierUser_CIBR_TC_21() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchMaxTransactionFullyVerifiedTierUser_CIBR_TC_21();
    }

    @Test(priority = 20)
    public void cashInViaBranchFullyVerifiedTierUser_CIBR_TC_18() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchFullyVerifiedTierUser_CIBR_TC_18();
    }

    @Test(priority = 21)
    public void cashInViaBranchTransactionDetailsUIValidation_CIBR_TC_22() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchTransactionDetailsUIValidation_CIBR_TC_22();
    }


    @Test(priority = 22)
    public void cashInViaBranchTransactionCancelledStatusValidation_CIBR_TC_26() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchTransactionCancelledStatusValidation_CIBR_TC_26();
    }
    @Test(priority = 23)
    public void cashInViaBranchTransactionPendingStatusValidation_CIBR_TC_23() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchTransactionPendingStatusValidation_CIBR_TC_23();
    }

    @Test(priority = 24)
    public void cashInViaBranchLocationPopupValidation_CIBR_TC_28() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchLocationPopupValidation_CIBR_TC_28();
    }

    @Test(priority = 25)
    public void cashInViaBranchLocationDenyFunctionality_CIBR_TC_29() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchLocationDenyFunctionality_CIBR_TC_29();
    }

    @Test(priority = 26)
    public void cashInViaBranchLocationPermissionDenyCloseBtnFunctionality_CIBR_TC_30() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchLocationPermissionDenyCloseBtnFunctionality_CIBR_TC_30();
    }

    @Test(priority = 27)
    public void cashInViaBranchLocationPermissionDenyOpenSettingsBtnFunctionality_CIBR_TC_31() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchLocationPermissionDenyOpenSettingsBtnFunctionality_CIBR_TC_31();
    }

//    @Test(priority = 28)
//    public void cashInViaBranchInternetInterruptionWhileEnteringOTP_CIBR_TC_33() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchInternetInterruptionWhileEnteringOTP_CIBR_TC_33();
//    }

    @Test(priority = 29)
    public void cashInViaBranchLocationPopUpAllowFunctionality_CIBR_TC_32() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchLocationPopUpAllowFunctionality_CIBR_TC_32();
    }

    @Test(priority = 30)
    public void cashInViaBranchTransactionValidationAfterMinimizingApp_CIBR_TC_36() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchTransactionValidationAfterMinimizingApp_CIBR_TC_36();
    }

    @Test(priority = 31)
    public void cashInViaBranchAmountFieldValidation_CIBR_TC_42() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchAmountFieldValidation_CIBR_TC_42();
    }

    @Test(priority = 32)
    public void cashInViaBranchTransactionWithValidMLPin_CIBR_TC_43() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchTransactionWithValidMLPin_CIBR_TC_43();
    }

    @Test(priority = 33)
    public void cashInViaBranchTransactionWithInValidMLPin_CIBR_TC_44() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchTransactionWithInValidMLPin_CIBR_TC_44();
    }

    @Test(priority = 34)
    public void cashInViaBranchOTPPopupValidation_CIBR_TC_50() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchOTPPopupValidation_CIBR_TC_50();
    }

    @Test(priority = 35)
    public void cashInViaBranchTransactionInAppOTPPopupUIValidation_CIBR_TC_51() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchTransactionInAppOTPPopupUIValidation_CIBR_TC_51();
    }

    @Test(priority = 36)
    public void cashInViaBranchTransactionNewOTPAfterSixtySecondsValidation_CIBR_TC_52() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchTransactionNewOTPAfterSixtySecondsValidation_CIBR_TC_52();
    }

    @Test(priority = 37)
    public void cashInViaBranchTransactionOTPCancelBtnFunctionality_CIBR_TC_53() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchTransactionOTPCancelBtnFunctionality_CIBR_TC_53();
    }

    @Test(priority = 38)
    public void cashInViaBranchOTPContinueBtnFunctionality_CIBR_TC_54() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchOTPContinueBtnFunctionality_CIBR_TC_54();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
