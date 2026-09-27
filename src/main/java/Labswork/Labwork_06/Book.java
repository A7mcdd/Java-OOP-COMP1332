package Labswork.Labwork_06;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Book extends LibraryItem implements IBinarySerializable{

	private String author;
	private int year;
	
	public Book(int id, String title,String author,int year) {
		super(id, title);
		this.author = author;
		this.year = year;
	}	
	
	
	
	public String getAuthor() {
		return author;
	}



	public int getYear() {
		return year;
	}



	@Override
	public void displayInfo() {
		System.out.println("Book ID: " + getId()+" ,Title: "+ getTitle() +" ,Author: "+ author + " ,Year: "+ year + " ,Available: "+ isAvailable());
	}
	
	@Override
	public void writeToStream(ObjectOutputStream oos) throws IOException{
		oos.writeInt(getId());
		oos.writeUTF(getTitle());
		oos.writeUTF(author);
		oos.writeInt(year);
		oos.writeBoolean(isAvailable());
	}
	
	@Override
	public void readFromStream(ObjectInputStream ois) throws IOException{
		id = ois.readInt();
		title = ois.readUTF();
		author = ois.readUTF();
		year = ois.readInt();
		available = ois.readBoolean();
	}
	
	
	
}
