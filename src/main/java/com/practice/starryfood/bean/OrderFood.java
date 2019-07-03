package com.practice.starryfood.bean;

import java.math.BigDecimal;

public class OrderFood {
    private String uuid;

    private String orderId;

    private String foodId;

    private Integer foodNum;

    private BigDecimal foodOnetotalprice;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public Integer getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    public BigDecimal getFoodOnetotalprice() {
        return foodOnetotalprice;
    }

    public void setFoodOnetotalprice(BigDecimal foodOnetotalprice) {
        this.foodOnetotalprice = foodOnetotalprice;
    }
}