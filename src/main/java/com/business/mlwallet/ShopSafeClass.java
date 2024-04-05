package com.business.mlwallet;

import com.mlwallet.pages.MLWalletHomePage;
import com.mlwallet.pages.MLWalletShopSafePage;
import com.utility.ExtentReporter;

import static com.utility.Utilities.*;
import static com.utility.Utilities.getText;

public class ShopSafeClass extends BaseClass {
    public ShopSafeClass() {
        super();

    }
    //--------------------Positive Test--------------------
    public void SSM_TC_01_Verify_if_the_Shop_Safe_button_Icon_Visible() throws Exception {
        ExtentReporter.HeaderChildNode("To verify if the Shop Safe button Icon Visible");

        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        verifyElementPresent(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        logger.info("Shop Safe Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_01", "To verify if the Shop Safe button Icon Visible");
    }
    public void SSM_TC_02_Verify_click_Shop_Safe_button_Redirect_to_Shop_Safe_Page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify click Shop Safe button Redirect to Shop Safe Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        if(verifyElementPresent(MLWalletShopSafePage.objShopSafeLabel,"Shop Safe Page")){
            verifyElementPresent(MLWalletShopSafePage.objStartTransactBtn,"Start Transaction Button");
            verifyElementPresent(MLWalletShopSafePage.objInvitesLabel,"Invites Label");
            verifyElementPresent(MLWalletShopSafePage.objOngoingTransactLabel,"Ongoing Transaction Label");
            verifyElementPresent(MLWalletShopSafePage.objCompletedTransactLabel,"Completed Transaction Label");
            verifyElementPresent(MLWalletShopSafePage.objCancelledTransactLabel,"Cancelled Transact Label");
            verifyElementPresent(MLWalletShopSafePage.objReturnedTransactLabel,"Returned Transaction Label");
            verifyElementPresent(MLWalletShopSafePage.objInvitesTransactTxtBtn,"Invites Transaction Text Button");
            verifyElementPresent(MLWalletShopSafePage.objOngoingTransactTxtBtn,"Ongoing Transaction Text Button");
        }
        logger.info("Redirect to Shop Safe Page Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_02", "To verify click Shop Safe button Redirect to Shop Safe Page");
    }

