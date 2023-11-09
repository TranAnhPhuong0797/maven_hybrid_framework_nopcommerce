package pageUI.nopcommerce.User;

public class ShopingCartPageUI {
	public static final String SHOPINGCART_PRODUCT_NAME = "xpath= //td[@class='product']//a[text()='%s']";
	public static final String SHOPINGCART_PRODUCT_PRICE = "xpath= //a[@class='product-name' and text()='%s']//parent::td//following-sibling::td[@class='subtotal']/span";
	public static final String QUANTITY_PRODUCT_TEXTBOX = "xpath=//a[@class='product-name' and text()='%s']//parent::td//following-sibling::td[@class='quantity']//input";
	public static final String PRODUCT_INFORMATION = "xpath=//a[text()='%s']//parent::td//div[@class='attributes']";
	public static final String SHOPPING_CART_MESSAGE_EMPTY = "xpath=//div[@class='no-data']";
	
	//Button
	public static final String ADD_TO_CART_BUTTON = "xpath=//div[@class='product-essential']//button[text()='Add to cart']";
	public static final String UPDATE_SHOPPING_CART_BUTTON = "xpath=//button[@id='updatecart']";
	public static final String EDIT_PRODUCT_BUTTON = "xpath=//a[@class='product-name' and text()='%s']//following-sibling::div[@class='edit-item']/a";
	public static final String REMOVE_PRODUCT_BUTTON = "xpath=//a[@class='product-name' and text()='%s']//parent::td//following-sibling::td[@class='remove-from-cart']";
	public static final String CHECKOUT_BUTTON = "id=checkout";
	
	//Checkbox
	public static final String TERM_OF_SERVICE_CHECKBOX = "xpath=//div[@class='terms-of-service']//input";
}
