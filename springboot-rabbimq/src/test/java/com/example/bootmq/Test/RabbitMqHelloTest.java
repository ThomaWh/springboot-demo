package com.example.bootmq.Test;

import com.example.bootmq.Model.User;
import com.example.bootmq.sender.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wh
 * @description hello mq 测试
 * @date 2019/4/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {
    //一对一示例
    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello(){

        helloSender.send();
    }
    //一对多示例
    @Autowired
    private OneToManySender oneToManySender;

    @Test
    public void oneToMany(){
        for (int i = 1; i < 30; i++) {
            oneToManySender.send(i);
        }

    }
    //多对多示例
    @Autowired
    private ManyToManySender1 manyToManySender1;
    @Autowired
    private ManyToManySender2 manyToManySender2;
    @Autowired
    private ManyToManySender3 manyToManySender3;
    @Test
    public void manyToMany(){
        for (int i = 1; i < 21; i++) {
            manyToManySender1.send(i);
            manyToManySender2.send(i);
            manyToManySender3.send(i);
        }

    }

    //对象操作示例
    @Autowired
    private ObjectSender objectSender;
    @Test
    public void obj(){
        User user = new User("北凉","徐凤年");
        objectSender.send(user);
    }

    @Autowired
    private TopicSender topicSender;
    @Test
    public void topic(){
        User user = new User("北凉","徐凤年");
        //topicSender.send1(user);
        topicSender.send2(user);
    }

    @Autowired
    private FanoutSender fanoutSender;
    @Test
    public void fanout(){
        User user = new User("北凉","徐凤年");
        fanoutSender.send1(user);
    }

    @Test
    public void aa(){
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        String str = "b";
        boolean contains = list.contains(str);
        System.out.println(contains);
    }
}
