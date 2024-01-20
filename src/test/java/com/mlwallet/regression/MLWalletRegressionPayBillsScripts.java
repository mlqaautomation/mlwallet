package com.mlwallet.regression;


import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

public class MLWalletRegressionPayBillsScripts extends BaseTest{
    @Test(priority = 1)
    public void payBillsPageValidation_PB_TC_01() throws Exception {
        mlWalletBillsPay.payBillsPageValidation_PB_TC_01();
    }

    @Test(priority = 2)
    public void billerCategories_PB_TC_02() throws Exception {
        mlWalletBillsPay.billerCategories_PB_TC_02();
    }

    @Test(priority = 3)
    public void billersInAlphabeticalOrder_PB_TC_03() throws Exception {
        mlWalletBillsPay.billersInAlphabeticalOrder_PB_TC_03();
    }

    @Test(priority = 4)
    public void selectBiller_PB_TC_04() throws Exception {
        mlWalletBillsPay.selectBiller_PB_TC_04();
    }

    @Test(priority = 5)
    public void searchBiller_PB_TC_05() throws Exception {
        mlWalletBillsPay.searchBiller_PB_TC_05();
    }

    @Test(priority = 6)
    public void billingInformationInput_PB_TC_06() throws Exception {
        mlWalletBillsPay.billingInformationInput_PB_TC_06();
    }


   @Test(priority = 7)
    public void payBillsWithValidInputs_PB_TC_07() throws Exception {
        mlWalletBillsPay.payBillsWithValidInputs_PB_TC_07();
    }

    @Test(priority = 8)
    public void payBillsInRecentTransactions_PB_TC_08() throws Exception {
        mlWalletBillsPay.payBillsInRecentTransactions_PB_TC_08();
    }

    @Test(priority = 9)
    public void payBillsInsufficientBalance_PB_TC_09() throws Exception {
        mlWalletBillsPay.payBillsInsufficientBalance_PB_TC_09();
    }

    @Test(priority = 10)
    public void billingInformationInvalidInput_PB_TC_10() throws Exception {
        mlWalletBillsPay.billingInformationInvalidInput_PB_TC_10();
    }

   @Test(priority = 11)
    public void addBillerToPayBills_PB_TC_12() throws Exception {
        mlWalletBillsPay.addBillerToPayBills_PB_TC_12();
    }

    @Test(priority = 12)
    public void editAddedBillerToPayBills_PB_TC_14() throws Exception {
        mlWalletBillsPay.editAddedBillerToPayBills_PB_TC_14();
    }


    @Test(priority = 13)
    public void deleteAddedBillerPayBills_PB_TC_15() throws Exception {
        mlWalletBillsPay.deleteAddedBillerPayBills_PB_TC_15();
    }

//============================================================================================================//


    @Test(priority = 14)
    public void payBillsUIValidation_PB_TC_16() throws Exception {
        mlWalletBillsPay.payBillsUIValidation_PB_TC_16();
    }

    @Test(priority = 15)
    public void payBillsAddBillerPageUIValidation_PB_TC_18() throws Exception {
        mlWalletBillsPay.payBillsAddBillerPageUIValidation_PB_TC_18();
    }

    @Test(priority = 16)
    public void paybillsRecentTransaction_PB_TC_19() throws Exception {
        mlWalletBillsPay.paybillsRecentTransaction_PB_TC_19();
    }

    @Test(priority = 17)
    public void payBillsSavedBilerUIValidation_PB_TC_20() throws Exception {
        mlWalletBillsPay.payBillsSavedBilerUIValidation_PB_TC_20();
    }

    @Test(priority = 18)
    public void payBillsMaxBillsPaymentPerTransactionBuyTierUser_PB_TC_22() throws Exception {
        mlWalletBillsPay.payBillsMaxBillsPaymentPerTransactionBuyTierUser_PB_TC_22();
    }

    @Test(priority = 19)
    public void payBillsMaxBillsPaymentPerTransactionSemiVerifiedTier_PB_TC_25() throws Exception {
        mlWalletBillsPay.payBillsMaxBillsPaymentPerTransactionSemiVerifiedTier_PB_TC_25();
    }

    @Test(priority = 20)
    public void payBillsMaxBillsPaymentPerTransactionBranchVerifiedTier_PB_TC_28() throws Exception {
        mlWalletBillsPay.payBillsMaxBillsPaymentPerTransactionBranchVerifiedTier_PB_TC_28();
    }

