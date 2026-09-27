package Labs.Lab03.Act3;

public class Subject {
	private String title,type;
	private int mark;
	
	public Subject(String title, String type, int mark) {
		super();
		this.title = title;
		this.type = type;
		this.mark = mark;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	@Override
	public String toString() {
		return "Title: "+title+" ,Type: "+type+" ,Mark: "+mark+"\n";
	}
	
}
