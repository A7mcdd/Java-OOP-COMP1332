package Labs.Lab03;

import java.util.ArrayList;
import java.util.Scanner;

public class Act1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Number> list = new ArrayList<>();

		list.add(0);
		list.add(0.3023);
		list.add(3);
		list.add(4);
		list.add(5.6);
		list.add(21);
		list.add(99.1);
		list.add(23.01f);
		
		
		System.out.println("List before shuffle: "+list);

		shuffle(list);

		System.out.println("List after shuffle: "+list);

		sc.close();
	}
	public static void shuffle(ArrayList<Number> list) {
		for (int i = 0; i < list.size(); i++) {
			int j = (int)(list.size()*Math.random());
			
			Number temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
	}

}
