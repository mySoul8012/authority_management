package com.ming.ssm.domain;

public class Traveller {
    private int id;
    private String name;
    private String sex;
    private String phonenumber;
    private String credentials_num;
    private int traveller_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCredentials_num() {
        return credentials_num;
    }

    public void setCredentials_num(String credentials_num) {
        this.credentials_num = credentials_num;
    }

    public int getTraveller_type() {
        return traveller_type;
    }

    public void setTraveller_type(int traveller_type) {
        this.traveller_type = traveller_type;
    }
}
