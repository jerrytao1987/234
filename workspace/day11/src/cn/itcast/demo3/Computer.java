package cn.itcast.demo3;

public class Computer {
	public void openComputer() {
		System.out.println("打开笔记本");
	}
	public void closeComputer() {
		System.out.println("关闭笔记本");
	}
	public void useUSB(USB usb) {
		usb.open();
		usb.close();
	}
}
