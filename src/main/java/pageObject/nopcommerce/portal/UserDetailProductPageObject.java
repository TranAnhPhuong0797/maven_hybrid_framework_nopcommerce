package pageObject.nopcommerce.portal;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.BasePage;
import pageUI.nopcommerce.User.DetailProductPageUI;


public class UserDetailProductPageObject extends BasePage{
	private WebDriver driver;
	
	public UserDetailProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickAddYourReview() {
		waitForElementClickable(driver, DetailProductPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, DetailProductPageUI.ADD_YOUR_REVIEW_LINK);
	}

	public void addToWishlist() {
		waitForElementClickable(driver, DetailProductPageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, DetailProductPageUI.ADD_TO_WISHLIST_BUTTON);
	}

	public UserWishlistPageObject OpenWishlist() {
		waitForElementClickable(driver, DetailProductPageUI.WISHLIST_LINK);
		clickToElement(driver, DetailProductPageUI.WISHLIST_LINK);
		return PageGeneratorManager.getUserWishlistPage(driver);
	}

	public void selectOptionProcessorIs(String processorValue) {
		waitForElementVisible(driver, DetailProductPageUI.PROCESSOR_DROPDOWN);
		selectItemInDefaultDropdown(driver, DetailProductPageUI.PROCESSOR_DROPDOWN, processorValue);
	}

	public void selectOptionRAMIs(String ramValue) {
		waitForElementVisible(driver, DetailProductPageUI.RAM_DROPDOWN);
		selectItemInDefaultDropdown(driver, DetailProductPageUI.RAM_DROPDOWN, ramValue);
	}

	public void clickOptionHDDIs(String hddValue) {
		waitForElementVisible(driver, DetailProductPageUI.HDD_RADIO_BUTTON_VALUE, hddValue);
		clickToElement(driver, DetailProductPageUI.HDD_RADIO_BUTTON_VALUE, hddValue);
	}

	public void clickOptionOSIs(String osValue) {
		waitForElementVisible(driver, DetailProductPageUI.OS_RADIO_BUTTON_VALUE, osValue);
		clickToElement(driver, DetailProductPageUI.OS_RADIO_BUTTON_VALUE, osValue);
	}

	public void clickOptionSoftwareIs(String softwareValue) {
		waitForElementVisible(driver, DetailProductPageUI.SOFTWARE_CHECKBOX_VALUE, softwareValue);
		checkToDefaultCheckboxOrRadio(driver, DetailProductPageUI.SOFTWARE_CHECKBOX_VALUE, softwareValue);
	}
	
	public void UntickOptionSoftwareIs(String softwareValue) {
		waitForElementVisible(driver, DetailProductPageUI.SOFTWARE_CHECKBOX_VALUE, softwareValue);
		unCheckToDefaultCheckboxOrRadio(driver, DetailProductPageUI.SOFTWARE_CHECKBOX_VALUE, softwareValue);
	}

	public void editQuantityProductis(String quantity) {
		waitForElementVisible(driver, DetailProductPageUI.QUANTITY_TEXTBOX);
		sendkeyToElement(driver, DetailProductPageUI.QUANTITY_TEXTBOX, quantity);
	}

	public void verifyProductPriceIs(String price) {
		waitForElementVisible(driver, DetailProductPageUI.PRODUCT_PRICE);
		Assert.assertEquals(getTextElement(driver, DetailProductPageUI.PRODUCT_PRICE), price);
	}
	
	public UserShopingCartPageObject OpenShoppingCard() {
		waitForElementClickable(driver, DetailProductPageUI.SHOPPING_CART_LINK);
		clickToElement(driver, DetailProductPageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getUserShopingCartPage(driver);
	}
	
}
