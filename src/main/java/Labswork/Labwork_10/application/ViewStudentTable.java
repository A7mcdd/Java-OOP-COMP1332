package Labswork.Labwork_10.application;



import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class ViewStudentTable {

	private StackPane stackpane;
	private TableView<Student> tableview;
	private TableColumn<Student, Integer> id,mobile;
	private TableColumn<Student, String> firstName,lastName,address,instructure;
	private TableColumn<Student, Double> quiz1,quiz2,quiz3,midterm,project1,project2,finalexam,grade;




	@SuppressWarnings("unchecked")
	ViewStudentTable(ObservableList<Student> olist){
		tableview = new TableView<Student>();

		id = new TableColumn<Student, Integer>("ID");
		id.setCellValueFactory(new PropertyValueFactory<>("id"));

		mobile = new TableColumn<Student, Integer>("Mobile Number");
		mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));

		firstName = new TableColumn<Student, String>("First Name");
		firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		lastName = new TableColumn<Student, String>("Last Name");
		lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

		address = new TableColumn<Student, String>("Address");
		address.setCellValueFactory(new PropertyValueFactory<>("address"));

		instructure = new TableColumn<Student, String>("Instructure");
		instructure.setCellValueFactory(new PropertyValueFactory<>("instructure"));

		quiz1 = new TableColumn<Student, Double>("Quiz 1");
		quiz1.setCellValueFactory(new PropertyValueFactory<>("quiz1"));

		quiz2 = new TableColumn<Student, Double>("Quiz 2");
		quiz2.setCellValueFactory(new PropertyValueFactory<>("quiz2"));

		quiz3 = new TableColumn<Student, Double>("Quiz 3");
		quiz3.setCellValueFactory(new PropertyValueFactory<>("quiz3"));

		midterm = new TableColumn<Student, Double>("Midterm");
		midterm.setCellValueFactory(new PropertyValueFactory<>("midterm"));

		project1 = new TableColumn<Student, Double>("Project 1");
		project1.setCellValueFactory(new PropertyValueFactory<>("project1"));

		project2 = new TableColumn<Student, Double>("Project 2");
		project2.setCellValueFactory(new PropertyValueFactory<>("project2"));

		finalexam = new TableColumn<Student, Double>("Final Exam");
		finalexam.setCellValueFactory(new PropertyValueFactory<>("finalexam"));

		grade = new TableColumn<Student, Double>("Grade");
		grade.setCellValueFactory(new PropertyValueFactory<>("grade"));

		instructure = new TableColumn<Student, String>("Instructure");
		instructure.setCellValueFactory(new PropertyValueFactory<>("instructure"));



		
		tableview.getColumns().addAll(id,firstName,lastName,address,mobile,quiz1,quiz2,quiz3,midterm,project1,project2,finalexam,grade,instructure);
	



		stackpane = new StackPane();
		stackpane.getChildren().add(tableview);




	}




	public StackPane getStackpane() {
		return stackpane;
	}


	public void setStackpane(StackPane stackpane) {
		this.stackpane = stackpane;
	}




	public TableView<Student> getTableview() {
		return tableview;
	}













}
