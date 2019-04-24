package com.example.bootmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description 多对多 消息提供者
 * @date 2019/4/22
 */
@Component
public class ManyToManySender1 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int counter){
        String message = "--$ManyToManySender1$--:消息提供者第"+counter+"发送消息";
        System.out.println(message);
        this.amqpTemplate.convertAndSend("many-to-many",message);
    }
}
