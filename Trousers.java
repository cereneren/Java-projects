
public class Trousers extends Clothing{
	
	public Trousers() {
		this(40.0);
	}
	
	public Trousers(double basePrice) {
		setBasePrice(basePrice);
	}

	//this method prints the instruction of how to wash the object
	@Override
	public void howToWash() {
		System.out.println("Wash Trousers at 30 degrees.");
		
	}
	
	//this method calculates the price of the object based on base price and vat
	@Override
	public double calculatePrice() {
		return getBasePrice()*(1 + getVat())*1.2;
	}

	
}
