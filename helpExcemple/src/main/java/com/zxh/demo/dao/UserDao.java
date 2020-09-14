package com.zxh.demo.dao;

import com.zxh.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: znn
 * @date: 2020/08/2020/8/4
 * @description 用户表dao
 */
@Repository
public class UserDao {

    public List<User> queryAll() {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setUserId("1");
        user1.setLoginName("张三");
        User user2 = new User();
        user2.setUserId("2");
        user2.setLoginName("李四");
        list.add(user1);
        list.add(user2);
        return list;
    }
}