    @Test(priority = 21)
    public void payBillsMaxBillsPaymentPerTransactionFullyVerifiedTier_PB_TC_31() throws Exception {
        mlWalletBillsPay.payBillsMaxBillsPaymentPerTransactionFullyVerifiedTier_PB_TC_31();
    }

    @Test(priority = 22)
    public void payBillsRecentTransaction_PB_TC_21() throws Exception {
        mlWalletBillsPay.payBillsRecentTransaction_PB_TC_21();
    }

    @Test(priority = 23)
    public void payBillsLocationPopupValidation_PB_TC_34() throws Exception {
        mlWalletBillsPay.payBillsLocationPopupValidation_PB_TC_34();
    }

    @Test(priority = 24)
    public void payBillsLocationDenyFunctionality_PB_TC_35() throws Exception {
        mlWalletBillsPay.payBillsLocationDenyFunctionality_PB_TC_35();
    }

    @Test(priority = 25)
    public void payBillsLocationPermissionDenyCloseBtnFunctionality_PB_TC_36() throws Exception {
        mlWalletBillsPay.payBillsLocationPermissionDenyCloseBtnFunctionality_PB_TC_36();
    }
//
    @Test(priority = 26)
    public void payBillsLocationPermissionDenyOpenSettingsBtnFunctionality_PB_TC_37() throws Exception {
        mlWalletBillsPay.payBillsLocationPermissionDenyOpenSettingsBtnFunctionality_PB_TC_37();
    }

    @Test(priority = 27)
    public void payBillsLocationPopUpAllowFunctionality_PB_TC_38() throws Exception {
        mlWalletBillsPay.payBillsLocationPopUpAllowFunctionality_PB_TC_38();
    }

//    @Test(priority = 28)
//    public void payBillsInternetInterruptionWhileEnteringOTP_PB_TC_39() throws Exception {
//        mlWalletBillsPay.payBillsInternetInterruptionWhileEnteringOTP_PB_TC_39();
//    }

    @Test(priority = 28)
//    public void payBillsInternetInterruptionWhileEnteringOTP_PB_TC_39() throws Exception {
//        mlWalletBillsPay.payBillsInternetInterruptionWhileEnteringOTP_PB_TC_39();
//    }    @Test(priority = 29)
    public void payBillsTransactionValidationAfterMinimizingApp_PB_TC_42() throws Exception {
        mlWalletBillsPay.payBillsTransactionValidationAfterMinimizingApp_PB_TC_42();
    }

    @Test(priority = 30)
    public void payBillsTransactionWithValidMLPin_PB_TC_48() throws Exception {
        mlWalletBillsPay.payBillsTransactionWithValidMLPin_PB_TC_48();
    }

    @Test(priority = 31)
    public void payBillsTransactionWithInValidMLPin_PB_TC_49() throws Exception {
        mlWalletBillsPay.payBillsTransactionWithInValidMLPin_PB_TC_49();
    }

    @Test(priority = 32)
    public void payBillsInOTPPopupValidation_PB_TC_55() throws Exception {
        mlWalletBillsPay.payBillsInOTPPopupValidation_PB_TC_55();
    }

    @Test(priority = 33)
    public void payBillsTransactionInAppOTPPopupUIValidation_PB_TC_56() throws Exception {
        mlWalletBillsPay.payBillsTransactionInAppOTPPopupUIValidation_PB_TC_56();
    }

    @Test(priority = 34)
    public void payBillsTransactionNewOTPAfterSixtySecondsValidation_PB_TC_57() throws Exception {
        mlWalletBillsPay.payBillsTransactionNewOTPAfterSixtySecondsValidation_PB_TC_57();
    }

    @Test(priority = 35)
    public void payBillsTransactionOTPCancelBtnFunctionality_PB_TC_58() throws Exception {
        mlWalletBillsPay.payBillsTransactionOTPCancelBtnFunctionality_PB_TC_58();
    }

    @Test(priority = 36)
    public void payBillsTransactionOTPContinueBtnFunctionality_PB_TC_59() throws Exception {
        mlWalletBillsPay.payBillsTransactionOTPContinueBtnFunctionality_PB_TC_59();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
