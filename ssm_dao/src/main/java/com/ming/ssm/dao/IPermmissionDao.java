package com.ming.ssm.dao;

import com.ming.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermmissionDao {
    @Select("select * from permission where id in (select permission from role_permission where role_id = #{id})")
    public List<Permission> findById(String id)throws Exception;

    @Select("select * from permission")
    public List<Permission> findAll()throws Exception;

    @Insert("insert into permission(perssion_name, url) values(#{perssion_name}, #{url})")
    public int insert(Permission permission)throws Exception;
}
