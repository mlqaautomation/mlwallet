package com.business.mlwallet;

import com.mlwallet.pages.MLWalletLoginPage;
import com.mlwallet.pages.MLWalletTroubleSigningInPage;
import com.utility.ExtentReporter;

import static com.utility.Utilities.*;

public class TroubleSigningInClass extends BaseClass {
    public TroubleSigningInClass(String Application, String deviceName, String portno) throws InterruptedException {
        super(Application, deviceName, portno);
    }

    public void troubleSigningInPageNavigationFromMpinScreen_TS_TC_01() throws Exception {
        ExtentReporter.HeaderChildNode("Trouble Signing In Page Navigation From Mpin Screen");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        mlWalletLogout();
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objTroubleSigningIn, getTextVal(MLWalletTroubleSigningInPage.objTroubleSigningIn, "Button"));
        if (verifyElementPresent(MLWalletTroubleSigningInPage.objTroubleSingingInPAge, getTextVal(MLWalletTroubleSigningInPage.objTroubleSingingInPAge, "Page"))) {
            logger.info("TS_TC_01, Trouble Signing In Page Navigation From Mpin Screen Validated");
            ExtentReporter.extentLoggerPass("TS_TC_01", "TS_TC_01, Trouble Signing In Page Navigation From Mpin Screen Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void troubleSigningInPageNavigationFromLoginScreen_TS_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("Trouble Signing In Page Navigation From Login Screen");
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objTroubleSigningIn, getTextVal(MLWalletTroubleSigningInPage.objTroubleSigningIn, "Button"));
        if (verifyElementPresent(MLWalletTroubleSigningInPage.objTroubleSingingInPAge, getTextVal(MLWalletTroubleSigningInPage.objTroubleSingingInPAge, "Page"))) {
            logger.info("TS_TC_10, Trouble Signing In Page Navigation From Login Screen Validated");
            ExtentReporter.extentLoggerPass("TS_TC_10", "TS_TC_10, Trouble Signing In Page Navigation From Login Screen Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void troubleSigningInPageBackArrowBtnFunctionality_TS_TC_11() throws Exception {
        ExtentReporter.HeaderChildNode("Trouble Signing In Page Back Arrow Button Functionality");
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objTroubleSigningIn, getTextVal(MLWalletTroubleSigningInPage.objTroubleSigningIn, "Button"));
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objTroubleSigningInBackArrowBtn, "Back Arrow Button");
        if (verifyElementPresent(MLWalletLoginPage.objLoginBtn, getTextVal(MLWalletLoginPage.objLoginBtn, "Button"))) {
            logger.info("TS_TC_11, Trouble Signing In Page Back Arrow Button Functionality Validated");
            ExtentReporter.extentLoggerPass("TS_TC_11", "TS_TC_11, Trouble Signing In Page Back Arrow Button Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void troubleSigningInClearFormFunctionality_TS_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Trouble Signing In Clear form functionality");
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objTroubleSigningIn, getTextVal(MLWalletTroubleSigningInPage.objTroubleSigningIn, "Button"));
        type(MLWalletTroubleSigningInPage.objFullNameField, prop.getproperty("First_Name"), "First Name Field");
//		String sFulName = getText(MLWalletTroubleSigningInPage.objFullNameField);
        type(MLWalletTroubleSigningInPage.objRegisteredEmail, prop.getproperty("Email"), "Registered Email Field");
//		String sRegisteredEmail = getText(MLWalletTroubleSigningInPage.objRegisteredEmail);
        Swipe("UP", 1);
        type(MLWalletTroubleSigningInPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Mobile Number Field");
//		String sMobileNumber = getText(MLWalletTroubleSigningInPage.objMobileNumber);
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objNatureOfRequest, getTextVal(MLWalletTroubleSigningInPage.objNatureOfRequest, "Nature of Request"));
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objClearFormButton, getTextVal(MLWalletTroubleSigningInPage.objClearFormButton, "Button"));
        if (verifyElementPresent(MLWalletTroubleSigningInPage.objClearFormPopup, getTextVal(MLWalletTroubleSigningInPage.objClearFormPopup, "Popup"))) {
            verifyElementPresent(MLWalletTroubleSigningInPage.objClearFormPopupMsg, getTextVal(MLWalletTroubleSigningInPage.objClearFormPopupMsg, "Popup Msg"));
            verifyElementPresent(MLWalletTroubleSigningInPage.objClearFormButton, getTextVal(MLWalletTroubleSigningInPage.objClearFormButton, "Button"));
            verifyElementPresent(MLWalletTroubleSigningInPage.objCancelBtn, getTextVal(MLWalletTroubleSigningInPage.objCancelBtn, "Button"));
            logger.info("TS_TC_12, Trouble Signing In Clear form functionality Validated");
            ExtentReporter.extentLoggerPass("TS_TC_12", "TS_TC_12, Trouble Signing In Clear form functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void troubleSigningInClearFormButtonOnClearFormPopupFunctionality_TS_TC_13() throws Exception {
        ExtentReporter.HeaderChildNode("Trouble Signing In Clear form Btn on Clear form popup functionality");
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objTroubleSigningIn, getTextVal(MLWalletTroubleSigningInPage.objTroubleSigningIn, "Button"));
        type(MLWalletTroubleSigningInPage.objFullNameField, prop.getproperty("First_Name"), "First Name Field");
        String sFullName = getText(MLWalletTroubleSigningInPage.objFullNameField);
        type(MLWalletTroubleSigningInPage.objRegisteredEmail, prop.getproperty("Email"), "Registered Email Field");
        Swipe("UP", 1);
        type(MLWalletTroubleSigningInPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Mobile Number Field");
        String sMobileNumber = getText(MLWalletTroubleSigningInPage.objMobileNumber);
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objNatureOfRequest, getTextVal(MLWalletTroubleSigningInPage.objNatureOfRequest, "Nature of Request"));
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objClearFormButton, getTextVal(MLWalletTroubleSigningInPage.objClearFormButton, "Button"));
        verifyElementPresent(MLWalletTroubleSigningInPage.objClearFormPopup, getTextVal(MLWalletTroubleSigningInPage.objClearFormPopup, "Popup"));
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objClearFormButton, getTextVal(MLWalletTroubleSigningInPage.objClearFormButton, "Button"));
        Swipe("DOWN", 3);
        String sActualFullName = getText(MLWalletTroubleSigningInPage.objFullNameField);
        String sActualRegisteredEmail = getText(MLWalletTroubleSigningInPage.objRegisteredEmail);
        Swipe("UP", 1);
        String sActualMobileNumber = getText(MLWalletTroubleSigningInPage.objMobileNumber);
        assertNotEquals(sActualFullName, sFullName);
        assertNotEquals(sActualRegisteredEmail, prop.getproperty("Email"));
        assertNotEquals(sActualMobileNumber, sMobileNumber);
        logger.info("TS_TC_13, Trouble Signing In Clear form Btn on Clear form popup functionality Validated");
        ExtentReporter.extentLoggerPass("TS_TC_13", "TS_TC_13, Trouble Signing In Clear form Btn on Clear form popup functionality Validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void troubleSigningInCancelButtonOnClearFormPopupFunctionality_TS_TC_14() throws Exception {
        ExtentReporter.HeaderChildNode("Trouble Signing In Cancel form Btn on Clear form popup functionality");
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objTroubleSigningIn, getTextVal(MLWalletTroubleSigningInPage.objTroubleSigningIn, "Button"));
        type(MLWalletTroubleSigningInPage.objFullNameField, prop.getproperty("First_Name"), "First Name Field");
        String sFullName = getText(MLWalletTroubleSigningInPage.objFullNameField);
        type(MLWalletTroubleSigningInPage.objRegisteredEmail, prop.getproperty("Email"), "Registered Email Field");
        Swipe("UP", 1);
        type(MLWalletTroubleSigningInPage.objMobileNumber, prop.getproperty("Branch_Verified"), "Mobile Number Field");
        String sMobileNumber = getText(MLWalletTroubleSigningInPage.objMobileNumber);
        Swipe("UP", 2);
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objNatureOfRequest, getTextVal(MLWalletTroubleSigningInPage.objNatureOfRequest, "Nature of Request"));
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objClearFormButton, getTextVal(MLWalletTroubleSigningInPage.objClearFormButton, "Button"));
        verifyElementPresent(MLWalletTroubleSigningInPage.objClearFormPopup, getTextVal(MLWalletTroubleSigningInPage.objClearFormPopup, "Popup"));
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objCancelBtn, getTextVal(MLWalletTroubleSigningInPage.objCancelBtn, "Button"));
        Swipe("DOWN", 3);
        String sActualFullName = getText(MLWalletTroubleSigningInPage.objFullNameField);
        String sActualRegisteredEmail = getText(MLWalletTroubleSigningInPage.objRegisteredEmail);
        Swipe("UP", 1);
        String sActualMobileNumber = getText(MLWalletTroubleSigningInPage.objMobileNumber);
        assertionValidation(sActualFullName, sFullName);
        assertionValidation(sActualRegisteredEmail, prop.getproperty("Email"));
        assertionValidation(sActualMobileNumber, sMobileNumber);
        logger.info("TS_TC_14, Trouble Signing In Cancel Btn on Clear form popup functionality Validated");
        ExtentReporter.extentLoggerPass("TS_TC_14", "TS_TC_14, Trouble Signing In Cancel Btn on Clear form popup functionality Validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void troubleSigningInEmptyFullNameFunctionality_TS_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Trouble Signing In Empty Full Name Functionality");
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objTroubleSigningIn, getTextVal(MLWalletTroubleSigningInPage.objTroubleSigningIn, "Button"));
        Swipe("UP", 4);
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objNextBtn, getTextVal(MLWalletTroubleSigningInPage.objNextBtn, "Button"));
        if (verifyElementPresent(MLWalletTroubleSigningInPage.objRequiredQuestion, getTextVal(MLWalletTroubleSigningInPage.objRequiredQuestion, "Error msg"))) {
            String sActualErrorMsg = getText(MLWalletTroubleSigningInPage.objRequiredQuestion);
            String sExceptedErrorMsg = "This is a required question";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TS_TC_15, Trouble Signing In Empty Full Name Functionality Validated");
            ExtentReporter.extentLoggerPass("TS_TC_15", "TS_TC_15, Trouble Signing In Empty Full Name Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void troubleSigningInEmptyRegisteredEmailFunctionality_TS_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("Trouble Signing In Empty Registered Email Functionality");
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objTroubleSigningIn, getTextVal(MLWalletTroubleSigningInPage.objTroubleSigningIn, "Button"));
        type(MLWalletTroubleSigningInPage.objFullNameField, prop.getproperty("First_Name"), "First Name Field");
        Swipe("UP", 4);
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objNextBtn, getTextVal(MLWalletTroubleSigningInPage.objNextBtn, "Button"));
        if (verifyElementPresent(MLWalletTroubleSigningInPage.objRequiredQuestion, getTextVal(MLWalletTroubleSigningInPage.objRequiredQuestion, "Error msg"))) {
            String sActualErrorMsg = getText(MLWalletTroubleSigningInPage.objRequiredQuestion);
            String sExceptedErrorMsg = "This is a required question";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TS_TC_16, Trouble Signing In Empty Registered Email Functionality Validated");
            ExtentReporter.extentLoggerPass("TS_TC_16", "TS_TC_16, Trouble Signing In Empty Registered Email Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void troubleSigningInEmptyRegisteredMobileNumberFunctionality_TS_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("Trouble Signing In Empty Registered Mobile Number Functionality");
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objTroubleSigningIn, getTextVal(MLWalletTroubleSigningInPage.objTroubleSigningIn, "Button"));
        type(MLWalletTroubleSigningInPage.objFullNameField, prop.getproperty("First_Name"), "First Name Field");
        type(MLWalletTroubleSigningInPage.objRegisteredEmail, prop.getproperty("Email"), "Registered Email Field");
        Swipe("UP", 4);
        verifyElementPresentAndClick(MLWalletTroubleSigningInPage.objNextBtn, getTextVal(MLWalletTroubleSigningInPage.objNextBtn, "Button"));
        if (verifyElementPresent(MLWalletTroubleSigningInPage.objRequiredQuestion, getTextVal(MLWalletTroubleSigningInPage.objRequiredQuestion, "Error msg"))) {
            String sActualErrorMsg = getText(MLWalletTroubleSigningInPage.objRequiredQuestion);
            String sExceptedErrorMsg = "This is a required question";
            assertionValidation(sActualErrorMsg, sExceptedErrorMsg);
            logger.info("TS_TC_17, Trouble Signing In Empty Mobile Number Functionality Validated");
            ExtentReporter.extentLoggerPass("TS_TC_17", "TS_TC_17, Trouble Signing In Empty Mobile Number Functionality Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
