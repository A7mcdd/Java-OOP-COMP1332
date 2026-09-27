package Labs.Lab04.Act3;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {

	public static void main(String[] args) {
		ArrayList<Subject> sublist1 = new ArrayList<>();
		sublist1.add(new Subject("Arabic", "Mandatory", 91));
		sublist1.add(new Subject("English", "Mandatory", 92));
		sublist1.add(new Subject("Physics", "Mandatory", 98));
		sublist1.add(new Subject("Math", "Mandatory", 189));
		sublist1.add(new Subject("Biology", "Elective I", 97));
		sublist1.add(new Subject("Chemistry", "Elective I", 87));
		sublist1.add(new Subject("Religious", "Elective II", 67));
		sublist1.add(new Subject("Technology", "Elective II", 87));

		ArrayList<Subject> sublist2 = new ArrayList<>();
		sublist2.add(new Subject("Arabic", "Mandatory", 142));
		sublist2.add(new Subject("English", "Mandatory", 109));
		sublist2.add(new Subject("Physics", "Mandatory", 98));
		sublist2.add(new Subject("History", "Mandatory", 89));
		sublist2.add(new Subject("Geography", "Elective I", 97));
		sublist2.add(new Subject("Religious", "Elective I", 87));
		sublist2.add(new Subject("Scientific Culture", "Elective II", 67));
		sublist2.add(new Subject("Technology", "Elective II", 87));


		Tawjihi sc1 = new Scientific(1, "ahmad", HumanBeing.Male, "bzu",12401,2024,sublist1);
		Tawjihi sc2 = new Scientific(2, "omar", 'M', "bzu",12402,2024,sublist2);
		Tawjihi sc3 = new Scientific(3, "maria", HumanBeing.Female, "bzu",12403,2024,sublist1);

		Tawjihi li1 = new Literary(4, "yousef", 'M', "bzu",12404,2024,sublist2);
		Tawjihi li2 = new Literary(5, "anas", 'M', "bzu",12405,2024,sublist1);
		Tawjihi li3 = new Literary(6, "murad", 'F', "bzu",12406,2024,sublist2);

		ArrayList<Tawjihi> students = new ArrayList<>();
		students.add(sc1);
		students.add(sc2);
		students.add(sc3);
		students.add(li1);
		students.add(li2);
		students.add(li3);

		for (int i = 0; i < students.size()-1; i++) {
			for (int j = i+1; j < students.size(); j++) {
				int comp = students.get(i).compareTo(students.get(j));
				if(comp==1){
					Tawjihi temp = students.get(i);
					students.set(i,students.get(j));
					students.set(j,temp);
				}
			}
		}
		//or
		Collections.sort(students);

		System.out.println(students);
	}

}
