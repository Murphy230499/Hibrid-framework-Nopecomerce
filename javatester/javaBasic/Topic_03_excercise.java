package javaBasic;

import org.testng.annotations.Test;

public class Topic_03_excercise {
	
@Test 
public void TC_01() {
	int a = 6;
	int b=5;
	System.out.println("Tong = " + (a+b ));
	System.out.println("Hieu = " + (a-b ));
	System.out.println("Tich = " + (a*b ));	
	System.out.println("Thuong = " + (a/b ));
}
@Test 
public void TC_02() {
	float width = 7.5f;
	float height = 3.8f;
	System.out.println("S of rectangle =" + (width * height));
			
}
}