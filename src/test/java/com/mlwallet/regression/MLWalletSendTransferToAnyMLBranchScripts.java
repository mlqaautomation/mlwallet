package com.mlwallet.regression;

import com.business.mlwallet.MLWalletBusinessLogic;
import com.driverInstance.AppiumServer;
import org.testng.annotations.*;
import com.business.mlwallet.SendMoneyVia_BranchClass;
public class MLWalletSendTransferToAnyMLBranchScripts {

    public static String deviceName;
    public static String portno;
    public static com.business.mlwallet.MLWalletBusinessLogic MLWalletBusinessLogic;
    public static com.business.mlwallet.SendMoneyVia_BranchClass sendMoneyVia_branchClass;



    //@BeforeSuite(groups = { "All" })
    @Parameters({"deviceName", "portno"})
    @BeforeMethod
    public void before(String deviceName, String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletSendTransferToAnyMLBranchScripts.deviceName = deviceName;
        MLWalletSendTransferToAnyMLBranchScripts.portno = portno;
//        MLWalletBusinessLogic = new MLWalletBusinessLogic("MLWallet", deviceName, portno);
        sendMoneyVia_branchClass = new SendMoneyVia_BranchClass("MLWallet", deviceName, portno);
    }

//============================================================================================//


    @Test(priority = 1)
    public void sendMoneyToMLBranch_STB_TC_01() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranch_STB_TC_01();
    }

    @Test(priority = 2)
    public void sendMoneyAddRecipient_STB_TC_03() throws Exception {
        sendMoneyVia_branchClass.sendMoneyAddRecipient_STB_TC_03();
    }

    @Test(priority = 3)
    public void sendMoneyContactDuplicate_STB_TC_04() throws Exception {
        sendMoneyVia_branchClass.sendMoneyContactDuplicate_STB_TC_04();
    }

    @Test(priority = 4)
    public void sendMoneyToSavedRecipient_STB_TC_02() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToSavedRecipient_STB_TC_02();
    }

    @Test(priority = 5)
    public void sendMoneyEditRecipient_STB_TC_06() throws Exception {
        sendMoneyVia_branchClass.sendMoneyEditRecipient_STB_TC_06();
    }

    @Test(priority = 6)
    public void sendMoneyDeleteRecipient_STB_TC_05() throws Exception {
        sendMoneyVia_branchClass.sendMoneyDeleteRecipient_STB_TC_05();
    }

    @Test(priority = 7)
    public void sendMoneyInvalidAmount_STB_TC_09() throws Exception {
        sendMoneyVia_branchClass.sendMoneyInvalidAmount_STB_TC_09("0");
    }

    @Test(priority = 8)
    public void sendMoneyInsufficientAmount_STB_TC_10() throws Exception {
        sendMoneyVia_branchClass.sendMoneyInsufficientAmount_STB_TC_10();
    }

    @Test(priority = 9)
    public void sendMoneyMaximumAmount_STB_TC_12() throws Exception {
        sendMoneyVia_branchClass.sendMoneyMaximumAmount_STB_TC_12();
    }

    @Test(priority = 10)
    public void sendMoneyRequiredDetails_STB_TC_08() throws Exception {
        sendMoneyVia_branchClass.sendMoneyRequiredDetails_STB_TC_08();
    }

    @Test(priority = 11)
    public void sendMoneyInvalidDetails_STB_TC_07() throws Exception {
        sendMoneyVia_branchClass.sendMoneyInvalidDetails_STB_TC_07();
    }


    //========================================================================================================//
    @Test(priority = 12)
    public void sendTransferUIValidation_STB_TC_13() throws Exception {
        sendMoneyVia_branchClass.sendTransferUIValidation_STB_TC_13();
    }


    @Test(priority = 13)
    public void sendMoneyToBranchUIValidation_STB_TC_14() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToBranchUIValidation_STB_TC_14();
    }

    @Test(priority = 14)
    public void sendMoneyToBranchSaveRecipientPageUIValidation_STB_TC_15() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToBranchSaveRecipientPageUIValidation_STB_TC_15();
    }

    @Test(priority = 15)
    public void sendMoneyToBranchSuccessUIValidation_STB_TC_16() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToBranchSuccessUIValidation_STB_TC_16();
    }

    @Test(priority = 16)
    public void sendMoneyToBranchConfirmDetailsPageUIValidation_STB_TC_17() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToBranchConfirmDetailsPageUIValidation_STB_TC_17("100");
    }

    @Test(priority = 17)
    public void sendMoneyToBranchSelectPaymentMethodPageUIValidation_STB_TC_18() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToBranchSelectPaymentMethodPageUIValidation_STB_TC_18("100");
    }

    @Test(priority = 18)
    public void sendMoneyToBranchEnterAmountPageUIValidation_STB_TC_19() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToBranchEnterAmountPageUIValidation_STB_TC_19();
    }

    @Test(priority = 19)
    public void kwartaPadalaTransactionDetailsUIValidation_STB_TC_20() throws Exception {
        sendMoneyVia_branchClass.kwartaPadalaTransactionDetailsUIValidation_STB_TC_20();
    }

    @Test(priority = 20)
    public void sendMoneyToBranchAddRecipientPageUIValidation_STB_TC_21() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToBranchAddRecipientPageUIValidation_STB_TC_21();
    }
