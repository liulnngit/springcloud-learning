package com.study.jesse.hello.controller;

import com.study.jesse.hello.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/user")
    public Object getUser(String id){
        System.out.println("这是客户端2返回的结果");
        return userDao.get(id);
    }


}
