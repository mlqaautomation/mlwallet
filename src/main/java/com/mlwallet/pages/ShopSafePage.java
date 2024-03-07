package com.mlwallet.pages;
import org.openqa.selenium.By;
public class ShopSafePage {
    //--------Home Dashboard
    public static By objShopSafeIconBtn = By.xpath("//XCUIElementTypeOther[@name=\"ShopSafe\"]");
    //-------Shop Safe Page
    public static By objShopSafeLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Shop Safe\"]");
    public static By objStartTransactBtn = By.xpath("//XCUIElementTypeOther[@name=\"Start Transaction  +\"]");
    public static By objInvitesLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Invites\"]");
    public static By objOngoingTransactLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Ongoing Transactions\"]");
    public static By objCompletedTransactLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Completed Transactions\"]");
    public static By objCancelledTransactLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Cancelled Transactions\"]");
    public static By objReturnedTransactLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Returned Transactions\"]");
    public static By objInvitesTransactTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"View All Invites\"])[1]");
    public static By objOngoingTransactTxtBtn = By.xpath("(//XCUIElementTypeOther[@name=\"View All Invites\"])[2]");
    //------- Create Transaction Page
    public static By objCreateTransactLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Create Transaction\"]");
    public static By objBackBtn = By.xpath("//XCUIElementTypeOther[@name=\"\"]");
    public static By objSellerNoTxtbx = By.xpath("//XCUIElementTypeOther[@name=\"Seller Mobile Number *\"]/XCUIElementTypeTextField");
    public static By objInviteSellerBtn = By.xpath("//XCUIElementTypeOther[@name=\"Invite Seller\"]");
    public static By objSuccessfInviteLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Successfully Invited\"]");
    public static By objOkayBtn = By.xpath("//XCUIElementTypeOther[@name=\"modal-confirm-button\"]");
    //------- Create Invites Transaction Page

    //--------Invite Seller Description
    public static By objBuyerDetailsLabel = By.xpath("//XCUIElementTypeStaticText[@name=\"Buyer Details\"]");
    public static By objBuyerNameTxt = By.xpath("(//XCUIElementTypeStaticText[@name=\"Buyer Name\"])[2]");
    public static By objOkayBtn = By.xpath("(//XCUIElementTypeStaticText[@name=\"Buyer Mobile No.\"])[2]");
    public static By objOkayBtn = By.xpath("//XCUIElementTypeStaticText[@name=\"Seller Details\"]");
    public static By objOkayBtn = By.xpath("(//XCUIElementTypeStaticText[@name=\"Seller Mobile Number\"])[2]");
    public static By objOkayBtn = By.xpath("//XCUIElementTypeOther[@name=\"Cancel Invitation\"]");
    public static By objOkayBtn = By.xpath("//XCUIElementTypeOther[@name=\"Back To Home\"]");

}
