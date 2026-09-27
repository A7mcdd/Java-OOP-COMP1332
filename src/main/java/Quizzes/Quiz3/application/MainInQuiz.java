package Quizzes.Quiz3.application;

import javafx.application.Application;
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


public class MainInQuiz extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			//
			GridPane inpts = new GridPane();
			inpts.setHgap(10);

			TextField Tnum = new TextField();
			TextField Rnum = new TextField();
			Rnum.setEditable(false);

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

			Button cnvBin = new Button("Convert to Binary");
			Button cnvDec = new Button("Convert to Decimal");
			Button cnvHex = new Button("Convert to Hexdecimal");
			Button Clear = new Button("Clear");

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
				String snum;
				int num = Integer.valueOf(Tnum.getText());
				if(RBdec.isSelected()){
					snum = Integer.toBinaryString(num);
					Rnum.setText(snum);
				}
				if(RBhex.isSelected()){
					snum = Integer.toBinaryString(num);
					Tnum.setText(snum);
				}
			});
			cnvDec.setOnAction(e->{
				String snum;
				int num = Integer.valueOf(Tnum.getText());
				if(RBbin.isSelected()){
					snum = Integer.toOctalString(num);
					Rnum.setText(snum);
				}
				if(RBhex.isSelected()){
					snum = Integer.toOctalString(num);
					Rnum.setText(snum);
				}
			});


			Clear.setOnAction(e->{
				Tnum.setText("");
			});

			RBbin.setOnAction(e->{
				if(RBbin.isSelected()){
					b2.setVisible(false);
					b3.setVisible(false);
					b4.setVisible(false);
					b5.setVisible(false);
					b6.setVisible(false);
					b7.setVisible(false);
					b8.setVisible(false);
					b9.setVisible(false);
					bA.setVisible(false);
					bB.setVisible(false);
					bC.setVisible(false);
					bD.setVisible(false);
					bE.setVisible(false);
					bF.setVisible(false);
				}
			});
			RBdec.setOnAction(e->{
				if(RBdec.isSelected()){
					b2.setVisible(true);
					b3.setVisible(true);
					b4.setVisible(true);
					b5.setVisible(true);
					b6.setVisible(true);
					b7.setVisible(true);
					b8.setVisible(true);
					b9.setVisible(true);
					bA.setVisible(false);
					bB.setVisible(false);
					bC.setVisible(false);
					bD.setVisible(false);
					bE.setVisible(false);
					bF.setVisible(false);
				}
			});
			RBhex.setOnAction(e->{
				if(RBhex.isSelected()){
					b2.setVisible(true);
					b3.setVisible(true);
					b4.setVisible(true);
					b5.setVisible(true);
					b6.setVisible(true);
					b7.setVisible(true);
					b8.setVisible(true);
					b9.setVisible(true);
					bA.setVisible(true);
					bB.setVisible(true);
					bC.setVisible(true);
					bD.setVisible(true);
					bE.setVisible(true);
					bF.setVisible(true);
				}
			});




			root.setTop(h1);
			root.setCenter(btns);
			Scene scene = new Scene(root,400,400);
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
