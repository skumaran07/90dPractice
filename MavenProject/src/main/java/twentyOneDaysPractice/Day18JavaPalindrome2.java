package twentyOneDaysPractice;

import java.util.Scanner;

public class Day18JavaPalindrome2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String str = sc.next();
		int i = 0, j = str.length()-1;
		if(str.charAt(i)!= str.charAt(j)) {
			System.out.println("No, Palindrome");
		} else {
			System.out.println("Yes, Palindrome");
		}
		i++;
		j--;

	}

}
