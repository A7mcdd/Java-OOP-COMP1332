package Labs.Lab13.application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Act2 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			TextField tf = new TextField();
			HBox h1 = new HBox(10);
			h1.setAlignment(Pos.CENTER);
			h1.getChildren().addAll(new Label("Enter a number:"),tf);

			TextArea ta = new TextArea();
			ta.setEditable(false);

			Button sort = new Button("Sort");
			Button shuf = new Button("Suffle");
			Button rev = new Button("Reverse");
			HBox h2 = new HBox(10);
			h2.setAlignment(Pos.CENTER);
			h2.getChildren().addAll(sort,shuf,rev);

			root.setTop(h1);
			root.setCenter(ta);
			root.setBottom(h2);
			root.setPadding(new Insets(5));

			tf.setOnAction(e->{
				try {
					int num = Integer.parseInt(tf.getText().trim());
					ta.setText(ta.getText()+num+" ");
					tf.setText("");}catch (Exception e1) {}
			});
			sort.setOnAction(e->{
				String Stnums[] = ta.getText().split(" ");
				ArrayList<Integer> nums = new ArrayList<>();
				for (int i = 0; i < Stnums.length; i++) {
					nums.add(Integer.parseInt(Stnums[i]));
				}
				Collections.sort(nums);
				ta.setText("");
				for (int i = 0; i < nums.size(); i++) {
					ta.setText(ta.getText()+nums.get(i)+" ");
				}
			});
			shuf.setOnAction(e->{
				String Stnums[] = ta.getText().split(" ");
				ArrayList<Integer> nums = new ArrayList<>();
				for (int i = 0; i < Stnums.length; i++) {
					nums.add(Integer.parseInt(Stnums[i]));
				}
				Collections.shuffle(nums);
				ta.setText("");
				for (int i = 0; i < nums.size(); i++) {
					ta.setText(ta.getText()+nums.get(i)+" ");
				}
			});
			rev.setOnAction(e->{
				String Stnums[] = ta.getText().split(" ");
				ArrayList<Integer> nums = new ArrayList<>();
				for (int i = 0; i < Stnums.length; i++) {
					nums.add(Integer.parseInt(Stnums[i]));
				}
				Collections.reverse(nums);
				ta.setText("");
				for (int i = 0; i < nums.size(); i++) {
					ta.setText(ta.getText()+nums.get(i)+" ");
				}
			});
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
