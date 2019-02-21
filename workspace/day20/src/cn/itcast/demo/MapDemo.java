package cn.itcast.demo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		function1();
	}

	private static void function1() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		System.out.println(map.get(3));
		System.out.println(map);
		map.remove(2);
		System.out.println(map);
	}

	private static void function() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		Integer i = map.put("a", 5);
		System.out.println(i);
		System.out.println(map);
	}

}