//====================================================================================
    @Test(priority = 21)
    public void sendMoneyToMLBranchBuyerTierAccount_STB_TC_22() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchBuyerTierAccount_STB_TC_22();
    }

    @Test(priority = 22)
    public void sendMoneyToMLBranchSemiVerifiedTierAccount_STB_TC_23() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchSemiVerifiedTierAccount_STB_TC_23();
    }

    @Test(priority = 23)
    public void sendMoneyToMLBranchBranchVerifiedAccount_STB_TC_24() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchBranchVerifiedAccount_STB_TC_24();
    }

    @Test(priority = 24)
    public void sendMoneyToMLBranchFullyVerifiedAccount_STB_TC_25() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchFullyVerifiedAccount_STB_TC_25();
    }

    @Test(priority = 25)
    public void sendMoneyToMLBranchSemiVerifiedTierAccountMaxAmount_STB_TC_26() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchSemiVerifiedTierAccountMaxAmount_STB_TC_26();
    }

    @Test(priority = 26)
    public void sendMoneyToMLBranchBranchVerifiedTierAccountMaxAmount_STB_TC_29() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchBranchVerifiedTierAccountMaxAmount_STB_TC_29();
    }

    @Test(priority = 27)
    public void sendMoneyToMLBranchFullyVerifiedTierAccountMaxAmount_STB_TC_32() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchFullyVerifiedTierAccountMaxAmount_STB_TC_32();
    }

    @Test(priority = 28)
    public void kwartaPadalaRates_STB_TC_35() throws Exception {
        sendMoneyVia_branchClass.kwartaPadalaRates_STB_TC_35();
    }

    @Test(priority = 29)
    public void sendMoneyToMLBranchRatesValidationScenarioOne_STB_TC_36() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioOne_STB_TC_36("10");
    }

    @Test(priority = 30)
    public void sendMoneyToMLBranchRatesValidationScenarioTwo_STB_TC_37() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioTwo_STB_TC_37("70");
    }

    @Test(priority = 31)
    public void sendMoneyToMLBranchRatesValidationScenarioThree_STB_TC_38() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioThree_STB_TC_38("200");
    }

    @Test(priority = 32)
    public void sendMoneyToMLBranchRatesValidationScenarioFour_STB_TC_39() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioFour_STB_TC_39("350");
    }

    @Test(priority = 33)
    public void sendMoneyToMLBranchRatesValidationScenarioFive_STB_TC_40() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioFive_STB_TC_40("450");
    }

    @Test(priority = 34)
    public void sendMoneyToMLBranchRatesValidationScenarioSix_STB_TC_41() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioSix_STB_TC_41("550");
    }


    @Test(priority = 35)
    public void sendMoneyToMLBranchRatesValidationScenarioSeven_STB_TC_42() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioSeven_STB_TC_42("650");
    }

    @Test(priority = 36)
    public void sendMoneyToMLBranchRatesValidationScenarioEight_STB_TC_43() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioEight_STB_TC_43("800");
    }

    @Test(priority = 37)
    public void sendMoneyToMLBranchRatesValidationScenarioNine_STB_TC_44() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioNine_STB_TC_44("950");
    }

    @Test(priority = 38)
    public void sendMoneyToMLBranchRatesValidationScenarioTen_STB_TC_45() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioTen_STB_TC_45("1300");
    }

    @Test(priority = 39)
    public void sendMoneyToMLBranchRatesValidationScenarioEleven_STB_TC_46() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioEleven_STB_TC_46("1800");
    }

    @Test(priority = 40)
    public void sendMoneyToMLBranchRatesValidationScenarioTwelve_STB_TC_47() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioTwelve_STB_TC_47("2300");
    }

    @Test(priority = 41)
    public void sendMoneyToMLBranchRatesValidationScenarioThirteen_STB_TC_48() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchRatesValidationScenarioThirteen_STB_TC_48("25000");
    }

    @Test(priority = 42)
    public void sendMoneyToMLBranchLocationPopupValidation_STB_TC_50() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchLocationPopupValidation_STB_TC_50();
    }

    @Test(priority = 43)
    public void sendMoneyToMLBranchLocationDenyFunctionality_STB_TC_51() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchLocationDenyFunctionality_STB_TC_51();
    }

    @Test(priority = 44)
    public void sendMoneyToMLBranchLocationPermissionDenyCloseBtnFunctionality_STB_TC_52() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchLocationPermissionDenyCloseBtnFunctionality_STB_TC_52();
    }

    @Test(priority = 45)
    public void sendMoneyToMLBranchLocationPermissionDenyOpenSettingsBtnFunctionality_STB_TC_53() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchLocationPermissionDenyOpenSettingsBtnFunctionality_STB_TC_53();
    }

    @Test(priority = 46)
    public void sendMoneyToMLBranchLocationPopUpAllowFunctionality_STB_TC_54() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchLocationPopUpAllowFunctionality_STB_TC_54();
    }

