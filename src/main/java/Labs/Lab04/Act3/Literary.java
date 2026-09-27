package Labs.Lab04.Act3;

import java.util.ArrayList;

public class Literary extends Tawjihi{

	public Literary(int iD, String name, char gender, String school, int seatingNum, int year,
			ArrayList<Subject> subjects) {
		super(iD, name, gender, school, seatingNum, year, subjects);
	}
	
	@Override
	public double calculateAverage() {
		double mark=0;
		double Elec1=0;
		double Elec2=0;

		for (int i = 0; i < super.getSubjects().size(); i++) {
			if (super.getSubjects().get(i).getType().equalsIgnoreCase("Mandatory"))
				mark = mark + super.getSubjects().get(i).getMark();
			
			if (super.getSubjects().get(i).getType().equalsIgnoreCase("Elective I"))
				if(Elec1<super.getSubjects().get(i).getMark())
					Elec1 = super.getSubjects().get(i).getMark();
			if (super.getSubjects().get(i).getType().equalsIgnoreCase("Elective II"))
				if(Elec2<super.getSubjects().get(i).getMark())
					Elec2 = super.getSubjects().get(i).getMark();
		}
		mark = mark+Elec1+Elec2;
		mark = mark/7;

		return mark;
	}
	
	@Override
	public String toString() {
		return super.toString()+" ,Literary branch.\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Scientific) {
			if(((Scientific)obj).getID()==getID())
				return true;
			}
		return false;
	}
	

}
