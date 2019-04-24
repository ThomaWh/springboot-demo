package com.example.bootmq.sender;

        import com.example.bootmq.Model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description 对象操作示例：提供者
 * @date 2019/4/22
 */
@Component
public class ObjectSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(User user){
        System.out.println("ObjectSender:"+user);
        rabbitTemplate.convertAndSend("object",user);
    }
}
