package Labs.Lab04.Act2;

public class Driver {
	public static void main(String[] args) {
		Point p1 = new Point(4,2);
		Point p2 = new Point(2,5);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.compareTo(p2));
		System.out.println(p1.equals(p2));

		try {
			Point p3 = (Point)p1.clone();
			System.out.println(p3);
			System.out.println(p3.equals(p1));
		}catch (CloneNotSupportedException e){
		}
	}

}
