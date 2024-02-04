//Ceren Eren 150121054 
//This class creates a payroll for employees and implements needed methods

class Payroll {
	private int workHour;
	private int itemCount;
	
	//Create a payroll with the given workHour and itemCount 
	public Payroll(int workHour, int itemCount) {
		this.workHour=workHour;
		this.itemCount=itemCount;

	}
	
	//Calculate salary of the employee according to the work hour and item count 
	public int calculateSalary() {
		
		return workHour*30 + itemCount*20;
	}
	
	//Return a String showing work hour and item count of the employee
	public String toString() {
		return "The work hour is " + workHour + " and the produced item count is " + itemCount;
	}
	
	
	//Implement getter-setter methods for the variables
	public int getWorkHour() {
		return workHour;
	}
	
	public void setNumberOfItems(int newWorkHour) {
		workHour=newWorkHour;
	}
	
	public int getItemCount() {
		return itemCount;
	}
	
	public void setItemCount(int newItemCount) {
		itemCount=newItemCount;
	}
}
