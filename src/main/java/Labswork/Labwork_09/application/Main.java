package Labswork.Labwork_09.application;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {

	static 	ObservableList<Book> list=FXCollections.observableArrayList();
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox vbox =new VBox();

			MenuClass menuclass=new MenuClass();
			BookForm bookform= new BookForm();

			TabPane tabpane=new TabPane();
			Tab book=new Tab("Book Information");
			Tab cdmedia=new Tab("CD media Information");
			Tab magazine=new Tab("Magazine Information");
			Tab newspaper=new Tab("NewsPaper Information");
			book.setClosable(false);
			cdmedia.setClosable(false);
			magazine.setClosable(false);
			newspaper.setClosable(false);

			tabpane.getTabs().addAll(book,cdmedia,magazine,newspaper);
			
			
			Font font = new Font(40);
			Label l1 = new Label("The doctor did not specify what was required");
			l1.setFont(font);
			Label l2 = new Label("The doctor did not specify what was required");
			l2.setFont(font);
			Label l3 = new Label("The doctor did not specify what was required");
			l3.setFont(font);
			cdmedia.setContent(l1);
			magazine.setContent(l2);
			newspaper.setContent(l3);


			ViewBookTable viewbookbable =new ViewBookTable( fillForm());

			BorderPane root = new BorderPane();

			root.setTop(menuclass.getHbox());
			root.setBottom(bookform.getGpane());
			root.setCenter(viewbookbable.getStackpane());

			book.setContent(root);


			// Events

			bookform.getAdd().setOnAction(e->{
				addMethod(bookform);
			});
			bookform.getDelete().setOnAction(e->{
				list.remove(viewbookbable.getTableview().getSelectionModel().getSelectedIndex());
			});
			bookform.getSave().setOnAction(e->{
				try {
					ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("src/main/java/Labswork/Labwork_09/books.dat"));
					OOS.writeObject(new ArrayList<>(list));
					OOS.close();
					
				} catch (IOException e1) {
				}
			});
			bookform.getUpdate().setOnAction(e->{
				try {
				ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("src/main/java/Labswork/Labwork_09/books.dat"));
				ArrayList<Book> saved = (ArrayList<Book>) OIS.readObject();
				OIS.close();
				list.clear();
				list.addAll(saved);
				
				} catch (ClassNotFoundException | IOException e1) {
				}
			});
			menuclass.getAdd().setOnAction(e->{
				addMethod(bookform);
			});
			menuclass.getDelete().setOnAction(e->{
				list.remove(viewbookbable.getTableview().getSelectionModel().getSelectedIndex());
			});
			menuclass.getSave().setOnAction(e->{
				try {
					ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("src/main/java/Labswork/Labwork_09/books.dat"));
					OOS.writeObject(new ArrayList<>(list));
					OOS.close();
					
				} catch (IOException e1) {
				}
			});
			menuclass.getUpdate().setOnAction(e->{
				try {
				ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("src/main/java/Labswork/Labwork_09/books.dat"));
				ArrayList<Book> saved = (ArrayList<Book>) OIS.readObject();
				OIS.close();
				list.clear();
				list.addAll(saved);
				
				} catch (ClassNotFoundException | IOException e1) {
				}
			});
			menuclass.getClose().setOnAction(e->{Platform.exit();});

			vbox.getChildren().addAll(menuclass.getHbox(),tabpane);

			Scene scene = new Scene(vbox,1000,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Book App");
			primaryStage.setScene(scene);
			primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static void addMethod(BookForm bookform ){
		boolean ishard;
		String author=bookform.getAuthor().getText();
		String title=bookform.getTitle().getText();
		if(bookform.getYes().isSelected() )
			ishard=true;
		else 
			ishard=false;
		try {
		Integer nocopy= Integer.parseInt(bookform.getNocopies().getText());
		list.add(new Book(author,title,nocopy,ishard));}catch (Exception e) {
			new Alert( Alert.AlertType.ERROR,"Enter invaild inputs").showAndWait();
		}
	}

	public static ObservableList<Book> fillForm(){		
		list.add(new Book("Data Structure","Ali Hamdan",10,true));
		list.add(new Book("Data Base","Sami Hamdan",5,true));
		list.add(new Book("Data Structure","Ali Hamdan",0,false));
		list.add(new Book("Java Programming","Jawad Hamdan",10,true));
		list.add(new Book("Python","Samlem Hamdan",5,true));
		list.add(new Book("Discrte Math","Hani Nader",7,true));
		list.add(new Book("HTML/CSS","Ali Samodi",0,false));
		list.add(new Book("Compiler","Nader Sami",20,true));
		return list;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
