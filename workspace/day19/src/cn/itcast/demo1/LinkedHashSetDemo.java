package cn.itcast.demo1;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		LinkedHashSet<Integer> link = new LinkedHashSet<Integer>();
		link.add(11);
		link.add(22);
		link.add(33);
		link.add(44);
		link.add(55);
		link.add(66);
		System.out.println(link);
	}

}
