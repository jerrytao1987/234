package tooldemo;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.tooldemo.httpclient.ApiService;

public class TestApiService {
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ApiService as = ac.getBean(ApiService.class);
		String result = as.doGet("http://www.baidu.com");
		System.out.println(result);
	}
}
