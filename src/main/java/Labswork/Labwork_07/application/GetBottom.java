package Labswork.Labwork_07.application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.image.*;

public class GetBottom {

	private GridPane gpane;
	private Button up,down,left,right;

	GetBottom(){
		Font font=new Font(null,25);
		gpane=new GridPane();

		gpane.setHgap(5);
		gpane.setVgap(5);

		up=new Button(null,new ImageView(new Image("up.png")));
		up.setFont(font);

		down=new Button(null,new ImageView(new Image("down.png")));
		down.setFont(font);

		left=new Button(null,new ImageView(new Image("left.png")));
		left.setFont(font);

		right=new Button(null,new ImageView(new Image("right.png")));
		right.setFont(font);

		gpane.add(up, 1, 0);
		gpane.add(down, 1, 2);
		gpane.add(left, 0, 1);
		gpane.add(right, 2, 1);


		gpane.setAlignment(Pos.CENTER);
		gpane.setPadding(new Insets(45));

	}

	public GridPane getGpane() {
		return gpane;
	}

	public Button getUp() {
		return up;
	}

	public Button getDown() {
		return down;
	}

	public Button getLeft() {
		return left;
	}

	public Button getRight() {
		return right;
	}




}
