package com.example.bootmq.sender;

import com.example.bootmq.config.TopicConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author wh
 * @description 基于topic生产者1
 * @date 2019/4/23
 */
@Component
public class TopicSender {
    private Logger logger = LoggerFactory.getLogger(TopicSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send1(Object object){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        String context = "hi i am message1";
        logger.debug(context);
        //(exchange,routhingkey,object要发送的消息对象,唯一标识id)
        rabbitTemplate.convertAndSend(TopicConfig.EXCHANGE_NAME , TopicConfig.SOLE_ROUTHINGKEY , object , correlationData);
    }

    public void send2(Object object){
        String context = "hi i m messages2";
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(TopicConfig.EXCHANGE_NAME , TopicConfig.ALL_ROUTHINGKEY , object , correlationData);
    }

}
