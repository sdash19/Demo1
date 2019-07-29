package arrayNString;

import java.util.Scanner;

//Java program to find missing integer numbers in an array of 1 to 100
public class ArrayFindMissingNumber {

	void getMissingNumber(int[] arrayNum) {

		int missingNum = 0;
		System.out.println("The missing numbers are : ");
		for (int i = 0; i < arrayNum.length; i++) {
			if (arrayNum[i + 1] - arrayNum[i] != 1) {
				missingNum = arrayNum[i] + 1;
				System.out.println(missingNum);
				arrayNum[i + 1] = missingNum;
			}
		}
	}

	public static void main(String[] args) {
		int arrayLength = 100;
		int[] arrayNum = new int[arrayLength];
		for (int j = 0; j < arrayNum.length; j++) {
			arrayNum[j] = j + 1;
			System.out.print(arrayNum[j]+" , ");
		}

		Scanner s = new Scanner(System.in);

		
		System.out.println("\n"+"Enter the number of missing numbers");
		int missNum=s.nextInt();
		System.out.println("Enter the missing numbers :");
		int[] missNumArray = new int[missNum];
		int m = 0;
		while (s.hasNext() && m<missNum) {
			missNumArray[m] = s.nextInt();
			m++;
		}
		
		for(int k=0;k<arrayNum.length;k++) {
			if(arrayNum[k]==missNumArray[k])
				arrayNum[k]=' ';
		}
		System.out.println("So the given array of integer from 1 to 100 with some missing numbers is :");
		for (int j = 0; j < arrayNum.length; j++) {
			
			System.out.print(arrayNum[j]+" , ");
		}
		new ArrayFindMissingNumber().getMissingNumber(arrayNum);

	}

}
