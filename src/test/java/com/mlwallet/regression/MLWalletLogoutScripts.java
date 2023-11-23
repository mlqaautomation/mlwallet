package com.mlwallet.regression;

import com.business.mlwallet.LogoutClass;
import com.driverInstance.AppiumServer;
import jdk.jpackage.internal.Log;
import org.testng.annotations.*;

public class MLWalletLogoutScripts {

    public static String deviceName;
    public static String portno;
    public static LogoutClass logoutClass;
    


    //@BeforeSuite(groups = { "All" })
    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletLogoutScripts.deviceName=deviceName;
        MLWalletLogoutScripts.portno= portno;
        logoutClass = new LogoutClass("MLWallet",deviceName,portno);
    }

//=======================================================================================================================//


    @Test(priority = 1)
    public void logOutMinimizeAndRelaunch_Lout_TC_03() throws Exception {
        logoutClass.logOutMinimizeAndRelaunch_Lout_TC_03();
    }

    @Test(priority = 2)
    public void logOutAppKillAndRelaunch() throws Exception {
        logoutClass.logOutAppKillAndRelaunch_Lout_TC_04();
    }

    @Test(priority = 3)
    public void logOUtPopUpValidation_Lout_TC_05() throws Exception {
        logoutClass.logOUtPopUpValidation_Lout_TC_05();
    }

    @Test(priority = 4)
    public void logOutPopUpCancelBtnValidation_Lout_TC_06() throws Exception {
        logoutClass.logOutPopUpCancelBtnValidation_Lout_TC_06();
    }

    @Test(priority = 5)
    public void logOutPopUpLogOutBtnValidation_Lout_TC_07() throws Exception {
        logoutClass.logOutPopUpLogOutBtnValidation_Lout_TC_07();
    }

    @Test(priority = 6)
    public void logoutChangeNumberUIValidation_Lout_TC_08() throws Exception {
        logoutClass.logoutChangeNumberUIValidation_Lout_TC_08();
    }

    @Test(priority = 7)
    public void logInWithChangeNumber_Lout_TC_09() throws Exception {
        logoutClass.logInWithChangeNumber_Lout_TC_09();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }



}
