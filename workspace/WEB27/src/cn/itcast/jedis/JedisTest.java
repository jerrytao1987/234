package cn.itcast.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
	//通过java程序访问redis数据库
	@Test
	public void test1(){
		
		//1.获得连接对象
		Jedis jedis = new Jedis("192.168.44.129", 6379);
		//2.获得数据
		String username = jedis.get("username");
		System.out.println(username);
		//3.存储
		jedis.set("addr", "北京");
		System.out.println(jedis.get("addr"));
	}
	
	//通过jedis的pool获得jedis连接对象
	@Test
	public void test2(){
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(30);
		poolConfig.setMinIdle(10);
		poolConfig.setMaxTotal(50);
		JedisPool pool = new JedisPool(poolConfig, "192.168.44.129", 6379);
		Jedis jedis = pool.getResource();
		jedis.set("xxx","yyy");
		System.out.println(jedis.get("xxx"));
		jedis.close();
		pool.close();
	}
}
