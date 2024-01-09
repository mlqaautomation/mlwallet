package com.mlwallet.regression;

import com.business.mlwallet.GCashClass;
import com.driverInstance.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MLWalletGcash {
    public static String deviceName;
    public static String portno;
    public static GCashClass gCashClass;
    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletCashOutViaBranch.deviceName=deviceName;
        MLWalletCashOutViaBranch.portno= portno;
        gCashClass = new GCashClass("MLWallet",deviceName,portno);

    }
    @Test(priority = 1)
    public void GC_SM_TC_132_SendMoney_as_SemiVerified()throws Exception{
        gCashClass.GC_SM_TC_132_SendMoney_as_SemiVerified();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }
}
