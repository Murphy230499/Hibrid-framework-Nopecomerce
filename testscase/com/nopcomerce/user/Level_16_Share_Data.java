package com.nopcomerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcomerce.common.common_01_Register_End_User;

import PageObjects.Nopcomerce.User.UserCustomerInforPageObject;
import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserLoginPageObject;
import PageObjects.Nopcomerce.User.UserRegisterPageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_16_Share_Data extends BaseTest {

	private WebDriver driver;
	private String emailAdress;
	private String Password ;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		emailAdress = common_01_Register_End_User.emailAdress;
		Password =common_01_Register_End_User.Password;
		log.info("Login_Step 01: Navigate to login page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login_Step 02: Enter to email textbox");
		loginPage.inPutToEmailTextbox(emailAdress);

		log.info("Login_Step 03: enter to password textbox");
		loginPage.inPutToPasswordTextbox(Password);

		log.info("Login_Step 04: Click to login button");
		homePage = loginPage.clickLoginButton();

	}

	@Test
	public void Search_01() {
	}

	public void Search_02() {
	}

	public void Search_03() {
	}

	public void Search_04() {
	}

	public void Search_05() {
	}

	public void Search_06() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
