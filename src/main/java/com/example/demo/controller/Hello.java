package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Hello {
    private static volatile AtomicInteger id = new AtomicInteger(0);

    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello " + name;
    }

    /**
     * 请求示例：http://localhost:8080/hello2?name=zhangsan
     * @param name
     * @return
     */
    @RequestMapping("/hello2")
    public User helloToUser(String name) {
        User user = new User();
        user.setId(id.getAndIncrement());
        user.setName(name);
        return user;
    }
}
