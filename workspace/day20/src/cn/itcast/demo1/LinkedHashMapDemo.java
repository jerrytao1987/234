package cn.itcast.demo1;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		function();
	}

	private static void function() {
		LinkedHashMap<String, String> link = new LinkedHashMap<String,String>();
		link.put("1", "a");
		link.put("2", "b");
		link.put("3", "c");
		System.out.println(link);
	}

}
