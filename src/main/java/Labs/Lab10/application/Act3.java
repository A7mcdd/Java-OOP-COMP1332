package Labs.Lab10.application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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


public class Act3 extends Application {
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
			
			TextArea tx = new TextArea();
			
			Button save = new Button("Save");
			HBox hbox2 = new HBox(10);
			hbox2.getChildren().add(save);
			hbox2.setAlignment(Pos.CENTER);
			
			root.setTop(hbox1);
			root.setCenter(tx);
			root.setBottom(hbox2);
			
			save.setOnAction(e->{
				File file = new File(tf.getText());
				try {
					PrintWriter pw = new PrintWriter(file);
					pw.write(tx.getText());
					pw.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
			
			load.setOnAction(e->{
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
