package arrayNString;
//To check String is Palindrome or not
import java.util.Scanner;

public class StringPalindrome {
	
 void getPalindrome(String str) {
	 	String palindrome = "";
		for (int i=str.length()- 1; i >=0; i--)
	         {
	           palindrome = palindrome + str.charAt(i);
				
	          }

			System.out.println(palindrome);
			if (str.equals(palindrome))
				System.out.println(str + " is a palindrome");
			else
				System.out.println(str + " is not a palindrome");
		}
 
	
	
	
		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			System.out.println("Please enter a string");
			String str = s.next();
			System.out.println("Given string is " + str);
			System.out.println("Reverse of the string is :");
			new StringPalindrome().getPalindrome(str);
		}

	}

