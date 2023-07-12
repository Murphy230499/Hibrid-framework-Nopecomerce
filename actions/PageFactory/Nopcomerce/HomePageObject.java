package PageFactory.Nopcomerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	// Page UI
	
@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
private WebElement registerLink;
@FindBy(xpath = "//a[@class='ico-login']")
private WebElement loginLink;
           
// Page Object/actions.
public void clickToRegisterLink() {
	waitForElementClickable(driver, registerLink);
	clickToElemnt(driver, registerLink);
}
public void clickToLoginLink() {
	waitForElementClickable(driver, loginLink);
	clickToElemnt(driver, loginLink);
}

@FindBy(xpath = "//a[@class='ico-register']")
private WebElement registeLink;
public void clickRegisterLink() {
	waitForElementClickable(driver, registeLink);
	clickToElemnt(driver, registeLink);
	
}
}
