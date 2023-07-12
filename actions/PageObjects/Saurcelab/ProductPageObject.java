package PageObjects.Saurcelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.Saurcelab.ProductPageUI;
import commons.BasePage;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void seletItemInProductSortDropDown(String itemInDropdown) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectedItemIndefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, itemInDropdown);

	}

	public boolean isProductNameSortByAscending() {

		// Tao ra 1 mang
		ArrayList<String> productUIList = new ArrayList<String>();

		// tao ra 1 list de lay elemnt va gan vao cho cai mang tren
		List<WebElement> productNameList = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_LIST);
		for (WebElement productName : productNameList) {
			productUIList.add(productName.getText());
		}

		// copy ra 1 cai mang moi => de dung sort du lieu trong arraylist cu -> cua
		// Selenimum co bang voi sort cua dev hay khong
		ArrayList<String> productSortUIList = new ArrayList<String>();

		for (String product : productSortUIList) {
			productSortUIList.add(product);

			// Sort cai productSortList
			Collections.sort(productSortUIList);
		}
		return productSortUIList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		// Tao ra 1 mang
		ArrayList<String> productUIList = new ArrayList<String>();

		// tao ra 1 list de lay elemnt va gan vao cho cai mang tren
		List<WebElement> productNameList = getListWebElement(driver, null);
		for (WebElement productName : productNameList) {
			productUIList.add(productName.getText());
		}

		// copy ra 1 cai mang moi => de dung sort du lieu trong arraylist cu -> cua
		// Selenimum co bang voi sort cua dev hay khong
		ArrayList<String> productSortUIList = new ArrayList<String>();

		for (String product : productSortUIList) {
			productSortUIList.add(product);

			// Sort cai productSortList
			Collections.sort(productSortUIList);
			Collections.reverse(productSortUIList);
		}
		return productSortUIList.equals(productUIList);
	}


	public boolean isProductPriceSortByAscending() {
		ArrayList<Float> productUIList = new ArrayList<Float>();
		
		List <WebElement> priceList = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_LIST);
		
		for (WebElement price : priceList) {
			productUIList.add(Float.parseFloat(price.getText().replace("$","")));
		}
		
		ArrayList<Float> productSortList = new ArrayList<Float>();
		
		for (Float priceText : productUIList) {
			productSortList.add(priceText);
			
			Collections.sort(productSortList);
		}
		
		
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
	ArrayList<Float> productUIList = new ArrayList<Float>();
		
		List <WebElement> priceList = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_LIST);
		
		for (WebElement price : priceList) {
			productUIList.add(Float.parseFloat(price.getText().replace("$","")));
		}
		
		ArrayList<Float> productSortList = new ArrayList<Float>();
		
		for (Float priceText : productUIList) {
			productSortList.add(priceText);
			
			Collections.sort(productSortList);
			Collections.reverse(productSortList);
			
		}
		
		
		return productSortList.equals(productUIList);
	}

	public boolean isDataSortedAscLamDa(WebDriver driver) {
		List<WebElement> elementLists = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_LIST);
		List<String> names= elementLists.stream().map(n->n.getText()).collect(Collectors.toList());
		List<String> sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
		return names.equals(sortedNames);
	}
	
	public boolean isDataSortedDescLamDa(WebDriver driver) {
		List<WebElement> elementLists = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_LIST);
		List<String> names= elementLists.stream().map(n->n.getText()).collect(Collectors.toList());
		List<String> sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
		Collections.reverse(sortedNames);
		return names.equals(sortedNames);
	}
}

