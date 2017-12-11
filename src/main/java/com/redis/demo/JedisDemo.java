package com.redis.demo;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis测试
 * @author shuang1
 *
 */
public class JedisDemo {
	

	/**
	 * 单例测试
	 */
	@Test
	public void Jedistest(){
		//设置IP地址和端口
		
		Jedis jedis = new Jedis("120.27.15.182", 6379);
		
		//输入密码，如果没有设置密码这行可以省略
		jedis.auth("xiaoduanduan");
		
		jedis.set("name", "12121212");
		
		System.out.println(jedis.get("name"));
		System.out.println(jedis.keys("*")); 
		jedis.close();
	}
	
	/**
	 * 测试连接池方式
	 */
	@Test
	public void test2(){
		
		//获取连接池的配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		//设置最大连接数
		config.setMaxTotal(30);
		//谁知最大空闲连接数
		config.setMaxIdle(10);
		//获取连接池：
		JedisPool jedisPool = new JedisPool("120.27.15.182", 6379);
		//获取连接
		Jedis jedis = null ;
		try {
			//通过连接池获取连接
			jedis = jedisPool.getResource();
			jedis.auth("xiaoduanduan");
			
			jedis.set("name", "123123");
			System.out.println("111111111111111111");
			System.out.println(jedis.get("name"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			if (jedis!=null) {
				jedis.close();
			}
			if(jedisPool != null){
				jedisPool.close();
			}
		}
	}
	
	
	/**
	 * 存储对象测试
	 */
	@Test
	public void Jedistest3(){
		//设置IP地址和端口
		
		Jedis jedis = new Jedis("120.27.15.182", 6379);
		
		//输入密码，如果没有设置密码这行可以省略
		jedis.auth("xiaoduanduan");
		
		User u = new User();
		u.setId(1);
		u.setName("对象测试");
		
		System.out.println(SerializeUtil.serialize(u));
		
//		jedis.set("1", "111111111");
		jedis.set("user1".getBytes(), SerializeUtil.serialize(u));
		
		byte [] os = jedis.get("user1".getBytes());
		
		Object o = SerializeUtil.unserialize(os);
		
		User u2 = (User) o;
		
		System.out.println(u2.getName());
		System.out.println(u2.getId());
		
		jedis.close();
	}
}
