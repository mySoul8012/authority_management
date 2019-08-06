package com.ming.ssm.service.impl;

import com.ming.ssm.dao.IUserDao;
import com.ming.ssm.domain.Role;
import com.ming.ssm.domain.User;
import com.ming.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = null;
        try {
            user = iUserDao.findByUserName1(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        org.springframework.security.core.userdetails.User user1;
        user1 = new org.springframework.security.core.userdetails.User(user.getUsername(), "{noop}" + user.getPassword(),  this.getAuthority(user.getRoles()));
        return user1;
    }


    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for(Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRole_name()));
        }
        return list;
    }
}
