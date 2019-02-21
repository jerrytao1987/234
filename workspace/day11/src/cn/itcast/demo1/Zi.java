package cn.itcast.demo1;

public class Zi extends Fu {
	public int a =2;
	public void show(){
		System.out.println("这是子类重写的方法");
		super.show();
	}
	void Zi(){
		System.out.println("zi");
	}
	public Zi(){
		System.out.println("这是zi构造方法");
	}
}
