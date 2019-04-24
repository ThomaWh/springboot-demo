package com.example.bootmq.receiver;

import com.example.bootmq.Model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description 对象操作示例：消费者
 * @date 2019/4/22
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    //@RabbitListener(queues = "object",containerFactory = "rabbitListenerContainerFactory")
    @RabbitHandler
    //这里一定要加@Payload否则循环报异常
    public void process(@Payload User user){
        System.out.println(user.getUserName());
        System.out.println("ObjectReceiver:"+user);
    }
}
