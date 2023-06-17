package com.Jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.Jquery.UploadFile.UploadFileHomePageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_11_Upload_File extends BaseTest{
	private WebDriver driver;
	String csharpFileName = "csharp.png";
	String javaFileName = "java.png";
	String pythonFileName = "python.png";  
	String rubyFileName = "ruby.png";
	String[] multipleFile = { csharpFileName,javaFileName,pythonFileName,rubyFileName};
	private UploadFileHomePageObject homePage;

	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver=getBrowserDriver(browserName, appUrl);
		homePage=PageGeneratorManager.getUploadFileHomePage(driver);
	}

	@Test
	public void upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, csharpFileName);

		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));

		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));
	}

	@Test
	public void upload_02_Multiple_File_Per_Time() {

		homePage.uploadMultipleFiles(driver, multipleFile);

		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(rubyFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(rubyFileName));

		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(rubyFileName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
