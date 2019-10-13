package com.study.jesse.hello.controller;

import com.study.jesse.hello.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/say.html")
    public String sayHello(){
        return "hello Jesse";
    }


    @GetMapping("/user")
    public Object getUser(@Param("id")String id){
        System.out.println("服务端已经接到请求，开始休眠3秒");
        //进行休眠，便于测试Hystrix降级
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是客户端1返回的结果");
        return userDao.get(id);
    }
}
