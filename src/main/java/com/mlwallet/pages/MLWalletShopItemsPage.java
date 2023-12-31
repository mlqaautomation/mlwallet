package com.mlwallet.pages;

import org.openqa.selenium.By;

public class MLWalletShopItemsPage {

	public static By objShopItemsTab=By.xpath("//*[@text='Shop']");
	public static By objMLShopPage=By.xpath("//*[@text='ML Shop']");
	public static By objItemMenu=By.xpath("//*[@text='Rings']/parent::android.view.View");
	public static By objHighPrice=By.xpath("//*[@text='High to Low']");
	public static By objLowPrice=By.xpath("//*[@text='Low to High']");
	public static By objCheckBox=By.xpath("(//*[@class='android.widget.CheckBox'])[1]");
	public static By objSelectItem = By.xpath("(//*[@text='High to Low' or @text='Low to High']/following-sibling::android.view.View[1]/child::android.widget.TextView[1])");
	public static By objAddToCartBtn=By.xpath("//*[@text='Add To Cart']");
	public static By objHamburgerMenu=By.xpath("//*[@text='Enjoy up to 50% Discount on Selected Items']/following-sibling::android.view.View/child::android.widget.Image");
	public static By objCart=By.xpath("//*[@content-desc='Cart']");
	public static By objCartIcon = By.xpath("//android.view.View[3]/child::android.view.View/child::android.widget.Image");
	public static By objEditAddress=By.xpath("//*[@text='   ']");
	public static By objCheckOutBtn=By.xpath("//android.widget.Button[@text='Checkout']");
	public static By objSelectBranchPage=By.xpath("//*[@resource-id='exampleModalLabel']");
	public static By objInputFieldOne=By.xpath("//*[@resource-id='dropEditProvince']"); 
	public static By objBranchName=By.xpath("//*[@text='Branch Name *']/following-sibling::android.view.View");
	// //*[@text='ML NRA']
	public static By objInputFieldTwo=By.xpath("//*[@resource-id='btnChangeAddress']");
	public static By objSubBranchName=By.xpath("//*[@text='BALER']");
	public static By objInputFieldThree=By.xpath("//*[@resource-id='dropEditBranchname']");
	public static By objSubBranchNameTwo=By.xpath("//*[@text='ML BALER 2, AURORA']");
	public static By objSaveBtn=By.xpath("//*[@resource-id='submitEditDeliveryAddresButton']");
	public static By objAddressSuccessfulMsg=By.xpath("//*[@text='Successfully Update Delivery Address.']");
	public static By objOkBtn=By.xpath("//*[@text='Ok' or @text='OK']");
	public static By objYesBtn=By.xpath("//*[@text='Yes']");
	public static By objPlaceOrderBtn=By.xpath("//*[@text='Place Order']");
	public static By objOtpPage=By.xpath("//*[@text='One Time Pin']");
	public static By objCheckOutConfirmationMsg = By.xpath("//*[@resource-id='mainCheckout']");
	public static By objOtpTextField=By.xpath("//*[@class='android.widget.EditText']");
	public static By objValidateBtn=By.xpath("//*[@text='Validate']");
	
	public static By objInvalidOtpPopUp=By.xpath("//*[@resource-id='swal2-title']");
	public static By objInvalidOtpPopUpMsg=By.xpath("//*[@resource-id='swal2-html-container']");
	
	public static By objCanceBtn=By.xpath("//*[@resource-id='btnConfirmCancelCheckout']");
	public static By objBackArrowBtn=By.xpath("//*[@text='']");
	public static By objAvailableBalance=By.xpath("//*[@text='Available Balance']");
	public static By objSelectPaymentMethod = By.xpath("//*[@text='Select Payment Method']");
	public static By objMLWallet = By.xpath("//android.widget.Button[@text='ML WALLET']");
	public static By objPayUsingMlWallet = By.xpath("((//*[@class='android.webkit.WebView'])[2]/child::android.view.View/child::android.view.View)[2]");
	//*[@text='ML Wallet']/parent::android.view.View/parent::android.view.View
	public static By objPayUsingOnlineBanking = By.xpath("//*[@text='Online Banking']/parent::android.view.View/parent::android.view.View");


