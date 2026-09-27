package Labswork.Labwork_07.application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GetRight {
	private VBox vbox;
	private CheckBox italic,bold;

	GetRight(){
		Font font=new Font(null,25);

		vbox=new VBox(10);
		italic=new CheckBox("Italic");
		italic.setFont(font);

		bold=new CheckBox("Bold");
		bold.setFont(font);

		vbox.getChildren().addAll(italic, bold);

		vbox.setAlignment(Pos.CENTER_LEFT);
		vbox.setPadding(new Insets(45));

	}

	public VBox getVbox() {
		return vbox;
	}

	public CheckBox getItalic() {
		return italic;
	}

	public CheckBox getBold() {
		return bold;
	}


}
