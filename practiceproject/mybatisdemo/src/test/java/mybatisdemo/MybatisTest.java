package mybatisdemo;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatisdemo.pojo.User;

public class MybatisTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws Exception {
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}
	@Test
	public void func1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("queryUserById", 10);
		System.out.println(user.getUsername());
		sqlSession.close();
	}
	@Test
	public void func2() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("queryUserByUsername1", "%王%");
		for (User user2 : list) {
			
			System.out.println(user2.getUsername());
		}
		sqlSession.close();
	}
	@Test
	public void func3() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("queryUserByUsername2", "张");
		for (User user2 : list) {
			
			System.out.println(user2.getUsername());
		}
		sqlSession.close();
	}
	@Test
	public void func4() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("queryUserByUsername3", "张");
		for (User user2 : list) {
			
			System.out.println(user2.getUsername());
		}
		sqlSession.close();
	}
	@Test
	public void func5() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("曹操");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("北京");
		sqlSession.insert("saveUser", user);
		System.out.println(user);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void func6() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("刘备");
		user.setId(29);
		sqlSession.update("updateUserById", user);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void func7() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("deleteUserById", 29);
		sqlSession.commit();
		sqlSession.close();
	}
}
