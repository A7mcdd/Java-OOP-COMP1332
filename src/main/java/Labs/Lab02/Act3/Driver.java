package Labs.Lab02.Act3;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		ArrayList<Subject> sublist = new ArrayList<>();
		sublist.add(new Subject("Math", "Mandatory", 98));
		sublist.add(new Subject("English", "Electivel", 97));
		
		Student s = new Student(1, "ahmad", 'M', "bzu");
		System.out.println(s.toString());
		Tawjihi t = new Tawjihi(1, "ahmad", 'M', "bzu",124,2024,sublist);
		System.out.println(t.toString());
	}

}
