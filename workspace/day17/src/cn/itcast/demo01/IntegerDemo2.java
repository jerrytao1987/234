package cn.itcast.demo01;

public class IntegerDemo2 {
	public static void main(String[] args) {
		function1();
	}
	public static void function1(){
		System.out.println(Integer.toBinaryString(99));
		System.out.println(Integer.toOctalString(99));
		System.out.println(Integer.toHexString(99));
	}
	public static void function() {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
