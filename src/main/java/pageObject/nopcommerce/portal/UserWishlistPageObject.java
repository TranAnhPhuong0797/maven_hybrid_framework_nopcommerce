package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.nopcommerce.User.UserWishlistPageUI;

public class UserWishlistPageObject extends BasePage{
	WebDriver driver;

	public UserWishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToWishlistSharing() {
		waitForElementClickable(driver, UserWishlistPageUI.WISHLIST_SHARING_LINK);
		clickToElement(driver, UserWishlistPageUI.WISHLIST_SHARING_LINK);
	}

	public boolean verifyProductisAddedSuccess(String product) {
		return isElementDisplayed(driver, UserWishlistPageUI.WISHLIST_PRODUCT_NAME, product);
	}
	
	
}
