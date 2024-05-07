package com.mlwallet.regression;

import com.driverInstance.AppiumServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class MLWalletShopSafeScripts extends BaseTest{

    //--------------Positive Test
//    @Test(priority = 1)
//    public void SSM_TC_01_Verify_if_the_Shop_Safe_button_Icon_Visible() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_01_Verify_if_the_Shop_Safe_button_Icon_Visible();
//    }
//    @Test(priority = 2)
//    public void SSM_TC_02_Verify_click_Shop_Safe_button_Redirect_to_Shop_Safe_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_02_Verify_click_Shop_Safe_button_Redirect_to_Shop_Safe_Page();
//    }
//    @Test(priority = 3)
//    public void SSM_TC_03_Verify_click_Start_Transaction_button_Redirect_to_Create_Transaction_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_03_Verify_click_Start_Transaction_button_Redirect_to_Create_Transaction_Page();
//    }
//    @Test(priority = 4)
//    public void SSM_TC_04_Verify_enter_valid_seller_number_in_Create_Transaction_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_04_Verify_enter_valid_seller_number_in_Create_Transaction_Page();
//    }
//    @Test(priority = 5)
//    public void SSM_TC_05_Verify_buyer_request_invites_click_View_Invitations_Button_in_Invites_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_05_Verify_buyer_request_invites_click_View_Invitations_Button_in_Invites_Page();
//    }
//    @Test(priority = 6)
//    public void SSM_TC_06_Verify_seller_received_invites_click_View_Invitations_Button_in_Invites_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_06_Verify_seller_received_invites_click_View_Invitations_Button_in_Invites_Page();
//    }
//    @Test(priority = 7)
//    public void SSM_TC_07_Verify_seller_fill_up_the_Item_Information_Page_and_clicking_proceed_button_Invites_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_07_Verify_seller_fill_up_the_Item_Information_Page_and_clicking_proceed_button_Invites_Page();
//    }
//    @Test(priority = 8)
//    public void SSM_TC_08_Verify_seller_fill_up_the_Item_Information_Page_and_clicking_proceed_button_Invites_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_08_Verify_seller_fill_up_the_Item_Information_Page_and_clicking_proceed_button_Invites_Page ();
//    }
//    @Test(priority = 9)
//    public void SSM_TC_09_Validate_Seller_Ongoing_Transaction_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_09_Validate_Seller_Ongoing_Transaction_Page ();
//    }
//    @Test(priority = 10)
//    public void SSM_TC_10_Validate_Seller_Ongoing_Transaction_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_10_Validate_Seller_Ongoing_Transaction_Page ();
//    }
    @Test(priority = 11)
    public void SSM_TC_11_Verify_seller_fill_up_the_Item_Information_Page_and_clicking_proceed_button_Invites_Page() throws Exception {
        mlWalletShopSafeScripts.SSM_TC_11_Verify_seller_fill_up_the_Item_Information_Page_and_clicking_proceed_button_Invites_Page();
    }


    //=================Negative
//    @Test(priority = 1)
//    public void SSM_TC_100_Validate_back_button_to_Shop_Safe_Page_back_to_Dashboard() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_100_Validate_back_button_to_Shop_Safe_Page_back_to_Dashboard ();
//    }
//    @Test(priority = 2)
//    public void SSM_TC_101_Validate_back_button_to_Create_Transaction_Page_back_to_Shop_Safe_page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_101_Validate_back_button_to_Create_Transaction_Page_back_to_Shop_Safe_page ();
//    }
//        @Test(priority = 3)
//    public void SSM_TC_102_Validate_back_button_to_Invites_Page_back_to_Shop_Safe_page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_102_Validate_back_button_to_Invites_Page_back_to_Shop_Safe_page ();
//    }
//    @Test(priority = 4)
//    public void SSM_TC_103_Validate_back_button_to_Invitation_Request_back_to_Shop_Invites_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_103_Validate_back_button_to_Invitation_Request_back_to_Shop_Invites_Page ();
//    }
//    @Test(priority = 5)
//    public void SSM_TC_104_Validate_back_button_to_Shop_Ongoing_Transaction_Page_back_to_Shop_Safe_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_104_Validate_back_button_to_Shop_Ongoing_Transaction_Page_back_to_Shop_Safe_Page ();
//    }
//    @Test(priority = 6)
//    public void SSM_TC_150_Validate_enter_characters_seller_number_in_Create_Transaction_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_150_Validate_enter_characters_seller_number_in_Create_Transaction_Page ();
//    }
//    @Test(priority = 7)
//    public void SSM_TC_151_Validate_enter_decimal_seller_number_in_Create_Transaction_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_151_Validate_enter_decimal_seller_number_in_Create_Transaction_Page ();
//    }
//    @Test(priority = 8)
//    public void SSM_TC_152_Validate_enter_empty_seller_number_in_Create_Transaction_Page() throws Exception {
//        mlWalletShopSafeScripts.SSM_TC_152_Validate_enter_empty_seller_number_in_Create_Transaction_Page ();
//    }

    @AfterMethod
    public void afterMethod(){
        AppiumServer.stopServer();
    }
}
