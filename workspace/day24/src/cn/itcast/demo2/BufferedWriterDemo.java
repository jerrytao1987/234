package cn.itcast.demo2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

	public static void main(String[] args) throws IOException {
		BufferedWriter bfw = new BufferedWriter(new FileWriter("d:\\buffer.txt"));
		bfw.write("你好");
		bfw.newLine();
		bfw.flush();
		bfw.write("我好".toCharArray());
		bfw.newLine();
		bfw.flush();
		bfw.write("大家好");
		bfw.close();
	}

}