	public static By objSearch=By.xpath("//*[@text=' Search']");
	public static By objProfile=By.xpath("//*[@content-desc='Profile']");
	public static By objShop = By.xpath("//*[@content-desc='Shop']");
	public static By objAbout = By.xpath("//*[@content-desc='About']");
	public static By objContact = By.xpath("//*[@content-desc='Contact']");
	public static By objItems = By.xpath("//*[@id='imahehome']/child::android.view.View/child::android.view.View/child::android.view.View/following-sibling::android.view.View");
	public static By objGenderDropdown = By.xpath("//*[@resource-id='drpGender']");
	public static By objColorDropdown = By.xpath("//*[@resource-id='drpColor']");
	public static By objKaratDropdown = By.xpath("//*[@resource-id='drpKarat']");
	public static By objPriceDropdown = By.xpath("//*[@resource-id='drpKarat']");

	public static By objProductImage = By.xpath("//*[@resource-id='crewimage']");
	public static By objShippingTo = By.xpath("//*[@resource-id='ship']");
	public static By objShippingFee = By.xpath("//*[@resource-id='shippingfee']");
	public static By objViewShop = By.xpath("//*[contains(@text,'View Shop')]");

	public static By objCartPageHeader = By.xpath("(//*[@class='android.widget.Image'])[1]/following-sibling::android.view.View");
	public static By objDeleteIcon = By.xpath("//*[@class='android.widget.CheckBox'][1]/parent::android.view.View/following-sibling::android.widget.Button");
	public static By objProductNameInCartPage = By.xpath("//*[@class='android.widget.CheckBox'][1]/parent::android.view.View/parent::android.view.View[1]");
	public static By objPriceInCartPage = By.xpath("(//*[@class='android.widget.CheckBox']/following-sibling::android.widget.TextView)[2]");
	
	public static By objShippingDetails = By.xpath("//*[@resource-id='font-sd']");
	public static By objAddAddress = By.xpath("//*[@resource-id='btnChangeAddress']");
	public static By objProductNameInShippingDetails = By.xpath("((//*/*[@class='android.view.View'])[21]/*[@text and @class='android.view.View'])[1]");
	public static By objProductQuantity = By.xpath("((//*/*[@class='android.view.View'])[21]/*[@text and @class='android.view.View'])[2]");
	public static By objItemSubTotal = By.xpath("((//*/*[@class='android.view.View'])[21]/*[@text and @class='android.view.View'])[3]");
	public static By objHeader = By.xpath("//*[@resource-id='captionproductorder']");
	public static By objTotalOrder = By.xpath("//*[@resource-id='product-totalorder2_0']");
	public static By objServiceFee = By.xpath("//*[@resource-id='product-servicefee2_0']");
	public static By objShippingFeeInShippingDetails = By.xpath("//*[@resource-id='product-shippingfee2_0']");

	public static By objOnlineBanking = By.xpath("//*[@text='Online Banking']");
	public static By objMerchandiseSubTotal = By.xpath("//*[@text='Merchandise Subtotal :']/following-sibling::android.view.View");
	public static By objServiceTotal = By.xpath("//*[@text='Service Total :']/following-sibling::android.view.View");
	public static By objShippingTotal = By.xpath("//*[@text='Shipping Total :']/following-sibling::android.view.View");
	public static By objPaymentTotal = By.xpath("//*[@resource-id='product-final-total']");
	public static By objCancel = By.xpath("//*[@text='Cancel']");
	public static By objAddressUpdateMsg = By.xpath("//*[@resource-id='swal2-html-container']");

	public static By objOTPMsg = By.xpath("//*[@text='Enter the 6-digit OTP sent to your mobile number']");
	public static By objErrorPopup = By.xpath("//*[@resource-id='swal2-html-container']");
	public static By objMyAccount = By.xpath("//*[@text='MY ACCOUNT']");
	public static By objMyAccountDropdown = By.xpath("//*[@text='My Account']");
	public static By objMyAccountPageCrossBtn = By.xpath("//*[@resource-id='close-sidebar']/child::android.widget.TextView");
	public static By objMyProfileHeader = By.xpath("(//*[@text='My Profile'])[2]");
	public static By objMyPurchase = By.xpath("//*[@text='Purchase History']");
	public static By objOrderDetails = By.xpath("//*[@resource-id='orderDetails']");
	public static By objSubtotalAmount = By.xpath("//*[@resource-id='cart-subtotal']");
	public static By objSelectedItemPrice = By.xpath("((//*[@class='android.widget.CheckBox'])[1]/following-sibling::android.widget.TextView)[2]");
	public static By objJewelry = By.xpath("//*[@text='Jewelry']");
	public static By objContactUs = By.xpath("//*[@text='Contact Us']");
	public static By objGreatDealsForFineWatches = By.xpath("//*[@text='Great Deals for Fine Watches']");
	public static By objRolex = By.xpath("//*[@text='Rolex']");
	public static By objHamilton = By.xpath("//*[@text='Hamilton']");
	public static By objOmega = By.xpath("//*[@text='Omega']");
	public static By objTagHeuer = By.xpath("//*[@text='Tag Heuer']");
	public static By objDiscountPercentage = By.xpath("(//*[@text='product image'])[1]/parent::android.view.View/parent::android.view.View/parent::android.view.View/child::android.widget.TextView");

