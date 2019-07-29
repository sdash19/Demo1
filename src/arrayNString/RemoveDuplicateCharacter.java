package arrayNString;
import java.util.Arrays;
//Remove duplicate character from a string
import java.util.Scanner;



public class RemoveDuplicateCharacter {

	void getRemoveDuplicateCharacter(String str) {
		
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			System.out.println(ch);
			StringBuffer sb=new StringBuffer(str);
			System.out.println(str);
			boolean isThere = false;
			int j = 0;
			while (j < str.length() - 1) {
				for (int i = 1; i < str.length(); i++) {
					if (ch[j] == ch[i]) {
						System.out.println("Duplicate character is : " + ch[i]);
						isThere = true;
						sb.deleteCharAt(i);
					}

					j++;

				}
				System.out.println(sb);
				if (isThere == false)
					System.out.println("There is no duplicate character in the String");
			}
		}
	
		public static void main(String[] args) {

			Scanner s = new Scanner(System.in);
			System.out.println("Please enter a string");
			String str = s.nextLine();
			System.out.println("Given string is " + str);

			new RemoveDuplicateCharacter().getRemoveDuplicateCharacter(str);
		}
	


	}


