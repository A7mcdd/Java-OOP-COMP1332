package Labs.Lab05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Act3 {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream("src/main/java/Labs/Lab05/data.dat");
		DataOutputStream DOS = new DataOutputStream(file);
		for (int i = 0; i < 100; i++) {
			Random r = new Random();
			DOS.writeInt(r.nextInt());
		}
		DOS.close();
		
		//test
		FileInputStream fileI = new FileInputStream("src/main/java/Labs/Lab05/data.dat");
		DataInputStream DIS = new DataInputStream(fileI);
		for (int i = 0; i < 100; i++) {
			System.out.println(DIS.readInt());
		}
		DIS.close();
		
		
	}

}
