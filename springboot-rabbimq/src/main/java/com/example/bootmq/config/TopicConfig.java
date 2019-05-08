package com.example.bootmq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wh
 * @description 主题交换机,消息根据路由键的规则发送到与之匹配的队列上[实际项目写法]
 * @date 2019/4/23
 */
@Configuration
public class TopicConfig {
    private final static Logger log = LoggerFactory.getLogger(TopicConfig.class);
    //自定义队列名称
    public final static String A_QUEUE = "topic.message";
    public final static String B_QUEUE = "topic.messages";

    //自定义交换机名称
    public final static String EXCHANGE_NAME = "exchange";

    //自定义routhing key 路由匹配规则,#代表匹配多个单词或0个,*匹配一个
    public final static String SOLE_ROUTHINGKEY = "topic.message";
    public final static String ALL_ROUTHINGKEY = "topic.#";

    //声明队列
    @Bean(A_QUEUE)
    public Queue queue1(){
        //队列名称
        log.debug("A_QUEUE  实例化创建了");
        return new Queue(A_QUEUE,true);
    }
    @Bean(B_QUEUE)
    public Queue queue2(){
        log.debug("B_QUEUE  实例化创建了");
        return new Queue(B_QUEUE);
    }

    //声明topicExchage  交换机
    @Bean(EXCHANGE_NAME)
    public TopicExchange topicExchange(){
        log.debug("B_QUEUE  实例化创建了");
        return new TopicExchange(EXCHANGE_NAME);
    }

    //将queue,exchange,routhingkey进行绑定,声明Binding
    //代码解释:消息的路由键与 SOLE_ROUTHINGKEY = topic.message ,就将该消息发送至队列A_QUEUE中
    @Bean
    public Binding bindingExchangeMessage1(@Qualifier(A_QUEUE)Queue queue1 , @Qualifier(EXCHANGE_NAME)TopicExchange exchange){
        //BindingBuilder.bind(队列).to(交换机).with(路由键);
        log.debug("绑定单个");
        return BindingBuilder.bind(queue1).to(exchange).with(SOLE_ROUTHINGKEY);
    }

    @Bean
    //代码解释:消息的路由键与 SOLE_ROUTHINGKEY = topic.#（凡是topic开头的） ,就将该消息发送至队列B_QUEUE中
    public Binding bindingExchangeMessage2(@Qualifier(B_QUEUE)Queue queue2 , @Qualifier(EXCHANGE_NAME)TopicExchange topicExchange){
        log.debug("绑定通配符");
        return BindingBuilder.bind(queue2).to(topicExchange).with(ALL_ROUTHINGKEY);
    }
}
