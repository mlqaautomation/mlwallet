package com.mlwallet.regression;


import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

public class MLWalletLogoutScripts extends BaseTest{
    
    @Test(priority = 1)
    public void logOutMinimizeAndRelaunch_Lout_TC_03() throws Exception {
        mlWalletLogout.logOutMinimizeAndRelaunch_Lout_TC_03();
    }

    @Test(priority = 2)
    public void logOutAppKillAndRelaunch() throws Exception {
        mlWalletLogout.logOutAppKillAndRelaunch_Lout_TC_04();
    }

    @Test(priority = 3)
    public void logOUtPopUpValidation_Lout_TC_05() throws Exception {
        mlWalletLogout.logOUtPopUpValidation_Lout_TC_05();
    }

    @Test(priority = 4)
    public void logOutPopUpCancelBtnValidation_Lout_TC_06() throws Exception {
        mlWalletLogout.logOutPopUpCancelBtnValidation_Lout_TC_06();
    }

    @Test(priority = 5)
    public void logOutPopUpLogOutBtnValidation_Lout_TC_07() throws Exception {
        mlWalletLogout.logOutPopUpLogOutBtnValidation_Lout_TC_07();
    }

    @Test(priority = 6)
    public void logoutChangeNumberUIValidation_Lout_TC_08() throws Exception {
        mlWalletLogout.logoutChangeNumberUIValidation_Lout_TC_08();
    }

    @Test(priority = 7)
    public void logInWithChangeNumber_Lout_TC_09() throws Exception {
        mlWalletLogout.logInWithChangeNumber_Lout_TC_09();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }



}
