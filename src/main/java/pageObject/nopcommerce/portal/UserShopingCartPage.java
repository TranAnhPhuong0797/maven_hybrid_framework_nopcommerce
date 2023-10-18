package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.nopcommerce.User.ShopingCartPageUI;

public class UserShopingCartPage extends BasePage{
	WebDriver driver;

	public UserShopingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyProductisAddedSuccess(String product) {
		return isElementDisplayed(driver, ShopingCartPageUI.SHOPINGCART_PRODUCT_NAME, product);
	}
	
	
}
