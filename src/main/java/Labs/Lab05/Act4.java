package Labs.Lab05;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Act4 {

	public static void main(String[] args) {
		try {
		FileInputStream file = new FileInputStream("src/main/java/Labs/Lab05/data.dat");
		DataInputStream DIS = new DataInputStream(file);
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum =+DIS.readInt();
		}
		System.out.println(sum);
		DIS.close();
		} catch (IOException e) {
			e.getMessage();
		}

	}

}
