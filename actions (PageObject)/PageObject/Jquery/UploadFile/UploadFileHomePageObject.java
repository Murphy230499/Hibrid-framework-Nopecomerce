package PageObject.Jquery.UploadFile;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.Jquery.UploadFile.HomePageUI;
import commons.BasePage;

public class UploadFileHomePageObject extends BasePage{

	WebDriver driver;
	
	public UploadFileHomePageObject(WebDriver driver) {
		
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplay(driver, HomePageUI.FILE_NAME_LOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
		
	}

	
	public boolean isFileLinkUploadedByName(String fileNames) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileNames);
		return isElementDisplay(driver,HomePageUI.FILE_NAME_UPLOADED_LINK, fileNames);
	}
 
	public boolean isFileImageUploadedByName(String fileNames) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileNames);
		return isImageLoaded(driver,HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileNames);
	}

}
