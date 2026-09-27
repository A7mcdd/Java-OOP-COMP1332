package Quizzes.Quiz4_sec8.application;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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

public class ManagmentTab extends VBox {
	int page = 0;
	private Label totalitems,totalcost;
	private TextField name,price,count;
	private Button add,save,load,prev,next;
	private HBox hb1,hb2,hb3,ha,hs,hl;
	@SuppressWarnings("unchecked")
	ManagmentTab(){
		name = new TextField();
		price = new TextField();
		count = new TextField();
		ha = new HBox(10);
		ha.getChildren().addAll(new Label("Product Name: "),name);
		hs = new HBox(18);
		hs.getChildren().addAll(new Label("Product Price:"),price);
		hl = new HBox(27);
		hl.getChildren().addAll(new Label("Quantity:     "),count);

		add = new Button("Add");
		save = new Button("Save");
		load = new Button("Load");
		hb1 = new HBox(10);
		hb1.getChildren().addAll(add,save,load);

		TableView<Product> tb = new TableView<>();
		TableColumn<Product,String> nameClm = new TableColumn<>("Product Name");
		nameClm.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<Product,Double> priceClm = new TableColumn<>("Price");
		priceClm.setCellValueFactory(new PropertyValueFactory<>("price"));
		TableColumn<Product,Integer> countClm = new TableColumn<>("Count");
		countClm.setCellValueFactory(new PropertyValueFactory<>("count"));
		TableColumn<Product,String> costClm = new TableColumn<>("Total Cost");
		costClm.setCellValueFactory(c->{return new SimpleStringProperty(String.valueOf(c.getValue().getTotalCost()));});

		tb.setItems(Main.olist);
		tb.getColumns().addAll(nameClm,priceClm,countClm,costClm);



		prev = new Button("Prev");
		next = new Button("Next");
		hb2 = new HBox(10);
		hb2.getChildren().addAll(prev,next);
		hb2.setAlignment(Pos.CENTER);


		totalitems = new Label("Total Items: 0");
		totalcost = new Label("Total Inventory Cost: 0");
		hb3 = new HBox(10);
		hb3.setAlignment(Pos.CENTER);
		hb3.getChildren().addAll(totalitems,totalcost);

		setSpacing(15);
		setPadding(new Insets(10));
		getChildren().addAll(ha,hs,hl,hb1,tb,hb2,hb3);

		add.setOnAction(e->{
			try {
			Main.olist.add(new Product(name.getText(), Double.valueOf(price.getText()), Integer.valueOf(count.getText())));
			System.out.println("added");
			totalItemsLabel();
			totalCostLabel();
			} catch (Exception e2) {
				System.out.println("Didn't added");
			}
		});

		save.setOnAction(e->{
			try {
				FileOutputStream file = new FileOutputStream("src/main/java/Quizzes/Quiz4_sec8/products.dat");
				ObjectOutputStream oos = new ObjectOutputStream(file);
				oos.writeObject(new ArrayList<>(Main.olist));
				oos.close();
				System.out.println("saved");
			} catch (IOException e1) {
				System.out.println("Didn't saved");
			}
		});

		load.setOnAction(e->{
			try {
				FileInputStream file = new FileInputStream("src/main/java/Quizzes/Quiz4_sec8/products.dat");
				ObjectInputStream ois = new ObjectInputStream(file);
				ArrayList<Product> list = new ArrayList<>(Main.olist);
				list = (ArrayList<Product>) ois.readObject();
				Main.olist.clear();
				Main.olist.addAll(list);
				ois.close();
				System.out.println("loaded");
				totalItemsLabel();
				totalCostLabel();
			} catch (IOException | ClassNotFoundException e1) {
				System.out.println("Didn't loaded");
			}		
		});

		next.setOnAction(e->{
			if (page<Main.olist.size()-1) {
				page++;
				name.setText(Main.olist.get(page).getName());
				price.setText(String.valueOf(Main.olist.get(page).getPrice()));
				count.setText(String.valueOf(Main.olist.get(page).getCount()));
			}
			System.out.println("page: "+page);
		});

		prev.setOnAction(e->{
			if(page>0) {
				page--;
				name.setText(Main.olist.get(page).getName());
				price.setText(String.valueOf(Main.olist.get(page).getPrice()));
				count.setText(String.valueOf(Main.olist.get(page).getCount()));
			}
			System.out.println("page: "+page);
		});
	}

	public int getPage() {
		return page;
	}

	public Label getTotalitems() {
		return totalitems;
	}

	public Label getTotalcost() {
		return totalcost;
	}

	public TextField getName() {
		return name;
	}

	public TextField getPrice() {
		return price;
	}

	public TextField getCount() {
		return count;
	}

	public Button getAdd() {
		return add;
	}

	public Button getSave() {
		return save;
	}

	public Button getLoad() {
		return load;
	}

	public Button getPrev() {
		return prev;
	}

	public Button getNext() {
		return next;
	}

	public HBox getHb1() {
		return hb1;
	}

	public HBox getHb2() {
		return hb2;
	}

	public HBox getHb3() {
		return hb3;
	}

	public void totalItemsLabel() {
		totalitems.setText("Total Items: "+Main.olist.size());
	}
	public void totalCostLabel() {
		double total=0;
		for (int i = 0; i < Main.olist.size(); i++) {
			total+=Main.olist.get(i).getTotalCost();
		}
		totalcost.setText("Total Inventory Cost: "+total);
	}

	public HBox getHa() {
		return ha;
	}

	public HBox getHs() {
		return hs;
	}

	public HBox getHl() {
		return hl;
	}
	
}
