package Quizzes.Quiz4_sec8.application;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StaticTab extends VBox {
	private Label l1,most,avg,low;
	private ListView<String> lowList;
	private Button ref;

	StaticTab() {
		l1 = new Label("Inventory Statistics");
		l1.setFont(new Font(20));
		most = new Label("Most Expensive Product: ");
		avg = new Label("Average Price of Products: ");
		low = new Label("Low Stock Alerts (Qty < 5): ");
		lowList = new ListView<>();
		lowList.setPrefHeight(100);

		ref = new Button("Refresh");
		setSpacing(15);
		getChildren().addAll(l1,most,avg,low,lowList,ref);
		setAlignment(Pos.CENTER);

		ref.setOnAction(e->{
			AveragePrice();
			MostExpensive();
			LowStock();
		});
	}

	public void MostExpensive() {
		double max=0;
		for (int i = 0; i < Main.olist.size(); i++) {
			if (max<Main.olist.get(i).getPrice())
				max = Main.olist.get(i).getPrice();
		}
		most.setText("Most Expensive Product: "+max);
	}
	public void AveragePrice() {
		double avgPrice = 0;
		for (int i = 0; i < Main.olist.size(); i++) {
			avgPrice= avgPrice +Main.olist.get(i).getPrice();
		}
		avgPrice = avgPrice/(double)Main.olist.size();
		avg.setText("Average Price of Products: "+avgPrice);
	}
	public void LowStock() {
	    lowList.getItems().clear(); // تنظيف القائمة قبل التحديث
	    for (Product p : Main.olist) {
	        if (p.getCount() < 5) {
	            lowList.getItems().add(p.getName() + " - Qty: " + p.getCount());
	        }
	    }
	}
	public Label getL1() {
		return l1;
	}

	public Label getMost() {
		return most;
	}

	public Label getAvg() {
		return avg;
	}

	public Label getLow() {
		return low;
	}

	public Button getRef() {
		return ref;
	}

	public ListView<String> getLowList() {
		return lowList;
	}
	


}
