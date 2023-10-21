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


//    @Test(priority = 15)
//    public void MLShop_Select14kMaterialDisplayProductionValidation_SI_TC_42() throws Exception
//    {
//        shopItems.MLShop_Select14kMaterialDisplayProductValidation_SI_TC_42();
//    }
//
//    @Test(priority = 16)
//    public void MLShop_Select18kMaterialDisplayProductionValidation_SI_TC_43() throws Exception
//    {
//        shopItems.MLShop_Select18kMaterialDisplayProductValidation_SI_TC_43();
//    }
//
//    @Test(priority = 17)
//    public void MLShop_Select20kMaterialDisplayProductionValidation_SI_TC_44() throws Exception
//    {
//        shopItems.MLShop_Select20kMaterialDisplayProductValidation_SI_TC_44();
//    }
//
//    @Test(priority = 18)
//    public void MLShop_Select21kMaterialDisplayProductionValidation_SI_TC_45() throws Exception
//    {
//        shopItems.MLShop_Select21kMaterialDisplayProductValidation_SI_TC_45();
//    }
//
//    @Test(priority = 19)
//    public void MLShop_Select22kMaterialDisplayProductionValidation_SI_TC_46() throws Exception
//    {
//        shopItems.MLShop_Select22kMaterialDisplayProductValidation_SI_TC_46();
//    }
//
//    @Test(priority = 20)
//    public void MLShop_Select12kMaterialDisplayProductionValidation_SI_TC_47() throws Exception
//    {
//        shopItems.MLShop_Select12kMaterialDisplayProductValidation_SI_TC_47();
//    }
//
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

    @Test(priority = 25)
    public void MLShop_SelectTriToneMaterialColorDisplayProductValidation_SI_TC_52() throws Exception
    {
        shopItems.MLShop_SelectTriToneMaterialColorDisplayProductValidation_SI_TC_52();
    }
    @Test(priority = 26)
    public void MLShop_FilteringLadiesProduct_SI_TC_53() throws Exception
    {
        shopItems.MLShop_FilteringLadiesProduct_SI_TC_53();
    }
    @Test(priority = 27)
    public void MLShop_FilteringMensProduct_SI_TC_54() throws Exception
    {
        shopItems.MLShop_FilteringMensProduct_SI_TC_54();
    }
    @Test(priority = 28)
    public void MLShop_FilteringUnisexProduct_SI_TC_55() throws Exception
    {
        shopItems.MLShop_FilteringUnisexProduct_SI_TC_55();
    }
    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
