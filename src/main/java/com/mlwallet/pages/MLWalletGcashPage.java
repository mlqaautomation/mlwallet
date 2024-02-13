package com.mlwallet.pages;

import org.openqa.selenium.By;

public class MLWalletGcashPage {
    //-------------GCash Services Page
    public static By objGcashText = By.xpath("//*[@text='GCash']");
    public static By objGcashServicesText = By.xpath("//*[@text='GCash Services']");
    public static By objGcashOptionsText = By.xpath("//*[@text='GCash Options']");
    //-------------Send Money GCash Page
    public static By objGcashSendMoneyText = By.xpath("//*[@text='Send Money']");
    public static By objSendMoneyPageHeader = By.xpath("//*[@text='Send Money to GCash']");
    public static By objSendMoneyReceiverText = By.xpath("//*[@text='Receiver']");
    public static By objGcashMobileNumber = By.xpath("//*[@text='+63']/following-sibling::android.widget.EditText");

    //-----------------------Contact Page
    public static By objContactPageHeader = By.xpath("(//*[@text='Contacts'])[1]");
    public static By objContactButton = By.xpath("(//*[@text='Contacts'])[2]");
    public static By objSelectContactText = By.xpath("//*[@text='Select from Contacts']");
    public static By objSearchBox = By.xpath("//*[@text='Search']");
    public static By objFavoritesBtn = By.xpath("//*[@text='Favorites']");
    public static By objOkAllowContacts = By.xpath("//*[@text='Allow']");
    public static By objGetErrMsg (String msg){
        return By.xpath("//*[@text='"+msg+"']");
    }
 //-------------------------------Send Money GCash Amount Page
    public static By objAmountTextBox = By.xpath("//*[@text='PHP']/following-sibling::android.widget.EditText");
    public static By objNextBtn = By.xpath("//*[@text='Next']");
    public static By objGcashMobileNumText = By.xpath("//*[@resource-id='JBOTZ0']");
    public static By objReceiverNumber = By.xpath("//*[@resource-id='X8L073']");

    public static By objProceedBtn = By.xpath(" //*[@text='Yes, Proceed Transaction']");
   //--------------------------Confirm Details Page
   public static By objConfirmDetailsPage = By.xpath("//*[@text='Confirm Details']");
    public static By objConfirmBtn = By.xpath("//*[@text='Confirm']");
    public static By objSendtoGCash_Confirm = By.xpath("//*[@text='Send Money to GCash']");
    public static By objReceiverNumber_Confirm = By.xpath("//*[@resource-id='ZM8UHR']/child::*[2]");
    public static By objSenderName_Confirm = By.xpath("//*[@resource-id='I4U5Q4']/child::*[2]");
    public static By objSenderNumber_Confirm = By.xpath("//*[@resource-id='X3HARL']/child::*[2]");
    public static By objAmount_Confirm = By.xpath("//*[@resource-id='YTS3NI']/child::*[2]");
    public static By objServiceFee_Confirm = By.xpath("//*[@resource-id='DTMI0G']/child::*[2]");
    public static By objTotal_Confirm = By.xpath("//*[@resource-id='ID316A']/child::*[2]");
    //------------------allow location
    public static By objAllowOnceBtn = By.xpath("//*[@text='Only this time']");
    public static By objUpgrade50kNowLabel = By.xpath("//*[@text='The maximum Send to GCash per transaction set for your verification level is P50,000.00. Please try again.']");
    public static By objUpgradeNowLabel = By.xpath("//*[@text='Send to GCash is not allowed for customers at this verification level. Please upgrade your account to use this service.']");
    public static By objUpgradeBtn = By.xpath("//*[@text='Upgrade Now']");
    public static By objSendMoney_WalletUserBtn = By.xpath("//*[@text='Send Money to ML Wallet User']");
    //--------------- Transaction Detail Page
    public static By objSendtoGCash_Transaction = By.xpath("//*[@text='Send Money to GCash']");
    public static By objAmountSendTransactText = By.xpath("//*[@text='Send Money to GCash']/following-sibling::*[1]");
    public static By objTransactionDetailsText = By.xpath("//*[@resource-id='2VIMA3']");
    public static By objReceiverNumber_Transaction = By.xpath("//*[@resource-id='ZM8UHR']/child::*[2]");
    public static By objSenderName_Transaction = By.xpath("//*[@resource-id='I4U5Q4']/child::*[2]");
    public static By objSenderNumber_Transaction = By.xpath("//*[@resource-id='X3HARL']/child::*[2]");
    public static By objGcashAmount = By.xpath("//*[@resource-id='YTS3NI']/child::*[2]");
    public static By objGcashServiceFee = By.xpath("//*[@resource-id='DTMI0G']/child::*[2]");
    public static By objGcashTotal = By.xpath("//*[@resource-id='ID316A']/child::*[2]");
    public static By objGcashReminder = By.xpath("//*[@resource-id='ARX1Q6']");
    public static By objBack_to_Home_Page = By.xpath("//*[@resource-id='TN8ENX']");
    public static By objNew_Transaction = By.xpath("//*[@resource-id='22M10L']");
    public static By objPendingText = By.xpath("//*[@text='Pending']");
   //--------------------No Gcash Kwarta Padala
    public static By objNoGCashOtherOptionLabel = By.xpath("//*[@text='This number does not have a GCash-registered account. Please check the number and try again.']");
    public static By objSendViaMLKwartaWallelabel = By.xpath("//*[@text='You may also use ML Kwarta Padala to send cash to anyone in the Philippines.']");
    public static By objSendViaMLKwartaPadalaBtn =By.xpath("//*[@text='Send Money via ML Kwarta Padala']");

    public static By objCloseBtn =By.xpath("//*[@text='Close']");
    public static By objSendViaMLWalletlabel = By.xpath("//*[@text='You may also Send Money to any ML Wallet User.']");
    public static By objSendViaMLWalletBtn =By.xpath(" //*[@text='Send Money to ML Wallet User']");
    //---------------------------------
    public static By objRecentPendingText = By.xpath("(//*[contains(@content-desc, \"Pending\")])[1]");
    public static By objRecentSucessText = By.xpath("(//*[contains(@content-desc, \"Completed\")])[1]");
    public static By objRecentFailedText = By.xpath("(//*[contains(@content-desc, \"Failed\")])[1]");
    public static By objGcashPage_BackBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"\uE5CB\"]/android.widget.TextView");
    public static By objIsRequired(String val){
        return By.xpath("//*[@text='"+val+"']");
    }
}
