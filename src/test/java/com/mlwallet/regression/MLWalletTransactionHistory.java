package com.mlwallet.regression;

import com.business.mlwallet.TransactionHistoryClass;
import com.driverInstance.AppiumServer;
import org.testng.annotations.*;

public class MLWalletTransactionHistory {
    public static String deviceName;
    public static String portno;
    public  static TransactionHistoryClass TransactionHistoryClass;


    //@BeforeSuite(groups = { "All" })
    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletTransactionHistory.deviceName=deviceName;
        MLWalletTransactionHistory.portno= portno;
        TransactionHistoryClass = new TransactionHistoryClass("MLWallet",deviceName,portno);
    }
//===================================================================================================//


    @Test(priority = 1)
    public void mlWalletTransactionHistoryScenario__TH_TC_01() throws Exception
    {
        TransactionHistoryClass.mlWallet_TransactionHistory_TH_TC_01();
    }

    @Test(priority = 2)
    public void billsPayTransactionHHistory_TH_TC_02() throws Exception {
        TransactionHistoryClass.billsPayTransactionHHistory_TH_TC_02();
    }

    @Test(priority = 3)
    public void buyLoadTransactionHistory_TH_TC_03() throws Exception {
        TransactionHistoryClass.buyLoadTransactionHistory_TH_TC_03();
    }

    @Test(priority = 4)
    public void sendMoneyTransactionHistory_TH_TC_04() throws Exception {
        TransactionHistoryClass.sendMoneyTransactionHistory_TH_TC_04();
    }

    @Test(priority = 5)
    public void cashInTransactionHistory_TH_TC_05() throws Exception {
        TransactionHistoryClass.cashInTransactionHistory_TH_TC_05();
    }

    @Test(priority = 6)
    public void cashOutTransactionHistory_TH_TC_06() throws Exception {
        TransactionHistoryClass.cashOutTransactionHistory_TH_TC_06();
    }

    @Test(priority = 7)
    public void receiveMoneyTransactionHistory_TH_TC_07() throws Exception {
        TransactionHistoryClass.receiveMoneyTransactionHistory_TH_TC_07();
    }

    @Test(priority = 8)
    public void balanceAdjustmentTransactionHistory_TH_TC_08() throws Exception {
        TransactionHistoryClass.balanceAdjustmentTransactionHistory_TH_TC_08();
    }

    @Test(priority = 9)
    public void mlShopTransactionHistory_TH_TC_09() throws Exception {
        TransactionHistoryClass.mlShopTransactionHistory_TH_TC_09();
    }


//======================================================================================================//

    @Test(priority = 10)
    public void transactionHistoryUIValidation() throws Exception {
        TransactionHistoryClass.transactionHistoryUIValidation_TH_TC_10();
    }

    @Test(priority = 11)
    public void transactionHistoryBillsPayTransactionDetailsValidation_TH_TC_13() throws Exception {
        TransactionHistoryClass.transactionHistoryBillsPayTransactionDetailsValidation_TH_TC_13();
    }

    @Test(priority = 12)
    public void transactionHistoryELoadTransactionDetailsValidation_TH_TC_14() throws Exception {
        TransactionHistoryClass.transactionHistoryELoadTransactionDetailsValidation_TH_TC_14();
    }

    @Test(priority = 13)
    public void transactionHistorySendMoneyWalletToWalletTransactionDetailsValidation_TH_TC_15() throws Exception {
        TransactionHistoryClass.transactionHistorySendMoneyWalletToWalletTransactionDetailsValidation_TH_TC_15();
    }

    @Test(priority = 14)
    public void transactionHistorySendMoneyKwartaPadalaTransactionDetailsValidation_TH_TC_16() throws Exception {
        TransactionHistoryClass.transactionHistorySendMoneyKwartaPadalaTransactionDetailsValidation_TH_TC_16();
    }

    @Test(priority = 15)
    public void transactionHistoryCashInTransactionDetailsValidation_TH_TC_17() throws Exception {
        TransactionHistoryClass.transactionHistoryCashInTransactionDetailsValidation_TH_TC_17();
    }

    @Test(priority = 16)
    public void transactionHistoryCashOutTransactionDetailsValidation_TH_TC_18() throws Exception {
        TransactionHistoryClass.transactionHistoryCashOutTransactionDetailsValidation_TH_TC_18();
    }

    @Test(priority = 17)
    public void transactionHistoryReceiveMoneyTransactionDetailsValidation_TH_TC_19() throws Exception {
        TransactionHistoryClass.transactionHistoryReceiveMoneyTransactionDetailsValidation_TH_TC_19();
    }

    @Test(priority = 18)
    public void transactionHistoryMLShopTransactionDetailsValidation_TH_TC_20() throws Exception {
        TransactionHistoryClass.transactionHistoryMLShopTransactionDetailsValidation_TH_TC_20();
    }



    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }






}
