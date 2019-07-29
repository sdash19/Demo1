package arrayNString;

import java.util.Arrays;
import java.util.Scanner;
//To check if two strings are anagram of each other, i.e. if they contains same characters but on different order

public class StringsAnagram {

	void getStringAnagram(String str1, String str2) {

		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();

		if (str1.length() != str2.length() || (str1 == null) || (str2 == null)) {
			System.out.println("The Strings are not Anagram of each other");
		} else {
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);
			if (Arrays.equals(charArray1, charArray2))
				System.out.println("The Strings are Anagram of each other");

			else
				System.out.println("The Strings are not anagram of each other");
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the string1");
		String str1 = s.next();
		System.out.println("Please enter the string2");
		String str2 = s.next();

		new StringsAnagram().getStringAnagram(str1, str2);
	}

}
