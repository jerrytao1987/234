package cn.itcast.demo1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo1 {

	public static void main(String[] args) {
		function();
	}

	private static void function() {
		Set<String> s = new HashSet<String>();
		s.add("cn");
		s.add("itcast");
		s.add("heima");
		s.add("java");
		s.add("java");
		Iterator<String> it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
