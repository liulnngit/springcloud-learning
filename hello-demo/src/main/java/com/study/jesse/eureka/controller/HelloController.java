package com.study.jesse.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/say.html")
    public String sayHello(){
        return "hello Jesse";
    }


}
