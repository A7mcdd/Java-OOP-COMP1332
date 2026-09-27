package Labs.Lab08.application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Act2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			VBox vbox = new VBox(20);
			
			TextField t1 = new TextField();
			TextField t2 = new TextField();
			TextField t3 = new TextField();
			t1.setPrefWidth(40);
			t2.setPrefWidth(40);
			t3.setPrefWidth(40);
			
			HBox h1 = new HBox(10);
			h1.getChildren().addAll(new Label("Number 1:"),t1,new Label("Number 2:"),t2,new Label("Result:"),t3);
			h1.setAlignment(Pos.CENTER);
			
			Button add = new Button("Add");
			Button sub = new Button("Subtract");
			Button multi = new Button("Multiply");
			Button divide = new Button("Divide");
			
			HBox h2 = new HBox(2);
			h2.getChildren().addAll(add,sub,multi,divide);
			h2.setAlignment(Pos.CENTER);
			
			vbox.getChildren().addAll(h1,h2);
			vbox.setPadding(new Insets(20));
			root.setCenter(vbox);
			
			
			add.setOnAction(e->{
				double num1 = Integer.valueOf(t1.getText());
				double num2 = Integer.valueOf(t2.getText());
				t3.setText(num1+num2+"");
			});
			sub.setOnAction(e->{
				double num1 = Integer.valueOf(t1.getText());
				double num2 = Integer.valueOf(t2.getText());
				t3.setText(num1-num2+"");
			});
			multi.setOnAction(e->{
				double num1 = Integer.valueOf(t1.getText());
				double num2 = Integer.valueOf(t2.getText());
				t3.setText(num1*num2+"");
			});
			divide.setOnAction(e->{
				double num1 = Integer.valueOf(t1.getText());
				double num2 = Integer.valueOf(t2.getText());
				t3.setText(num1/num2+"");
			});
			
			Scene scene = new Scene(root,400,100);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Activity 2");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
