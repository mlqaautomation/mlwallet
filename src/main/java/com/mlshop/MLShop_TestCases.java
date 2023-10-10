package com.mlshop;

import com.business.mlwallet.BaseClass;
import com.mlwallet.pages.MLWalletShopItemsPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.mlwallet.pages.MLWalletShopItemsPage.objSelectMaterialColorOptions;
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
    public void MLShop_Select10kMaterialDisplayProductValidation_SI_TC_41()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 10k material display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("10k"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select 10k material display Product validated successfully");
    }

    public void MLShop_Select14kMaterialDisplayProductValidation_SI_TC_42()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 14k material display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("14k"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select 14k material display Product validated successfully");
    }

    public void MLShop_Select18kMaterialDisplayProductValidation_SI_TC_43()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 18k material display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("18k"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select 18k material display Product validated successfully");
    }

    public void MLShop_Select20kMaterialDisplayProductValidation_SI_TC_44()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 20k material display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("20k"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select 20k material display Productvalidated successfully");
    }

    public void MLShop_Select21kMaterialDisplayProductValidation_SI_TC_45()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 21k material display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("21k"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select 21k material display Product validated successfully");
    }

    public void MLShop_Select22kMaterialDisplayProductValidation_SI_TC_46()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 22k material display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("22k"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select 22k material display Product validated successfully");
    }

    public void MLShop_Select12kMaterialDisplayProductValidation_SI_TC_47()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select 12k material display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterial(objSelectMaterialOptions("12k"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select 12k material display Product validated successfully");
    }

    public void MLShop_SelectYellowGoldMaterialColorDisplayProductValidation_SI_TC_48()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select Yellow Gold material color display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterialColor(objSelectMaterialColorOptions("Yellow Gold"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select Yellow Gold material color display product validated successfully");
    }

    public void MLShop_SelectWhiteGoldMaterialColorDisplayProductValidation_SI_TC_49()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select White Gold material color display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterialColor(objSelectMaterialColorOptions("White Gold"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select White Gold material color display product validated successfully");
    }

    public void MLShop_SelectRoseGoldMaterialColorDisplayProductValidation_SI_TC_50()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select Rose Gold material color display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterialColor(objSelectMaterialColorOptions("Rose Gold"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select Rose Gold material color display product validated successfully");
    }

    public void MLShop_SelectTwoToneMaterialColorDisplayProductValidation_SI_TC_51()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select  Two Tone material color display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterialColor(objSelectMaterialColorOptions("Two - Tone"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select Two Tone  material color display product validated successfully");
    }

    public void MLShop_SelectTriToneMaterialColorDisplayProductValidation_SI_TC_52()throws Exception{
        ExtentReporter.HeaderChildNode("MLS_TC_41, Select  Two Tone material color display product Validation");
        mlWalletLogin(prop.getproperty("New_Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        selectFilterMaterialColor(objSelectMaterialColorOptions("Tri - Tone"), MLWalletShopItemsPage.objMaterialTextView );
        logger.info("Select Two Tone  material color display product validated successfully");
    }

}

