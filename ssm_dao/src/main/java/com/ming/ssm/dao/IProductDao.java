package com.ming.ssm.dao;

import com.ming.ssm.domain.Product;
import com.ming.ssm.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    /**
     * 查询所有产品信息
     * @return
     */
    @Select("select * from spring.product")
    public List<Product> findAll() throws Exception;

    @Select("select * from product where id = #{id}")
    public Product findById(@Param("id") int id) throws Exception;


    @Insert("insert into product(product_num, product_name, city_name, departure_time, product_price, product_status) values (#{product_num}, #{product_name}, #{city_name}, #{departure_time}, #{product_price}, #{product_status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int save(Product product);

    @Select("select * from User")
    public List<com.ming.ssm.domain.User> findUserAll() throws Exception;

    @Insert("insert into User(username, email, phone_num, status, password) values(#{username}, #{email}, #{phone_num}, #{status}, #{password})")
    public int saveUser(com.ming.ssm.domain.User user)throws Exception;
}
