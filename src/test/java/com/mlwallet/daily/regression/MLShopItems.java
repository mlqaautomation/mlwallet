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

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
