package pageUIs.Nopcomerce.User;

public class BasePageNopcomerceUI {
	public static  String MY_PRODUCT_REVIEW_PAGE="xpath=//ul[@class ='list']/li[contains(@class,'customer-reviews')]";
	public static  String REWARD_POINT_PAGE ="xpath=//ul[@class ='list']/li[contains(@class,'reward-points')]";
	public static  String ADDRESS_PAGE = "xpath=//ul[@class ='list']/li[contains(@class,'customer-addresses')]";
	public static  String CUSTOMER_INFOR_PAGE = "xpath=//ul[@class ='list']/li[contains(@class,'customer-info')]";
	public static  String LOGOUT_LINK_ADMIN ="xpath=//a[text()='Logout']";
	public static  String LOGOUT_LINK_USER = "xpath=//a[@class = 'ico-logout']";
	
	public static String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//ul[@class ='list']/li[contains(@class,'%s')]";
	
//	public static void clickToElement(String dinamicLocator, String namePage) {
//		System.out.print (String.format(dinamicLocator, namePage));
//	}
}