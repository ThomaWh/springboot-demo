package com.example.poi.server;

import com.example.poi.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wh
 * @description
 * @date 2019/5/9
 */
@Service
public class UserService {

    public List<User> getAll(){
        List<User> listUser = new ArrayList<>();
        for (int i = 1 ; i <= 11 ; i++){
            User user = new User("刘国柱"+i,"man"+i,"召唤师峡谷"+i,"A"+i,"法师"+i,"吹牛"+i);
            listUser.add(user);
        }
        return listUser;
    }
}
