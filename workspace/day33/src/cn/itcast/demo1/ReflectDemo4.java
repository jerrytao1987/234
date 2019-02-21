package cn.itcast.demo1;

import java.lang.reflect.Constructor;

public class ReflectDemo4 {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("cn.itcast.demo1.Person");
		/*Constructor[] cons = c.getDeclaredConstructors();
		for (Constructor con : cons) {
			System.out.println(con);
		}*/
		Constructor con = c.getDeclaredConstructor(int.class,String.class);
		System.out.println(con);
		con.setAccessible(true);
		Object obj = con.newInstance(20,"lisi");
		System.out.println(obj);
	}

}
