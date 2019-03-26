package springbootdemo;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.itcast.springboot.dao.UserDao;
import cn.itcast.springboot.pojo.User;
import cn.itcast.springboot.service.UserService;
import cn.itcast.springboot.springconfig.SpringConfig;

public class TestSpringConfig {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		UserDao userDao = context.getBean(UserDao.class);
		List<User> queryUserList = userDao.queryUserList();
		System.out.println(queryUserList);
		UserService userService = context.getBean(UserService.class);
		List<User> list = userService.queryUserList();
		for (User user : list) {
			System.out.println(user.getUsername());
		}
	}
}
