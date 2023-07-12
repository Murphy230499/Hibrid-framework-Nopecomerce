package com.wordpress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.wordpress.AdminAddNewPostPO;
import PageObject.wordpress.AdminDashboardPO;
import PageObject.wordpress.AdminLoginPO;
import PageObject.wordpress.AdminPostSearchPO;
import PageObject.wordpress.UserHomePO;
import PageObject.wordpress.UserPostDetailPO;
import PageObject.wordpress.UserSearchPostPO;
import PageObjects.Nopcomerce.User.UserCustomerInforPageObject;
import PageObjects.Nopcomerce.User.UserHomePageObject;
import PageObjects.Nopcomerce.User.UserLoginPageObject;
import PageObjects.Nopcomerce.User.UserRegisterPageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;
 
public class Post_01_Create_Read_Update_Delete_Search_Post extends BaseTest {

	String adminUserName = "automationfc";
	String adminUserPassword = "automationfc"; 
	String searchPostUrl;
	public int randomNumber = generateFakeNumber();
	String postTitle = "automationfc Title" + randomNumber;
	String postBody = "automationfc Body" + randomNumber;
	String editPostTilte = "Edit automationfc Title" + randomNumber;
	String editPostBody = "Edit automationfc Body" + randomNumber;
	String authorName ="automationfc";
	String adminUrl,userUrl;
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String AdminUrl, String userUrl) {
		log.info("Precondition_step01 : open browser and admin url ");
		this.adminUrl =AdminUrl;
		this.userUrl =userUrl;
		driver = getBrowserDriver(browserName, AdminUrl);
		adminLoginPage = PageObject.wordpress.PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Precondition_step03 : Enter password to textbox with value" + adminUserName);
		adminLoginPage.enterToUserNameTextbox(adminUserName);

		log.info("Precondition_step03 : Enter password to textbox with value" + adminUserPassword);
		adminLoginPage.enterToPasswordTextbox(adminUserPassword);

		log.info("Precondition_step04 : Click to login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();

	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post_01 : Click to post menu link");
		adminPostSearchPage = adminDashboardPage.clickPostMenuLink();
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);
 
		log.info("Create_Post_02 : Click to  'addnew' button");
		adminAddNewPostPage = adminPostSearchPage.clickToPostAddNewButton();

		log.info("Create_Post_03 : Enter to post titile");
		adminAddNewPostPage.enterToAddNewPostTitle(postTitle);

		log.info("Create_Post_04 : Enter to post body");
		adminAddNewPostPage.enterToAddNewPostBody(postBody);
		
		log.info("Create_Post_05 : Click to 'publish' button");
		adminAddNewPostPage.clickToPrePublishButton();

		log.info("Create_Post_05 : Click to 'publish' button");
		adminAddNewPostPage.clickToPublishButton();

		log.info("Create_Post_06 : Verify 'Post published.' Massage is displayed");
		verifyTrue(adminAddNewPostPage.isPostPublishOrPublicMassageDislayed("Post published."));

	}

	@Test
	public void Post_02_Search_And_ViewPost() {
		log.info("Search_Post_01 : Open 'search post' Page");
		adminPostSearchPage = adminAddNewPostPage.openSearchPostUrl(searchPostUrl);
		
		log.info("Search_Post_02 : Enter to 'search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		

		log.info("Search_Post_03 : Click to 'search post' button");
		adminPostSearchPage.clickToSearchPostButton();
		
		log.info("Search_Post_04 : Verify search table contains' " + postTitle +"'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title",postTitle));
		
		 
		log.info("Search_Post_05 : Verify search table contains'  " + authorName +"'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author",authorName));
		
		
		log.info("Search_Post_06 : Open 'End user' site");
		userHomePage = adminPostSearchPage.opentEndUserSite(driver,this.userUrl);
		
		
		log.info("Search_Post_07 : Verify post infor displayed at homepage");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle,postBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithAuthorName(postTitle,authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithCurrentDate(postTitle,currentDay));
		
		log.info("Search_Post_08 : Clik to post title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);
		
		log.info("Search_Post_09 : Verify post infor displayed at post detail page");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postTitle,postBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithAuthorName(postTitle,authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithCurrentDate(postTitle,currentDay));
	}

	@Test
	public void Post_03_Edit_Post() { 
		
		log.info("Edit_Post_01 : Open 'Admin site'");
		adminDashboardPage=userPostDetailPage.OpenAdminSite(driver, this.adminUrl);
		
		log.info("Edit_Post_02 : Click to 'post' menu link");
		adminPostSearchPage = adminDashboardPage.clickPostMenuLink();
		
		log.info("Edit_Post_03 : Enter to 'search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		
		log.info("Edit_Post_04 : Click to 'search post' button");
		adminPostSearchPage.clickToSearchPostButton();
		
		log.info("Edit_Post_05 : Click to post title detail link and navigato edit post page");
		adminAddNewPostPage = adminPostSearchPage.clickToPostTitle(postTitle);
		
		log.info("Edit_Post_06 : Enter to post titile");
		adminAddNewPostPage.enterToAddNewPostTitle(editPostTilte);

		log.info("Edit_Post_07 : Enter to post body");
		adminAddNewPostPage.enterToEditPostBody(editPostBody);

		log.info("Edit_Post_08 : Click to 'update' button");
		adminAddNewPostPage.clickToUpdateButton();
		
		log.info("Edit_Post_09  : Verify 'Post updated.' Massage is displayed");
		verifyTrue(adminAddNewPostPage.isPostPublishOrPublicMassageDislayed("Post updated."));
		
		log.info("Edit_Post_10  : Open 'search post' Page");
		adminPostSearchPage = adminAddNewPostPage.openSearchPostUrl(searchPostUrl);
		
		log.info("Edit_Post_11  : Enter to 'search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTilte);
		

		log.info("Edit_Post_12  : Click to 'search post' button");
		adminPostSearchPage.clickToSearchPostButton();
		
		log.info("Edit_Post_13  : Verify search table contains' " + editPostTilte +"'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title",editPostTilte));
		
		 
		log.info("Edit_Post_14  : Verify search table contains'  " + authorName +"'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author",authorName));
		
		
		log.info("Edit_Post_15  : Open 'End user' site");
		userHomePage = adminPostSearchPage.opentEndUserSite(driver,this.userUrl);
		
		
		log.info("Edit_Post_16  : Verify post infor displayed at homepage");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(editPostTilte));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(editPostTilte,editPostBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithAuthorName(editPostTilte,authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithCurrentDate(editPostTilte,currentDay));
		
		log.info("Edit_Post_17 : Clik to post title");
		userPostDetailPage = userHomePage.clickToPostTitle(editPostTilte);
		
		log.info("Edit_Post_18  : Verify post infor displayed at post detail page");
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(editPostTilte));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(editPostTilte,editPostBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithAuthorName(editPostTilte,authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayedWithCurrentDate(editPostTilte,currentDay));
		 
	}

	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete_Post_01 : Open 'Admin site'");
		adminDashboardPage=userPostDetailPage.OpenAdminSite(driver, this.adminUrl);
		
		log.info("Delete_Post_02 : Click to 'post' menu link");
		adminPostSearchPage = adminDashboardPage.clickPostMenuLink();
		
		log.info("Delete_Post_03 : Enter to 'search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTilte);
		
		
		log.info("Delete_Post_04 : Click to 'search post' button");
		adminPostSearchPage.clickToSearchPostButton();
		
		log.info("Delete_Post_05 : Select post detail checkbox");
		adminPostSearchPage.selectPostCheckBoxButton(editPostTilte);
		

		log.info("Delete_Post_06 : Select 'Move To Trash' action in dropdown");
		adminPostSearchPage.selectTextItemInDropdown("Move to Trash");
		
		log.info("Delete_Post_07 : Click to 'Apply' button");
		adminPostSearchPage.clickToApplyButton();
		
		log.info("Delete_Post_08 : Verify '1 post moved to the Trash.' message is Displayed");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplay("1 post moved to the Trash."));
		
		log.info("Delete_Post_09  : Enter to 'search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTilte);
		

		log.info("Delete_Post_10  : Click to 'search post' button");
		adminPostSearchPage.clickToSearchPostButton();
		
		log.info("Delete_Post_11 : Verify 'No posts found.' message is Displayed");
		verifyTrue(adminPostSearchPage.isNoPostFoundMessageDisplayed("No posts found."));
		
		log.info("Delete_Post_12  : Open 'End user' site");
		userHomePage = adminPostSearchPage.opentEndUserSite(driver,this.userUrl);
		
		log.info("Delete_Post_13 : Verify 'postTitle' is Undisplayed");
		verifyTrue(userHomePage.isPostInforUndisplayedWithPostTitle(editPostTilte));
		
		log.info("Delete_Post_14 : Enter to search textbox");
		userHomePage.enterToSearchTextbox(editPostTilte);
		
		log.info("Delete_Post_15 : Click to search button");
		userSearchPostPage=userHomePage.clickToSearchButton();
		
		log.info("Delete_Post_16 : Verify 'No posts Found.' message is displayed");
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed("Nothing Found"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminAddNewPostPO adminAddNewPostPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
	UserSearchPostPO userSearchPostPage;
}
