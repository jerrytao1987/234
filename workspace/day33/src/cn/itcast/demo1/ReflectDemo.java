package cn.itcast.demo1;

public class ReflectDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		Person p = new Person();
		Class c = p.getClass();
		System.out.println(c);
		Class c1 = Person.class;
		System.out.println(c1);
		System.out.println(c==c1);
		System.out.println(c.equals(c1));
		Class c2 = Class.forName("cn.itcast.demo1.Person");
		System.out.println(c2);
	}

}
