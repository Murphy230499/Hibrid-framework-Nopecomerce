package PageObject.wordpress;

import org.openqa.selenium.WebDriver;

import PageUI.Wordpress.UserHomePageUI;
import PageUI.Wordpress.UserPostDetailPageUI;
import commons.BasePage;

public class UserHomePO extends BasePage {
	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}


	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver,UserHomePageUI.POST_TITLE_TEXT,postTitle);
		return isElementDisplay(driver, UserHomePageUI.POST_TITLE_TEXT,postTitle);
	}


	public boolean isPostInforDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver,UserHomePageUI.POST_BODY_BY_POST_TITLE,postTitle,postBody);
		return isElementDisplay(driver, UserHomePageUI.POST_BODY_BY_POST_TITLE,postTitle,postBody);
	}


	public boolean isPostInforDisplayedWithAuthorName(String postTitle, String authorName) {
		waitForElementVisible(driver,UserHomePageUI.POST_AUTHOR_BY_POST_TITLE,postTitle,authorName);
		return isElementDisplay(driver, UserHomePageUI.POST_AUTHOR_BY_POST_TITLE,postTitle,authorName);
	}


	public boolean isPostInforDisplayedWithCurrentDate(String postTitle, String currentDay) {
		waitForElementVisible(driver,UserHomePageUI.POST_CURRENT_DAY_BY_POST_TITLE,postTitle,currentDay);
		return isElementDisplay(driver, UserHomePageUI.POST_CURRENT_DAY_BY_POST_TITLE,postTitle,currentDay);
	}

	public UserPostDetailPO clickToPostTitle(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT,postTitle);
		clickToElemnt(driver, UserHomePageUI.POST_TITLE_TEXT,postTitle);
		return PageGeneratorManager.getUserPostDetailPage(driver); 
	}


	public boolean isPostInforUndisplayedWithPostTitle(String editPostTilte) {
		return isElementUndisplay(driver,UserHomePageUI.POST_TITLE_TEXT, editPostTilte);
	}


	public void enterToSearchTextbox(String editPostTilte) {
		waitForElementInvisible(driver, UserHomePageUI.SEARCH_TEXTBOX);
		sendkeyToElemnt(driver, UserHomePageUI.SEARCH_TEXTBOX, editPostTilte);
	}


	public UserSearchPostPO clickToSearchButton() {
		waitForElementInvisible(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElemnt(driver,UserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchPostPage(driver);
	}
	}

