package cn.itcast.demo1;

public class Person {
	public String name;
	private int age;
	static{
		System.out.println("这是静态代码块");
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	private Person(int age,String name) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	public void sleep(String s,int a,double b){
		System.out.println("人在睡觉"+s+"..."+a+"..."+b);
	}
	public void eat(){
		System.out.println("人在吃饭");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
