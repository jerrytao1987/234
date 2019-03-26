package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
	public static void main(String[] args) {
		/*
		 * String str = "我我我要要要学学编编编编程程"; str = str.replaceAll("(.)\\1+","$1");
		 * System.out.println(str);
		 */
		String str = "北京市(朝阳区)(西城区)(海淀区)";
		Pattern p = Pattern.compile(".*?(?=\\()");
		Matcher m = p.matcher(str);
		if (m.find()) {
			System.out.println(m.group());
		}
	}
}
