package bjava24;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://192.168.0.106/ssh_easyUI/");
		URLConnection conn = url.openConnection();
		System.out.println(conn);
		InputStream in = conn.getInputStream();
		byte[] buff = new byte[1024];
		//int len = in.read(buff);
		int len = -1;
		while((len=in.read(buff))!=-1){
			System.out.println(new String(buff, 0, len));
		}
		
	}
}
