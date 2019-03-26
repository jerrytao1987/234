package springmvcdemo;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.springmvc.mapper.ItemsMapper;
import cn.itcast.springmvc.pojo.Items;
import cn.itcast.springmvc.service.ItemService;

public class ItemServiceTest {
	@Test
	public void func1() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext-dao.xml","spring/applicationContext-service.xml","spring/applicationContext-trans.xml"});
		ItemService itemService = ac.getBean(ItemService.class);
		List<Items> list = itemService.queryItemList();
		for (Items items : list) {
			System.out.println(items.getName());
		}
	}
}
