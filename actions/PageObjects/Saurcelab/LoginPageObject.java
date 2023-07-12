package PageObjects.Saurcelab;

import org.openqa.selenium.WebDriver;

import PageUI.Saurcelab.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextBox(String userName) {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		sendkeyToElemnt(driver, LoginPageUI.LOGIN_BUTTON, userName);
	}

	public void enterToPasswordTextBox(String Password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD);
		sendkeyToElemnt(driver, LoginPageUI.PASSWORD, Password);
		
	}

	public ProductPageObject clicktoLoginButton() {
		waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElemnt(driver,LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}
	}
