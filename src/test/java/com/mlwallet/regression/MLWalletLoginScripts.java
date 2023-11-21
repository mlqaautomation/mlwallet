package com.mlwallet.regression;

import com.business.mlwallet.LoginClass;
import com.driverInstance.DriverInstance;
import com.driverInstance.DriverManager;
import com.mlwallet.pages.MLWalletLoginPage;
import org.testng.annotations.*;
import com.driverInstance.AppiumServer;
import static com.business.mlwallet.LoginClass.prop;
import static com.utility.Utilities.setWifiConnectionToONOFF;
import com.business.mlwallet.LoginClass;

public class MLWalletLoginScripts {
    public static String deviceName;
    public static String portno;
    public  static com.business.mlwallet.LoginClass LoginClass;

    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletLoginScripts.deviceName=deviceName;
        MLWalletLoginScripts.portno= portno;
       // LoginClass = new LoginClass("MLWallet",deviceName,portno);
        LoginClass = new LoginClass("MLWallet",deviceName,portno);
    }

//====================================================================================================//
    @Test(priority = 1)
    public void LogInScenarioWithValidMobNumber()throws Exception{
        LoginClass.logInScenarioWithValidMobNumber_Lgn_TC_01();
    }
//    @Test(priority = 1)
//    public void LogInScenarioWithValidMobNumber() throws Exception
//    {
//        LoginClass.logInScenarioWithValidMobNumber_Lgn_TC_01();
//    }
    @Test(priority = 2)
    public void LogInScenarioWithInvalidMobNumber() throws Exception {
        LoginClass.logInScenarioWithInvalidMobNumber_Lgn_TC_02();
    }
    @Test(priority = 3)
    public void LogInScenarioWithValidOTP() throws Exception {
        LoginClass.logInScenarioWithValidOTP_Lgn_TC_03();
    }
////==============================================================================================================//
////
//
//
    @Test(priority = 4)
    public void appLaunch_Lgn_TC_05() throws Exception {
        LoginClass.appLaunch_Lgn_TC_05();
    }

    @Test(priority = 5)
    public void loginPageUIValidation_Lgn_TC_06() throws Exception {
        LoginClass.loginPageUIValidation_Lgn_TC_06();
    }

    @Test(priority = 6)
    public void loginTroubleSigningIn_Lgn_TC_07() throws Exception {
        LoginClass.loginTroubleSigningIn_Lgn_TC_07();
    }

    @Test(priority = 7)
    public void loginCreateOne_Lgn_TC_08() throws Exception {
        LoginClass.loginCreateOne_Lgn_TC_08();
    }

    @Test(priority = 8)
    public void loginBranchLocator_Lgn_TC_09() throws Exception {
        LoginClass.loginBranchLocator_Lgn_TC_09();
    }

    @Test(priority = 9)
    public void loginOTPPageUIValidation_Lgn_TC_10() throws Exception {
        LoginClass.loginOTPPageUIValidation_Lgn_TC_10();
    }


    @Test(priority = 10)
    public void logInScenarioWithInvalidMobNumber_Lgn_TC_15() throws Exception {
        LoginClass.logInScenarioWithInvalidMobNumber_Lgn_TC_15();
    }


    @Test(priority = 11)
    public void loginWithExistingMobileNumber_Lgn_TC_17() throws Exception {
        LoginClass.loginWithExistingMobileNumber_Lgn_TC_17();
    }

    @Test(priority = 12)
    public void loginMPinPageUIValidation_Lgn_TC_18() throws Exception {
        LoginClass.loginMPinPageUIValidation_Lgn_TC_18();
    }

//    @Test(priority = 13)
//    public void loginNetworkInterruptionValidation_Lgn_TC_19() throws Exception {
//        LoginClass.loginNetworkInterruptionWhileLoggingInValidation_Lgn_TC_19(prop.getproperty("Branch_Verified"));
//    }
//
//    @Test(priority = 14)
//    public void loginInternetInterruptionWhileLaunchingApp_Lgn_TC_20() throws Exception {
//        LoginClass.loginInternetInterruptionWhileLaunchingApp_Lgn_TC_20();
//        setWifiConnectionToONOFF("ON");
//    }

    @Test(priority = 15)
    public void loginInAppOTPNavigation_Lgn_TC_22() throws Exception {
        setWifiConnectionToONOFF("ON");
        LoginClass.loginInAppOTPNavigation_Lgn_TC_22();
    }

    @Test(priority = 16)
    public void loginInAppOTPPageUIValidation_Lgn_TC_23() throws Exception {
        LoginClass.loginInAppOTPPageUIValidation_Lgn_TC_23();
    }

    @Test(priority = 17)
    public void loginNewOTPAfterSixtySecondsValidation_Lgn_TC_24() throws Exception {
        LoginClass.loginNewOTPAfterSixtySecondsValidation_Lgn_TC_24();
    }

    @Test(priority = 18)
    public void loginOTPCancelBtnFunctionality_Lgn_TC_25() throws Exception {
        LoginClass.loginOTPCancelBtnFunctionality_Lgn_TC_25();
    }

    @Test(priority = 19)
    public void loginOTPContinueBtnFunctionality_Lgn_TC_26() throws Exception {
        LoginClass.loginOTPContinueBtnFunctionality_Lgn_TC_26();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
