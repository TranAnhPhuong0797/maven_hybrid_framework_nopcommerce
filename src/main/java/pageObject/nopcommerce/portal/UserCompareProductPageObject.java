package pageObject.nopcommerce.portal;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.BasePage;
import pageUI.nopcommerce.User.CompareProductPageUI;

public class UserCompareProductPageObject extends BasePage{
	WebDriver driver;

	public UserCompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickClearListButton() {
		waitForElementClickable(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
	}

	public void verifyMessageNoItems(String message) {
		waitForElementVisible(driver, CompareProductPageUI.MESSAGE_COMPARE_LIST_NO_ITEM);
		assertEquals(getTextElement(driver, CompareProductPageUI.MESSAGE_COMPARE_LIST_NO_ITEM), message);
	}

	public boolean verifyCompareTableHaveRemoveButtons(int buttons) {
		waitForAllElementsVisible(driver, CompareProductPageUI.INDEX_COMPARE_TABLE_REMOVE_ROW);
		List<WebElement> elements = getListElements(driver, CompareProductPageUI.INDEX_COMPARE_TABLE_REMOVE_ROW);
		
		if(elements.size() == buttons) {
			return true;
		}else {
			return false;
		}
	}

	public void verifyCompapeTableProductNameWithIndex(String productName, String index) {
		waitForElementVisible(driver, CompareProductPageUI.INDEX_COMPARE_TABLE_NAME_ROW, index);
		Assert.assertEquals(getTextElement(driver, CompareProductPageUI.INDEX_COMPARE_TABLE_NAME_ROW, index), productName);
	}

	public void verifyCompareTableProductPriceWithIndex(String productPrice, String index) {
		waitForElementVisible(driver, CompareProductPageUI.INDEX_COMPARE_TABLE_PRICE_ROW, index);
		Assert.assertEquals(getTextElement(driver, CompareProductPageUI.INDEX_COMPARE_TABLE_PRICE_ROW, index), productPrice);
	}



	
}
