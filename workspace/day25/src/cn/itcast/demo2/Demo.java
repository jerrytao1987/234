package cn.itcast.demo2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException {
		function();
	}

	public static void function1() throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("d:\\5.txt");
		PrintWriter pw = new PrintWriter(fos,true);
		pw.println("i");
		pw.println("love");
		pw.println("java");
		pw.close();
	}

	public static void function() {
		int[] arr = {1};
		System.out.println(arr);
		char[] ch = {'a','b'};
		System.out.println(ch);
		byte[] b = {};
		System.out.println(b);
	}

}
