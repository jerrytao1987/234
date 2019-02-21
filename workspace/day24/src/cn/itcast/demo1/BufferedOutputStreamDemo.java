package cn.itcast.demo1;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {

	public static void main(String[] args) throws IOException {
//		FileOutputStream fos = new FileOutputStream("D:\\buffer.txt");
//		BufferedOutputStream bos = new BufferedOutputStream(fos);
		BufferedOutputStream bos = new 
				BufferedOutputStream(new FileOutputStream("d:\\buffer.txt"));
		bos.write(55);
		byte[] b = "hello world".getBytes();
		bos.write(b);
		bos.write(b, 1, 2);
		bos.close();
	}

}
