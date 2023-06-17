package com.Jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.Jquery.DataGrid.DataGridHomePageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {

	private WebDriver driver;
	DataGridHomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getDataGridHomePage(driver);
	}
 
	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActive("10"));

		homePage.openPagingByPageNumber("1");
		Assert.assertTrue(homePage.isPageNumberActive("1"));

		homePage.openPagingByPageNumber("4");
		Assert.assertTrue(homePage.isPageNumberActive("4"));

		homePage.openPagingByPageNumber("5");
		Assert.assertTrue(homePage.isPageNumberActive("5"));

	}

	@Test
	public void Table_02_Enter_To_Header() {
		homePage.insertToHeaderTextboxByLabel("Country", "Argentina");
		homePage.insertToHeaderTextboxByLabel("Females", "338282");
		homePage.insertToHeaderTextboxByLabel("Males", "60681000");
		homePage.insertToHeaderTextboxByLabel("Total", "117427000");
	}

	@Test
	public void Table_03_Enter_To_Header() {
		homePage.getAllValuesOfAllRowsEachPage();

	}

	public void Table_04_Enter_To_Textbox_Any_Row() {
		homePage.clickToLoadDataButton();
		homePage.sleepInSecond(5);
		homePage.enterToTextboxAtRowNumberByCollumnName("Company","1","FPT");
		homePage.enterToTextboxAtRowNumberByCollumnName("Contact Person","1","MurPhy");
		homePage.enterToTextboxAtRowNumberByCollumnName("Order Placed","1","Danang");
		homePage.seletDropDownAtCollumnName("Country","1","Germany");
		homePage.checkToCheckboxAtRowNumberByCollumnName("NPO?","1");
		homePage.checkToCheckboxAtRowNumberByCollumnName("NPO?","2");
		homePage.checkToCheckboxAtRowNumberByCollumnName("NPO?","3");
		
		homePage.UncheckToCheckboxAtRowNumberByCollumnName("NPO?","1");
		homePage.UncheckToCheckboxAtRowNumberByCollumnName("NPO?","2");
		homePage.UncheckToCheckboxAtRowNumberByCollumnName("NPO?","3");
		
		homePage.clickToIconByRowNumber("1","Insert Row Above']");
		homePage.clickToIconByRowNumber("2","Insert Row Above']");
		homePage.clickToIconByRowNumber("3","Insert Row Above']");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
