package com.example.bootmq.receiver;

import com.example.bootmq.config.TopicConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description 基于topic消费者2
 * @date 2019/4/23
 */
@Component
@RabbitListener(queues = TopicConfig.B_QUEUE)
public class TopicReceiver2 {

    @RabbitHandler
    public void process(Object object){
        System.out.println("****TopicReceiver2"+object);
    }
}
