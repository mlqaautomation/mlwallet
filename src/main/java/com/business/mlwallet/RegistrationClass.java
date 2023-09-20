package com.business.mlwallet;

import com.mlwallet.pages.MLWalletCashOutPage;
import com.mlwallet.pages.MLWalletLoginPage;
import com.mlwallet.pages.MLWalletRegistration;
import com.utility.ExtentReporter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.utility.Utilities.*;

public class RegistrationClass extends  BaseClass{
    public RegistrationClass(String Application, String deviceName, String portno) throws InterruptedException {
        super(Application, deviceName, portno);
    }

    public void registrationPageNavigation() throws Exception {
        verifyElementPresentAndClick(MLWalletRegistration.objCreateOne, getTextVal(MLWalletRegistration.objCreateOne, "Button"));
        waitTime(6000);
        type(MLWalletRegistration.objMobileNumberField, prop.getproperty("Registration_MobileNumber"), "Mobile Number Text Field");
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        enterOTP(prop.getproperty("Valid_OTP"));
    }

    public void registrationInputName() throws Exception {
        verifyElementPresent(MLWalletRegistration.objRegistrationPersonalInfo, getTextVal(MLWalletRegistration.objRegistrationPersonalInfo, "Page"));
        verifyElementPresent(MLWalletRegistration.objPersonalInfo, getTextVal(MLWalletRegistration.objPersonalInfo, "Header"));
        type(MLWalletRegistration.objFirstName, prop.getproperty("First_Name"), "First Name Input Field");
        type(MLWalletRegistration.objMiddleName, prop.getproperty("Middle_Name"), "Middle Name Input Field");
        type(MLWalletRegistration.objLastName, prop.getproperty("Last_Name"), "Last Name Input Field");
    }

