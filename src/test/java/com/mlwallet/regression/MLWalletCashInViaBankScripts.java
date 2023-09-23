package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.*;
import com.business.mlwallet.CashInVia_BankClass;
public class MLWalletCashInViaBankScripts {

    public static String deviceName;
    public static String portno;
    public static CashInVia_BankClass cashInViaBankClass;


    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletCashInViaBankScripts.deviceName=deviceName;
        MLWalletCashInViaBankScripts.portno= portno;
        cashInViaBankClass = new CashInVia_BankClass("MLWallet",deviceName,portno);
    }

//==================================================================================================//


    @Test(priority = 1)
    public void cashInViaBank() throws Exception {
        cashInViaBankClass.cashInViaBank_CIBA_TC_01();
    }

    @Test(priority = 2)
    public void cashInViaBankMinimumTransactionLimit() throws Exception {
        cashInViaBankClass.cashInViaBankMinimumTransactionLimit_CIBA_TC_03();
    }

    @Test(priority = 3)
    public void cashInViaBankMaximumTransaction() throws Exception {
        cashInViaBankClass.cashInViaBankMaximumTransaction_CIBA_TC_04();
    }


//=========================================================================================================//

    @Test(priority = 4)
    public void cashInViaBankInvalidAmount() throws Exception {
        cashInViaBankClass.cashInViaBankInvalidAmount_STW_TC_05();
    }

    @Test(priority = 5)
    public void cashInViaBankNavigation_STW_TC_06() throws Exception {
        cashInViaBankClass.cashInViaBankNavigation_STW_TC_06();
    }

    @Test(priority = 6)
    public void cashInUIValidation_STW_TC_07() throws Exception {
        cashInViaBankClass.cashInUIValidation_STW_TC_07();
    }

    @Test(priority = 7)
    public void cashInPageBackArrowBtnValidation_STW_TC_08() throws Exception {
        cashInViaBankClass.cashInPageBackArrowBtnValidation_STW_TC_08();
    }

    @Test(priority = 8)
    public void cashInSelectBankPageUIValidation_STW_TC_09() throws Exception {
        cashInViaBankClass.cashInSelectBankPageUIValidation_STW_TC_09();
    }

    @Test(priority = 9)
    public void cashInViaBankSearchInvalidBank_STW_TC_10() throws Exception {
        cashInViaBankClass.cashInViaBankSearchInvalidBank_STW_TC_10();
    }

    @Test(priority = 10)
    public void cashInViaBankSelectBankPageBackBtnValidation_STW_TC_11() throws Exception {
        cashInViaBankClass.cashInViaBankSelectBankPageBackBtnValidation_STW_TC_11();
    }

    @Test(priority = 11)
    public void cashInViaBankDragonPayPageUIValidation_STW_TC_12() throws Exception {
        cashInViaBankClass.cashInViaBankDragonPayPageUIValidation_STW_TC_12();
    }

    @Test(priority = 12)
    public void cashInViaBankDragonPayBackBtnValidation_STW_TC_13() throws Exception {
        cashInViaBankClass.cashInViaBankDragonPayBackBtnValidation_STW_TC_13();
    }

    @Test(priority = 13)
    public void cashInViaBankReviewTransactionPageUIValidation_STW_TC_14() throws Exception {
        cashInViaBankClass.cashInViaBankReviewTransactionPageUIValidation_STW_TC_14();
    }

    @Test(priority = 14)
    public void cashInViaBankReviewTransactionBackBtnValidation_STW_TC_15() throws Exception {
        cashInViaBankClass.cashInViaBankReviewTransactionBackBtnValidation_STW_TC_15();
    }

    @Test(priority = 15)
    public void cashInViaBankStatusTransaction_CIBA_TC_16() throws Exception {
        cashInViaBankClass.cashInViaBankStatusTransaction_CIBA_TC_16();
    }

    @Test(priority = 16)
    public void cashInViaBankPendingTransaction_CIBA_TC_17() throws Exception {
        cashInViaBankClass.cashInViaBankPendingTransaction_CIBA_TC_17();
    }

    @Test(priority = 17)
    public void cashInViaBankWithExistingPendingTransaction_CIBA_TC_20() throws Exception {
        cashInViaBankClass.cashInViaBankWithExistingPendingTransaction_CIBA_TC_20();
    }

    @Test(priority = 18)
    public void cancelButtonValidationInDragonPayPopUp_CIBA_TC_21() throws Exception {
        cashInViaBankClass.cancelButtonValidationInDragonPayPopUp_CIBA_TC_21();
    }


    @Test(priority = 19)
    public void cashInViaBankTappingOutsideTheDragonPayPopupValidation_CIBA_TC_22() throws Exception {
        cashInViaBankClass.cashInViaBankTappingOutsideTheDragonPayPopupValidation_CIBA_TC_22();
    }


    @Test(priority = 20)
    public void cashInViaBankInvalidAmountFieldValidation_CIBA_TC_23() throws Exception {
        cashInViaBankClass.cashInViaBankInvalidAmountFieldValidation_CIBA_TC_23();
    }

    @Test(priority = 21)
    public void cashInViaBankBuyerTierLevel_CIBA_TC_24() throws Exception {
        cashInViaBankClass.cashInViaBankBuyerTierLevel_CIBA_TC_24();
    }

    @Test(priority = 22)
    public void cashInViaBankSemiVerifiedTierStatusTransaction_STW_TC_25() throws Exception {
        cashInViaBankClass.cashInViaBankSemiVerifiedTierStatusTransaction_CIBA_TC_25();
    }

    @Test(priority = 23)
    public void cashInViaBankFullyVerifiedTierStatusTransaction_CIBA_TC_26() throws Exception {
        cashInViaBankClass.cashInViaBankFullyVerifiedTierStatusTransaction_CIBA_TC_26();
    }


    @Test(priority = 24)
    public void cashInViaBankSemiVerifiedUserMaxLimit_CIBA_TC_27() throws Exception {
        cashInViaBankClass.cashInViaBankSemiVerifiedUserMaxLimit_CIBA_TC_27();
    }

    @Test(priority = 25)
    public void cashInViaBankFullyVerifiedUserMaxLimit_CIBA_TC_28() throws Exception {
        cashInViaBankClass.cashInViaBankFullyVerifiedUserMaxLimit_CIBA_TC_28();
    }

    @Test(priority = 26)
    public void cashInViaBankTransactionDetailsPageUIValidation_CIBA_TC_29() throws Exception {
        cashInViaBankClass.cashInViaBankTransactionDetailsPageUIValidation_CIBA_TC_29();
    }


    @Test(priority = 27)
    public void cashInViaBankDragonPayChagresPopUpValidation_CIBA_TC_32() throws Exception {
        cashInViaBankClass.cashInViaBankDragonPayChagresPopUpValidation_CIBA_TC_32();
    }

    @Test(priority = 28)
    public void cashInViaBankLocationPopupValidation_CIBA_TC_35() throws Exception {
        cashInViaBankClass.cashInViaBankLocationPopupValidation_CIBA_TC_35();
    }

    @Test(priority = 29)
    public void cashInViaBankLocationDenyFunctionality_CIBA_TC_36() throws Exception {
        cashInViaBankClass.cashInViaBankLocationDenyFunctionality_CIBA_TC_36();
    }

    @Test(priority = 30)
    public void cashInViaBankLocationPermissionDenyCloseBtnFunctionality_CIBA_TC_37() throws Exception {
        cashInViaBankClass.cashInViaBankLocationPermissionDenyCloseBtnFunctionality_CIBA_TC_37();
    }

    @Test(priority = 31)
    public void cashInViaBankLocationPermissionDenyOpenSettingsBtnFunctionality_CIBA_TC_38() throws Exception {
        cashInViaBankClass.cashInViaBankLocationPermissionDenyOpenSettingsBtnFunctionality_CIBA_TC_38();
    }

    @Test(priority = 32)
    public void cashInViaBankLocationPopUpAllowFunctionality_CIBA_TC_39() throws Exception {
        cashInViaBankClass.cashInViaBankLocationPopUpAllowFunctionality_CIBA_TC_39();
    }

    @Test(priority = 33)
    public void cashInViaBankInternetInterruptionWhileEnteringOTP_CIBA_TC_40() throws Exception {
        cashInViaBankClass.cashInViaBankInternetInterruptionWhileEnteringOTP_CIBA_TC_40();
    }

    @Test(priority = 34)
    public void cashInViaBankTransactionValidationAfterMinimizingApp_CIBA_TC_43() throws Exception {
        cashInViaBankClass.cashInViaBankTransactionValidationAfterMinimizingApp_CIBA_TC_43();
    }

    @Test(priority = 35)
    public void cashInViaBankAmountFieldValidation_CIBA_TC_49() throws Exception {
        cashInViaBankClass.cashInViaBankAmountFieldValidation_CIBA_TC_49();
    }

    @Test(priority = 36)
    public void cashInViaBankTransactionWithValidMLPin_CIBA_TC_50() throws Exception {
        cashInViaBankClass.cashInViaBankTransactionWithValidMLPin_CIBA_TC_50();
    }

    @Test(priority = 37)
    public void cashInViaBankTransactionWithInValidMLPin_CIBA_TC_51() throws Exception {
        cashInViaBankClass.cashInViaBankTransactionWithInValidMLPin_CIBA_TC_51();
    }

    @Test(priority = 38)
    public void cashInViaBankOTPPopupValidation_CIBA_TC_57() throws Exception {
        cashInViaBankClass.cashInViaBankOTPPopupValidation_CIBA_TC_57();
    }

    @Test(priority = 39)
    public void cashInViaBankTransactionInAppOTPPopupUIValidation_CIBA_TC_58() throws Exception {
        cashInViaBankClass.cashInViaBankTransactionInAppOTPPopupUIValidation_CIBA_TC_58();
    }

    @Test(priority = 40)
    public void cashInViaBankTransactionNewOTPAfterSixtySecondsValidation_CIBA_TC_59() throws Exception {
        cashInViaBankClass.cashInViaBankTransactionNewOTPAfterSixtySecondsValidation_CIBA_TC_59();
    }

    @Test(priority = 41)
    public void cashInViaBankTransactionOTPCancelBtnFunctionality_CIBA_TC_60() throws Exception {
        cashInViaBankClass.cashInViaBankTransactionOTPCancelBtnFunctionality_CIBA_TC_60();
    }

    @Test(priority = 42)
    public void cashInViaBankOTPContinueBtnFunctionality_CIBA_TC_61() throws Exception {
        cashInViaBankClass.cashInViaBankOTPContinueBtnFunctionality_CIBA_TC_61();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
