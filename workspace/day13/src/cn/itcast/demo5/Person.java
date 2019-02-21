package cn.itcast.demo5;

public class Person {
	private String name;
	private int age;
	public Person(String name,int age){
		this.name =name;
		this.age=age;
		System.out.println("这是构造方法");
	}
	{
		System.out.println("我是构造代码块");
	}
	static{
		System.out.println("我是静态代码块");
	}
}
