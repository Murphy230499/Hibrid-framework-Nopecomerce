package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Exercise {
	
@Test 
public void TC_01_SwapNumber() {
	int a=5;
	int b=6;
	
	a=a+b;
    b= a-b;
    a=a-b;
    System.out.println(a);
    System.out.println(b);
}}