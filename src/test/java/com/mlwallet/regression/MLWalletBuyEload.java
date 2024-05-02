package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

import static com.business.mlwallet.MLWalletBusinessLogic.prop;
public class MLWalletBuyEload extends BaseTest{

    //p
    @Test(priority = 1)
    public void buyELoadTransactionDetails_BE_TC_01() throws Exception
    {
        mlWalletBuyELoad.buyELoadTransactionDetails_BE_TC_01(prop.getproperty("Fully_Verified"),2);
    }
    @Test(priority = 2)
    public void buyELoadWithoutTelecommunicationSelected_BE_TC_04() throws Exception
    {
        mlWalletBuyELoad.buyELoadWithoutTelecommunicationSelected_BE_TC_04();
    }
    @Test(priority = 3)
    public void buyELoadTransactionPageUIValidation_BE_TC_10() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionPageUIValidation_BE_TC_10(prop.getproperty("Fully_Verified"));
    }
    @Test(priority = 4)
    public void buyELoadNextButtonFunctionalityOnELoadTransactionPage_BE_TC_11() throws Exception {
        mlWalletBuyELoad.buyELoadNextButtonFunctionalityOnELoadTransactionPage_BE_TC_11(prop.getproperty("Fully_Verified"),prop.getproperty("SMART"),3);
    }
    @Test(priority = 5)
    public void buyELoadLoadSelectionPageUIValidation_BE_TC_13() throws Exception {
        mlWalletBuyELoad.buyELoadLoadSelectionPageUIValidation_BE_TC_13(prop.getproperty("Fully_Verified"),2);
    }
    @Test(priority = 6)
    public void buyELoadTransactionDetailsPageUIValidation__BE_TC_15() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionDetailsPageUIValidation_BE_TC_15(prop.getproperty("Fully_Verified"),2);
    }
    @Test(priority = 7)
    public void buyELoadSelectFromContactsBtnFunctionality_BE_TC_16() throws Exception {
        mlWalletBuyELoad.buyELoadSelectFromContactsBtnFunctionality_BE_TC_16(prop.getproperty("Fully_Verified"));
    }
    @Test(priority = 8)
    public void buyELoadContactsPageUIValidation_BE_TC_17() throws Exception {
        mlWalletBuyELoad.buyELoadContactsPageUIValidation_BE_TC_17(prop.getproperty("Fully_Verified"));
    }
    @Test(priority = 8)
    public void buyELoadSearchFieldValidation_BE_TC_19() throws Exception {
        mlWalletBuyELoad.buyELoadSearchFieldValidation_BE_TC_19(prop.getproperty("Fully_Verified"));
    }
    @Test(priority = 9)
    public void buyELoadAddContactToFavorites_BE_TC_20() throws Exception {
        mlWalletBuyELoad.buyELoadAddContactToFavorites_BE_TC_20(prop.getproperty("Fully_Verified"));
    }
    @Test(priority = 10)
    public void buyELoadAddedContactToFavoritesValidation_BE_TC_21() throws Exception {
        mlWalletBuyELoad.buyELoadAddedContactToFavoritesValidation_BE_TC_21(prop.getproperty("Fully_Verified"));
    }
    @Test(priority = 11)
    public void buyELoadSearchAddedFavoriteContact_BE_TC_22() throws Exception {
        mlWalletBuyELoad.buyELoadSearchAddedFavoriteContact_BE_TC_22(prop.getproperty("Fully_Verified"));
    }
    @Test(priority = 12)
    public void buyELoadPromoConfirmationPopupValidation_BE_TC_24() throws Exception {
        mlWalletBuyELoad.buyELoadPromoConfirmationPopupValidation_BE_TC_24(prop.getproperty("Fully_Verified"),2);
    }
    @Test(priority = 13)
    public void buyELoadOTPPageUIValidation_BE_TC_25() throws Exception {
        mlWalletBuyELoad.buyELoadOTPPageUIValidation_BE_TC_25(prop.getproperty("Fully_Verified"),2);
    }
    @Test(priority = 14)
    public void buyELoadSuccessfulTransaction_BE_TC_26() throws Exception {
        mlWalletBuyELoad.buyELoadSuccessfulTransaction_BE_TC_26(prop.getproperty("Fully_Verified"),2);
    }
    @Test(priority = 15)
    public void buyELoadRecentTransactionUIValidation_BE_TC_27() throws Exception {
        mlWalletBuyELoad.buyELoadRecentTransactionUIValidation_BE_TC_27();
    }
    @Test(priority = 16)
    public void buyELoadTransactionDetailsUIValidation_BE_TC_28() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionDetailsUIValidation_BE_TC_28();
    }
    @Test(priority = 17)
    public void buyELoadLocationPopupValidation_BE_TC_51() throws Exception {
        mlWalletBuyELoad.buyELoadLocationPopupValidation_BE_TC_51(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 18)
    public void buyELoadLocationPopUpAllowFunctionality_BE_TC_55() throws Exception {
        mlWalletBuyELoad.buyELoadLocationPopUpAllowFunctionality_BE_TC_55(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 19)
    public void buyELoadContactsPermissionPopup_BE_TC_56() throws Exception {
        mlWalletBuyELoad.buyELoadContactsPermissionPopup_BE_TC_56(prop.getproperty("Fully_Verified"));
    }
    @Test(priority = 20)
    public void buyELoadContactPermissionPopupAllowBtnFunctionality_BE_TC_57() throws Exception {
        mlWalletBuyELoad.buyELoadContactPermissionPopupAllowBtnFunctionality_BE_TC_57();
    }
    @Test(priority = 21)
    public void buyELoadContactPermissionTwoAllowBtnFunctionality_BE_TC_60() throws Exception {
        mlWalletBuyELoad.buyELoadContactPermissionTwoAllowBtnFunctionality_BE_TC_60();
    }
    @Test(priority = 22)
    public void buyELoadNewTransactionBtnFunctionality_BE_TC_66() throws Exception {
        mlWalletBuyELoad.buyELoadNewTransactionBtnFunctionality_BE_TC_66();
    }
    @Test(priority = 23)
    public void buyELoadTransactionValidationAfterMinimizingApp_BE_TC_069() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionValidationAfterMinimizingApp_BE_TC_069(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 24)
    public void buyELoadTransactionWithValidMLPin_BE_TC_78() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionWithValidMLPin_BE_TC_78(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 25)
    public void buyELoadInOTPPopupValidation_BE_TC_089() throws Exception {
        mlWalletBuyELoad.buyELoadInOTPPopupValidation_BE_TC_089(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 26)
    public void buyELoadTransactionInAppOTPPopupUIValidation_BE_TC_090() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionInAppOTPPopupUIValidation_BE_TC_090(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 27)
    public void buyELoadTransactionOTPContinueBtnFunctionality_BE_TC_093() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionOTPContinueBtnFunctionality_BE_TC_093(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 28)
    public void buyELoadSecondTimeLoadSelectionPopupValidation_BE_TC_29() throws Exception {
        mlWalletBuyELoad.buyELoadSecondTimeLoadSelectionPopupValidation_BE_TC_29(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 29)
    public void buyELoadMLPinPageNavigation_BE_TC_87() throws Exception {
        mlWalletBuyELoad.buyELoadMLPinPageNavigation_BE_TC_87("9999999999",2);
    }


    //============================================================================================================


    @Test(priority = 30)
    public void buyELoadInvalidMobileNumber_BE_TC_02() throws Exception
    {
        mlWalletBuyELoad.buyELoadInvalidMobileNumber_BE_TC_02();
    }
    @Test(priority = 31)
    public void buyELoadWithoutInputMobNumber_BE_TC_03() throws Exception
    {
        mlWalletBuyELoad.buyELoadWithoutInputMobNumber_BE_TC_03();
    }
    @Test(priority = 33)
    public void buyELoadInsufficientBalance_BE_TC_05() throws Exception
    {
        mlWalletBuyELoad.buyELoadInsufficientBalance_BE_TC_05(prop.getproperty("Branch_Verified_LowBalance"),2);
    }
    @Test(priority = 34)
    public void buyELoadMaxLimitPerTransaction_BE_TC_09() throws Exception {
        mlWalletBuyELoad.buyELoadMaxLimitPerTransaction_BE_TC_09(prop.getproperty("Fully_Verified"),2);
    }
    @Test(priority = 35)
    public void buyELoadLoadSelectionPageBackBtnValidation_BE_TC_12() throws Exception {
        mlWalletBuyELoad.buyELoadLoadSelectionPageBackBtnValidation_BE_TC_12();
    }
    @Test(priority = 36)
    public void buyELoadLoadSelectionChangeBtnFunctionality_BE_TC_14() throws Exception {
        mlWalletBuyELoad.buyELoadLoadSelectionChangeBtnFunctionality_BE_TC_14(prop.getproperty("Fully_Verified"),2);
    }
    @Test(priority = 37)
    public void buyELoadContactsPageBackBtnValidation_BE_TC_18() throws Exception {
        mlWalletBuyELoad.buyELoadContactsPageBackBtnValidation_BE_TC_18(prop.getproperty("Fully_Verified"));
    }
    @Test(priority = 38)
    public void buyELoadSearchUnFavoriteContact_BE_TC_23() throws Exception {
        mlWalletBuyELoad.buyELoadSearchUnFavoriteContact_BE_TC_23(prop.getproperty("Fully_Verified"));
    }
    @Test(priority = 39)
    public void buyELoadLocationDenyFunctionality_BE_TC_52() throws Exception {
        mlWalletBuyELoad.buyELoadLocationDenyFunctionality_BE_TC_52(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 40)
    public void buyELoadLocationPermissionDenyCloseBtnFunctionality_BE_TC_53() throws Exception {
        mlWalletBuyELoad.buyELoadLocationPermissionDenyCloseBtnFunctionality_BE_TC_53(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 41)
    public void buyELoadLocationPermissionDenyOpenSettingsBtnFunctionality_BE_TC_54() throws Exception {
        mlWalletBuyELoad.buyELoadLocationPermissionDenyOpenSettingsBtnFunctionality_BE_TC_54(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 42)
    public void buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_58() throws Exception {
        mlWalletBuyELoad.buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_58();
    }
    @Test(priority = 43)
    public void buyELoadContactPermissionTwoDenyBtnFunctionality_BE_TC_59() throws Exception {
        mlWalletBuyELoad.buyELoadContactPermissionTwoDenyBtnFunctionality_BE_TC_59();
    }

//    @Test(priority = 44)
//    public void buyELoadInternetInterruptionWhileEnteringOTP_BE_TC_61() throws Exception {
//        mlWalletBuyELoad.buyELoadInternetInterruptionWhileEnteringOTP_BE_TC_61(prop.getproperty("Fully_Verified"), 2);
//    }

    @Test(priority = 45)
    public void buyELoadLocationPermissionAskMeLaterButtonFunctionality_BE_TC_62() throws Exception {
        mlWalletBuyELoad.buyELoadLocationPermissionAskMeLaterButtonFunctionality_BE_TC_62();
    }
    @Test(priority = 46)
    public void buyELoadLocationPermissionTwoDenyBtnFunctionality_BE_TC_63() throws Exception {
        mlWalletBuyELoad.buyELoadLocationPermissionTwoDenyBtnFunctionality_BE_TC_63();
    }
    @Test(priority = 47)
    public void buyELoadLocationPermissionTwoAllowBtnFunctionality_BE_TC_64() throws Exception {
        mlWalletBuyELoad.buyELoadLocationPermissionTwoAllowBtnFunctionality_BE_TC_64();
    }
    @Test(priority = 48)
    public void buyELoadContactPopupNotDisplayedAfterClickingODenyButtonValidation_BE_TC_65() throws Exception {
        mlWalletBuyELoad.buyELoadContactPopupNotDisplayedAfterClickingODenyButtonValidation_BE_TC_65();
    }
    @Test(priority = 49)
    public void buyELoadTransactionWithInValidMLPin_BE_TC_79() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionWithInValidMLPin_BE_TC_79(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 50)
    public void buyELoadTransactionNewOTPAfterSixtySecondsValidation_BE_TC_091() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionNewOTPAfterSixtySecondsValidation_BE_TC_091(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 51)
    public void buyELoadTransactionOTPCancelBtnFunctionality_BE_TC_092() throws Exception {
        mlWalletBuyELoad.buyELoadTransactionOTPCancelBtnFunctionality_BE_TC_092(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 52)
    public void buyELoadMaximumTransactionForBranchVerifiedTier_BE_TC_42() throws Exception {
        mlWalletBuyELoad.buyELoadMaximumTransactionForBranchVerifiedTier_BE_TC_42(prop.getproperty("Branch_Verified"), 2);
    }
    @Test(priority = 53)
    public void buyELoadMaximumLimitForSemiVerifiedTier_BE_TC_33() throws Exception {
        mlWalletBuyELoad.buyELoadMaximumLimitForSemiVerifiedTier_BE_TC_33(prop.getproperty("Semi_Verified"), 2);
    }
    @Test(priority = 54)
    public void buyELoadMaximumTransactionForSemiVerifiedTier_BE_TC_30() throws Exception {
        mlWalletBuyELoad.buyELoadMaximumTransactionForSemiVerifiedTier_BE_TC_30(prop.getproperty("Semi_Verified"), 2);
    }
    @Test(priority = 55)
    public void buyELoadMaximumLimitForFullyVerifiedTier_BE_TC_39() throws Exception {
        mlWalletBuyELoad.buyELoadMaximumLimitForFullyVerifiedTier_BE_TC_39(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 56)
    public void buyELoadMaximumTransactionForFullyVerifiedTier_BE_TC_36() throws Exception {
        mlWalletBuyELoad.buyELoadMaximumTransactionForFullyVerifiedTier_BE_TC_36(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 57)
    public void buyELoadMaximumLimitForBuyerTierVerifiedTier_BE_TC_45() throws Exception {
        mlWalletBuyELoad.buyELoadMaximumLimitForBuyerTierVerifiedTier_BE_TC_45(prop.getproperty("Fully_Verified"), 2);
    }
    @Test(priority = 58)
    public void buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_48() throws Exception {
        mlWalletBuyELoad.buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_48(prop.getproperty("Fully_Verified"), 2);
    }


    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }
}
