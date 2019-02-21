package cn.itcast.demo1;

import java.lang.reflect.Constructor;

public class ReflectDemo1 {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("cn.itcast.demo1.Person");
		/*Constructor[] cons = c.getConstructors();
		for (Constructor con : cons) {
			System.out.println(con);
			
		}*/
		Constructor con = c.getConstructor();
//		System.out.println(con);
		Object obj = con.newInstance();
		System.out.println(obj);
	}

}
