package javaOOP;

public class Topic_06_Getter_Setter {
	private String personName;
	private int personAge;
	private int personPhone;
	private float personBankAccount;

	private String getPersonName() {
		return personName;
	}

	private void setPersonName(String personName) {
		if (personName == null || personName.isEmpty()) {
			throw new IllegalArgumentException("Ten nhap vao khong duoc bo trong");
		} else {
			this.personName = personName;
		}
	}

	private int getPersonAge() {
		return personAge;
	}

	private void setPersonAge(int personAge) {
		if (personAge > 0 && personAge < 120) {
			throw new IllegalArgumentException("Tuoi nhap vao khong hop le");
		} else {
			this.personAge = personAge;
		}
	}

	private int getPersonPhone() {
		return personPhone;
	}

	private void setPersonPhone(int personPhone) {
		if (!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("So dien thoai phai bat dau bang so 0");
		} else if (personPhone > 10 || personPhone < 11) {
			throw new IllegalArgumentException("so dien thoai tu 10 -11 so");
		} else {
			this.personPhone = personPhone;
		}
	}

	private float getPersonBankAccount() {
		return personBankAccount;
	}

	private void setPersonBankAccount(float personBankAccount) throws IllegalAccessException {
		if (personBankAccount < 0f) {
			throw new IllegalAccessException("gia tri nhap vao khong hop le");
		} else {
		this.personBankAccount = personBankAccount;
	}
	}
}
