package Labswork.Labwork_10.application;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class StatisticalPane {
	private GridPane gpane;
	private Text top10,max,min,avg,suc,fail,aavg,bavg;

	StatisticalPane(){
		gpane = new GridPane();
		gpane.setHgap(1);
		gpane.setVgap(15);
		gpane.setAlignment(Pos.CENTER);

		max = new Text("-");
		avg = new Text("-");
		min = new Text("-");
		suc = new Text("-");
		fail = new Text("-");
		aavg = new Text("-");
		bavg = new Text("-");
		top10 = new Text("-");


		gpane.add(new Label("Max"),0,0);
		gpane.add(max, 0, 1);

		gpane.add(new Label("Avarge"),0,2);
		gpane.add(avg, 0, 3);

		gpane.add(new Label("Min"),0,4);
		gpane.add(min, 0, 5);

		gpane.add(new Label("Number of Successful"),0,6);
		gpane.add(suc, 0, 7);

		gpane.add(new Label("Number of Failures"),0,8);
		gpane.add(fail, 0, 9);

		gpane.add(new Label("Above Average"),0,10);
		gpane.add(aavg, 0, 11);

		gpane.add(new Label("Below Average"),0,12);
		gpane.add(bavg, 0, 13);

		gpane.add(new Label("Top 10 Students"),0,14);



	}

	public GridPane getGpane() {
		return gpane;
	}

	public Text getTop10() {
		return top10;
	}

	public Text getMax() {
		return max;
	}

	public Text getMin() {
		return min;
	}

	public Text getAvg() {
		return avg;
	}

	public Text getSuc() {
		return suc;
	}

	public Text getFail() {
		return fail;
	}

	public Text getAavg() {
		return aavg;
	}

	public Text getBavg() {
		return bavg;
	}




}
