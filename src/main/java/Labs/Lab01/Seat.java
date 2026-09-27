package Labs.Lab01;



public class Seat {
	private int seatNumber;
	private String name;

	Seat(int seatNumber){
		this.seatNumber = seatNumber;

	}



	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isEmpty() {
		if (name == null)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Seat Number: "+seatNumber+" ,Name: "+name;
	}

	public static Boolean isValid(int num) {
		if (0<num && 92>=num && num!=3 &&  num!=4 && num!=89 && num != 90)
			return true;
		return false;
	}

	public static int getRow(int num) {
		if (isValid(num))
			return (num-1)/4;
		else return -1;
	}
	public static int getColumn(int num) {
		if (isValid(num)) {
			return (num-1)%4;
		}
		else return -1;
	}


}
