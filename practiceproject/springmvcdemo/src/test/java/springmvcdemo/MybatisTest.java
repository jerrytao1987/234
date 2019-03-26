package springmvcdemo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.springmvc.mapper.ItemsMapper;
import cn.itcast.springmvc.pojo.Items;

public class MybatisTest {
	@Test
	public void func1() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		ItemsMapper itemMapper = ac.getBean(ItemsMapper.class);
		List<Items> list = itemMapper.selectByExample(null);
		for (Items items : list) {
			System.out.println(items.getName());
		}
	}
	@Test
	public void testException() throws Exception {
		try {
			Items i= null;
			if (i==null) {
				throw new NullPointerException("出现空指针异常了，请检查对象是否为null");
		}
		} catch (NullPointerException e) {
			String message = e.getMessage();
			System.out.println(message ); 
			
			String result = e.toString();
			System.out.println(result);	
			
			e.printStackTrace(); 
		}
	}
}
