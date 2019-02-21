package cn.itcast.d_springaop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)//帮我们创建容器
//指定创建容器时使用哪个配置文件
@ContextConfiguration("classpath:cn/itcast/d_springaop/applicationContext.xml")
public class Demo {
	
	@Resource(name="userService")
	private UserService us;
	@Test
	public void fun1(){
		us.save();
	}
}
