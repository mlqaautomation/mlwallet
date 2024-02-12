package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MLWalletGcash extends BaseTest{

    @Test(priority = 1)
    public void GC_Land_TC_02()throws Exception{
        mlWalletGCash.GC_Land_TC_02();
<<<<<<< Updated upstream
=======
    }
    @Test(priority = 2)
    public void GC_SM_TC_43()throws Exception{
        mlWalletGCash.GC_SM_TC_43();
    }
    @Test(priority = 3)
    public void GC_SM_TC_132_SendMoney_as_SemiVerified()throws Exception{
        mlWalletGCash.GC_SM_TC_132_SendMoney_as_SemiVerified();
>>>>>>> Stashed changes
    }
    @Test(priority = 4)
    public void GC_RM_TC_135_SendMoney_as_BranchVerified()throws Exception{
        mlWalletGCash.GC_RM_TC_135_SendMoney_as_BranchVerified();
    }
    @Test(priority = 5)
    public void GC_SM_TC_49_EmptyReceiverNumber_ErrorMsg_Validation()throws Exception{
        mlWalletGCash.GC_SM_TC_49_EmptyReceiverNumber_ErrorMsg_Validation();
    }
    @Test(priority = 6)
    public void GC_SM_TC_50_InvalidReceiverNumber_ErrorMsg_Validation()throws Exception{
        mlWalletGCash.GC_SM_TC_50_InvalidReceiverNumber_ErrorMsg_Validation();
    }
    @Test(priority = 7)
    public void GC_SM_TC_51_InvalidReceiverNumber_ErrorMsg_Validation()throws Exception{
        mlWalletGCash.GC_SM_TC_51_InvalidReceiverNumber_ErrorMsg_Validation();
    }
    @Test(priority = 8)
    public void GC_SM_TC_54_MoreThanTwoDecimal_ErrorMsg_Validation()throws Exception{
        mlWalletGCash.GC_SM_TC_54_MoreThanTwoDecimal_ErrorMsg_Validation();
    }
    @Test(priority = 9)
    public void GC_SM_TC_56_RedirectBack_ToGcashServices_From_SendMoney_Validation()throws Exception{
        mlWalletGCash.GC_SM_TC_56_RedirectBack_ToGcashServices_From_SendMoney_Validation();
    }
    @Test(priority = 10)
    public void GC_SM_TC_57_SendMoneytoGcash_LessThan_One_Validation()throws Exception{
        mlWalletGCash.GC_SM_TC_57_SendMoneytoGcash_LessThan_One_Validation();
    }
    @Test(priority = 11)
    public void GC_SM_TC_59_RedirectBack_SendMoneytoGcash_From_ConfirmDetails_Validation()throws Exception{
        mlWalletGCash.GC_SM_TC_59_RedirectBack_SendMoneytoGcash_From_ConfirmDetails_Validation();
    }
    @Test(priority = 12)
    public void GC_SM_TC_60_InAppOtp_Page_Redirection_Validation()throws Exception{
        mlWalletGCash.GC_SM_TC_60_InAppOtp_Page_Redirection_Validation();
    }
    @Test(priority = 13)
    public void GC_SM_TC_61_ValidateSMSOTP_Redirect_SendMoney_to_Gcash_Details_Page()throws Exception{
        mlWalletGCash.GC_SM_TC_61_ValidateSMSOTP_Redirect_SendMoney_to_Gcash_Details_Page();
    }
    @Test(priority = 14)
    public void GC_SM_TC_64_CancelOTP_Redirect_SendMoney_to_Gcash_Mobile_Entry()throws Exception{
        mlWalletGCash.GC_SM_TC_64_CancelOTP_Redirect_SendMoney_to_Gcash_Mobile_Entry();
    }
    @Test(priority = 15)
    public void GC_SM_TC_69_ValidateSMSOTP_One_time_Pin_GCash_Send_Money()throws Exception{
        mlWalletGCash.GC_SM_TC_69_ValidateSMSOTP_One_time_Pin_GCash_Send_Money();
    }
    @Test(priority = 16)
    public void GC_SM_TC_70_ValidateSMSOTP_Mpin_GCash_Send_Money()throws Exception{
        mlWalletGCash.GC_SM_TC_70_ValidateSMSOTP_Mpin_GCash_Send_Money();
    }
    @Test(priority = 17)
    public void GC_SM_TC_72_ValidateSMSOTP_InApp_GCash_Send_Money()throws Exception{
        mlWalletGCash.GC_SM_TC_72_ValidateSMSOTP_InApp_GCash_Send_Money();
    }
    @Test(priority = 18)
    public void GC_SM_TC_73_Validate_Back_Btn_In_GCash_Transaction_Details_Page()throws Exception{
        mlWalletGCash.GC_SM_TC_73_Validate_Back_Btn_In_GCash_Transaction_Details_Page();
    }
    @Test(priority = 19)
    public void GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page()throws Exception{
        mlWalletGCash.GC_SM_TC_76_Validate_Back_Home_Btn_In_GCash_View_Recent_Transaction_Dashboard_Page();
    }
    @Test(priority = 20)
    public void GC_SM_TC_83_Validate_Transaction_Details_Match_User_Entered_Details()throws Exception{
        mlWalletGCash.GC_SM_TC_83_Validate_Transaction_Details_Match_User_Entered_Details();
    }
    @Test(priority = 21)
    public void GC_SM_TC_102_Validate_SendMoneyGCash_BuyerTier()throws Exception{
        mlWalletGCash.GC_SM_TC_102_Validate_SendMoneyGCash_BuyerTier();
    }
    @Test(priority = 22)
    public void GC_SM_TC_103_Validate_SendMoneyGCash50k_SemiVerified()throws Exception{
        mlWalletGCash.GC_SM_TC_103_Validate_SendMoneyGCash50k_SemiVerified();
    }
    @Test(priority = 23)
    public void GC_SM_TC_104_Validate_SendMoneyGCash50k_BranchVerified()throws Exception{
        mlWalletGCash.GC_SM_TC_104_Validate_SendMoneyGCash50k_BranchVerified();
    }
    @Test(priority = 24)
    public void GC_SM_TC_105_Validate_SendMoneyGCash50k_FullyVerified()throws Exception{
        mlWalletGCash.GC_SM_TC_105_Validate_SendMoneyGCash50k_FullyVerified();
    }
    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }
}
