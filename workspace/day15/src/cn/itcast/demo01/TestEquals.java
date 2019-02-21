package cn.itcast.demo01;

public class TestEquals {

	public static void main(String[] args) {
		Person p1 = new Person("张三", 20);
		Person p2 = new Person("李四", 25);
		boolean b = p1.equals(p2);
		System.out.println(b);
	}

}
