package com.nopcommerce.user.livecoding;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.BaseTest;
import pageObject.nopcommerce.portal.UserHomePageObject;
import pageObject.nopcommerce.portal.PageGeneratorManager;
import pageObject.nopcommerce.portal.UserRegisterPageObject;
import reportConfig.ExtentTestManagerV5;

public class LiveCoding_nopcommerce_Register_TestCase extends BaseTest{
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserName(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstname = "Tony";
		lastname = "Teo";
		invalidEmail = "testEmail" + fakeNumber() + "@@gmail.vn";
		emailAddress = "testEmail" + fakeNumber() + "@gmail.vn";
		validPassword = "123789";
		incorrectPassword = "1234";
		
		log.info("Preconditions - Step 01: Navigate to Register Page");
		registerPage = homePage.clickToRegisterLink();
		
	}

	@Test
	public void Register_01_With_EmptyData(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With EmptyData");
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Click Register Button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02: Verify error message from first name textbox");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextBox(), "First name is required.");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03: Verify error message from last name textbox");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(), "Last name is required.");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 04: Verify error message from email textbox");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Email is required.");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 05: Verify error message from password textbox");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password is required.");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 06: Verify error message from confirm password textbox");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "Password is required.");
	}
	
	@Test
	public void Register_02_With_InvalidEmail(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With InvalidEmail");
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Input invalid email");
		registerPage.inputToEmailTextBox(invalidEmail);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02: Click Register Button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03: Verify error message from email textbox");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Wrong email");
	}
			
	@Test
	public void Register_03_With_Valid_Infor(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With Valid Infor");
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Input first name");
		registerPage.inputToFirstNameTextBox(firstname);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02: Input last name");
		registerPage.inputToLastNameTextBox(lastname);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03: Input email");
		registerPage.inputToEmailTextBox(emailAddress);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 04: Input password");
		registerPage.inputToPasswordTextBox(validPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 05: Input confirm password");
		registerPage.inputToConfirmPasswordTextBox(validPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 06: Click Register Button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 07: Verify message registration completed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 08: Click Continue Button");
		registerPage.clicktoContinueButton();
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 09: Click Register link");
		homePage.clickToRegisterLink();
	}
	
	@Test
	public void Register_04_With_Email_Aldready_Exists(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With Email Aldready Exists");
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Input first name");
		registerPage.inputToFirstNameTextBox(firstname);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02: Input last name");
		registerPage.inputToLastNameTextBox(lastname);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03: Input email");
		registerPage.inputToEmailTextBox(emailAddress);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 04: Input password");
		registerPage.inputToPasswordTextBox(validPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 05: Input confirm password");
		registerPage.inputToConfirmPasswordTextBox(validPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 06: Click Register Button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 07: Verify error message email already exists");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}
	
	@Test
	public void Register_05_With_Password_LessThan_6Chars(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With Password LessThan 6Chars");
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Input incorrect password");
		registerPage.inputToPasswordTextBox(incorrectPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02: Click Register Button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03: Verify error message password");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password must meet the following rules:\n" + "must have at least 6 characters");
	}
	
	@Test
	public void  Register_06_With_ConfirmPassword_NotCorrect(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register With ConfirmPassword NotCorrect");
		registerPage = PageGeneratorManager.getUserRegistorPage(driver);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Input password");
		registerPage.inputToPasswordTextBox(validPassword);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02: Input incorrect confirmation password");
		registerPage.inputToConfirmPasswordTextBox("012345");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03: Click Register Button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 04: Verify error message confirm password");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "The password and confirmation password do not match.");
	}
	
	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress, invalidEmail, firstname, lastname, validPassword, incorrectPassword;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
}
