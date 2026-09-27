package Labs.Lab05.Act2;

public class HexFormatException extends Exception{
	private static final long serialVersionUID = 1L;
	
	HexFormatException(){
		super("Not a hex number");
	}
	
	HexFormatException(String msg){
		super(msg);
	}
	
}
