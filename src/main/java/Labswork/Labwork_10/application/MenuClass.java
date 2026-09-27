package Labswork.Labwork_10.application;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;

public class MenuClass {
	private HBox hbox;
	private MenuItem add,next,prev,save,load,close,update;
	MenuClass(){
		MenuBar menubar = new MenuBar();

		Menu menufile = new Menu("File");
		Menu menuedit = new Menu("Edit");
		Menu menuhelp = new Menu("Help");

		add = new MenuItem("Add Student");
		update = new MenuItem("Update Student");
		next = new MenuItem("Next Student");
		prev = new MenuItem("Previus Student");
		save = new MenuItem("Save File");
		load = new MenuItem("Load File");
		close = new MenuItem("Close");



		menuedit.getItems().addAll(add,update,next,prev);
		menufile.getItems().addAll(save,load);
		menuhelp.getItems().add(close);


		menubar.getMenus().addAll(menufile,menuedit,menuhelp);

		add.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
		update.setAccelerator(KeyCombination.keyCombination("Ctrl+U"));
		next.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
		prev.setAccelerator(KeyCombination.keyCombination("Ctrl+P"));
		save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		load.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));
		close.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));

		//actions
		close.setOnAction(e -> {Platform.exit();});

		hbox=new HBox(5);
		hbox.getChildren().add(menubar);
		hbox.setPrefWidth(600);
	}
	public HBox getHbox() {
		return hbox;
	}
	public MenuItem getAdd() {
		return add;
	}
	public MenuItem getSave() {
		return save;
	}
	public MenuItem getClose() {
		return close;
	}
	public MenuItem getNext() {
		return next;
	}
	public MenuItem getPrev() {
		return prev;
	}
	public MenuItem getLoad() {
		return load;
	}
	public MenuItem getUpdate() {
		return update;
	}



}
