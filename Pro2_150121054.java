/* Ceren Eren 150121054
This program asks the user how many eggs she has and computes how many gross, how many dozen and how many extra eggs are left over */

import java.util.Scanner;

public class Pro2_150121054 {

	public static void main(String[] args) {
		//This line takes an input from the user
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your total amount of eggs= ");
		
		int eggAmount = input.nextInt();
		
		// This line computes the gross amount
		int grossAmount = eggAmount / 144;
		
		// This line computes the dozen amount
		int dozenAmount = eggAmount % 144 / 12;
		
		// This line computes the remaining amount 
		int remainingAmount = eggAmount % 12;
		
		// This line displays the result
		System.out.println("Your number of eggs is " + grossAmount + " gross, " + dozenAmount + " dozen, and " + remainingAmount );
		

	}

}