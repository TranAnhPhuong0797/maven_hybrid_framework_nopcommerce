package com.nopcommerce.user.livecoding;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.data.UserData;

import common.BaseTest;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserRegisterPageObject;
import pageObject.nopcommerce.portal.UserSearchPageObject;
import reportConfig.ExtentTestManagerV5;

public class LiveCoding_nopcommerce_Search_TestCase extends BaseTest{	
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
	}

	@Test
	public void Searh_01_Search_With_Empty_Data(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With EmptyData");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 01: Navigate to Search page");
		userHomePage.clickCustomerServiceLinkInFooter("Search");
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 02: Click Search button");
		userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
		userSearchPage.clickSearchButton();
		
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 03: Verify error message");
		userSearchPage.verifySearchErrorMessage("Search term minimum length is 3 characters");
	}
	
	@Test
	public void Searh_02_Search_With_Data_NOT_Exist(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With EmptyData");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 01: Input product not exist in the search field");
		userSearchPage.inputValueInSearchTextbox("Macbook Pro 2050");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 02: Click Search button");
		userSearchPage.clickSearchButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 03: Verify message no result is displayed");
		userSearchPage.verifySearchNoResultMessage();
	}
	
	@Test
	public void Searh_03_Search_With_Product_Name_Relative(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With EmptyData");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 01: Input product not exist in the search field");
		userSearchPage.inputValueInSearchTextbox("Lenovo");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 02: Click Search button");
		userSearchPage.clickSearchButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 03: Veirfy number product result is displayed");
		userSearchPage.productResultEqualDisplayed(2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 04: Veirfy product name is displayed");
		userSearchPage.VeirfyProductNameIsDisplayed("Lenovo IdeaCentre 600 All-in-One PC");
		userSearchPage.VeirfyProductNameIsDisplayed("Lenovo Thinkpad X1 Carbon Laptop");
	}
	
	@Test
	public void Searh_04_Search_With_Product_Name_Adsolute(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With EmptyData");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 01: Input product not exist in the search field");
		userSearchPage.inputValueInSearchTextbox("Thinkpad x1 carbon");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 02: Click Search button");
		userSearchPage.clickSearchButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 03: Veirfy number product result is displayed");
		userSearchPage.productResultEqualDisplayed(1);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 04: Veirfy product name is displayed");
		userSearchPage.VeirfyProductNameIsDisplayed("Lenovo Thinkpad X1 Carbon Laptop");
	}
	
	@Test
	public void Searh_05_Advanced_Search_With_Paren_Categories(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With EmptyData");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 01: Input value in Search textbox");
		userSearchPage.inputValueInSearchTextbox("Apple MacBook Pro");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 02: Tick the Advanced Search checkbox");
		userSearchPage.checkTheCheckBoxInSearchPage("Advanced search");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 03: Select categories with value = Computers");
		userSearchPage.selectCategoriesDropDownWithValue("Computers");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 04: Tick the Automatically search sub categories checkbox");
		userSearchPage.unCheckTheCheckBoxInSearchPage("Automatically search sub categories");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 05: Click Search button");
		userSearchPage.clickSearchButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 06: Verify message no result is displayed");
		userSearchPage.verifySearchNoResultMessage();
	}
	
	@Test
	public void Searh_06_Advanced_Search_With_SubCategories(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With EmptyData");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 01: Input value in Search textbox");
		userSearchPage.inputValueInSearchTextbox("Apple MacBook Pro");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 02: Tick the Advanced Search checkbox");
		userSearchPage.checkTheCheckBoxInSearchPage("Advanced search");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 03: Select categories with value = Computers");
		userSearchPage.selectCategoriesDropDownWithValue("Computers");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 04: Tick the Automatically search sub categories checkbox");
		userSearchPage.checkTheCheckBoxInSearchPage("Automatically search sub categories");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 05: Click Search button");
		userSearchPage.clickSearchButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 06: Veirfy number product result is displayed");
		userSearchPage.productResultEqualDisplayed(1);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 07: Veirfy product name is displayed");
		userSearchPage.VeirfyProductNameIsDisplayed("Apple MacBook Pro 13-inch");
	}
	
	@Test
	public void Searh_07_Advanced_Search_With_Incorrect_Manufacturer(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With EmptyData");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 01: Input value in Search textbox");
		userSearchPage.inputValueInSearchTextbox("Apple MacBook Pro");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 02: Tick the Advanced Search checkbox");
		userSearchPage.checkTheCheckBoxInSearchPage("Advanced search");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 03: Select categories with value = Computers");
		userSearchPage.selectCategoriesDropDownWithValue("Computers");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 04: Tick the Automatically search sub categories checkbox");
		userSearchPage.checkTheCheckBoxInSearchPage("Automatically search sub categories");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 05: Select manufacturer with value = HP");
		userSearchPage.selectManufacturerDropDownWithValue("HP");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 06: Click Search button");
		userSearchPage.clickSearchButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 07: Verify message no result is displayed");
		userSearchPage.verifySearchNoResultMessage();
	}
	
	@Test
	public void Searh_08_Advanced_Search_With_Correct_Manufacturer(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With EmptyData");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 01: Input value in Search textbox");
		userSearchPage.inputValueInSearchTextbox("Apple MacBook Pro");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 02: Tick the Advanced Search checkbox");
		userSearchPage.checkTheCheckBoxInSearchPage("Advanced search");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 03: Select categories with value = Computers");
		userSearchPage.selectCategoriesDropDownWithValue("Computers");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 04: Tick the Automatically search sub categories checkbox");
		userSearchPage.checkTheCheckBoxInSearchPage("Automatically search sub categories");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 05: Select manufacturer with value = Apple");
		userSearchPage.selectManufacturerDropDownWithValue("Apple");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 06: Click Search button");
		userSearchPage.clickSearchButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Search Page - Step 07: Veirfy product name is displayed");
		userSearchPage.VeirfyProductNameIsDisplayed("Apple MacBook Pro 13-inch");
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
	private UserSearchPageObject userSearchPage;
}
