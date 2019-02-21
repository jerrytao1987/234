package cn.itcast.demo2;

public class ThreadDemo {

	public static void main(String[] args) {
		SubRunnable sr = new SubRunnable();
		Thread t = new Thread(sr);
		t.start();
		for(int i = 0;i<50;i++){
			System.out.println("main..."+i);
		}
	}

}
