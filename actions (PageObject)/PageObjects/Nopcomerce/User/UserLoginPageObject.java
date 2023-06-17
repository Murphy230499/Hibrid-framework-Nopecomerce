package PageObjects.Nopcomerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.Nopcomerce.User.UserHomePageUI;
import pageUIs.Nopcomerce.User.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
private WebDriver driver;

public UserLoginPageObject(WebDriver driver) {
	this.driver = driver;
}

public UserHomePageObject clickLoginButton() {
	waitForElementClickable(driver, UserLoginPageUI.L0GIN_BUTTON);
	clickToElemnt(driver, UserLoginPageUI.L0GIN_BUTTON);
	return PageGeneratorManager.getUserHomePage(driver);
	
}

public String getErorrMessageAtEmailTextbox() {
	waitForElementVisible(driver,UserLoginPageUI.EMAIL_ERORR_MESSAGE);
	return getElementText(driver, UserLoginPageUI.EMAIL_ERORR_MESSAGE);
	
	
}

public void clickToLoginLink() {
waitForElementClickable(driver,UserLoginPageUI.LOGIN_LINK);
clickToElemnt(driver, UserLoginPageUI.LOGIN_LINK);
	
}

public void inPutToEmailTextbox(String email) {
	waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
	sendkeyToElemnt(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
}

public String getUnsuccessFullErorrMessage() {
	waitForElementVisible(driver,UserLoginPageUI.UNCUCCESSFULL_ERORR_MESSAGE);
	return getElementText(driver,UserLoginPageUI.UNCUCCESSFULL_ERORR_MESSAGE);
}


public void inPutToPasswordTextbox(String Password) {
	waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
	sendkeyToElemnt(driver, UserLoginPageUI.PASSWORD_TEXTBOX, Password);
	
}

public boolean isMyAccountDisplayed() {
		waitForElementVisible(driver,UserLoginPageUI.MY_ACCOUNT_LINK);
		
		return isEnable(driver,UserLoginPageUI.MY_ACCOUNT_LINK);
}

public void loginAsUser(String emailAddress, String password) {
	inPutToEmailTextbox(emailAddress);
	inPutToPasswordTextbox(password);
	clickLoginButton();
}

	
}

