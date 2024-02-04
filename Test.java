/* Ceren Eren 150121054 this program creates a shopping mall simulator with oop approach. In this simulation you can create a shopping mall object and
 * store items in it. You can get "how to wash", "made out of" informations of objects by invoking necessary methods and you can get a bill of the
 * items you purchase.  */

public class Test {

	public static void main(String[] args) {
		
		//adding shopping items
		ShoppingMall mall = new ShoppingMall();
		ShoppingMall.getItems().add(new Dairy());
		ShoppingMall.getItems().add(new Fruit());
		ShoppingMall.getItems().add(new Top());
		ShoppingMall.getItems().add(new Trousers());
		ShoppingMall.getItems().add(new Underware());
		ShoppingMall.getItems().add(new Vegetable());
		ShoppingMall.getItems().add(new Top(100.0));
		
		//invoking necessary methods
		printContent();
		printWashingInstructions();
		
		System.out.println(mall.bill());
	}
	
	//this method prints what all the vegan objects in the shopping mall are made of
	public static void printContent() {
		for(Item item: ShoppingMall.getItems()) {
			if(item instanceof Vegan)
				((Vegan) item).madeOf();
		}
	}
	
	//this method prints all the washing intructions of washable objects
	public static void printWashingInstructions() {
		for(Item item: ShoppingMall.getItems()) {
			if(item instanceof Washable)
				((Washable) item).howToWash();
		}
	}

}
