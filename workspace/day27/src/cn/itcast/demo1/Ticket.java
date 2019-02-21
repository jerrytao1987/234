package cn.itcast.demo1;

public class Ticket implements Runnable {
	int ticket = 100;
	public void run() {
		while (true) {
			payTicket();
		}

	}

	public synchronized void payTicket() {
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
