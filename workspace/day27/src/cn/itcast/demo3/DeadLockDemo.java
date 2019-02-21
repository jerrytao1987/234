package cn.itcast.demo3;

public class DeadLockDemo {

	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		Thread t0 = new Thread(dl);
		Thread t1 = new Thread(dl);
		t0.start();
		t1.start();
	}

}
