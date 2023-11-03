package com.mlwallet.daily.regression;

import com.business.mlwallet.ShopItemsClass;
import com.mlshop.MLShop_TestCases;
import com.driverInstance.AppiumServer;
import com.mlshop.MLShop_TestCases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MLShopItems {
    public static String deviceName;
    public static String portno;
    public static MLShop_TestCases shopItems;



    //@BeforeSuite(groups = { "All" })
    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLShopItems.deviceName=deviceName;
        MLShopItems.portno= portno;
        shopItems = new MLShop_TestCases("MLWallet",deviceName,portno);
    }

//    @Test(priority = 1)
//    public void MLShop_Homepage_TC_01() throws Exception
//    {
//        shopItems.MLShop_Homepage_TC_01();
//    }
//    @Test(priority = 2)
//    public void MLShop_Aboutpage_TC_02() throws Exception
//    {
//        shopItems.MLShop_Aboutpage_TC_02();
//    }
//    @Test(priority = 3)
//    public void MLShop_Contactpage_TC_03() throws Exception
//    {
//        shopItems.MLShop_Contactpage_TC_03();
//    }
//    @Test(priority = 4)
//
//    public void MLShop_ShopCart_TC_04() throws Exception
//    {
//        shopItems.MLShop_ShopCart_TC_04();
//    }
//    @Test(priority = 5)
//    public void MLShop_Profile_TC_05() throws Exception
//    {
//        shopItems.MLShop_Profile_TC_05();
//    }
//    @Test(priority = 6)
//
//    public void MLShop_PurchaseHistory_TC_06() throws Exception
//    {
//        shopItems.MLShop_PurchaseHistory_TC_06();
//    }
//    @Test(priority = 7)
//    public void MLShop_Logout_TC_07() throws Exception
//    {
//        shopItems.MLShop_Logout_TC_07();
//    }
//
//    @Test(priority = 8)
//    public void MLShop_ExitIcon_TC_13() throws Exception
//    {
//        shopItems.MLShop_ExitIcon_TC_13();
//    }
//
    @Test(priority = 1)
    public void MLShop_PurchaseItemViaMlWallet_TC_178() throws Exception
    {
        shopItems.MLShop_PurchaseItemViaMlWallet_TC_178();
    }


    @Test(priority = 2)
    public void MLShop_PaymongoPortalCreditDebit_TC_205() throws Exception
    {
        shopItems.MLShop_PaymongoPortalCreditDebit_TC_205();
    }

    @Test(priority = 3)
    public void MLShop_PaymongoPortalGrabPay_TC_206() throws Exception
    {
        shopItems.MLShop_PaymongoPortalGrabPay_TC_206();
    }

    @Test(priority = 4)
    public void MLShop_PaymongoPortalGcash_TC_207() throws Exception
    {
        shopItems.MLShop_PaymongoPortalGcash_TC_207();
    }
    @Test(priority = 5)
    public void MLShop_PaymongoPortalMaya_TC_208() throws Exception
    {
        shopItems.MLShop_PaymongoPortalMaya_TC_208();
    }
    @Test(priority = 6)
    public void MLShop_PaymongoPortalDirectOnlineBank_TC_209() throws Exception
    {
        shopItems.MLShop_PaymongoPortalDirectOnlineBank_TC_209();
    }

    @Test(priority = 7)
    public void MLShop_Homepage_TC_01() throws Exception
    {
        shopItems.MLShop_Homepage_TC_01();
    }
    @Test(priority = 8)
    public void MLShop_Aboutpage_TC_02() throws Exception
    {
        shopItems.MLShop_Aboutpage_TC_02();
    }

    @Test(priority = 9)
    public void MLShop_Contactpage_TC_03() throws Exception
    {
        shopItems.MLShop_Contactpage_TC_03();
    }

    @Test(priority = 10)
    public void MLShop_ShopCart_TC_04() throws Exception
    {
        shopItems.MLShop_ShopCart_TC_04();
    }
    @Test(priority = 11)
    public void MLShop_Profile_TC_05() throws Exception
    {
        shopItems.MLShop_Profile_TC_05();
    }
    @Test(priority = 12)
    public void MLShop_PurchaseHistory_TC_06() throws Exception
    {
        shopItems.MLShop_PurchaseHistory_TC_06();
    }
    @Test(priority = 13)
    public void MLShop_Logout_TC_07() throws Exception
    {
        shopItems.MLShop_Logout_TC_07();
    }

    @Test(priority = 14)
    public void MLShop_ExitIcon_TC_13() throws Exception
    {
        shopItems.MLShop_ExitIcon_TC_13();
    }

    @Test(priority = 15)
    public void MLShop_NecklaceCheckboxProductTypeUiValidation_TC_35() throws Exception
    {
        shopItems.MLShop_NecklaceCheckboxProductTypeUiValidation_TC_35();
    }

    @Test(priority = 16)
    public void MLShop_objBraceletAndBangleCheckboxProductTypeUiValidation_TC_36() throws Exception
    {
        shopItems.MLShop_objBraceletAndBangleCheckboxProductTypeUiValidation_TC_36();
    }

