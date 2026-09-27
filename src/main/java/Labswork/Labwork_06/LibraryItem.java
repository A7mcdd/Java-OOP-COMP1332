package Labswork.Labwork_06;


public abstract class LibraryItem{
	protected int id;
	protected String title;
	protected boolean available;

	public LibraryItem(int id, String title) {
		this.id = id;
		this.title = title;
		this.available = true;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public abstract void displayInfo();


}
