package com.example.bootmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wh
 * @description 分发/订阅交换机
 * @date 2019/4/24
 */
@Configuration
public class FanoutConfig {
    //自定义队列名称
    public final static String A_QUEUE = "fanout.A";
    public final static String B_QUEUE = "fanout.B";
    public final static String C_QUEUE = "fanout.C";

    //定义交换机名称
    public final static String EXCHANGE_NAME = "fanout.exchange";

    //定义交换机类型
    @Bean(EXCHANGE_NAME)
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(EXCHANGE_NAME);
    }

    //创建队列实例
    @Bean(A_QUEUE)
    public Queue queueA(){
        return new Queue(A_QUEUE);
    }

    @Bean(B_QUEUE)
    public Queue queueB(){
        return new Queue(B_QUEUE);
    }

    @Bean(C_QUEUE)
    public Queue queueC(){
        return new Queue(C_QUEUE);
    }

    //绑定队列,交换机  因为交换机为fanout exchange所以routhingkey没用
    @Bean
    public Binding bindingA(@Qualifier(A_QUEUE) Queue queue , @Qualifier(EXCHANGE_NAME) FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingB(@Qualifier(B_QUEUE) Queue queue , @Qualifier(EXCHANGE_NAME) FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingC(@Qualifier(C_QUEUE) Queue queue , @Qualifier(EXCHANGE_NAME) FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
