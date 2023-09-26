package com.business.mlwallet;

import com.mlwallet.pages.MLWalletShopItemsPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.utility.Utilities.*;
import static com.utility.Utilities.click;

public class ShopItemsClass extends BaseClass{
    public ShopItemsClass(String Application, String deviceName, String portno) throws InterruptedException {
        super(Application, deviceName, portno);
    }
    public void shopItemsNavigation() throws Exception {
        click(MLWalletShopItemsPage.objShopItemsTab, "Shop Items Icon");
        Thread.sleep(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMLShopPage, "ML Shop Page");
        Thread.sleep(10000);
        click(MLWalletShopItemsPage.objloginOkayButton, "Button");
    }

    public void selectItemAndAddToCart() throws Exception {
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        waitTime(5000);
        Swipe("up", 2);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
    }

    public void navigationToCart() throws Exception {
        click(MLWalletShopItemsPage.objHambergerMenu, "Hamburger Menu");
        click(MLWalletShopItemsPage.objCart, "Cart");
    }

    public void editAddressAndPlaceTheOrder() throws Exception {
        click(MLWalletShopItemsPage.objCheckBox, "Check Box");
        click(MLWalletShopItemsPage.objCheckOutBtn, "Checkout Button");
        click(MLWalletShopItemsPage.objEditAddress, "Edit Address Tab");
        verifyElementPresent(MLWalletShopItemsPage.objSelectBranchPage, getTextVal(MLWalletShopItemsPage.objSelectBranchPage, "Page"));
        click(MLWalletShopItemsPage.objSaveBtn, "Save Button");
        verifyElementPresent(MLWalletShopItemsPage.objAddressSuccessfulMsg, getTextVal(MLWalletShopItemsPage.objAddressSuccessfulMsg, "Message"));
        click(MLWalletShopItemsPage.objOkBtn, "OK Button");
        Swipe("UP", 2);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethod, getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod, "Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMLWallet, getTextVal(MLWalletShopItemsPage.objMLWallet, "Option"));
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objPlaceOrderBtn, "Place Order Button");
    }


    public void mlWallet_ShopItems_Successful_Purchase() throws Exception {
        ExtentReporter.HeaderChildNode("mlWalletShopItems_Successful_Purchase");
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        editAddressAndPlaceTheOrder();
        verifyElementPresent(MLWalletShopItemsPage.objOtpPage, getTextVal(MLWalletShopItemsPage.objOtpPage, "Pop up"));
        Thread.sleep(2000);
        click(MLWalletShopItemsPage.objOtpTextField, "Otp Text Field");
        handleOtp(prop.getproperty("otp"));
        click(MLWalletShopItemsPage.objValidateBtn, "Validate Button");
        // code for successful purchase message validation
    }

    public void mlWallet_ShopItems_with_Insufficient_Balance() throws Exception {
        ExtentReporter.HeaderChildNode("mlWallet_ShopItems_with_Insufficient_Balance");
        mlWalletLogin(prop.getproperty("Buyer_Tier"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        editAddressAndPlaceTheOrder();
        verifyElementPresent(MLWalletShopItemsPage.objOtpPage, getTextVal(MLWalletShopItemsPage.objOtpPage, "Pop up"));
        Thread.sleep(2000);
        click(MLWalletShopItemsPage.objOtpTextField, "Otp Text Field");
        handleOtp(prop.getproperty("OTP"));
        click(MLWalletShopItemsPage.objValidateBtn, "Validate Button");
        String oOpsMsg = getText(MLWalletShopItemsPage.objInvalidOtpPopUp);
        String supplyFieldsMsg = getText(MLWalletShopItemsPage.objInvalidOtpPopUpMsg);
        logger.info(oOpsMsg + " " + supplyFieldsMsg + " Pop Up Message is displayed");
        ExtentReporter.extentLogger("", oOpsMsg + " " + supplyFieldsMsg + " Pop Up Message is displayed");
        logger.info("MLS_TC_02, Oops... Insufficient Balance. - Error message is validated ");
        ExtentReporter.extentLoggerPass("MLS_TC_02", "MLS_TC_02, Oops... Insufficient Balance. - Error message is validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void mlWallet_ShopItems_with_Incorrect_Otp() throws Exception {
        ExtentReporter.HeaderChildNode("mlWallet_ShopItems_with_Incorrect_Otp");
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        editAddressAndPlaceTheOrder();
        verifyElementPresent(MLWalletShopItemsPage.objOtpPage, getTextVal(MLWalletShopItemsPage.objOtpPage, "Pop up"));
        Thread.sleep(2000);
        click(MLWalletShopItemsPage.objOtpTextField, "Otp Text Field");
        handleOtp(prop.getproperty("incorrectOtp"));
        click(MLWalletShopItemsPage.objValidateBtn, "Validate Button");
        // Code to be written to validate incorrect otp msg
    }
    public void shopItemsWithoutInputOtp_MLS_TC_04() throws Exception {
        ExtentReporter.HeaderChildNode("mlWallet_ShopItems_without_Input_Otp");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        editAddressAndPlaceTheOrder();
        verifyElementPresent(MLWalletShopItemsPage.objOtpPage, getTextVal(MLWalletShopItemsPage.objOtpPage, "Pop up"));
        Thread.sleep(2000);
        click(MLWalletShopItemsPage.objValidateBtn, "Validate Button");
        String oOpsMsg = getText(MLWalletShopItemsPage.objInvalidOtpPopUp);
        String supplyFieldsMsg = getText(MLWalletShopItemsPage.objInvalidOtpPopUpMsg);
        logger.info(oOpsMsg + " " + supplyFieldsMsg + " Pop Up Message is displayed");
        ExtentReporter.extentLogger("", oOpsMsg + " " + supplyFieldsMsg + " Pop Up Message is displayed");
        logger.info("MLS_TC_04, Oops... Please supply all fields. - Error message is validated");
        ExtentReporter.extentLoggerPass("MLS_TC_04", "MLS_TC_04, Oops... Please supply all fields. - Error message is validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsHamburgerMenuNavigation_MLS_TC_12() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Hamburger Menu Navigation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objHambergerMenu, "Hamburger Menu");
        if (verifyElementPresent(MLWalletShopItemsPage.objSearch, getTextVal(MLWalletShopItemsPage.objSearch, "Button"))) {
            verifyElementPresent(MLWalletShopItemsPage.objProfile, getTextVal(MLWalletShopItemsPage.objProfile, "Button"));
            verifyElementPresent(MLWalletShopItemsPage.objCart, getTextVal(MLWalletShopItemsPage.objCart, "Button"));
            verifyElementPresent(MLWalletShopItemsPage.objShop, getTextVal(MLWalletShopItemsPage.objShop, "Button"));
            verifyElementPresent(MLWalletShopItemsPage.objAbout, getTextVal(MLWalletShopItemsPage.objAbout, "Button"));
            verifyElementPresent(MLWalletShopItemsPage.objContact, getTextVal(MLWalletShopItemsPage.objContact, "Button"));
            logger.info("MLS_TC_12, Shop Items Hamburger Menu Navigation validated");
            ExtentReporter.extentLoggerPass("MLS_TC_12", "MLS_TC_12, Shop Items Hamburger Menu Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsRespectivePageNavigationAfterSelectingAnCategory_MLS_TC_15() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Respective Page Navigation After Selecting An Category");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        if (verifyElementDisplayed(MLWalletShopItemsPage.objItems)) {
            List<WebElement> values = findElements(MLWalletShopItemsPage.objItems);
            for (int i = 0; i < values.size(); i++) {
                String displayedItem = values.get(i).getText();
                logger.info("Item : " + displayedItem + " is displayed");
                ExtentReporter.extentLogger(" ", "Item : " + displayedItem + " is displayed");
            }
        }
        verifyElementPresent(MLWalletShopItemsPage.objGenderDropdown, getTextVal(MLWalletShopItemsPage.objGenderDropdown, "Dropdown"));
        verifyElementPresent(MLWalletShopItemsPage.objColorDropdown, getTextVal(MLWalletShopItemsPage.objColorDropdown, "Dropdown"));
        verifyElementPresent(MLWalletShopItemsPage.objKaratDropdown, getTextVal(MLWalletShopItemsPage.objKaratDropdown, "Dropdown"));
        verifyElementPresent(MLWalletShopItemsPage.objPriceDropdown, getTextVal(MLWalletShopItemsPage.objPriceDropdown, "Dropdown"));
        logger.info("MLS_TC_15, Shop Items Respective Page Navigation After Selecting An Category validated");
        ExtentReporter.extentLoggerPass("MLS_TC_15", "MLS_TC_15, Shop Items Respective Page Navigation After Selecting An Category validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsSelectedItemScreenUIValidation_MLS_TC_18() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Selected Item Screen UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        Swipe("UP", 2);
        if (verifyElementPresent(MLWalletShopItemsPage.objProductImage, "Selected Product Image")) {
            verifyElementPresent(MLWalletShopItemsPage.objProductPrice, getTextVal(MLWalletShopItemsPage.objProductPrice, "Product Price"));
            verifyElementPresent(MLWalletShopItemsPage.objShippingTo, getTextVal(MLWalletShopItemsPage.objShippingTo, "Shipping To"));
            verifyElementPresent(MLWalletShopItemsPage.objShippingFee, getTextVal(MLWalletShopItemsPage.objShippingFee, "Shipping Fee"));
            verifyElementPresent(MLWalletShopItemsPage.objAddToCartBtn, getTextVal(MLWalletShopItemsPage.objAddToCartBtn, "Button"));
            verifyElementPresent(MLWalletShopItemsPage.objViewShop, getTextVal(MLWalletShopItemsPage.objViewShop, "Button"));
            logger.info("MLS_TC_18, Shop Items Selected Item Screen UI validated");
            ExtentReporter.extentLoggerPass("MLS_TC_18", "MLS_TC_18, Shop Items Selected Item Screen UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsCartPageUIValidation_MLS_TC_19() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Cart Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        if (verifyElementPresent(MLWalletShopItemsPage.objCartPageHeader, getTextVal(MLWalletShopItemsPage.objCartPageHeader, "Header"))) {
            verifyElementPresent(MLWalletShopItemsPage.objCheckBox, "Item Check Box");
            verifyElementPresent(MLWalletShopItemsPage.objProductNameInCartPage, getTextVal(MLWalletShopItemsPage.objProductNameInCartPage, "Product Name in Cart Page"));
            verifyElementPresent(MLWalletShopItemsPage.objPriceInCartPage, getTextVal(MLWalletShopItemsPage.objPriceInCartPage, "Price"));
            verifyElementPresent(MLWalletShopItemsPage.objDeleteIcon, "Delete Icon");
            verifyElementPresent(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn, "Button"));
            logger.info("MLS_TC_19, Shop Items Cart Page UI validated");
            ExtentReporter.extentLoggerPass("MLS_TC_19", "MLS_TC_19, Shop Items Cart Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsShippingDetailsPageUIValidation_MLS_TC_20() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Shipping Details Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        click(MLWalletShopItemsPage.objCheckBox, "Check Box");
        click(MLWalletShopItemsPage.objCheckOutBtn, "Checkout Button");
        if (verifyElementPresent(MLWalletShopItemsPage.objShippingDetails, getTextVal(MLWalletShopItemsPage.objShippingDetails, "Page"))) {
            verifyElementPresent(MLWalletShopItemsPage.objAddAddress, getTextVal(MLWalletShopItemsPage.objAddAddress, "Button"));
            verifyElementPresent(MLWalletShopItemsPage.objEditAddress, "Edit address Icon");
            verifyElementPresent(MLWalletShopItemsPage.objHeader, getTextVal(MLWalletShopItemsPage.objHeader, "Header"));
            verifyElementPresent(MLWalletShopItemsPage.objProductNameInShippingDetails, getTextVal(MLWalletShopItemsPage.objProductNameInShippingDetails, "Product Name in Shipping Details"));
            verifyElementPresent(MLWalletShopItemsPage.objProductQuantity, getTextVal(MLWalletShopItemsPage.objProductQuantity, "Product Quantity"));
            verifyElementPresent(MLWalletShopItemsPage.objItemSubTotal, getTextVal(MLWalletShopItemsPage.objItemSubTotal, "Item SubTotal"));
            verifyElementPresent(MLWalletShopItemsPage.objTotalOrder, getTextVal(MLWalletShopItemsPage.objTotalOrder, "Total Order"));
            Swipe("UP", 2);
            verifyElementPresent(MLWalletShopItemsPage.objServiceFee, getTextVal(MLWalletShopItemsPage.objServiceFee, "Service Fee"));
            verifyElementPresent(MLWalletShopItemsPage.objShippingFeeInShippingDetails, getTextVal(MLWalletShopItemsPage.objShippingFeeInShippingDetails, "Shipping Fee in Shipping Details"));
            verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethod, getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod, "Header"));
            verifyElementPresent(MLWalletShopItemsPage.objMLWallet, getTextVal(MLWalletShopItemsPage.objMLWallet, "Payment Method"));
            verifyElementPresent(MLWalletShopItemsPage.objOnlineBanking, getTextVal(MLWalletShopItemsPage.objOnlineBanking, "Payment Method"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletShopItemsPage.objMerchandiseSubTotal, getTextVal(MLWalletShopItemsPage.objMerchandiseSubTotal, "Merchandise Subtotal"));
            verifyElementPresent(MLWalletShopItemsPage.objServiceTotal, getTextVal(MLWalletShopItemsPage.objServiceTotal, "Service Total"));
            verifyElementPresent(MLWalletShopItemsPage.objShippingTotal, getTextVal(MLWalletShopItemsPage.objShippingTotal, "Shipping Total"));
            verifyElementPresent(MLWalletShopItemsPage.objPaymentTotal, getTextVal(MLWalletShopItemsPage.objPaymentTotal, "Total Payment"));
            verifyElementPresent(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn, "Button"));
            logger.info("MLS_TC_20, Shop Items Shipping Details Page UI validated");
            ExtentReporter.extentLoggerPass("MLS_TC_20", "MLS_TC_20, Shop Items Shipping Details Page UI validated");
            System.out.println("-----------------------------------------------------------");

        }
    }

    public void shopItemsSelectBranchAddressPageUIValidation_MLS_TC_21() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Select Branch Address Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        click(MLWalletShopItemsPage.objCheckBox, "Check Box");
        click(MLWalletShopItemsPage.objCheckOutBtn, "Checkout Button");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objEditAddress, "Edit address Icon");
        if (verifyElementPresent(MLWalletShopItemsPage.objInputFieldOne, getTextVal(MLWalletShopItemsPage.objInputFieldOne, "Select Branch Address Field 1"))) {
            verifyElementPresent(MLWalletShopItemsPage.objInputFieldTwo, getTextVal(MLWalletShopItemsPage.objInputFieldTwo, "Select Branch Address Field 2"));
            verifyElementPresent(MLWalletShopItemsPage.objInputFieldThree, getTextVal(MLWalletShopItemsPage.objInputFieldThree, "Select Branch Address Field 3"));
            verifyElementPresent(MLWalletShopItemsPage.objSaveBtn, getTextVal(MLWalletShopItemsPage.objSaveBtn, "Button"));
            verifyElementPresent(MLWalletShopItemsPage.objCancel, getTextVal(MLWalletShopItemsPage.objCancel, "Button"));
            logger.info("MLS_TC_21, Shop Items Select Branch Address Page UI validated");
            ExtentReporter.extentLoggerPass("MLS_TC_21", "MLS_TC_21, Shop Items Select Branch Address Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void shopItemsSaveBtnFunctionalityOnSelectBranchScreen_MLS_TC_22() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Save Button Functionality On Select Branch Screen");
        shopItemsSelectBranchAddressPageUIValidation_MLS_TC_21();
        click(MLWalletShopItemsPage.objSaveBtn, getTextVal(MLWalletShopItemsPage.objSaveBtn, "Button"));
        if (verifyElementPresent(MLWalletShopItemsPage.objAddressUpdateMsg, getTextVal(MLWalletShopItemsPage.objAddressUpdateMsg, "Message"))) {
            verifyElementPresent(MLWalletShopItemsPage.objOkBtn, getTextVal(MLWalletShopItemsPage.objOkBtn, "Button"));
            logger.info("MLS_TC_22, Shop Items Select Branch Address Page UI validated");
            ExtentReporter.extentLoggerPass("MLS_TC_22", "MLS_TC_22, Shop Items Select Branch Address Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsCancelBtnFunctionalityOnSelectBranchScreen_MLS_TC_23() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Cancel Button Functionality On Select Branch Screen");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        click(MLWalletShopItemsPage.objCheckBox, "Check Box");
        click(MLWalletShopItemsPage.objCheckOutBtn, "Checkout Button");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objEditAddress, "Edit address Icon");
        String sSelectAddressOne = getText(MLWalletShopItemsPage.objInputFieldOne);
        String sSelectAddressTwo = getText(MLWalletShopItemsPage.objInputFieldTwo);
        String sSelectAddressThree = getText(MLWalletShopItemsPage.objInputFieldThree);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCancel, getTextVal(MLWalletShopItemsPage.objCancel, "Button"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objEditAddress, "Edit address Icon");
        String sActualSelectAddressOne = getText(MLWalletShopItemsPage.objInputFieldOne);
        String sActualSelectAddressTwo = getText(MLWalletShopItemsPage.objInputFieldTwo);
        String sActualSelectAddressThree = getText(MLWalletShopItemsPage.objInputFieldThree);
        assertionValidation(sActualSelectAddressOne, sSelectAddressOne);
        assertionValidation(sActualSelectAddressTwo, sSelectAddressTwo);
        assertionValidation(sActualSelectAddressThree, sSelectAddressThree);
        logger.info("MLS_TC_23, Shop Items Cancel Button Functionality On Select Branch Screen validated");
        ExtentReporter.extentLoggerPass("MLS_TC_23", "MLS_TC_23, Shop Items Cancel Button Functionality On Select Branch Screen validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void shopItemsPlaceOrderBtnFunctionalityOnShippingDetailsScreen_MLS_TC_24() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Place Order Button Functionality On Shipping Details Screen");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        editAddressAndPlaceTheOrder();
        if (verifyElementPresent(MLWalletShopItemsPage.objOtpPage, getTextVal(MLWalletShopItemsPage.objOtpPage, "Pop up"))) {
            logger.info("MLS_TC_24, Shop Items Place Order Button Functionality On Shipping Details Screen validated");
            ExtentReporter.extentLoggerPass("MLS_TC_24", "MLS_TC_24, Shop Items Place Order Button Functionality On Shipping Details Screen validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void shopItemsOneTimePinPageUIValidation_MLS_TC_25() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items One Time Pin Page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        editAddressAndPlaceTheOrder();
        if (verifyElementPresent(MLWalletShopItemsPage.objOtpPage, getTextVal(MLWalletShopItemsPage.objOtpPage, "Pop up"))) {
            verifyElementPresent(MLWalletShopItemsPage.objOTPMsg, getTextVal(MLWalletShopItemsPage.objOTPMsg, "Message"));
            verifyElementPresent(MLWalletShopItemsPage.objValidateBtn, getTextVal(MLWalletShopItemsPage.objValidateBtn, "Button"));
            verifyElementPresent(MLWalletShopItemsPage.objCancel, getTextVal(MLWalletShopItemsPage.objCancel, "Buttn"));
            logger.info("MLS_TC_25, Shop Items One Time Pin Page UI validated");
            ExtentReporter.extentLoggerPass("MLS_TC_25", "MLS_TC_25, Shop Items One Time Pin Page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsCancelBtnFunctionalityOnOTPScreen_MLS_TC_26() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Cancel Button Functionality on OTP Screen");
        shopItemsOneTimePinPageUIValidation_MLS_TC_25();
        click(MLWalletShopItemsPage.objCancel, getTextVal(MLWalletShopItemsPage.objCancel, "Button"));
        waitTime(4000);
        if (verifyElementPresent(MLWalletShopItemsPage.objPlaceOrderBtn, getTextVal(MLWalletShopItemsPage.objPlaceOrderBtn, "Button"))) {
            logger.info("MLS_TC_26, Shop Items Cancel Button Functionality on OTP Screen validated");
            ExtentReporter.extentLoggerPass("MLS_TC_26", "MLS_TC_26, Shop Items Cancel Button Functionality on OTP Screen validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPlacingAnOrderWithOutSelectingPaymentMethod_MLS_TC_33() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Placing An Order without Selecting payment method");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        click(MLWalletShopItemsPage.objCheckBox, "Check Box");
        click(MLWalletShopItemsPage.objCheckOutBtn, "Checkout Button");
        click(MLWalletShopItemsPage.objEditAddress, "Edit Address Tab");
        verifyElementPresent(MLWalletShopItemsPage.objSelectBranchPage, getTextVal(MLWalletShopItemsPage.objSelectBranchPage, "Page"));
        click(MLWalletShopItemsPage.objSaveBtn, "Save Button");
        verifyElementPresent(MLWalletShopItemsPage.objAddressSuccessfulMsg, getTextVal(MLWalletShopItemsPage.objAddressSuccessfulMsg, "Message"));
        click(MLWalletShopItemsPage.objOkBtn, "OK Button");
        Swipe("UP", 4);
        click(MLWalletShopItemsPage.objPlaceOrderBtn, "Place Order Button");
        if (verifyElementPresent(MLWalletShopItemsPage.objErrorPopup, getTextVal(MLWalletShopItemsPage.objErrorPopup, "Error Popup"))) {
            String sActualErrorPopup = getText(MLWalletShopItemsPage.objErrorPopup);
            String sExpectedErrorPopup = "Please select payment method.";
            assertionValidation(sActualErrorPopup, sExpectedErrorPopup);
            verifyElementPresent(MLWalletShopItemsPage.objOkBtn, getTextVal(MLWalletShopItemsPage.objOkBtn, "Button"));
            logger.info("MLS_TC_33, Please select payment method. Error message validated");
            ExtentReporter.extentLoggerPass("MLS_TC_33", "MLS_TC_33, Please select payment method. Error message validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsOkBtnFunctionalityOnErrorPopup_MLS_TC_34() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Ok Button Functionality On Error popup");
        shopItemsPlacingAnOrderWithOutSelectingPaymentMethod_MLS_TC_33();
        click(MLWalletShopItemsPage.objOkBtn, getTextVal(MLWalletShopItemsPage.objOkBtn, "Button"));
        if (verifyElementNotPresent(MLWalletShopItemsPage.objErrorPopup, "Error popup", 5)) {
            logger.info("MLS_TC_34, Error popup disappeared after clicking on Ok Button is validated");
            ExtentReporter.extentLoggerPass("MLS_TC_34", "MLS_TC_34, Error popup disappeared after clicking on Ok Button is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsCartPageNavigation_MLS_TC_42() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Cart Page Navigation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        if (verifyElementPresent(MLWalletShopItemsPage.objCartPageHeader, getTextVal(MLWalletShopItemsPage.objCartPageHeader, "Header"))) {
            verifyElementPresent(MLWalletShopItemsPage.objCheckBox, "Item Check Box");
            verifyElementPresent(MLWalletShopItemsPage.objProductNameInCartPage, getTextVal(MLWalletShopItemsPage.objProductNameInCartPage, "Product Name in Cart Page"));
            verifyElementPresent(MLWalletShopItemsPage.objPriceInCartPage, getTextVal(MLWalletShopItemsPage.objPriceInCartPage, "Price"));
            verifyElementPresent(MLWalletShopItemsPage.objDeleteIcon, "Delete Icon");
            verifyElementPresent(MLWalletShopItemsPage.objCheckOutBtn, getTextVal(MLWalletShopItemsPage.objCheckOutBtn, "Button"));
            logger.info("MLS_TC_42, Shop Items Cart Page Navigation validated");
            ExtentReporter.extentLoggerPass("MLS_TC_42", "MLS_TC_42, Shop Items Cart Page Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsCancelBtnFunctionalityOnRemoveItemPopup_MLS_TC_43() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Cancel Button Functionality On Remove Item Popup");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objDeleteIcon, "Delete Icon");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCancel, getTextVal(MLWalletShopItemsPage.objCancel, "Button"));
        if (verifyElementPresent(MLWalletShopItemsPage.objCheckOutBtn, "Cart Page")) {
            logger.info("MLS_TC_43, Shop Items Cancel Button Functionality On Remove Item Popup validated");
            ExtentReporter.extentLoggerPass("MLS_TC_43", "MLS_TC_43, Shop Items Cancel Button Functionality On Remove Item Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void shopItemsOkBtnFunctionalityOnRemoveItemPopup_MLS_TC_44() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Ok Button Functionality On Remove Item Popup");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objDeleteIcon, "Delete Icon");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objYesBtn, getTextVal(MLWalletShopItemsPage.objYesBtn, "Button"));
        if (verifyElementNotPresent(MLWalletShopItemsPage.objProductNameInCartPage, "Cart Page", 5)) {
            logger.info("MLS_TC_44, Shop Items Ok Button Functionality On Remove Item Popup validated");
            ExtentReporter.extentLoggerPass("MLS_TC_44", "MLS_TC_44, Shop Items Ok Button Functionality On Remove Item Popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsNavigationToProfileOption_MLS_TC_46() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Navigation To Profile Option");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        click(MLWalletShopItemsPage.objHambergerMenu, "Hamburger Menu");
        click(MLWalletShopItemsPage.objProfile, getTextVal(MLWalletShopItemsPage.objProfile, "Option"));
        if (verifyElementPresent(MLWalletShopItemsPage.objMyAccount, getTextVal(MLWalletShopItemsPage.objMyAccount, "Page"))) {
            logger.info("MLS_TC_46, Shop Items Navigation To Profile Option validated");
            ExtentReporter.extentLoggerPass("MLS_TC_46", "MLS_TC_46, Shop Items Navigation To Profile Option validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsProfileScreenNavigation_MLS_TC_47() throws Exception {
        ExtentReporter.HeaderChildNode("Shop items Profile Screen Navigation");
        shopItemsNavigationToProfileOption_MLS_TC_46();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMyAccountDropdown, getTextVal(MLWalletShopItemsPage.objMyAccountDropdown, "Dropdown"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProfile, getTextVal(MLWalletShopItemsPage.objProfile, "Dropdown Element"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMyAccountPageCrossBtn, "Cross Button");
        if (verifyElementPresent(MLWalletShopItemsPage.objMyProfileHeader, getTextVal(MLWalletShopItemsPage.objMyProfileHeader, "Header"))) {
            logger.info("MLS_TC_47, Shop items Profile Screen Navigation validated");
            ExtentReporter.extentLoggerPass("MLS_TC_47", "MLS_TC_47, Shop items Profile Screen Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsMyAccountPopupCrossBtnFunctionality_MLS_TC_48() throws Exception {
        ExtentReporter.HeaderChildNode("Shop items My Account Popup Cross Btn Functionality");
        shopItemsNavigationToProfileOption_MLS_TC_46();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMyAccountDropdown, getTextVal(MLWalletShopItemsPage.objMyAccountDropdown, "Dropdown"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProfile, getTextVal(MLWalletShopItemsPage.objProfile, "Dropdown Element"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMyAccountPageCrossBtn, "Cross Button");
        if (verifyElementPresent(MLWalletShopItemsPage.objMyProfileHeader, getTextVal(MLWalletShopItemsPage.objMyProfileHeader, "Header"))) {
            logger.info("MLS_TC_48, Shop items My Account Popup Cross Btn Functionality validated");
            ExtentReporter.extentLoggerPass("MLS_TC_48", "MLS_TC_48, Shop items My Account Popup Cross Btn Functionality validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsMyPurchasePageNavigation_MLS_TC_49() throws Exception {
        ExtentReporter.HeaderChildNode("Shop items My Purchase Page Navigation");
        shopItemsNavigationToProfileOption_MLS_TC_46();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMyPurchase, getTextVal(MLWalletShopItemsPage.objMyPurchase, "Option"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMyAccountPageCrossBtn, "Cross Button");
        if (verifyElementPresent(MLWalletShopItemsPage.objOrderDetails, getTextVal(MLWalletShopItemsPage.objOrderDetails, "Button"))) {
            logger.info("MLS_TC_49, Shop items My Purchase Page Navigation validated");
            ExtentReporter.extentLoggerPass("MLS_TC_49", "MLS_TC_49, Shop items My Purchase Page Navigation validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSubTotalVerificationWithOutSelectingTheItemsInCart_MLS_TC_59() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Total subTotal Verification without selecting the items in the Cart");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        if (verifyElementPresent(MLWalletShopItemsPage.objSubtotalAmount, getTextVal(MLWalletShopItemsPage.objSubtotalAmount, "SubTotal Items"))) {
            String sActualSubtotalItems = getText(MLWalletShopItemsPage.objSubtotalAmount);
            String sExceptedSubtotalItems = "P 0.00";
            assertionValidation(sActualSubtotalItems, sExceptedSubtotalItems);
            logger.info("MLS_TC_59, Shop Items Total subTotal Verification without selecting the items in the Cart validated");
            ExtentReporter.extentLoggerPass("MLS_TC_59", "MLS_TC_59, Shop Items Total subTotal Verification without selecting the items in the Cart validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void shopItemsSubTotalVerificationWithSelectingTheItemsInCart_MLS_TC_60() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Total subTotal Verification with selecting the items in the Cart");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCheckBox, "Check Box");
        waitTime(5000);
        if (verifyElementPresent(MLWalletShopItemsPage.objSubtotalAmount, getTextVal(MLWalletShopItemsPage.objSubtotalAmount, "SubTotal Items"))) {
            String sSelectItemPrice = getText(MLWalletShopItemsPage.objSelectedItemPrice);
            String sActualSubtotalItems = getText(MLWalletShopItemsPage.objSubtotalAmount);
            assertionValidation(sActualSubtotalItems, sSelectItemPrice);
            logger.info("MLS_TC_60, Shop Items Total subTotal Verification with selecting the items in the Cart validated");
            ExtentReporter.extentLoggerPass("MLS_TC_60", "MLS_TC_60, Shop Items Total subTotal Verification with selecting the items in the Cart validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAboutLinkFunctionality_MLS_TC_83() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items About Link Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objHambergerMenu, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objAbout, getTextVal(MLWalletShopItemsPage.objAbout, "Button"));
        if (verifyElementPresent(MLWalletShopItemsPage.objJewelry, getTextVal(MLWalletShopItemsPage.objJewelry, "Page"))) {
            logger.info("MLS_TC_83, After Clicking on About link from Hamburger menu, Application navigates to Jewelry Page is validated");
            ExtentReporter.extentLoggerPass("MLS_TC_83", "MLS_TC_83, After Clicking on About link from Hamburger menu, Application navigates to Jewelry Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsContactLinkFunctionality_MLS_TC_84() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Contact Link Functionality");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        verifyElementPresentAndClick(MLWalletShopItemsPage.objHambergerMenu, "Hamburger Menu");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objContact, getTextVal(MLWalletShopItemsPage.objContact, "Button"));
        if (verifyElementPresent(MLWalletShopItemsPage.objContactUs, getTextVal(MLWalletShopItemsPage.objContactUs, "Page"))) {
            logger.info("MLS_TC_84, After Clicking on contact link from Hamburger menu, Application navigates to Contact Us Page is validated");
            ExtentReporter.extentLoggerPass("MLS_TC_84", "MLS_TC_84, After Clicking on contact link from Hamburger menu, Application navigates to Contact Us Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsGreatDealsForFineWatchesValidation_MLS_TC_85() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Great Deals for Fine Watches Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        swipeDownUntilElementVisible("Great Deals for Fine Watches");
        if (verifyElementPresent(MLWalletShopItemsPage.objGreatDealsForFineWatches, getTextVal(MLWalletShopItemsPage.objGreatDealsForFineWatches, "Header"))) {
            Swipe("UP", 1);
            verifyElementPresent(MLWalletShopItemsPage.objRolex, getTextVal(MLWalletShopItemsPage.objRolex, "Watch Products"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletShopItemsPage.objHamilton, getTextVal(MLWalletShopItemsPage.objHamilton, "Watch Products"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletShopItemsPage.objOmega, getTextVal(MLWalletShopItemsPage.objOmega, "Watch Product"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletShopItemsPage.objTagHeuer, getTextVal(MLWalletShopItemsPage.objTagHeuer, "Watch Product"));
            logger.info("MLS_TC_85, Shop Items Great Deals for Fine Watches validated");
            ExtentReporter.extentLoggerPass("MLS_TC_85", "MLS_TC_85, Shop Items Great Deals for Fine Watches validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsProductDetailsValidation_MLS_TC_86() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Product Details Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        waitTime(10000);
        if (verifyElementPresent(MLWalletShopItemsPage.objProductImage, "Product Image")) {
            verifyElementPresent(MLWalletShopItemsPage.objProductName, getTextVal(MLWalletShopItemsPage.objProductName, "Product Name"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountPercentage, getTextVal(MLWalletShopItemsPage.objDiscountPercentage, "Discount Percentage"));
            verifyElementPresent(MLWalletShopItemsPage.objOriginalPrice, getTextVal(MLWalletShopItemsPage.objOriginalPrice, "Original Price"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountPrice, getTextVal(MLWalletShopItemsPage.objDiscountPrice, "Discount Price"));
            logger.info("MLS_TC_86, Shop Items Product Details validated");
            ExtentReporter.extentLoggerPass("MLS_TC_86", "MLS_TC_86, Shop Items Product Details validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsCategoriesValidation_MLS_TC_88() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Categories Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCategoriesHamburgerMenu, "Categories Hamburger Menu");
        if (verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Menu"))) {
            verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollections, getTextVal(MLWalletShopItemsPage.objAmparitoCollections, "Category Header"));
            verifyElementPresent(MLWalletShopItemsPage.objFineJewelry, getTextVal(MLWalletShopItemsPage.objFineJewelry, "Category Header"));
            logger.info("MLS_TC_88, Shop Items Categories validated");
            ExtentReporter.extentLoggerPass("MLS_TC_88", "MLS_TC_88, Shop Items Categories validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAmparitoCollectionsProductTypesValidation_MLS_TC_89() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Amparito Collections Product Types Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCategoriesHamburgerMenu, "Categories Hamburger Menu");
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Menu"));
        verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollections, getTextVal(MLWalletShopItemsPage.objAmparitoCollections, "Category Header"));
        for (int i = 1; i <= 9; i++) {
            verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollectionsProductTypes(i), getTextVal(MLWalletShopItemsPage.objAmparitoCollectionsProductTypes(i), "Product Type"));
        }
        logger.info("MLS_TC_89, Shop Items Amparito Collections Product Types validated");
        ExtentReporter.extentLoggerPass("MLS_TC_89", "MLS_TC_89, Shop Items Amparito Collections Product Types validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsAmparitoCollectionsRingProductTypeSubTypesValidation_MLS_TC_90() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Amparito Collections Ring Product Type SubTypes Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCategoriesHamburgerMenu, "Categories Hamburger Menu");
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Menu"));
        verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollections, getTextVal(MLWalletShopItemsPage.objAmparitoCollections, "Category Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objRing, getTextVal(MLWalletShopItemsPage.objRing, "Product Type"));
        for (int i = 1; i <= 6; i++) {
            verifyElementPresent(MLWalletShopItemsPage.objRingsSubTypes(i), getTextVal(MLWalletShopItemsPage.objRingsSubTypes(i), "Ring SubType"));
        }
        logger.info("MLS_TC_90, Shop Items Amparito Collections Ring Product Type SubTypes validated");
        ExtentReporter.extentLoggerPass("MLS_TC_90", "MLS_TC_90, Shop Items Amparito Collections Ring Product Type SubTypes validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsAmparitoCollectionsNecklaceProductTypeSubTypesValidation_MLS_TC_91() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Amparito Collections Necklace Product Type SubTypes Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCategoriesHamburgerMenu, "Categories Hamburger Menu");
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Menu"));
        verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollections, getTextVal(MLWalletShopItemsPage.objAmparitoCollections, "Category Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objNecklace, getTextVal(MLWalletShopItemsPage.objNecklace, "Product Type"));
        for (int i = 1; i <= 15; i++) {
            verifyElementPresent(MLWalletShopItemsPage.objNecklaceSubTypes(i), getTextVal(MLWalletShopItemsPage.objNecklaceSubTypes(i), "Necklace SubType"));
        }
        logger.info("MLS_TC_91, Shop Items Amparito Collections Necklace Product Type SubTypes validated");
        ExtentReporter.extentLoggerPass("MLS_TC_91", "MLS_TC_91, Shop Items Amparito Collections Necklace Product Type SubTypes validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void shopItemsAmparitoCollectionsBraceletAndBangleProductTypeSubTypesValidation_MLS_TC_92() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Amparito Collections Bracelet And Bangle Product Type SubTypes Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCategoriesHamburgerMenu, "Categories Hamburger Menu");
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Menu"));
        verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollections, getTextVal(MLWalletShopItemsPage.objAmparitoCollections, "Category Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objBraceletAndBangle, getTextVal(MLWalletShopItemsPage.objBraceletAndBangle, "Product Type"));
        for (int i = 1; i <= 6; i++) {
            verifyElementPresent(MLWalletShopItemsPage.objBraceletAndBangleSubTypes(i), getTextVal(MLWalletShopItemsPage.objBraceletAndBangleSubTypes(i), "Bracelet And Bangle SubType"));
        }
        logger.info("MLS_TC_92, Shop Items Amparito Collections Bracelet And Bangle Product Type SubTypes validated");
        ExtentReporter.extentLoggerPass("MLS_TC_92", "MLS_TC_92, Shop Items Amparito Collections Bracelet And Bangle Product Type SubTypes validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void shopItemsAmparitoCollectionsEarringsProductTypeSubTypesValidation_MLS_TC_93() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Amparito Collections Earrings Product Type SubTypes Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCategoriesHamburgerMenu, "Categories Hamburger Menu");
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Menu"));
        verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollections, getTextVal(MLWalletShopItemsPage.objAmparitoCollections, "Category Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objEarrings, getTextVal(MLWalletShopItemsPage.objEarrings, "Product Type"));
        for (int i = 1; i <= 7; i++) {
            verifyElementPresent(MLWalletShopItemsPage.objEarringsSubTypes(i), getTextVal(MLWalletShopItemsPage.objEarringsSubTypes(i), "Earrings SubType"));
        }
        logger.info("MLS_TC_93, Shop Items Amparito Collections Earrings Product Type SubTypes validated");
        ExtentReporter.extentLoggerPass("MLS_TC_93", "MLS_TC_93, Shop Items Amparito Collections Earrings Product Type SubTypes validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void shopItemsAmparitoCollectionsPendantProductTypeSubTypesValidation_MLS_TC_94() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Amparito Collections Pendant Product Type SubTypes Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCategoriesHamburgerMenu, "Categories Hamburger Menu");
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Menu"));
        verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollections, getTextVal(MLWalletShopItemsPage.objAmparitoCollections, "Category Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPendant, getTextVal(MLWalletShopItemsPage.objPendant, "Product Type"));
        for (int i = 1; i <= 6; i++) {
            verifyElementPresent(MLWalletShopItemsPage.objPendantSubTypes(i), getTextVal(MLWalletShopItemsPage.objPendantSubTypes(i), "Pendant SubType"));
        }
        logger.info("MLS_TC_94, Shop Items Amparito Collections Pendant Product Type SubTypes validated");
        ExtentReporter.extentLoggerPass("MLS_TC_94", "MLS_TC_94, Shop Items Amparito Collections Pendant Product Type SubTypes validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void shopItemsAmparitoCollectionsTernoAndSetProductTypeSubTypesValidation_MLS_TC_95() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Amparito Collections Terno and Set Product Type SubTypes Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCategoriesHamburgerMenu, "Categories Hamburger Menu");
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Menu"));
        verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollections, getTextVal(MLWalletShopItemsPage.objAmparitoCollections, "Category Header"));
        if (verifyElementPresentAndClick(MLWalletShopItemsPage.objTernoAndSet, getTextVal(MLWalletShopItemsPage.objTernoAndSet, "Product Type"))) {
            verifyElementPresent(MLWalletShopItemsPage.objTernoAndSetSubTypes, getTextVal(MLWalletShopItemsPage.objTernoAndSetSubTypes, "Terno and Set SubType"));
            logger.info("MLS_TC_95, Shop Items Amparito Collections Terno and Set Product Type SubTypes validated");
            ExtentReporter.extentLoggerPass("MLS_TC_95", "MLS_TC_95, Shop Items Amparito Collections Terno and Set Product Type SubTypes validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void shopItemsAmparitoCollectionsWeddingRingProductTypeSubTypesValidation_MLS_TC_96() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Amparito Collections Wedding Ring Product Type SubTypes Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCategoriesHamburgerMenu, "Categories Hamburger Menu");
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Menu"));
        verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollections, getTextVal(MLWalletShopItemsPage.objAmparitoCollections, "Category Header"));
        if (verifyElementPresentAndClick(MLWalletShopItemsPage.objWeddingRing, getTextVal(MLWalletShopItemsPage.objWeddingRing, "Product Type"))) {
            verifyElementPresent(MLWalletShopItemsPage.objWeddingRingSubTypes, getTextVal(MLWalletShopItemsPage.objWeddingRingSubTypes, "Wedding Ring SubType"));
            logger.info("MLS_TC_96, Shop Items Amparito Collections Wedding Ring Product Type SubTypes validated");
            ExtentReporter.extentLoggerPass("MLS_TC_96", "MLS_TC_96, Shop Items Amparito Collections Wedding Ring Product Type SubTypes validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsAmparitoCollectionsPinBrouchAndScalpingProductTypeSubTypesValidation_MLS_TC_97() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Amparito Collections Pin, Brouch & Scalping Product Type SubTypes Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCategoriesHamburgerMenu, "Categories Hamburger Menu");
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Menu"));
        verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollections, getTextVal(MLWalletShopItemsPage.objAmparitoCollections, "Category Header"));
        if (verifyElementPresentAndClick(MLWalletShopItemsPage.objPinBrouchAndScalpings, getTextVal(MLWalletShopItemsPage.objPinBrouchAndScalpings, "Product Type"))) {
            verifyElementPresent(MLWalletShopItemsPage.objPinBrouchAndScalpingsSubTypes, getTextVal(MLWalletShopItemsPage.objPinBrouchAndScalpingsSubTypes, "Pin, Brouch & Scalpings SubType"));
            logger.info("MLS_TC_97, Shop Items Amparito Collections Pin, Brouch & Scalpings Product Type SubTypes validated");
            ExtentReporter.extentLoggerPass("MLS_TC_97", "MLS_TC_97, Shop Items Amparito Collections Pin, Brouch & Scalpings Product Type SubTypes validated");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void shopItemsAmparitoCollectionsWatchesProductTypeSubTypesValidation_MLS_TC_98() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Amparito Collections Watches Product Type SubTypes Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objCategoriesHamburgerMenu, "Categories Hamburger Menu");
        verifyElementPresent(MLWalletShopItemsPage.objCategory, getTextVal(MLWalletShopItemsPage.objCategory, "Menu"));
        verifyElementPresent(MLWalletShopItemsPage.objAmparitoCollections, getTextVal(MLWalletShopItemsPage.objAmparitoCollections, "Category Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objWatches, getTextVal(MLWalletShopItemsPage.objWatches, "Product Type"));
        for (int i = 1; i <= 8; i++) {
            verifyElementPresent(MLWalletShopItemsPage.objWatchesSubTypes(i), getTextVal(MLWalletShopItemsPage.objWatchesSubTypes(i), "Bracelet And Bangle SubType"));
        }
        logger.info("MLS_TC_98, Shop Items Amparito Collections Watches Product Type SubTypes validated");
        ExtentReporter.extentLoggerPass("MLS_TC_98", "MLS_TC_98, Shop Items Amparito Collections Watches Product Type SubTypes validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsGenderFilterValidation_MLS_TC_99() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Gender Filter Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objGender, getTextVal(MLWalletShopItemsPage.objGender, "Filter"));
        for (int i = 1; i <= 5; i++) {
            verifyElementPresent(MLWalletShopItemsPage.objFilterCheckBox(i), getTextVal(MLWalletShopItemsPage.objFilterCheckBox(i), "CheckBox"));
        }
        logger.info("MLS_TC_99, Shop Items Gender Filter validated");
        ExtentReporter.extentLoggerPass("MLS_TC_99", "MLS_TC_99, Shop Items Gender Filter validated");
        System.out.println("-----------------------------------------------------------");
    }


    public void shopItemsColorFilterValidation_MLS_TC_100() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Color Filter Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objColor, getTextVal(MLWalletShopItemsPage.objColor, "Filter"));
        for (int i = 1; i <= 6; i++) {
            verifyElementPresent(MLWalletShopItemsPage.objFilterCheckBox(i), getTextVal(MLWalletShopItemsPage.objFilterCheckBox(i), "CheckBox"));
        }
        logger.info("MLS_TC_100, Shop Items Color Filter validated");
        ExtentReporter.extentLoggerPass("MLS_TC_100", "MLS_TC_100, Shop Items Color Filter validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsKaratFilterValidation_MLS_TC_101() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Karat Filter Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objKarat, getTextVal(MLWalletShopItemsPage.objKarat, "Filter"));
        for (int i = 1; i <= 6; i++) {
            verifyElementPresent(MLWalletShopItemsPage.objFilterCheckBox(i), getTextVal(MLWalletShopItemsPage.objFilterCheckBox(i), "CheckBox"));
        }
        logger.info("MLS_TC_101, Shop Items Karat Filter validated");
        ExtentReporter.extentLoggerPass("MLS_TC_101", "MLS_TC_101, Shop Items Karat Filter validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsPriceFilterValidation_MLS_TC_102() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Price Filter Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPrice, getTextVal(MLWalletShopItemsPage.objPrice, "Filter"));
        for (int i = 1; i <= 3; i++) {
            verifyElementPresent(MLWalletShopItemsPage.objFilterCheckBox(i), getTextVal(MLWalletShopItemsPage.objFilterCheckBox(i), "CheckBox"));
        }
        logger.info("MLS_TC_102, Shop Items Price Filter validated");
        ExtentReporter.extentLoggerPass("MLS_TC_102", "MLS_TC_102, Shop Items Price Filter validated");
        System.out.println("-----------------------------------------------------------");
    }

    public void shopItemsProductDetailsPageValidation_MLS_TC_103() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Product details Page validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        waitTime(5000);
        if (verifyElementPresent(MLWalletShopItemsPage.objMainProductImage, "Product Image in Product Details Page")) {
            verifyElementPresent(MLWalletShopItemsPage.objOptionalProductImage, "Optional Product Image");
            verifyElementPresent(MLWalletShopItemsPage.objProductNameInProductDetails, getTextVal(MLWalletShopItemsPage.objProductNameInProductDetails, " : Product Name in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objColorInProductDetails, getTextVal(MLWalletShopItemsPage.objColorInProductDetails, "Color in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objKaratInProductDetails, getTextVal(MLWalletShopItemsPage.objKaratInProductDetails, "Karat in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objGenderInProductDetails, getTextVal(MLWalletShopItemsPage.objGenderInProductDetails, "Gender in Product details"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletShopItemsPage.objPriceInProductDetails, getTextVal(MLWalletShopItemsPage.objPriceInProductDetails, "Header in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objActualPriceInProductDetails, getTextVal(MLWalletShopItemsPage.objActualPriceInProductDetails, "Actual Price in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountPriceInProductDetails, getTextVal(MLWalletShopItemsPage.objDiscountPriceInProductDetails, "Discount Price in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objShippingTo, getTextVal(MLWalletShopItemsPage.objShippingTo, "Shipping To"));
            verifyElementPresent(MLWalletShopItemsPage.objShippingFee, getTextVal(MLWalletShopItemsPage.objShippingFee, "Shipping Fee"));
            logger.info("MLS_TC_103, Shop Items Product details Page validated");
            ExtentReporter.extentLoggerPass("MLS_TC_103", "MLS_TC_103, Shop Items Product details Page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSellerDetailsInProductDetailsPageValidation_MLS_TC_104() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Seller Details In Product Details Page validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        waitTime(5000);
        Swipe("UP", 2);
        if (verifyElementPresent(MLWalletShopItemsPage.objShopName, getTextVal(MLWalletShopItemsPage.objShopName, "Shop Name"))) {
            verifyElementPresent(MLWalletShopItemsPage.objShopMobileNumber, getTextVal(MLWalletShopItemsPage.objShopMobileNumber, "Shop Mobile Number"));
            verifyElementPresent(MLWalletShopItemsPage.objShopEmailID, getTextVal(MLWalletShopItemsPage.objShopEmailID, "Shop Email ID"));
            verifyElementPresent(MLWalletShopItemsPage.objTotalProducts, getTextVal(MLWalletShopItemsPage.objTotalProducts, "Total Products"));
            verifyElementPresent(MLWalletShopItemsPage.objSoldProducts, getTextVal(MLWalletShopItemsPage.objSoldProducts, "Sold Products"));
            verifyElementPresent(MLWalletShopItemsPage.objViewShop, getTextVal(MLWalletShopItemsPage.objViewShop, "Button"));
            logger.info("MLS_TC_104, Shop Items Seller Details In Product Details Page validated");
            ExtentReporter.extentLoggerPass("MLS_TC_104", "MLS_TC_104, Shop Items Seller Details In Product Details Page validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsYouMayAlsoBeInterestedInItemsDetailsValidation_MLS_TC_105() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items You May Also Be Interested In Items Details validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        waitTime(5000);
        Swipe("UP", 3);
        if (verifyElementPresent(MLWalletShopItemsPage.objProductImageInInterestedIn, "Product Image In Interested In")) {
            verifyElementPresent(MLWalletShopItemsPage.objProductNameInInterestedIn, getTextVal(MLWalletShopItemsPage.objProductNameInInterestedIn, "Product Name In Interested In"));
            verifyElementPresent(MLWalletShopItemsPage.objActualPriceInInterestedIn, getTextVal(MLWalletShopItemsPage.objActualPriceInInterestedIn, "Actual Price In Interested In"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountPriceInInterestedIn, getTextVal(MLWalletShopItemsPage.objDiscountPriceInInterestedIn, "Discount Price In Interested In"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountPercentageInInterestedIn, getTextVal(MLWalletShopItemsPage.objDiscountPercentageInInterestedIn, "Discount percentage In Interested In"));
            logger.info("MLS_TC_105, Shop Items You May Also Be Interested In Items Details validated");
            ExtentReporter.extentLoggerPass("MLS_TC_105", "MLS_TC_105, Shop Items You May Also Be Interested In Items Details validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsYouMayAlsoBeInterestedInItemPageUIValidation_MLS_TC_106() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items You May Also Be Interested In Item page UI Validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        waitTime(5000);
        Swipe("UP", 3);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objProductImageInInterestedIn, "First Item under You May Also Be Interested In Item Tab");
        if (verifyElementPresent(MLWalletShopItemsPage.objMainProductImage, "Product Image in Product Details Page")) {
            verifyElementPresent(MLWalletShopItemsPage.objOptionalProductImage, "Optional Product Image");
            verifyElementPresent(MLWalletShopItemsPage.objProductNameInProductDetails, getTextVal(MLWalletShopItemsPage.objProductNameInProductDetails, " : Product Name in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objColorInProductDetails, getTextVal(MLWalletShopItemsPage.objColorInProductDetails, "Color in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objKaratInProductDetails, getTextVal(MLWalletShopItemsPage.objKaratInProductDetails, "Karat in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objGenderInProductDetails, getTextVal(MLWalletShopItemsPage.objGenderInProductDetails, "Gender in Product details"));
            Swipe("UP", 1);
            verifyElementPresent(MLWalletShopItemsPage.objPriceInProductDetails, getTextVal(MLWalletShopItemsPage.objPriceInProductDetails, "Header in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objActualPriceInProductDetails, getTextVal(MLWalletShopItemsPage.objActualPriceInProductDetails, "Actual Price in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objDiscountPriceInProductDetails, getTextVal(MLWalletShopItemsPage.objDiscountPriceInProductDetails, "Discount Price in Product details"));
            verifyElementPresent(MLWalletShopItemsPage.objShippingTo, getTextVal(MLWalletShopItemsPage.objShippingTo, "Shipping To"));
            verifyElementPresent(MLWalletShopItemsPage.objShippingFee, getTextVal(MLWalletShopItemsPage.objShippingFee, "Shipping Fee"));
            logger.info("MLS_TC_106, Shop Items You May Also Be Interested In Item page UI validated");
            ExtentReporter.extentLoggerPass("MLS_TC_106", "MLS_TC_106, Shop Items You May Also Be Interested In Item page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void shopItemsProductDetailsPageViewShopButtonFunctionalityValidation_MLS_TC_107() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Product Details Page View Shop Button Functionality validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(10000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item"));
        waitTime(5000);
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objViewShop, getTextVal(MLWalletShopItemsPage.objViewShop, "Button"));
        if (verifyElementPresent(MLWalletShopItemsPage.objShopName, getTextVal(MLWalletShopItemsPage.objShopName, "Shop Name"))) {
            verifyElementPresent(MLWalletShopItemsPage.objShopMobileNumber, getTextVal(MLWalletShopItemsPage.objShopMobileNumber, "Shop Mobile Number"));
            verifyElementPresent(MLWalletShopItemsPage.objShopEmailID, getTextVal(MLWalletShopItemsPage.objShopEmailID, "Shop Email ID"));
            verifyElementPresent(MLWalletShopItemsPage.objShopAddress1, getTextVal(MLWalletShopItemsPage.objShopAddress1, "Shop Address 1"));
            verifyElementPresent(MLWalletShopItemsPage.objShopAddress2, getTextVal(MLWalletShopItemsPage.objShopAddress2, "Shop Address 2"));
            logger.info("MLS_TC_107, Shop Items Product Details Page View Shop Button Functionality validated");
            ExtentReporter.extentLoggerPass("MLS_TC_107", "MLS_TC_107, Shop Items Product Details Page View Shop Button Functionality validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPageUIValidation_MLS_TC_11() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items page UI validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShopItemsTab, "Shop Items Icon");
        waitTime(10000);
        if (verifyElementPresent(MLWalletShopItemsPage.objMLShopPage, getTextVal(MLWalletShopItemsPage.objMLShopPage, "Page"))) {
            verifyElementPresent(MLWalletShopItemsPage.objMLShopPageBanner, getTextVal(MLWalletShopItemsPage.objMLShopPageBanner, "Banner"));
            verifyElementPresent(MLWalletShopItemsPage.objMLShopLOgo, "ML Shop Logo");
            verifyElementPresent(MLWalletShopItemsPage.objMLShopProductsHeader, getTextVal(MLWalletShopItemsPage.objMLShopProductsHeader, "Header"));
            verifyElementPresent(MLWalletShopItemsPage.objProductImageInMLShopPage, "Product Image in ML Shop Page");
            verifyElementPresent(MLWalletShopItemsPage.objHambergerMenu, "Hamburger Menu");
            logger.info("MLS_TC_11, Shop Items page UI validated");
            ExtentReporter.extentLoggerPass("MLS_TC_11", "MLS_TC_11, Shop Items page UI validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSuccessfulLoginPopupValidation_MLS_TC_17() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Successful Login popup validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShopItemsTab, "Shop Items Icon");
        if (verifyElementPresent(MLWalletShopItemsPage.objSuccessfulLoginTxt, getTextVal(MLWalletShopItemsPage.objSuccessfulLoginTxt, "Popup"))) {
            logger.info("MLS_TC_17, Shop Items Successful Login popup validated");
            ExtentReporter.extentLoggerPass("MLS_TC_17", "MLS_TC_17, Shop Items Successful Login popup validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPayUsingMLWalletOptionSelectionValidation_MLS_TC_35() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Pay using ML Wallet option selection validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        click(MLWalletShopItemsPage.objCheckBox, "Check Box");
        click(MLWalletShopItemsPage.objCheckOutBtn, "Checkout Button");
        click(MLWalletShopItemsPage.objEditAddress, "Edit Address Tab");
        verifyElementPresent(MLWalletShopItemsPage.objSelectBranchPage, getTextVal(MLWalletShopItemsPage.objSelectBranchPage, "Page"));
        click(MLWalletShopItemsPage.objSaveBtn, "Save Button");
        verifyElementPresent(MLWalletShopItemsPage.objAddressSuccessfulMsg, getTextVal(MLWalletShopItemsPage.objAddressSuccessfulMsg, "Message"));
        click(MLWalletShopItemsPage.objOkBtn, "OK Button");
        Swipe("UP", 2);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethod, getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod, "Header"));
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMLWallet, "Pay using ML Wallet Option");
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objPlaceOrderBtn, "Place Order Button");
        if (verifyElementPresent(MLWalletShopItemsPage.objOtpPage, getTextVal(MLWalletShopItemsPage.objOtpPage, "Page"))) {
            logger.info("MLS_TC_35, Shop Items Pay using ML Wallet option selected and App Navigates to OTP Page is validated");
            ExtentReporter.extentLoggerPass("MLS_TC_35", "MLS_TC_35, Shop Items Pay using ML Wallet option selected and App Navigates to OTP Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsPayUsingOnlineBankingOptionSelectionValidation_MLS_TC_36() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Pay using Online Banking option selection validation");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("down", 4);
        navigationToCart();
        click(MLWalletShopItemsPage.objCheckBox, "Check Box");
        click(MLWalletShopItemsPage.objCheckOutBtn, "Checkout Button");
        click(MLWalletShopItemsPage.objEditAddress, "Edit Address Tab");
        verifyElementPresent(MLWalletShopItemsPage.objSelectBranchPage, getTextVal(MLWalletShopItemsPage.objSelectBranchPage, "Page"));
        click(MLWalletShopItemsPage.objSaveBtn, "Save Button");
        verifyElementPresent(MLWalletShopItemsPage.objAddressSuccessfulMsg, getTextVal(MLWalletShopItemsPage.objAddressSuccessfulMsg, "Message"));
        click(MLWalletShopItemsPage.objOkBtn, "OK Button");
        Swipe("UP", 2);
        verifyElementPresent(MLWalletShopItemsPage.objSelectPaymentMethod, getTextVal(MLWalletShopItemsPage.objSelectPaymentMethod, "Header"));
        Swipe("UP", 1);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objPayUsingOnlineBanking, "Pay using Online Banking Option");
        Swipe("UP", 1);
        click(MLWalletShopItemsPage.objPlaceOrderBtn, "Place Order Button");
        if (verifyElementPresent(MLWalletShopItemsPage.objCheckOutConfirmationMsg, "Confirmation CheckOut Popup")) {
            logger.info("MLS_TC_36, Shop Items Pay using Online Banking option selected and App Navigates to OTP Page is validated");
            ExtentReporter.extentLoggerPass("MLS_TC_36", "MLS_TC_36, Shop Items Pay using Online Banking option selected and App Navigates to OTP Page is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void shopItemsSubTotalAmountValidationBeforeSelectingItems_MLS_TC_59() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items SubTotal amount validation before Selecting Items");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("DOWN", 4);
        navigationToCart();
        if (verifyElementPresent(MLWalletShopItemsPage.objSubtotalAmount, getTextVal(MLWalletShopItemsPage.objSubtotalAmount, "SubTotal Amount"))) {
            String sSubTotalAmount = getText(MLWalletShopItemsPage.objSubtotalAmount);
            String sExceptedSubTotalAmount = "P 0.00";
            assertionValidation(sSubTotalAmount, sExceptedSubTotalAmount);
            logger.info("MLS_TC_59, Shop Items SubTotal amount should be P 0.00 before Selecting Items is validated");
            ExtentReporter.extentLoggerPass("MLS_TC_59", "MLS_TC_59, Shop Items SubTotal amount should be P 0.00 before Selecting Items is validated");
            System.out.println("-----------------------------------------------------------");
        }
    }


    public void shopItemsSubTotalAmountValidationAfterSelectingItems_MLS_TC_59() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items SubTotal amount validation after Selecting Items");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("DOWN", 4);
        navigationToCart();
        click(MLWalletShopItemsPage.objCheckBox, "Check Box");


    }

    public void shopItemsClickYesButtonToRemoveItemsFromTheCart_MLS_TC_108() throws Exception {
        ExtentReporter.HeaderChildNode("Shop Items Click the 'Yes' button to remove Items from The Cart");
        mlWalletLogin(prop.getproperty("Branch_Verified"));
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("DOWN", 2);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objShoppingCartIcon,"Shopping Cart Icon");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objDeleteIcon,"Button");
        if(verifyElementPresent(MLWalletShopItemsPage.objDeleteConfirmation,"Popup Confirmation")){
            verifyElementPresentAndClick(MLWalletShopItemsPage.objDeleteYesButton,"Button");
            if (verifyElementNotPresent(MLWalletShopItemsPage.objProductNameInCartPage, "Cart Page", 5)) {
                logger.info("MLS_TC_108, Shop Items Click the 'Yes' button to remove Items from The Cart Validated");
                ExtentReporter.extentLoggerPass("MLS_TC_108", "MLS_TC_108, Shop Items Click the 'Yes' button to remove Items from The Cart Validated");
                System.out.println("-----------------------------------------------------------");
            }

        }
    }
}
