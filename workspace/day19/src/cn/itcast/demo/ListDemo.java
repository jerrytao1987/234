package cn.itcast.demo;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		function2();
	}

	private static void function2() {
		List<Double> list = new ArrayList<Double>();
		list.add(1.1);
		list.add(1.2);
		list.add(1.3);
		list.add(1.4);
		double d = list.set(0,1.5);
		System.out.println(list);
		System.out.println(d);
	}

	private static void function1() {
		List<Double> list = new ArrayList<Double>();
		list.add(1.1);
		list.add(1.2);
		list.add(1.3);
		list.add(1.4);
		double d = list.remove(0);
		System.out.println(list);
		System.out.println(d);
	}

	private static void function() {
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		System.out.println(list);
		list.add(1, "itcast");
		System.out.println(list);
	}

}
