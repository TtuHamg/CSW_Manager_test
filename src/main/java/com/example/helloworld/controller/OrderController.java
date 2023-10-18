package com.example.helloworld.controller;

import com.example.helloworld.entity.Order;
import com.example.helloworld.entity.sqlUser;
import com.example.helloworld.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/orders")
    public List queryOrders(){
        List<Order> list=orderMapper.find();
        System.out.println(list);
        return list;
    }

    @GetMapping("/orders/findAll")
    public List<Order> find(){
        return orderMapper.selectAllUserAndOrders();
    }
}
