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
import Utilities.DataHelper;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_20_FakeData2 extends BaseTest {

	@Parameters({"browser","firstName","lastName","emailAdress","Password"})
	@BeforeClass
	public void beforeClass(String browserName,String fistName, String lastName, String emailAdress, String Password) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		this.firstName = fistName;
		this.lastName = lastName;
		this.emailAdress = emailAdress + generateFakeNumber() + "@fakemail.com";
		this.Password = Password;
	}

	@Test
	public void User_01_Register() {

		
		log.info("Register_Step 01:Navigate to register Page");
		registerPage = 	homePage.clickRegisterLink();
		 
		
		log.info("Register_Step 02: Enter to fistName Textbox with values '"+ firstName+"'" );	
		registerPage.inputToFirstNameTextBox(firstName);
		
		log.info("Register_Step 03: Enter to LastName Textbox with values '"+ lastName+"'" );	
		registerPage.inputToLastNameTextBox(lastName);
		
		log.info("Register_Step 04: Enter to emailadress Textbox with values '"+ emailAdress+"'" );	
		registerPage.inputToEmailTextBox(emailAdress);
		
		log.info("Register_Step 05: Enter to password Textbox with values '"+ Password+"'" );	
		registerPage.inputToPasswordTextBox(Password);
		
		log.info("Register_Step 06: Enter to confirmPassword Textbox with values '"+ Password+"'" );	
		registerPage.inputToConfirmPasswordTextBox(Password);
		
		log.info("Register_Step 07: click to register Button" );	
		registerPage.clickToRegisterButton();
		
		log.info("Register_Step 08: verify register sucess Massage is displayed");	
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
		
		log.info("Register_Step 09: Click to logout link" );	
		homePage = registerPage.clickToLogOutLink();

		
	}
	
	@Test
	public void User_02_Login() {
		log.info("Login_Step 01: Navigate to login page" );	
		loginPage = homePage.clickToLoginLink();
		
		log.info("Login_Step 02: Enter to email textbox" );		
		loginPage.inPutToEmailTextbox(emailAdress);
		
		log.info("Login_Step 03: enter to password textbox" );	
		loginPage.inPutToPasswordTextbox(Password);
		
		log.info("Login_Step 04: Click to login button" );	
		homePage = loginPage.clickLoginButton();
		
		log.info("Login_Step 05: verify my account link display" );
		verifyFalse(homePage.isMyaccountLinkDisplayed());

		log.info("Login_Step 06: Navigate to customer infor page" );	
		customerInforPage = homePage.clickToMyAccountLink();
		
		log.info("Login_Step 07: verify my account page displayed" );		
		verifyFalse(customerInforPage.isMyAccountPageDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private WebDriver driver;
	private String firstName;
	private String lastName;
	private String emailAdress;
	private String Password;
}
