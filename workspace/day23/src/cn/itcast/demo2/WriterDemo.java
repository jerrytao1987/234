package cn.itcast.demo2;

import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("d:\\a.txt");
		fw.write(100);
		fw.flush();
		char[] c = {'a','b','c','d'};
		fw.write(c);
		fw.flush();
		
		fw.write(c,1,2);
		fw.flush();
		
		fw.write("helloworld");
		fw.flush();
		
		fw.close();
	}

}
