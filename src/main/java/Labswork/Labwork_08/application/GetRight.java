package Labswork.Labwork_08.application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
//import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GetRight {
	private VBox vbox;
	private RadioButton r1,r2,r3;

	GetRight(){
		Font font=new Font(null,25);

		vbox=new VBox(10);
		r1 = new RadioButton("1.5");
		r2 = new RadioButton("2.5");
		r3 = new RadioButton("3.5");
		
		r1.setFont(font);
		r2.setFont(font);
		r3.setFont(font);
		
		ToggleGroup tg = new ToggleGroup();
		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		r3.setToggleGroup(tg);
		
		vbox.getChildren().addAll(r1,r2,r3);


		vbox.setAlignment(Pos.CENTER_LEFT);
		vbox.setPadding(new Insets(45));

	}

	public VBox getVbox() {
		return vbox;
	}

	
	public RadioButton Getr1() {
		return r1;
	}
	public RadioButton Getr2() {
		return r2;
	}
	public RadioButton Getr3() {
		return r3;
	}


}

