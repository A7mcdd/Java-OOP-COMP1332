package Labs.Lab10.Act4_tawjihi;

public abstract class Human implements HumanBeing{
	private String name;
	private char gender;
	
	public Human(String name, char gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	

}
