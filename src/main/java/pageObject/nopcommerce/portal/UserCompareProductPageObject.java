package pageObject.nopcommerce.portal;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

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

	
}
