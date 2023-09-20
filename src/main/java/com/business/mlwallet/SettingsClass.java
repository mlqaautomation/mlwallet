package com.business.mlwallet;

import com.mlwallet.pages.MLWalletLoginPage;
import com.mlwallet.pages.MLWalletSettingsPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.utility.Utilities.*;

public class SettingsClass extends BaseClass{

    public SettingsClass(String Application, String deviceName, String portno)throws InterruptedException{
        super(Application, deviceName, portno);
    }
    public void settingsAccountDetailsValidation_SS_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Account Details validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        click(MLWalletSettingsPage.objAccountDetails, "Account Details");
        waitTime(3000);
        verifyElementPresent(MLWalletSettingsPage.objAccountDetails, getTextVal(MLWalletSettingsPage.objAccountDetails, "Name"));
        verifyElementPresent(MLWalletSettingsPage.objNameOfAccountHolder, getTextVal(MLWalletSettingsPage.objNameOfAccountHolder, "Name"));
        verifyElementPresent(MLWalletSettingsPage.objMailAddressOfAccountHolder, getTextVal(MLWalletSettingsPage.objMailAddressOfAccountHolder, "Mail Address"));
        verifyElementPresent(MLWalletSettingsPage.objMobileNoOfAccountHolder, getTextVal(MLWalletSettingsPage.objMobileNoOfAccountHolder, "Mobile Number"));
        logger.info("SS_TC_01, Account Details validated");
        ExtentReporter.extentLoggerPass("SS_TC_01", "SS_TC_01, Account Details validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void settingsInvalidMLPinValidation_SS_TC_03() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Invalid ML Pin Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        click(MLWalletSettingsPage.objChangeMLPin, "Change ML Pin");
        verifyElementPresent(MLWalletSettingsPage.objChangeMLPin, "Change ML Pin");
        handleMpin(prop.getproperty("wrongMpin"));
        if (verifyElementPresent(MLWalletSettingsPage.objInvalaidMpinPopUp, getTextVal(MLWalletSettingsPage.objInvalaidMpinPopUp, "Error Popup Message"))) {
            String sInvalidMPinPopUp = getText(MLWalletSettingsPage.objInvalaidMpinPopUp);
            String sExceptedErrorPOpUp = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sInvalidMPinPopUp, sExceptedErrorPOpUp);
            logger.info("SS_TC_03, Invalid ML PIN validated");
            ExtentReporter.extentLoggerPass("SS_TC_03", "SS_TC_03, Invalid ML PIN validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void settingsValidMLPinValidation_SS_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Valid ML Pin Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        click(MLWalletSettingsPage.objChangeMLPin, "Change ML Pin");
        verifyElementPresent(MLWalletSettingsPage.objChangeMLPin, "Change ML Pin");
        waitTime(2000);
        handleMpin(prop.getproperty("mPin"));
        waitTime(2000);
        if (verifyElementPresent(MLWalletSettingsPage.objEnterNewMMLpinText,
                getTextVal(MLWalletSettingsPage.objEnterNewMMLpinText, "Page"))) {
            waitTime(2000);
            handleMpin(prop.getproperty("newMpin"));
            waitTime(2000);
            handleMpin(prop.getproperty("newMpin"));
            if (verifyElementPresent(MLWalletSettingsPage.objMLPinChangedPopup,
                    getTextVal(MLWalletSettingsPage.objMLPinChangedPopup, "Success Popup"))) {
                String sActualSuccessPopUp = getText(MLWalletSettingsPage.objMLPinChangedPopup);
                String sExpectedSuccessPopUp = "ML Pin Successfully Changed";
                assertionValidation(sActualSuccessPopUp, sExpectedSuccessPopUp);
                logger.info("SS_TC_02 To validate ML PIN validated");
                ExtentReporter.extentLoggerPass("SS_TC_02", "'SS_TC_02' To validate ML PIN validated");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }


    public void settingsBiometricsLogin_SS_TC_04() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Biometrics Login");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objBiometricsLogin, getTextVal(MLWalletSettingsPage.objBiometricsLogin, "Option"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objBiometricsSwitch, "Biometrics Switch");
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletSettingsPage.objActivateBiometricsLogin, getTextVal(MLWalletSettingsPage.objActivateBiometricsLogin, "Header"))) {
            String sActualActiveMsg = getText(MLWalletSettingsPage.objActivateBiometricsLogin);
            String sExceptedActiveMsg = "Activate Biometrics Login";
            assertionValidation(sActualActiveMsg, sExceptedActiveMsg);
            logger.info("SS_TC_04, Settings Biometrics Login Validated");
            ExtentReporter.extentLoggerPass("SS_TC_04", "'SS_TC_04' Settings Biometrics Login Validated");
            System.out.println("-----------------------------------------------------------");
        }


    }


