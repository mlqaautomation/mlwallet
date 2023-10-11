package com.mlshop;

import com.business.mlwallet.BaseClass;
import com.mlwallet.pages.MLWalletShopItemsPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

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
        selectFilterMaterial(objSelectMaterialOptions("10k"), MLWalletShopItemsPage.objMaterialTextView);
        logger.info("Select 10k material display Production validated successfully");
    }

    public void MLShop_Select14kMaterialDisplayProductionValidation_SI_TC_42() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 14k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("14k"), MLWalletShopItemsPage.objMaterialTextView);
        logger.info("Select 14k material display Production validated successfully");
    }

    public void MLShop_Select18kMaterialDisplayProductionValidation_SI_TC_43() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 18k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("18k"), MLWalletShopItemsPage.objMaterialTextView);
        logger.info("Select 18k material display Production validated successfully");
    }

    public void MLShop_Select20kMaterialDisplayProductionValidation_SI_TC_44() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 20k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("20k"), MLWalletShopItemsPage.objMaterialTextView);
        logger.info("Select 20k material display Production validated successfully");
    }

    public void MLShop_Select21kMaterialDisplayProductionValidation_SI_TC_45() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 21k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("21k"), MLWalletShopItemsPage.objMaterialTextView);
        logger.info("Select 21k material display Production validated successfully");
    }

    public void MLShop_Select22kMaterialDisplayProductionValidation_SI_TC_46() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 22k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("22k"), MLWalletShopItemsPage.objMaterialTextView);
        logger.info("Select 22k material display Production validated successfully");
    }

    public void MLShop_Select12kMaterialDisplayProductionValidation_SI_TC_47() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 12k material display production Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("12k"), MLWalletShopItemsPage.objMaterialTextView);
        logger.info("Select 12k material display Production validated successfully");
    }

    public void MLShop_NecklaceCheckboxProductTypeUiValidation_TC_35() throws Exception {
        ExtentReporter.HeaderChildNode("MLS_TC_35,Necklace Checkbox Product Type UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
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
