package com.example.bootmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description 多对多, 消息消费者1
 * @date 2019/4/22
 */
@Component
@RabbitListener(queues = "many-to-many")
public class ManyToManyReceiver2 {
    @RabbitHandler
    public void procees(String hello){
        System.out.println("**--OneToManyReceiver2--**: "+hello);
    }
}
