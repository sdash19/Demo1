package arrayNString;

import java.util.Scanner;

//Java Program reverse a string using recursion method
public class ReverseStringWRecursion {

	void getReverseString(String str) {

		if ((str.length() <= 1 )|| (str==null))
			System.out.println(str);
		else {
			System.out.print(str.charAt(str.length() - 1));
			getReverseString(str.substring(0, str.length() - 1));
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a string");
		String str = s.nextLine();
		System.out.println("Given string is :" + str);
		System.out.println("Reverse of the string is :");
		new ReverseStringWRecursion().getReverseString(str);
	}

}
