package cn.itcast.ssh.service;

import cn.itcast.ssh.pojo.Users;

public interface UserService {
	public Users findByUsername(String username);

	public Users login(Users user);
}
