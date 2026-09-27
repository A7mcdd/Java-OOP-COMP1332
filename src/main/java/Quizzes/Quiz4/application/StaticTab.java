package Quizzes.Quiz4.application;


import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StaticTab extends VBox{
	private TableView<Car> table;
	private TextField cost;
	private Button ref;

	@SuppressWarnings("unchecked")
	StaticTab(){
		table = new TableView<>();
		TableColumn<Car,String> nameClm = new TableColumn<>("Rental Name");
		nameClm.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<Car,String> rentalClm = new TableColumn<>("Car Palet");
		rentalClm.setCellValueFactory(new PropertyValueFactory<>("palet"));
		TableColumn<Car,String> typeClm = new TableColumn<>("Car Type");
		typeClm.setCellValueFactory(new PropertyValueFactory<>("type"));
		TableColumn<Car,Integer> dayClm = new TableColumn<>("Days");
		dayClm.setCellValueFactory(new PropertyValueFactory<>("days"));
		TableColumn<Car,String> costClm = new TableColumn<>("Cost");
		costClm.setCellValueFactory(c-> {return new SimpleStringProperty(String.valueOf(c.getValue().getCost()));});

		table.getColumns().clear();
		table.getColumns().addAll(nameClm,rentalClm,typeClm,dayClm,costClm);
		table.setItems(Main.olist);
		
		cost = new TextField();
		cost.setEditable(false);
		HBox h1 = new HBox(10);
		h1.getChildren().addAll(new Label("Total of Rental Cost:"),cost);
		ref = new Button("Refresh");
		carCost();
		
		setSpacing(15);
		setPadding(new Insets(10));
		setAlignment(Pos.CENTER);
		getChildren().addAll(table,h1,ref);
		
		ref.setOnAction(e->{
			carCost();
			table.setItems(Main.olist);
			});
	}

	public TableView<Car> getTable() {
		return table;
	}

	public TextField getCost() {
		return cost;
	}
	public void carCost() {
		double totalcost=0;
		for (int i = 0; i < Main.olist.size(); i++) {
			totalcost = totalcost +Main.olist.get(i).getCost();
		}
		cost.setText(""+totalcost);
	}


}
