package cn.itcast.demo;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(111);
		array.add(222);
		array.add(333);
		array.add(444);
		array.add(555);
		array.add(666);
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
		
		ArrayList<Person> arr = new ArrayList<Person>();
		arr.add(new Person("张三1",201));
		arr.add(new Person("张三2",202));
		arr.add(new Person("张三3",203));
		arr.add(new Person("张三4",204));
		arr.add(new Person("张三5",205));
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
