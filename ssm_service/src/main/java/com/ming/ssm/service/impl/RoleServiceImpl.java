package com.ming.ssm.service.impl;

import com.ming.ssm.dao.IRole;
import com.ming.ssm.dao.IRoleDao;
import com.ming.ssm.domain.Role;
import com.ming.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;
    @Autowired
    private IRole iRole;

    public List<Role> findAll() throws Exception {
        return iRoleDao.findAll(); }

    public int insert(Role role) throws Exception {
        return iRoleDao.insert(role);
    }

    public boolean insert1(String user_id, String[] permission) throws Exception {
        int res = 0;
        for(int i = 0; i < permission.length; i++){
            res = iRole.insert1(user_id, permission[i]);
        }
        if(1 == res){
            return true;
        }

        return false;

    }
}
