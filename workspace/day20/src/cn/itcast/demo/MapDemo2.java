package cn.itcast.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo2 {

	public static void main(String[] args) {
		function();
	}

	private static void function() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 11);
		map.put("b", 12);
		map.put("c", 13);
		map.put("d", 14);
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String,Integer>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println("========================================");
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

}
