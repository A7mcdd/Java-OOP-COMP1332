package Labs.Lab11.application;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class TawjihiTable extends VBox{
	private TableView<Tawjihi> table;
	@SuppressWarnings("unchecked")
	TawjihiTable(ArrayList<Tawjihi> students){
		table = new TableView<>();

		ObservableList<Tawjihi> olist = FXCollections.observableArrayList(students);

		TableColumn<Tawjihi, Integer> num = new TableColumn<>("Num");
		num.setCellValueFactory(new PropertyValueFactory<>("seatingNum"));
		TableColumn<Tawjihi, String> name = new TableColumn<>("Name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<Tawjihi, String> grade = new TableColumn<>("Grade");
		grade.setCellValueFactory(c->{
			if(c.getValue() instanceof Scientific s)
				return new SimpleStringProperty(String.valueOf(s.calculateAverage()));
			if(c.getValue() instanceof Literary t)
				return new SimpleStringProperty(String.valueOf(t.calculateAverage()));
			return new SimpleStringProperty("");
		});
		 
		table.setItems(olist);
		table.getColumns().addAll(num,name,grade);
		
		getChildren().add(table);

	}
	public TableView<Tawjihi> getTable() {
		return table;
	}
	public void setTable(TableView<Tawjihi> table) {
		this.table = table;
	}
	
}
