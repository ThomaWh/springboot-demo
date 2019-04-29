package com.example.jsondemo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.jsondemo.controller.JsonDemoController;
import com.example.jsondemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsondemoApplicationTests {
    @Autowired
    private JsonDemoController jsonDemoController;
    @Test
    public void contextLoads() {
        //map示例
        Map map = jsonDemoController.outPut();
       // JSONObject jsonObject = JSONObject.parseObject(map.toString());
        String s = JSONObject.toJSONString(map);
        System.out.println(s);
        JSONObject jsonObject = JSONObject.parseObject(s);
        User user1 = jsonObject.getObject("user1", User.class);
        System.out.println(user1.getUserName());
        //System.out.println(user);
        //Object o = jsonObject.get("user1");
       // System.out.println(o);
       /* System.out.println("jsonObject:"+jsonObject);
        //User user = (User)jsonObject.get("user1");
        User user1 = jsonObject.getObject("user1", User.class);
        System.out.println("user1的userName:"+user1.getUserName());*/
    }
    @Test
    public void list(){
        //String out = jsonDemoController.out();
        List out = jsonDemoController.out();
       /* List<User> users = JSONArray.parseArray(out, User.class);
        for (User user : users) {
            System.out.println(user);
        }*/
        System.out.println(out);
        String s = JSONObject.toJSONString(out);
        List<User> users = JSONArray.parseArray(s, User.class);
        for (User user : users) {
            System.out.println(users);
        }
        System.out.println(s);
       // System.out.println("out:"+user.getUserName());
       // System.out.println("object:"+parse);
    }

    @Test
    public void entity(){
        User user = new User("凤歌","男",12);
        System.out.println(user);
        String jsonString = JSONObject.toJSONString(user);
        System.out.println(jsonString);
        User user1 = JSONObject.parseObject(jsonString, User.class);
        System.out.println(user1.getUserName());
    }

    @Test
    public void testaa(){
        List<User> out = jsonDemoController.out();
        for (User user : out) {
            System.out.println(user);
        }
    }
}
