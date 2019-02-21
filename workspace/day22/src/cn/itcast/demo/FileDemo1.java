package cn.itcast.demo;

import java.io.File;

public class FileDemo1 {

	public static void main(String[] args) {
		function2();
	}
	private static void function2() {
		File file = new File("C:");
		File file1 = new File(file,"windows");
		System.out.println(file1);
	}
	private static void function1() {
		File file = new File("C:","windows");
		System.out.println(file);
	}
	public static void function(){
		File f = new File("D:"+File.separator+"develop"+File.separator+"eclipse-java-mars-2-win32"+File.separator+"eclipse");
		System.out.println(f);
	}
}
