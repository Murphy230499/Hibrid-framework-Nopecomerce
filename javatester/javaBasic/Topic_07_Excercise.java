package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_Excercise {
	Scanner scanner = new Scanner(System.in);
	
		//@Test
		public void TC_01() {
		
		int number = scanner.nextInt();
		
		if (number % 2 == 0) {
			System.out.println("number la so chan");
			
		} else System.out.println("number la so le");
		
}
		
		//@Test
		public void TC_02() {
		int numbera = scanner.nextInt();
		int numberb = scanner.nextInt();
		
		if (numbera > numberb) {
			System.out.println(numbera + "lon hon "+ numberb);
		}else  if (numbera == numberb) {
			System.out.println(numbera + " bang"+ numberb);	
		}else  if (numbera < numberb) {
			System.out.println(numbera + " nho hon "+ numberb);	
}
}
	
		//@Test
		public void TC_03() {
			
		String fiststudent = scanner.nextLine();
		String secondstudent = scanner.nextLine();
		
		
		if (fiststudent.equals(secondstudent)) {
			System.out.println("hai sinh vien trung ten nhau");
		}else System.out.println("hai sinh vien deo trung ten nhau");
		
		// khong dung voi text vi no khong doi chieu vung nho chi doi chieu value cua bien
		if (fiststudent == secondstudent) {
			System.out.println("hai sinh vien trung ten nhau");
		}else System.out.println("hai sinh vien deo trung ten nhau");
}
	
		
		//@Test
		public void TC_04() {
			int numbera = scanner.nextInt();
			int numberb = scanner.nextInt();
			int numberc = scanner.nextInt();
			
		if (numbera>numberb && numbera>numberc ) {
			System.out.println(numbera + " co gia tri lon nhat");
} 		else if (numbera<numberb && numberb>numberc ) {
			System.out.println(numberb + " co gia tri lon nhat");
}		else if (numbera<numberc && numberb<numberc )
			System.out.println(numberc + " co gia tri lon nhat");
}
		
		
		//@Test
		public void TC_05() {
			int numbera = scanner.nextInt();
			
			if (10<numbera && numbera<100) {
				System.out.println(numbera + " nam trong khoang ");
				
			} else {	System.out.println(numbera + " nam trong ngoai khoang ");

			}
		}
		
		
		//@Test
		public void TC_06() {
			float studentpoint = scanner.nextFloat();
			
			// 0<5 Diem D
			
			// 5<7.5 Diem C
			
			//7.5 < 8.5 Diem B
			
			// 8.5 < 10 Diem A
			
			
			if (8.5<studentpoint && studentpoint <10) {
				
				System.out.println(studentpoint + " Thuoc he so A ");
				
			} else if (7.5<studentpoint && studentpoint <8.5) {
				
				System.out.println(studentpoint + " Thuoc he so B ");

			}else if (5<studentpoint && studentpoint <7.5) {
				
				System.out.println(studentpoint + " Thuoc he so C ");

			}else if (0<studentpoint && studentpoint <5) {
				
				System.out.println(studentpoint + " Thuoc he so D ");

			}
}

		@Test
		public void TC_07() {
			int month = scanner.nextInt();
			
			if (month == 1 || month == 3 || month == 5 ||  month == 7 || month == 10 ||month == 12) {
				System.out.println(" Thang nay co 31 ngay ");
			} else if (month == 4 || month == 6 || month == 5 ||  month == 9|| month == 11) {
				System.out.println(" Thang nay co 30 ngay ");

			} else if (month == 2) {
				System.out.println(" Thang nay co 28 ngay ");

			}
		}
}