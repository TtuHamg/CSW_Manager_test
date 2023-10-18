package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.*;
import com.example.helloworld.entity.User;

@RestController
public class ParamController {
    //http://localhost:8080/getTest2?nickname=XXX
    @RequestMapping(value = "/getTest3",method= RequestMethod.GET)
    public String getTest3(@RequestParam(value = "nickname",required = false) String name){
        System.out.println("nickname: "+name);
        return "Get请求";
    }

    @RequestMapping(value = "/postTest1",method = RequestMethod.POST)
    public String postTest1(){
        return "Post请求";
    }

    @RequestMapping(value = "/postTest2",method = RequestMethod.POST)
    public String postTest2(String username, String password){
        System.out.println("username: "+username);
        System.out.println("password: "+password);
        return "Post请求";
    }

    @RequestMapping(value = "/postTest3",method = RequestMethod.POST)
    public String postTest3(User user){
        System.out.println(user);
        return "Post请求";
    }

    @RequestMapping(value = "/postTest4",method = RequestMethod.POST)
    public String postTest4(@RequestBody User user){
        System.out.println(user);
        return "Post请求";
    }
}
