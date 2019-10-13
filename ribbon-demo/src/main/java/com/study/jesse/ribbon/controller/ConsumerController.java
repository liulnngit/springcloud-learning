package com.study.jesse.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.study.jesse.ribbon.command.CommandForIndex;
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
        //通过ribbon进行负载均衡调用
        //return restTemplate.getForObject("http://helloclient/user?id="+id,Object.class);
        //通过服务降级调用
        return new CommandForIndex(id,restTemplate).execute();
    }

    @HystrixCommand(fallbackMethod = "callTimeoutFallBack",
            //配置线程池
            threadPoolProperties = { @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "1") },
            // 配置命令执行相关的，示例：超时时间
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
    @GetMapping("hts")
    public Object hystrixIndex(String id){
        //通过ribbon进行负载均衡调用
        return restTemplate.getForObject("http://helloclient/user?id="+id,Object.class);
    }

    public String callTimeoutFallBack(){
        return "查询超时啦，我降级了。";
    }

}
