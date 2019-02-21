package cn.itcast.demo;

public class Student extends Person {
	int b =2;
	public Student(){
		this(3);
		System.out.println("子类构造方法");
	}
	public Student(int c){
		super(5);
		b =c;
		
	}
}
