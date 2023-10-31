package pageUI.nopcommerce.User;

public class DetailProductPageUI {
	
	public static final String ADD_YOUR_REVIEW_LINK = "xpath=//a[text()='Add your review']";
	public static final String ADD_TO_WISHLIST_BUTTON = "xpath=//div[@class='add-to-wishlist']/button";
	public static final String ADD_TO_COMPARE_LIST_BUTTON = "xpath=//div[@class='compare-products']/button";
	public static final String EMAIL_A_FRIEND = "xpath=//div[@class='email-a-friend']/button";
	public static final String WISHLIST_LINK = "xpath=//a[@class='ico-wishlist']";
	public static final String SHOPPING_CART_LINK = "xpath=//a[@class='ico-cart']/span[@class='cart-label']";
	
	//Information production
	public static final String PROCESSOR_DROPDOWN = "xpath=(//label[contains(text(),'Processor')]//parent::dt//following-sibling::dd/select)[1]";
	public static final String RAM_DROPDOWN = "xpath=(//label[contains(text(),'RAM')]//parent::dt//following-sibling::dd/select)[1]";
	public static final String HDD_RADIO_BUTTON_VALUE = "xpath=//label[contains(text(),'%s')]//preceding-sibling::input";
	public static final String OS_RADIO_BUTTON_VALUE = "xpath=//label[contains(text(),'%s')]//preceding-sibling::input";
	public static final String SOFTWARE_CHECKBOX_VALUE = "xpath=//label[contains(text(),'%s')]//preceding-sibling::input";
}
