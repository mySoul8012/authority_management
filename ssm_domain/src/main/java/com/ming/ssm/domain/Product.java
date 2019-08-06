package com.ming.ssm.domain;

/**
 * 产品信息
 * @author ming
 */
public class Product {
    /**
     *  主键id
     */
    private int id;
    /**
     * 编号 唯一
     */
    private String product_num;
    /**
     * 名称
     */
    private String product_name;
    /**
     * 出发城市
     */
    private String city_name;
    /**
     * 出发时间
     */
    private String departure_time;
    /**
     * 产品价格
     */
    private String product_price;
    /**
     * 产品状态
     */
    private Integer product_status;

    private String product_status_str;

    public String getProduct_status_str() {
        return product_status_str;
    }

    public void setProduct_status_str(String product_status_str) {
        this.product_status_str = product_status_str;
    }

    /**
     * 出发时间格式化
     */
    private String departure_time_str;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_num() {
        return product_num;
    }

    public void setProduct_num(String product_num) {
        this.product_num = product_num;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public Integer getProduct_status() {
        return product_status;
    }

    public void setProduct_status(Integer product_status) {
        if(!"1".equals(product_status)){
            this.product_status_str = "开启";
        }else{
            this.product_status_str = "关闭";
        }
        this.product_status = product_status;
    }

    public String getDeparture_time_str() {
        return departure_time_str;
    }

    public void setDeparture_time_str(String departure_time_str) {
        this.departure_time_str = departure_time_str;
    }
}
