package cn.itcast.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.PageBean;

@Service("userService")
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService {
	
	private UserDao ud;
	@Override
	public User getUserByCodePassword(User u) {
		User existU = ud.getByUserCode(u.getUser_code());
		if(existU==null){
			throw new RuntimeException("用户名不存在");
		}
		if(!existU.getUser_password().equals(u.getUser_password())){
			throw new RuntimeException("密码错误");
		}
		return existU;
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		User existU = ud.getByUserCode(u.getUser_code());
		if(existU!=null){
			throw new RuntimeException("用户名已存在，请重新输入！");
		}
		ud.save(u);
	}
	@Resource(name="userDao")
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public PageBean<User> getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount = ud.getTotalCount(dc);
		PageBean<User> pb = new PageBean<>(currentPage, totalCount, pageSize);
		List<User> pageList = ud.getPageList(dc, pb.getStart(), pb.getPageSize());
		pb.setList(pageList);
		return pb;
	}

}
