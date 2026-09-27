package Labswork.Labwork_08.application;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



public class Main extends Application {
	//
	static final Circle circle = new Circle (250,250,5);
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


			//mouseEvent

			circle.setOnMouseClicked(e->{
				if (e.getButton() == MouseButton.SECONDARY) {
					double r= circle.getRadius()+10;
					if (r>10&&r<200)
					circle.setRadius(r);}
				if (e.getButton() == MouseButton.PRIMARY) {
					double r= circle.getRadius()-10;
					if (r>10&&r<200)
					circle.setRadius(r);}
			});
			//
			getleft.getColors().setOnAction(e -> {
				String color = getleft.getColors().getValue();

				if (color.equals("Red"))
					circle.setFill(Color.RED);
				else if (color.equals("Green"))
					circle.setFill(Color.GREEN);
				else if (color.equals("Blue"))
					circle.setFill(Color.BLUE);

			});
			// اضافي من عندي عشان يحرك الدائرة
			circle.setOnMouseDragged(e -> {
			    circle.setCenterX(e.getX());
			    circle.setCenterY(e.getY());
			});



			getbottom.getUp().setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					circle.setCenterY(circle.getCenterY()-10);
				}
			});

			getbottom.getRight().setOnAction(e->{

				circle.setCenterX(circle.getCenterX()+10);
			});

			getbottom.getLeft().setOnAction(e->{
				circle.setCenterX(circle.getCenterX()-10);
			});

			getbottom.getDown().setOnAction(new MoveDownHandler());

			getright.Getr1().setOnAction(e -> circle.setStrokeWidth(1.5));
			getright.Getr2().setOnAction(e -> circle.setStrokeWidth(2.5));
			getright.Getr3().setOnAction(e -> circle.setStrokeWidth(3.5));

			gettop.getTf().setOnAction(e -> {
				int r = Integer.parseInt(gettop.getTf().getText());
				if (r<10)
					r = 10;
				if (r>200)
					r = 200;
				circle.setRadius(r);
			});

			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Circle App");
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch(Exception e) {
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Pane getCenter(){

		Pane stackpane=new Pane();
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(1);

		stackpane.getChildren().add(circle);

		return stackpane;

	}

	class MoveDownHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			circle.setCenterY(circle.getCenterY()+10);
		}
	}

}
