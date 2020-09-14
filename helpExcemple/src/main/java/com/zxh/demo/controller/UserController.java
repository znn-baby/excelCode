package com.zxh.demo.controller;

import com.zxh.demo.model.User;
import com.zxh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: znn
 * @date: 2020/08/2020/8/4
 * @description 用户查询
 */
@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userServiceImpl;

    @Autowired
    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping("query")
    public String query(Model model) {
        List<User> userList = userServiceImpl.queryAll();
        model.addAttribute("userList", userList);
        System.out.println("======主方法======");
        //int a = 1/0;
        return "layout/hello";
    }
}
