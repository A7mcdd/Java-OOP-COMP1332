package Labs.Lab05.Act2;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a hex number");
		String hex = sc.nextLine();
		try {
			System.out.println(hex2Dec(hex));
		} catch (HexFormatException e) {
			System.out.println(("Not a hex number"));
		}
		sc.close();

	}
	public static int hex2Dec(String hexString) throws HexFormatException{
		for (int i = 0; i < hexString.length(); i++) {
			char c = hexString.charAt(i);
			if (!((c>='0'&&c<='9')||(c>='A'&&c<='F'))) {
				throw new HexFormatException();}
		}
		int dec = Integer.parseInt(hexString,16);
		return dec;
	}
}
