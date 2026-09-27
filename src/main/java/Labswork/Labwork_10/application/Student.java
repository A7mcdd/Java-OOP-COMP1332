package Labswork.Labwork_10.application;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable{
	private Integer id,mobile;
	private String firstName,lastName,address,instructure;
	private Double quiz1,quiz2,quiz3,midterm,project1,project2,finalexam,grade;
	public Student(Integer id, Integer mobile, String firstName, String lastName, String address, String instructure, double quiz1, double quiz2,
			double quiz3, double midterm, double project1, double project2, double finalexam,double grade) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.quiz1 = quiz1;
		this.quiz2 = quiz2;
		this.quiz3 = quiz3;
		this.midterm = midterm;
		this.project1 = project1;
		this.project2 = project2;
		this.finalexam = finalexam;
		this.grade = grade;
		this.instructure =instructure;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getQuiz1() {
		return quiz1;
	}
	public void setQuiz1(double quiz1) {
		this.quiz1 = quiz1;
	}
	public double getQuiz2() {
		return quiz2;
	}
	public void setQuiz2(double quiz2) {
		this.quiz2 = quiz2;
	}
	public double getQuiz3() {
		return quiz3;
	}
	public void setQuiz3(double quiz3) {
		this.quiz3 = quiz3;
	}
	public double getMidterm() {
		return midterm;
	}
	public void setMidterm(double midterm) {
		this.midterm = midterm;
	}
	public double getProject1() {
		return project1;
	}
	public void setProject1(double project1) {
		this.project1 = project1;
	}
	public double getProject2() {
		return project2;
	}
	public void setProject2(double project2) {
		this.project2 = project2;
	}
	public double getFinalexam() {
		return finalexam;
	}
	public void setFinalexam(double finalexam) {
		this.finalexam = finalexam;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getInstructure() {
		return instructure;
	}
	public void setInstructure(String instructure) {
		this.instructure = instructure;
	}

	public double caalculateGrade() {
		return	quiz1+quiz2+quiz3+midterm+project1+project2+finalexam;

	}

	public double calculateGradePushed(String type) {
		double gradep = quiz1+quiz2+quiz3+midterm+project1+project2+finalexam;
		if (type.equals(null)) {return gradep;}

		if (type.equals("Best 2 Quizzes")) {
			gradep = (quiz1*1.5)+(quiz2*1.5)+midterm+project1+project2+finalexam;
			return gradep;
		}
		if (type.equals("Push 3 Grades")) {
			return gradep+3;
		}
		if (type.equals("Push 10%")) {
			gradep += gradep*0.10;
			return gradep;
		}
		return gradep;

	}
}






