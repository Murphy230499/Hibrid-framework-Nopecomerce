package com.nopcomerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.Nopcomerce.User.UserAdressPageObject;
import PageObjects.Nopcomerce.User.UserCustomerInforPageObject;
import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserLoginPageObject;
import PageObjects.Nopcomerce.User.UserMyProductReviewPageObject;
import PageObjects.Nopcomerce.User.UserRegisterPageObject;
import PageObjects.Nopcomerce.User.UserRewardPointPageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_07_Switch_Page extends BaseTest {

	private WebDriver driver;
	private String firstName;
	private String lastName;
	private String emailAdress;
	private String Password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAdressPageObject adressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage; 

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		emailAdress = "" + generateFakeNumber() + "@gmail.com";
		Password = "123456";

	}

	@Test
	public void User_01_Register() {
		homePage = PageGeneratorManager.getUserHomePage(driver);
		homePage.clickRegisterLink();
		registerPage = PageGeneratorManager.getUserRegisterPage(driver);
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAdress);
		registerPage.inputToPasswordTextBox(Password);
		registerPage.inputToConfirmPasswordTextBox(Password);
		registerPage.clickToRegisterButton();
		homePage = registerPage.clickToLogOutLink();

	}
 
	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inPutToEmailTextbox(emailAdress);
		loginPage.inPutToPasswordTextbox(Password);
		loginPage.clickLoginButton();
	}

	@Test
	public void User_03_MyAccount() {
		customerInforPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isMyAccountPageDisplay());
	}

	@Test
	public void User_04_Switch_Page() {
		// customer infor-> Adress
		adressPage = customerInforPage.openAdressPage(driver);
		
		// Adress -> My product review
		myProductReviewPage = adressPage.openMyProductReviewPage(driver);
		// My product review-> Reward point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		// Reward Point -> Adress
		
		adressPage = rewardPointPage.openAdressPage(driver);
		// Adress -> reward point
		
		rewardPointPage = adressPage.openRewardPointPage(driver);
		
		// Reward Point -> My product review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		
		// my product review -> customer infor
		customerInforPage = myProductReviewPage.openCustomerPage(driver);
	}

	@Test
	public void User_05_Switch_Role() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
