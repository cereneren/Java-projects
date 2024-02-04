//Ceren Eren 150121054 
//This class is implemented to store the objects created by employees in an array with given capacity

class Storage {
	private int capacity;
	private Item[] items;
	
	//Create a storage object with the given capacity
	public Storage(int capacity) {
		this.capacity=capacity;
	}
	
	//Resize the items array then add the given item to the array
	public void addItem(Item item) { 
		
		if(item.numberOfItems>capacity) {
			System.out.println("Storage is full");
			System.exit(1);
		}
			
		
		else {
		
		//Create a temporary array to store the objects in the items array
		Item[] tempArr = new Item[item.numberOfItems-1];
		this.items = new Item[item.numberOfItems-1];
		
		for (int i = 0; i < tempArr.length; i++) 
			tempArr[i]=this.items[i];
		
		//Increase the items array's length by one
		this.items= new Item[this.items.length+1];
		
		for (int i = 0; i < tempArr.length; i++) 
			this.items[i]=tempArr[i];
		
		//Add the given object to the array
		this.items[tempArr.length]=item;
		}
	}

	//Implement getter-setter methods for the variables
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int newCapacity) {
		capacity=newCapacity;
	}

	public Item[] getItems() {
		return items;
	}
	
	public void setItems(Item[] newItems) {
		items=newItems;
	}
}
