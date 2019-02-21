package com.itheima.webservice;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class HelloService {
	public String sayHello(String name){
		System.out.println("服务端的sayHello方法被调用了....");
		return "hello"+name;
	}
	public static void main(String[] args) {
		String address = "http://192.168.0.106/hello";
		Object implementor = new HelloService();
		Endpoint.publish(address, implementor);
	}
}
