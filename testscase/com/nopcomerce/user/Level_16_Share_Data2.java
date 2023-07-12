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

public class Level_16_Share_Data2 extends BaseTest {

	private WebDriver driver;
	private String firstName;
	private String lastName;
	private String emailAdress;
	private String Password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

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
	public void Precondtions() {

		
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
