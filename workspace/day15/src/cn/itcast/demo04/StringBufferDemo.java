package cn.itcast.demo04;

public class StringBufferDemo {

	public static void main(String[] args) {
		function();
	}
	public static void function5(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("abcdef").append(123456);
		String s = buffer.toString();
		System.out.println(s);
	}
	public static void function4(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("abcdef");
		buffer.reverse();
		System.out.println(buffer);
	}
	public static void function3(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("abcdef");
		buffer.replace(1, 3, "9.5");
		System.out.println(buffer);
	}
	public static void function2(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("abcdef");
		buffer.insert(3, 9.5);
		System.out.println(buffer);
	}
	public static void function1(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("abcdef");
		buffer.delete(1, 5);
		System.out.println(buffer);
	}
	public static void function(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(6).append(false);
		System.out.println(buffer);
	}
}
