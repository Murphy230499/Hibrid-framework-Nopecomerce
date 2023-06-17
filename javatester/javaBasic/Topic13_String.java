package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic13_String {
	public static void main (String [] args) {
		
		String schoolName = "Automation Testing ";
		String courseName = "AUTOMATION TESTING";
		String schoolAddress = "Ho Chi Minh City";
		
		System.out.println("Do dai cua chuoi =" + schoolName.length());
		System.out.println("Lay ra 1 ki tu = " + schoolName.charAt(0));
		
		//tuyet doi
		System.out.println("Noi 2 chuoi " +  schoolName + schoolAddress);
		System.out.println("Kiem tra 2 chuoi bang nhau tuyet doi = " +  schoolName.equals(courseName));
		
		//Multi browser
		System.out.println("Kiem tra 2 chuoi bang nhau tuong doi = " +  schoolName.equalsIgnoreCase(courseName));
		
		
		// Startwith/endswith/contain
		System.out.println("Co bat dau 1 ki tu/ 1 chuoi ki tu = " + schoolName.startsWith("A"));
		System.out.println("Co bat dau 1 ki tu/ 1 chuoi ki tu = " + schoolName.startsWith("Automation"));
		System.out.println("Co bat dau 1 ki tu/ 1 chuoi ki tu = " + schoolName.startsWith("Testing"));
		
		
		System.out.println("Co chua 1 ki tu/ 1 chuoi ki tu = " + schoolName.contains("A"));
		System.out.println("Co chua 1 ki tu/ 1 chuoi ki tu = " + schoolName.contains("Automation"));
		System.out.println("Co chua 1 ki tu/ 1 chuoi ki tu = " + schoolName.contains("Testing"));
		
	
		System.out.println("Co ket thuc 1 ki tu/ 1 chuoi ki tu = " + schoolName.endsWith(" Testing"));
		System.out.println("Co ket thuc ki tu/ 1 chuoi ki tu = " + schoolName.endsWith("g"));
		System.out.println("Co ket thuc 1 ki tu/ 1 chuoi ki tu = " + schoolName.endsWith("A"));
		
		// lay vi tri index cua ki tu hoac 1 doan chuoi ki tu trong chuoi
		System.out.println("Vi tri cua 1 ki tu/ chuoi ki tu trong chuoi = " + schoolName.indexOf("utomaition"));
		System.out.println("Vi tri cua 1 ki tu/ chuoi ki tu trong chuoi = " + schoolName.indexOf(" Testing"));
		System.out.println("Vi tri cua 1 ki tu/ chuoi ki tu trong chuoi = " + schoolName.indexOf(" T"));
		
		
		// lay text / char tu 1 vi tri index nay den vi tri index khac
		System.out.println("Tach 1 ki tu/ chuoi ki tu trong chuoi = " + schoolName.substring(11));
		System.out.println("Tach 1 ki tu/ chuoi ki tu trong chuoi = " + schoolName.substring(11,15));
		System.out.println("Tach 1 ki tu/ chuoi ki tu trong chuoi = " + schoolName.substring(0,15));
		
		// split tach chuoi thanh 1 mang dua vao 1 kis tu -> sau do lay index de lay ki tu mong muon 
		String result = "Viewing 48 of 132 results";
		String results[]=result.split(" ");
		System.out.println(results[1]);
		
		// Replace 
		String productPrice = "$100.000";
		productPrice = productPrice.replace("$","");
		System.out.println(productPrice);
		
		// convert qua kieu so
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);
		
		// Convert qua kieu String
		productPrice = String.valueOf(productPriceF);
		
		// Loai bo ki tu trang
		String helloWorld = "      \n    \t    Hello World!";
		System.out.println(helloWorld.trim());
		
		// Empty/ blank
		helloWorld = " ";
		System.out.println("Empty = " + helloWorld.isEmpty());
		System.out.println("Empty = " + helloWorld.isBlank());
		
		
		//Dynamic Locator
		String DynamicButtonXpath = "//button[@id ='%S']";
		System.out.println("Click to login Button = " + DynamicButtonXpath.format(DynamicButtonXpath, "Login"));
		System.out.println("Click to login Button = " + DynamicButtonXpath.format(DynamicButtonXpath, "Register"));
		System.out.println("Click to login Button = " + DynamicButtonXpath.format(DynamicButtonXpath, "Search"));
	}
	
	}


