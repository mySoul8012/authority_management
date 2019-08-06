package com.ming.ssm.dao;

import com.ming.ssm.domain.Orders;
import com.ming.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "order_num", column = "order_num"),
            @Result(property = "order_time", column = "order_time"),
            @Result(property = "people_count", column = "people_count"),
            @Result(property = "order_desc", column = "order_desc"),
            @Result(property = "producter", column = "producter", javaType = Product.class, one = @One(select = "com.ming.ssm.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberid", javaType = IUserDao.class, one = @One(select = "com.ming.ssm.dao.IUserDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "com.ming.ssm.dao.IUserDao.findById"))
    })
    public List<Orders> findAll() throws Exception;


    @Insert("insert into orders(order_num, order_time, people_count, order_desc, pay_type, order_status) values(#{order_num}, #{order_time}, #{people_count}, #{order_desc}, #{pay_type}, #{order_status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int save(Orders orders)throws Exception;
}