//    @Test(priority = 47)
//    public void sendMoneyToMLBranchInternetInterruptionWhileEnteringOTP_STB_TC_55() throws Exception {
//        sendMoneyVia_branchClass.sendMoneyToMLBranchInternetInterruptionWhileEnteringOTP_STB_TC_55();
//    }

    @Test(priority = 48)
    public void sendMoneyToMLBranchTransactionValidationAfterMinimizingApp_STB_TC_58() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchTransactionValidationAfterMinimizingApp_STB_TC_58();
    }

    @Test(priority = 49)
    public void sendMoneyToMLBranchTransactionWithValidMLPin_STB_TC_64() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchTransactionWithValidMLPin_STB_TC_64();
    }

    @Test(priority = 50)
    public void sendMoneyToMLBranchTransactionWithInValidMLPin_STB_TC_65() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchTransactionWithInValidMLPin_STB_TC_65();
    }

    @Test(priority = 51)
    public void sendMoneyToMLBranchInOTPPopupValidation_STB_TC_71() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchInOTPPopupValidation_STB_TC_71();
    }

    @Test(priority = 52)
    public void sendMoneyToMLBranchTransactionInAppOTPPopupUIValidation_STB_TC_72() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchTransactionInAppOTPPopupUIValidation_STB_TC_72();
    }

    @Test(priority = 53)
    public void sendMoneyToMLBranchTransactionNewOTPAfterSixtySecondsValidation_STB_TC_73() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchTransactionNewOTPAfterSixtySecondsValidation_STB_TC_73();
    }

    @Test(priority = 54)
    public void sendMoneyToMLBranchTransactionOTPCancelBtnFunctionality_STB_TC_74() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchTransactionOTPCancelBtnFunctionality_STB_TC_74();
    }

    @Test(priority = 55)
    public void sendMoneyToMLBranchOTPContinueBtnFunctionality_STB_TC_75() throws Exception {
        sendMoneyVia_branchClass.sendMoneyToMLBranchTransactionOTPContinueBtnFunctionality_STB_TC_75();
    }



    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }




}