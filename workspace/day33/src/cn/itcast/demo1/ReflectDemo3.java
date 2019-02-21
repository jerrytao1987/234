package cn.itcast.demo1;

public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("cn.itcast.demo1.Person");
		Object obj = c.newInstance();
		System.out.println(obj);
	}
}
