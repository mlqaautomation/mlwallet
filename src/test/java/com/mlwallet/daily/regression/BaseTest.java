package com.mlwallet.daily.regression;

import com.business.mlwallet.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;


public class BaseTest extends BaseClass {
    protected com.business.mlwallet.BaseClass baseClass;
    @Parameters({"deviceName", "portno"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(String deviceName, String portno) throws Exception {
        baseClass = new BaseClass("mlwallet", deviceName, portno);
        propertyFileReader();
        softAssert = new SoftAssert();

    }
    @AfterMethod
    public void afterTest() {
        baseClass.tearDown();
    }
}
