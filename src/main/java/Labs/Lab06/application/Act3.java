package Labs.Lab06.application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Act3 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane pane = new GridPane();
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					Rectangle r = new Rectangle();
					r.widthProperty().bind(pane.widthProperty().divide(8));
					r.heightProperty().bind(pane.heightProperty().divide(8));

					if((i+j)%2==0)
						r.setFill(Color.BLACK);
					else 
						r.setFill(Color.WHITE);

					pane.add(r, i, j);
				}


			}

			Scene scene = new Scene(pane,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Chess pane");
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
