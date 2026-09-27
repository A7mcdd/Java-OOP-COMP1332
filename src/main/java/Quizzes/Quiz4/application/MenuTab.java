package Quizzes.Quiz4.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class MenuTab {
	private MenuBar mb;
	@SuppressWarnings("unchecked")
	MenuTab(){
		mb = new MenuBar();

		Menu file = new Menu("File");
		MenuItem load = new MenuItem("Load");
		MenuItem add = new MenuItem("Add New");
		MenuItem save = new MenuItem("Save");
		load.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));
		add.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
		save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));


		file.getItems().addAll(load,add,save);

		add.setOnAction(e->{
			Stage stage = new Stage();
			AddNew an = new AddNew();
			Scene scene = new Scene(an,400,200);
			stage.setTitle("Add New Car");
			stage.setScene(scene);
			stage.show();
		});


		save.setOnAction(e->{
			try {
				FileOutputStream filee = new FileOutputStream("src/main/java/Quizzes/Quiz4/car.dat");
				ObjectOutputStream oos = new ObjectOutputStream(filee);
				oos.writeObject(new ArrayList<>(Main.olist));
				oos.close();
				System.out.println("saved");
				
			} catch (IOException e1) {
				System.out.println("Didn't saved");
			}
		});
		load.setOnAction(e->{
			try {
				FileInputStream filee = new FileInputStream("src/main/java/Quizzes/Quiz4/car.dat");
				ObjectInputStream ois = new ObjectInputStream(filee);
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



	}
	public MenuBar getMb() {
		return mb;
	}

}
