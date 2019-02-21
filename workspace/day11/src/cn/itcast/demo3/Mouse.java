package cn.itcast.demo3;

public class Mouse implements USB {

	@Override
	public void open() {
		System.out.println("开启鼠标");
	}

	@Override
	public void close() {
		System.out.println("关闭鼠标");
	}

}
