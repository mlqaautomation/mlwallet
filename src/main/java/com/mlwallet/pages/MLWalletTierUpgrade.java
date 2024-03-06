package com.mlwallet.pages;

import org.openqa.selenium.By;

public class MLWalletTierUpgrade {

    public static By objVerificationTierPerksLabel = By.xpath("//*[@text='Verification Tier Perks']");
    //  Verification Tier perk page back button
    public static By objVerificationTierPerksBackBtn = By.xpath("//*[@text='Verification Tier Perks']/parent::android.view.ViewGroup/preceding-sibling::android.view.ViewGroup");
    //  Semi verified Tab
    public static By objSemiVerifiedTab = By.xpath("//*[@text='Semi Verified']");
    //  Upgrade Tier Level Button
    public static By objUpgradeTierLevel = By.xpath("//*[@text='Upgrade Tier Level']");
    //  Fully verified Tab
    public static By objFullyVerifiedTab = By.xpath("//*[@text='Fully Verified']");
    //  Branch verified Tab
    public static By objBranchVerifiedTab = By.xpath("//*[@text='Branch Verified']");
    //  Account Details
    public static By objAccountDetails = By.xpath("//*[@text='Account Details']");
    //  Account Details page back button
    public static By objAccountDetailsBackBtn = By.xpath("//*[@text='Account Details']/parent::android.view.ViewGroup/preceding-sibling::android.view.ViewGroup");
    //  Search field
    public static By objSearchFieldInput = By.xpath("//*[@class='android.widget.EditText']");
    //  Matching elements for Product/Services
    public static By objMatchingElementsProductServices(int i){
        return By.xpath("((//*[@class='android.widget.ScrollView']/child::android.view.ViewGroup/child::android.view.ViewGroup)["+i+"]/child::android.view.ViewGroup)[1]/child::android.view.ViewGroup/child::android.widget.TextView");
    }
    //  Matching Elements
    public static By objMatchingElements = By.xpath("//*[@class='android.widget.ScrollView']/child::android.view.ViewGroup/child::android.view.ViewGroup");
    //  Product/Services Offered selection button
    public static By objProductServiceSelectionBtn = By.xpath("//*[@text='Product/Services Offered']/preceding-sibling::android.view.ViewGroup/child::android.widget.TextView");
    //  Position at Work selection button
    public static By objPositionAtWokSelectionBtn = By.xpath("//*[@text='Position at Work']/preceding-sibling::android.view.ViewGroup/child::android.widget.TextView");
    //  Nature of Work selection button
    public static By objNatureOfWorkSelectionBtn = By.xpath("(//*[@text='Nature of Work']/preceding-sibling::android.view.ViewGroup/child::android.widget.TextView)[2]");
    //  Confirm details btn
    public static By objConfirmDetails = By.xpath("//*[@text='Confirm Details']");
    //  Tier Upgrade btn
    public static By objTierUpgrade = By.xpath("//*[@text='Tier Upgrade']");
    //  Place of Birth
    public static By objPlaceOfBirth = By.xpath("//*[@text='Place of Birth']/following-sibling::android.widget.EditText");
    //  Nationality
    public static By objNationality = By.xpath("//*[@text='Nationality']/preceding-sibling::android.view.ViewGroup/child::android.view.ViewGroup/child::android.widget.TextView");
    //  Civil Status
    public static By objCivilStatus = By.xpath("//*[@text='Civil Status']/preceding-sibling::android.view.ViewGroup/child::android.view.ViewGroup/child::android.widget.TextView");
    //  Civil = Married
    public static By objMarried = By.xpath("//*[@text='Married']");
    //
//  Gender at Birth
    public static By objGenderAtBirth = By.xpath("//*[@text='Gender at Birth']/preceding-sibling::android.view.ViewGroup/child::android.view.ViewGroup/child::android.widget.TextView");
    //  Gender = Male
    public static By objGenderMale = By.xpath("//*[@text='Male']");
    //  Gender = Female
    public static By objGenderFemale = By.xpath("//*[@text='Female']");
    //----------Source of Income-------------------
    public static By objSourceOfIncome = By.xpath("//*[@text='Source of Income']/preceding-sibling::android.view.ViewGroup/child::android.view.ViewGroup/child::android.widget.TextView");
    public static By objSourceOfIncomePage = By.xpath("//*[@text='Source of Income']");
    public static By getObjSourceOfIncome(String source) {
        return By.xpath("//*[@text='" + source + "']/self::android.widget.TextView");
    }
    //  Company/Employer Name
    public static By objCompanyOrEmployerName = By.xpath("//*[@text='Company/Employer Name']/following-sibling::android.widget.EditText");
    //  Work Address
    public static By objWorkAddress = By.xpath("//*[@text='Work Address']/following-sibling::android.widget.EditText");
    //  Account Details
    public static By objPersonalInformation = By.xpath("//*[@text='Personal Information']");
    //-----------------Product/Service Offered-----------------
    public static By objProductServiceOffered = By.xpath("//*[@text='Product/Services Offered']/preceding-sibling::android.view.ViewGroup/child::android.view.ViewGroup/child::android.widget.TextView");
    public static By objProductServicePage = By.xpath("//*[@text='Product/Services Offered']");
    public static By getObjProductServiceOffered(String service){
        return By.xpath("//*[@text='" + service + "']/self::android.widget.TextView");
    }
    // -------------- Position At work-------------
    public static By objPositionAtWork = By.xpath("//*[@text='Position at Work']/preceding-sibling::android.view.ViewGroup/child::android.view.ViewGroup/child::android.widget.TextView");
    public static By objPositionAtWorkPage = By.xpath("//*[@text='Position at Work']");
    public static By getObjPositionAtWork(String position){
        return By.xpath("//*[@text='" + position + "']/self::android.widget.TextView");
    }

