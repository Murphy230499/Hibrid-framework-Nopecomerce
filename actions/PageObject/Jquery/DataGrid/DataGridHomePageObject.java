package PageObject.Jquery.DataGrid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.Jquery.DataGrid.HomePageUI;
import commons.BasePage;

public class DataGridHomePageObject extends BasePage {
	WebDriver dirver;

	public DataGridHomePageObject(WebDriver driver) {
		this.dirver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(dirver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElemnt(dirver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}
 
	public void insertToHeaderTextboxByLabel(String headerTable, String valuesenkey) {
		waitForElementVisible(dirver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerTable);
		sendkeyToElemnt(dirver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, valuesenkey, headerTable);
		pressKeyToElement(dirver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerTable);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementVisible(dirver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplay(dirver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);

	}

	public List<String> getAllValuesOfAllRowsEachPage() {
		int totalPage = getElementSize(dirver, HomePageUI.TOTAL_PAGINATION);

		List<String> allRowValuesAllPage = new ArrayList<String>();

		// duyet qua cac page
		for (int index = 1; index <= totalPage; index++) {
			clickToElemnt(dirver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));
			sleepInSecond(1);

			// gettext cua all row cua moi page dua vao array list
			List<WebElement> allRowElementEachPage = getListWebElement(dirver, HomePageUI.ALL_ROW_EACH_PAGE);

			for (WebElement eachRow : allRowElementEachPage) {
				allRowValuesAllPage.add(eachRow.getText());

			}

		}
		// in tat ca gia tri row ra cua tat ca cac page
		for (String value : allRowValuesAllPage) {
			System.out.println("--------------------");
			System.out.println(value);

		}

		return allRowValuesAllPage;
	}

	public void enterToTextboxAtRowNumberByCollumnName(String collumnName, String rowIndex, String valuesendkey) {
		int indexcollumn = getElementSize(dirver, HomePageUI.INDEX_COLLUMN_BY_NAME, collumnName) + 1;
		waitForElementVisible(dirver, HomePageUI.TEXTBOX_BY_INDEX_ROW_AND_INDEX_COLLUMN, rowIndex,String.valueOf(indexcollumn));
		sendkeyToElemnt(dirver, HomePageUI.TEXTBOX_BY_INDEX_ROW_AND_INDEX_COLLUMN,valuesendkey ,rowIndex,String.valueOf(indexcollumn));
	}

	public void seletDropDownAtCollumnName(String collumnDropdownName, String rowIndex, String valueselect) {
		int indexcollumn = getElementSize(dirver, HomePageUI.INDEX_COLLUMN_BY_NAME, collumnDropdownName) + 1;
		waitForElementClickable(dirver, HomePageUI.DROPDOWN_BY_INDEX_ROW_AND_INDEX_COLLUMN, rowIndex,String.valueOf(indexcollumn));
		selectedItemIndefaultDropdown(dirver, HomePageUI.DROPDOWN_BY_INDEX_ROW_AND_INDEX_COLLUMN,valueselect ,rowIndex,String.valueOf(indexcollumn));
	}

	public void clickToLoadDataButton() {
	waitForElementClickable(dirver, HomePageUI.LOAD_DATA_BUTTON);
	clickToElemnt(dirver,  HomePageUI.LOAD_DATA_BUTTON);
	}
	
	public void checkToCheckboxAtRowNumberByCollumnName(String collumCheckboxName, String rowIndex ) {
		int indexcollumn = getElementSize(dirver, HomePageUI.INDEX_COLLUMN_BY_NAME, collumCheckboxName) + 1;
		waitForElementClickable(dirver, HomePageUI.DROPDOWN_BY_INDEX_ROW_AND_INDEX_COLLUMN, rowIndex,String.valueOf(indexcollumn));
		checkToDefaultCheckBoxorRadio(dirver, HomePageUI.DROPDOWN_BY_INDEX_ROW_AND_INDEX_COLLUMN,rowIndex,String.valueOf(indexcollumn));
	}

	public void UncheckToCheckboxAtRowNumberByCollumnName(String collumCheckboxName, String rowIndex ) {
		int indexcollumn = getElementSize(dirver, HomePageUI.INDEX_COLLUMN_BY_NAME, collumCheckboxName) + 1;
		waitForElementClickable(dirver, HomePageUI.DROPDOWN_BY_INDEX_ROW_AND_INDEX_COLLUMN, rowIndex,String.valueOf(indexcollumn));
		uncheckToCheckBox(dirver, HomePageUI.DROPDOWN_BY_INDEX_ROW_AND_INDEX_COLLUMN,rowIndex,String.valueOf(indexcollumn));
	}

	
	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(dirver, HomePageUI.ICON_AT_ROW_NUMBER,rowNumber, iconName);
		clickToElemnt(dirver,HomePageUI.ICON_AT_ROW_NUMBER,rowNumber, iconName);
		
	}

		

}