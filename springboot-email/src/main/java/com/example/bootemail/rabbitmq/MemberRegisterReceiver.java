package com.example.bootemail.rabbitmq;

import com.example.bootemail.constans.Constans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description 用户注册消息接收者
 * @date 2019/5/6
 */
@Component
@RabbitListener(queues = Constans.MEMBER_REGISTER_QUEUE_NAME)
public class MemberRegisterReceiver {

    private Logger logger = LoggerFactory.getLogger(MemberRegisterReceiver.class);

    @RabbitHandler
    public void habdler(Integer memberId){
            logger.info("接收会员注册成功消息 ......邮件准备中");
    }
}