//    @Test(priority = 1)
//    public void MLShop_PurchaseItemViaMlWallet_TC_178() throws Exception
//    {
//        shopItems.MLShop_PurchaseItemViaMlWallet_TC_178();
//    }
//
//
//    @Test(priority = 2)
//    public void MLShop_PaymongoPortalCreditDebit_TC_205() throws Exception
//    {
//        shopItems.MLShop_PaymongoPortalCreditDebit_TC_205();
//    }
//
//    @Test(priority = 1)
//    public void MLShop_PaymongoPortalGrabPay_TC_206() throws Exception
//    {
//        shopItems.MLShop_PaymongoPortalGrabPay_TC_206();
//    }
//
//    @Test(priority = 4)
//    public void MLShop_PaymongoPortalGcash_TC_207() throws Exception
//    {
//        shopItems.MLShop_PaymongoPortalGcash_TC_207();
//    }
//    @Test(priority = 5)
//    public void MLShop_PaymongoPortalMaya_TC_208() throws Exception
//    {
//        shopItems.MLShop_PaymongoPortalMaya_TC_208();
//    }
//    @Test(priority = 6)
//    public void MLShop_PaymongoPortalDirectOnlineBank_TC_209() throws Exception
//    {
//        shopItems.MLShop_PaymongoPortalDirectOnlineBank_TC_209();
//    }
//
//    @Test(priority = 1)
//    public void MLShop_Select10kMaterialDisplayProductionValidation_SI_TC_41() throws Exception
//    {
//        shopItems.MLShop_Select10kMaterialDisplayProductionValidation_SI_TC_41();
//    }
//
//    @Test(priority = 2)
//    public void MLShop_Select14kMaterialDisplayProductionValidation_SI_TC_42() throws Exception
//    {
//        shopItems.MLShop_Select14kMaterialDisplayProductionValidation_SI_TC_42();
//    }
//
//    @Test(priority = 3)
//    public void MLShop_Select18kMaterialDisplayProductionValidation_SI_TC_43() throws Exception
//    {
//        shopItems.MLShop_Select18kMaterialDisplayProductionValidation_SI_TC_43();
//    }
//
//    @Test(priority = 4)
//    public void MLShop_Select20kMaterialDisplayProductionValidation_SI_TC_44() throws Exception
    @Test(priority = 17)
    public void MLShop_EarringsCheckboxProductTypeUiValidation_TC_37() throws Exception
    {
        shopItems.MLShop_EarringsCheckboxProductTypeUiValidation_TC_37();
    }

    @Test(priority = 18)
    public void MLShop_PendantCheckboxProductTypeUiValidation_TC_38() throws Exception
    {
        shopItems.MLShop_PendantCheckboxProductTypeUiValidation_TC_38();
    }

    @Test(priority = 19)
    public void MLShop_Select10kMaterialDisplayProductionValidation_SI_TC_41() throws Exception
    {
        shopItems.MLShop_Select10kMaterialDisplayProductionValidation_SI_TC_41();
    }

    @Test(priority = 20)
    public void MLShop_Select14kMaterialDisplayProductionValidation_SI_TC_42() throws Exception
    {
        shopItems.MLShop_Select14kMaterialDisplayProductionValidation_SI_TC_42();
    }

    @Test(priority = 21)
    public void MLShop_Select18kMaterialDisplayProductionValidation_SI_TC_43() throws Exception
    {
        shopItems.MLShop_Select18kMaterialDisplayProductionValidation_SI_TC_43();
    }

    @Test(priority = 22)
    public void MLShop_Select20kMaterialDisplayProductionValidation_SI_TC_44() throws Exception
    {
        shopItems.MLShop_Select20kMaterialDisplayProductionValidation_SI_TC_44();
    }

    @Test(priority = 23)
    public void MLShop_Select21kMaterialDisplayProductionValidation_SI_TC_45() throws Exception
    {
        shopItems.MLShop_Select21kMaterialDisplayProductionValidation_SI_TC_45();
    }

    @Test(priority = 24)
    public void MLShop_Select22kMaterialDisplayProductionValidation_SI_TC_46() throws Exception
    {
        shopItems.MLShop_Select22kMaterialDisplayProductionValidation_SI_TC_46();
    }

    @Test(priority = 25)
    public void MLShop_Select12kMaterialDisplayProductionValidation_SI_TC_47() throws Exception
    {
        shopItems.MLShop_Select12kMaterialDisplayProductionValidation_SI_TC_47();
    }

