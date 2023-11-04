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
	
	public boolean verifyProductisRemovedSuccess(String product) {
		return isElementUndisplayed(driver, ShopingCartPageUI.SHOPINGCART_PRODUCT_NAME, product);
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

	public boolean verifyInformationOfProduct(String product, String infor, String contentInfor) {
		waitForElementVisible(driver, ShopingCartPageUI.PRODUCT_INFORMATION, product);
		String information = getTextElement(driver, ShopingCartPageUI.PRODUCT_INFORMATION, product).replace("\n", ",");
		
		String[] subInformation = information.split(",");
		
		switch (infor) {
		case "Processor":
			for (String findInfor : subInformation) {
				if (findInfor.contains(contentInfor)) {
					return true;
				}else {
					continue;
				}
			}
			break;

		case "RAM":
			for (String findInfor : subInformation) {
				if (findInfor.contains(contentInfor)) {
					return true;
				}else {
					continue;
				}
			}
			break;

		case "HDD":
			for (String findInfor : subInformation) {
				if (findInfor.contains(contentInfor)) {
					return true;
				}else {
					continue;
				}
			}
			break;

		case "OS":
			for (String findInfor : subInformation) {
				if (findInfor.contains(contentInfor)) {
					return true;
				}else {
					continue;
				}
			}
			break;
			
		case "Software":
			for (String findInfor : subInformation) {
				if (findInfor.contains(contentInfor)) {
					return true;
				}else {
					continue;
				}
			}
			break;
		}
		return false;
	}

	public void removeProductInCart(String productName) {
		waitForElementClickable(driver, ShopingCartPageUI.REMOVE_PRODUCT_BUTTON, productName);
		clickToElement(driver, ShopingCartPageUI.REMOVE_PRODUCT_BUTTON, productName);
	}

	public void verifyShoppingCartIsEmpty(String message) {
		waitForElementVisible(driver, ShopingCartPageUI.SHOPPING_CART_MESSAGE_EMPTY);
		Assert.assertEquals(getTextElement(driver, ShopingCartPageUI.SHOPPING_CART_MESSAGE_EMPTY), message);
	}

	public void increaseQuantityOfProducts(String productName, String quantity) {
		waitForElementVisible(driver, ShopingCartPageUI.QUANTITY_PRODUCT_TEXTBOX, productName);
		sendkeyToElement(driver, ShopingCartPageUI.QUANTITY_PRODUCT_TEXTBOX, quantity, productName);
	}

	public void clickUpdateShoppingCart() {
		waitForElementClickable(driver, ShopingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, ShopingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
	}

}
