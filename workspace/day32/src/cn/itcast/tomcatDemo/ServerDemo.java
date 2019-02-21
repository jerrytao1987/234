package cn.itcast.tomcatDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 测试tomcat
 * 可以用浏览器测试，控制台打印浏览器请求内容
 * @author dengting
 *
 */
public class ServerDemo {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(11000);
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress());
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		/*int len = -1;
		while((len=in.read(buf))!=-1){
			System.out.println(new String(buf, 0, len));
		}*/
		int len = in.read(buf);
		System.out.println(new String(buf, 0, len));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("<div style='color:red;font-size:32px;'>客户端您好</div>");
		s.close();
		ss.close();
	}
}
