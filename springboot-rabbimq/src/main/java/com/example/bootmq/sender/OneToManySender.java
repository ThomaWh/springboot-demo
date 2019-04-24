package com.example.bootmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description 一对多 消息提供者
 * @date 2019/4/22
 */
@Component
public class OneToManySender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int counter){
        String message = "消息提供者第"+counter+"发送消息";
        System.out.println("第"+counter+"进入消息提供者send方法");
        this.amqpTemplate.convertAndSend("one-to-many",message);
    }
}
