package cn.itcast.demo1;

public class ThreadDemo {

	public static void main(String[] args) {
		NameThread nt = new NameThread();
		nt.start();
		/*Thread t = Thread.currentThread();
		System.out.println(t.getName());*/
		System.out.println(Thread.currentThread().getName());
	}

}
