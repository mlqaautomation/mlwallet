package com.mlwallet.pages;

import org.openqa.selenium.By;

public class MLWalletReferAndEarn {
    public static By Refer_Back_btn = By.xpath("(//android.view.ViewGroup[@content-desc=\"\uE5CB\"]");
    public static By Refer_and_earn_text = By.xpath("//*[@text='Refer and Earn']");

    public static By Cash_back_referral_bonuses = By.xpath("//*[@text='Cashback and referral bonuses']");
    public static By Redeem_btn = By.xpath("//*[@text='Redeem0']");
    public static By Copy_link_btn = By.xpath("//android.view.ViewGroup[@content-desc=\"\uE14D\"]");
    public static By Share_btn = By.xpath("//android.view.ViewGroup[@content-desc=\"Share 0\"]");

    public static By Rewards_history_icon = By.xpath("//android.view.ViewGroup[@content-desc=\"\uE5D2\"]/android.widget.TextView");
    public static By Rewards_history_text = By.xpath("");
    public static By Cash_rewards_text = By.xpath("//*[@text='Cash Rewards']");
    public static By Cash_back_transaction = By.xpath("//android.widget.ScrollView//android.view.ViewGroup//*[@text='\uE86C CASH BACK']//parent::android.view.ViewGroup/parent::android.view.ViewGroup");
}
