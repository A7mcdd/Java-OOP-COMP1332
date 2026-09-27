package Labs.Lab02;

import java.util.ArrayList;
import java.util.Scanner;

public class Act1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		
		System.out.println("Enter a sequence of numbers ending with 0");
		
		while (sc.hasNext()) {
			int num = sc.nextInt();
			if (num ==0)
				break;
			list.add(num);
		}

		if (max(list)==null)
			System.out.println("The list is Empty");
		else 
			System.out.println("The max number is "+max(list));
		sc.close();
	}

	public static Integer max(ArrayList<Integer> list) {
		if (list == null || list.size()==0)
			return null;
		
		int max=list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (max<list.get(i))
				max = list.get(i);
		}
		return max;
	}
}
