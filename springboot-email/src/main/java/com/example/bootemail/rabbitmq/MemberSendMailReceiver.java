package com.example.bootemail.rabbitmq;

import com.example.bootemail.constans.Constans;
import com.example.bootemail.mapper.MemberMapper;
import com.example.bootemail.model.Email;
import com.example.bootemail.model.Member;
import com.example.bootemail.service.EmaliService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description 接收注册成功消息, 发送邮件
 * @date 2019/5/6
 */
@Component
@RabbitListener(queues = Constans.MEMBER_SEND_MAIL_QUEUE_NAME)
public class MemberSendMailReceiver {

    private Logger logger = LoggerFactory.getLogger(MemberSendMailReceiver.class);

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private EmaliService emaliService;
    @RabbitHandler
    public void semdMailHandler(Integer memberId){
        logger.info("会员Id：",memberId);
        Member member = memberMapper.findMemberById(memberId);
        Email email = new Email("wang9982341@163.com",member.getEmail(),"东京热会员注册邮件","注册会员共享资源：狗哥的童年",null);
        emaliService.send(email);
    }
}
