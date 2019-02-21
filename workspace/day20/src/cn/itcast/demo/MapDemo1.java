package cn.itcast.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {

	public static void main(String[] args) {
		function();
	}

	private static void function() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 11);
		map.put("b", 12);
		map.put("c", 13);
		map.put("d", 14);
		Set<String> keySet = map.keySet();
		System.out.println(keySet.getClass());
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(value);
		}
		System.out.println("=================================");
		for (String string : keySet) {
			System.out.println(map.get(string));
		}
	}

}
