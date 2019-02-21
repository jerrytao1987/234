package cn.itcast.demo1;

import java.util.concurrent.Executors;

public class ThreadDemo {

	public static void main(String[] args) {
		Ticket t = new Ticket();
		Thread t1 = new Thread(t,"窗口1");
		Thread t2 = new Thread(t,"窗口2");
		Thread t3 = new Thread(t,"窗口3");
		t1.start();
		t2.start();
		t3.start();
	}

}
