package PageObjects.Nopcomerce.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcomerce.Admin.AdminDashBoardPageUI;

public class AdminDashBoardPageObject extends BasePage {

	private WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashBoardPageHeaderDisplay() {
		waitForElementVisible(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
		return isElementDisplay(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
		
	}
	}