	public static By objOriginalPrice = By.xpath("((//*[@text='product image'])[1]/parent::android.view.View/following-sibling::android.view.View)[2]/child::android.view.View");
	public static By objDiscountPrice = By.xpath("(//*[@text='product image'])[1]/parent::android.view.View/following-sibling::android.widget.TextView");

	public static By objCategoriesHamburgerMenu = By.xpath("//*[contains(@text,'C A T E G O R Y')]");
	public static By objAmparitoCollections = By.xpath("//*[@text='Amparito Collections']");
	public static By objFineJewelry = By.xpath("//*[@text='Fine Jewelry']");
	public static By objAmparitoCollectionsProductTypes(int i) {
		return By.xpath("(//*[@text='Amparito Collections']/parent::android.view.View/following-sibling::android.view.View/child::android.widget.TextView)["+i+"]");
	}
	public static By objRings = By.xpath("//*[@text='Rings']");

	public static By objNecklacePendants= By.xpath("//*[@text='Necklaces & Pendants']");

	public static By objBraceletAndBangle = By.xpath("//*[@text='Bracelets & Bangles']");
	public static By objRing = By.xpath("//*[contains(@text,'Ring')]");
	public static By objRingsSubTypes(int i){
		return By.xpath("(//*[@resource-id='amparitoCollRing1']/child::android.widget.Button)["+i+"]");
	}
	public static By objNecklace = By.xpath("//*[contains(@text,'Necklace')]");
	public static By objNecklaceSubTypes(int i){
		return By.xpath("(//*[@text='Necklace']/following-sibling::android.view.View/child::android.widget.Button)["+i+"]");
	}

	public static By objBraceletAndBangleSubTypes(int i){
		return By.xpath("(//*[@text='Bracelet & Bangle']/following-sibling::android.view.View/child::android.widget.Button)["+i+"]");
	}
	public static By objEarrings = By.xpath("//*[contains(@text,'Earrings')]");
	public static By objEarringsSubTypes(int i){
		return By.xpath("(//*[contains(@text,'Earrings')]/following-sibling::android.view.View/child::android.widget.Button)["+i+"]");
	}
	public static By objPendant = By.xpath("//*[contains(@text,'Pendant')]");
	public static By objPendantSubTypes(int i){
		return By.xpath("(//*[@text='Pendant']/following-sibling::android.view.View/child::android.widget.Button)["+i+"]");
	}
	public static By objTernoAndSet = By.xpath("//*[contains(@text,'Terno & Set')]");
	public static By objTernoAndSetSubTypes = By.xpath("//*[@text='Terno & Set']/following-sibling::android.view.View/child::android.widget.Button");
	public static By objWeddingRing = By.xpath("//*[@text='Wedding Ring']");
	public static By objWeddingRingSubTypes = By.xpath("//*[@text='Wedding Ring']/following-sibling::android.view.View/child::android.widget.Button");

	public static By objPinBrouchAndScalpings = By.xpath("//*[contains(@text,'Brooch')]");
	public static By objPinBrouchAndScalpingsSubTypes = By.xpath("//*[@text='Pin, Brouch & Scaplings']/following-sibling::android.view.View/child::android.widget.Button");

	public static By objWatches = By.xpath("//*[@text='Watches']");
	public static By objWatchesSubTypes(int i){
		return By.xpath("(//*[@text='Watches']/following-sibling::android.view.View/child::android.widget.Button)["+i+"]");
	}

