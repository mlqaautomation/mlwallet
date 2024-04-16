package com.mlwallet.regression;

import com.business.mlwallet.ShopItemsClass;
import com.driverInstance.AppiumServer;
import org.testng.annotations.*;
import com.business.mlwallet.ShopItemsClass;

import static com.business.mlwallet.MLWalletBusinessLogic.prop;

public class HappyPathScripts extends BaseTest{
//    public static String deviceName;
//    public static String portno;
//    public static ShopItemsClass shopItemsClass;

    //@BeforeSuite(groups = { "All" })
//    @Parameters({"deviceName","portno"})
//    @BeforeMethod
//    public void before(String deviceName,String portno) throws Exception {
//        AppiumServer.startServer();
//        MLWalletShopItemScripts.deviceName=deviceName;
//        MLWalletShopItemScripts.portno= portno;
//        // shopItemsClass = new shopItemsClass("MLWallet",deviceName,portno);
//        shopItemsClass = new ShopItemsClass("MLWallet",deviceName,portno);
//    }

//----- Cant Automate Need Scan QR code
//    --------------CashInViaBank
//    @Test(priority = 2)
//    public void cashInViaBankFullyVerifiedTierStatusTransaction_CIBA_TC_26() throws Exception {
//        mlWalletCashInViaBank.cashInViaBankFullyVerifiedTierStatusTransaction_CIBA_TC_26();
//    }

    //--------------CashInViaBranch
    @Test(priority = 1)
    public void cashInViaBranchSuccessfulTransaction_CIBR_TC_16() throws Exception {
        mlWalletCashInViaBranch.cashInViaBranchSuccessfulTransaction_CIBR_TC_16();
    }

    //--------------KwartaPadalaViaBranch
    @Test(priority = 2)
    public void kwartaPadalaViaBranchSuccessfulTransaction_STB_TC_02() throws Exception {
        mlWalletSendMoneyViaBranch.kwartaPadalaViaBranchSuccessfulTransaction_STB_TC_02();
    }

    //--------------KwartaPadalaViaWalletUser
    @Test(priority = 3)
    public void kwartaPadalaViaMLWalletSuccessfulTransaction_STW_TC_02() throws Exception{
        mlWalletSendMoneyViaWallet.kwartaPadalaViaMLWalletSuccessfulTransaction_STW_TC_02();
    }

//----- Cant Automate Need QR code
    //--------------CashOutWithdrawBank
//    @Test(priority = 5)
//    public void cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123() throws Exception {
//        mlWalletCashOutViaBank.cashOutBankTransactionOTPContinueBtnFunctionality_WM_TC_123("100");
//    }

    //--------------CashOutWithdrawBranch
    @Test(priority = 4)
    public void cashOutViaBranchSuccessfulTransaction_WM_TC_05() throws Exception {
        mlWalletCashOutViaBranch.cashOutViaBranchSuccessfulTransaction_WM_TC_05();
    }
//
////      --------------ELoad
    @Test(priority = 5)
    public void buyELoadSuccessfulTransaction_BE_TC_26() throws Exception {
        mlWalletBuyELoad.buyELoadSuccessfulTransaction_BE_TC_26(prop.getproperty("Fully_Verified"),2);
    }
//
//    //--------------GCash
    @Test(priority = 6)
    public void GCashSuccessfulTransaction_GC_SM_TC_76() throws Exception {
        mlWalletGCashScripts.GCashSuccessfulTransaction_GC_SM_TC_76();
    }
//
//    //--------------PayBills
    @Test(priority = 7)
    public void paybillsSuccessfulTransaction_PB_TC_19() throws Exception {
        mlWalletBillsPay.paybillsSuccessfulTransaction_PB_TC_19();
    }
//
////----- Need to Update Test Script
////    //--------------ShopItems
////    @Test(priority = 9)
////    public void shopItemsSubTotalAmountValidationBeforeSelectingItems_MLS_TC_59() throws Exception {
////        shopItemsClass.shopItemsSubTotalAmountValidationBeforeSelectingItems_MLS_TC_59();
////    }
//
//    //---------------TopUpGames
    @Test(priority = 8)
    public void topUpGamesSuccessfulTransaction_TUG_TC_06() throws Exception {
        mlWalletTopUp.topUpGamesSuccessfulTransaction_TUG_TC_06();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }
}
//dem04