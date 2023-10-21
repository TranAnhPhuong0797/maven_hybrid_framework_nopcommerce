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
import pageObject.nopcommerce.portal.UserRegisterPageObject;
import pageObject.nopcommerce.portal.UserShopingCartPage;
import pageObject.nopcommerce.portal.UserWishlistPageObject;
import reportConfig.ExtentTestManagerV5;

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
		Assert.assertTrue(userWishlistPage.verifyProductisRemovedSuccess("Apple MacBook Pro 13-inch"));
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
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 07: Tick remove checkbox");
		userWishlistPage.clickRemoveProduct("HTC One M8 Android L 5.0 Lollipop");
		userWishlistPage.clickRemoveProduct("Apple MacBook Pro 13-inch");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 08: Verify wishlist is empty");
		userWishlistPage.verifyWishlistEmpty("The wishlist is empty!");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "WishList Page - Step 10: Verify product is removed");
		Assert.assertTrue(userWishlistPage.verifyProductisRemovedSuccess("HTC One M8 Android L 5.0 Lollipop"));
	}
	
	@Test
	public void Wishlist_04_Add_Product_To_Compare(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Add product to Compare");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 01: Back To Home Page");
		userWishlistPage.OpenHomePage(driver);
		
		sleepInSecond(2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 02: Add products to Compare");
		userHomePage.addProductToCompare("Build your own computer");
		sleepInSecond(1);
		userHomePage.addProductToCompare("$25 Virtual Gift Card");
		sleepInSecond(1);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 03: Verify messgate products is added to compare list");
		userHomePage.verifyBarNotificationWithHyperLink(driver, "The product has been added to your product comparison");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Compare Page - Step 04: Navigate to compare list");
		userCompareProductPage = userHomePage.clickCustomerServiceLinkInFooter("Compare products list");
		sleepInSecond(1);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Compare Page - Step 05: Verify information");
		userCompareProductPage.verifyCompareTableHaveRemoveButtons(2);
		userCompareProductPage.verifyCompapeTableProductNameWithIndex("$25 Virtual Gift Card", "2");
		userCompareProductPage.verifyCompapeTableProductNameWithIndex("Build your own computer", "3");
		userCompareProductPage.verifyCompareTableProductPriceWithIndex("$25.00", "2");
		userCompareProductPage.verifyCompareTableProductPriceWithIndex("$1,200.00", "3");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Compare Page - Step 06: Click Clear button");
		userCompareProductPage.clickClearListButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Compare Page - Step 07: Verify message no items to compare");
		userCompareProductPage.verifyMessageNoItems("You have no items to compare.");
		
		
	}
	
	@Test
	public void Wishlist_05_(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Recently viewd products");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 01: Back To Home Page");
		userWishlistPage.OpenHomePage(driver);
		
		sleepInSecond(2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Home Page - Step 02: Select Computer menu");
		userCategoriesPage = userHomePage.selectHeaderMenu("Computers");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Catagory Page - Step 03: Click 5 Products");
		userCategoriesPage.selectCategories("Desktops");
		userCategoriesPage.selectProductTitle("Build your own computer");
		userCategoriesPage.selectProductTitle("Digital Storm VANQUISH 3 Custom Performance PC");
		userCategoriesPage.selectProductTitle("Lenovo IdeaCentre 600 All-in-One PC");
		userCategoriesPage.selectCategories("Notebooks");
		userCategoriesPage.selectProductTitle("HP Spectre XT Pro UltraBook");
		userCategoriesPage.selectProductTitle("Lenovo Thinkpad X1 Carbon Laptop");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Catagory Page - Step 04: Navigate to Recently viewed products page");
		userCategoriesPage.SelectFooterCustomerService(driver, "Recently viewed products");
		
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
}
