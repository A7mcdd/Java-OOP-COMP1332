package Labs.Lab12.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;


public class Act2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Scene scene = new Scene(root,600,600);

			
			Circle c1 = new Circle(15);
			c1.setCenterX(250);c1.setCenterY(300);
			c1.setFill(Color.GREEN);
			c1.setStroke(Color.BLACK); c1.setStrokeWidth(2);
			Circle c2 = new Circle(15);
			c2.setCenterX(300);c2.setCenterY(250);
			c2.setFill(Color.RED);
			c2.setStroke(Color.BLACK); c2.setStrokeWidth(2);
			Circle c3 = new Circle(15);
			c3.setCenterX(350);c3.setCenterY(200);
			c3.setFill(Color.YELLOW);
			c3.setStroke(Color.BLACK); c3.setStrokeWidth(2);

			Line line = new Line(25,550,575,550);
			root.getChildren().addAll(c1,c2,c3,line);

			double endLine= line.getEndY()-20;

			Thread move1 = new Thread(new Ball(c1,c1.getCenterY(),endLine));
			Thread move2 = new Thread(new Ball(c2,c2.getCenterY(),endLine));
			Thread move3 = new Thread(new Ball(c3,c3.getCenterY(),endLine));
			move2.start();
			move3.start();
			move1.start();


			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Activity 2 (3 bouncing balls)");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	class Ball implements Runnable{
		Circle c ;
		double bottomLimit,topLimit;
		boolean moveDown = true;
		Ball(Circle c ,double topLimit,double bottomLimit){
			this.c = c;
			this.topLimit = topLimit;
			this.bottomLimit = bottomLimit;
		}
		@Override
		public void run() {
			while (true) {
				Platform.runLater(()->{
					if(moveDown) {
						c.setCenterY(c.getCenterY()+10);
						if (c.getCenterY()>=bottomLimit)
							moveDown = false;
					}
					else {
						c.setCenterY(c.getCenterY()-10);
						if (c.getCenterY()<=topLimit)
							moveDown = true;
					}


				});
				try {Thread.sleep(40);} catch (InterruptedException e) {}
			}
		}
	}
}
