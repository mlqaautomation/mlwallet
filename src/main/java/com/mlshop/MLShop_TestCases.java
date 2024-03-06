package com.mlshop;
import com.driverInstance.DriverManager;
import com.mlwallet.pages.MLWalletHomePage;
import com.mlwallet.pages.MLWalletLogOutPage;
import com.mlwallet.pages.MLWalletTroubleSigningInPage;
import com.business.mlwallet.BaseClass;
import com.mlwallet.pages.MLWalletShopItemsPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.mlwallet.pages.MLWalletShopItemsPage.*;
import java.util.List;
import static com.mlwallet.pages.MLWalletShopItemsPage.objSelectMaterialOptions;
import static com.utility.ExtentReporter.extentLoggerPass;
import static com.utility.Utilities.*;

public class MLShop_TestCases extends MLShop_GenMethods {
    public MLShop_TestCases(String Application, String deviceName, String portno) throws InterruptedException {
        super(Application, deviceName, portno);
    }

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
        if (verifyElementPresent(MLWalletShopItemsPage.objGreatSalesText, getTextVal(MLWalletShopItemsPage.objGreatSalesText," Page"))) {
            logger.info("SI_TC_07, After clicking on Logout option on Hamburger menu, Application Navigated to MLhuillier -  page");
            ExtentReporter.extentLoggerPass("SI_TC_07   ", "Logoutmenu link will redirect to the MLhuillier - page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void MLShop_ExitIcon_TC_13() throws Exception {

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

    public void MLShop_PurchaseItemViaMlWallet_TC_178() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_178, Purchase Item Via MLWallet As Payment Method");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWallet_ShopItems_Successful_Purchase();
        if (verifyElementPresent(MLWalletShopItemsPage.objSuccesFullyCheckOutMsg,
                getTextVal(MLWalletShopItemsPage.objSuccesFullyCheckOutMsg, "Confirmation Message"))) {
            click(MLWalletShopItemsPage.objSuccessFullyCheckOutOkayBtn, "Button");
            logger.info("MLS_TC_178, Purchase Item Via MLWallet As Payment Method, Validated");
            ExtentReporter.extentLoggerPass("MLS_TC_178", "Purchase Item Via MLWallet As Payment Method");
        }
    }

    //Paymongo Portal
    public void MLShop_PaymongoPortalCreditDebit_TC_205() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_205, Paymongo Portal Page CreditDebit UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        eWalletPaymongoPortalUIValidation(shopProp.getproperty("CreditDebit"));
        if (verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, getText(MLWalletShopItemsPage.objPaymongoPortalPage))) {
            logger.info("MLS_TC_205, Paymongo Portal Page CreditDebit UI Validation, Validated");
            extentLoggerPass("MLS_TC_205", "Paymongo Portal Page CreditDebit UI Validation, Validated");
        }
    }

    public void MLShop_PaymongoPortalGrabPay_TC_206() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_206, Paymongo Portal Page GrabPay UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        eWalletPaymongoPortalUIValidation(shopProp.getproperty("Grab"));
        if (verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, getText(MLWalletShopItemsPage.objPaymongoPortalPage))) {
            logger.info("MLS_TC_206, Paymongo Portal Page GrabPay UI Validation, Validated");
            extentLoggerPass("MLS_TC_206", "Paymongo Portal Page GrabPay UI Validation, Validated");
        }
    }

    public void MLShop_PaymongoPortalGcash_TC_207() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_207, Paymongo Portal Page Gcash UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        eWalletPaymongoPortalUIValidation(shopProp.getproperty("Gcash"));
        if (verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, getText(MLWalletShopItemsPage.objPaymongoPortalPage))) {
            logger.info("MLS_TC_207, Paymongo Portal Page Gcash UI Validation, Validated");
            extentLoggerPass("MLS_TC_207", "Paymongo Portal Page Gcash UI Validation, Validated");
        }
    }

    public void MLShop_PaymongoPortalMaya_TC_208() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_208, Paymongo Portal Page Maya UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        eWalletPaymongoPortalUIValidation(shopProp.getproperty("Paymaya"));
        if (verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, getText(MLWalletShopItemsPage.objPaymongoPortalPage))) {
            logger.info("MLS_TC_208, Paymongo Portal Page Maya UI Validation, Validated");
            extentLoggerPass("MLS_TC_208", "Paymongo Portal Page Maya UI Validation, Validated");
        }
    }

    public void MLShop_PaymongoPortalDirectOnlineBank_TC_209() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_209, Paymongo Portal Page Direct Online Banking UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        eWalletPaymongoPortalUIValidation(shopProp.getproperty("Paymaya"));
        if (verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, getText(MLWalletShopItemsPage.objPaymongoPortalPage))) {
            logger.info("MLS_TC_209, Paymongo Portal Page Direct Online Banking UI Validation, Validated");
            extentLoggerPass("MLS_TC_209", "Paymongo Portal Page Direct Online Banking UI Validation, Validated");
        }
    }

    public void MLShop_Select10kMaterialDisplayProductionValidation_SI_TC_41() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 10k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("10k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 10k material display Product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_41","Select 10k material display Product validated successfully");
        selectFilterMaterial(objSelectMaterialOptions("10k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 10k material display Production validated successfully");
    }

    public void MLShop_Select14kMaterialDisplayProductionValidation_SI_TC_42() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 14k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("14k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 14k material display Product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_42","Select 14k material display Product validated successfully");
    }

    public void MLShop_Select18kMaterialDisplayProductionValidation_SI_TC_43() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 18k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("18k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 18k material display Product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_43","Select 18k material display Product validated successfully");
    }

    public void MLShop_Select20kMaterialDisplayProductionValidation_SI_TC_44() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 20k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("20k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 20k material display Product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_44","Select 20k material display Product validated successfully");

    }

    public void MLShop_Select21kMaterialDisplayProductionValidation_SI_TC_45() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 21k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("21k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 21k material display Product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_45","Select 21k material display Product validated successfully");

    }

    public void MLShop_Select22kMaterialDisplayProductionValidation_SI_TC_46() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 22k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("22k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 22k material display Product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_41","Select 22k material display Product validated successfully");
    }

    public void MLShop_Select12kMaterialDisplayProductionValidation_SI_TC_47() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 12k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("12k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 12k material display Product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_47","Select 12k material display Product validated successfully");
    }

    public void MLShop_SelectYellowGoldMaterialColorDisplayProductValidation_SI_TC_48()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select Yellow Gold material color display product Validation");
        ExtentReporter.HeaderChildNode("MLS_TC_48, Select Yellow Gold material color display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilter(objSelectMaterialOptions("Yellow Gold"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select Yellow Gold material color display product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_48","Select Yellow Gold material color display product validated successfully");
    }

    public void MLShop_SelectWhiteGoldMaterialColorDisplayProductValidation_SI_TC_49()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select White Gold material color display product Validation");
        ExtentReporter.HeaderChildNode("MLS_TC_49, Select White Gold material color display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilter(objSelectMaterialOptions("White Gold"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select White Gold material color display product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_49","Select White Gold material color display product validated successfully");
    }

    public void MLShop_SelectRoseGoldMaterialColorDisplayProductValidation_SI_TC_50()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select Rose Gold material color display product Validation");
        ExtentReporter.HeaderChildNode("MLS_TC_50, Select Rose Gold material color display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilter(objSelectMaterialOptions("Rose Gold"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select Rose Gold material color display product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_50","Select Rose Gold material color display product validated successfully");
    }


    public void MLShop_SelectTwoToneMaterialColorDisplayProductValidation_SI_TC_51()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select Two Tone material color display product Validation");
        ExtentReporter.HeaderChildNode("MLS_TC_51, Select Two Tone material color display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilter(objSelectMaterialOptions("Two - Tone"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select Two Tone material color display product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_51", "Select Two Tone material color display product validated successfully");
    }



    public void MLShop_NecklaceCheckboxProductTypeUiValidation_TC_35() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_35,Necklace Checkbox Product Type UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("Yellow Gold"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select Yellow Gold material color display product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_48","Select Yellow Gold material color display product validated successfully");
        Swipe("up", 2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objNecklace, "Necklace item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilter,"Filter");
        if(verifyElementPresent(MLWalletShopItemsPage.objCategoriesHamburgerMenu,"Menu")){
            verifyElementPresent(MLWalletShopItemsPage.objNecklace,"Product Type");
            logger.info("MLS_TC_35,Necklace Checkbox Product Type UI Validated");
            extentLoggerPass("MLS_TC_35", "Necklace Checkbox Product Type UI Validated");
        }
    }

    public void MLShop_objBraceletAndBangleCheckboxProductTypeUiValidation_TC_36() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_35,objBracelet And Bangle Checkbox Product Type UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("White Gold"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select White Gold material color display product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_49","Select White Gold material color display product validated successfully");
        Swipe("up", 2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBraceletAndBangle, "Bracelet And Bangle item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilter,"Filter");
        if(verifyElementPresent(MLWalletShopItemsPage.objCategoriesHamburgerMenu,"Menu")){
            verifyElementPresent(MLWalletShopItemsPage.objBraceletAndBangle,"Product Type");
            logger.info("MLS_TC_35,objBracelet And Bangle Checkbox Product Type UI Validated");
            extentLoggerPass("MLS_TC_35", "objBracelet And Bangle Checkbox Product Type UI Validated");
        }
    }

    public void MLShop_EarringsCheckboxProductTypeUiValidation_TC_37() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_37,Earrings Checkbox Product Type UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("Rose Gold"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select Rose Gold material color display product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_50","Select Rose Gold material color display product validated successfully");

        Swipe("up", 2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objEarrings, "Earrings item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilter,"Filter");
        if(verifyElementPresent(MLWalletShopItemsPage.objCategoriesHamburgerMenu,"Menu")){
            verifyElementPresent(MLWalletShopItemsPage.objEarrings,"Product Type");
            logger.info("MLS_TC_37,Earrings Checkbox Product Type UI Validated");
            extentLoggerPass("MLS_TC_37", "Earrings Checkbox Product Type UI Validated");
        }
    }

    public void MLShop_PendantCheckboxProductTypeUiValidation_TC_38() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_38,Pendant Checkbox Product Type UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("Two - Tone"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select Two Tone  material color display product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_51", "Select Two Tone material color display product validated successfully");

    }

    public void MLShop_SelectTriToneMaterialColorDisplayProductValidation_SI_TC_52()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_52, Select  Tri Tone material color display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("Tri - Tone"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select Two Tone  material color display product validated successfully");
        ExtentReporter.extentLoggerPass("MLS_TC_52", "Select Tri Tone material color display product validated successfully");
    }
    public void MLShop_FilteringLadiesProduct_SI_TC_53()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_53, Filtering Ladies Product");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        filterGender(objSelectMaterialOptions(shopProp.getproperty("Ladies")));
        waitTime(5000);
        verifyElementPresent(objItemName, getText(objItemName));
        if(getText(objItemName).contains(shopProp.getproperty("Ladies"))){
            logger.info("MLS_TC_53, Filtering Ladies Product Successfully Validated");
            extentLoggerPass("MLS_TC_53", "Filtering Ladies Product Successfully Validated");
        }
    }
    public void MLShop_FilteringMensProduct_SI_TC_54()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_54, Filtering Mens Product");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        filterGender(objSelectMaterialOptions(shopProp.getproperty("Mens")));
        waitTime(5000);
        verifyElementPresent(objItemName, getText(objItemName));
        if(getText(objItemName).contains(shopProp.getproperty("Mens"))){
            logger.info("MLS_TC_54, Filtering Mens Product Successfully Validated");
            extentLoggerPass("MLS_TC_54", "Filtering Mens Product Successfully Validated");
        }
    }
    public void MLShop_FilteringUnisexProduct_SI_TC_55()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_55, Filtering Unisex Product");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        filterGender(objSelectMaterialOptions(shopProp.getproperty("Unisex")));
        waitTime(5000);
        verifyElementPresent(objItemName, getText(objItemName));
        if(getText(objItemName).contains(shopProp.getproperty("Unisex"))){
            logger.info("MLS_TC_55, Filtering Unisex Product Successfully Validated");
            extentLoggerPass("MLS_TC_55", "Filtering Unisex Product Successfully Validated");
        }
    }
    public void MLShop_FilterByPrice_SI_TC_56()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_56, Filtering By Price");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        setFilterPriceRange(shopProp.getproperty("Min"), shopProp.getproperty("Max"));
        if(verifyElementPresent(MLWalletShopItemsPage.objItemName, getText(MLWalletShopItemsPage.objItemName))){
            logger.info("Filtering By Price Successfully Validated");
            extentLoggerPass("", "");
        }
    }
    public void MLShop_SortItemsByPrice_SI_TC_57()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_57, Sorting By Price");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(5000);
        clickSort();
        if(verifyElementPresent(MLWalletShopItemsPage.objItemName, getText(MLWalletShopItemsPage.objItemName))){
            logger.info("Sorting By Price Successfully Validated");
            extentLoggerPass("", "");
        }

    }
    public void MLShop_VerifyProductDetails_SI_TC_58()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_58, Sorting By Price");
        mlWalletLogin(prop.getproperty("Semi_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(5000);
        clickSort();
        if(verifyElementPresent(MLWalletShopItemsPage.objItemName, getText(MLWalletShopItemsPage.objItemName))){
            verifyElementPresent(objItemDescription, getText(objItemDescription));
            logger.info("Sorting By Price Successfully Validated");
            extentLoggerPass("", "");
        }
    }
    public void MLShop_SI_TC_88()throws Exception{

    }
    public void MLShop_SI_TC_89()throws Exception{
        Swipe("up", 2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPendant, "Pendant item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilter,"Filter");
        if(verifyElementPresent(MLWalletShopItemsPage.objCategoriesHamburgerMenu,"Menu")){
            verifyElementPresent(MLWalletShopItemsPage.objPendant,"Product Type");
            logger.info("MLS_TC_38,Pendant Checkbox Product Type UI Validated");
            extentLoggerPass("MLS_TC_38", "Pendant Checkbox Product Type UI Validated");
        }
    }

    public void MLShop_SetsCheckboxProductTypeUiValidation_TC_39() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_39,Sets Checkbox Product Type UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("up", 2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objRing, "Ring item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilter,"Filter");
        if(verifyElementPresent(MLWalletShopItemsPage.objCategoriesHamburgerMenu,"Menu")){
            verifyElementPresentAndClick(MLWalletShopItemsPage.objTernoAndSet,"Product Type");
            logger.info("MLS_TC_39,Sets Checkbox Product Type UI Validated");
            extentLoggerPass("MLS_TC_39", "Sets Checkbox Product Type UI Validated");
        }
    }

    public void MLShop_BrouchCheckboxProductTypeUiValidation_TC_40() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_40,Brouch Checkbox Product Type UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("up", 2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objRing, "Ring item");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objFilter,"Filter");
        if(verifyElementPresent(MLWalletShopItemsPage.objCategoriesHamburgerMenu,"Menu")){
            verifyElementPresentAndClick(MLWalletShopItemsPage.objPinBrouchAndScalpings,"Product Type");
            logger.info("MLS_TC_40,Brouch Checkbox Product Type UI Validated");
            extentLoggerPass("MLS_TC_40", "Brouch Checkbox Product Type UI Validated");
        }
    }

    public void MLShop_AddToCartConfirmationMessageValidation_SI_TC_98()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_98, Add to Cart Confirmation Message Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item" ));
        waitTime(5000);
        Swipe("up", 2);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        if(verifyElementPresent(MLWalletShopItemsPage.objSuccessfullyAddedToCart,"Item has been successfully added to your cart.")){
            logger.info("Add to Cart Confirmation Message validated");
            extentLoggerPass("MLS_TC_98", "Add to Cart Confirmation Message Validation");
        }else {
            verifyElementPresent(MLWalletShopItemsPage.objItemAlreadyAddedInCart,"This item is already in your cart.");
            logger.info("Already in your cart Confirmation Message validated");
        }
    }
    public void MLShop_AlreadyInCartConfirmationMessageValidation_SI_TC_99()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_99, Already in your cart Confirmation Message Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item" ));
        waitTime(5000);
        Swipe("up", 2);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        if(verifyElementPresent(MLWalletShopItemsPage.objItemAlreadyAddedInCart,"This item is already in your cart.")){
            logger.info("Already in your cart Confirmation Message validated");
            extentLoggerPass("MLS_TC_99", "Already in your cart Confirmation Message Validation");
        }else{
            if(verifyElementPresent(MLWalletShopItemsPage.objSuccessfullyAddedToCart,"Item has been successfully added to your cart.")){
                waitTime(5000);
                click(MLWalletShopItemsPage.objConfirmAddCarButton,"Confirm Button");
                waitTime(5000);
                click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
                verifyElementPresent(MLWalletShopItemsPage.objItemAlreadyAddedInCart,"This item is already in your cart.");
                logger.info("Already in your cart Confirmation Message validated");
                extentLoggerPass("MLS_TC_99", "Already in your cart Confirmation Message Validation");
            }
        }
    }
    public void MLShop_UpdateItemCountInShoppingCartValidation_SI_TC_100()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_100, Update item count In Shopping Cart Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(5000);
        WebElement element = DriverManager.getAppiumDriver().findElement(MLWalletShopItemsPage.objCartItemCount);
        String initialValue = element.getText();
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item" ));
        waitTime(5000);
        Swipe("up", 2);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        click(MLWalletShopItemsPage.objConfirmAddCarButton,"Confirm Button");
        int originalValue = Integer.parseInt(initialValue);
        int expectedValue = originalValue + 1;
        if (originalValue + 1 == expectedValue) {
            logger.info("Item count updated");
            extentLoggerPass("MLS_TC_100", "Update item count In Shopping Cart validated successfully");
        }
    }
    public void MLShop_ProductDetailsDisplayValidation_SI_TC_105()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_105, Product Details Display Validation ");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 3);
        click(MLWalletShopItemsPage.objWatchProducts, "Watches Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item" ));
        waitTime(5000);
        Swipe("up", 1);
        if(verifyElementPresent(MLWalletShopItemsPage.objProductDetailsModelName, " Product Name")){
            checkProductDetails(objProductDetailsModelName, objProductDetailsMaterial, objProductDetailsColor, objProductDetailsSize, objProductDetailsBrand,  objProductDetailsMovement, objProductDetailsGender, objProductDetailsNote, objProductDetailsStockNumber );
            logger.info("Product details is displayed");
            extentLoggerPass("MLS_TC_105", "Product Details Display Validated successfully");
        }
    }
    public void MLShop_VerifyAddedProductIntTheCartValidation_SI_TC_107()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_107, Verify added product in the cart validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 3);
        click(MLWalletShopItemsPage.objWatchProducts, "Watches Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item" ));
        waitTime(5000);
        Swipe("up", 1);
        WebElement element = DriverManager.getAppiumDriver().findElement(objProductDetailsModelName);
        String displayedProduct = element.getText();
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        click(MLWalletShopItemsPage.objConfirmAddCarButton,"Confirm Button");
        Swipe("DOWN", 1);
        click(MLWalletShopItemsPage.objCartIcon, "Cart");
        WebElement elementInCart = DriverManager.getAppiumDriver().findElement(objItemInTheCartName);
        String addedProduct = elementInCart.getText();
        if (addedProduct.contains(displayedProduct)){
            logger.info("Selected Item " + displayedProduct + " is displayed in the cart " + addedProduct);
            extentLoggerPass("MLS_TC_107", "Verify added product in the cart validated successfully");
        }
    }
    public void MLShop_RemoveConfirmationPopUpDisplayValidationSI_TC_108()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_108, Remove Confirmation Pop Up Display Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 3);
        click(MLWalletShopItemsPage.objWatchProducts, "Watches Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item" ));
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        click(MLWalletShopItemsPage.objConfirmAddCarButton,"Confirm Button");
        Swipe("DOWN", 1);
        click(MLWalletShopItemsPage.objCartIcon, "Cart");
        click(MLWalletShopItemsPage.objDeleteIcon, "Button");
        if (verifyElementPresent(MLWalletShopItemsPage.objDeleteConfirmation, "Popup Confirmation")) {
            verifyElementPresentAndClick(MLWalletShopItemsPage.objDeleteYesButton, "Button");
            logger.info("Confirmation modal is displayed");
            extentLoggerPass("MLS_TC_108", "Remove Confirmation Pop Up Display Validated successfully");
        }
    }
    public void MLShop_VerifyIfCheckedBoxInitiallyCheckedValidation_SI_TC_112()throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_112, Verify If Checked Box Initially Checked Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        click(MLWalletShopItemsPage.objConfirmAddCarButton, "Confirm Button");
        Swipe("DOWN", 1);
        click(MLWalletShopItemsPage.objCartIcon, "Cart");
        WebElement checkbox = DriverManager.getAppiumDriver().findElement(objShoppngCartCheckBox);
        String isChecked = checkbox.getAttribute("checked");
        if (isChecked != null && isChecked.equalsIgnoreCase("true")) {
            logger.info("Checkbox is checked by default");
            extentLoggerPass("MLS_TC_112", "Verify If Checked Box Initially Checked Validated successfully");
        }
    }
    public void MLShop_RedirectToGrabPayPortalValidationSI_TC_216() throws Exception {
        ExtentReporter.HeaderChildNode("SI_TC_216, Redirect To Grab Pay Portal Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 3);
        click(MLWalletShopItemsPage.objWatchProducts, "Watches Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item" ));
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        click(MLWalletShopItemsPage.objConfirmAddCarButton, "Confirm Button");
        Swipe("DOWN", 1);
        click(MLWalletShopItemsPage.objCartIcon, "Cart");
        click(MLWalletShopItemsPage.objCheckOutBtn, "Checkout");
        waitTime(5000);
        Swipe("up", 3);
        selectPickUpBranch();
        click(MLWalletShopItemsPage.objPaymentEWallet, "Option");
        click(MLWalletShopItemsPage.objGrabPay, "Grab Pay");
        Swipe("up", 2);
        click(MLWalletShopItemsPage.objPlaceOrderBtn, "Place Order");
        click(MLWalletShopItemsPage.objProceedBtn, "Proceed");
        if (verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, "Pay Mongo Portal")) {
            logger.info("Pay Mongo Portal Grab Pay is displayed");
            extentLoggerPass("MLS_TC_216", " Redirect To Grab Pay Portal Validated successfully");
        }
    }
    public void MLShop_RedirectToPayMayaPortalValidationSI_TC_218() throws Exception {
        ExtentReporter.HeaderChildNode("SI_TC_218, Redirect To Pay Maya Portal Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 3);
        click(MLWalletShopItemsPage.objWatchProducts, "Watches Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item" ));
        waitTime(5000);
        Swipe("up", 1);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        click(MLWalletShopItemsPage.objConfirmAddCarButton, "Confirm Button");
        Swipe("DOWN", 1);
        click(MLWalletShopItemsPage.objCartIcon, "Cart");
        click(MLWalletShopItemsPage.objCheckOutBtn, "Checkout");
        waitTime(5000);
        Swipe("up", 3);
        selectPickUpBranch();
        click(MLWalletShopItemsPage.objPaymentEWallet, "Option");
        click(MLWalletShopItemsPage.objPayMaya, "Pay Maya");
        Swipe("up", 2);
        click(MLWalletShopItemsPage.objPlaceOrderBtn, "Place Order");
        click(MLWalletShopItemsPage.objProceedBtn, "Proceed");
        if (verifyElementPresent(MLWalletShopItemsPage.objPaymongoPortalPage, "Pay Mongo Portal")) {
            logger.info("Pay Mongo Portal Paya Maya is displayed");
            extentLoggerPass("MLS_TC_216", " Redirect To Pay Maya Portal Validated successfully");
        }
    }
    public void MLShop_WalletDeductOnSuccessPurchased_TC_202() throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_202,Check Wallet Balance After Purchasing via Wallet");
        mlWalletLogin(prop.getproperty("Branch_Verified_LowBalance"));
        String beforeBal =null , afterBal  = null;
        //getWallentBalance(beforeBal);
        shopItemsNavigation();
        selectItemAndAddToCart();
        navigationToCart();
        placeOrder(shopProp.getproperty("MLWallet"));
        waitTime(5000);
        enterOTP(prop.getproperty("Valid_OTP"));
        waitTime(5000);
        click(MLWalletShopItemsPage.objSuccessFullyCheckOutOkayBtn, "Button");
        click(objBackArrowBtn, "Exit MLShop Button");
        Swipe("DOWN", 2);
        assertNotEquals(beforeBal, afterBal);
        logger.info("MLS_TC_202, Wallet Deduction on Success Purchased via Wallet");
        ExtentReporter.extentLoggerPass("MLS_TC_202", "Wallet Deduction on Success Purchased via Wallet");

    }
    public void MLShop_SuccessfullyPurchasedGCash_TC_308() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_308, MLShop Successfully Purchased GCash");
        MLShop_PaymongoPortalGcash_TC_207();
        click(MLWalletShopItemsPage.objContinuePaymongo, "Continue");
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objAgreePolicyPaymongo, "Agree Policy");
        click(MLWalletShopItemsPage.objCompletePaymentPaymongo, "CompletePayment");
        click(MLWalletShopItemsPage.objAuthorizeTestPaymentPaymongo, "Authorize Test Payment");
        verifyElementPresent(MLWalletShopItemsPage.objSuccessfulGcashPayment, getTextVal(MLWalletShopItemsPage.objSuccessfulGcashPayment, "GCash payment received!"));
        logger.info("MLS_TC_308, MLShop Successfully Purchased GCash");
        extentLoggerPass("MLS_TC_308", "MLShop Successfully Purchased GCash");
    }
    public void MLShop_SuccessfullyPurchasedGrabPay_TC_309() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_309, MLShop Successfully Purchased GrabPay");
        MLShop_PaymongoPortalGrabPay_TC_206();
        click(MLWalletShopItemsPage.objContinuePaymongo, "Continue");
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objAgreePolicyPaymongo, "Agree Policy");
        click(MLWalletShopItemsPage.objCompletePaymentPaymongo, "CompletePayment");
        click(MLWalletShopItemsPage.objAuthorizeTestPaymentPaymongo, "Authorize Test Payment");
        verifyElementPresent(MLWalletShopItemsPage.objSuccessfulGrabPayPayment, getTextVal(MLWalletShopItemsPage.objSuccessfulGrabPayPayment, "GrabPay payment received!"));
        logger.info("MLS_TC_309, MLShop Successfully Purchased GrabPay");
        extentLoggerPass("MLS_TC_309", "MLShop Successfully Purchased GrabPay");
    }


    public void MLShop_SuccessfullyPurchasedPaymaya_TC_310() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_310, MLShop Successfully Purchased Paymaya");
        MLShop_PaymongoPortalMaya_TC_208();
        click(MLWalletShopItemsPage.objContinuePaymongo, "Continue");
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objAgreePolicyPaymongo, "Agree Policy");
        click(MLWalletShopItemsPage.objCompletePaymentPaymongo, "CompletePayment");
        click(MLWalletShopItemsPage.objAuthorizeTestPaymentPaymongo, "Authorize Test Payment");
        verifyElementPresent(MLWalletShopItemsPage.objSuccessfulMayaPayment, getTextVal(MLWalletShopItemsPage.objSuccessfulMayaPayment, "Maya payment received!"));
        logger.info("MLS_TC_310, MLShop Successfully Purchased Paymaya");
        extentLoggerPass("MLS_TC_310", "MLShop Successfully Purchased Paymaya");
    }
    public void MLShop_SuccessfullyPurchasedVisaMastercard_TC_311() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_311, MLShop Successfully Purchased Visa Mastercard");
        MLShop_PaymongoPortalCreditDebit_TC_205();
        click(MLWalletShopItemsPage.objContinuePaymongo, "Continue");
        Swipe("UP", 1);
        type(objcardnumberCreditPayment, shopProp.getproperty("CardNumber"), "Card Number");
        type(objExpMonthCreditPayment, shopProp.getproperty("CardMonth"), "Card Month");
        type(objExpYearCreditPayment, shopProp.getproperty("CardYear"), "Card Year");
        type(objCvcCreditPayment, shopProp.getproperty("CardCVC"), "Card CVC");
        Swipe("UP", 3);
        click(MLWalletShopItemsPage.objAgreePolicyPaymongo, "Agree Policy");
        click(MLWalletShopItemsPage.objCompletePaymentPaymongo, "CompletePayment");
        verifyElementPresent(MLWalletShopItemsPage.objSuccessfulCreditPayment, getTextVal(MLWalletShopItemsPage.objSuccessfulCreditPayment, "Credit or debit card payment received!"));
        logger.info("MLS_TC_311, MLShop Successfully Purchased Visa Mastercard");
        extentLoggerPass("MLS_TC_311", "MLShop Successfully Purchased Visa Mastercard");
    }

    public void MLShop_PaymongoVerifyListOfPaymentMethod_TC_204() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_204, Paymongo Verify List Of Payment Method");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        placeOrder(shopProp.getproperty("Ewallet"));
        if (verifyElementPresent(MLWalletShopItemsPage.objPaymentEWallet, getTextVal(MLWalletShopItemsPage.objPaymentEWallet, "E-Wallet"))) {
            verifyElementPresent(MLWalletShopItemsPage.objPaymentGrabPay, getTextVal(MLWalletShopItemsPage.objPaymentGrabPay, "Grab Pay"));
            verifyElementPresent(MLWalletShopItemsPage.objPaymentGcash, getTextVal(MLWalletShopItemsPage.objPaymentGcash, "Gcash"));
            verifyElementPresent(MLWalletShopItemsPage.objPaymentPayMaya, getTextVal(MLWalletShopItemsPage.objPaymentPayMaya, "PayMaya"));
            logger.info("MLS_TC_204, Paymongo Verify List Of Payment Method");
            extentLoggerPass("MLS_TC_204", "Paymongo Verify List Of Payment Method");
        }
    }

    public void shopItemsJewelryAvailabilityProductTypesUIValidation_MLS_TC_18 () throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Jewelry Availability Product Types UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        waitTime(5000);
        Swipe("UP", 2);
        verifyElementPresent(MLWalletShopItemsPage.objRings, getTextVal(MLWalletShopItemsPage.objRings, "Rings"));
        verifyElementPresent(MLWalletShopItemsPage.objNecklacePendants, getTextVal(MLWalletShopItemsPage.objNecklacePendants, "Necklaces And Pendants"));
        verifyElementPresent(MLWalletShopItemsPage.objBraceletAndBangle, getTextVal(MLWalletShopItemsPage.objBraceletAndBangle, "Bracelets And Bangles"));
        verifyElementPresent(MLWalletShopItemsPage.objEarrings, getTextVal(MLWalletShopItemsPage.objEarrings, "Earrings"));
        logger.info("MLS_TC_adb , Shop Items Jewelry Availability Product Types UI Validation");
        ExtentReporter.extentLoggerPass("MLS_TC_18", "MLS_TC_18, Shop Items Jewelry Availability Product Types UI Validation");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsSelectedItemScreenRingsDetailsUIValidation_MLS_TC_20 () throws Exception {
        ExtentReporter.HeaderChildNode("shop Items Selected Item Screen Rings Details UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        waitTime(5000);
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings");
        clickSort();
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        Swipe("UP", 2);
        verifyElementPresent(MLWalletShopItemsPage.objProductName, getTextVal(MLWalletShopItemsPage.objProductName, "Product Name"));
        verifyElementPresent(MLWalletShopItemsPage.objProductMaterial, getTextVal(MLWalletShopItemsPage.objProductMaterial, "Material"));
        verifyElementPresent(MLWalletShopItemsPage.objProductMaterialColor, getTextVal(MLWalletShopItemsPage.objProductMaterialColor, "Material Color"));
        verifyElementPresent(MLWalletShopItemsPage.objProductSize, getTextVal(MLWalletShopItemsPage.objProductSize, "Size"));
        verifyElementPresent(MLWalletShopItemsPage.objProductStone, getTextVal(MLWalletShopItemsPage.objProductStone, "Stone"));
        verifyElementPresent(MLWalletShopItemsPage.objProductItemWeight, getTextVal(MLWalletShopItemsPage.objProductItemWeight, "Item Weight"));
        verifyElementPresent(MLWalletShopItemsPage.objProductStoneColor, getTextVal(MLWalletShopItemsPage.objProductStoneColor, "Stone Color"));
        verifyElementPresent(MLWalletShopItemsPage.objProductGender, getTextVal(MLWalletShopItemsPage.objProductGender, "Gender"));
        verifyElementPresent(MLWalletShopItemsPage.objProductStockNo, getTextVal(MLWalletShopItemsPage.objProductStockNo, "Stock No"));
        logger.info("MLS_TC_20, shop Items Selected Item Screen Rings Details UI Validation");
        ExtentReporter.extentLoggerPass("MLS_TC_20", "MLS_TC_20, shop Items Selected Item Screen Rings Details UI Validation");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsSelectedItemScreenBraceletAndBangleDetailsUIValidation_MLS_TC_21 () throws Exception {
        ExtentReporter.HeaderChildNode("shop Items Selected Item Screen Bracelet And Bangle Details UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        waitTime(5000);
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objBraceletAndBangle, "Bracelet And Bangle");
        clickSort();
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        Swipe("UP", 2);
        verifyElementPresent(MLWalletShopItemsPage.objProductName, getTextVal(MLWalletShopItemsPage.objProductName, "Product Name"));
        verifyElementPresent(MLWalletShopItemsPage.objProductMaterial, getTextVal(MLWalletShopItemsPage.objProductMaterial, "Material"));
        verifyElementPresent(MLWalletShopItemsPage.objProductMaterialColor, getTextVal(MLWalletShopItemsPage.objProductMaterialColor, "Material Color"));
        verifyElementPresent(MLWalletShopItemsPage.objProductSize, getTextVal(MLWalletShopItemsPage.objProductSize, "Size"));
        verifyElementPresent(MLWalletShopItemsPage.objProductStone, getTextVal(MLWalletShopItemsPage.objProductStone, "Stone"));
        verifyElementPresent(MLWalletShopItemsPage.objProductItemWeight, getTextVal(MLWalletShopItemsPage.objProductItemWeight, "Item Weight"));
        verifyElementPresent(MLWalletShopItemsPage.objProductStoneColor, getTextVal(MLWalletShopItemsPage.objProductStoneColor, "Stone Color"));
        verifyElementPresent(MLWalletShopItemsPage.objProductGender, getTextVal(MLWalletShopItemsPage.objProductGender, "Gender"));
        verifyElementPresent(MLWalletShopItemsPage.objProductStockNo, getTextVal(MLWalletShopItemsPage.objProductStockNo, "Stock No"));
        logger.info("MLS_TC_21, shop Items Selected Item Screen Bracelet And Bangle Details UI Validation");
        ExtentReporter.extentLoggerPass("MLS_TC_21", "MLS_TC_21, shop Items Selected Item Screen Bracelet And Bangle Details UI Validation");
        System.out.println("-----------------------------------------------------------");
    }
}
