package cn.itcast.demo3;

public class Keyboard implements USB {

	@Override
	public void open() {
		System.out.println("开启键盘");
	}

	@Override
	public void close() {
		System.out.println("关闭键盘");
	}

}
