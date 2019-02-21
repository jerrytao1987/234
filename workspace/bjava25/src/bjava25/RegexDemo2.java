package bjava25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo2 {
	
	public static void main(String[] args) {
		getDemo();
	}
	private static void getDemo() {
		String str = "ming tian jiu yao fang jia le ,da jia. ";
		//str="301323231";
		//String reg = "\\d{9}";
		//String reg = "[a-z]{3}";
		String reg = "\\b[a-z]{4}\\b";
		//1、将正则表达式封装成对象
		Pattern p = Pattern.compile(reg);
		//2、让正则对象和要操作的字符串相关联 ,获取正则匹配引擎
		Matcher m = p.matcher(str);
		//System.out.println(m.matches());//其实String类中的matches方法，用的就是Pattern和Matcher对象来完成的。
										//只不过被String的方法封装后，用起来较为简单。但是功能却单一
//		boolean b = m.find();//将规则作用到字符串上，并进行符合规则的子串查找。
//		System.out.println(b);
//		System.out.println(m.group());//用于获取匹配后的结果，需要先匹配
//		boolean b1 = m.find();//将规则作用到字符串上，并进行符合规则的子串查找。
//		System.out.println(b1);
//		System.out.println(m.group());//用于获取匹配后的结果，需要先匹配
		//System.out.println(m.matches());//注意：此处调用matches()方法后，匹配的指针往后移动到了ming后面的空格符后面t上面
		while(m.find()){
			System.out.println(m.group());
			System.out.println(m.start()+"..."+m.end());
		}
		
	}
}
