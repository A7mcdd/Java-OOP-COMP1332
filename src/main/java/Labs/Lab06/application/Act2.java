package Labs.Lab06.application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;


public class Act2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane shape = new Pane();
			
			Circle c = new Circle(200,200,100);
			c.setFill(Color.WHITE);
			c.setStroke(Color.BLACK);
			
			Polygon triangle = new Polygon(
					200,170,
					180,210,
					220,210);
			triangle.setFill(Color.WHITE);
			triangle.setStroke(Color.BLACK);
			
			Ellipse e1 = new Ellipse(160,160,25,18);
			e1.setFill(Color.WHITE);
			e1.setStroke(Color.BLACK);
			
			Ellipse e2 = new Ellipse(240,160,25,18);
			e2.setFill(Color.WHITE);
			e2.setStroke(Color.BLACK);
			
			Circle c1 = new Circle(160,160,12);
			Circle c2 = new Circle(240,160,12);
			
			Arc a = new Arc(200,250,50,20,-180,180);
			a.setFill(Color.WHITE);
			a.setStroke(Color.BLACK);
			Text l = new Text(150,320,"Mamoun Nawahdah");

			shape.getChildren().addAll(c,triangle,e1,e2,c1,c2,a,l);
			
			Scene scene = new Scene(shape,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Mamoun");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
