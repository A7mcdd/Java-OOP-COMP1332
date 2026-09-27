package Labswork.Labwork_09.application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
public class BookForm {
	private GridPane gpane;
	private TextField title,author,nocopies;
	private Button add,save,update, delete;
	private RadioButton yes,no;
	
	
	BookForm(){
		gpane=new GridPane();
		gpane.setHgap(5);
		gpane.setVgap(5);
		
		title= new TextField();
		author= new TextField();
		nocopies= new TextField();
		yes=new RadioButton("Yes");
		no =new RadioButton("No");
		
		add=new Button("Add");
		save=new Button("Save");
		delete=new Button("Delete");
		update=new Button("Update");
		
		
		gpane.add(new Label("Book Title"), 0, 0);
		gpane.add(title, 1, 0);
		
		gpane.add(new Label("Book Author"), 0, 1);
		gpane.add(author, 1, 1);
		
		gpane.add(new Label("Number Of Copies"), 0, 2);
		gpane.add(nocopies, 1, 2);
		
		HBox rhbox=new HBox(10);
		rhbox.getChildren().addAll(yes,no);
		
		gpane.add(new Label ("Is hard Copye ? "), 0, 3);
		gpane.add(rhbox, 1, 3);
		ToggleGroup tg=new ToggleGroup();
		
		yes.setToggleGroup(tg);
		no.setToggleGroup(tg);
		
		gpane.add(add, 1, 5);
		gpane.add(delete, 2, 5);
		gpane.add(update, 3, 5);
		gpane.add(save, 4, 5);
		
		
		
		gpane.setPadding(new Insets(45));
		
		
		
	}


	public GridPane getGpane() {
		return gpane;
	}


	public TextField getTitle() {
		return title;
	}


	public TextField getAuthor() {
		return author;
	}


	public TextField getNocopies() {
		return nocopies;
	}


	public Button getAdd() {
		return add;
	}


	public Button getSave() {
		return save;
	}


	public Button getUpdate() {
		return update;
	}


	public Button getDelete() {
		return delete;
	}


	public RadioButton getYes() {
		return yes;
	}


	public RadioButton getNo() {
		return no;
	}
	
	
	
	
	

}
