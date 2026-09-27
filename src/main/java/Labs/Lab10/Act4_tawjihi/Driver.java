package Labs.Lab10.Act4_tawjihi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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


		Tawjihi sc1 = new Scientific(1, "ahmad", HumanBeing.Male, "bzu",12401,2024,sublist1);
		Tawjihi sc2 = new Scientific(2, "maria", HumanBeing.Female, "bzu",12402,2024,sublist1);
		Tawjihi sc3 = new Scientific(3, "mohamed", 'M', "bzu",12403,2024,sublist2);

		Tawjihi li1 = new Literary(4, "yousef", 'M', "bzu",12404,2024,sublist2);
		Tawjihi li2 = new Literary(5, "anas", 'M', "bzu",12405,2024,sublist2);
		Tawjihi li3 = new Literary(6, "murad", 'M', "bzu",12406,2024,sublist1);

		ArrayList<Tawjihi> students = new ArrayList<>();
		students.add(sc1);
		students.add(sc2);
		students.add(sc3);
		students.add(li1);
		students.add(li2);
		students.add(li3);


		//lab6
		try {
			saveStudent(students);
		} catch (IOException e) {
			e.getMessage();
		}
		try {
			System.out.println(loadStudent());
		} catch (IOException e) {
			e.getMessage();
		}
	}
	public static void saveStudent(ArrayList<Tawjihi> students) throws IOException {
		DataOutputStream DOS = new DataOutputStream(new FileOutputStream("src/main/java/Labs/Lab10/Tawjihi.dat"));
		DOS.writeInt(students.size());
		for (Tawjihi s : students) {
			DOS.writeInt(s.getID());
			DOS.writeUTF(s.getName());
			DOS.writeChar(s.getGender());
			DOS.writeUTF(s.getSchool());
			if(s instanceof Scientific)
				DOS.writeUTF("Scientific");
			else if(s instanceof Literary)
				DOS.writeUTF("Literary");
			DOS.writeInt(s.getSeatingNum());
			DOS.writeInt(s.getYear());
			DOS.writeInt(s.getSubjects().size());
			for (Subject sub : s.getSubjects()) {
				DOS.writeUTF(sub.getTitle());
				DOS.writeUTF(sub.getType());
				DOS.writeInt(sub.getMark());
				DOS.writeInt(sub.getMaxMark());
			}
		}
		DOS.close();
	}
	public static ArrayList<Tawjihi> loadStudent() throws IOException {
		DataInputStream DIS = new DataInputStream(new FileInputStream("src/main/java/Labs/Lab10/Tawjihi.dat"));
		int listSize = DIS.readInt();
		ArrayList<Tawjihi> students = new ArrayList<>();
		for (int i = 0; i < listSize; i++) {
			int id = DIS.readInt();
			String name = DIS.readUTF();
			char gender = DIS.readChar();
			String School =DIS.readUTF();
			String Branch =DIS.readUTF();
			int SeatingNum = DIS.readInt();
			int year = DIS.readInt();
			int numOfSubjects = DIS.readInt();
			ArrayList<Subject> sub = new ArrayList<>();
			for (int j = 0; j < numOfSubjects; j++) {
				String title = DIS.readUTF();
				String type = DIS.readUTF();
				int mark = DIS.readInt();
				DIS.readInt();
				sub.add(new Subject(title, type, mark));
			}
			Tawjihi stu = null;
			if(Branch.equals("Scientific")) {
				stu = new Scientific(id, name, gender, School, SeatingNum, year, sub);}
			else if(Branch.equals("Literary")){
				stu = new Literary(id, name, gender, School, SeatingNum, year, sub);
			}
			students.add(stu);
		}
		DIS.close();
		return students;
	}
}
