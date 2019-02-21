package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo1 {

	public static void main(String[] args) {
		function();
	}
	public static void function(){
		Collection coll = new ArrayList();
		coll.add("abc");
		coll.add(222);
		coll.add(33.3);
		coll.add(true);
		Iterator it = coll.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			System.out.println(obj);
		}
	}

}
