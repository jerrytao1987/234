package cn.itcast.demo03;

public class MathDemo {

	public static void main(String[] args) {
		function6();
	}
	public static void function6(){
		double d = Math.round(9.5);
		System.out.println(d);
	}
	public static void function5(){
		double d = Math.random();
		System.out.println(d);
	}
	public static void function4(){
		double d = Math.sqrt(9);
		System.out.println(d);
	}
	public static void function3(){
		double d = Math.pow(9,2);
		System.out.println(d);
	}
	public static void function2(){
		double d = Math.floor(9.9);
		System.out.println(d);
	}
	public static void function1(){
		double d = Math.ceil(9.1);
		System.out.println(d);
	}
	public static void function(){
		int i = Math.abs(-9);
		System.out.println(i);
		
	}
}
