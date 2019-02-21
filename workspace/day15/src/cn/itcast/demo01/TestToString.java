package cn.itcast.demo01;

public class TestToString {
	public static void main(String[] args) {
		Person p = new Person("张三", 20);
		String s = p.toString();
		System.out.println(p);
		System.out.println(s);
	}
}
