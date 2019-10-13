package com.study.jesse.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("")
    public Object index(String id){
        //直接是通过RestTemplate进行调用
        //return restTemplate.getForObject("http://localhost:8001/user?id="+id,Object.class);
        return restTemplate.getForObject("http://helloclient/user?id="+id,Object.class);
    }



}
