package pageObject.nopcommerce.portal;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.nopcommerce.User.WishlistPageUI;

public class UserWishlistPageObject extends BasePage{
	WebDriver driver;

	public UserWishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToWishlistSharing() {
		waitForElementClickable(driver, WishlistPageUI.WISHLIST_SHARING_LINK);
		clickToElement(driver, WishlistPageUI.WISHLIST_SHARING_LINK);
	}

	public boolean verifyProductisAddedSuccess(String product) {
		return isElementDisplayed(driver, WishlistPageUI.WISHLIST_PRODUCT_NAME, product);
	}

	public boolean verifyProductisRemovedSuccess(String product) {
		return isElementUndisplayed(driver, WishlistPageUI.WISHLIST_PRODUCT_NAME, product);
	}
	
	public UserShopingCartPageObject clicktoButtonAddToCart() {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getUserShopingCartPage(driver);
	}

	public void verifyTitleofWishlistViewProduct(String title) {
		waitForElementVisible(driver, WishlistPageUI.TITLE_WISHLIST_PAGE);
		assertEquals(getTextElement(driver, WishlistPageUI.TITLE_WISHLIST_PAGE), title);
	}

	public void addProduct(String product) {
		waitForElementVisible(driver, WishlistPageUI.ADD_PRODUCT_CHECKBOX, product);
		checkToDefaultCheckboxOrRadio(driver, WishlistPageUI.ADD_PRODUCT_CHECKBOX, product);
	}

	public void clickRemoveProduct(String product) {
		waitForElementClickable(driver, WishlistPageUI.REMOVE_PRODUCT_BUTTON, product);
		clickToElement(driver, WishlistPageUI.REMOVE_PRODUCT_BUTTON, product);
	}

	public void verifyWishlistEmpty(String emptyMessage) {
		waitForElementVisible(driver, WishlistPageUI.MESSAGE_WISHLIST_EMPTY);
		assertEquals(getTextElement(driver, WishlistPageUI.MESSAGE_WISHLIST_EMPTY), emptyMessage);
		
	}
	
	
}
