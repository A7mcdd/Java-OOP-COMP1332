package Labswork.Labwork_06;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Transaction implements IBinarySerializable {
private int transactionId;
protected int memberId;
protected int bookId;
protected LocalDate dateBorrowed;
protected LocalDate dateReturned;

public Transaction(int transactionId, int memberId, int bookId) {
	this.transactionId = transactionId;
	this.memberId = memberId;
	this.bookId = bookId;
	this.dateBorrowed = LocalDate.now();
	this.dateReturned = null;
}

public void returnBook() {
	dateReturned = LocalDate.now();
	System.out.println("Book is Returned on "+ dateReturned);
}
public void displayInfo() {
	System.out.println("Transaction ID: "+transactionId+" Member ID: "+memberId+" Book ID: "+bookId+" Date Borrowed: "+dateBorrowed+" Date Returned: "+dateReturned);
}

@Override
public void writeToStream(ObjectOutputStream oos) throws IOException{
	oos.writeInt(transactionId);
	oos.writeInt(memberId);
	oos.writeInt(bookId);
	oos.writeObject(dateBorrowed);
	oos.writeObject(dateReturned);
}

@Override
public void readFromStream(ObjectInputStream ois) throws IOException, ClassNotFoundException {
	transactionId = ois.readInt();
	memberId = ois.readInt();
	bookId = ois.readInt();
	dateBorrowed = (LocalDate) ois.readObject();
	dateReturned = (LocalDate) ois.readObject();
	
}
}
