package com.example.bootemail.constans;

/**
 * @author wh
 * @description rabbitmqx相关常量类
 * @date 2019/5/6
 */
public class Constans {
    /**
     * 消息队列-topic交换机名称
     */
    public static final String MEMBER_TOPIC_EXCHANGE_NAME = "rabbit_mq_topic_exchange_name";
    /**
     * 消息队列-注册会员-队列名称
     */
    public static final String MEMBER_REGISTER_QUEUE_NAME = "rabbit_mq_member_register_queue_name";
    /**
     * 消息队列-注册会员-队列路由键
     */
    public static final String MEMBER_REGISTER_QUEUE_ROUTE_KEY = "register.*";
    /**
     * 消息队列-发送邮件-队列名称
     */
    public static final String MEMBER_SEND_MAIL_QUEUE_NAME = "rabbit_mq_member_send_mail_queue_name";
    /**
     * 消息队列-发送邮件-队列路由键
     */
    public static final String MEMBER_SEND_MAIL_QUEUE_ROUTE_KEY = "register.#";
    /**
     * 消息队列-topic交换机-路由key
     */
    public static final String MEMBER_TOPIC_EXCHANGE_ROUTE_KEY = "register.member";
    /**
     * 邮件文本类型 - HTML
     */
    public static final String SEND_MAIL_HTML_TYPE = "text/html;charset=UTF-8";
    /**
     * 邮件文本类型 - TEXT
     */
    public static final String SEND_MAIL_TEXT_TYPE = "text";

}
