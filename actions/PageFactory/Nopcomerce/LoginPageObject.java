package PageFactory.Nopcomerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.Nopcomerce.User.UserLoginPageUI;

public class LoginPageObject extends BasePageFactory{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}

	@FindBy(xpath="//input[@class='email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath ="//input[@class='password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath ="//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	
	@FindBy(xpath ="//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath ="//div[contains(@class,'message-error')]")
	private WebElement unsuccessfullErorrMessage;
	
    @FindBy(xpath ="//a[@class='ico-login']")
    private WebElement loginLink;
    
    @FindBy(xpath ="//a[@class='ico-account']")
    private WebElement myAccountLink;

    
    public void clickLoginButton() {
    	waitForElementClickable(driver, loginButton);
    	clickToElemnt(driver, loginButton);
    	
    }

    public String getErorrMessageAtEmailTextbox() {
    	waitForElementVisible(driver,emailErrorMessage);
    	return getElementText(driver, emailErrorMessage);
    	
    	
    }

    public void clickToLoginLink() {
    waitForElementClickable(driver,loginLink);
    clickToElemnt(driver, loginLink);
    	
    }



    public void inPutToEmailTextbox(String email) {
    	waitForElementVisible(driver, emailTextbox);
    	sendkeyToElemnt(driver,emailTextbox, email);
    }

    public String getUnsuccessFullErorrMessage() {
    	waitForElementVisible(driver,unsuccessfullErorrMessage);
    	return getElementText(driver,unsuccessfullErorrMessage);
    }


    public void inPutToPasswordTextbox(String Password) {
    	waitForElementVisible(driver,passwordTextbox);
    	sendkeyToElemnt(driver,passwordTextbox, Password);
    	
    }
}
//    public boolean isMyAccountDisplayed() {
//    		waitForElementVisible(driver,myAccountLink);
//    		
//    		return isEnable(driver,myAccountLink);
//    }
//    }


