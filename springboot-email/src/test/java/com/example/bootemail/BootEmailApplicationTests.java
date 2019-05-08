package com.example.bootemail;

import com.alibaba.fastjson.JSONObject;
import com.example.bootemail.model.Email;
import com.example.bootemail.service.EmaliService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootEmailApplicationTests {
    @Autowired
    EmaliService emaliService;
    Email email = new Email("wang9982341@163.com" ,
            "925346457@qq.com" ,
            "澳门首家赌场上线啦" ,"恭喜您注册成为性感荷官，在线发牌",
            "E:\\WEB-INF\\ThinkInJava.pdf");

    @Test
    public void emailTest() {
        emaliService.send(email);

    }

    @Test
    public void accessory() {
        emaliService.sendAccessory(email);
    }

    @Test
    public void abb(){
        Email email = new Email("a","b","c","d","e");
        String jsonString = JSONObject.toJSONString(email);
        System.out.println(jsonString);
        Email email1 = JSONObject.parseObject(jsonString, Email.class);
        System.out.println(email1);
        int i = 3;
        String s = Integer.toBinaryString(i);
        i =  2<<i;
        System.out.println(i);
        //System.out.println(int a = <<i);
    }

    /**
     * 群发邮件测试
     */
    @Test
    public void sendAllEmail(){
        emaliService.sendGroupEmail(email);
    }

}
