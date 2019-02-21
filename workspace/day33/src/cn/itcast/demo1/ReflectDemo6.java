package cn.itcast.demo1;

import java.lang.reflect.Method;

public class ReflectDemo6 {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("cn.itcast.demo1.Person");
		Object obj = c.newInstance();
		/*Method[] methods = c.getMethods();
		for (Method m : methods) {
			System.out.println(m);
		}*/
		Method method = c.getMethod("eat");
		System.out.println(method);
		method.invoke(obj);
	}

}
