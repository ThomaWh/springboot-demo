package com.example.bootmq.sender;

import com.example.bootmq.config.FanoutConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description fanout生产者
 * @date 2019/4/24
 */
@Component
public class FanoutSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send1(Object o){
        System.out.println("sen1");
        rabbitTemplate.convertAndSend(FanoutConfig.EXCHANGE_NAME,"",o);
    }

   /* public void send2(Object o){
        System.out.println("sen2");
        rabbitTemplate.convertAndSend(FanoutConfig.EXCHANGE_NAME,"",o);
    }

    public void send3(Object o){
        System.out.println("sen3");
        rabbitTemplate.convertAndSend(FanoutConfig.EXCHANGE_NAME,"",o);
    }*/
}
