package Labs.Lab04.Act1;

public class Driver {

	public static void main(String[] args) {
		Time t1 = new Time();
		Time t2 = new Time(1000223);
		Time t3 = new Time(23, 49, 30);
		
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		try {
			Time t4 = (Time) t3.clone();
			System.out.println(t4);
			System.out.println(t4.compareTo(t3));
		} catch (CloneNotSupportedException e) {
		}
		System.out.println(t1.compareTo(t3));
		System.out.println(t2.compareTo(t3));
		System.out.println(t2.compareTo(t1));
		

	}

}
