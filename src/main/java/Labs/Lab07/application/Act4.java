package Labs.Lab07.application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Act4 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gp = new GridPane();
			gp.setVgap(10);
			gp.setHgap(10);
			gp.setPadding(new Insets(20));
			gp.setAlignment(Pos.CENTER);
			
			TextField id = new TextField();
			id.setMaxWidth(100);
			TextField name = new TextField();
			TextField gender = new TextField();
			gender.setMaxWidth(30);
			gp.add(new Label("ID:"), 0, 0);
			gp.add(id, 1, 0);
			gp.add(new Label("Name:"), 2, 0);
			gp.add(name, 3, 0);
			gp.add(new Label("Gender:"), 4, 0);
			gp.add(gender, 5, 0);
			
			TextField seatnum = new TextField();
			seatnum.setMaxWidth(100);
			TextField branch = new TextField();
			gp.add(new Label("Seat Num:"), 0, 1);
			gp.add(seatnum, 1, 1);
			gp.add(new Label("Branch:"), 2, 1);
			gp.add(branch, 3, 1);
			
			
			TextField year = new TextField();
			year.setMaxWidth(100);
			TextField school = new TextField();
			gp.add(new Label("Year:"), 0, 2);
			gp.add(year, 1, 2);
			gp.add(new Label("School:"), 2, 2);
			gp.add(school, 3, 2);

			
			
			
			
			ImageView pic = new ImageView("Avtar.jpg");
			pic.setFitWidth(230);
			pic.setFitHeight(300);
			
			GridPane grades = new GridPane();
			grades.setHgap(10);
			grades.add(new Label("Math"), 0, 0);
			grades.add(new Label("Mandatory"), 1, 0);
			grades.add(new Label("185/200"), 2, 0);
			
			grades.add(new Label("English"), 0, 1);
			grades.add(new Label("Mandatory"), 1, 1);
			grades.add(new Label("94/100"), 2, 1);
			
			grades.add(new Label("Biology"), 0, 2);
			grades.add(new Label("Electivel"), 1, 2);
			grades.add(new Label("95/100"), 2, 2);
			
			grades.add(new Label("Chemistry"), 0, 3);
			grades.add(new Label("Electivel"), 1, 3);
			grades.add(new Label("88/100"), 2, 3);
			grades.setAlignment(Pos.CENTER);
			
			GridPane info = new GridPane();
			info.setHgap(30);
			info.setAlignment(Pos.CENTER);
			info.add(grades,0,0);
			info.add(pic,1,0);
			
			Label avarge = new Label("Average = 93%");
			avarge.setFont(Font.font("Arial",FontWeight.BOLD,30));
			HBox havg = new HBox();
			havg.setAlignment(Pos.CENTER);
			havg.getChildren().add(avarge);
			
			Button next = new Button("Next");
			Button prior = new Button("Prior");
			HBox h4 = new HBox(10);
			h4.setAlignment(Pos.CENTER);
			h4.getChildren().addAll(prior,next);
			
			
			VBox vbox = new VBox(10);
			vbox.getChildren().addAll(gp,info,havg,h4);
			
			
			Scene scene = new Scene(vbox,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tawjihi Editor");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
