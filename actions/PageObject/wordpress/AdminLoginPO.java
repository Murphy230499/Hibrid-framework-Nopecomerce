package PageObject.wordpress;

import org.openqa.selenium.WebDriver;

import PageUI.Wordpress.AdminLoginPageUI;
import commons.BasePage;

public class AdminLoginPO extends BasePage {
WebDriver driver;

public AdminLoginPO(WebDriver driver) {
	this.driver = driver;
}

public void enterToUserNameTextbox(String adminUserName) {
	waitForElementVisible(driver,AdminLoginPageUI.USERNAME_TEXTBOX);
	sendkeyToElemnt(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUserName);
	
}
 
public void enterToPasswordTextbox(String adminUserPassword) {
	waitForElementVisible(driver,AdminLoginPageUI.PASSWORD_TEXTBOX);
	sendkeyToElemnt(driver, AdminLoginPageUI.PASSWORD_TEXTBOX,adminUserPassword);
}

public AdminDashboardPO clickToLoginButton() { 
	waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
	clickToElemnt(driver, AdminLoginPageUI.LOGIN_BUTTON);
	return PageGeneratorManager.getAdminDashBoardPage(driver);
}


}
