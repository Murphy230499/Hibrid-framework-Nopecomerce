package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.Facebook.LoginPageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_13_Verify_Undisplayed extends BaseTest {
	private WebDriver driver;
	LoginPageObject loginPage;
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName,String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccoutnButton();
		verifyTrue(loginPage.isEmailAdressTextboxDisplayed());
	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		
		// TRUONG HOP NAY KHONG THE DUNG WAITFORELEMENTCLICKABLE VI:
		// NEU ROI VAO CASE VISABLE THI DUNG ( DUNG WAIT DUOC)
		// NHUNG NEU ROI VAO CASE INVISABLE THI NEU DUNG WAIT VAO THI WAIT KHONG CO SE BAO FAIL =>FAIL
		loginPage.enterToEmailAdressTextbox("automationFc@gmail.com");
		verifyTrue(loginPage.isConfirmEmailAdressTextboxDislayed());
		loginPage.sleepInSecond(3);
		loginPage.enterToEmailAdressTextbox("");
		loginPage.sleepInSecond(3);
		verifyFalse(loginPage.isConfirmEmailAdressTextboxDislayed());
		

	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickToSignUpCloseIcon();
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
