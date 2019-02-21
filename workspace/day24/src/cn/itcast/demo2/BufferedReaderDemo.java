package cn.itcast.demo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		int lineNumber = 0;
		BufferedReader bfr = new BufferedReader(new FileReader("d:\\BugReport.txt"));
		String line = null;
		while((line = bfr.readLine())!=null){
			//lineNumber++;
			System.out.println(++lineNumber+"  "+line);
		}
		/*String line = bfr.readLine();
		System.out.println(line);
		line = bfr.readLine();
		System.out.println(line);
		line = bfr.readLine();
		System.out.println(line);
		line = bfr.readLine();
		System.out.println(line);
		line = bfr.readLine();
		System.out.println(line);
		line = bfr.readLine();
		System.out.println(line);*/
		bfr.close();
	}

}
