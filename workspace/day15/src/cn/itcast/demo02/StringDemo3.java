package cn.itcast.demo02;

public class StringDemo3 {

	public static void main(String[] args) {
		function();
	}
	public static void function5(){
		String str = " ab C ";
		System.out.println(str.isEmpty());
		System.out.println(str.indexOf('b'));
		System.out.println(str.charAt(2));
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		System.out.println(str.replace('b', 'd'));
		System.out.println(str.replace("b", "ef"));
		System.out.println(str.trim());
		System.out.println(str);
	}
	public static void function4(){
		String str = "abc";
		String str1 = "ABC";
		System.out.println(str.equals(str1));
		System.out.println(str.equalsIgnoreCase(str1));
	}
	public static void function3(){
		String str = "aA0";
		byte[] bytes = str.getBytes();
		for (byte b : bytes) {
			System.out.println(b);
		}
		char[] c = str.toCharArray();
		for (char d : c) {
			System.out.println(d);
		}
	}
	public static void function2(){
		String str = "howareyou.java";
		boolean b = str.startsWith("how");
		System.out.println(b);
		boolean b1 = str.endsWith(".java");
		System.out.println(b1);
		int i = str.indexOf("are");
		System.out.println(i);
		boolean b2 = str.contains("ar");
		System.out.println(b2);
	}
	/*public static void function(){
		byte[] bytes ={97,65,48};
		String str = new String(bytes);
		System.out.println(str);
		byte[] bytes1 = {65,66,67,68};
		String str1 = new String(bytes1, 1, 2);
		System.out.println(str1);
		System.out.println(str.length());
		System.out.println(str.substring(1,2));
	}*/
	private static void function() {
		String s1 = "ab";
		String s2 = "abc";
		String s3 = s1 + "c";
		System.out.println(s3 == s2);
		System.out.println(s3.equals(s2)); 		//true
	}
}
