package twentyOneDaysPractice;

import java.util.ArrayList;
import java.util.List;

public class Day21JavaPrintList4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Bugatti Chiron";
		List<Character> lis = new ArrayList<Character>();
		for(int i = 0; i < str.length(); i++) {
			lis.add(str.charAt(i));
		}
		int count = 0;
		while (count < lis.size()) {
			System.out.println(lis.get(count));
			count++;
			
		}

	}

}
