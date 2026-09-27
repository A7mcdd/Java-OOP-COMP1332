package Labs.Lab09.application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class Act4 extends Application {
	double distX,distY,dist;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			Circle c1 = new Circle(10);
			c1.setFill(Color.WHITE);
			c1.setStroke(Color.BLACK);
			c1.setCenterX(40);c1.setCenterY(40);
			Circle c2 = new Circle(10);
			c2.setFill(Color.WHITE);
			c2.setStroke(Color.BLACK);
			c2.setCenterX(120);c2.setCenterY(150);

			Line li = new Line(c1.getCenterX(),c1.getCenterY(),c2.getCenterX(),c2.getCenterY());
			distX = Math.abs((int)c2.getCenterX()+(int)c1.getCenterX());
			distY =Math.abs((int)c2.getCenterY()+(int)c1.getCenterY());;
			dist =(Math.sqrt(Math.pow((int)distX,2)+Math.pow((int)distY,2)));

			Text distLb = new Text((int)dist+"");
			distLb.setX(distX/2);
			distLb.setY(distY/2);

			root.getChildren().addAll(li,c1,c2,distLb);
			
			c1.setOnMouseDragged(e->{
				c1.setCenterX(e.getX());c1.setCenterY(e.getY());
				
				distX = Math.abs((int)c2.getCenterX()+(int)c1.getCenterX());
				distY =Math.abs((int)c2.getCenterY()+(int)c1.getCenterY());
				dist =(Math.sqrt(Math.pow((int)distX,2)+Math.pow((int)distY,2)));
				distLb.setX(distX/2);
				distLb.setY(distY/2);
				distLb.setText((int)dist+"");
				
				li.setStartX(c1.getCenterX());
				li.setStartY(c1.getCenterY());
				li.setEndX(c2.getCenterX());
				li.setEndY(c2.getCenterY());
			});

			c2.setOnMouseDragged(e->{
				c2.setCenterX(e.getX());c2.setCenterY(e.getY());
				
				distX = Math.abs((int)c2.getCenterX()+(int)c1.getCenterX());
				distY =Math.abs((int)c2.getCenterY()+(int)c1.getCenterY());
				dist =(Math.sqrt(Math.pow((int)distX,2)+Math.pow((int)distY,2)));
				distLb.setX(distX/2);
				distLb.setY(distY/2);
				distLb.setText((int)dist+"");
				
				li.setStartX(c1.getCenterX());
				li.setStartY(c1.getCenterY());
				li.setEndX(c2.getCenterX());
				li.setEndY(c2.getCenterY());
			});
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Activity 4");
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
