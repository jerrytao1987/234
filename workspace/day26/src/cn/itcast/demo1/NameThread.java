package cn.itcast.demo1;

public class NameThread extends Thread {
	public void run(){
		System.out.println(super.getName());
	}
}
