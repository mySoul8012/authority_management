package com.ming.ssm.service;

import com.ming.ssm.domain.Permission;

import java.util.List;

public interface IPermission {
    public List<Permission> findAll()throws Exception;

    public int insert(Permission permission)throws Exception;
}
