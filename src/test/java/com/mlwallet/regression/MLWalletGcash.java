package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletGcash extends BaseTest{

    @Test(priority = 1)
    public void GC_SM_TC_132_SendMoney_as_SemiVerified()throws Exception{
        mlWalletGCash.GC_SM_TC_132_SendMoney_as_SemiVerified();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }
}
