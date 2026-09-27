package Labs.Lab08.application;



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class Act3 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setVgap(0);
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					Label l = new Label("");
					l.setStyle("-fx-border-color : red; -fx-border-width : 5");
					l.setFont(new Font(30));
					l.setPrefHeight(100);
					l.setPrefWidth(100);
					l.setAlignment(Pos.CENTER);
					
					l.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							l.setText(""+(int)(Math.random()*2));
						}
					});
					root.add(l, i, j);
					
				}
			}

			Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tic-Tac-Toe");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
