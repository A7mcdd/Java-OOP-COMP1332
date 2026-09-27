package Labs.Lab11.application;

public abstract class Student extends Human {
	private int ID;
	private String school;
	
	public Student(int iD, String name ,char gender, String school) {
		super(name,gender);
		this.ID = iD;
		this.school = school;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	@Override
	public String toString() {
		return "ID: "+ID+" ,Name: "+super.getName()+" ,Gender: "+super.getGender()+" ,School: "+school;
	}
}
