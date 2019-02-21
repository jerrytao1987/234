package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {

	public static void main(String[] args) {
		function3();
	}
	private static void function3() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");
		coll.add("itcast");
		coll.add("heima");
		coll.add("abc");
		System.out.println(coll);
		coll.remove("abc");
		System.out.println(coll);
	}
	private static void function2() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");
		coll.add("itcast");
		coll.add("heima");
		Object[] obj = coll.toArray();
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}
	}
	private static void function1() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");
		coll.add("itcast");
		coll.add("heima");
		boolean b =coll.contains("itcast");
		System.out.println(b);
	}
	public static void function(){
		Collection<Integer> coll = new ArrayList<Integer>();
		coll.add(111);
		coll.add(222);
		coll.add(333);
		coll.add(444);
		coll.add(555);
		coll.add(666);
		System.out.println(coll);
		coll.clear();
		System.out.println(coll);
	}

}
