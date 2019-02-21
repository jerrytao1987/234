package cn.e3mall.sso.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.mapper.TbUserMapper;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.pojo.TbUserExample;
import cn.e3mall.pojo.TbUserExample.Criteria;
import cn.e3mall.sso.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private TbUserMapper userMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;
	@Override
	public E3Result userLogin(String username, String password) {
		if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
			return E3Result.build(400, "用户名或密码不能为空，登录失败！");
		}
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		//1.判断用户名和密码是否正确
		List<TbUser> list = userMapper.selectByExample(example );
		if(list == null || list.size()==0){
			return E3Result.build(400, "用户名或密码错误，登录失败！");
		}
		TbUser user = list.get(0);
		if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())){
			//2.如果不正确，返回登录失败
			return E3Result.build(400, "用户名或密码错误，登录失败！");
		}
		//3.如果正确，生成token
		String token = UUID.randomUUID().toString();
		//4.把用户信息写入redis，key:token value:用户信息
		user.setPassword(null);
		jedisClient.set("SESSION:"+token, JsonUtils.objectToJson(user));
		//5.设置session的过期时间
		jedisClient.expire("SESSION:"+token, SESSION_EXPIRE);
		//6.把token返回
		return E3Result.ok(token);
	}

}
