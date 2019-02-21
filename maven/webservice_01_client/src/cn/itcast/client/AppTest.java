package cn.itcast.client;

public class AppTest {
	public static void main(String[] args) {
		HelloServiceService ss = new HelloServiceService();
		HelloService proxy = ss.getHelloServicePort();
		String ret = proxy.sayHello("小明");
		System.out.println(ret);
	}
}
