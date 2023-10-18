package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworldcontroller {

    //http://localhost:8080/hello?nickname=zhangsan
//    @GetMapping("/hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(String nickname,String phone){
        return "你好 "+nickname+" 手机号码 "+phone;
    }
}
