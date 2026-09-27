package Quizzes.Quiz4.application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	static ObservableList<Car> olist = FXCollections.observableArrayList();
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			RentCarTab rt = new RentCarTab();
			StaticTab st = new StaticTab();
			MenuTab mt = new MenuTab();

			TabPane tp = new TabPane();
			Tab rentcar = new Tab("Rent Car");
			Tab Static = new Tab("Static");
			rentcar.setClosable(false);
			Static.setClosable(false);
			rentcar.setContent(rt);
			Static.setContent(st);
			tp.getTabs().addAll(rentcar,Static);


			root.setCenter(tp);
			root.setTop(mt.getMb());
			
			Scene scene = new Scene(root,1000,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Car Rental System");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
