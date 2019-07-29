package arrayNString;

import java.util.Scanner;

public class ArrayFindSecondLargestNumber {

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

	// To Find Second Largest number
	void getSecondLargestNum(int[] arrayNum, int arrayLength) {
		int largestNum = 0, secondLargestNum = 0;
		int temp = 0;
		int j = 0;

		while (j < arrayLength) {
			for (int i = 0; i < arrayLength - 1; i++) {
				if (arrayNum[i] > arrayNum[i + 1]) {
					temp = arrayNum[i];
					arrayNum[i] = arrayNum[i + 1];
					arrayNum[i + 1] = temp;
				}
			}

			j++;

		}
		secondLargestNum = arrayNum[arrayLength - 2];
		System.out.println("\n"+"Second largest number in the array is : " + secondLargestNum);

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

		new ArrayFindSecondLargestNumber().printArray(arrayNum, arrayLength);
		new ArrayFindSecondLargestNumber().getSecondLargestNum(arrayNum, arrayLength);

	}
}
