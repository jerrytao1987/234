package cn.itcast.demo;

public class Test {
	public static void main(String[] args) {
		Develop d = new Develop();
		d.name = "张三";
		System.out.println(d.name);
		d.work();
		d.print();
		WeiHu wh = new WeiHu();
		wh.name = "李四";
		wh.work();
		wh.print();
	}
}
