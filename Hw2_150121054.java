/* Ceren Eren 150121054
 This program takes 2 integer numbers, base and operation input from the user and calculates the operation in the base given 
 by the user, then displays the result. */
 


import java.util.Scanner;
public class Hw2_150121054 {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		
		//Prompt the user to enter base, operation to be done and 2 integer numbers	
		System.out.print("Enter the base of the number system: ");
		int base= input.nextInt();
		
		System.out.print("Enter the type of the operation: ");
		String op=input.next();
		
		System.out.print("Enter the input numbers: ");
		int number1= input.nextInt();
		int number2= input.nextInt();
		
		//Assign variables to be used later on
		int convertedNum1 =0;
		int convertedNum2 =0;
		int convertedResult=0;
		String result = "";
		
		//Convert number1 in the given base to decimal's (base-10) base
		while (number1>0) {
			
			for(int i=0; i<11; i++) {
			int remainder1= (number1 % 10)*(int)Math.pow(base, i);
			
			convertedNum1 = remainder1 + convertedNum1;
			number1 /= 10;
			}
		}
		
		//Convert number2 in the given base to decimal's (base-10) base
		while (number2>0) {
					
			for(int i=0; i<11; i++) {
			int remainder2= (number2 % 10)*(int)Math.pow(base, i);
					
			convertedNum2 = remainder2 + convertedNum2;
			number2 /= 10;
			}
		}
		
		
		//Check the operation input and calculate the result according to the operation in base-10 using switch-case statement
		switch (op) {
		
			case "a":
			case "A":
				convertedResult = convertedNum1 + convertedNum2;
				
				break;
				
			case "s":
			case "S":
				
				//Check if converted number2 is bigger than converted number1, if so, replace the numbers
				if(convertedNum2 > convertedNum1) {
					int temp = convertedNum2;
					convertedNum2 = convertedNum1;
					convertedNum1 = temp;
				}
				convertedResult = convertedNum1 - convertedNum2;
				
				break;
				
			case "m":
			case "M":
				convertedResult = convertedNum1 * convertedNum2;
				
				break;
				
			case "d":
			case "D":
				
				//Check if converted number2 is bigger than converted number1, if so, replace the numbers
				if(convertedNum2 > convertedNum1) {
					int temp = convertedNum2;
					convertedNum2 = convertedNum1;
					convertedNum1 = temp;
				}
				convertedResult = convertedNum1 / convertedNum2;
				
				break;
			default: System.exit(1);	
		
		}
		
		//Convert the result back to its original base
		while (convertedResult > 0) { 
	    	int remainder = convertedResult % base;
	    	convertedResult = convertedResult / base;
	    	result = remainder + result;
	    	
	    	 }
		
		//Display the result
		System.out.print(result);
		
	}
	
}
