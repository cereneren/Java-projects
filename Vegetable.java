
public class Vegetable extends Food implements Washable, Vegan{
	
	public Vegetable() {
		this(10.0);
	}
	
	public Vegetable(double basePrice) {
		setBasePrice(basePrice);
	}

	//this method prints what the object is made of
	@Override
	public void madeOf() {
		System.out.println("It is made only of vegetables.");
		
	}

	//this method prints the instruction of how to wash the object
	@Override
	public void howToWash() {
		System.out.println("Wash Vegetable with warm water.");
		
	}

	//this method calculates the price of the object based on base price and vat
	@Override
	public double calculatePrice() {
		return getBasePrice()*(1 + getVat())*1.25;
	}
	
	
}
