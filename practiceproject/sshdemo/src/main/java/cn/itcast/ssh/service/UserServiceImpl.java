package cn.itcast.ssh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.ssh.dao.UserDao;
import cn.itcast.ssh.pojo.Users;
@Service
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao ud;
	public UserDao getUd() {
		return ud;
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	public Users findByUsername(String username) {
		Users user = ud.findByUsername(username);
		return user;
	}
	public Users login(Users user) {
		/*Users u = ud.findByUsername(user.getUsername());
		if(u!=null&&user.getPassword()!=null&&user.getPassword().equals(u.getPassword())){
			return u;
		}*/
		Users u = ud.login(user);
		return u;
	}

}
