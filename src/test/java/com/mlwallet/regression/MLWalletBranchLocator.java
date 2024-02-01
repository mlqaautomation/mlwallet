package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

public class MLWalletBranchLocator extends BaseTest{

    @Test(priority = 1)
    public void branchLocatorNavigationFromMPinPage_BL_TC_01() throws Exception {
        mlWalletBranchLocator.branchLocatorNavigationFromMPinPage_BL_TC_01();
    }

    @Test(priority = 2)
    public void branchLocatorNavigationFromLogInPage_BL_TC_02() throws Exception {
        mlWalletBranchLocator.branchLocatorNavigationFromLogInPage_BL_TC_02();
    }

    @Test(priority = 3)
    public void branchLocatorHamburgerFunctionality_BL_TC_05() throws Exception {
        mlWalletBranchLocator.branchLocatorHamburgerFunctionality_BL_TC_05();
    }

    @Test(priority = 4)
    public void branchLocatorBranchesButtonFunctionality_BL_TC_07() throws Exception {
        mlWalletBranchLocator.branchLocatorBranchesButtonFunctionality_BL_TC_07();
    }

    @Test(priority = 5)
    public void branchLocatorPromosFunctionality_BL_TC_08() throws Exception {
        mlWalletBranchLocator.branchLocatorPromosFunctionality_BL_TC_08();
    }

    @Test(priority = 6)
    public void branchLocatorBlogFunctionality_BL_TC_09() throws Exception {
        mlWalletBranchLocator.branchLocatorBlogFunctionality_BL_TC_09();
    }


    @Test(priority = 7)
    public void branchLocatorNewsLettersFunctionality_BL_TC_10() throws Exception {
        mlWalletBranchLocator.branchLocatorNewsLettersFunctionality_BL_TC_10();
    }

    @Test(priority = 8)
    public void branchLocatorFAQFunctionality_BL_TC_11() throws Exception {
        mlWalletBranchLocator.branchLocatorFAQFunctionality_BL_TC_11();
    }

    @Test(priority = 9)
    public void branchLocatorCareersPageNavigation_BL_TC_13() throws Exception {
        mlWalletBranchLocator.branchLocatorCareersPageNavigation_BL_TC_13();
    }

    @Test(priority = 10)
    public void branchLocatorShopItemsPageNavigation_BL_TC_16() throws Exception {
        mlWalletBranchLocator.branchLocatorShopItemsPageNavigation_BL_TC_16();
    }

    @Test(priority = 11)
    public void branchLocatorPayBillsPageNavigation_BL_TC_17() throws Exception {
        mlWalletBranchLocator.branchLocatorPayBillsPageNavigation_BL_TC_17();
    }

    @Test(priority = 12)
    public void branchLocatorBuyELoadPageNavigation_BL_TC_19() throws Exception {
        mlWalletBranchLocator.branchLocatorBuyELoadPageNavigation_BL_TC_19();
    }

    @Test(priority = 13)
    public void branchLocatorLoansPageNavigation_BL_TC_22() throws Exception {
        mlWalletBranchLocator.branchLocatorLoansPageNavigation_BL_TC_22();
    }

    @Test(priority = 14)
    public void branchLocatorInsurancePageNavigation_BL_TC_23() throws Exception {
        mlWalletBranchLocator.branchLocatorInsurancePageNavigation_BL_TC_23();
    }

    @Test(priority = 15)
    public void branchLocatorLogInFunctionality_BL_TC_14() throws Exception {
        mlWalletBranchLocator.branchLocatorLogInFunctionality_BL_TC_14();
    }

    @Test(priority = 16)
    public void branchLocatorSendTransferPageNavigation_BL_TC_18() throws Exception {
        mlWalletBranchLocator.branchLocatorSendTransferPageNavigation_BL_TC_18();
    }

    @Test(priority = 17)
    public void branchLocatorCashInPageNavigation_BL_TC_20() throws Exception {
        mlWalletBranchLocator.branchLocatorCashInPageNavigation_BL_TC_20();
    }

    @Test(priority = 18)
    public void branchLocatorCashOutPageNavigation_BL_TC_21() throws Exception {
        mlWalletBranchLocator.branchLocatorCashOutPageNavigation_BL_TC_21();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
