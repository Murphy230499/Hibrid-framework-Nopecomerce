package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_10_Excercise {

	static Scanner scanner = new Scanner(System.in);

	// Function
	public static void main(String[] args) {
		TC_02_While();
	}

	@Test
	public static void TC_01_For() {

		int number = scanner.nextInt();

		for (int i = number; i < 100; i++) {

			if (i % 2 == 0) {
				System.out.println(i);

			}
		}
	}

	//@Test
	public static void TC_02_While() {

		int number = scanner.nextInt();

		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);
			}
			number++;

		}
	}
}

