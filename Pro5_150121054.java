/* Ceren Eren 150121054 
This program takes a String input from the user which consists of number user enters separated by 
dashes. Then converts the integer numbers to their binary equivalent and displays them with a grid. 
After that updates the numbers with the rules given according to number of steps entered by user. 
Then displays the updated version of the grid and the decimal value of updated numbers.
*/

public class Pro5_150121054 {

	public static void main(String[] args) {
		//Create a Scanner object
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		
		System.out.println("Welcome to our program.");
		
			for( ; ; ) {
			
			//Prompt user to enter a String
			System.out.print("Enter a string: ");
			String s = input.next();
			
			//Count how many numbers the String has and assign it to variable
			int numberCount=1;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)=='-')
					numberCount++;
			}
			
			//Create an array to store numbers entered by user
			int arr[]=new int[numberCount];
			
			
			int size=arr.length;
			
			
			//Create two arrays to store the binary conversion of numbers and the updated version of numbers converted to binary
			int initialArray[][]= new int[numberCount][numberCount];
			int updatedArray[][]= new int[numberCount][numberCount];
			
			//Implement assignArray method to assign numbers entered to array
			assignArray(arr,s);
			
			//Print an error message and restart the program if the numbers  
			//user enters cannot be displayed with current array size
			boolean isNotRepresented=false;
			for(int i=0; i<arr.length; i++) {
				if (arr[i]>Math.pow(2, size)-1) {
					System.out.println("The number " + arr[i] + " cannot be represented with " + size + "x" + size + " array!");
					isNotRepresented=true;
				}
			}
			
			if(isNotRepresented==true)
				continue;
			
			//Prompt user to enter number of steps will be applied to update the grid
			System.out.print("Enter a number of steps: ");
			int number = input.nextInt();
			
			//Implement assignInitialArray method to assign binary conversion of the numbers into 2 dimensional array
			assignInitialArray(arr, initialArray);
			
			//Implement printArray method to print the initial array
			printArray(initialArray);
			
			//Create a for loop to update the array, print the update message and print the updated array
			for(int i=1; i<=number; i++) {
				updateArray(initialArray, updatedArray);
				
				System.out.println();
				System.out.println("It is converted to the following table after " + i + " st step:");
				printArray(updatedArray);
				
			}
			
			//Convert the binary numbers in updated array to their decimal equivalent back and print
			System.out.print("The decimal value for the second table after " + number + " steps: ");
			for(int i=0; i<arr.length; i++) {
				int convertedResult=0;
				if(i!=0)
				System.out.print("-");
				for(int j=0, k=arr.length-1; j<arr.length; j++, k--) {
					convertedResult += updatedArray[i][j]*Math.pow(2,k);
				}
				System.out.print(convertedResult);
				
			}
			
			
			break;
			}
		}
			
		//Create a method which converts decimal number to its binary equivalent, assigns it into an array, then returns the array
		public static int[] convertDectoB (int number, int size) { 
			int[] array= new int[size];
			
			String convertedNum="";
			
			//Convert the number using while-loop
			while (number > 0) { 
		    	int remainder = number % 2;
		    	number = number / 2;
		    	convertedNum = remainder + convertedNum;
		    	 }
			
			int length=convertedNum.length();
			
			//Assign the converted number into the array
			for(int i=0; i<size-length; i++) 
				array[i]=0;
			
			for(int i=size-length, j=0; i<size; i++, j++) 
				array[i]=convertedNum.charAt(j)-48;
				
			return array;
				
		}
		
		//Create a method which assigns the numbers in the given string to a given array in order
		public static void assignArray (int arr[], String str) {
			String s="";
			int j=0;
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)!='-')
					s += str.charAt(i);
				else {
					arr[j]=Integer.parseInt(s);
					s="";
					j++;
				}
			}
			arr[j]=Integer.parseInt(s);
			
	}
		
		//Create a method which converts the numbers in given array to their binary equivalent using ConvertDectoB method
		//Then assigns it to a 2 dimensional array
		public static void assignInitialArray (int arr[], int array[][]) {
			for (int i=0; i<arr.length; i++) {
				for (int j=0; j<arr.length; j++) 
					array[i][j]=convertDectoB(arr[i],arr.length)[j];
			}
		}
		
		//Create a method which prints the given 2 dimensional array with grid and dashes
		public static void printArray (int arr[][]) {
			
			for(int i=0; i<(1+arr.length*4); i++) 
				System.out.print("-"); 
			
			for(int i=0; i<arr.length; i++) {
				
				System.out.println();
				System.out.print("|");
				
				for(int j=0; j<(arr.length); j++) {
					System.out.print(" ");
					System.out.print(arr[i][j]);
					System.out.print(" ");
					System.out.print("|");
				}
				System.out.println();
				
				for(int j=0; j<(1+arr.length*4); j++) 
					System.out.print("-"); 
			}
			
			System.out.println();
		}
		
		//Create a method which updates the digits of the first array, assigns it to the updatedArray and updates the initial array
		public static void updateArray (int initialArray[][], int updatedArray[][]) {
			
			//Declare some variables to be used later on
			int count=0;
			int sum=0;
			
			//Check the 8 neighbors of each digit and count how many '1's there are using nested for-loops
			for(int i=0; i<initialArray.length; i++) {
				for(int j=0; j<initialArray.length; j++) {
					
					
					for(int k=-1; k<2; k++) {
						for (int l=-1; l<2; l++) {
							
							//Don't check the neighbor digits if they are out of array
							if (j+l<0 || j+l>=initialArray.length || i+k<0 || i+k>=initialArray.length)
								count=0;
							else 
								count=initialArray[i+k][j+l];
							sum +=count;	
						}
					}
					
					//Update the array -updatedArray- with respect to the rules given
					if(initialArray[i][j]==1 && !(sum-1==2 || sum-1==3)) 
						updatedArray[i][j]=0;
					else if (initialArray[i][j]==1 && (sum-1==2 || sum-1==3))
						updatedArray[i][j]=1;
					
					else if (initialArray[i][j]==0 && sum==3)
						updatedArray[i][j]=1;
					
					else if (initialArray[i][j]==0 && sum!=3)
						updatedArray[i][j]=0;
					
					sum=0;
				
				}
			}
			
			//Update the initial array
			for(int i=0; i<initialArray.length; i++) {
				for(int j=0; j<initialArray.length; j++)
					initialArray[i][j]=updatedArray[i][j];
			}
				
		}
			
		}

