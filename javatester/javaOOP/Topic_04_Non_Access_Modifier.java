package javaOOP;

public class Topic_04_Non_Access_Modifier {

	// Static variable: pham vi toan bo system co the su dung no
	static String BROWSER = "Chrome";

	// Non-static variable: muon dung trong ham static phai thong qua 1 Object

	String serverName = "Developement";

	//Hang so ( final variable)
	final String colorCar = "Red";

	public static void main(String[] args) {
		System.out.println(BROWSER);

		Topic_04_Non_Access_Modifier obj = new Topic_04_Non_Access_Modifier();

		System.out.println(obj.serverName);
		obj.clickToElement("button");
		sendKeyToElement("Link");
		System.out.println(obj.colorCar);
	}

	// Non-static method: ham non-static phai thong qua 1 Object de su dung
	public void clickToElement(String element) {
		System.out.println(element);

	}

	// Static method : Ham static thi co the goi truc tiep ra de dung
	public static void sendKeyToElement(String element) {
		System.out.println(element);

	}
	
	public final void setCarName() { // final method khong cho class khac ke thua de ghi de/ override dung lai
		
	}
	
	
	// Note: doi voi final class thi khong cho ke thua nhung lai cho khoi tao nhu 1 object de dung ham trong no
	// Note: doi voi abstract class thi cho ke thua nhung khong cho khoi tao.
}
