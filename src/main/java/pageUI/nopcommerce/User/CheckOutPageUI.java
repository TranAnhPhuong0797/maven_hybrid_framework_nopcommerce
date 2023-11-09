package pageUI.nopcommerce.User;

public class CheckOutPageUI {
	public static final String PAYMENT_INFORMATION = "xpath=//div[@class='info']//td";
	public static final String ORDER_INFORMATION_BILLING_ADDRESS_INFO = "xpath=//div[@class='order-review-data']//div[@class='billing-info-wrap']//div[@class='billing-info']//ul//li[@class='%s']";
	public static final String ORDER_INFORMATION_BILLING_ADDRESS_PAYMENT = "xpath=//div[@class='order-review-data']//div[@class='billing-info-wrap']//div[@class='payment-method-info']//ul//li[@class='%s']//span[@class='value']";
	public static final String ORDER_INFORMATION_SHIPPING_ADDRESS_INFO = "xpath=//div[@class='order-review-data']//div[@class='shipping-info-wrap']//div[@class='shipping-info']//ul//li[@class='%s']";
	public static final String ORDER_INFORMATION_SHIPPING_ADDRESS_METHOD = "xpath=//div[@class='order-review-data']//div[@class='shipping-info-wrap']//div[@class='shipping-method-info']//ul//li[@class='%s']//span[@class='value']";
	public static final String ORDER_INFORMATION_SHOPPING_CART = "xpath=";
	
	//Checkbox/Radio
	public static final String BILLING_SHIP_TO_THE_SAME_ADDRESS_CHECKBOX = "id=ShipToSameAddress";
	public static final String SHIPPING_METHOD_RADIO_BUTTON = "xpath=//ul[@class='method-list']//label[text()='%s']//preceding-sibling::input";
	public static final String PAYMENT_METHOD_RADIO_BUTTON = "xpath=//ul[@id='payment-method-block']//label[text()='%s']//preceding-sibling::input";
	
	//Dropdown List
	public static final String BILLING_COUNTRY_DROPDOWN_LIST = "id=BillingNewAddress_CountryId";
	public static final String BILLING_STATE_PROVINCE_DROPDOWN_LIST = "id=BillingNewAddress_StateProvinceId";
	public static final String BILLING_ADDRESS_DROPDOWN_LIST = "id=billing-address-select";
	public static final String SHIPPING_ADDRESS_DROPDOWN_LIST = "id=shipping-address-select";
	public static final String SHIPPING_COUNTRY_DROPDOWN_LIST = "id=ShippingNewAddress_CountryId";
	public static final String SHIPPING_STATE_PROVINCE_DROPDOWN_LIST = "id=ShippingNewAddress_StateProvinceId";
	
	//Textbox
	public static final String BILLING_FIRSTNAME_TEXTBOX = "id=BillingNewAddress_FirstName";
	public static final String BILLING_LASTNAME_TEXTBOX = "id=BillingNewAddress_LastName";
	public static final String BILLING_EMAIL_TEXTBOX = "id=BillingNewAddress_Email";
	public static final String BILLING_CITY_TEXTBOX = "id=BillingNewAddress_City";
	public static final String BILLING_ADDRESS1_TEXTBOX = "id=BillingNewAddress_Address1";
	public static final String BILLING_ZIP_CODE_TEXTBOX = "id=BillingNewAddress_ZipPostalCode";
	public static final String BILLING_PHONE_NUMBER_TEXTBOX = "id=BillingNewAddress_PhoneNumber";
	public static final String SHIPPING_CITY_TEXTBOX = "id=ShippingNewAddress_City";
	public static final String SHIPPING_ADDRESS1_TEXTBOX = "id=ShippingNewAddress_Address1";
	public static final String SHIPPNG_ZIP_CODE_TEXTBOX = "id=ShippingNewAddress_ZipPostalCode";
	public static final String SHIPPNG_PHONE_NUMBER_TEXTBOX = "id=ShippingNewAddress_PhoneNumber";
	
	//Button
	public static final String SHIPPING_COUNTINUE_BUTTON = "xpath=//div[@id='shipping-buttons-container']//button[@class='button-1 new-address-next-step-button']";
	public static final String SHIPPING_METHOD_COUNTINUE_BUTTON = "xpath=//div[@id='shipping-method-buttons-container']//button[@class='button-1 shipping-method-next-step-button']";
	public static final String PAYMENT_METHOD_COUNTINUE_BUTTON = "xpath=//div[@id='payment-method-buttons-container']//button[@class='button-1 payment-method-next-step-button']";
	public static final String PAYMENT_INFO_COUNTINUE_BUTTON = "xpath=//div[@id='payment-info-buttons-container']//button[@class='button-1 payment-info-next-step-button']";
	public static final String ORDER_INFORMATION_CONFIRM_BUTTON = "xpath=//div[@id='confirm-order-buttons-container']//button[@class='button-1 confirm-order-next-step-button']";
}
