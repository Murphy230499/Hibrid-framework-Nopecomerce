package commons;

import org.openqa.selenium.WebDriver;

import PageObject.Facebook.LoginPageObject;
import PageObject.Jquery.DataGrid.DataGridHomePageObject;
import PageObject.Jquery.UploadFile.UploadFileHomePageObject;
import PageObjects.Nopcomerce.Admin.AdminDashBoardPageObject;
import PageObjects.Nopcomerce.Admin.AdminLoginPageObject;
import PageObjects.Nopcomerce.User.UserAdressPageObject;
import PageObjects.Nopcomerce.User.UserCustomerInforPageObject;
import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserLoginPageObject;
import PageObjects.Nopcomerce.User.UserMyProductReviewPageObject;
import PageObjects.Nopcomerce.User.UserRegisterPageObject;
import PageObjects.Nopcomerce.User.UserRewardPointPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}

	public static UserAdressPageObject getUserAdressPage(WebDriver driver) {
		return new UserAdressPageObject(driver);
	}

	public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}

	public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);

	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashBoardPageObject getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardPageObject(driver);
	}
	
	public static DataGridHomePageObject getDataGridHomePage(WebDriver driver) {
		return new DataGridHomePageObject(driver);
	}

	public static UploadFileHomePageObject getUploadFileHomePage(WebDriver driver) {
		return new UploadFileHomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject (driver);
	}
	
}