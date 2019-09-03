package com.example.producerserver;

import com.example.producerserver.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *  添加 @EnableEurekaClient 注解表明自己是一个消费者
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ProducerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerServerApplication.class, args);
    }

    @Value("${server.port}")
    String port;

//    @RequestMapping("/hi")
//    public String home(@RequestParam String name)
//    {
//        return "hi " + name + ",i am from port:" + port;
//    }


    @RequestMapping("/hi")
    public Object home(@RequestParam String name)
    {
        Map<String,Object> map = new HashMap<>();
        User user = new User("1","fls");
        String i = "hi"+name+",i am from port:"+port;
        map.put("user",user);
        map.put("str",i);
        return map;
    }

}
