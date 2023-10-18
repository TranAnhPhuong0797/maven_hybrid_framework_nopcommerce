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
import pageObject.nopcommerce.portal.UserDetailProductPageObject;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;
import pageObject.nopcommerce.portal.UserShopingCartPage;
import pageObject.nopcommerce.portal.UserWishlistPageObject;
import reportConfig.ExtentTestManagerV5;
import utilities.DataHelper;

public class LiveCoding_nopcommerce_Wishlist_Compare_RecentView extends BaseTest{
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
		userDetailProductPage = userHomePage.selectProductInSectionFeaturedProducts("Apple MacBook Pro 13-inch");
	}
	
	@Test
	public void Wishlist_01_Add_To_Wishlist(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Add to Wishlist");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 01: Click Add to Wishlist");
		userDetailProductPage.addToWishlist();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 02: Verify message product has been added to your wishlist");
		Assert.assertTrue(userDetailProductPage.verifyBarNotification(driver, "The product has been added to your ")); 
		
		sleepInSecond(3);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 03: Close message");
		userDetailProductPage.closeBarNotification(driver);
		
		sleepInSecond(3);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 04: Navigate to Wishlist page");
		userWishlistPage = userDetailProductPage.OpenWishlist();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 05: Verify product is added in Wishlist page");
		Assert.assertTrue(userWishlistPage.verifyProductisAddedSuccess("Apple MacBook Pro 13-inch"));
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 06: Click Your wishlist URL for sharing");
		userWishlistPage.clickToWishlistSharing();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 07: Verifying wishlist view product from link");
		userWishlistPage.verifyTitleofWishlistViewProduct("Wishlist of Nguyen Van A");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 08: Veirify view product from link");
		Assert.assertTrue(userWishlistPage.verifyProductisAddedSuccess("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void Wishlist_02_Add_Product_To_Card_From_Wishlist(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Add Product to Card");
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 01: Select Product in Wishlist");
		userWishlistPage.addProduct("Apple MacBook Pro 13-inch");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 02: Click Add to Wishlist");
		userShopingCartPage = userWishlistPage.clicktoButtonAddToCart();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Shopping Cart Page - Step 03: Verify, navigate to Shopping Cart Page");
		Assert.assertTrue(userShopingCartPage.verifyProductisAddedSuccess("Apple MacBook Pro 13-inch"));
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 04: Back to Wishlist Page");
		userShopingCartPage.OpenWishlist(driver);
		
		sleepInSecond(3);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 05: Verify product is removed in wishlist page");
		Assert.assertFalse(userWishlistPage.verifyProductisAddedSuccess("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void Wishlist_03_Remove_Product_In_Wishlist(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Remove product");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 01: Back To Home Page");
		userWishlistPage.OpenHomePage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 02: Select any product in Home Page");
		userDetailProductPage = userHomePage.selectProductInSectionFeaturedProducts("HTC One M8 Android L 5.0 Lollipop");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 03: Click Add to Wishlist");
		userDetailProductPage.addToWishlist();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 04: Verify message product has been added to your wishlist");
		Assert.assertTrue(userDetailProductPage.verifyBarNotification(driver, "The product has been added to your ")); 
		
		sleepInSecond(3);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Detail Product Page - Step 05: Close message");
		userDetailProductPage.closeBarNotification(driver);
		
		sleepInSecond(3);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 06: Navigate to Wishlist page");
		userWishlistPage = userDetailProductPage.OpenWishlist();
	}
	
	@Test
	public void Wishlist_04_Add_Product_To_Compare(Method method) {
		//ExtentTestManagerV5.startTest(method.getName(), "Add product to Compare");
		
	}
	
	@Test
	public void Wishlist_05_(Method method) {
		
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
}