	public static By objGender = By.xpath("//*[@resource-id='drpGender']");
	public static By objFilterCheckBox(int i) {
		return By.xpath("(//*[@resource-id='android:id/text1'])["+i+"]");
	}
	public static By objColor = By.xpath("//*[@resource-id='drpColor']");
	public static By objKarat = By.xpath("//*[@resource-id='drpKarat']");
	public static By objPrice = By.xpath("//*[@resource-id='drpPrice']");
	public static By objMainProductImage = By.xpath("//*[@resource-id='crewimage']");
	public static By objOptionalProductImage = By.xpath("//*[@text='Card image cap']");
	public static By objProductNameInProductDetails = By.xpath("//*[@resource-id='mlproduct-description']");
	public static By objColorInProductDetails = By.xpath("//*[@resource-id='mlproduct-color']");
	public static By objKaratInProductDetails = By.xpath("//*[@resource-id='mlproduct-karat']");
	public static By objGenderInProductDetails = By.xpath("//*[@resource-id='mlproduct-gender']");
	public static By objPriceInProductDetails = By.xpath("//*[@text='Price']");
	public static By objActualPriceInProductDetails = By.xpath("//*[@resource-id='compareAtPriceDisplay']/child::android.view.View");
	public static By objDiscountPriceInProductDetails = By.xpath("//*[@resource-id='productPriceDisplay']");
	public static By objShopName = By.xpath("//*[@resource-id='ml-shopname']");
	public static By objShopMobileNumber = By.xpath("(//*[@resource-id='ml-shopname']/following-sibling::android.view.View)[1]");
	public static By objShopEmailID =By.xpath("(//*[@resource-id='ml-shopname']/following-sibling::android.view.View)[2]");
	public static By objShopAddress1 = By.xpath("(//*[@resource-id='ml-shopname']/following-sibling::android.view.View)[3]");
	public static By objShopAddress2 = By.xpath("(//*[@resource-id='ml-shopname']/following-sibling::android.view.View)[4]");
	public static By objTotalProducts = By.xpath("(//*[contains(@text,'Products')])[1]");
	public static By objSoldProducts = By.xpath("(//*[contains(@text,'Products')])[2]");

	public static By objProductImageInInterestedIn =  By.xpath("(//*[@text='product image'])[1]");
	public static By objProductNameInInterestedIn = By.xpath("((//*[@text='product image'])[1]/following-sibling::android.view.View)[1]");
	public static By objActualPriceInInterestedIn = By.xpath("((//*[@text='product image'])[1]/following-sibling::android.view.View)[2]/child::android.view.View");
	public static By objDiscountPriceInInterestedIn = By.xpath("(//*[@text='product image'])[1]/following-sibling::android.widget.TextView");
	public static By objDiscountPercentageInInterestedIn = By.xpath("(//*[@text='product image'])[1]/preceding-sibling::android.widget.TextView");

	public static By objMLShopLOgo = By.xpath("//*[@resource-id='nav-logo']");
	public static By objProductImageInMLShopPage = By.xpath("//*[@text='Product image']");
	public static By objMLShopProductsHeader = By.xpath("//*[@resource-id='best-sellers-section-main-label']");
	public static By objMLShopPageBanner = By.xpath("//*[@resource-id='banner-text']");

	public static By objSuccessfulLoginTxt = By.xpath("//*[@text='Successfully Login']");
	public static By objloginOkayButton = By.xpath("//*[@text='Okay']");
	public static By objDeleteYesButton =By.xpath("//*[@text='Yes']");
	public static By objDeleteCancelButton =By.xpath("//*[@text='Cancel']");
	public static By objDeleteConfirmation =By.xpath("//*[@text='Are you sure to remove this item?']");
	public static By objDeleteExitButton =By.xpath("//*[@text='Are you sure to remove this item?']/parent::android.view.View/preceding-sibling::android.view.View/child::android.widget.Button");
	public static By objConfirmAddCarButton = By.xpath("//*[@text='Confirm']");
	public static By objSuccessAddtoCartMsg = By.xpath("//*[@resource-id='swal2-html-container']");
	public static By objExitHamburgerMenu = By.xpath("//*[@content-desc='Profile']/parent::android.view.View/preceding-sibling::android.view.View");

	public static By objShoppingCartIcon=By.xpath("//android.view.View/child::android.view.View");


