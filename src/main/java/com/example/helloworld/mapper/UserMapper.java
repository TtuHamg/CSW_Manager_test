package com.example.helloworld.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.helloworld.entity.User;
import com.example.helloworld.entity.sqlUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<sqlUser> {
    @Select("select * from user")
    public List<sqlUser> find();

    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public int add(sqlUser sqluser);

    @Select("select * from user")
    @Results({
            @Result(column="id",property="id"),//former is table attribute, later is class attribute
            @Result(column="username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "id",property = "orders",javaType = List.class,
            many=@Many(select = "com.example.helloworld.mapper.OrderMapper.selectByUid"))//one user may has many order, column:id is put into the selectByUid, finally the reuslt is put into the property:orders
    })
    List<sqlUser> selectAllUserAndOrders();

    @Select("select * from user where id=#{id}")
    public sqlUser selectById(int id);


}


