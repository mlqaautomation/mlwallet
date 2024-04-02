package com.mlwallet.pages;
import org.openqa.selenium.By;
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
    public static By objItemNameTxtBx = By.xpath("//XCUIElementT//*[@text='Item name *']");
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
    public static By objSelectNearest = By.xpath("//android.view.View[@content-desc=\"Google Map\"]/android.view.View[2]\n");
    public static By objBranchNameGMapVal = By.xpath("(//*[@resource-id='DJCC83']/child::*/child::*)[1]");
    public static By objBranchAddressGMapVal = By.xpath("(//*[@resource-id='DJCC83']/child::*/child::*)[2]");
    //-----------Confirmation Page
    public static By objConfirmDetailsPage = By.xpath("//*[@text='Confirm Details']");
    public static By objPicture = By.xpath("(//*[@resource-id='X63NQ1']/child::*/child::*/child::*)[1]");
    public static By objRFTN = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*)[1]");
    public static By objSellersDetailLabel = By.xpath("//*[@text='Seller Details']");
    public static By objSellersNameVal = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*/child::*)[2]");
    public static By objSellersNoVal = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*/child::*)[4]");
    public static By objBuyersDetailLabel = By.xpath("//*[@text='Buyer Details']");
    public static By objBuyersNameVal = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*/child::*)[6]");
    public static By objBuyersNoVal = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*/child::*)[8]");
    public static By objItemDetailsLabel = By.xpath("//*[@text='Item details']");
    public static By objItemNameVal = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*/child::*)[10]");
    public static By objItemDescriptVal = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*/child::*)[12]");
    public static By objBrandVal = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*/child::*)[14]");
    public static By objModelNoVal = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*/child::*)[16]");
    public static By objCategoryVal = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*/child::*)[18]");
    public static By objItemPriceVal = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*/child::*)[20]");
    public static By objShipDetailLabel = By.xpath("//*[@text='Shipping Details']");
    public static By objOriginBranchVal = By.xpath("(//*[@resource-id='XHZ48R']/child::*/child::*/child::*)[22]");
    public static By objConfirmInvitationBtn = By.xpath("//*[@text='Confirm Invitation']");
    public static By objBacksBtn = By.xpath("//*[@text='Back']");

    //-----------Transaction Details Page
    public static By objTransactionDetailPage = By.xpath( "");
    public static By objRFTNTransact = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*)[2]");
    public static By objSellersDetailTransactLabel = By.xpath("//*[@text='Seller Details']");
    public static By objSellersNameTransactVal = By.xpath("(//*[@resource-id='PT340E']/child::android.view.ViewGroup)[2]");
    public static By objSellersNoTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[4]");
    public static By objBuyersDetailTransactLabel = By.xpath("//*[@text='Buyer Details']");
    public static By objBuyersNameTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[6]");
    public static By objBuyersNoTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[8]");
    public static By objItemDetailsTransactLabel = By.xpath("//*[@text='Item details']");
    public static By objItemNameTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[10]");
    public static By objItemDescriptTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[12]");
    public static By objBrandTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[14]");
    public static By objModelNoTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[16]");
    public static By objCategoryTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[18]");
    public static By objItemPriceTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[20]");
    public static By objShipDetailTransactLabel = By.xpath("//*[@text='Shipping Details']");
    public static By objOriginBranchTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[22]");
    public static By objPictureTransact = By.xpath("(//*[@resource-id='LWPG92']/child::*/child::*/child::*)[1]");

    //----------- Ongoing Transaction
    public static By objTransactionDetailPage = By.xpath( "");
    public static By objRFTNTransact = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*)[2]");
    public static By objSellersDetailTransactLabel = By.xpath("//*[@text='Seller Details']");
    public static By objSellersNameTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[3]");
    public static By objSellersNoTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[5]");
    public static By objBuyersDetailTransactLabel = By.xpath("//*[@text='Buyer Details']");
    public static By objBuyersNameTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[7]");
    public static By objBuyersNoTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[9]");
    public static By objItemDetailsTransactLabel = By.xpath("//*[@text='Item details']");
    public static By objItemNameTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[11]");
    public static By objItemDescriptTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[13]");
    public static By objBrandTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[15]");
    public static By objModelNoTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[17]");
    public static By objCategoryTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[19]");
    public static By objItemPriceTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[21]");
    public static By objShipDetailTransactLabel = By.xpath("//*[@text='Shipping Details']");
    public static By objOriginBranchTransactVal = By.xpath("(//*[@resource-id='MQ33UF']/child::*/child::*/child::*)[22]");
    public static By objPictureTransact = By.xpath("(//*[@resource-id='LWPG92']/child::*/child::*/child::*)[1]");
}
