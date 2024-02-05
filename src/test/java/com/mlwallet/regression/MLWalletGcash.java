package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletGcash extends BaseTest{

    @Test(priority = 1)
    public void GC_Land_TC_02()throws Exception{
        mlWalletGCash.GC_Land_TC_02();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }
}
