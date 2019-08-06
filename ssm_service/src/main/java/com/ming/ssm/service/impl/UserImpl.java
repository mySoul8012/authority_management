package com.ming.ssm.service.impl;

import com.ming.ssm.dao.IProductDao;
import com.ming.ssm.dao.IRole;
import com.ming.ssm.dao.IUserDao;
import com.ming.ssm.domain.Role;
import com.ming.ssm.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userImpl")
public class UserImpl implements User {
    @Autowired
    private IProductDao productDao;
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private IRole iRole;

    public List<com.ming.ssm.domain.User> findAll() throws Exception {
        return productDao.findUserAll();
    }

    public boolean isUser(com.ming.ssm.domain.User user) throws Exception {
        user.setPassword(user.getPassword());
        // 从数据库中获取user对象
        com.ming.ssm.domain.User user1 = iUserDao.findByUserName(user.getUsername());
        // 判断user1 是否存在
        if(user1 == null){
            return false;
        }

        // 判断password是否为空
        if(user1.getPassword() == null){
            return false;
        }


        // 比较
        if(user1.getPassword().equals(user.getPassword())){
            return true;
        }

        return false;
    }

    public int save(com.ming.ssm.domain.User User) throws Exception {
        return productDao.saveUser(User);
    }

    public com.ming.ssm.domain.User findById(String id) throws Exception {
        return iUserDao.findById(id);
    }

    public List<Role> findOtherRoles(String id) throws Exception {
        return iRole.findRole(id);
    }

    public boolean insert(String[] role_id, String user_id) throws Exception {
        int res = 0;
        for(int i = 0; i < role_id.length; i++){
            res = iRole.insert(user_id, role_id[i]);
        }
        if("1".equals(res)){
            return true;
        }
        return false;
    }
}
