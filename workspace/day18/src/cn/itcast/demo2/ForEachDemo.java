package cn.itcast.demo2;

import java.util.ArrayList;

import cn.itcast.demo.Person;

public class ForEachDemo {

	public static void main(String[] args) {
		function2();
	}

	private static void function2() {
		ArrayList<Person> arr = new ArrayList<Person>();
		arr.add(new Person("a",20));
		arr.add(new Person("b",26));
		for(Person p : arr){
			System.out.println(p);
		}
	}

	private static void function1() {
		String[] str = {"abc","sfda","dafasdfd"};
		for(String s : str){
			System.out.println(s.length());
		}
	}

	private static void function() {
		int[] arr = {1,3,5,7,8,0};
		for(int i:arr){
			System.out.println(i+1);
		}
		System.out.println(arr[0]);
	}
	
}
