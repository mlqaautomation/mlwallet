package com.mlshop;

import com.business.mlwallet.BaseClass;
import com.mlwallet.pages.MLWalletHomePage;
import com.mlwallet.pages.MLWalletLogOutPage;
import com.mlwallet.pages.MLWalletShopItemsPage;
import com.mlwallet.pages.MLWalletTroubleSigningInPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.utility.Utilities.*;
import static com.utility.Utilities.click;

public class MLShop_TestCases extends MLShop_GenMethods {
    public MLShop_TestCases(String Application, String deviceName, String portno) throws InterruptedException {
        super(Application, deviceName, portno);
    }


    //todo
    // TEST CASES FOR HOMEPAGE
    //SI_TC_01
    //SI_TC_02
    //SI_TC_03
    //SI_TC_04
    //SI_TC_05
    //SI_TC_06
    //SI_TC_07
    //SI_TC_13

    public void MLShop_Homepage_TC_01() throws Exception {

        ExtentReporter.HeaderChildNode("SI_TC_01, Shop menu link will redirect to the ML Shop Homepage");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objHamburgerMenu, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShop, "Shop option");
        waitTime(5000);
            if (verifyElementPresent(MLWalletShopItemsPage.objGreatSalesText, getTextVal(MLWalletShopItemsPage.objGreatSalesText, "Home Page"))) {
            logger.info("SI_TC_01, After clicking on shop option on Hamburger menu, Application Navigated to Shop Homepage");
            ExtentReporter.extentLoggerPass("SI_TC_01", "Shop menu link will redirect to the ML Shop Homepage");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void MLShop_Aboutpage_TC_02() throws Exception {

        ExtentReporter.HeaderChildNode("SI_TC_02, About menu link will redirect to the MLhuillier - Jewelry page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objHamburgerMenu, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objAbout, "About option");
        waitTime(5000);
        if (verifyElementPresent(MLWalletShopItemsPage.objJewelryText, getTextVal(MLWalletShopItemsPage.objJewelryText, "Home Page"))) {
            logger.info("SI_TC_02, After clicking on about option on Hamburger menu, Application Navigated to MLhuillier - Jewelry page");
            ExtentReporter.extentLoggerPass("SI_TC_02", "About menu link will redirect to the MLhuillier - Jewelry page");
            System.out.println("-----------------------------------------------------------");
        }
    }



    public void MLShop_Contactpage_TC_03() throws Exception {

        ExtentReporter.HeaderChildNode("SI_TC_03, Contact menu link will redirect to the MLhuillier - Contact us page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objHamburgerMenu, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objContact, "Contact option");
        waitTime(5000);
        if (verifyElementPresent(MLWalletShopItemsPage.objContactUsText, getTextVal(MLWalletShopItemsPage.objContactUsText, "Home Page"))) {
            logger.info("SI_TC_03, After clicking on contact option on Hamburger menu, Application Navigated to MLhuillier - Contact us page");
            ExtentReporter.extentLoggerPass("SI_TC_03   ", "Contact menu link will redirect to the MLhuillier - Contact us page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void MLShop_ShopCart_TC_04() throws Exception {

        ExtentReporter.HeaderChildNode("SI_TC_04, Cart menu link will redirect to the MLhuillier - Shop cart page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objHamburgerMenu, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCart, "Cart option");
        waitTime(5000);
        if (verifyElementPresent(MLWalletShopItemsPage.objShopCartText, getTextVal(MLWalletShopItemsPage.objShopCartText, "Home Page"))) {
            logger.info("SI_TC_04, After clicking on cart option on Hamburger menu, Application Navigated to MLhuillier - Shopping Cart page");
            ExtentReporter.extentLoggerPass("SI_TC_04   ", "Cart menu link will redirect to the MLhuillier - Shopping Cart page");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void MLShop_Profile_TC_05() throws Exception {

        ExtentReporter.HeaderChildNode("SI_TC_05, Profile menu link will redirect to the MLhuillier - Profile page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objHamburgerMenu, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProfile, "Profile option");
        waitTime(5000);
        if (verifyElementPresent(MLWalletShopItemsPage.objProfileText, getTextVal(MLWalletShopItemsPage.objProfileText, "Home Page"))) {
            logger.info("SI_TC_05, After clicking on profile option on Hamburger menu, Application Navigated to MLhuillier - Profile page");
            ExtentReporter.extentLoggerPass("SI_TC_05   ", "Profile menu link will redirect to the MLhuillier - Profile page");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void MLShop_PurchaseHistory_TC_06() throws Exception {

        ExtentReporter.HeaderChildNode("SI_TC_06, Purchase History menu link will redirect to the MLhuillier - Purchase History page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objHamburgerMenu, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMyPurchase, "Purchase History option");
        waitTime(5000);
        if (verifyElementPresent(MLWalletShopItemsPage.objPurchaseText, getTextVal(MLWalletShopItemsPage.objPurchaseText, "Home Page"))) {
            logger.info("SI_TC_06, After clicking on Purchase History option on Hamburger menu, Application Navigated to MLhuillier - Purchase page");
            ExtentReporter.extentLoggerPass("SI_TC_06   ", "Purchase History menu link will redirect to the MLhuillier - Purchase History page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void MLShop_Logout_TC_07() throws Exception {

        ExtentReporter.HeaderChildNode("SI_TC_07, Logout menu link will redirect to the MLhuillier - Home page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objHamburgerMenu, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objLogout, "Logout option");
        waitTime(5000);
        if (verifyElementPresent(MLWalletShopItemsPage.objLogoutText, getTextVal(MLWalletShopItemsPage.objLogoutText," Page"))) {
            logger.info("SI_TC_07, After clicking on Logout option on Hamburger menu, Application Navigated to MLhuillier -  page");
            ExtentReporter.extentLoggerPass("SI_TC_07   ", "Logoutmenu link will redirect to the MLhuillier - page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void MLShop_ExitIcon_TC_13() throws Exception {
        //click hamburger menu
        // click shop
        // verify if it navigates to mlshop exit icon

        ExtentReporter.HeaderChildNode("SI_TC_13, Exit icon link will redirect to the MLhuillier - Home page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objHamburgerMenu, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objExitHamburgerMenu, "Exit Icon");
        waitTime(5000);
        if (verifyElementPresent(MLWalletShopItemsPage.objGreatSalesText, getTextVal(MLWalletShopItemsPage.objGreatSalesText," Page"))) {
            logger.info("SI_TC_13, After clicking on Exit icon on Hamburger menu, Application Navigated to MLShop Page");
            ExtentReporter.extentLoggerPass("SI_TC_13   ", "Exit icon link will redirect to the MLshop  Page");
            System.out.println("-----------------------------------------------------------");
        }
    }





    public void MLShop_PurchaseItemViaMlWallet_TC_178()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_178, Purchase Item Via MLWallet As Payment Method");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWallet_ShopItems_Successful_Purchase();
        if(verifyElementPresent(MLWalletShopItemsPage.objSuccesFullyCheckOutMsg,
                getTextVal(MLWalletShopItemsPage.objSuccesFullyCheckOutMsg, "Confirmation Message"))){
            click(MLWalletShopItemsPage.objSuccessFullyCheckOutOkayBtn , "Button");
            logger.info("MLS_TC_178, Purchase Item Via MLWallet As Payment Method, Validated");
            ExtentReporter.extentLoggerPass("MLS_TC_178", "Purchase Item Via MLWallet As Payment Method");
        }
    }

    //Paymongo Portal
    public void MLShop_PaymongoPortalCreditDebit_TC_205()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_205, Paymongo Portal Page CreditDebit UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        eWalletPaymongoPortalUIValidation(shopProp.getproperty("CreditDebit"));
        if(verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, getText(MLWalletShopItemsPage.objPaymongoPortalPage))){
            logger.info("MLS_TC_205, Paymongo Portal Page CreditDebit UI Validation, Validated");
            extentLoggerPass("MLS_TC_205", "Paymongo Portal Page CreditDebit UI Validation, Validated");
        }
    }
    public void MLShop_PaymongoPortalGrabPay_TC_206()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_206, Paymongo Portal Page GrabPay UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        eWalletPaymongoPortalUIValidation(shopProp.getproperty("Grab"));
        if(verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, getText(MLWalletShopItemsPage.objPaymongoPortalPage))){
            logger.info("MLS_TC_206, Paymongo Portal Page GrabPay UI Validation, Validated");
            extentLoggerPass("MLS_TC_206", "Paymongo Portal Page GrabPay UI Validation, Validated");
        }
    }
    public void MLShop_PaymongoPortalGcash_TC_207()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_207, Paymongo Portal Page Gcash UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        eWalletPaymongoPortalUIValidation(shopProp.getproperty("Gcash"));
        if(verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, getText(MLWalletShopItemsPage.objPaymongoPortalPage))){
            logger.info("MLS_TC_207, Paymongo Portal Page Gcash UI Validation, Validated");
            extentLoggerPass("MLS_TC_207", "Paymongo Portal Page Gcash UI Validation, Validated");
        }
    }
    public void MLShop_PaymongoPortalMaya_TC_208()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_208, Paymongo Portal Page Maya UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        eWalletPaymongoPortalUIValidation(shopProp.getproperty("Paymaya"));
        if(verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, getText(MLWalletShopItemsPage.objPaymongoPortalPage))){
            logger.info("MLS_TC_208, Paymongo Portal Page Maya UI Validation, Validated");
            extentLoggerPass("MLS_TC_208", "Paymongo Portal Page Maya UI Validation, Validated");
        }
    }
    public void MLShop_PaymongoPortalDirectOnlineBank_TC_209()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_209, Paymongo Portal Page Direct Online Banking UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        eWalletPaymongoPortalUIValidation(shopProp.getproperty("Paymaya"));
        if(verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, getText(MLWalletShopItemsPage.objPaymongoPortalPage))){
            logger.info("MLS_TC_209, Paymongo Portal Page Direct Online Banking UI Validation, Validated");
            extentLoggerPass("MLS_TC_209", "Paymongo Portal Page Direct Online Banking UI Validation, Validated");
        }
    }
}
