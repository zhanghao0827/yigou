package com.yigou.portal.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisMessageListener implements MessageListener {

    /**
     * message：要处理的消息
     * @param message 消息内容
     * @param bytes 获取的频道信息
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();// 建议使用: valueSerializer
        byte[] channel = message.getChannel();
        System.out.print("onMessage >> ");
        System.out.println(String.format("channel: %s, body: %s, bytes: %s"
                , new String(channel), new String(body), new String(bytes)));
    }
}
