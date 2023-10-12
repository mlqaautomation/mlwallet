package com.mlshop;

import com.business.mlwallet.BaseClass;
import com.driverInstance.DriverManager;
import com.mlwallet.pages.MLWalletLoginPage;
import com.mlwallet.pages.MLWalletShopItemsPage;
import com.propertyfilereader.PropertyFileReader;
import com.utility.ExtentReporter;
import com.utility.LoggingUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.utility.Utilities.*;
import static com.utility.Utilities.waitTime;

public class MLShop_GenMethods extends BaseClass {
    public MLShop_GenMethods(String Application, String deviceName, String portno) throws InterruptedException {
        super(Application, deviceName, portno);

    }
    public void shopItemsNavigation() throws Exception {
        logger.info("----------Navigating into MLShop-------------");
        click(MLWalletShopItemsPage.objShopItemsTab, "Shop Items Icon");
        waitTime(10000);
        verifyElementPresentAndClick(MLWalletShopItemsPage.objMLShopPage, "ML Shop Page");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objloginOkayButton, "Login Success Button");

    }
    public void selectItemAndAddToCart() throws Exception {
        logger.info("------------Adding Ring Item To Cart--------------");
        Swipe("UP", 2);
        click(MLWalletShopItemsPage.objItemMenu, "Rings Item");
        waitTime(5000);
        click(MLWalletShopItemsPage.objSelectItem, getTextVal(MLWalletShopItemsPage.objSelectItem, "Item" ));
        waitTime(5000);
        Swipe("up", 2);
        click(MLWalletShopItemsPage.objAddToCartBtn, "Add to cart Button");
        waitTime(5000);
        click(MLWalletShopItemsPage.objConfirmAddCarButton,"Confirm Button");
    }
    public void navigationToCart() throws Exception {
        click(MLWalletShopItemsPage.objCartIcon ,"Icon");
    }

    public void placeOrder(String option) throws Exception {
        logger.info("---------------Place Order----------------");
        click(MLWalletShopItemsPage.objCheckBox, "Check Box");
        click(MLWalletShopItemsPage.objCheckOutBtn, "Checkout Button");
        Swipe("UP", 4);
        selectPickUpBranch();
        if(option.equals("MLWallet")) {
            selectWalletAsPaymentMethod();
        }else{
            selectEWalletAsPaymentMethod(option);
        }
        click(MLWalletShopItemsPage.objPlaceOrderBtn ,"Button");
    }

    public void mlWallet_ShopItems_Successful_Purchase() throws Exception {
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("DOWN", 4);
        navigationToCart();
        placeOrder(shopProp.getproperty("MLWallet"));
        click(MLWalletShopItemsPage.objProceedBtn, "Proceed Button");
        waitTime(5000);
        enterOTP(prop.getproperty("Valid_OTP"));
    }


    public void selectPickUpBranch()throws Exception{
        click(MLWalletShopItemsPage.objBranchNameDropDown, "DropDown");
        click(MLWalletShopItemsPage.objSelectedBranchName, getTextVal(MLWalletShopItemsPage.objSelectedBranchName, "Branch Name"));
        verifyElementPresent(MLWalletShopItemsPage.objBranchAddress, getText(MLWalletShopItemsPage.objBranchAddress));
    }

    public void selectWalletAsPaymentMethod()throws Exception{
        click(MLWalletShopItemsPage.objPaymentMLWallet ,"Option");
    }
    public void selectEWalletAsPaymentMethod(String options)throws Exception{
        logger.info("Selecting EWallet as Payment Method : " + options);
        click(MLWalletShopItemsPage.objPaymentEWallet, "Option");
        verifyElementPresentAndClick(MLWalletShopItemsPage.objEWalletOptions(shopProp.getproperty(options)), "E-Wallet Option");
    }
    public void eWalletPaymongoPortalUIValidation(String options)throws Exception{
        shopItemsNavigation();
        selectItemAndAddToCart();
        Swipe("DOWN", 4);
        navigationToCart();
        placeOrder(shopProp.getproperty(options));
        click(MLWalletShopItemsPage.objProceedBtn, "Button");
        waitTime(5000);

    }

    public void selectFilterMaterial(By materialLocator, By materialDisplayed) throws Exception {
        click(MLWalletShopItemsPage.objFilter, "Filter");
        Swipe("UP", 1);
        clickAllVisibleCheckBox(MLWalletShopItemsPage.objAllCheckBox);
        waitTime(5000);
        click(materialLocator, "Material locator is selected");
        waitTime(5000);
        Swipe("DOWN", 2);
        click(MLWalletShopItemsPage.objExitFilterIcon, "Exit");
        if(verifyElementDisplayed(MLWalletShopItemsPage.objNoProductFound)){
            verifyElementPresent(MLWalletShopItemsPage.objNoProductFound, "No Products Found!");
            logger.info("No Products Found!");
        } else {
            WebElement element = DriverManager.getAppiumDriver().findElement(materialDisplayed);
            String materialValue = element.getText();

            Map<String, String> materialMessages = new HashMap<>();
            materialMessages.put("10k", "10k");
            materialMessages.put("14k", "14k");
            materialMessages.put("18k", "18k");
            materialMessages.put("20k", "20k");
            materialMessages.put("21k", "21k");
            materialMessages.put("22k", "22k");
            materialMessages.put("12k", "12k");
            for (Map.Entry<String, String> entry : materialMessages.entrySet()) {
                if (materialValue.contains(entry.getKey())) {
                    waitTime(5000);
                    verifyElementPresent(materialDisplayed, entry.getKey());
                    logger.info(entry.getValue() + "is/are displayed");
                    return;
                }
            }
        }
        logger.info("No matching material found.");
    }

    public void clickAllVisibleCheckBox(By locator) throws Exception {
        List<WebElement> elements = DriverManager.getAppiumDriver().findElements(locator);

        for (WebElement element : elements) {
            if (element.isDisplayed() && element.isEnabled()) {
                element.click();
            }
        }
    }

    public void selectFilterMaterialColor(By materialColorLocator, By materialColorDisplayed) throws Exception {
        click(MLWalletShopItemsPage.objFilter, "Filter");
        Swipe("UP", 1);
        clickAllVisibleCheckBox(MLWalletShopItemsPage.objAllCheckBox);
        waitTime(5000);
        click(materialColorLocator, "Material Color locator is selected");
        waitTime(5000);
        Swipe("DOWN", 2);
        click(MLWalletShopItemsPage.objExitFilterIcon, "Exit");

        if(verifyElementDisplayed(MLWalletShopItemsPage.objNoProductFound)){
            verifyElementPresent(MLWalletShopItemsPage.objNoProductFound, "No Products Found!");
            logger.info("No Products Found!");
        } else {
            WebElement element = DriverManager.getAppiumDriver().findElement(materialColorDisplayed);
            String materialValue = element.getText();

            Map<String, String> materialMessages = new HashMap<>();
            materialMessages.put("Yellow Gold", "Yellow Gold");
            materialMessages.put("White Gold", "White Gold");
            materialMessages.put("Rose Gold", "Rose Gold");
            materialMessages.put("Two - Tone", "Two - Tone");
            materialMessages.put("Tri - Tone", "Tri - Tone");
            for (Map.Entry<String, String> entry : materialMessages.entrySet()) {
                if (materialValue.contains(entry.getKey())) {
                    waitTime(5000);
                    verifyElementPresent(materialColorDisplayed, entry.getKey());
                    logger.info(entry.getValue() + " is/are displayed");
                    return;
                }
            }
        }
        logger.info("No matching material color found.");
    }

}
