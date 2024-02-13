package com.mlwallet.regression;

import org.aspectj.lang.annotation.After;
import com.business.mlwallet.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.driverInstance.AppiumServer;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class BaseTest {
    protected com.business.mlwallet.BaseClass baseClass;
    protected LoginClass mlWalletLogin;
    protected BillsPayClass mlWalletBillsPay;
    protected BranchLocatorClass mlWalletBranchLocator;
    protected BuyEloadClass mlWalletBuyELoad;
    protected CashInVia_BankClass mlWalletCashInViaBank;
    protected CashInVia_BranchClass mlWalletCashInViaBranch;
    protected CashOutVia_BankClass mlWalletCashOutViaBank;
    protected CashOutVia_BranchClass mlWalletCashOutViaBranch;
    protected GCashClass mlWalletGCash;
    protected HomeAndDashboardClass mlWalletHomeDashBoard;
    protected LogoutClass mlWalletLogout;
    protected RegistrationClass mlWalletRegistration;
    protected SendMoneyVia_BranchClass mlWalletSendMoneyViaBranch;
    protected SendMoneyVia_WalletClass mlWalletSendMoneyViaWallet;
    protected SettingsClass mlWalletSettings;
    protected ShopItemsClass mlWalletShopItems;
    protected TierUpgradeClass mlWalletTierUpgrade;
    protected TopUpGameClass mlWalletTopUp;
    protected TransactionHistoryClass mlWalletTransactionHistory;
    protected TroubleSigningInClass mlWalletTroubleSignIn;
    @BeforeSuite
    public void startAppiumServer(){
        try {
            AppiumServer.startServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Parameters({"deviceName", "portno"})
    @BeforeMethod
    public void initialize(String deviceName, String portno)throws Exception{
        baseClass = new BaseClass("MLWallet", deviceName, portno);
        mlWalletLogin = new LoginClass();
        mlWalletBranchLocator = new BranchLocatorClass();
        mlWalletBuyELoad = new BuyEloadClass();
        mlWalletBillsPay = new BillsPayClass();
        mlWalletCashInViaBank = new CashInVia_BankClass();
        mlWalletCashInViaBranch = new CashInVia_BranchClass();
        mlWalletCashOutViaBank = new CashOutVia_BankClass();
        mlWalletCashOutViaBranch = new CashOutVia_BranchClass();
        mlWalletHomeDashBoard = new HomeAndDashboardClass();
        mlWalletLogout = new LogoutClass();
        mlWalletRegistration = new RegistrationClass();
        mlWalletSendMoneyViaBranch = new SendMoneyVia_BranchClass();
        mlWalletSendMoneyViaWallet = new SendMoneyVia_WalletClass();
        mlWalletSettings = new SettingsClass();
        //mlWalletShopItems = new ShopItemsClass();
        mlWalletTierUpgrade = new TierUpgradeClass();
        mlWalletTopUp = new TopUpGameClass();
        mlWalletTransactionHistory = new TransactionHistoryClass();
        mlWalletTroubleSignIn = new TroubleSigningInClass();
        mlWalletGCash = new GCashClass();
    }
    @AfterSuite
    public void endAppiumServer(){
        AppiumServer.terminateAppium();
    }
}
