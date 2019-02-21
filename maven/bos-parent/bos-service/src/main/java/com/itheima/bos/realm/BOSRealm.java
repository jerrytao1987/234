package com.itheima.bos.realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.itheima.bos.dao.IFunctionDao;
import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.entity.Function;
import com.itheima.bos.entity.User;

public class BOSRealm extends AuthorizingRealm {
	@Autowired
	private IFunctionDao functionDao;
	@Autowired
	private IUserDao userDao;
	
	//授权方法
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//info.addStringPermission("staff-list");
		
		//TODO 后期需要修改为根据当前登录用户查询数据库，获取实际对应的权限
		User user1 = (User) SecurityUtils.getSubject().getPrincipal();
		//User user2 = (User) principals.getPrimaryPrincipal();
		List<Function> list = null;
		if(user1.getUsername().equals("admin")){
			
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
			list = functionDao.findByCriteria(detachedCriteria );
		}else{
			list = functionDao.findFunctionListByUserId(user1.getId());
		}
		for (Function function : list) {
			info.addStringPermission(function.getCode());
		}
		return info;
	}

	//认证方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("自定义认证方法打印了。。。");
		UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
		String username = passwordToken.getUsername();
		User user = userDao.findUserByUsername(username);
		if(user == null){
			return null;
		}
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		return info;
	}

}
