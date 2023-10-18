package com.example.helloworld.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.helloworld.entity.Order;
import com.example.helloworld.entity.sqlUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from t_order where uid=#{uid}")
    List<Order> selectByUid(int uid);

    @Select("select * from t_order")
    List<Order> find();

    @Select("select * from t_order")
    @Results({
            @Result(column="id",property="id"),//former is table attribute, later is class attribute
            @Result(column="order_time",property = "orderTime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "uuser",javaType = sqlUser.class,
                    one=@One(select = "com.example.helloworld.mapper.UserMapper.selectById"))//one user may has many order, column:id is put into the selectByUid, finally the reuslt is put into the property:orders
    })
    List<Order> selectAllUserAndOrders();
}
