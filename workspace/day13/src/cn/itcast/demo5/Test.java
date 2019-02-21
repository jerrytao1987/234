package cn.itcast.demo5;

public class Test {
	public static void main(String[] args) {
		new Person("张三",20);
		new Person("张三2",202);
		{
			System.out.println("这是局部代码块");
		}
	}
}
