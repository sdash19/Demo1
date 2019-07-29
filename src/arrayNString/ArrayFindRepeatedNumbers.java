package arrayNString;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayFindRepeatedNumbers {

	
	// print the array given by user
		void printArray(int[] arrayNum, int arrayLength) {
			System.out.print("Given Array of integer is = " + "{");

			for (int i = 0; i != arrayLength;) {
				System.out.print(arrayNum[i]);
				++i;
				if (i < arrayLength)
					System.out.print(" , ");
			}
			System.out.print("}");
		}

		
		//Find repeated numbers in an array
		void getFindRepeatedNums(int[] arrayNum,int arrayLength) {
			Arrays.sort(arrayNum);
			int j=0;
			boolean flag=false;
			while(j<arrayLength-2) {
			for(int i=1;i<arrayLength-1;i++) {
			if(arrayNum[j]==arrayNum[i]) {
				System.out.println("The repeated number is : "+arrayNum[i]);
			    flag=true;}
			
				j++;}
			if(flag==false)System.out.println("There is no repeated number in the array");
			}
		}
		
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the length of array");
		int arrayLength = s.nextInt();
		int[] arrayNum = new int[arrayLength];
		int x = 0;
		// Get the array values from the user
		for (int i = 0; i < arrayLength; i++) {
			System.out.println("Enter a number for array[" + i + "]");

			if (s.hasNextInt() == true) {
				arrayNum[i] = s.nextInt();

			}
		}

		new ArrayFindRepeatedNumbers().printArray(arrayNum, arrayLength);
		new ArrayFindRepeatedNumbers().getFindRepeatedNums(arrayNum, arrayLength);
		

	}
}