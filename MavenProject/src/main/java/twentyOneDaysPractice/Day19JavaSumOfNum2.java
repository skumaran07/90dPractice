package twentyOneDaysPractice;

public class Day19JavaSumOfNum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "asdf1qwer9as8d7";
		int sum = 0;
		System.out.println(str);
		for(int i=0; i< str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				String temp = str.substring(i, i+1);
				sum = sum + Integer.parseInt(temp);
				
				
			}
		}
		System.out.println(sum);

	}

}
