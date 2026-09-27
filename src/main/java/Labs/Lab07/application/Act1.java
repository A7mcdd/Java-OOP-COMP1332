package Labs.Lab07.application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class Act1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setVgap(0);
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					Label l = new Label(""+(int)(Math.random()*2));
					l.setStyle("-fx-border-color : red; -fx-border-width : 5");
					l.setFont(new Font(30));
					l.setPrefHeight(100);
					l.setPrefWidth(100);
					l.setAlignment(Pos.CENTER);
					root.add(l, i, j);
				}
			}
			
			
			
			
			Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Display random 0 or 1");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