    public void selectDate() throws Exception {
        verifyElementPresentAndClick(MLWalletRegistration.objBirthDate, "Birth Date Input Field");
        verifyElementPresentAndClick(MLWalletRegistration.objDatePickerYear, getTextVal(MLWalletRegistration.objDatePickerYear, "Year Section"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String year = dateFormat.format(date);
        int selectYear = Integer.parseInt(year) - 18;
        verticalSwipeByPercentages(0.4, 0.8, 0.5);
        verticalSwipeByPercentages(0.4, 0.8, 0.5);
        verifyElementPresentAndClick(MLWalletRegistration.objYearSelector(Integer.toString(selectYear)), "Selected Year");
        verifyElementPresentAndClick(MLWalletRegistration.objOkBtn, getTextVal(MLWalletRegistration.objOkBtn, "Button"));
    }

    public void emailAndPlaceOfBirth() throws Exception {
        type(MLWalletRegistration.objEmailAddress, prop.getproperty("Email"), "Email Address Field");
        type(MLWalletRegistration.objReEnterEmailAddress, prop.getproperty("Email"), "Re-Enter Email Address Field");
        type(MLWalletRegistration.objPlaceOfBirth, prop.getproperty("Valid_PlaceOfBirth"), "Place of Birth Field");
    }

    public void swipeAndConfirm() throws Exception {
        swipeDownUntilElementVisible("Confirm");
        verifyElementPresentAndClick(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
    }

    public void selectNationality() throws Exception {
        verifyElementPresentAndClick(MLWalletRegistration.objNationality, "Nationality Field");
        waitTime(5000);
        type(MLWalletRegistration.objNationalitySearchField, "filipino", "Nationality search field");
        verifyElementPresentAndClick(MLWalletRegistration.objFilipino, getTextVal(MLWalletRegistration.objFilipino, "Nationality"));
    }

    public void civilAndGenderSelection() throws Exception {
        verifyElementPresentAndClick(MLWalletRegistration.objCivilStatus, "Civil Status");
        verifyElementPresentAndClick(MLWalletRegistration.objSingleCivilStatus, getTextVal(MLWalletRegistration.objSingleCivilStatus, "Civil Status"));
        verifyElementPresentAndClick(MLWalletRegistration.objGender, "Gender Field");
        verifyElementPresentAndClick(MLWalletRegistration.objMaleGender, getTextVal(MLWalletRegistration.objMaleGender, "Gender"));
    }

    public void registrationAddressPageNavigation() throws Exception {
        registrationPageNavigation();
        waitTime(5000);
        registrationInputName();
        selectDate();
        emailAndPlaceOfBirth();
        selectNationality();
        swipeDownUntilElementVisible("Confirm");
        civilAndGenderSelection();
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
    }


    public void registrationInvalidMobileNumber_RG_TC_02() throws Exception {
        ExtentReporter.HeaderChildNode("Registration With Invalid Number");
        verifyElementPresentAndClick(MLWalletRegistration.objCreateOne, getTextVal(MLWalletRegistration.objCreateOne, "Button"));
        waitTime(10000);
        type(MLWalletRegistration.objMobileNumberField, prop.getproperty("Invalid_MobileNumber"), "Mobile Number Text Field");
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        if (verifyElementPresent(MLWalletLoginPage.objInvalidMobNumberTxt, getTextVal(MLWalletLoginPage.objInvalidMobNumberTxt, "Error Message"))) {
            logger.info("RG_TC_02, Mobile number is Invalid Error Message is Displayed");
            ExtentReporter.extentLoggerPass("RG_TC_02", "RG_TC_02, Mobile number is Invalid Error Message is Displayed");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationFirstNameInputFieldValidation_RG_TC_04() throws Exception {
        ExtentReporter.HeaderChildNode("Registration First Name Input Field Validation");
        registrationPageNavigation();
        waitTime(5000);
        verifyElementPresent(MLWalletRegistration.objRegistrationPersonalInfo, getTextVal(MLWalletRegistration.objRegistrationPersonalInfo, "Page"));
        verifyElementPresent(MLWalletRegistration.objPersonalInfo, getTextVal(MLWalletRegistration.objPersonalInfo, "Header"));
        type(MLWalletRegistration.objFirstName, prop.getproperty("Invalid_First_Name"), "First Name Input Field");
        swipeAndConfirm();
        Swipe("DOWN", 2);
        if (verifyElementPresent(MLWalletRegistration.objFirstNameErrorMsg, getTextVal(MLWalletRegistration.objFirstNameErrorMsg, "Error Message"))) {
            String sInvalidFirstNameErrorMsg = getText(MLWalletRegistration.objFirstNameErrorMsg);
            String sExceptedFirstNameErrorMsg = "First name must only contain letters and spaces";
            assertionValidation(sInvalidFirstNameErrorMsg, sExceptedFirstNameErrorMsg);
            logger.info("RG_TC_04, Registration First Name Input Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_04", "RG_TC_04, Registration First Name Input Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationMiddleNameInputFieldValidation_RG_TC_05() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Middle Name Input Field Validation");
        registrationPageNavigation();
        waitTime(5000);
        verifyElementPresent(MLWalletRegistration.objRegistrationPersonalInfo, getTextVal(MLWalletRegistration.objRegistrationPersonalInfo, "Page"));
        verifyElementPresent(MLWalletRegistration.objPersonalInfo, getTextVal(MLWalletRegistration.objPersonalInfo, "Header"));
        type(MLWalletRegistration.objFirstName, prop.getproperty("First_Name"), "First Name Input Field");
        type(MLWalletRegistration.objMiddleName, prop.getproperty("Invalid_Middle_Name"), "Middle Name Input Field");
        swipeAndConfirm();
        Swipe("DOWN", 2);
        if (verifyElementPresent(MLWalletRegistration.objMiddleNameErrorMsg, getTextVal(MLWalletRegistration.objMiddleNameErrorMsg, "Error Message"))) {
            String sInvalidMiddleNameErrorMsg = getText(MLWalletRegistration.objMiddleNameErrorMsg);
            String sExceptedMiddleNameErrorMsg = "Middle name must only contain letters and spaces";
            assertionValidation(sInvalidMiddleNameErrorMsg, sExceptedMiddleNameErrorMsg);
            logger.info("RG_TC_05, Registration Middle Name Input Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_05", "RG_TC_05, Registration Middle Name Input Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationLastNameInputFieldValidation_RG_TC_06() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Last Name Input Field Validation");
        registrationPageNavigation();
        waitTime(5000);
        verifyElementPresent(MLWalletRegistration.objRegistrationPersonalInfo, getTextVal(MLWalletRegistration.objRegistrationPersonalInfo, "Page"));
        verifyElementPresent(MLWalletRegistration.objPersonalInfo, getTextVal(MLWalletRegistration.objPersonalInfo, "Header"));
        type(MLWalletRegistration.objFirstName, prop.getproperty("First_Name"), "First Name Input Field");
        type(MLWalletRegistration.objMiddleName, prop.getproperty("Middle_Name"), "Middle Name Input Field");
        type(MLWalletRegistration.objLastName, prop.getproperty("Invalid_Last_Name"), "Last Name Input Field");
        swipeAndConfirm();
        if (verifyElementPresent(MLWalletRegistration.objLastNameErrorMsg, getTextVal(MLWalletRegistration.objLastNameErrorMsg, "Error Message"))) {
            String sInvalidLastNameErrorMsg = getText(MLWalletRegistration.objLastNameErrorMsg);
            String sExceptedLastNameErrorMsg = "Last name must only contain letters and spaces";
            assertionValidation(sInvalidLastNameErrorMsg, sExceptedLastNameErrorMsg);
            logger.info("RG_TC_06, Registration Last Name Input Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_06", "RG_TC_06, Registration Last Name Input Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationInvalidBirthDate_RG_TC_07() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Invalid Birth Date");
        registrationPageNavigation();
        waitTime(5000);
        registrationInputName();
        verifyElementPresentAndClick(MLWalletRegistration.objBirthDate, "Birth Date Input Field");
        verifyElementPresentAndClick(MLWalletRegistration.objOkBtn, getTextVal(MLWalletRegistration.objOkBtn, "Button"));
        swipeAndConfirm();
        if (verifyElementPresent(MLWalletRegistration.objBirthDateErrorMsg, getTextVal(MLWalletRegistration.objBirthDateErrorMsg, "Error Message"))) {
            String sInvalidBirthDateNameErrorMsg = getText(MLWalletRegistration.objBirthDateErrorMsg);
            String sExceptedBirthDateNameErrorMsg = "You must be 18 years old and above to register";
            assertionValidation(sInvalidBirthDateNameErrorMsg, sExceptedBirthDateNameErrorMsg);
            logger.info("RG_TC_07, Registration Invalid Birth Date Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_07", "RG_TC_07, Registration Invalid Birth Date Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationInvalidEmailAddress_RG_TC_08() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Invalid Email Address");
        registrationPageNavigation();
        waitTime(5000);
        registrationInputName();
        selectDate();
        type(MLWalletRegistration.objEmailAddress, prop.getproperty("Invalid_Email_Address"), "Email Address Field");
        swipeAndConfirm();
        if (verifyElementPresent(MLWalletRegistration.objEmailAddressErrorMsg, getTextVal(MLWalletRegistration.objEmailAddressErrorMsg, "Error Message"))) {
            String sInvalidEmailAddressNameErrorMsg = getText(MLWalletRegistration.objEmailAddressErrorMsg);
            String sExceptedEmailAddressNameErrorMsg = "Email address is invalid";
            assertionValidation(sInvalidEmailAddressNameErrorMsg, sExceptedEmailAddressNameErrorMsg);
            logger.info("RG_TC_08, Registration Invalid Email Address Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_08", "RG_TC_08, Registration Invalid Email Address Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationInvalidReEnterEmailAddress_RG_TC_09() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Invalid Re-Enter Email Address");
        registrationPageNavigation();
        waitTime(5000);
        registrationInputName();
        selectDate();
        type(MLWalletRegistration.objEmailAddress, prop.getproperty("Email"), "Email Address Field");
        type(MLWalletRegistration.objReEnterEmailAddress, prop.getproperty("eMailAddress"), "Re-Enter Email Address Field");
        swipeAndConfirm();
        if (verifyElementPresent(MLWalletRegistration.objReEnterEmailAddressErrorMsg, getTextVal(MLWalletRegistration.objReEnterEmailAddressErrorMsg, "Error Message"))) {
            String sInvalidEmailAddressNameErrorMsg = getText(MLWalletRegistration.objReEnterEmailAddressErrorMsg);
            String sExceptedEmailAddressNameErrorMsg = "Email address did not match.";
            assertionValidation(sInvalidEmailAddressNameErrorMsg, sExceptedEmailAddressNameErrorMsg);
            logger.info("RG_TC_09, Registration Invalid Re-Enter Email Address Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_09", "RG_TC_09, Registration Invalid Re-Enter Email Address Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationInvalidPlaceOfBirthValidation_RG_TC_10() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Invalid Place of Birth");
        registrationPageNavigation();
        waitTime(5000);
        registrationInputName();
        selectDate();
        type(MLWalletRegistration.objEmailAddress, prop.getproperty("Email"), "Email Address Field");
        type(MLWalletRegistration.objReEnterEmailAddress, prop.getproperty("Email"), "Re-Enter Email Address Field");
        type(MLWalletRegistration.objPlaceOfBirth, prop.getproperty("Invalid_PlaceOfBirth"), "Place of Birth Field");
        swipeAndConfirm();
        if (verifyElementPresent(MLWalletRegistration.objPlaceOfBirthErrorMsg, getTextVal(MLWalletRegistration.objPlaceOfBirthErrorMsg, "Error Message"))) {
            String sInvalidPlaceOfBirthErrorMsg = getText(MLWalletRegistration.objPlaceOfBirthErrorMsg);
            String sExceptedPlaceOfBirthErrorMsg = "Place of Birth must only contain letters and spaces";
            assertionValidation(sInvalidPlaceOfBirthErrorMsg, sExceptedPlaceOfBirthErrorMsg);
            logger.info("RG_TC_10, Registration Invalid Place of Birth Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_10", "RG_TC_10, Registration Invalid Place of Birth Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationEmptyNationalityFieldValidation_RG_TC_11() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Empty Nationality Field Validation");
        registrationPageNavigation();
        waitTime(5000);
        registrationInputName();
        selectDate();
        emailAndPlaceOfBirth();
        swipeAndConfirm();
        if (verifyElementPresent(MLWalletRegistration.objNationalityErrorMsg, getTextVal(MLWalletRegistration.objNationalityErrorMsg, "Error Message"))) {
            String sInvalidNationalityErrorMsg = getText(MLWalletRegistration.objNationalityErrorMsg);
            String sExceptedNationalityErrorMsg = "Nationality is required";
            assertionValidation(sInvalidNationalityErrorMsg, sExceptedNationalityErrorMsg);
            logger.info("RG_TC_11, Registration Invalid Empty Nationality Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_11", "RG_TC_11, Registration Empty Nationality Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationEmptyCivilStatusFieldValidation_RG_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Empty Civil status Field Validation");
        registrationPageNavigation();
        waitTime(5000);
        registrationInputName();
        selectDate();
        emailAndPlaceOfBirth();
        selectNationality();
        swipeAndConfirm();
        if (verifyElementPresent(MLWalletRegistration.objCivilStatusErrorMsg, getTextVal(MLWalletRegistration.objCivilStatusErrorMsg, "Error Message"))) {
            String sInvalidCivilStatusErrorMsg = getText(MLWalletRegistration.objCivilStatusErrorMsg);
            String sExceptedCivilStatusErrorMsg = "Civil Status is required";
            assertionValidation(sInvalidCivilStatusErrorMsg, sExceptedCivilStatusErrorMsg);
            logger.info("RG_TC_12, Registration Empty Civil status Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_12", "RG_TC_12, Registration Empty Civil status Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationEmptyGenderFieldValidation_RG_TC_13() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Empty Gender Field Validation");
        registrationPageNavigation();
        waitTime(5000);
        registrationInputName();
        selectDate();
        emailAndPlaceOfBirth();
        selectNationality();
        swipeDownUntilElementVisible("Confirm");
        verifyElementPresentAndClick(MLWalletRegistration.objCivilStatus, "Civil Status");
        verifyElementPresentAndClick(MLWalletRegistration.objSingleCivilStatus, getTextVal(MLWalletRegistration.objSingleCivilStatus, "Civil Status"));
        swipeAndConfirm();
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        if (verifyElementPresent(MLWalletRegistration.objGenderErrorMsg, getTextVal(MLWalletRegistration.objGenderErrorMsg, "Error Message"))) {
            String sActualGenderErrorMsg = getText(MLWalletRegistration.objGenderErrorMsg);
            String sExceptedGenderErrorMsg = "Gender is required";
            assertionValidation(sActualGenderErrorMsg, sExceptedGenderErrorMsg);
            logger.info("RG_TC_13, Registration Empty Gender Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_13", "RG_TC_13, Registration Empty Gender Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationEmptyProvinceFieldValidation_RG_TC_14() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Empty Province Field Validation");
        registrationAddressPageNavigation();
        verifyElementPresent(MLWalletRegistration.objRegistrationAddress, getTextVal(MLWalletRegistration.objRegistrationAddress, "Page"));
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        if (verifyElementPresent(MLWalletRegistration.ObjProvinceErrorMsg, getTextVal(MLWalletRegistration.ObjProvinceErrorMsg, "Error Message"))) {
            String sInvalidProvinceNameErrorMsg = getText(MLWalletRegistration.ObjProvinceErrorMsg);
            String sExceptedProvinceNameErrorMsg = "Province / State is required";
            assertionValidation(sInvalidProvinceNameErrorMsg, sExceptedProvinceNameErrorMsg);
            logger.info("RG_TC_14, Registration Empty Province Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_14", "RG_TC_14, Registration Empty Province Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationEmptyCityFieldValidation_RG_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Empty City Field Validation");
        registrationAddressPageNavigation();
        verifyElementPresent(MLWalletRegistration.objRegistrationAddress, getTextVal(MLWalletRegistration.objRegistrationAddress, "Page"));
        verifyElementPresentAndClick(MLWalletRegistration.objProvince, "Province Field");
        type(MLWalletRegistration.objProvinceSearchField, "Aurora", "Province Search Field");
        verifyElementPresentAndClick(MLWalletRegistration.objAuroraProvince, getTextVal(MLWalletRegistration.objAuroraProvince, "Province"));
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        if (verifyElementPresent(MLWalletRegistration.objCityErrorMsg, getTextVal(MLWalletRegistration.objCityErrorMsg, "Error Message"))) {
            String sInvalidCityNameErrorMsg = getText(MLWalletRegistration.objCityErrorMsg);
            String sExceptedCityNameErrorMsg = "City / Town is required";
            assertionValidation(sInvalidCityNameErrorMsg, sExceptedCityNameErrorMsg);
            logger.info("RG_TC_15, Registration Empty City Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_15", "RG_TC_15, Registration Empty City Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationEmptyHouseNoFieldValidation_RG_TC_16() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Empty House No Field Validation");
        registrationAddressPageNavigation();
        waitTime(5000);
        verifyElementPresent(MLWalletRegistration.objRegistrationAddress, getTextVal(MLWalletRegistration.objRegistrationAddress, "Page"));
        verifyElementPresentAndClick(MLWalletRegistration.objProvince, "Province Field");
        type(MLWalletRegistration.objProvinceSearchField, "Aurora", "Province Search Field");
        verifyElementPresentAndClick(MLWalletRegistration.objAuroraProvince, getTextVal(MLWalletRegistration.objAuroraProvince, "Province"));
        verifyElementPresentAndClick(MLWalletRegistration.objCity, "City Field");
        verifyElementPresentAndClick(MLWalletRegistration.objMariaAurora, getTextVal(MLWalletRegistration.objMariaAurora, "City"));
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        if (verifyElementPresent(MLWalletRegistration.objHouseNoErrorMsg, getTextVal(MLWalletRegistration.objHouseNoErrorMsg, "Error Message"))) {
            String sInvalidHouseNoNameErrorMsg = getText(MLWalletRegistration.objHouseNoErrorMsg);
            String sExceptedHouseNoNameErrorMsg = "Unit, House No., St. is required";
            assertionValidation(sInvalidHouseNoNameErrorMsg, sExceptedHouseNoNameErrorMsg);
            logger.info("RG_TC_16, Registration Empty House No Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_16", "RG_TC_16, Registration Empty House No Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationEmptyFirstNameFieldValidation_RG_TC_18() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Empty First Name Field Validation");
        registrationPageNavigation();
        waitTime(5000);
        swipeAndConfirm();
        Swipe("DOWN", 2);
        if (verifyElementPresent(MLWalletRegistration.objFirstNameErrorMsg, getTextVal(MLWalletRegistration.objFirstNameErrorMsg, "Error Message"))) {
            String sFirstNameErrorMsg = getText(MLWalletRegistration.objFirstNameErrorMsg);
            String sExpectedMsg = "First name is required";
            assertionValidation(sFirstNameErrorMsg, sExpectedMsg);
            logger.info("RG_TC_18, Registration Empty First Name Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_18", "RG_TC_18, Registration Empty First Name Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationEmptyMiddleNameFieldValidation_RG_TC_19() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Empty Middle Name Input Validation");
        registrationPageNavigation();
        waitTime(6000);
        verifyElementPresent(MLWalletRegistration.objRegistrationPersonalInfo, getTextVal(MLWalletRegistration.objRegistrationPersonalInfo, "Page"));
        verifyElementPresent(MLWalletRegistration.objPersonalInfo, getTextVal(MLWalletRegistration.objPersonalInfo, "Header"));
        type(MLWalletRegistration.objFirstName, prop.getproperty("First_Name"), "First Name Input Field");
        swipeAndConfirm();
        Swipe("DOWN", 2);
        if (verifyElementPresent(MLWalletRegistration.objMiddleNameErrorMsg, getTextVal(MLWalletRegistration.objMiddleNameErrorMsg, "Error Message"))) {
            String sInvalidMiddleNameErrorMsg = getText(MLWalletRegistration.objMiddleNameErrorMsg);
            String sExceptedMiddleNameErrorMsg = "Middle name should be at least 2 characters long";
            assertionValidation(sInvalidMiddleNameErrorMsg, sExceptedMiddleNameErrorMsg);
            logger.info("RG_TC_19, Registration Empty Middle Name Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_19", "RG_TC_19, Registration Empty Middle Name Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationEmptyLastNameFieldValidation_RG_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Empty Last Name Field Validation");
        registrationPageNavigation();
        waitTime(5000);
        verifyElementPresent(MLWalletRegistration.objRegistrationPersonalInfo, getTextVal(MLWalletRegistration.objRegistrationPersonalInfo, "Page"));
        verifyElementPresent(MLWalletRegistration.objPersonalInfo, getTextVal(MLWalletRegistration.objPersonalInfo, "Header"));
        type(MLWalletRegistration.objFirstName, prop.getproperty("First_Name"), "First Name Input Field");
        type(MLWalletRegistration.objMiddleName, prop.getproperty("Middle_Name"), "Middle Name Input Field");
        swipeAndConfirm();
        if (verifyElementPresent(MLWalletRegistration.objLastNameErrorMsg, getTextVal(MLWalletRegistration.objLastNameErrorMsg, "Error Message"))) {
            String sInvalidLastNameErrorMsg = getText(MLWalletRegistration.objLastNameErrorMsg);
            String sExceptedLastNameErrorMsg = "Last name is required";
            assertionValidation(sInvalidLastNameErrorMsg, sExceptedLastNameErrorMsg);
            logger.info("RG_TC_20, Registration Empty Last Name Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_20", "RG_TC_06, Registration Empty Last Name Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationEmptyEmailAddress_RG_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Empty Email Address Field Validation");
        registrationPageNavigation();
        waitTime(5000);
        registrationInputName();
        selectDate();
        swipeAndConfirm();
        if (verifyElementPresent(MLWalletRegistration.objEmailAddressErrorMsg, getTextVal(MLWalletRegistration.objEmailAddressErrorMsg, "Error Message"))) {
            String sInvalidEmailAddressNameErrorMsg = getText(MLWalletRegistration.objEmailAddressErrorMsg);
            String sExceptedEmailAddressNameErrorMsg = "Email address is required";
            assertionValidation(sInvalidEmailAddressNameErrorMsg, sExceptedEmailAddressNameErrorMsg);
            logger.info("RG_TC_22, Registration Empty Email Address Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_22", "RG_TC_22, Registration Empty Email Address Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationEmptyPlaceOfBirthValidation_RG_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Empty Place of Birth Field Validation");
        registrationPageNavigation();
        waitTime(5000);
        registrationInputName();
        selectDate();
        type(MLWalletRegistration.objEmailAddress, prop.getproperty("Email"), "Email Address Field");
        type(MLWalletRegistration.objReEnterEmailAddress, prop.getproperty("Email"), "Re-Enter Email Address Field");
        swipeAndConfirm();
        if (verifyElementPresent(MLWalletRegistration.objPlaceOfBirthErrorMsg, getTextVal(MLWalletRegistration.objPlaceOfBirthErrorMsg, "Error Message"))) {
            String sInvalidPlaceOfBirthNameErrorMsg = getText(MLWalletRegistration.objPlaceOfBirthErrorMsg);
            String sExceptedPlaceOfBirthNameErrorMsg = "Place of Birth is required";
            assertionValidation(sInvalidPlaceOfBirthNameErrorMsg, sExceptedPlaceOfBirthNameErrorMsg);
            logger.info("RG_TC_23, Registration Empty Place of Birth Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_23", "RG_TC_23, Registration Empty Place of Birth Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationInvalidHouseNoFieldValidation_RG_TC_24() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Invalid House No Field Validation");
        registrationAddressPageNavigation();
        waitTime(5000);
        verifyElementPresent(MLWalletRegistration.objRegistrationAddress, getTextVal(MLWalletRegistration.objRegistrationAddress, "Page"));
        verifyElementPresentAndClick(MLWalletRegistration.objProvince, "Province Field");
        type(MLWalletRegistration.objProvinceSearchField, "Aurora", "Province Search Field");
        verifyElementPresentAndClick(MLWalletRegistration.objAuroraProvince, getTextVal(MLWalletRegistration.objAuroraProvince, "Province"));
        verifyElementPresentAndClick(MLWalletRegistration.objCity, "City Field");
        verifyElementPresentAndClick(MLWalletRegistration.objMariaAurora, getTextVal(MLWalletRegistration.objMariaAurora, "City"));
        type(MLWalletRegistration.objHouseNo, prop.getproperty("Invalid_HouseNo"), "House No Field");
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        if (verifyElementPresent(MLWalletRegistration.objHouseNoErrorMsg, getTextVal(MLWalletRegistration.objHouseNoErrorMsg, "Error Message"))) {
            String sInvalidEmailAddressNameErrorMsg = getText(MLWalletRegistration.objHouseNoErrorMsg);
            String sExceptedEmailAddressNameErrorMsg = "Address must contain letters and numbers only";
            assertionValidation(sInvalidEmailAddressNameErrorMsg, sExceptedEmailAddressNameErrorMsg);
            logger.info("RG_TC_24, Registration Invalid House No Field Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_24", "RG_TC_24, Registration Invalid House No Field Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationCreatingAccountWithExistingMLWalletAccount_RG_TC_25() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Creating Account With Existing ML Wallet Account");
        verifyElementPresentAndClick(MLWalletRegistration.objCreateOne, getTextVal(MLWalletRegistration.objCreateOne, "Button"));
        explicitWaitVisibility(MLWalletRegistration.objMobileNumberField, 10);
        type(MLWalletRegistration.objMobileNumberField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        enterOTP(prop.getproperty("Valid_OTP"));
        if (verifyElementPresent(MLWalletRegistration.objExistingAccErrorMsg, getTextVal(MLWalletRegistration.objExistingAccErrorMsg, "Error message"))) {
            String sActualErrorMsg = getText(MLWalletRegistration.objExistingAccErrorMsg);
            String sExpectedErrorMsg = "As an existing M.Lhuillier Customer, you can directly log-in using this mobile number.";
            assertionValidation(sActualErrorMsg, sExpectedErrorMsg);
            verifyElementPresent(MLWalletRegistration.objGOBackToLoginScreenBtn, getTextVal(MLWalletRegistration.objGOBackToLoginScreenBtn, "Button"));
            logger.info("RG_TC_25, Registration Creating Account With Existing ML Wallet Account Error message Validated");
            ExtentReporter.extentLoggerPass("RG_TC_25", "RG_TC_25, Registration Creating Account With Existing ML Wallet Account Error message Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationNumberPageUIValidation_RG_TC_27() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Number Page UI Validation");
        verifyElementPresentAndClick(MLWalletRegistration.objCreateOne, getTextVal(MLWalletRegistration.objCreateOne, "Button"));
        if (verifyElementPresent(MLWalletRegistration.objRegistration, getTextVal(MLWalletRegistration.objRegistration, "page"))) {
            verifyElementPresent(MLWalletRegistration.objMobileNumberField, "Mobile Number Input Field");
            verifyElementPresent(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
            logger.info("RG_TC_27, Registration Number Page UI Validated");
            ExtentReporter.extentLoggerPass("RG_TC_27", "RG_TC_27, Registration Number Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationOTPPageUIValidation_RG_TC_28() throws Exception {
        ExtentReporter.HeaderChildNode("Registration OTP Page UI Validation");
        verifyElementPresentAndClick(MLWalletRegistration.objCreateOne, getTextVal(MLWalletRegistration.objCreateOne, "Button"));
        type(MLWalletRegistration.objMobileNumberField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
//			verifyElementPresent(MLWalletLoginPage.objOtpTextField, "OTP text Field");
            verifyElementPresent(MLWalletCashOutPage.objResendCode, getTextVal(MLWalletCashOutPage.objResendCode, "Seconds"));
            logger.info("RG_TC_28, Registration One Time Pin page UI Validated");
            ExtentReporter.extentLoggerPass("RG_TC_28", "RG_TC_28, Registration One Time Pin page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationPersonalInfoPageUIValidation_RG_TC_30() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Personal info Page UI Validation");
        registrationPageNavigation();
        waitTime(5000);
        if (verifyElementPresent(MLWalletRegistration.objRegistrationPersonalInfo, getTextVal(MLWalletRegistration.objRegistrationPersonalInfo, "Page"))) {
            verifyElementPresent(MLWalletRegistration.objPersonalInfo, getTextVal(MLWalletRegistration.objPersonalInfo, "Header"));
            verifyElementPresent(MLWalletRegistration.objFirstName, "First Name Input Field");
            verifyElementPresent(MLWalletRegistration.objMiddleName, "Middle Name Input Field");
            verifyElementPresent(MLWalletRegistration.objLastName, "Last Name Input Field");
            verifyElementPresent(MLWalletRegistration.objBirthDate, "Birth date Input Field");
            verifyElementPresent(MLWalletRegistration.objEmailAddress, "Email Address Input Field");
            verifyElementPresent(MLWalletRegistration.objReEnterEmailAddress, "Re-Email Address Input Field");
            verifyElementPresent(MLWalletRegistration.objPlaceOfBirth, "Place of Birth Input Field");
            Swipe("UP", 1);
            verifyElementPresent(MLWalletRegistration.objNationality, "Choose Nationality Field");
            verifyElementPresent(MLWalletRegistration.objCivilStatus, "Choose Civil Status Field");
            verifyElementPresent(MLWalletRegistration.objGender, "Choose Gender Field");
            verifyElementPresent(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
            logger.info("RG_TC_30, Registration Personal info Page UI Validated");
            ExtentReporter.extentLoggerPass("RG_TC_30", "RG_TC_30, Registration Personal info Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationNumberPageBackBtnValidation_RG_TC_31() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Number Page Back Arrow Button Validation");
        verifyElementPresentAndClick(MLWalletRegistration.objCreateOne, getTextVal(MLWalletRegistration.objCreateOne, "Button"));
        verifyElementPresentAndClick(MLWalletRegistration.objRegistrationBackBtn, "Registration Page Back Arrow Btn");
        if (verifyElementPresent(MLWalletLoginPage.objLoginBtn, getTextVal(MLWalletLoginPage.objLoginBtn, "Button"))) {
            logger.info("RG_TC_31, Registration Number Page Back Arrow Button Validated");
            ExtentReporter.extentLoggerPass("RG_TC_31", "RG_TC_31, Registration Number Page Back Arrow Button Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationOTPPageBackBtnValidation_RG_TC_32() throws Exception {
        ExtentReporter.HeaderChildNode("Registration OTP Page Back Arrow Button Validation");
        verifyElementPresentAndClick(MLWalletRegistration.objCreateOne, getTextVal(MLWalletRegistration.objCreateOne, "Button"));
        type(MLWalletRegistration.objMobileNumberField, prop.getproperty("Branch_Verified"), "Mobile Number Text Field");
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        verifyElementPresentAndClick(MLWalletRegistration.objOTPPageBackBtn, "OTP Page Back arrow Btn");
        if (verifyElementPresent(MLWalletRegistration.objRegistration, getTextVal(MLWalletRegistration.objRegistration, "Page"))) {
            logger.info("RG_TC_32, Registration OTP Page Back Arrow Button Validated");
            ExtentReporter.extentLoggerPass("RG_TC_32", "RG_TC_32, Registration OTP Page Back Arrow Button Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationPersonalInfoPageBackBtnValidationRG_TC_33() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Personal Info Page Back Btn Validation");
        registrationPageNavigation();
        waitTime(5000);
        waitTime(5000);
        verifyElementPresentAndClick(MLWalletRegistration.objRegistrationPersonalInfoBackBtn, "OTP Page Back arrow Btn");
        if (verifyElementPresent(MLWalletLoginPage.objOneTimePin, getTextVal(MLWalletLoginPage.objOneTimePin, "Page"))) {
            logger.info("RG_TC_33, Registration Personal Info Page Back Btn Validated");
            ExtentReporter.extentLoggerPass("RG_TC_33", "RG_TC_33, Registration Personal Info Page Back Btn Validated");
            System.out.println("-----------------------------------------------------------");
        }

    }

    public void registrationAddressPageUIValidation_RG_TC_34() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Address Page UI Validation");
        registrationAddressPageNavigation();
        if (verifyElementPresent(MLWalletRegistration.objRegistrationAddress, getTextVal(MLWalletRegistration.objRegistrationAddress, "Page"))) {
            verifyElementPresent(MLWalletRegistration.objProvince, "Select State Or Province Field");
            verifyElementPresent(MLWalletRegistration.objCity, "Select City or Town");
            verifyElementPresent(MLWalletRegistration.objHouseNo, "Unit, House No., St.");
            verifyElementPresent(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
            logger.info("RG_TC_34, Registration Address Page UI Validated");
            ExtentReporter.extentLoggerPass("RG_TC_34", "RG_TC_34, Registration Address Page UI Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void registrationAddressPageBackBtnValidation_RG_TC_35() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Address Page Back btn Validation");
        registrationAddressPageNavigation();
        verifyElementPresent(MLWalletRegistration.objRegistrationAddress, getTextVal(MLWalletRegistration.objRegistrationAddress, "Page"));
        verifyElementPresentAndClick(MLWalletRegistration.objRegistrationAddressBackBtn, "Registration Address Back Btn");
        if (verifyElementPresent(MLWalletRegistration.objRegistrationPersonalInfo, getTextVal(MLWalletRegistration.objRegistrationPersonalInfo, "Page"))) {
            logger.info("RG_TC_35, Registration Address Page Back btn Validated");
            ExtentReporter.extentLoggerPass("RG_TC_35", "RG_TC_35, Registration Address Page Back btn Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void registrationTermsAndConditionPageBackBtnValidation_RG_TC_37() throws Exception {
        ExtentReporter.HeaderChildNode("Registration Terms and Condition Page Back Btn Validation");
        registrationAddressPageNavigation();
        waitTime(5000);
        verifyElementPresent(MLWalletRegistration.objRegistrationAddress, getTextVal(MLWalletRegistration.objRegistrationAddress, "Page"));
        verifyElementPresentAndClick(MLWalletRegistration.objProvince, "Province Field");
        type(MLWalletRegistration.objProvinceSearchField, "Aurora", "Province Search Field");
        verifyElementPresentAndClick(MLWalletRegistration.objAuroraProvince, getTextVal(MLWalletRegistration.objAuroraProvince, "Province"));
        verifyElementPresentAndClick(MLWalletRegistration.objCity, "City Field");
        verifyElementPresentAndClick(MLWalletRegistration.objMariaAurora, getTextVal(MLWalletRegistration.objMariaAurora, "City"));
        type(MLWalletRegistration.objHouseNo, prop.getproperty("HouseNo"), "House No Field");
        click(MLWalletRegistration.objConfirm, getTextVal(MLWalletRegistration.objConfirm, "Button"));
        verifyElementPresent(MLWalletRegistration.objTermsAndCondition, getTextVal(MLWalletRegistration.objTermsAndCondition, "Page"));
        verifyElementPresentAndClick(MLWalletRegistration.objTermsAndConditionBackBtn, "Terms And Condition back Btn");
        if (verifyElementPresent(MLWalletRegistration.objRegistrationAddress, getTextVal(MLWalletRegistration.objRegistrationAddress, "Page"))) {
            logger.info("RG_TC_37, Registration Terms and Condition Page Back Btn Validated");
            ExtentReporter.extentLoggerPass("RG_TC_37", "RG_TC_37, Registration Terms and Condition Page Back Btn Validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
}
