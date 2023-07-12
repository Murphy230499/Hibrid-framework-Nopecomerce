package PageObject.wordpress;

import org.openqa.selenium.WebDriver;

import PageUI.Wordpress.AdminPostAddNewPageUI;
import commons.BasePage;

public class AdminAddNewPostPO extends BasePage {
	WebDriver driver;

	public AdminAddNewPostPO(WebDriver driver) {
		this.driver = driver;
	} 
 
	public void enterToAddNewPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX);
		sendkeyToElemnt(driver, AdminPostAddNewPageUI.POST_TITLE_TEXTBOX, postTitle);
	}

	public void enterToEditPostBody(String postBody) { 
		waitForElementClickable(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX_BEFOR_CLICK);
		clickToElemnt(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX_BEFOR_CLICK);
		clearValueInElementByDeleteKeyOnMac(driver,  AdminPostAddNewPageUI.POST_BODY_TEXTBOX_BEFOR_CLICK);
		sendkeyToElemnt(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX_BEFOR_CLICK, postBody);
	}
 
	public void enterToAddNewPostBody(String postBody) { 
		waitForElementClickable(driver, AdminPostAddNewPageUI.POST_BODY_BUTTON);
		clickToElemnt(driver, AdminPostAddNewPageUI.POST_BODY_BUTTON);
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX_BEFOR_CLICK);
		sendkeyToElemnt(driver, AdminPostAddNewPageUI.POST_BODY_TEXTBOX_BEFOR_CLICK, postBody);
	}
	
	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.AFTER_POST_PUBLISH_BUTTON);
		clickToElemnt(driver, AdminPostAddNewPageUI.AFTER_POST_PUBLISH_BUTTON);
	}

	public boolean isPostPublishOrPublicMassageDislayed(String message) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_PUBLISH_OR_UPDATED_MASSAGE,message);
		return isElementDisplay(driver, AdminPostAddNewPageUI.POST_PUBLISH_OR_UPDATED_MASSAGE,message);
	}

	public AdminPostSearchPO openSearchPostUrl(String searchPostUrl) { 
		opentUrl(driver, searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver); 
	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_POST_PUBLISH_BUTTON);
		clickToElemnt(driver, AdminPostAddNewPageUI.PRE_POST_PUBLISH_BUTTON);
		
	}

	public void clickToUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.POST_UPDATE_BUTTON);
		clickToElemnt(driver, AdminPostAddNewPageUI.POST_UPDATE_BUTTON);
		
	}
}
