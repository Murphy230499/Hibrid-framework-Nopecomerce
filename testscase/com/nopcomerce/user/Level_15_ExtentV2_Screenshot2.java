package com.nopcomerce.user;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import PageObjects.Nopcomerce.User.UserCustomerInforPageObject;
import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserLoginPageObject;
import PageObjects.Nopcomerce.User.UserRegisterPageObject;
//import ReportConfig.ExtentManager;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_15_ExtentV2_Screenshot2 extends BaseTest {

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
	public void User_01_Register(Method method) {

//		ExtentManager.startTest(method.getName(), "User_01: Register");
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 01:Navigate to register Page");
//		registerPage = 	homePage.clickRegisterLink();
//		 
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 02: Enter to fistName Textbox with values '"+ firstName+"'" );	
//		registerPage.inputToFirstNameTextBox(firstName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 03: Enter to LastName Textbox with values '"+ lastName+"'" );	
//		registerPage.inputToLastNameTextBox(lastName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 04: Enter to emailaddress Textbox with values '"+ emailAdress+"'" );	
//		registerPage.inputToEmailTextBox(emailAdress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 05: Enter to password Textbox with values '"+ Password+"'" );	
//		registerPage.inputToPasswordTextBox(Password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 06: Enter to confirmPassword Textbox with values '"+ Password+"'" );	
//		registerPage.inputToConfirmPasswordTextBox(Password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 07: click to register Button" );	
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Register_Step 08: verify register success Massage is displayed");	
//		assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
//		
//		ExtentManager.endTest();
		
	}
	
	@Test
	public void User_02_Login(Method method) {
//		
//		ExtentManager.startTest(method.getName(), "User_02: Login");
//		homePage = PageGeneratorManager.getUserHomePage(driver);
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Login_Step 01: Navigate to login page" );	
//		loginPage = homePage.clickToLoginLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Login_Step 02: Enter to email textbox" );		
//		loginPage.inPutToEmailTextbox(emailAdress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Login_Step 03: enter to password textbox" );	
//		loginPage.inPutToPasswordTextbox(Password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Login_Step 04: Click to login button" );	
//		homePage = loginPage.clickLoginButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Login_Step 05: verify my account link display" );
//		assertTrue(homePage.isMyaccountLinkDisplayed());
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Login_Step 06: Navigate to customer infor page" );	
//		customerInforPage = homePage.clickToMyAccountLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Login_Step 07: verify my account page displayed" );		
//		assertFalse(customerInforPage.isMyAccountPageDisplay());
//		
//		ExtentManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
