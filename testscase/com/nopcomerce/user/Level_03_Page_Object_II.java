package com.nopcomerce.user;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserLoginPageObject;
import PageObjects.Nopcomerce.User.UserRegisterPageObject;
import commons.BasePage;

public class Level_03_Page_Object_II {

	private WebDriver driver;
	private String firstName;
	private String lastName;
	private String existingEmail;
	private String invalidEmail;
	private String notFoudEmail;
	private String validPassword;
	private String incorrectPassword;
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		homePage = new UserHomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		existingEmail = "" + generateFakeNumber() + "@gmail.com";
		invalidEmail = "Afc@134@123";
		notFoudEmail= "" + generateFakeNumber() + "@gmail.com";
		validPassword = "123456";
		incorrectPassword="654321";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		// Precondition
		homePage = new UserHomePageObject(driver);
		System.out.println("Precondition - Step 01: Click to registerlink");
		homePage.clickRegisterLink();
		System.out.println("Precondition - Step 02: Input require fields");
		registerPage = new UserRegisterPageObject(driver);
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(existingEmail);
		registerPage.inputToPasswordTextBox(validPassword);
		registerPage.inputToConfirmPasswordTextBox(validPassword);

		System.out.println("Precondition - Step 03: Click to registerButton");
		registerPage.clickToRegisterButton();
		registerPage.clickToLogOutLink();
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage = new UserHomePageObject(driver);
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
		loginPage.clickLoginButton();

		Assert.assertEquals(loginPage.getErorrMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.clickToLoginLink();
		loginPage.inPutToEmailTextbox(invalidEmail);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErorrMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		loginPage.clickToLoginLink();
		loginPage.inPutToEmailTextbox(notFoudEmail);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessFullErorrMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		loginPage.clickToLoginLink();
		loginPage.inPutToEmailTextbox(existingEmail);
		loginPage.inPutToPasswordTextbox("");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessFullErorrMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		loginPage.clickToLoginLink();
		loginPage.inPutToEmailTextbox(existingEmail);
		loginPage.inPutToPasswordTextbox(incorrectPassword);
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getUnsuccessFullErorrMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void Login_06_Valid_Email_Password() {
		loginPage.clickToLoginLink();
		loginPage.inPutToEmailTextbox(existingEmail);
		loginPage.inPutToPasswordTextbox(validPassword);
		loginPage.clickLoginButton();
	
	
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
