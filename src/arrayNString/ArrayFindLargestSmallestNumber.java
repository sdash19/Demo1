package arrayNString;

import java.util.Arrays;
//Find Largest and smallest number in unsorted array
import java.util.Scanner;

public class ArrayFindLargestSmallestNumber {

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

	// To Find Largest number using Arrays class predefined methods
	void getLargestSmallestNum(int[] arrayNum, int arrayLength) {
		Arrays.sort(arrayNum);
		System.out.println("Largest Number in the array is : " + arrayNum[arrayNum.length - 1]);
		System.out.println("Smallest Number in the array is : " + arrayNum[0]);
	}

	// To Find Largest number without using Arrays class predefined methods
	void getLargestSmallestNumber(int[] arrayNum, int arrayLength) {
		int largestNum = 0, smallestNum = 0;
		for (int i = 0; i < arrayLength - 1; i++) {
			if (arrayNum[i] > arrayNum[i + 1])
				arrayNum[i + 1] = arrayNum[i];
			largestNum = arrayNum[i + 1];
		}
		System.out.println("Largest number in the array is : " + largestNum);

		for (int i = 0; i < arrayLength - 1; i++) {
			if (arrayNum[i] < arrayNum[i + 1])
				arrayNum[i + 1] = arrayNum[i];
			smallestNum = arrayNum[i + 1];
		}
		System.out.println("Smallest number in the array is : " + smallestNum);
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

		new ArrayFindLargestSmallestNumber().printArray(arrayNum, arrayLength);
		new ArrayFindLargestSmallestNumber().getLargestSmallestNum(arrayNum, arrayLength);
		new ArrayFindLargestSmallestNumber().getLargestSmallestNumber(arrayNum, arrayLength);

	}
}
