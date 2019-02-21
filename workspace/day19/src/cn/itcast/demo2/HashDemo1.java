package cn.itcast.demo2;

import java.util.HashSet;

public class HashDemo1 {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new String("bcd"));
		set.add(new String("bcd"));
		System.out.println(set);
		HashSet<Person> setPerson = new HashSet<Person>();
		setPerson.add(new Person("a", 10));
		setPerson.add(new Person("a", 10));
		setPerson.add(new Person("b", 23));
		setPerson.add(new Person("a", 24));
		setPerson.add(new Person("c", 40));
		setPerson.add(new Person("d", 32));
		System.out.println(setPerson);
		
	}

}
