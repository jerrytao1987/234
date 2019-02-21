package cn.itcast.demo02;

public class Person {
	public void finalize(){
		System.out.println("垃圾收取了");
	}
}
