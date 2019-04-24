package com.example.bootmq.receiver;

import com.example.bootmq.config.FanoutConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description fanout1消费者
 * @date 2019/4/24
 */
@Component
@RabbitListener(queues = FanoutConfig.B_QUEUE)
public class FanoutReceiver2 {

    @RabbitHandler
    public void procees(Object o){
        System.out.println(o);
    }
}
