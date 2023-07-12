package PageUI.Wordpress;

public class UserPostDetailPageUI {
	public static final String POST_TITLE_TEXT = "xpath= //article/header/h1[text()='%s']";
	public static final String POST_CURRENT_DAY_BY_POST_TITLE = "xpath=//article/header/h1[text()='%s']/parent::header//time[text()='%s']";
	public static final String POST_BODY_BY_POST_TITLE= "xpath=//article/header/h1[text()='%s']/parent::header/following-sibling::div/p[text()='%s']";
	public static final String POST_AUTHOR_BY_POST_TITLE = "xpath=//article/header/h1[text()='%s']/parent::header//span/following-sibling::span//a[text()='%s']";

}
