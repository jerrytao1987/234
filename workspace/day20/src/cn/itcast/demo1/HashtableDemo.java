package cn.itcast.demo1;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashtableDemo {

	public static void main(String[] args) {
		function1();
	}

	private static void function1() {
		Map<String, String> map = new Hashtable<String,String>();
		map.put(null, null);//编译无问题，运行报空指针异常NullPointerException
		System.out.println(map);
	}

	private static void function() {
		Map<String, String> map = new HashMap<String,String>();
		map.put(null, null);
		System.out.println(map);
	}

}
