package com.mlwallet.regression;

import com.business.mlwallet.ShopItemsClass;
import com.driverInstance.AppiumServer;
import org.testng.annotations.*;
import com.business.mlwallet.ShopItemsClass;

import static com.business.mlwallet.MLWalletBusinessLogic.prop;

public class HappyPathScripts extends BaseTest{
    public static String deviceName;
    public static String portno;
    public static ShopItemsClass shopItemsClass;

    //@BeforeSuite(groups = { "All" })
    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletShopItemScripts.deviceName=deviceName;
        MLWalletShopItemScripts.portno= portno;
        // shopItemsClass = new shopItemsClass("MLWallet",deviceName,portno);
        shopItemsClass = new ShopItemsClass("MLWallet",deviceName,portno);
    }

//----- Cant Automate Need Scan QR code
//    --------------CashInViaBank
//    @Test(priority = 2)
//    public void cashInViaBankFullyVerifiedTierStatusTransaction_CIBA_TC_26() throws Exception {
//        mlWalletCashInViaBank.cashInViaBankFullyVerifiedTierStatusTransaction_CIBA_TC_26();
//    }

//    //--------------CashInViaBranch
//    @Test(priority = 1)
//    public void cashInViaBranchBuyerTierUser_CIBR_TC_16() throws Exception {
//        mlWalletCashInViaBranch.cashInViaBranchBuyerTierUser_CIBR_TC_16();
//    }

//    --------------SendMoneyBranch
//    @Test(priority = 7)
//    public void sendMoneyToSavedRecipient_STB_TC_02() throws Exception {
//        mlWalletSendMoneyViaBranch.sendMoneyToSavedRecipient_STB_TC_02();
//    }

//    --------------SendMoneyWalletUser
//    @Test(priority = 8)
//    public void sendMoneyMLWalletToExistingReceiver_STW_TC_02() throws Exception{
//        mlWalletSendMoneyViaWallet.sendMoneyMLWalletToExistingReceiver_STW_TC_02();
//    }

//----- Cant Automate Need QR code
    //--------------CashOutWithdrawBank
//    @Test(priority = 5)
//    public void cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123() throws Exception {
//        mlWalletCashOutViaBank.cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123("100");
//    }

    //--------------CashOutWithdrawBranch
//    @Test(priority = 5)
//    public void cashOutWithdrawBranch_WM_TC_05() throws Exception {
//        mlWalletCashOutViaBranch.cashOutWithdrawBranch_WM_TC_05();
//    }

//      --------------ELoad
//    @Test(priority = 1)
//    public void buyELoadSuccessfulTransactionUIValidation_BE_TC_26() throws Exception {
//        mlWalletBuyELoad.buyELoadSuccessfulTransactionUIValidation_BE_TC_26(prop.getproperty("Fully_Verified"),2);
//    }

    //--------------GCash
//    @Test(priority = 4)
//    public void GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page() throws Exception {
//        mlWalletGCashScripts.GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page();
//    }

    //--------------PayBills
//    @Test(priority = 6)
//    public void paybillsRecentTransaction_PB_TC_19() throws Exception {
//        mlWalletBillsPay.paybillsRecentTransaction_PB_TC_19();
//    }

//----- Need to Update Test Script
//    //--------------ShopItems
//    @Test(priority = 9)
//    public void shopItemsSubTotalAmountValidationBeforeSelectingItems_MLS_TC_59() throws Exception {
//        shopItemsClass.shopItemsSubTotalAmountValidationBeforeSelectingItems_MLS_TC_59();
//    }

    //---------------TopUpGames
//    @Test(priority = 10)
//    public void topUpGamesSuccessfulLoadTransaction_TUG_TC_06() throws Exception {
//        mlWalletTopUp.topUpGamesSuccessfulLoadTransaction_TUG_TC_06();
//    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }
}
//dem04