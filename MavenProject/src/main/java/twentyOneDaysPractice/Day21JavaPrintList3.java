package twentyOneDaysPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day21JavaPrintList3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Bugatti Chiron";
		List<Character> lis = new ArrayList<Character>();
		for(int i = 0; i < str.length(); i++) {
			lis.add(str.charAt(i));
		}
		Iterator<Character> it = lis.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
