
public class Fruit extends Food implements Washable, Vegan {
	
	public Fruit() {
		this(6.0);
	}
	
	public Fruit(double basePrice) {
		setBasePrice(basePrice);
	}

	//this method prints what the object is made of
	@Override
	public void madeOf() {
		System.out.println("It is made only of fruits.");
		
	}
	
	//this method prints the instruction of how to wash the object
	@Override
	public void howToWash() {
		System.out.println("Wash Fruit with cold water");
		
	}
	
	//this method calculates the price of the object based on base price and vat
	@Override
	public double calculatePrice() {
		return getBasePrice()*(1 + getVat())*1.2;
	}

}
