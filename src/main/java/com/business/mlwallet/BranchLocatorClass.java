package com.business.mlwallet;

import com.mlwallet.pages.MLWalletBranchLocator;
import com.mlwallet.pages.MLWalletLoginPage;
import com.utility.ExtentReporter;

import static com.utility.Utilities.*;
import static com.utility.Utilities.getTextVal;

public class BranchLocatorClass extends BaseClass{
    public BranchLocatorClass(){
        super();
    }
    public void branchLocatorNavigationFromMPinPage_BL_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Page Navigation from MPin Page and UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        branchLocatorNavigation();
        if (verifyElementPresent(MLWalletLoginPage.objBranchLocator, getTextVal(MLWalletLoginPage.objBranchLocator, "Page"))) {
            branchLocatorPageValidation();
            logger.info("BL_TC_01, Branch Locator Page Navigation from MPin Page and UI Validated");
            ExtentReporter.extentLoggerPass("BL_TC_01", "BL_TC_01, Branch Locator Page Navigation from MPin Page and UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorNavigationFromLogInPage_BL_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator page Navigation From Login Page and UI validation");
        enableNotif();
        branchLocatorNavigation();
        if (verifyElementPresent(MLWalletLoginPage.objBranchLocator, getTextVal(MLWalletLoginPage.objBranchLocator, "Page"))) {
            branchLocatorPageValidation();
            logger.info("BL_TC_02, Branch Locator Page Navigation from Login Page and UI Validated");
            ExtentReporter.extentLoggerPass("BL_TC_02", "BL_TC_02, Branch Locator Page Navigation from Login Page and UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorHamburgerFunctionality_BL_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Hamburger Button Functionality");
        enableNotif();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocator.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        if (verifyElementPresent(MLWalletBranchLocator.objHome, getTextVal(MLWalletBranchLocator.objHome, "Option"))) {
            verifyElementPresent(MLWalletBranchLocator.objBranches, getTextVal(MLWalletBranchLocator.objBranches, "Option"));
            verifyElementPresent(MLWalletBranchLocator.objProductAndServices, getTextVal(MLWalletBranchLocator.objProductAndServices, "Option"));
            verifyElementPresent(MLWalletBranchLocator.objPromos, getTextVal(MLWalletBranchLocator.objPromos, "Option"));
            verifyElementPresent(MLWalletBranchLocator.objBlog, getTextVal(MLWalletBranchLocator.objBlog, "Option"));
            verifyElementPresent(MLWalletBranchLocator.objNewsLetters, getTextVal(MLWalletBranchLocator.objNewsLetters, "Option"));
            verifyElementPresent(MLWalletBranchLocator.objMLUSBtn, getTextVal(MLWalletBranchLocator.objMLUSBtn, "Option"));
            verifyElementPresent(MLWalletBranchLocator.objFAQ, getTextVal(MLWalletBranchLocator.objFAQ, "Option"));
            verifyElementPresent(MLWalletBranchLocator.objCareers, getTextVal(MLWalletBranchLocator.objCareers, "Option"));
            verifyElementPresent(MLWalletBranchLocator.objLogin, getTextVal(MLWalletBranchLocator.objLogin, "Option"));
            verifyElementPresent(MLWalletBranchLocator.objDownloadApp, getTextVal(MLWalletBranchLocator.objDownloadApp, "Option"));
            logger.info("BL_TC_05, Branch Locator Hamburger Button Functionality Validated");
            ExtentReporter.extentLoggerPass("BL_TC_05", "BL_TC_05, Branch Locator Hamburger Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorBranchesButtonFunctionality_BL_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Branches Button Functionality");
        enableNotif();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocator.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocator.objBranches, getTextVal(MLWalletBranchLocator.objBranches, "Option"));
        if (verifyElementPresent(MLWalletLoginPage.objBranchLocator, getTextVal(MLWalletLoginPage.objBranchLocator, "Page"))) {
            branchLocatorPageValidation();
            logger.info("BL_TC_07, Branch Locator Branches Button Functionality validated");
            ExtentReporter.extentLoggerPass("BL_TC_07", "BL_TC_07, Branch Locator Branches Button Functionality validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorPromosFunctionality_BL_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Promos Button Functionality");
        enableNotif();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocator.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocator.objPromos, getTextVal(MLWalletBranchLocator.objPromos, "Option"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletBranchLocator.objPromos, getTextVal(MLWalletBranchLocator.objPromos, "Page"))) {
            logger.info("BL_TC_08, Branch Locator Promos Button Functionality validated and App Navigated to Promos Page");
            ExtentReporter.extentLoggerPass("BL_TC_08", "BL_TC_08, Branch Locator Promos Button Functionality validated and App Navigated to Promos Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorBlogFunctionality_BL_TC_09() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Blog Functionality");
        enableNotif();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocator.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocator.objBlog, getTextVal(MLWalletBranchLocator.objBlog, "Option"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletBranchLocator.objBlog, getTextVal(MLWalletBranchLocator.objBlog, "Page"))) {
            logger.info("BL_TC_09, Branch Locator Blog Button Functionality validated and App Navigated to Blog Page");
            ExtentReporter.extentLoggerPass("BL_TC_09", "BL_TC_09, Branch Locator Blog Button Functionality validated and App Navigated to Blog Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorNewsLettersFunctionality_BL_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator NewsLetter Functionality");
        enableNotif();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocator.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocator.objNewsLetters, getTextVal(MLWalletBranchLocator.objNewsLetters, "Option"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletBranchLocator.objNewsLetters, getTextVal(MLWalletBranchLocator.objNewsLetters, "Page"))) {
            logger.info("BL_TC_10, Branch Locator NewsLetter Button Functionality validated and App Navigated to NewsLetter Page");
            ExtentReporter.extentLoggerPass("BL_TC_10", "BL_TC_10, Branch Locator NewsLetter Button Functionality validated and App Navigated to NewsLetter Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorFAQFunctionality_BL_TC_11() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator FAQ Functionality");
        enableNotif();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocator.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocator.objFAQ, getTextVal(MLWalletBranchLocator.objFAQ, "Option"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletBranchLocator.objFrequentlyAskedQuestions, getTextVal(MLWalletBranchLocator.objFrequentlyAskedQuestions, "Page"))) {
            logger.info("BL_TC_11, Branch Locator FAQ Button Functionality validated and App Navigated to Frequently Asked Questions Page");
            ExtentReporter.extentLoggerPass("BL_TC_11", "BL_TC_11, Branch Locator FAQ Button Functionality validated and App Navigated to Frequently Asked Questions Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorCareersPageNavigation_BL_TC_13() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Carrers Page Navigation");
        enableNotif();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocator.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocator.objCareers, getTextVal(MLWalletBranchLocator.objCareers, "Option"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletBranchLocator.objCareersPage, getTextVal(MLWalletBranchLocator.objCareersPage, "Page"))) {
            logger.info("BL_TC_13, Branch Locator Carrers Button Functionality validated and App Navigated to Carrers Page");
            ExtentReporter.extentLoggerPass("BL_TC_13", "BL_TC_13, Branch Locator Carrers Button Functionality validated and App Navigated to Carrers Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorShopItemsPageNavigation_BL_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Shop Items Page Navigation");
        enableNotif();
        branchLocatorNavigation();
        homePageNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocator.objShop, getTextVal(MLWalletBranchLocator.objShop, "Option"));
        if (verifyElementPresent(MLWalletBranchLocator.objShopItemsPage, "Shop Items Page")) {
            logger.info("BL_TC_16, Branch Locator Shop Button Functionality validated and App Navigated to Shop Items Web Page Page");
            ExtentReporter.extentLoggerPass("BL_TC_16", "BL_TC_16, Branch Locator Shop Button Functionality validated and App Navigated to Shop Items Web Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorPayBillsPageNavigation_BL_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Pay Bills Page Navigation");
        enableNotif();
        branchLocatorNavigation();
        homePageNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocator.objPayBillsLearnMore, getTextVal(MLWalletBranchLocator.objPayBillsLearnMore, "Option"));
        if (verifyElementPresent(MLWalletBranchLocator.objPayBillsPage, getTextVal(MLWalletBranchLocator.objPayBillsPage, "Page"))) {
            logger.info("BL_TC_17, Branch Locator Pay Bills Functionality validated and App Navigated to Pay Bills Web Page Page");
            ExtentReporter.extentLoggerPass("BL_TC_17", "BL_TC_17, Branch Locator Pay Bills Button Functionality validated and App Navigated to Pay Bills Web Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorBuyELoadPageNavigation_BL_TC_19() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Buy ELoad Page Navigation");
        enableNotif();
        branchLocatorNavigation();
        homePageNavigation();
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletBranchLocator.objBuyELoadLearnMore, getTextVal(MLWalletBranchLocator.objBuyELoadLearnMore, "Buy ELoad Button"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletBranchLocator.objBuyELoad, getTextVal(MLWalletBranchLocator.objBuyELoad, "Page"))) {
            logger.info("BL_TC_19, Branch Locator Buy ELoad Functionality validated and App Navigated to Buy ELoad Web Page Page");
            ExtentReporter.extentLoggerPass("BL_TC_19", "BL_TC_19, Branch Locator Buy ELoad Button Functionality validated and App Navigated to Buy ELoad Web Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorLoansPageNavigation_BL_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Loans Page Navigation");
        enableNotif();
        branchLocatorNavigation();
        homePageNavigation();
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletBranchLocator.objLoans, getTextVal(MLWalletBranchLocator.objLoans, "Loans Button"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletBranchLocator.objLoansPage, getTextVal(MLWalletBranchLocator.objLoansPage, "Page"))) {
            logger.info("BL_TC_22, Branch Locator Loans Functionality validated and App Navigated to Loans Web Page Page");
            ExtentReporter.extentLoggerPass("BL_TC_22", "BL_TC_22, Branch Locator Loans Button Functionality validated and App Navigated to Loans Web Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorInsurancePageNavigation_BL_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Insurance Page Navigation");
        enableNotif();
        branchLocatorNavigation();
        homePageNavigation();
        Swipe("UP", 2);
//		swipeDownUntilElementVisible("Insurance");
        verifyElementPresentAndClick(MLWalletBranchLocator.objInsurance, getTextVal(MLWalletBranchLocator.objInsurance, "Insurance Button"));
        waitTime(6000);
        if (verifyElementPresent(MLWalletBranchLocator.objInsurancePage, "Insurance Page")) {
            logger.info("BL_TC_23, Branch Locator Insurance Functionality validated and App Navigated to Insurance Web Page Page");
            ExtentReporter.extentLoggerPass("BL_TC_23", "BL_TC_23, Branch Locator Insurance Button Functionality validated and App Navigated to Insurance Web Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorLogInFunctionality_BL_TC_14() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator LogIn Functionality");
        enableNotif();
        branchLocatorNavigation();
        verifyElementPresentAndClick(MLWalletBranchLocator.objBranchLocatorHamburgerMenu, "Hamburger Menu Button");
        verifyElementPresentAndClick(MLWalletBranchLocator.objLogin, getTextVal(MLWalletBranchLocator.objLogin, "Option"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletBranchLocator.objToUseMLWalletOnYourComputer, getTextVal(MLWalletBranchLocator.objToUseMLWalletOnYourComputer, "Page"))) {
            logger.info("BL_TC_14, Branch Locator LogIn Button Functionality validated and App Navigated to To use ML Wallet on your computer Page");
            ExtentReporter.extentLoggerPass("BL_TC_14", "BL_TC_14, Branch Locator LogIn Button Functionality validated and App Navigated to To use ML Wallet on your computer Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorSendTransferPageNavigation_BL_TC_18() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Send transfer page Navigation");
        enableNotif();
        branchLocatorNavigation();
        homePageNavigation();
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletBranchLocator.objSendNowBtn, getTextVal(MLWalletBranchLocator.objSendNowBtn, "Button"));
        waitTime(15000);
        if (verifyElementPresent(MLWalletBranchLocator.objToUseMLWalletOnYourComputer, getTextVal(MLWalletBranchLocator.objToUseMLWalletOnYourComputer, "Page"))) {
            for (int i = 1; i <= 3; i++) {
                verifyElementPresent(MLWalletBranchLocator.objToUseMLWalletOnYourComputerSteps(i), getTextVal(MLWalletBranchLocator.objToUseMLWalletOnYourComputerSteps(i), +i + " Step"));
            }
            verifyElementPresent(MLWalletBranchLocator.objDoNotHaveMLWallet, getTextVal(MLWalletBranchLocator.objDoNotHaveMLWallet, "Text"));
            logger.info("BL_TC_18, Branch Locator Send transfer page navigation validated");
            ExtentReporter.extentLoggerPass("BL_TC_18", "BL_TC_18, Branch Locator Send transfer page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorCashInPageNavigation_BL_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Cash In page Navigation");
        enableNotif();
        branchLocatorNavigation();
        homePageNavigation();
        waitTime(5000);
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletBranchLocator.objCashInLearnMore, getTextVal(MLWalletBranchLocator.objCashInLearnMore, "Cash In Button"));
        waitTime(15000);
        if (verifyElementPresent(MLWalletBranchLocator.objToUseMLWalletOnYourComputer, getTextVal(MLWalletBranchLocator.objToUseMLWalletOnYourComputer, "Page"))) {
            for (int i = 1; i <= 3; i++) {
                verifyElementPresent(MLWalletBranchLocator.objToUseMLWalletOnYourComputerSteps(i), getTextVal(MLWalletBranchLocator.objToUseMLWalletOnYourComputerSteps(i), +i + " Step"));
            }
            verifyElementPresent(MLWalletBranchLocator.objDoNotHaveMLWallet, getTextVal(MLWalletBranchLocator.objDoNotHaveMLWallet, "Text"));
            logger.info("BL_TC_20, Branch Locator Cash In page navigation validated");
            ExtentReporter.extentLoggerPass("BL_TC_20", "BL_TC_20, Branch Locator Cash In page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void branchLocatorCashOutPageNavigation_BL_TC_21() throws Exception {
        ExtentReporter.HeaderChildNode("Branch Locator Cash out page Navigation");
        enableNotif();
        branchLocatorNavigation();
        homePageNavigation();
        waitTime(5000);
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletBranchLocator.objCashOutLearnMore, getTextVal(MLWalletBranchLocator.objCashOutLearnMore, "Cash Out Button"));
        waitTime(15000);
        if (verifyElementPresent(MLWalletBranchLocator.objToUseMLWalletOnYourComputer, getTextVal(MLWalletBranchLocator.objToUseMLWalletOnYourComputer, "Page"))) {
            for (int i = 1; i <= 3; i++) {
                verifyElementPresent(MLWalletBranchLocator.objToUseMLWalletOnYourComputerSteps(i), getTextVal(MLWalletBranchLocator.objToUseMLWalletOnYourComputerSteps(i), +i + " Step"));
            }
            verifyElementPresent(MLWalletBranchLocator.objDoNotHaveMLWallet, getTextVal(MLWalletBranchLocator.objDoNotHaveMLWallet, "Text"));
            logger.info("BL_TC_21, Branch Locator Cash out page navigation validated");
            ExtentReporter.extentLoggerPass("BL_TC_21", "BL_TC_21, Branch Locator Cash out page navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

}