    public void settingAccRecovery_SS_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("Invalid ML Pin Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        click(MLWalletSettingsPage.objAccountRecovery, "Account Recovery");
        verifyElementPresent(MLWalletSettingsPage.objMlWalletSupportPage,
                getTextVal(MLWalletSettingsPage.objMlWalletSupportPage, "Page"));
        click(MLWalletSettingsPage.objFullNameField, "First Name Field");
        type(MLWalletSettingsPage.objFullNameField, prop.getproperty("firstName"), "First Name Field");
        hideKeyboard();
        Swipe("UP", 1);
        click(MLWalletSettingsPage.objRegisteredEmail, "Registered Email Field");
        type(MLWalletSettingsPage.objRegisteredEmail, prop.getproperty("eMailAddress"),
                "Registered Email Field");
        hideKeyboard();
        Swipe("UP", 1);
        click(MLWalletSettingsPage.objMobileNumber, "Mobile Number Field");
        type(MLWalletSettingsPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Mobile Number Field");
        hideKeyboard();
        click(MLWalletSettingsPage.objNatureOfReqRadioBtn,
                getTextVal(MLWalletSettingsPage.objNatureOfReqRadioBtn, "Text"));
        scrollToVertical("Next");
        click(MLWalletSettingsPage.objNextBtn, "Next Button");
        verifyElementPresent(MLWalletSettingsPage.objStolenPage,
                getTextVal(MLWalletSettingsPage.objStolenPage, "Page"));
        click(MLWalletSettingsPage.objYourAnswer, "Lost/Stolen Mobile Number Field");
        type(MLWalletSettingsPage.objYourAnswer, prop.getproperty("Branch_Verified"),
                "Lost/Stolen Mobile Number Field");
        hideKeyboard();
        click(MLWalletSettingsPage.objNewMobNo, "New Mobile Number Field");
        type(MLWalletSettingsPage.objNewMobNo, prop.getproperty("newMobileNumber"), "New Mobile Number Field");
        hideKeyboard();
        click(MLWalletSettingsPage.objFacebookMessangerName, "Facebook Messenger Name Field");
        type(MLWalletSettingsPage.objFacebookMessangerName, prop.getproperty("messangerName"),
                "Facebook Messenger Name Field");
        hideKeyboard();
        scrollToVertical("Submit");
        click(MLWalletSettingsPage.objSumbitBtn, "Submit Button");
        verifyElementPresent(MLWalletSettingsPage.objReviewPage, "Review Page");
        String actualText = "Please allow us some time to review the details of your request. A customer service representative will contact you for updates and/or to get additional information.";
        String reviewExpectedText = getText(MLWalletSettingsPage.objReviewPage);
        assertionValidation(actualText, reviewExpectedText);
        logger.info("'SS_TC_05', To verify account recovery validated");
        ExtentReporter.extentLoggerPass("Account Recovery", "'SS_TC_05', To verify account recovery validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void settingsBackBtnValidation_SS_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Back Button Button Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objSettingsBackBtn, "Settings Back Button");
        if (verifyElementPresent(MLWalletLoginPage.objAvailableBalance, getTextVal(MLWalletLoginPage.objAvailableBalance, "Text"))) {
            logger.info("SS_TC_07, Settings Back Button Button validated");
            ExtentReporter.extentLoggerPass("SS_TC_07", "SS_TC_07, Settings Back Button Button validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountPopUpUIValidation_SS_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account PopUp UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccount, getTextVal(MLWalletSettingsPage.objDeleteAccount, "Option"));
        if (verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUp, getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUp, "Confirmation Popup"))) {
            String sActualConfirmationPopupMsg = getText(MLWalletSettingsPage.objDeleteConfirmationPopUp);
            String sExpectedConfirmationPopupMsg = "Are you sure you would like to delete your account?";
            assertionValidation(sActualConfirmationPopupMsg, sExpectedConfirmationPopupMsg);
            verifyElementPresent(MLWalletSettingsPage.objProceedBtn, getTextVal(MLWalletSettingsPage.objProceedBtn, "Button"));
            verifyElementPresent(MLWalletSettingsPage.objCancelBtn, getTextVal(MLWalletSettingsPage.objCancelBtn, "Button"));
            logger.info("SS_TC_10, Settings, Settings Delete Account PopUp UI validated");
            ExtentReporter.extentLoggerPass("SS_TC_10", "SS_TC_10, Settings Delete Account PopUp UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsChangeMLPinNavigation_SS_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Change ML Pin Navigation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objChangeMLPin, getTextVal(MLWalletSettingsPage.objChangeMLPin, "option"));
        Thread.sleep(5000);
        if (verifyElementPresent(MLWalletSettingsPage.objChangeMLPin, getTextVal(MLWalletSettingsPage.objChangeMLPin, "Page"))) {
            verifyElementPresent(MLWalletSettingsPage.objEnterCurrentMLPin, getTextVal(MLWalletSettingsPage.objEnterCurrentMLPin, "Header"));
            verifyElementPresent(MLWalletSettingsPage.objKeyword, "Keyword to Enter MLPin");
            verifyElementPresent(MLWalletSettingsPage.objMLPinEditField, "ML Pin Edit Field");
            logger.info("SS_TC_12, Settings Change ML Pin Navigation validated");
            ExtentReporter.extentLoggerPass("SS_TC_12", "SS_TC_12, Settings Change ML Pin Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsChangeMlPinBackBtnValidation_SS_TC_13() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Change ML Pin Back Button Validation");
        settingsChangeMLPinNavigation_SS_TC_12();
        verifyElementPresentAndClick(MLWalletSettingsPage.objChangeMLPinBackBtn, "Back Button");
        if (verifyElementPresent(MLWalletSettingsPage.objSettings, getTextVal(MLWalletSettingsPage.objSettings, "Page"))) {
            logger.info("SS_TC_13, Settings, After clicking on  Change ML Pin Back Button App Navigated to Settings Page validated");
            ExtentReporter.extentLoggerPass("SS_TC_13", "SS_TC_13, Settings, After clicking on  Change ML Pin Back Button App Navigated to Settings Page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsPageUIValidation_SS_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        if (verifyElementPresent(MLWalletSettingsPage.objSettings, getTextVal(MLWalletSettingsPage.objSettings, "Page"))) {
            verifyElementPresent(MLWalletSettingsPage.objAccountDetails, getTextVal(MLWalletSettingsPage.objAccountDetails, "Option"));
            verifyElementPresent(MLWalletSettingsPage.objChangeMLPin, getTextVal(MLWalletSettingsPage.objChangeMLPin, "Option"));
            verifyElementPresent(MLWalletSettingsPage.objBiometricsLogin, getTextVal(MLWalletSettingsPage.objBiometricsLogin, "Option"));
            verifyElementPresent(MLWalletSettingsPage.objAccountRecovery, getTextVal(MLWalletSettingsPage.objAccountRecovery, "Option"));
            verifyElementPresent(MLWalletSettingsPage.objNotification, getTextVal(MLWalletSettingsPage.objNotification, "Option"));
            verifyElementPresent(MLWalletSettingsPage.objDeleteAccount, getTextVal(MLWalletSettingsPage.objDeleteAccount, "Option"));
            logger.info("SS_TC_06, Settings Page UI validated");
            ExtentReporter.extentLoggerPass("SS_TC_06", "SS_TC_06, Settings Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsAccountDetailsNavigation_SS_TC_14() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Account Details Navigation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objAccountDetails, getTextVal(MLWalletSettingsPage.objAccountDetails, "Option"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletSettingsPage.objAccountDetails, getTextVal(MLWalletSettingsPage.objAccountDetails, "Page"))) {
            logger.info("SS_TC_14, Settings Account Details Navigation validated");
            ExtentReporter.extentLoggerPass("SS_TC_14", "SS_TC_14, Settings Account Details Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsAccountDetailsBackBtnValidation_SS_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Account details Back Button Validation");
        settingsAccountDetailsNavigation_SS_TC_14();
        verifyElementPresentAndClick(MLWalletSettingsPage.objAccountDetailsBackBtn, "Back Button");
        if (verifyElementPresent(MLWalletSettingsPage.objSettings, getTextVal(MLWalletSettingsPage.objSettings, "Page"))) {
            logger.info("SS_TC_15, Settings Account Details Back Button Navigation validated");
            ExtentReporter.extentLoggerPass("SS_TC_15", "SS_TC_15, Settings Account Details Back Button Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingChangeMLPinUIValidation_SS_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Change ML Pin UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objChangeMLPin, getTextVal(MLWalletSettingsPage.objChangeMLPin, "option"));
        Thread.sleep(5000);
        if (verifyElementPresent(MLWalletSettingsPage.objChangeMLPin, getTextVal(MLWalletSettingsPage.objChangeMLPin, "Page"))) {
            verifyElementPresent(MLWalletSettingsPage.objEnterCurrentMLPin, getTextVal(MLWalletSettingsPage.objEnterCurrentMLPin, "Header"));
            verifyElementPresent(MLWalletSettingsPage.objKeyword, "Keyword to Enter MLPin");
            verifyElementPresent(MLWalletSettingsPage.objMLPinEditField, "ML Pin Edit Field");
            logger.info("SS_TC_16, Settings Change ML Pin UI validated");
            ExtentReporter.extentLoggerPass("SS_TC_16", "SS_TC_16, Settings Change ML Pin UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsAccountRecoveryUIValidation_SS_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Account Recovery UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objAccountRecovery, getTextVal(MLWalletSettingsPage.objAccountRecovery, "Option"));
        waitTime(6000);
        if (verifyElementPresent(MLWalletSettingsPage.objTroubleSigningIn, getTextVal(MLWalletSettingsPage.objTroubleSigningIn, "Page"))) {
            verifyElementPresent(MLWalletSettingsPage.objMLWalletSupport, getTextVal(MLWalletSettingsPage.objMLWalletSupport, "Header"));
            verifyElementPresent(MLWalletSettingsPage.objFullNameField, "First Name Field");
            verifyElementPresent(MLWalletSettingsPage.objRegisteredEmail, "Registered Email Field");
            Swipe("UP", 1);
            verifyElementPresent(MLWalletSettingsPage.objMobileNumber, "Mobile Number Field");
            Swipe("UP", 2);
            if (verifyElementDisplayed(MLWalletSettingsPage.objNatureOfRequests)) {
                List<WebElement> values = findElements(MLWalletSettingsPage.objNatureOfRequests);
                for (int i = 0; i < values.size(); i++) {
                    String savedRecipientName = values.get(i).getText();
                    logger.info("Nature of Your Request : " + savedRecipientName + " is displayed");
                    ExtentReporter.extentLogger(" ", "Nature of Your Request : " + savedRecipientName + " is displayed");
                }
            }
            logger.info("SS_TC_17, Settings Account Recovery UI validated");
            ExtentReporter.extentLoggerPass("SS_TC_17", "SS_TC_17, Settings Account Recovery UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountCancelBtnValidation_SS_TC_18() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account Cancel Button Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccount, getTextVal(MLWalletSettingsPage.objDeleteAccount, "Option"));
        verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUp, getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUp, "Delete Confirmation Popup"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objCancelBtn, getTextVal(MLWalletSettingsPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletSettingsPage.objSettings, getTextVal(MLWalletSettingsPage.objSettings, "Page"))) {
            logger.info("SS_TC_18, Settings, After clicking on Cancel button on Delete Confirmation Popup App should navigate to Settings Page is validated");
            ExtentReporter.extentLoggerPass("SS_TC_18", "SS_TC_18, Settings, After clicking on Cancel button on Delete Confirmation Popup App should navigate to Settings Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsBiometricsLoginUIValidation_SS_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Biometrics Login UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objBiometricsLogin, getTextVal(MLWalletSettingsPage.objBiometricsLogin, "Option"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletSettingsPage.objBiometricsLogin, getTextVal(MLWalletSettingsPage.objBiometricsLogin, "Page"))) {
            verifyElementPresent(MLWalletSettingsPage.objBiometrics, getTextVal(MLWalletSettingsPage.objBiometrics, "Header"));
            verifyElementPresent(MLWalletSettingsPage.objBiometricsSwitch, "Biometrics Switch");
            verifyElementPresent(MLWalletSettingsPage.objActivateBiometricsLogin, getTextVal(MLWalletSettingsPage.objActivateBiometricsLogin, "Header"));
            logger.info("SS_TC_20, Settings, Settings Biometrics Login UI validated");
            ExtentReporter.extentLoggerPass("SS_TC_20", "SS_TC_20, Settings Biometrics Login UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsAccountRecoveryNavigation_SS_TC_21() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Account Recovery Navigation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objAccountRecovery, getTextVal(MLWalletSettingsPage.objAccountRecovery, "Option"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletSettingsPage.objTroubleSigningIn, getTextVal(MLWalletSettingsPage.objTroubleSigningIn, "Page"))) {
            logger.info("SS_TC_21, Settings, After clicking on Account recovery, application navigated to Trouble Signing in page is validated");
            ExtentReporter.extentLoggerPass("SS_TC_21", "SS_TC_21, After clicking on Account recovery, application navigated to Trouble Signing in page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsTroubleSigningInBackBtnValidation_SS_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Trouble Signing In Bak Btn Validation");
        settingsAccountRecoveryNavigation_SS_TC_21();
        verifyElementPresentAndClick(MLWalletSettingsPage.objTroubleSigningInBackBtn, "Trouble Signing In Page Back Button");
        if (verifyElementPresent(MLWalletSettingsPage.objSettings, getTextVal(MLWalletSettingsPage.objSettings, "Page"))) {
            logger.info("SS_TC_22, Settings Account Details Back Button Navigation validated");
            ExtentReporter.extentLoggerPass("SS_TC_22", "SS_TC_22, Settings Account Details Back Button Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsBiometricsLoginNavigation_SS_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Biometrics Login Navigation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objBiometricsLogin, getTextVal(MLWalletSettingsPage.objBiometricsLogin, "Option"));
        waitTime(3000);
        if (verifyElementPresent(MLWalletSettingsPage.objBiometricsLogin, getTextVal(MLWalletSettingsPage.objBiometricsLogin, "Page"))) {
            logger.info("SS_TC_23, Settings, After clicking on Account recovery, application navigated to Biometrics Login page is validated");
            ExtentReporter.extentLoggerPass("SS_TC_23", "SS_TC_23, After clicking on Account recovery, application navigated to Biometrics Login page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsBiometricsLoginBackBtnValidation_SS_TC_24() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Biometrics Login Back Button validation");
        settingsBiometricsLoginNavigation_SS_TC_23();
        verifyElementPresentAndClick(MLWalletSettingsPage.objBiometricsLoginBackBtn, "Biometrics Login Page Back Button");
        if (verifyElementPresent(MLWalletSettingsPage.objSettings, getTextVal(MLWalletSettingsPage.objSettings, "Page"))) {
            logger.info("SS_TC_24, Settings Biometrics Login Back Button validated");
            ExtentReporter.extentLoggerPass("SS_TC_24", "SS_TC_24, Settings Biometrics Login Back Button validated validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void settingsDeleteAccountPageUIValidation_SS_TC_25() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccount, getTextVal(MLWalletSettingsPage.objDeleteAccount, "Option"));
        verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUp, getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUp, "Confirmation Popup"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objProceedBtn, getTextVal(MLWalletSettingsPage.objProceedBtn, "Button"));
        if (verifyElementPresent(MLWalletSettingsPage.objDeleteAccount, getTextVal(MLWalletSettingsPage.objDeleteAccount, "Page"))) {
            verifyElementPresent(MLWalletSettingsPage.objDeleteAccountBackBtn, "Back Arrow Button");
            verifyElementPresent(MLWalletSettingsPage.objWarningHeader, getTextVal(MLWalletSettingsPage.objWarningHeader, "Header"));
            for (int i = 1; i < 10; i++) {
                if (i % 2 == 0) {
                    verifyElementPresent(MLWalletSettingsPage.objWarningMsg(i), getTextVal(MLWalletSettingsPage.objWarningMsg(i), "Warning Message"));
                }
            }
            verifyElementPresent(MLWalletSettingsPage.objDeleteAccount, getTextVal(MLWalletSettingsPage.objDeleteAccount, "Button"));
            verifyElementPresent(MLWalletSettingsPage.objIWantToStay, getTextVal(MLWalletSettingsPage.objIWantToStay, "Button"));
            logger.info("SS_TC_25, Settings Delete Account Page UI validated");
            ExtentReporter.extentLoggerPass("SS_TC_25", "SS_TC_25, Settings Delete Account Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountIWantToStayButtonFunctionality_SS_TC_26() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account I Want To Stay Button Functionality");
        settingsDeleteAccountPageUIValidation_SS_TC_25();
        click(MLWalletSettingsPage.objIWantToStay, getTextVal(MLWalletSettingsPage.objIWantToStay, "Button"));
        if (verifyElementPresent(MLWalletSettingsPage.objSettings, getTextVal(MLWalletSettingsPage.objSettings, "Page"))) {
            logger.info("SS_TC_26, Settings Delete Account, After clicking on I Want To Stay Button, App navigates to Settings Page");
            ExtentReporter.extentLoggerPass("SS_TC_26", "SS_TC_26, Settings Delete Account, After clicking on I Want To Stay Button, App navigates to Settings Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountPageBackButtonValidation_SS_TC_27() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account Page Back Button Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        navigateToProfile();
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccount, getTextVal(MLWalletSettingsPage.objDeleteAccount, "Option"));
        verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUp, getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUp, "Confirmation Popup"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objProceedBtn, getTextVal(MLWalletSettingsPage.objProceedBtn, "Button"));
        verifyElementPresent(MLWalletSettingsPage.objDeleteAccount, getTextVal(MLWalletSettingsPage.objDeleteAccount, "Page"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccountBackBtn, "Back Arrow Button");
        if (verifyElementPresent(MLWalletSettingsPage.objSettings, getTextVal(MLWalletSettingsPage.objSettings, "Page"))) {
            logger.info("SS_TC_27, Settings Delete Account, After clicking on Back-Arrow Button, App navigates to Settings Page");
            ExtentReporter.extentLoggerPass("SS_TC_27", "SS_TC_27, Settings Delete Account, After clicking on Back-Arrow Button, App navigates to Settings Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountButtonFunctionality_SS_TC_28() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account Button Functionality");
        settingsDeleteAccountPageUIValidation_SS_TC_25();
        click(MLWalletSettingsPage.objDeleteAccountBtn, getTextVal(MLWalletSettingsPage.objDeleteAccountBtn, "Button"));
        if (verifyElementPresent(MLWalletSettingsPage.objDeleteConfirmationPopUp, getTextVal(MLWalletSettingsPage.objDeleteConfirmationPopUp, "Page"))) {
            verifyElementPresent(MLWalletSettingsPage.objProceedBtn, getTextVal(MLWalletSettingsPage.objProceedBtn, "Button"));
            verifyElementPresent(MLWalletSettingsPage.objCancelBtn, getTextVal(MLWalletSettingsPage.objCancelBtn, "Button"));
            logger.info("SS_TC_28, Settings Delete Account Button Functionality validated");
            ExtentReporter.extentLoggerPass("SS_TC_28", "SS_TC_28, Settings Delete Account Button Functionality validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void settingsDeleteAccountConfirmationPopupCancelBtnFunctionality_SS_TC_29() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account Confirmation Popup Cancel Button Functionality");
        settingsDeleteAccountButtonFunctionality_SS_TC_28();
        click(MLWalletSettingsPage.objCancelBtn, getTextVal(MLWalletSettingsPage.objCancelBtn, "Button"));
        if (verifyElementPresent(MLWalletSettingsPage.objDeleteAccount, getTextVal(MLWalletSettingsPage.objDeleteAccount, "Page"))) {
            logger.info("SS_TC_29, Settings Delete Account Confirmation Popup, After clicking on Cancel button App stays in Delete Account Page");
            ExtentReporter.extentLoggerPass("SS_TC_29", "SS_TC_29, Settings Delete Account Confirmation Popup, After clicking on Cancel button App stays in Delete Account Page");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void settingsDeleteAccountConfirmationPopupProceedBtnFunctionality_SS_TC_30() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account Confirmation Popup Proceed Button Functionality");
        settingsDeleteAccountButtonFunctionality_SS_TC_28();
        click(MLWalletSettingsPage.objProceedBtn, getTextVal(MLWalletSettingsPage.objProceedBtn, "Button"));
        if (verifyElementPresent(MLWalletSettingsPage.objDeleteAccountMLPin, getTextVal(MLWalletSettingsPage.objDeleteAccountMLPin, "Page"))) {
            logger.info("SS_TC_30, Settings Delete Account Confirmation Popup, After clicking on Proceed button App navigates to Delete Account ML pin Page");
            ExtentReporter.extentLoggerPass("SS_TC_30", "SS_TC_30, Settings Delete Account Confirmation Popup, After clicking on Proceed button App navigates to Delete Account ML pin Page");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountMLPinPageUIValidation_SS_TC_31() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account ML Pin Page UI Validation");
        settingsDeleteAccountButtonFunctionality_SS_TC_28();
        click(MLWalletSettingsPage.objProceedBtn, getTextVal(MLWalletSettingsPage.objProceedBtn, "Button"));
        if (verifyElementPresent(MLWalletSettingsPage.objDeleteAccountMLPin, getTextVal(MLWalletSettingsPage.objDeleteAccountMLPin, "Page"))) {
            verifyElementPresent(MLWalletSettingsPage.objEnterCurrentMLPinHeader, getTextVal(MLWalletSettingsPage.objEnterCurrentMLPinHeader, "Header"));
            verifyElementPresent(MLWalletSettingsPage.objMLInputField, "ML Pin Input Field");
            logger.info("SS_TC_31, Settings Delete Account ML Pin Page UI Validated");
            ExtentReporter.extentLoggerPass("SS_TC_31", "SS_TC_31, Settings Delete Account ML Pin Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountMLPinPageBackArrowBtnFunctionality_SS_TC_32() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account ML Pin Page Back Arrow Button Functionality");
        settingsDeleteAccountButtonFunctionality_SS_TC_28();
        click(MLWalletSettingsPage.objProceedBtn, getTextVal(MLWalletSettingsPage.objProceedBtn, "Button"));
        verifyElementPresent(MLWalletSettingsPage.objDeleteAccountMLPin, getTextVal(MLWalletSettingsPage.objDeleteAccountMLPin, "Page"));
        verifyElementPresentAndClick(MLWalletSettingsPage.objDeleteAccMLPinBackBtn, getTextVal(MLWalletSettingsPage.objDeleteAccMLPinBackBtn, "Button"));
        if (verifyElementPresent(MLWalletSettingsPage.objDeleteAccount, getTextVal(MLWalletSettingsPage.objDeleteAccount, "Page"))) {
            logger.info("SS_TC_32, Settings Delete Account ML Pin Page Back Arrow Button Validated");
            ExtentReporter.extentLoggerPass("SS_TC_32", "SS_TC_32, Settings Delete Account ML Pin Page Back Arrow Button Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountInvalidMLPin_SS_TC_34() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account Invalid ML Pin");
        settingsDeleteAccountButtonFunctionality_SS_TC_28();
        click(MLWalletSettingsPage.objProceedBtn, getTextVal(MLWalletSettingsPage.objProceedBtn, "Button"));
        verifyElementPresent(MLWalletSettingsPage.objDeleteAccountMLPin, getTextVal(MLWalletSettingsPage.objDeleteAccountMLPin, "Page"));
        handleMpin("9999");
        if (verifyElementPresent(MLWalletSettingsPage.objInvalidMLPinMsg, getTextVal(MLWalletSettingsPage.objInvalidMLPinMsg, "Popup"))) {
            String sActualInvalidMLPinMsg = getText(MLWalletSettingsPage.objInvalidMLPinMsg);
            String sExceptedMsg = "You have entered an invalid PIN. Please try again.";
            assertionValidation(sActualInvalidMLPinMsg, sExceptedMsg);
            verifyElementPresent(MLWalletSettingsPage.objOKBtn, getTextVal(MLWalletSettingsPage.objOKBtn, "Button"));
            logger.info("SS_TC_34, Settings Delete Account Invalid ML Pin message Validated");
            ExtentReporter.extentLoggerPass("SS_TC_34", "SS_TC_34, Settings Delete Account Invalid ML Pin message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void settingsDeleteAccountInvalidMLPinPopupOkBtnFunctionality_SS_TC_35() throws Exception {
        ExtentReporter.HeaderChildNode("Settings Delete Account invalid ML Pin Popup Ok Button Functionality");
        settingsDeleteAccountInvalidMLPin_SS_TC_34();
        click(MLWalletSettingsPage.objOKBtn, getTextVal(MLWalletSettingsPage.objOKBtn, "Button"));
        if (verifyElementPresent(MLWalletSettingsPage.objDeleteAccountMLPin, getTextVal(MLWalletSettingsPage.objDeleteAccountMLPin, "Page"))) {
            logger.info("SS_TC_35, Settings Delete Account invalid ML Pin Popup Ok Button Functionality Validated");
            ExtentReporter.extentLoggerPass("SS_TC_35", "SS_TC_35, Settings Delete Account invalid ML Pin Popup Ok Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


}
