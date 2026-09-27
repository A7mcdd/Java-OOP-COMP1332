package Labswork.Labwork_08.application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;


public class GetLeft {

	private VBox vbox;
	private ComboBox<String> colors;

	GetLeft(){

		
		vbox=new VBox(10);
		
		colors = new ComboBox<>();
		colors.getItems().addAll("Red", "Green", "Blue");
		colors.setStyle(null);
		
		vbox.getChildren().addAll(colors);
        


		vbox.setAlignment(Pos.CENTER_LEFT);
		vbox.setPadding(new Insets(45));

	}

	public VBox getVbox() {
		return vbox;
	}
	
	public ComboBox<String> getColors(){
		return colors;
	}




}
