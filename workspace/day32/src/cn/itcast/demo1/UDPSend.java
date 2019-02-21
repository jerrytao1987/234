package cn.itcast.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSend {

	public static void main(String[] args) throws IOException {
		byte[] data = "你好UDP".getBytes();
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		DatagramPacket dp = new DatagramPacket(data, data.length, inet, 6000);
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		ds.close();
	}

}
