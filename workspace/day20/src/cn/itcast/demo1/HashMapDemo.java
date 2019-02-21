package cn.itcast.demo1;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		function1();
	}

	private static void function1() {
		HashMap<Person, String> map = new HashMap<Person,String>();
		map.put(new Person("a",20), "中国");
		map.put(new Person("b",39), "美国");
		map.put(new Person("c",23), "俄罗斯");
		for(Person key:map.keySet()){
			System.out.println(key+"..."+map.get(key));
		}
		System.out.println("=========================");
		for(Map.Entry<Person, String> entry:map.entrySet()){
			System.out.println(entry.getKey()+"..."+entry.getValue());
		}
	}

	private static void function() {
		HashMap<String, Person> map = new HashMap<String, Person>();
		map.put("beijing", new Person("a",20));
		map.put("shanghai", new Person("b",22));
		map.put("guangzhou", new Person("c",25));
		for (String key : map.keySet()) {
			System.out.println(key+"..."+map.get(key));
		}
		System.out.println("==========================");
		for(Map.Entry<String, Person> entry:map.entrySet()){
			String key = entry.getKey();
			System.out.println(key+"..."+map.get(key));
		}
	}

}
