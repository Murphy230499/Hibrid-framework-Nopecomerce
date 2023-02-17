package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Operator {
	
public static void  main (String[] args) {
int number = 10;
number +=5;
System.out.println(number);

//in trước xong cộng 1 sau
System.out.println(number++);

// cộng 1 trước rồi 
System.out.println(++number);

for (int i = 0; i<3; i++)
System.out.println(i);


// Bieu thu logic
String address ="HANOI" ;

if (!(address == "Hochiminh")) {
	
	System.out.println("The address is the same");
}

// Bieu thuc dieu kien " Tam Nguyen"
boolean Status = (address == "HANOI")? true : false ;
System.out.println(Status);


}
}