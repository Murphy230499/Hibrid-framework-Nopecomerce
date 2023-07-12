package com.nopcomerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
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

public class common_01_Register_Cookie extends BaseTest {

	


	@Parameters("browser")
	@BeforeTest(description = "create new common user for all Class tesst")
	public void Register (String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		emailAdress = "afc" + generateFakeNumber() + "@gmail.com";
		Password = "123456";
	
		log.info("Precondtions 01:Navigate to register Page");
		registerPage = 	homePage.clickRegisterLink();
		 
		
		log.info("Precondtions 02: Enter to fistName Textbox with values '"+ firstName+"'" );	
		registerPage.inputToFirstNameTextBox(firstName);
		
		log.info("Precondtions 03: Enter to LastName Textbox with values '"+ lastName+"'" );	
		registerPage.inputToLastNameTextBox(lastName);
		
		log.info("Precondtions 04: Enter to emailaddress Textbox with values '"+ emailAdress+"'" );	
		registerPage.inputToEmailTextBox(emailAdress);
		
		log.info("Precondtions 05: Enter to password Textbox with values '"+ Password+"'" );	
		registerPage.inputToPasswordTextBox(Password);
		
		log.info("Precondtions 06: Enter to confirmPassword Textbox with values '"+ Password+"'" );	
		registerPage.inputToConfirmPasswordTextBox(Password);
		
		log.info("Precondtions 07: click to register Button" );	
		registerPage.clickToRegisterButton();
		
		log.info("Precondtions 08: verify register success Massage is displayed");	
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	
		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Precondtions 09: Navigate to login page" );	
		loginPage = homePage.clickToLoginLink();
		
		log.info("Precondtions 10: Enter to email textbox" );		
		loginPage.inPutToEmailTextbox(emailAdress);
		
		log.info("Precondtions 11: enter to password textbox" );	
		loginPage.inPutToPasswordTextbox(Password);
		
		log.info("Precondtions 12: Click to login button" );	
		homePage = loginPage.clickLoginButton();
		
		loggedcookies = homePage.getAllCookie(driver);
	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}
	private WebDriver driver;
	private String firstName;
	private String lastName;
	public static String emailAdress;
	public static String Password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	public static Set<Cookie> loggedcookies;

}
