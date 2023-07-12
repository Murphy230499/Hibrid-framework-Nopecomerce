package PageObjects.Nopcomerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcomerce.User.UserCustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage {
	public WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	} 

	public boolean isMyAccountPageDisplay() {
		waitForElementVisible(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_PAGE_TITLE);
		return isElementDisplay(driver, UserCustomerInforPageUI.CUSTOMER_INFOR_PAGE_TITLE);
	}

}
