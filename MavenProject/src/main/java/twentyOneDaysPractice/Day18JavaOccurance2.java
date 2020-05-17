package twentyOneDaysPractice;

import java.util.HashMap;

public class Day18JavaOccurance2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "You have no choice other than following me!";
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		char[] charArr = str.toCharArray();
		for(char c : charArr) {
			if(charCountMap.containsKey(c)) {
				charCountMap.put(c, charCountMap.get(c) + 1);
			}else {
				charCountMap.put(c, 1);
			}
		}
		System.out.println("Characters Occurance: " +charCountMap);

	}

}
