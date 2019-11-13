//DeLay & Maierhofer 
import java.io.Serializable;
public class Members implements Serializable {
	/************************************************************************/
	//VARIABLES 
	private String name, lastname;
	private int age, height, weight;
	private int BPSy, BPdias;
	private String cancer, diabetes, Alzheimers;
	
	/************************************************************************/ //Emily De Lay
	//GETTERS AND SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getBPSy() {
		return BPSy;
	}
	public void setBPSy(int bPSy) {
		BPSy = bPSy;
	}
	public int getBPdias() {
		return BPdias;
	}
	public void setBPdias(int bPdias) {
		BPdias = bPdias;
	}
	public String getCancer() {
		return cancer;
	}
	public void setCancer(String cancer) {
		this.cancer = cancer;
	}
	public String getDiabetes() {
		return diabetes;
	}
	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}
	public String getAlzheimers() {
		return Alzheimers;
	}
	public void setAlzheimers(String alzheimers) {
		Alzheimers = alzheimers;
	}
	/************************************************************************/ //emily de lay
	public Members() {
		name = "";
		lastname = "";
		age = 0;
		height = 0;
		weight = 0;
		BPSy = 0;
		BPdias = 0;
		cancer = "";
		diabetes = "";
		Alzheimers = "";
		
	}
	//gotta make the constructor 
	public Members(String name, String lastname, int age, int height, int weight, int bPSy, int bPdias, String cancer,
			String diabetes, String alzheimers) {
	//setfunction(variable)
		setName(name);
		setLastname(lastname);
		setAge(age);
		setHeight(height);
		setWeight(weight);
		setBPSy(bPSy);
		setBPdias(bPdias);
		setCancer(cancer);
		setDiabetes(diabetes);
		setAlzheimers(alzheimers);
		
	}
	@Override
	public String toString() {
		return String.format("Information for: \n"
				+ "%s %s \n"
				+ "Age: %d \n"
				+ "Height: %d in.\n"
				+ "Weight: %d lbs. \n"
				+ "BP Syst: %d \n"
				+ "Bp Dias: %d \n"
				+ "Cancer: %s \n"
				+ "Diabetes: %s \n"
				+ "Alzheimers: %s \n", 
				name, lastname, age, height, weight,
				BPSy, BPdias, cancer, diabetes, Alzheimers);
	}
	
	
}

