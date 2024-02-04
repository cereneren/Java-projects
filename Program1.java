/* Ceren Eren 150121054
This program takes a sequence of characters and draws the image they represent according to the characters 
and the digits before characters.
 */


import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {
		
		//Create a Scanner
		Scanner input = new Scanner(System.in);
		
		
		//Prompt the user to enter the sequence as a string
		System.out.println("Welcome to the image printer program.");
		System.out.print("Please enter your sequence:");

		
		String sequence = input.nextLine();
		
		//Assign a coefficient value
		int coef=1;
		
		for(int i=0; i<sequence.length(); i++) {
			
			
			char ch = sequence.charAt(i);
			
			
			//Assign a value and equalize it to coefficient value
			int n=coef;
			coef=ch;
			
			//Check if the character is a digit or a letter, if it's a digit continue the loop and go to the next character
			if (coef >=48  && coef <=57 ) {
				coef -=48;
				continue;	
				
			}
			
			//When the character is a letter, print the image it represents according to its coefficient using for loop
			else {
			
				for(int j=1; j<=n; j++) {
					if (ch=='b')
					System.out.print(" ");
					else if (ch=='s')
					System.out.print("*");
					else if (ch=='n')
					System.out.println();
					
				}
				
			//Assign the coefficient value to 1 again
			coef=1;
			
			}
			
		}		
		
		
	}

}
