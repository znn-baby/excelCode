package com.zxh.demo.service;

import com.zxh.demo.model.User;

import java.util.List;

/**
 * @author: znn
 * @date: 2020/08/2020/8/4
 * @description 用户表service
 */
public interface UserService {
    /**
     * 查询所有
     * @return 用户集合
     */
    List<User> queryAll();
}
