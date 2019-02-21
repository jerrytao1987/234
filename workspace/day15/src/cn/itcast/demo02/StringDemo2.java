package cn.itcast.demo02;

public class StringDemo2 {

	public static void main(String[] args) {
		String str = new String("abc");
		String str1 = "abc";
		System.out.println(str==str1);
		System.out.println(str.equals(str1));
	}

}
