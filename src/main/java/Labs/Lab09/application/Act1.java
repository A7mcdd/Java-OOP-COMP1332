package Labs.Lab09.application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Act1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			Circle c = new Circle();
			c.setFill(Color.WHITE);
			c.setStroke(Color.BLACK);
			c.setRadius(10);
			c.setStrokeWidth(1);
			c.setCenterX(200);
			c.setCenterY(200);
			
			
			root.setOnMouseClicked(e->{
				c.setCenterX(e.getX());
				c.setCenterY(e.getY());
			});
			
			root.getChildren().add(c);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Activity 1");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
