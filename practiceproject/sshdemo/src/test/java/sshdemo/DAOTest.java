package sshdemo;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.ssh.dao.UserDao;
import cn.itcast.ssh.pojo.Users;

/*@RunWith(SpringJUnit4ClassRunner.class)
@Configuration("classpath:applicationContext.xml")*/
public class DAOTest {
	/*@Autowired
	private UserDao ud;
	public UserDao getUd() {
		return ud;
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}*/
	@Test
	public void testName() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao ud = (UserDao) ac.getBean(UserDao.class);
		Users user = ud.findByUsername("a");
		System.out.println(user.getId());
	}
}
