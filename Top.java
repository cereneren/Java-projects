
public class Top extends Clothing {
	
	public Top() {
		this(20.0);
	}
	
	public Top(double basePrice) {
		setBasePrice(basePrice);
	}

	//this method prints the instruction of how to wash the object
	@Override
	public void howToWash() {
		System.out.println("Wash Top at 40 degrees.");
	}

	//this method calculates the price of the object based on base price and vat
	@Override
	public double calculatePrice() {
		return getBasePrice()*(1 + getVat())*1.2;
	}
}
