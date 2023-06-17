package PageObject.Facebook;

import org.openqa.selenium.WebDriver;

import PageUI.Facebook.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccoutnButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUTN_BUTTON);
		clickToElemnt(driver, LoginPageUI.CREATE_NEW_ACCOUTN_BUTTON);

	}
	public boolean isEmailAdressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.SIGNUP_EMAIL_TEXTBOX);
		return isElementDisplay(driver, LoginPageUI.SIGNUP_EMAIL_TEXTBOX);
	}

	public void enterToEmailAdressTextbox(String valuesendkey) {
		waitForElementVisible(driver,LoginPageUI.SIGNUP_EMAIL_TEXTBOX);
		sendkeyToElemnt(driver, LoginPageUI.SIGNUP_EMAIL_TEXTBOX, valuesendkey);
		
	}

	public boolean isConfirmEmailAdressTextboxDislayed() {
		
		return isElementDisplay(driver, LoginPageUI.SIGNUP_CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickToSignUpCloseIcon() {
		waitForElementClickable(driver, LoginPageUI.SIGNUP_CLOSE_ICON);
		clickToElemnt(driver, LoginPageUI.SIGNUP_CLOSE_ICON);
	}

	public boolean isConfirmEmailTextboxUndisplayed() {
		waitForElementUndisplay(driver, LoginPageUI.SIGNUP_CONFIRM_EMAIL_TEXTBOX);
		return isElementUndisplay(driver, LoginPageUI.SIGNUP_CONFIRM_EMAIL_TEXTBOX);
	}

}
