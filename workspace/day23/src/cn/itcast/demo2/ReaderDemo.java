package cn.itcast.demo2;

import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("d:\\a.txt");
		/*int len = 0;
		while((len = fr.read())!=-1){
			System.out.print((char)len);
		}*/
		char[] c = new char[1024];
		int len = 0;
		while((len = fr.read(c))!=-1){
			System.out.println(new String(c,0,len));
		}
		fr.close();
	}

}
