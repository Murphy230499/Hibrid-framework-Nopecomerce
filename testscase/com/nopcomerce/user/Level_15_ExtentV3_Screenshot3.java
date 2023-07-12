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


import PageObjects.Nopcomerce.User.UserCustomerInforPageObject;
import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserLoginPageObject;
import PageObjects.Nopcomerce.User.UserRegisterPageObject;

import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_15_ExtentV3_Screenshot3 extends BaseTest {

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

		
		registerPage = 	homePage.clickRegisterLink();
		 
		
		
		registerPage.inputToFirstNameTextBox(firstName);
		
		
		registerPage.inputToLastNameTextBox(lastName);
		
		
		registerPage.inputToEmailTextBox(emailAdress);
		
		
		registerPage.inputToPasswordTextBox(Password);
		
		
		registerPage.inputToConfirmPasswordTextBox(Password);
		
		
		registerPage.clickToRegisterButton();
		
		
		assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		

		
	}
	
	@Test
	public void User_02_Login(Method method) {
	
		homePage = PageGeneratorManager.getUserHomePage(driver);
		

		loginPage = homePage.clickToLoginLink();
		
		
		loginPage.inPutToEmailTextbox(emailAdress);
		

		loginPage.inPutToPasswordTextbox(Password);
		
	
		homePage = loginPage.clickLoginButton();
		

		assertTrue(homePage.isMyaccountLinkDisplayed());

	
		customerInforPage = homePage.clickToMyAccountLink();
		
		
		assertFalse(customerInforPage.isMyAccountPageDisplay());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
