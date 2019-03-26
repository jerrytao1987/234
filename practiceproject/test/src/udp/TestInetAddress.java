package udp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress local = InetAddress.getLocalHost();
		InetAddress baidu = InetAddress.getByName("www.baidu.com");
		InetAddress byName = InetAddress.getByName("192.168.0.103");
		System.out.println(local.getHostAddress());
		System.out.println(local.getHostName());
		System.out.println(baidu.getHostAddress());
		System.out.println(baidu.getHostName());
		System.out.println(byName.getHostAddress());
		System.out.println(byName.getHostName());
	}
}
