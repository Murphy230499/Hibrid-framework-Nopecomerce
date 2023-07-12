package PageUI.Wordpress;

public class UserHomePageUI {
	public static final String POST_TITLE_TEXT = "xpath= //article/header/h2/a[text()='%s']";
	public static final String POST_CURRENT_DAY_BY_POST_TITLE = "xpath=//article/header/h2/a[text()='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_BY_POST_TITLE= "xpath=//article/header/h2/a[text()='%s']/parent::h2/parent::header/following-sibling::div/p[text()='%s']";
	public static final String POST_AUTHOR_BY_POST_TITLE = "xpath=//article/header/h2/a[text()='%s']/parent::h2/following-sibling::div/span[@class='byline']//a[text()='%s']";
	public static final String SEARCH_TEXTBOX = "xpath=//input[@type='search'and @id= 'wp-block-search__input-1']";
	public static final String SEARCH_BUTTON = "xpath=//button[text()='Search']";
}
