package javaOOP;

public class Topic_03_Method {
	void showCarName() {
		System.out.print("HuynhDai");

	}

	static void showCarColor() {
		System.out.print("White");
	}

	public static void main(String[] args) {
		
		// goi vao 1 ham static khac duoc
	
		showCarColor();// HAM STACTIC
		
		Topic_03_Method obj = new Topic_03_Method();
		obj.showCarName(); // Ham non - static muon goi phai thong qua object
		

	}
}
