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

public class Level_09_Dynamic_Locator extends BaseTest { 

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

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		emailAdress = "" + generateFakeNumber() + "@gmail.com";
		Password = "123456";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void User_01_Register_Login() {
		registerPage=homePage.clickRegisterLink();
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAdress);
		registerPage.inputToPasswordTextBox(Password);
		registerPage.inputToConfirmPasswordTextBox(Password);
		registerPage.clickToRegisterButton();
		homePage = registerPage.clickToLogOutLink();

		loginPage = homePage.clickToLoginLink();
		loginPage.inPutToEmailTextbox(emailAdress);
		loginPage.inPutToPasswordTextbox(Password);
		loginPage.clickLoginButton();

		customerInforPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isMyAccountPageDisplay());
	}

	@Test
	public void User_02_Dynamic_Page() {
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

	}
	
	// dung khi so luong page it

	@Test
	public void User_03_Dynamic_Page_01() {

		// My product review-> Reward point
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openAtMyAccountByName(driver,
				"customer-info");

		// Reward Point -> Adress

		adressPage = (UserAdressPageObject) rewardPointPage.openAtMyAccountByName(driver, "customer-addresses");
		// Adress -> reward point

		rewardPointPage = (UserRewardPointPageObject) adressPage.openAtMyAccountByName(driver, "reward-points");

		// Reward Point -> My product review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openAtMyAccountByName(driver,
				"customer-reviews");

		// my product review -> customer infor
		customerInforPage = (UserCustomerInforPageObject) myProductReviewPage.openAtMyAccountByName(driver,
				"customer-info");
	}

	
	// dung khi so luong page nhieu
	@Test
	public void User_04_Dynamic_Page_02() {
		// customer infor -> my product review
		customerInforPage.openAtMyAccountByName(driver, "customer-reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		// My product review-> Reward point
		myProductReviewPage.openAtMyAccountByName(driver,"customer-info");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		// Reward Point -> Adress
		
		 rewardPointPage.openAtMyAccountByName(driver,"customer-addresses");
			adressPage = PageGeneratorManager.getUserAdressPage(driver);
			
		// Adress -> reward point
		
		adressPage.openAtMyAccountByName(driver, "reward-points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		// Reward Point -> My product review
		rewardPointPage.openAtMyAccountByName(driver, "customer-reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
				
		// my product review -> customer infor
		myProductReviewPage.openAtMyAccountByName(driver, "customer-info");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
