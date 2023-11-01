package pageObject.nopcommerce.portal;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.BasePage;
import pageUI.nopcommerce.User.ShopingCartPageUI;

public class UserShopingCartPage extends BasePage {
	WebDriver driver;

	public UserShopingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyProductisAddedSuccess(String product) {
		return isElementDisplayed(driver, ShopingCartPageUI.SHOPINGCART_PRODUCT_NAME, product);
	}

	public UserDetailProductPageObject clickEditProduct(String product) {
		waitForElementClickable(driver, ShopingCartPageUI.EDIT_PRODUCT_BUTTON, product);
		clickToElement(driver, ShopingCartPageUI.EDIT_PRODUCT_BUTTON, product);
		return PageGeneratorManager.getUserDetailProductPage(driver);
	}

	public void veirfyThePriceOfProduct(String productName, String productPrice) {
		waitForElementVisible(driver, ShopingCartPageUI.SHOPINGCART_PRODUCT_PRICE, productName);
		Assert.assertEquals(getTextElement(driver, ShopingCartPageUI.SHOPINGCART_PRODUCT_PRICE, productName),
				productPrice);
	}

	public void verifyInformationOfProduct(String product, String infor) {
		waitForElementVisible(driver, ShopingCartPageUI.PRODUCT_INFORMATION, product);
		String information = getTextElement(driver, ShopingCartPageUI.PRODUCT_INFORMATION, product);
		System.out.println(information);
		switch (infor) {
		case "Processor":
			
			break;

		case "RAM":

			break;

		case "HDD":

			break;

		case "OS":

			break;
			
		case "Software":

			break;
		}
	}

}
