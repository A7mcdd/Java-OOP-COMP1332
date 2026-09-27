package Quizzes.Quiz3.application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			root.setPadding(new Insets(20));


			//
			GridPane inpts = new GridPane();
			inpts.setAlignment(Pos.CENTER);
			inpts.setHgap(10);


			TextField Tnum = new TextField();
			TextField Rnum = new TextField();
			Tnum.setEditable(false);
			Rnum.setEditable(false);
			Tnum.setText("");
			Rnum.setText("");

			RadioButton RBbin = new RadioButton();
			RadioButton RBdec = new RadioButton();
			RadioButton RBhex = new RadioButton();
			VBox v1 = new VBox(10);
			v1.getChildren().addAll(new Label("Binary",RBbin),new Label("Decimal",RBdec),new Label("Hexdecimal",RBhex));

			ToggleGroup tg = new ToggleGroup();
			RBbin.setToggleGroup(tg);
			RBdec.setToggleGroup(tg);
			RBhex.setToggleGroup(tg);

			inpts.add(new Label("Number"), 0, 0);
			inpts.add(Tnum, 1, 0);
			inpts.add(new Label("Result"), 0, 1);
			inpts.add(Rnum, 1, 2);

			HBox h1 = new HBox(10);
			h1.getChildren().addAll(inpts,v1);

			//
			GridPane btns = new GridPane();
			btns.setHgap(10);
			btns.setVgap(10);
			btns.setPadding(new Insets(20));

			Button cnvBin = new Button("Convert to Binary");
			Button cnvDec = new Button("Convert to Decimal");
			Button cnvHex = new Button("Convert to Hexdecimal");
			Button Clear = new Button("Clear");
			cnvBin.setPrefWidth(140);
			cnvDec.setPrefWidth(140);
			cnvHex.setPrefWidth(140);
			Clear.setPrefWidth(140);

			Button b0 = new Button("0");
			Button b1 = new Button("1");
			Button b2 = new Button("2");
			Button b3 = new Button("3");
			Button b4 = new Button("4");
			Button b5 = new Button("5");
			Button b6 = new Button("6");
			Button b7 = new Button("7");
			Button b8 = new Button("8");
			Button b9 = new Button("9");
			Button bA = new Button("A");
			Button bB = new Button("B");
			Button bC = new Button("C");
			Button bD = new Button("D");
			Button bE = new Button("E");
			Button bF = new Button("F");

			btns.add(b0, 0, 0);
			btns.add(b1, 1, 0);
			btns.add(b2, 2, 0);
			btns.add(b3, 3, 0);
			btns.add(cnvBin, 4, 0);
			btns.add(b4, 0, 1);
			btns.add(b5, 1, 1);
			btns.add(b6, 2, 1);
			btns.add(b7, 3, 1);
			btns.add(cnvDec, 4, 1);
			btns.add(b8, 0, 2);
			btns.add(b9, 1, 2);
			btns.add(bA, 2, 2);
			btns.add(bB, 3, 2);
			btns.add(cnvHex, 4, 2);
			btns.add(bC, 0, 3);
			btns.add(bD, 1, 3);
			btns.add(bE, 2, 3);
			btns.add(bF, 3, 3);
			btns.add(Clear, 4, 3);

			b0.setOnAction(e->{Tnum.setText(Tnum.getText()+"0");});
			b1.setOnAction(e->{Tnum.setText(Tnum.getText()+"1");});
			b2.setOnAction(e->{Tnum.setText(Tnum.getText()+"2");});
			b3.setOnAction(e->{Tnum.setText(Tnum.getText()+"3");});
			b4.setOnAction(e->{Tnum.setText(Tnum.getText()+"4");});
			b5.setOnAction(e->{Tnum.setText(Tnum.getText()+"5");});
			b6.setOnAction(e->{Tnum.setText(Tnum.getText()+"6");});
			b7.setOnAction(e->{Tnum.setText(Tnum.getText()+"7");});
			b8.setOnAction(e->{Tnum.setText(Tnum.getText()+"8");});
			b9.setOnAction(e->{Tnum.setText(Tnum.getText()+"9");});
			bA.setOnAction(e->{Tnum.setText(Tnum.getText()+"A");});
			bB.setOnAction(e->{Tnum.setText(Tnum.getText()+"B");});
			bC.setOnAction(e->{Tnum.setText(Tnum.getText()+"C");});
			bD.setOnAction(e->{Tnum.setText(Tnum.getText()+"D");});
			bE.setOnAction(e->{Tnum.setText(Tnum.getText()+"E");});
			bF.setOnAction(e->{Tnum.setText(Tnum.getText()+"F");});


			cnvBin.setOnAction(e->{
				if(Tnum.getText().equals(""))
					Tnum.setText("0");
				Long num = (long) 0;
				if(RBbin.isSelected()) {num = Long.parseLong(Tnum.getText(),2);}
				if(RBdec.isSelected()) {num = Long.parseLong(Tnum.getText(),10);}
				if(RBhex.isSelected()) {num = Long.parseLong(Tnum.getText(),16);}
				Rnum.setText(Long.toBinaryString(num));
			});
			cnvDec.setOnAction(e->{
				if(Tnum.getText().equals(""))
					Tnum.setText("0");
				Long num = (long) 0;
				if(RBbin.isSelected()) {num = Long.parseLong(Tnum.getText(),2);}
				if(RBdec.isSelected()) {num = Long.parseLong(Tnum.getText(),10);}
				if(RBhex.isSelected()) {num = Long.parseLong(Tnum.getText(),16);}
				Rnum.setText(num+"");
			});
			cnvHex.setOnAction(e->{
				if(Tnum.getText().equals(""))
					Tnum.setText("0");
				Long num = (long) 0;
				if(RBbin.isSelected()) {num = Long.parseLong(Tnum.getText(),2);}
				if(RBdec.isSelected()) {num = Long.parseLong(Tnum.getText(),10);}
				if(RBhex.isSelected()) {num = Long.parseLong(Tnum.getText(),16);}
				Rnum.setText(Long.toHexString(num).toUpperCase());
			});



			Clear.setOnAction(e->{
				Tnum.setText("");
				Rnum.setText("");
			});

			RBbin.setOnAction(e->{
				if(RBbin.isSelected()){
					Tnum.setText("");
					Rnum.setText("");
					b2.setDisable(true);
					b3.setDisable(true);
					b4.setDisable(true);
					b5.setDisable(true);
					b6.setDisable(true);
					b7.setDisable(true);
					b8.setDisable(true);
					b9.setDisable(true);
					bA.setDisable(true);
					bB.setDisable(true);
					bC.setDisable(true);
					bD.setDisable(true);
					bE.setDisable(true);
					bF.setDisable(true);
				}
			});
			RBdec.setOnAction(e->{
				if(RBdec.isSelected()){
					Tnum.setText("");
					Rnum.setText("");
					b2.setDisable(false);
					b3.setDisable(false);
					b4.setDisable(false);
					b5.setDisable(false);
					b6.setDisable(false);
					b7.setDisable(false);
					b8.setDisable(false);
					b9.setDisable(false);
					bA.setDisable(true);
					bB.setDisable(true);
					bC.setDisable(true);
					bD.setDisable(true);
					bE.setDisable(true);
					bF.setDisable(true);
				}
			});
			RBhex.setOnAction(e->{
				if(RBhex.isSelected()){
					Tnum.setText("");
					Rnum.setText("");
					b2.setDisable(false);
					b3.setDisable(false);
					b4.setDisable(false);
					b5.setDisable(false);
					b6.setDisable(false);
					b7.setDisable(false);
					b8.setDisable(false);
					b9.setDisable(false);
					bA.setDisable(false);
					bB.setDisable(false);
					bC.setDisable(false);
					bD.setDisable(false);
					bE.setDisable(false);
					bF.setDisable(false);
				}
			});



			RBhex.setSelected(true);
			root.setTop(h1);
			root.setCenter(btns);
			Scene scene = new Scene(root,400,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Number Systems Converter");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
