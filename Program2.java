/* Ceren Eren 150121054
 This program asks the user the enter a number, calculates and displays the value of that number in a certain sequence
 The sequence is: 0, 1, 4, 15, 56, 209, 780, 2911... 
 */

import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		
		//Create a Scanner
		Scanner input = new Scanner(System.in);
		
		//Prompt the user to enter a number
		System.out.print("Please enter an integer number: ");	
		
		//Assign variables to be used later on
		int number = input.nextInt();
		int value=0;
		int previousValue1=0;
		int previousValue2=0;
		
			//Calculate the value of the number in the sequence using if-else statements inside a for loop
			for(int i=1; i<=number; i++) {
				if(i==1) {
					previousValue2=0;
					value=0; }
				else if(i==2) {
					previousValue1=1;
					value=1;
				}
				else {
					value=(4*previousValue1) - previousValue2;
					previousValue2=previousValue1;
					previousValue1=value;
				}					
			}
		
		//Print the value
		System.out.println("In position " + number + ", the value is " + value + ".");

	}

}

