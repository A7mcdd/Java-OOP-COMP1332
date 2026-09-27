package Labswork.Labwork_09.application;

import java.io.Serializable;

public class Book implements Serializable{


	private static final long serialVersionUID = 1L;
	private String title,author;
	private int nocopies;
	private boolean ishard;
	
	public Book(String title, String author, int nocopies, boolean ishardl) {
		super();
		this.title = title;
		this.author = author;
		this.nocopies = nocopies;
		this.ishard = ishardl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNocopies() {
		return nocopies;
	}

	public void setNocopies(int nocopies) {
		this.nocopies = nocopies;
	}

	public boolean isIshard() {
		return ishard;
	}

	public void setIshard(boolean ishard) {
		this.ishard = ishard;
	}
	
	
}