    // ------------- Nature of work ------------------
    public static By ObjNatureOfWork = By.xpath("(//*[@text='Nature of Work'])[2]/preceding-sibling::android.view.ViewGroup/child::android.view.ViewGroup/child::android.widget.TextView");
    public static By ObjNatureOfWorkPage = By.xpath("//*[@text='Nature of Work']");
    public static  By getObjNatureOfWork(String nature){
        return By.xpath("//*[@text='" + nature + "']/self::android.widget.TextView");
    }

    //  Select any valid ID
    public static By objSelectAnyValidID = By.xpath("//*[@text='Select Any Valid ID']");
    //  Select ID
    public static By objSelectID = By.xpath("//*[@text='Select ID']");
    //  Select ID Selection Btn
    public static By objSelectIDSelectionBtn = By.xpath("//*[@text='Select ID']/preceding-sibling::android.view.ViewGroup/child::android.widget.TextView");
    //  Tier upgrade Back btn
    public static By objTierUpgradeBackBtn = By.xpath("//*[@text='Tier Upgrade']/parent::android.view.ViewGroup/preceding-sibling::android.view.ViewGroup");
    //  Upload ID Photos
    public static By objUploadIDPhotos = By.xpath("//*[@text='Upload ID Photos']");
    //  Select ID
    public static By objSelectIDField = By.xpath("//*[@text='Select ID']/preceding-sibling::android.view.ViewGroup/child::android.view.ViewGroup/child::android.widget.TextView");
    //  Card Number Input Field
    public static By objCardInputField = By.xpath("//*[@class='android.widget.EditText']");
    //  Scan Front of ID
    public static By objScanFrontOfID = By.xpath("//*[@text='Scan Front of ID']");
    //  Scan Front of ID Back Arrow Button
    public static By objScanFrontOfIDBackBtn = By.xpath("//*[@text='Scan Front of ID']/parent::android.view.ViewGroup/preceding-sibling::android.view.ViewGroup");
    //  Scan Back of ID
    public static By objScanBackOfID = By.xpath("//*[@text='Scan Back of ID']");
    //  Scan Front of ID Back Arrow Button
    public static By objScanBackOfIDBackBtn = By.xpath("//*[@text='Scan Back of ID']/parent::android.view.ViewGroup/preceding-sibling::android.view.ViewGroup");
    //  Take a Face Identity Photo
    public static By objTakeAFaceIdentityPhoto = By.xpath("//*[@text='Take a Face Identity Photo']");
    //  Phil Health
    public static By objPhilHealth = By.xpath("//*[@text='PHILHEALTH']");
    //  Scan Front of ID Info
    public static By objScanFrontOfIDInfo = By.xpath("(//*[@resource-id='com.mlhuillier.mlwallet:id/texture_view']/parent::android.widget.FrameLayout/following-sibling::android.widget.TextView)[2]");
//  Capture Screen
    public static By objCaptureScreen = By.xpath("(//*[@resource-id='com.mlhuillier.mlwallet:id/texture_view']/parent::android.widget.FrameLayout/following-sibling::android.view.ViewGroup)[1]");
//  Capture button
    public static By objCaptureButton = By.xpath("(//*[@resource-id='com.mlhuillier.mlwallet:id/texture_view']/parent::android.widget.FrameLayout/following-sibling::android.view.ViewGroup)[2]");
//  Tier Upgrade Take a Face Identity Photo Info
    public static By objTakeAFaceIdentityPhotoInfo = By.xpath("//*[@resource-id='com.mlhuillier.mlwallet:id/texture_view']/parent::android.widget.FrameLayout/following-sibling::android.widget.TextView");
//  Err message
    public static By objSourceOfIncomeFieldMessage = By.xpath("//*[@text='Source of Income']/preceding-sibling::android.view.ViewGroup/following-sibling::android.view.ViewGroup/child::android.widget.TextView");
    public static By objCompanyEmployerFieldMessage = By.xpath("//*[@text='Company/Employer Name'][1]/parent::android.view.ViewGroup/following-sibling::android.widget.TextView");
    public static By objProductServiceFieldMessage = By.xpath("//*[@text='Product/Services Offered']/following-sibling::android.view.ViewGroup/child::android.widget.TextView");
    public static By objWorkAddressFieldMessage = By.xpath("//*[@text='Work Address'][1]/parent::android.view.ViewGroup/following-sibling::android.widget.TextView");
    public static By objPositionAtWorkFieldMessage = By.xpath("//*[@text='Position at Work']/following-sibling::android.view.ViewGroup/child::android.view.ViewGroup");
    public static By objNatureOfWorkFieldMessage = By.xpath("//*[@text='Choose Nature of Work']/ancestor::android.view.ViewGroup[2]/following-sibling::android.view.ViewGroup/child::android.widget.TextView");
    public static By objReceivingPensionFieldMessage = By.xpath("//*[@text='Receiving Pension From']/following-sibling::android.view.ViewGroup/child::android.widget.TextView");
    public static By objYearRetiredFieldMessage = By.xpath("//*[@text='Year Retired'][1]/parent::android.view.ViewGroup/following-sibling::android.widget.TextView");
    public static By objPositionUponRetirementMessage = By.xpath("//*[@text='Position Upon Retirement']/following-sibling::android.view.ViewGroup/child::android.widget.TextView");
    public static By objSchoolFieldMessage = By.xpath("//*[@text='School/University']/parent::android.view.ViewGroup/following-sibling::android.widget.TextView");
    public static By objSchoolAddressFieldMessage = By.xpath("//*[@text='School Address']/parent::android.view.ViewGroup/following-sibling::android.widget.TextView");
    public static By objRemarksFieldMessage = By.xpath("//*[@text='Remarks']/parent::android.view.ViewGroup/following-sibling::android.widget.TextView");
    public static By objGrantFieldMessage = By.xpath("//*[@text='Grant/Program Type']/parent::android.view.ViewGroup/following-sibling::android.widget.TextView");
    public static By objOccupationFieldMessage = By.xpath("//*[@text='Occupation']/parent::android.view.ViewGroup/following-sibling::android.widget.TextView");
    public static By objSourceOfFundsFieldMessage = By.xpath("//*[@text='Source of Funds']/parent::android.view.ViewGroup/following-sibling::android.widget.TextView");
// Search Field
    public static By objSearchField =
            By.xpath("//*[@class='android.view.ViewGroup']/child::android.widget.EditText");
// Pension Fields
    public static By objReceivingPensionField = By.xpath("//*[@text='Receiving Pension From']/preceding-sibling::android.view.ViewGroup/child::android.view.ViewGroup/child::android.widget.TextView");
    public static By objYearRetiredField = By.xpath("//*[@text='Year Retired'][2]");
    public static By objPositionField = By.xpath("//*[@text='Position Upon Retirement']/preceding-sibling::android.view.ViewGroup/child::android.view.ViewGroup/child::android.widget.TextView");
// Financial Fields
    public static By objRemarksField = By.xpath("//*[@text='Remarks'][1]/following-sibling::android.widget.EditText");
// Student Fields
    public static By objUniversityField = By.xpath("//*[@text='School/University']/following-sibling::android.widget.EditText");
    public static By objSchoolAddressField = By.xpath("//*[@text='School Address']/following-sibling::android.widget.EditText");
//
// Govt Fields
    public static By objProgramTypeField = By.xpath("//*[@text='Grant/Program Type']/following-sibling::android.widget.EditText");

// Other Source Income Fields
    public static By objOccupationField = By.xpath("//*[@text='Occupation']/following-sibling::android.widget.EditText");
    public static By objSourceOfFundsField = By.xpath("//*[@text='Source of Funds']/following-sibling::android.widget.EditText");

    // is required error message locators
    public static  By getObjIsRequired(String type){
        return By.xpath("//*[@text='" + type + "']");
    }
}
