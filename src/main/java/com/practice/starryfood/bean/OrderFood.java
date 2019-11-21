package com.practice.starryfood.bean;

import java.math.BigDecimal;

public class OrderFood {
    private String orderFoodUuid;

    private String orderId;

    private String foodId;

    private Integer foodNum;

    private BigDecimal foodOneTotalPrice;

    public String getOrderFoodUuid() {
        return orderFoodUuid;
    }

    public void setOrderFoodUuid(String orderFoodUuid) {
        this.orderFoodUuid = orderFoodUuid;
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

    public BigDecimal getFoodOneTotalPrice() {
        return foodOneTotalPrice;
    }

    public void setFoodOneTotalPrice(BigDecimal foodOneTotalPrice) {
        this.foodOneTotalPrice = foodOneTotalPrice;
    }
}