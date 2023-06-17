package javaBasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

public class Topic_09_For_ForEach {

//@Test
public void TC_01_For() {
	// for (int i = 1; i <11;i++) {
		// System.out.println(i);
	//}
	// ve 1: bien tam dung de tang gia tri len sau moi lan duyet
	// dung de so sanh vs tong gia tri 
	// ve 2: so sanh vs tong 
	// ve 3: tang i len 1 don vi sau khi chay vao than vong for
	 
	 
	 //Array
	 String[] cityName = {"Ha Noi", "Da Namg", "Ho Chi Minh", "Can Tho"};
	 
	// Array/List/Set/Queue(index)
	 // Ket hop dieu kien: thoa man dieu kien moi dung lai
	  for (int i = 0; i < cityName.length; i++) {
		  System.out.println(cityName[i]);
		
		 // tim thay gia tri roi khong tim nua -> break
	 for (int n = 0; n < cityName.length; n++) {
			 
		 if(cityName[n].equals("Da Nang"));
		 
		 System.out.println("Do action");
		 
		 break;
	  }
		 
	// Dung de chay qua het gia tri
	
		 
		for ( String city : cityName) {
		
			 System.out.println(city);
			
				
		}

	}
}


@Test
public void TC_02_Foreach() {
	 String[] cityName = {"Ha Noi", "Da Namg", "Ho Chi Minh", "Can Tho"};
	 
	 //Java collection
	 // Class: ArrayList/LinkedList/Vector/..
	 // interface: List/Set/queue

	 List<String> cityAddress = new ArrayList<String>();
	 cityAddress.add("Hai phong");
	 cityAddress.add("Quang Tri");
	 cityAddress.add("Hue");
	 for (String city : cityName) {
		 cityAddress.add(city);
}
	 System.out.println(cityAddress.size());
	 
	 for (String cityadd : cityAddress) {
		 if(cityadd.equals("Quang Tri"))
		 System.out.println(cityadd);
		 
	}
}
}

