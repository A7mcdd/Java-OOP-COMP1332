package Quizzes.Quiz4_sec8.application;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private double price;
	private int count;
	public Product(String name, double price, int count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getTotalCost() {
		return count*price;
	}
	
}
