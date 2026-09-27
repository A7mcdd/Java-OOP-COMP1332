package Labs.Lab09.application;
	

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Act2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			GridPane contrl = new GridPane();
			
			Button up = new Button(null,new ImageView("up.png"));
			Button down = new Button(null,new ImageView("down.png"));
			Button left = new Button(null,new ImageView("left.png"));
			Button right = new Button(null,new ImageView("right.png"));
			
			
			contrl.add(up,1,0);
			contrl.add(left,0,1);
			contrl.add(right,2,1);
			contrl.add(down,1,1);
			contrl.setAlignment(Pos.CENTER);
			contrl.setVgap(1);
			contrl.setHgap(1);
			
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
			up.setOnAction(e->{
				c.setCenterY(c.getCenterY()-15);
			});
			down.setOnAction(e->{
				c.setCenterY(c.getCenterY()+15);
			});
			right.setOnAction(e->{
				c.setCenterX(c.getCenterX()+15);
			});
			left.setOnAction(e->{
				c.setCenterX(c.getCenterX()-15);
			});
			
			root.getChildren().add(c);
			root.setBottom(contrl);
			Scene scene = new Scene(root,1000,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Activity 2");
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
