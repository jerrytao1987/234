package cn.itcast.demo1;

import java.lang.reflect.Field;

public class ReflectDemo5 {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("cn.itcast.demo1.Person");
		Object obj = c.newInstance();
//		Field[] fields = c.getFields();
		/*Field[] fields = c.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f);
		}*/
		Field field = c.getField("name");
		System.out.println(field);
		field.set(obj, "lisi");
		System.out.println(obj);
	}

}
