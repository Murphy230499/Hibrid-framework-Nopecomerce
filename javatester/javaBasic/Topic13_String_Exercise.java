package javaBasic;

import org.testng.annotations.Test;

public class Topic13_String_Exercise {
	String courseName = "Automation Testing Advance 1 2 3 ";

//@Test
	public void TC_01() {
		char courseNameArr[] = courseName.toCharArray();

		int countUpper = 0;
		int countLower = 0;
		int countNumber = 0;

		for (char charater : courseNameArr) {
			// Ki tu viet hoa
			if (charater <= 'Z' && charater >= 'A') {
				countUpper++;
			}

			// Ki tu viet thuong
			if (charater <= 'z' && charater >= 'a') {
				countLower++;
			}

			// Ki tu so
			if (charater <= '9' && charater >= '0') {
				countNumber++;

			}
		}

		System.out.println("Sum of upper case = " + countUpper);
		System.out.println("Sum of Lower case = " + countLower);
		System.out.println("Sum of Number case = " + countNumber);
	}

	//@Test
	public void TC_02() {

		char courseNameArr[] = courseName.toCharArray();
		int count = 0;
		for (char c : courseNameArr) {
			if (c == 'a') {
				count ++;
			}
		}
		System.out.println(count);
	}

	@Test
	public void TC_03(){
		char courseNameArr [] = courseName.toCharArray();
		
		for (int i = courseNameArr.length - 1;i>=0;i--) {
			System.out.println(courseNameArr[i]);
	
		}
}
}