package com.zxh.demo.service.impl;

import com.zxh.demo.dao.UserDao;
import com.zxh.demo.model.User;
import com.zxh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: znn
 * @date: 2020/08/2020/8/4
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }
}
