package com.example.bootmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wh
 * @description
 * @date 2019/4/22
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        //声明了一个为"heelo"的队列
        System.out.println("首先执行queue");
        return new Queue("hello");
    }

    @Bean
    public Queue oneToManyQueue(){
        return new Queue("one-to-many");
    }

    @Bean
    public Queue manyToManyQueue(){
        return new Queue("many-to-many");
    }

    @Bean
    public Queue objectQueue(){
        return new Queue("object");
    }

    /**
     * 定义rabbitTemplate用于数据(消息)接收和发送
     * @param connectionFactory
     * @return
     */
    /*@Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }*/


}
