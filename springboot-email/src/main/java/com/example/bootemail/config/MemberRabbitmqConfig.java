package com.example.bootemail.config;

import com.example.bootemail.constans.Constans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wh
 * @description 会员注册-rabbitmq-相关配置
 * @date 2019/5/6
 */
@Configuration
public class MemberRabbitmqConfig {

    private Logger logger = LoggerFactory.getLogger(MemberRabbitmqConfig.class);

    /**
     *
     * @return 交换机实例
     */
    @Bean
    public TopicExchange topicExchange(){
        TopicExchange topicExchange = new TopicExchange(Constans.MEMBER_TOPIC_EXCHANGE_NAME);
        logger.info("交换机实例化");
        return topicExchange;
    }

    /**
     * 会员注册队列
     * @return 会员注册队列实例
     */
    @Bean
    public Queue memberRegisterQueue(){
        Queue memberRegisterQueue = new Queue(Constans.MEMBER_REGISTER_QUEUE_NAME, true);
        logger.info("会员注册队列实例化");
        return memberRegisterQueue;
    }

    /**
     * 发送邮件队列
     * @return 发送邮件队列实例
     */
    @Bean
    public Queue memberSendmailQueue(){
        Queue memberSendmailQueue = new Queue(Constans.MEMBER_SEND_MAIL_QUEUE_NAME, true);
        logger.info("发送邮件队列实例化");
        return memberSendmailQueue;
    }

    @Bean
    public Binding bindingRegister(){
        Binding binding = BindingBuilder.bind(memberRegisterQueue()).to(topicExchange()).with(Constans.MEMBER_REGISTER_QUEUE_ROUTE_KEY);
        logger.info("注册binding完成");
        return binding;
    }

    @Bean
    public Binding bindingSendmail(){
        Binding binding = BindingBuilder.bind(memberSendmailQueue()).to(topicExchange()).with(Constans.MEMBER_SEND_MAIL_QUEUE_ROUTE_KEY);
        logger.info("发送邮件binding完成");
        return binding;
    }
}
