package cn.itcast.demo2;

public class Dog extends Animal{

	@Override
	public void eat() {
		System.out.println("狗吃狗粮");
	}
	public void lookHome() {
		System.out.println("狗看家");
	}
	
}
