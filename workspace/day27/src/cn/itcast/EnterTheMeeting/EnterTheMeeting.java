package cn.itcast.EnterTheMeeting;

public class EnterTheMeeting {

	public static void main(String[] args) {
		Employee em = new Employee(100);
		Thread t0 = new Thread(em,"前门");
		Thread t1 = new Thread(em,"后门");
		t0.start();
		t1.start();
		
	}

}
