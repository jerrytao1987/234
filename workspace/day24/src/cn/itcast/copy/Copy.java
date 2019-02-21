package cn.itcast.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copy {

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader("d:\\buffer.txt"));
		BufferedWriter bfw = new BufferedWriter(new FileWriter("e:\\buffer.txt"));
		String line = null;
		while((line = bfr.readLine())!=null){
			bfw.write(line);
			bfw.newLine();
		}
		bfw.close();
		bfr.close();
	}

}
