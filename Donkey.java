
public class Donkey extends Mammal {
	private static int count;
	
	//declaring class constructor
	public Donkey(String name, int age) {
		//invoking super class' constructor
		super(name,age);
		super.setLegNumber(4);
		super.setNumberOfOffsprings(1);
		super.setPregnancyPerYear(1);
		count++;
	}
	
	@Override
	public void sayGreeting() { //Overrides the sayGreeting method
		System.out.println("Life will go on as it has always gone –that is, badly!");
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
