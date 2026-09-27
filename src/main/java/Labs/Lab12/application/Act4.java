package Labs.Lab12.application;

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;


public class Act4 extends Application {
	boolean gravityrun = true;
	int r ;
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Scene scene = new Scene(root,1200,700);

			ImageView bird = new ImageView("Bird.png");
			Image lowpipe = new Image("lowerPipe.png");
			Image uppipe = new Image("upperPipe.png");

			ArrayList<ImageView> lp = new ArrayList<>();
			ArrayList<ImageView> up = new ArrayList<>();

			Random rand = new Random();
			for (int i = 0; i < 10; i++) {
				r=rand.nextInt(250);
				lp.add(new ImageView(lowpipe));
				up.add(new ImageView(uppipe));
				lp.get(i).setFitHeight(400+r);
				lp.get(i).setFitWidth(300);
				lp.get(i).setLayoutX(1000+i*300);lp.get(i).setLayoutY(300);
				up.get(i).setFitHeight(300+r);
				up.get(i).setFitWidth(300);
				up.get(i).setLayoutX(1000+i*300);up.get(i).setLayoutY(0);
				root.getChildren().addAll(lp.get(i),up.get(i));
			}



			bird.setFitWidth(80);
			bird.setPreserveRatio(true);
			bird.setLayoutX(400);bird.setLayoutY(300);

			Thread gravity = new Thread(()->{
				while(gravityrun) {
					Platform.runLater(()->{
						for (int i = 0; i < lp.size(); i++) {
							lp.get(i).setLayoutX(lp.get(i).getLayoutX()-10);
							up.get(i).setLayoutX(lp.get(i).getLayoutX()-10);
							if(lp.get(i).getLayoutX()<=-1000) {
								lp.get(i).setLayoutX(2000);
								up.get(i).setLayoutX(2000);
								r=rand.nextInt(250);
								lp.get(i).setFitHeight(400+r);
								up.get(i).setFitHeight(300+r);
							}	
						}
						bird.setLayoutY(bird.getLayoutY()+5);

						if(bird.getLayoutX()>=1200) 
							bird.setLayoutX(-50);

					});
					try {Thread.sleep(60);} catch (InterruptedException e) {}
				}

			});
			gravity.setDaemon(true);
			gravity.start();


			root.getChildren().addAll(bird);

			scene.setOnKeyPressed(e->{
				if (e.getCode()== KeyCode.UP||e.getCode()== KeyCode.W) {
					bird.setLayoutY(bird.getLayoutY()-60);
				}
				if (e.getCode()== KeyCode.DOWN||e.getCode()== KeyCode.S) {
					bird.setLayoutY(bird.getLayoutY()+30);
				}
			});
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Flappy Bird");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
