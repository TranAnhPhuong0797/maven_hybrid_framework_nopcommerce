package com.nopcommerce.user.livecoding;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.data.UserData;

import common.BaseTest;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserCheckOutPageObject;
import pageObject.nopcommerce.portal.UserDetailProductPageObject;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;
import pageObject.nopcommerce.portal.UserShopingCartPageObject;
import reportConfig.ExtentTestManagerV5;

public class LiveCoding_nopcommerce_Order extends BaseTest{
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = UserData.Register.FIRST_NAME;
		lastName = UserData.Register.LAST_NAME;
		emailAddress = UserData.Register.EMAIL_ADDRESS;
		validPassword = UserData.Register.PASSWORD;
		
		//Preconditions
		log.info("Preconditions - Step 01: Navigate to Register Page");
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		log.info("Preconditions - Step 02: Register new User account");
		userRegisterPage.registerNewUserAccount(firstName, lastName, emailAddress, validPassword, validPassword);
		
		log.info("Preconditions - Step 03: Navigate to Login page");
		userLoginPage = userHomePage.openLoginPage();
		
		log.info("Preconditions - Step 04: Login new User");
		userHomePage = userLoginPage.LoginAsUser(emailAddress, validPassword);
		
		log.info("Preconditions - Step 05: Select any product in Home Page");
		userDetailProductPage = userHomePage.selectProductInSectionFeaturedProducts("Build your own computer");
	}
	
	@Test
	public void Order_01_Add_Product_To_Cart(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Add Product to Card");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 01: Select option Processor");
		userDetailProductPage.selectOptionProcessorIs("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 02: Select option RAM");
		userDetailProductPage.selectOptionRAMIs("8GB [+$60.00]");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 03: Select option HDD");
		userDetailProductPage.clickOptionHDDIs("400 GB [+$100.00]");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 04: Select option OS");
		userDetailProductPage.clickOptionOSIs("Vista Premium [+$60.00]");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 05: Select option Software");
		userDetailProductPage.clickOptionSoftwareIs("Microsoft Office [+$50.00]");
		userDetailProductPage.clickOptionSoftwareIs("Acrobat Reader [+$10.00]");
		userDetailProductPage.clickOptionSoftwareIs("Total Commander [+$5.00]");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 06: Click button Add to Cart");
		userDetailProductPage.clicktoButtonByText(driver, "Add to cart");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 07: Verify message");
		userDetailProductPage.verifyBarNotificationWithHyperLink(driver, "The product has been added to your shopping cart"); 
		sleepInSecond(1);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 08: Close message");
		userDetailProductPage.closeBarNotification(driver);
		sleepInSecond(1);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 09: Click shopping cart");
		userShopingCartPage = userDetailProductPage.OpenShoppingCard();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 10: Verify shopping cart quantity");
		userShopingCartPage.verifyShoppingCartQuantity(driver,"(1)");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 11: Verify information of product is updated in shopping cart");
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "Processor", "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]"));
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "RAM", "RAM: 8GB [+$60.00]"));
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "HDD", "HDD: 400 GB [+$100.00]"));
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "OS", "OS: Vista Premium [+$60.00]"));
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "Software", "Software: Microsoft Office [+$50.00]"));
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "Software", "Software: Acrobat Reader [+$10.00]"));
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "Software", "Software: Total Commander [+$5.00]"));
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 12: Verify price");
		userShopingCartPage.veirfyThePriceOfProduct("Build your own computer","$1,500.00");
	}
	
	@Test
	public void Order_02_Edit_Product_In_Shopping_Cart(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Edit product in shopping cart");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 01: Click edit product Build your own computer");
		userDetailProductPage = userShopingCartPage.clickEditProduct("Build your own computer");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 02: Select option Processor");
		userDetailProductPage.selectOptionProcessorIs("2.2 GHz Intel Pentium Dual-Core E2200");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 03: Select option RAM");
		userDetailProductPage.selectOptionRAMIs("4GB [+$20.00]");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 04: Select option HDD");
		userDetailProductPage.clickOptionHDDIs("320 GB");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 04: Select option OS");
		userDetailProductPage.clickOptionOSIs("Vista Home [+$50.00]");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 05: Select option Software");
		userDetailProductPage.UntickOptionSoftwareIs("Acrobat Reader [+$10.00]");
		sleepInSecond(1);
		userDetailProductPage.UntickOptionSoftwareIs("Total Commander [+$5.00]");
		sleepInSecond(1);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 06: Increase quantity to 2 products");
		userDetailProductPage.editQuantityProductis("2");
		sleepInSecond(1);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 07: Verify price");
		userDetailProductPage.verifyProductPriceIs("$1,320.00");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 08: Click button Update");
		userDetailProductPage.clicktoButtonByText(driver, "Update");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 09: Verify message");
		userDetailProductPage.verifyBarNotificationWithHyperLink(driver, "The product has been added to your shopping cart"); 
		sleepInSecond(1);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 10: Close message");
		userDetailProductPage.closeBarNotification(driver);
		sleepInSecond(1);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 11: Click shopping cart");
		userShopingCartPage = userDetailProductPage.OpenShoppingCard();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 12: Verify information of product is updated in shopping cart");
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "Processor", "Processor: 2.2 GHz Intel Pentium Dual-Core E2200"));
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "RAM", "RAM: 4GB [+$20.00]"));
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "HDD", "HDD: 320 GB"));
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "OS", "OS: Vista Home [+$50.00]"));
		verifyTrue(userShopingCartPage.verifyInformationOfProduct("Build your own computer", "Software", "Software: Microsoft Office [+$50.00]"));
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 13: Verify price");
		userShopingCartPage.veirfyThePriceOfProduct("Build your own computer","$2,640.00");
	}
	
	@Test
	public void Order_03_Remove_Product_In_Shopping_Cart(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Remove product");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 01: Click remove product");
		userShopingCartPage.removeProductInCart("Build your own computer");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 02: Verify shopping cart is empty");
		userShopingCartPage.verifyShoppingCartIsEmpty("Your Shopping Cart is empty!");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 03: Verify product is NOT displayed in shopping cart");
		Assert.assertTrue(userShopingCartPage.verifyProductisRemovedSuccess("Build your own computer"));
	}
	
	@Test
	public void Order_04_Update_Product_In_Shopping_Cart(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Update shopping cart");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 01: Search product Lenovo IdeaCentre 600 All-in-One PC");
		userShopingCartPage.searchOnGlobalSearch(driver, "Lenovo IdeaCentre 600 All-in-One PC");
		sleepInSecond(2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 02: Click Add to Cart");
		userShopingCartPage.clicktoButtonByText(driver, "Add to cart");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 03: Close message");
		userShopingCartPage.closeBarNotification(driver);
		sleepInSecond(3);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 04: Click shopping cart");
		userShopingCartPage.openShoppingCart(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 05: Increase quantity upto 5 products");
		userShopingCartPage.increaseQuantityOfProducts("Lenovo IdeaCentre 600 All-in-One PC", "5");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 06: Click Update shopping cart");
		userShopingCartPage.clickUpdateShoppingCart();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 07: Verify price");
		userShopingCartPage.veirfyThePriceOfProduct("Lenovo IdeaCentre 600 All-in-One PC","$2,500.00");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 08: Remove product");
		userShopingCartPage.removeProductInCart("Lenovo IdeaCentre 600 All-in-One PC");
	}
	
	@Test
	public void Order_05_Checkout_Order_Payment_Method_Cheque(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Checkout or Order by Payment Method Cheque");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 01: Search product Apple MacBook Pro 13-inch");
		userShopingCartPage.searchOnGlobalSearch(driver, "Apple MacBook Pro 13-inch");
		sleepInSecond(2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 02: Click Add to Cart in global search");
		userShopingCartPage.clicktoButtonByText(driver, "Add to cart");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 03: Click Add to Cart in Detail Product Page");
		userDetailProductPage = userShopingCartPage.clicktoButtonAddToCart();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 04: Close message");
		userDetailProductPage.closeBarNotification(driver);
		sleepInSecond(3);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 05: Click shopping cart");
		userShopingCartPage = userDetailProductPage.OpenShoppingCard();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 06: Tick accept term of service");
		userShopingCartPage.tickAcceptTermOfService();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 07: Click Checkout");
		userCheckOutPage = userShopingCartPage.clickButtonCheckout();	
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 08: Select Shipping Address");
		userCheckOutPage.untickShipToSameAddress();
		userCheckOutPage.selectBillingAddress("New Address");
		sleepInSecond(2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 09: Input Billing Address");
		userCheckOutPage.inputFirstName("Nguyen");
		userCheckOutPage.inputLastName("Van A");
		userCheckOutPage.inputEmail("automationfc.vn@gmail.com");
		userCheckOutPage.selectCountry("United Kingdom");
		userCheckOutPage.selectStateAndProvince("Other");
		userCheckOutPage.inputCity("Manchester");
		userCheckOutPage.inputAddress1("113 New world street, Ward 11, Home District");
		userCheckOutPage.inputZipCode("2000");
		userCheckOutPage.inputPhoneNumber("+2 9999112113");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 10: Click Countinue button");
		userCheckOutPage.clicktoButtonByText(driver, "Continue");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 11: Select Shipping Address");
		userCheckOutPage.selectShippingAddress("New Address");
		sleepInSecond(2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 12: Input Shipping Address");
		userCheckOutPage.selectShippingCountry("Viet Nam");
		userCheckOutPage.selectShippingStateAndProvince("Other");
		userCheckOutPage.inputShippingCity("Ho Chi Minh");
		userCheckOutPage.inputShippingAddress1("113 Hoang Hoa Tham street, Ward 11, Tan Binh District");
		userCheckOutPage.inputShippingZipCode("70000");
		userCheckOutPage.inputShippingPhoneNumber("09999112113");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 13: Click Countinue button");
		userCheckOutPage.clicktoShippingCountinueButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 14: Select Shipping Method");
		userCheckOutPage.clickShippingMethod("Ground ($0.00)");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 15: Click Countinue button");
		userCheckOutPage.clicktoShippingMethodCountinueButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 16: Select Payment Method");
		userCheckOutPage.clickPaymentMethod("Check / Money Order");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 17: Click Countinue button");
		userCheckOutPage.clicktoPaymentMethodCountinueButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 18: Verify Payment information");
		userCheckOutPage.verifyPaymentInformation("Mail Personal or Business Check, Cashier's Check or money order to:  NOP SOLUTIONS your address here, New York, NY 10001 USA Notice that if you pay by Personal or Business Check, your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. If you want us to ship faster upon receipt of your payment, then we recommend your send a money order or Cashier's check. P.S. You can edit this text from admin panel.");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 19: Click Countinue button");
		userCheckOutPage.clicktoPaymentInfoCountinueButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 20: Verify Order Information Billing Information");
		userCheckOutPage.verifyOrderInformation("Billing Address", "NAME", "Nguyen Van A");
		userCheckOutPage.verifyOrderInformation("Billing Address", "email", "Email: automationfc.vn@gmail.com");
		userCheckOutPage.verifyOrderInformation("Billing Address", "phone", "Phone: +2 9999112113");
		userCheckOutPage.verifyOrderInformation("Billing Address", "fax", "Fax: ");
		userCheckOutPage.verifyOrderInformation("Billing Address", "ADDREsS1", "113 New world street, Ward 11, Home District");
		userCheckOutPage.verifyOrderInformation("Billing Address", "city-state-zip", "Manchester,2000 ");
		userCheckOutPage.verifyOrderInformation("Billing Address", "country", "United Kingdom");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 21: Verify Order Information Billing Payment");
		userCheckOutPage.verifyOrderInformation("Payment", "payment-method", "Check / Money Order");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 22: Verify Order Information Shipping Information");
		userCheckOutPage.verifyOrderInformation("Shipping Address", "name", "Nguyen Van A");
		userCheckOutPage.verifyOrderInformation("Shipping Address", "email", "Email: automationfc.vn@gmail.com");
		userCheckOutPage.verifyOrderInformation("Shipping Address", "phone", "Phone: 09999112113");
		userCheckOutPage.verifyOrderInformation("Shipping Address", "fax", "Fax: ");
		userCheckOutPage.verifyOrderInformation("Shipping Address", "ADDREsS1", "113 Hoang Hoa Tham street, Ward 11, Tan Binh District");
		userCheckOutPage.verifyOrderInformation("Shipping Address", "city-state-zip", "Ho Chi Minh,70000");
		userCheckOutPage.verifyOrderInformation("Shipping Address", "country", "Viet Nam");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 23: Verify Order Information Shipping Method");
		userCheckOutPage.verifyOrderInformation("Shipping", "shipping-method", "Ground");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 24: Verify Order Information Shopping card information");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Checkout Page - Step 24: Click Confirm button");
		userCheckOutPage.clickToOrderConfirmButton();
	}
	
	@Test
	public void Order_06_Checkout_Order_Payment_Method_By_Card_Visa_Master(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Checkout or Order by Card");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 01: Back To Home Page");
			
	}
	
	@Test
	public void Order_07_ReOrder(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Re-Order");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 01: Back To Home Page");
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress, validPassword;
	private String firstName, lastName;

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserDetailProductPageObject userDetailProductPage;
	private UserShopingCartPageObject userShopingCartPage;
	private UserCheckOutPageObject userCheckOutPage;
}
