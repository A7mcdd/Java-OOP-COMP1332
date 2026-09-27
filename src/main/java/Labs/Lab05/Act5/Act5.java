package Labs.Lab05.Act5;

import java.io.File;
import java.io.IOException;

public class Act5 {

	public static void main(String[] args) throws IOException {
		File file = new File("src/main/java/Labs/Lab05/bin.dat");
		BitOutputStream BOS = new BitOutputStream(file);
		BOS.writeBit('1');
		BOS.writeBit('0');
		BOS.writeBit('0');
		BOS.writeBit('1');
		BOS.writeBit('0');
		BOS.writeBit('0');
		BOS.writeBit('0');
		BOS.writeBit('1');
		
		BOS.writeBit("01000001");
		BOS.writeBit("10110");
		BOS.close();
	}

}
