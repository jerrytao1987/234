package cn.e3mall.publish;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPublish {

	@Test
	public void publishService() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		/*while(true){
			Thread.sleep(1000);
		}*/
		System.out.println("服务已经启动......");
		System.in.read();
		System.out.println("服务已经关闭");
	}

}
