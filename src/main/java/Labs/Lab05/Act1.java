package Labs.Lab05;

import java.util.Scanner;

public class Act1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter a hex number");
			String hex = sc.nextLine();
			System.out.println(hex2Dec(hex));
		} catch (NumberFormatException e) {
			System.out.println("Not a hex number");
		}
		sc.close();
		
	}
	public static int hex2Dec(String heString) {
		int dec = Integer.parseInt(heString,16);
		return dec;
	}
}
