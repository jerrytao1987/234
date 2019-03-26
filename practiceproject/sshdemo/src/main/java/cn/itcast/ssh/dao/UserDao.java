package cn.itcast.ssh.dao;

import cn.itcast.ssh.pojo.Users;

public interface UserDao {
	public Users findByUsername(String username);

	public Users login(Users user);
}
