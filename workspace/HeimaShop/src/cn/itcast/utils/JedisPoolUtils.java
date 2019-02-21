package cn.itcast.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {
	private static JedisPool pool=null;
	static{
		InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));
		poolConfig.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));
		poolConfig.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString()));
		pool = new JedisPool(poolConfig, pro.getProperty("redis.url"), Integer.parseInt(pro.getProperty("redis.port")));
	}
	public static Jedis getJedis(){
		return pool.getResource();
	}
	public static void main(String[] args){
		Jedis jedis = getJedis();
		System.out.println(jedis.get("xxx"));
	}
}
