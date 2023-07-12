package PageObject.wordpress;

import org.openqa.selenium.WebDriver;

import PageUI.Wordpress.AdminPostAddNewPageUI;
import PageUI.Wordpress.AdminPostSearchPageUI;
import commons.BasePage;

	public class AdminPostSearchPO extends BasePage {
		WebDriver driver;

		public AdminPostSearchPO(WebDriver driver) {
			this.driver = driver;
}

		public AdminAddNewPostPO clickToPostAddNewButton() {
			waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
			clickToElemnt(driver,AdminPostSearchPageUI.ADD_NEW_BUTTON);
			return PageGeneratorManager.getAdminAddNewPage(driver) ;
		}

		public void enterToSearchTextbox(String postTitle) {
			waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
			sendkeyToElemnt(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, postTitle);
			
		}

		public void clickToSearchPostButton() { 
			waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
			clickToElemnt(driver,AdminPostSearchPageUI.SEARCH_BUTTON);
			
		}

		public boolean isPostSearchTableDisplayed(String headerID, String posTitle) {
			int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME,headerID)+1;
			waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_NAME,String.valueOf(headerIndex),posTitle);
			return isElementDisplay(driver,AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_NAME,String.valueOf(headerIndex),posTitle);
		}

		public AdminAddNewPostPO clickToPostTitle(String postTitle) {
			waitForElementClickable(driver, AdminPostSearchPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, postTitle);
			clickToElemnt(driver, AdminPostSearchPageUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, postTitle);
			return PageGeneratorManager.getAdminAddNewPage(driver);
		}

		public void selectPostCheckBoxButton(String title) {
			waitForElementClickable(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE, title);
			checkToDefaultCheckBoxorRadio(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE, title);
		}

		public void selectTextItemInDropdown(String dropdownItem) {
			waitForElementClickable(driver, AdminPostSearchPageUI.ACTION_DROPDOWN);
			selectedItemIndefaultDropdown(driver, AdminPostSearchPageUI.ACTION_DROPDOWN, dropdownItem);
		}

		public void clickToApplyButton() {
			waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_ACTION_BUTTON);
			clickToElemnt(driver, AdminPostSearchPageUI.APPLY_ACTION_BUTTON);
		}

		public boolean isMoveToTrashMessageDisplay(String message) {
			waitForAllElementVisible(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_SUCCESS_MESSAGE, message);
			return isElementDisplay(driver,AdminPostSearchPageUI.MOVE_TO_TRASH_SUCCESS_MESSAGE, message);
		}

		public boolean isNoPostFoundMessageDisplayed(String notFoundMassage) {
			waitForAllElementVisible(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, notFoundMassage);
			return isElementDisplay(driver,AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, notFoundMassage);
		}

		
}