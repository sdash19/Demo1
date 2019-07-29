package arrayNString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ArrayRemoveDuplicateNumbers {

			
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

			
	/*
	 * //Remove duplicate numbers in an array without using set
	 *  void getRemoveDuplicateNumbers(int[]arrayNum,int arrayLength) {
	 *   Arrays.sort(arrayNum); int[]
	 * newArrayNum=arrayNum; //Set<Integer> newArrayNum=new HashSet<>(arrayNum); int
	 * j=0; boolean flag=false; while(j<arrayLength-2) { for(int
	 * i=1,k=0;i<arrayLength-1;i++) { if(arrayNum[j]==arrayNum[i]) {
	 * System.out.println("The repeated number is : "+arrayNum[i]); flag=true;
	 * newArrayNum[k]=newArrayNum[i++];} else newArrayNum[k]=newArrayNum[i];
	 * 
	 * j++;}
	 * 
	 * if(flag==false)System.out.println("There is no repeated number in the array"
	 * ); }printArray(newArrayNum, newArrayNum.length); }
	 */
			
			void getRemoveDuplicateNumbers(int[]arrayNum,int arrayLength) {
				Set<Integer> set=new HashSet<Integer>();
				for(int num:arrayNum) {
					set.add(num);
				}
				System.out.println("After removing the repeated numbers :"+set);
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

			new ArrayRemoveDuplicateNumbers().printArray(arrayNum, arrayLength);
			new ArrayRemoveDuplicateNumbers().getRemoveDuplicateNumbers(arrayNum, arrayLength);

	}

}
