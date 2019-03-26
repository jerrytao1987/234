package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPRecieve {
	/*
	 * UDP接收端
	 * 
	 * 1,创建DatagramSocket对象
	 * 2,创建DatagramPacket对象
	 * 3,接收数据存储到DatagramPacket对象中
	 * 4,获取DatagramPacket对象的内容
	 * 5,释放流资源
	 */
	public static void main(String[] args) throws IOException {
		while(true){
			DatagramSocket ds = new DatagramSocket(6000);
			byte[] buf=new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);
			byte[] data = dp.getData();
			int length=dp.getLength();
			String dataStr = new String(data,0,length);
			String ip=dp.getAddress().getHostAddress();
			System.out.println("发送端ip:"+ip+"数据的长度"+length+"数据内容："+dataStr);
			ds.close();
		}
	}
}
