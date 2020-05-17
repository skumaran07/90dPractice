package twentyOneDaysPractice;

public class Day19JavaSumOfNum1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "asdf1qwer9as8d7";
		int sum = 0;
		for(int i=0; i<str.length();i++) {
			char temp = str.charAt(i);
			if(Character.isDigit(temp)) {
				int b = Integer.parseInt(String.valueOf(temp));
				sum = sum + b;
			}
		}
		System.out.println("Sum of the digits: " +sum);
	}

}
