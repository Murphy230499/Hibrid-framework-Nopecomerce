package PageFactory.Nopcomerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.Nopcomerce.User.UserRegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		// Init element => khoi tao driver khi chay vao cac ham
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath ="//input[@id='FirstName']")
	private WebElement firstNameTextbox;
	
	@FindBy(xpath ="//input[@id='LastName']")
	private WebElement lastNameTextbox;
	
	@FindBy(xpath ="//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(xpath ="//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath ="//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(xpath ="//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(xpath ="//span[@id='FirstName-error']")
	private WebElement firstNameErorrMessage;
	
	@FindBy(xpath ="span[@id='LastName-error']")
	private WebElement lastNameErorrMessage;
	
	@FindBy(xpath ="//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath ="//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	
	@FindBy(xpath ="//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy(xpath ="//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy(xpath ="//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath ="//div[contains(@class,'message-error')]")
	private WebElement existingEmailMessage;
	
	@FindBy(xpath ="//a[@class='ico-login']")
	private WebElement loginLink;
	
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElemnt(driver,registerButton);
		
	}

	public String getErrorMessageAtFirstNameTextBox() {
	waitForElementVisible(driver,firstNameErorrMessage);
		return getElementText(driver,firstNameErorrMessage);
	}

	public String getErrorMessageAtLastNameTextBox() {
		waitForElementVisible(driver,lastNameErorrMessage);
		return getElementText(driver, lastNameErorrMessage);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver,emailErrorMessage);
		return getElementText(driver,emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextBox() {
		waitForElementVisible(driver,passwordErrorMessage);
		return getElementText(driver,passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextBox() {
		waitForElementVisible(driver,confirmPasswordErrorMessage);
		return getElementText(driver,confirmPasswordErrorMessage);
	}

	public void inputToFirstNameTextBox(String firsName) {
		waitForElementVisible(driver,firstNameTextbox);
		sendkeyToElemnt(driver,firstNameTextbox, firsName);
		
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver,firstNameTextbox);
		sendkeyToElemnt(driver,firstNameTextbox, lastName);
		
	}

	public void inputToEmailTextBox(String emailAdrress) {
		waitForElementVisible(driver,emailTextbox);
		sendkeyToElemnt(driver,emailTextbox, emailAdrress);
		
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver,passwordTextbox);
		sendkeyToElemnt(driver,passwordTextbox, password);
		
	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver,confirmPasswordTextbox);
		sendkeyToElemnt(driver,confirmPasswordTextbox, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver,registerSuccessMessage);
		return getElementText(driver,registerSuccessMessage);

	}

	public void clickToLogOutLink() {
		waitForElementClickable(driver,registerLink);	
		clickToElemnt(driver,registerLink);
	}
	
	public String getErrorExitingEmailMessage() {
		waitForElementVisible(driver,existingEmailMessage);
		return getElementText(driver,existingEmailMessage);
	}

	public void clickRegisterLink() {
		waitForElementClickable(driver,registerLink);
		clickToElemnt(driver,registerLink);
		
	}
	
	public void clickToLoginLink() {
		waitForElementClickable(driver,loginLink);
		clickToElemnt(driver,loginLink);
		
	}
}
