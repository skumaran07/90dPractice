package twentyOneDaysPractice;

public class Day19JavaSumOfNum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "asdf1qwer9as8d7";
		int sum = 0;
		String val = str.replaceAll("\\D", "");
		System.out.println(val);
		int num = Integer.parseInt(val);
		while(num > 0) {
		int temp = num % 10;
		sum = sum + temp;
		num = num / 10;
		}
		System.out.println(sum);
		

	}

}