package PageObjects.Nopcomerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.Nopcomerce.User.UserCustomerInforPageUI;
import pageUIs.Nopcomerce.User.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	 WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	} 
	
	public UserRegisterPageObject clickRegisterLink() {
		waitForElementClickable(driver,UserHomePageUI.REGISTER_LINK );
 	clickToElemnt(driver,UserHomePageUI.REGISTER_LINK );
	return  PageGeneratorManager.getUserRegisterPage(driver);
	}


	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElemnt(driver,UserHomePageUI.LOGIN_LINK );
		return PageGeneratorManager.getUserLoginPage(driver);
		}

	public UserCustomerInforPageObject openMyAccountPage() {
		waitForElementClickable(driver,UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElemnt(driver,UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	public UserLoginPageObject openLoginPage() {
		opentUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElemnt(driver,UserHomePageUI.LOGIN_LINK);
				return PageGeneratorManager.getUserLoginPage(driver);
	}

	public UserCustomerInforPageObject clickToMyAccountLink() {
		waitForElementClickable(driver,UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElemnt(driver,UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	public void printlocator() {
		System.out.println(UserHomePageUI.REGISTER_LINK);
		
	}

	public boolean isMyaccountLinkDisplayed() {
		waitForElementInvisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver,UserHomePageUI.MY_ACCOUNT_LINK);
	}
 
}