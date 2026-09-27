package Labs.Lab05.Act5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitOutputStream {
	private FileOutputStream output;
	private int buf;
	private int count;
	BitOutputStream(File file) throws IOException{
		output = new FileOutputStream(file);
		buf=0;
		count=0;
	}

	public void writeBit(char bit) throws IOException {
		buf = buf<<1; //shifting كاننا ضربناه ب  2 وحركناه خانة
		if(bit == '1') 
			buf=buf|1; //بدل ما نجمع 1 بنسوي اور لاول بت عشان لو اول بت 1 يضل مثل ما هو وما ياثر علي بعده
		count++;
		if(count==8) {
			output.write(buf);
			buf=0;
			count=0;
		}
	}
	public void writeBit(String bits) throws IOException {
		for (int i = 0; i < bits.length(); i++) {
			writeBit(bits.charAt(i));
		}
	}

	public void close() throws IOException {
		if(count>0) {
			buf = buf <<(8-count);
			output.write(buf);
		}
		output.close();
	}



	public FileOutputStream getOutput() {
		return output;
	}
	public void setOutput(FileOutputStream output) {
		this.output = output;
	}
	public int getBuf() {
		return buf;
	}
	public void setBuf(int buf) {
		this.buf = buf;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}




}
