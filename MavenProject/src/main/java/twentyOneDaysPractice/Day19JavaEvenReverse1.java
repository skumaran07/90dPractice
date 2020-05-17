package twentyOneDaysPractice;

public class Day19JavaEvenReverse1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "When the world realise its own mistake, corona will dissolve automatically";
		String arr[] = str.split(" ");
		for(int i=0; i < arr.length; i++) {
			if (i % 2 != 0) {
				for(int j = arr[i].length()-1; j>=0 ; j--) {
					System.out.print(arr[i].charAt(j));
				} 
				}else {
					System.out.print(arr[i]);
			}
			System.out.print(" ");
		}
	}

}
