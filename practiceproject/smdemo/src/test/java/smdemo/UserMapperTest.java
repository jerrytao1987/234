package smdemo;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itcast.smdemo.mapper.UserMapper;
import cn.itcast.smdemo.pojo.User;
import cn.itcast.smdemo.pojo.UserExample;
import cn.itcast.smdemo.pojo.UserExample.Criteria;

public class UserMapperTest {
	private ApplicationContext ac;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
	@Test
	public void selectByPrimaryKey() throws Exception {
		UserMapper userMapper = ac.getBean(UserMapper.class);
		User user = userMapper.selectByPrimaryKey(28);
		System.out.println(user.getUsername());
	}
	@Test
	public void selectByExample() throws Exception {
		UserMapper userMapper = ac.getBean(UserMapper.class);
		UserExample example=new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameLike("%张%");
		List<User> list = userMapper.selectByExample(example);
		for (User user : list) {
			System.out.println(user.getUsername());
		}
	}
	@Test
	public void insert() throws Exception {
		UserMapper userMapper = ac.getBean(UserMapper.class);
		User user=new User();
		user.setUsername("hello");
		user.setBirthday(new Date());
		userMapper.insert(user);
	}
	@Test
	public void deleteByExample() throws Exception {
		UserMapper userMapper = ac.getBean(UserMapper.class);
		UserExample example=new UserExample();
		Criteria criteria = example.createCriteria().andUsernameEqualTo("hello");
		userMapper.deleteByExample(example);
	}
	/**
	 * 更新部分内容
	 * @throws Exception
	 */
	@Test
	public void updateByExampleSelective() throws Exception {
		UserMapper userMapper = ac.getBean(UserMapper.class);
		User user=new User();
		user.setUsername("孙权");
		UserExample example = new UserExample();
		example.createCriteria().andSexEqualTo("男");
		userMapper.updateByExampleSelective(user, example);
	}
	@Test
	public void countByExample() throws Exception {
		UserMapper userMapper = ac.getBean(UserMapper.class);
		UserExample example=new UserExample();
		long row = userMapper.countByExample(example);
		System.out.println(row);
	}
	@Test
	public void selectOrderByUsername() throws Exception {
		UserMapper userMapper = ac.getBean(UserMapper.class);
		UserExample example=new UserExample();
		example.setOrderByClause("username");
		example.createCriteria().andUsernameLike("%张%");
		List<User> list = userMapper.selectByExample(example);
		for (User user : list) {
			System.out.println(user.getUsername());
		}
	}
	@Test
	public void testPagHelper() throws Exception {
		UserMapper userMapper = ac.getBean(UserMapper.class);
		//获取第1页，3条内容，默认查询总数count
		PageHelper.startPage(1, 3);
		UserExample example=new UserExample();
		//紧跟着的第一个select方法会被分页
		List<User> list = userMapper.selectByExample(example);
		/*//取分页的第一种方式
		Page<User> page = (Page<User>) list;
		System.out.println(page.getTotal());
		System.out.println(page.getPages());
		System.out.println(page.getPageNum());
		System.out.println(page.getPageSize());
		List<User> list2 = page.getResult();
		for (User user : page) {
			System.out.println(user.getUsername());
		}*/
		//取分页的第二种方式
		PageInfo<User> pageInfo = new PageInfo<>(list);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(pageInfo.getPageNum());
		System.out.println(pageInfo.getPageSize());
		List<User> list2 = pageInfo.getList();
		for (User user : list2) {
			System.out.println(user.getUsername());
		}
	}
}
