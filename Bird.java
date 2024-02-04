
public class Bird extends Animal {
	
	//declaring class constructor
	public Bird(String name, int age) {
		//invoking super class' constructor
		super(name,age);
	}
	
	public void fly() { // prints the flying activity of the animal
		System.out.println("I can fly to the endless skies!");
	}
	
	@Override
	public void reproduce() { //prints the reproducing activity of the animal
		System.out.println("I lay eggs!");
	}
	
	public void omnivore() { //prints the eating habit of the animal
		System.out.println("I can eat everything!");
	}
	
}
