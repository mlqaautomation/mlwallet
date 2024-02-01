package com.mlwallet.regression;


import com.driverInstance.AppiumServer;
import org.testng.annotations.*;


public class MLWalletHomeAndDashboard extends BaseTest{
    
    @Test(priority = 1)
    public void mlWalletHomePageUIValidation_HD_TC_01() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageUIValidation_HD_TC_01();
    }

    @Test(priority = 2)
    public void mlWalletLogOutFromHomePage_HD_TC_02() throws Exception {
        mlWalletHomeDashBoard.mlWalletLogOutFromHomePage_HD_TC_02();
    }

    @Test(priority = 3)
    public void mlWalletSettingsNavigationFromHomePage_HD_TC_03() throws Exception {
        mlWalletHomeDashBoard.mlWalletSettingsNavigationFromHomePage_HD_TC_03();
    }

    @Test(priority = 4)
    public void mlWalletHomePageEyeIconValidation_HD_TC_04() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageEyeIconValidation_HD_TC_04();
    }

    @Test(priority = 5)
    public void mlWalletAccountTierLevelVerification_HD_TC_05() throws Exception {
        mlWalletHomeDashBoard.mlWalletAccountTierLevelVerification_HD_TC_05();
    }

    @Test(priority = 6)
    public void mlWalletHomePageRecentTransaction_HD_TC_06() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageRecentTransaction_HD_TC_06();
    }

    @Test(priority = 7)
    public void mlWalletHomePageWithdrawCash_HD_TC_07() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageWithdrawCash_HD_TC_07();
    }

    @Test(priority = 8)
    public void mlWalletHomePageTopUpMLWallet_HD_TC_08() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageTopUpMLWallet_HD_TC_08();
    }

    @Test(priority = 9)
    public void mlWalletHomePageShopHD_TC_09() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageShopHD_TC_09();
    }

    @Test(priority = 10)
    public void mlWalletHomePageKwartaPadalaRatesValidation_HD_TC_10() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageKwartaPadalaRatesValidation_HD_TC_10();
    }

    @Test(priority = 11)
    public void mlWalletVerificationTierPerksNavigationFromHomePageHamburgerMenu_HD_TC_11() throws Exception {
        mlWalletHomeDashBoard.mlWalletVerificationTierPerksNavigationFromHomePageHamburgerMenu_HD_TC_11();
    }

    @Test(priority = 12)
    public void mlWalletSupportPageNavigation_HD_TC_12() throws Exception {
        mlWalletHomeDashBoard.mlWalletSupportPageNavigation_HD_TC_12();
    }

    @Test(priority = 13)
    public void mlWalletAboutPageNavigation_HD_TC_13() throws Exception {
        mlWalletHomeDashBoard.mlWalletAboutPageNavigation_HD_TC_13();
    }

    @Test(priority = 14)
    public void mlWalletVerificationTierPerksAsSemiVerifiedUser_HD_TC_14() throws Exception {
        mlWalletHomeDashBoard.mlWalletVerificationTierPerksAsSemiVerifiedUser_HD_TC_14();
    }

    @Test(priority = 15)
    public void mlWalletVerificationTierPerksAsFullyVerifiedUser_HD_TC_15() throws Exception {
        mlWalletHomeDashBoard.mlWalletVerificationTierPerksAsFullyVerifiedUser_HD_TC_15();
    }

    @Test(priority = 16)
    public void mlWalletVerificationAllTierPerksLoggingInAsSemiVerifiedUser_HD_TC_16() throws Exception {
        mlWalletHomeDashBoard.mlWalletVerificationAllTierPerksLoggingInAsSemiVerifiedUser_HD_TC_16();
    }


    @Test(priority = 17)
    public void mlWalletVerificationTierPerksAsBranchVerifiedUser_HD_TC_17() throws Exception {
        mlWalletHomeDashBoard.mlWalletVerificationTierPerksAsBranchVerifiedUser_HD_TC_17();
    }

    @Test(priority = 18)
    public void mlWalletVerificationTierPerksAsBuyerTierUser_HD_TC_18() throws Exception {
        mlWalletHomeDashBoard.mlWalletVerificationTierPerksAsBuyerTierUser_HD_TC_18();
    }

    @Test(priority = 19)
    public void mlWalletHamburgerMenuTransactionBtnValidation_HD_TC_19() throws Exception {
        mlWalletHomeDashBoard.mlWalletHamburgerMenuTransactionBtnValidation_HD_TC_19();
    }

    @Test(priority = 20)
    public void mlWalletHomePageIIconValidationAsBranchVerifiedUser_HD_TC_20() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageIIconValidationAsBranchVerifiedTierUser_HD_TC_20();
    }

    @Test(priority = 21)
    public void mlWalletHomePageIIconValidationAsBuyerTierVerifiedUser_HD_TC_21() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageIIconValidationAsBuyerTierUser_HD_TC_21();
    }

    @Test(priority = 22)
    public void mlWalletHomePageIIconValidationAsSemiVerifiedTierUser_HD_TC_22() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageIIconValidationAsSemiVerifiedTierUser_HD_TC_22();
    }

    @Test(priority = 23)
    public void mlWalletHomePageIIconValidationAsFullyVerifiedTierUser_HD_TC_23() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageIIconValidationAsFullyVerifiedTierUser_HD_TC_23();
    }

    @Test(priority = 24)
    public void mlWalletHomePageDoYouHaveAnotherAcButtonFunctionality_HD_TC_24() throws Exception {
        mlWalletHomeDashBoard.mlWalletHomePageDoYouHaveAnotherAcButtonFunctionality_HD_TC_24();
    }
    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
