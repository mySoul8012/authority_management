package com.ming.ssm.domain;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private String phone_num;
    private String status;
    private String password;
    private String statusStr;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if("1".equals(status)){
            this.statusStr = "开启";
        }else{
            this.statusStr = "关闭";
        }
        this.status = status;
    }
}
