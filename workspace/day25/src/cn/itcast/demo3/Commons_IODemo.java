package cn.itcast.demo3;

import org.apache.commons.io.FilenameUtils;

public class Commons_IODemo {

	public static void main(String[] args) {
		function1();
	}

	public static void function2() {
		boolean b = FilenameUtils.isExtension("d:\\mm.java", "java");
		System.out.println(b);
	}

	public static void function1() {
		String name = FilenameUtils.getName("d:\\windows");
		System.out.println(name);
	}

	public static void function() {
		String str = FilenameUtils.getExtension("d:\\mm.java");
		System.out.println(str);
	}

}
