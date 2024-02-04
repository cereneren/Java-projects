
public class Animal {
	//declaring variables to be used later on
	private String name;
	private int legNumber;
	private int age;
	private int pregnancyPerYear;
	private int numberOfOffsprings;
	
	//declaring class constructor
	public Animal(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public void sayGreeting() { //prints the greeting of the animal
		System.out.println("Have nothing to say!");
	}
	
	public void reproduce() { //prints the reproducing activity of the animal
		System.out.println("None of your business!!");
	}
	
	@Override
	public String toString() { //returns a string containing name, age and leg number of the animal
		return "My name is " + name + "! \nI am " + age + " years old!" + "\nI have " + legNumber + " legs!";
	}
	
	
	
	//getter setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLegNumber() {
		return legNumber;
	}

	public void setLegNumber(int legNumber) {
		this.legNumber = legNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPregnancyPerYear() {
		return pregnancyPerYear;
	}

	public void setPregnancyPerYear(int pregnancyPerYear) {
		this.pregnancyPerYear = pregnancyPerYear;
	}

	public int getNumberOfOffsprings() {
		return numberOfOffsprings;
	}

	public void setNumberOfOffsprings(int numberOfOffsprings) {
		this.numberOfOffsprings = numberOfOffsprings;
	}
	
}
