package twentyOneDaysPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Day21JavaDupChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, Integer> dup = new HashMap<Character, Integer>();
		String str = "When life gives you lemons, make lemonade";
		char[] ch = str.toCharArray();
		for(char c : ch) {
			if(dup.containsKey(c)) {
				dup.put(c, dup.get(c)+1);
			} else {
				dup.put(c, 1);
			}
			
		}
		
	/* Approach 1	
	  Set<Map.Entry<Character, Integer>> eSet = dup.entrySet();
		for(Map.Entry<Character, Integer> entry : eSet) {
			if(entry.getValue() > 1) {
				System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
			}
		} */
		
		// Approach 2
		Set<Character> keys = dup.keySet();
		for(Character cCount : keys){
		      if(dup.get(cCount) > 1){
		        System.out.println("Char "+cCount+" "+dup.get(cCount));
		      }
		    }
			
	}

}
