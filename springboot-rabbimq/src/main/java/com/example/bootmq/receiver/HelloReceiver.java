package com.example.bootmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description 消息接送者
 * @date 2019/4/22
 */
@Component
//该注解表示定义接收名为"hello"的queue
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void procees(String hello){
        System.out.println("最后执行我receiver");
        System.out.println("receiver: "+hello);
    }
}
