package cn.itcast.demo03;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo1 {

	public static void main(String[] args) {
		function();
	}
	public static void function3() {
		Calendar c = Calendar.getInstance();
		//c.set(Calendar.MONTH, 9);
		Date date = c.getTime();
		System.out.println(date);
	}
	public static void function2() {
		Calendar c = Calendar.getInstance();
		//c.set(Calendar.MONTH, 9);
		c.add(Calendar.DAY_OF_MONTH,365);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+month+"月"+day+"日");
	}
	public static void function1() {
		Calendar c = Calendar.getInstance();
		//c.set(Calendar.MONTH, 9);
		c.set(2019, 5, 10);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+month+"月"+day+"日");
	}
	public static void function() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+month+"月"+day+"日");
	}

}