    public void SSM_TC_03_Verify_click_Start_Transaction_button_Redirect_to_Create_Transaction_Page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify click Start Transaction button Redirect to Create Transaction Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objStartTransactBtn,"Start Transaction Button");
        if(verifyElementPresent(MLWalletShopSafePage.objCreateTransactLabel,"Start Transaction Button")){
            verifyElementPresent(MLWalletShopSafePage.objBackBtn,"Back Button");
            verifyElementPresent(MLWalletShopSafePage.objSellerNoTxtbx,"Seller Number Textbox");
            verifyElementPresent(MLWalletShopSafePage.objInviteSellerBtn,"Invite Seller Button");
        }
        logger.info("Redirect to Create Transaction Page Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_03", "To verify click Start Transaction button Redirect to Create Transaction Page");
    }

    public void SSM_TC_04_Verify_enter_valid_seller_number_in_Create_Transaction_Page() throws Exception {
        ExtentReporter.HeaderChildNode("To verify enter valid seller number in Create Transaction Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objStartTransactBtn,"Start Transaction Button");
        verifyElementPresent(MLWalletShopSafePage.objCreateTransactLabel,"Start Transaction Button");
        verifyElementPresent(MLWalletShopSafePage.objBackBtn,"Back Button");
        verifyElementPresent(MLWalletShopSafePage.objSellerNoTxtbx,"Seller Number Textbox");
        type(MLWalletShopSafePage.objSellerNoTxtbx, shopsafeprop.getproperty("VaildShopSafeNumber"), "Type Valid Number");
        click(MLWalletShopSafePage.objInviteSellerBtn,"Invite Seller Button");
        if(verifyElementPresent(MLWalletShopSafePage.objSuccessfInviteLabel,"Successful Invite")){
            verifyElementPresent(MLWalletShopSafePage.objOkayBtn,"Okay Button");
        }
        logger.info("Enter valid seller number in Create Transaction Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_04", "To verify enter valid seller number in Create Transaction Page");
    }

    public void SSM_TC_05_Verify_buyer_request_invites_click_View_Invitations_Button_in_Invites_Page () throws Exception {
        ExtentReporter.HeaderChildNode("To verify buyer request invites click View Invitations Button in Invites Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objInvitesTransactTxtBtn,"View all Invites Text Button");
        if(verifyElementPresentAndClick(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list")){
            verifyElementPresent(MLWalletShopSafePage.objBuyerDetailsLabel,"Buyer Details Label");
            verifyElementPresent(MLWalletShopSafePage.objBuyerNameVal,"Buyer Name Value");
            verifyElementPresent(MLWalletShopSafePage.objBuyerNoVal,"Buyer Number Value");
            verifyElementPresent(MLWalletShopSafePage.objSellerDetailsLabel,"Seller Details Label");
            verifyElementPresent(MLWalletShopSafePage.objSellerNoVal,"Seller Number Value");
            verifyElementPresent(MLWalletShopSafePage.objCancelInviteBtn,"Cancel Invite Button");
            verifyElementPresent(MLWalletShopSafePage.objBackToHomesBtn,"Back To Homes Button");
        }
        logger.info("View buyer request new invitations in Invites Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_05", "To verify buyer request invites click View Invitations Button in Invites Page");
    }
    public void SSM_TC_06_Verify_seller_received_invites_click_View_Invitations_Button_in_Invites_Page () throws Exception {
        ExtentReporter.HeaderChildNode("To verify seller received invites click View Invitations Button in Invites Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objInvitesTransactTxtBtn,"View all Invites Text Button");
        if(verifyElementPresentAndClick(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list")){
            verifyElementPresent(MLWalletShopSafePage.objPicOfItemBtn,"Picture Of Item Button");
            verifyElementPresent(MLWalletShopSafePage.objItemNameTxtBx,"Item Name textbox");
            verifyElementPresent(MLWalletShopSafePage.objItemDescriptTxtBx,"Item Description TextBox");
            verifyElementPresent(MLWalletShopSafePage.objBrandTxtBx,"Brand TextBox");
            verifyElementPresent(MLWalletShopSafePage.objModelNoTxtbox,"Model No TextBox");
            verifyElementPresent(MLWalletShopSafePage.objItemQuantityTxtbx,"Item Quantity Textbx");
            verifyElementPresent(MLWalletShopSafePage.objCategoryDropDownlist,"Category DropDownlist");
            verifyElementPresent(MLWalletShopSafePage.objItemPriceTxtbx,"Item Price Textbox");
            verifyElementPresent(MLWalletShopSafePage.objWeightRangeDropDownList,"Weight Range DropDownList");
            verifyElementPresent(MLWalletShopSafePage.objNearestDropOffGMap,"Nearest Drop Off GMap");
            verifyElementPresent(MLWalletShopSafePage.objProceedsBtn,"Proceeds Button");
            verifyElementPresent(MLWalletShopSafePage.objDeclineBtn,"Decline Button");
        }
        logger.info("View new invitations in Invites Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_05", "To verify seller received invites click View Invitations Button in Invites Page");
    }

    public void Camera()throws Exception{
        click(MLWalletShopSafePage.objPicOfItemBtn,"Picture Of Item Button");
        click(MLWalletShopSafePage.objCameraBtn,"Camera Button");
        if(verifyElementDisplayed(MLWalletShopSafePage.objAllowCameraWhileUsingAppBtn)){
            click(MLWalletShopSafePage.objAllowCameraWhileUsingAppBtn,"Allow Camera");
        }
        click(MLWalletShopSafePage.objTakeAPicBtn,"Take a Photo Button");
        click(MLWalletShopSafePage.objTakeAPicOkBtn,"Photo OK Button");
    }

    public void DropOff() throws Exception{
        click(MLWalletShopSafePage.objNearestDropOffGMap,"Nearest Drop Off GMap");
        click(MLWalletShopSafePage.objAllowWhileUsingAppBtn,"Allow G Map");
        PartialZoomOutInConsumptionScreen(1);
        click(MLWalletShopSafePage.objSelectNearest,"Select Near");
        click(MLWalletShopSafePage.objConfirmBranchBtn,"Confirm Branch Button");
    }
    public void VerifyConfirmationPage() throws Exception{
        verifyElementPresent(MLWalletShopSafePage.objConfirmDetailsPage,"Confirmation Page");
        verifyElementPresent(MLWalletShopSafePage.objPicture,"Picture ");
        verifyElementPresent(MLWalletShopSafePage.objRFTN,"RFTN");
        verifyElementPresent(MLWalletShopSafePage.objSellersDetailLabel,"Sellers Detail");
        verifyElementPresent(MLWalletShopSafePage.objSellersNameVal,"Sellers Name");
        verifyElementPresent(MLWalletShopSafePage.objSellersNoVal,"Sellers Number");
        verifyElementPresent(MLWalletShopSafePage.objBuyersDetailLabel,"Buyers Detail");
        verifyElementPresent(MLWalletShopSafePage.objBuyersNameVal,"Buyers Name");
        verifyElementPresent(MLWalletShopSafePage.objBuyersNoVal,"Buyers No");
        verifyElementPresent(MLWalletShopSafePage.objItemDetailsLabel,"Item Details");
        verifyElementPresent(MLWalletShopSafePage.objItemNameVal,"Item Name");
        verifyElementPresent(MLWalletShopSafePage.objItemDescriptVal,"Item Description");
        verifyElementPresent(MLWalletShopSafePage.objBrandVal,"Brand");
        verifyElementPresent(MLWalletShopSafePage.objModelNoVal,"Mode Number");
        verifyElementPresent(MLWalletShopSafePage.objCategoryVal,"Category");
        verifyElementPresent(MLWalletShopSafePage.objItemPriceVal,"Item Price");
        verifyElementPresent(MLWalletShopSafePage.objShipDetailLabel,"Ship Detail");
        verifyElementPresent(MLWalletShopSafePage.objOriginBranchVal,"Origin Branch");
        verifyElementPresent(MLWalletShopSafePage.objConfirmInvitationBtn,"Confirm Invitation");
        verifyElementPresent(MLWalletShopSafePage.objBacksBtn,"Back Button");
    }
    public void FillItemInformation() throws Exception{
        type(MLWalletShopSafePage.objItemNameTxtBx, shopsafeprop.getproperty("ValidItemName"), "Type Item Name");
        type(MLWalletShopSafePage.objItemDescriptTxtBx, shopsafeprop.getproperty("ValidItemDescript"), "Type Item Description");
        type(MLWalletShopSafePage.objBrandTxtBx, shopsafeprop.getproperty("ValidBrand"), "Type Brand");
        type(MLWalletShopSafePage.objModelNoTxtbox, shopsafeprop.getproperty("ValidModelNo"), "Type Model No");
        type(MLWalletShopSafePage.objItemQuantityTxtbx, shopsafeprop.getproperty("ValidItemQuantity"), "Type Item Quantity");
        click(MLWalletShopSafePage.objCategoryDropDownlist,"Category DropDownlist");
        click(MLWalletShopSafePage.objClothesTxtBtn,"Select Clothes");
        type(MLWalletShopSafePage.objItemPriceTxtbx, shopsafeprop.getproperty("ValidItemPrice"), "Type Item Price");
        click(MLWalletShopSafePage.objWeightRangeDropDownList,"Weight Range DropDownList");
        click(MLWalletShopSafePage.obj0kgTxtBtn, "Select 0 to 3 kg");
    }
    public void SSM_TC_07_Verify_seller_fill_up_the_Item_Information_Page_and_clicking_proceed_button_Invites_Page () throws Exception {
        ExtentReporter.HeaderChildNode("To verify seller received invites click View Invitations Button in Invites Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objInvitesTransactTxtBtn,"View all Invites Text Button");
        click(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list");
        Camera();
        Camera();
        FillItemInformation();
        DropOff();
        click(MLWalletShopSafePage.objProceedsBtn,"Proceeds Button");
        VerifyConfirmationPage();

        logger.info("View new invitations in Invites Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_05", "To verify seller received invites click View Invitations Button in Invites Page");
    }

    public void VerifyTransactionPage() throws Exception{
        verifyElementPresent(MLWalletShopSafePage.objRFTN,"RFTN");
        verifyElementPresent(MLWalletShopSafePage.objSellersDetailTransactLabel,"Sellers Detail");
        verifyElementPresent(MLWalletShopSafePage.objSellersNameTransactVal,"Sellers Name");
        verifyElementPresent(MLWalletShopSafePage.objSellersNoTransactVal,"Sellers Number");
        verifyElementPresent(MLWalletShopSafePage.objBuyersDetailTransactLabel,"Buyers Detail");
        verifyElementPresent(MLWalletShopSafePage.objBuyersNameTransactVal,"Buyers Name");
        verifyElementPresent(MLWalletShopSafePage.objBuyersNoTransactVal,"Buyers No");
        verifyElementPresent(MLWalletShopSafePage.objItemDetailsTransactLabel,"Item Details");
        verifyElementPresent(MLWalletShopSafePage.objItemNameTransactVal,"Item Name");
        verifyElementPresent(MLWalletShopSafePage.objItemDescriptTransactVal,"Item Description");
        verifyElementPresent(MLWalletShopSafePage.objBrandTransactVal,"Brand");
        verifyElementPresent(MLWalletShopSafePage.objModelNoTransactVal,"Mode Number");
        verifyElementPresent(MLWalletShopSafePage.objCategoryTransactVal,"Category");
        verifyElementPresent(MLWalletShopSafePage.objItemPriceTransactVal,"Item Price");
        verifyElementPresent(MLWalletShopSafePage.objShipDetailTransactLabel,"Ship Detail");
        verifyElementPresent(MLWalletShopSafePage.objOriginBranchTransactVal,"Origin Branch");
        verifyElementPresent(MLWalletShopSafePage.objPictureTransact,"Picture ");
    }
    public void SSM_TC_08_Verify_seller_fill_up_the_Item_Information_Page_and_clicking_proceed_button_Invites_Page () throws Exception {
        ExtentReporter.HeaderChildNode("To verify seller received invites click View Invitations Button in Invites Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objInvitesTransactTxtBtn,"View all Invites Text Button");
        click(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list");
        Camera();
        Camera();
        FillItemInformation();
        DropOff();
        click(MLWalletShopSafePage.objProceedsBtn,"Proceeds Button");
        click(MLWalletShopSafePage.objConfirmInvitationBtn,"Confirm Invitation");
        VerifyTransactionPage();

        logger.info("View new invitations in Invites Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_05", "To verify seller received invites click View Invitations Button in Invites Page");
    }




    //--------------------Negative Test--------------------
    public void SSM_TC_100_Validate_back_button_to_Shop_Safe_Page_back_to_Dashboard() throws Exception {
        ExtentReporter.HeaderChildNode("Validate back button to Shop Safe Page back to Dashboard");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objBackBtn, "Back Button");
        verifyElementPresent(MLWalletHomePage.objAvailableBalance," Available Text");
        verifyElementPresent(MLWalletHomePage.objEyeIcon,"Eye Icon");
        logger.info("Redirect back to Dashboard Page Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_03", "Validate back button to Shop Safe Page back to Dashboard");
    }
    public void SSM_TC_101_Validate_back_button_to_Create_Transaction_Page_back_to_Shop_Safe_page() throws Exception {
        ExtentReporter.HeaderChildNode("Validate back button to Create Transaction Page back to Shop Safe page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objStartTransactBtn, "Start Transaction Button");
        click(MLWalletShopSafePage.objBackBtn, "Back Button");
        verifyElementPresent(MLWalletShopSafePage.objShopSafeLabel, "Shop Safe Label");
        verifyElementPresent(MLWalletShopSafePage.objStartTransactBtn, "Start Transaction Button");
        logger.info("Redirect back to Shop Safe Page Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_03", "Validate back button to Create Transaction Page back to Shop Safe page");
    }
    public void SSM_TC_102_Validate_back_button_to_Invites_Page_back_to_Shop_Safe_page() throws Exception {
        ExtentReporter.HeaderChildNode("Validate back button to Invites Page back to Shop Safe page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objInvitesTransactTxtBtn, "View All Invites Button");
        click(MLWalletShopSafePage.objBackBtn, "Back Button");
        verifyElementPresent(MLWalletShopSafePage.objShopSafeLabel, "Shop Safe Label");
        logger.info("Redirect back to Shop Safe Page Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_03", "Validate back button to Invites Page back to Shop Safe page");
    }

    public void SSM_TC_103_Validate_back_button_to_Invitation_Request_back_to_Shop_Invites_Page() throws Exception {
        ExtentReporter.HeaderChildNode("Validate back button to Invitation Request back to Invites Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objInvitesTransactTxtBtn, "View All Invites Button");
        click(MLWalletShopSafePage.objFirstInTab,"New Invitation");
        click(MLWalletShopSafePage.objBackBtn, "Back Button");
        verifyElementPresent(MLWalletShopSafePage.objShopSafeLabel, "Shop Safe Label");
        logger.info("Redirect back to Invites Page Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_03", "Validate back button to Invitation Request back to Invites Page");
    }

    public void SSM_TC_104_Validate_back_button_to_Shop_Ongoing_Transaction_Page_back_to_Shop_Safe_Page() throws Exception {
        ExtentReporter.HeaderChildNode("Validate back button to Ongoing Transaction Page back to Shop Safe Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objOngoingTransactTxtBtn, "View All Invites Button");
        click(MLWalletShopSafePage.objBackBtn, "Back Button");
        verifyElementPresent(MLWalletShopSafePage.objShopSafeLabel, "Shop Safe Label");
        verifyElementPresent(MLWalletShopSafePage.objStartTransactBtn, "Start Transaction Button");
        logger.info("Redirect back to Dashboard Page Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_03", "Validate back button to Ongoing Transaction Page back to Shop Safe Page");
    }
    //--------------------Invalid Input textbox
    public void SSM_TC_150_Validate_enter_characters_seller_number_in_Create_Transaction_Page() throws Exception {
        ExtentReporter.HeaderChildNode("Validate enter characters seller number in Create Transaction Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objStartTransactBtn, "Start Transaction Button");
        type(MLWalletShopSafePage.objSellerNoTxtbx, shopsafeprop.getproperty("CharacterNumber"), "Enter Character");
        click(MLWalletShopSafePage.objInviteSellerBtn, "Invite Seller Button");
        assertionValidation(getText(MLWalletShopSafePage.objGetErrMsg(shopsafeprop.getproperty("InvalidMobileNum"))), shopsafeprop.getproperty("InvalidMobileNum"));
        logger.info("Prompt Display should be Mobile number is invalid");
        ExtentReporter.extentLoggerPass("SSM_TC_03", "Validate enter characters seller number in Create Transaction Page");
    }

    public void SSM_TC_151_Validate_enter_decimal_seller_number_in_Create_Transaction_Page() throws Exception {
        ExtentReporter.HeaderChildNode("Validate enter decimal seller number in Create Transaction Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objStartTransactBtn, "Start Transaction Button");
        type(MLWalletShopSafePage.objSellerNoTxtbx, shopsafeprop.getproperty("DecimalNumber"), "Enter Decimal");
        click(MLWalletShopSafePage.objInviteSellerBtn, "Invite Seller Button");
        assertionValidation(getText(MLWalletShopSafePage.objGetErrMsg(shopsafeprop.getproperty("InvalidMobileNum"))), shopsafeprop.getproperty("InvalidMobileNum"));
        logger.info("Prompt Display should be Mobile number is invalid");
        ExtentReporter.extentLoggerPass("SSM_TC_03", "Validate enter decimal seller number in Create Transaction Page");
    }

    public void SSM_TC_152_Validate_enter_empty_seller_number_in_Create_Transaction_Page() throws Exception {
        ExtentReporter.HeaderChildNode("Validate enter empty seller number in Create Transaction Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objStartTransactBtn, "Start Transaction Button");
        click(MLWalletShopSafePage.objInviteSellerBtn, "Invite Seller Button");
        assertionValidation(getText(MLWalletShopSafePage.objGetErrMsg(shopsafeprop.getproperty("EmptyMobileNum"))), shopsafeprop.getproperty("EmptyMobileNum"));
        logger.info("Prompt Display should be Mobile number is required");
        ExtentReporter.extentLoggerPass("SSM_TC_03", "Validate enter empty seller number in Create Transaction Page");
    }
}
