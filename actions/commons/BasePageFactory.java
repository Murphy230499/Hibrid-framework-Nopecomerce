package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	private WebElement getWebElement(WebDriver driver, WebElement element) {
		return element;
	}

	private List<WebElement> getListWebElement(WebDriver driver, List<WebElement> elements) {
		return elements;
	}

	public void clickToElemnt(WebDriver driver,WebElement element) {
		element.click();
	}

	public void sendkeyToElemnt(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}

	public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		return element .getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	public boolean isElementDisplay(WebDriver driver,WebElement element) {
		return element.isDisplayed();

	}

	public void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitForElementInvisible(WebDriver driver, WebElement element) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
			explicitWait.until(ExpectedConditions.invisibilityOf(element));
		} catch (TimeoutException e) {
			// Handle the timeout exception by logging an error message
			String errorMessage = "Timed out waiting for element to become invisible";
			System.out.println(errorMessage);
			e.printStackTrace();
		}
	}

	public void waitForAllElementInvisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements (elements));
	}

	public void waitForElementClickable(WebDriver driver,  WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private long longTimeOut = 30;
}