package eclipTip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Debug {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		driver = new ChromeDriver();
	}

	@Test
	public void TC_01_Debug() {
		driver.get("https://www.facebook.com/");

		String headerText = driver.findElement(By.xpath("//img [@alt='Facebook']/parent::div/following-sibling::h2")).getText();
		System.out.println(headerText);
		Assert.assertEquals(headerText, "Facebook giúp bạn kết nối và chia sẻ với mọi người trong cuộc sống của bạn.");

		boolean loginSatatus = driver.findElement(By.name("login")).isDisplayed();
		Assert.assertTrue(loginSatatus);
	}
}
