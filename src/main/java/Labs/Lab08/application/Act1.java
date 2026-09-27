package Labs.Lab08.application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Act1 extends Application {
	Circle c;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			c = new Circle(20);
			c.setFill(Color.WHITE);
			c.setStroke(Color.BLACK);
			c.setStrokeWidth(2);
			c.setCenterX(200);
			c.setCenterY(200);

			Button up = new Button("Up");
			Button down = new Button("Down");
			Button left = new Button("Left");
			Button right = new Button("Right");
			HBox cont = new HBox(10);
			cont.getChildren().addAll(left,right,up,down);
			cont.setAlignment(Pos.CENTER);

			up.setOnAction(e->{
				c.setCenterY(c.getCenterY()-20);
			});

			downhandler handle1 = new downhandler();
			down.setOnAction(handle1);

			left.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					c.setCenterX(c.getCenterX()-20);
				}
			});

			right.setOnAction(e->{
				c.setCenterX(c.getCenterX()+20);
			});
			root.getChildren().add(c);
			root.setBottom(cont);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Activity 1");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	class downhandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			c.setCenterY(c.getCenterY()+20);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
