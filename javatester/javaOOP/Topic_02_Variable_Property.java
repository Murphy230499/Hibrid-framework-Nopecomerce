package javaOOP;

public class Topic_02_Variable_Property {
	// goi la variable khi khai bao va gan gia trij
	// goi la property khi no di voi mot Object va gan/lay du lieu qua ham set/Get
	// Cau truc cua 1 variable
	// 1. access modifier
	// 2.Data type
	// 3. Variable Name
	// 4. Value

	// trong pham vi class goi la golbal, neu ngoai class goi la instance variable,
	// nam trong 1 ham goi la local variable
	private String studentName = "MurphyLee"; // ngoai ham/ hoac block code duoc goi la bien toan cuc (Global variable)

	int studentID = 0123; // cau truc 1 bien/ variable

	// Static variable
	public static String studentAdress = "Ho Chi Minh"; // Public static : co the goi trong 1 ham static (Truc tiep)
														// hoac minh co the mo
														// 1 class khac goi class len va dung bien truc tiep khong can
														// phai khoi tao 1 Object de dung bien do

	private static String studentPhone = "0388870792"; // private static : chi dung trong class ( cho tat ca instance/
														// Object)

	// Final variable
	final String Country = "Viet Nam"; // final thi khong duoc phep gan/overide lai , muc dich co dinh du lieu khong
										// duoc phep thay doi trong qua trinh chay

	// Static final variable : la 1 hang so (constant) : Khong duoc ghi de, co the truy cap rong rai cho cac instance/ thread;
	static final float PI_NUMBER = 3.14453f;

	public static void display() {
		String studentName = "MurphyLee";// bien local vi nam trong 1 ham hoac 1 block
		String studentAdrees = "Ho chi Minh";

	}
}