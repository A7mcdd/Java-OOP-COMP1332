package Labswork.Labwork_06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
	private List<Book> books;
	private List<Member> members;
	private List<Transaction> transactions;
	private final String BOOK_FILE = "src/main/java/Labswork/Labwork_06/book.dat" , MEMBER_FILE = "src/main/java/Labswork/Labwork_06/member.dat",TRANSACTION_FILE = "src/main/java/Labswork/Labwork_06/transaction.dat";

	public LibraryManager() {
		books = new ArrayList<Book>();
		members = new ArrayList<Member>();
		transactions = new ArrayList<Transaction>();
	}

	public void addBook(Book b) {
		books.add(b);
	}

	public void addMember (Member m) {
		members.add(m);
	}



	public void borrowBook(int memberId, int bookId) {
		Member member = findMember(memberId);
		Book book = findBook(bookId);
		if (member != null && book != null && book.isAvailable()) {
			member.borrowBook(bookId);
			book.setAvailable(false);
			transactions.add(new Transaction(transactions.size()+1,memberId,bookId));
			System.out.println("Book borrowed.");
		}
		else
			System.out.println("Cannot borrow book.");
	}

	public void returnBook(int memberId, int bookId) {
		Member member = findMember(memberId);
		Book book = findBook(bookId);
		if(book!=null&&member!=null&& book.isAvailable()!=true) {
			member.returnBook(Integer.valueOf(bookId));
			book.setAvailable(true);
			for (Transaction t : transactions) {
				if (t.memberId == memberId&&t.bookId==bookId&&t.dateReturned==null) {
					t.returnBook();
					break;}
			}
			System.out.println("Book returned.");
		}
		else {
			System.out.println("Cannot return book.");
		}

	}

	public void displayAllBooks() {
		for(Book b : books)
			b.displayInfo();
	}

	public void displayAllMembers() {
		for(Member m : members)
			m.displayInfo();
	}

	public void saveData() throws FileNotFoundException, IOException {
		writeListToFile(books, BOOK_FILE);
		writeListToFile(members, MEMBER_FILE);
		writeListToFile(transactions, TRANSACTION_FILE);

	}


	@SuppressWarnings("unchecked")
	public void loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		books = (List<Book>) readListFromFile(BOOK_FILE);
		members = (List<Member>) readListFromFile(MEMBER_FILE);
		transactions = (List<Transaction>) readListFromFile(TRANSACTION_FILE);

	}

	public void writeListToFile(Object obj , String filename) throws FileNotFoundException, IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));){
			if (filename.equals(BOOK_FILE)) {
				oos.writeInt(books.size());
				for (Book b : books)
					b.writeToStream(oos);
			}
			else if (filename.equals(MEMBER_FILE)) {
				oos.writeInt(members.size());
				for (Member m : members)
					m.writeToStream(oos);
			}
			else if (filename.equals(TRANSACTION_FILE)) {
				oos.writeInt(transactions.size());
				for (Transaction t : transactions)
					t.writeToStream(oos);
			}
		}
	}

	public Object readListFromFile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Object> list = new ArrayList<>();
		File f = new File(filename);
		if (!f.exists()) return list;
		try (ObjectInputStream ois = new ObjectInputStream (new FileInputStream(filename));){
			int size = ois.readInt();
			for(int i=0;i<size;i++) {
				if (filename.equals(BOOK_FILE)) {
					Book b = new Book(0, "", "", 0);
					b.readFromStream(ois);
					list.add(b);}

				else if (filename.equals(MEMBER_FILE)) {
					Member m = new Member(0, "");
					m.readFromStream(ois);
					list.add(m);}

				else if (filename.equals(TRANSACTION_FILE)) {
					Transaction t = new Transaction(0, 0, 0);
					t.readFromStream(ois);
					list.add(t);
				}}

			return list;}
	}





	public Member findMember (int id) {
		for (Member m : members)
			if (m.getMemberId()== id)
				return m;
		return null;
	}

	public Book findBook (int id) {
		for (Book b : books)
			if (b.getId()==id)
				return b;
		return null;
	} 


}
