package cn.itcast.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
	private int ticket = 100;
	private Lock l = new ReentrantLock();

	public void run() {
		while (true) {
			l.lock();
			if (ticket > 0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName() + "正在卖票：" + ticket--);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally{
					l.unlock();
				}
			}
		}

	}

}
