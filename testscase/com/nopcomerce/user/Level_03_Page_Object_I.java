package com.nopcomerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserRegisterPageObject;
import commons.BasePage;

public class Level_03_Page_Object_I {

	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		homePage = new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Empty_Data() {

		System.out.println("Home page - Step 01: Click to registerlink");
		homePage.clickRegisterLink();

		System.out.println("Register Page - Step 02: Click to registerButton");
		registerPage.clickToRegisterButton();

		System.out.println("Register page - Step 03: verify error message");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {

		System.out.println("Register Page - Step 01: Click to registerlink");
		registerPage.clickRegisterLink();

		System.out.println("Register Page - Step 02: Input require fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox("1234@456#%*");
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);

		System.out.println("Register Page - Step 03: Click to registerButton");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04: verify error message");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {

		System.out.println("Register page - Step 01: Click to registerlink");
		registerPage.clickRegisterLink();

		System.out.println("Register page - Step 02: Input require fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);

		System.out.println("Register page - Step 03: Click to registerButton");
		registerPage.clickToRegisterButton();

		System.out.println("Register page - Step 04: verify success message isdisplay");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	

	}

	@Test
	public void TC_04_Existing_Email() {

		System.out.println("Register page - Step 01: Click to registerlink");
		registerPage.clickRegisterLink();

		System.out.println("Register page - Step 02: Input require fields");

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox("tony@gmail.com");
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);

		System.out.println("Register page - Step 03: Click to registerButton");
		registerPage.clickToRegisterButton();

		System.out.println("Register page - Step 04: verify exist email");
		Assert.assertEquals(registerPage.getErrorExitingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void TC_05_PassWord_Less_Than_6_Char() {
		System.out.println("Register page - Step 01: Click to registerlink");
		registerPage.clickRegisterLink();

		System.out.println("Register page - Step 02: Input require fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox("1234");
		registerPage.inputToConfirmPasswordTextBox("1234");

		System.out.println("Register page - Step 03: Click to registerButton");
		registerPage.clickToRegisterButton();

		System.out.println("Register page - Step 04: verify error password isdisplay");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(),"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Cofirm_Password() {
		System.out.println("register page - Step 01: Click to registerlink");
		registerPage.clickRegisterLink();

		System.out.println("register page - Step 02: Input require fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(emailAddress);

		System.out.println("register page - Step 03: Click to registerButton");
		registerPage.clickToRegisterButton();

		System.out.println("register page - Step 04: verify error Confirmpassword isdisplay");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(),	"The password and confirmation password do not match.");

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
