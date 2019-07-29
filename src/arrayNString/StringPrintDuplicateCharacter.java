package arrayNString;

import java.util.Arrays;
import java.util.Scanner;

//To print duplicate character from a string
public class StringPrintDuplicateCharacter {

	void getPrintDuplicateCharacter(String str) {
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		boolean isThere = false;
		int j = 0;
		while (j < str.length() - 2) {
			for (int i = 1; i < str.length(); i++) {
				if (ch[j] == ch[i]) {
					System.out.println("Duplicate character is : " + ch[j]);
					isThere = true;
					
				}

				j++;

			}
			if (isThere == false)
				System.out.println("There is no duplicate character in the String");
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a string");
		String str = s.nextLine();
		System.out.println("Given string is " + str);

		new StringPrintDuplicateCharacter().getPrintDuplicateCharacter(str);
	}
}
