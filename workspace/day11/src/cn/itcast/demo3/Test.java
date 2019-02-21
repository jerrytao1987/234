package cn.itcast.demo3;

public class Test {
	public static void main(String[] args) {
		Computer com = new Computer();
		com.openComputer();
		Mouse m = new Mouse();
		com.useUSB(m);
		Keyboard k = new Keyboard();
		com.useUSB(k);
		com.closeComputer();
	}
}
