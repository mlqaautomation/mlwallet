package com.mlwallet.regression;


import com.driverInstance.AppiumServer;
import org.testng.annotations.*;
import com.business.mlwallet.TroubleSigningInClass;

public class MLWalletTroubleSingingIn {
    public static String deviceName;
    public static String portno;
//    public  static com.business.mlwallet.MLWalletBusinessLogic MLWalletBusinessLogic;
public static TroubleSigningInClass troubleSigningInClass;





    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletTroubleSingingIn.deviceName=deviceName;
        MLWalletTroubleSingingIn.portno= portno;
        troubleSigningInClass = new TroubleSigningInClass("MLWallet",deviceName,portno);
    }

    @Test(priority = 1)
    public void troubleSigningInPageNavigationFromMpinScreen_TS_TC_01() throws Exception {
        troubleSigningInClass.troubleSigningInPageNavigationFromMpinScreen_TS_TC_01();
    }

    @Test(priority = 2)
    public void troubleSigningInPageNavigationFromLoginScreen_TS_TC_10() throws Exception {
        troubleSigningInClass.troubleSigningInPageNavigationFromLoginScreen_TS_TC_10();
    }

    @Test(priority = 3)
    public void troubleSigningInPageBackArrowBtnFunctionality_TS_TC_11() throws Exception {
        troubleSigningInClass.troubleSigningInPageBackArrowBtnFunctionality_TS_TC_11();
    }

    @Test(priority = 4)
    public void troubleSigningInClearFormFunctionality_TS_TC_12() throws Exception {
        troubleSigningInClass.troubleSigningInClearFormFunctionality_TS_TC_12();
    }

    @Test(priority = 5)
    public void troubleSigningInClearFormButtonOnClearFormPopupFunctionality_TS_TC_13() throws Exception {
        troubleSigningInClass.troubleSigningInClearFormButtonOnClearFormPopupFunctionality_TS_TC_13();
    }

    @Test(priority = 6)
    public void troubleSigningInCancelButtonOnClearFormPopupFunctionality_TS_TC_14() throws Exception {
        troubleSigningInClass.troubleSigningInCancelButtonOnClearFormPopupFunctionality_TS_TC_14();
    }


    @Test(priority = 7)
    public void troubleSigningInEmptyFullNameFunctionality_TS_TC_15() throws Exception {
        troubleSigningInClass.troubleSigningInEmptyFullNameFunctionality_TS_TC_15();
    }

    @Test(priority = 8)
    public void troubleSigningInEmptyRegisteredEmailFunctionality_TS_TC_16() throws Exception {
        troubleSigningInClass.troubleSigningInEmptyRegisteredEmailFunctionality_TS_TC_16();
    }

    @Test(priority = 9)
    public void troubleSigningInEmptyRegisteredMobileNumberFunctionality_TS_TC_17() throws Exception {
        troubleSigningInClass.troubleSigningInEmptyRegisteredMobileNumberFunctionality_TS_TC_17();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }


}
