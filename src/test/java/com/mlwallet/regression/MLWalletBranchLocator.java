    package com.mlwallet.regression;


import com.driverInstance.AppiumServer;
import org.testng.annotations.*;
import com.business.mlwallet.BranchLocatorClass;

public class MLWalletBranchLocator {

    public static String deviceName;
    public static String portno;
//    public  static com.business.mlwallet.branchLocatorClass branchLocatorClass;
    public static BranchLocatorClass branchLocatorClass;



    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletBranchLocator.deviceName=deviceName;
        MLWalletBranchLocator.portno= portno;
//        branchLocatorClass = new branchLocatorClass("MLWallet",deviceName,portno);
        branchLocatorClass = new BranchLocatorClass("MLWallet",deviceName,portno);
    }

//==============================================================================================================//

    @Test(priority = 1)
    public void branchLocatorNavigationFromMPinPage_BL_TC_01() throws Exception {
        branchLocatorClass.branchLocatorNavigationFromMPinPage_BL_TC_01();
    }

    @Test(priority = 2)
    public void branchLocatorNavigationFromLogInPage_BL_TC_02() throws Exception {
        branchLocatorClass.branchLocatorNavigationFromLogInPage_BL_TC_02();
    }

    @Test(priority = 3)
    public void branchLocatorHamburgerFunctionality_BL_TC_05() throws Exception {
        branchLocatorClass.branchLocatorHamburgerFunctionality_BL_TC_05();
    }

    @Test(priority = 4)
    public void branchLocatorBranchesButtonFunctionality_BL_TC_07() throws Exception {
        branchLocatorClass.branchLocatorBranchesButtonFunctionality_BL_TC_07();
    }

    @Test(priority = 5)
    public void branchLocatorPromosFunctionality_BL_TC_08() throws Exception {
        branchLocatorClass.branchLocatorPromosFunctionality_BL_TC_08();
    }

    @Test(priority = 6)
    public void branchLocatorBlogFunctionality_BL_TC_09() throws Exception {
        branchLocatorClass.branchLocatorBlogFunctionality_BL_TC_09();
    }


    @Test(priority = 7)
    public void branchLocatorNewsLettersFunctionality_BL_TC_10() throws Exception {
        branchLocatorClass.branchLocatorNewsLettersFunctionality_BL_TC_10();
    }

    @Test(priority = 8)
    public void branchLocatorFAQFunctionality_BL_TC_11() throws Exception {
        branchLocatorClass.branchLocatorFAQFunctionality_BL_TC_11();
    }

    @Test(priority = 9)
    public void branchLocatorCareersPageNavigation_BL_TC_13() throws Exception {
        branchLocatorClass.branchLocatorCareersPageNavigation_BL_TC_13();
    }

    @Test(priority = 10)
    public void branchLocatorShopItemsPageNavigation_BL_TC_16() throws Exception {
        branchLocatorClass.branchLocatorShopItemsPageNavigation_BL_TC_16();
    }

    @Test(priority = 11)
    public void branchLocatorPayBillsPageNavigation_BL_TC_17() throws Exception {
        branchLocatorClass.branchLocatorPayBillsPageNavigation_BL_TC_17();
    }

    @Test(priority = 12)
    public void branchLocatorBuyELoadPageNavigation_BL_TC_19() throws Exception {
        branchLocatorClass.branchLocatorBuyELoadPageNavigation_BL_TC_19();
    }

    @Test(priority = 13)
    public void branchLocatorLoansPageNavigation_BL_TC_22() throws Exception {
        branchLocatorClass.branchLocatorLoansPageNavigation_BL_TC_22();
    }

    @Test(priority = 14)
    public void branchLocatorInsurancePageNavigation_BL_TC_23() throws Exception {
        branchLocatorClass.branchLocatorInsurancePageNavigation_BL_TC_23();
    }

    @Test(priority = 15)
    public void branchLocatorLogInFunctionality_BL_TC_14() throws Exception {
        branchLocatorClass.branchLocatorLogInFunctionality_BL_TC_14();
    }

    @Test(priority = 16)
    public void branchLocatorSendTransferPageNavigation_BL_TC_18() throws Exception {
        branchLocatorClass.branchLocatorSendTransferPageNavigation_BL_TC_18();
    }

    @Test(priority = 17)
    public void branchLocatorCashInPageNavigation_BL_TC_20() throws Exception {
        branchLocatorClass.branchLocatorCashInPageNavigation_BL_TC_20();
    }

    @Test(priority = 18)
    public void branchLocatorCashOutPageNavigation_BL_TC_21() throws Exception {
        branchLocatorClass.branchLocatorCashOutPageNavigation_BL_TC_21();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }






}
