package Labswork.Labwork_10.application;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	static ObservableList<Student> list = FXCollections.observableArrayList();
	ObservableList<Student> top10list = FXCollections.observableArrayList();
	private int currentIndex=-1;
	@Override
	public void start(Stage primaryStage) {
		try {


			StudentForm studentform = new StudentForm();
			StatisticalPane stapane = new StatisticalPane();
			ViewStudentTable viewtable = new ViewStudentTable(list);
			ViewStudentTable topviewtable = new ViewStudentTable(top10list);
			MenuClass menuclass = new MenuClass();

			TabPane tabpane =new TabPane();
			Tab recored=new Tab("Student Recored");
			Tab report=new Tab("Statical Report");

			BorderPane pstat = new BorderPane();
			pstat.setTop(stapane.getGpane());
			pstat.setCenter(topviewtable.getStackpane());

			recored.setContent(studentform.getGpane());
			report.setContent(pstat);

			tabpane.getTabs().addAll(recored,report);

			BorderPane root = new BorderPane();
			root.setTop(menuclass.getHbox());
			root.setCenter(tabpane);

			Stage showStage = new Stage();
			VBox vbox = new VBox(10);
			vbox.setPadding(new Insets(10));
			HBox hbox = new HBox(20);
			Button delete = new Button("Delete");
			Button update = new Button("Update");
			Button add = new Button("Add");
			hbox.getChildren().addAll(add,update,delete);
			vbox.getChildren().addAll(viewtable.getStackpane(),hbox);
			Scene showScene = new Scene(vbox,800,700);
			showStage.setScene(showScene);
			showStage.setTitle("Student Table");

			//actions
			studentform.getShowTable().setOnAction(e -> {
				showStage.show();


			});

			studentform.getAdd().setOnAction(e -> {
				try {
					if (!isFormValid(studentform)) {
						System.out.println("fill all fields with vaild id");
						return;
					}
					addMethod(studentform);
					updateStatistics(stapane);
					updateTop10();

				} catch (Exception e2) {
					System.out.println("Invaild Inputs");
				}
			});

			studentform.getCalGrade().setOnAction(e->{
				try {
					double total =
							Double.parseDouble(studentform.getQuiz1().getText())+
							Double.parseDouble(studentform.getQuiz2().getText())+
							Double.parseDouble(studentform.getQuiz3().getText())+
							Double.parseDouble(studentform.getMidterm().getText())+
							Double.parseDouble(studentform.getProject1().getText())+
							Double.parseDouble(studentform.getProject2().getText())+
							Double.parseDouble(studentform.getFinalexam().getText());
					studentform.setGradeValue(total);
				} catch (Exception e2) {
				}

			});
			studentform.getNext().setOnAction(e -> {
				if (list.isEmpty()) {
					clearForm(studentform);
					currentIndex = -1;
					return;
				}
				if(currentIndex < list.size()-1) {
					currentIndex++;
					fillForm(studentform, list.get(currentIndex));
				}
				else {
					currentIndex = list.size();
					clearForm(studentform);
				}
			});
			studentform.getPrev().setOnAction(e -> {
				try {
					if (list.isEmpty()) {
						clearForm(studentform);
						currentIndex = -1;
						return;
					}
					if ( currentIndex >0) {
						currentIndex--;
					}
					fillForm(studentform, list.get(currentIndex));
				} catch (Exception e2) {
					System.out.println("No Prev page");
				}


			});
			delete.setOnAction(e -> {
				Student selected = viewtable.getTableview()
						.getSelectionModel()
						.getSelectedItem();

				if (selected == null) {
					return;   
				}

				list.remove(selected);
				clearForm(studentform);
				currentIndex = -1;
				updateStatistics(stapane);
				updateTop10();



			});
			update.setOnAction(e ->{
				try {

					if (currentIndex < 0 || currentIndex >= list.size()) {
						return;
					}


					Student s = list.get(currentIndex);
					if (!isFormValidForUpdate(studentform)) {
						System.out.println("fill all fields");
						return;
					}
					s.setId(Integer.parseInt(studentform.getId().getText()));
					s.setMobile(Integer.parseInt(studentform.getMobile().getText()));
					s.setFirstName(studentform.getFirstName().getText());
					s.setLastName(studentform.getLastName().getText());
					s.setAddress(studentform.getAddress().getText());

					s.setQuiz1(Double.parseDouble(studentform.getQuiz1().getText()));
					s.setQuiz2(Double.parseDouble(studentform.getQuiz2().getText()));
					s.setQuiz3(Double.parseDouble(studentform.getQuiz3().getText()));
					s.setMidterm(Double.parseDouble(studentform.getMidterm().getText()));
					s.setProject1(Double.parseDouble(studentform.getProject1().getText()));
					s.setProject2(Double.parseDouble(studentform.getProject2().getText()));
					s.setFinalexam(Double.parseDouble(studentform.getFinalexam().getText()));

					s.setGrade(s.caalculateGrade());
					updateStatistics(stapane);
					updateTop10();
					viewtable.getTableview().refresh();
				} catch (Exception e2) {
					System.out.println("Invaild Inputs");
				}
			});
			menuclass.getUpdate().setOnAction(e ->{
				try {

					if (currentIndex < 0 || currentIndex >= list.size()) {
						return;
					}


					Student s = list.get(currentIndex);
					if (!isFormValidForUpdate(studentform)) {
						System.out.println("fill all fields");
						return;
					}
					s.setId(Integer.parseInt(studentform.getId().getText()));
					s.setMobile(Integer.parseInt(studentform.getMobile().getText()));
					s.setFirstName(studentform.getFirstName().getText());
					s.setLastName(studentform.getLastName().getText());
					s.setAddress(studentform.getAddress().getText());

					s.setQuiz1(Double.parseDouble(studentform.getQuiz1().getText()));
					s.setQuiz2(Double.parseDouble(studentform.getQuiz2().getText()));
					s.setQuiz3(Double.parseDouble(studentform.getQuiz3().getText()));
					s.setMidterm(Double.parseDouble(studentform.getMidterm().getText()));
					s.setProject1(Double.parseDouble(studentform.getProject1().getText()));
					s.setProject2(Double.parseDouble(studentform.getProject2().getText()));
					s.setFinalexam(Double.parseDouble(studentform.getFinalexam().getText()));

					s.setGrade(s.caalculateGrade());
					updateStatistics(stapane);
					updateTop10();
					viewtable.getTableview().refresh();
				} catch (Exception e2) {
					System.out.println("Invaild Inputs");
				}
			});
			add.setOnAction(e -> {
				try {
					if (!isFormValid(studentform)) {
						System.out.println("fill all fields with vaild id");
						return;
					}
					addMethod(studentform);
					updateStatistics(stapane);
					updateTop10();
				} catch (Exception e2) {
					System.out.println("Invaild Inputs");
				}

			});
			menuclass.getAdd().setOnAction(e -> {
				try {
					if (!isFormValid(studentform)) {
						System.out.println("fill all fields with vaild id");
						return;
					}
					addMethod(studentform);
					updateStatistics(stapane);
					updateTop10();
				} catch (Exception e2) {
					System.out.println("Invaild Inputs");
				}

			});
			menuclass.getNext().setOnAction(e -> {
				if (list.isEmpty()) {
					clearForm(studentform);
					currentIndex = -1;
					return;
				}
				if(currentIndex < list.size()-1) {
					currentIndex++;
					fillForm(studentform, list.get(currentIndex));
				}
				else {
					currentIndex = list.size();
					clearForm(studentform);
				}
			});
			menuclass.getPrev().setOnAction(e -> {
				try {
					if (list.isEmpty()) {
						clearForm(studentform);
						currentIndex = -1;
						return;
					}
					if ( currentIndex >0) {
						currentIndex--;
					}
					fillForm(studentform, list.get(currentIndex));
				} catch (Exception e2) {
					System.out.println("No prev page");
				}


			});
			menuclass.getSave().setOnAction(e -> {
				saveStudents(new ArrayList<>(list));

			});
			menuclass.getLoad().setOnAction(e -> {
				list.setAll(loadStudents());
				updateStatistics(stapane);
				updateTop10();
			});


			Scene scene = new Scene(root,1000,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Student App");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}













	public void addMethod(StudentForm studentform) {
		String firstName= studentform.getFirstName().getText();
		String lastName= studentform.getLastName().getText();
		String address= studentform.getAddress().getText();
		Integer id= Integer.valueOf(studentform.getId().getText());
		Integer mobile= Integer.valueOf(studentform.getMobile().getText());
		Double quiz1= Double.valueOf(studentform.getQuiz1().getText());
		Double quiz2= Double.valueOf(studentform.getQuiz2().getText());
		Double quiz3= Double.valueOf(studentform.getQuiz3().getText());
		Double midterm= Double.valueOf(studentform.getMidterm().getText());
		Double project1= Double.valueOf(studentform.getProject1().getText());
		Double project2= Double.valueOf(studentform.getProject2().getText());
		Double finalexam= Double.valueOf(studentform.getFinalexam().getText());

		String instructure="None";
		if (studentform.getFasial().isSelected()) {
			instructure = "Fasial";}
		if (studentform.getMurad().isSelected()) {
			instructure = "Murad";}
		if (studentform.getMammoun().isSelected()) {
			instructure = "Mammoun";}

		String pushType = studentform.getCbox().getValue();
		Student s =new Student(id,mobile, firstName,lastName,address,instructure,quiz1,quiz2,quiz3,midterm,project1,project2, finalexam, 0);
		s.setGrade(s.caalculateGrade());
		if(pushType!=null) 
			s.setGrade(s.calculateGradePushed(pushType));
		list.add(s);
	}

	public void updateStatistics(StatisticalPane stat) {
		if (list.isEmpty()) {
			stat.getMax().setText("-");
			stat.getAvg().setText("-");
			stat.getMin().setText("-");
			return;
		}

		double sum =0;
		double max = list.get(0).getGrade();
		double min = list.get(0).getGrade();
		int suc = 0;
		int fail = 0;
		int aavg = 0;
		int bavg = 0;

		for(Student s : list) {
			double g = s.getGrade();
			sum+=g;

			if(g>max) 
				max = g;
			if(g<min)
				min =g;
			if(g>=60)
				suc++;
			if(g<60)
				fail++;
		}


		double avg = sum/list.size();
		for(Student s : list) {
			double g = s.getGrade();
			if(g>=avg)
				aavg++;
			if(g<avg)
				bavg++;
		}

		stat.getMax().setText("%"+max);
		stat.getAvg().setText("%"+avg);
		stat.getMin().setText("%"+min);
		stat.getSuc().setText(""+suc);
		stat.getFail().setText(""+fail);
		stat.getAavg().setText(""+aavg);
		stat.getBavg().setText(""+bavg);


	}

	public void updateTop10() {
		top10list.setAll(list.stream()
				.sorted(new Comparator<Student>() {
					@Override
					public int compare(Student a , Student b) {
						return Double.compare(b.getGrade(), a.getGrade());
					}

				}).limit(10).toList());

	}
	public void fillForm(StudentForm form, Student s) {

		form.getId().setText(String.valueOf(s.getId()));
		form.getMobile().setText(String.valueOf(s.getMobile()));
		form.getFirstName().setText(s.getFirstName());
		form.getLastName().setText(s.getLastName());
		form.getAddress().setText(s.getAddress());

		form.getQuiz1().setText(String.valueOf(s.getQuiz1()));
		form.getQuiz2().setText(String.valueOf(s.getQuiz2()));
		form.getQuiz3().setText(String.valueOf(s.getQuiz3()));
		form.getMidterm().setText(String.valueOf(s.getMidterm()));
		form.getProject1().setText(String.valueOf(s.getProject1()));
		form.getProject2().setText(String.valueOf(s.getProject2()));
		form.getFinalexam().setText(String.valueOf(s.getFinalexam()));

		form.setGradeValue(s.getGrade());
	}

	public void clearForm(StudentForm form) {
		form.getId().clear();
		form.getMobile().clear();
		form.getFirstName().clear();
		form.getLastName().clear();
		form.getAddress().clear();

		form.getQuiz1().clear();
		form.getQuiz2().clear();
		form.getQuiz3().clear();
		form.getMidterm().clear();
		form.getProject1().clear();
		form.getProject2().clear();
		form.getFinalexam().clear();

		form.setGradeValue(0);
	}

	public static void saveStudents(ArrayList<Student> students) {
		try {
			FileOutputStream fileOut = new FileOutputStream("src/main/java/Labswork/Labwork_10/students.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(students);

			out.close();
			fileOut.close();

			System.out.println("Students saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<Student> loadStudents() {
		try {
			FileInputStream fileIn = new FileInputStream("src/main/java/Labswork/Labwork_10/students.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);

			@SuppressWarnings("unchecked")
			ArrayList<Student> students = (ArrayList<Student>) in.readObject();

			in.close();
			fileIn.close();

			System.out.println("Students loaded successfully");
			return students;

		} catch (Exception e) {
			System.out.println("No save file found");
			return new ArrayList<>();
		}
	}
	public boolean isFormValid(StudentForm form) {

		if (form.getId().getText().isEmpty()) return false;
		if (form.getMobile().getText().isEmpty()) return false;
		if (form.getFirstName().getText().isEmpty()) return false;
		if (form.getLastName().getText().isEmpty()) return false;
		if (form.getQuiz1().getText().isEmpty()) return false;
		if (form.getQuiz2().getText().isEmpty()) return false;
		if (form.getQuiz3().getText().isEmpty()) return false;
		if (form.getMidterm().getText().isEmpty()) return false;
		if (form.getFinalexam().getText().isEmpty()) return false;

		int id = Integer.parseInt(form.getId().getText());

		for (int i = 0; i < list.size(); i++) {
			if (i != currentIndex && list.get(i).getId() == id) {
				return false; 
			}}

		return true; 
	}
	public boolean isFormValidForUpdate(StudentForm form) {

		if (form.getId().getText().isEmpty()) return false;
		if (form.getMobile().getText().isEmpty()) return false;
		if (form.getFirstName().getText().isEmpty()) return false;
		if (form.getLastName().getText().isEmpty()) return false;
		if (form.getQuiz1().getText().isEmpty()) return false;
		if (form.getQuiz2().getText().isEmpty()) return false;
		if (form.getQuiz3().getText().isEmpty()) return false;
		if (form.getMidterm().getText().isEmpty()) return false;
		if (form.getFinalexam().getText().isEmpty()) return false;



		return true; 
	}

	public static void main(String[] args) {
		launch(args);
	}

}
