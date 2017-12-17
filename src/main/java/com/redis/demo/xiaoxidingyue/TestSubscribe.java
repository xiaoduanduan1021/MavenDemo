package com.redis.demo.xiaoxidingyue;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * 
 * 订阅测试类
 * 
 * @author shuang1 该类实现对频道redisChatTest的订阅监听，频道的订阅，取消订阅， 收到消息都会调用listener对象的对应方法
 *         注意：subscribe是一个阻塞的方法，在取消订阅该频道前，会一直阻塞在这， 只有当取消了订阅才会执行下面的other
 *         code，参考上面代码，我在onMessage里面收到消息后， 调用了this.unsubscribe();
 *         来取消订阅，这样才会执行后面的other code
 */
public class TestSubscribe {
	@Test
	public void testSubscribe() throws Exception {

		// 设置IP地址和端口
		Jedis jedis = new Jedis("120.27.15.182", 6379);
		// 输入密码，如果没有设置密码这行可以省略
		jedis.auth("xiaoduanduan");

		System.out.println("链接成功");
		
		RedisMsgPubSubListener listener = new RedisMsgPubSubListener();
		
		System.out.println("开始订阅--订阅后会阻塞，一直等待接收消息直到取消订阅方法被调用");
		jedis.subscribe(listener, "chat");
		System.out.println("订阅完成");
		
		// other code
	}
}