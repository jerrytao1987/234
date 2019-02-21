package cn.itcast.a_jdbctemplate;

import java.beans.PropertyVetoException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.itcast.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	@Resource(name="userDao")
	private UserDao ud;
	
	@Test
	public void fun1() throws PropertyVetoException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///hibernate_32?uSSL=false");
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(dataSource);
		String sql = "insert into t_user values(null,'rose')";
		jt.update(sql);
		
	}
	
	@Test
	public void fun2() throws PropertyVetoException{
		User u = new User();
		u.setName("tom");
		ud.save(u);
		
	}
	
	@Test
	public void fun3() throws PropertyVetoException{
		User u = new User();
		u.setId(2);
		u.setName("jack");
		ud.update(u);
		
	}
	
	@Test
	public void fun4() throws PropertyVetoException{
		ud.delete(2);
		
	}
	
	@Test
	public void fun5() throws PropertyVetoException{
		int totalCount = ud.getTotalCount();
		System.out.println(totalCount);
		
	}
	
	@Test
	public void fun6() throws PropertyVetoException{
		User u = ud.getById(1);
		System.out.println(u);
		
	}
	
	@Test
	public void fun7() throws PropertyVetoException{
		List<User> list = ud.getAll();
		System.out.println(list);
		
	}
}
