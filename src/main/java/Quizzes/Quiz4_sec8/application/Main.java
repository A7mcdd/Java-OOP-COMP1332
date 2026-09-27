package Quizzes.Quiz4_sec8.application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	static ObservableList<Product> olist = FXCollections.observableArrayList();
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			ManagmentTab mt = new ManagmentTab();
			StaticTab st = new StaticTab();
			
			TabPane tp = new TabPane();
			Tab Managment = new Tab("Managment");
			Tab Static = new Tab("Static");
			Managment.setClosable(false);
			Static.setClosable(false);
			Managment.setContent(mt);
			Static.setContent(st);
			tp.getTabs().addAll(Managment,Static);

			
			root.setTop(tp);

			Scene scene = new Scene(root,1000,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Marekt System");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
