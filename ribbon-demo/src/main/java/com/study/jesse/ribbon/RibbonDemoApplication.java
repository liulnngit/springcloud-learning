package com.study.jesse.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class RibbonDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonDemoApplication.class, args);
    }

   /* @Bean
    //@LoadBalanced  直接走RestTemplate 没有走Ribbon
    public RestTemplate template(){
        return new RestTemplate();
    }*/

    @Bean
    @LoadBalanced
    public RestTemplate template(){
        return new RestTemplate();
    }


}



