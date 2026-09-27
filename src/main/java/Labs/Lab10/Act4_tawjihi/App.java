package Labs.Lab10.Act4_tawjihi;


import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class App extends Application {
	int page;
	@Override
	public void start(Stage primaryStage) {
		try {

			GridPane gp = new GridPane();
			gp.setVgap(10);
			gp.setHgap(10);
			gp.setPadding(new Insets(20));
			gp.setAlignment(Pos.CENTER);

			TextField id = new TextField();
			id.setMaxWidth(100);
			TextField name = new TextField();
			RadioButton genderM = new RadioButton("M");
			RadioButton genderF = new RadioButton("F");
			ToggleGroup tg = new ToggleGroup();
			genderF.setToggleGroup(tg);
			genderM.setToggleGroup(tg);


			HBox gender = new HBox(10);
			gender.getChildren().addAll(genderM,genderF);
			gp.add(new Label("ID:"), 0, 0);
			gp.add(id, 1, 0);
			gp.add(new Label("Name:"), 2, 0);
			gp.add(name, 3, 0);
			gp.add(new Label("Gender:"), 4, 0);
			gp.add(gender, 5, 0);

			TextField seatnum = new TextField();
			seatnum.setMaxWidth(100);

			ComboBox<String> branch = new ComboBox<String>();
			branch.getItems().addAll("Scientific","Literary");

			gp.add(new Label("Seat Num:"), 0, 1);
			gp.add(seatnum, 1, 1);
			gp.add(new Label("Branch:"), 2, 1);
			gp.add(branch, 3, 1);


			ComboBox<String> year = new ComboBox<>();
			year.getItems().addAll("2018","2019","2020","2021","2022","2023","2024","2025","2026");
			year.setMaxWidth(100);
			TextField school = new TextField();
			gp.add(new Label("Year:"), 0, 2);
			gp.add(year, 1, 2);
			gp.add(new Label("School:"), 2, 2);
			gp.add(school, 3, 2);




			
			ImageView pic = new ImageView("Avtar0.jpg");
			pic.setFitWidth(230);
			pic.setPreserveRatio(true);

			TextArea grades = new TextArea();

			GridPane info = new GridPane();
			info.setHgap(30);
			info.setAlignment(Pos.CENTER);
			info.add(grades,0,0);
			info.add(pic,1,0);
			info.setPrefHeight(300);

			Label avarge = new Label("Average = 93%");
			avarge.setFont(Font.font("Arial",FontWeight.BOLD,30));
			HBox havg = new HBox();
			havg.setAlignment(Pos.CENTER);
			havg.getChildren().add(avarge);

			Button next = new Button("Next");
			Button prior = new Button("Prior");
			HBox h4 = new HBox(10);
			h4.setAlignment(Pos.CENTER);
			h4.getChildren().addAll(prior,next);


			VBox vbox = new VBox();
			vbox.getChildren().addAll(gp,info,havg,h4);

			ArrayList<Tawjihi> students = Driver.loadStudent();
			
			id.setEditable(false);
			name.setEditable(false);
			seatnum.setEditable(false);
			school.setEditable(false);
			grades.setEditable(false);
			
			//fill first
			page=0;
			students.get(page);
			id.setText(students.get(page).getID()+"");
			name.setText(students.get(page).getName());
			if(students.get(page).getGender()=='M')
				genderM.setSelected(true);
			if(students.get(page).getGender()=='F')
				genderF.setSelected(true);
			seatnum.setText(students.get(page).getSeatingNum()+"");
			if(students.get(page) instanceof Scientific)
				branch.getSelectionModel().select(0);
			if(students.get(page) instanceof Literary)
				branch.getSelectionModel().select(1);
			year.setValue(students.get(page).getYear()+"");
			school.setText(students.get(page).getSchool());
			grades.setText(students.get(page).getSubjects().toString());
			avarge.setText("Average = "+students.get(page).calculateAverage()+"%");
			pic.setImage(new Image("Avtar"+page+".jpg"));
			System.out.println("page: "+page);
			next.setOnAction(e->{
				if(page<students.size()-1) {
					page++;
				students.get(page);
				id.setText(students.get(page).getID()+"");
				name.setText(students.get(page).getName());
				if(students.get(page).getGender()=='M')
					genderM.setSelected(true);
				if(students.get(page).getGender()=='F')
					genderF.setSelected(true);
				seatnum.setText(students.get(page).getSeatingNum()+"");
				if(students.get(page) instanceof Scientific)
					branch.getSelectionModel().select(0);
				if(students.get(page) instanceof Literary)
					branch.getSelectionModel().select(1);
				year.setValue(students.get(page).getYear()+"");
				school.setText(students.get(page).getSchool());
				grades.setText(students.get(page).getSubjects().toString());
				avarge.setText("Average = "+students.get(page).calculateAverage()+"%");
				pic.setImage(new Image("Avtar"+page+".jpg"));

				System.out.println("page: "+page);
				}
			});
			prior.setOnAction(e->{
				if(page>0) {
				page--;
				students.get(page);
				id.setText(students.get(page).getID()+"");
				name.setText(students.get(page).getName());
				if(students.get(page).getGender()=='M')
					genderM.setSelected(true);
				if(students.get(page).getGender()=='F')
					genderF.setSelected(true);
				seatnum.setText(students.get(page).getSeatingNum()+"");
				if(students.get(page) instanceof Scientific)
					branch.getSelectionModel().select(0);
				if(students.get(page) instanceof Literary)
					branch.getSelectionModel().select(1);
				year.setValue(students.get(page).getYear()+"");
				school.setText(students.get(page).getSchool());
				grades.setText(students.get(page).getSubjects().toString());
				avarge.setText("Average = "+students.get(page).calculateAverage()+"%");
				pic.setImage(new Image("Avtar"+page+".jpg"));
				System.out.println("page: "+page);
				}
			});
			
			vbox.setPadding(new Insets(10));
			Scene scene = new Scene(vbox,700,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tawjihi Editor");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
