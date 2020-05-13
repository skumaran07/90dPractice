package twentyOneDaysPractice;

public class Day18JavaOccurance1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// Write a Java Program to find the occurance of the character 'o' in the following String.
		String str = "You have no choice other than following me!";
		char[] c = str.toCharArray();
		int sum = 0;
		for(char occ : c) {
			if (occ == 'o') {
				sum = sum + 1;
			}
		}
		System.out.println("Occurance of o is: " +sum);
	}

}
