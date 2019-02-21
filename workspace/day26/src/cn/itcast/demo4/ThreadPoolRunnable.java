package cn.itcast.demo4;

public class ThreadPoolRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"线程提交的任务");
	}

}
