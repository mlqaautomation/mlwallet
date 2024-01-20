package com.business.mlwallet;

import com.driverInstance.DriverManager;
import com.mlwallet.pages.MLWalletLogOutPage;
import com.mlwallet.pages.MLWalletLoginPage;
import com.utility.ExtentReporter;

import java.time.Duration;

import static com.utility.Utilities.*;
import static com.utility.Utilities.getTextVal;

public class LogoutClass extends BaseClass{

    public LogoutClass(){
        super();
    }

    public void logOutMinimizeAndRelaunch_Lout_TC_03() throws Exception {
        ExtentReporter.HeaderChildNode("Log Out Minimize and relaunch the application");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        logger.info("Application Minimized for 5 Seconds");
        DriverManager.getAppiumDriver().runAppInBackground(Duration.ofSeconds(5));
        logger.info("Applicaton relaunched after 5 Seconds");
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("User should not be able to logout from the app");
            logger.info("Lout_TC_03, Log Out Minimize and relaunch the application validated");
            ExtentReporter.extentLoggerPass("Lout_TC_03", "Lout_TC_03, Log Out Minimize and relaunch the application validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logOutAppKillAndRelaunch_Lout_TC_04() throws Exception {
        ExtentReporter.HeaderChildNode("Kill Application and Relaunch");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        DriverManager.getAppiumDriver().closeApp();
        logger.info("Killed the Application");
        DriverManager.getAppiumDriver().launchApp();
        logger.info("Relaunch the Application");
        if (verifyElementPresent(MLWalletLoginPage.objLoginBtn, getTextVal(MLWalletLoginPage.objLoginBtn, "page"))) {
            logger.info("Lout_TC_04, After Killing and relaunch the Application, Application got logged off");
            ExtentReporter.extentLoggerPass("Lout_TC_04", "Lout_TC_04, After Killing and relaunch the Application, Application got logged off");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logOUtPopUpValidation_Lout_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("LogOut Popup Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletLogOutPage.objHamburgerMenu, "Hamburger Menu");
        click(MLWalletLogOutPage.objLogoutBtn, getTextVal(MLWalletLogOutPage.objLogoutBtn, "Button"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletLogOutPage.objLogoOutPopupMsg, getTextVal(MLWalletLogOutPage.objLogoOutPopupMsg, "Pop up Message"))) {
            String sLogOutPopupMsg = getText(MLWalletLogOutPage.objLogoOutPopupMsg);
            String sExpectedErrorMsg = "Are you sure you would like to logout?";
            assertionValidation(sLogOutPopupMsg, sExpectedErrorMsg);
            verifyElementPresent(MLWalletLogOutPage.objLogoutBtn, getTextVal(MLWalletLogOutPage.objLogoutBtn, "Button"));
            verifyElementPresent(MLWalletLogOutPage.objCancelBtn, getTextVal(MLWalletLogOutPage.objCancelBtn, "Button"));
            logger.info("Lout_TC_05, LogOut Popup validated");
            ExtentReporter.extentLoggerPass("Lout_TC_05", "Lout_TC_05, LogOut Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logOutPopUpCancelBtnValidation_Lout_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("LogOut PopUp Cancel Button Validation");
        logOUtPopUpValidation_Lout_TC_05();
        click(MLWalletLogOutPage.objCancelBtn, getTextVal(MLWalletLogOutPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletLogOutPage.objHome, getTextVal(MLWalletLogOutPage.objHome, "Button"))) {
            logger.info("Lout_TC_06, Popup disappeared after clicking on Cancel Button, LogOut PopUp Cancel Button validated");
            ExtentReporter.extentLoggerPass("Lout_TC_06", "Lout_TC_06, Popup disappeared after clicking on Cancel Button, LogOut PopUp Cancel Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logOutPopUpLogOutBtnValidation_Lout_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("LogOut PopUp LogOut Btn Validation");
        logOUtPopUpValidation_Lout_TC_05();
        click(MLWalletLogOutPage.objLogoutBtn, getTextVal(MLWalletLogOutPage.objLogoutBtn, "Button"));
        if (verifyElementPresent(MLWalletLogOutPage.objChangeNumber, getTextVal(MLWalletLogOutPage.objChangeNumber, "Page"))) {
            logger.info("Lout_TC_07, Popup disappeared after clicking on Cancel Button, LogOut PopUp Cancel Button validated");
            ExtentReporter.extentLoggerPass("Lout_TC_07", "Lout_TC_07, Popup disappeared after clicking on Cancel Button, LogOut PopUp Cancel Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logoutChangeNumberUIValidation_Lout_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("Log Out Change Number UI page Validation");
        logOUtPopUpValidation_Lout_TC_05();
        click(MLWalletLogOutPage.objLogoutBtn, getTextVal(MLWalletLogOutPage.objLogoutBtn, "Button"));
        if (verifyElementPresent(MLWalletLogOutPage.objChangeNumber, getTextVal(MLWalletLogOutPage.objChangeNumber, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objTroubleSigningIn, getTextVal(MLWalletLoginPage.objTroubleSigningIn, "Link"));
            verifyElementPresent(MLWalletLoginPage.objBranchLocator, getTextVal(MLWalletLoginPage.objBranchLocator, "Link"));
            verifyElementPresent(MLWalletLoginPage.objAppVersionChangeNumber, getTextVal(MLWalletLoginPage.objAppVersionChangeNumber, "App Version"));
            logger.info("Lout_TC_08, Log Out Change Number UI page validated");
            ExtentReporter.extentLoggerPass("Lout_TC_08", "Lout_TC_08, Log Out Change Number UI page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logInWithChangeNumber_Lout_TC_09() throws Exception {
        ExtentReporter.HeaderChildNode("Log In With Change Number");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        click(MLWalletLogOutPage.objChangeNumber, getTextVal(MLWalletLogOutPage.objChangeNumber, "Link"));
        mlWalletLogin(prop.getproperty("Fully_verified"));
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("Lout_TC_09,Application Logged In Successfully with Change Number");
            ExtentReporter.extentLoggerPass("Lout_TC_09", "Lout_TC_09, Application Logged In Successfully with Change Number");
            System.out.println("-----------------------------------------------------------");
        }
    }


}
