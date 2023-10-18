package com.example.helloworld.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.helloworld.entity.Order;
import com.example.helloworld.entity.User;
import com.example.helloworld.entity.sqlUser;
import com.example.helloworld.mapper.OrderMapper;
import com.example.helloworld.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @ApiOperation("获取用户")
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id){
        System.out.println(id);
        return "根据ID获取用户信息";
    }

    @PostMapping("/user")
    public String save(User user){
        return "添加用户";
    }

    @PutMapping("/user")
    public String update(User user){
        return "更新用户";
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id){
        System.out.println(id);
        return "根据ID删除用户";
    }

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/eee")
    public sqlUser eee(){
        sqlUser a=userMapper.selectById(1);
        return a;
    }

    @GetMapping("/users/findAll")
    public List<sqlUser> find(){
        return userMapper.selectAllUserAndOrders();
    }

    @GetMapping("/users")
    public List query(){
//        List<sqlUser> list=userMapper.find();
        List<sqlUser> list=userMapper.selectList(null);
        System.out.println(list);
        return list;
    }

    @PostMapping("/users")
    public String save(sqlUser sqluser){
//        int i = userMapper.add(sqluser);
        int i=userMapper.insert(sqluser);
        if(i>0){
            return "插入成功";
        }
        else{
            return "插入失败";
        }
    }

    //condition queries
    @GetMapping("/user/find")
    public List<sqlUser> findByCond(){
        QueryWrapper<sqlUser> queryWrapper=new QueryWrapper();
        queryWrapper.eq("username","lucy");
        return userMapper.selectList(queryWrapper);
    }


    //paginated queries
    @GetMapping("/user/findByPage")
    public IPage findByPage(){
        Page<sqlUser> page=new Page<>(0,2);
        IPage iPage=userMapper.selectPage(page,null);
        return iPage;
    }
}
