package javaOOP;

public class Topic_07_Overloading {

	private int firstNumber;
	private int secondNumber;

	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);

	}

	public void sumNumber(int fistNumber, int sencondNumber) {
		System.out.println(firstNumber + secondNumber);

	}
	
	public void sumNumber(float firstNumber, float sencondNumber) {
		System.out.println(firstNumber + secondNumber);

	}
	public static void main(String[] args) {

	}
}

//Note: overloading duoc goi la chong ham
// overloading duoc goi la tinh da hinh , tuc la ten cac method co the trung nhau/ trung ham
// nhung khac nhau ve tham so truyen vao vi du nhu data type hoac do dai cua tham so
// pham vi chi trong 1 class