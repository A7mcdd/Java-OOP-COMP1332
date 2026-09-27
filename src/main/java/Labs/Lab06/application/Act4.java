package Labs.Lab06.application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Act4 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			
			HBox hbox = new HBox(10);
			hbox.setAlignment(Pos.BOTTOM_CENTER);
			
			Rectangle proj = new Rectangle();
			proj.setWidth(70);
			proj.setHeight(40);
			proj.setFill(Color.RED);
			Rectangle quiz = new Rectangle();
			quiz.setWidth(70);
			quiz.setHeight(20);
			quiz.setFill(Color.BLUE);
			Rectangle mid = new Rectangle();
			mid.setWidth(70);
			mid.setHeight(60);
			mid.setFill(Color.GREEN);
			Rectangle finl = new Rectangle();
			finl.setWidth(70);
			finl.setHeight(80);
			finl.setFill(Color.GOLDENROD);
			
			Label l1 = new Label("Project -- 20%",proj);
			l1.setContentDisplay(ContentDisplay.BOTTOM);
			Label l2 = new Label("Quiz -- 10%",quiz);
			l2.setContentDisplay(ContentDisplay.BOTTOM);
			Label l3 = new Label("Midterm -- 30%",mid);
			l3.setContentDisplay(ContentDisplay.BOTTOM);
			Label l4 = new Label("Final -- 40%",finl);
			l4.setContentDisplay(ContentDisplay.BOTTOM);
			
			hbox.getChildren().addAll(l1,l2,l3,l4);
			
			root.setPadding(new Insets(3));
			
			root.setCenter(hbox);
			Scene scene = new Scene(root,400,160);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Display a bar chart");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
