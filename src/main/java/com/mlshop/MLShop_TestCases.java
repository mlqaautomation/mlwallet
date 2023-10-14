package com.mlshop;

import com.business.mlwallet.BaseClass;
import com.mlwallet.pages.MLWalletShopItemsPage;
import com.utility.ExtentReporter;
import static com.mlwallet.pages.MLWalletShopItemsPage.*;
import java.util.List;
import static com.mlwallet.pages.MLWalletShopItemsPage.objSelectMaterialOptions;
import static com.utility.Utilities.*;
import static com.utility.Utilities.click;

public class MLShop_TestCases extends MLShop_GenMethods {
    public MLShop_TestCases(String Application, String deviceName, String portno) throws InterruptedException {
        super(Application, deviceName, portno);
    }


    //todo
    // TEST CASES FOR HOMEPAGE
    //
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
        selectFilterMaterial(objSelectMaterialOptions("20k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 20k material display Production validated successfully");
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
        selectFilterMaterial(objSelectMaterialOptions("21k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 21k material display Production validated successfully");
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
        selectFilterMaterial(objSelectMaterialOptions("22k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 22k material display Production validated successfully");
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
        selectFilterMaterial(objSelectMaterialOptions("12k"), MLWalletShopItemsPage.objItemDescription);
        logger.info("Select 12k material display Production validated successfully");
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
}
