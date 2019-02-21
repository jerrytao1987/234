package cn.itcast.demo01;

public class IntegerDemo {
	public static void main(String[] args) {
		function4();
	}
	public static void function4(){
		Integer in = new Integer("100");
		int i = in.intValue();
		System.out.println(i--);
		
	}
	public static void function3(){
		String s = Integer.toString(5,2);
		System.out.println(s);
	}
	public static void function2(){
		int i =10;
		String s = i+"";
		System.out.println(s);
	}
	public static void function1(){
		int i = Integer.parseInt("110",2);
		System.out.println(i);
	}
	public static void function() {
		int i = Integer.parseInt("12");
		System.out.println(i / 2);
	}
}
