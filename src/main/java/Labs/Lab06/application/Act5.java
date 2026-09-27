package Labs.Lab06.application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;


public class Act5 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			Arc sc = new Arc(200,200,80,80,0,(3.6*35));
			sc.setFill(Color.RED);
			sc.setType(ArcType.ROUND);
			Arc li = new Arc(200,200,80,80,0+(3.6*35),(3.6*55));
			li.setFill(Color.LIGHTBLUE);
			li.setType(ArcType.ROUND);
			Arc other = new Arc(200,200,80,80,0+(3.6*90),(3.6*10));
			other.setFill(Color.DARKGREEN);
			other.setType(ArcType.ROUND);
			
			Text l1 = new Text("Scientific 35%");
			l1.setLayoutX(220);
			l1.setLayoutY(110);
			Text l2 = new Text("Literary 55%");
			l2.setLayoutX(50);
			l2.setLayoutY(220);
			Text l3 = new Text("Others 10%");
			l3.setLayoutX(290);
			l3.setLayoutY(220);
			
			root.getChildren().addAll(sc,li,other,l1,l2,l3);
			
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tawjihi Statistics");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
