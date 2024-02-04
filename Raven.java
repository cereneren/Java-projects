
public class Raven extends Bird {
	private static int count;
	
	//declaring class constructor
	public Raven(String name, int age) {
		//invoking super class' constructor
		super(name,age);
		super.setLegNumber(2);
		super.setNumberOfOffsprings(5);
		super.setPregnancyPerYear(1);
		count++;
	}
	
	@Override
	public void sayGreeting() { //Overrides the sayGreeting method
		System.out.println("A happy country where we poor animals shall rest forever!");
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
