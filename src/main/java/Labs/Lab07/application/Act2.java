package Labs.Lab07.application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class Act2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			root.setPadding(new Insets(10));
			TextField tf = new TextField();
			Label label = new Label("FileName: ");
			Button load = new Button("Load");
			HBox hbox1 = new HBox(10);
			hbox1.getChildren().addAll(label,tf,load);
			hbox1.setAlignment(Pos.CENTER);
			
			Text tx = new Text("I like JavaFX!!!");
			
			Button save = new Button("Save");
			HBox hbox2 = new HBox(10);
			hbox2.getChildren().add(save);
			hbox2.setAlignment(Pos.CENTER);
			
			root.setTop(hbox1);
			root.setCenter(tx);
			root.setBottom(hbox2);
			
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("File Editor Interface");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
