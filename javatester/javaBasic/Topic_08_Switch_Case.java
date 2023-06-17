package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_08_Switch_Case {
WebDriver driver;
String projectpath = System.clearProperty("user.fir");
Scanner scanner = new Scanner(System.in);

//@Parameters("browserName")
//@Test
public void TC_01_If_Else_IF_Else (String browserName) {
		
		switch (browserName) {
		case "chrome" :
			System.setProperty("webdriver.chrome.driver", projectpath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
			case "firefox" :
				System.setProperty("webdriver.gecko.driver", projectpath + "\\browserDrivers\\geckodriver.exe");
				driver = new ChromeDriver();
				break;
				
			case "edge" :
				System.setProperty("webdriver.edge.driver", projectpath + "\\browserDrivers\\msedgedriver.exe");
				driver = new ChromeDriver();
			break;
			
			case "ie" :
				System.setProperty("webdriver.ie.driver", projectpath + "\\browserDrivers\\IEdriverServer.exe");
				driver = new ChromeDriver();
			break;
			
			default :
				new RuntimeException("Please input correct the browser name !");
				break;
			 }
		
		
	}
	
	

//@Test
public void TC_02() {
	int month = scanner.nextInt();
	
	switch (month) {
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
		
		System.out.println();System.out.println(" Thang nay co 31 ngay ");		
		break;
		
	case 4:
	case 6:
	case 9:
	case 11:
		
		System.out.println(" Thang nay co 30 ngay ");
		break;
		
	case 2:
		System.out.println(" Thang nay co 28 ngay ");

	default:
		
		System.out.println(" thang nhap vao khong hop le");
		break;
	}
	
}


//@Test
public void TC_03() {
	int number = scanner.nextInt();
	
	switch (number) {
	case 1:
		System.out.println();System.out.println(" one ");		
		break;
	case 2:
		System.out.println();System.out.println(" two ");		
		break;
	case 3:
		System.out.println();System.out.println(" three ");		
		break;
	case 4:
		System.out.println();System.out.println(" four ");		
		break;
	case 5:
		System.out.println();System.out.println(" five ");		
		break;
	case 6:
		System.out.println();System.out.println(" six");		
		break;
	case 7:
		System.out.println();System.out.println(" seven ");		
		break;
	case 8:
		
		System.out.println();System.out.println(" eight ");		
		break;
	case 9:
		System.out.println();System.out.println("nine ");		
		break;
	case 10:
		
		System.out.println();System.out.println(" ten ");		
		break;
	
	default:
		
		System.out.println(" number khong hop le");
		break;
	}
}

}

