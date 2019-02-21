package cn.itcast.demo;

import java.io.File;
import java.io.IOException;

public class FileDemo2 {

	public static void main(String[] args) throws IOException {
		function1();
	}
	private static void function2() {
		File f = new File("D:\\a\\b\\c");
		boolean b = f.delete();
		System.out.println(b);
	}
	private static void function1() {
		File f = new File("D:\\a\\b\\c");
		boolean b = f.mkdirs();
		System.out.println(b);
	}
	public static void function() throws IOException{
		File f = new File("D:\\a.txt");
		boolean b = f.createNewFile();
		System.out.println(b);
	}
}
