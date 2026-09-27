package Labswork.Labwork_07.application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GetLeft {

	private VBox vbox;
	private RadioButton rrbtn,grbtn,brbtn;

	GetLeft(){
		Font font=new Font(null,25);
		
		vbox=new VBox(10);
		rrbtn=new RadioButton("Red");
		rrbtn.setFont(font);
		
		grbtn=new RadioButton("Green");
		grbtn.setFont(font);
		
		brbtn=new RadioButton("Blue");
		brbtn.setFont(font);
		
		vbox.getChildren().addAll(rrbtn,grbtn,brbtn);

        ToggleGroup tg= new ToggleGroup();
        rrbtn.setToggleGroup(tg);
        grbtn.setToggleGroup(tg);
        brbtn.setToggleGroup(tg);
        

		vbox.setAlignment(Pos.CENTER_LEFT);
		vbox.setPadding(new Insets(45));

	}

	public VBox getVbox() {
		return vbox;
	}

	public RadioButton getRrbtn() {
		return rrbtn;
	}

	public RadioButton getGrbtn() {
		return grbtn;
	}

	public RadioButton getBrbtn() {
		return brbtn;
	}



}
