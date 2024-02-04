
public class Mammal extends Animal {
	
	//declaring class constructor
	public Mammal(String name, int age) {
		//invoking super class' constructor
		super(name,age); 
	}
	
	public void walk() { // prints the walking activity of the animal
		System.out.println("I can walk to the far away lands!");
	}
	
	@Override
	public void reproduce() { //prints the reproducing activity of the animal
		System.out.println("I give birth!");
	}
	
	public void herbivore() { //prints the eating habit of the animal
		System.out.println("I eat plants only!");
	}
	
}
