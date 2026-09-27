package Quizzes.Quiz4.application;

import java.io.Serializable;

public class Car implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name,palet,type;
	private int days;

	public Car(String name, String palet, String type, int days) {
		this.name = name;
		this.palet = palet;
		this.type = type;
		this.days = days;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPalet() {
		return palet;
	}
	public void setPalet(String palet) {
		this.palet = palet;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public double getCost() {
		if (type.equals("Sport"))
			return 200*days;
		if (type.equals("Laxury"))
			return 500*days;
		if (type.equals("Van"))
			return 300*days;
		return 0;
	}





}
