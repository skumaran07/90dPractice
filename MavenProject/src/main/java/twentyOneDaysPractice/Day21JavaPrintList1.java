package twentyOneDaysPractice;

import java.util.ArrayList;
import java.util.List;

public class Day21JavaPrintList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Bugatti Chiron";
		List<Character> lis = new ArrayList<Character>();
		for(int i = 0; i < str.length(); i++) {
			lis.add(str.charAt(i));
		}
		for(int j = 0; j < lis.size(); j++) {
			System.out.println(lis.get(j));
		}
			
		

	}

}
