package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo1 {

	public static void main(String[] args) {
		function();
	}

	private static void function() {
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		System.out.println(list);
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			if(it.next().equals("abc3")){
				list.add("ABC3");
			}
		}
		System.out.println(list);
	}

}
