package cn.itcast.demo3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericDemo {

	public static void main(String[] args) {
		function();
	}

	private static void function() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");
		coll.add("asdfasd");
		coll.add("hghhfgdghdfghf");
		//coll.add(1);
		Iterator it = coll.iterator();
		while(it.hasNext()){
			String s = (String)it.next();
			System.out.println(s.length());
		}
	}

}