//    @Test(priority = 21)
//    public void MLShop_SelectYellowGoldMaterialColorDisplayProductValidation_SI_TC_48() throws Exception

//    {
//        shopItems.MLShop_SelectYellowGoldMaterialColorDisplayProductValidation_SI_TC_48();
//    }
//
//    @Test(priority = 22)
//    public void MLShop_SelectWhiteGoldMaterialColorDisplayProductValidation_SI_TC_49() throws Exception
//    {
//        shopItems.MLShop_SelectWhiteGoldMaterialColorDisplayProductValidation_SI_TC_49();
//    }
//
//    @Test(priority = 23)
//    public void MLShop_SelectRoseGoldMaterialColorDisplayProductValidation_SI_TC_50() throws Exception
//    {
//        shopItems.MLShop_SelectRoseGoldMaterialColorDisplayProductValidation_SI_TC_50();
//    }
//
//    @Test(priority = 24)
//    public void MLShop_SelectTwoToneMaterialColorDisplayProductValidation_SI_TC_51() throws Exception
//    {
//        shopItems.MLShop_SelectTwoToneMaterialColorDisplayProductValidation_SI_TC_51();
//    }
    //    @Test(priority = 8)
//    public void MLShop_SelectYellowGoldMaterialColorDisplayProductValidation_SI_TC_48() throws Exception
//    {
//        shopItems.MLShop_SelectYellowGoldMaterialColorDisplayProductValidation_SI_TC_48();
//    }
//
//    @Test(priority = 9)
//    public void MLShop_SelectWhiteGoldMaterialColorDisplayProductValidation_SI_TC_49() throws Exception
//    {
//        shopItems.MLShop_SelectWhiteGoldMaterialColorDisplayProductValidation_SI_TC_49();
//    }
//
//    @Test(priority = 10)
//    public void MLShop_SelectRoseGoldMaterialColorDisplayProductValidation_SI_TC_50() throws Exception
//    {
//        shopItems.MLShop_SelectRoseGoldMaterialColorDisplayProductValidation_SI_TC_50();
//    }
//
//    @Test(priority = 11)
//    public void MLShop_SelectTwoToneMaterialColorDisplayProductValidation_SI_TC_51() throws Exception
//    {
//        shopItems.MLShop_SelectTwoToneMaterialColorDisplayProductValidation_SI_TC_51();
//    }
//
//    @Test(priority = 12)
//    public void MLShop_SelectTriToneMaterialColorDisplayProductValidation_SI_TC_52() throws Exception
//    {
//        shopItems.MLShop_SelectTriToneMaterialColorDisplayProductValidation_SI_TC_52();
//    }


