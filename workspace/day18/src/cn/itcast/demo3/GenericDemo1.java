package cn.itcast.demo3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class GenericDemo1 {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		HashSet<Integer> set = new HashSet<Integer>();
		arr.add("abc");
		arr.add("bcd");
		set.add(111);
		set.add(222);
		iterator(arr);
		iterator(set);
	}

	private static void iterator(Collection<?> coll) {
		Iterator<?> it = coll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
