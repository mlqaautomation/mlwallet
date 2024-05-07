package com.mlwallet.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MLWalletShopSafePage {
    //--------Home Dashboard
    public static By objShopSafeIconBtn = By.xpath("//*[@text='ShopSafe']");
    //-------Shop Safe Page
    public static By objShopSafeLabel = By.xpath("//*[@text='Shop Safe']");
    public static By objStartTransactBtn = By.xpath("//*[@text='Start Transaction  +']");
    public static By objInvitesLabel = By.xpath("//*[@text='Invites']");
    public static By objOngoingTransactLabel = By.xpath("//*[@text='Ongoing Transactions']");
    public static By objCompletedTransactLabel = By.xpath("//*[@text='Completed Transactions']");
    public static By objCancelledTransactLabel = By.xpath("//*[@text='Cancelled Transactions']");
    public static By objReturnedTransactLabel = By.xpath("//*[@text='Returned Transactions']");
    public static By objInvitesTransactTxtBtn = By.xpath("(//android.view.ViewGroup[@content-desc=\"View All Invites\"])[1]/android.widget.TextView");
    public static By objOngoingTransactTxtBtn = By.xpath("(//android.view.ViewGroup[@content-desc=\"View All Invites\"])[2]/android.widget.TextView");
    //------- Create Transaction Page
    public static By objCreateTransactLabel = By.xpath("//*[@text='Create Transaction']");
    public static By objBackBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"\uE5CB\"]/android.widget.TextView");
    public static By objSellerNoTxtbx = By.xpath("//*[@text='Seller Mobile Number *']");
    public static By objInviteSellerBtn = By.xpath("//*[@text='Invite Seller']");
    public static By objSuccessfInviteLabel = By.xpath("//*[@text='Successfully Invited']");
    public static By objOkayBtn = By.xpath("//*[@text='Ok']");
    //-------Invites Transaction Page
    public static By objViewAllInvitation = By.xpath("//*[@text='View All Invitation']");
    public static By objFirstInTab = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");

    //--------Buyer Invite Seller Page
    public static By objInvtesSellerLabel = By.xpath("//*[@text='Seller Invitation']");
    public static By objBuyerDetailsLabel = By.xpath("//*[@text='Buyer Details']");
    public static By objBuyerNameVal = By.xpath("//*[@resource-id='X0AKRJ']/child::*[2]");
    public static By objBuyerNoVal = By.xpath("//*[@resource-id='IMOO2V']/child::*[2]");
    public static By objSellerDetailsLabel = By.xpath("//*[@text='Seller Details']");
    public static By objSellerNoVal = By.xpath("//*[@resource-id='RTYWVC']/child::*[2]");
    public static By objCancelInviteBtn = By.xpath("//*[@text='Cancel Invitation']");
    public static By objBackToHomesBtn = By.xpath("//*[@text='Back To Home']");

    //--------Seller Received Invites Page
    public static By objPicOfItemBtn = By.xpath("//*[@text='\uE3B0Pictures of your Item *']");
    public static By objItemNameTxtBx = By.xpath("//*[@text='Item name *']");
    public static By objItemDescriptTxtBx = By.xpath("//*[@text='Item description/condition *']");
    public static By objBrandTxtBx = By.xpath("//*[@text='Brand (optional)']");
    public static By objModelNoTxtbox = By.xpath("//*[@text='Model No (optional)']");
    public static By objItemQuantityTxtbx = By.xpath("//*[@text='Item quantity *']");
    public static By objCategoryDropDownlist = By.xpath("//*[@text='Category *']");
    public static By objItemPriceTxtbx = By.xpath("//*[@text='Item price *']");
    public static By objWeightRangeDropDownList = By.xpath("//*[@text='Choose weight range']");
    public static By objNearestDropOffGMap = By.xpath("//*[@text='Please choose nearest drop off branch *']");
    public static By objProceedsBtn = By.xpath("//*[@text='Proceed']");
    public static By objDeclineBtn = By.xpath("//*[@text='Decline']");
    //-----Selection for Camera
    public static By objCameraBtn = By.xpath("//*[@text='Camera']");
    public static By objGalleryBtn = By.xpath("//*[@text='Gallery']");
    public static By objCancelsBtn = By.xpath("//*[@text='Cancel']");
    public static By objAllowCameraWhileUsingAppBtn = By.xpath("//*[@text='While using the app']");
    public static By objTakeAPicBtn = By.xpath("//*[@resource-id='com.sec.android.app.camera:id/bottom_background']");
    public static By objTakeAPicOkBtn = By.xpath("//*[@text='OK']");

    //-------------Select Category List
    public static By objSelectCategoryLabel = By.xpath("//*[@text='Select Category']");
    public static By objSearchCategoryTxtbx = By.xpath("//*[@text='Search Category']");
    public static By objClothesTxtBtn = By.xpath("//*[@text='Clothes / Bag / Shoes']");
    public static By objElectronicsTxtBtn = By.xpath("//*[@text='Electronics / Appliance']");
    public static By objJewelryTxtBtn = By.xpath("//*[@text='Jewelry / Watches']");
    public static By objSportGoodTxtBtn = By.xpath("//*[@text='Sporting Goods']");
    public static By objToolsTxtBtn = By.xpath("//*[@text='Tools / Supplies / Paper']");
    public static By objOthersTxtBtn = By.xpath("//*[@text='Others']");

    //-----------Select Weight Ranges List
    public static By objWeightRangeLabel = By.xpath("//*[@text='Weight Range']");
    public static By objRateLabel = By.xpath("//*[@text='Rate']");
    public static By obj0kgTxtBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"0.00 kg - 3.00kg, Php 195.00\"]");
    public static By obj3kgTxtBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"3.01 kg - 5.00kg, Php 375.00\"]");
    public static By obj5kgTxtBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"5.01 kg - 10.00kg, Php 875.00\"]");
    public static By obj10kgTxtBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"5.01 kg - 10.00kg, Php 875.00\"]");
    public static By obj20kgTxtBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"20.01 kg - 30.00kg, Php 3,000.00\"]");
    public static By obj30kgTxtBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"30.01 kg - 40.00kg, Php 6,500.00\"]");
    public static By obj40kgTxtBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"30.01 kg - 40.00kg, Php 6,500.00\"]");

    //-----------Select Drop Off Branch List
    public static By objGetErrMsg (String msg){
        return By.xpath("//*[@text='"+msg+"']");
    }
    public static By objAllowWhileUsingAppBtn = By.xpath("//*[@text='While using the app']");
    public static By objSelectNearest = By.xpath("//android.view.View[@content-desc=\"Google Map\"]/android.view.View[1]");
    public static By objBranchNameGMapVal = By.xpath("(//*[@resource-id='DJCC83']/child::*/child::*)[1]");
    public static By objBranchAddressGMapVal = By.xpath("(//*[@resource-id='DJCC83']/child::*/child::*)[2]");
    public static By objConfirmBranchBtn = By.xpath("//*[@text='Confirm Branch']");
    //-----------Confirmation Page
    public static By objConfirmDetailsPage = By.xpath("//*[@text='Confirm Details']");
    public static By objPicture = By.xpath("(//*[@resource-id='X63NQ1']/child::*/child::*/child::*)[1]");
    public static By objRFTN = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/child::android.view.ViewGroup[2]/child::android.widget.TextView\n");
    public static By objSellersDetailLabel = By.xpath("//*[@text='Seller Details']");
    public static By objSellersNameVal = By.xpath("(//*[@resource-id='Seller Name'])[2]");
    public static By objSellersNoVal = By.xpath("(//*[@resource-id='Seller Mobile Number'])[2]");
    public static By objBuyersDetailLabel = By.xpath("//*[@text='Buyer Details']");
    public static By objBuyersNameVal = By.xpath("(//*[@resource-id='Buyer Name'])[2]");
    public static By objBuyersNoVal = By.xpath("(//*[@resource-id='Buyer Mobile Number'])[2]");
    public static By objItemDetailsLabel = By.xpath("//*[@text='Item details']");
    public static By objItemNameVal = By.xpath("(//*[@resource-id='Item name'])[2]");
    public static By objItemDescriptVal = By.xpath("(//*[@resource-id='Item description/condition'])[2]");
    public static By objBrandVal = By.xpath("(//*[@resource-id='Brand'])[2]");
    public static By objModelNoVal = By.xpath("(//*[@resource-id='Model No'])[2]");
    public static By objCategoryVal = By.xpath("(//*[@resource-id='Category'])[2]");
    public static By objItemPriceVal = By.xpath("(//*[@resource-id='Item price'])[2]");
    public static By objShipDetailLabel = By.xpath("//*[@text='Shipping Details']");
    public static By objOriginBranchVal = By.xpath("(//*[@resource-id='Origin Branch'])[2]");
    public static By objConfirmInvitationBtn = By.xpath("//*[@text='Confirm Invitation']");
    public static By objBacksBtn = By.xpath("//*[@text='Back']");

    //-----------Transaction Details Page
    public static By objTransactionDetailPage = By.xpath("");
    public static By objRFTNTransact = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*)[2]");
    public static By objSellersDetailTransactLabel = By.xpath("//*[@text='Seller Details']");
    public static By objSellersNameTransactVal = By.xpath("(//*[@resource-id='Seller Name'])[2]");
    public static By objSellersNoTransactVal = By.xpath("(//*[@resource-id='Seller Mobile Number'])[2]");
    public static By objBuyersDetailTransactLabel = By.xpath("//*[@text='Buyer Details']");
    public static By objBuyersNameTransactVal = By.xpath("(//*[@resource-id='Buyer Name'])[2]");
    public static By objBuyersNoTransactVal = By.xpath("(//*[@resource-id='Buyer Mobile Number'])[2]");
    public static By objItemDetailsTransactLabel = By.xpath("//*[@text='Item details']");
    public static By objItemNameTransactVal = By.xpath("(//*[@resource-id='Item name'])[2]");
    public static By objItemDescriptTransactVal = By.xpath("(//*[@resource-id='Item description/condition'])[2]");
    public static By objBrandTransactVal = By.xpath("(//*[@resource-id='Brand'])[2]");
    public static By objModelNoTransactVal = By.xpath("(//*[@resource-id='Model No'])[2]");
    public static By objCategoryTransactVal = By.xpath("(//*[@resource-id='Category'])[2]");
    public static By objItemPriceTransactVal = By.xpath("(//*[@resource-id='Item price'])[2]");
    public static By objShipDetailTransactLabel = By.xpath("//*[@text='Shipping Details']");
    public static By objOriginBranchTransactVal = By.xpath("(//*[@resource-id='Origin Branch'])[2]");
    public static By objPictureTransact = By.xpath("(//*[@resource-id='LWPG92']/child::*/child::*/child::*)[1]");

    //----------- Ongoing Transaction
    public static By objOngoingDetailPageLabel = By.xpath("");
    public static By objOngoingRFTN = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/child::android.view.ViewGroup[2]/child::android.widget.TextView");
    public static By objOngoingDropOffStatus = By.xpath("//*[@text='For Drop Off']");
    public static By objOngoingWaitPaymentStatus = By.xpath("//*[@text='Waiting For Payment']");
    public static By objOngoingellersDetailLabel = By.xpath("//*[@text='Seller Details']");
    public static By objOngoingSellersNameVal = By.xpath("(//*[@resource-id='Seller Name'])[2]");
    public static By objOngoingSellersNoVal = By.xpath("(//*[@resource-id='Seller Mobile Number'])[2]");
    public static By objOngoingBuyersDetailLabel = By.xpath("//*[@text='Buyer Details']");
    public static By objOngoingBuyersNameVal = By.xpath("(//*[@resource-id='Buyer Name'])[2]");
    public static By objOngoingBuyersNoVal = By.xpath("(//*[@resource-id='Buyer Mobile Number'])[2]");
    public static By objOngoingItemDetailsLabel = By.xpath("//*[@text='Item details']");
    public static By objOngoingItemNameVal = By.xpath("(//*[@resource-id='Item name'])[2]");
    public static By objOngoingItemDescriptVal = By.xpath("(//*[@resource-id='Item description/condition'])[2]");
    public static By objOngoingBrandVal = By.xpath("(//*[@resource-id='Brand'])[2]");
    public static By objOngoingModelNoVal = By.xpath("(//*[@resource-id='Model No'])[2]");
    public static By objOngoingCategoryVal = By.xpath("(//*[@resource-id='Category'])[2]");
    public static By objOngoingItemPriceVal = By.xpath("(//*[@resource-id='Item price'])[2]");
    public static By objOngoingShipDetailLabel = By.xpath("//*[@text='Shipping Details']");
    public static By objOngoingOriginBranchVal = By.xpath("(//*[@resource-id='Origin Branch'])[2]");
    public static By objOngoingSellerPicture = By.xpath("(//*[@resource-id='LWPG92']/child::*/child::*/child::*)[1]");
    public static By objOngoingBuyerPicture = By.xpath("(//*[@resource-id='ZN2H1C']/child::*/child::*/child::*)[1]");
    public static By objOngoingChooseNearestBranchBtn = By.xpath("//*[@text='Please choose nearest pickup branch *']");
    public static By objOngoingGmapWhileUSingAppBtn =By.xpath("//*[@text='While using the app']");
    public static By objOngoingSelectNearestBtn =By.xpath("//android.view.View[@content-desc=\"Google Map\"]/android.view.View[1]\n");
    public static By objOngoingBranchNameGMapVal = By.xpath("(//*[@resource-id='DJCC83']/child::*/child::*)[1]");
    public static By objOngoingBranchAddressGMapVal = By.xpath("(//*[@resource-id='DJCC83']/child::*/child::*)[2]");
    public static By objOngoingPlsChooseBranchBtn = By.xpath("//*[@text='Please Choose Branch']");
    public static By objOngoingOKBtn = By.xpath("//*[@text='Ok']");
    public static By objOngoingConfirmBranchBtn = By.xpath("//*[@text='Confirm Branch']");
    public static By objOngoingProceedToReviewBtn = By.xpath("//*[@text='Proceed to review']");
    public static By objOngoingCancelBtn = By.xpath("//*[@text='Cancel Transaction']");
    //----------- Terms and Condition
    public static By objTermsAndConditionsLabel = By.xpath("//*[@text='Terms and Condition']");
    public static By objAcceptTermsAndConditionsBtn = By.xpath("//*[@text='Accept Terms and Conditions']");
    public static By objTermsAndConditionsBackBtn = By.xpath("//*[@text='Back']");
    //----------- Shop Safe Payment
    public static By objPaymentPicture = By.xpath("(//*[@resource-id='XYK4G1']/child::*/child::*/child::*)");
    public static By objPaymentRFTN = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*)[2]");
    public static By objPaymentSellersNameVal = By.xpath("(//*[@resource-id='Seller Name'])[2]");
    public static By objPaymentSellersNoVal = By.xpath("(//*[@resource-id='Seller Mobile Number'])[2]");
    public static By objPaymentBuyersDetailLabel = By.xpath("//*[@text='Buyer Details']");
    public static By objPaymentBuyersNameVal = By.xpath("(//*[@resource-id='Buyer Name'])[2]");
    public static By objPaymentBuyersNoVal = By.xpath("(//*[@resource-id='Buyer Mobile Number'])[2]");
    public static By objPaymentItemDetailsLabel = By.xpath("//*[@text='Item details']");
    public static By objPaymentItemNameVal = By.xpath("(//*[@resource-id='Item name'])[2]");
    public static By objPaymentItemDescriptVal = By.xpath("(//*[@resource-id='Item description/condition'])[2]");
    public static By objPaymentBrandVal = By.xpath("(//*[@resource-id='Brand'])[2]");
    public static By objPaymentModelNoVal = By.xpath("(//*[@resource-id='Model No'])[2]");
    public static By objPaymentCategoryVal = By.xpath("(//*[@resource-id='Category'])[2]");
    public static By objPaymentItemPriceVal = By.xpath("(//*[@resource-id='Item price'])[2]");
    public static By objShippingFeeVal = By.xpath("//*[@text='Shipping Fee']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/child::android.widget.TextView");
    public static By objReturnShippingDepositDropOffVal = By.xpath("//*[@text='Return Shipping Deposit']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/child::android.widget.TextView");
    public static By objReturnShippingDepositVal = By.xpath("(//*[@resource-id='Return Shipping Deposit'])[2]");
    public static By objInsuranceFeeVal = By.xpath("(//*[@resource-id='Insurance Fee'])[2]");
    public static By objServiceFeeVal = By.xpath("(//*[@resource-id='Service Fee'])[2]");
    public static By objTotalAmountVal = By.xpath("(//*[@resource-id='Total Amount'])[2]");
    public static By objShippingDetailsLabel = By.xpath("//*[@text='Shipping Details']");
    public static By objPaymentOriginBranchVal = By.xpath("(//*[@resource-id='Origin Branch'])[2]");
    public static By objPaymentTotalAmountVal = By.xpath("(//*[@resource-id='Destination branch'])[2]");
    public static By objPaymentAmountBtn = By.xpath("//*[@text='Pay Amount']");
    public static By objPaymentBackBtn = By.xpath("//*[@text='Back']");
    public static By objSuccessfullyPaidLabel = By.xpath("//*[@text='Successfully Paid']");
    public static By objPaymentOkayBtn = By.xpath("//*[@text='Okay']");
    //----------- Cancelled Transaction
    public static By objCancelledDetailPageLabel = By.xpath("");
    public static By objCancelledStatusLabel = By.xpath("//*[@text='Buyer Details']");
    public static By objCancelledRFTN = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*)[2]");
    public static By objCancelledellersDetailLabel = By.xpath("//*[@text='Seller Details']");
    public static By objCancelledSellersNameVal = By.xpath("(//*[@resource-id='PT340E']/child::*)[2]");
    public static By objCancelledSellersNoVal = By.xpath("(//*[@resource-id='6CMA15']/child::*)[2]");
    public static By objCancelledBuyersDetailLabel = By.xpath("//*[@text='Buyer Details']");
    public static By objCancelledBuyersNameVal = By.xpath("(//*[@resource-id='2KIF77']/child::*)[2]");
    public static By objCancelledBuyersNoVal = By.xpath("(//*[@resource-id='P92RHD']/child::*)[2]");
    public static By objCancelledItemDetailsLabel = By.xpath("//*[@text='Item details']");
    public static By objCancelledItemNameVal = By.xpath("(//*[@resource-id='GXE94G']/child::*)[2]");
    public static By objCancelledItemDescriptVal = By.xpath("(//*[@resource-id='8A2AWU']/child::*)[2]");
    public static By objCancelledBrandVal = By.xpath("(//*[@resource-id='Brand'])[2]");
    public static By objCancelledModelNoVal = By.xpath("(//*[@resource-id='Model No'])[2]");
    public static By objCancelledCategoryVal = By.xpath("(//*[@resource-id='Category'])[2]");
    public static By objCancelledItemPriceVal = By.xpath("(//*[@resource-id='Item price'])[2]");
    public static By objCancelledShipDetailLabel = By.xpath("//*[@text='Shipping Details']");
    public static By objCancelledOriginBranchVal = By.xpath("(//*[@resource-id='Origin Branch'])[2]");
    public static By objCancelledPicture = By.xpath("(//*[@resource-id='LWPG92']/child::*/child::*/child::*)[1]");
}

