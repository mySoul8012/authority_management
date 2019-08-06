package com.ming.ssm.service;

import com.ming.ssm.domain.Permission;
import com.ming.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll() throws Exception;

    public int insert(Role role)throws Exception;

    public boolean insert1(String user_id, String[] permission)throws Exception;

}
