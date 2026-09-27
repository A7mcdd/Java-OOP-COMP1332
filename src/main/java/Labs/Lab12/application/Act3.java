package Labs.Lab12.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;


public class Act3 extends Application {
	Boolean Running;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			ImageView car = new ImageView("Car.png");
			car.setFitWidth(200);
			car.setPreserveRatio(true);
			car.setX(50);car.setY(200);
			Button start = new Button("Start");
			Button stop = new Button("Stop");
			HBox h1 = new HBox(10);
			h1.setAlignment(Pos.CENTER);
			h1.getChildren().addAll(start,stop);
			Line line = new Line(0,335,1600,335);
			root.getChildren().addAll(car,line);
			root.setBottom(h1);
			
			start.setOnAction(e->{//lembda
				Running= true;
				Thread t = new Thread ( ()->{
					while(Running) {
						Platform.runLater(()->{
						car.setX(car.getX()+10);
						if(car.getX()>1400)
							car.setX(-200);
						});
						try {Thread.sleep(30);} catch (InterruptedException e1) {}
					}
				});
				t.start();
			});
			stop.setOnAction(e->{
				Running = false;
			});
			

			Scene scene = new Scene(root,1400,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
