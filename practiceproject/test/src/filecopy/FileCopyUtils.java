package filecopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件拷贝工具
 * @author dengting
 *
 */
public class FileCopyUtils {
	private FileCopyUtils(){
		throw new AssertionError();
	}
	/**
	 * 使用jdk1.7nio(new i/o)拷贝文件
	 * @param source 拷贝的资源位置
	 * @param target 目的文件位置
	 * @throws IOException 
	 */
	public static void NIOCopyFile(String source,String target) throws IOException{
		FileOutputStream fos = new FileOutputStream(target);
		FileInputStream fis = new FileInputStream(source);
		FileChannel in = fis.getChannel();
		FileChannel out = fos.getChannel();
		//分配一个新的字节缓冲区。
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(in.read(buffer)!=-1){
			//反转此缓冲区。首先将限制设置为当前位置，然后将位置设置为 0.如果已定义了标记，则丢弃该标记。
			buffer.flip();
			out.write(buffer);
			//清除此缓冲区。将位置设置为 0，将限制设置为容量，并丢弃标记。
			buffer.clear();
		}
		
	}
	/**
	 * 使用传统方式复制文件
	 * @param source 
	 * @param target
	 * @throws IOException
	 */
	public static void copyFile(String source,String target) throws IOException{
		FileOutputStream fos = new FileOutputStream(target);
		FileInputStream fis = new FileInputStream(source);
		byte[] buf = new byte[1024];
		int len = -1;
		while((len=fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		fos.close();
		fis.close();
	}
}
