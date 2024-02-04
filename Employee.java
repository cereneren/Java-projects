//Ceren Eren 150121054 
//This class is implemented to create an employee with given properties, implement startShift and endShift methods
//And to display employee's attributes with toString() method

class Employee {
	
	//Declare variables needed for class
	private int id;
	private String name;
	private String surname;
	private int workHour;
	private int speed;
	private Item[] items;
	private Payroll payroll;
	
	//Create an employee object with the given id, name, surname, workHour and speed
	public Employee (int id, String name, String surname, int workHour, int speed) {
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.workHour=workHour;
		this.speed=speed;
	}
	
	//Implement startShift() method to start the shift of the employee then return items created by employee in an array
	public Item[] startShift() { //shuffle
		
		//Create a temporary array with size of employee's item count
		int[] tempArr=new int[speed*workHour];
		
		//For each object created, assign an id between 1-100
		for (int i = 0; i < speed*workHour; i++) {
			tempArr[i]=(int)(Math.random()*101);
			for (int j = 0; j < i; ) {
				if(tempArr[i]==tempArr[j]) {
					tempArr[i]=(int)(Math.random()*101);
					j=0;
				}
				else
					j++;
			}		
		}
		
		//Increase the items array's length by one
		items = new Item[speed*workHour];
		
		for (int i = 0; i < speed*workHour; i++) {
				items[i]= new Item(tempArr[i]);
		}
		return items;
	}
	
	//Implement endShift() method to end the shift of the employee, create a payroll object for the employee and return it
	public Payroll endShift() {
		Payroll payroll= new Payroll(workHour,items.length);
		return payroll;
	}
	
	//Return a String displaying id, speed, work hour and item count of the employee
	public String toString() {
		return "This is the employee with id " + id + " speed " + speed + ". The work hour is " + workHour +
				" and the produced item count is " + speed*workHour + ".";
	}
	
	//Implement getter-setter methods for the variables
	public int getId() {
		return id;
	}
	
	public void setId(int newId) {
		id=newId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name=newName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String newSurname) {
		surname=newSurname;
	}
	
	public int getWorkHour() {
		return workHour;
	}
	
	public void setWorkHour(int newWorkHour) {
		workHour=newWorkHour;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int newSpeed) {
		speed=newSpeed;
	}
	
	public Item[] getItems() {
		return items;
	}
	
	public void setItems(Item[] newItems) {
		items=newItems;
	}
	
}
