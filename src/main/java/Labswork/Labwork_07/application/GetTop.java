package Labswork.Labwork_07.application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class GetTop {
	private HBox hbox;
	private Label lb;
	private TextField tf;

	GetTop(){
		Font font=new Font(null,25);

		hbox=new HBox(10);
		lb=new Label("Enter Font Size: ");
		tf=new TextField();
		hbox.getChildren().addAll(lb,tf);
		lb.setFont(font);

		tf.setPrefWidth(350);
		tf.setPrefHeight(35);


		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(45));



	}

	public HBox getHbox() {
		return hbox;
	}

	public Label getLb() {
		return lb;
	}

	public TextField getTf() {
		return tf;
	}



}
