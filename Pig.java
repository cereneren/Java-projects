
public class Pig extends Mammal {
	private static int count;
	
	//declaring class constructor
	public Pig(String name, int age) {
		//invoking super class' constructor
		super(name,age);
		super.setLegNumber(4);
		super.setNumberOfOffsprings(12);
		super.setPregnancyPerYear(2);
		count++;
	}
	
	@Override
	public void sayGreeting() { //Overrides the sayGreeting method
		System.out.println("All animals are equal, but some animals are more equal than others!");
	}
	
	//getter setter methods
	public static int getCount() {
		return count;
	}
	
	//decrements the count
	public static void decrementCount() {
		count--;
	}
	
}
