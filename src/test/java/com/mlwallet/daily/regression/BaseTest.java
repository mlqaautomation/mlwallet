package com.mlwallet.daily.regression;

import com.business.mlwallet.BaseClass;
import com.business.mlwallet.GCashClass;
import com.driverInstance.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;


public class BaseTest{
    protected String deviceName;
    protected String portno;
    protected com.business.mlwallet.GCashClass gCashClass;
    @Parameters({"deviceName", "portno"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(String deviceName, String portno) throws Exception {
        AppiumServer.startServer();
        this.deviceName=deviceName;
        this.portno=portno;
        gCashClass = new GCashClass("mlwallet", deviceName, portno);

    }
    @AfterMethod
    public void afterTest() {
        AppiumServer.stopServer();
    }
}
