package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.*;
public class HappyPathScripts extends BaseTest{
    @Test(priority = 1)
    public void GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page() throws Exception {
        mlWalletGCashScripts.GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page();
    }
    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }
}
//dem04