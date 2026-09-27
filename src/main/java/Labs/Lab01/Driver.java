package Labs.Lab01;



import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Train train = new Train();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println(
							  "\n1. Read passengers file.\n"
							+ "2. Reserve a new empty seat.\n"
							+ "3. Delete a reserved seat.\n"
							+ "4. Delete all reserved seats.\n"
							+ "5. Update passengers file.\n"
							+ "6. Quit");
			System.out.print("\nEnter Choice: ");
			if(!sc.hasNextInt()) {System.out.println("\nInvaild input. Please try again.");sc.nextLine();continue;}
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				try {
					train.loadFromFile();
					System.out.println("Passengers file loaded successfully");
				} catch (FileNotFoundException e) {
					System.out.println("Passengers file didn't loaded");
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter the seat number: ");
				if(!sc.hasNextInt()) {System.out.println("\nInvaild input. Please try again.");sc.nextLine();continue;}
				int numSeat = sc.nextInt();sc.nextLine();
				System.out.println("Enter the passenger name: ");
				String name = sc.nextLine();
				train.reserveSeat(numSeat, name);
				break;
			case 3:
				System.out.println("Enter the seat number: ");
				if(!sc.hasNextInt()) {System.out.println("\nInvaild input. Please try again.");sc.nextLine();continue;}
				numSeat = sc.nextInt();sc.nextLine();
				train.deleteSeat(numSeat);
				break;
			case 4:
				train.deleteAll();
				break;
			case 5:
				try {
					train.saveToFile();
					System.out.println("Passengers file updated successfully");
				} catch (FileNotFoundException e) {
					System.out.println("Passengers file didn't updated");
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("Quit");
				break;
			}
		}while(choice !=6);
		sc.close();
	}
}
