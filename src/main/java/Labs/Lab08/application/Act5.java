package Labs.Lab08.application;



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Act5 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			CalnderNode cn = new CalnderNode();

			root.setCenter(cn);
			Scene scene = new Scene(root,400,300);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Calendar");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
