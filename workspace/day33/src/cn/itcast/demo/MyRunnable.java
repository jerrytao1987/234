package cn.itcast.demo;

public class MyRunnable implements Runnable {
	private int i;
	
	public MyRunnable(int i) {
		super();
		this.i = i;
	}

	@Override
	public void run() {
		TestClass testClass = StaticClass.getTestClass();
		testClass.setName("jame"+i);
		System.out.println(testClass+"\t"+testClass.getName());
	}

}
