
public class Sheep extends Mammal {
	private static int count = 0;
	
	//declaring class constructor
	public Sheep(String name, int age) {
		//invoking super class' constructor
		super(name,age);
		super.setLegNumber(4);
		super.setNumberOfOffsprings(1);
		super.setPregnancyPerYear(1);
		count++;
	}
	
	@Override
	public void sayGreeting() { //Overrides the sayGreeting method
		System.out.println("Four legs good, two legs better!");
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