	//--- Product Details---
	public static By objProductName = By.xpath("//*[@class='android.view.View'][1]/child::android.widget.TextView[1]");
	public static By objProductPrice = By.xpath("//*[@class='android.view.View'][1]/child::android.widget.TextView[29]");
	public static By objProductMaterial = By.xpath("//*[@class='android.view.View'][1]/child::android.widget.TextView[4]");
	public static By objProductMaterialColor = By.xpath("//*[@class='android.view.View'][1]/child::android.widget.TextView[7]");
	public static By objProductSize = By.xpath("//*[@class='android.view.View'][1]/child::android.widget.TextView[10]");
	public static By objProductStone = By.xpath("//*[@class='android.view.View'][1]/child::android.widget.TextView[13]");
	public static By objProductItemWeight = By.xpath("//*[@class='android.view.View'][1]/child::android.widget.TextView[16]");
	public static By objProductStoneColor = By.xpath("//*[@class='android.view.View'][1]/child::android.widget.TextView[19]");
	public static By objProductGender = By.xpath("//*[@class='android.view.View'][1]/child::android.widget.TextView[22]");
	public static By objProductStockNo = By.xpath("//*[@class='android.view.View'][1]/child::android.widget.TextView[25]");

	// --- SELECT PICK UP BRANCH SECTION ---
	public static By objSelectBranchLabel=By.xpath("//*[@text='Select Pick Up Branch']");
	public static By objProvinceStateDropDown=By.xpath("//*[@text='Select Pick Up Branch']/following-sibling::android.widget.TextView[1]/following-sibling::android.view.View[1]");
	public static By objCityTownDropDown=By.xpath("//*[@text='Select Pick Up Branch']/following-sibling::android.widget.TextView[2]/following-sibling::android.view.View[1]");
	public static By objBranchNameDropDown=By.xpath("//*[@text='Select Pick Up Branch']/following-sibling::android.widget.TextView[3]/following-sibling::android.view.View[1]");
	public static By objSelectedBranchName=By.xpath("//*[@class='android.widget.ListView']/child::android.widget.CheckedTextView[2]");
	public static By objBranchAddress=By.xpath("//*[@text='Select Pick Up Branch']/following-sibling::android.widget.TextView[3]/following-sibling::android.view.View[1]/following-sibling::android.widget.TextView");
	// --- SELECT PICK UP BRANCH SECTION ---


