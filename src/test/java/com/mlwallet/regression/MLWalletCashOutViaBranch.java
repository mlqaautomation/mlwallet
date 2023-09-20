package com.mlwallet.regression;

import com.business.mlwallet.CashOutVia_BankClass;
import com.business.mlwallet.CashOutVia_BranchClass;
import com.driverInstance.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MLWalletCashOutViaBranch {
    public static String deviceName;
    public static String portno;
//    public  static com.business.mlwallet.MLWalletBusinessLogic MLWalletBusinessLogic;
    public static CashOutVia_BranchClass cashOutVia_branchClass;


    @Parameters({"deviceName","portno"})
    @BeforeMethod
    public void before(String deviceName,String portno) throws Exception {
        AppiumServer.startServer();
        MLWalletCashOutViaBranch.deviceName=deviceName;
        MLWalletCashOutViaBranch.portno= portno;
//        MLWalletBusinessLogic = new MLWalletBusinessLogic("MLWallet",deviceName,portno);
        cashOutVia_branchClass = new CashOutVia_BranchClass("MLWallet",deviceName,portno);

    }
    //============================================================================================================//
    @Test(priority = 1)
    public void cashOutWithdrawBranch_WM_TC_05() throws Exception
    {
        cashOutVia_branchClass.cashOutWithdrawBranch_WM_TC_05();
    }

    @Test(priority = 2)
    public void cashOutMaxLimit_WM_TC_06() throws Exception
    {
        cashOutVia_branchClass.cashOutMaxLimit_WM_TC_06();
    }

    @Test(priority = 3)
    public void cashOutInsufficientBalance_WM_TC_07() throws Exception {
        cashOutVia_branchClass.cashOutInsufficientBalance_WM_TC_07();
    }

    @Test(priority = 4)
    public void cashOutBuyerTierLevelAcc_WM_TC_09() throws Exception
    {
        cashOutVia_branchClass.cashOutBuyerTierLevelAcc_WM_TC_09();
    }

//=========================== Phase 2=================================================================//
@Test(priority = 5)
public void cashOutUIValidation_WM_TC_16() throws Exception {
    cashOutVia_branchClass.cashOutUIValidation_WM_TC_16();
}

    @Test(priority = 6)
    public void cashOutWithdrawBackBtnValidation_WM_TC_17() throws Exception {
        cashOutVia_branchClass.cashOutWithdrawBackBtnValidation_WM_TC_17();
    }

    @Test(priority = 7)
    public void cashOutToBranchUIValidation_WM_TC_18() throws Exception {
        cashOutVia_branchClass.cashOutToBranchUIValidation_WM_TC_18();
    }

    @Test(priority = 8)
    public void cashOutToBranchBackBtnValidation_WM_TC_19 () throws Exception {
        cashOutVia_branchClass.cashOutToBranchBackBtnValidation_WM_TC_19();
    }
    @Test(priority = 9)
    public void cashOutMlBranchQRPageUIValidation_WM_TC_22() throws Exception {
        cashOutVia_branchClass.cashOutMlBranchQRPageUIValidation_WM_TC_22();
    }

    @Test(priority = 10)
    public void cashOutCancelIconValidation_WM_TC_23() throws Exception {
        cashOutVia_branchClass.cashOutCancelIconValidation_WM_TC_23();
    }
    @Test(priority = 11)
    public void cashOutMLBranchSemiVerifiedTier_WM_TC_31() throws Exception {
            cashOutVia_branchClass.cashOutMLBranchSemiVerifiedTier_WM_TC_31();
    }

    @Test(priority = 12)
    public void cashOutMLBranchFullyVerifiedTier_WM_TC_32() throws Exception {
        cashOutVia_branchClass.cashOutMLBranchFullyVerifiedTier_WM_TC_32();
    }
    @Test(priority = 13)
    public void cashOutMLBranchMaxLimitSemiVerifiedTier_WM_TC_39() throws Exception {
        cashOutVia_branchClass.cashOutMLBranchMaxLimitSemiVerifiedTier_WM_TC_39();
    }

    @Test(priority = 14)
    public void cashOutMLBranchMaxLimitFullyVerifiedTier_WM_TC_42() throws Exception {
        cashOutVia_branchClass.cashOutMLBranchMaxLimitFullyVerifiedTier_WM_TC_42();
    }
    @Test(priority = 15)
    public void cashOutMLBranchBackToHomeBtnValidation_WM_TC_54() throws Exception {
        cashOutVia_branchClass.cashOutMLBranchBackToHomeBtnValidation_WM_TC_54();
    }

    @Test(priority = 16)
    public void cashOutMLBranchNewTransactionBtnValidation_WM_TC_55() throws Exception {
        cashOutVia_branchClass.cashOutMLBranchNewTransactionBtnValidation_WM_TC_55();
    }
    @Test(priority = 17)
    public void cashOutMLBranchOTPPageUiValidation_WM_TC_60() throws Exception {
        cashOutVia_branchClass.cashOutMLBranchOTPPageUiValidation_WM_TC_60();
    }

    @Test(priority = 18)
    public void cashOutMLBranchTransactionDetailsUIValidation_WM_TC_61() throws Exception {
        cashOutVia_branchClass.cashOutMLBranchTransactionDetailsUIValidation_WM_TC_61();
    }
    @Test(priority = 19)
    public void cashOutBranchLocationPopupValidation_WM_TC_74() throws Exception {
        cashOutVia_branchClass.cashOutBranchLocationPopupValidation_WM_TC_74("10");
    }

    @Test(priority = 20)
    public void cashOutBranchLocationDenyFunctionality_WM_TC_75() throws Exception {
        cashOutVia_branchClass.cashOutBranchLocationDenyFunctionality_WM_TC_75("10");
    }

    @Test(priority = 21)
    public void cashOutBranchLocationPermissionDenyCloseBtnFunctionality_WM_TC_76() throws Exception {
        cashOutVia_branchClass.cashOutBranchLocationPermissionDenyCloseBtnFunctionality_WM_TC_76("10");
    }

    @Test(priority = 22)
    public void cashOutBranchLocationPermissionDenyOpenSettingsBtnFunctionality_WM_TC_77() throws Exception {
        cashOutVia_branchClass.cashOutBranchLocationPermissionDenyOpenSettingsBtnFunctionality_WM_TC_77("10");
    }

    @Test(priority = 23)
    public void cashOutBranchLocationPopUpAllowFunctionality_WM_TC_78() throws Exception {
        cashOutVia_branchClass.cashOutBranchLocationPopUpAllowFunctionality_WM_TC_78("10");
    } @Test(priority = 24)
    public void cashOutBranchInternetInterruptionWhileEnteringOTP_WM_TC_80() throws Exception {
        cashOutVia_branchClass.cashOutBranchInternetInterruptionWhileEnteringOTP_WM_TC_80("10");
    }
    @Test(priority = 25)
    public void cashOutBranchTransactionValidationAfterMinimizingApp_WM_TC_91() throws Exception {
        cashOutVia_branchClass.cashOutBranchTransactionValidationAfterMinimizingApp_WM_TC_91();
    }

    @Test(priority = 26)
    public void cashOutBranchMaximumTransactionBranchVerifiedTier_WM_TC_08() throws Exception {
        cashOutVia_branchClass.cashOutBranchMaximumTransactionBranchVerifiedTier_WM_TC_08();
    }  @Test(priority = 27)
    public void cashOutBranchAmountFieldValidation_WM_TC_98() throws Exception {
        cashOutVia_branchClass.cashOutBranchAmountFieldValidation_WM_TC_98("100.123");
    }@Test(priority = 28)
    public void cashOutBranchTransactionWithValidMLPin_WM_TC_100() throws Exception {
        cashOutVia_branchClass.cashOutBranchTransactionWithInValidMLPin_WM_TC_100("100");
    }

    @Test(priority = 29)
    public void cashOutBranchTransactionWithValidMLPin_WM_TC_106() throws Exception {
        cashOutVia_branchClass.cashOutBranchTransactionWithValidMLPin_WM_TC_106();
    }

    @Test(priority = 30)
    public void cashOutBranchTransactionWithInValidMLPin_WM_TC_107() throws Exception {
        cashOutVia_branchClass.cashOutBranchTransactionWithInValidMLPin_WM_TC_107();
    }

    @Test(priority = 31)
    public void cashOutBranchInAppOTPPopupValidation_WM_TC_113() throws Exception {
        cashOutVia_branchClass.cashOutBranchInAppOTPPopupValidation_WM_TC_113();
    }

    @Test(priority = 32)
    public void cashOutBranchTransactionInAppOTPPopupUIValidation_WM_TC_114() throws Exception {
        cashOutVia_branchClass.cashOutBranchTransactionInAppOTPPopupUIValidation_WM_TC_114();
    }

    @Test(priority = 33)
    public void cashOutBranchTransactionNewOTPAfterSixtySecondsValidation_WM_TC_115() throws Exception {
        cashOutVia_branchClass.cashOutBranchTransactionNewOTPAfterSixtySecondsValidation_WM_TC_115();
    }

    @Test(priority = 34)
    public void cashOutBranchTransactionOTPCancelBtnFunctionality_WM_TC_116() throws Exception {
        cashOutVia_branchClass.cashOutBranchTransactionOTPCancelBtnFunctionality_WM_TC_116();
    }

    @Test(priority = 35)
    public void cashOutBranchTransactionOTPContinueBtnFunctionality_WM_TC_117() throws Exception {
        cashOutVia_branchClass.cashOutBranchTransactionOTPContinueBtnFunctionality_WM_TC_117();
    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }

}
