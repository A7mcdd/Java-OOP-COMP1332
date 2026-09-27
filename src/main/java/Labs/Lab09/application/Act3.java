package Labs.Lab09.application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Act3 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			root.setOnMouseClicked(e->{

				Circle c = new Circle(5);
				if (e.getButton() == MouseButton.PRIMARY) {
					c.setFill(Color.WHITE);
					c.setStroke(Color.BLACK);
					c.setCenterX(e.getX());
					c.setCenterY(e.getY());
					root.getChildren().add(c);
					c.setOnMouseClicked(ex->{
						if(ex.getButton() == MouseButton.SECONDARY)
							root.getChildren().remove(c);
					});}
			});


			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Activity 3");
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
