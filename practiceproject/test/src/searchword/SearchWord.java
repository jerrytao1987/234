package searchword;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchWord {
	public static void main(String[] args) throws IOException {
		String word = "重庆";
		String pathName = "C:/Users/dengting/Desktop/已投简历备注.txt";
		int count = searchWordByBufferedReader(pathName, word, "gbk");
		//int count = searchWordByInputStreamReader(pathName, word, "gbk");
		System.out.println(count);
	}
	/**
	 * 根据指定的文件编码格式读取文本文件并查找指定的字符串在文本文件中出现的次数
	 * @param pathName 要查询的文件路径
	 * @param word 要查询的字符串
	 * @param charset 指定文本文件编码格式
	 * @return 总次数
	 * @throws IOException
	 */
	public static int searchWordByInputStreamReader(String pathName,String word,String charset) throws IOException{
		int count=0;
		FileInputStream fis = new FileInputStream(pathName);
		InputStreamReader ir = new InputStreamReader(fis, charset);
		char[] buf = new char[1024];
		int len = -1;
		while((len=ir.read(buf))!=-1){
			int index = -1;
			String line = new String(buf, 0, len);
			while(line.length()>=word.length()&&(index=line.indexOf(word))!=-1){
				count++;
				line=line.substring(index+word.length());
			}
		}
		ir.close();
		return count;
	}
	/**
	 * 根据指定的文件编码格式高效的读取文本文件，并查询指定字符串在文本文件中出现的次数
	 * @param pathName 要查询的文件路径
	 * @param word 要查询的字符串
	 * @param charset 指定文件编码格式
	 * @return 总次数
	 * @throws IOException
	 */
	public static int searchWordByBufferedReader(String pathName,String word,String charset) throws IOException{
		int count=0;
		InputStreamReader ir = new InputStreamReader(new FileInputStream(pathName),charset);
		BufferedReader br = new BufferedReader(ir);
		String line=null;
		while((line=br.readLine())!=null){
			int index=-1;
			while(line.length()>=word.length()&&(index=line.indexOf(word))!=-1){
				count++;
				line=line.substring(index+word.length());
			}
		}
		br.close();
		return count;
	}
	/**
	 * 根据默认编码格式读取文本文件，查询指定的字符串在文本文件中出现的次数
	 * @param pathName 要查询的文件路径
	 * @param word 要查询的字符串
	 * @return 总次数
	 * @throws IOException
	 */
	public static int searchWordByBufferedReader(String pathName,String word) throws IOException{
		int count = 0;
		BufferedReader br = new BufferedReader(new FileReader(pathName));
		String line = null;
		while((line=br.readLine())!=null){
			int index=-1;
			while(line.length()>word.length()&&(index=line.indexOf(word))!=-1){
				count++;
				line=line.substring(index+word.length());
			}
		}
		br.close();
		return count;
	}
}
