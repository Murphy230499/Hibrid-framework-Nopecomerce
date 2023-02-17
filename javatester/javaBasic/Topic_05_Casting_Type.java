package javaBasic;

public class Topic_05_Casting_Type {
	public static void main (String [] args) {
		// Ngam dinh khong mat du lieu
		
//		byte bNumber = 126;
//		System.out.println(bNumber);
//		
//		short sNumber= bNumber;
//		System.out.println(sNumber);
//		
//		int iNumber = sNumber;
//		System.out.println(iNumber);
//		
//		long lNumber = iNumber;
//		System.out.println(lNumber);
//		
//		float fNumber = lNumber;
//		System.out.println(fNumber);
//		
//		double dNumber = fNumber;
//		System.out.println(dNumber);
		
	
		//Tuong minh mat du lieu
		
		double dNumber = 654321;
		System.out.println(dNumber);
		
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		
		long lNumber = (long) fNumber;
		System.out.println(lNumber);
		
		int iNumber = (int) lNumber;
		System.out.println(iNumber);
		
		short sNumber = (short) iNumber;
		System.out.println(sNumber);
		
		byte bNumber= (byte) sNumber;
		System.out.println(bNumber);
	}
	
	

}
