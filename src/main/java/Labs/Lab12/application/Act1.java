package Labs.Lab12.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;


public class Act1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Scene scene = new Scene(root,600,600);

			Circle c = new Circle(15);
			c.setLayoutX(scene.getWidth()/2);c.setLayoutY(scene.getHeight()/2);
			c.setFill(Color.RED);
			c.setStroke(Color.BLACK); c.setStrokeWidth(2);
			Line line = new Line(25,550,575,550);
			root.getChildren().addAll(c,line);

			Thread ball = new Ball(c,300,520);
			ball.setDaemon(true);// هون لو صار تعليق بالرام وهيك بقتل الثريد لاني سويت شي غلط خلاه يعلق
			ball.start();

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Activity 1 (1 bouncing balls)");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	class Ball extends Thread{
		Circle c ;
		double goDown,goUp,bottomLimit,topLimit;
		Ball(Circle c ,double topLimit,double bottomLimit){
			this.c = c;
			this.topLimit = topLimit;
			this.bottomLimit = bottomLimit;
			goDown = topLimit;
			goUp = bottomLimit;
		}
		@Override
		public void run() {
			while (true) {
				Platform.runLater(()->{
					if(goDown<=bottomLimit) {
						c.setCenterY(c.getCenterY()+10);
						if (goDown>=bottomLimit) {
							goUp = bottomLimit;
						}
						goDown+=10;
					}
					else if (goUp>=topLimit){
						c.setCenterY(c.getCenterY()-10);
						if (goUp<=topLimit)
							goDown =topLimit;
						goUp-=10;
					}


				});
				try {Thread.sleep(50);} catch (InterruptedException e) {}
			}
		}
	}
}
