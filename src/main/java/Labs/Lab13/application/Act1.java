package Labs.Lab13.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Scanner;

public class Act1 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/main/java/Labs/Lab13/word.txt");
		Scanner sc = new Scanner(file);
		ArrayList<String> list = new ArrayList<>();
		while (sc.hasNext()) {
			String word=sc.next();
			if(Character.isLetter(word.charAt(0)))
				list.add(word);
		}
		sc.close();

		sortArray(list);
//		Collections.sort(list); //or
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	public static void sortArray(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 1+i; j < list.size(); j++) {
				if (list.get(j).compareTo(list.get(i))<0) {
					String temp = list.get(i);
					list.set(i,list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
}
