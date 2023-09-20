package com.mlwallet.regression;

import com.business.mlwallet.MLWalletBusinessLogic;
import com.driverInstance.AppiumServer;
import org.testng.annotations.*;


import static com.business.mlwallet.MLWalletBusinessLogic.prop;
import com.business.mlwallet.BuyEloadClass;
public class MLWalletBuyEload {

    public static String deviceName;
    public static String portno;
    public  static com.business.mlwallet.MLWalletBusinessLogic MLWalletBusinessLogic;
    public static com.business.mlwallet.BuyEloadClass buyEloadClass;



    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletBuyEload.deviceName=deviceName;
        MLWalletBuyEload.portno= portno;
//        MLWalletBusinessLogic = new MLWalletBusinessLogic("MLWallet",deviceName,portno);
        buyEloadClass = new BuyEloadClass("MLWallet",deviceName,portno);
    }




    //===================================buy eload=======================================


    @Test(priority = 1)
    public void buyELoadTransactionDetails_BE_TC_01() throws Exception
    {
        buyEloadClass.buyELoadTransactionDetails_BE_TC_01(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 2)
    public void buyELoadInvalidMobileNumber_BE_TC_02() throws Exception
    {
        buyEloadClass.buyELoadInvalidMobileNumber_BE_TC_02();
    }

    @Test(priority = 3)
    public void buyELoadWithoutInputMobNumber_BE_TC_03() throws Exception
    {
        buyEloadClass.buyELoadWithoutInputMobNumber_BE_TC_03();
    }

    @Test(priority = 4)
    public void buyELoadWithoutTelecommunicationSelected_BE_TC_04() throws Exception
    {
        buyEloadClass.buyELoadWithoutTelecommunicationSelected_BE_TC_04();
    }

    @Test(priority = 5)
    public void buyELoadInsufficientBalance_BE_TC_05() throws Exception
    {
        buyEloadClass.buyELoadInsufficientBalance_BE_TC_05(prop.getproperty("Branch_Verified_LowBalance"),2);
    }

    @Test(priority = 6)
    public void buyELoadMaxLimitPerTransaction_BE_TC_09() throws Exception {
        buyEloadClass.buyELoadMaxLimitPerTransaction_BE_TC_09(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 7)
    public void buyELoadTransactionPageUIValidation_BE_TC_10() throws Exception {
        buyEloadClass.buyELoadTransactionPageUIValidation_BE_TC_10(prop.getproperty("Fully_Verified"));
    }

    @Test(priority = 8)
    public void buyELoadNextButtonFunctionalityOnELoadTransactionPage_BE_TC_11() throws Exception {
        buyEloadClass.buyELoadNextButtonFunctionalityOnELoadTransactionPage_BE_TC_11(prop.getproperty("Fully_Verified"),prop.getproperty("GLOBE"),2);
    }

    @Test(priority = 9)
    public void buyELoadLoadSelectionPageBackBtnValidation_BE_TC_12() throws Exception {
        buyEloadClass.buyELoadLoadSelectionPageBackBtnValidation_BE_TC_12();
    }

    @Test(priority = 10)
    public void buyELoadLoadSelectionPageUIValidation_BE_TC_13() throws Exception {
        buyEloadClass.buyELoadLoadSelectionPageUIValidation_BE_TC_13(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 11)
    public void buyELoadLoadSelectionChangeBtnFunctionality_BE_TC_14() throws Exception {
        buyEloadClass.buyELoadLoadSelectionChangeBtnFunctionality_BE_TC_14(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 12)
    public void buyELoadTransactionDetailsPageUIValidation__BE_TC_15() throws Exception {
        buyEloadClass.buyELoadTransactionDetailsPageUIValidation_BE_TC_15(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 13)
    public void buyELoadSelectFromContactsBtnFunctionality_BE_TC_16() throws Exception {
        buyEloadClass.buyELoadSelectFromContactsBtnFunctionality_BE_TC_16(prop.getproperty("Fully_Verified"));
    }

    @Test(priority = 14)
    public void buyELoadContactsPageUIValidation_BE_TC_17() throws Exception {
        buyEloadClass.buyELoadContactsPageUIValidation_BE_TC_17(prop.getproperty("Fully_Verified"));
    }

    @Test(priority = 15)
    public void buyELoadContactsPageBackBtnValidation_BE_TC_18() throws Exception {
        buyEloadClass.buyELoadContactsPageBackBtnValidation_BE_TC_18(prop.getproperty("Fully_Verified"));
    }

    @Test(priority = 16)
    public void buyELoadSearchFieldValidation_BE_TC_19() throws Exception {
        buyEloadClass.buyELoadSearchFieldValidation_BE_TC_19(prop.getproperty("Fully_Verified"));
    }

    @Test(priority = 17)
    public void buyELoadAddContactToFavorites_BE_TC_20() throws Exception {
        buyEloadClass.buyELoadAddContactToFavorites_BE_TC_20(prop.getproperty("Fully_Verified"));
    }

    @Test(priority = 18)
    public void buyELoadAddedContactToFavoritesValidation_BE_TC_21() throws Exception {
        buyEloadClass.buyELoadAddedContactToFavoritesValidation_BE_TC_21(prop.getproperty("Fully_Verified"));
    }

    @Test(priority = 19)
    public void buyELoadSearchAddedFavoriteContact_BE_TC_22() throws Exception {
        buyEloadClass.buyELoadSearchAddedFavoriteContact_BE_TC_22(prop.getproperty("Fully_Verified"));
    }

    @Test(priority = 20)
    public void buyELoadSearchUnFavoriteContact_BE_TC_23() throws Exception {
        buyEloadClass.buyELoadSearchUnFavoriteContact_BE_TC_23(prop.getproperty("Fully_Verified"));
    }

    @Test(priority = 21)
    public void buyELoadPromoConfirmationPopupValidation_BE_TC_24() throws Exception {
        buyEloadClass.buyELoadPromoConfirmationPopupValidation_BE_TC_24(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 22)
    public void buyELoadOTPPageUIValidation_BE_TC_25() throws Exception {
        buyEloadClass.buyELoadOTPPageUIValidation_BE_TC_25(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 23)
    public void buyELoadSuccessfulTransactionUIValidation_BE_TC_26() throws Exception {
        buyEloadClass.buyELoadSuccessfulTransactionUIValidation_BE_TC_26(prop.getproperty("Fully_Verified"),2);
    }

    @Test(priority = 24)
    public void buyELoadRecentTransactionUIValidation_BE_TC_27() throws Exception {
        buyEloadClass.buyELoadRecentTransactionUIValidation_BE_TC_27();
    }

    @Test(priority = 25)
    public void buyELoadTransactionDetailsUIValidation_BE_TC_28() throws Exception {
        buyEloadClass.buyELoadTransactionDetailsUIValidation_BE_TC_28();
    }

    @Test(priority = 26)
    public void buyELoadLocationPopupValidation_BE_TC_51() throws Exception {
        buyEloadClass.buyELoadLocationPopupValidation_BE_TC_51(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 27)
    public void buyELoadLocationDenyFunctionality_BE_TC_52() throws Exception {
        buyEloadClass.buyELoadLocationDenyFunctionality_BE_TC_52(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 28)
    public void buyELoadLocationPermissionDenyCloseBtnFunctionality_BE_TC_53() throws Exception {
        buyEloadClass.buyELoadLocationPermissionDenyCloseBtnFunctionality_BE_TC_53(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 29)
    public void buyELoadLocationPermissionDenyOpenSettingsBtnFunctionality_BE_TC_54() throws Exception {
        buyEloadClass.buyELoadLocationPermissionDenyOpenSettingsBtnFunctionality_BE_TC_54(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 30)
    public void buyELoadLocationPopUpAllowFunctionality_BE_TC_55() throws Exception {
        buyEloadClass.buyELoadLocationPopUpAllowFunctionality_BE_TC_55(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 31)
    public void buyELoadContactsPermissionPopup_BE_TC_56() throws Exception {
        buyEloadClass.buyELoadContactsPermissionPopup_BE_TC_56(prop.getproperty("Fully_Verified"));
    }

    @Test(priority = 32)
    public void buyELoadContactPermissionPopupAllowBtnFunctionality_BE_TC_57() throws Exception {
        buyEloadClass.buyELoadContactPermissionPopupAllowBtnFunctionality_BE_TC_57();
    }

    @Test(priority = 33)
    public void buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_58() throws Exception {
        buyEloadClass.buyELoadContactPermissionPopupDenyBtnFunctionality_BE_TC_58();
    }

    @Test(priority = 34)
    public void buyELoadContactPermissionTwoDenyBtnFunctionality_BE_TC_59() throws Exception {
        buyEloadClass.buyELoadContactPermissionTwoDenyBtnFunctionality_BE_TC_59();
    }

    @Test(priority = 35)
    public void buyELoadContactPermissionTwoAllowBtnFunctionality_BE_TC_60() throws Exception {
        buyEloadClass.buyELoadContactPermissionTwoAllowBtnFunctionality_BE_TC_60();
    }

    @Test(priority = 36)
    public void buyELoadInternetInterruptionWhileEnteringOTP_BE_TC_61() throws Exception {
        buyEloadClass.buyELoadInternetInterruptionWhileEnteringOTP_BE_TC_61(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 37)
    public void buyELoadLocationPermissionAskMeLaterButtonFunctionality_BE_TC_62() throws Exception {
        buyEloadClass.buyELoadLocationPermissionAskMeLaterButtonFunctionality_BE_TC_62();
    }

    @Test(priority = 38)
    public void buyELoadLocationPermissionTwoDenyBtnFunctionality_BE_TC_63() throws Exception {
        buyEloadClass.buyELoadLocationPermissionTwoDenyBtnFunctionality_BE_TC_63();
    }

    @Test(priority = 39)
    public void buyELoadLocationPermissionTwoAllowBtnFunctionality_BE_TC_64() throws Exception {
        buyEloadClass.buyELoadLocationPermissionTwoAllowBtnFunctionality_BE_TC_64();
    }

    @Test(priority = 40)
    public void buyELoadContactPopupNotDisplayedAfterClickingODenyButtonValidation_BE_TC_65() throws Exception {
        buyEloadClass.buyELoadContactPopupNotDisplayedAfterClickingODenyButtonValidation_BE_TC_65();
    }

    @Test(priority = 41)
    public void buyELoadNewTransactionBtnFunctionality_BE_TC_66() throws Exception {
        buyEloadClass.buyELoadNewTransactionBtnFunctionality_BE_TC_66();
    }

    @Test(priority = 42)
    public void buyELoadTransactionValidationAfterMinimizingApp_BE_TC_069() throws Exception {
        buyEloadClass.buyELoadTransactionValidationAfterMinimizingApp_BE_TC_069(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 43)
    public void buyELoadTransactionWithValidMLPin_BE_TC_78() throws Exception {
        buyEloadClass.buyELoadTransactionWithValidMLPin_BE_TC_78(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 44)
    public void buyELoadTransactionWithInValidMLPin_BE_TC_79() throws Exception {
        buyEloadClass.buyELoadTransactionWithInValidMLPin_BE_TC_79(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 45)
    public void buyELoadInOTPPopupValidation_BE_TC_089() throws Exception {
        buyEloadClass.buyELoadInOTPPopupValidation_BE_TC_089(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 46)
    public void buyELoadTransactionInAppOTPPopupUIValidation_BE_TC_090() throws Exception {
        buyEloadClass.buyELoadTransactionInAppOTPPopupUIValidation_BE_TC_090(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 47)
    public void buyELoadTransactionNewOTPAfterSixtySecondsValidation_BE_TC_091() throws Exception {
        buyEloadClass.buyELoadTransactionNewOTPAfterSixtySecondsValidation_BE_TC_091(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 48)
    public void buyELoadTransactionOTPCancelBtnFunctionality_BE_TC_092() throws Exception {
        buyEloadClass.buyELoadTransactionOTPCancelBtnFunctionality_BE_TC_092(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 49)
    public void buyELoadTransactionOTPContinueBtnFunctionality_BE_TC_093() throws Exception {
        buyEloadClass.buyELoadTransactionOTPContinueBtnFunctionality_BE_TC_093(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 50)
    public void buyELoadMaximumTransactionForBranchVerifiedTier_BE_TC_42() throws Exception {
        buyEloadClass.buyELoadMaximumTransactionForBranchVerifiedTier_BE_TC_42(prop.getproperty("Branch_Verified"), 2);
    }

    @Test(priority = 51)
    public void buyELoadMaximumLimitForSemiVerifiedTier_BE_TC_33() throws Exception {
        buyEloadClass.buyELoadMaximumLimitForSemiVerifiedTier_BE_TC_33(prop.getproperty("Semi_Verified"), 2);
    }
    @Test(priority = 52)
    public void buyELoadMaximumTransactionForSemiVerifiedTier_BE_TC_30() throws Exception {
        buyEloadClass.buyELoadMaximumTransactionForSemiVerifiedTier_BE_TC_30(prop.getproperty("Semi_Verified"), 2);
    }

    @Test(priority = 53)
    public void buyELoadMaximumLimitForFullyVerifiedTier_BE_TC_39() throws Exception {
        buyEloadClass.buyELoadMaximumLimitForFullyVerifiedTier_BE_TC_39(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 54)
    public void buyELoadMaximumTransactionForFullyVerifiedTier_BE_TC_36() throws Exception {
        buyEloadClass.buyELoadMaximumTransactionForFullyVerifiedTier_BE_TC_36(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 55)
    public void buyELoadMaximumLimitForBuyerTierVerifiedTier_BE_TC_45() throws Exception {
        buyEloadClass.buyELoadMaximumLimitForBuyerTierVerifiedTier_BE_TC_45(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 56)
    public void buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_48() throws Exception {
        buyEloadClass.buyELoadMaximumTransactionForBuyerTierVerifiedTier_BE_TC_48(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 57)
    public void buyELoadSecondTimeLoadSelectionPopupValidation_BE_TC_29() throws Exception {
        buyEloadClass.buyELoadSecondTimeLoadSelectionPopupValidation_BE_TC_29(prop.getproperty("Fully_Verified"), 2);
    }

    @Test(priority = 58)
    public void buyELoadMLPinPageNavigation_BE_TC_87() throws Exception {
        buyEloadClass.buyELoadMLPinPageNavigation_BE_TC_87("9999999999",2);
    }







    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }





}
