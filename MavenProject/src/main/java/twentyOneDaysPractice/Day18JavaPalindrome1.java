package twentyOneDaysPractice;

public class Day18JavaPalindrome1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "malayalam", strRev = "";
		int size = str.length();
		for(int i= size-1; i >= 0; i--) {
			
			strRev = strRev + str.charAt(i);
		}
		if (str.equalsIgnoreCase(strRev)) {
			System.out.println("Yes, Palindrome");
		} else {
			System.out.println("No, not a palindrome");
		}
		

	}

}
