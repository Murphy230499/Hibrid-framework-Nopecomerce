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

public class Level_12_Assert_Verify extends BaseTest {

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
		emailAdress = "" + generateFakeNumber() + "@gmail.com";
		Password = "123456";

	}

	@Test
	public void User_01_Register_Login() {

		registerPage = homePage.clickRegisterLink();
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAdress);
		registerPage.inputToPasswordTextBox(Password);
		registerPage.inputToConfirmPasswordTextBox(Password);
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
		homePage = registerPage.clickToLogOutLink();

		loginPage = homePage.clickToLoginLink();
		loginPage.inPutToEmailTextbox(emailAdress);
		loginPage.inPutToPasswordTextbox(Password);
		homePage= loginPage.clickLoginButton();
		verifyFalse(homePage.isMyaccountLinkDisplayed());

		customerInforPage = homePage.clickToMyAccountLink();
		verifyFalse(customerInforPage.isMyAccountPageDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
