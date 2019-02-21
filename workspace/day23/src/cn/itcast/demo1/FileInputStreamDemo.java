package cn.itcast.demo1;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("d:\\a.txt");
		int len = 0;
		while((len = fis.read())!=-1){
			System.out.print((char)len);
		}
		fis.close();
	}

}
