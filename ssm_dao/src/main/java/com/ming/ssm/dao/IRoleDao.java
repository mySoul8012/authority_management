package com.ming.ssm.dao;

import com.ming.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    @Select("select * from Role")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "role_name", column = "role_name"),
            @Result(property = "role_desc", column = "role_desc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.ming.ssm.dao.IPermmissionDao.findById")),
            @Result(property = "users", column = "id", javaType = java.util.List.class, many = @Many(select = "com.ming.ssm.dao.IUserDao.findRoleId"))
}
    )
    public List<Role> findAll()throws Exception;

    @Insert("insert into Role(role_name, role_desc) values(#{role_name}, #{role_desc})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insert(Role role)throws Exception;
}
