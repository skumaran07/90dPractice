package twentyOneDaysPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day20JavaValEmail1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "._@gmail.com";
		String pattern = "[a-zA-Z0-9._]+@[a-z0-9]+.[a-z.]{2,}";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(str);
		System.out.println(matcher.matches());

	}

}
