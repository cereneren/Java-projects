/* Ceren Eren 150121054
 This program takes an string input from the user and displays the string on a certain pattern depending on 
 the string length and if the user enters QUIT, the program terminates. */

import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) {
		
		//Create a Scanner 
		Scanner input= new Scanner(System.in);
		
		for( ; ; ) {
			
		//Prompt the user to enter a string in a for loop 
		System.out.print("Enter an input string: ");
		String inputString = input.nextLine();
		
		//Convert the string to all upper case
		inputString=inputString.toUpperCase();
		
		
		//Terminate the program if the user enters "QUIT" or "quit"
		if (inputString.equalsIgnoreCase("QUIT")) { 
		System.out.println("OK. Good bye :-)");
		break;
		}
		
		
			//Create the first half of the pattern using nested for loops then display
			for (int i=inputString.length(); i>0; i--) {
			System.out.print(inputString.substring(0,i));
			
				for (int j=0; j<(inputString.length()-i)*2; j++) 
				System.out.print(" ");
			
			//Display the space between letters
			System.out.print(inputString.substring(inputString.length()-i,inputString.length()));
			System.out.println();
			
			}
			
			//Create the second half of the pattern using nested for loops then display
			for(int i=1; i<=inputString.length();i++) {
				System.out.print(inputString.substring(0,i));
				
				for (int j=0; j<(inputString.length()-i)*2; j++) 
				System.out.print(" ");
				
			//Display the space between letters
			System.out.print(inputString.substring(inputString.length()-i,inputString.length()));
			System.out.println();
			
			}
			
		}
	}

}
