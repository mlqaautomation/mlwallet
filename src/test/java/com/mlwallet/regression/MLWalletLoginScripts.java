package com.mlwallet.regression;

import org.testng.annotations.*;
import com.driverInstance.AppiumServer;
import static com.utility.Utilities.setWifiConnectionToONOFF;


public class MLWalletLoginScripts extends BaseTest{
    @Test(priority = 1)
    public void LogInScenarioWithValidMobNumber()throws Exception{
        mlWalletLogin.logInScenarioWithValidMobNumber_Lgn_TC_01();
    }
    @Test(priority = 2)
    public void LogInScenarioWithInvalidMobNumber() throws Exception {
        mlWalletLogin.logInScenarioWithInvalidMobNumber_Lgn_TC_02();
    }
    @Test(priority = 3)
    public void LogInScenarioWithValidOTP() throws Exception {
        mlWalletLogin.logInScenarioWithValidOTP_Lgn_TC_03();
    }
    @Test(priority = 4)
    public void appLaunch_Lgn_TC_05() throws Exception {
        mlWalletLogin.appLaunch_Lgn_TC_05();
    }

    @Test(priority = 5)
    public void loginPageUIValidation_Lgn_TC_06() throws Exception {
        mlWalletLogin.loginPageUIValidation_Lgn_TC_06();
    }

    @Test(priority = 6)
    public void loginTroubleSigningIn_Lgn_TC_07() throws Exception {
        mlWalletLogin.loginTroubleSigningIn_Lgn_TC_07();
    }

    @Test(priority = 7)
    public void loginCreateOne_Lgn_TC_08() throws Exception {
        mlWalletLogin.loginCreateOne_Lgn_TC_08();
    }

    @Test(priority = 8)
    public void loginBranchLocator_Lgn_TC_09() throws Exception {
        mlWalletLogin.loginBranchLocator_Lgn_TC_09();
    }

    @Test(priority = 9)
    public void loginOTPPageUIValidation_Lgn_TC_10() throws Exception {
        mlWalletLogin.loginOTPPageUIValidation_Lgn_TC_10();
    }


    @Test(priority = 10)
    public void logInScenarioWithInvalidMobNumber_Lgn_TC_15() throws Exception {
        mlWalletLogin.logInScenarioWithInvalidMobNumber_Lgn_TC_15();
    }


    @Test(priority = 11)
    public void loginWithExistingMobileNumber_Lgn_TC_17() throws Exception {
        mlWalletLogin.loginWithExistingMobileNumber_Lgn_TC_17();
    }

    @Test(priority = 12)
    public void loginMPinPageUIValidation_Lgn_TC_18() throws Exception {
        mlWalletLogin.loginMPinPageUIValidation_Lgn_TC_18();
    }

//    @Test(priority = 13)
//    public void loginNetworkInterruptionValidation_Lgn_TC_19() throws Exception {
//        mlWalletLogin.loginNetworkInterruptionWhileLoggingInValidation_Lgn_TC_19(prop.getproperty("Branch_Verified"));
//    }

//    @Test(priority = 14)
//    public void loginInternetInterruptionWhileLaunchingApp_Lgn_TC_20() throws Exception {
//        mlWalletLogin.loginInternetInterruptionWhileLaunchingApp_Lgn_TC_20();
//        setWifiConnectionToONOFF("ON");
//    }

    @Test(priority = 15)
    public void loginInAppOTPNavigation_Lgn_TC_22() throws Exception {
        mlWalletLogin.loginInAppOTPNavigation_Lgn_TC_22();
    }

    @Test(priority = 16)
    public void loginInAppOTPPageUIValidation_Lgn_TC_23() throws Exception {
        mlWalletLogin.loginInAppOTPPageUIValidation_Lgn_TC_23();
    }

    @Test(priority = 17)
    public void loginNewOTPAfterSixtySecondsValidation_Lgn_TC_24() throws Exception {
        mlWalletLogin.loginNewOTPAfterSixtySecondsValidation_Lgn_TC_24();
    }

    @Test(priority = 18)
    public void loginOTPCancelBtnFunctionality_Lgn_TC_25() throws Exception {
        mlWalletLogin.loginOTPCancelBtnFunctionality_Lgn_TC_25();
    }

    @Test(priority = 19)
    public void loginOTPContinueBtnFunctionality_Lgn_TC_26() throws Exception {
        mlWalletLogin.loginOTPContinueBtnFunctionality_Lgn_TC_26();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
