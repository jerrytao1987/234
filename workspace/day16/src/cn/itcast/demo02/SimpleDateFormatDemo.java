package cn.itcast.demo02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {

	public static void main(String[] args) throws Exception {
		function1();
	}
	public static void function1() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		Date date = sdf.parse("2018年07月26日  23:20:53");
		System.out.println(date);
	}
	public static void function(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		String date = sdf.format(new Date());
		System.out.println(date);
	}

}
