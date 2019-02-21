package cn.itcast.demo;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		function1();
	}

	private static void function1() {
		LinkedList<String> link = new LinkedList<String>();
		link.addLast("a");
		link.addLast("b");
		link.addLast("c");
		link.addLast("d");
		link.addFirst("1");
		link.addFirst("2");
		link.addFirst("3");
		link.addFirst("4");
		System.out.println(link);
	}

	private static void function() {
		LinkedList<String> link = new LinkedList<String>();
		link.addLast("heima");
		link.add("abc");
		link.add("bcd");
		link.addFirst("itcast");
		System.out.println(link);
	}

}
