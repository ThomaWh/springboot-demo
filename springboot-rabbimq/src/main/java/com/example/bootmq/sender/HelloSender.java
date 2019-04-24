package com.example.bootmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wh
 * @description 消息发送提供者
 * @date 2019/4/22
 */
@Component
public class HelloSender {

    @Autowired
    //提供mq模板的依赖注入
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("sender: "+context);
        System.out.println("再执行我send");
        //表示为向名为"hello"的queue发送context消息
        amqpTemplate.convertAndSend("hello",context);
    }
}
