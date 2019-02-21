package cn.itcast.demo;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("d:\\a.txt");
		fos.write(97);
		//byte[] bytes = {97,98,99,100};
		byte[] bytes = {65,66,67,68};
		fos.write(bytes);
		fos.write(48);
		fos.write(bytes, 2, 2);
		fos.write("hello".getBytes());
		fos.close();
	}

}
