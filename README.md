# springcloud-learning
Spring Cloud相关应用

eureka版本 提供注册中心的相关服务

ribbon版本 客户端的负载均衡
可以脱离eureka 来进行负载均衡调用

ribbon+hystrix进行整合
通过Hystrix进行熔断的时候，需要注意超时时间，和线程池的大小
注意配置超时时间

zuul网关 
请求拦截转发  将自定义的filter关掉
http://localhost:7001/nick
http://localhost:7001/tony/find-by-teacher?id=1




