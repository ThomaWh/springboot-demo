package com.example.bootemail.rabbitmq;

import com.example.bootemail.constans.Constans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author wh
 * @description 用户注册消息发送者
 * @date 2019/5/6
 */
@Component
public class MemberRegisterSender {

    private Logger logger = LoggerFactory.getLogger(MemberRegisterSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendRegisterSuccess(Integer memberId){
        logger.info("会员注册成功");
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(Constans.MEMBER_TOPIC_EXCHANGE_NAME,Constans.MEMBER_TOPIC_EXCHANGE_ROUTE_KEY,memberId,correlationData);
    }
}
