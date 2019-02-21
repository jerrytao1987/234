package cn.itcast.demo;

public class Ticket implements Runnable {
	int ticket = 100;
	private Object obj = new Object();

	public void run() {
		while (true) {
			synchronized (obj) {
				if (ticket > 0) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "正在卖票：" + ticket--);
				}
			}
		}

	}

}
