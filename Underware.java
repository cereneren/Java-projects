
public class Underware extends Clothing{
	
	public Underware() {
		this(30.0);
	}
	
	public Underware(double basePrice) {
		setBasePrice(basePrice);
	}

	//this method prints the instruction of how to wash the object
	@Override
	public void howToWash() {
		System.out.println("Wash Underware at 60 degrees.");
		
	}

	//this method calculates the price of the object based on base price and vat
	@Override
	public double calculatePrice() {
		return getBasePrice()*(1 + getVat())*1.45;
	}
}
