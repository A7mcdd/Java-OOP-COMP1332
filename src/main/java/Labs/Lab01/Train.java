package Labs.Lab01;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Train {
	private static Seat[][] seats = new Seat[23][4];

	Train() {
		for (int i = 0; i < seats.length; i++) {
			if (i==0 || i==22) {
				seats[i]= new Seat[2];
				seats[i][0]= new Seat(i*4+1);
				seats[i][1]= new Seat(i*4+2);
			}
			else {
				seats[i] = new Seat[4];
				for (int j = 0; j < 4; j++) {
					seats[i][j] = new Seat(i * 4 + j + 1);
				}
			}
		}
	}


	public static Seat[][] getSeats() {
		return seats;
	}

	public Boolean reserveSeat(int seatNumber , String Name) {
		if (Seat.isValid(seatNumber)) {
			int r = Seat.getRow(seatNumber);
			int c = Seat.getColumn(seatNumber);
			Seat seat = seats[r][c];
			if(seat.isEmpty()) {
				seat.setName(Name);
				return true;
			}
		}
		return false;
	}

	public Boolean deleteSeat(int seatNumber) {
		if(Seat.isValid(seatNumber)) {
			int r = Seat.getRow(seatNumber);
			int c = Seat.getColumn(seatNumber);
			Seat seat = seats[r][c];
			if(!seat.isEmpty()) {
				seat.setName(null);
				return true;
			}
		}
		return false;
	}

	public void deleteAll() {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j].setName(null);
			}
		}
	}

	public void saveToFile() throws FileNotFoundException {
		File file = new File("src/main/java/Labs/Lab01/passengers.txt");
		PrintWriter pw = new PrintWriter(file);
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (!seats[i][j].isEmpty()) {
					pw.println(seats[i][j].getSeatNumber()+": "+seats[i][j].getName());
				}
			}

		}
		pw.close();

	}

	public void loadFromFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/main/java/Labs/Lab01/passengers.txt"));
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			
			if (line.contains(": "))
				continue;
			
			String[] a = line.split(": ");
			
			if (a.length!=2)
				continue;
			
			int num = Integer.parseInt(a[0]);
			String name = a[1];
			reserveSeat(num, name);
		}
		sc.close();

	}



}
