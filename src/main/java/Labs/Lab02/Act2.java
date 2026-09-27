package Labs.Lab02;

import java.util.ArrayList;
import java.util.Scanner;

public class Act2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		
		System.out.println("enter 10 integers to a list ");
		
		for (int i = 0; i < 10; i++) {
			list.add(sc.nextInt());
		}
		removeDuplicate(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		sc.close();
		
	}
	public static void removeDuplicate(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(j);
					j--;// عشان ما تتجاوز العنصر الي بعدو
				}
			}
		}
	}
}
