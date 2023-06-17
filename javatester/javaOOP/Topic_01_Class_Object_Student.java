package javaOOP;

public class Topic_01_Class_Object_Student {

	private int studenID;
	private String studentName;
	private float knowlegePoint;
	private float practicepoint;

	private int getStudenID() {
		return studenID;
	}

	private void setStudenID(int studenID) {
		this.studenID = studenID;
	}

	private String getStudentName() {
		return studentName;
	}

	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private float getKnowlegePoint() {
		return knowlegePoint;
	}

	private void setKnowlegePoint(float knowlegePoint) {
		this.knowlegePoint = knowlegePoint;
	}

	private float getPracticepoint() {
		return practicepoint;
	}

	private void setPracticepoint(float practicepoint) {
		this.practicepoint = practicepoint;
	}

	private float getAverangePoint() {
		return (this.knowlegePoint + this.practicepoint * 2) / 3;
	}

	private void showInform() {
		System.out.println("******************");
		System.out.println("Student ID = " + getStudenID());
		System.out.println("Student Name= " + getStudentName());
		System.out.println("Student Knowlege point = " + getKnowlegePoint());
		System.out.println("Student Practice point = " + getPracticepoint());
		System.out.println("Student Averange point = " + getAverangePoint());
		System.out.println("******************");
	}

	public static void main(String[] args) {

		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		firstStudent.setStudenID(2005226);
		firstStudent.setStudentName("Ronaldo");
		firstStudent.setKnowlegePoint(9.5f);
		firstStudent.setPracticepoint(7.8f);
		firstStudent.showInform();
		
		
		Topic_01_Class_Object_Student secondStudent = new Topic_01_Class_Object_Student();
		secondStudent.setStudenID(2005227);
		secondStudent.setStudentName("Messi");
		secondStudent.setKnowlegePoint(9.5f);
		secondStudent.setPracticepoint(9f);
		secondStudent.showInform();
	}
	
}
