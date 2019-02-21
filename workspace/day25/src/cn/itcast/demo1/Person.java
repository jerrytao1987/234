package cn.itcast.demo1;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1132432L;
	private String name;
	private int age;
//	private static int age;//静态不能序列化,这时大家要问了，说不序列化static变量，怎么读取出来的反序列化对象的值，age的值还改变呢？这正是因为我们并没有序列化static变量，所以它并没有被写入流中，所以当我们要读取age的值时，它不可能在反序列化的文件里找到新的值，而是去全局数据区取值,分开执行或者换个文件执行，age的值就没有改变了
//	private transient int age;//transient阻止序列化
	
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
