package com.nopcomerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjects.Nopcomerce.User.UserCustomerInforPageObject;
import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserLoginPageObject;
import PageObjects.Nopcomerce.User.UserRegisterPageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class common_01_Register_End_User extends BaseTest {

	private WebDriver driver;
	private String firstName;
	private String lastName;
	public static String emailAdress;
	public static String Password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeTest(description = "create new common user for all Class tesst")
	public void Register (String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		emailAdress = "afc" + generateFakeNumber() + "@gmail.com";
		Password = "123456";
	
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

	@AfterTest
	public void afterClass() {
		driver.quit();
	}

}
