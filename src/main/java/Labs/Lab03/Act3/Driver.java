package Labs.Lab03.Act3;

import java.util.ArrayList;

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

		Tawjihi sc1 = new Scientific(1, "ahmad", 'M', "bzu",12401,2024,sublist1);
		Tawjihi sc2 = new Scientific(2, "omar", 'M', "bzu",12402,2024,sublist1);
		Tawjihi sc3 = new Scientific(3, "maria", 'F', "bzu",12403,2024,sublist1);

		Tawjihi li1 = new Literary(4, "yousef", 'M', "bzu",12404,2024,sublist2);
		Tawjihi li2 = new Literary(5, "anas", 'M', "bzu",12405,2024,sublist2);
		Tawjihi li3 = new Literary(6, "murad", 'F', "bzu",12406,2024,sublist2);

		System.out.println(sc1);
		System.out.println(sc2);
		System.out.println(sc3);
		System.out.println(li1);
		System.out.println(li2);
		System.out.println(li3);

		ArrayList<Tawjihi> students = new ArrayList<>();
		students.add(sc1);
		students.add(sc2);
		students.add(sc3);
		students.add(li1);
		students.add(li2);
		students.add(li3);

		//the table code made with AI help
		Scientific topScientific = null;
		Literary topLiterary = null;

		System.out.println("\n-----------------------------------------------------------------------------");
		System.out.printf("%-15s | %-12s | %-12s | %-10s\n", "Name", "Seating No", "Branch", "Average");
		System.out.println("-----------------------------------------------------------------------------");

		for (Tawjihi s : students) {
			double avg = s.calculateAverage();
			String branch = (s instanceof Scientific) ? "Scientific" : "Literary";

			System.out.printf("%-15s | %-12d | %-12s | %-10.2f\n", s.getName(), s.getSeatingNum(), branch, avg);

			if (s instanceof Scientific) {
				if (topScientific == null || avg > topScientific.calculateAverage()) {
					topScientific = (Scientific) s;
				}
			} 
			else if (s instanceof Literary) {
				if (topLiterary == null || avg > topLiterary.calculateAverage()) {
					topLiterary = (Literary) s;
				}
			}
		}
		System.out.println("-----------------------------------------------------------------------------");

		System.out.println("\nTop Student in Scientific Branch: " + topScientific.getName() + " with Average: " + String.format("%.2f", topScientific.calculateAverage()));
		System.out.println("Top Student in Literary Branch: " + topLiterary.getName() + " with Average: " + String.format("%.2f", topLiterary.calculateAverage()));

	}

}
