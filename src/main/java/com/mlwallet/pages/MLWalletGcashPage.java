package com.mlwallet.pages;

import org.openqa.selenium.By;

public class MLWalletGcashPage {
    public static By objGcashText = By.xpath("//*[@text='GCash']");
    public static By objGcashServicesText = By.xpath("//*[@text='GCash Services']");
    public static By objGcashOptionsText = By.xpath("//*[@text='GCash Options']");
    public static By objGcashSendMoneyText = By.xpath("//*[@text='Send Money']");
    public static By objSendMoneyPageHeader = By.xpath("//*[@text='Send Money to GCash']");
    public static By objSendMoneyReceiverText = By.xpath("//*[@text='Receiver']");
    public static By objGcashMobileNumber = By.xpath("//*[@text='+63']/following-sibling::android.widget.EditText");
    public static By objSelectContactText = By.xpath("//*[@text='Select from Contacts']");
    public static By objGetErrMsg (String msg){
        return By.xpath("//*[@text='"+msg+"']");
    }
    public static By objAmountTextBox = By.xpath("//*[@text='PHP']/following-sibling::android.widget.EditText");
    public static By objNextBtn = By.xpath("//*[@text='Next']");
    public static By objGcashMobileNumText = By.xpath("//*[@resource-id='JBOTZ0']");
    public static By objReceiverNumber = By.xpath("//*[@resource-id='X8L073']");
    public static By objConfirmDetailsPage = By.xpath("//*[@text='Confirm Details']");

    public static By objConfirmBtn = By.xpath("//*[@text='Confirm']");
    public static By objSendMoney_WalletUserBtn = By.xpath("//*[@text='Send Money to ML Wallet User']");
    public static By objTransactionDetailsText = By.xpath("//*[@resource-id='2VIMA3']");
    public static By objReceiverNumber_Transaction = By.xpath("//*[@resource-id='Receiver GCash Mobile #']");
    public static By objSenderName_Transaction = By.xpath("//*[@resource-id='Sender Name']");
    public static By objSenderNumber_Transaction = By.xpath("//*[@resource-id='Sender Mobile No.']");
    public static By objGcashAmount = By.xpath("//*[@resource-id='Amount']");
    public static By objGcashServiceFee = By.xpath("//*[@resource-id='Service Fee']");
    public static By objGcashTotal = By.xpath("//*[@resource-id='Total']");
    public static By objGcashReminder = By.xpath("//*[@resource-id='ARX1Q6']");
    public static By objContactPageHeader = By.xpath("//*[@text='Contacts']");
    public static By objBack_to_Home_Page = By.xpath("//*[@resource-id='TN8ENX']");
    public static By objNew_Transaction = By.xpath("//*[@resource-id='22M10L']");
    public static By objPendingText = By.xpath("//*[@text='Pending']");
    public static By objRecentPendingText = By.xpath("(//*[contains(@content-desc, \"Pending\")])[1]");
    public static By objRecentSucessText = By.xpath("(//*[contains(@content-desc, \"Completed\")])[1]");
    public static By objRecentFailedText = By.xpath("(//*[contains(@content-desc, \"Failed\")])[1]");
    public static By objGcashPage_BackBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"\uE5CB\"]/android.widget.TextView");
}
