package Labswork.Labwork_09.application;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;

public class MenuClass {
	
	private HBox hbox;
	private MenuItem add,delete,update,save,close;
	
	MenuClass(){
		MenuBar menubar =new MenuBar();
		
		Menu menufile= new Menu("File");
		Menu menuexit= new Menu("Exit");
		
		 add=new MenuItem("Add Book");
		 update=new MenuItem("Update Book");
		 delete=new MenuItem("Delete Book");
		 save=new MenuItem("Save to File");
		
		 close=new MenuItem("Close");
		
		menufile.getItems().addAll(add,update, delete,save);
		menuexit.getItems().add(close);
		
		menubar.getMenus().addAll(menufile,menuexit);
		
		add.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
		update.setAccelerator(KeyCombination.keyCombination("Ctrl+U"));
		delete.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
		save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		close.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
		
		hbox=new HBox(5);
		hbox.getChildren().add(menubar);
	
		
	}

	public HBox getHbox() {
		return hbox;
	}

	public MenuItem getAdd() {
		return add;
	}

	public MenuItem getDelete() {
		return delete;
	}

	public MenuItem getUpdate() {
		return update;
	}

	public MenuItem getSave() {
		return save;
	}

	public MenuItem getClose() {
		return close;
	}
	
	

}
