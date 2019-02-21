package cn.itcast.demo3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

	public static void main(String[] args) {
		function2();
	}

	private static void function2() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(6);
		list.add(7);
		list.add(4);
		list.add(8);
		list.add(11);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}

	private static void function1() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(11);
		System.out.println(list);
		int index = Collections.binarySearch(list, 7);
		System.out.println(index);
	}

	private static void function() {
		List<String> list = new ArrayList<String>();
		list.add("bb");
		list.add("aa");
		list.add("ba");
		list.add("ab");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}

}
