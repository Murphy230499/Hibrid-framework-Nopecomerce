package PageObject.wordpress;

import org.openqa.selenium.WebDriver;

import PageUI.Wordpress.AdminDashboardPageUI;
import commons.BasePage;


	public class AdminDashboardPO extends BasePage {
		WebDriver driver;

		public AdminDashboardPO(WebDriver driver) {
			this.driver = driver;
		}

		public AdminPostSearchPO clickPostMenuLink() {
			waitForElementClickable(driver, AdminDashboardPageUI.POST_MENU_LINK);
			clickToElemnt(driver,  AdminDashboardPageUI.POST_MENU_LINK);
			
			return PageGeneratorManager.getAdminPostSearchPage(driver);
		}
}
