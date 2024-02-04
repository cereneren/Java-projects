//Ceren Eren 150121054 
//This class creates items with the given id's and counts how many items have been created since the beginning of the program

class Item {
	private int id;
	public static int numberOfItems;
	
	//Create an item with the given id and increment numberOfItems
	public Item(int id) {
		this.id=id;
		numberOfItems++;
	}
	
	//Implement getter-setter methods for the variable id
	public int getId() {
		return id;
	}
	
	public void setId(int newId) {
		id=newId;
	}

}
