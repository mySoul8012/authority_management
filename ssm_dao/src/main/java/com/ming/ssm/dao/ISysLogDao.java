package com.ming.ssm.dao;

import com.ming.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {

    @Insert("insert into SysLog(visitTime, username, ip, url) value(#{visitTime}, #{username}, #{ip}, #{url})")
    public int save(SysLog sysLog)throws Exception;


    @Select("select * from SysLog")
    public List<SysLog> findAll()throws Exception;

}
