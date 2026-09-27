package Labswork.Labwork_06;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface IBinarySerializable {

	 void writeToStream( ObjectOutputStream oos) throws IOException;
	 void readFromStream( ObjectInputStream ois) throws IOException,ClassNotFoundException;
}
