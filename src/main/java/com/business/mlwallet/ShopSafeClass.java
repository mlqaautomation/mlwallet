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
            Swipe("UP", 3);
            verifyElementPresent(MLWalletShopSafePage.objCancelledTransactLabel,"Cancelled Transact Label");
            verifyElementPresent(MLWalletShopSafePage.objReturnedTransactLabel,"Returned Transaction Label");
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
        waitTime(3000);
        if(verifyElementPresent(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list")){
            click(MLWalletShopSafePage.objFirstInTab,"Click New Invitation in Invites list");
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
        mlWalletLogin(prop.getproperty("SS_Fully_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objInvitesTransactTxtBtn,"View all Invites Text Button");
        waitTime(3000);
        if(verifyElementPresent(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list")){
            click(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list");
            Swipe("UP", 1);
            verifyElementPresent(MLWalletShopSafePage.objPicOfItemBtn,"Picture Of Item Button");
            verifyElementPresent(MLWalletShopSafePage.objItemNameTxtBx,"Item Name textbox");
            Swipe("UP", 1);
            verifyElementPresent(MLWalletShopSafePage.objItemDescriptTxtBx,"Item Description TextBox");
            verifyElementPresent(MLWalletShopSafePage.objBrandTxtBx,"Brand TextBox");
            verifyElementPresent(MLWalletShopSafePage.objModelNoTxtbox,"Model No TextBox");
            verifyElementPresent(MLWalletShopSafePage.objItemQuantityTxtbx,"Item Quantity Textbx");
            verifyElementPresent(MLWalletShopSafePage.objCategoryDropDownlist,"Category DropDownlist");
            verifyElementPresent(MLWalletShopSafePage.objItemPriceTxtbx,"Item Price Textbox");
            Swipe("UP", 1);
            verifyElementPresent(MLWalletShopSafePage.objWeightRangeDropDownList,"Weight Range DropDownList");
            verifyElementPresent(MLWalletShopSafePage.objNearestDropOffGMap,"Nearest Drop Off GMap");
            Swipe("UP", 1);
            verifyElementPresent(MLWalletShopSafePage.objProceedsBtn,"Proceeds Button");
            verifyElementPresent(MLWalletShopSafePage.objDeclineBtn,"Decline Button");
        }
        logger.info("View new invitations in Invites Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_05", "To verify seller received invites click View Invitations Button in Invites Page");
    }

    public void Camera()throws Exception{
        Swipe("UP", 1);
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
        waitTime(3000);
        if(verifyElementDisplayed(MLWalletShopSafePage.objSelectNearest)){
            click(MLWalletShopSafePage.objSelectNearest, "Select Near");
        }
        verifyElementPresent(MLWalletShopSafePage.objBranchNameGMapVal,"");
        verifyElementPresent(MLWalletShopSafePage.objBranchAddressGMapVal,"");
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
        Swipe("UP", 1);
        verifyElementPresent(MLWalletShopSafePage.objItemDetailsLabel,"Item Details");
        verifyElementPresent(MLWalletShopSafePage.objItemNameVal,"Item Name");
        verifyElementPresent(MLWalletShopSafePage.objItemDescriptVal,"Item Description");
        verifyElementPresent(MLWalletShopSafePage.objBrandVal,"Brand");
        verifyElementPresent(MLWalletShopSafePage.objModelNoVal,"Mode Number");
        verifyElementPresent(MLWalletShopSafePage.objCategoryVal,"Category");
        verifyElementPresent(MLWalletShopSafePage.objItemPriceVal,"Item Price");
        Swipe("UP", 1);
        verifyElementPresent(MLWalletShopSafePage.objShipDetailLabel,"Ship Detail");
        verifyElementPresent(MLWalletShopSafePage.objOriginBranchVal,"Origin Branch");
        Swipe("UP", 1);
        verifyElementPresent(MLWalletShopSafePage.objConfirmInvitationBtn,"Confirm Invitation");
        verifyElementPresent(MLWalletShopSafePage.objBacksBtn,"Back Button");
    }
    public void FillItemInformation() throws Exception{
        Swipe("UP", 1);
        type(MLWalletShopSafePage.objItemNameTxtBx, shopsafeprop.getproperty("ValidItemName"), "Type Item Name");
        Swipe("UP", 1);
        type(MLWalletShopSafePage.objItemDescriptTxtBx, shopsafeprop.getproperty("ValidItemDescript"), "Type Item Description");
        type(MLWalletShopSafePage.objBrandTxtBx, shopsafeprop.getproperty("ValidBrand"), "Type Brand");
        type(MLWalletShopSafePage.objModelNoTxtbox, shopsafeprop.getproperty("ValidModelNo"), "Type Model No");
        type(MLWalletShopSafePage.objItemQuantityTxtbx, shopsafeprop.getproperty("ValidItemQuantity"), "Type Item Quantity");
        click(MLWalletShopSafePage.objCategoryDropDownlist,"Category DropDownlist");
        click(MLWalletShopSafePage.objClothesTxtBtn,"Select Clothes");
        type(MLWalletShopSafePage.objItemPriceTxtbx, shopsafeprop.getproperty("ValidItemPrice"), "Type Item Price");
        Swipe("UP", 1);
        click(MLWalletShopSafePage.objWeightRangeDropDownList,"Weight Range DropDownList");
        click(MLWalletShopSafePage.obj0kgTxtBtn, "Select 0 to 3 kg");
    }
    public void SSM_TC_07_Verify_seller_fill_up_the_Item_Information_Page_and_clicking_proceed_button_Invites_Page () throws Exception {
        ExtentReporter.HeaderChildNode("To verify seller received invites click View Invitations Button in Invites Page");
        mlWalletLogin(prop.getproperty("SS_Fully_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objInvitesTransactTxtBtn,"View all Invites Text Button");
        waitTime(3000);
        if(verifyElementPresent(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list")) {
            click(MLWalletShopSafePage.objFirstInTab, "New Invitation in Invites list");
            Camera();
            Swipe("UP", 1);
            Camera();
            FillItemInformation();
            DropOff();
            waitTime(1000);
            Swipe("UP", 1);
            click(MLWalletShopSafePage.objProceedsBtn, "Proceeds Button");
            VerifyConfirmationPage();
        }
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
        Swipe("UP", 1);
        verifyElementPresent(MLWalletShopSafePage.objItemDetailsTransactLabel,"Item Details");
        verifyElementPresent(MLWalletShopSafePage.objItemNameTransactVal,"Item Name");
        verifyElementPresent(MLWalletShopSafePage.objItemDescriptTransactVal,"Item Description");
        verifyElementPresent(MLWalletShopSafePage.objBrandTransactVal,"Brand");
        verifyElementPresent(MLWalletShopSafePage.objModelNoTransactVal,"Mode Number");
        verifyElementPresent(MLWalletShopSafePage.objCategoryTransactVal,"Category");
        verifyElementPresent(MLWalletShopSafePage.objItemPriceTransactVal,"Item Price");
        Swipe("UP", 1);
        verifyElementPresent(MLWalletShopSafePage.objShipDetailTransactLabel,"Ship Detail");
        verifyElementPresent(MLWalletShopSafePage.objOriginBranchTransactVal,"Origin Branch");
        Swipe("UP", 1);
        verifyElementPresent(MLWalletShopSafePage.objPictureTransact,"Picture ");
    }

    public void SSM_TC_08_Verify_seller_fill_up_the_Item_Information_Page_and_clicking_proceed_button_Invites_Page () throws Exception {
        ExtentReporter.HeaderChildNode("To verify seller received invites click View Invitations Button in Invites Page");
        mlWalletLogin(prop.getproperty("SS_Fully_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        click(MLWalletShopSafePage.objInvitesTransactTxtBtn,"View all Invites Text Button");
        waitTime(3000);
        click(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list");
        Camera();
        Swipe("UP", 1);
        Camera();
        FillItemInformation();
        DropOff();
        Swipe("UP", 1);
        waitTime(1000);
        Swipe("UP", 1);
        click(MLWalletShopSafePage.objProceedsBtn,"Proceeds Button");
        Swipe("UP", 3);
        click(MLWalletShopSafePage.objConfirmInvitationBtn,"Confirm Invitation");
        VerifyTransactionPage();

        logger.info("View new invitations in Invites Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_05", "To verify seller received invites click View Invitations Button in Invites Page");
    }

    public void validateBuyerOngoing() throws Exception{
        verifyElementPresent(MLWalletShopSafePage.objOngoingBuyerPicture,"Buyer Picture");
        verifyElementPresent(MLWalletShopSafePage.objOngoingRFTN,"Reference Number");
        verifyElementPresent(MLWalletShopSafePage.objOngoingellersDetailLabel,"Seller Detail Label");
        verifyElementPresent(MLWalletShopSafePage.objOngoingSellersNameVal,"Sellers Name");
        verifyElementPresent(MLWalletShopSafePage.objOngoingSellersNoVal,"Sellers No");
        verifyElementPresent(MLWalletShopSafePage.objOngoingBuyersDetailLabel,"Buyers Detail Label");
        verifyElementPresent(MLWalletShopSafePage.objOngoingBuyersNameVal,"Buyers Name");
        Swipe("UP", 1);
        verifyElementPresent(MLWalletShopSafePage.objOngoingBuyersNoVal,"Buyers No");
        verifyElementPresent(MLWalletShopSafePage.objOngoingItemDetailsLabel,"Item Details Label");
        verifyElementPresent(MLWalletShopSafePage.objOngoingItemNameVal,"Item Name");
        verifyElementPresent(MLWalletShopSafePage.objOngoingItemDescriptVal,"Item Description");
        verifyElementPresent(MLWalletShopSafePage.objOngoingBrandVal,"Brand");
        verifyElementPresent(MLWalletShopSafePage.objOngoingModelNoVal,"Model No");
        verifyElementPresent(MLWalletShopSafePage.objOngoingCategoryVal,"Category");
        verifyElementPresent(MLWalletShopSafePage.objOngoingItemPriceVal,"Item Price");
        Swipe("UP", 1);
        verifyElementPresent(MLWalletShopSafePage.objOngoingChooseNearestBranchBtn,"Choose Nearest Branch");
        verifyElementPresent(MLWalletShopSafePage.objOngoingProceedToReviewBtn,"Proceed To Review Btn");
        verifyElementPresent(MLWalletShopSafePage.objOngoingCancelBtn,"Cancel Btn");
    }

    public void validateSellerOngoing() throws Exception{

        verifyElementPresent(MLWalletShopSafePage.objOngoingWaitPaymentStatus,"Waiting For Payment Status");
        verifyElementPresent(MLWalletShopSafePage.objOngoingRFTN,"Reference Number");
        verifyElementPresent(MLWalletShopSafePage.objOngoingellersDetailLabel,"Seller Detail Label");
        verifyElementPresent(MLWalletShopSafePage.objOngoingSellersNameVal,"Sellers Name");
        verifyElementPresent(MLWalletShopSafePage.objOngoingSellersNoVal,"Sellers No");
        verifyElementPresent(MLWalletShopSafePage.objOngoingBuyersDetailLabel,"Buyers Detail Label");
        verifyElementPresent(MLWalletShopSafePage.objOngoingBuyersNameVal,"Buyers Name");
        verifyElementPresent(MLWalletShopSafePage.objOngoingBuyersNoVal,"Buyers No");
        verifyElementPresent(MLWalletShopSafePage.objOngoingItemDetailsLabel,"Item Details");
        verifyElementPresent(MLWalletShopSafePage.objOngoingItemNameVal,"Item Name");
        verifyElementPresent(MLWalletShopSafePage.objOngoingItemDescriptVal,"Item Description");
        verifyElementPresent(MLWalletShopSafePage.objOngoingBrandVal,"Brand");
        Swipe("UP", 1);
        verifyElementPresent(MLWalletShopSafePage.objOngoingModelNoVal,"Model No");
        verifyElementPresent(MLWalletShopSafePage.objOngoingCategoryVal,"Category");
        verifyElementPresent(MLWalletShopSafePage.objOngoingItemPriceVal,"Item Price");
        verifyElementPresent(MLWalletShopSafePage.objOngoingShipDetailLabel,"Ship Detail");
        Swipe("UP", 1);
        verifyElementPresent(MLWalletShopSafePage.objOngoingOriginBranchVal,"Origin Branch");
        verifyElementPresent(MLWalletShopSafePage.objOngoingSellerPicture,"Buyer Picture");
    }

    public void SSM_TC_09_Validate_Buyer_Ongoing_Transaction_Page () throws Exception {
        ExtentReporter.HeaderChildNode("To verify seller received invites click View Invitations Button in Invites Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        Swipe("UP", 2);
        click(MLWalletShopSafePage.objOngoingTransactTxtBtn,"View all Invites Text Button");
        click(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list");
        validateBuyerOngoing();
        logger.info("View new invitations in Invites Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_05", "To verify seller received invites click View Invitations Button in Invites Page");
    }

    public void SSM_TC_10_Validate_Seller_Ongoing_Transaction_Page () throws Exception {
        ExtentReporter.HeaderChildNode("To verify seller received invites click View Invitations Button in Invites Page");
        mlWalletLogin(prop.getproperty("SS_Fully_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        Swipe("UP", 2);
        click(MLWalletShopSafePage.objOngoingTransactTxtBtn,"View all Invites Text Button");
        waitTime(3000);
        click(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list");
        validateSellerOngoing();
        logger.info("View new invitations in Invites Page Success");
        ExtentReporter.extentLoggerPass("SSM_TC_05", "To verify seller received invites click View Invitations Button in Invites Page");
       }

    public void DropOffBuyer() throws Exception{
        click(MLWalletShopSafePage.objOngoingChooseNearestBranchBtn,"Nearest Drop Off GMap");
        click(MLWalletShopSafePage.objOngoingGmapWhileUSingAppBtn,"Allow G Map");
        waitTime(3000);
        if(verifyElementPresentAndClick(MLWalletShopSafePage.objOngoingSelectNearestBtn,"Select Near")){
            click(MLWalletShopSafePage.objOngoingSelectNearestBtn, "Select Near");
        }
        verifyElementPresent(MLWalletShopSafePage.objOngoingBranchNameGMapVal,"");
        verifyElementPresent(MLWalletShopSafePage.objOngoingBranchAddressGMapVal,"");
        click(MLWalletShopSafePage.objOngoingConfirmBranchBtn,"Confirm Branch Button");
    }
    public void ValidatePayment() throws Exception{
        verifyElementPresent(MLWalletShopSafePage.objPaymentPicture,"Picture");
        verifyElementPresent(MLWalletShopSafePage.objPaymentRFTN,"RFTN");
        verifyElementPresent(MLWalletShopSafePage.objPaymentSellersNameVal,"Sellers Name");
        verifyElementPresent(MLWalletShopSafePage.objPaymentSellersNoVal,"Sellers No");
        verifyElementPresent(MLWalletShopSafePage.objPaymentBuyersDetailLabel,"Buyers Detail Label");
        verifyElementPresent(MLWalletShopSafePage.objPaymentBuyersNameVal,"Buyers Name");
        verifyElementPresent(MLWalletShopSafePage.objPaymentBuyersNoVal,"Buyers No");
        Swipe("UP", 2);
        verifyElementPresent(MLWalletShopSafePage.objPaymentItemDetailsLabel,"Item Details");
        verifyElementPresent(MLWalletShopSafePage.objPaymentItemNameVal,"Item Name");
        verifyElementPresent(MLWalletShopSafePage.objPaymentItemDescriptVal,"Item Description");
        verifyElementPresent(MLWalletShopSafePage.objPaymentBrandVal,"Brand");
        verifyElementPresent(MLWalletShopSafePage.objPaymentModelNoVal,"Model No");
        verifyElementPresent(MLWalletShopSafePage.objPaymentCategoryVal,"Category");
        verifyElementPresent(MLWalletShopSafePage.objPaymentItemPriceVal,"Item Price");
        verifyElementPresent(MLWalletShopSafePage.objShippingFeeVal,"Shipping Fee");
        verifyElementPresent(MLWalletShopSafePage.objReturnShippingDepositVal,"Return Shipping Deposit");
        verifyElementPresent(MLWalletShopSafePage.objInsuranceFeeVal,"Insurance Fee");
        verifyElementPresent(MLWalletShopSafePage.objServiceFeeVal,"Service Fee");
        verifyElementPresent(MLWalletShopSafePage.objTotalAmountVal,"Total Amount");
        Swipe("UP", 1);
        verifyElementPresent(MLWalletShopSafePage.objShippingDetailsLabel,"Shipping Details Label");
        verifyElementPresent(MLWalletShopSafePage.objPaymentOriginBranchVal,"Origin Branch");
        verifyElementPresent(MLWalletShopSafePage.objPaymentTotalAmountVal,"Total Amount");
        verifyElementPresent(MLWalletShopSafePage.objPaymentBackBtn,"Back Btn");
        verifyElementPresentAndClick(MLWalletShopSafePage.objPaymentAmountBtn,"Amount Btn");

    }
    public void SSM_TC_11_Verify_seller_fill_up_the_Item_Information_Page_and_clicking_proceed_button_Invites_Page () throws Exception {
        ExtentReporter.HeaderChildNode("To verify seller received invites click View Invitations Button in Invites Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        Swipe("UP", 2);
        click(MLWalletShopSafePage.objOngoingTransactTxtBtn,"View all Invites Text Button");
        click(MLWalletShopSafePage.objFirstInTab,"New Invitation in Invites list");
        Swipe("UP", 4);
        DropOffBuyer();
        click(MLWalletShopSafePage.objOngoingProceedToReviewBtn,"Proceed To Review Btn");
        verifyElementPresent(MLWalletShopSafePage.objTermsAndConditionsLabel,"Terms And Conditions Label");
        verifyElementPresentAndClick(MLWalletShopSafePage.objAcceptTermsAndConditionsBtn,"Accept Btn");
        verifyElementPresent(MLWalletShopSafePage.objTermsAndConditionsBackBtn,"Back Btn");
        Swipe("UP", 3);
        verifyElementPresent(MLWalletShopSafePage.objOngoingOriginBranchVal,"Origin Branch");
        verifyElementPresent(MLWalletShopSafePage.objTermsAndConditionsLabel,"Terms And Conditions Label");
        ValidatePayment();
        verifyElementPresent(MLWalletShopSafePage.objSuccessfullyPaidLabel,"Successfully Paid Label");
        verifyElementPresentAndClick(MLWalletShopSafePage.objPaymentOkayBtn,"Okay Btn");

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
        verifyElementPresent(MLWalletHomePage.objEyeIcon,"Eye Icon");
        click(MLWalletHomePage.objEyeIcon,"Eye Icon");
        verifyElementPresent(MLWalletHomePage.objAvailableBalance," Available Text");
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
        waitTime(3000);
        click(MLWalletShopSafePage.objFirstInTab,"New Invitation");
        waitTime(3000);
        click(MLWalletShopSafePage.objBackBtn, "Back Button");
        verifyElementPresent(MLWalletShopSafePage.objViewAllInvitation, "View All Invitation Label");
        logger.info("Redirect back to Invites Page Navigation Success");
        ExtentReporter.extentLoggerPass("SSM_TC_03", "Validate back button to Invitation Request back to Invites Page");
    }

    public void SSM_TC_104_Validate_back_button_to_Shop_Ongoing_Transaction_Page_back_to_Shop_Safe_Page() throws Exception {
        ExtentReporter.HeaderChildNode("Validate back button to Ongoing Transaction Page back to Shop Safe Page");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        waitTime(1000);
        click(MLWalletShopSafePage.objShopSafeIconBtn, "Shop Safe Icon Button");
        Swipe("UP", 2);
        click(MLWalletShopSafePage.objOngoingTransactTxtBtn, "View All Invites Button");
        click(MLWalletShopSafePage.objBackBtn, "Back Button");
        Swipe("DOWN", 2);
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
