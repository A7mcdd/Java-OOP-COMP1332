package Labswork.Labwork_07.application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {

	static final Text text=new Text(250,250,"Java FX Programing");
	@Override
	public void start(Stage primaryStage) {
		try {

			GetBottom getbottom=new GetBottom();
			GetLeft getleft=new GetLeft();
			GetRight getright=new GetRight();
			GetTop gettop=new GetTop();

			BorderPane root = new BorderPane();
			root.setCenter(getCenter());
			root.setBottom(getbottom.getGpane());
			root.setLeft(getleft.getVbox());
			root.setRight(getright.getVbox());
			root.setTop(gettop.getHbox());


			getleft.getRrbtn().setOnAction(e->{
               text.setFill(Color.RED);

			});
			getleft.getGrbtn().setOnAction(e->{
	               text.setFill(Color.GREEN);

				});

			getleft.getBrbtn().setOnAction(e->{

	               text.setFill(Color.BLUE);

				});

			getbottom.getUp().setOnAction(e->{

				text.setY(text.getY()-10);
			});

			getbottom.getRight().setOnAction(e->{

				text.setX(text.getX()+10);
			});

			getbottom.getLeft().setOnAction(e->{

				text.setX(text.getX()-10);
			});

			getbottom.getDown().setOnAction(e->{

				text.setY(text.getY()+10);
			});

			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("My First App");
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Pane getCenter(){

		Pane stackpane=new Pane();
		//Color color=new Color(0.25,0.75,0,1.0);
		Color color=Color.rgb(240, 2, 235, 1.0);


		Font font=Font.font("Ravie", FontWeight.BOLD, FontPosture.ITALIC, 50);

		text.setFont(font);
		text.setFill(color);

		stackpane.getChildren().add(text);

		return stackpane;

	}

}
