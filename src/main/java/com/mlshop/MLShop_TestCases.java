package com.mlshop;
import com.mlwallet.pages.MLWalletHomePage;
import com.mlwallet.pages.MLWalletLogOutPage;
import com.mlwallet.pages.MLWalletTroubleSigningInPage;
import com.business.mlwallet.BaseClass;
import com.mlwallet.pages.MLWalletShopItemsPage;
import com.utility.ExtentReporter;
import static com.mlwallet.pages.MLWalletShopItemsPage.*;
import java.util.List;
import static com.mlwallet.pages.MLWalletShopItemsPage.objSelectMaterialOptions;
import com.mlwallet.pages.MLWalletShopItemsPage;
import com.utility.ExtentReporter;

import static com.utility.Utilities.*;
import static com.utility.Utilities.click;

public class MLShop_TestCases extends MLShop_GenMethods {
    public MLShop_TestCases(String Application, String deviceName, String portno) throws InterruptedException {
        super(Application, deviceName, portno);
    }


    //todo
    // TEST CASES FOR HOMEPAGE
    //


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

    public void MLShop_NecklaceCheckboxProductTypeUiValidation_TC_35() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_35,Necklace Checkbox Product Type UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("Yellow Gold"), MLWalletShopItemsPage.objItemDescription);
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
}
