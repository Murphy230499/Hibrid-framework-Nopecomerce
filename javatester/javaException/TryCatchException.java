package javaException;

public class TryCatchException {
	public static void main(String[] args) {
		int number = 10;

		try {
			// Dung: chay het doan code trong try va khong qua catch
			// Sai: gap exception thi no se nhay qua catch
			
			number = number / 0;
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println(number);

		String[] browserName = { "Chrome", "Firefox", "Sarari" };
		try {
			browserName[0] = "Edge Chromium";
			browserName[3] = "Edge Chromium";
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String browser : browserName) {
			System.out.println(browser);
		}

	}
}
