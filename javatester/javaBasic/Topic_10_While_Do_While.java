package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

//Class
public class Topic_10_While_Do_While {
	public static void main(String[] args) {


		// Block code
		for (int i = 0; i < 5; i++) {
			System.out.println(i);

		}

		// While
		int i = 0;
		while (i < 5) {
			System.out.println("while" + i);
			i++;
			if (i == 3) {
				break;
			}

			// Do - while : chay it nhat 1 lan roi moi kieu tra dieu kien
			do {
				System.out.println("While" + i);
				i++;
			} while (i < 5);

		}
}
}