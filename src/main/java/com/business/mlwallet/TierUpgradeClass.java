package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.mlwallet.pages.MLWalletHomePage;
import com.mlwallet.pages.MLWalletTierUpgrade;
import com.utility.ExtentReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.utility.Utilities.*;
import static com.utility.Utilities.getTextVal;

public class TierUpgradeClass extends BaseClass {

    public TierUpgradeClass(){
        super();
    }

    public void tierUpgradeHomePageIIconValidationAsBuyerTierUser_TU_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Home Page I Icon Validation as BuyerTier User");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        if (verifyElementPresent(MLWalletHomePage.objIIcon, "i Icon")) {
            verifyElementPresent(MLWalletHomePage.objLearnMoreTxt,getTextVal(MLWalletHomePage.objLearnMoreTxt,"Text"));
            logger.info("TU_TC_01, Tier Upgrade Home Page I Icon validated as BuyerTier User");
            ExtentReporter.extentLoggerPass("TU_TC_01", "TU_TC_01, Tier Upgrade Home Page I Icon validated as BuyerTier User");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeHomePageIIconValidationAsSemiVerifiedTierUser_TU_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Home Page I Icon Validation as as Semi verified Tier User");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        if (verifyElementPresent(MLWalletHomePage.objIIcon, "i Icon")) {
            verifyElementPresent(MLWalletHomePage.objLearnMoreTxt,getTextVal(MLWalletHomePage.objLearnMoreTxt,"Text"));
            logger.info("TU_TC_02, Tier Upgrade Home Page I Icon validated as Semi verified User");
            ExtentReporter.extentLoggerPass("TU_TC_02", "TU_TC_02, Tier Upgrade Home Page I Icon validated as Semi verified User");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeHomePageIIconValidationAsFullyVerifiedTierUser_TU_TC_03() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Home Page I Icon Validation as Fully verified Tier User");
        mlWalletLogin(prop.getproperty("Fully_verified"));
        verifyElementNotPresent(MLWalletHomePage.objIIcon, "i Icon", 5);
        verifyElementNotPresent(MLWalletHomePage.objLearnMoreTxt,"Learn More Txt",5);
        logger.info("TU_TC_03, Tier Upgrade Home Page I Icon not displayed For Fully-verified Tier user");
        ExtentReporter.extentLoggerPass("TU_TC_03", "TU_TC_03, Tier Upgrade Home Page I Icon not displayed For Fully-verified Tier user");
        System.out.println("-----------------------------------------------------------");
    }

    public void tierUpgradeVerificationTierPerksPageNavigationAsBuyerTierUser_TU_TC_04() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Verification tier perks page navigation as BuyerTier User");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            logger.info("TU_TC_04, Tier Upgrade Verification tier perks page navigation validated as BuyerTier User");
            ExtentReporter.extentLoggerPass("TU_TC_04", "TU_TC_04, Tier Upgrade Verification tier perks page navigation validated as BuyerTier User");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeVerificationTierPerksPageNavigationAsSemiVerifiedTierUser_TU_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Verification tier perks page navigation as Semi Verified Tier User");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            logger.info("TU_TC_05, Tier Upgrade Verification tier perks page navigation validated as Semi Verified Tier User");
            ExtentReporter.extentLoggerPass("TU_TC_05", "TU_TC_05, Tier Upgrade Verification tier perks page navigation validated as Semi Verified Tier User");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeVerificationTierPerksBackBtnValidation_TU_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Verification tier perks Back button validation");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objVerificationTierPerksBackBtn,"Back Button");
        if(verifyElementPresent(MLWalletHomePage.objAvailableBalanceHeader,getTextVal(MLWalletHomePage.objAvailableBalanceHeader,"Header"))){
            logger.info("TU_TC_06, Tier Upgrade, After clicking back btn in verification tier perks app navigates to Home Page is validated");
            ExtentReporter.extentLoggerPass("TU_TC_06", "TU_TC_06, Tier Upgrade, After clicking back btn in verification tier perks app navigates to Home Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeUpgradeTierLevelBtnValidationForSemiVerifiedTabAsBuyTierUser_TU_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Upgrade tier level Button validation, For Semi verified tab As Buyer tier User");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objSemiVerifiedTab,getTextVal(MLWalletTierUpgrade.objSemiVerifiedTab,"Tab"));
        if(verifyElementPresent(MLWalletTierUpgrade.objUpgradeTierLevel,getTextVal(MLWalletTierUpgrade.objUpgradeTierLevel, "Button"))){
            logger.info("TU_TC_07, Tier Upgrade Upgrade tier level Button validated, For Semi verified tab As Buyer tier User");
            ExtentReporter.extentLoggerPass("TU_TC_07", "TU_TC_07, Tier Upgrade Upgrade tier level Button validated, For Semi verified tab As Buyer tier User");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeUpgradeTierLevelBtnValidationForFullyVerifiedTabAsBuyTierUser_TU_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Upgrade tier level Button validation, For Fully verified tab As Buyer tier User");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objFullyVerifiedTab,getTextVal(MLWalletTierUpgrade.objFullyVerifiedTab,"Tab"));
        if(verifyElementPresent(MLWalletTierUpgrade.objUpgradeTierLevel,getTextVal(MLWalletTierUpgrade.objUpgradeTierLevel, "Button"))){
            logger.info("TU_TC_08, Tier Upgrade Upgrade tier level Button validated, For Fully verified tab As Buyer tier User");
            ExtentReporter.extentLoggerPass("TU_TC_08", "TU_TC_08, Tier Upgrade Upgrade tier level Button validated, For Fully verified tab As Buyer tier User");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeUpgradeTierLevelBtnValidationForBranchVerifiedTabAsBuyerTierUser_TU_TC_09() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Upgrade tier level Button validation, For Branch verified tab As Buyer tier User");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objBranchVerifiedTab,getTextVal(MLWalletTierUpgrade.objBranchVerifiedTab,"Tab"));
        verifyElementNotPresent(MLWalletTierUpgrade.objUpgradeTierLevel,"Upgrade Tier Level Button",5);
        logger.info("TU_TC_09, Tier Upgrade Upgrade tier level Button validated, For Branch verified tab As Buyer tier User");
        ExtentReporter.extentLoggerPass("TU_TC_09", "TU_TC_09, Tier Upgrade Upgrade tier level Button validated, For Branch verified tab As Buyer tier User");
        System.out.println("-----------------------------------------------------------");
    }

    public void tierUpgradeUpgradeTierLevelBtnValidationForFullyVerifiedTabAsSemiVerifiedTierUser_TU_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Upgrade tier level Button validation, For Fully verified tab As Semi verified tier User");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objFullyVerifiedTab,getTextVal(MLWalletTierUpgrade.objFullyVerifiedTab,"Tab"));
        if(verifyElementPresent(MLWalletTierUpgrade.objUpgradeTierLevel,getTextVal(MLWalletTierUpgrade.objUpgradeTierLevel, "Button"))){
            logger.info("TU_TC_10, Tier Upgrade Upgrade tier level Button validated, For Fully verified tab As Semi verified tier User");
            ExtentReporter.extentLoggerPass("TU_TC_10", "TU_TC_10, Tier Upgrade Upgrade tier level Button validated, For Fully verified tab As Semi verified tier User");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeUpgradeTierLevelBtnValidationForBranchVerifiedTabAsSemiVerifiedTierUser_TU_TC_11() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Upgrade tier level Button validation, For Branch verified tab As Semi verified tier User");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objBranchVerifiedTab,getTextVal(MLWalletTierUpgrade.objBranchVerifiedTab,"Tab"));
        verifyElementNotPresent(MLWalletTierUpgrade.objUpgradeTierLevel,"Upgrade Tier Level Button",5);
        logger.info("TU_TC_11, Tier Upgrade Upgrade tier level Button validated, For Branch verified tab As Semi verified tier User");
        ExtentReporter.extentLoggerPass("TU_TC_11", "TU_TC_11, Tier Upgrade Upgrade tier level Button validated, For Branch verified tab As Semi verified tier User");
        System.out.println("-----------------------------------------------------------");
    }

    public void tierUpgradeAccountDetailsPageNavigationAsBuyerTierUserToUpgradeToSemiVerifiedTier_TU_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Account details page navigation as Buyer tier user to upgrade to Semi verified tier user");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objSemiVerifiedTab,getTextVal(MLWalletTierUpgrade.objSemiVerifiedTab,"Tab"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objUpgradeTierLevel,getTextVal(MLWalletTierUpgrade.objUpgradeTierLevel, "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objAccountDetails,getTextVal(MLWalletTierUpgrade.objAccountDetails, "Page"))){
            logger.info("TU_TC_12, Tier Upgrade Account details page navigation validated as Buyer tier user to upgrade to Semi verified tier user");
            ExtentReporter.extentLoggerPass("TU_TC_12", "TU_TC_12, Tier Upgrade Account details page navigation validated as Buyer tier user to upgrade to Semi verified tier user");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeAccountDetailsPageNavigationAsBuyerTierUserToUpgradeToFullyVerifiedTier_TU_TC_13() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Account details page navigation as Buyer tier user to upgrade to Fully verified tier user");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objFullyVerifiedTab,getTextVal(MLWalletTierUpgrade.objFullyVerifiedTab,"Tab"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objUpgradeTierLevel,getTextVal(MLWalletTierUpgrade.objUpgradeTierLevel, "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objAccountDetails,getTextVal(MLWalletTierUpgrade.objAccountDetails, "Page"))){
            logger.info("TU_TC_13, Tier Upgrade Account details page navigation validated as Buyer tier user to upgrade to Fully verified tier user");
            ExtentReporter.extentLoggerPass("TU_TC_13", "TU_TC_13, Tier Upgrade Account details page navigation validated as Buyer tier user to upgrade to Fully verified tier user");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeAccountDetailsPageNavigationAsSemiVerifiedTierUserToUpgradeToFullyVerifiedTier_TU_TC_14() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Account details page navigation as Semi verified tier user to upgrade to Fully verified tier user");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objFullyVerifiedTab,getTextVal(MLWalletTierUpgrade.objFullyVerifiedTab,"Tab"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objUpgradeTierLevel,getTextVal(MLWalletTierUpgrade.objUpgradeTierLevel, "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objAccountDetails,getTextVal(MLWalletTierUpgrade.objAccountDetails, "Page"))){
            logger.info("TU_TC_14, Tier Upgrade Account details page navigation validated as Semi verified tier user to upgrade to Fully verified tier user");
            ExtentReporter.extentLoggerPass("TU_TC_14", "TU_TC_14, Tier Upgrade Account details page navigation validated as Semi verified tier user to upgrade to Fully verified tier user");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeAccountDetailsPageBackBtnValidation_TU_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Tier upgrade Account details page Back button functionality validation");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objFullyVerifiedTab,getTextVal(MLWalletTierUpgrade.objFullyVerifiedTab,"Tab"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objUpgradeTierLevel,getTextVal(MLWalletTierUpgrade.objUpgradeTierLevel, "Button"));
        verifyElementPresent(MLWalletTierUpgrade.objAccountDetails,getTextVal(MLWalletTierUpgrade.objAccountDetails, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objAccountDetailsBackBtn,"Account details page Back button");
        if (verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"))) {
            logger.info("TU_TC_15, Tier Upgrade, After clicking back btn in Account details page app navigates to Verification tier perks Page is validated");
            ExtentReporter.extentLoggerPass("TU_TC_15", "TU_TC_15, Tier Upgrade, After clicking back btn in Account details page app navigates to Verification tier perks Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeAutoSuggestionsValidationForProductServicesOffered_TU_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Auto Suggestions validation for Product/Services Offered");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objProductServiceSelectionBtn,"Product/Services offered selection Button");
        type(MLWalletTierUpgrade.objSearchFieldInput,"C","Product/Services offered search field");
        if (verifyElementDisplayed(MLWalletTierUpgrade.objMatchingElements)) {
            List<WebElement> values = findElements(MLWalletTierUpgrade.objMatchingElements);
            for (int i = 1; i < values.size(); i++) {
                String matchingElements = getText(MLWalletTierUpgrade.objMatchingElementsProductServices(i));
                logger.info("Matching Elements : " + matchingElements + " is displayed");
                ExtentReporter.extentLogger(" ", "Matching Elements : " + matchingElements + " is displayed");
            }
        } else {
            logger.info("No Matching Elements");
        }
        logger.info("TU_TC_16, Tier Upgrade, Auto Suggestions validated for Product/Services Offered");
        ExtentReporter.extentLoggerPass("TU_TC_16", "TU_TC_16, Tier Upgrade, Auto Suggestions validated for Product/Services Offered");
        System.out.println("-----------------------------------------------------------");
    }

    public void tierUpgradeAutoSuggestionsValidationForPositionAtWork_TU_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Auto Suggestions validation for Position at Work");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objPositionAtWokSelectionBtn,"Position at Work selection Button");
        type(MLWalletTierUpgrade.objSearchFieldInput,"A","Position at Work search field");
        if (verifyElementDisplayed(MLWalletTierUpgrade.objMatchingElements)) {
            List<WebElement> values = findElements(MLWalletTierUpgrade.objMatchingElements);
            for (int i = 1; i < values.size(); i++) {
                String matchingElements = getText(MLWalletTierUpgrade.objMatchingElementsProductServices(i));
                logger.info("Matching Elements : " + matchingElements + " is displayed");
                ExtentReporter.extentLogger(" ", "Matching Elements : " + matchingElements + " is displayed");
            }
        } else {
            logger.info("No Matching Elements");
        }
        logger.info("TU_TC_17, Tier Upgrade, Auto Suggestions validated for Position at Work");
        ExtentReporter.extentLoggerPass("TU_TC_17", "TU_TC_17, Tier Upgrade, Auto Suggestions validated for Position at Work");
        System.out.println("-----------------------------------------------------------");
    }

    public void tierUpgradeAutoSuggestionsValidationForNatureOfWork_TU_TC_18() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Auto Suggestions validation for Nature of Work");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objNatureOfWorkSelectionBtn,"Nature of Work selection Button");
        type(MLWalletTierUpgrade.objSearchFieldInput,"U","Nature of Work search field");
        if (verifyElementDisplayed(MLWalletTierUpgrade.objMatchingElements)) {
            List<WebElement> values = findElements(MLWalletTierUpgrade.objMatchingElements);
            for (int i = 1; i < values.size(); i++) {
                String matchingElements = getText(MLWalletTierUpgrade.objMatchingElementsProductServices(i));
                logger.info("Matching Elements : " + matchingElements + " is displayed");
                ExtentReporter.extentLogger(" ", "Matching Elements : " + matchingElements + " is displayed");
            }
        } else {
            logger.info("No Matching Elements");
        }
        logger.info("TU_TC_18, Tier Upgrade, Auto Suggestions validated for Nature of Work");
        ExtentReporter.extentLoggerPass("TU_TC_18", "TU_TC_18, Tier Upgrade, Auto Suggestions validated for Nature of Work");
        System.out.println("-----------------------------------------------------------");
    }

    public void tierUpgradeConfirmDetailsBtnValidationInAccountDetailsPage_TU_TC_19() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Confirm details button validation in Account details page");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP",2);
        if(verifyElementPresent(MLWalletTierUpgrade.objConfirmDetails,getTextVal(MLWalletTierUpgrade.objConfirmDetails,"Button"))){
            logger.info("TU_TC_19, Tier Upgrade, Confirm details button validated in Account details page");
            ExtentReporter.extentLoggerPass("TU_TC_19", "TU_TC_19, Tier Upgrade, Confirm details button validated in Account details page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradePageNavigation_TU_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Tier upgrade page navigation");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails,getTextVal(MLWalletTierUpgrade.objConfirmDetails,"Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade,getTextVal(MLWalletTierUpgrade.objTierUpgrade,"Page"))){
            logger.info("TU_TC_20, Tier Upgrade page navigation validated");
            ExtentReporter.extentLoggerPass("TU_TC_20", "TU_TC_20, Tier Upgrade page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeFullyVerifiedTierTabUIValidation_TU_TC_21() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Fully verified ter Tab UI Validation");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletHomePage.objIIcon, "i Icon");
        verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objFullyVerifiedTab,getTextVal(MLWalletTierUpgrade.objFullyVerifiedTab,"Tab"));
        waitTime(3000);
        if(verifyElementPresent(MLWalletHomePage.objTier, getTextVal(MLWalletHomePage.objTier, "Header"))) {
            verificationTierPerksPageValidation();
            verifyElementPresent(MLWalletTierUpgrade.objUpgradeTierLevel, getTextVal(MLWalletTierUpgrade.objUpgradeTierLevel, "Button"));
            logger.info("TU_TC_21, Tier Upgrade Fully verified ter Tab UI validated");
            ExtentReporter.extentLoggerPass("TU_TC_21", "TU_TC_21, Tier Upgrade Fully verified ter Tab UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeAccountDetailsPageUIValidation_TU_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Tier upgrade Account details page UI validation");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        if(verifyElementPresent(MLWalletTierUpgrade.objAccountDetails,getTextVal(MLWalletTierUpgrade.objAccountDetails, "Page"))){
            verifyElementPresent(MLWalletTierUpgrade.objPersonalInformation,getTextVal(MLWalletTierUpgrade.objPersonalInformation,"Header"));
            verifyElementPresent(MLWalletTierUpgrade.objPlaceOfBirth,getTextVal(MLWalletTierUpgrade.objPlaceOfBirth,"Place of Birth"));
            verifyElementPresent(MLWalletTierUpgrade.objNationality,getTextVal(MLWalletTierUpgrade.objNationality,"Nationality"));
            verifyElementPresent(MLWalletTierUpgrade.objCivilStatus,getTextVal(MLWalletTierUpgrade.objCivilStatus,"Civil Status"));
            verifyElementPresent(MLWalletTierUpgrade.objGenderAtBirth,getTextVal(MLWalletTierUpgrade.objGenderAtBirth,"Gender at Birth"));
            verifyElementPresent(MLWalletTierUpgrade.objSourceOfIncome,getTextVal(MLWalletTierUpgrade.objSourceOfIncome,"Source of Income"));
            verifyElementPresent(MLWalletTierUpgrade.objCompanyOrEmployerName,getTextVal(MLWalletTierUpgrade.objCompanyOrEmployerName,"Company/Employer Name"));
            verifyElementPresent(MLWalletTierUpgrade.objProductServiceOffered,getTextVal(MLWalletTierUpgrade.objProductServiceOffered,"Product/Service offered"));
            verifyElementPresent(MLWalletTierUpgrade.objWorkAddress,getTextVal(MLWalletTierUpgrade.objWorkAddress,"Work Address"));
            Swipe("UP",2);
            verifyElementPresent(MLWalletTierUpgrade.objPositionAtWork,getTextVal(MLWalletTierUpgrade.objPositionAtWork,"Position at Work"));
            verifyElementPresent(MLWalletTierUpgrade.ObjNatureOfWork,getTextVal(MLWalletTierUpgrade.ObjNatureOfWork,"Nature of Work"));
            logger.info("TU_TC_23, Tier upgrade Account details page UI validated");
            ExtentReporter.extentLoggerPass("TU_TC_23", "TU_TC_23, Tier upgrade Account details page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradePageUIValidation_TU_TC_24() throws Exception {
        ExtentReporter.HeaderChildNode("Tier upgrade page UI validation");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP",2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails,getTextVal(MLWalletTierUpgrade.objConfirmDetails,"Button"));
        if (verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade, getTextVal(MLWalletTierUpgrade.objTierUpgrade, "Page"))) {
            verifyElementPresent(MLWalletTierUpgrade.objSelectAnyValidID,getTextVal(MLWalletTierUpgrade.objSelectAnyValidID,"Header"));
            verifyElementPresent(MLWalletTierUpgrade.objSelectID,getTextVal(MLWalletTierUpgrade.objSelectID,"Input field Header"));
            verifyElementPresent(MLWalletTierUpgrade.objSelectIDSelectionBtn,"Select ID Selection Button");
            logger.info("TU_TC_24, Tier upgrade page UI validated");
            ExtentReporter.extentLoggerPass("TU_TC_24", "TU_TC_24, Tier upgrade page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeBackArrowBtnValidation_TU_TC_25() throws Exception {
        ExtentReporter.HeaderChildNode("Tier upgrade page UI validation");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade, getTextVal(MLWalletTierUpgrade.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objTierUpgradeBackBtn,"Tier upgrade Back Arrow Btn");
        if(verifyElementPresent(MLWalletTierUpgrade.objAccountDetails,getTextVal(MLWalletTierUpgrade.objAccountDetails,"Page"))){
            logger.info("TU_TC_25, After clicking on Back Arrow Btn on Tier upgrade Page, Application Navigates to Account Details Page is validated");
            ExtentReporter.extentLoggerPass("TU_TC_25", "TU_TC_25, After clicking on Back Arrow Btn on Tier upgrade Page, Application Navigates to Account Details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeUploadIDPhotosUIValidationAfterSelectingPHILHEALTH_TU_TC_26() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade, Upload ID photos UI validation After Selecting PHIL HEALTH");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade, getTextVal(MLWalletTierUpgrade.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objSelectIDSelectionBtn,"Select ID Selection Button");
        type(MLWalletTierUpgrade.objSearchFieldInput,"PhilHealth","Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objPhilHealth,getTextVal(MLWalletTierUpgrade.objPhilHealth,"ID"));
        if (verifyElementPresent(MLWalletTierUpgrade.objUploadIDPhotos, getTextVal(MLWalletTierUpgrade.objUploadIDPhotos, "Header"))) {
            verifyElementPresent(MLWalletTierUpgrade.objSelectIDField,getTextVal(MLWalletTierUpgrade.objSelectIDField,"Selected ID Field"));
            verifyElementPresent(MLWalletTierUpgrade.objCardInputField,"Card Input Field");
            verifyElementPresent(MLWalletTierUpgrade.objScanFrontOfID,getTextVal(MLWalletTierUpgrade.objScanFrontOfID,"Button"));
            verifyElementPresent(MLWalletTierUpgrade.objScanBackOfID,getTextVal(MLWalletTierUpgrade.objScanBackOfID,"Button"));
            verifyElementPresent(MLWalletTierUpgrade.objTakeAFaceIdentityPhoto,getTextVal(MLWalletTierUpgrade.objTakeAFaceIdentityPhoto,"Button"));
            logger.info("TU_TC_26, Tier Upgrade, Upload ID photos UI validated After Selecting PHIL HEALTH");
            ExtentReporter.extentLoggerPass("TU_TC_26", "TU_TC_26, Tier Upgrade, Upload ID photos UI validated After Selecting PHIL HEALTH");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeUploadIDPhotosBackArrowBtnValidation_TU_TC_27() throws Exception {
        ExtentReporter.HeaderChildNode("Tier upgrade page UI validation");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade, getTextVal(MLWalletTierUpgrade.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgrade.objSearchFieldInput, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objPhilHealth, getTextVal(MLWalletTierUpgrade.objPhilHealth, "ID"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objTierUpgradeBackBtn, "Tier upgrade Back Arrow Btn");
        if (verifyElementPresent(MLWalletTierUpgrade.objAccountDetails, getTextVal(MLWalletTierUpgrade.objAccountDetails, "Page"))) {
            logger.info("TU_TC_27, After clicking on Back Arrow Btn on Tier upgrade Upload ID Photos Page, Application Navigates to Account Details Page is validated");
            ExtentReporter.extentLoggerPass("TU_TC_27", "TU_TC_27, After clicking on Back Arrow Btn on Tier upgrade Upload ID Photos Page, Application Navigates to Account Details Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeScanFrontOfIDPageUIValidation_TU_TC_28() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Scan front of ID page UI Validation");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade, getTextVal(MLWalletTierUpgrade.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objSelectIDSelectionBtn,"Select ID Selection Button");
        type(MLWalletTierUpgrade.objSearchFieldInput,"PhilHealth","Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objPhilHealth,getTextVal(MLWalletTierUpgrade.objPhilHealth,"ID"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objScanFrontOfID,getTextVal(MLWalletTierUpgrade.objScanFrontOfID,"Button"));
        enableCameraPopup();
        if(verifyElementPresent(MLWalletTierUpgrade.objScanFrontOfID,getTextVal(MLWalletTierUpgrade.objScanFrontOfID,"Page"))){
            verifyElementPresent(MLWalletTierUpgrade.objScanFrontOfIDInfo,getTextVal(MLWalletTierUpgrade.objScanFrontOfIDInfo,"info"));
            verifyElementPresent(MLWalletTierUpgrade.objCaptureScreen,"Capture Screen");
            verifyElementPresent(MLWalletTierUpgrade.objCaptureButton,"Capture Button");
            logger.info("TU_TC_28, Tier Upgrade Scan front of ID page UI validated");
            ExtentReporter.extentLoggerPass("TU_TC_28", "TU_TC_28, Tier Upgrade Scan front of ID page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeScanFrontOfIDPageBackArrowBtnValidation_TU_TC_29() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Scan front of ID page BAck Arrow button Validation");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade, getTextVal(MLWalletTierUpgrade.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgrade.objSearchFieldInput, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objPhilHealth, getTextVal(MLWalletTierUpgrade.objPhilHealth, "ID"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objScanFrontOfID, getTextVal(MLWalletTierUpgrade.objScanFrontOfID, "Button"));
        enableCameraPopup();
        verifyElementPresent(MLWalletTierUpgrade.objScanFrontOfID, getTextVal(MLWalletTierUpgrade.objScanFrontOfID, "Button"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objTierUpgradeBackBtn,"Tier Upgrade Scan Front of ID Back Arrow Button");
        waitTime(3000);
        if(verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade,getTextVal(MLWalletTierUpgrade.objTierUpgrade,"Page"))){
            logger.info("TU_TC_29, Tier Upgrade, After clicking back btn in Tier Upgrade Scan Front of ID app navigates to Tier Upgrade page is validated");
            ExtentReporter.extentLoggerPass("TU_TC_29", "TU_TC_29, Tier Upgrade, After clicking back btn in Tier Upgrade Scan Front of ID app navigates to Tier Upgrade page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeScanBackOfIDPageUIValidation_TU_TC_30() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Scan Back of ID page UI Validation");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade, getTextVal(MLWalletTierUpgrade.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgrade.objSearchFieldInput, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objPhilHealth, getTextVal(MLWalletTierUpgrade.objPhilHealth, "ID"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objScanBackOfID,getTextVal(MLWalletTierUpgrade.objScanBackOfID,"Button"));
        enableCameraPopup();
        if(verifyElementPresent(MLWalletTierUpgrade.objScanBackOfID,getTextVal(MLWalletTierUpgrade.objScanBackOfID,"Page"))){
            verifyElementPresent(MLWalletTierUpgrade.objScanFrontOfIDInfo,getTextVal(MLWalletTierUpgrade.objScanFrontOfIDInfo,"info"));
            verifyElementPresent(MLWalletTierUpgrade.objCaptureScreen,"Capture Screen");
            verifyElementPresent(MLWalletTierUpgrade.objCaptureButton,"Capture Button");
            logger.info("TU_TC_30, Tier Upgrade Scan Back of ID page UI validated");
            ExtentReporter.extentLoggerPass("TU_TC_30", "TU_TC_30, Tier Upgrade Scan Back of ID page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void tierUpgradeScanBackOfIDPageBackArrowBtnValidation_TU_TC_31() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Scan Back of ID page BAck Arrow button Validation");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails, "Button"));
        verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade, getTextVal(MLWalletTierUpgrade.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgrade.objSearchFieldInput, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objPhilHealth, getTextVal(MLWalletTierUpgrade.objPhilHealth, "ID"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objScanBackOfID, getTextVal(MLWalletTierUpgrade.objScanBackOfID, "Button"));
        enableCameraPopup();
        verifyElementPresent(MLWalletTierUpgrade.objScanBackOfID, getTextVal(MLWalletTierUpgrade.objScanBackOfID, "Button"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objTierUpgradeBackBtn,"Tier Upgrade Scan Back of ID Back Arrow Button");
        waitTime(3000);
        if(verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade,getTextVal(MLWalletTierUpgrade.objTierUpgrade,"Page"))){
            logger.info("TU_TC_31, Tier Upgrade, After clicking back btn in Tier Upgrade Scan Back of ID app navigates to Tier Upgrade page is validated");
            ExtentReporter.extentLoggerPass("TU_TC_31", "TU_TC_31, Tier Upgrade, After clicking back btn in Tier Upgrade Scan Back of ID app navigates to Tier Upgrade page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeTakeAFaceIdentityPhotoPageUIValidation_TU_TC_32() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Take a face identity photo page UI Validation");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails, "Button"));
        waitTime(5000);
        verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade, getTextVal(MLWalletTierUpgrade.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgrade.objSearchFieldInput, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objPhilHealth, getTextVal(MLWalletTierUpgrade.objPhilHealth, "ID"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objTakeAFaceIdentityPhoto,getTextVal(MLWalletTierUpgrade.objTakeAFaceIdentityPhoto,"Button"));
        enableCameraPopup();
        if(verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade,getTextVal(MLWalletTierUpgrade.objTierUpgrade,"Page"))){
            verifyElementPresent(MLWalletTierUpgrade.objTakeAFaceIdentityPhotoInfo,getTextVal(MLWalletTierUpgrade.objTakeAFaceIdentityPhotoInfo,"info"));
            verifyElementPresent(MLWalletTierUpgrade.objCaptureScreen,"Capture Screen");
            verifyElementPresent(MLWalletTierUpgrade.objCaptureButton,"Capture Button");
            logger.info("TU_TC_32, Tier Upgrade Take a face identity photo page UI validated");
            ExtentReporter.extentLoggerPass("TU_TC_32", "TU_TC_32, Tier Upgrade Take a face identity photo page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeTakeAFaceIdentityPhotoPageBackArrowBtnValidation_TU_TC_33() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade Take a face identity photo Back arrow button Validation");
        accountDetailsPageNavigation(prop.getproperty("Buyer_Tier"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails, "Button"));
        waitTime(3000);
        verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade, getTextVal(MLWalletTierUpgrade.objTierUpgrade, "Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objSelectIDSelectionBtn, "Select ID Selection Button");
        type(MLWalletTierUpgrade.objSearchFieldInput, "PhilHealth", "Select ID Input field");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objPhilHealth, getTextVal(MLWalletTierUpgrade.objPhilHealth, "ID"));
        waitTime(3000);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objTakeAFaceIdentityPhoto,getTextVal(MLWalletTierUpgrade.objTakeAFaceIdentityPhoto,"Button"));
        enableCameraPopup();
        verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade,getTextVal(MLWalletTierUpgrade.objTierUpgrade,"Page"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objTierUpgradeBackBtn,"Tier Upgrade, Take a face identity photo Back Arrow Btn");
        waitTime(3000);
        if(verifyElementPresent(MLWalletTierUpgrade.objTierUpgrade,getTextVal(MLWalletTierUpgrade.objTierUpgrade,"Page"))) {
            logger.info("TU_TC_33, Tier Upgrade, After clicking back btn in Tier Upgrade Take a face identity photo app navigates to Tier Upgrade page is validated");
            ExtentReporter.extentLoggerPass("TU_TC_33", "TU_TC_33, Tier Upgrade, After clicking back btn in Tier Upgrade Take a face identity photo app navigates to Tier Upgrade page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void tierUpgradeToBranchVerifiedFromBuyerTier_TU_TC_244() throws Exception {
        ExtentReporter.HeaderChildNode("Tier Upgrade to Branch verified tier from Buyer tier");
//		openKPXInChrome(prop.getproperty("KPX_URL"));
        openKPXInChrome("https://accounts.google.com/signin");
//		waitTime(5000);
//		WebElement frame1= DriverManager.getDriver().findElement(By.xpath("//iframe[@title='Sign in with Google Button']"));
//		DriverManager.getDriver().switchTo().frame(frame1);
//		System.out.println("Switched");
//		switchFrame_id("//*[@id='gsi_628747_308167']");
//		verifyElementPresentAndClick(MLWalletKPX.objSignInWithGoogle,"Sign in with Button");
//		type(MLWalletKPX.objEmailInputField,prop.getproperty("Gmail_Password"),"Email Input Field");
//		verifyElementPresentAndClick(MLWalletKPX.objNextBtn,getTextVal(MLWalletKPX.objNextBtn,"Button"));
        //URL launch
//		DriverManager.getDriver().get("https://accounts.google.com/signin");
        //identify email
//		WebElement l = DriverManager.getDriver()
//				.findElement(By.name("identifier"));
//		l.sendKeys("COLLABERAML@GMAIL.COM");
//		WebElement b = DriverManager.getDriver()
//				.findElement(By.className("VfPpkd-LgbsSe"));

//		click(MLWalletKPX.objNextBtn,"Next");
        //identify password
//		WebElement p = DriverManager.getDriver()
//				.findElement(By.name("password"));
//		p.sendKeys("123456");
//		click(MLWalletKPX.objNextBtn,"Next");
        //close browser

        // Find and fill in the email field
        WebElement emailField = DriverManager.getDriver().findElement(By.id("identifierId"));
        emailField.sendKeys("COLLABERAML@GMAIL.COM");

        // Find and click the "Next" button
        WebElement nextButton = DriverManager.getDriver().findElement(By.id("identifierNext"));
        nextButton.click();

        // Wait for password field to appear
        // You might need to use explicit waits here using WebDriverWait

        // Find and fill in the password field
        WebElement passwordField = DriverManager.getDriver().findElement(By.name("password"));
        passwordField.sendKeys("");

        // Find and click the "Next" button for password
//		WebElement passwordNextButton = DriverManager.getDriver().findElement(By.id("passwordNext"));
//		passwordNextButton.click();
    }
    //todo
    // tc 85-108
    public void TierUpgradeSourceOfIncomeFieldValidation_TU_TC_85() throws Exception{
        ExtentReporter.HeaderChildNode("Source of income is required when field is empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objSourceOfIncomeFieldMessage, getTextVal(MLWalletTierUpgrade.objSourceOfIncomeFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objSourceOfIncomeFieldMessage);
            String expected = tierProp.getproperty("SourceIncome_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_85, Tier Upgrade, After keeping the required source of income field as empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_85", "TU_TC_85, Tier Upgrade, After keeping the required source of income field as empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeCompanyFieldValidation_TU_TC_86() throws Exception{
        ExtentReporter.HeaderChildNode("Company/Employer Name is required when field is empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("SALARY"));
        selectProductServiceOffered(tierProp.getproperty("IT"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objWorkAddress, tierProp.getproperty("Address"), "Edit Text");
        selectPositionAtWork(tierProp.getproperty("ENGR"));
        selectNatureOfWork(tierProp.getproperty("ACCOUNTANT_FINANCE_STAFF"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objCompanyEmployerFieldMessage, getTextVal(MLWalletTierUpgrade.objCompanyEmployerFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objCompanyEmployerFieldMessage);
            String expected = tierProp.getproperty("Company_Empty_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_86, Tier Upgrade, After keeping the Company/Employer Name field as empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_86", "TU_TC_86, Tier Upgrade, After keeping the Company/Employer Name field as empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeOrganizationNameFieldValidation_TU_TC_87() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters special characters in Company/Employer name field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("SALARY"));
        type(MLWalletTierUpgrade.objCompanyOrEmployerName, tierProp.getproperty("Invalid_Company_Name"), "Company Name");
        selectProductServiceOffered(tierProp.getproperty("IT"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objWorkAddress, tierProp.getproperty("Address"), "Work Address");
        selectPositionAtWork(tierProp.getproperty("ENGR"));
        selectNatureOfWork(tierProp.getproperty("ACCOUNTANT_FINANCE_STAFF"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objCompanyEmployerFieldMessage, getTextVal(MLWalletTierUpgrade.objCompanyEmployerFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objCompanyEmployerFieldMessage);
            String expected = tierProp.getproperty("Company_Special_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_87, Tier Upgrade, When user enters special characters in Company/Employer name field. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_87", "TU_TC_87, Tier Upgrade, When user enters special characters in Company/Employer name field. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeProductServicesFieldValidation_TU_TC_88() throws Exception{
        ExtentReporter.HeaderChildNode(" Product/services offered is required when field is empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("SALARY"));
        type(MLWalletTierUpgrade.objCompanyOrEmployerName, tierProp.getproperty("Company_Name"), "Company Name");
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objWorkAddress, tierProp.getproperty("Address"), "Work Address");
        selectPositionAtWork(tierProp.getproperty("ENGR"));
        selectNatureOfWork(tierProp.getproperty("ACCOUNTANT_FINANCE_STAFF"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objProductServiceFieldMessage, getTextVal(MLWalletTierUpgrade.objProductServiceFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objProductServiceFieldMessage);
            String expected = tierProp.getproperty("Product_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_88, Tier Upgrade, After keeping the Product/services field  empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_88", "TU_TC_88, Tier Upgrade, " +
                    "After keeping the  Product/services field  empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeEmptyAddressFieldValidation_TU_TC_89() throws Exception{
        ExtentReporter.HeaderChildNode(" Work Address is required when field is empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("SALARY"));
        type(MLWalletTierUpgrade.objCompanyOrEmployerName, tierProp.getproperty("Company_Name"), "Company Name");
        selectProductServiceOffered(tierProp.getproperty("IT"));
        Swipe("UP", 2);
        selectPositionAtWork(tierProp.getproperty("ENGR"));
        selectNatureOfWork(tierProp.getproperty("ACCOUNTANT_FINANCE_STAFF"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objWorkAddressFieldMessage, getTextVal(MLWalletTierUpgrade.objWorkAddressFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objWorkAddressFieldMessage);
            String expected = tierProp.getproperty("WorkAddress_Empty_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_89, Tier Upgrade, After keeping the Work Address field  empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_89", "TU_TC_89, Tier Upgrade, " +
                    "After keeping the  Work Address field  empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeSpecialAddressFieldValidation_TU_TC_90() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters special characters in work address field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("SALARY"));
        type(MLWalletTierUpgrade.objCompanyOrEmployerName, tierProp.getproperty("Company_Name"), "Company Name");
        selectProductServiceOffered(tierProp.getproperty("IT"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objWorkAddress, tierProp.getproperty("Invalid_Address"), "Work Address");
        selectPositionAtWork(tierProp.getproperty("ENGR"));
        selectNatureOfWork(tierProp.getproperty("ACCOUNTANT_FINANCE_STAFF"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objWorkAddressFieldMessage, getTextVal(MLWalletTierUpgrade.objWorkAddressFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objWorkAddressFieldMessage);
            String expected = tierProp.getproperty("WorkAddress_Invalid_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_90, Tier Upgrade, After user enters special characters in work address field. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_90", "TU_TC_90, Tier Upgrade, " +
                    "After user enters special characters in work address field. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradePositionFieldValidation_TU_TC_91() throws Exception{
        ExtentReporter.HeaderChildNode(" When keeping the required Position at work field empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("SALARY"));
        type(MLWalletTierUpgrade.objCompanyOrEmployerName, tierProp.getproperty("Company_Name"), "Company Name");
        selectProductServiceOffered(tierProp.getproperty("IT"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objWorkAddress, tierProp.getproperty("Address"), "Work Address");
        selectNatureOfWork(tierProp.getproperty("ACCOUNTANT_FINANCE_STAFF"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objPositionAtWorkFieldMessage, getTextVal(MLWalletTierUpgrade.objPositionAtWorkFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objPositionAtWorkFieldMessage);
            String expected = tierProp.getproperty("Position_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_91, Tier Upgrade, When keeping the required Position at work field empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_91", "TU_TC_91, Tier Upgrade, " +
                    "When keeping the required Position at work field empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeNatureOfWorkFieldValidation_TU_TC_92() throws Exception{
        ExtentReporter.HeaderChildNode(" When keeping the required Nature of work field empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("SALARY"));
        type(MLWalletTierUpgrade.objCompanyOrEmployerName, tierProp.getproperty("Company_Name"), "Company Name");
        selectProductServiceOffered(tierProp.getproperty("IT"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objWorkAddress, tierProp.getproperty("Address"), "Work Address");
        selectPositionAtWork(tierProp.getproperty("ENGR"));
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objNatureOfWorkFieldMessage, getTextVal(MLWalletTierUpgrade.objNatureOfWorkFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objNatureOfWorkFieldMessage);
            String expected = tierProp.getproperty("Nature_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_92, Tier Upgrade, When keeping the required Nature of work field empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_92", "TU_TC_92, Tier Upgrade, " +
                    "When keeping the required Nature of work field empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradePensionFieldValidation_TU_TC_93() throws Exception{
        ExtentReporter.HeaderChildNode(" When keeping the required Receiving Pension Form field empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("PENSION"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objReceivingPensionFieldMessage, getTextVal(MLWalletTierUpgrade.objReceivingPensionFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objReceivingPensionFieldMessage);
            String expected = tierProp.getproperty("ReceivingPension_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_93, Tier Upgrade, When keeping the required Receiving Pension Form field empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_93", "TU_TC_93, Tier Upgrade, " +
                    "When keeping the required Receiving Pension Form field empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeYearRetiredFieldValidation_TU_TC_94() throws Exception{
        ExtentReporter.HeaderChildNode(" When keeping the required Year Retired field empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("PENSION"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objYearRetiredFieldMessage, getTextVal(MLWalletTierUpgrade.objYearRetiredFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objYearRetiredFieldMessage);
            String expected = tierProp.getproperty("YearRetired_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_94, Tier Upgrade, When keeping the required Year Retired field empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_94", "TU_TC_94, Tier Upgrade, " +
                    "When keeping the required Year Retired field empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradePositionRetirementFieldValidation_TU_TC_95() throws Exception{
        ExtentReporter.HeaderChildNode(" When  keeping the required Position Upon Retirement empty");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("PENSION"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objPositionUponRetirementMessage, getTextVal(MLWalletTierUpgrade.objPositionUponRetirementMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objPositionUponRetirementMessage);
            String expected = tierProp.getproperty("PositionRetirement_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_95, Tier Upgrade, When  keeping the required Position Upon Retirement empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_95", "TU_TC_95, Tier Upgrade, " +
                    "When  keeping the required Position Upon Retirement empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeRemarksFieldValidation_TU_TC_96() throws Exception{
        ExtentReporter.HeaderChildNode(" When keeping the required Remarks field empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("FINANCIAL_ASSISTANCE"));
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objRemarksFieldMessage, getTextVal(MLWalletTierUpgrade.objRemarksFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objRemarksFieldMessage);
            String expected = tierProp.getproperty("Remarks_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_96, Tier Upgrade, When keeping the required Remarks field empty Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_96", "TU_TC_96, Tier Upgrade, " +
                    "When keeping the required Remarks field empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void TierUpgradeErrorMessageUniversityIsRequiredEmptyFieldValidation_TU_TC_97() throws Exception{
        ExtentReporter.HeaderChildNode(" When keeping the required School/University field empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("STUDENT_SCHOLARSHIP"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objSchoolFieldMessage, getTextVal(MLWalletTierUpgrade.objSchoolFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objSchoolFieldMessage);
            String expected = tierProp.getproperty("University_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_97, Tier Upgrade, When keeping the required School/University field empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_97", "TU_TC_97, Tier Upgrade, " +
                    "When keeping the required School/University field empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeErrorMessageUniversityNameSpecialCharactersValidation_TU_TC_98() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters special characters in School/University field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("STUDENT_SCHOLARSHIP"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objUniversityField, tierProp.getproperty("Invalid_University_Name"), "Universty_Name");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objSchoolFieldMessage, getTextVal(MLWalletTierUpgrade.objSchoolFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objSchoolFieldMessage);
            String expected = tierProp.getproperty("University_Special_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_98, Tier Upgrade, When user enters special characters in School/University field. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_98", "TU_TC_98, Tier Upgrade, " +
                    "When user enters special characters in School/University field. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeErrorMessageSchoolAddressIsRequiredEmptyValidation_TU_TC_99() throws Exception{
        ExtentReporter.HeaderChildNode(" When keeping the required School Address field empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("STUDENT_SCHOLARSHIP"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objSchoolAddressFieldMessage, getTextVal(MLWalletTierUpgrade.objSchoolAddressFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objSchoolAddressFieldMessage);
            String expected = tierProp.getproperty("SchoolAddress_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_99, Tier Upgrade, When keeping the required School Address field empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_99", "TU_TC_99, Tier Upgrade, " +
                    "When keeping the required School Address field empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeErrorMessageSchoolAddressSpecialCharactersValidation_TU_TC_100() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters special characters in School Address field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("STUDENT_SCHOLARSHIP"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objSchoolAddressField, tierProp.getproperty("Invalid_School_Address"), "School_Address");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objSchoolAddressFieldMessage, getTextVal(MLWalletTierUpgrade.objSchoolAddressFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objSchoolAddressFieldMessage);
            String expected = tierProp.getproperty("SchoolAddress_Special_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_100, Tier Upgrade, When user enters special characters in School Address field. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_100", "TU_TC_100, Tier Upgrade, " +
                    "When user enters special characters in School Address field. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeErrorMessageProgramTypeIsRequiredEmptyFieldValidation_TU_TC_101() throws Exception{
        ExtentReporter.HeaderChildNode(" When keeping the required Program Type field empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("GOVERNMENT_AID"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objGrantFieldMessage, getTextVal(MLWalletTierUpgrade.objGrantFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objGrantFieldMessage);
            String expected = tierProp.getproperty("ProgramType_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_101, Tier Upgrade, When keeping the required Program Type field empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_101", "TU_TC_101, Tier Upgrade, " +
                    "When keeping the required Program Type field empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeErrorMessageProgramTypeSpecialCharactersValidation_TU_TC_102() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters special characters in Program Type field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("GOVERNMENT_AID"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objProgramTypeField, tierProp.getproperty("Invalid_Program_Type"), "Program_Type");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objGrantFieldMessage, getTextVal(MLWalletTierUpgrade.objGrantFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objGrantFieldMessage);
            String expected = tierProp.getproperty("ProgramType_Special_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_102, Tier Upgrade, When user enters special characters in Program Type field. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_102", "TU_TC_102, Tier Upgrade, " +
                    "When user enters special characters in Program Type field. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeErrorMessageOccupationNameIsRequiredEmptyFieldValidation_TU_TC_103() throws Exception{
        ExtentReporter.HeaderChildNode(" When keeping the required Occupation field empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("OTHER"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objOccupationFieldMessage, getTextVal(MLWalletTierUpgrade.objOccupationFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objOccupationFieldMessage);
            String expected = tierProp.getproperty("Occupation_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_103, Tier Upgrade, When keeping the required Occupation field empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_103", "TU_TC_103, Tier Upgrade, " +
                    "When keeping the required Occupation field empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeErrorMessageOccupationNameSpecialCharactersValidation_TU_TC_104() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters special characters in Occupation field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("OTHER"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objOccupationField, tierProp.getproperty("Invalid_Occupation"), "Occupation");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objOccupationFieldMessage, getTextVal(MLWalletTierUpgrade.objOccupationFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objOccupationFieldMessage);
            String expected = tierProp.getproperty("Occupation_Special_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_104, Tier Upgrade, When user enters special characters in Occupation field. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_104", "TU_TC_104, Tier Upgrade, " +
                    "When user enters special characters in Occupation field. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeErrorMessageSourceOfFundsIsRequiredEmptyFieldValidation_TU_TC_105() throws Exception{
        ExtentReporter.HeaderChildNode(" When keeping the required Source of Funds field empty.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("OTHER"));
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objSourceOfFundsFieldMessage, getTextVal(MLWalletTierUpgrade.objSourceOfFundsFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objSourceOfFundsFieldMessage);
            String expected = tierProp.getproperty("SourceOfFunds_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_105, Tier Upgrade, When keeping the required Source of Funds field empty. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_105", "TU_TC_105, Tier Upgrade, " +
                    "When keeping the required Source of Funds field empty. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeErrorMessageEmployerNameSpecialCharactersValidation_TU_TC_106() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters special characters in Employer Name field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("SALARY"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objCompanyOrEmployerName, tierProp.getproperty("Invalid_Employer_Name"), "Employer_Name");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objCompanyEmployerFieldMessage, getTextVal(MLWalletTierUpgrade.objCompanyEmployerFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objCompanyEmployerFieldMessage);
            String expected = tierProp.getproperty("Employer_Name_Special_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_106, Tier Upgrade, When user enters special characters in Employer Name field. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_106", "TU_TC_106, Tier Upgrade, " +
                    "When user enters special characters in Employer Name field. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeErrorMessageWorkAddressSpecialCharactersValidation_TU_TC_107() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters special characters in Work Address field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("SALARY"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objWorkAddress, tierProp.getproperty("Invalid_Address"), "Address");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objWorkAddressFieldMessage, getTextVal(MLWalletTierUpgrade.objWorkAddressFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objWorkAddressFieldMessage);
            String expected = tierProp.getproperty("WorkAddress_Invalid_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_107, Tier Upgrade, When user enters special characters in Work Address field. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_107", "TU_TC_107, Tier Upgrade, " +
                    "When user enters special characters in Work Address field. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeErrorMessageRetiredFieldSpecialCharactersValidation_TU_TC_108() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters special characters in Year Retired field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("PENSION"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objYearRetiredField, tierProp.getproperty("Invalid_Retired_Year"), "Retired_Year");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objYearRetiredFieldMessage, getTextVal(MLWalletTierUpgrade.objYearRetiredFieldMessage , "Message"))){
            //assert
            String actual = getText(MLWalletTierUpgrade.objYearRetiredFieldMessage);
            String expected = tierProp.getproperty("YearRetired_Err");
            assertionValidation(actual, expected);
            logger.info("TU_TC_108, Tier Upgrade, When user enters special characters in Year Retired field. Error Message Should Pop Up");
            ExtentReporter.extentLoggerPass("TU_TC_108", "TU_TC_108, Tier Upgrade, " +
                    "When user enters special characters in Year Retired field. Error Message Should Pop Up");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeBranchTierVerificationTierNavigation_TU_TC_109() throws Exception{
        ExtentReporter.HeaderChildNode(" When branch tier user navigates to verification tier perk page.");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletHomePage.objHamburgerMenu , "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletHomePage.objViewTier, getTextVal(MLWalletHomePage.objViewTier, "Button"));
        if(verifyElementPresent(MLWalletHomePage.objVerificationTierPerks, getTextVal(MLWalletHomePage.objVerificationTierPerks , "Page"))){
            verifyElementPresent(MLWalletHomePage.objBranchVerified, getTextVal(MLWalletHomePage.objVerificationTierPerks , "Current Tier"));
            logger.info("TU_TC_109, Tier Upgrade, When branch tier user navigates to verification tier perk page. User should be navigated");
            ExtentReporter.extentLoggerPass("TU_TC_109", "TU_TC_109, Tier Upgrade, " +
                    " When branch tier user navigates to verification tier perk page. User should be navigated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeSchoolUniveristyFieldValidation_TU_TC_110() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters alphabets, space, and numbers in School/University Name field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("STUDENT_SCHOLARSHIP"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objUniversityField, tierProp.getproperty("University_Name_v1"), "School/University Name");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        String actual = getText(MLWalletTierUpgrade.objUniversityField);
        String exptected = tierProp.getproperty("University_Name_v1");
        assertionValidation(actual, exptected);
        logger.info("TU_TC_110, Tier Upgrade, When user enters alphabets, space, and numbers in School/University field. User should be able to input");
        ExtentReporter.extentLoggerPass("TU_TC_110", "TU_TC_110, Tier Upgrade, " +
                " When user enters alphabets, space, and numbers in School/University field. User should be able to input");
        System.out.println("-----------------------------------------------------------");
    }
    public void TierUpgradeSchoolAddressFieldValidation_TU_TC_111() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters alphabets, space, and numbers in School/University Address field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("STUDENT_SCHOLARSHIP"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objUniversityField, tierProp.getproperty("University_Name_v1"), "School/University Name");
        type(MLWalletTierUpgrade.objSchoolAddressField, tierProp.getproperty("School_Address_v1"), "School/University Address");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        String actual = getText(MLWalletTierUpgrade.objSchoolAddressField);
        String exptected = tierProp.getproperty("School_Address_v1");
        assertionValidation(actual, exptected);
        logger.info("TU_TC_111, Tier Upgrade, When user enters alphabets, space, and numbers in School/University Address field. User should be able to input");
        ExtentReporter.extentLoggerPass("TU_TC_111", "TU_TC_111, Tier Upgrade, " +
                " When user enters alphabets, space, and numbers in School/University Address field. User should be able to input");
        System.out.println("-----------------------------------------------------------");
    }
    public void TierUpgradeGrantProgramFIeldValidation_TU_TC_112() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters alphabets, space, and numbers in Grant/Program Type field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("GOVERNMENT_AID"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objProgramTypeField, tierProp.getproperty("Program_Type_v1"), "Grant/Program Type Field");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objSelectAnyValidID, getTextVal(MLWalletTierUpgrade.objSelectAnyValidID, "Page"))){
            logger.info("TU_TC_112, Tier Upgrade, When user enters alphabets, space, and numbers in Grant/Program Type field. User should be able to input");
            ExtentReporter.extentLoggerPass("TU_TC_112", "TU_TC_112, Tier Upgrade, " +
                    " When user enters alphabets, space, and numbers in Grant/Program Type field. User should be able to input");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void TierUpgradeOccupationFieldValidation_TU_TC_113() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters alphabets, space, and numbers in Occupation Type field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("OTHER"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objOccupationField, tierProp.getproperty("Occupation_v1"), "Occupation Field");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        String actual = getText(MLWalletTierUpgrade.objOccupationField);
        String exptected = tierProp.getproperty("Occupation_v1");
        assertionValidation(actual, exptected);
        logger.info("TU_TC_113, Tier Upgrade, When user enters alphabets, space, and numbers in Occupation Type field. User should be able to input");
        ExtentReporter.extentLoggerPass("TU_TC_113", "TU_TC_113, Tier Upgrade, " +
                " When user enters alphabets, space, and numbers in Occupation Type field. User should be able to input");
        System.out.println("-----------------------------------------------------------");
    }
    public void TierUpgradeOccupationFieldValidation_TU_TC_114() throws Exception{
        ExtentReporter.HeaderChildNode(" When user enters alphabets, space, and numbers in Source of Fund field.");
        accountDetailsPageNavigation(prop.getproperty("New_Buyer_Tier"));
        selectSourceOfIncome(tierProp.getproperty("OTHER"));
        Swipe("UP", 2);
        type(MLWalletTierUpgrade.objOccupationField, tierProp.getproperty("Occupation_v1"), "Occupation Field");
        type(MLWalletTierUpgrade.objSourceOfFundsField, tierProp.getproperty("SourceFund_v1"), "Source of Fund Field");
        verifyElementPresentAndClick(MLWalletTierUpgrade.objConfirmDetails, getTextVal(MLWalletTierUpgrade.objConfirmDetails , "Button"));
        if(verifyElementPresent(MLWalletTierUpgrade.objSelectAnyValidID, getTextVal(MLWalletTierUpgrade.objSelectAnyValidID, "Page"))){
            logger.info("TU_TC_114, Tier Upgrade, When user enters alphabets, space, and numbers in Source of Fund field. User should be able to input");
            ExtentReporter.extentLoggerPass("TU_TC_114", "TU_TC_114, Tier Upgrade, " +
                    " When user enters alphabets, space, and numbers in Source of Fund field. User should be able to input");
            System.out.println("-----------------------------------------------------------");
        }
    }


}
