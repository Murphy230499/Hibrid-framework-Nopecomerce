package com.nopcomerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.Nopcomerce.Admin.AdminDashBoardPageObject;
import PageObjects.Nopcomerce.Admin.AdminLoginPageObject;
import PageObjects.Nopcomerce.User.UserAdressPageObject;
import PageObjects.Nopcomerce.User.UserCustomerInforPageObject;
import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserLoginPageObject;
import PageObjects.Nopcomerce.User.UserMyProductReviewPageObject;
import PageObjects.Nopcomerce.User.UserRegisterPageObject;
import PageObjects.Nopcomerce.User.UserRewardPointPageObject;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;

public class Level_08_Switch_Role extends BaseTest {

	private WebDriver driver;
	private String userEmailAddress;
	private String userPassword;
	private String adminEmailAddress;
	private String adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashBoardPageObject adminDashBoardPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		userEmailAddress = "duc@es.com";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword ="admin";
	}

	@Test
	public void Role_01_User_To_Admin() {
		//Login as user Rolr
		userLoginPage= userHomePage.openLoginPage();
		userLoginPage.loginAsUser(userEmailAddress, userPassword);
		
		
		//HomePage -> customer Infor
		userCustomerInforPage = userHomePage.openMyAccountPage();
		
		// customer infor -> click  logout -> HomePage
		userCustomerInforPage.clickToLogoutLinkAtUserPage(driver);
		
		// User homePage -> LoginPage Admin
		userHomePage.opentUrl(driver,GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		// Login as admin role
		adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		adminDashBoardPage = PageGeneratorManager.getAdminDashBoardPage(driver);
		Assert.assertTrue(adminDashBoardPage.isDashBoardPageHeaderDisplay());
		
		// Dashboard -> click Logout -> ADmin login
		adminLoginPage = adminDashBoardPage.clickToLogoutLinkAtAdminPage(driver);
	}
	

	@Test
	public void Role_02_Admin_To_User() {
		
		//admin Login page -> open portal url -> userHomePage
		adminLoginPage.opentUrl(driver,GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		// user HomePage -> user Login Page
		userHomePage.openLoginPage();
		userLoginPage.loginAsUser(userEmailAddress, userPassword);
		userLoginPage.clickLoginButton();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
