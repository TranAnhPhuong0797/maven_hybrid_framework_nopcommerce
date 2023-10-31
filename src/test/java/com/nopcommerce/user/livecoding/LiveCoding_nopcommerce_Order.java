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
import pageObject.nopcommerce.portal.UserCategoriesPageObject;
import pageObject.nopcommerce.portal.UserCompareProductPageObject;
import pageObject.nopcommerce.portal.UserDetailProductPageObject;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.UserRecentlyViewProductPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;
import pageObject.nopcommerce.portal.UserShopingCartPage;
import pageObject.nopcommerce.portal.UserWishlistPageObject;
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
		userDetailProductPage.selectOptionProcessor("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 02: Select option RAM");
		userDetailProductPage.selectOptionRAM("8GB [+$60.00]");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 03: Select option HDD");
		userDetailProductPage.clickOptionHDD("400 GB [+$100.00]");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 04: Select option OS");
		userDetailProductPage.clickOptionOS("Vista Premium [+$60.00]");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 05: Select option Software");
		userDetailProductPage.clickOptionSoftware("Microsoft Office [+$50.00]");
		userDetailProductPage.clickOptionSoftware("Acrobat Reader [+$10.00]");
		userDetailProductPage.clickOptionSoftware("Total Commander [+$5.00]");
		
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
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 10: Verify the product is added into shopping cart");
		Assert.assertTrue(userShopingCartPage.verifyProductisAddedSuccess("Build your own computer"));
	}
	
	@Test
	public void Order_02_(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Edit product in shopping cart");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 01: Click edit product Build your own computer");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 02: Select option Processor");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 03: Select option RAM");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 04: Select option HDD");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 04: Select option OS");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 05: Select option Software");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 06: Increase quantity to 2 products");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 07: Verify price");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 08: Click button Update");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 09: Verify message");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 10: Close message");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 11: Click shopping cart");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 12: Verify information of product is updated in shopping cart");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 13: Verify price");
		
	}
	
	@Test
	public void Order_03_(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Remove product");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 01: Back To Home Page");
		
	}
	
	@Test
	public void Order_04_(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Add product to Compare");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 01: Back To Home Page");
		
		
		
	}
	
	@Test
	public void Order_05__(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Recently viewd products");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 01: Back To Home Page");
		
	}
	
	@Test
	public void Order_06__(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Recently viewd products");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 01: Back To Home Page");
		
	}
	
	@Test
	public void Order_07__(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Recently viewd products");
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
	private UserWishlistPageObject userWishlistPage;
	private UserShopingCartPage userShopingCartPage;
	private UserCompareProductPageObject userCompareProductPage;
	private UserCategoriesPageObject userCategoriesPage;
	private UserRecentlyViewProductPageObject userRecentlyViewProductPage;
}
