package Labs.Lab06.application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class Act1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			ImageView iv = new ImageView("Shireen_Abu_Akleh.jpg");
			iv.setFitWidth(400);
			iv.setFitHeight(500);
			
			root.setCenter(iv);
			Scene scene = new Scene(root,400,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Activity 1");
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
