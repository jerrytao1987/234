package cn.e3mall.solrj.activemq;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageConsumer {
	
	@Test
	public void msgConsumer() throws Exception {
		//初始化spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//等待
		System.in.read();
	}
}
