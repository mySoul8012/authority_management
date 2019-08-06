package com.ming.ssm.domain;

import java.util.List;

public class Orders {
    private int id;
    private String order_num;
    private String order_time;
    private String people_count;
    private String order_desc;
    private String pay_type;
    private String order_status;
    private Product producter;
    private User member;
    private List<Traveller> travellers;
    private String order_status_str;

    public String getOrder_status_str() {
        return order_status_str;
    }

    public void setOrder_status_str(String order_status_str) {
        this.order_status_str = order_status_str;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getPeople_count() {
        return people_count;
    }

    public void setPeople_count(String people_count) {
        this.people_count = people_count;
    }

    public String getOrder_desc() {
        return order_desc;
    }

    public void setOrder_desc(String order_desc) {
        this.order_desc = order_desc;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        if("1".equals(order_status)){
            order_status_str = "开启";
        }else{
            order_status_str = "关闭";
        }
        this.order_status = order_status;
    }

    public Product getProducter() {
        return producter;
    }

    public void setProducter(Product producter) {
        this.producter = producter;
    }

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }
}
