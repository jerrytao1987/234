package cn.itcast.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) throws UnknownHostException {
		function1();
	}

	private static void function1() throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("www.baidu.com");
		String ip = inet.getHostAddress();
		String pc = inet.getHostName();
		System.out.println(ip);
		System.out.println(pc);
		
	}

	private static void function() throws UnknownHostException {
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet);
		String ip = inet.getHostAddress();
		String pc = inet.getHostName();
		System.out.println(ip);
		System.out.println(pc);
	}

}