//    @Test(priority = 13)
//    public void MLShop_FilteringLadiesProduct_SI_TC_53() throws Exception
//    {
//        shopItems.MLShop_FilteringLadiesProduct_SI_TC_53();
//    }
//    @Test(priority = 14)
//    public void MLShop_FilteringMensProduct_SI_TC_54() throws Exception
//    {
//        shopItems.MLShop_FilteringMensProduct_SI_TC_54();
//    }
//    @Test(priority = 15)
//    public void MLShop_FilteringUnisexProduct_SI_TC_55() throws Exception {
//        shopItems.MLShop_FilteringUnisexProduct_SI_TC_55();
//
//    }
//    @Test(priority = 1)
//    public void MLShop_NecklaceCheckboxProductTypeUiValidation_TC_35() throws Exception
//    {
//        shopItems.MLShop_NecklaceCheckboxProductTypeUiValidation_TC_35();
//    }
//    @Test(priority = 2)
//    public void MLShop_objBraceletAndBangleCheckboxProductTypeUiValidation_TC_36() throws Exception
//    {
//        shopItems.MLShop_objBraceletAndBangleCheckboxProductTypeUiValidation_TC_36();
//    }
//    @Test(priority = 3)
//    public void MLShop_EarringsCheckboxProductTypeUiValidation_TC_37() throws Exception
//    {
//        shopItems.MLShop_EarringsCheckboxProductTypeUiValidation_TC_37();
//    }
//    @Test(priority = 4)
//    public void MLShop_PendantCheckboxProductTypeUiValidation_TC_38() throws Exception
//    {
//        shopItems.MLShop_PendantCheckboxProductTypeUiValidation_TC_38();
//    }
//    @Test(priority = 5)
//    public void MLShop_SetsCheckboxProductTypeUiValidation_TC_39() throws Exception
//    {
//        shopItems.MLShop_SetsCheckboxProductTypeUiValidation_TC_39();
//    }
//    @Test(priority = 6)
//    public void MLShop_BrouchCheckboxProductTypeUiValidation_TC_40() throws Exception
//    {
//        shopItems.MLShop_BrouchCheckboxProductTypeUiValidation_TC_40();
//    }

