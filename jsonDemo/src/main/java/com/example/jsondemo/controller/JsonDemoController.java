package com.example.jsondemo.controller;

import com.example.jsondemo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wh
 * @description json示例操作
 * @date 2019/4/29
 */
@RestController
public class JsonDemoController {

    @GetMapping("outPut")
    public Map outPut(){
        Map map = new HashMap();
        map.put("user1",new User("a","n",12));
        map.put("user2",new User("b","n",12));
        map.put("user3",new User("c","n",12));
        //讲对象转换成json对象
        /*Object o = JSONObject.toJSON(map);
        System.out.println("转换成对象："+o);
        String s = JSONObject.toJSONString(map);
        System.out.println("string :"+s);*/

        return map;
    }

    @GetMapping("out")
    public List out(){
        List<User> list = new ArrayList();
        list.add(new User("a","n",12));
        list.add(new User("b","n",12));
        list.add(new User("c","n",12));
        /*String s = JSONObject.toJSONString(list);
        JSONArray objects = JSONArray.parseArray(s);*/
        return list;
    }


}
