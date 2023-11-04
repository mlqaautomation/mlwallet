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
    public static By objGcashAmount = By.xpath("//*[@resource-id='Amount']");
    public static By objGcashServiceFee = By.xpath("//*[@resource-id='Amount']");
    public static By objGcashTotal = By.xpath("//*[@resource-id='Total']");
    public static By objGcashReminder = By.xpath("//*[@resource-id='ARX1Q6']");
    public static By objContactPageHeader = By.xpath("//*[@text='Contacts']");
}