//    @Test(priority = 1)
//    public void MLShop_AddToCartConfirmationMessageValidation_SI_TC_98() throws Exception
//    {
//        shopItems.MLShop_AddToCartConfirmationMessageValidation_SI_TC_98();
//    }
//
//    @Test(priority = 1)
//    public void MLShop_AlreadyInCartConfirmationMessageValidation_SI_TC_99() throws Exception
//    {
//        shopItems.MLShop_AlreadyInCartConfirmationMessageValidation_SI_TC_99();
//    }
//
//    @Test(priority = 1)
//    public void MLShop_UpdateItemCountInShoppingCartValidation_SI_TC_100() throws Exception
//    {
//        shopItems.MLShop_UpdateItemCountInShoppingCartValidation_SI_TC_100();
//    }
//    @Test(priority = 1)
//    public void MLShop_ProductDetailsDisplayVadation_SI_TC_105() throws Exception
//    {
//        shopItems.MLShop_ProductDetailsDisplayValidation_SI_TC_105();
//    }
//    @Test(priority = 1)
//    public void MLShop_VerifyAddedProductIntTheCartValidation_SI_TC_107() throws Exception
//    {
//        shopItems.MLShop_VerifyAddedProductIntTheCartValidation_SI_TC_107();
//    }
//    @Test(priority = 1)
//    public void MLShop_RemoveConfirmationPopUpDisplayValidationSI_TC_108() throws Exception
//    {
//        shopItems.MLShop_RemoveConfirmationPopUpDisplayValidationSI_TC_108();
//    }
//    @Test(priority = 1)
//    public void MLShop_VerifyIfCheckedBoxInitiallyCheckedValidation_SI_TC_112() throws Exception
//    {
//        shopItems.MLShop_VerifyIfCheckedBoxInitiallyCheckedValidation_SI_TC_112();
//    }
    @Test(priority = 1)
    public void MLShop_RedirectToGrabPayPortalValidationSI_TC_216() throws Exception

    @Test(priority = 26)
    public void MLShop_SelectTriToneMaterialColorDisplayProductValidation_SI_TC_52() throws Exception
    {
        shopItems.MLShop_SelectTriToneMaterialColorDisplayProductValidation_SI_TC_52();
    }
    @Test(priority = 27)
    public void MLShop_FilteringLadiesProduct_SI_TC_53() throws Exception
    {
        shopItems.MLShop_FilteringLadiesProduct_SI_TC_53();
    }
    @Test(priority = 28)
    public void MLShop_FilteringMensProduct_SI_TC_54() throws Exception

    {
        shopItems.MLShop_RedirectToGrabPayPortalValidationSI_TC_216();
    }

    @Test(priority = 2)
    public void MLShop_RedirectToPayMayaPortalValidationSI_TC_218() throws Exception

    @Test(priority = 29)
    public void MLShop_FilteringUnisexProduct_SI_TC_55() throws Exception

    {
        shopItems.MLShop_RedirectToPayMayaPortalValidationSI_TC_218();
    }

    @Test(priority = 30)
    public void MLShop_WalletDeductOnSuccessPurchased_TC_202() throws Exception{
        shopItems.MLShop_WalletDeductOnSuccessPurchased_TC_202();
    }
    @Test(priority = 31)
    public void MLShop_SuccessfullyPurchasedGCash_TC_308() throws Exception{
        shopItems.MLShop_SuccessfullyPurchasedGCash_TC_308();
    }
    @Test(priority = 32)
    public void MLShop_SuccessfullyPurchasedGrabPay_TC_309() throws Exception{
        shopItems.MLShop_SuccessfullyPurchasedGrabPay_TC_309();
    }
    @Test(priority = 33)
    public void MLShop_SuccessfullyPurchasedPaymaya_TC_310() throws Exception{
        shopItems.MLShop_SuccessfullyPurchasedPaymaya_TC_310();
    }
    @Test(priority = 34)
    public void MLShop_SuccessfullyPurchasedVisaMastercard_TC_311() throws Exception{
        shopItems.MLShop_SuccessfullyPurchasedVisaMastercard_TC_311();
    }
    @Test(priority = 35)
    public void MLShop_PaymongoVerifyListOfPaymentMethod_TC_204() throws Exception{
        shopItems.MLShop_PaymongoVerifyListOfPaymentMethod_TC_204();
    }
    @Test(priority = 36)
    public void shopItemsJewelryAvailabilityProductTypesUIValidation_MLS_TC_18() throws Exception{
        shopItems.shopItemsJewelryAvailabilityProductTypesUIValidation_MLS_TC_18();
    }

    @Test(priority = 37)
    public void shopItemsSelectedItemScreenRingsDetailsUIValidation_MLS_TC_20() throws Exception{
        shopItems.shopItemsSelectedItemScreenRingsDetailsUIValidation_MLS_TC_20();
    }
    @Test(priority = 38)
    public void shopItemsSelectedItemScreenBraceletAndBangleDetailsUIValidation_MLS_TC_21() throws Exception{
        shopItems.shopItemsSelectedItemScreenBraceletAndBangleDetailsUIValidation_MLS_TC_21();
    }
    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
