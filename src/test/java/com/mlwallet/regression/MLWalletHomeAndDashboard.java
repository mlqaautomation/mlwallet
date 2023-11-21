package com.mlwallet.regression;


import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

import com.business.mlwallet.HomeAndDashboardClass;

public class MLWalletHomeAndDashboard {
    public static String deviceName;
    public static String portno;
    public static HomeAndDashboardClass HomeAndDashboard;


    //@BeforeSuite(groups = { "All" })
    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletHomeAndDashboard.deviceName=deviceName;
        MLWalletHomeAndDashboard.portno= portno;
//        HomeAndDashboard = new HomeAndDashboard("MLWallet",deviceName,portno);
        HomeAndDashboard = new HomeAndDashboardClass("MLWallet", deviceName, portno);

    }

// ====================================================================================================//


    @Test(priority = 1)
    public void mlWalletHomePageUIValidation_HD_TC_01() throws Exception {
        HomeAndDashboard.mlWalletHomePageUIValidation_HD_TC_01();
    }

    @Test(priority = 2)
    public void mlWalletLogOutFromHomePage_HD_TC_02() throws Exception {
        HomeAndDashboard.mlWalletLogOutFromHomePage_HD_TC_02();
    }

    @Test(priority = 3)
    public void mlWalletSettingsNavigationFromHomePage_HD_TC_03() throws Exception {
        HomeAndDashboard.mlWalletSettingsNavigationFromHomePage_HD_TC_03();
    }

    @Test(priority = 4)
    public void mlWalletHomePageEyeIconValidation_HD_TC_04() throws Exception {
        HomeAndDashboard.mlWalletHomePageEyeIconValidation_HD_TC_04();
    }

    @Test(priority = 5)
    public void mlWalletAccountTierLevelVerification_HD_TC_05() throws Exception {
        HomeAndDashboard.mlWalletAccountTierLevelVerification_HD_TC_05();
    }

    @Test(priority = 6)
    public void mlWalletHomePageRecentTransaction_HD_TC_06() throws Exception {
        HomeAndDashboard.mlWalletHomePageRecentTransaction_HD_TC_06();
    }

    @Test(priority = 7)
    public void mlWalletHomePageWithdrawCash_HD_TC_07() throws Exception {
        HomeAndDashboard.mlWalletHomePageWithdrawCash_HD_TC_07();
    }

    @Test(priority = 8)
    public void mlWalletHomePageTopUpMLWallet_HD_TC_08() throws Exception {
        HomeAndDashboard.mlWalletHomePageTopUpMLWallet_HD_TC_08();
    }

    @Test(priority = 9)
    public void mlWalletHomePageShopHD_TC_09() throws Exception {
        HomeAndDashboard.mlWalletHomePageShopHD_TC_09();
    }

    @Test(priority = 10)
    public void mlWalletHomePageKwartaPadalaRatesValidation_HD_TC_10() throws Exception {
        HomeAndDashboard.mlWalletHomePageKwartaPadalaRatesValidation_HD_TC_10();
    }

    @Test(priority = 11)
    public void mlWalletVerificationTierPerksNavigationFromHomePageHamburgerMenu_HD_TC_11() throws Exception {
        HomeAndDashboard.mlWalletVerificationTierPerksNavigationFromHomePageHamburgerMenu_HD_TC_11();
    }

    @Test(priority = 12)
    public void mlWalletSupportPageNavigation_HD_TC_12() throws Exception {
        HomeAndDashboard.mlWalletSupportPageNavigation_HD_TC_12();
    }

    @Test(priority = 13)
    public void mlWalletAboutPageNavigation_HD_TC_13() throws Exception {
        HomeAndDashboard.mlWalletAboutPageNavigation_HD_TC_13();
    }

    @Test(priority = 14)
    public void mlWalletVerificationTierPerksAsSemiVerifiedUser_HD_TC_14() throws Exception {
        HomeAndDashboard.mlWalletVerificationTierPerksAsSemiVerifiedUser_HD_TC_14();
    }

    @Test(priority = 15)
    public void mlWalletVerificationTierPerksAsFullyVerifiedUser_HD_TC_15() throws Exception {
        HomeAndDashboard.mlWalletVerificationTierPerksAsFullyVerifiedUser_HD_TC_15();
    }

    @Test(priority = 16)
    public void mlWalletVerificationAllTierPerksLoggingInAsSemiVerifiedUser_HD_TC_16() throws Exception {
        HomeAndDashboard.mlWalletVerificationAllTierPerksLoggingInAsSemiVerifiedUser_HD_TC_16();
    }


    @Test(priority = 17)
    public void mlWalletVerificationTierPerksAsBranchVerifiedUser_HD_TC_17() throws Exception {
        HomeAndDashboard.mlWalletVerificationTierPerksAsBranchVerifiedUser_HD_TC_17();
    }

    @Test(priority = 18)
    public void mlWalletVerificationTierPerksAsBuyerTierUser_HD_TC_18() throws Exception {
        HomeAndDashboard.mlWalletVerificationTierPerksAsBuyerTierUser_HD_TC_18();
    }

    @Test(priority = 19)
    public void mlWalletHamburgerMenuTransactionBtnValidation_HD_TC_19() throws Exception {
        HomeAndDashboard.mlWalletHamburgerMenuTransactionBtnValidation_HD_TC_19();
    }

    @Test(priority = 20)
    public void mlWalletHomePageIIconValidationAsBranchVerifiedUser_HD_TC_20() throws Exception {
        HomeAndDashboard.mlWalletHomePageIIconValidationAsBranchVerifiedTierUser_HD_TC_20();
    }

    @Test(priority = 21)
    public void mlWalletHomePageIIconValidationAsBuyerTierVerifiedUser_HD_TC_21() throws Exception {
        HomeAndDashboard.mlWalletHomePageIIconValidationAsBuyerTierUser_HD_TC_21();
    }

    @Test(priority = 22)
    public void mlWalletHomePageIIconValidationAsSemiVerifiedTierUser_HD_TC_22() throws Exception {
        HomeAndDashboard.mlWalletHomePageIIconValidationAsSemiVerifiedTierUser_HD_TC_22();
    }

    @Test(priority = 23)
    public void mlWalletHomePageIIconValidationAsFullyVerifiedTierUser_HD_TC_23() throws Exception {
        HomeAndDashboard.mlWalletHomePageIIconValidationAsFullyVerifiedTierUser_HD_TC_23();
    }

    @Test(priority = 24)
    public void mlWalletHomePageDoYouHaveAnotherAcButtonFunctionality_HD_TC_24() throws Exception {
        HomeAndDashboard.mlWalletHomePageDoYouHaveAnotherAcButtonFunctionality_HD_TC_24();
    }
    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
