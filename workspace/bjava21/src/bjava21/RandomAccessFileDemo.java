package bjava21;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
//		writeFile();
		readFile();
//		wirteFile_2();
	}
	public static void readFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "r");
		//调整对象中指针
		//raf.seek(8*1);
		//跳过指定的字节数,不能往前跳
		//raf.skipBytes(8);
		raf.seek(10);
		byte[] buf = new byte[6];
		raf.read(buf);
		//System.out.println(Arrays.toString(buf));
		String name = new String(buf,"utf-8");
		int age = raf.readInt();
		System.out.println("name="+name);
		System.out.println("age="+age);
		//System.out.println(Arrays.toString(name.getBytes()));
		raf.close();
	}
	public static void wirteFile_2() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
		raf.seek(8*0);
		raf.write("周期".getBytes());
		raf.writeInt(103);
		raf.close();
	}
	public static void writeFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("ran.txt", "rw");
		raf.write("李四".getBytes());
		//raf.write(97);//向此文件写入指定的字节。从当前文件指针开始写入。b - 要写入的 byte
		raf.writeInt(97);
		raf.write("王五".getBytes());
		raf.writeInt(99);
		raf.close();
	}
}
