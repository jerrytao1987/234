package cn.itcast.demo6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("a",23));
		list.add(new Person("b",12));
		list.add(new Person("c",36));
		list.add(new Person("d",21));
		System.out.println(list);
		Comparator<Person> c = new Comparator<Person>() {
			
			public int compare(Person o1, Person o2) {
				return o1.getAge() -o2.getAge();
			}

		};
		Collections.sort(list,c);
		System.out.println(list);
	}

}
