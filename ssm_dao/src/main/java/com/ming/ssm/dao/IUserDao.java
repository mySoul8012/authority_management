package com.ming.ssm.dao;

import com.ming.ssm.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Select("select * from User where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.ming.ssm.dao.IRole.findById"))
    })
    public com.ming.ssm.domain.User findById(@Param("id") String id) throws Exception;

    @Select("select * from User where username = #{name} ")
    public com.ming.ssm.domain.User findByUserName(@Param("name")String name)throws Exception;


    @Select("select * from User where id in (select user_id from users_role where role_id = #{id})")
    public List<User> findRoleId(@Param("id")String id)throws Exception;


    @Select("select * from User where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.ming.ssm.dao.IRole.findById"))
    })
    public User findByUserName1(String username) throws Exception;
}
