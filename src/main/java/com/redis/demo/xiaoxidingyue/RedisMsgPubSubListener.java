package com.redis.demo.xiaoxidingyue;
import redis.clients.jedis.JedisPubSub;

/**
 * 首先需要一个消息监听器类
 * 
 * 该类需要继承JedisPubSub ，并实现其抽象方法，通过方法的名称很清楚的看出来，
 * 这个监听器是用来订阅一个频道，在订阅该频道，取消订阅，
 * 收到消息等状态会对应调用相关的方法
 * 
 * Created by denglinjie on 2016/6/29.
 */
public class RedisMsgPubSubListener extends JedisPubSub {
    @Override
    
    //取消订阅
    public void unsubscribe() {
        super.unsubscribe();
    }

    @Override
    public void unsubscribe(String... channels) {
        super.unsubscribe(channels);
    }

    @Override
    public void subscribe(String... channels) {
        super.subscribe(channels);
    }

    @Override
    public void psubscribe(String... patterns) {
        super.psubscribe(patterns);
    }

    @Override
    public void punsubscribe() {
        super.punsubscribe();
    }

    @Override
    public void punsubscribe(String... patterns) {
        super.punsubscribe(patterns);
    }

    @Override
    public void onMessage(String channel, String message) {
        System.out.println("channel:" + channel + "receives message :" + message);
        if (message.equals("取消订阅")) {
        	this.unsubscribe();
		}
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {

    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("channel:" + channel + "is been subscribed:" + subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {

    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {

    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("channel:" + channel + "is been unsubscribed:" + subscribedChannels);
    }
}