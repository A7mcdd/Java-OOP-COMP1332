package Labswork.Labwork_09.application;


import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
public class ViewBookTable {	
	private StackPane stackpane;
	private TableView<Book> tableview;
	private TableColumn<Book,String> titlecolumn, authorcolumn;
	private TableColumn<Book,Integer>  copiescolumn;
	private TableColumn<Book,Boolean>  ishardcolumn;
	@SuppressWarnings("unchecked")
	ViewBookTable(ObservableList<Book> olist){	
		tableview= new TableView<Book>();
		
		titlecolumn=new  TableColumn<>("Book Title");
		titlecolumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		titlecolumn.setPrefWidth(400);
		titlecolumn.setEditable(true);
		titlecolumn.setSortable(false);
		
		
		authorcolumn=new  TableColumn<>("Book Author");
		authorcolumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		
		
		copiescolumn=new  TableColumn<>("No of Copies");
		copiescolumn.setCellValueFactory(new PropertyValueFactory<>("nocopies"));
		
		ishardcolumn=new  TableColumn<>("Is Hard Copy?");
		ishardcolumn.setCellValueFactory(new PropertyValueFactory<>("ishard"));
		
		tableview.getColumns().addAll(titlecolumn,authorcolumn,copiescolumn,ishardcolumn);
		
		tableview.setItems(olist);
		
		stackpane=new StackPane();
		stackpane.getChildren().add(tableview);
		
	}
	

	public TableView<Book> getTableview() {
		return tableview;
	}


	public TableColumn<Book, String> getTitlecolumn() {
		return titlecolumn;
	}


	public TableColumn<Book, String> getAuthorcolumn() {
		return authorcolumn;
	}


	public TableColumn<Book, Integer> getCopiescolumn() {
		return copiescolumn;
	}


	public TableColumn<Book, Boolean> getIshardcolumn() {
		return ishardcolumn;
	}


	public StackPane getStackpane() {
		return stackpane;
	}

	
	
	
	

}
