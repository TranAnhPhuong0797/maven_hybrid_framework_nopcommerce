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



}
