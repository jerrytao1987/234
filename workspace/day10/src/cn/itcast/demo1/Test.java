package cn.itcast.demo1;

public class Test {
	public static void main(String[] args) {
		//Zi z = new Zi();
		Fu f = new Zi();
		System.out.println(f.i);
		Fu1 f1 = f.work();
		System.out.println(f1.age);
	}
}
