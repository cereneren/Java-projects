/* Ceren Eren 150121054 
This program takes inputs from the user and performs the following operations: 
• Changing case of a given String, 
• Counting occurrences of a given word in a given sentence, 
• Encryption of a given String based on a given pattern, 
• Printing the statistics about all inputs by implementing several methods. 
 */

import java.util.Scanner;

public class HW4 {

	public static void main(String[] args) {
		
		//Create a Scanner object
		Scanner input = new Scanner(System.in);
		
		//Declare variables to use later on
		int totalNumberOfWords=0;
		int totalNumberOfLetters=0;
	
		
		//Implement for loop for main body of the program		
		for( ; ; ) {
			System.out.println("Menu:");
			System.out.println("1. Change Case");
			System.out.println("2. Count occurences");
			System.out.println("3. Encryption");
			System.out.println("4. Statistics");
			System.out.println("5. Exit");
			System.out.println();
			System.out.print("Please select an option: ");
			
			//Prompt user to enter a selection from the menu
			int selection = input.nextInt();
			
			//Perform operation 4 and 5
			if(selection==5) {
				System.out.print("Program ends. Bye :)");
				break; }
			if (selection==4) {
			printStat(totalNumberOfWords-1, totalNumberOfLetters);
				continue; }
			
			//Prompt user to enter input String
			System.out.print("Please enter an input String: ");
			input.nextLine();
			String s=input.nextLine();
			
			//Declare an array consisting of the words of the String
			String[] list = new String[wordCount(totalNumberOfWords,s)];
			assignArray(list,s);
			
			
			//Perform operation entered by the user using switch-case statement
			switch (selection) {
			case 1:
				System.out.println(changeCase(s));
				break;
				
			case 2:
				System.out.print("Please enter an input word: ");
				String word = input.nextLine();
				
				//If any, print how many times the given word occurred
				if(countOccurences(list,word)==0)
					System.out.println(word + " doesn't appear in this sentence." );
				else
					System.out.println(word + " appears " + countOccurences(list,word) + " time(s) in this sentence." );
				break;
				
			case 3:
				//Prompt user to enter pattern integer
				System.out.print("Enter an integer pattern: ");
				int pattern=input.nextInt();
				
				System.out.println(encryption(s,pattern));
				break;
			
			//Create a default option
			default:
				System.out.println("Please select a number on the menu.");
		}
			
			//Decrease the total number of words if the word doesn't consist of letters
			for(int i=0; i<list.length; i++) {
				for(int j=0; j<list[i].length();j++) {
					if((list[i].charAt(j)>=65 && list[i].charAt(j)<=90) || (list[i].charAt(j)>=97 && list[i].charAt(j)<=122))
						break;
					else
						totalNumberOfWords--;
						break;
				}
			}
			
			//Update the total number of letters and total number of words
			totalNumberOfLetters=updateLetterCount(totalNumberOfLetters, s);
			totalNumberOfWords=updateWordCount(totalNumberOfWords, s);
			
			System.out.println();
		}
			
	}
	
	//Create a method which returns the current word count in the loop
	public static int wordCount(int count, String str) {
			count=0;
		
			for(int i=0; i<str.length(); i++) {
				if (str.charAt(i)==' ')
					count++;		
			}
			return count+1;
	}
	
	//Create a method which returns the total number of letters the user has entered since the program starts 
	public static int updateLetterCount(int count, String str) {
		
		
		for(int i=0; i<str.length(); i++) {
			if((str.charAt(i)>=65 && str.charAt(i)<=90) || (str.charAt(i)>=97 && str.charAt(i)<=122))
				count++;
			
		}
		
		return count;

	}

	//Create a method which returns the total number of words the user has entered since the program starts
	public static int updateWordCount(int count, String str) {
		for(int i=0; i<str.length(); i++) {
			if (str.charAt(i)==' ')
				count++;		
		}
		return ++count;
	}
	
	//Create a method which returns the stats of the total words and letters entered
	public static void printStat (int wordCount, int letterCount) {
		String str ="";
		
		System.out.println("Number of words: " + updateWordCount(wordCount,str));
		System.out.println("Number of alphabetic letters: " + updateLetterCount(letterCount,str));
	}
	
	
	//Create a method which changes the case of the letter to the opposite and returns them as a new String
	public static String changeCase (String str) {
		char ch=str.charAt(0);
		String newStr="";
		
		for(int i=0; i<str.length(); i++) {
			ch=str.charAt(i);
			if(Character.isLowerCase(ch)) 
				newStr = newStr + Character.toUpperCase(ch);
			else
				newStr = newStr + Character.toLowerCase(ch);
		}
			
		return newStr;
	}
	
	
	//Create a method which counts the occurrence of the given word and returns the count value
	public static int countOccurences (String[] sentence, String word) {
		int count=0;
		for (int i=0; i< sentence.length; i++) {
			if (word.equalsIgnoreCase(sentence[i]))
				count++;
		}
		return count;
	}

	//Create a method which assigns an array consisting of the each word of the String the user has entered
	public static void assignArray(String array[], String str) {
		int n=str.indexOf(" ");
		
		for(int i=0; i<array.length-1; i++) {
			if(i==0)
				array[i]=str.substring(0,n);
			else {
				array[i]= str.substring(n+1,(str.indexOf(" ", n+1)));
				n=(str.indexOf(" ", n+1));
			}
			array[(array.length-1)]= str.substring(str.lastIndexOf(" ")+1,str.length());
		}
		
	}

	//Create a method which encrypts the given String based on a given pattern and returns the encrypted String
	public static String encryption (String str, int pattern) {
		char arr[][]= new char[pattern][100];
		
		//Declare variables to be used inside the method
		String tempStr="";
		String newStr="";
		int n=0;
		int coef=1;
		
		//Delete the space characters of the given String
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i)==' ')
				continue;
			else
				tempStr += str.charAt(i);
		}
		
		tempStr=tempStr.toUpperCase();
		
		//Assign the letters in a multi-dimensional array according to the pattern
		for(int i=0, k=0; k<tempStr.length(); i++,k++) {
			
			
			arr[n][i]=tempStr.charAt(k);
			
			if(n==(pattern-1)) 
				coef=-1;
			else if (n==0)
				coef=1;
			
			n += coef;
			
		}
		
		//Print the array from left to right
		for(int i=0; i<arr.length ; i++)
			for(int j=0; j<arr[0].length; j++)
				if(arr[i][j]==0)
					continue;
					else
						newStr += arr[i][j];
		
		return newStr;
	}

}
	
