package cn.itcast.demo1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamDemo {

	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new 
				BufferedInputStream(new FileInputStream("d:\\buffer.txt"));
		byte[] b = new byte[10];
		int len =0;
		while((len = bis.read(b))!=-1){
			System.out.print(new String(b,0,len));
		}
		bis.close();
	}
}
