package Labs.Lab08.application;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CalnderNode extends BorderPane{
	private Calendar today,cal;
	private int firstDay,daysInMonth,col,row,page;
	private Label monthyear;
	private HBox h1,h2;
	private GridPane gp;
	private Button next,prior;

	private static String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	private static String[] month = {"January" , "February" , "March" , "April" , "May" , "June" , "July" , "August" , "September" , "October" , "November" , "December"};

	CalnderNode(){
		
		today = new GregorianCalendar();
		cal = new GregorianCalendar(today.get(Calendar.YEAR),today.get(Calendar.MONTH),1);
		firstDay = cal.get(Calendar.DAY_OF_WEEK);
		daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		monthyear = new Label(month[cal.get(Calendar.MONTH)]+","+cal.get(Calendar.YEAR));
		h1 = new HBox();
		h1.getChildren().add(monthyear);
		h1.setAlignment(Pos.CENTER);
		setTop(h1);

		gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setAlignment(Pos.CENTER);

		for (int i = 0; i < days.length; i++) {
			Label l = new Label(""+days[i]);
			gp.add(l, i, 0);
		}

		col = firstDay-1;
		row = 1;
		for (int i = 1; i <= daysInMonth; i++) {
			Label l = new Label(""+i);
			gp.add(l, col, row);
			col++;
			if (col==7) {
				col=0;
				row++;
			}
		}

		next = new Button("Next");
		prior = new Button("Prior");
		h2 = new HBox(10);
		h2.getChildren().addAll(prior,next);
		h2.setAlignment(Pos.CENTER);
		setBottom(h2);
		setCenter(gp);

		page=0;
		next.setOnAction(e->{
			page++;
			cal = new GregorianCalendar(today.get(Calendar.YEAR),today.get(Calendar.MONTH)+page,1);
			firstDay = cal.get(Calendar.DAY_OF_WEEK);
			daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

			monthyear = new Label(month[cal.get(Calendar.MONTH)]+","+cal.get(Calendar.YEAR));
			h1 = new HBox();
			h1.getChildren().add(monthyear);
			h1.setAlignment(Pos.CENTER);
			setTop(h1);

			gp = new GridPane();
			gp.setHgap(10);
			gp.setVgap(10);
			gp.setAlignment(Pos.CENTER);

			for (int i = 0; i < days.length; i++) {
				Label l = new Label(""+days[i]);
				gp.add(l, i, 0);
			}

			col = firstDay-1;
			row = 1;
			for (int i = 1; i <= daysInMonth; i++) {
				Label l = new Label(""+i);
				gp.add(l, col, row);
				col++;
				if (col==7) {
					col=0;
					row++;
				}
			}
			setCenter(gp);
		});
		prior.setOnAction(e->{
			page--;
			cal = new GregorianCalendar(today.get(Calendar.YEAR),today.get(Calendar.MONTH)+page,1);
			firstDay = cal.get(Calendar.DAY_OF_WEEK);
			daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

			monthyear = new Label(month[cal.get(Calendar.MONTH)]+","+cal.get(Calendar.YEAR));
			h1 = new HBox();
			h1.getChildren().add(monthyear);
			h1.setAlignment(Pos.CENTER);
			setTop(h1);

			gp = new GridPane();
			gp.setHgap(10);
			gp.setVgap(10);
			gp.setAlignment(Pos.CENTER);

			for (int i = 0; i < days.length; i++) {
				Label l = new Label(""+days[i]);
				gp.add(l, i, 0);
			}

			col = firstDay-1;
			row = 1;
			for (int i = 1; i <= daysInMonth; i++) {
				Label l = new Label(""+i);
				gp.add(l, col, row);
				col++;
				if (col==7) {
					col=0;
					row++;
				}
			}
			setCenter(gp);
		});
	}
	
	public Calendar getToday() {
		return today;
	}
	public Calendar getCal() {
		return cal;
	}
	public int getFirstDay() {
		return firstDay;
	}
	public int getDaysInMonth() {
		return daysInMonth;
	}
	public int getCol() {
		return col;
	}
	public int getRow() {
		return row;
	}
	public int getPage() {
		return page;
	}
	public Label getMonthyear() {
		return monthyear;
	}
	public HBox getH1() {
		return h1;
	}
	public HBox getH2() {
		return h2;
	}
	public GridPane getGp() {
		return gp;
	}
	public Button getNext() {
		return next;
	}
	public Button getPrior() {
		return prior;
	}
	public static String[] getDays() {
		return days;
	}
	public static String[] getMonth() {
		return month;
	}

}
