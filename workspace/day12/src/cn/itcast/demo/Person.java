package cn.itcast.demo;

public class Person {
	int a=1;
	public Person(){
		this(2);
		System.out.println("父类构造器");
	}
	public Person(int a){
		this.a=a;
	}
}
