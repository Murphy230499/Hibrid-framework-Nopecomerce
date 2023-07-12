package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.wordpress.AdminDashboardPO;
import PageObject.wordpress.UserHomePO;
import PageObjects.Nopcomerce.Admin.AdminLoginPageObject;
import PageObjects.Nopcomerce.User.UserAdressPageObject;
import PageObjects.Nopcomerce.User.UserCustomerInforPageObject;
import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserMyProductReviewPageObject;
import PageObjects.Nopcomerce.User.UserRewardPointPageObject;
import PageUI.Jquery.UploadFile.BasePageJqueryUI;
import PageUI.Jquery.UploadFile.HomePageUI;
import pageUIs.Nopcomerce.User.BasePageNopcomerceUI;

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();

	}

	private By getByLocator(String locatorType) {
		By by = null;
		// System.out.println("locatorType " + locatorType);
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
				|| locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
				|| locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
				|| locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator Type is not supported");
		}
		return by;
	}

	private String getDynamicXpath(String locatorType, String... dynamicValues) {
		if (locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath="))
			;
		{
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
			return locatorType;
		}
	}

	public void opentUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();

	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();

	}

	public void refreshCurrentPage(WebDriver driver) {

		driver.navigate().refresh();

	}

	public Set<Cookie> getAllCookie(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookie(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public Alert waitForAlertPresent(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresent(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresent(driver).dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresent(driver).getText();
	}

	public void senKeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresent(driver).sendKeys(textValue);
	}

	public void switchToWindowById(WebDriver driver, String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}

		}
	}

	public void switchToWindowByTitle(WebDriver driver, String tabTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String acctualTitel = driver.getTitle();
			if (acctualTitel.equals(tabTitle)) {
				break;
			}

		}
	}

	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();

		for (String id : allWindowIDs) {

			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public void clickToElemnt(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElemnt(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}

	public void sendkeyToElemnt(WebDriver driver, String locatorType, String textValue) {
		WebElement element = this.getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void clearValueInElementByDeleteKeyOnMac(WebDriver driver, String locatorType) {
		WebElement element = this.getWebElement(driver, locatorType);
		element.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
	}

	public void clearValueInElementByDeleteKeyOnWindown(WebDriver driver, String locatorType) {
		WebElement element = this.getWebElement(driver, locatorType);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
	}

	public void sendkeyToElemnt(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {

		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectedItemIndefaultDropdown(WebDriver driver, String locatorType, String textItem) {

		Select select = new Select(driver.findElement(getByLocator(locatorType)));
		select.selectByVisibleText(textItem);
	}

	public void selectedItemIndefaultDropdown(WebDriver driver, String locatorType, String textItem,
			String... dynamicValues) {
		Select select = new Select(driver.findElement(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
		select.selectByVisibleText(textItem);
	}

	public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(driver.findElement(getByLocator(locatorType)));
		return select.getFirstSelectedOption().getText();

	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(driver.findElement(By.xpath(locatorType)));
		return select.isMultiple();

	}

	public void selectItemIncustomDropdown(WebDriver driver, String parentLocator, String ChildLocator,
			String TextExpectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		List<WebElement> AllItem = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(ChildLocator)));
		for (WebElement Item : AllItem) {
			if (Item.getText().trim().equals(TextExpectedItem)) {
				JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;
				jsExcutor.executeAsyncScript("arguments[0].scrollIntoView(true);", Item);
				sleepInSecond(1);
				Item.click();
				break;
			}
		}
	}

	public void sleepInSecond(long timeinSecond) {
		try {
			Thread.sleep(timeinSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();

	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}

	public void checkToDefaultCheckBoxorRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckBoxorRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckBox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckBox(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplay(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();

	}

	public boolean isElementDisplay(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();

	}

	public boolean isElementUndisplay(WebDriver driver, String locatorType) {
		overrideTimeOut(driver, shortTimeOut);
		List<WebElement> elements = getListWebElement(driver, locatorType);
		overrideTimeOut(driver, longTimeOut);

		if (elements.size() == 0) {
			return true;

		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;

		} else {

			return false;
		}
	}

	public boolean isElementUndisplay(WebDriver driver, String locatorType, String... dynamicValues) {
		overrideTimeOut(driver, shortTimeOut);
		List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		overrideTimeOut(driver, longTimeOut);

		if (elements.size() == 0) {
			return true;

		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;

		} else {

			return false;
		}
	}

	public void overrideTimeOut(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isEnable(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();

	}

	public boolean isSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();

	}

	public void switchToFrame(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));

	}

	public void switchDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();

	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions
				.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		} catch (TimeoutException e) {
			// Handle the timeout exception by logging an error message
			String errorMessage = "Timed out waiting for element with XPath " + locatorType + " to become invisible";
			System.out.println(errorMessage);
			e.printStackTrace();
		}
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
			explicitWait.until(ExpectedConditions
					.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
		} catch (TimeoutException e) {
			// Handle the timeout exception by logging an error message
			String errorMessage = "Timed out waiting for element with XPath " + locatorType + " to become invisible";
			System.out.println(errorMessage);
			e.printStackTrace();
		}
	}

	/**
	 * wait for element undisplay in DOM or not In DOM and override implicit timeOut
	 */

	public void waitForElementUndisplay(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeOut);
		overrideTimeOut(driver, shortTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideTimeOut(driver, longTimeOut);
	}

	public void waitForAllElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}

	public void waitForAllElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions
				.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(
				ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		// Duong dan cua thu muc uploadFiles: windown/mac/linux
		String filePath = GlobalConstants.UPLOAD_FILE_FOLDER;

		// Duong dan cua tat ca cac file

		String fullFileName = "";

		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}

		fullFileName = fullFileName.trim();

		getWebElement(driver, BasePageJqueryUI.UPLOAD_FILE).sendKeys(fullFileName);
	}

	public String getDirectorySlash(String folderName) {
		String separator = System.getProperty("file.separator");
		return separator + folderName + separator;
	}

	// Toi uu o bai Level_07_Switch page
	public UserAdressPageObject openAdressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopcomerceUI.ADDRESS_PAGE);
		clickToElemnt(driver, BasePageNopcomerceUI.ADDRESS_PAGE);
		return PageGeneratorManager.getUserAdressPage(driver);
	}

	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopcomerceUI.MY_PRODUCT_REVIEW_PAGE);
		clickToElemnt(driver, BasePageNopcomerceUI.MY_PRODUCT_REVIEW_PAGE);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopcomerceUI.REWARD_POINT_PAGE);
		clickToElemnt(driver, BasePageNopcomerceUI.REWARD_POINT_PAGE);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}

	public UserCustomerInforPageObject openCustomerPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopcomerceUI.CUSTOMER_INFOR_PAGE);
		clickToElemnt(driver, BasePageNopcomerceUI.CUSTOMER_INFOR_PAGE);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	// Toi uu level_09_Dynamic_Page (Parten Object)
	public BasePage openAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageNopcomerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElemnt(driver, BasePageNopcomerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);

		switch (pageName) {
		case "customer-info":
			PageGeneratorManager.getUserCustomerInforPage(driver);
		case "reward-points":
			PageGeneratorManager.getUserRewardPointPage(driver);

		case "customer-addresses":
			PageGeneratorManager.getUserAdressPage(driver);

		case "customer-reviews":
			PageGeneratorManager.getUserMyProductReviewPage(driver);

		default:
			throw new RuntimeException("Invalid page name at My Account area.");
		}
	}

	public void inputToTexboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementInvisible(driver, BasePageNopcomerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElemnt(driver, BasePageNopcomerceUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);

	}

	public void clickToButtonByText(WebDriver driver, String textButton) {
		waitForElementClickable(driver, BasePageNopcomerceUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		clickToElemnt(driver, BasePageNopcomerceUI.DYNAMIC_BUTTON_BY_TEXT, textButton);

	}

	// Level_08_Switch role
public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopcomerceUI.LOGOUT_LINK_USER);
		clickToElemnt(driver, BasePageNopcomerceUI.LOGOUT_LINK_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopcomerceUI.LOGOUT_LINK_ADMIN);
		clickToElemnt(driver, BasePageNopcomerceUI.LOGOUT_LINK_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);

	}

	public UserHomePO opentEndUserSite(WebDriver driver, String userUrl) {
		opentUrl(driver, userUrl);
		return PageObject.wordpress.PageGeneratorManager.getUserHomepage(driver);
	}

	public AdminDashboardPO OpenAdminSite(WebDriver driver, String adminUrl) {
		opentUrl(driver, adminUrl);
		return PageObject.wordpress.PageGeneratorManager.getAdminDashBoardPage(driver);

	}

	private long longTimeOut = GlobalConstants.LONG_TIMEOUT;

	private long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;
}
