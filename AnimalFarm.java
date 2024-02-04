
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class AnimalFarm {
	private ArrayList<Animal> animalList = new ArrayList<>();
	private ArrayList<String> animalNames = new ArrayList<>();
	final private int CAPACITY;
	private static int numberOfAnimals=0;
	java.util.Date additionDate;
	
	//declaring class constructor
	public AnimalFarm(int capacity) {
		this.CAPACITY=capacity;
	}
	
	//adds the given animal to the farm
	public boolean addAnimal(Animal animal) throws IllegalNameException { 
		//checks if the name is unique
		if(!animalNames.contains(animal.getName())) {
			if(CAPACITY-numberOfAnimals>0) {
				animalList.add(animal);
				animalNames.add(animal.getName());
				numberOfAnimals++;
				
				return true;
			}
			else
				System.out.println("Capacity is full!");
			return false;
		}
		else { //throws exception if there's any
			throw new IllegalNameException(animal.getName());
		}
	}
	
	//removes the animal from the animal farm and the arraylists 
	public boolean removeAnimal(String name) {
		//checks if the animal exists
		if(animalNames.contains(name)) {
			int index = animalNames.indexOf(name);
			
			if(animalList.get(index) instanceof Chicken)
				Chicken.decrementCount();
			else if(animalList.get(index) instanceof Donkey)
				Donkey.decrementCount();
			else if(animalList.get(index) instanceof Horse)
				Horse.decrementCount();
			else if(animalList.get(index) instanceof Pig)
				Pig.decrementCount();
			else if(animalList.get(index) instanceof Raven)
				Raven.decrementCount();
			else if(animalList.get(index) instanceof Sheep)
				Sheep.decrementCount(); 
			
			animalList.remove(index);
			animalNames.remove(name);
			numberOfAnimals--;
					
			return true;
		}
		else
			return false;
	}
	
	//prints all animal greetings by invoking printing one animal greeting method
	public void printAllAnimalGreetings() {
		for (int i = 0; i < animalList.size(); i++) 
			printOneAnimalGreeting(animalList.get(i));
	}
	
	//prints the greeting of the given animal
	public void printOneAnimalGreeting(Animal animal) {
		animal.sayGreeting();
	}
	
	//prints the names of all the animals
	public void printAllAnimalNames() {
		for (int i = 0; i < animalList.size(); i++) 
			printOneAnimalName(animalList.get(i));
	}
	
	//prints the name of the given animal
	public void printOneAnimalName(Animal animal) { //Prints the given animal
		System.out.println(animal.getName());
	}
	
	//prints all animals by invoking their toString method
	public void printAllAnimals() { //Prints all animals in animalList
		for (int i = 0; i < animalList.size(); i++) 
			System.out.println(animalList.get(i).toString());
	}
	
	//estimates the next year's population with number of off springs and pregnancy per year variables
	public int nextYearPopulationForecast() {
		int sum=0;
		for (int i = 0; i < animalList.size(); i++)
			sum += animalList.get(i).getNumberOfOffsprings() + animalList.get(i).getPregnancyPerYear();
		return sum;
	}
	
	//prints all the animal movements
	public void animalMovements() {
		for (int i = 0; i < animalList.size(); i++) {
			System.out.print("My name is " + animalList.get(i).getName() + " and "); 
			
			if(animalList.get(i) instanceof Bird) 
				((Bird)animalList.get(i)).fly();
			
			else if (animalList.get(i) instanceof Mammal) 
				((Mammal)animalList.get(i)).walk();
		}		
	}
	
	//prints the eating habits of all animals
	public void eatingHabits() {
		for (int i = 0; i < animalList.size(); i++) {
			System.out.print("My name is " + animalList.get(i).getName() + " and "); 
			
			if(animalList.get(i) instanceof Bird) 
				((Bird)animalList.get(i)).omnivore();
			
			else if (animalList.get(i) instanceof Mammal) 
				((Mammal)animalList.get(i)).herbivore();
		}		
	}
	
	//sorts the animal alphabetically
	public void sortAlphabetically() { 
		//creating temporary variables to keep the original variables unchanged
		ArrayList<String> tempArr = new ArrayList<>();
		String temp;
		
		for (int i = 0; i < animalNames.size(); i++) 
			tempArr.add(animalNames.get(i));
		
		for (int i = 0; i < animalNames.size(); i++) {
			for (int j = i+1; j < animalNames.size(); j++) {
				if(tempArr.get(i).compareTo(tempArr.get(j))>0) {
					temp = tempArr.get(i);
					tempArr.set(i, tempArr.get(j));
					tempArr.set(j, temp);
				}		
			}	
		} 
		//displaying the sorted array
		for (int i = 0; i < tempArr.size(); i++) 
			System.out.println(tempArr.get(i));
	}
	
	//sorts the animals based on their leg numbers
	public void sortBasedOnLegNumber() {
		for (int i = 0; i < animalList.size(); i++) {
			if(animalList.get(i) instanceof Bird)
				System.out.println(animalList.get(i).getName() + " has " + animalList.get(i).getLegNumber() + " legs!");
		}
		
		for (int i = 0; i < animalList.size(); i++) {
			if(animalList.get(i) instanceof Mammal)
				System.out.println(animalList.get(i).getName() + " has " + animalList.get(i).getLegNumber() + " legs!");
		}	
	}
	
	//sorts the animals based on their ages
	public void sortBasedOnAge() {
		//creating temporary variables to keep the original variables unchanged
		ArrayList<Animal> tempArr = new ArrayList<>();
		Animal temp = new Animal(null,0);
		
		for (int i = 0; i < animalList.size(); i++) 
			tempArr.add(animalList.get(i));
		
		for (int i = 0; i < animalList.size(); i++) {
			for (int j = i+1; j < animalList.size(); j++) {
				if(tempArr.get(i).getAge()>=tempArr.get(j).getAge()) {
					temp = tempArr.get(i);
					tempArr.set(i, tempArr.get(j));
					tempArr.set(j, temp);
				}		
			}	
		} 
		//displaying the sorted array
		for (int i = 0; i < tempArr.size(); i++) 
			System.out.println(tempArr.get(i).getName() + " is " + tempArr.get(i).getAge() + " years old!");
	}
	
	//searchs the animal with the given name
	public void searchBasedOnName(String name) {
		//checks if the animal exists
		if(animalNames.contains(name)) {
			int index = animalNames.indexOf(name);
			System.out.println(animalList.get(index).toString());
		}
		else
			System.out.println("There's no such animal.");
	}
	
	//searches animal with the given age
	public void searchBasedOnAge(int age) {
		for (int i = 0; i < animalList.size(); i++) {
			//displays results
			if(animalList.get(i).getAge()==age)
				System.out.println(animalList.get(i).toString());
		}
	}
	
	//creates a file with the given name and prints the animal info on the file
	public void printReport(String fileName) throws Exception {
		try ( java.io.PrintWriter pw = new java.io.PrintWriter(fileName)){
			pw.println("We have a total of " + AnimalFarm.numberOfAnimals + " animals in the farm.");
			
			//check if there's any chicken
			if(Chicken.getCount()>0) {
				pw.println("    *" + Chicken.getCount() + " of them are Chicken. Those are:");
				pw.println("        Name           Age            Leg Number");
				for (Animal animal: animalList) {
					if(animal instanceof Chicken)
						pw.printf("        %-15s%-15s%-15s\n", animal.getName(),animal.getAge(),animal.getLegNumber());
				}
			}
			
			//check if there's any donkey
			if(Donkey.getCount()>0) {
				pw.println("    *" + Donkey.getCount() + " of them are Donkey. Those are:");
				pw.println("        Name           Age            Leg Number");
				for (Animal animal: animalList) {
					if(animal instanceof Donkey)
						pw.printf("        %-15s%-15s%-15s\n", animal.getName(),animal.getAge(),animal.getLegNumber());
				}
			}
			
			//check if there's any horse
			if(Horse.getCount()>0) {
				pw.println("    *" + Horse.getCount() + " of them are Horse. Those are:");
				pw.println("        Name           Age            Leg Number");
				for (Animal animal: animalList) {
					if(animal instanceof Horse)
						pw.printf("        %-15s%-15s%-15s\n", animal.getName(),animal.getAge(),animal.getLegNumber());
				}
			}
			
			//check if there's any pig
			if(Pig.getCount()>0) {
				pw.println("    *" + Pig.getCount() + " of them are Pig. Those are:");
				pw.println("        Name           Age            Leg Number");
				for (Animal animal: animalList) {
					if(animal instanceof Pig)
						pw.printf("        %-15s%-15s%-15s\n", animal.getName(),animal.getAge(),animal.getLegNumber());
				}
			}
			
			//check if there's any raven
			if(Raven.getCount()>0) {
				pw.println("    *" + Raven.getCount() + " of them are Raven. Those are:");
				pw.println("        Name           Age            Leg Number");
				for (Animal animal: animalList) {
					if(animal instanceof Raven)
						pw.printf("        %-15s%-15s%-15s\n", animal.getName(),animal.getAge(),animal.getLegNumber());
				}
			}
			
			//check if there's any sheep
			if(Sheep.getCount()>0) {
				pw.println("    *" + Sheep.getCount() + " of them are Sheep. Those are:");
				pw.println("        Name           Age            Leg Number");
				for (Animal animal: animalList) {
					if(animal instanceof Sheep)
						pw.printf("        %-15s%-15s%-15s\n", animal.getName(),animal.getAge(),animal.getLegNumber());
				}
			}
			//close the file
            pw.close();
         }
        

	}

	//getter setter methods
	public ArrayList<Animal> getAnimalList() {
		return animalList;
	}

	public void setAnimalList(ArrayList<Animal> animalList) {
		this.animalList = animalList;
	}

	public ArrayList<String> getAnimalNames() {
		return animalNames;
	}

	public void setAnimalNames(ArrayList<String> animalNames) {
		this.animalNames = animalNames;
	}

	public int getCAPACITY() {
		return CAPACITY;
	}
	
	public int getNumberOfAnimals() {
		return numberOfAnimals;
	}

	public static void setNumberOfAnimals(int numberOfAnimals) {
		AnimalFarm.numberOfAnimals = numberOfAnimals;
	}
	
	
	
}

