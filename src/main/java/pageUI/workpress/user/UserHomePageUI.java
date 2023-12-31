package pageUI.workpress.user;

public class UserHomePageUI {
	public static final String POST_TITLE_TEXT = "xpath=//article//h2/a[text()='%s']";
	public static final String POST__CURRENT_DAY_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String POST_AUTHOR_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/parent::h2/following-sibling::div//span[@class='author vcard']/a[text()='%s']";
	public static final String POST_BODY_TEXT = "xpath=//article//a[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String BODY_SEARCH_TEXT = "xpath=//input[@class='wp-block-search__input']";
	public static final String BODY_SEARCH_BUTTON = "xpath=//button[contains(@class,'wp-block-search__button')]";
}
