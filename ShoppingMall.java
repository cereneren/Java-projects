import java.util.ArrayList;

public class ShoppingMall {
	//create arraylist to store items
	private static ArrayList<Item> items = new ArrayList<>();

	//getter method of the arraylist
	public static ArrayList<Item> getItems() {
		return items;
	}
	
	//add items to arraylist
	public void addDairy() {
		items.add(new Dairy());
	}
	
	public void addFruit() {
		items.add(new Fruit());
	}

	public void addTop() {
		items.add(new Top());
	}
	
	public void addTrousers() {
		items.add(new Trousers());
	}
	
	public void addUnderware() {
		items.add(new Underware());
	}
	
	public void addVegetable() {
		items.add(new Vegetable());
	}
	
	public void addArbitrary(Item item) {
		items.add(item);
	}
	
	//this method calculates and returns the total bill
	public double bill() {
		int sum=0;
		for(Item item: items) 
				sum += item.calculatePrice();
		
		return sum;
	}
}
