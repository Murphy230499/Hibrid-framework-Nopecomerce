package PageObjects.Nopcomerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.Nopcomerce.User.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;
	public UserRegisterPageObject (WebDriver driver) {
		this.driver = driver;
	}
	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElemnt(driver,UserRegisterPageUI.REGISTER_BUTTON);
		
	}

	public String getErrorMessageAtFirstNameTextBox() {
	waitForElementVisible(driver,UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver,UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextBox() {
		waitForElementVisible(driver,UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver,UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextBox() {
		waitForElementVisible(driver,UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(driver,UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextBox(String firsName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXT_BOX);
		sendkeyToElemnt(driver,UserRegisterPageUI.FIRST_NAME_TEXT_BOX, firsName);
		
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXT_BOX);
		sendkeyToElemnt(driver,UserRegisterPageUI.LAST_NAME_TEXT_BOX, lastName);
		
	}

	public void inputToEmailTextBox(String emailAdrress) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXT_BOX);
		sendkeyToElemnt(driver,UserRegisterPageUI.EMAIL_TEXT_BOX, emailAdrress);
		
	}

	public void inputToPasswordTextBox(String password) {
		waitForAllElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElemnt(driver,UserRegisterPageUI.PASSWORD_TEXT_BOX, password);
		
	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForAllElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
		sendkeyToElemnt(driver,UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForAllElementVisible(driver,UserRegisterPageUI.REGISTER_SUCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCESS_MESSAGE);

	}

	public UserHomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_LINK);	
		clickToElemnt(driver, UserRegisterPageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorExitingEmailMessage() {
		waitForAllElementVisible(driver,UserRegisterPageUI.EXITING_EMAIL_MESSSAGE);
		return getElementText(driver, UserRegisterPageUI.EXITING_EMAIL_MESSSAGE);
	}
	
		
	public UserRegisterPageObject clickRegisterLink() {
		waitForAllElementVisible(driver,UserRegisterPageUI.REGISTER_LINK);
		clickToElemnt(driver, UserRegisterPageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	public UserLoginPageObject clickToLoginLink() {
	waitForElementVisible(driver, UserRegisterPageUI.LOGIN_LINK);
	clickToElemnt(driver, UserRegisterPageUI.LOGIN_LINK);
	return PageGeneratorManager.getUserLoginPage(driver);
	}

}
