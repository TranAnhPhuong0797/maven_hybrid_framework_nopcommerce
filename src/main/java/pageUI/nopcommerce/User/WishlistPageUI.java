package pageUI.nopcommerce.User;

public class WishlistPageUI {
	public static final String WISHLIST_SHARING_LINK = "xpath=//div[@class='share-info']/a";
	public static final String WISHLIST_PRODUCT_NAME = "xpath=//td[@class='product']//a[text()='%s']";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[@name='addtocartbutton']";
	public static final String TITLE_WISHLIST_PAGE = "xpath=//div[@class='page-title']/h1";
	public static final String PRODUCT_CHECKBOX = "xpath=//a[@class='product-name' and text()='%s']//parent::td//preceding-sibling::td[@class='add-to-cart']//input";
	
}
