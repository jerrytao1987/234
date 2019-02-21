package cn.itcast.demo02;

import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		long l = System.currentTimeMillis();
		System.out.println(l);
		function3();
	}
	public static void function3(){
		Date d = new Date();
		d.setTime(0);
		System.out.println(d);
	}
	public static void function2(){
		Date d = new Date();
		long l = d.getTime();
		System.out.println(l);
	}
	public static void function1(){
		Date d = new Date(9223372036854775807L);
		System.out.println(d);
	}
	public static void function(){
		Date d = new Date();
		System.out.println(d);
	}

}
