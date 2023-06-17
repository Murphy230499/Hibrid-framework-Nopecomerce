package javaOOP;

public class Topic_05_This_Super {
	private int firstNumber;
	private int secondNumber;

	public Topic_05_This_Super(int firstNumber, int secondNumber) {// dung this de lay bien global
		this.firstNumber = firstNumber; 
		this.secondNumber = secondNumber ;
	}
		
	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}
	

	public static void main (String [] args) {
	 Topic_05_This_Super Topic = new Topic_05_This_Super(5,17);
	 Topic.sumNumber();
	}

}
