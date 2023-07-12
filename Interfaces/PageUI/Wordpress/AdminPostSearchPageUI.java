package PageUI.Wordpress;

public class AdminPostSearchPageUI { 
	public static final String ADD_NEW_BUTTON = "xpath=//a[@class='page-title-action']";
	public static final String SEARCH_TEXTBOX = "xpath=//input[@id='post-search-input']";
	public static final String SEARCH_BUTTON = "xpath=//input[@id='search-submit']";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "xpath=//table [contains(@class,'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_NAME = "xpath=//table [contains(@class,'table-view-list posts')]/tbody/tr/*[%s]//a[text()='%s']";
	public static final String ROW_CHECKBOX_BY_TITLE = "xpath=//table [contains(@class,'table-view-list posts')]/tbody/tr/th/label[contains(text(),'%s')]/following-sibling::input";
	public static final String ACTION_DROPDOWN = "xpath=//select[@name='action']";
	public static final String APPLY_ACTION_BUTTON = "xpath=//input[@class='button action' and @id= 'doaction']";
	public static final String MOVE_TO_TRASH_SUCCESS_MESSAGE = "xpath=//div[@id='message']/p[contains(text(),'%s')]";
	public static final String NO_POST_FOUND_MESSAGE = "xpath=//table/tbody//td[text()='%s']";
	public static final String ROW_TITLE_DETAIL_BY_TITLE_NAME = "xpath=//table/tbody//td//a[text()='%s']";

}
