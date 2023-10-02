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
    @Test(priority = 1)
    public void MLShop_PurchaseItemViaMlWallet_TC_178() throws Exception
    {
        shopItems.MLShop_PurchaseItemViaMlWallet_TC_178();
    }

//    @Test(priority = 0)
//    public void shopItemsAddedItemInCartDeletedPopupValidationExitButton_MLS_TC_131() throws Exception
//    {
//
//    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
