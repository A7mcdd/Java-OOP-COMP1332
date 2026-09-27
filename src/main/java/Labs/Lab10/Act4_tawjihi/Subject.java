package Labs.Lab10.Act4_tawjihi;

public class Subject implements Comparable<Subject>{
	private String title,type;
	private int mark;
	private int maxMark;

	public Subject(String title, String type, int mark) {
		this.title = title;
		this.type = type;
		this.mark = mark;
	}
	public Subject(String title, String type, int mark,int maxMark) {
		this.title = title;
		this.type = type;
		this.mark = mark;
		this.maxMark = maxMark;
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
	public int getMaxMark() {
		return maxMark;
	}
	public void setMaxMark(int maxMark) {
		this.maxMark = maxMark;
	}

	@Override
	public String toString() {
		return "Title: "+title+" ,Type: "+type+" ,Mark: "+mark+"\n";
	}

	@Override
	public int compareTo(Subject o) {
		if(title.equals(o.getTitle())){
			if (mark>o.getMark())
				return 1;
			else if (mark<o.getMark())
				return -1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Subject) {
			if (title.equalsIgnoreCase(((Subject)obj).getTitle())&&mark==((Subject)obj).getMark())
				return true;
		}
		return false;
	}



}
