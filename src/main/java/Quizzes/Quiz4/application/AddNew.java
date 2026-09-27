package Quizzes.Quiz4.application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddNew extends VBox {
	private TextField name,palet,days;
	private Button add;
	private ComboBox<String> type;
	AddNew(){
		name = new TextField();
		palet = new TextField();
		days = new TextField();
		add = new Button("Add");

		String[] stypes = {"Sport","Laxury","Van"};
		ObservableList<String> lt = FXCollections.observableArrayList(stypes);
		type = new ComboBox<>(lt);

		GridPane gp = new GridPane();

		gp.add(new Label("Rental Name: "),0,0);
		gp.add(name,1,0);
		gp.add(new Label("Car Palet: "),0,1);
		gp.add(palet,1,1);
		gp.add(new Label("Type: "),0,2);
		gp.add(type,1,2);
		gp.add(new Label("Days: "),0,3);
		gp.add(days,1,3);
		HBox h1 = new HBox();
		h1.setAlignment(Pos.CENTER);
		h1.getChildren().add(add);
		gp.setVgap(10);
		gp.setHgap(10);
		gp.setAlignment(Pos.CENTER);

		
		setSpacing(15);
		setPadding(new Insets(10));
		getChildren().addAll(gp,h1);

		add.setOnAction(e->{
			try {
			String stype ="";
			if (type.getSelectionModel().getSelectedIndex()==0) {stype = "Sport";}
			if (type.getSelectionModel().getSelectedIndex()==1) {stype = "Laxury";}
			if (type.getSelectionModel().getSelectedIndex()==2) {stype = "Van";}
			Main.olist.add(new Car(name.getText(),palet.getText(), stype, Integer.valueOf(days.getText())));
			System.out.println("added");
			} catch (Exception e2) {
				System.out.println("Didn't added");
			}
			
		});
	}
	public TextField getName() {
		return name;
	}
	public TextField getPalet() {
		return palet;
	}
	public TextField getDays() {
		return days;
	}
	public Button getAdd() {
		return add;
	}
	public ComboBox<String> getType() {
		return type;
	}
	
}
