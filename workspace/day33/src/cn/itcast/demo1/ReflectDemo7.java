package cn.itcast.demo1;

import java.lang.reflect.Method;

public class ReflectDemo7 {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("cn.itcast.demo1.Person");
		Method method = c.getMethod("sleep", String.class,int.class,double.class);
		Object obj = c.newInstance();
		method.invoke(obj , "休眠",20,1.1);
	}

}
