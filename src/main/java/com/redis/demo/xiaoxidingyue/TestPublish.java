package com.redis.demo.xiaoxidingyue;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * 
 * 发布消息测试类 这个类向频道redisChatTest发布消息，第二步因为订阅了该频道，所以会收到该消息。
 * 
 * @author shuang1
 * 
 */
public class TestPublish {
	@Test
	public void testPublish() throws Exception {

		// 设置IP地址和端口
		Jedis jedis = new Jedis("120.27.15.182", 6379);
		// 输入密码，如果没有设置密码这行可以省略
		jedis.auth("xiaoduanduan");

		System.out.println("链接成功");

		jedis.publish("chat", "我是天才");
		jedis.publish("chat", "我牛逼");
		jedis.publish("chat", "哈哈");
//		jedis.publish("chat", "取消订阅");
		
		
		
	}
	
	/**
	 * 取消订阅
	 * @throws Exception
	 */
	@Test
	
	public void testPubli() throws Exception {
		
		// 设置IP地址和端口
		Jedis jedis = new Jedis("120.27.15.182", 6379);
		// 输入密码，如果没有设置密码这行可以省略
		jedis.auth("xiaoduanduan");
		
		System.out.println("链接成功");
		System.out.println("取消完成");
	}
	
	
}
