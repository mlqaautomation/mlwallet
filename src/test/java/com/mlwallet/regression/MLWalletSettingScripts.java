package com.mlwallet.regression;


import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

import com.business.mlwallet.SettingsClass;
public class MLWalletSettingScripts {

    public static String deviceName;
    public static String portno;
    //public  static com.business.mlwallet.settingsClass settingsClass;
    public static SettingsClass settingsClass;


    //@BeforeSuite(groups = { "All" })
    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletSettingScripts.deviceName=deviceName;
        MLWalletSettingScripts.portno= portno;
        //settingsClass = new settingsClass("MLWallet",deviceName,portno);
        settingsClass = new SettingsClass("MLWallet",deviceName,portno);
    }
//=========================================================================================================//

    @Test(priority = 1)
    public void accountDetails_SS_TC_01() throws Exception {
        //settingsClass.settingsAccountDetailsValidation_SS_TC_01();
        settingsClass.settingsAccountDetailsValidation_SS_TC_01();
    }
//
    @Test(priority = 2)
    public void settingsValidMLPinValidation_SS_TC_02() throws Exception {
        settingsClass.settingsValidMLPinValidation_SS_TC_02();
    }

    @Test(priority = 3)
    public void settingsInvalidMLPinValidation_SS_TC_03() throws Exception {
        settingsClass.settingsInvalidMLPinValidation_SS_TC_03();
    }

    @Test(priority = 4)
    public void settingsBiometricsLogin_SS_TC_04() throws Exception {
        settingsClass.settingsBiometricsLogin_SS_TC_04();
    }

    @Test(priority = 5)
    public void settingAccRecovery_SS_TC_05() throws Exception {
        settingsClass.settingAccRecovery_SS_TC_05();
    }


    @Test(priority = 6)
    public void settingsPageUIValidation_SS_TC_06() throws Exception {
        settingsClass.settingsPageUIValidation_SS_TC_06();
    }


    @Test(priority = 7)
    public void settingsBackBtnValidation_SS_TC_07() throws Exception {
        settingsClass.settingsBackBtnValidation_SS_TC_07();
    }


    @Test(priority = 8)
    public void settingsDeleteAccountPopUpUIValidation_SS_TC_10() throws Exception {
        settingsClass.settingsDeleteAccountPopUpUIValidation_SS_TC_10();
    }
    @Test(priority = 9)
    public void settingsChangeMLPinNavigation_SS_TC_12() throws Exception {
        settingsClass.settingsChangeMLPinNavigation_SS_TC_12();
    }

    @Test(priority = 10)
    public void settingsChangeMlPinBackBtnValidation_SS_TC_13() throws Exception {
        settingsClass.settingsChangeMlPinBackBtnValidation_SS_TC_13();
    }

    @Test(priority = 11)
    public void settingsAccountDetailsNavigation_SS_TC_14() throws Exception {
        settingsClass.settingsAccountDetailsNavigation_SS_TC_14();
    }

    @Test(priority = 12)
    public void settingsAccountDetailsBackBtnValidation_SS_TC_15() throws Exception {
        settingsClass.settingsAccountDetailsBackBtnValidation_SS_TC_15();
    }

    @Test(priority = 13)
    public void settingChangeMLPinUIValidation_SS_TC_16() throws Exception {
        settingsClass.settingChangeMLPinUIValidation_SS_TC_16();
    }

    @Test(priority = 14)
    public void settingsAccountRecoveryUIValidation_SS_TC_17() throws Exception {
        settingsClass.settingsAccountRecoveryUIValidation_SS_TC_17();
    }

    @Test(priority = 15)
    public void settingsDeleteAccountCancelBtnValidation_SS_TC_18() throws Exception {
        settingsClass.settingsDeleteAccountCancelBtnValidation_SS_TC_18();
    }

    @Test(priority = 16)
    public void settingsBiometricsLoginUIValidation_SS_TC_20() throws Exception {
        settingsClass.settingsBiometricsLoginUIValidation_SS_TC_20();
    }

    @Test(priority = 17)
    public void settingsAccountRecoveryNavigation_SS_TC_21() throws Exception {
        settingsClass.settingsAccountRecoveryNavigation_SS_TC_21();
    }

    @Test(priority = 18)
    public void settingsTroubleSigningInBackBtnValidation_SS_TC_22() throws Exception {
        settingsClass.settingsTroubleSigningInBackBtnValidation_SS_TC_22();
    }

    @Test(priority = 19)
    public void settingsBiometricsLoginNavigation_SS_TC_23() throws Exception {
        settingsClass.settingsBiometricsLoginNavigation_SS_TC_23();
    }

    @Test(priority = 20)
    public void settingsBiometricsLoginBackBtnValidation_SS_TC_24() throws Exception {
        settingsClass.settingsBiometricsLoginBackBtnValidation_SS_TC_24();
    }

    @Test(priority = 21)
    public void settingsDeleteAccountPageUIValidation_SS_TC_25() throws Exception {
        settingsClass.settingsDeleteAccountPageUIValidation_SS_TC_25();
    }

    @Test(priority = 22)
    public void settingsDeleteAccountIWantToStayButtonFunctionality_SS_TC_26() throws Exception {
        settingsClass.settingsDeleteAccountIWantToStayButtonFunctionality_SS_TC_26();
    }

    @Test(priority = 23)
    public void settingsDeleteAccountPageBackButtonValidation_SS_TC_27() throws Exception {
        settingsClass.settingsDeleteAccountPageBackButtonValidation_SS_TC_27();
    }

    @Test(priority = 24)
    public void settingsDeleteAccountButtonFunctionality_SS_TC_28() throws Exception {
        settingsClass.settingsDeleteAccountButtonFunctionality_SS_TC_28();
    }

    @Test(priority = 25)
    public void settingsDeleteAccountConfirmationPopupCancelBtnFunctionality_SS_TC_29() throws Exception {
        settingsClass.settingsDeleteAccountConfirmationPopupCancelBtnFunctionality_SS_TC_29();
    }

    @Test(priority = 26)
    public void settingsDeleteAccountConfirmationPopupProceedBtnFunctionality_SS_TC_30() throws Exception {
        settingsClass.settingsDeleteAccountConfirmationPopupProceedBtnFunctionality_SS_TC_30();
    }

    @Test(priority = 27)
    public void settingsDeleteAccountMLPinPageUIValidation_SS_TC_31() throws Exception {
        settingsClass.settingsDeleteAccountMLPinPageUIValidation_SS_TC_31();
    }

    @Test(priority = 28)
    public void settingsDeleteAccountMLPinPageBackArrowBtnFunctionality_SS_TC_32() throws Exception {
        settingsClass.settingsDeleteAccountMLPinPageBackArrowBtnFunctionality_SS_TC_32();
    }

    @Test(priority = 29)
    public void settingsDeleteAccountInvalidMLPin_SS_TC_34() throws Exception {
        settingsClass.settingsDeleteAccountInvalidMLPin_SS_TC_34();
    }

    @Test(priority = 30)
    public void settingsDeleteAccountInvalidMLPinPopupOkBtnFunctionality_SS_TC_35() throws Exception {
        settingsClass.settingsDeleteAccountInvalidMLPinPopupOkBtnFunctionality_SS_TC_35();
    }
    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }






}
