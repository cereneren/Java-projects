
public class Chicken extends Bird {
	private static int count;
	
	//declaring class constructor
	public Chicken(String name, int age) {
		//invoking super class' constructor
		super(name,age);	
		super.setLegNumber(2);
		super.setNumberOfOffsprings(1);
		super.setPregnancyPerYear(200);
		count++;
	}
	
	@Override
	public void sayGreeting() { //Overrides the sayGreeting method
		System.out.println("I have nothing to say other than I am against Pigs!");
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

