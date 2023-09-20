package com.mlwallet.regression;

import com.business.mlwallet.TierUpgradeClass;
import com.driverInstance.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MLWalletTierUpgrade {

    public static String deviceName;
    public static String portno;
    public  static TierUpgradeClass TierUpgradeClass;


    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletTierUpgrade.deviceName=deviceName;
        MLWalletTierUpgrade.portno= portno;
//        MLWalletBusinessLogic = new MLWalletBusinessLogic("MLWallet",deviceName,portno);
        TierUpgradeClass = new  TierUpgradeClass("MLWallet",deviceName,portno);
    }

    @Test(priority = 1)
    public void tierUpgradeHomePageIIconValidationAsBuyerTierUser_TU_TC_01() throws Exception {
        TierUpgradeClass.tierUpgradeHomePageIIconValidationAsBuyerTierUser_TU_TC_01();
    }

    @Test(priority = 2)
    public void tierUpgradeHomePageIIconValidationAsSemiVerifiedTierUser_TU_TC_02() throws Exception {
        TierUpgradeClass.tierUpgradeHomePageIIconValidationAsSemiVerifiedTierUser_TU_TC_02();
    }

    @Test(priority = 3)
    public void tierUpgradeHomePageIIconValidationAsFullyVerifiedTierUser_TU_TC_03() throws Exception {
        TierUpgradeClass.tierUpgradeHomePageIIconValidationAsFullyVerifiedTierUser_TU_TC_03();
    }

    @Test(priority = 4)
    public void tierUpgradeVerificationTierPerksPageNavigationAsBuyerTierUser_TU_TC_04() throws Exception {
        TierUpgradeClass.tierUpgradeVerificationTierPerksPageNavigationAsBuyerTierUser_TU_TC_04();
    }

    @Test(priority = 5)
    public void tierUpgradeVerificationTierPerksPageNavigationAsSemiVerifiedTierUser_TU_TC_05() throws Exception {
        TierUpgradeClass.tierUpgradeVerificationTierPerksPageNavigationAsSemiVerifiedTierUser_TU_TC_05();
    }

    @Test(priority = 6)
    public void tierUpgradeVerificationTierPerksBackBtnValidation_TU_TC_06() throws Exception {
        TierUpgradeClass.tierUpgradeVerificationTierPerksBackBtnValidation_TU_TC_06();
    }

    @Test(priority = 7)
    public void tierUpgradeUpgradeTierLevelBtnValidationForSemiVerifiedTabAsBuyTierUser_TU_TC_07() throws Exception {
        TierUpgradeClass.tierUpgradeUpgradeTierLevelBtnValidationForSemiVerifiedTabAsBuyTierUser_TU_TC_07();
    }

    @Test(priority = 8)
    public void tierUpgradeUpgradeTierLevelBtnValidationForFullyVerifiedTabAsBuyTierUser_TU_TC_08() throws Exception {
        TierUpgradeClass.tierUpgradeUpgradeTierLevelBtnValidationForFullyVerifiedTabAsBuyTierUser_TU_TC_08();
    }

    @Test(priority = 9)
    public void tierUpgradeUpgradeTierLevelBtnValidationForBranchVerifiedTabAsBuyTierUser_TU_TC_09() throws Exception {
        TierUpgradeClass.tierUpgradeUpgradeTierLevelBtnValidationForBranchVerifiedTabAsBuyerTierUser_TU_TC_09();
    }

    @Test(priority = 10)
    public void tierUpgradeUpgradeTierLevelBtnValidationForFullyVerifiedTabAsSemiVerifiedTierUser_TU_TC_10() throws Exception {
        TierUpgradeClass.tierUpgradeUpgradeTierLevelBtnValidationForFullyVerifiedTabAsSemiVerifiedTierUser_TU_TC_10();
    }

    @Test(priority = 11)
    public void tierUpgradeUpgradeTierLevelBtnValidationForBranchVerifiedTabAsSemiVerifiedTierUser_TU_TC_11() throws Exception {
        TierUpgradeClass.tierUpgradeUpgradeTierLevelBtnValidationForBranchVerifiedTabAsSemiVerifiedTierUser_TU_TC_11();
    }

    @Test(priority = 12)
    public void tierUpgradeAccountDetailsPageNavigationAsBuyerTierUserToUpgradeToSemiVerifiedTier_TU_TC_12() throws Exception {
        TierUpgradeClass.tierUpgradeAccountDetailsPageNavigationAsBuyerTierUserToUpgradeToSemiVerifiedTier_TU_TC_12();
    }

    @Test(priority = 13)
    public void tierUpgradeAccountDetailsPageNavigationAsBuyerTierUserToUpgradeToFullyVerifiedTier_TU_TC_13() throws Exception {
        TierUpgradeClass.tierUpgradeAccountDetailsPageNavigationAsBuyerTierUserToUpgradeToFullyVerifiedTier_TU_TC_13();
    }

    @Test(priority = 14)
    public void tierUpgradeAccountDetailsPageNavigationAsSemiVerifiedTierUserToUpgradeToFullyVerifiedTier_TU_TC_14() throws Exception {
        TierUpgradeClass.tierUpgradeAccountDetailsPageNavigationAsSemiVerifiedTierUserToUpgradeToFullyVerifiedTier_TU_TC_14();
    }

    @Test(priority = 15)
    public void tierUpgradeAccountDetailsPageBackBtnValidation_TU_TC_15() throws Exception {
        TierUpgradeClass.tierUpgradeAccountDetailsPageBackBtnValidation_TU_TC_15();
    }

    @Test(priority = 16)
    public void tierUpgradeAutoSuggestionsValidationForProductServicesOffered_TU_TC_16() throws Exception {
        TierUpgradeClass.tierUpgradeAutoSuggestionsValidationForProductServicesOffered_TU_TC_16();
    }

    @Test(priority = 17)
    public void tierUpgradeAutoSuggestionsValidationForPositionAtWork_TU_TC_17() throws Exception {
        TierUpgradeClass.tierUpgradeAutoSuggestionsValidationForPositionAtWork_TU_TC_17();
    }

    @Test(priority = 18)
    public void tierUpgradeAutoSuggestionsValidationForNatureOfWork_TU_TC_18() throws Exception {
        TierUpgradeClass.tierUpgradeAutoSuggestionsValidationForNatureOfWork_TU_TC_18();
    }

    @Test(priority = 19)
    public void tierUpgradeConfirmDetailsBtnValidationInAccountDetailsPage_TU_TC_19() throws Exception {
        TierUpgradeClass.tierUpgradeConfirmDetailsBtnValidationInAccountDetailsPage_TU_TC_19();
    }

    @Test(priority = 20)
    public void tierUpgradePageNavigation_TU_TC_20() throws Exception {
        TierUpgradeClass.tierUpgradePageNavigation_TU_TC_20();
    }

    @Test(priority = 21)
    public void tierUpgradeFullyVerifiedTierTabUIValidation_TU_TC_21() throws Exception {
        TierUpgradeClass.tierUpgradeFullyVerifiedTierTabUIValidation_TU_TC_21();
    }

    @Test(priority = 22)
    public void tierUpgradeAccountDetailsPageUIValidation_TU_TC_23() throws Exception {
        TierUpgradeClass.tierUpgradeAccountDetailsPageUIValidation_TU_TC_23();
    }

    @Test(priority = 23)
    public void tierUpgradePageUIValidation_TU_TC_24() throws Exception {
        TierUpgradeClass.tierUpgradePageUIValidation_TU_TC_24();
    }

    @Test(priority = 24)
    public void tierUpgradeBackArrowBtnValidation_TU_TC_25() throws Exception {
        TierUpgradeClass.tierUpgradeBackArrowBtnValidation_TU_TC_25();
    }

    @Test(priority = 25)
    public void tierUpgradeUploadIDPhotosUIValidationAfterSelectingPHILHEALTH_TU_TC_26() throws Exception {
        TierUpgradeClass.tierUpgradeUploadIDPhotosUIValidationAfterSelectingPHILHEALTH_TU_TC_26();
    }

    @Test(priority = 26)
    public void tierUpgradeUploadIDPhotosBackArrowBtnValidation_TU_TC_27() throws Exception {
        TierUpgradeClass.tierUpgradeUploadIDPhotosBackArrowBtnValidation_TU_TC_27();
    }

    @Test(priority = 27)
    public void tierUpgradeScanFrontOfIDPageUIValidation_TU_TC_28() throws Exception {
        TierUpgradeClass.tierUpgradeScanFrontOfIDPageUIValidation_TU_TC_28();
    }

    @Test(priority = 28)
    public void tierUpgradeScanFrontOfIDPageBackArrowBtnValidation_TU_TC_29() throws Exception {
        TierUpgradeClass.tierUpgradeScanFrontOfIDPageBackArrowBtnValidation_TU_TC_29();
    }

    @Test(priority = 29)
    public void tierUpgradeScanBackOfIDPageUIValidation_TU_TC_30() throws Exception {
        TierUpgradeClass.tierUpgradeScanBackOfIDPageUIValidation_TU_TC_30();
    }

    @Test(priority = 30)
    public void tierUpgradeScanBackOfIDPageBackArrowBtnValidation_TU_TC_31() throws Exception {
        TierUpgradeClass.tierUpgradeScanBackOfIDPageBackArrowBtnValidation_TU_TC_31();
    }

    @Test(priority = 31)
    public void tierUpgradeTakeAFaceIdentityPhotoPageUIValidation_TU_TC_32() throws Exception {
        TierUpgradeClass.tierUpgradeTakeAFaceIdentityPhotoPageUIValidation_TU_TC_32();
    }

    @Test(priority = 32)
    public void tierUpgradeTakeAFaceIdentityPhotoPageBackArrowBtnValidation_TU_TC_33() throws Exception {
        TierUpgradeClass.tierUpgradeTakeAFaceIdentityPhotoPageBackArrowBtnValidation_TU_TC_33();
    }

    @Test(priority = 33)
    public void tierUpgradeToBranchVerifiedFromBuyerTier_TU_TC_244() throws Exception {
        TierUpgradeClass.tierUpgradeToBranchVerifiedFromBuyerTier_TU_TC_244();
    }
    @Test(priority = 34)
    public void TierUpgradeSourceOfIncomeFieldValidation_TU_TC_85() throws Exception {
    TierUpgradeClass.TierUpgradeSourceOfIncomeFieldValidation_TU_TC_85();
    }
    @Test(priority = 35)
    public void TierUpgradeCompanyFieldValidation_TU_TC_86() throws Exception {
        TierUpgradeClass.TierUpgradeCompanyFieldValidation_TU_TC_86();
    }
    @Test(priority = 36)
    public void TierUpgradeOrganizationNameFieldValidation_TU_TC_87() throws Exception {
        TierUpgradeClass.TierUpgradeOrganizationNameFieldValidation_TU_TC_87();
    }@Test(priority = 37)
    public void TierUpgradeProductServicesFieldValidation_TU_TC_88() throws Exception {
        TierUpgradeClass.TierUpgradeProductServicesFieldValidation_TU_TC_88();
    }@Test(priority = 38)
    public void TierUpgradeEmptyAddressFieldValidation_TU_TC_89() throws Exception {
        TierUpgradeClass.TierUpgradeEmptyAddressFieldValidation_TU_TC_89();
    }@Test(priority = 39)
    public void TierUpgradeSpecialAddressFieldValidation_TU_TC_90() throws Exception {
        TierUpgradeClass.TierUpgradeSpecialAddressFieldValidation_TU_TC_90();
    }@Test(priority = 40)
    public void TierUpgradePositionFieldValidation_TU_TC_91() throws Exception {
        TierUpgradeClass.TierUpgradePositionFieldValidation_TU_TC_91();
    }@Test(priority = 41)
    public void TierUpgradeNatureOfWorkFieldValidation_TU_TC_92() throws Exception {
        TierUpgradeClass.TierUpgradeNatureOfWorkFieldValidation_TU_TC_92();
    }@Test(priority = 42)
    public void TierUpgradePensionFieldValidation_TU_TC_93() throws Exception {
        TierUpgradeClass.TierUpgradePensionFieldValidation_TU_TC_93();
    }@Test(priority = 43)
    public void TierUpgradeYearRetiredFieldValidation_TU_TC_94() throws Exception {
        TierUpgradeClass.TierUpgradeYearRetiredFieldValidation_TU_TC_94();
    }@Test(priority = 44)
    public void TierUpgradePositionRetirementFieldValidation_TU_TC_95() throws Exception {
        TierUpgradeClass.TierUpgradePositionRetirementFieldValidation_TU_TC_95();
    }@Test(priority = 45)
    public void TierUpgradeRemarksFieldValidation_TU_TC_96() throws Exception {
        TierUpgradeClass.TierUpgradeRemarksFieldValidation_TU_TC_96();
    }@Test(priority = 46)
    public void TierUpgradeErrorMessageUniversityIsRequiredEmptyFieldValidation_TU_TC_97() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageUniversityIsRequiredEmptyFieldValidation_TU_TC_97();
    }
    @Test(priority = 47)
    public void TierUpgradeErrorMessageUniversityNameSpecialCharactersValidation_TU_TC_98() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageUniversityNameSpecialCharactersValidation_TU_TC_98();
    }
    @Test(priority = 48)
    public void TierUpgradeErrorMessageSchoolAddressIsRequiredEmptyValidation_TU_TC_99() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageSchoolAddressIsRequiredEmptyValidation_TU_TC_99();
    }
    @Test(priority = 49)
    public void TierUpgradeErrorMessageSchoolAddressSpecialCharactersValidation_TU_TC_100() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageSchoolAddressSpecialCharactersValidation_TU_TC_100();
    }
    @Test(priority = 50)
    public void TierUpgradeErrorMessageProgramTypeIsRequiredEmptyFieldValidation_TU_TC_101() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageProgramTypeIsRequiredEmptyFieldValidation_TU_TC_101();
    }
    @Test(priority = 51)
    public void TierUpgradeErrorMessageProgramTypeSpecialCharactersValidation_TU_TC_102() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageProgramTypeSpecialCharactersValidation_TU_TC_102();
    }
    @Test(priority = 52)
    public void TierUpgradeErrorMessageOccupationNameIsRequiredEmptyFieldValidation_TU_TC_103() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageOccupationNameIsRequiredEmptyFieldValidation_TU_TC_103();
    }
    @Test(priority = 53)
    public void TierUpgradeErrorMessageOccupationNameSpecialCharactersValidation_TU_TC_104() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageOccupationNameSpecialCharactersValidation_TU_TC_104();
    }
    @Test(priority = 54)
    public void TierUpgradeErrorMessageSourceOfFundsIsRequiredEmptyFieldValidation_TU_TC_105() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageSourceOfFundsIsRequiredEmptyFieldValidation_TU_TC_105();
    }
    @Test(priority = 55)
    public void TierUpgradeErrorMessageEmployerNameSpecialCharactersValidation_TU_TC_106() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageEmployerNameSpecialCharactersValidation_TU_TC_106();
    }
    @Test(priority = 56)
    public void TierUpgradeErrorMessageWorkAddressSpecialCharactersValidation_TU_TC_107() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageWorkAddressSpecialCharactersValidation_TU_TC_107();
   }
    @Test(priority = 57)
    public void TierUpgradeErrorMessageRetiredFieldSpecialCharactersValidation_TU_TC_108() throws Exception {
        TierUpgradeClass.TierUpgradeErrorMessageRetiredFieldSpecialCharactersValidation_TU_TC_108();
    }
    @Test(priority = 58)
    public void TierUpgradeBranchTierVerificationTierNavigation_TU_TC_109() throws Exception {
        TierUpgradeClass.TierUpgradeBranchTierVerificationTierNavigation_TU_TC_109();
    }
    @Test(priority = 59)
    public void TierUpgradeSchoolUniveristyFieldValidation_TU_TC_110() throws Exception {
        TierUpgradeClass.TierUpgradeSchoolUniveristyFieldValidation_TU_TC_110();
    }

    @Test(priority = 60)
    public void TierUpgradeSchoolAddressFieldValidation_TU_TC_111() throws Exception {
        TierUpgradeClass.TierUpgradeSchoolAddressFieldValidation_TU_TC_111();
    }
    @Test(priority = 61)
    public void TierUpgradeGrantProgramFIeldValidation_TU_TC_112() throws Exception {
        TierUpgradeClass.TierUpgradeGrantProgramFIeldValidation_TU_TC_112();
    }

    @Test(priority = 62)
    public void TierUpgradeOccupationFieldValidation_TU_TC_113() throws Exception {
        TierUpgradeClass.TierUpgradeOccupationFieldValidation_TU_TC_113();
    }

    @Test(priority = 63)
    public void TierUpgradeOccupationFieldValidation_TU_TC_114() throws Exception {
        TierUpgradeClass.TierUpgradeOccupationFieldValidation_TU_TC_114();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
