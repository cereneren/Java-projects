/* Ceren Eren 150121054
The Private Pension System, PPS for short, is a special pension system in order to enable you to spend your retirement happily by 
means of regular savings. This program takes the input of user's salary, the portion of user's salary user wants to save, the monthly
interest rate and government support rate. Then it displays the value of user's saving account for six months and the value saved by
user's salary and user's total profit.  */

import java.util.Scanner;

public class Pro3_150121054 {

	public static void main(String[] args) {
		
		// This line takes an input from the user
		Scanner input = new Scanner(System.in);
		
		// This line creates a variable named salary
		System.out.print("Please enter your salary= ");
		float salary = input.nextFloat();
		
		// This line creates a variable named portionToBeSaved and converts it into percentage 
		System.out.print("Please enter the portion of your salary to be saved= ");
		float portionToBeSaved = input.nextFloat();
		portionToBeSaved = portionToBeSaved / 100.0f;
		
		// This line creates a variable named monthlyInterestRate and converts it into percentage 
		System.out.print("Please enter monthly interest rate= ");
		float monthlyInterestRate = input.nextFloat();
		monthlyInterestRate = monthlyInterestRate / 100.0f;
		
		// This line creates a variable named portionToBeSaved and converts it into percentage 
		System.out.print("Please enter government support rate= ");
		float govermentSupportRate = input.nextFloat();
		govermentSupportRate = govermentSupportRate / 100.0f;
		
		// This set of lines compute the account's first six months' value with the formula given 
		double firstmonth = salary * portionToBeSaved * (1 + govermentSupportRate) * (1 + monthlyInterestRate);
		double secondmonth = (firstmonth + salary * portionToBeSaved * (1 + govermentSupportRate)) * (1 + monthlyInterestRate);
		double thirdmonth = (secondmonth + salary * portionToBeSaved * (1 + govermentSupportRate)) * (1 + monthlyInterestRate);
		double fourthmonth = (thirdmonth + salary * portionToBeSaved * (1 + govermentSupportRate)) * (1 + monthlyInterestRate);
		double fifthmonth = (fourthmonth + salary * portionToBeSaved * (1 + govermentSupportRate)) * (1 + monthlyInterestRate);
		double sixthmonth = (fifthmonth + salary * portionToBeSaved * (1 + govermentSupportRate)) * (1 + monthlyInterestRate);
		
		// This line computes total saving 
		double totalSaving = (int)((6 * salary * portionToBeSaved) * 100)/100.0;
		
		// This line computes the profit
		double profit = sixthmonth - totalSaving;

		/* This set of lines display the value of user's saving account for six months and the value saved by user's
	 	salary and user's total profit */
		System.out.println("After the first month, the account value is " + (int)(firstmonth*100)/100.0 + " TLs ");
		System.out.println("After the second month, the account value is " + (int)(secondmonth*100)/100.0 + " TLs ");
		System.out.println("After the third month, the account value is " + (int)(thirdmonth*100)/100.0 + " TLs ");
		System.out.println("After the fourth month, the account value is " + (int)(fourthmonth*100)/100.0 + " TLs ");
		System.out.println("After the fifth month, the account value is " + (int)(fifthmonth*100)/100.0 + " TLs ");
		System.out.println("After the sixth month, the account value is " + (int)(sixthmonth*100)/100.0 + " TLs ");
		System.out.println("In total, you saved " + totalSaving + " TLs and your profit is " + (int)(profit*100)/100.0 + " TLs ");
		
		
	}

}