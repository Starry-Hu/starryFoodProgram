package com.practice.starryfood.bean;

import java.math.BigDecimal;

public class OrderFood {
    private String uuid;

    private String orderid;

    private String foodid;

    private Integer foodnum;

    private BigDecimal foodonetotalprice;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid;
    }

    public Integer getFoodnum() {
        return foodnum;
    }

    public void setFoodnum(Integer foodnum) {
        this.foodnum = foodnum;
    }

    public BigDecimal getFoodonetotalprice() {
        return foodonetotalprice;
    }

    public void setFoodonetotalprice(BigDecimal foodonetotalprice) {
        this.foodonetotalprice = foodonetotalprice;
    }
}