
public abstract class Item {
	//declare variables
	private double vat;
	private double basePrice;
	
	public abstract double calculatePrice();
	
	//getter setter methods
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	

}
