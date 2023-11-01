package pageUI.nopcommerce.User;

public class ShopingCartPageUI {
	public static final String SHOPINGCART_PRODUCT_NAME = "xpath= //td[@class='product']//a[text()='%s']";
	public static final String SHOPINGCART_PRODUCT_PRICE = "xpath= //a[@class='product-name' and text()='%s']//parent::td//following-sibling::td[@class='subtotal']/span";
	public static final String EDIT_PRODUCT_BUTTON = "xpath=//a[@class='product-name' and text()='%s']//following-sibling::div[@class='edit-item']/a";
	public static final String PRODUCT_INFORMATION = "xpath=//a[text()='%s']//parent::td//div[@class='attributes']";
}
