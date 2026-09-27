package Labs.Lab10.application;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;


public class Act1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FlowPane fp = new FlowPane();
			fp.setOrientation(Orientation.VERTICAL);
			fp.setMaxHeight(290);
			fp.setMaxWidth(100);
			fp.setPadding(new Insets(20,20,20,20));
			fp.setVgap(20);
			fp.setStyle("-fx-background-color : white; -fx-border-color : black; -fx-border-width : 2");

			BorderPane root = new BorderPane();
			root.setCenter(fp);

			CheckBox red = new CheckBox("Red");
			CheckBox yellow = new CheckBox("Yellow");
			CheckBox green = new CheckBox("Green");
			red.setFont(new Font(15));
			yellow.setFont(new Font(15));
			green.setFont(new Font(15));

			HBox hb = new HBox();
			hb.setAlignment(Pos.CENTER);
			hb.getChildren().addAll(red,yellow,green);

			Circle rc = new Circle(30);
			Circle yc = new Circle(30);
			Circle gc = new Circle(30);
			rc.setStyle("-fx-fill : white; -fx-stroke : black; -fx-stroke-width : 4");
			yc.setStyle("-fx-fill : white; -fx-stroke : black; -fx-stroke-width : 4");
			gc.setStyle("-fx-fill : white; -fx-stroke : black; -fx-stroke-width : 4");
			fp.getChildren().addAll(rc,yc,gc);

			red.setOnAction(e -> {
				if (red.isSelected())
					rc.setFill(Color.RED);
				if (!red.isSelected())
					rc.setFill(Color.WHITE);
			});
			yellow.setOnAction(e -> {
				if (yellow.isSelected())
					yc.setFill(Color.YELLOW);
				if (!yellow.isSelected())
					yc.setFill(Color.WHITE);
			});
			green.setOnAction(e -> {
				if (green.isSelected())
					gc.setFill(Color.GREEN);
				if (!green.isSelected())
					gc.setFill(Color.WHITE);
			});




			root.setBottom(hb);

			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Activity 1");
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
