package com.ming.ssm.service;

import com.ming.ssm.domain.Role;

import java.util.List;

public interface User {
    public List<com.ming.ssm.domain.User> findAll() throws Exception;

    public int save(com.ming.ssm.domain.User User) throws Exception;

    public boolean isUser(com.ming.ssm.domain.User user) throws Exception;

    public com.ming.ssm.domain.User findById(String id) throws Exception;

    public List<Role> findOtherRoles(String id)throws Exception;

    public boolean insert(String[] role_id, String user_id)throws Exception;
}
