package Labs.Lab04.Act3;

import java.util.ArrayList;

public abstract class Tawjihi extends Student implements Comparable<Tawjihi>{
	private int seatingNum,year;
	private ArrayList<Subject> subjects;

	public Tawjihi(int iD, String name, char gender, String school, int seatingNum, int year,
			ArrayList<Subject> subjects) {
		super(iD, name, gender, school);
		this.seatingNum = seatingNum;
		this.year = year;
		this.subjects = subjects;
	}

	public int getSeatingNum() {
		return seatingNum;
	}

	public void setSeatingNum(int seatingNum) {
		this.seatingNum = seatingNum;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}


	public void addSubject(Subject subject) {
		subjects.add(subject);
	}

	public Subject getSubject(String title) {
		for (int i = 0; i < subjects.size(); i++) {
			if (title.equals(subjects.get(i).getTitle()))
				return subjects.get(i);
		}
		return null;
	}
	
	public abstract double calculateAverage();

	@Override
	public String toString() {
		return super.toString()+" ,Seating Number: "+seatingNum+" ,Year: "+year+"\nSubjects: \n"+subjects+" ,Average: "+calculateAverage();
	}

	@Override
	public int compareTo(Tawjihi o) {
		if(calculateAverage()>o.calculateAverage())
			return 1;
		else if (calculateAverage()<o.calculateAverage())
			return -1;
		else return 0;
	}
	
	@Override
	public abstract boolean equals(Object obj);

}
