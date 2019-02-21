package cn.itcast.demo3;

public class ThreadDemo {

	public static void main(String[] args) {
		new Thread(){
			public void run(){
				System.out.println("!!");
			}
		}.start();
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("#####");
			}
		};
		new Thread(r).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("-------");
			}
		}).start();
	}

}
