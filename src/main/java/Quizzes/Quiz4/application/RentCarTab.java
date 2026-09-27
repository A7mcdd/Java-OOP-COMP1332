package Quizzes.Quiz4.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RentCarTab extends VBox{
	private TextField name,palet,days,rent,type;
	private Button prev,next,load,save,addnew;
	private AddNew an;
	int page =0;
	@SuppressWarnings("unchecked")
	public RentCarTab() {
		name = new TextField();
		palet = new TextField();
		type = new TextField();
		days = new TextField();
		rent = new TextField();
		prev = new Button("<-");
		next = new Button("->");
		load = new Button("Load");
		save = new Button("Save");
		addnew = new Button("AddNew");

		name.setEditable(false);
		palet.setEditable(false);
		days.setEditable(false);
		rent.setEditable(false);
		type.setEditable(false);

		GridPane gp = new GridPane();

		gp.add(new Label("Rental Name: "),0,0);
		gp.add(name,1,0);
		gp.add(new Label("Car Palet: "),0,1);
		gp.add(palet,1,1);
		gp.add(new Label("Type: "),0,2);
		gp.add(type,1,2);
		gp.add(new Label("Days: "),0,3);
		gp.add(days,1,3);
		gp.add(new Label("Cost of rent: "),0,4);
		gp.add(rent,1,4);
		gp.setVgap(10);
		gp.setHgap(10);
		gp.setAlignment(Pos.CENTER);
		
		
		HBox h1 = new HBox(10);
		h1.getChildren().addAll(prev,next);
		h1.setAlignment(Pos.CENTER);
		
		HBox h2 = new HBox(10);
		h2.getChildren().addAll(load,addnew,save);
		h2.setAlignment(Pos.CENTER);
		
		
		
		setPadding(new Insets(10));
		setAlignment(Pos.CENTER);
		getChildren().addAll(gp,h1,h2);
		setSpacing(15);
		

		addnew.setOnAction(e->{
			Stage stage = new Stage();
			an = new AddNew();
			Scene scene = new Scene(an,400,200);
			stage.setTitle("Add New Car");
			stage.setScene(scene);
			stage.show();
		});


		save.setOnAction(e->{
			try {
				FileOutputStream file = new FileOutputStream("src/main/java/Quizzes/Quiz4/car.dat");
				ObjectOutputStream oos = new ObjectOutputStream(file);
				oos.writeObject(new ArrayList<>(Main.olist));
				oos.close();
				System.out.println("saved");
				
			} catch (IOException e1) {
				System.out.println("Didn't saved");
			}
		});
		load.setOnAction(e->{
			try {
				FileInputStream file = new FileInputStream("src/main/java/Quizzes/Quiz4/car.dat");
				ObjectInputStream ois = new ObjectInputStream(file);
				ArrayList<Car> list = new ArrayList<>(Main.olist);
				list = (ArrayList<Car>) ois.readObject();
				Main.olist.clear();
				Main.olist.addAll(list);
				ois.close();
				System.out.println("loaded");

			} catch (IOException | ClassNotFoundException e1) {
				System.out.println("Didn't loaded");
			}
		});

		next.setOnAction(e->{
			if (page<Main.olist.size()-1) {
				page++;
				name.setText(Main.olist.get(page).getName());
				palet.setText(String.valueOf(Main.olist.get(page).getPalet()));
				type.setText(String.valueOf(Main.olist.get(page).getType()));
				days.setText(String.valueOf(Main.olist.get(page).getDays()));
				rent.setText(String.valueOf(Main.olist.get(page).getCost()));
			}
			System.out.println("page: "+page);
		});

		prev.setOnAction(e->{
			if(page>0) {
				page--;
				name.setText(Main.olist.get(page).getName());
				palet.setText(String.valueOf(Main.olist.get(page).getPalet()));
				type.setText(String.valueOf(Main.olist.get(page).getType()));
				days.setText(String.valueOf(Main.olist.get(page).getDays()));
				rent.setText(String.valueOf(Main.olist.get(page).getCost()));
			}
			System.out.println("page: "+page);
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
	public TextField getRent() {
		return rent;
	}
	public TextField getType() {
		return type;
	}
	public Button getPrev() {
		return prev;
	}
	public Button getNext() {
		return next;
	}
	public Button getLoad() {
		return load;
	}
	public Button getSave() {
		return save;
	}
	public Button getAddnew() {
		return addnew;
	}
	public AddNew getAn() {
		return an;
	}
	public int getPage() {
		return page;
	}
	

}
