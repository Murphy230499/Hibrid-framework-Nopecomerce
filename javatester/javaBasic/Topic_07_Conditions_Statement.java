package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Conditions_Statement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	
public void beforeclass () {
	System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
	  driver = new FirefoxDriver();
}
		
		  
		  
	@Test
	public void TC_01_If() {
	}
		
	@Test 
	public void TC_02_If_Else () {
	// Cp toi 2 dieu kien: Neu nhu dung thi vao if - sai thif vao else
	
	// Neu nhu driver start voi browser nhu chorme/firefox/Edge/safari thi dung ham click
		
	// Thong thuong (Bbuiltin) cua selenium webElement
		
	// Neu driver laf IE Thi dung ham click cuar Javas
	}
	@Test 
	public void TC_03_If_Else_If_Else () {
	}
	
	
	@Test 
	public void TC_04_If_Else_If_Else () {
		//Page Object
		//Dynamic Page
		
	String pageName = "Login";
	
	if (pageName.equals("Login")) {
		// LoginPage loginPage = new LoginPage();
		//return loginPage;
	}
	
	else if (pageName.equals("Register")){
		// RegisterPage Register = new RegisterPage();
		//return RegisterPage;
		
	} else if (pageName.equals("New Customer")) {
		// CustomerPage customerPage = new CustomerPage();
		//return CustomerPage;
	}
	
	// Bieu thu tam nguyr
	
	int  age =20;
	
	String access = (age <18)? " you can not access" : "Welcome to system" ;
	
	if (age<18) {
		access = " you can not access";
	}
		else access = "Welcome to system";
}
}

