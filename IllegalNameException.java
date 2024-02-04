
public class IllegalNameException extends Exception{
	private String name;
	
	//declaring class constructor
	public IllegalNameException(String name) {
		this.name=name;
	}

}
