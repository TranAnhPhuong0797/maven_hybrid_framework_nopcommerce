package pageObject.nopcommerce.portal;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.BasePage;
import pageUI.nopcommerce.User.RecentlyViewProductPageUI;

public class UserRecentlyViewProductPageObject extends BasePage{
	WebDriver driver;

	public UserRecentlyViewProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyProductNameVisible(String productName) {
		return isElementDisplayed(driver, RecentlyViewProductPageUI.PRODUCT_TITLE);
	}

	
}
