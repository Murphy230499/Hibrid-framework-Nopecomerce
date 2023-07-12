package PageObjects.Nopcomerce.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.Nopcomerce.Admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
}
	public void inputToUserNameTextbox(String adminEmailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElemnt(driver, AdminLoginPageUI.EMAIL_TEXTBOX, adminEmailAddress);
	}
	
	public void inputToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElemnt(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}
	
	public AdminDashBoardPageObject clickToLoginButton () {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElemnt(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashBoardPage(driver);
	}
	
	public void loginAsAdmin (String adminEmailAddress , String adminPassword) {
		inputToUserNameTextbox(adminEmailAddress);
		inputToPasswordTextbox(adminPassword);
		clickToLoginButton();
	}
}