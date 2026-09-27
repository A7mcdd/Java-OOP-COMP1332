package Labswork.Labwork_06;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Member implements IBinarySerializable {
	private int memberId;
	private String name;
	private List<Integer> borrowedBooks;
	
	public Member(int memberId, String name) {
		this.memberId = memberId;
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}

	public int getMemberId() {
		return memberId;
	}

	public String getName() {
		return name;
	}

	public List<Integer> getBorrowedBooks() {
		return borrowedBooks;
	}
	
	public void borrowBook (int bookId) {
		borrowedBooks.add(bookId);
	} 
	
	public void returnBook ( int bookId) {
		borrowedBooks.remove(Integer.valueOf(bookId));
	}
	
	public void displayInfo() {
		System.out.println("ID: "+memberId+" ,Name: "+name);
	}
	
	@Override
	public void writeToStream(ObjectOutputStream oos) throws IOException{
		oos.writeInt(memberId);
		oos.writeUTF(name);
		oos.writeInt(borrowedBooks.size());;
		for (int bookId : borrowedBooks) {
			oos.writeInt(bookId);
		}
	}
	
	@Override
	public void readFromStream(ObjectInputStream ois) throws IOException{
		memberId = ois.readInt();
		name = ois.readUTF();
		int size = ois.readInt();
		borrowedBooks = new ArrayList<>();
		for(int i =0;i<size;i++)
			borrowedBooks.add(ois.readInt());
	}
	
	
}
