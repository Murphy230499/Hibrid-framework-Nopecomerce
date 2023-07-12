package com.saurcelab;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.Saurcelab.LoginPageObject;
import PageObjects.Saurcelab.PageGeneratorManager;
import PageObjects.Saurcelab.ProductPageObject;
import commons.BaseTest;

public class level_19_Sort_Asc_Desc extends BaseTest {
	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToUserNameTextBox(userName);
		loginPage.enterToPasswordTextBox(password);
		productPage = loginPage.clicktoLoginButton();

	}

	@Test
	public void Sort_01_Name() {
		// Asceding
		productPage.seletItemInProductSortDropDown("Name (Z to A)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductNameSortByAscending());
		
		// Decesding
		productPage.seletItemInProductSortDropDown("Name (A to Z)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductNameSortByDescending());
	}

	@Test
	public void Sort_02_Price() {
		
		// Asceding
		productPage.seletItemInProductSortDropDown("Price (low to high)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductPriceSortByAscending());
		

		// Decesding
		productPage.seletItemInProductSortDropDown("Price (high to low)");
		productPage.sleepInSecond(3);
		Assert.assertTrue(productPage.isProductPriceSortByDescending());
	}
	


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	String userName = "standard_user";
	String password = "secret_sauce";
	LoginPageObject loginPage;
	ProductPageObject productPage;
}
