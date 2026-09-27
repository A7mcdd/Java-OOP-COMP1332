package Labswork.Labwork_06;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		LibraryManager lm = new LibraryManager();
		int choice;
		do {
			System.out.println("\n\n1. Add Book\n2. Add Member\n3. Borrow Book\n4. Return Book\n5. Display Books\n6. Display Members\n7. Save \n8. Load \n9. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter ID: ");
				int id = sc.nextInt();sc.nextLine();
				System.out.println("Enter Title: ");
				String title = sc.nextLine();
				System.out.println("Enter Author: ");
				String author = sc.nextLine();
				System.out.println("Enter Year: ");
				int year = sc.nextInt();sc.nextLine();
				lm.addBook(new Book(id, title, author, year));
				break;
			}
			case 2: {
				System.out.println("Enter ID: ");
				int memberId= sc.nextInt();sc.nextLine();
				System.out.println("Enter Name: ");
				String name = sc.nextLine();
				lm.addMember(new Member(memberId, name));
				break;
			}
			case 3: {
				System.out.println("Enter Member ID: ");
				int memberId= sc.nextInt();sc.nextLine();
				System.out.println("Enter Book ID: ");
				int bookId= sc.nextInt();sc.nextLine();
				lm.borrowBook(memberId,bookId);
				break;
			}
			case 4: {
				System.out.println("Enter Member ID: ");
				int memberId= sc.nextInt();sc.nextLine();
				System.out.println("Enter Book ID: ");
				int bookId= sc.nextInt();sc.nextLine();
				lm.returnBook(memberId, bookId);
				break;
			}
			case 5: {
				lm.displayAllBooks();
				break;
			}
			case 6: {
				lm.displayAllMembers();
				break;
			}
			case 7: {
				lm.saveData();
				System.out.println("Data saved.");
				break;
			}
			case 8: {
				lm.loadData();
				System.out.println("Data loaded.");
				break;
			}
			case 9: {
				System.out.println("End.");
				break;
			}

			default:
				System.out.println("Invilad choice.");
			}



		} while (choice != 9);
		sc.close();
	}

}