	// --- SELECT PAYMENT METHOD SECTION ---
	public static By objPaymentMLWallet=By.xpath("//*[@text='ML WALLET']");
	public static By objPaymentEWallet=By.xpath("//*[@text='E-WALLET']");
	public static By objPaymentVisa=By.xpath("//*[@text='VISA/MASTERCARD']");
	public static By objDirectOnlineBank=By.xpath("//*[@text='DIRECT ONLINE BANKING']");
	// --- SELECT PAYMENT METHOD SECTION ---
	public static By objProceedBtn=By.xpath("//*[@text='Proceed']");
	public static By objCloseBtn=By.xpath("//*[@text='Close']");
	public static By objPLaceOrderConfirmationMsg=By.xpath("//*[contains(@text,'You are about')]");
	public static By objSuccesFullyCheckOutMsg=By.xpath("//*[@text='Successfully checkout items. Thank you!']");
	public static By objSuccessFullyCheckOutOkayBtn=By.xpath("//*[@text='Okay']");
	public static By objEWalletOptions(String option){
		return By.xpath("//*[@text='"+option+"']");
	}
	public static By objPaymongoPortalPage=By.xpath("//*[@text='PayMongo Logo']");
	public static By objPaymongoPaymentAmount=By.xpath("//*[@text='Payment amount']/following-sibling::android.widget.TextView");
	public static By objFilter = By.xpath("//*[@text='Filter']");
	public static By objExitFilterIcon = By.xpath("//*[@text='C A T E G O R Y']/preceding-sibling::android.view.View");
	public static By objAllCheckBox = By.xpath("//android.widget.CheckBox");
	public static By objSelectMaterialOptions(String option){
		return By.xpath("//*[@text='"+option+"']");
	}
	public static By objItemDescription = By.xpath("//*[@text='Sort by: Price']/following-sibling::android.widget.Spinner/following-sibling::android.view.View/child::android.view.View[2]");
	public static By objNoProductFound= By.xpath("//*[@text='No Products Found!']");
	public static By objItemName = By.xpath("//*[@text='Sort by: Price']/following-sibling::android.widget.Spinner/following-sibling::android.view.View/child::android.view.View[1]");
	public static By objMin=By.xpath("//*[@text='Min']/following-sibling::android.widget.EditText[1]");
	public static By objMax=By.xpath("//*[@text='Max']/following-sibling::android.widget.EditText[1]");
	public static By objsortByPrice=By.xpath("//*[@text='High to Low' or @text='Low to High']");
	public static By objGreatSalesText=By.xpath("//android.widget.TextView[@text='HALLOWEEN SALE']");
	public static By objJewelryText=By.xpath("//android.widget.TextView[@text='Jewelry']");
	public static By objContactUsText=By.xpath("//android.widget.TextView[@text='Contact Us']");
	public static By objShopCartText=By.xpath("//android.widget.TextView[@text='Shopping Cart']");
	public static By objProfileText=By.xpath("//android.widget.TextView[@text='Full Name']");
	public static By objPurchaseText=By.xpath("//android.widget.TextView[@text='ML Shop Jewelry Store']");
	public static By objLogout = By.xpath("//android.widget.TextView[@text='Logout']");
	public static By objLogoutText=By.xpath("//android.widget.TextView[@text='GREAT SUMMER SALE']");
	public static By objSuccessfullyAddedToCart = By.xpath("//*[@text= 'Item has been successfully added to your cart.']");
	public static By objItemAlreadyAddedInCart = By.xpath("//*[@text= 'This item is already in your cart.']");
	public static By objCartItemCount = By.xpath("//android.widget.Image/following-sibling::android.widget.TextView']");
	public static By objWatchProducts = By.xpath("(//android.view.View[@content-desc='watchproducts'])[1]");
	public static By objProductDetailsModelName = By.xpath("//*[@text='Model Name']/following-sibling::android.widget.TextView[2]");
	public static By objProductDetailsMaterial = By.xpath("//*[@text='Material']/following-sibling::android.widget.TextView[2]");
	public static By objProductDetailsColor = By.xpath("//*[@text='Color']/following-sibling::android.widget.TextView[2]");
	public static By objProductDetailsSize = By.xpath("//*[@text='Size']/following-sibling::android.widget.TextView[2]");
	public static By objProductDetailsBrand = By.xpath("//*[@text='Brand']/following-sibling::android.widget.TextView[2]");
	public static By objProductDetailsMovement = By.xpath("//*[@text='Movement']/following-sibling::android.widget.TextView[2]");
	public static By objProductDetailsGender = By.xpath("//*[@text='Gender']/following-sibling::android.widget.TextView[2]");
	public static By objProductDetailsStockNumber = By.xpath("//*[@text='Stock no.']/following-sibling::android.widget.TextView[2]");
	public static By objProductDetailsNote = By.xpath("//*[@text='Notes']/following-sibling::android.widget.TextView[2]");
	public static By objItemInTheCartName = By.xpath("//android.widget.ListView//android.widget.TextView[1]");
	public static By objShoppngCartCheckBox = By.xpath("//android.widget.CheckBox");
	public static By objHightoLow=By.xpath("//android.widget.CheckedTextView[1]");
	public static By objLowtoHigh=By.xpath("//android.widget.CheckedTextView[2]");
	public static By objContinuePaymongo=By.xpath("//*[@text='Continue']");
	public static By objAgreePolicyPaymongo=By.xpath("//*[@resource-id='privacy-policy']");
	public static By objCompletePaymentPaymongo=By.xpath("//*[@text='Complete payment']");
	public static By objAuthorizeTestPaymentPaymongo=By.xpath("//*[@text='Authorize Test Payment']");
	public static By objSuccessfulGrabPayPayment=By.xpath("//*[@text='GrabPay payment received!']");
	public static By objSuccessfulGcashPayment=By.xpath("//*[@text='GCash payment received!']");
	public static By objSuccessfulMayaPayment=By.xpath("//*[@text='Maya payment received!']");
	public static By objSuccessfulCreditPayment=By.xpath("//*[@text='Credit or debit card payment received!']");
	public static By objcardnumberCreditPayment=By.xpath("//*[@resource-id='cardNumber']");
	public static By objExpMonthCreditPayment=By.xpath("//*[@resource-id='expMonth']");
	public static By objExpYearCreditPayment=By.xpath("//*[@resource-id='expYear']");
	public static By
			objCvcCreditPayment=By.xpath("//*[@resource-id='cvc']");
	public static By
			objPaymentGrabPay=By.xpath("//*[@text='GRAB PAY']");
	public static By
			objPaymentGcash=By.xpath("//*[@text='GCASH']");
	public static By
			objPaymentPayMaya=By.xpath("//*[@text='PAYMAYA']");
	public static By objGrabPay = By.xpath("//*[@text='GRAB PAY']");
	public static By objPayMaya = By.xpath("//*[@text='PAYMAYA']");

}
