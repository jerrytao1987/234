package cn.itcast.demo1;

import java.lang.reflect.Constructor;

public class ReflectDemo2 {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("cn.itcast.demo1.Person");
		Constructor con = c.getConstructor(String.class,int.class);
		System.out.println(con);
		Object obj = con.newInstance("zhangsan",20);
		System.out.println(obj);
	}

}
