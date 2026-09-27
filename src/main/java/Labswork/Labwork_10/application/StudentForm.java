package Labswork.Labwork_10.application;






import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class StudentForm {
	private GridPane gpane;
	private TextField id,mobile, firstName,lastName,address, quiz1,quiz2,quiz3,midterm,project1,project2,finalexam;
	private RadioButton mammoun,fasial,murad;
	private Text grade;
	private Button calGrade,add,showTable,prev,next;
	private ComboBox<String> cbox;

	public StudentForm() {

		gpane=new GridPane();
		gpane.setVgap(10);
		gpane.setHgap(20);
		gpane.setAlignment(Pos.CENTER);

		//
		id= new TextField();
		mobile= new TextField();
		firstName= new TextField();
		lastName= new TextField();
		address= new TextField();
		quiz1= new TextField();
		quiz2= new TextField();
		quiz3= new TextField();
		midterm= new TextField();
		project1= new TextField();
		project2= new TextField();
		finalexam= new TextField();

		calGrade = new Button("Calcilate Grade");
		add = new Button("Add Student");
		showTable = new Button("Show Table");
		prev = new Button("<-");
		next = new Button("->");

		mammoun = new RadioButton("Mammoun");
		fasial= new RadioButton("Fasial");
		murad= new RadioButton("Murad");
		grade = new Text("-");


		//
		gpane.add(new Label("Student ID:"), 0, 0);
		gpane.add(id,1,0);

		gpane.add(new Label("Student FirstName:"), 0, 1);
		gpane.add(firstName,1,1);

		gpane.add(new Label("Student LastName:"), 0, 2);
		gpane.add(lastName,1,2);

		gpane.add(new Label("Address:"), 0, 3);
		gpane.add(address,1,3);

		gpane.add(new Label("Mobile:"), 0, 4);
		gpane.add(mobile,1,4);

		gpane.add(new Label("Quiz 1:"), 0, 5);
		gpane.add(quiz1,1,5);

		gpane.add(new Label("Quiz 2:"), 0, 6);
		gpane.add(quiz2,1,6);

		gpane.add(new Label("Quiz 3:"), 0, 7);
		gpane.add(quiz3,1,7);

		gpane.add(new Label("Midterm:"), 0, 8);
		gpane.add(midterm,1,8);

		gpane.add(new Label("Project 1:"), 0, 9);
		gpane.add(project1,1,9);

		gpane.add(new Label("Project 2:"), 0, 10);
		gpane.add(project2,1,10);

		gpane.add(new Label("Final Exam:"), 0, 11);
		gpane.add(finalexam,1,11);

		gpane.add(new Label("Grade:"), 0, 12);
		gpane.add(grade,1,12);
		gpane.add(calGrade, 2, 12);

		HBox rhbox = new HBox(10);
		rhbox.getChildren().addAll(mammoun,fasial,murad);
		gpane.add(new Label("Instrcuter Name:"), 0, 13);
		gpane.add(rhbox, 1, 13);

		//Push Up:
		HBox abox = new HBox(10);
		abox.getChildren().addAll(add,showTable);
		gpane.add(abox, 1, 14);

		String[] items = {"","Best 2 Quizzes","Push 3 Grades","Push 10%"};
		ObservableList<String> oitems = FXCollections.observableArrayList(items);
		cbox = new ComboBox<>();
		cbox.getItems().addAll(oitems);
		gpane.add(cbox, 2, 14);

		HBox shbox = new HBox(20);
		shbox.getChildren().addAll(prev,next);
		gpane.add(shbox, 1, 15);






		ToggleGroup tg = new ToggleGroup();
		mammoun.setToggleGroup(tg);
		fasial.setToggleGroup(tg);
		murad.setToggleGroup(tg);

		gpane.setPadding(new Insets(20));


	}







	public Button getCalGrade() {
		return calGrade;
	}

	public Button getAdd() {
		return add;
	}

	public Button getShowTable() {
		return showTable;
	}

	public Button getPrev() {
		return prev;
	}

	public Button getNext() {
		return next;
	}

	public GridPane getGpane() {
		return gpane;
	}
	public TextField getId() {
		return id;
	}
	public TextField getMobile() {
		return mobile;
	}
	public TextField getFirstName() {
		return firstName;
	}
	public TextField getLastName() {
		return lastName;
	}
	public TextField getAddress() {
		return address;
	}
	public TextField getQuiz1() {
		return quiz1;
	}
	public TextField getQuiz2() {
		return quiz2;
	}
	public TextField getQuiz3() {
		return quiz3;
	}
	public TextField getMidterm() {
		return midterm;
	}
	public TextField getProject1() {
		return project1;
	}
	public TextField getProject2() {
		return project2;
	}
	public TextField getFinalexam() {
		return finalexam;
	}
	public RadioButton getMammoun() {
		return mammoun;
	}
	public RadioButton getFasial() {
		return fasial;
	}
	public RadioButton getMurad() {
		return murad;
	}
	public Text getGrade() {
		return grade;
	}

	public ComboBox<String> getCbox() {
		return cbox;
	}







	public void setGradeValue(double value) {
		grade.setText(String.valueOf(value));
	}




}
