package Labs.Lab07.application;


import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class Act3 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
			String[] month = {"January" , "February" , "March" , "April" , "May" , "June" , "July" , "August" , "September" , "October" , "November" , "December"};
			Calendar today = new GregorianCalendar();
			Calendar cal = new GregorianCalendar(today.get(Calendar.YEAR),today.get(Calendar.MONTH),1);
			int firstDay = cal.get(Calendar.DAY_OF_WEEK);
			int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

			Label monthyear = new Label(month[cal.get(Calendar.MONTH)]+","+cal.get(Calendar.YEAR));
			HBox h1 = new HBox();
			h1.getChildren().add(monthyear);
			h1.setAlignment(Pos.CENTER);
			root.setTop(h1);
			
			GridPane gp = new GridPane();
			gp.setHgap(10);
			gp.setVgap(10);
			gp.setAlignment(Pos.CENTER);
			
			for (int i = 0; i < days.length; i++) {
					Label l = new Label(""+days[i]);
					gp.add(l, i, 0);
			}
			
			int col = firstDay-1;
			int row = 1;
			for (int i = 1; i <= daysInMonth; i++) {
					Label l = new Label(""+i);
					gp.add(l, col, row);
					col++;
					if (col==7) {
						col=0;
						row++;
					}
					
				
			}

			Button next = new Button("Next");
			Button prior = new Button("Prior");
			HBox h2 = new HBox(10);
			h2.getChildren().addAll(prior,next);
			h2.setAlignment(Pos.CENTER);
			root.setBottom(h2);

			root.setCenter(gp);
			Scene scene = new Scene(root,400,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Calendar");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
