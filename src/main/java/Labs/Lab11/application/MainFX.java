package Labs.Lab11.application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class MainFX extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ArrayList<Tawjihi> students = DriverConsel.loadStudent();
			ArrayList<Tawjihi> sclist = new ArrayList<Tawjihi>();
			ArrayList<Tawjihi> litlist = new ArrayList<Tawjihi>();
			
			for (Tawjihi s : students) {
				if(s instanceof Scientific)
					sclist.add( s);
				if(s instanceof Literary)
					litlist.add( s);
			}
			
			TawjihiTable sctable = new TawjihiTable(sclist);
			TawjihiTable littable = new TawjihiTable(litlist);
			double sSum=0;
			for (Tawjihi sc : sclist) {
				sSum += sc.calculateAverage();
			}
			sSum/=sclist.size();
			double lSum=0;
			for (Tawjihi li : litlist) {
				lSum += li.calculateAverage();
			}
			lSum/=litlist.size();
			
			Label labelS =new Label("Scientific Average: "+(float)sSum+"%");
			Label labelL =new Label("Literary Average: "+(float)lSum+"%");
			Font font = new Font(25);
			labelS.setFont(font);
			labelL.setFont(font);
			
			VBox vbox = new VBox();
			vbox.getChildren().addAll(labelS,labelL);			
			vbox.setAlignment(Pos.CENTER);
			BorderPane root = new BorderPane();
			
			TabPane tabpane = new TabPane();
			Tab sum = new Tab("Summary");
			Tab sci = new Tab("Scientific");
			Tab lit = new Tab("Literary");
			sum.setClosable(false);
			sci.setClosable(false);
			lit.setClosable(false);
			
			sci.setContent(sctable);
			lit.setContent(littable);
			sum.setContent(vbox);
			
			tabpane.getTabs().setAll(sum,sci,lit);
			root.setTop(tabpane);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Display Tabs");
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
