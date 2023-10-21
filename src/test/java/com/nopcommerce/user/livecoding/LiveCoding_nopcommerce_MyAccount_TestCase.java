package com.nopcommerce.user.livecoding;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.BaseTest;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.UserLoginPageObject;
import pageObject.nopcommerce.portal.UserMyProductReviewPageObject;
import pageObject.nopcommerce.portal.UserProductReviewPageObject;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserAddressPageObject;
import pageObject.nopcommerce.portal.UserCategoriesPageObject;
import pageObject.nopcommerce.portal.UserChangePasswordPageObject;
import pageObject.nopcommerce.portal.UserCustomerInforPageObject;
import pageObject.nopcommerce.portal.UserDetailProductPageObject;
import pageObject.nopcommerce.portal.UserRegisterPageObject;
import reportConfig.ExtentTestManagerV5;

public class LiveCoding_nopcommerce_MyAccount_TestCase extends BaseTest{
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Tony";
		lastName = "Teo";
		emailAddress = "automationfc.vn@gmail.com";
		validPassword = "123456";
		companyName = "Automate Company";
		gender = "Female";
		days = "01";
		months = "January";
		years = "1999";
		country = "Viet Nam";
		stateProvince = "Other";
		city = "Da Nang";
		address1 = "123/04 Le Lai";
		address2 = "234/05 Hai Phong";
		zipcode = "550000";
		phoneNumber = "0123456789";
		faxNumber = "0987654321";
		newPassword = "654321";
		
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
	public void MyAccount_01_CustomerInfor(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "CustomerInfor page");
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 01: Navigate to My account page");
		customerInforPage = userHomePage.clickToMyAccountLink();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 02: Verify My account page displayed");
		Assert.assertTrue(customerInforPage.isMyAccountPageDisplayed());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 03: Select gender");
		customerInforPage.selectGender(gender);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 04: Input first name");
		customerInforPage.inputFirstName(firstName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 05: Input last name");
		customerInforPage.inputLastName(lastName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 04: Input email");
		customerInforPage.inputEmailAddress(emailAddress);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 05: Input company name");
		customerInforPage.inputCompanyName(companyName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 06: Select day");
		customerInforPage.selectDays(days);

		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 07: Select month");
		customerInforPage.selectMonths(months);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 08: Select year");
		customerInforPage.selectYears(years);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 09: Click Save button");
		customerInforPage.clicktoButtonByText(driver, "Save");
	}
	
	@Test
	public void MyAccount_02_Address(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Address page");
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 01: Navigate to Address page");
		addressPage = customerInforPage.openAddressPage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 02: Click Add New button");
		addressPage.clicktoButtonByText(driver, "Add new");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 03: Input first name");
		addressPage.inputToTextboxByText(driver, "First name", firstName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 04: Input last name");
		addressPage.inputToTextboxByText(driver, "Last name", lastName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 05: Input email");
		addressPage.inputToTextboxByText(driver, "Email", emailAddress);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 06: Input company");
		addressPage.inputToTextboxByText(driver, "Company", companyName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 07: Select country");
		addressPage.selectCountryDropdownlist(country);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 08: Select state/province");
		addressPage.selectStateProvinceDropdownlist(stateProvince);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 09: Input city");
		addressPage.inputToTextboxByText(driver, "City", city);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 10: Input address 1");
		addressPage.inputToTextboxByText(driver, "Address 1", address1);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 11: Input address 2");
		addressPage.inputToTextboxByText(driver, "Address 2", address2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 12: Input zip / portal code");
		addressPage.inputToTextboxByText(driver, "Zip / postal code", zipcode);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 13: Input phone number");
		addressPage.inputToTextboxByText(driver, "Phone number", phoneNumber);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 14: Input fax number");
		addressPage.inputToTextboxByText(driver, "Fax number", faxNumber);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 15: Click Save button");
		addressPage.clicktoButtonByText(driver, "Save");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 16: Veirfy message address added successfully");
		addressPage.verifyNotificationAddressAddedSuccessfully("The new address has been added successfully.");
	}
	
	@Test
	public void MyAccount_03_ChangePassword(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Change Password page");
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 01: Navigate to Chang Password page");
		changePasswordPage = addressPage.openChangePasswordPage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 02: Input old password");
		changePasswordPage.inputToTextboxByText(driver, "Old password", validPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 03: Input new password");
		changePasswordPage.inputToTextboxByText(driver, "New password", newPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 04: Input confirm new password");
		changePasswordPage.inputToTextboxByText(driver, "Confirm password", newPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 05: Click Save button");
		customerInforPage.clicktoButtonByText(driver, "Change password");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 06: Click logout link");
		userHomePage = userRegisterPage.clickToLogoutLink();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 07: Click login link");
		userLoginPage = userHomePage.openLoginPage();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 08: Login new User");
		userHomePage = userLoginPage.LoginAsUser(emailAddress, validPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 09: Verify login unsuccessful message");
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessgfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 10: Login new User");
		userHomePage = userLoginPage.LoginAsUser(emailAddress, newPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 11: Verify My account link displayed");
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void MyAccount_04_MyProduct_Reviews(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "My product review page");
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 01: Back to Home Page");
		userHomePage.backToHomePage();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 02: Select menu computers");
		userHomePage.selectHeaderMenu("Computers");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 03: Select category Desktop");
		categoryPage = PageGeneratorManager.getUserCategoriesPage(driver);
		categoryPage.selectCategories("Desktops");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 04: Select product Build your own computer");
		categoryPage.selectProductTitle("Build your own computer");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 05: Click add review product");
		detailProductPage = PageGeneratorManager.getUserDetailProductPage(driver);
		detailProductPage.clickAddYourReview();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 06: Verify Product Review Page displays");
		productReviewPage = PageGeneratorManager.getUserProductReviewPage(driver);
		productReviewPage.verifyProductTitleIsDisplayedWithName("Build your own computer");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 07: input review title");
		productReviewPage.inputToTextboxByID(driver, "AddProductReview_Title", "Test review title");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 08: input review text");
		productReviewPage.inputToTextareaByID(driver, "AddProductReview_ReviewText", "Good Product");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 09: Click button submit review");
		productReviewPage.clicktoButtonByText(driver, "Submit review");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 10: Navigate to My account page");
		customerInforPage = userHomePage.clickToMyAccountLink();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 11: Open My product reviews");
		myProductReviewPage = customerInforPage.openMyProductReviewPage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "My account - Step 12: Veirfy my product review visibility");
		myProductReviewPage.verifyProductReviewTitle("Test review title");
		myProductReviewPage.verifyProductReviewContent("Good Product");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress, validPassword;
	private String firstName, lastName, companyName, gender, days, months, years,country, stateProvince, city, address1, address2, zipcode, phoneNumber, faxNumber, newPassword;

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserCategoriesPageObject categoryPage;
	private UserDetailProductPageObject detailProductPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserProductReviewPageObject productReviewPage;
}
