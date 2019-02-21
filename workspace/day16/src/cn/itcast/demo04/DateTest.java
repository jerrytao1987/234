package cn.itcast.demo04;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateTest {

	public static void main(String[] args) throws Exception {
		function1();
	}
	public static void function1(){
		Calendar c = Calendar.getInstance();
		c.set(2088, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
	}
	public static void function() throws Exception {
		System.out.println("请输入出生日期，格式为yyyy-MM-dd");
		String birthdayString = new Scanner(System.in).next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate = sdf.parse(birthdayString);
		Date today = new Date();
		long birthdaySecond = birthdayDate.getTime();
		long todaySecond = today.getTime();
		long second = todaySecond-birthdaySecond;
		System.out.println(second/1000/60/60/24);
	}
}
