package twentyOneDaysPractice;

public class Day19JavaNumOfCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1. It is Work from Home not Work for Home";
		System.out.println("Numbers: "+str.replaceAll("[^0-9]", "").length());
		System.out.println("Upper case: "+str.replaceAll("[^A-Z]", "").length());
		System.out.println("Lower case: "+str.replaceAll("[^a-z]", "").length());
		System.out.println("Space: "+str.replaceAll("\\S", "").length());
	}

}
