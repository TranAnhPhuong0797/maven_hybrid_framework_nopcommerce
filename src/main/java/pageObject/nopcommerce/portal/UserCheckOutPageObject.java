package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.BasePage;
import pageUI.nopcommerce.User.CheckOutPageUI;

public class UserCheckOutPageObject extends BasePage {
	WebDriver driver;

	public UserCheckOutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void untickShipToSameAddress() {
		waitForElementClickable(driver, CheckOutPageUI.BILLING_SHIP_TO_THE_SAME_ADDRESS_CHECKBOX);
		unCheckToDefaultCheckboxOrRadio(driver, CheckOutPageUI.BILLING_SHIP_TO_THE_SAME_ADDRESS_CHECKBOX);
	}
	
	public void selectBillingAddress(String billingAddress) {
		waitForElementVisible(driver, CheckOutPageUI.BILLING_ADDRESS_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, CheckOutPageUI.BILLING_ADDRESS_DROPDOWN_LIST, billingAddress);
	}

	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, CheckOutPageUI.BILLING_FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, CheckOutPageUI.BILLING_FIRSTNAME_TEXTBOX, firstName);
	}

	public void inputLastName(String lastName) {
		waitForElementVisible(driver, CheckOutPageUI.BILLING_LASTNAME_TEXTBOX);
		sendkeyToElement(driver, CheckOutPageUI.BILLING_LASTNAME_TEXTBOX, lastName);
	}

	public void inputEmail(String email) {
		waitForElementVisible(driver, CheckOutPageUI.BILLING_EMAIL_TEXTBOX);
		sendkeyToElement(driver, CheckOutPageUI.BILLING_EMAIL_TEXTBOX, email);
	}
	
	public void selectCountry(String country) {
		waitForElementVisible(driver, CheckOutPageUI.BILLING_COUNTRY_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, CheckOutPageUI.BILLING_COUNTRY_DROPDOWN_LIST, country);
	}

	public void selectStateAndProvince(String state) {
		waitForElementVisible(driver, CheckOutPageUI.BILLING_STATE_PROVINCE_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, CheckOutPageUI.BILLING_STATE_PROVINCE_DROPDOWN_LIST, state);
	}

	public void inputAddress1(String address) {
		waitForElementVisible(driver, CheckOutPageUI.BILLING_ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, CheckOutPageUI.BILLING_ADDRESS1_TEXTBOX, address);
	}

	public void inputCity(String city) {
		waitForElementVisible(driver, CheckOutPageUI.BILLING_CITY_TEXTBOX);
		sendkeyToElement(driver, CheckOutPageUI.BILLING_CITY_TEXTBOX, city);
	}

	public void inputZipCode(String zipCode) {
		waitForElementVisible(driver, CheckOutPageUI.BILLING_ZIP_CODE_TEXTBOX);
		sendkeyToElement(driver, CheckOutPageUI.BILLING_ZIP_CODE_TEXTBOX, zipCode);
	}

	public void inputPhoneNumber(String phone) {
		waitForElementVisible(driver, CheckOutPageUI.BILLING_PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, CheckOutPageUI.BILLING_PHONE_NUMBER_TEXTBOX, phone);
	}

	public void selectShippingAddress(String shippingAddress) {
		waitForElementVisible(driver, CheckOutPageUI.SHIPPING_ADDRESS_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, CheckOutPageUI.SHIPPING_ADDRESS_DROPDOWN_LIST, shippingAddress);
	}
	
	public void selectShippingCountry(String shippingCountry) {
		waitForElementVisible(driver, CheckOutPageUI.SHIPPING_COUNTRY_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, CheckOutPageUI.SHIPPING_COUNTRY_DROPDOWN_LIST, shippingCountry);
	}

	public void selectShippingStateAndProvince(String shippingState) {
		waitForElementVisible(driver, CheckOutPageUI.SHIPPING_STATE_PROVINCE_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, CheckOutPageUI.SHIPPING_STATE_PROVINCE_DROPDOWN_LIST, shippingState);
	}

	public void inputShippingCity(String shippingCity) {
		waitForElementVisible(driver, CheckOutPageUI.SHIPPING_CITY_TEXTBOX);
		sendkeyToElement(driver, CheckOutPageUI.SHIPPING_CITY_TEXTBOX, shippingCity);
	}

	public void inputShippingAddress1(String shippingAddress) {
		waitForElementVisible(driver, CheckOutPageUI.SHIPPING_ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, CheckOutPageUI.SHIPPING_ADDRESS1_TEXTBOX, shippingAddress);
	}

	public void inputShippingZipCode(String shippingZipcode) {
		waitForElementVisible(driver, CheckOutPageUI.SHIPPNG_ZIP_CODE_TEXTBOX);
		sendkeyToElement(driver, CheckOutPageUI.SHIPPNG_ZIP_CODE_TEXTBOX, shippingZipcode);
	}

	public void inputShippingPhoneNumber(String shippingPhone) {
		waitForElementVisible(driver, CheckOutPageUI.SHIPPNG_PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, CheckOutPageUI.SHIPPNG_PHONE_NUMBER_TEXTBOX, shippingPhone);
	}
	
	public void clicktoShippingCountinueButton() {
		waitForElementClickable(driver, CheckOutPageUI.SHIPPING_COUNTINUE_BUTTON);
		clickToElement(driver, CheckOutPageUI.SHIPPING_COUNTINUE_BUTTON);
	}

	public void clickShippingMethod(String shippingMethod) {
		waitForElementClickable(driver, CheckOutPageUI.SHIPPING_METHOD_RADIO_BUTTON, shippingMethod);
		checkToDefaultCheckboxOrRadio(driver, CheckOutPageUI.SHIPPING_METHOD_RADIO_BUTTON, shippingMethod);
	}
	
	public void clicktoShippingMethodCountinueButton() {
		waitForElementClickable(driver, CheckOutPageUI.SHIPPING_METHOD_COUNTINUE_BUTTON);
		clickToElement(driver, CheckOutPageUI.SHIPPING_METHOD_COUNTINUE_BUTTON);
	}
	
	public void clickPaymentMethod(String paymentMethod) {
		waitForElementClickable(driver, CheckOutPageUI.PAYMENT_METHOD_RADIO_BUTTON, paymentMethod);
		checkToDefaultCheckboxOrRadio(driver, CheckOutPageUI.PAYMENT_METHOD_RADIO_BUTTON, paymentMethod);	
	}		
	
	public void clicktoPaymentMethodCountinueButton() {
		waitForElementClickable(driver, CheckOutPageUI.PAYMENT_METHOD_COUNTINUE_BUTTON);
		clickToElement(driver, CheckOutPageUI.PAYMENT_METHOD_COUNTINUE_BUTTON);
	}

	public void verifyPaymentInformation(String info) {
		waitForElementVisible(driver, CheckOutPageUI.PAYMENT_INFORMATION);
		String information = getTextElement(driver, CheckOutPageUI.PAYMENT_INFORMATION).replace("\n", " ");
		Assert.assertEquals(information, info);	
	}
	
	public void clicktoPaymentInfoCountinueButton() {
		waitForElementClickable(driver, CheckOutPageUI.PAYMENT_INFO_COUNTINUE_BUTTON);
		clickToElement(driver, CheckOutPageUI.PAYMENT_INFO_COUNTINUE_BUTTON);
	}

	public boolean verifyOrderInformation(String orderInfo, String typeInfo, String value) {
		switch (orderInfo.toUpperCase()) {
		case "BILLING ADDRESS":
			waitForElementVisible(driver, CheckOutPageUI.ORDER_INFORMATION_BILLING_ADDRESS_INFO, typeInfo.toLowerCase());
			Assert.assertEquals(getTextElement(driver, CheckOutPageUI.ORDER_INFORMATION_BILLING_ADDRESS_INFO, typeInfo.toLowerCase()).trim(), value.trim());
			break;
		
		case "PAYMENT":	
			waitForElementVisible(driver, CheckOutPageUI.ORDER_INFORMATION_BILLING_ADDRESS_PAYMENT, typeInfo.toLowerCase());
			Assert.assertEquals(getTextElement(driver, CheckOutPageUI.ORDER_INFORMATION_BILLING_ADDRESS_PAYMENT, typeInfo.toLowerCase()).trim(), value.trim());
			break;
			
		case "SHIPPING ADDRESS":
			waitForElementVisible(driver, CheckOutPageUI.ORDER_INFORMATION_SHIPPING_ADDRESS_INFO, typeInfo.toLowerCase());
			Assert.assertEquals(getTextElement(driver, CheckOutPageUI.ORDER_INFORMATION_SHIPPING_ADDRESS_INFO, typeInfo.toLowerCase()).trim(), value.trim());
			break;
			
		case "SHIPPING":
			waitForElementVisible(driver, CheckOutPageUI.ORDER_INFORMATION_SHIPPING_ADDRESS_METHOD, typeInfo.toLowerCase());
			Assert.assertEquals(getTextElement(driver, CheckOutPageUI.ORDER_INFORMATION_SHIPPING_ADDRESS_METHOD, typeInfo.toLowerCase()).trim(), value.trim());
			break;
		}
		return false;
	}

	public void clickToOrderConfirmButton() {
		waitForElementClickable(driver, CheckOutPageUI.ORDER_INFORMATION_CONFIRM_BUTTON);
		clickToElement(driver, CheckOutPageUI.ORDER_INFORMATION_CONFIRM_BUTTON);
	}

}
