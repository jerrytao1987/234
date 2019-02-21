package cn.itcast.tomcatDemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 模拟浏览器
 * @author dengting
 *
 */
public class MyIE {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("192.168.0.106",80);
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		/*192.168.0.106
		GET /ssh_easyUI/ HTTP/1.1
		Accept: application/x-ms-application, image/jpeg, application/xaml+xml, image/gif, image/pjpeg, application/x-ms-xbap, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, *
		Accept-Language: zh-CN
		User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; InfoPath.2; Shuame)
		Accept-Encoding: gzip, deflate
		Host: 192.168.0.106:11000
		Connection: Keep-Alive
		Cache-Control: no-cache
		
		*/
		out.println("GET /ssh_easyUI/ HTTP/1.1");
		out.println("Accept: application/x-ms-application, image/jpeg, application/xaml+xml, image/gif, image/pjpeg, application/x-ms-xbap, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, *");
		out.println("User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; InfoPath.2; Shuame)User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; InfoPath.2; Shuame)");
		out.println("Accept-Language: zh-CN");
		out.println("Host: 192.168.0.106");
		out.println("Connection: closed");
		out.println();
		out.println();
		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while((line=bufr.readLine())!=null){
			System.out.println(line);
		}
		s.close();
	}
}
