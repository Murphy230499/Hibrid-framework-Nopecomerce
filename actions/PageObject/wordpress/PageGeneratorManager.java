package PageObject.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
	return new AdminLoginPO(driver);
}

public static AdminDashboardPO getAdminDashBoardPage(WebDriver driver) {
	return new AdminDashboardPO(driver);
}

public static AdminPostSearchPO getAdminPostSearchPage(WebDriver driver) {
	return new AdminPostSearchPO(driver);
}

public static AdminAddNewPostPO getAdminAddNewPage(WebDriver driver) {
	return new AdminAddNewPostPO(driver);
}

public static UserHomePO getUserHomepage(WebDriver driver) {
	return new UserHomePO(driver);
}


public static UserPostDetailPO getUserPostDetailPage(WebDriver driver) {
	return new UserPostDetailPO(driver);
}

public static UserSearchPostPO getUserSearchPostPage(WebDriver driver) {
	return new UserSearchPostPO(driver);
}
} 