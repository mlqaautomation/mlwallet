package com.business.mlwallet;

import com.mlwallet.pages.MLWalletHomePage;
import com.mlwallet.pages.MLWalletLogOutPage;
import com.mlwallet.pages.MLWalletLoginPage;
import com.utility.ExtentReporter;

import static com.utility.Utilities.*;

public class LoginClass extends BaseClass{

    public LoginClass(String Application, String deviceName, String portno) throws InterruptedException {
        super(Application, deviceName, portno);
    }

    public void logInScenarioWithValidMobNumber_Lgn_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("Login Scenarios With Valid Mobile Number");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("Lgn_TC_01, Logged In Successfully and redirected to Dashboard");
            ExtentReporter.extentLoggerPass("Lgn_TC_01", "Lgn_TC_01, Logged In Successfully and redirected to Dashboard");
            System.out.println("-----------------------------------------------------------");

        }
    }

    public void logInScenarioWithInvalidMobNumber_Lgn_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("Login Scenarios With Invalid Mobile Number");
        explicitWaitVisibility(MLWalletLoginPage.objMobileNumberTextField, 10);
//		click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Invalid_MobileNumber"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        if (verifyElementPresent(MLWalletLoginPage.objInvalidMobNumberTxt, getTextVal(MLWalletLoginPage.objInvalidMobNumberTxt, "Error Message"))) {
            logger.info("Lgn_TC_02, Mobile number is Invalid Error Message is Displayed");
            ExtentReporter.extentLoggerPass("Lgn_TC_02", "Lgn_TC_02, Mobile number is Invalid Error Message is Displayed");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void logInScenarioWithValidOTP_Lgn_TC_03() throws Exception {
        ExtentReporter.HeaderChildNode("Login Scenarios With Valid OTP");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("Lgn_TC_03, Logged In Successfully and redirected to Dashboard");
            ExtentReporter.extentLoggerPass("Lgn_TC_03", "Lgn_TC_03, Logged In Successfully and redirected to Dashboard");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void LogInScenarioWithInValidOTP() throws Exception {
        ExtentReporter.HeaderChildNode("Login Scenarios With InValid OTP");
        explicitWaitVisibility(MLWalletLoginPage.objMobileNumberTextField, 10);
//		click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
//		type(MLWalletLoginPage.objOtpTextField, prop.getproperty("InValid_OTP"), "OTP Text Field");
    }


//========================================== Phase 2==========================================//

    public void appLaunch_Lgn_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("App Launch");
        if (verifyElementPresent(MLWalletLoginPage.objLoginBtn, "Login Button")) {
            logger.info("Lgn_TC_05, Application Launched Successfully");
            ExtentReporter.extentLoggerPass("Lgn_TC_05", "Lgn_TC_05, Application Launched Successfully");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginPageUIValidation_Lgn_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("Login Page UI Validation");
        if (verifyElementPresent(MLWalletLoginPage.objLoginBtn, "Login Button")) {
            verifyElementPresent(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
            verifyElementPresent(MLWalletLoginPage.objTroubleSigningIn, getTextVal(MLWalletLoginPage.objTroubleSigningIn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objHaveAnAccountMsg, getTextVal(MLWalletLoginPage.objHaveAnAccountMsg, "Message"));
            verifyElementPresent(MLWalletLoginPage.objCreateOneBtn, getTextVal(MLWalletLoginPage.objCreateOneBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objBranchLocator, getTextVal(MLWalletLoginPage.objBranchLocator, "Button"));
            verifyElementPresent(MLWalletLoginPage.objAppVersion, getTextVal(MLWalletLoginPage.objAppVersion, "App Version"));
            logger.info("Lgn_TC_06, Login Page UI Validated");
            ExtentReporter.extentLoggerPass("Lgn_TC_06", "Lgn_TC_06,  Login Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginTroubleSigningIn_Lgn_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("LogIn Trouble Signing In Validation");
        if (verifyElementPresentAndClick(MLWalletLoginPage.objTroubleSigningIn, getTextVal(MLWalletLoginPage.objTroubleSigningIn, "Button"))) {
            waitTime(6000);
            verifyElementPresent(MLWalletLoginPage.objTroubleSigningPage, getTextVal(MLWalletLoginPage.objTroubleSigningPage, "Page"));
            verifyElementPresent(MLWalletLoginPage.objMLWalletSupport, getTextVal(MLWalletLoginPage.objMLWalletSupport, "Header"));
            logger.info("Lgn_TC_07, Navigated to Trouble Signing In Page");
            ExtentReporter.extentLoggerPass("Lgn_TC_07", "Lgn_TC_07,  Navigated to Trouble Signing In Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginCreateOne_Lgn_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("LogIn Create One");
        if (verifyElementPresentAndClick(MLWalletLoginPage.objCreateOneBtn, getTextVal(MLWalletLoginPage.objCreateOneBtn, "Button"))) {
            verifyElementPresent(MLWalletLoginPage.objRegistrationNumber, getTextVal(MLWalletLoginPage.objRegistrationNumber, "Page"));
            logger.info("Lgn_TC_08, Navigated to Create One Page");
            ExtentReporter.extentLoggerPass("Lgn_TC_08", "Lgn_TC_08, Navigated to Create One Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginBranchLocator_Lgn_TC_09() throws Exception {
        ExtentReporter.HeaderChildNode("LogIn Branch Locator");
        if (verifyElementPresentAndClick(MLWalletLoginPage.objBranchLocator, getTextVal(MLWalletLoginPage.objBranchLocator, "Button"))) {
            waitTime(6000);
            enableLocation_PopUp();
            verifyElementPresent(MLWalletLoginPage.objBranchLocator, getTextVal(MLWalletLoginPage.objBranchLocator, "Page"));
            logger.info("Lgn_TC_09, Navigated to Branch Locator Page");
            ExtentReporter.extentLoggerPass("Lgn_TC_09", "Lgn_TC_09, Navigated to Branch Locator Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginOTPPageUIValidation_Lgn_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("LogIn OTP Page UI Validation");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
//			verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
//			verifyElementPresent(MLWalletLoginPage.objResendCode, getTextVal(MLWalletCashOutPage.objResendCode, "Seconds"));
            logger.info("Lgn_TC_10, LogIn OTP Page UI Validated");
            ExtentReporter.extentLoggerPass("Lgn_TC_10", "Lgn_TC_10, LogIn OTP Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginWithExistingMobileNumber_Lgn_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("Login With Existing Mobile Number");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        verifyElementPresent(MLWalletLogOutPage.objChangeNumber, "Mpin Page");
        enterMLPin();
        waitTime(10000);
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("Lgn_TC_17, Application Logged In Successfully");
            ExtentReporter.extentLoggerPass("Lgn_TC_17", "Lgn_TC_17, Application Logged In Successfully");
            System.out.println("-----------------------------------------------------------");
        } else {
            logger.info("Application not get Logged In Successfully");
        }
    }

    public void loginMPinPageUIValidation_Lgn_TC_18() throws Exception {
        ExtentReporter.HeaderChildNode("Login Mpin Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        if (verifyElementPresent(MLWalletLogOutPage.objChangeNumber, "Mpin Page")) {
            verifyElementPresent(MLWalletLogOutPage.objChangeNumber, getTextVal(MLWalletLogOutPage.objChangeNumber, "button"));
            verifyElementPresent(MLWalletLoginPage.objTroubleSigningIn, getTextVal(MLWalletLoginPage.objTroubleSigningIn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objBranchLocator, getTextVal(MLWalletLoginPage.objBranchLocator, "Button"));
            verifyElementPresent(MLWalletLoginPage.objAppVersionChangeNumber, getTextVal(MLWalletLoginPage.objAppVersionChangeNumber, "App Version"));
            logger.info("Lgn_TC_18, Application Logged In Successfully");
            ExtentReporter.extentLoggerPass("Lgn_TC_18", "Lgn_TC_18, Application Logged In Successfully");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginNetworkInterruptionWhileLoggingInValidation_Lgn_TC_19(String sTier) throws Exception {
        ExtentReporter.HeaderChildNode("Login Network Interruption Validation");
        waitTime(5000);
        type(MLWalletLoginPage.objMobileNumberTextField, sTier, "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(5000);
        setWifiConnectionToONOFF("OFF");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletHomePage.objInternetConnectionPopUp, getTextVal(MLWalletHomePage.objInternetConnectionPopUp, "PopUp"))) {
            internetConnectionError();
            logger.info("Lgn_TC_19, Login Network Interruption Validation");
            ExtentReporter.extentLoggerPass("Lgn_TC_19", "Lgn_TC_19, Login Network Interruption Validation");
            System.out.println("-----------------------------------------------------------");
        }
        setWifiConnectionToONOFF("ON");
    }

    public void loginInternetInterruptionWhileLaunchingApp_Lgn_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Login Internet Interruption While Launching App");
        setWifiConnectionToONOFF("OFF");
        if (verifyElementDisplayed(MLWalletLoginPage.objErrorPopup)) {
            verifyElementPresentAndClick(MLWalletLoginPage.objOkBtn, getTextVal(MLWalletLoginPage.objOkBtn, "Button"));
        }
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        verifyElementPresent(MLWalletLoginPage.objConnectionError, getTextVal(MLWalletLoginPage.objConnectionError, "Header"));
        verifyElementPresent(MLWalletLoginPage.objNoInternetConnectionMsg, getTextVal(MLWalletLoginPage.objNoInternetConnectionMsg, "Msg"));
        logger.info("Lgn_TC_20, Login Internet Interruption While Launching App");
        ExtentReporter.extentLoggerPass("Lgn_TC_20", "Lgn_TC_20, Login Internet Interruption While Launching App");
        System.out.println("-----------------------------------------------------------");
        setWifiConnectionToONOFF("ON");
    }


    public void loginInAppOTPNavigation_Lgn_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("LogIn In App OTP Navigation");
//		click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            logger.info("Lgn_TC_22, LogIn In App OTP Navigation validated");
            ExtentReporter.extentLoggerPass("Lgn_TC_22", "Lgn_TC_22, LogIn In App OTP Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginInAppOTPPageUIValidation_Lgn_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Login InApp OTP Page UI Validation");
//		click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(5000);
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"));
            verifyElementPresent(MLWalletLoginPage.objSeconds, getTextVal(MLWalletLoginPage.objSeconds, "Seconds"));
            verifyElementPresent(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
            verifyElementPresent(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
            logger.info("Lgn_TC_23, LogIn In App OTP Navigation validated");
            ExtentReporter.extentLoggerPass("Lgn_TC_23", "Lgn_TC_23, LogIn In App OTP Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginNewOTPAfterSixtySecondsValidation_Lgn_TC_24() throws Exception {
        ExtentReporter.HeaderChildNode("LogIn New OTP After Sixty Seconds Validation");
//		click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        if (verifyElementPresent(MLWalletLoginPage.objOTP, getTextVal(MLWalletLoginPage.objOTP, "One Time Pin"))) {
            String sGeneratedOTP = getText(MLWalletLoginPage.objOTP);
            waitTime(70000);
            String sNewlyGeneratedOTPAfterSixtySeconds = getText(MLWalletLoginPage.objOTP);
            assertNotEquals(sGeneratedOTP, sNewlyGeneratedOTPAfterSixtySeconds);
            logger.info("Lgn_TC_24, LogIn, After Sixty Seconds New OTP got generated is validated");
            ExtentReporter.extentLoggerPass("Lgn_TC_24", "Lgn_TC_24, LogIn, After Sixty Seconds New OTP got generated is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void loginOTPCancelBtnFunctionality_Lgn_TC_25() throws Exception {
        ExtentReporter.HeaderChildNode("LogIn OTP Cancel Button Functionality");
//		click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objCancelBtn, getTextVal(MLWalletLoginPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletLoginPage.objLoginBtn, getTextVal(MLWalletLoginPage.objLoginBtn, "Button"))) {
            logger.info("Lgn_TC_25, LogIn, After clicking on Cancel in One time pin popup App navigates to login Page validated");
            ExtentReporter.extentLoggerPass("Lgn_TC_25", "Lgn_TC_25, LogIn, After clicking on Cancel in One time pin popup App navigates to login Page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void loginOTPContinueBtnFunctionality_Lgn_TC_26() throws Exception {
        ExtentReporter.HeaderChildNode("LogIn OTP Continue Button Functionality");
//		click(MLWalletLoginPage.objMobileNumberTextField, "Mobile Number Text Field");
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        waitTime(5000);
        verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"));
        verifyElementPresentAndClick(MLWalletLoginPage.objContinueBtn, getTextVal(MLWalletLoginPage.objContinueBtn, "Button"));
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Button"))) {
            logger.info("Lgn_TC_26, LogIn, After clicking on Continue in One time pin popup App navigates to Home Page validated");
            ExtentReporter.extentLoggerPass("Lgn_TC_26", "Lgn_TC_26, LogIn, After clicking on Continue in One time pin popup App navigates to Home Page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void logInScenarioWithInvalidMobNumber_Lgn_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Login Scenarios With Invalid Mobile Number");
        explicitWaitVisibility(MLWalletLoginPage.objMobileNumberTextField, 10);
        type(MLWalletLoginPage.objMobileNumberTextField, prop.getproperty("Invalid_AlphaNumericMobileNumber"), "Mobile Number Text Field");
        click(MLWalletLoginPage.objLoginBtn, "Login Button");
        if (verifyElementPresent(MLWalletLoginPage.objInvalidMobNumberTxt, getTextVal(MLWalletLoginPage.objInvalidMobNumberTxt, "Error Message"))) {
            logger.info("Lgn_TC_15, Mobile number is Invalid Error Message is Displayed");
            ExtentReporter.extentLoggerPass("Lgn_TC_15", "Lgn_TC_15, Mobile number is Invalid Error Message is Displayed");
            System.out.println("-----------------------------------------------------------");
        }
    }

}
