package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

public class MLWalletTroubleSingingIn extends BaseTest{
   
    @Test(priority = 1)
    public void troubleSigningInPageNavigationFromMpinScreen_TS_TC_01() throws Exception {
        mlWalletTroubleSignIn.troubleSigningInPageNavigationFromMpinScreen_TS_TC_01();
    }

    @Test(priority = 2)
    public void troubleSigningInPageNavigationFromLoginScreen_TS_TC_10() throws Exception {
        mlWalletTroubleSignIn.troubleSigningInPageNavigationFromLoginScreen_TS_TC_10();
    }

    @Test(priority = 3)
    public void troubleSigningInPageBackArrowBtnFunctionality_TS_TC_11() throws Exception {
        mlWalletTroubleSignIn.troubleSigningInPageBackArrowBtnFunctionality_TS_TC_11();
    }

    @Test(priority = 4)
    public void troubleSigningInClearFormFunctionality_TS_TC_12() throws Exception {
        mlWalletTroubleSignIn.troubleSigningInClearFormFunctionality_TS_TC_12();
    }

    @Test(priority = 5)
    public void troubleSigningInClearFormButtonOnClearFormPopupFunctionality_TS_TC_13() throws Exception {
        mlWalletTroubleSignIn.troubleSigningInClearFormButtonOnClearFormPopupFunctionality_TS_TC_13();
    }

    @Test(priority = 6)
    public void troubleSigningInCancelButtonOnClearFormPopupFunctionality_TS_TC_14() throws Exception {
        mlWalletTroubleSignIn.troubleSigningInCancelButtonOnClearFormPopupFunctionality_TS_TC_14();
    }


    @Test(priority = 7)
    public void troubleSigningInEmptyFullNameFunctionality_TS_TC_15() throws Exception {
        mlWalletTroubleSignIn.troubleSigningInEmptyFullNameFunctionality_TS_TC_15();
    }

    @Test(priority = 8)
    public void troubleSigningInEmptyRegisteredEmailFunctionality_TS_TC_16() throws Exception {
        mlWalletTroubleSignIn.troubleSigningInEmptyRegisteredEmailFunctionality_TS_TC_16();
    }

    @Test(priority = 9)
    public void troubleSigningInEmptyRegisteredMobileNumberFunctionality_TS_TC_17() throws Exception {
        mlWalletTroubleSignIn.troubleSigningInEmptyRegisteredMobileNumberFunctionality_TS_TC_17();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
