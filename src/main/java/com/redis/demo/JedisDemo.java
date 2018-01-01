package com.redis.demo;



import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

import com.redis.demo.SerializeUtil;
import com.redis.demo.User;

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
	
	/**
	 * list测试
	 */
	@Test
	public void Jedis(){
		//设置IP地址和端口
		
		Jedis jedis = new Jedis("120.27.15.182", 6379);
		
		//输入密码，如果没有设置密码这行可以省略
		jedis.auth("xiaoduanduan");
		
		System.out.println("链接成功");
		
		jedis.lpush("testList", "123");
		jedis.lpush("testList", "234");
		jedis.lpush("testList", "qqq");
		jedis.lpush("testList", "wer");
		
		List<String> ll = jedis.lrange("testList", 0, 100);
		
		for (String string : ll) {
			System.out.println(string);
		}
		
		jedis.close();
	}
	/**
	 * redis事务测试
	 * 
	 * 注意：开启事务后在做修改数据和提交事务等操作都要用transaction，开启事务得把这个东西保存下来
	 */
	@Test
	public void Jedis44() {
		// 设置IP地址和端口
		Jedis jedis = new Jedis("120.27.15.182", 6379);
		// 输入密码，如果没有设置密码这行可以省略
		jedis.auth("xiaoduanduan");

		System.out.println("链接成功");


			Transaction transaction = jedis.multi();
			System.out.println("开启事务");
			transaction.set("a7", "33333333333");
			
			System.out.println(jedis.get("a7"));;
			
			transaction.set("a8", "33333333333");

			List<Object> lll = transaction.exec();

			jedis.close();
	}
	/**
	 * redis事务测试
	 * 
	 * 注意：开启事务后在做修改数据和提交事务等操作都要用transaction，开启事务得把这个东西保存下来
	 */
	@Test
	public void Jedis4344() {
		// 设置IP地址和端口
		Jedis jedis = new Jedis("120.27.15.182", 6379);
		// 输入密码，如果没有设置密码这行可以省略
		jedis.auth("xiaoduanduan");
		
		System.out.println("链接成功");
		
		jedis.set("a5", "asdf");
		
		jedis.set("a6", "asdf");
		
		System.out.println("结束");
		jedis.close();
	}
	/**
	 * redis管道测试
	 * 
	 */
	@Test
	public void Jedi33 () throws Exception {
		// 设置IP地址和端口
		Jedis jedis = new Jedis("120.27.15.182", 6379);
		// 输入密码，如果没有设置密码这行可以省略
		jedis.auth("xiaoduanduan");
		
		System.out.println("链接成功");
		
		Pipeline pipeline = jedis.pipelined();
		
		pipeline.set("a7", "bb");
		pipeline.set("a8", "bb");
		pipeline.set("a9", "bb");
		pipeline.set("a10", "bb");
		
		double a = 1/0;
		
		pipeline.set("a11", "bb");
		
		List<Object> results = pipeline.syncAndReturnAll();
		
		
		
		System.out.println("结束");
		jedis.close();
	}
	
	
	
	public static void main(String[] args) throws Exception {
		new JedisDemo().Jedi33();
	}
}