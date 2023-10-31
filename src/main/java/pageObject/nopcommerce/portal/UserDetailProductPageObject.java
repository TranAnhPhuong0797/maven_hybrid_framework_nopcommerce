package pageObject.nopcommerce.portal;


import org.openqa.selenium.WebDriver;

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

	public void selectOptionProcessor(String processorValue) {
		waitForElementVisible(driver, DetailProductPageUI.PROCESSOR_DROPDOWN);
		selectItemInDefaultDropdown(driver, DetailProductPageUI.PROCESSOR_DROPDOWN, processorValue);
	}

	public void selectOptionRAM(String ramValue) {
		waitForElementVisible(driver, DetailProductPageUI.RAM_DROPDOWN);
		selectItemInDefaultDropdown(driver, DetailProductPageUI.RAM_DROPDOWN, ramValue);
	}

	public void clickOptionHDD(String hddValue) {
		waitForElementVisible(driver, DetailProductPageUI.HDD_RADIO_BUTTON_VALUE, hddValue);
		clickToElement(driver, DetailProductPageUI.HDD_RADIO_BUTTON_VALUE, hddValue);
	}

	public void clickOptionOS(String osValue) {
		waitForElementVisible(driver, DetailProductPageUI.OS_RADIO_BUTTON_VALUE, osValue);
		clickToElement(driver, DetailProductPageUI.OS_RADIO_BUTTON_VALUE, osValue);
	}

	public void clickOptionSoftware(String softwareValue) {
		waitForElementVisible(driver, DetailProductPageUI.SOFTWARE_CHECKBOX_VALUE, softwareValue);
		checkToDefaultCheckboxOrRadio(driver, DetailProductPageUI.SOFTWARE_CHECKBOX_VALUE, softwareValue);
	}


	public UserShopingCartPage OpenShoppingCard() {
		waitForElementClickable(driver, DetailProductPageUI.SHOPPING_CART_LINK);
		clickToElement(driver, DetailProductPageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getUserShopingCartPage(driver);
	}
}
