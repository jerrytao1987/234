package cn.itcast.demo2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintWriterDemo1 {

	public static void main(String[] args) throws IOException {
		function1();
	}
	
	public static void function1() throws IOException{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d:\\t.jpg"));
		PrintStream ps = new PrintStream(new FileOutputStream("e:\\t.jpg"), true);
		byte[] buf = new byte[1024];
		int len = -1;
		while((len=bis.read(buf))!=-1){
			ps.write(buf, 0, len);
		}
		ps.close();
		bis.close();
	}

	private static void function() throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader("d:\\5.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("e:\\5.txt"));
		String line = null;
		while((line = bfr.readLine())!=null){
			pw.println(line);
		}
		pw.close();
		bfr.close();
	}

}
