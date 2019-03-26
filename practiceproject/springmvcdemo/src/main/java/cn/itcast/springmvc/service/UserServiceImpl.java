package cn.itcast.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.springmvc.mapper.UserMapper;
import cn.itcast.springmvc.pojo.User;
import cn.itcast.springmvc.pojo.UserExample;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(User user) {
		UserExample example=new UserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername());
		List<User> user1 = userMapper.selectByExample(example);
		if(user1.isEmpty()){
			return null;
		}
		return user1.get(0);
	}

}
