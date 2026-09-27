package Labs.Lab13.application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Act3 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			root.setPadding(new Insets(10));
			TextField tf = new TextField();
			Label label = new Label("FileName: ");
			HBox hbox1 = new HBox(10);
			hbox1.getChildren().addAll(label,tf);
			hbox1.setAlignment(Pos.CENTER);
			
			TextArea tx = new TextArea();
			tx.setEditable(false);
			
			Button check = new Button("Check");
			
			Label isCorect = new Label("");
			VBox hbox2 = new VBox(10);
			hbox2.getChildren().addAll(check,isCorect);
			hbox2.setAlignment(Pos.CENTER);
			
			root.setTop(hbox1);
			root.setCenter(tx);
			root.setBottom(hbox2);
			
			
			tf.setOnAction(e->{
				File file = new File(tf.getText());
				try {
					Scanner sc = new Scanner(file);
					String lines="";
					while (sc.hasNextLine())
						lines = lines + sc.nextLine()+"\n";
					tx.setText(lines);
					sc.close();
				} catch (FileNotFoundException e1) {
				new Alert(Alert.AlertType.ERROR, "file doesn't exist").showAndWait();
				}
			});
			
			check.setOnAction(e->{
				String name = tf.getText();

				File file = new File(name);

				StringBuilder code = new StringBuilder();
				
				Scanner rf;
				try {
					rf = new Scanner(file);
					while (rf.hasNextLine()) {
						code.append(rf.nextLine());
					}
					rf.close();
					if(Act3Console.isVaildCode(code.toString())) {
						isCorect.setTextFill(Color.GREEN);
						isCorect.setText("The file has correct pairs of grouping symbols");}
					else {
						isCorect.setTextFill(Color.RED);
						isCorect.setText("The file has not correct pairs of grouping symbols");}
				} catch (FileNotFoundException e1) {
					isCorect.setTextFill(Color.RED);
					isCorect.setText("The file is not exist");
				}
			});
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("File Editor");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
