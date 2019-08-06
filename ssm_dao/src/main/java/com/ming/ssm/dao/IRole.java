package com.ming.ssm.dao;

import com.ming.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRole {

    @Select("select * from Role where id in (select role_id from users_role where user_id = #{userid})")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "role_name", column = "role_name"),
            @Result(property = "role_desc", column = "role_desc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.ming.ssm.dao.IPermmissionDao.findById")),
            @Result(property = "users", column = "id", javaType = java.util.List.class, many = @Many(select = "com.ming.ssm.dao.IUserDao.findRoleId"))
    })
    public List<Role> findById(String userid)throws Exception;


    @Select("select * from Role")
    public List<Role> findRole(String userid)throws Exception;

    @Insert("insert into users_role(user_id, role_id) values(#{user_id}, #{role_id})")
    public int insert(@Param(value = "user_id") String user_id, @Param(value = "role_id") String role_id)throws Exception;

    @Insert("insert into role_permission(role_id, permission) values(#{user_id}, #{permission})")
    public int insert1(@Param(value="user_id") String user_id, @Param(value = "permission")String permission)throws Exception;
}
