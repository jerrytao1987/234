package cn.itcast.demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) throws IOException {
		funtion2();
	}

	private static void funtion2() throws IOException {
		//PrintWriter pw = new PrintWriter(new FileOutputStream("d:\\3.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("d:\\4.txt"));
		pw.println("打印流");
		pw.close();
	}

	private static void funtion1() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("d:\\2.txt");
		pw.println(3.5);
		pw.close();
	}

	private static void funtion() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("d:\\1.txt"));
		pw.println(100);
		pw.close();
	}

}
