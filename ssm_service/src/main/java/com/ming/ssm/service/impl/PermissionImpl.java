package com.ming.ssm.service.impl;

import com.ming.ssm.dao.IPermmissionDao;
import com.ming.ssm.service.IPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="permission")
public class PermissionImpl implements IPermission {
    @Autowired
    private IPermmissionDao permmissionDao;

    public List<com.ming.ssm.domain.Permission> findAll() throws Exception {
        return permmissionDao.findAll();
    }

    public int insert(com.ming.ssm.domain.Permission permission) throws Exception {
        return permmissionDao.insert(permission);
    }
}
