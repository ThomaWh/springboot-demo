package com.example.bootmq.receiver;

import com.example.bootmq.config.TopicConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description 基于topic消费者1
 * @date 2019/4/23
 */
@Component
@RabbitListener(queues = TopicConfig.A_QUEUE)
public class TopicReceiver1 {
    @RabbitHandler
    public void process(Object object){
        System.out.println("****TopicReceiver1："+object);
    }
}
