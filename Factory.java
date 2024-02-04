//Ceren Eren 150121054 
//This class is implemented to create a factory object with the given properties and implement methods to get revenue, 
//get paid salaries, add & remove employees and add payroll

class Factory {
	
	//Declare variables needed for class
	private String name;
	private Employee[] employees = new Employee[1];
	private Storage storage;
	private Payroll[] payrolls = new Payroll[1];
	private double itemPrice;
	private int numberOfEmployees=0;
	private int numberOfPayrolls=0;
	
	//Create a factory object with the given name, capacity and item price
	public Factory(String name, int capacity, double itemPrice) { 
		this.name=name;
		this.itemPrice=itemPrice;
		Storage storage= new Storage(capacity);		
		this.storage=storage;
	}
	
	//Calculate revenue and return it
	public double getRevenue() {
		return storage.getItems().length*itemPrice;
	}
	
	//Calculate paid salaries and return it
	public double getPaidSalaries() { 
		double totalPayrolls=0;
		for (int i = 0; i < payrolls.length; i++) {
			totalPayrolls += payrolls[i].calculateSalary();
		}	
		return totalPayrolls;
	}
	
	//Resize the employees array, add new employee to the array and start the shift of new employee
	public void addEmployee(Employee employee) {
		numberOfEmployees++;
		employee.startShift();

		
		//Create a temporary employee array
		Employee[] tempEmp = new Employee[numberOfEmployees];
		
		//Assign objects in the employees array to temporary array
		for (int i = 0; i < employees.length; i++) {
			tempEmp[i] = this.employees[i];
		}
		
		//Increase the employees array's length by one
		this.employees = new Employee[numberOfEmployees];
		
		for (int i = 0; i < tempEmp.length; i++) {
			this.employees[i] = tempEmp[i];
		}
		
		//Assign new employee to employees array's last index
		this.employees[numberOfEmployees-1] = employee;
		
		//Add item returned from the startShift() method to storage
		for (int i = 0; i < employee.getItems().length; i++) {
			storage.addItem(employee.getItems()[i]);
		}
		
		
	}
	
	//Resize employees array, remove the employee with the given id from array, return the removed employee
	public Employee removeEmployee(int id) {
		
		//Create a temporary array to store the objects in the employees array
		Employee[] tempArr = new Employee[numberOfEmployees];
		int employeeNum=0;
		
		//If there are no employees print the appropriate message 
		if (numberOfEmployees==0) {
			System.out.println("There are no employees!");
			return null;
		}
			
		
		else {
			boolean doesExist=false;
			
			//Check if the employee with the given id exists
			for (int i = 0; i < numberOfEmployees; i++) {
				if (employees[i].getId()==id) {
					employeeNum=i;
					doesExist=true;
				}	
			}
			
			//If employee with the given id does not exist print the appropriate message 
			if (doesExist==false) 
				System.out.println("Employee does not exist!");
			
			
			
			if(doesExist==true) {
				tempArr[numberOfEmployees-1]=employees[employeeNum];
				numberOfEmployees--;
				//Add payroll to the removed employee
				addPayroll(employees[employeeNum].endShift());
				
				
				//Remove the employee from the array then create a new array with smaller size assign the current array to it
				for (int i= employeeNum; i < numberOfEmployees; i++) {
						employees[i]=employees[i+1];
				}
				for (int i = 0; i < employees.length; i++) {
					tempArr[i]=employees[i];
				}
				
				employees = new Employee[numberOfEmployees];
				
				for (int i = 0; i < employees.length; i++) 
					employees[i]=tempArr[i];
				
				//Return the removed employee
				return tempArr[numberOfEmployees];
			}
		}
		return null;
	}
	
	//Resize the payrolls array and add the given payroll to payrolls array
	private void addPayroll(Payroll payroll) {
		numberOfPayrolls++;
		
		//Create a temporary payrolls array to store objects in the payrolls array
		Payroll[] tempPay = new Payroll[payrolls.length];
			
		for (int i = 0; i < tempPay.length; i++) 
			tempPay[i]=payrolls[i];
			
		//Increase the payroll array's length by one
		payrolls = new Payroll[numberOfPayrolls];
			
		for (int i = 0; i < tempPay.length; i++) 
			payrolls[i]=tempPay[i];
			
		//Add the given payroll to payrolls array	
		payrolls[payrolls.length-1]=payroll;
		}
	
	//Implement getter-setter methods of variables
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name=newName;
	}
	
	public Employee[] getEmployees() {
		return employees;
	}
	
	public void setEmployee(Employee[] newEmployee) {
		employees=newEmployee;
	}
	
	public Storage getStorage() {
		return storage;
	}
	
	public void setStorage(Storage newStorage) {
		storage=newStorage;
	}
	
	public Payroll[] getPayrolls() {
		return payrolls;
	}
	
	public void setPayroll(Payroll[] newPayroll) {
		payrolls=newPayroll;
	}
	
	public double itemPrice() {
		return itemPrice;
	}
	
	public void setItemPrice(double newItemPrice) {
		itemPrice=newItemPrice;
	}
		
}
