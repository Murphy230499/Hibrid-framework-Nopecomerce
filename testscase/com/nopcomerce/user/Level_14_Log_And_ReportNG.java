package com.nopcomerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjects.Nopcomerce.User.UserCustomerInforPageObject;
import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserLoginPageObject;
import PageObjects.Nopcomerce.User.UserRegisterPageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_14_Log_And_ReportNG extends BaseTest {

	private WebDriver driver;
	private String firstName;
	private String lastName;
	private String emailAdress;
	private String Password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		emailAdress = "afc" + generateFakeNumber() + "@gmail.com";
		Password = "123456";
	}

	@Test
	public void User_01_Register() {

		
		log.info("Register_Step 01:Navigate to register Page");
		registerPage = 	homePage.clickRegisterLink();
		 
		
		log.info("Register_Step 02: Enter to fistName Textbox with values '"+ firstName+"'" );	
		registerPage.inputToFirstNameTextBox(firstName);
		
		log.info("Register_Step 03: Enter to LastName Textbox with values '"+ lastName+"'" );	
		registerPage.inputToLastNameTextBox(lastName);
		
		log.info("Register_Step 04: Enter to emailaddress Textbox with values '"+ emailAdress+"'" );	
		registerPage.inputToEmailTextBox(emailAdress);
		
		log.info("Register_Step 05: Enter to password Textbox with values '"+ Password+"'" );	
		registerPage.inputToPasswordTextBox(Password);
		
		log.info("Register_Step 06: Enter to confirmPassword Textbox with values '"+ Password+"'" );	
		registerPage.inputToConfirmPasswordTextBox(Password);
		
		log.info("Register_Step 07: click to register Button" );	
		registerPage.clickToRegisterButton();
		
		log.info("Register_Step 08: verify register success Massage is displayed");	
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		

		
	}
	
	@Test
	public void User_02_Login() {
		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Login_Step 01: Navigate to login page" );	
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login_Step 02: Enter to email textbox" );		
		loginPage.inPutToEmailTextbox(emailAdress);
		
		log.info("Login_Step 03: enter to password textbox" );	
		loginPage.inPutToPasswordTextbox(Password);
		
		log.info("Login_Step 04: Click to login button" );	
		homePage = loginPage.clickLoginButton();
		
		log.info("Login_Step 05: verify my account link display" );
		verifyTrue(homePage.isMyaccountLinkDisplayed());

		log.info("Login_Step 06: Navigate to customer infor page" );	
		customerInforPage = homePage.clickToMyAccountLink();
		
		log.info("Login_Step 07: verify my account page displayed" );		
		verifyTrue(customerInforPage.isMyAccountPageDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
