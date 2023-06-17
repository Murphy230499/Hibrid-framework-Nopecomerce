package com.nopcomerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	BasePage basePage;
	
@BeforeClass
public void beforeClass() {
	System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
	  driver = new FirefoxDriver();
	  basePage = new BasePage();
	  emailAddress = "" + generateFakeNumber() + "@gmail.com";
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
}

@Test
public void TC_01_Empty_Data() {
	  basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
	  basePage.clickToElemnt(driver, "//a[@class='ico-register']");
	  
	  basePage.waitForElementClickable(driver,"//button[@id='register-button']");
	  basePage.clickToElemnt(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
}

@Test
public void TC_02_Register_Invalid_Email(){
	  basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
	  basePage.clickToElemnt(driver, "//a[@class='ico-register']");
	  
	  basePage.sendkeyToElemnt(driver, "//input[@id='FirstName']","Automaiton" );
	  basePage.sendkeyToElemnt(driver, "//input[@id='LastName']","FC");
	  basePage.sendkeyToElemnt(driver, "//input[@id='Email']","1234@456#%*");
	  basePage.sendkeyToElemnt(driver, "//input[@id='Password']","123456" );
	  basePage.sendkeyToElemnt(driver, "//input[@id='ConfirmPassword']","123456");
	  
	  basePage.waitForElementClickable(driver,"//button[@id='register-button']");
	  basePage.clickToElemnt(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@class='field-validation-error']"),"Wrong email");
}

@Test
public void TC_03_Register_Success() {
	  basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
	  basePage.clickToElemnt(driver, "//a[@class='ico-register']");
	  
	  
	  basePage.sendkeyToElemnt(driver, "//input[@id='FirstName']","Automaiton");
	  basePage.sendkeyToElemnt(driver, "//input[@id='LastName']","FC");
	  basePage.sendkeyToElemnt(driver, "//input[@id='Email']",emailAddress);
	  basePage.sendkeyToElemnt(driver, "//input[@id='Password']","123456");
	  basePage.sendkeyToElemnt(driver, "//input[@id='ConfirmPassword']","123456");
	  
	  
	  
	  basePage.waitForElementClickable(driver,"//button[@id='register-button']");
	  basePage.clickToElemnt(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"),"Your registration completed");
	  
}

@Test
public void TC_04_Existing_Email() {
	  basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
	  basePage.clickToElemnt(driver, "//a[@class='ico-register']");
	  
	  basePage.sendkeyToElemnt(driver, "//input[@id='FirstName']","Automaiton");
	  basePage.sendkeyToElemnt(driver, "//input[@id='LastName']","FC");
	  basePage.sendkeyToElemnt(driver, "//input[@id='Email']","peter113@gmai.com");
	  basePage.sendkeyToElemnt(driver, "//input[@id='Password']","123456");
	  basePage.sendkeyToElemnt(driver, "//input[@id='ConfirmPassword']","123456");
	  
	  
	  
	  basePage.waitForElementClickable(driver,"//button[@id='register-button']");
	  basePage.clickToElemnt(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
	 
}

@Test
public void TC_05_PassWord_Less_Than_6_Char() {
	  basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
	  basePage.clickToElemnt(driver, "//a[@class='ico-register']");
	  
	  
	  basePage.sendkeyToElemnt(driver, "//input[@id='FirstName']","Automaiton");
	  basePage.sendkeyToElemnt(driver, "//input[@id='LastName']","FC" );
	  basePage.sendkeyToElemnt(driver, "//input[@id='Email']",emailAddress);
	  basePage.sendkeyToElemnt(driver, "//input[@id='Password']","1234");
	  basePage.sendkeyToElemnt(driver, "//input[@id='ConfirmPassword']","1234");
	  
	  
	  basePage.waitForElementClickable(driver,"//button[@id='register-button']");
	  basePage.clickToElemnt(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
}

@Test
public void TC_06_Register_Invalid_Cofirm_Password() {
	  basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
	  basePage.clickToElemnt(driver, "//a[@class='ico-register']");
	  
	  basePage.sendkeyToElemnt(driver, "//input[@id='FirstName']","Automaiton");
	  basePage.sendkeyToElemnt(driver, "//input[@id='LastName']","FC");
	  basePage.sendkeyToElemnt(driver, "//input[@id='Email']",emailAddress);
	  basePage.sendkeyToElemnt(driver, "//input[@id='Password']","123456");
	  basePage.sendkeyToElemnt(driver, "//input[@id='ConfirmPassword']","1234");
	  
	  basePage.waitForElementClickable(driver,"//button[@id='register-button']");
	  basePage.clickToElemnt(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
}

@AfterClass
public void afterClass() {
	driver.quit();
}

public int generateFakeNumber() {
	  Random  rand = new Random();
	return  rand.nextInt(9999);
}
}
